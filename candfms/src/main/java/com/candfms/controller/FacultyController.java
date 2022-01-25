package com.candfms.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;

import com.candfms.helper.Message;
import com.candfms.models.ActiLab;
import com.candfms.models.AssWeek;
import com.candfms.models.Assess;
import com.candfms.models.Chapteraf;
import com.candfms.models.Chapterbf;
import com.candfms.models.Chapterlast;
import com.candfms.models.ComLearn;
import com.candfms.models.Coursout;
import com.candfms.models.Fmie;
import com.candfms.models.Groupt;
import com.candfms.models.Methodo;
import com.candfms.models.Post;
import com.candfms.models.Refer;
import com.candfms.models.Semester;
import com.candfms.models.Switcch;
import com.candfms.models.TabRef;
import com.candfms.models.User;
import com.candfms.models.Week;
import com.candfms.models.Year;
import com.candfms.repositories.ActiLabRepository;
import com.candfms.repositories.AssWeekRepository;
import com.candfms.repositories.AssessRepository;
import com.candfms.repositories.CapterafRepository;
import com.candfms.repositories.CapterlastRepository;
import com.candfms.repositories.ChapterbfRepository;
import com.candfms.repositories.ComLearnRepository;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.FmieRepository;
import com.candfms.repositories.GrouptRepository;
import com.candfms.repositories.MethodeRepository;
import com.candfms.repositories.PostRepository;
import com.candfms.repositories.ReferRepository;
import com.candfms.repositories.RoleRepository;
import com.candfms.repositories.SemisterRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.TabRefRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.repositories.WeekRepository;
import com.candfms.repositories.YearRepository;




