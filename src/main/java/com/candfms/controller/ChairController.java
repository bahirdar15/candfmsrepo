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
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.context.WebContext;

import com.candfms.helper.Message;
import com.candfms.models.Evaluationstudent;
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
import com.candfms.repositories.EvaluationStudentRequRepository;
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
@RequestMapping("/qualiity")
public class ChairController {


	@Autowired
	private EvaluationStudentRequRepository evaStumRepo;

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
	RoleRepository roleRepo;

	@Autowired
	private SwitcchRepository swichRepo;

	@ModelAttribute
	public void addCommonData(Model model, Principal principal,HttpSession session) {
		 
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
		
		
		String role6 = "DEAN";
		Integer id6 = roleRepo.findByName(role6).getId();
		List<User> user6 = this.userRepository.findByRole(id6);
		model.addAttribute("dean", user6);

		String role7 = "QUALITY";
		Integer id7 = roleRepo.findByName(role7).getId();
		List<User> user7 = this.userRepository.findByRole(id7);
		model.addAttribute("quality", user7);
		
		

		List<Fmie> fmieList = this.fmieRepository.findAll();
		model.addAttribute("fmies", fmieList);

		List<Year> yearList = this.yearRepository.findAll();
		model.addAttribute("years", yearList);

		List<Semester> semesterList = this.semesterRepository.findAll();
		model.addAttribute("semesters", semesterList);

		List<Groupt> grouptList = this.grouptRepository.findAll();
		model.addAttribute("groupts", grouptList);

		List<Integer> allAyear = this.instaOrderRepository.allAyear();
		model.addAttribute("allAyear", allAyear);
		
		List<Integer> allFmieId = this.instaOrderDeileRepository.allFmieId();
		model.addAttribute("allFmieId", allFmieId);
		List<Integer> allFmieId2 = this.instaOrderDeileRepository.allFmieId2();
		model.addAttribute("allFmieId2", allFmieId2);
		
		List<User> findByRole = this.userRepository.findByRole(id3);
		model.addAttribute("findByRole",findByRole);
		
		List<User> userAll = this.userRepository.findAll();
		model.addAttribute("userAll", userAll);
		
		
	}

