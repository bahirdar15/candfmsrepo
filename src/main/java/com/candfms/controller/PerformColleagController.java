package com.candfms.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.context.WebContext;

import com.candfms.helper.Message;
import com.candfms.models.Coursout;
import com.candfms.models.EvaluationCo;
import com.candfms.models.Evaluationstudent;
import com.candfms.models.Evaluationsuper;
import com.candfms.models.Fmie;
import com.candfms.models.Groupt;
import com.candfms.models.ProformRequ;
import com.candfms.models.Semester;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.models.UserCoursoutDetile;
import com.candfms.models.Year;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.EvaluationCoRequRepository;
import com.candfms.repositories.EvaluationStudentRequRepository;
import com.candfms.repositories.EvaluationSuperRequRepository;
import com.candfms.repositories.FmieRepository;
import com.candfms.repositories.GrouptRepository;
import com.candfms.repositories.InstaOrderDeileRepository;
import com.candfms.repositories.InstaOrderRepository;
import com.candfms.repositories.OrderRepository;
import com.candfms.repositories.ProformRequCollegeRepository;
import com.candfms.repositories.RoleRepository;
import com.candfms.repositories.SemisterRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserCoursoutAssignRepository;
import com.candfms.repositories.UserCoursoutDetileRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.repositories.YearRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;

@Controller
@RequestMapping("/performco")
public class PerformColleagController {

	@Autowired
	private UserCoursoutAssignRepository UserCourAssignRepo;
	
	@Autowired
	private UserCoursoutDetileRepository userCourDetileRepo;

	
	@Autowired	
	private EvaluationSuperRequRepository esuprRepository;
	
	@Autowired	
	private EvaluationStudentRequRepository estuderRepository;
	
	@Autowired
	private EvaluationCoRequRepository ecrRepository;
	
	@Autowired
	private ProformRequCollegeRepository prcRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private InstaOrderDeileRepository instaOrderDeileRepository;
	
	@Autowired
	private InstaOrderRepository instaOrderRepository;
	
	@Autowired
	private CoursoutRepository coursoutRepository;
	
	@Autowired
	private UserRepositories userRepository;
	
	@Autowired
	private FmieRepository fmieRepository;
	
	@Autowired
	private YearRepository yearRepository;
	
	@Autowired
	private SemisterRepository semesterRepository;
	
	@Autowired
	private GrouptRepository grouptRepository;
	
	@Autowired
	 ServletContext servletContext;
	 
	 @Autowired
	 FacultyController facultyController;
	
	 @Autowired RoleRepository roleRepo;

	 @Autowired
		private SwitcchRepository swichRepo;
		
		@ModelAttribute
		public void addCommonData(Model model,Principal principal) { 
			
			Switcch switchFeedback1 = swichRepo.findById(1).get();
			model.addAttribute("switchFeedback1",switchFeedback1);
			Switcch switchFeedback2 = swichRepo.findById(2).get();
			model.addAttribute("switchFeedback2", switchFeedback2);

			Switcch switchPro1 = swichRepo.findById(3).get();
			model.addAttribute("switchPro1", switchPro1);
			Switcch switchPro2 = swichRepo.findById(4).get();
			model.addAttribute("switchPro2", switchPro2);
			

			String userName = principal.getName();
			User user = userRepository.getUserByUserName(userName);
			model.addAttribute("user", user);
			
			String role01 = "ASSISTANT";
			Integer id01 = roleRepo.findByName(role01).getId();
			List<User> user01 = this.userRepository.findByRole(id01);
			model.addAttribute("assis", user01);

			String role0 = "INSTRUCTOR";
			Integer id0 = roleRepo.findByName(role0).getId();
			List<User> user0 = this.userRepository.findByRole(id0);
			model.addAttribute("Instructo", user0);

			String role2 = "COURSE_CHAIR";
			Integer id2 = roleRepo.findByName(role2).getId();
			List<User> user2 = this.userRepository.findByRole(id2);
			model.addAttribute("coursChair", user2);

			String role3 = "CHAIR_HOLDER";
			Integer id3 = roleRepo.findByName(role3).getId();
			List<User> user3 = this.userRepository.findByRole(id3);
			model.addAttribute("chairHolder", user3);
									
		List<Fmie> fmieList = this.fmieRepository.findAll();
		model.addAttribute("fmies",fmieList);
		
		List<Year> yearList = this.yearRepository.findAll();
		model.addAttribute("years",yearList);
		
		List<Semester> semesterList = this.semesterRepository.findAll();
		model.addAttribute("semesters",semesterList);
		
		List<Groupt> grouptList = this.grouptRepository.findAll();
		model.addAttribute("groupts",grouptList);
		
		List<Integer> assiandIns = new ArrayList<>();
		assiandIns.add(id0);
		assiandIns.add(id01);			
		List<User> roleBothInsAndAssinotDepar = this.userRepository.findByRoleBothInsAndAssiNotDepart(assiandIns);
		model.addAttribute("roleBothInsAndAssinotDepar",roleBothInsAndAssinotDepar);
		List<Integer> getdeper = new ArrayList<>();
		getdeper.add(user.getDepar());	
		
		List<Integer> exeptUser = new ArrayList<>();
		exeptUser.add(user.getId());
		//start findByRoleAndDeperExptItself				
		List<User> findByRoleAndDeperExptItself = this.userRepository.findByRoleBothInsAndAssiAndDeperWithOutItself(exeptUser,assiandIns,getdeper);
		model.addAttribute("findByRoleAndDeperExptItself",findByRoleAndDeperExptItself);
		//end findByRoleAndDeperExptItself
		
		//start findByRolewithDeper					
				List<User> findByRoleBothAndDepar = this.userRepository.findByRoleBothInsAndAssi(getdeper,assiandIns);
				model.addAttribute("findByRoleBothAndDepar",findByRoleBothAndDepar);
		//end findByRolewithDeper
		
		List<User> userAll = this.userRepository.findAll();
		model.addAttribute("userAll", userAll);
		
		//>=5 show
		
	}
	
	
	// for cart page in one	
	
