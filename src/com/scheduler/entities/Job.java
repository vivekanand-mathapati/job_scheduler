package com.scheduler.entities;

import com.scheduler.constants.JobPriority;
import com.scheduler.constants.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
    private String JobId;
    private Integer Duration;
    private Integer Priority;
    private Integer Deadline;
    private Integer userType;

    public Job(String jobId, Integer duration, JobPriority priority, Integer deadline, UserType userType) {
        this.JobId = jobId;
        this.Duration = duration;
        this.Priority = priority.getValue();
        this.Deadline = deadline;
        this.userType = userType.getValue();
    }
}