	@PostMapping("/qu")
	public String changePassword(Principal principal, HttpSession session, Model m,
			@RequestParam("ayear1") String ayear, @RequestParam("semesterid1") Integer semesterid,
			@RequestParam("prog1") String prog, @RequestParam("bam1") String bam,@RequestParam("year1") Integer yea) {
		m.addAttribute("title", "C|And|F - Qualiity Show all");	
		try {
			
			m.addAttribute("ayea", ayear);
			m.addAttribute("semes", semesterid);		
			m.addAttribute("yea", yea);
			m.addAttribute("bm", bam);
			m.addAttribute("pro", prog);
			for (int i = 1; i < 8; i++) {			  			 
			if(yea==0) {
				Integer ncp = instaOrderDeileRepository.findncpBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("ncp"+i, ncp);
				Integer ncco = instaOrderDeileRepository.findnccoBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("ncco"+i, ncco);
				Integer nap = instaOrderDeileRepository.findnapBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("nap"+i, nap);
				Integer nad = instaOrderDeileRepository.findnadBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("nad"+i, nad);
				Integer naf = instaOrderDeileRepository.findnafBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("naf"+i, naf);	
			}else {
				Integer ncp = instaOrderDeileRepository.findncpBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("ncp"+i, ncp);
				Integer ncco = instaOrderDeileRepository.findnccoBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("ncco"+i,ncco);
				Integer nap = instaOrderDeileRepository.findnapBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("nap"+i, nap);
				Integer nad = instaOrderDeileRepository.findnadBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("nad"+i, nad);
				Integer naf = instaOrderDeileRepository.findnafBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("naf"+i, naf);
			}
		  }
			Integer findnafBy4allYearFmieDistinctcompaid = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctcompaid(ayear,semesterid,bam,prog);
			m.addAttribute("distnicQultycompaid", findnafBy4allYearFmieDistinctcompaid);
			
			Integer findnafBy4allYearFmieDistinctendorsdeanid = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctendorsdeanid(ayear,semesterid,bam,prog);
			m.addAttribute("distnicQultyendorsdeanid", findnafBy4allYearFmieDistinctendorsdeanid);
			
			String findnafBy4allYearFmieDistinctcopadate = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctcopadate(ayear,semesterid,bam,prog);
			m.addAttribute("distnicQultycopadate", findnafBy4allYearFmieDistinctcopadate);
			
			String findnafBy4allYearFmieDistinctendorsedeandate = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctendorsedeandate(ayear,semesterid,bam,prog);
			m.addAttribute("distnicQultyendorsedeandate", findnafBy4allYearFmieDistinctendorsedeandate);
			

			return "faculty/ChairTotal3";
			
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
		
		
	}

	
	@RequestMapping("/qualiity")
	public String showqualiityall(Model m, Principal principal, InstaCart instaCart,HttpSession session) {
		/* model.addAttribute("userCoursout",new UserCoursout()); */
		try {
		m.addAttribute("title", "C|And|F - Qualiity Show all");
		String role6 = "DEAN";
		Integer id6 = roleRepo.findByName(role6).getId();
		 List<User> dean = this.userRepository.findByRole(id6);
		m.addAttribute("dean", dean);
		
		
		return "faculty/ChairTotal2";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	
	@RequestMapping("/{cId1}/{cId2}/{cId3}/{cId4}/{cId5}/PdfAllFeedback")
	  public String  CheckOrderByOrderIpggppkd(Model m, Principal principal,HttpSession session,
			  @PathVariable("cId1") String ayear, 
			  @PathVariable("cId2") Integer semesterid, 
			  @PathVariable("cId3") Integer yea, 
			  @PathVariable("cId4") String bam, 
			  @PathVariable("cId5") String prog) { 
		try { 
		m.addAttribute("title", "C|And|F - Pdf");  
		  String name = principal.getName();
			User user = this.userRepository.getUserByUserName(name);		
			if (!user.getSignature().equals("1") )  {
				session.setAttribute("message",
						new Message("Before Request Fill signature Image then after update go back into request form!!",
								"alert-danger"));
				return "redirect:/faculty/add-signature";		
			} else {					 	
				return "redirect:/qualiity/" +ayear+ "/" +semesterid+"/" +yea+"/" +bam+"/" + prog+"/PdfAllFeedback1"; 		  
			}	
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	  }
	 

	@RequestMapping(path = "/{cId1}/{cId2}/{cId3}/{cId4}/{cId5}/PdfAllFeedback1")
	public ResponseEntity<?> getPDFfg(HttpServletRequest request, Principal principal, HttpServletResponse response,Model m,
			  @PathVariable("cId1") String ayear, 
			  @PathVariable("cId2") Integer semesterid, 
			  @PathVariable("cId3") Integer yea, 
			  @PathVariable("cId4") String bam, 
			  @PathVariable("cId5") String prog) throws IOException {
		String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
	            .replacePath(null)
	            .build()
	            .toUriString();
		List<Year> yearList = this.yearRepository.findAll(); 
		List<Semester> semesterList = this.semesterRepository.findAll();
		List<Integer> allFmieId2 = this.instaOrderDeileRepository.allFmieId2();
		         String role3 = "CHAIR_HOLDER"; Integer id3 = roleRepo.findByName(role3).getId();
		List<User> findByRole = this.userRepository.findByRole(id3);
		
		
		List<User> userAll = this.userRepository.findAll();
		m.addAttribute("userAll", userAll);
		Integer findnafBy4allYearFmieDistinctcompaid = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctcompaid(ayear,semesterid,bam,prog);
		m.addAttribute("distnicQultycompaid", findnafBy4allYearFmieDistinctcompaid);
		
		Integer findnafBy4allYearFmieDistinctendorsdeanid = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctendorsdeanid(ayear,semesterid,bam,prog);
		m.addAttribute("distnicQultyendorsdeanid", findnafBy4allYearFmieDistinctendorsdeanid);
		
		String findnafBy4allYearFmieDistinctcopadate = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctcopadate(ayear,semesterid,bam,prog);
		m.addAttribute("distnicQultycopadate", findnafBy4allYearFmieDistinctcopadate);
		
		String findnafBy4allYearFmieDistinctendorsedeandate = this.instaOrderDeileRepository.findnafBy4allYearFmieDistinctendorsedeandate(ayear,semesterid,bam,prog);
		m.addAttribute("distnicQultyendorsedeandate", findnafBy4allYearFmieDistinctendorsedeandate);
		
		
		/* ================================== */
		for (int i = 1; i < 8; i++) {			  			 
			if(yea==0) {
				Integer ncp = instaOrderDeileRepository.findncpBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("ncp"+i, ncp);
				Integer ncco = instaOrderDeileRepository.findnccoBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("ncco"+i, ncco);
				Integer nap = instaOrderDeileRepository.findnapBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("nap"+i, nap);
				Integer nad = instaOrderDeileRepository.findnadBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("nad"+i, nad);
				Integer naf = instaOrderDeileRepository.findnafBy5allYear(ayear, semesterid,bam, prog, i);
				m.addAttribute("naf"+i, naf);	
			}else {
				Integer ncp = instaOrderDeileRepository.findncpBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("ncp"+i, ncp);
				Integer ncco = instaOrderDeileRepository.findnccoBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("ncco"+i,ncco);
				Integer nap = instaOrderDeileRepository.findnapBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("nap"+i, nap);
				Integer nad = instaOrderDeileRepository.findnadBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("nad"+i, nad);
				Integer naf = instaOrderDeileRepository.findnafBy6(ayear, semesterid, yea, bam, prog, i);
				m.addAttribute("naf"+i, naf);
			}
		  }
		/* ===================== ==================================================*/
		

		WebContext context = new WebContext(request, response, request.getServletContext(), request.getLocale(), m.asMap());
		/* WebContext context = new WebContext(request, response, servletContext); */
		
		context.setVariable("findByRole",findByRole);
		context.setVariable("allFmieId2", allFmieId2);
		context.setVariable("years", yearList);
		context.setVariable("semesters", semesterList);
		
		context.setVariable("ayea", ayear);
		context.setVariable("semes", semesterid);
		context.setVariable("yea", yea);
		context.setVariable("bm", bam);
		context.setVariable("pro", prog);
		String orderHtml = facultyController.templateEngine.process("faculty/pdffeedbackAll", context);
		/* Setup Source and target I/O streams */
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		/* Setup converter properties. */
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri(baseUrl +"/faculty");
		/* Call convert method */
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		String ccode = ayear;

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dates = dateFormat.format(new Date());

		/* extract output as bytes */

		byte[] bytes = target.toByteArray();
		/* Send the response as downloadable PDF */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ccode + "_" + dates + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	
	}
	
	
	  @RequestMapping("/{cId1}/{cId2}/{cId3}/{cId4}/{cId5}/checkPdfCoursdtaile") public String
	  CheckOrderByOrderId(Model m, Principal principal, User user,HttpSession session,
			  @PathVariable("cId1") String ayear, 
			  @PathVariable("cId2") Integer semesterid, 
			  @PathVariable("cId3") Integer yea, 
			  @PathVariable("cId4") String bam, 
			  @PathVariable("cId5") String prog) {
			try {  
		  m.addAttribute("title", "C|And|F - Qualiity Show all");	
			m.addAttribute("ayea", ayear);
			m.addAttribute("semes", semesterid);		
			m.addAttribute("yea", yea);
			m.addAttribute("bm", bam);
			m.addAttribute("pro", prog);

	  return "faculty/pdffeedbackAll"; 
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
	  }
	 

	// Compiled handler
		@RequestMapping(value = "/process-compaPut", method = RequestMethod.GET)
		public String compaPut(Model model, HttpSession session, InstaOrder instaOrder, Principal principal, 
				@RequestParam("ayear1") String ayear, @RequestParam("semesterid1") Integer semesterid,
				@RequestParam("bam1") String bam,@RequestParam("prog1") String prog,@RequestParam("endo") Integer endo) {
			try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			
			String userName = principal.getName();
			User user = userRepository.getUserByUserName(userName);

			if (!user.getSignature().equals("1")) {

				session.setAttribute("message",
						new Message(
								"Before Approved Fill in the Uplode Image then after update go back into request form!!",
								"alert-danger"));
				return "redirect:/faculty/add-signature";
			} else {
				
			 List<InstaOrderDetile> findByOrderId = this.instaOrderDeileRepository.findnafBy4allYearFmie(ayear,semesterid,bam,prog);
				
				for (InstaOrderDetile instaCart1 : findByOrderId) {
					/* InstaOrderDetile instaOrderDetile1 = new InstaOrderDetile(); */
					InstaOrderDetile instaOrderDetile1 = this.instaOrderDeileRepository.findById(instaCart1.id).get();
					instaOrderDetile1.setCompaid(user.getId());
					instaOrderDetile1.setEndorsdeanid(endo);
					instaOrderDetile1.setCopadate(dtf.format(now));
					this.instaOrderDeileRepository.save(instaOrderDetile1);
				}
				
				session.setAttribute("message", new Message("Successfully Compiled  !!", "alert-success"));

			}

			return "redirect:/qualiity/qualiity";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
	  
		// EndorsedGet handler
				@RequestMapping(value = "/process-EndorsedGet", method = RequestMethod.GET)
				public String EndorsedGet(Model model, HttpSession session, InstaOrder instaOrder, Principal principal, 
						@RequestParam("ayear1") String ayear, @RequestParam("semesterid1") Integer semesterid,
						@RequestParam("bam1") String bam,@RequestParam("prog1") String prog) {
					try {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now = LocalDateTime.now();
					
					String userName = principal.getName();
					User user = userRepository.getUserByUserName(userName);

					if (!user.getSignature().equals("1")) {

						session.setAttribute("message",
								new Message(
										"Before Approved Fill in the Uplode Image then after update go back into request form!!",
										"alert-danger"));
						return "redirect:/faculty/add-signature";
					} else {
						
					 List<InstaOrderDetile> findByOrderId = this.instaOrderDeileRepository.findnafBy4allYearFmie(ayear,semesterid,bam,prog);
						
						for (InstaOrderDetile instaCart1 : findByOrderId) {
							/* InstaOrderDetile instaOrderDetile1 = new InstaOrderDetile(); */
							InstaOrderDetile instaOrderDetile1 = this.instaOrderDeileRepository.findById(instaCart1.id).get();
							
							instaOrderDetile1.setEndorsedeandate(dtf.format(now));
							this.instaOrderDeileRepository.save(instaOrderDetile1);
						}
						
						session.setAttribute("message", new Message("Successfully Endorsed  !!", "alert-success"));

					}

					return "redirect:/qualiity/qualiity";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//////////////////////chart
				
				/*
				 * @GetMapping("/barChart2") public String barChart2(Model model,HttpSession
				 * session) { Map<String, try { Integer> data = new LinkedHashMap<String,
				 * Integer>(); data.put("Ashish", 30); data.put("Ankit", 50);
				 * data.put("Gurpreet", 70); data.put("Mohit", 90); data.put("Manish", 25);
				 * model.addAttribute("keySet", data.keySet()); model.addAttribute("values",
				 * data.values()); return "faculty/barChart"; } catch(Exception e) {
				 * e.printStackTrace(); session.setAttribute("message", new
				 * Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger")); return
				 * "faculty/index"; } }
				 */
				
				
				
				@PostMapping("/barChart")
				public String barChart(Principal principal, HttpSession session, Model m,
						@RequestParam("ayear1") String ayear, @RequestParam("semesterid1") Integer semesterid,
						@RequestParam("prog1") String prog, @RequestParam("bam1") String bam,@RequestParam("year1") Integer yea) {
					try {
					m.addAttribute("title", "C|And|F - Qualiity Show all");	
					m.addAttribute("ayea", ayear);
					m.addAttribute("semes", semesterid);		
					m.addAttribute("yea", yea);
					m.addAttribute("bm", bam);
					m.addAttribute("pro", prog);
					DecimalFormat df = new DecimalFormat("0.0");
					for (int i = 1; i < 8; i++) {			  			 
					if(yea==0) {
						Integer ncp = instaOrderDeileRepository.findncpBy5allYear(ayear, semesterid,bam, prog, i);
						m.addAttribute("ncp"+i, ncp);
						Integer ncco = instaOrderDeileRepository.findnccoBy5allYear(ayear, semesterid,bam, prog, i);
						m.addAttribute("ncco"+i, ncco);
						Integer nap = instaOrderDeileRepository.findnapBy5allYear(ayear, semesterid,bam, prog, i);
						m.addAttribute("nap"+i, nap);
						Integer nad = instaOrderDeileRepository.findnadBy5allYear(ayear, semesterid,bam, prog, i);
						m.addAttribute("nad"+i, nad);
						Integer naf = instaOrderDeileRepository.findnafBy5allYear(ayear, semesterid,bam, prog, i);
						m.addAttribute("naf"+i, naf);	
						
						
						
						 
						  if (ncp == 0) { 
							  float f = 0; 
							  m.addAttribute("chap"+i, f);
						  }else { 
						  double chap=(ncco*100)/ncp;
						  float e =Float.parseFloat(df.format(chap)); 
						  m.addAttribute("chap"+i, e);
						  }
						  
							
							  if(nap==0) { 
								  float a = 0; 
								  m.addAttribute("asses"+i, a);
							  m.addAttribute("feed"+i, a); 
							  }else { 
								  double ass=(nad*100)/(nap); 
								  float p =Float.parseFloat(df.format(ass)); 
								  m.addAttribute("asses"+i, p);
							  
							  double fee=(naf*100)/(nap); 
							  float g =Float.parseFloat(df.format(fee));
							  m.addAttribute("feed"+i, g); }
							 
						 
						 
					}else {
						Integer ncp = instaOrderDeileRepository.findncpBy6(ayear, semesterid, yea, bam, prog, i);
						m.addAttribute("ncp"+i, ncp);
						Integer ncco = instaOrderDeileRepository.findnccoBy6(ayear, semesterid, yea, bam, prog, i);
						m.addAttribute("ncco"+i,ncco);
						Integer nap = instaOrderDeileRepository.findnapBy6(ayear, semesterid, yea, bam, prog, i);
						m.addAttribute("nap"+i, nap);
						Integer nad = instaOrderDeileRepository.findnadBy6(ayear, semesterid, yea, bam, prog, i);
						m.addAttribute("nad"+i, nad);
						Integer naf = instaOrderDeileRepository.findnafBy6(ayear, semesterid, yea, bam, prog, i);
						m.addAttribute("naf"+i, naf);
						
						 
						if (ncp == 0) { 
							  float f = 0; 
							  m.addAttribute("chap"+i, f);
						  }else { 
						  double chap=(ncco*100)/ncp;
						  float e =Float.parseFloat(df.format(chap)); 
						  m.addAttribute("chap"+i, e);
						  }
						  
							
							  if(nap==0) { 
								  float a = 0; 
								  m.addAttribute("asses"+i, a);
							  m.addAttribute("feed"+i, a); 
							  }else { 
								  double ass=(nad*100)/(nap); 
								  float p =Float.parseFloat(df.format(ass)); 
								  m.addAttribute("asses"+i, p);
							  
							  double fee=(naf*100)/(nap); 
							  float g =Float.parseFloat(df.format(fee));
							  m.addAttribute("feed"+i, g); }
						 
					       
					       
					       
					}
				  }
					

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now = LocalDateTime.now();
					
					m.addAttribute("datee", dtf.format(now));
							
					
					return "faculty/barChart";
					
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
}
