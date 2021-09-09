package com.xiaomi.mico.common.util.jobqueue;

import java.util.Iterator;
import java.util.List;

public class ParallelJob extends ProgressJob {
    private List<IJob> mJobs;
    private String mName;

    public ParallelJob(String str, List<IJob> list) {
        this.mName = str;
        this.mJobs = list;
    }

    public void onAdded() {
        for (IJob onAdded : this.mJobs) {
            onAdded.onAdded();
        }
    }

    public boolean isFinished() {
        Iterator<IJob> it = this.mJobs.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return false;
    }

    public void start() {
        for (IJob start : this.mJobs) {
            start.start();
        }
    }
}
