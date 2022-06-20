package com.springboot.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.springboot.entities.Login;
import com.springboot.springboot.repository.LoginRepo;

@Controller
public class LoginController {

	@Autowired
	private LoginRepo lrepo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
  @GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
  @PostMapping("/login")
  public String login(@ModelAttribute(name="loginForm") Login login, Model m) {
   String uname = login.getUsername();
   String pass = login.getPassword();
    Login log1=lrepo.findByUsername(uname);
    Login log2=lrepo.findByPassword(pass);
   
    if(log1==null || log2==null) {
    	   m.addAttribute("error", "Incorrect Username & Password");
    	   return "login";
    	   }
   if(log1==log2 && log1.getUsername().endsWith("@hmp")) {
	    m.addAttribute("uname", uname);
	    m.addAttribute("pass", pass);
	    return "redirect:appointment";
  }
   if(log1==log2 && log1.getUsername().endsWith("@hmd")) {
	    m.addAttribute("uname", uname);
	    m.addAttribute("pass", pass);
	    return "redirect:dpatient";
 }
  
   m.addAttribute("error", "Incorrect Username & Password");
   return "login";
  }
}
