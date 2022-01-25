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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.context.WebContext;

import com.candfms.helper.Message;
import com.candfms.models.ActiLab;
import com.candfms.models.AssWeek;
import com.candfms.models.Assess;
import com.candfms.models.Chapteraf;
import com.candfms.models.Chapterbf;
import com.candfms.models.Chapterlast;
import com.candfms.models.ComLearn;
import com.candfms.models.Coursout;
import com.candfms.models.InstaOrder;
import com.candfms.models.InstaOrderDetile;
import com.candfms.models.Methodo;
import com.candfms.models.Refer;
import com.candfms.models.Role;
import com.candfms.models.Switcch;
import com.candfms.models.TabRef;
import com.candfms.models.User;
import com.candfms.models.UserCoursoutAssign;
import com.candfms.models.UserCoursoutCart;
import com.candfms.models.UserCoursoutDetile;
import com.candfms.models.Week;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.RoleRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserCoursoutAssignRepository;
import com.candfms.repositories.UserCoursoutCartRepository;
import com.candfms.repositories.UserCoursoutDetileRepository;
import com.candfms.repositories.UserRepositories;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;


@Controller
@RequestMapping("/assign")
public class AssigController {

	@Autowired
	private CoursoutRepository coursoutRepository;

	@Autowired
	private UserRepositories userRepository;

	@Autowired
	private UserCoursoutAssignRepository UserCourAssignRepo;

	@Autowired
	private UserCoursoutDetileRepository userCourDetileRepo;

	@Autowired
	private UserCoursoutCartRepository userCoursCartRepo;

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
		
		String role4 = "ADVISOR";
		Integer id4 = roleRepo.findByName(role4).getId();
		List<User> user4 = this.userRepository.findByRole(id4);	
		model.addAttribute("advisor", user4);
		
		String role5 = "APO";
		Integer id5 = roleRepo.findByName(role5).getId();
		List<User> user5 = this.userRepository.findByRole(id5);	
		model.addAttribute("apo", user5);
		
		
		List<Integer> assiandIns = new ArrayList<>();
		assiandIns.add(id0);
		assiandIns.add(id01);
		
		List<Integer> hh = new ArrayList<>();
		hh.add(user.getDepar());
		List<User> roleBothInsAndAssi = this.userRepository.findByRoleBothInsAndAssi(hh,assiandIns);
		model.addAttribute("roleBothInsAndAssi", roleBothInsAndAssi);
		
