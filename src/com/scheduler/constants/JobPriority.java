package com.scheduler.constants;

public enum JobPriority {
    P0(0),
    P1(1),
    P2(2);

    private final int priority;
    JobPriority(final  int priority) {
        this.priority = priority;
    }

    public int getValue(){
        return priority;
    }
}