	@RequestMapping("/show_pc1")
	public String showPc1(Model model,Principal principal,ProformRequ proformRequ,HttpSession session) {
		try {
		model.addAttribute("title","C|And|F - Performance");	
		String name = principal.getName();
		User user=this.userRepository.getUserByUserName(name);
				
	    List<ProformRequ> findByReqUserId = this.prcRepository.findByReqUserId(user.getId());
		model.addAttribute("proformRequ",findByReqUserId);
		
		
		return "faculty/performColleagShow1";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	@RequestMapping("/show_pc2")
	public String showPc2(Model model,Principal principal,ProformRequ proformRequ,HttpSession session) {
		try {
		model.addAttribute("title","C|And|F - Performance");	
		String name = principal.getName();
		User user=this.userRepository.getUserByUserName(name); 
		List<ProformRequ> findBydepar = this.prcRepository.findBydepar(user.getDepar());
		model.addAttribute("proformRequdepar",findBydepar) ;
		return "faculty/performColleagShow2";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	@RequestMapping("/show_pc3")
	public String showPc3(Model model,Principal principal,ProformRequ proformRequ,HttpSession session) {
		try {
		
			model.addAttribute("title","C|And|F - Performance");	
		String name = principal.getName();
		User user=this.userRepository.getUserByUserName(name);			
		List<ProformRequ> dean = this.prcRepository.findAll();
		model.addAttribute("dean",dean);	
		return "faculty/performColleagShow3";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	// open new add newProCoRec
	@RequestMapping("/{id}/newProCoRec")
	public String newProCoRec(@PathVariable("id") Integer id,Model model,
			HttpSession session,Principal principal,ProformRequ proformRequ) {
		try {
		model.addAttribute("title","C|And|F - New Performance");	
	
		Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(id);
		Coursout coursout = coursoutOptional.get();
		
		model.addAttribute("coursouted", coursout);
		
		return "faculty/performColleagRequ";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	
		
		// process new handler
		@RequestMapping(value = "/process-ProformRequ", method = RequestMethod.POST)
		public String newRecProCoHandler(@ModelAttribute ProformRequ proformRequ, 
				Model m, HttpSession session, Principal principal) {

			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
				LocalDateTime now1 = LocalDateTime.now();
				
				proformRequ.setStatus("Pending");
				proformRequ.setRequestdate(dtf.format(now));
				//proformRequ.setAyear(dtf1.format(now1));
					this.prcRepository.save(proformRequ);
					session.setAttribute("message", new Message("Your Data is Saved...", "alert-success"));
					
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return "redirect:/performco/show_pc";
		}	
	
		
				
	
	
				
				// a handler
				@GetMapping("/approved/{id}")
				public String profCollApproved(@PathVariable("id") Integer id, Model model, 
						HttpSession session, 
						Principal principal) {
					try {
					String userName = principal.getName();
					User user = userRepository.getUserByUserName(userName);
					Optional<ProformRequ> proformRequ1 = this.prcRepository.findById(id);
					ProformRequ proformRequ2 = proformRequ1.get();
					
					if(user.getImageUrl().isEmpty()) {
						
						session.setAttribute("message", new Message("Before Approved Fill in the Uplode Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						//insert date
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();	        
						
						 proformRequ2.setApproveddate(dtf.format(now));
						 proformRequ2.setStatus("Approved");						
						 prcRepository.save(proformRequ2);
						session.setAttribute("message", new Message("Successfully Approved  !!", "alert-success"));

					}
					
					return "redirect:/performco/show_pc";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
				// my proferm result by collage
				@RequestMapping("/{cId}/myprofrma")
				public String showresultByEnstaId(@PathVariable("cId") Integer cId,Model m,
						Principal principal,HttpSession session) {	
					try {
					m.addAttribute("title","C|And|F - my prof");	
				     ProformRequ proformRequ = this.prcRepository.findById(cId).get();				
					m.addAttribute("proformRequ", proformRequ);	
					DecimalFormat df = new DecimalFormat("0.00");
					/*
					 * long count = this.ecrRepository.count(); m.addAttribute("count", count);
					 */
					   //for collage
					       Integer countEvaluterCo = this.ecrRepository.countEvaluterCo(cId);
					       m.addAttribute("countEvaluterCo", countEvaluterCo);	
					       
					       float sumEvaluterCo = this.ecrRepository.sumEvaluterCo(cId);
					       m.addAttribute("sumEvaluterCo", sumEvaluterCo);
							/* 1/0==0/0=NaN 0/2=0 wedezero mekeyer alebgn */
					       double collagAvaa = sumEvaluterCo/countEvaluterCo ;
					       
					       if (countEvaluterCo == 0) {
					    	   collagAvaa = 0;
					    	}
					       String collagAva = df.format(collagAvaa);
					       m.addAttribute("collagAva", collagAva);
					  // for superv
					       Integer countEvaluterSuper = this.esuprRepository.countEvaluterCo(cId);
					       m.addAttribute("countEvaluterSuper", countEvaluterSuper);	
					       
					       float sumEvaluterSuper = this.esuprRepository.sumEvaluterCo(cId);
					       m.addAttribute("sumEvaluterCo", sumEvaluterSuper);
					       
					       double SuperAvaa = sumEvaluterSuper/countEvaluterSuper ;
					       
					       if (countEvaluterSuper == 0) {
					    	   SuperAvaa = 0;
					    	}
					       String SuperAva = df.format(SuperAvaa);
					       m.addAttribute("SuperAva", SuperAva);
					  // for student					       
					       Integer countEvaluterStudent = this.estuderRepository.countEvaluterCo(cId);
					       m.addAttribute("countEvaluterStudent", countEvaluterStudent);	
					       
					       float sumEvaluterStudent = this.estuderRepository.sumEvaluterCo(cId);
					       m.addAttribute("sumEvaluterStudent", sumEvaluterStudent);
					       
					       double StudentAvaa = sumEvaluterStudent/countEvaluterStudent ;
					       
					       if (countEvaluterStudent == 0) {
					    	   StudentAvaa = 0;
					    	}
					       String StudentAva = df.format(StudentAvaa);
					       m.addAttribute("StudentAva", StudentAva);
					  //total
					       double totalalla= collagAvaa + SuperAvaa + StudentAvaa;
					       String totalall = df.format(totalalla);
					       m.addAttribute("totalall", totalall);
					    
					return "faculty/performColleagResult";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
				
				
				
				
				
				
				/* for evalute yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy */
				
				// show evaluted list by me 	
				@RequestMapping("/show_pcEva1")
				public String showPceva1(Model model,Principal principal,ProformRequ proformRequ,HttpSession session) {			
					try {
					model.addAttribute("title","C|And|F - Performance");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name); 		
					List<UserCoursoutDetile> assigninstaDetil = this.userCourDetileRepo.findAll();
					model.addAttribute("assigninstaDetil", assigninstaDetil);					
				    List<ProformRequ> findByReqUserId = this.prcRepository.findAll();
					model.addAttribute("proformRequ",findByReqUserId);				
					List<ProformRequ> findByApprovedChairHolderId = this.prcRepository.findByApprovedChairHolderId(user.getId());
					model.addAttribute("proformRequApprovedBy",findByApprovedChairHolderId);				
					return "faculty/performColleagEvaluShow1";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				@RequestMapping("/show_pcEva2")
				public String showPceva2(Model model,Principal principal,ProformRequ proformRequ,HttpSession session) {			
					try {
					model.addAttribute("title","C|And|F - Performance");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name); 		
					List<UserCoursoutDetile> assigninstaDetil = this.userCourDetileRepo.findAll();
					model.addAttribute("assigninstaDetil", assigninstaDetil);					
				    List<ProformRequ> findByReqUserId = this.prcRepository.findAll();
					model.addAttribute("proformRequ",findByReqUserId);				
					List<ProformRequ> findByApprovedChairHolderId = this.prcRepository.findByApprovedChairHolderId(user.getId());
					model.addAttribute("proformRequApprovedBy",findByApprovedChairHolderId);				
					return "faculty/performColleagEvaluShow2";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				@RequestMapping("/show_pcEva3")
				public String showPceva3(Model model,Principal principal,ProformRequ proformRequ,HttpSession session) {			
					try {
					model.addAttribute("title","C|And|F - Performance");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name); 		
					List<UserCoursoutDetile> assigninstaDetil = this.userCourDetileRepo.findAll();
					model.addAttribute("assigninstaDetil", assigninstaDetil);					
				    List<ProformRequ> findByReqUserId = this.prcRepository.findAll();
					model.addAttribute("proformRequ",findByReqUserId);				
					List<ProformRequ> findByApprovedChairHolderId = this.prcRepository.findByApprovedChairHolderId(user.getId());
					model.addAttribute("proformRequApprovedBy",findByApprovedChairHolderId);				
					return "faculty/performColleagEvaluShow3";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
	//////////////////////////// for colla			
				// open evalute hander for college
				@RequestMapping("/{cId}/markColl")
				public String showOrderByOrderId(@PathVariable("cId") Integer cId,Model m,Principal principal,HttpSession session) {	
					try {
					m.addAttribute("title","C|And|F - Mark By Colleagues");	
					/*
					 * ProformRequ proformRequ = this.prcRepository.findById(cId).get();
					 * m.addAttribute("proformRequ", proformRequ);
					 */
					
					User getUserById = this.userRepository.findById(cId).get();
					m.addAttribute("getUserById", getUserById);	
					return "faculty/performColleagEvalu";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				// process Evalu handler for college
				@RequestMapping(value = "/process-EvalutColla", method = RequestMethod.POST)
				public String EvaluCoHandler(@ModelAttribute ProformRequ proformRequ,@ModelAttribute EvaluationCo evaluationCo, 
						Model m, HttpSession session, Principal principal,
@RequestParam("instauserid") Integer instauserid,@RequestParam("semesterid") Integer semesterid) {
					
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);
					int userdd=user.getId();
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
					LocalDateTime now = LocalDateTime.now();
					Integer year=Integer.parseInt(dtf.format(now));
					Integer semesteridd=semesterid;
					Integer useridd=instauserid;
					
					DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now2 = LocalDateTime.now();
					String dataa2=dtf2.format(now2);
									
					Integer int0 = this.prcRepository.countProformRequBytree(useridd,year,semesteridd);
					try {
						if(int0==1) {						
							          int id99 = this.prcRepository.getProformRequBytreeSingle(useridd,year,semesteridd).getId();	
							          Integer idd32 = ecrRepository.countProformRequBytwo(id99, userdd);
							          if(idd32==1) {
											 session.setAttribute("message", new Message("Your Data data already exists!!  ደጋግሞ መሙላት የተክለከለ ነው።!! ...", "alert-danger"));
										}else {
											ProformRequ findById2 = this.prcRepository.findById(id99).get();
											  proformRequ.setId(findById2.getId());
											  proformRequ.setAyear(findById2.getAyear()); 
											  proformRequ.setUserid(findById2.getUserid());
											  int dss=findById2.getCountinsta()+1;
											  proformRequ.setCountinsta(dss);
											  proformRequ.setCountchair(findById2.getCountchair());
											  proformRequ.setCountstu(findById2.getCountstu());
											  proformRequ.setApprovedby(findById2.getApprovedby());
											  proformRequ.setApproveddate(findById2.getApproveddate());
											  proformRequ.setSemesterid(findById2.getSemesterid()); 
											  if(findById2.getCountinsta()==4) {
													int gt=findById2.getSumofcount()+4;
													 proformRequ.setSumofcount(gt);
												}else {
													 proformRequ.setSumofcount(findById2.getSumofcount());
												}
											 prcRepository.save(proformRequ);
											
											//int id99 = this.prcRepository.getProformRequBytreeSingle(useridd,year,semesteridd).getId();							  
											evaluationCo.setEvaluatdate(dataa2);
											evaluationCo.setProformRequid(id99);						  
											evaluationCo.setAvtotal(evaluationCo.getAvtotald());
											this.ecrRepository.save(evaluationCo);	
											
											
											 session.setAttribute("message", new Message("Your Data is Marked...", "alert-success"));											 
										}														  
						}else {													
							  proformRequ.setAyear(year); 
							  proformRequ.setUserid(useridd);
							  int ds=1;
							  proformRequ.setCountinsta(ds);
							  proformRequ.setSemesterid(semesteridd); 
							  int prcid = prcRepository.save(proformRequ).getId();
							  
							  evaluationCo.setEvaluatdate(dataa2);
							  evaluationCo.setProformRequid(prcid);
							  evaluationCo.setAvtotal(evaluationCo.getAvtotald());
							  this.ecrRepository.save(evaluationCo);							 
							 session.setAttribute("message", new Message("Your Data is Marked...", "alert-success"));								
						}						   																			
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}			
					return "redirect:/performco/show_pcEva1";
				}	
				
				
///////////////////////////for 	Super				
				
				// open evalute hander for super
				@RequestMapping("/{cId}/markSuper")
				public String evalutorSuperId(@PathVariable("cId") Integer cId,Model m,Principal principal,HttpSession session) {	
					try {
					m.addAttribute("title","C|And|F - Mark By Colleagues");	
					/*
					 * ProformRequ proformRequ = this.prcRepository.findById(cId).get();
					 * m.addAttribute("proformRequ", proformRequ);
					 */
					User getUserById = this.userRepository.findById(cId).get();
					m.addAttribute("getUserById", getUserById);	
					
					return "faculty/performSuperEvalu";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
			
				// process Evalu handler for super
				@RequestMapping(value = "/process-EvalutSuper", method = RequestMethod.POST)
				public String EvalusuperHandler(@ModelAttribute ProformRequ proformRequ,@ModelAttribute Evaluationsuper evaluationsuper, 
						
						Model m, HttpSession session, Principal principal, 
@RequestParam("instauserid") Integer instauserid,@RequestParam("semesterid") Integer semesterid) {
					
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);
					int userdd=user.getId();
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
					LocalDateTime now = LocalDateTime.now();
					Integer year=Integer.parseInt(dtf.format(now));
					Integer semesteridd=semesterid;
					Integer useridd=instauserid;
					
					DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now2 = LocalDateTime.now();
					String dataa2=dtf2.format(now2);
									
					Integer int0 = this.prcRepository.countProformRequBytree(useridd,year,semesteridd);
					try {
						if(int0==1) {						
							          int id99 = this.prcRepository.getProformRequBytreeSingle(useridd,year,semesteridd).getId();	
							          Integer idd32 = esuprRepository.countProformRequBytwo(id99, userdd);
							          if(idd32==1) {
											 session.setAttribute("message", new Message("Your Data data already exists!!  ደጋግሞ መሙላት የተክለከለ ነው።!! ...", "alert-danger"));
										}else {
											ProformRequ findById2 = this.prcRepository.findById(id99).get();
											  proformRequ.setId(findById2.getId());
											  proformRequ.setAyear(findById2.getAyear()); 
											  proformRequ.setUserid(findById2.getUserid());
											  proformRequ.setApprovedby(userdd);
											  proformRequ.setApproveddate(dataa2);
											  int ddr=findById2.getCountchair()+1;
											  proformRequ.setCountchair(ddr);
											  proformRequ.setCountinsta(findById2.getCountinsta());
											  proformRequ.setCountstu(findById2.getCountstu());
											  proformRequ.setSemesterid(findById2.getSemesterid()); 
											  if(findById2.getCountchair()==0) {
													int gt=findById2.getSumofcount()+1;
													proformRequ.setSumofcount(gt);
												}else {
													proformRequ.setSumofcount(findById2.getSumofcount());
												}
											  prcRepository.save(proformRequ);
											//int id99 = this.prcRepository.getProformRequBytreeSingle(useridd,year,semesteridd).getId();							  
											evaluationsuper.setEvaluatdate(dataa2);
											evaluationsuper.setProformRequid(id99);						  
											evaluationsuper.setAvtotal(evaluationsuper.getAvtotald());
											this.esuprRepository.save(evaluationsuper);	
											 session.setAttribute("message", new Message("Your Data is Marked...", "alert-success"));											 
										}														  
						}else {													
							  proformRequ.setAyear(year); 
							  proformRequ.setApprovedby(userdd);
							  proformRequ.setApproveddate(dataa2);
							  int chhd=1;
							  proformRequ.setCountchair(chhd);
							  proformRequ.setUserid(useridd);
							  proformRequ.setSemesterid(semesteridd); 
							 
									proformRequ.setSumofcount(chhd);
								
							  int prcid = prcRepository.save(proformRequ).getId();
							  
							  evaluationsuper.setEvaluatdate(dataa2);
							  evaluationsuper.setProformRequid(prcid);
							  evaluationsuper.setAvtotal(evaluationsuper.getAvtotald());
							  this.esuprRepository.save(evaluationsuper);
							//  ProformRequ findById2 = this.prcRepository.findById(prcid).get();
							  
							 session.setAttribute("message", new Message("Your Data is Marked...", "alert-success"));								
						}						   																			
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}			
					return "redirect:/performco/show_pcEva2";
				}	
				
////////////////for student				
				// open evalute hander for student
				@RequestMapping("/{id}/markStudent")
				public String evalutorStudentrId(@PathVariable("id") Integer id,Model m,Principal principal,HttpSession session) {	
					try {
					m.addAttribute("title","C|And|F - Mark By Colleagues");	
					/* ProformRequ proformRequ = this.prcRepository.findById(cId).get(); */	
					User getUserById = this.userRepository.findById(id).get();
					m.addAttribute("getUserById", getUserById);						
					return "faculty/performStudentEvalu";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				// process Evalu handler for student
				@RequestMapping(value = "/process-EvalutStudent", method = RequestMethod.POST)
				public String EvaluStudentHandler(@ModelAttribute ProformRequ proformRequ,@ModelAttribute Evaluationstudent evaluationstudent, 
						Model m, HttpSession session, Principal principal, 
			@RequestParam("instauserid") Integer instauserid,@RequestParam("semesterid") Integer semesterid) {
					
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);
					int userdd=user.getId();
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
					LocalDateTime now = LocalDateTime.now();
					Integer year=Integer.parseInt(dtf.format(now));
					Integer semesteridd=semesterid;
					Integer useridd=instauserid;
					
					DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now2 = LocalDateTime.now();
					String dataa2=dtf2.format(now2);
									
					Integer int0 = this.prcRepository.countProformRequBytree(useridd,year,semesteridd);
					try {
						if(int0==1) {						
							          int id99 = this.prcRepository.getProformRequBytreeSingle(useridd,year,semesteridd).getId();	
							          Integer idd32 = estuderRepository.countProformRequBytwo(id99, userdd);
							          if(idd32==1) {
											 session.setAttribute("message", new Message("Your Data data already exists!!  ደጋግሞ መሙላት የተክለከለ ነው።!! ...", "alert-danger"));
										}else {
											ProformRequ findById2 = this.prcRepository.findById(id99).get();
											  proformRequ.setId(findById2.getId());
											  proformRequ.setAyear(findById2.getAyear()); 
											  proformRequ.setUserid(findById2.getUserid());
											  int pop=findById2.getCountstu()+1;
											  proformRequ.setCountinsta(findById2.getCountinsta()); 
											  proformRequ.setCountchair(findById2.getCountchair());
											  proformRequ.setCountstu(pop);
											  proformRequ.setApprovedby(findById2.getApprovedby());
											  proformRequ.setApproveddate(findById2.getApproveddate());
											  proformRequ.setSemesterid(findById2.getSemesterid()); 
											  if(findById2.getCountstu()==4) {
													int gt=findById2.getSumofcount()+4;
													proformRequ.setSumofcount(gt);
												}else {
													proformRequ.setSumofcount(findById2.getSumofcount());
												}
											  prcRepository.save(proformRequ);
											 
											  
											//int id99 = this.prcRepository.getProformRequBytreeSingle(useridd,year,semesteridd).getId();							  
											  evaluationstudent.setEvaluatdate(dataa2);
											  evaluationstudent.setProformRequid(id99);						  
											  evaluationstudent.setAvtotal(evaluationstudent.getAvtotald());
											  this.estuderRepository.save(evaluationstudent);	
											  
											  
											 session.setAttribute("message", new Message("Your Data is Marked...", "alert-success"));											 
										}														  
						}else {													
							  proformRequ.setAyear(year); 
							  proformRequ.setUserid(useridd);
							  int gh=1;
							  proformRequ.setCountstu(gh);
							  proformRequ.setSemesterid(semesteridd); 
							  int prcid = prcRepository.save(proformRequ).getId();
							  
							  evaluationstudent.setEvaluatdate(dataa2);
							  evaluationstudent.setProformRequid(prcid);
							  evaluationstudent.setAvtotal(evaluationstudent.getAvtotald());
							  this.estuderRepository.save(evaluationstudent);							 
							 session.setAttribute("message", new Message("Your Data is Marked...", "alert-success"));								
						}						   																			
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}			
					return "redirect:/performco/show_pcEva3";
				}	
				
				
				
				
				
				
							
				
				/* print pdf */							
				@RequestMapping(path = "/{cId}/proformRequPdf")
			    public ResponseEntity<?> getPDFf(@PathVariable("cId") Integer cId,HttpServletRequest request, HttpServletResponse response) throws IOException {
					String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
				            .replacePath(null)
				            .build()
				            .toUriString();
					/* Do Business Logic*/
				
					String role388 = "CHAIR_HOLDER";
					Integer id388 = roleRepo.findByName(role388).getId();
					List<User> chairHolder= this.userRepository.findByRole(id388);											
					DecimalFormat df = new DecimalFormat("0.00");
					
					
					 ProformRequ proformRequ = this.prcRepository.findById(cId).get();					 										 
					 Integer countEvaluterCo = this.ecrRepository.countEvaluterCo(cId);				      					 				 					       
				       float sumEvaluterCo = this.ecrRepository.sumEvaluterCo(cId);		    
				       double collagAvaa = sumEvaluterCo/countEvaluterCo ;				       
				       if (countEvaluterCo == 0) {
				    	   collagAvaa = 0;
				    	}
				       String collagAva = df.format(collagAvaa);
				       // for superv
				       Integer countEvaluterSuper = this.esuprRepository.countEvaluterCo(cId);				     				       
				       float sumEvaluterSuper = this.esuprRepository.sumEvaluterCo(cId);				      				       
				       double SuperAvaa = sumEvaluterSuper/countEvaluterSuper ;				       
				       if (countEvaluterSuper == 0) {
				    	   SuperAvaa = 0;
				    	}
				       String SuperAva = df.format(SuperAvaa);
				      //for student
				       Integer countEvaluterStudent = this.estuderRepository.countEvaluterCo(cId);				     					       
				       float sumEvaluterStudent = this.estuderRepository.sumEvaluterCo(cId);				    				       
				       double StudentAvaa = sumEvaluterStudent/countEvaluterStudent ;				       
				       if (countEvaluterStudent == 0) {
				    	   StudentAvaa = 0;
				    	}	
				       String StudentAva = df.format(StudentAvaa);
				  //total
				       double totalalla= collagAvaa + SuperAvaa + StudentAvaa;				    				 
				       String totalall = df.format(totalalla);
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
						
					/* Order order = OrderHelper.getOrder(); */
			        /* Create HTML using Thymeleaf template Engine */  
					WebContext context = new WebContext(request, response, servletContext);
			       
					   context.setVariable("chairHolder", chairHolder);
					
			           context.setVariable("proformRequ", proformRequ);
			        
			           context.setVariable("countEvaluterCo", countEvaluterCo);
			           context.setVariable("sumEvaluterCo", sumEvaluterCo);				       
				       context.setVariable("collagAva", collagAva);
				       
				       context.setVariable("countEvaluterSuper", countEvaluterSuper);
				       context.setVariable("sumEvaluterCo", sumEvaluterCo);
				       context.setVariable("SuperAva", SuperAva);
				       
				       context.setVariable("countEvaluterStudent", countEvaluterStudent);
				       context.setVariable("sumEvaluterStudent", sumEvaluterStudent);
				       context.setVariable("StudentAva", StudentAva);
				       
				       context.setVariable("totalall", totalall);
			        
			        FontProvider dfp = new DefaultFontProvider(true, false, false);
			        dfp.addFont("/static/fonts/bamini.ttf");
			        String orderHtml = facultyController.templateEngine.process("faculty/pdfproformaEvaluatRusult", context);
			        /* Setup Source and target I/O streams */
			        ByteArrayOutputStream target = new ByteArrayOutputStream();
			        /*Setup converter properties. */
			        ConverterProperties converterProperties = new ConverterProperties();
			        converterProperties.setBaseUri(baseUrl +"/faculty");
			        converterProperties.setFontProvider(dfp);
			        /* Call convert method */
			        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);  
			        String ccode = "fmie";
			       
			        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			         String dates = dateFormat.format(new Date());
					
					
			        /* extract output as bytes */
			       
			        byte[] bytes = target.toByteArray();
			        /* Send the response as downloadable PDF */
			        return ResponseEntity.ok()
			                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+ccode +"_"+ dates +".pdf")
			                .contentType(MediaType.APPLICATION_PDF)
			                .body(bytes);

			    }

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/* leadisu letekeyerew ma */
				
				// open new add newProCoRec
				@GetMapping("/{id}/newProCoRecForAssigind")
				public String newProCoReoc(@PathVariable("id") Integer id,Model model,
						HttpSession session, Principal principal,ProformRequ proformRequ) {
				
					model.addAttribute("title","C|And|F - New Performance");	
				
					Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(id);
					Coursout coursout = coursoutOptional.get();
					
					 Optional<UserCoursoutDetile> findById = this.userCourDetileRepo.findById(id);
						UserCoursoutDetile userCoursoutDetile = findById.get();
					try {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDateTime now = LocalDateTime.now();
						DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
						LocalDateTime now1 = LocalDateTime.now();
						
						ProformRequ proformRequ1 = new ProformRequ();
						proformRequ1.setStatus("Pending");
						proformRequ1.setRequestdate(dtf.format(now));
						//proformRequ1.setAyear(dtf1.format(now1));
						//proformRequ1.setCoursoutid(id);
						proformRequ1.setApprovedby(userCoursoutDetile.userid);
						proformRequ1.setUserid(userCoursoutDetile.instaId);
						
							this.prcRepository.save(proformRequ1);
							session.setAttribute("message", new Message("Your Data is Saved...", "alert-success"));					
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}	
					return "redirect:/performco/show_pc";
				}
				
				
				
				@RequestMapping(value = "/process-lemukera", method = RequestMethod.POST)
				public String lemukera(@ModelAttribute ProformRequ proformRequ,@ModelAttribute Evaluationstudent evaluationstudent, 
						Model m, HttpSession session, Principal principal) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
					LocalDateTime now = LocalDateTime.now();
					Integer dataa=2021;
					
					DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now2 = LocalDateTime.now();
					String dataa2=dtf2.format(now2);


					Integer int0 = this.prcRepository.countProformRequBytree(13,2021,1);


					try {


						if(int0==1) {
							
							
							int id99 = this.prcRepository.getProformRequBytreeSingle(11,2021,2).getId();
							  
							  evaluationstudent.setEvaluatdate(dataa2);
							  evaluationstudent.setProformRequid(id99);
							  evaluationstudent.setTotal(evaluationstudent.getTotald());
							  evaluationstudent.setAvtotal(evaluationstudent.getAvtotald());
							  this.estuderRepository.save(evaluationstudent);
							 

							 session.setAttribute("message", new Message("Your Data is ale...", "alert-success"));
							 
							  
						}else {						

							
							  proformRequ.setAyear(dataa); 
							  proformRequ.setUserid(11);
							  proformRequ.setSemesterid(2); 
							  int prcid = prcRepository.save(proformRequ).getId();
							  
							  evaluationstudent.setEvaluatdate(dataa2);
							  evaluationstudent.setProformRequid(prcid);
							 
							  this.estuderRepository.save(evaluationstudent);
							 

							 session.setAttribute("message", new Message("Your Data is yelem...", "alert-success"));
								

						}
						   
							
						
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
						
					return "redirect:/faculty/index";
				}	
				
}
