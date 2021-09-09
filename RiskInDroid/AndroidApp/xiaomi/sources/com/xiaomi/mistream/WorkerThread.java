package com.xiaomi.mistream;

import android.os.HandlerThread;

public class WorkerThread extends HandlerThread {
    public WorkerThread(String str) {
        super(str);
    }

    public WorkerThread(String str, int i) {
        super(str, i);
    }
}
