package com.test.jenkins;
import com.templ.backend.jenkins.JenkinsRestClient;

//import java.sql.Timestamp;
//import java.time.Instant;
//import java.util.Date;
//import java.util.Map;

public class MainJenkins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://hub.spigotmc.org/jenkins/";
		String username = null;
		String password = null;
		JenkinsRestClient jenClient = new JenkinsRestClient(url, username, password);
//		Map<String, Job> jobMap = jenClient.getJobsByView("RSS");
//		Timestamp ts = new Timestamp(1000);
//		Date dt = Date.from(ts.toInstant());
//		System.out.println("hello: " + dt );


		
	}

}
