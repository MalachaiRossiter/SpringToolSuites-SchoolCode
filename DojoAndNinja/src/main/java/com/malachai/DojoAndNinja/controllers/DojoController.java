package com.malachai.DojoAndNinja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malachai.DojoAndNinja.models.Dojo;
import com.malachai.DojoAndNinja.services.AppService;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	@Autowired
	private AppService aService;
	
	@GetMapping("/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/createDojo")
	public String dojoCreate(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		this.aService.createDojo(dojo);
		return "redirect:/ninja/new.jsp";
	}
	
	@GetMapping("/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", this.aService.getOneDojo(id));
		return "showDojo.jsp";
	}
	
}
