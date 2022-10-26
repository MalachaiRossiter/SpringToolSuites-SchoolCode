package com.malachai.saveTravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.malachai.saveTravels.models.Expence;
import com.malachai.saveTravels.services.ExpenceService;

@Controller
public class HomeController {
	@Autowired
	private ExpenceService expenceService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expence")Expence expence) {
		model.addAttribute("expences", expenceService.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/expence/{id}/edit")
	public String editExpence(@PathVariable(name="id") Long id, Model model) {
		Expence expence = expenceService.getOne(id);
		model.addAttribute("expence", expence);
		return "editExpence.jsp";
	}
	
	@PostMapping("/expence/create")
	public String createExpence(@Valid @ModelAttribute("expence") Expence expence, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expences", expenceService.getAll());
			return "index.jsp";
		}
		expenceService.createExpence(expence);
		return "redirect:/";
	}
	
	@PutMapping("/expence/{id}/edit")
	public String updateExpence(@Valid @ModelAttribute("expence") Expence expence, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expence", expence);
			return "editExpence.jsp";
		}
		expenceService.updateExpence(expence);
		return "redirect:/";
	}
	
	@GetMapping("/expence/{id}/delete")
	public String deleteExpence(@PathVariable(name="id") Long id) {
		expenceService.deleteExpence(id);
		return "redirect:/";
	}
}
