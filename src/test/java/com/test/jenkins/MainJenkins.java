package com.test.jenkins;
import com.offbytwo.jenkins.model.Job;

import java.util.Map;
import com.temple.backend.jenkins.JenkinsRestClient;

public class MainJenkins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://hub.spigotmc.org/jenkins/";
		String username = null;
		String password = null;
		JenkinsRestClient jenClient = new JenkinsRestClient(url, username, password);
		Map<String, Job> jobMap = jenClient.getJobs(null);
		System.out.println("hello");


		
	}

}
