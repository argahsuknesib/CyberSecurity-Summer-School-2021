package com.facebook.react.jstasks;

public interface HeadlessJsTaskRetryPolicy {
    boolean canRetry();

    HeadlessJsTaskRetryPolicy copy();

    int getDelay();

    HeadlessJsTaskRetryPolicy update();
}
