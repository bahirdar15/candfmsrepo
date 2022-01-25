package com.candfms.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.context.WebContext;

import com.candfms.helper.Message;
import com.candfms.models.Coursout;
import com.candfms.models.Fmie;
import com.candfms.models.Groupt;
import com.candfms.models.InstaCart;
import com.candfms.models.InstaOrderDetile;
import com.candfms.models.LabCart;
import com.candfms.models.LabOrder;
import com.candfms.models.LabOrderDetile;
import com.candfms.models.Semester;
import com.candfms.models.StuCart;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.models.Year;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.FmieRepository;
import com.candfms.repositories.GrouptRepository;
import com.candfms.repositories.InstaOrderDeileRepository;
import com.candfms.repositories.InstaOrderRepository;
import com.candfms.repositories.LabCartStuRepository;
import com.candfms.repositories.LabOrderDeileRepository;
import com.candfms.repositories.LabOrderRepository;
import com.candfms.repositories.OrderRepository;
import com.candfms.repositories.RoleRepository;
import com.candfms.repositories.SemisterRepository;
import com.candfms.repositories.StuCartStuRepository;
import com.candfms.repositories.StuOrderDeileRepository;
import com.candfms.repositories.StuOrderRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.repositories.YearRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

@Controller
@RequestMapping("/orderLab")
public class OrderLabController {
	
	@Autowired
	private LabCartStuRepository labCartRepository;
	
	@Autowired
	private LabOrderRepository labOrderRepository;
	
	@Autowired
	private LabOrderDeileRepository labOrderDeileRepository;
	
	
	

	@Autowired
	private StuCartStuRepository stuCartRepository;
	
	@Autowired
	private StuOrderRepository stuOrderRepository;
	
	@Autowired
	private StuOrderDeileRepository stuOrderDeileRepository;
	
	
	
	
	
	
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

	

	 @Autowired
		private SwitcchRepository swichRepo;
		
	 @Autowired RoleRepository roleRepo;
	 
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
			
			String role4 = "ADVISOR";
			Integer id4 = roleRepo.findByName(role4).getId();
			List<User> user4 = this.userRepository.findByRole(id4);	
			model.addAttribute("advisor", user4);
			
			String role5 = "APO";
			Integer id5 = roleRepo.findByName(role5).getId();
			List<User> user5 = this.userRepository.findByRole(id5);	
			model.addAttribute("apo", user5);
		
		
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
				
		List<Integer> hh = new ArrayList<>();
		hh.add(user.getDepar());
		List<User> roleBothInsAndAssi = this.userRepository.findByRoleBothInsAndAssi(hh,assiandIns);
		model.addAttribute("roleBothInsAndAssi", roleBothInsAndAssi);
		
		
		List<Integer> assiandIns3 = new ArrayList<>();
		assiandIns3.add(id3);
		
