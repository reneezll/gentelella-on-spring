package com.templ.backend.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.BuildResult;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.templ.gentelella.domain.model.entity.jenkins.JobReport;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JenkinsRestClient {
	public URI cUri = null;
	// test_data
	public String url = "https://hub.spigotmc.org/jenkins/";
	public String prefixView = "view/%s";
	public String username = null;
	public String password = null;

	public JenkinsRestClient(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public ArrayList<JobReport> getJobsByView(String view) {
		Map<String, Job> map= null;
		ArrayList<JobReport> arJobRport = new ArrayList<>();
		URI uri = null;
		String viewUrl = url+String.format(prefixView,view);
		try {
			uri = new URI(url+String.format(prefixView,view));
			System.out.println("view Url: " + viewUrl);
		} catch (URISyntaxException e) {
			System.out.println("URI has error.");
			e.printStackTrace();
		}

		JenkinsServer jenkins = new JenkinsServer(uri, null, null);
		Map<String, Job> jobs = null;
		try {
			jobs = jenkins.getJobs();
			Iterator<String> keys = jobs.keySet().iterator();
			while( keys.hasNext() ){
				String key = keys.next();
				Job job = jobs.get(key);
				JobReport jr = new JobReport();
				System.out.println( String.format("key : %s, value : %s", key, jobs.get(key)) );
				JobWithDetails jobDetails = job.details();
				BuildResult br =jobDetails.getLastBuild().details().getResult();
				System.out.println("jobName: " + job.getName()+ " lastBuildResult: "+ br.name());
				jr.setJobName(job.getName());
				jr.setLastBuildResult(br.name());
				jr.setViewName(view);
				jr.setLastDuration(0); // TODO: get timestamp
				arJobRport.add(jr);

			}


		} catch (IOException e) {
			System.out.println("Get Job has error.");
			e.printStackTrace();
		}
		return arJobRport;
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