@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private ComLearnRepository comLearnRepo; 
	
	@Autowired
	private MethodeRepository methodoRepo;
	
	@Autowired
	private ActiLabRepository actiLabRepo;
	
	@Autowired
	private TabRefRepository tabRefRepo;
	
	@Autowired
	private AssWeekRepository assWeekRepo;
	
	
	@Autowired
	private ReferRepository refRepo;
	
	@Autowired
	private AssessRepository assRepo;
	
	@Autowired
	private WeekRepository weekRepo;
	@Autowired
	private ChapterbfRepository chapBfRepo;
	@Autowired
	private CapterafRepository chapAfRepo;
	@Autowired
	private CapterlastRepository chapLasRepo;
	
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
	
	

	@Autowired RoleRepository roleRepo;
	
	@Autowired
	private SwitcchRepository swichRepo;
	
	@Autowired
	private PostRepository postRepo;
	
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
		
		//get the user using username(username)
		String userName=principal.getName();
		User user = userRepository.getUserByUserName(userName);				
		model.addAttribute("user",user);
		
		
		
		List<Fmie> fmieList = this.fmieRepository.findAll();
		model.addAttribute("fmies",fmieList);
		
		List<Year> yearList = this.yearRepository.findAll();
		model.addAttribute("years",yearList);
		
		List<Semester> semesterList = this.semesterRepository.findAll();
		model.addAttribute("semesters",semesterList);
		
		List<Groupt> grouptList = this.grouptRepository.findAll();
		model.addAttribute("groupts",grouptList);
	}
	
	 @Autowired
	 ServletContext servletContext;

	 public final TemplateEngine templateEngine;

	    public FacultyController(TemplateEngine templateEngine) {
	        this.templateEngine = templateEngine;
	    }
	
	
	
	@RequestMapping(path = "/order")
    public String getOrderPage(Model model,HttpSession session) throws IOException {
		try {
		List<Coursout> coursouts = this.coursoutRepository.findAll();
		Coursout coursout = this.coursoutRepository.findById(3).get();
		/* Order order = OrderHelper.getOrder() */
		model.addAttribute("coursout", coursout);
        model.addAttribute("orderEntry", coursouts);
        Semester nameBySemesterid = this.semesterRepository.getNameBysemesterid(coursout.semesterid);					
		model.addAttribute("semesterName", nameBySemesterid);
        return "faculty/order";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
    }
	
	@RequestMapping(path = "/coursepdf")
    public String getCoursoutPdfPage(Model model,HttpSession session) throws IOException {
		try {
		List<Coursout> coursouts = this.coursoutRepository.findAll();
		Coursout coursout = this.coursoutRepository.findById(3).get();
		/* Order order = OrderHelper.getOrder() */
		model.addAttribute("coursout", coursout);
        model.addAttribute("orderEntry", coursouts);
        Semester nameBySemesterid = this.semesterRepository.getNameBysemesterid(coursout.semesterid);					
		model.addAttribute("semesterName", nameBySemesterid);
        return "faculty/pdfcoursOut";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
    }
	
	
	@RequestMapping("/{cId}/coursepdf")
	public String getCoursoutPdfPage(@PathVariable("cId") Integer cId,Model model,Principal principal,HttpSession session) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(cId);
		Coursout coursout = coursoutOptional.get();
		model.addAttribute("coursout", coursout);
		
		return "faculty/pdfcoursOut";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	
	
	
	
	
	@RequestMapping(path = "/evalupdf")
    public String getEvaluResultPdfPage(Model model,HttpSession session) throws IOException {
		try {
		List<Coursout> coursouts = this.coursoutRepository.findAll();
		Coursout coursout = this.coursoutRepository.findById(3).get();
		/* Order order = OrderHelper.getOrder() */
		model.addAttribute("coursout", coursout);
        model.addAttribute("orderEntry", coursouts);
        Semester nameBySemesterid = this.semesterRepository.getNameBysemesterid(coursout.semesterid);					
		model.addAttribute("semesterName", nameBySemesterid);
        return "faculty/evalupdf";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
    }
	
	
	
	
	
	
	@RequestMapping("/index")
	public String dashbfacu(Model model,HttpSession session) {
		try {
		model.addAttribute("title","C|And|F - Home");	
		List<Post> findAllPost = this.postRepo.findAllPost1();
		model.addAttribute("allPost", findAllPost);	
		return "faculty/index";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@RequestMapping("/sample")
	public String sample(Model model,HttpSession session) {
		try {
		model.addAttribute("title","C|And|F - sample");		
		return "faculty/sample";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@RequestMapping("/report")
	public String repor(Model model) {
		model.addAttribute("title","C|And|F - Report");		
		return "faculty/report";
	}
	
	@RequestMapping("/table")
	public String table(Model model) {
		model.addAttribute("title","C|And|F - Table");		
		return "faculty/tables";
	}
	
	@RequestMapping("/blank")
	public String blan(Model model) {
		model.addAttribute("title","C|And|F - Blank");		
		return "faculty/blanks";
	}
	
	
	
	@RequestMapping("/addCours")
	public String Addcours(Model model,Principal principal,HttpSession session) {
		try {
		model.addAttribute("title","C|And|F - Add Cours");
		model.addAttribute("coursout",new Coursout());
		
		/*
		 * String roledd = "ROLE_DIV"; List<User> uuu=
		 * this.userRepository.getUserByRole(roledd); model.addAttribute("userss", uuu);
		 */
		List<Fmie> fmieList = this.fmieRepository.findAll();
		model.addAttribute("fmies",fmieList); 
		return "faculty/add_coursOut";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@GetMapping("/show_Cours")
	public String showCorsout(Model m,Principal principal,HttpSession session) {
		try {
		m.addAttribute("title", "C|And|F - Show Cours");		
		List<Coursout> coursouts = this.coursoutRepository.findAll();
		m.addAttribute("coursouts", coursouts);
		
		return "faculty/show_Cours";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	//processing add CoursOutline form
		@PostMapping("/process-cours")
		public String processCours(@ModelAttribute  Coursout coursout,Refer refer,Assess assess,Model model,				
				Week week,Chapteraf chapteraf,Chapterbf chapterbf,Chapterlast chapterlast,
				ComLearn comlearn,Methodo methodo,ActiLab actilab,TabRef tabref,AssWeek assWeek ,Principal principal,HttpSession session) {
			
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
			LocalDateTime now1 = LocalDateTime.now();
			/* comLearnRepo; methodoRepo; actiLabRepo; tabRefRepo; assWeekRepo; */
			try {
				
				int weekid=weekRepo.save(week).getwId();
				int chapterbfid=chapBfRepo.save(chapterbf).getBfId();
				int chapterafid=chapAfRepo.save(chapteraf).getAfId();
				int chapterlastid=chapLasRepo.save(chapterlast).getlId();
				
				int referid=refRepo.save(refer).getRefId();
				int assessid=assRepo.save(assess).getAsseId();
				
				
				int comlearnid=comLearnRepo.save(comlearn).getClenId();
				int methodoid=methodoRepo.save(methodo).getMethId();
				int actilabid=actiLabRepo.save(actilab).getAlabId();
				int tabrefid=tabRefRepo.save(tabref).getTbrId();
				int assweekid=assWeekRepo.save(assWeek).getAswId();
				
				        coursout.setaYear(dtf1.format(now1));
						coursout.setFmie(null);	
						
						
						coursout.setChapterbfid(chapterbfid);
						coursout.setChapterafid(chapterafid);
						coursout.setChapterlastid(chapterlastid);
						coursout.setWeekid(weekid);
						coursout.setReferid(referid);
						coursout.setAssessid(assessid);
						
						coursout.setComlearnid(comlearnid);
						coursout.setMethodoid(methodoid);
						coursout.setActilabid(actilabid);
						coursout.setTabrefid(tabrefid);
						coursout.setAsweekid(assweekid);
						
						
				this.coursoutRepository.save(coursout);
				
				
				
			//message success...........
				session.setAttribute("message", new Message("Successfully Add New Cours Outline  !!","alert-success"));
		    
				return "redirect:/faculty/addCours";
			}catch(Exception e) {
				System.out.println("ERROR"+e.getMessage());
				e.printStackTrace();
		    //message error.............
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				
			}
			
			
			return "redirect:/faculty/addCours";
		    
		}
		
		
		
		
		
		//showing perticular contact detailes.
		
		@RequestMapping("/{cId}/coursout")
		public String showConsoutDetail(@PathVariable("cId") Integer cId,Model model,Principal principal,HttpSession session) {
			/* model.addAttribute("userCoursout",new UserCoursout()); */
			model.addAttribute("title", "C|And|F - Show Cours Details");	
			try {
			Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(cId);
			Coursout coursout = coursoutOptional.get();
			
			model.addAttribute("coursout", coursout);
			
			Fmie nameByFmieid = this.fmieRepository.getNameByFmieid(coursout.fmieid);			
			model.addAttribute("fmieName", nameByFmieid);
			
			Semester nameBySemesterid = this.semesterRepository.getNameBysemesterid(coursout.semesterid);					
			model.addAttribute("semesterName", nameBySemesterid);
			
            Groupt nameByGrouptid = this.grouptRepository.getNameByGrouptid(coursout.grouptid);
			model.addAttribute("grouptName",nameByGrouptid);

			String role399 = "CHAIR_HOLDER";
			Integer id399 = roleRepo.findByName(role399).getId();
			List<User> user3 = this.userRepository.findByRole(id399);
			model.addAttribute("getRCHname", user3);
			
			
			return "faculty/coursout_detail";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
			
		}
		
		//delete contact handler
		@GetMapping("/delete/{cid}")
		public String deleteCoursout(@PathVariable("cid") Integer cId,Model model,HttpSession session,
				Week week,Chapteraf chapteraf,Chapterbf chapterbf,Chapterlast chapterlast
				,Principal principal,Refer refer) {
			try {
			Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(cId);
			Coursout coursout = coursoutOptional.get();
			//Check session................Assignment.......
			 
               
			    this.coursoutRepository.delete(coursout);
			
			
                Refer refer2 = this.refRepo.findById(coursout.referid).get();
                Week week2 = this.weekRepo.findById(coursout.weekid).get();
				Chapterbf chapterbf2 = this.chapBfRepo.findById(coursout.chapterbfid).get();
				Chapteraf chapteraf2 = this.chapAfRepo.findById(coursout.chapterafid).get();
				Chapterlast chapterlast2 = this.chapLasRepo.findById(coursout.chapterlastid).get();
                
                
                
                
				this.weekRepo.delete(week2);
				this.chapBfRepo.delete(chapterbf2);
				this.chapAfRepo.delete(chapteraf2);
				this.chapLasRepo.delete(chapterlast2);
                this.refRepo.delete(refer2);
			
                
			///message....
			session.setAttribute("message", new Message("Successfully Deleted  !!","alert-success"));
			
			return "redirect:/faculty/show_Cours";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		//update form handler
				@PostMapping("/update-coursout/{cid}")
				public String updateFormcors(@PathVariable("cid") Integer cid, Model m,HttpSession session) {
					try {
					m.addAttribute("title", "Update coursout");					
					Coursout coursout = this.coursoutRepository.findById(cid).get();
					m.addAttribute("coursout", coursout);
					
					Fmie nameByFmieid = this.fmieRepository.getNameByFmieid(coursout.fmieid);					
					m.addAttribute("fmieName", nameByFmieid);
					
					Semester nameBySemesterid = this.semesterRepository.getNameBysemesterid(coursout.semesterid);					
					m.addAttribute("semesterName", nameBySemesterid);
					
	                Groupt nameByGrouptid = this.grouptRepository.getNameByGrouptid(coursout.grouptid);
					m.addAttribute("grouptName",nameByGrouptid);
					
					
					return "faculty/update-coursout";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				// update contact handler
				@RequestMapping(value = "/process-updateCor", method = RequestMethod.POST)
				public String updateHandler(@ModelAttribute Coursout coursout, Refer refer,Assess assess,
						Week week,Chapteraf chapteraf,Chapterbf chapterbf,Chapterlast chapterlast
						,ComLearn comlearn,Methodo methodo,ActiLab actilab,TabRef tabref,AssWeek assWeek
						,Model m, HttpSession session, Principal principal) {
					
					DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
					LocalDateTime now1 = LocalDateTime.now();
					 
					try {
						
						
						
						
						this.weekRepo.save(week);
						this.chapBfRepo.save(chapterbf);
						this.chapAfRepo.save(chapteraf);
						this.chapLasRepo.save(chapterlast);
						this.refRepo.save(refer);
						this.assRepo.save(assess);
						
						this.comLearnRepo.save(comlearn);
						this.methodoRepo.save(methodo);
						this.actiLabRepo.save(actilab);
						this.tabRefRepo.save(tabref);
						this.assWeekRepo.save(assWeek);
						
						coursout.setaYear(dtf1.format(now1));
						this.coursoutRepository.save(coursout);

						session.setAttribute("message", new Message("Your contact is updated...", "alert-success"));

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("Coursout Title is from " + coursout.getCcode());
					System.out.println("Coursout ID is from " + coursout.getcId());
					return "redirect:/faculty/" + coursout.getcId() + "/coursout";
				}	
				
				
				
				
	
				
				
				
				
}
