package com.scheduler.services;

import com.scheduler.entities.Job;
import lombok.val;

import java.util.*;

public class FPSJobScheduler implements JobScheduler{
    private List<Job> jobs;
    private JobService jobService;
    private HashMap<Integer, List<String>> threads;
    private Integer noOfThreads;

    public FPSJobScheduler(int noOfThreads) {
        this.jobs = new ArrayList<>();
        this.jobService = JobService.getJobService();
        this.threads = new HashMap<>();
        this.noOfThreads = noOfThreads;
    }

    @Override
    public void scheduler(){
        jobs.addAll(jobService.getJobs());
        jobs.sort(Comparator.comparing(Job::getPriority)
                .thenComparing(Job::getUserType).thenComparing(Job::getDuration, Comparator.reverseOrder()));
        int index = 0;
        for(Job job : jobs) {
            if (threads.containsKey((index % noOfThreads))) {
                threads.get(index % noOfThreads).add(job.getJobId());
            }else{
                List<String> arr = new ArrayList<>();
                arr.add(job.getJobId());
                threads.put((index % noOfThreads),arr);
            }
            index++;
        }

        for (Map.Entry<Integer, List<String>> thread : threads.entrySet()){
            System.out.println(String.format("Thread %d: ", thread.getKey())+ thread.getValue());
        }
    }
}
