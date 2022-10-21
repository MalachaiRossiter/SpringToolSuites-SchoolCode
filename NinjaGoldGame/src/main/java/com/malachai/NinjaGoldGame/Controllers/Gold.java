package com.malachai.NinjaGoldGame.Controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Gold {
	
	@GetMapping("/")
	public String reroute() {
		return "redirect:/gold";
	}
	
	@GetMapping("/gold")
	public String index(HttpSession session, Model model) {
		Integer total = (Integer) session.getAttribute("total");
		
		model.addAttribute("total", total);
		
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(HttpSession session, Model model,
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required=false) String cave,
			@RequestParam(value="house", required=false) String house,
			@RequestParam(value="quest", required=false) String quest) {
			Random random = new Random();
			Integer total = 0;
			
		if (session.getAttribute("total") == null) {
			session.setAttribute("total", 0);
		}
		else {
			total = (Integer) session.getAttribute("total");
		}
		
		if (farm != null) {
			total += random.nextInt(10,30);
			session.setAttribute("total", total);
		}
		else if (cave != null) {
			total += random.nextInt(30);
			session.setAttribute("total", total);
		}
		else if (house != null) {
			total -= random.nextInt(10, 20);
			session.setAttribute("total", total);
		}
		else if (quest != null) {
			if (random.nextBoolean()== true) {
				total += random.nextInt(50);
			}
			else {
				total -= random.nextInt(50);
			}
			session.setAttribute("total", total);
		}
		
		return "redirect:/gold";
	}
}
