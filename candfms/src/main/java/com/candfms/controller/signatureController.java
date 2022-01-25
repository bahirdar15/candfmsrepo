package com.candfms.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.ServletContextAware;

import com.candfms.helper.Message;
import com.candfms.models.Coursout;
import com.candfms.models.Fmie;
import com.candfms.models.LabOrder;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.models.Year;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.FmieRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.repositories.YearRepository;
import com.candfms.service.FmieService;

@Controller
@RequestMapping("/faculty")
public class signatureController {

	@Autowired
	private FmieService fmieService;

	@Autowired
	private CoursoutRepository coursoutRepository;
	@Autowired
	private UserRepositories userRepository;

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
			
		// get the user using username(username)
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		System.out.println("USER " + user);// on consol display all user detaile
		model.addAttribute("user", user);
	}

	// open signatures form handler
	@GetMapping("/add-signature")
	public String openAddContactForm(Model model, HttpSession session, Principal principal) throws IOException {
		try {
		model.addAttribute("title", "C|And|F - Add Signature");
		model.addAttribute("user", new User());
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
	//	if (user.getImageUrl().length() != 0 || !user.getImageUrl().isEmpty() || user.getImageUrl().equals("") || !user.getImageUrl().equals(null) || !user.getImageUrl().equals(" ")) {
		if (user.getSignature().equals("0") || user.getSignature().equals("1") || user.getSignature().equals("2") ) {
			File file = new File("signatu/" + user.getImageUrl());

			ImageInputStream iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			if (readers.hasNext()) {
				// Get the first available ImageReader
				ImageReader reader = readers.next();
				reader.setInput(iis, true);

				String exten = reader.getFormatName();
				int wid = reader.getWidth(0);
				int hei = reader.getHeight(0);

				String diame = wid + "x" + hei + " pixels";
				model.addAttribute("diame", diame);
				model.addAttribute("exten", exten);
			}
			DecimalFormat df = new DecimalFormat("0.00");
			float fileSizeInBytes = file.length();
			// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
			float fileSizeInKB = fileSizeInBytes / 1024;
			// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
			float fileSizeInMB = fileSizeInKB / 1024;
			String siz = df.format(fileSizeInKB) + " Kb";
			model.addAttribute("siz", siz);
			
		}else {
			return "faculty/signature";
		}

		return "faculty/signature";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	@Autowired
	private YearRepository yearRepository;

	@RequestMapping("/findByIdd")
	@ResponseBody
	public Optional<User> findByIdd(int id) {
		return userRepository.findById(id);
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Optional<Year> findById(int id) {
		return yearRepository.findById(id);
	}

	// processing add contact form
	@PostMapping("/process-user")
	public String processContact(@RequestParam("profileImage") MultipartFile file, Principal principal,
			HttpSession session) {
		try {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String name = principal.getName();
		User user = this.userRepository.getUserByUserName(name);
		String naf = user.getId() + file.getOriginalFilename();
		System.out.println("naf=========================== " + naf);
		// processing and uploading file user.getImageUrl() ==
		// (user.getId()+file.getOriginalFilename().endsWith("xlsx")))
		if (user.getSignature().isEmpty()) {
			try {
				String uploadDir = "signatu/";
				Path uploadPath = Paths.get(uploadDir);
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}
				InputStream inputStream = file.getInputStream();
				Path filePath = uploadPath.resolve(user.getId() + fileName);

				// File saveFile = new ClassPathResource("static/img").getFile();
				// Path path = Paths.get(uploadPath + File.separator + user.getId() +
				// file.getOriginalFilename());
				if (Files.exists(filePath)) {
					session.setAttribute("message", new Message(
							"file name already exists please change name " + file.getOriginalFilename() + "  !!",
							"alert-danger"));
				} else {
					if (file.isEmpty()) {
						session.setAttribute("message", new Message("Not file selected !!", "alert-danger"));
					} else {

						user.setImageUrl(user.getId() + file.getOriginalFilename());
						user.setSignature("0");
						// Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
						Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						this.userRepository.save(user);
						// message success...........
						session.setAttribute("message", new Message("You successfully uploaded", "alert-success"));
					}
				}

			} catch (Exception e) {
				System.out.println("ERROR" + e.getMessage());
				e.printStackTrace();
				// message error.............
				session.setAttribute("message", new Message("Somthing Went wrong !!", "alert-danger"));
			}
		} else {

			session.setAttribute("message",
					new Message("before new signature upload delete old signature !!", "alert-danger"));
		}

		return "redirect:/faculty/add-signature";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}

	}

	// Signature delete handler
	@GetMapping("/deletesig/{id}")
	public String apprCoursoutsuStu(@PathVariable("id") Integer id, Model model, HttpSession session,
			Principal principal) {

		String userName = principal.getName();
		Optional<User> findById = this.userRepository.findById(id);
		User user = findById.get();

		try {
			String uploadDir = "signatu/";
			Path uploadPath = Paths.get(uploadDir + user.getImageUrl());
			// File saveFile = new ClassPathResource("/signatu/").getFile();
			// Path path = Paths.get(saveFile + user.getImageUrl());
			if (Files.exists(uploadPath)) {
				Files.delete(uploadPath);
			}

			user.setImageUrl("");
			user.setSignature("");
			userRepository.save(user);
			session.setAttribute("message", new Message("Successfully Deleted !!", "alert-success"));
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			e.printStackTrace();
			// message error.............
			session.setAttribute("message", new Message("Somthing Went wrong !!", "alert-danger"));
		}

		return "redirect:/faculty/add-signature";
	}

	// Signature applicable handler
	@GetMapping("/applicablSign/{id}")
	public String applicable(@PathVariable("id") Integer id, Model model, HttpSession session, Principal principal) {
		try {
		String userName = principal.getName();
		Optional<User> findById = this.userRepository.findById(id);
		User user = findById.get();
		user.setSignature("1");
		userRepository.save(user);
		session.setAttribute("message", new Message("Successfully Applicabled !!", "alert-success"));
		return "redirect:/div/showAdmin";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// Signature invalidSig handler
	@GetMapping("/invalidSig/{id}")
	public String invalidSig(@PathVariable("id") Integer id, Model model, HttpSession session, Principal principal) {
		try {
		String userName = principal.getName();
		Optional<User> findById = this.userRepository.findById(id);
		User user = findById.get();
		user.setSignature("2");
		userRepository.save(user);
		session.setAttribute("message", new Message("Successfully Invalided !!", "alert-success"));
		return "redirect:/div/showAdmin";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}

	// Download Signature handler
	@GetMapping("/download")
	public void downlod(HttpServletResponse response) throws IOException {
		/* File file = new File("signatu\\10signature2.png"); */

		/* File file = new File("src/main/resources/static/img/signature2.png"); */
		File file = new ClassPathResource("static/img/signature2.png").getFile();
		response.setContentType("application/octet-stream");
		String headerkey = "Content-Disposition";
		String headerValue = "attachement; filename=" + file.getName();

		response.setHeader(headerkey, headerValue);
		ServletOutputStream outputStream = response.getOutputStream();
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[8192];// 8kb buffer
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
	}

}
