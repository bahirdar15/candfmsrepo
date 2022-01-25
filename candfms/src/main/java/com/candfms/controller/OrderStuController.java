package com.candfms.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.candfms.models.Fmie;
import com.candfms.models.Groupt;
import com.candfms.models.Semester;
import com.candfms.models.StuCart;
import com.candfms.models.StuOrder;
import com.candfms.models.StuOrderDetile;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.models.UserCoursoutDetile;
import com.candfms.models.Year;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.FmieRepository;
import com.candfms.repositories.GrouptRepository;
import com.candfms.repositories.InstaOrderDeileRepository;
import com.candfms.repositories.InstaOrderRepository;
import com.candfms.repositories.OrderRepository;
import com.candfms.repositories.RoleRepository;
import com.candfms.repositories.SemisterRepository;
import com.candfms.repositories.StuCartStuRepository;
import com.candfms.repositories.StuOrderDeileRepository;
import com.candfms.repositories.StuOrderRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserCoursoutAssignRepository;
import com.candfms.repositories.UserCoursoutDetileRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.repositories.YearRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

@Controller
@RequestMapping("/orderStu")
public class OrderStuController {

	@Autowired
	private UserCoursoutAssignRepository UserCourAssignRepo;
	
	@Autowired
	private UserCoursoutDetileRepository userCourDetileRepo;

	
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
	}
	
	
	
	// for new from instructor request in one	
	
		@RequestMapping("/newfeedback")
		public String showNewInstaCartdds(Model m, Principal principal,HttpSession session) {
			try {
			m.addAttribute("title", "C|And|F - Request");
			//String userName = principal.getName();
			//User user = userRepository.getUserByUserName(userName);
			 List<UserCoursoutDetile> userCoursoutDetile = this.userCourDetileRepo.findAll();		
		//	List<UserCoursout> userCoursouts = this.userCoursoutRepository.findAll();
			m.addAttribute("userCoursoutDetile", userCoursoutDetile);
			
			return "faculty/newfeedback";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
	
	// for cart page in one	
	
	@RequestMapping("/show_cartStu")
	public String showInstaCartdds(Model model,Principal principal,StuCart stuCart,HttpSession session) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title","C|And|F - My Cart");	
		String name = principal.getName();
		User user=this.userRepository.getUserByUserName(name);
		
		
         List<StuCart> findByUserId = this.stuCartRepository.findByUserId(user.getId());
		
		if(!findByUserId.isEmpty()) { 
			model.addAttribute("instaCartd",findByUserId);
		  } else {
			  model.addAttribute("instaCart6", "null cart");
		  }
		
		return "faculty/insta_cartShowStu";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	// Go to New
	
		@RequestMapping("/{cId}/cartStu")
		public String showCartByIds(@PathVariable("cId") Integer cId,Model m,Principal principal,HttpSession session) {	
			try {
			m.addAttribute("title","C|And|F - Cart");	
			/*
			 * Optional<Coursout> coursoutOptional = this.coursoutRepository.findById(cId);
			 * Coursout coursout = coursoutOptional.get();
			 * 
			 * m.addAttribute("coursouted", coursout);
			 */
			
			 UserCoursoutDetile userCoursoutDetile = this.userCourDetileRepo.findById(cId).get();			
			 m.addAttribute("userCoursoutDetile", userCoursoutDetile);	
			
			return "faculty/insta_cartStu";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		// process new handler
		@RequestMapping(value = "/process-cartStu", method = RequestMethod.POST)
		public String updateHandlers(@ModelAttribute StuCart stuCart, 
				Model m, HttpSession session, Principal principal) {

			try {			
					this.stuCartRepository.save(stuCart);
					session.setAttribute("message", new Message("Your Data is Saved...", "alert-success"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return "redirect:/orderStu/show_cartStu";
		}	
	
		//go to update form handler
		@GetMapping("/update-cartStu/{cid}")
		public String updateFormcorss(@PathVariable("cid") Integer cid, Model m,HttpSession session) {
			try {
			m.addAttribute("title", "Update Cart");				
			StuCart stuCart = this.stuCartRepository.findById(cid).get();			
			m.addAttribute("instaCart2",stuCart);
			
			return "faculty/insta_cartEditeStu";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		
		// update process
		@RequestMapping(value = "/process-updatecartStu", method = RequestMethod.POST)
		public String updateCartProcessHandletrs(@ModelAttribute StuCart stuCart, 
				Model m, HttpSession session, Principal principal) {

			try {


				this.stuCartRepository.save(stuCart);

				session.setAttribute("message", new Message("Your Data is updated...", "alert-success"));

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/orderStu/show_cartStu";
		}	
		
		// delete cart handler
		@GetMapping("/deleteCartStu/{id}")
		public String deleteCoursoutts(@PathVariable("id") Integer id, Model m, HttpSession session,
				Principal principal) {
			try {
			StuCart stuCart = this.stuCartRepository.findById(id).get();			
									
			// Check session................Assignment.......

			this.stuCartRepository.delete(stuCart);

			/// message....
			session.setAttribute("message", new Message("Successfully Deleted  !!", "alert-success"));

			return "redirect:/orderStu/show_cartStu";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
		
		// order process
				@RequestMapping(value = "/process-orderStu", method = RequestMethod.POST)
				public String orderCartProcessHandlerrs(@ModelAttribute StuCart stuCart,StuOrder stuOrder, 
						StuOrderDetile stuOrderDetile,Model m, HttpSession session, Principal principal, 
						@RequestParam("semesterid") Integer semesterid,@RequestParam("coursoutid") Integer coursoutid,
						 @RequestParam("bam") String bam,@RequestParam("prog") String prog, 
						 @RequestParam("section") String section, @RequestParam("yearid") Integer yearid) {
					try { 
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);						
					//check if signature fill 										
					if(!user.getSignature().equals("1")) {						
						session.setAttribute("message", new Message("Before Request Fill signature Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						
						try {		
							
							/* InstaOrder instaOrder= new InstaOrder(); */
							//for filld date
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDateTime now = LocalDateTime.now();
							//for acadamic year
							DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
							LocalDateTime now1 = LocalDateTime.now();
							
							
							 
								Integer compaid88 = this.stuOrderDeileRepository.findnafByid(dtf1.format(now1),semesterid,bam,prog,user.getId(),yearid,section,coursoutid);
								
								if(compaid88==null) {
									/* start code */


									stuOrder.setFilleddate(dtf.format(now));
									stuOrder.setAyear(dtf1.format(now1));
									stuOrder.setStatus("Filled"); 
									  int orderid=stuOrderRepository.save(stuOrder).getId();
									  System.out.println("order id is ...... " + orderid);						  						  
									  List<StuCart> instaCartOptional = this.stuCartRepository.findByUserId(user.getId());
										/* m.addAttribute("instaCart",instaCartOptional); */						  
									  for(StuCart instaCart1:instaCartOptional) {
										  StuOrderDetile instaOrderDetile1 = new StuOrderDetile();
										  instaOrderDetile1.setId(instaCart1.getCoursout().getcId());
										 // instaOrderDetile1.setNcc(instaCart1.getNcc());
										 // instaOrderDetile1.setNcp(instaCart1.getNcp());
										  instaOrderDetile1.setNcco(instaCart1.getNcco());
										 // instaOrderDetile1.setNap(instaCart1.getNap());
										  instaOrderDetile1.setNad(instaCart1.getNad());
										  instaOrderDetile1.setNaf(instaCart1.getNaf());
										  
										  instaOrderDetile1.setRema(instaCart1.getRema());
										  
										  instaOrderDetile1.setUserCoursoutDetileid(instaCart1.getUserCoursoutDetileid());
										  instaOrderDetile1.setCoursoutid(instaCart1.getCoursoutid());
										  instaOrderDetile1.setOrderid(orderid); 
										  
										  instaOrderDetile1.setUserid(user.getId()); 
										  instaOrderDetile1.setBam(bam);
										  instaOrderDetile1.setSemesterid(semesterid);
										  instaOrderDetile1.setAyear(dtf1.format(now1));
										  instaOrderDetile1.setYearid(yearid);
										  instaOrderDetile1.setSection(section);
										  instaOrderDetile1.setProg(prog);
										  
										  this.stuOrderDeileRepository.save(instaOrderDetile1);							  
									  }						
									  
									  this.stuCartRepository.deleteAll(instaCartOptional); 											
									session.setAttribute("message", new Message("Your Data is Filled Success...", "alert-success"));
									return "redirect:/orderStu/show_myorderStu1";
									/* end code */
								}else {
									session.setAttribute("message", new Message("Your Data data already exists!!  ደጋግሞ መሙላት የተክለከለ ነው።!! ...", "alert-danger"));
									 
									return "redirect:/orderStu/show_cartStu";
								}
							 

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
					
					
					return "redirect:/orderStu/show_myorderStu1";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}	
		
				// Show Order page 	
				
				@RequestMapping("/show_myorderStu1")
				public String showOrderUserIdss1(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<StuOrder> findByOrderUserId = this.stuOrderRepository.findByOrderUserId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<StuOrder> findByApprovedCourseChairId = this.stuOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<StuOrder> findByEndorsedChairHolderId = this.stuOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<StuOrder> dean = this.stuOrderRepository.findAll();
					model.addAttribute("dean",dean);
					
					return "faculty/insta_myOrderShowStu1";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				@RequestMapping("/show_myorderStu2")
				public String showOrderUserIdss2(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<StuOrder> findByOrderUserId = this.stuOrderRepository.findByOrderUserId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<StuOrder> findByApprovedCourseChairId = this.stuOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<StuOrder> findByEndorsedChairHolderId = this.stuOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<StuOrder> dean = this.stuOrderRepository.findAll();
					model.addAttribute("dean",dean);
					
					return "faculty/insta_myOrderShowStu2";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				@RequestMapping("/show_myorderStu3")
				public String showOrderUserIdss3(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<StuOrder> findByOrderUserId = this.stuOrderRepository.findByOrderUserId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<StuOrder> findByApprovedCourseChairId = this.stuOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<StuOrder> findByEndorsedChairHolderId = this.stuOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<StuOrder> dean = this.stuOrderRepository.findAll();
					model.addAttribute("dean",dean);
					
					return "faculty/insta_myOrderShowStu3";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				@RequestMapping("/show_myorderStu4")
				public String showOrderUserIdss4(Model model,Principal principal,HttpSession session) {
					/* model.addAttribute("userCoursout",new UserCoursout()); */
					try {
					model.addAttribute("title","C|And|F - My Order");	
					String name = principal.getName();
					User user=this.userRepository.getUserByUserName(name);										
					List<StuOrder> findByOrderUserId = this.stuOrderRepository.findByOrderUserId(user.getId());
					model.addAttribute("instaOrder",findByOrderUserId);	
					
					List<StuOrder> findByApprovedCourseChairId = this.stuOrderRepository.findByApprovedCourseChairId(user.getId());
					model.addAttribute("approvedby",findByApprovedCourseChairId);	
					
					List<StuOrder> findByEndorsedChairHolderId = this.stuOrderRepository.findByEndorsedChairHolderId(user.getId());
					model.addAttribute("endorsedby",findByEndorsedChairHolderId);	
					
					List<StuOrder> dean = this.stuOrderRepository.findAll();
					model.addAttribute("dean",dean);
					
					return "faculty/insta_myOrderShowStu4";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				@RequestMapping("/{cId}/orderdtaileStu")
				public String showOrderByOrderIds(@PathVariable("cId") Integer cId,Model m,
						Principal principal,HttpSession session) {	
					try {
					m.addAttribute("title","C|And|F - Order Details");	
				     StuOrder stuOrder = this.stuOrderRepository.findById(cId).get();				
					m.addAttribute("instaOrders", stuOrder);	
					
					List<StuOrderDetile> findByOrderId = stuOrderDeileRepository.findByOrderId(cId);
					m.addAttribute("orderDetailes", findByOrderId);	
					
					User approve = this.userRepository.getUserByapproIdSingle(stuOrder.getApprovedby());
					m.addAttribute("approve", approve);

					User endor = this.userRepository.getUserByapproIdSingle(stuOrder.getEndorsedby());
					m.addAttribute("endor", endor);
					
					return "faculty/insta_myOrderDetaileStu";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				// approve handler
				@RequestMapping(value = "/process-approvedPostStu", method = RequestMethod.POST)
				public String apprCoursouts(Model model, HttpSession session,
						StuOrder stuOrder, Principal principal) {
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
						 stuOrder.setApproveddate(dtf.format(now));
						 stuOrder.setStatus("Approved");
						 stuOrderRepository.save(stuOrder);				
			    		 session.setAttribute("message", new Message("Successfully Approved  !!", "alert-success"));

					}
					
					return "redirect:/orderStu/show_myorderStu2";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
	
	
				
				// Endorsed handler
				@GetMapping("/endorsedStu/{id}")
				public String apprCoursoutsStu(@PathVariable("id") Integer id, Model model, HttpSession session, Principal principal) {
					try {
					String userName = principal.getName();
					User user = userRepository.getUserByUserName(userName);
					Optional<StuOrder> instaOrder1 = this.stuOrderRepository.findById(id);
					StuOrder instaOrder2 = instaOrder1.get();
					
					if(!user.getSignature().equals("1")) {
						
						session.setAttribute("message", new Message("Before Approved Fill in the Uplode Image then after update go back into request form!!" , "alert-danger"));
						return "redirect:/faculty/add-signature";
					}else {
						//insert date
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();	        
						
						 instaOrder2.setEndorseddate(dtf.format(now));
						 instaOrder2.setStatus("Endorsed");						
						 stuOrderRepository.save(instaOrder2);
						session.setAttribute("message", new Message("Successfully Endorsed  !!", "alert-success"));

					}
					
					return "redirect:/orderStu/show_myorderStu3";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
/* insta feedback instaFeedbackpdf  pdf*/
				
				@RequestMapping(path = "/{cId}/stuFeedbackpdf")
			    public ResponseEntity<?> getPDFf(@PathVariable("cId") Integer cId,HttpServletRequest request, HttpServletResponse response) throws IOException {
					String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
				            .replacePath(null)
				            .build()
				            .toUriString();
					/* Do Business Logic*/					
					StuOrder instaOrders = this.stuOrderRepository.findById(cId).get();											
					List<StuOrderDetile> orderDetailes = stuOrderDeileRepository.findByOrderId(cId);
		
					
					User approve = this.userRepository.getUserByapproIdSingle(instaOrders.getApprovedby());
					User endor = this.userRepository.getUserByapproIdSingle(instaOrders.getEndorsedby());
					 
					/* Order order = OrderHelper.getOrder(); */
			        /* Create HTML using Thymeleaf template Engine */  
					WebContext context = new WebContext(request, response, servletContext);
			       
			        context.setVariable("instaOrders", instaOrders);
			        context.setVariable("orderDetailes", orderDetailes);
			        
			        context.setVariable("approve", approve);
			        context.setVariable("endor", endor);
			        
			        String orderHtml = facultyController.templateEngine.process("faculty/pdffeedbackStudent", context);
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
}
