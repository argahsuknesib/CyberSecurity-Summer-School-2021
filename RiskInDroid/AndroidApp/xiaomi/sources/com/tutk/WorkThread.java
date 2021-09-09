package com.tutk;

public abstract class WorkThread extends Thread {
    protected volatile boolean mIsRunning = false;

    /* access modifiers changed from: protected */
    public abstract void doInitial();

    /* access modifiers changed from: protected */
    public abstract void doRelease();

    /* access modifiers changed from: protected */
    public abstract int doRepeatWork() throws InterruptedException;

    public WorkThread(String str) {
        super(str);
        setPriority(1);
    }

    public void run() {
        doInitial();
        while (this.mIsRunning) {
            try {
                doRepeatWork();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        doRelease();
    }

    public synchronized void start() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            super.start();
        }
    }

    public synchronized void stopThreadAsyn() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            interrupt();
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }
}
