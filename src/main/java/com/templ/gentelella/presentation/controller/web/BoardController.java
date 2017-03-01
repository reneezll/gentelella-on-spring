package com.templ.gentelella.presentation.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", "Gentelella on Spring");
		return "dashboard";
	}
}
