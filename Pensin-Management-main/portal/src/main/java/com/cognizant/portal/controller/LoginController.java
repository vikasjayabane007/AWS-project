package com.cognizant.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.UserLoginCredential;
import com.cognizant.portal.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@Autowired
	private PortalService portalService;

	
	@GetMapping("/")
	public String homePage() {
		log.debug("Fetching The index Page");
		return "index";
	}
	

	@GetMapping("/login")
	public String displayLoginPage(Model model, UserLoginCredential login) {
		log.debug("Fetching the login Page");
		model.addAttribute("login", login);
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,Model model)
	{
		log.debug("Logging Out");
		session.invalidate();
		model.addAttribute("login", new UserLoginCredential()); 
		return "login";
	}
	

	@PostMapping("/login")
	public String parseLoginPage(@Valid @ModelAttribute("pensionerInput") PensionerInput pensionerInput ,@ModelAttribute("login") UserLoginCredential login,HttpServletRequest request,Model model) {
		log.debug("Submitting login Information");
		UserLoginCredential token = portalService.getPensionerPage(pensionerInput,login);

		if(token!=null)
		{
			log.debug("User Successfully authenticated");
			log.debug("Fetching PensionerDetails Form");
			request.getSession().setAttribute("token", token.getToken());
			request.getSession().setAttribute("uid", token.getUid());
			return "pensionerdetails";
		}
			model.addAttribute("loginerror", "Invalid Username/Password");
			return "login";
	
		
	}
}
