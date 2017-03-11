package com.templ.gentelella.presentation.controller.rest.jenkins;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = { "/rest/jenkins" })
public class JenkinsRestController {


	@RequestMapping(value = "/joblist", method = RequestMethod.GET)
	public String jobList(@RequestParam(value = "server", required = true) String server) {
		return "hi";
	}

}
