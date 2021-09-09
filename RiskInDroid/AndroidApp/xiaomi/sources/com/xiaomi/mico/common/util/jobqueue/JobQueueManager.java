package com.xiaomi.mico.common.util.jobqueue;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class JobQueueManager {
    private static JobQueueManager mInstance;
    protected Handler mBackgroundHandler;
    protected HandlerThread mBackgroundThread;
    HashMap<String, IJob> mJobMap = new HashMap<>(30);
    ArrayBlockingQueue<IJob> mJobQueue = new ArrayBlockingQueue<>(30);

    public static synchronized JobQueueManager instance() {
        JobQueueManager jobQueueManager;
        synchronized (JobQueueManager.class) {
            if (mInstance == null) {
                mInstance = new JobQueueManager();
            }
            jobQueueManager = mInstance;
        }
        return jobQueueManager;
    }

    public synchronized void addJob(IJob iJob) {
        if (iJob.shouldRunImmediately()) {
            iJob.onAdded();
            iJob.start();
        } else {
            this.mJobQueue.offer(iJob);
            iJob.onAdded();
        }
        this.mJobMap.put(iJob.getId(), iJob);
        scheduleMonitorJobs();
    }

    public void pause() {
        this.mBackgroundHandler.removeMessages(1);
    }

    public void scheduleMonitorJobs() {
        if (this.mBackgroundThread == null) {
            this.mBackgroundThread = new HandlerThread("JobManager");
            this.mBackgroundThread.start();
            this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper()) {
                /* class com.xiaomi.mico.common.util.jobqueue.JobQueueManager.AnonymousClass1 */

                public void handleMessage(Message message) {
                    IJob poll;
                    int i = message.what;
                    if (i == 1) {
                        boolean z = false;
                        Iterator<Map.Entry<String, IJob>> it = JobQueueManager.this.mJobMap.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry next = it.next();
                            if (((IJob) next.getValue()).isRunning()) {
                                z = true;
                            } else if (((IJob) next.getValue()).isFinished()) {
                                it.remove();
                            }
                        }
                        if (!z && (poll = JobQueueManager.this.mJobQueue.poll()) != null) {
                            poll.start();
                            z = true;
                        }
                        if (z) {
                            JobQueueManager.this.mBackgroundHandler.sendEmptyMessageDelayed(1, 200);
                            return;
                        }
                        JobQueueManager.this.mBackgroundHandler.removeMessages(1);
                        JobQueueManager.this.mBackgroundHandler.sendEmptyMessageDelayed(2, 60000);
                    } else if (i == 2) {
                        JobQueueManager.this.quitBackgroundThread();
                    }
                }
            };
        }
        if (!this.mBackgroundHandler.hasMessages(1)) {
            this.mBackgroundHandler.sendEmptyMessage(1);
        }
        this.mBackgroundHandler.removeMessages(2);
    }

    public void quitBackgroundThread() {
        this.mBackgroundHandler.removeCallbacksAndMessages(null);
        this.mBackgroundHandler = null;
        this.mBackgroundThread.quit();
        this.mBackgroundThread = null;
    }

    public boolean hasJob(String str) {
        return this.mJobMap.containsKey(str);
    }

    public IJob getJob(String str) {
        return this.mJobMap.get(str);
    }

    public boolean hasJob(Class cls) {
        for (IJob iJob : this.mJobMap.values()) {
            if (iJob.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }
}
