package com.mi.multimonitor;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class Executor {
    private volatile MonitorHandler mMonitorHandler = new MonitorHandler(this.mMonitorLooper);
    private volatile Looper mMonitorLooper;

    Executor(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.mMonitorLooper = handlerThread.getLooper();
    }

    /* access modifiers changed from: package-private */
    public void execute(Request request) {
        sendToExecute(request);
    }

    private void sendToExecute(Request request) {
        Message obtainMessage = this.mMonitorHandler.obtainMessage();
        obtainMessage.obj = request;
        obtainMessage.what = 291;
        obtainMessage.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void quit() {
        this.mMonitorLooper.quit();
    }

    final class MonitorHandler extends Handler {
        public MonitorHandler(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Request request;
            if (message.what == 291 && (request = (Request) message.obj) != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(request);
            }
        }
    }
}
