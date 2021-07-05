package com.scheduler.constants;

public enum UserType {
    ROOT(3),
    USER(2),
    ADMIN(1);

    private final int value;
    UserType(final int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
