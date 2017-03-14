package com.templ.gentelella.domain.model.entity.jenkins;

import com.offbytwo.jenkins.model.Job;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by java on 17. 3. 14.
 */
public class JenkinsInfoModel {
    private String url = null;
    private String view = null;
    private String displayName = null; /*server display name */
    private ArrayList<JobReport> jobMap= null;

    public JenkinsInfoModel(String aUrl, String displayName, String aView, ArrayList<JobReport> jobMap){

        this.url = aUrl;
        this.view = aView;
        this.jobMap = jobMap;
        this.displayName = displayName;
    }

    public ArrayList<JobReport> getJobMap() {
        return jobMap;
    }
    public void setJobMap(ArrayList<JobReport> jobMap) {
        this.jobMap = jobMap;
    }
    public String getDisplayName(){
        return displayName;
    }
    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
