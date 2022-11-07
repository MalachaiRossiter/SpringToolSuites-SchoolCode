package com.malachai.KickBall.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malachai.KickBall.models.Team;
import com.malachai.KickBall.models.User;
import com.malachai.KickBall.services.TeamService;
import com.malachai.KickBall.services.UserService;

@Controller
@RequestMapping("/kickball")
public class TeamController {
	@Autowired
	private UserService userService;
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/createTeam")
	public String addTeam(@ModelAttribute("team") Team team, Model model, HttpSession session) {
		
		if(session.getAttribute("loggedIn") == null) {
			return "redirect:/kickball/login";
		}
		User user = userService.findById((Long)session.getAttribute("loggedIn"));
		model.addAttribute("user", user);
		return "addTeam.jsp";
	}
	
	@PostMapping("/createTeam")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if(result.hasErrors()) {
			return "addTeam.jsp";
		}
		
		teamService.create(team);
		return "redirect:/kickball/dashboard";
	}
	
	@GetMapping("/teams/{id}")
	public String teamPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("loggedIn") == null) {
			return "redirect:/kickball/login";
		}
		Team team = teamService.findById(id);
		model.addAttribute("team", team);
		model.addAttribute("user", userService.findById((Long)session.getAttribute("loggedIn")));
		return "team.jsp";
	}
	
	@GetMapping("/teams/edit/{id}")
	public String editTeams(Model model, @PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("loggedIn") == null) {
			return "redirect:/kickball/login";
		}
		Team team = teamService.findById(id);
		model.addAttribute("team", team);
		model.addAttribute("user", userService.findById((long)session.getAttribute("loggedIn")));
		return "editTeam.jsp";
	}
	
	@PutMapping("/teams/edit/{id}")
	public String updateTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editTeam.jsp";
		}
		
		teamService.update(team);
		return "redirect:/kickball/dashboard";
	}
	
	@GetMapping("/teams/delete/{id}")
	public String deleteTeam(@PathVariable("id")Long id) {
		teamService.delete(id);
		return "redirect:/kickball/dashboard";
	}
}
