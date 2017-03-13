package com.templ.gentelella.presentation.controller.web.jenkins;

import com.offbytwo.jenkins.model.Job;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.templ.backend.jenkins.JenkinsRestClient;

import java.util.Map;

@Controller
public class JenkinsController {

	@RequestMapping(value = "/jenkins", method = RequestMethod.GET)
	public String index(Model model) {
		String url = "https://hub.spigotmc.org/jenkins/";
		String username = null;
		String password = null;
		JenkinsRestClient jenClient = new JenkinsRestClient(url, username, password);
		Map<String, Job> jobAMap = jenClient.getJobsByView("RSS");
		model.addAttribute("name", "Gentelella on Spring");
		model.addAttribute("jenkinsAUrl" ,url);
		model.addAttribute("jenkinsA" ,jobAMap.toString() );
		return "jenkins/jenkins_page";
	}
}
