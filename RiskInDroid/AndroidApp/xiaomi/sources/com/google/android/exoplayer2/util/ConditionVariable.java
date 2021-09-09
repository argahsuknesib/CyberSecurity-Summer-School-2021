package com.google.android.exoplayer2.util;

import android.os.SystemClock;

public class ConditionVariable {
    private boolean isOpen;

    public synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public synchronized boolean close() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }

    public synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public synchronized boolean block(long j) throws InterruptedException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = j + elapsedRealtime;
        while (!this.isOpen && elapsedRealtime < j2) {
            wait(j2 - elapsedRealtime);
            elapsedRealtime = SystemClock.elapsedRealtime();
        }
        return this.isOpen;
    }

    public synchronized boolean isOpen() {
        return this.isOpen;
    }
}
