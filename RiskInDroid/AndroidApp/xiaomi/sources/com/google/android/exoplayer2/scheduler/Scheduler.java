package com.google.android.exoplayer2.scheduler;

public interface Scheduler {
    boolean cancel();

    boolean schedule(Requirements requirements, String str, String str2);
}
