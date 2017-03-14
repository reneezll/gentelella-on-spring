package com.templ.gentelella.domain.model.entity.jenkins;

/**
 * Created by java on 17. 3. 14.
 */
public class JobReport {
    private String lastBuildResult=null;
    private String jobName =null;
    private String viewName =null;
    private Integer lastDuration = null;


    public String getLastBuildResult() {
        return lastBuildResult;
    }

    public void setLastBuildResult(String lastBuildResult) {
        this.lastBuildResult = lastBuildResult;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Integer getLastDuration() {
        return lastDuration;
    }

    public void setLastDuration(Integer lastDuration) {
        this.lastDuration = lastDuration;
    }
}
