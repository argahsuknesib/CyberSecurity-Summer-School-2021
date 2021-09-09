package com.xiaomi.mico.common.util.jobqueue;

public interface IJob {
    String getId();

    boolean isFinished();

    boolean isRunning();

    void onAdded();

    boolean shouldRunImmediately();

    void start();
}
