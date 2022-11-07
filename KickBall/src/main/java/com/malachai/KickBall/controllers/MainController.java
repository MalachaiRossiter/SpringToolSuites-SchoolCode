package com.malachai.KickBall.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malachai.KickBall.models.LoginUser;
import com.malachai.KickBall.models.User;
import com.malachai.KickBall.services.TeamService;
import com.malachai.KickBall.services.UserService;

@Controller
@RequestMapping("/kickball")
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/")
	public String reroute() {
		return "redirect:/kickball/Login";
	}
	
	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		
		if(session.getAttribute("loggedIn") == null) {
			return "redirect:/kickball/login";
		}
		model.addAttribute("teams", teamService.getAll());
		model.addAttribute("user", userService.findById((long)session.getAttribute("loggedIn")));
		return "dashboard.jsp";
	}
	
	@PostMapping("/register")
	public String Register(@Valid @ModelAttribute(name="newUser") User user, BindingResult result, Model model, HttpSession session) {
		User newUser = userService.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("loggedIn", newUser.getId());
		return "redirect:/kickball/dashboard";
	}
	
	@PostMapping("/login")
	public String Login(@Valid @ModelAttribute(name="newLogin")LoginUser login, BindingResult result, Model model, HttpSession session) {
		User newUser = userService.authenticate(login, result);
		if (result.hasErrors() || newUser == null) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("loggedIn", newUser.getId());
		return "redirect:/kickball/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.print("I got past here I think");
		session.removeAttribute("loggedIn");
		return "redirect:/kickball/login";
	}
}
