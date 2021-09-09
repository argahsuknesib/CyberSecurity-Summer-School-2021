package com.xiaomi.smarthome.frame.plugin;

public class SendMessageHandle {
    boolean mIsCanceled = false;

    public synchronized boolean isCanceled() {
        return this.mIsCanceled;
    }

    public synchronized void cancel() {
        this.mIsCanceled = true;
    }
}
