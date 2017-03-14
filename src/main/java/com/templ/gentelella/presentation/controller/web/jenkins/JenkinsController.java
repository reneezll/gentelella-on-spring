package com.templ.gentelella.presentation.controller.web.jenkins;

import com.offbytwo.jenkins.model.Job;
import com.templ.gentelella.domain.model.entity.jenkins.JenkinsInfoModel;
import com.templ.gentelella.domain.model.entity.jenkins.JobReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.templ.backend.jenkins.JenkinsRestClient;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class JenkinsController {

	@RequestMapping(value = "/jenkins", method = RequestMethod.GET)
	public String index(Model model) {
		String url = "https://hub.spigotmc.org/jenkins/";
		String view = "RSS";
		String displayname= "JEN A";

		String username = null;
		String password = null;


		JenkinsRestClient jenClient = new JenkinsRestClient(url, username, password);
		ArrayList<JobReport> arJob = jenClient.getJobsByView(view);

		ArrayList<JenkinsInfoModel> arList = new ArrayList<>();
		JenkinsInfoModel infoModel = new JenkinsInfoModel(url, displayname, view, arJob);
		arList.add(infoModel);

		model.addAttribute("name", "Gentelella on Spring");
		model.addAttribute("jenkinsAUrl" ,url);
		model.addAttribute("jenList", arList);
		return "jenkins/jenkins_page";
	}
}
