package com.sts.contact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sts.contact.Dao.UserDAO;
import com.sts.contact.model.Contact;
import com.sts.contact.model.User;

@Controller
public class SamrtController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/")
	public String getHome(Model model) {

		model.addAttribute("Title", "Home - Smart Contact Manager");
		return "home";
	}

	@RequestMapping("/about")
	public String getAbout(Model model) {

		model.addAttribute("Title", "About - Smart Contact Manager");
		return "about";
	}

	@GetMapping("/signup")
	public String getSignup(Model model) {
		model.addAttribute("Title", "About - Smart Contact Manager");
		return "signup";
	}

	@PostMapping("/do_register")
	public String doRegister(@ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {
		// model.addAttribute("Title","About - Smart Contact Manager");

		if (!agreement) {
			System.out.println("Not Agreed");
		}
		user.setRole("ROLE_USER");
		user.setEnable(true);
		userDAO.save(user);

		System.out.println(user.getName());
		System.out.println(agreement);
		System.out.println(user);
		
		model.addAttribute("user",user);
		return "signup";
	}

	// @RequestParam( value= "agreement",defaultValue = "false") boolean agreement,

	@GetMapping("/smart")
	public String smartContact() {

		Contact cn = new Contact();
		cn.setDescription("desc3");
		cn.setEmail("email3");
		cn.setImage("img3");
		cn.setName("name3");
		List<Contact> l1 = new ArrayList<Contact>();
		l1.add(cn);

		User us = new User();
		us.setName("pkr3");
		us.setAbout("abt3");
		us.setEmail("mmm3");
		us.setEnable(true);
		us.setImage("img3");
		us.setPassword("pass3");
		us.setRole("role3");
		us.setContacts(l1);
		userDAO.save(us);
		return "Success";
	}

}
