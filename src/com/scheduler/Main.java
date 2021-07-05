package com.scheduler;

import com.scheduler.constants.JobPriority;
import com.scheduler.constants.UserType;
import com.scheduler.services.*;

public class Main {

    public static void main(String[] args) {
	    //add jobs
        JobService jobService = JobService.getJobService();

        jobService.addJob("J1",50,	JobPriority.P0,10, UserType.ADMIN);
        jobService.addJob("J2",20,	JobPriority.P1,40, UserType.ADMIN);
        jobService.addJob("J3",15,	JobPriority.P2,40, UserType.ROOT);
        jobService.addJob("J4",30,	JobPriority.P1,40, UserType.USER);
        jobService.addJob("J5",10,	JobPriority.P0,30, UserType.ADMIN);

        JobScheduler jobScheduler = new SJFJobScheduler(2);
        jobScheduler.scheduler();
        JobScheduler jobScheduler1 = new FCFSJobScheduler(2);
        jobScheduler1.scheduler();
        JobScheduler jobScheduler2 = new FPSJobScheduler(2);
        jobScheduler2.scheduler();
    }
}

/*
Job Name	Duration	Priority	Deadline	User Type
J1		10		P0		10		Root
J2		20		P0		40		Admin
J3		15		P2		40		Root
J4		30		P1		40		User
J5		10		P2		30		User

 */