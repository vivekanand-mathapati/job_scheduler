Job Scheduler

Task
Given a single machine, Write a job scheduler to schedule M jobs on N threads.
The input contains the following data
Job Name
Duration: time taken for job completion 
Priority: priority of the job. P0 > P1 > P2.
Deadline: Expiry time after which job should not be run (The clock starts from 0 and deadline is the actual clock time)
UserType: Type of user who has initiated the job, Precedence of users Root>Admin>User

There are various scheduling algorithms - 
Shortest Job first - SJF
Shortest job first (SJF), is a scheduling policy that selects the waiting process with the smallest execution time to execute next.
In case of tie choose the job according to the following order - 
Priority (higher priority job gets scheduled first)
First Come First Serve - FCFS
Jobs are executed on first come, first serve basis. Take the input as the order of jobs need to be scheduled.
Fixed Priority Scheduling - FPS
Each process is assigned a priority. Process with highest priority is to be executed first and so on.
In case of tie choose the job according to the following order - 
User Type
Longest Job First
Earliest Deadline First - EDF
Next job will be searched on the basis of job which is closest to its deadline.
In case of tie, choose the job according to the following order - 
Priority (higher priority job gets scheduled first)
Duration (lesser duration job gets scheduled first)
In case we cannot schedule a job such that it completes before its deadline then it should be ignored.

You would be given a list of jobs (refer example below for format) and number of threads as input. You are expected to print the order of jobs scheduled for each algorithm on each thread as output.
Example
Input
Threads = 2

Job Name	Duration	Priority	Deadline	User Type
J1		10		P0		10		Root
J2		20		P0		40		Admin
J3		15		P2		40		Root
J4		30		P1		40		User
J5		10		P2		30		User
Output
SJF
Thread 1 - J1, J3, J4
Thread 2 - J5, J2

FCFS
Thread 1 - J1, J3, J5
Thread 2 - J2, J4

FPS
Thread 1 - J1, J4
Thread 2 - J2, J3, J5

EDF
Thread 1 - J1, J2
Thread 2 - J5, J4
Bonus Question
Given a generic time slice, schedule the jobs using round robin algorithm(ie each job is assigned a fixed time slot in a cyclic).
Expected output
Job_Name(Time), Job_Name(Time) ....
Sample (considering time-slice = 10)
SJF
J1(10), J5(10), J3(10), J2(10), J4(10), J3(5), J2(10), J4(10), J4(10)
Thread 1 - J1(10), J3(10), J4(10), J4(10), J4(10)
Thread 2 - J5(10), J2(10), J3(5), J2(10)

