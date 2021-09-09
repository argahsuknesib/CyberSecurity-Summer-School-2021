package _m_j;

public abstract class fsg extends Thread {
    protected volatile boolean mIsRunning = false;

    /* access modifiers changed from: protected */
    public abstract void doInitial();

    /* access modifiers changed from: protected */
    public abstract void doRelease();

    /* access modifiers changed from: protected */
    public abstract int doRepeatWork() throws InterruptedException;

    public fsg(String str) {
        super(str);
        setPriority(1);
    }

    public void run() {
        doInitial();
        while (this.mIsRunning) {
            try {
                doRepeatWork();
            } catch (Throwable unused) {
            }
        }
        doRelease();
        cki.O00000oO("thread", "[Thread quit]" + getName());
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

    public synchronized void stopThreadSyn() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            interrupt();
            try {
                join();
            } catch (InterruptedException unused) {
            }
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }
}
