package com.temple.backend.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.BuildResult;
import com.offbytwo.jenkins.model.JobWithDetails;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;

public class JenkinsRestClient {
	public String url = "https://hub.spigotmc.org/jenkins/";
	public URI cUri = null;
	public String username = null;
	public String password = null;

	public JenkinsRestClient(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public Map<String, Job> getJobs(String filter) {
		try {
			cUri = new URI(url);
		} catch (URISyntaxException e) {
			System.out.println("URI has error.");
			e.printStackTrace();
		}
		JenkinsServer jenkins = new JenkinsServer(cUri, null, null);
		Map<String, Job> jobs = null;
		try {
			jobs = jenkins.getJobs();
			Iterator<String> keys = jobs.keySet().iterator();
			while( keys.hasNext() ){
	            String key = keys.next();
	            Job job = jobs.get(key);
	            System.out.println( String.format("key : %s, value : %s", key, jobs.get(key)) );
	            JobWithDetails jobDetails = job.details();
	            BuildResult br = BuildResult.UNKNOWN;
	            br = jobDetails.getLastBuild().details().getResult();
	            System.out.println("jobName: " + job.getName()+ "lastBuildResult: "+ br.name());
	        }


		} catch (IOException e) {
			System.out.println("Get Job has error.");
			e.printStackTrace();
		}
		return jobs;
	}
}
