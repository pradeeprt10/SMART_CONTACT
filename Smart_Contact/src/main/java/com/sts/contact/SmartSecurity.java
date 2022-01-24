package com.sts.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SmartSecurity {
	
	@RequestMapping("/sec")
	public String checkSecurity() {		
		return "/normal/user_dashboard";
	}

}
