package com.test.jenkins;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
public class MainJenkins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		
		URI uri = null;
		String jUrl = "https://hub.spigotmc.org/jenkins/";
		try {
			uri = new URI(jUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println("URI has error.");
			e.printStackTrace();
		}
		JenkinsServer jenkins = new JenkinsServer(uri, null, null);
		Map<String, Job> jobs = null; 
		try {
			jobs = jenkins.getJobs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Get Job has error.");
			e.printStackTrace();
		}

		System.out.println(jobs.toString());
	}

}
