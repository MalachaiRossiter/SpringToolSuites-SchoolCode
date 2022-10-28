package com.malachai.DojoAndNinja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malachai.DojoAndNinja.models.Dojo;
import com.malachai.DojoAndNinja.models.Ninja;
import com.malachai.DojoAndNinja.services.AppService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
	@Autowired
	private AppService aService;
	
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = this.aService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/createNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = this.aService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "newNinja.jsp";
		}
		this.aService.createNinja(ninja);
		return "redirect:/dojo/" + ninja.getDojo().getId();
	}
	
}
