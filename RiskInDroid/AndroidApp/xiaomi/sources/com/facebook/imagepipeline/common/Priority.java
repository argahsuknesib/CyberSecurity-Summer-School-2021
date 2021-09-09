package com.facebook.imagepipeline.common;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority getHigherPriority(Priority priority, Priority priority2) {
        if (priority == null) {
            return priority2;
        }
        return (priority2 != null && priority.ordinal() <= priority2.ordinal()) ? priority2 : priority;
    }
}
