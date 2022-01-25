package com.candfms.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
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
import com.candfms.models.Fmie;
import com.candfms.models.Groupt;
import com.candfms.models.InstaCart;
import com.candfms.models.InstaOrder;
import com.candfms.models.InstaOrderDetile;
import com.candfms.models.Semester;
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
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserCoursoutAssignRepository;
import com.candfms.repositories.UserCoursoutDetileRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.repositories.YearRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserCoursoutAssignRepository UserCourAssignRepo;
	
	@Autowired
	private UserCoursoutDetileRepository userCourDetileRepo;

	
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
	HomeController homController;
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
			
		// get the user using username(username)
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);

		

		String role2 = "COURSE_CHAIR";
		Integer id2 = roleRepo.findByName(role2).getId();
		List<User> user2 = this.userRepository.findByRole(id2);
		model.addAttribute("coursChair", user2);

		String role3 = "CHAIR_HOLDER";
		Integer id3 = roleRepo.findByName(role3).getId();
		List<User> user3 = this.userRepository.findByRole(id3);
		model.addAttribute("chairHolder", user3);
		
		

		List<Fmie> fmieList = this.fmieRepository.findAll();
		model.addAttribute("fmies", fmieList);

		List<Year> yearList = this.yearRepository.findAll();
		model.addAttribute("years", yearList);

		List<Semester> semesterList = this.semesterRepository.findAll();
		model.addAttribute("semesters", semesterList);

		List<Groupt> grouptList = this.grouptRepository.findAll();
		model.addAttribute("groupts", grouptList);
		
		List<Integer> assiandIns = new ArrayList<>();
		assiandIns.add(id2);
				
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
		
		List<User> userAll = this.userRepository.findAll();
		model.addAttribute("userAll", userAll);
		
		
		 
	}

	// for cart page in one

	@RequestMapping("/show_cart")
	public String showInstaCart(Model model, Principal principal, HttpSession session,InstaCart instaCart) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title", "C|And|F - My Cart");
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		List<InstaCart> instaCartOptional4 = this.orderRepository.findByUserId(user.getId()); 
		/*
		 * if(instaCartOptional4 != null) { model.addAttribute("instaCart4",
		 * instaCartOptional4); }
		 */
		  
		  if(!instaCartOptional4.isEmpty()) { 
			  model.addAttribute("instaCart5", instaCartOptional4);
		  } else {
			  model.addAttribute("instaCart6", "null cart");
		  }

		return "faculty/insta_cartShow";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// Go to New

	@RequestMapping("/{cId}/cart")
	public String showCartById(@PathVariable("cId") Integer cId, Model m,HttpSession session, Principal principal) {
		try {
		m.addAttribute("title", "C|And|F - Cart");
		 Optional<UserCoursoutDetile> findById = this.userCourDetileRepo.findById(cId);
			UserCoursoutDetile userCoursoutDetile = findById.get();
		
		//UserCoursout userCoursout = this.userCoursoutRepository.findById(cId).get();
		m.addAttribute("userCoursoutDetile", userCoursoutDetile);

		return "faculty/insta_cart";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
		
	}

	// process new handler
	@RequestMapping(value = "/process-cart", method = RequestMethod.POST)
	public String updateHandler(@ModelAttribute InstaCart instaCart, Model m, HttpSession session,
			Principal principal) {

		try {

			this.orderRepository.save(instaCart);
			session.setAttribute("message", new Message("Your Data is Saved...", "alert-success"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/order/show_cart";
	}

	// go to update form handler
	@GetMapping("/update-cart/{cid}")
	public String updateFormcors(@PathVariable("cid") Integer cid, Model m,HttpSession session) {
		try {
		m.addAttribute("title", "Update Cart");
		InstaCart instaCart = this.orderRepository.findById(cid).get();
		m.addAttribute("instaCart2", instaCart);

		return "faculty/insta_cartEdite";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// update process
	@RequestMapping(value = "/process-updatecart", method = RequestMethod.POST)
	public String updateCartProcessHandler(@ModelAttribute InstaCart instaCart, Model m, HttpSession session,
			Principal principal) {

		try {

			this.orderRepository.save(instaCart);

			session.setAttribute("message", new Message("Your Data is updated...", "alert-success"));

		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
		return "redirect:/order/show_cart";
	}

	// delete cart handler
	@GetMapping("/deleteCart/{id}")
	public String deleteCoursout(@PathVariable("id") Integer id, Model m, HttpSession session, Principal principal) {
		try {
		InstaCart instaCart = this.orderRepository.findById(id).get();

		// Check session................Assignment.......

		this.orderRepository.delete(instaCart);

		/// message....
		session.setAttribute("message", new Message("Successfully Deleted  !!", "alert-success"));

		return "redirect:/order/show_cart";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// order process
		@RequestMapping(value = "/process-order", method = RequestMethod.POST)
		public String orderCartProcessHandler(@ModelAttribute InstaCart instaCart, InstaOrder instaOrder,
				InstaOrderDetile instaOrderDetile, Model m, HttpSession session, Principal principal, 
				 @RequestParam("semesterid") Integer semesterid,
				 @RequestParam("bam") String bam,@RequestParam("prog") String prog) {
			
			String name = principal.getName();
			User user = this.userRepository.getUserByUserName(name);
			// check if signature fill
			if (!user.getSignature().equals("1")) {
				session.setAttribute("message",
						new Message("Before Request Fill signature Image then after update go back into request form!!",
								"alert-danger"));
				return "redirect:/faculty/add-signature";
			} else {

				try {
					
					
					/* InstaOrder instaOrder= new InstaOrder(); */
					// for filld date
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now = LocalDateTime.now();
					// for acadamic year
					DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
					LocalDateTime now1 = LocalDateTime.now();
					instaOrder.setFilleddate(dtf.format(now));
					instaOrder.setAyear(dtf1.format(now1));
					instaOrder.setStatus("Filled");
					
					
					
					
					
					
					
					
					List<InstaCart> instaCartOptional = this.orderRepository.findByUserId(user.getId());

						Integer compaid = this.instaOrderDeileRepository.findnafBy34compaid(dtf1.format(now1),semesterid,bam,prog);
						if(compaid==null || compaid==0) {
							
							 
					/*	start code*/
							for (InstaCart instaCart2 : instaCartOptional) {
								int yearr=instaCart2.getYearid();
								String sect=instaCart2.getSect();
								int coursoutid = instaCart2.getCoursoutid();
							Integer compaid8 = this.instaOrderDeileRepository.findnafBy8compaid(dtf1.format(now1),semesterid,bam,prog,user.getId(),yearr,sect,coursoutid);
							
							if(compaid8==null) {
								
								
								/*	start code 2*/	
							int orderid = instaOrderRepository.save(instaOrder).getId();	
							 InstaOrder orderIdbyInsertId  = instaOrderRepository.findById(orderid).get();
							for (InstaCart instaCart1 : instaCartOptional) {
								InstaOrderDetile instaOrderDetile1 = new InstaOrderDetile();
								
								instaOrderDetile1.setNcco(instaCart1.getNcco());
								
								instaOrderDetile1.setNad(instaCart1.getNad());
								instaOrderDetile1.setNaf(instaCart1.getNaf());
								instaOrderDetile1.setSect(instaCart1.getSect());
								/* instaOrderDetile1.setProg(instaCart1.getProg()); */
								instaOrderDetile1.setRema(instaCart1.getRema());
								instaOrderDetile1.setFmieid(user.getDepar());
								instaOrderDetile1.setYearid(instaCart1.getYearid());
								
								
								instaOrderDetile1.setProg(orderIdbyInsertId.getProg());
								instaOrderDetile1.setSemesterid(orderIdbyInsertId.getSemesterid());
								instaOrderDetile1.setAyear(orderIdbyInsertId.getAyear());
								instaOrderDetile1.setEndorsedby(orderIdbyInsertId.getEndorsedby());
								instaOrderDetile1.setApprovedby(orderIdbyInsertId.getApprovedby());
								instaOrderDetile1.setBam(orderIdbyInsertId.getBam());
								instaOrderDetile1.setFilledby(user.getId());
								
								instaOrderDetile1.setUserCoursoutDetileid(instaCart1.getUserCoursoutDetileid());
								instaOrderDetile1.setCoursoutid(instaCart1.getCoursoutid());
								instaOrderDetile1.setOrderid(orderid);
								if(orderIdbyInsertId.getBam()=="1") {
									instaOrderDetile1.setNcc(instaCart1.getCoursout().getChapbf());
									instaOrderDetile1.setNcp(instaCart1.getCoursout().getChapbfmidplan());
									instaOrderDetile1.setNap(instaCart1.getCoursout().getAssbfmidplan());
								}else {
									instaOrderDetile1.setNcc(instaCart1.getCoursout().getChapaf());
									instaOrderDetile1.setNcp(instaCart1.getCoursout().getChapafmidplan());
									instaOrderDetile1.setNap(instaCart1.getCoursout().getAssafmidplan());
								}
								
								
								this.instaOrderDeileRepository.save(instaOrderDetile1);
							}

							this.orderRepository.deleteAll(instaCartOptional);
							
							session.setAttribute("message", new Message("Your Data is Filled Success...", "alert-success"));

							return "redirect:/order/show_myorder1";
							/*	end code 2*/
							
							
							
							}else {
								
								session.setAttribute("message", new Message("Your Data data already exists!!  ደጋግሞ መሙላት የተክለከለ ነው።!! ...", "alert-danger"));
												 
								return "redirect:/order/show_cart";
							}
							
							}
					/* end code */
							
						}else {
							
							session.setAttribute("message", new Message("Before Filled Check Semester and Mid Exam!!",
											"alert-danger"));
							return "redirect:/order/show_cart";
						}
					
					
					
					
					
				} catch(Exception e) {
					e.printStackTrace(); 
					session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
					return "faculty/index";
				}

			}

			return "redirect:/order/show_myorder1";
		}

	// Show Order page

	@RequestMapping("/show_myorder1")
	public String showOrderUserIds(Model model, Principal principal,HttpSession session, InstaCart instaCart) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title", "C|And|F - My Cart");
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		List<InstaOrder> findByOrderUserId = this.instaOrderRepository.findByOrderUserId(user.getId());
		model.addAttribute("instaOrder", findByOrderUserId);

		List<InstaOrder> findByApprovedCourseChairId = this.instaOrderRepository
				.findByApprovedCourseChairId(user.getId());
		model.addAttribute("approvedby", findByApprovedCourseChairId);

		List<InstaOrder> findByEndorsedChairHolderId = this.instaOrderRepository
				.findByEndorsedChairHolderId(user.getId());
		model.addAttribute("endorsedby", findByEndorsedChairHolderId);

		List<InstaOrder> dean = this.instaOrderRepository.findAll();
		model.addAttribute("dean", dean);

		return "faculty/insta_myOrderShow1";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	@RequestMapping("/show_myorder2")
	public String showOrderUserIds2(Model model,HttpSession session, Principal principal, InstaCart instaCart) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title", "C|And|F - My Cart");
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		List<InstaOrder> findByOrderUserId = this.instaOrderRepository.findByOrderUserId(user.getId());
		model.addAttribute("instaOrder", findByOrderUserId);

		List<InstaOrder> findByApprovedCourseChairId = this.instaOrderRepository
				.findByApprovedCourseChairId(user.getId());
		model.addAttribute("approvedby", findByApprovedCourseChairId);

		List<InstaOrder> findByEndorsedChairHolderId = this.instaOrderRepository
				.findByEndorsedChairHolderId(user.getId());
		model.addAttribute("endorsedby", findByEndorsedChairHolderId);

		List<InstaOrder> dean = this.instaOrderRepository.findAll();
		model.addAttribute("dean", dean);

		return "faculty/insta_myOrderShow2";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	@RequestMapping("/show_myorder3")
	public String showOrderUserIds3(Model model, 
			HttpSession session ,Principal principal, InstaCart instaCart) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title", "C|And|F - My Cart");
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		List<InstaOrder> findByOrderUserId = this.instaOrderRepository.findByOrderUserId(user.getId());
		model.addAttribute("instaOrder", findByOrderUserId);

		List<InstaOrder> findByApprovedCourseChairId = this.instaOrderRepository
				.findByApprovedCourseChairId(user.getId());
		model.addAttribute("approvedby", findByApprovedCourseChairId);

		List<InstaOrder> findByEndorsedChairHolderId = this.instaOrderRepository
				.findByEndorsedChairHolderId(user.getId());
		model.addAttribute("endorsedby", findByEndorsedChairHolderId);

		List<InstaOrder> dean = this.instaOrderRepository.findAll();
		model.addAttribute("dean", dean);

		return "faculty/insta_myOrderShow3";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	@RequestMapping("/show_myorder4")
	public String showOrderUserIds4(Model model, Principal principal,HttpSession session, InstaCart instaCart) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		model.addAttribute("title", "C|And|F - My Cart");
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		List<InstaOrder> findByOrderUserId = this.instaOrderRepository.findByOrderUserId(user.getId());
		model.addAttribute("instaOrder", findByOrderUserId);

		List<InstaOrder> findByApprovedCourseChairId = this.instaOrderRepository
				.findByApprovedCourseChairId(user.getId());
		model.addAttribute("approvedby", findByApprovedCourseChairId);

		List<InstaOrder> findByEndorsedChairHolderId = this.instaOrderRepository
				.findByEndorsedChairHolderId(user.getId());
		model.addAttribute("endorsedby", findByEndorsedChairHolderId);

		List<InstaOrder> dean = this.instaOrderRepository.findAll();
		model.addAttribute("dean", dean);
		return "faculty/insta_myOrderShow4";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	@RequestMapping("/{cId}/orderdtaile")
	public String showOrderByOrderId(@PathVariable("cId") Integer cId, Model m,
			HttpSession session,Principal principal, User user) {
		try {
		m.addAttribute("title", "C|And|F - Cart");
		InstaOrder instaOrder = this.instaOrderRepository.findById(cId).get();
		m.addAttribute("instaOrders", instaOrder);

		List<InstaOrderDetile> findByOrderId = instaOrderDeileRepository.findByOrderId(cId);
		m.addAttribute("orderDetailes", findByOrderId);

		/*
		 * User approve =
		 * this.userRepository.findById(instaOrder.getApprovedby()).get();
		 * m.addAttribute("approve", approve);
		 */

		User approve = this.userRepository.getUserByapproIdSingle(instaOrder.getApprovedby());
		m.addAttribute("approve", approve);

		User endor = this.userRepository.getUserByapproIdSingle(instaOrder.getEndorsedby());
		m.addAttribute("endor", endor);

		return "faculty/insta_myOrderDetaile";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// approve handler
	@RequestMapping(value = "/process-approvedPost", method = RequestMethod.POST)
	public String apprCoursout(@RequestParam("endorsedby")Integer endorsedby,Model model, HttpSession session, InstaOrder instaOrder, Principal principal) {
		/*
		 * Optional<UserCoursout> userCoursoutOptional =
		 * this.userCoursoutRepository.findById(id); UserCoursout userCoursout =
		 * userCoursoutOptional.get();
		 */
		try {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);

		if (!user.getSignature().equals("1")) {

			session.setAttribute("message",
					new Message(
							"Before Approved Fill in the Uplode Image then after update go back into request form!!",
							"alert-danger"));
			return "redirect:/faculty/add-signature";
		} else {
			// insert date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			instaOrder.setApproveddate(dtf.format(now));
			instaOrder.setStatus("Approved");
			/* instaOrderRepository.save(instaOrder); */
			int orderid = instaOrderRepository.save(instaOrder).getId();
			
			
		 List<InstaOrderDetile> findByOrderId = this.instaOrderDeileRepository.findByOrderId(orderid);
			
			for (InstaOrderDetile instaCart1 : findByOrderId) {
				/* InstaOrderDetile instaOrderDetile1 = new InstaOrderDetile(); */
				InstaOrderDetile instaOrderDetile1 = this.instaOrderDeileRepository.findById(instaCart1.id).get();
				
				instaOrderDetile1.setEndorsedby(endorsedby);
				
				this.instaOrderDeileRepository.save(instaOrderDetile1);
			}
			
			session.setAttribute("message", new Message("Successfully Approved  !!", "alert-success"));

		}

		return "redirect:/order/show_myorder2";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// Endorsed handler
	@GetMapping("/endorsed/{id}")
	public String apprCoursout(@PathVariable("id") Integer id, Model model, HttpSession session, Principal principal) {
		try {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		Optional<InstaOrder> instaOrder1 = this.instaOrderRepository.findById(id);
		InstaOrder instaOrder2 = instaOrder1.get();

		if (!user.getSignature().equals("1")) {

			session.setAttribute("message",
					new Message(
							"Before Approved Fill in the Uplode Image then after update go back into request form!!",
							"alert-danger"));
			return "redirect:/faculty/add-signature";
		} else {
			// insert date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();

			instaOrder2.setEndorseddate(dtf.format(now));
			instaOrder2.setStatus("Endorsed");
			instaOrderRepository.save(instaOrder2);
			session.setAttribute("message", new Message("Successfully Endorsed  !!", "alert-success"));

		}

		return "redirect:/order/show_myorder3";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	/* insta feedback instaFeedbackpdf pdf */

	@RequestMapping(path = "/{cId}/instaFeedbackpdf")
	public ResponseEntity<?> getPDFf(@PathVariable("cId") Integer cId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
	            .replacePath(null)
	            .build()
	            .toUriString();
		/* Do Business Logic */
		InstaOrder instaOrders = this.instaOrderRepository.findById(cId).get();
		List<InstaOrderDetile> orderDetailes = instaOrderDeileRepository.findByOrderId(cId);
		
		User approve = this.userRepository.getUserByapproIdSingle(instaOrders.getApprovedby());	
		User endor = this.userRepository.getUserByapproIdSingle(instaOrders.getEndorsedby());
		

		/* Order order = OrderHelper.getOrder(); */
		/* Create HTML using Thymeleaf template Engine */
		WebContext context = new WebContext(request, response, servletContext);

		context.setVariable("instaOrders", instaOrders);
		context.setVariable("orderDetailes", orderDetailes);
		
		context.setVariable("approve", approve);
		context.setVariable("endor", endor);

		String orderHtml = facultyController.templateEngine.process("faculty/pdffeedbackInsta", context);
		/* Setup Source and target I/O streams */
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		/* Setup converter properties. */
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri(baseUrl +"/faculty");
		/* Call convert method */
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		String ayear = instaOrders.ayear;
		String semester = instaOrders.semester.getName();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dates = dateFormat.format(new Date());

		/* extract output as bytes */
		System.out.println("=========================================== Base Url is  " +baseUrl);
		byte[] bytes = target.toByteArray();
		/* Send the response as downloadable PDF */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=" + ayear + "_" + semester + "_" + dates + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);

	}
	
	
	/*
	 * @RequestMapping("/{cId}/checkPdfCoursdtaile") public String
	 * CheckOrderByOrderId(@PathVariable("cId") Integer cId, Model m, Principal
	 * principal, User user) { m.addAttribute("title", "C|And|F - Cart"); InstaOrder
	 * instaOrder = this.instaOrderRepository.findById(cId).get();
	 * m.addAttribute("instaOrders", instaOrder);
	 * 
	 * List<InstaOrderDetile> findByOrderId =
	 * instaOrderDeileRepository.findByOrderId(cId); m.addAttribute("orderDetailes",
	 * findByOrderId);
	 * 
	 * User approve =
	 * this.userRepository.getUserByapproIdSingle(instaOrder.getApprovedby());
	 * m.addAttribute("approve", approve);
	 * 
	 * User endor =
	 * this.userRepository.getUserByapproIdSingle(instaOrder.getEndorsedby());
	 * m.addAttribute("endor", endor);
	 * 
	 * return "faculty/pdffeedbackInsta"; }
	 */

}
