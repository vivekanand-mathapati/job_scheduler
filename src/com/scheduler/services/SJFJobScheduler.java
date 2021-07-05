package com.scheduler.services;

import com.scheduler.constants.UserType;
import com.scheduler.entities.Job;

import java.util.*;

public class SJFJobScheduler implements JobScheduler{
    private List<Job> jobs;
    private JobService jobService;
    private HashMap<Integer, List<String>> threads;
    private Integer noOfThreads;

    public SJFJobScheduler(int noOfThreads) {
        this.jobs = new ArrayList<>();
        this.jobService = JobService.getJobService();
        this.threads = new HashMap<>();
        this.noOfThreads = noOfThreads;
    }

    @Override
    public void scheduler(){
        jobs.addAll(jobService.getJobs());
        jobs.sort(Comparator.comparing(Job::getDuration).thenComparing(Job::getPriority));
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