		List<Integer> hh3 = new ArrayList<>();
		hh3.add(user.getDepar());
		List<User> roleBothInsAndAssi3 = this.userRepository.findByRoleBothInsAndAssi(hh3,assiandIns3);
		model.addAttribute("roleBothInsAndAssi3", roleBothInsAndAssi3);
	}
	
	
	// for cart page in one	
	
	@RequestMapping("/show_cartLab")
	public String showInstaCartdds(Model model,Principal principal,StuCart stuCart,HttpSession session) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title","C|And|F - My Cart");	
		String name = principal.getName();
		User user=this.userRepository.getUserByUserName(name);
		
		
         List<StuCart> findByUserId = this.stuCartRepository.findByUserId(user.getId());
		model.addAttribute("instaCartd",findByUserId);
		
		return "faculty/insta_cartShowLab";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	// Go to New
	
		@RequestMapping("/{cId}/cartLab")
		public String showCartByIdLabs(@PathVariable("cId") Integer cId,Model m,HttpSession session,Principal principal) {	
			try {
			m.addAttribute("title","C|And|F - Cart");	
			Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(cId);
			Coursout coursout = coursoutOptional.get();
			
			m.addAttribute("coursouted", coursout);
			 
			return "faculty/insta_cartLab";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		// process new handler
		@RequestMapping(value = "/process-cartLab", method = RequestMethod.POST)
		public String updateHandlers(@ModelAttribute LabCart labCart, LabOrder labOrder,
				Model m, HttpSession session, Principal principal, 
				 @RequestParam("semesterid") Integer semesterid,
				 @RequestParam("bam") String bam,@RequestParam("prog") String prog,
				 @RequestParam("section") String section,@RequestParam("grou") String grou,
				 @RequestParam("yearid") Integer yearid, @RequestParam("coursoutid") Integer coursoutid) {
			
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
			LocalDateTime now1 = LocalDateTime.now();
			String name = principal.getName();
			User user = this.userRepository.getUserByUserName(name);
			

			try {	
				
			 List<Integer> findnafBy9compaid = this.labOrderRepository.findnafBy9compaid(dtf1.format(now1),semesterid,bam,prog,yearid,section,coursoutid,grou,user.getId());
			 if(findnafBy9compaid.isEmpty()) {
							 labOrder.setData("oncart"); 
							 labOrder.setAyear(dtf1.format(now1)); 
							 int orderid=labOrderRepository.save(labOrder).getId(); 
							  labCart.setOrderid(orderid); 
							  this.labCartRepository.save(labCart);
							 
							session.setAttribute("message", new Message("Your Data is Saved On Cart...", "alert-success"));
							return "redirect:/orderLab/" + orderid + "/oncartDtaileByuserId";
				 
			 }else { 
				  
				 session.setAttribute("message", new Message("Your Data is already on Cart...", "alert-danger"));
				 return "redirect:/orderLab/" + coursoutid + "/cartLab";
					  
			 }	
					
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}	
			
			//return "redirect:/orderLab/" + labCart.getOrderid() + "/oncartDtaileByuserId";
			
		}	
		
		// Show Order page 	
		
		@RequestMapping("/show_myCartLab")
		public String showOrderOnCart(Model model,Principal principal,HttpSession session) {
			/* model.addAttribute("userCoursout",new UserCoursout()); */
			try {
			model.addAttribute("title","C|And|F - My Order");	
			String name = principal.getName();
			User user=this.userRepository.getUserByUserName(name);										
			List<LabOrder> findByOrderUserId = this.labOrderRepository.findByOrderUserId(user.getId());
			model.addAttribute("instaOrder",findByOrderUserId);	
			
			return "faculty/LabCartOrderdShow";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		@RequestMapping("/{cId}/oncartDtaileByuserId")
		public String showCartDtailesIds(@PathVariable("cId") Integer cId,Model m,
				HttpSession session,Principal principal) {	
			try {
			m.addAttribute("title","C|And|F - Cart Details");	
		     LabOrder labOrder = this.labOrderRepository.findById(cId).get();				
			m.addAttribute("instaOrders", labOrder);	
			
			List<LabCart> findByOrderId = labCartRepository.findByOrderId(cId);
			m.addAttribute("orderDetailes", findByOrderId);	
			
			return "faculty/LabCartOrderdDetaile";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		
		@PostMapping("/addNewLab")
		public String addNew(HttpSession session,LabCart labCart,Principal principal) {
			try {
			String name = principal.getName();
			User user=this.userRepository.getUserByUserName(name);	
			 labCart.setUserid(user.getId()); 
			this.labCartRepository.save(labCart);

			session.setAttribute("message", new Message("Successfully Add New Lab  !!","alert-success"));    
			return "redirect:/orderLab/" + labCart.getOrderid() + "/oncartDtaileByuserId";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		
		// delete cart handler
				@GetMapping("/deleteCartLab/{id}")
				public String deleteCartByIds(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
					LabCart labCart2 = this.labCartRepository.findById(id).get();			
					LabOrder labOrder2 = this.labOrderRepository.findById(labCart2.getOrderid()).get();
					
					  this.labCartRepository.delete(labCart2);
					 
					/// message....
					
					  session.setAttribute("message", new Message("Successfully Deleted  !!", "alert-success"));
					 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/oncartDtaileByuserId";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				// delete Order handler
				@GetMapping("/deleteOrderLab/{id}")
				public String deleteOrderByIds(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
					List<LabCart> findByOrderId = this.labCartRepository.findByOrderId(id);
					LabOrder labOrder2 = this.labOrderRepository.findById(id).get();
					
			           m.addAttribute("instaOrders", labOrder2);
					// Check session................Assignment.......

					
					  this.labCartRepository.deleteAll(findByOrderId);
					  this.labOrderRepository.delete(labOrder2);
					 
					/// message....
					
					  session.setAttribute("message", new Message("Successfully Deleted  !!", "alert-success"));
					 
			           return "redirect:/orderLab/show_myCartLab";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
		
				// Signatur For Assi handler
				@GetMapping("/SignaLabForAsssi/{id}")
				public String signtByAssisIds(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
					LabCart labCart2 = this.labCartRepository.findById(id).get();			
					LabOrder labOrder2 = this.labOrderRepository.findById(labCart2.getOrderid()).get();
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);						
					//check if signature fill 										
					if(!user.getSignature().equals("1")) {						
						session.setAttribute("message", new Message("Before Request Fill signature Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {	
						
						if(labCart2.getAssista()==null) {						
							labCart2.setId(id);
							labCart2.setAssista("p");
							this.labCartRepository.save(labCart2);
						}else {					
							labCart2.setId(id);
							labCart2.setAssista(null);
							this.labCartRepository.save(labCart2);
						}
						
						/*
						 * labCart2.setId(id); labCart2.setAssista("p");
						 * this.labCartRepository.save(labCart2);
						 */
					}
					
					 
					/// message....				
					  session.setAttribute("message", new Message("Successfully Signed  !!", "alert-success"));				 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/oncartDtaileByuserId";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				 
				// Signatur For Insta handler
				@GetMapping("/SignaLabForInsta/{id}")
				public String signtByInstractorIds(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
					LabCart labCart2 = this.labCartRepository.findById(id).get();			
					LabOrder labOrder2 = this.labOrderRepository.findById(labCart2.getOrderid()).get();
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);						
					//check if signature fill 										
					if(!user.getSignature().equals("1")) {						
						session.setAttribute("message", new Message("Before Request Fill signature Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						
						if(labCart2.getInstrac()==null) {						
							labCart2.setId(id);
							labCart2.setInstrac("p");
							this.labCartRepository.save(labCart2);
						}else {					
							labCart2.setId(id);
							labCart2.setInstrac(null);
							this.labCartRepository.save(labCart2);
						}
						
						/*
						 * labCart2.setId(id); labCart2.setInstrac("P");
						 * this.labCartRepository.save(labCart2);
						 */
					}
					
					 
					/// message....
					
					  session.setAttribute("message", new Message("Successfully Signed  !!", "alert-success"));					 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/oncartDtaileByuserId";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
		
				// Signatur For Insta handler
				@GetMapping("/SignaLabForStu/{id}")
				public String signtByStudentIds(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
					LabCart labCart2 = this.labCartRepository.findById(id).get();			
					LabOrder labOrder2 = this.labOrderRepository.findById(labCart2.getOrderid()).get();
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);						
					//check if signature fill 										
					if(!user.getSignature().equals("1")) {						
						session.setAttribute("message", new Message("Before Request Fill signature Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						
						if(labCart2.getStudent()==null) {						
							labCart2.setId(id);
							labCart2.setStudent("p");
							this.labCartRepository.save(labCart2);
						}else {					
							labCart2.setId(id);
							labCart2.setStudent(null);
							this.labCartRepository.save(labCart2);
						}
						
						/*
						 * labCart2.setId(id); labCart2.setStudent("P");
						 * this.labCartRepository.save(labCart2);
						 */
					}
										 
					/// message....					
					  session.setAttribute("message", new Message("Successfully Signed  !!", "alert-success"));					 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/oncartDtaileByuserId";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
		
	///now orderddddddddd	
				// order process
				@RequestMapping(value = "/process-LabOrdered", method = RequestMethod.POST)
				public String orderCartProcessHandlerrs(@ModelAttribute LabCart labCart,LabOrder labOrder, 
						LabOrderDetile labOrderDetile,Model m, Principal principal,HttpSession session) {
					try {
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);						
					//check if signature fill 										
					if (!user.getSignature().equals("1")) {						
						session.setAttribute("message", new Message("Before Request Fill signature Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						
						try {						
							/* InstaOrder instaOrder= new InstaOrder(); */
							//for filld date
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDateTime now = LocalDateTime.now();
							//for acadamic year
							
							labOrder.setFilleddate(dtf.format(now));
							
							labOrder.setStatus("Filled");
							labOrder.setData("ordered");											
							  int orderid=labOrderRepository.save(labOrder).getId();
							  System.out.println("order id is ...... " + orderid);	
							  
							  
							  List<LabCart> instaCartOptional = this.labCartRepository.findByOrderId(orderid);
								/* m.addAttribute("instaCart",instaCartOptional); */						  
								
								  for(LabCart labCart1:instaCartOptional) { 
									  LabOrderDetile labOrderDetile1  = new LabOrderDetile();
								 
								  labOrderDetile1.setWeek(labCart1.getWeek());
								  labOrderDetile1.setLname(labCart1.getLname());
								  labOrderDetile1.setInstrac(labCart1.getInstrac());
								  labOrderDetile1.setAssista(labCart1.getAssista());
								  labOrderDetile1.setStudent(labCart1.getStudent());
								  labOrderDetile1.setRema(labCart1.getRema());
						 
								  labOrderDetile1.setOrderid(orderid);
								  this.labOrderDeileRepository.save(labOrderDetile1); 
								  }
								 				
							  
							  this.labCartRepository.deleteAll(instaCartOptional);
																			
							session.setAttribute("message", new Message("Your Data is Filled Success...", "alert-success"));

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
					
					
					return "redirect:/orderLab/show_myorderLab1";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
// Show Order page 	
				
				@RequestMapping("/show_myorderLab1")
				public String showOrderrUserIdss1(Model model,Principal principal,HttpSession session) {
					try {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<LabOrder> findByOrderUserId = this.labOrderRepository.findByOrderUserDataId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<LabOrder> findByApprovedCourseChairId = this.labOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<LabOrder> findByEndorsedChairHolderId = this.labOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<LabOrder> dean = this.labOrderRepository.findAll();
					model.addAttribute("dean",dean);	
					
					return "faculty/insta_myOrderShowLab1";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				@RequestMapping("/show_myorderLab2")
				public String showOrderrUserIdss2(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<LabOrder> findByOrderUserId = this.labOrderRepository.findByOrderUserDataId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<LabOrder> findByApprovedCourseChairId = this.labOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<LabOrder> findByEndorsedChairHolderId = this.labOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<LabOrder> dean = this.labOrderRepository.findAll();
					model.addAttribute("dean",dean);	
					
					return "faculty/insta_myOrderShowLab2";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}	
				@RequestMapping("/show_myorderLab3")
				public String showOrderrUserIdss3(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<LabOrder> findByOrderUserId = this.labOrderRepository.findByOrderUserDataId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<LabOrder> findByApprovedCourseChairId = this.labOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<LabOrder> findByEndorsedChairHolderId = this.labOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<LabOrder> dean = this.labOrderRepository.findAll();
					model.addAttribute("dean",dean);	
					
					return "faculty/insta_myOrderShowLab3";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}	
				
				@RequestMapping("/show_myorderLab4")
				public String showOrderrUserIdss4(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<LabOrder> findByOrderUserId = this.labOrderRepository.findByOrderUserDataId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<LabOrder> findByApprovedCourseChairId = this.labOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<LabOrder> findByEndorsedChairHolderId = this.labOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<LabOrder> dean = this.labOrderRepository.findAll();
					model.addAttribute("dean",dean);	
					
					return "faculty/insta_myOrderShowLab4";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}	
				
				@RequestMapping("/show-orderLabAdmin")
				public String showOrderAdmin(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<LabOrder> findByOrderUserId = this.labOrderRepository.findByOrderUserDataId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<LabOrder> findByApprovedCourseChairId = this.labOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<LabOrder> findByEndorsedChairHolderId = this.labOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<LabOrder> dean = this.labOrderRepository.findAll();
					model.addAttribute("dean",dean);	
					
					return "faculty/insta_myOrderShowLabAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}	
				
				@RequestMapping("/{cId}/orderdtaileLab")
				public String showOrderByOrdertrIds(@PathVariable("cId") Integer cId
						,HttpSession session,Model m,Principal principal) {	
					try {
					m.addAttribute("title","C|And|F - Order Details");	
				     LabOrder labOrder = this.labOrderRepository.findById(cId).get();				
					m.addAttribute("instaOrders", labOrder);	
					
					List<LabOrderDetile> findByOrderId = labOrderDeileRepository.findByOrderId(cId);
					m.addAttribute("orderDetailes", findByOrderId);	
					
					User approve = this.userRepository.getUserByapproIdSingle(labOrder.getApprovedby());
					m.addAttribute("approve", approve);

					User endor = this.userRepository.getUserByapproIdSingle(labOrder.getEndorsedby());
					m.addAttribute("endor", endor);
					
					return "faculty/insta_myOrderDetaileLab";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
				@RequestMapping("/{cId}/orderdtaileLabAdmin")
				public String showOrderToAdmin(@PathVariable("cId") Integer cId
						,HttpSession session,Model m,Principal principal) {	
					try {
					m.addAttribute("title","C|And|F - Order Details");	
				     LabOrder labOrder = this.labOrderRepository.findById(cId).get();				
					m.addAttribute("instaOrders", labOrder);	
					
					List<LabOrderDetile> findByOrderId = labOrderDeileRepository.findByOrderId(cId);
					m.addAttribute("orderDetailes", findByOrderId);	
					
					User approve = this.userRepository.getUserByapproIdSingle(labOrder.getApprovedby());
					m.addAttribute("approve", approve);

					User endor = this.userRepository.getUserByapproIdSingle(labOrder.getEndorsedby());
					m.addAttribute("endor", endor);
					
					return "faculty/insta_myOrderDetaileLabAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
				
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
			
		
				
				
				
				
				
				// approve handler
				@RequestMapping(value = "/process-approvedPostLab", method = RequestMethod.POST)
				public String apprCoursouts(Model model, HttpSession session, 
						LabOrder labOrder, Principal principal) {
					try {
					/*
					 * Optional<UserCoursout> userCoursoutOptional =
					 * this.userCoursoutRepository.findById(id); UserCoursout userCoursout =
					 * userCoursoutOptional.get();
					 */
					String userName = principal.getName();
					User user = userRepository.getUserByUserName(userName);
					
					if(!user.getSignature().equals("1")) {
						
						session.setAttribute("message", new Message("Before Approved Fill in the Uplode Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						//insert date
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();	
						 labOrder.setApproveddate(dtf.format(now));
						 labOrder.setStatus("Approved");
						 labOrderRepository.save(labOrder);
						
						session.setAttribute("message", new Message("Successfully Approved  !!", "alert-success"));

					}
					
					return "redirect:/orderLab/show_myorderLab2";
				} catch(Exception e) {
					e.printStackTrace(); 
					session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
					return "faculty/index";
				}
				}
	
	
				
				// Endorsed handler
				@GetMapping("/endorsedLab/{id}")
				public String apprCoursoutsuStu(@PathVariable("id") Integer id, Model model, HttpSession session, Principal principal) {
					try {
					String userName = principal.getName();
					User user = userRepository.getUserByUserName(userName);
					Optional<LabOrder> instaOrder1 = this.labOrderRepository.findById(id);
					LabOrder instaOrder2 = instaOrder1.get();
					
					if(!user.getSignature().equals("1")) {
						
						session.setAttribute("message", new Message("Before Approved Fill in the Uplode Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						//insert date
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();	        
						
						 instaOrder2.setEndorseddate(dtf.format(now));
						 instaOrder2.setStatus("Endorsed");						
						 labOrderRepository.save(instaOrder2);
						session.setAttribute("message", new Message("Successfully Endorsed  !!", "alert-success"));

					}
					
					return "redirect:/orderLab/show_myorderLab3";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
/* Assistant feedback instaFeedbackpdf  pdf*/
				
				@RequestMapping(path = "/{cId}/labFeedbackpdf")
			    public ResponseEntity<?> getPDFfnew(@PathVariable("cId") Integer cId,HttpServletRequest request, HttpServletResponse response) throws IOException {
					String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
				            .replacePath(null)
				            .build()
				            .toUriString();
					/* Do Business Logic*/					
					 LabOrder instaOrders = this.labOrderRepository.findById(cId).get();																	
						List<LabOrderDetile> orderDetailes = labOrderDeileRepository.findByOrderId(cId);
						
						User approve = this.userRepository.getUserByapproIdSingle(instaOrders.getApprovedby());						
						User endor = this.userRepository.getUserByapproIdSingle(instaOrders.getEndorsedby());
					
					 
					/* Order order = OrderHelper.getOrder(); */
			        /* Create HTML using Thymeleaf template Engine */  
					WebContext context = new WebContext(request, response, servletContext);
			       
			        context.setVariable("instaOrders", instaOrders);
			        context.setVariable("orderDetailes", orderDetailes);
			        
			        context.setVariable("approve", approve);
			        context.setVariable("endor", endor);
			        
			        String orderHtml = facultyController.templateEngine.process("faculty/pdffeedbackLabAssi", context);
			        /* Setup Source and target I/O streams */
			        ByteArrayOutputStream target = new ByteArrayOutputStream();
			        /*Setup converter properties. */
			        ConverterProperties converterProperties = new ConverterProperties();
			        converterProperties.setBaseUri(baseUrl +"/faculty");
			        /* Call convert method */
			        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);  
			        String ayear=instaOrders.ayear;
			        String semester=instaOrders.semester.getName();
			        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			         String dates = dateFormat.format(new Date());
					
					
			        /* extract output as bytes */
			       
			        byte[] bytes = target.toByteArray();
			        /* Send the response as downloadable PDF */
			        return ResponseEntity.ok()
			                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+ayear +"_"+ semester +"_"+ dates +".pdf")
			                .contentType(MediaType.APPLICATION_PDF)
			                .body(bytes);

			    }
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/* new for Admin =====================================================================*/
				
				// Signatur For Assi handler
				@GetMapping("/SignaLabForAsssiByAdmin/{id}")
				public String signtByAssisIdsByAdmin(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
					LabOrderDetile labOrderDetile22 = this.labOrderDeileRepository.findById(id).get();			

					LabOrder labOrder2 = this.labOrderRepository.findById(labOrderDetile22.getOrderid()).get();
		
					if(labOrderDetile22.getAssista()==null) {						
						labOrderDetile22.setId(id);
						labOrderDetile22.setAssista("p");
						this.labOrderDeileRepository.save(labOrderDetile22);
					}else {					
						labOrderDetile22.setId(id);
						labOrderDetile22.setAssista(null);
						this.labOrderDeileRepository.save(labOrderDetile22);
					}
					
					 
					/// message....	/{cId}/orderdtaileLab			
					  session.setAttribute("message", new Message("Successfully Signed  !!", "alert-success"));				 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/orderdtaileLabAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				 
				// Signatur For Insta handler
				@GetMapping("/SignaLabForInstaByAdmin/{id}")
				public String signtByInstractorIdsByAdmin(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
						LabOrderDetile labOrderDetile22 = this.labOrderDeileRepository.findById(id).get();			

						LabOrder labOrder2 = this.labOrderRepository.findById(labOrderDetile22.getOrderid()).get();
					if(labOrderDetile22.getInstrac()==null) {						
						labOrderDetile22.setId(id);
						labOrderDetile22.setInstrac("p");
						this.labOrderDeileRepository.save(labOrderDetile22);
					}else {	
						
						labOrderDetile22.setId(id);
						labOrderDetile22.setInstrac(null);
						this.labOrderDeileRepository.save(labOrderDetile22);
					}
					
					  session.setAttribute("message", new Message("Successfully Signed  !!", "alert-success"));					 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/orderdtaileLabAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
		
				// Signatur For stu handler
				@GetMapping("/SignaLabForStuByAdmin/{id}")
				public String signtByStudentIdsByAdmin(@PathVariable("id") Integer id, Model m, HttpSession session,
						Principal principal,LabCart labCart,LabOrder labOrder) {
					try {
						LabOrderDetile labOrderDetile22 = this.labOrderDeileRepository.findById(id).get();			

						LabOrder labOrder2 = this.labOrderRepository.findById(labOrderDetile22.getOrderid()).get();

					if(labOrderDetile22.getStudent()==null) {						
						labOrderDetile22.setId(id);
						labOrderDetile22.setStudent("p");
						this.labOrderDeileRepository.save(labOrderDetile22);
					}else {	
						
						
						labOrderDetile22.setId(id);
						labOrderDetile22.setStudent(null);
						this.labOrderDeileRepository.save(labOrderDetile22);
					}

										 
					/// message....					
					  session.setAttribute("message", new Message("Successfully Signed  !!", "alert-success"));					 
			           return "redirect:/orderLab/" + labOrder2.getId() + "/orderdtaileLabAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
				
				
				
				
				
}