		List<User> userAll = this.userRepository.findAll();
		model.addAttribute("userAll", userAll);
	}

	@RequestMapping("/addCartToAssign")
	public String Addcours(Model model, Principal principal,HttpSession session) {
		try {
		model.addAttribute("title", "C|And|F - Add Cart");
		model.addAttribute("coursout", new Coursout());

		return "faculty/add_coursOut";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	@GetMapping("/show_Cours")
	public String showCorsout(Model m, Principal principal,HttpSession session) {
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

	// processing add CoursOutline form
	@PostMapping("/process-cours")
	public String processCours(@ModelAttribute Coursout coursout, Refer refer, Assess assess, Model model, Week week,
			Chapteraf chapteraf, Chapterbf chapterbf, Chapterlast chapterlast, ComLearn comlearn, Methodo methodo,
			ActiLab actilab, TabRef tabref, AssWeek assWeek, Principal principal, HttpSession session) {
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
		LocalDateTime now1 = LocalDateTime.now();
		/*
		 * comLearnRepo; methodoRepo; actiLabRepo; tabRefRepo; assWeekRepo;
		 * UserCourAssignRepo
		 */
		try {

			this.coursoutRepository.save(coursout);

			// message success...........
			session.setAttribute("message", new Message("Successfully Add New Cours Outline  !!", "alert-success"));

			return "faculty/add_coursOut";
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			// message error.............
			session.setAttribute("message", new Message("Somthing Went wrong !!" + e.getMessage(), "alert-danger"));

		}
 
		return "faculty/add_coursOut";
		
	}

	@GetMapping("/ShowAllCours")
	public String showCorsoutForAssign(Model m, Principal principal,HttpSession session) {
		try {
		m.addAttribute("title", "C|And|F - Show Cours");
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		List<Integer> fmieids = new ArrayList<>();
		fmieids.add(user.getDepar());
		fmieids.add(8);		
		List<Coursout> ChairAllcours = this.coursoutRepository.findCoursoutsByfmieid(fmieids);
		m.addAttribute("ChairAllcours", ChairAllcours);

		return "faculty/ChirshowCours";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	@RequestMapping("/myCart")
	public String showConsoutMyCartAssign(Model model, Principal principal, UserCoursoutDetile ucd,
			UserCoursoutCart ucc,HttpSession session) {
		try {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);

		List<UserCoursoutCart> assigner = this.userCoursCartRepo.findByAssignerId(user.getId());
		
		if(!assigner.isEmpty()) { 
			model.addAttribute("assigner", assigner);
		  } 
		
		return "faculty/assynCart";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// showing perticular contact detailes.

	@RequestMapping("/coursoutAssign/{cId}")
	public String showConsoutDetailty(@PathVariable("cId") Integer cId, Model model, Principal principal,
			UserCoursoutDetile ucd, UserCoursoutCart ucc,HttpSession session) {
		try {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);

		ucc.setCoursoutid(cId);
		ucc.setUserid(user.getId());
		this.userCoursCartRepo.save(ucc);

		/*
		 * List<UserCoursoutCart> assigner =
		 * this.userCoursCartRepo.findByAssignerId(user.getId());
		 * model.addAttribute("assigner", assigner);
		 */
		return "redirect:/assign/myCart";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}

	}

	// delete contact handler
	@GetMapping("/deleteAssignCours/{cid}")
	public String deleteCoursout(@PathVariable("cid") Integer cId, Model model, HttpSession session,
			UserCoursoutDetile ucd, UserCoursoutCart ucc, Principal principal, Refer refer) {
		try {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		Optional<UserCoursoutCart> findById = this.userCoursCartRepo.findById(cId);
		UserCoursoutCart userCoursoutCart = findById.get();

		this.userCoursCartRepo.delete(userCoursoutCart);

		/// message....
		session.setAttribute("message", new Message("Successfully Deleted  !!", "alert-success"));
		return "redirect:/assign/myCart";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// delete Multiple course handler
	@PostMapping("/deleteMultipleAssignCours")
	public String deleteMultipleCoursout(@RequestParam("cidd") Integer[] cidds, Model model, HttpSession session,
			UserCoursoutDetile ucd, UserCoursoutCart ucc, Principal principal, Refer refer) {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		try {
			List<UserCoursoutCart> findByIdIn = this.userCoursCartRepo.findByIdIn(cidds);

			if (cidds.length == 0) {
				session.setAttribute("message", new Message("Not Checked Checkbox !!", "alert-danger"));
			}

			this.userCoursCartRepo.deleteAll(findByIdIn);
			// System.out.println("naf=========================== " + findByIdIn);
			// System.out.println("naf=========================== " + cidds);
			/// message....
			session.setAttribute("message", new Message("Successfully Deleted  !!", "alert-success"));

		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			// message error.............
			session.setAttribute("message", new Message("Somthing Went wrong !!", "alert-danger"));
		}
		return "redirect:/assign/myCart";
		
	}

	// cart Multiple course handler
	@PostMapping("/AssignMultipleAssignCours")
	public String AssignMultipleCoursout(@RequestParam("cId") Integer[] cIds, Model model, HttpSession session,
			UserCoursoutDetile ucd, UserCoursoutCart ucc, Coursout coursout, Principal principal, Refer refer) {
		try {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		List<Coursout> findByCIdIn = this.coursoutRepository.findBycIdIn(cIds);
		// insert
		for (Coursout ucCart : findByCIdIn) {
			UserCoursoutCart userCoursoutCart2 = new UserCoursoutCart();
			// userCoursoutCart2.setId(ucCart.getcId());
			userCoursoutCart2.setUserid(user.getId());
			userCoursoutCart2.setCoursoutid(ucCart.getcId());
			this.userCoursCartRepo.save(userCoursoutCart2);
		}

		session.setAttribute("message", new Message("Successfully Add  !!", "alert-success"));
		return "redirect:/assign/myCart";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// Assign Process
	@RequestMapping(value = "/process-assign", method = RequestMethod.POST)
	public String orderCartProcessHandler(@RequestParam("instaId") Integer instaId,
			@ModelAttribute UserCoursoutDetile ucd, UserCoursoutCart ucc, UserCoursoutAssign uca, Coursout coursout,
			Model m, HttpSession session, Principal principal) {
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		// check if signature fill/* UserCourRepo; userCourDetileRepo;
		// userCoursCartRepo; UserCourAssignRepo;UserCourAssignRepo*/
		if (user.getSignature().equals("1")) {
			try {

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				uca.setUserid(user.getId());
				uca.setAssigndate(dtf.format(now));
				uca.setAssignstatust("1"); // Assigned
				int userCoursoutAssignid = UserCourAssignRepo.save(uca).getId();

				List<UserCoursoutCart> assigner = this.userCoursCartRepo.findByAssignerId(user.getId());
				/* m.addAttribute("instaCart",instaCartOptional); */
				for (UserCoursoutCart ucc1 : assigner) {
					UserCoursoutDetile userCoursoutDetile1 = new UserCoursoutDetile();

					userCoursoutDetile1.setUserCoursoutAssignid(userCoursoutAssignid);
					userCoursoutDetile1.setCoursoutid(ucc1.getCoursoutid());
					userCoursoutDetile1.setAssignstatust("1");
					userCoursoutDetile1.setStatust("0");
					userCoursoutDetile1.setUserid(user.getId());
					userCoursoutDetile1.setAssigndate(dtf.format(now));
					userCoursoutDetile1.setInstaId(instaId);

					this.userCourDetileRepo.save(userCoursoutDetile1);
				}

				this.userCoursCartRepo.deleteAll(assigner);
				session.setAttribute("message", new Message("Your Data is Filled Success...", "alert-success"));

			} catch (Exception e) {
				e.printStackTrace();
			}
		        return "redirect:/assign/" + instaId + "/assignInstadetail";
			
		} else {

			session.setAttribute("message",
					new Message("Before Request Fill signature Image then after update go back into request form!!",
							"alert-danger"));
			return "redirect:/faculty/add-signature";
		}
		
	}

	@RequestMapping("/assignShow")
	public String showConsoutAssignShow(Model model, Principal principal, HttpSession session, UserCoursoutDetile ucd,
			UserCoursoutCart ucc) {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		try {
			List<UserCoursoutAssign> findReqByAssignerUserId = this.UserCourAssignRepo
					.findReqByAssignerUserId(user.getId());
			model.addAttribute("assignerUser", findReqByAssignerUserId);

		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			// message error.............
			session.setAttribute("message", new Message("Somthing Went wrong !!", "alert-danger"));
		}
		return "faculty/assynShow";
	}

	@RequestMapping("/{instaid}/assignInstadetail")
	public String showConsoutDetileAssign(@PathVariable("instaid") Integer instaid, Model model, Principal principal,
			HttpSession session, UserCoursoutDetile ucd, UserCoursoutCart ucc) {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		try {
			List<UserCoursoutDetile> assigninstaDetil = this.userCourDetileRepo.findByInstaUserId(instaid);
			model.addAttribute("assigninstaDetil", assigninstaDetil);

		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			// message error.............
			session.setAttribute("message", new Message("Somthing Went wrong !!", "alert-danger"));
		}
		return "faculty/assynDetai";
	}

	/* for instrac */
	@RequestMapping("/instaCoursdetailAssigned")
	public String showConsoutDetileAssignedForme(Model model, Principal principal, HttpSession session,
			UserCoursoutDetile ucd, UserCoursoutCart ucc) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		try {
			List<UserCoursoutDetile> assigninstaDetil = this.userCourDetileRepo.findByInstaUserId(user.getId());
			model.addAttribute("assigninstaDetil", assigninstaDetil);
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			// message error.............
			session.setAttribute("message", new Message("Somthing Went wrong !!", "alert-danger"));
		}
		return "faculty/assynDetaiOnInsta";
		
	}

	/* request */
	@GetMapping("/assignRequesting/{id}")
	public String requestCoursout(@PathVariable("id") Integer id, Model model, HttpSession session,
			Principal principal) {
		try {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		Optional<UserCoursoutDetile> findById = this.userCourDetileRepo.findById(id);
		UserCoursoutDetile userCoursoutDetile = findById.get();
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
			userCoursoutDetile.setReqdate(dtf.format(now));
			userCoursoutDetile.setStatust("1");
			userCourDetileRepo.save(userCoursoutDetile);
			session.setAttribute("message", new Message("Successfully Requesting  !!", "alert-success"));
		}

		return "redirect:/assign/instaCoursdetailAssigned";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	/* denied */
	/*
	 * @GetMapping("/denied/{id}") public String deniedCoursout(@PathVariable("id")
	 * Integer id, Model model, HttpSession session, Principal principal) {
	 * UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo
	 * String userName = principal.getName(); User user =
	 * userRepository.getUserByUserName(userName); Optional<UserCoursoutDetile>
	 * findById = this.userCourDetileRepo.findById(id); UserCoursoutDetile
	 * userCoursoutDetile = findById.get();
	 * 
	 * 
	 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 * LocalDateTime now = LocalDateTime.now();
	 * userCoursoutDetile.setReqdate(dtf.format(now));
	 * userCoursoutDetile.setStatust("3");
	 * userCourDetileRepo.save(userCoursoutDetile); session.setAttribute("message",
	 * new Message("Successfully Requesting  !!", "alert-success"));
	 * 
	 * 
	 * return "redirect:/assign/instaCoursdetailAssigned"; }
	 */
	/* approved */
	@GetMapping("/assignapproved/{id}")
	public String apprCoursout(@PathVariable("id") Integer id, Model model, HttpSession session, Principal principal) {
		try {
		/* UserCourRepo; userCourDetileRepo; userCoursCartRepo; UserCourAssignRepo */
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		Optional<UserCoursoutDetile> findById = this.userCourDetileRepo.findById(id);
		UserCoursoutDetile userCoursoutDetile = findById.get();
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
			userCoursoutDetile.setApprdate(dtf.format(now));
			userCoursoutDetile.setStatust("2");
			userCourDetileRepo.save(userCoursoutDetile);
			session.setAttribute("message", new Message("Successfully Approved  !!", "alert-success"));
		}

		return "redirect:/assign/" + userCoursoutDetile.instaId + "/assignInstadetail";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	
	
	  @RequestMapping("/{cId}/courspdf")
	  public String  CheckOrderByOrderIpppkd(@PathVariable("cId") Integer cId, Model m, Principal
	  principal,HttpSession session) { 
		  try {
		  m.addAttribute("title", "C|And|F - Pdf");  
		  String name = principal.getName();
			User user = this.userRepository.getUserByUserName(name);		
			if (!user.getSignature().equals("1") )  {
				session.setAttribute("message",
						new Message("Before Request Fill signature Image then after update go back into request form!!",
								"alert-danger"));
				return "redirect:/faculty/add-signature";		
			} else if(user.getAddress().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty()) {				
				try {
					
					session.setAttribute("message",
							new Message("Before Request Fill below inputs address,email and phone number then after update go back into request form!!",
									"alert-danger"));
					return "redirect:/div/profile";
				} catch (Exception e) {
					e.printStackTrace();
				}	  	
				 
			}else {		
				 	
				return "redirect:/assign/" + cId + "/courspdf2"; 		  
			}
			return "redirect:/assign/" + cId + "/courspdf2";
			
		  } catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
	  }
	 

	@RequestMapping(path = "/{cId}/courspdf2")
	public ResponseEntity<?> getPDFf(@PathVariable("cId") Integer cId, HttpServletRequest request, Principal principal,
			HttpServletResponse response) throws IOException {
		String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
	            .replacePath(null)
	            .build()
	            .toUriString();
		UserCoursoutDetile userCoursout = this.userCourDetileRepo.findById(cId).get();
		User insta = this.userRepository.findById(userCoursout.instaId).get();

		/* Order order = OrderHelper.getOrder(); */
		/* Create HTML using Thymeleaf template Engine */
		WebContext context = new WebContext(request, response, servletContext);

		context.setVariable("userCoursout", userCoursout);
		context.setVariable("insta", insta);
		String orderHtml = facultyController.templateEngine.process("faculty/pdfcoursOut", context);
		/* Setup Source and target I/O streams */
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		/* Setup converter properties. */
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri(baseUrl +"/faculty");
		/* Call convert method */
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		String ccode = userCoursout.coursout.ccode;

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dates = dateFormat.format(new Date());

		/* extract output as bytes */

		byte[] bytes = target.toByteArray();
		/* Send the response as downloadable PDF */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ccode + "_" + dates + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
		
		
		

	}

	@RequestMapping("/{cId}/checkcourspdf")
	public String CheckOrderByOrderId(@PathVariable("cId") Integer cId, Model m, 
			Principal principal,HttpSession session, User user) {
		try {
		m.addAttribute("title", "C|And|F - Cart");

		UserCoursoutDetile userCoursout = this.userCourDetileRepo.findById(cId).get();

		User insta = this.userRepository.findById(userCoursout.instaId).get();

		m.addAttribute("userCoursout", userCoursout);

		m.addAttribute("insta", insta);
		return "faculty/pdfcoursOut";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

}
