package com.scheduler.services;

import com.scheduler.constants.JobPriority;
import com.scheduler.constants.UserType;
import com.scheduler.entities.Job;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JobService {
    private static JobService jobService;
    private static List<Job> jobs;
    public static JobService getJobService(){
        if(jobService == null)
            jobService = new JobService();
        return jobService;
    }

    private JobService(){
        this.jobs = new ArrayList<>();
    }

    public void addJob(String jobId, Integer duration, JobPriority priority, Integer deadLine, UserType userType){
        Job job = new Job(jobId, duration, priority, deadLine, userType);
        jobs.add(job);
        System.out.println("Job added successfully!");
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
