package com.tencent.mm.sdk.b;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;

public final class g implements Runnable {
    private static final String bf = ("taskName = %s" + "|token = %s" + "|handler = %s" + "|threadName = %s" + "|threadId = %d" + "|priority = %d" + "|addTime = %d" + "|delayTime = %d" + "|usedTime = %d" + "|cpuTime = %d" + "|started = %b");
    private static final String bg;
    final Runnable aQ;
    final String aR;
    final Object aS;
    final Thread aT;
    String aU;
    long aV;
    final a aW;
    long aX;
    long aY;
    long aZ;
    long ba;
    long bb;
    long bc;
    long bd;
    float be = -1.0f;
    final Handler handler;
    int priority;
    boolean started = false;

    public interface a {
        void c(Runnable runnable, g gVar);
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("taskName = %s");
        sb.append(" | addTime = %s");
        sb.append(" | endTime = %s");
        sb.append(" | usedTime = %d");
        sb.append(" | cpuTime = %d");
        sb.append(" | threadCpuTime = %d");
        sb.append(" | totalCpuTime = %d");
        sb.append(" | threadCpuRate = %.1f");
        bg = sb.toString();
    }

    g(Thread thread, Handler handler2, Runnable runnable, Object obj, a aVar) {
        int indexOf;
        this.aT = thread;
        if (thread != null) {
            this.aU = thread.getName();
            this.aV = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler2;
        this.aQ = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!h.h(obj2) && (indexOf = obj2.indexOf(124)) > 0) {
            name = name + "_" + obj2.substring(indexOf + 1);
        }
        this.aR = name;
        this.aS = obj;
        this.aW = aVar;
        this.aX = System.currentTimeMillis();
    }

    public final void run() {
        int myTid = Process.myTid();
        StringBuilder sb = new StringBuilder("/proc/self/task/");
        sb.append(myTid);
        sb.append("/stat");
        this.ba = System.currentTimeMillis();
        this.bb = Debug.threadCpuTimeNanos();
        this.bc = -1;
        this.bd = -1;
        this.started = true;
        this.aQ.run();
        this.bc = -1 - this.bc;
        this.bd = -1 - this.bd;
        this.aZ = System.currentTimeMillis();
        this.ba = this.aZ - this.ba;
        this.bb = (Debug.threadCpuTimeNanos() - this.bb) / 1000000;
        long j = this.bd;
        if (j != 0) {
            this.be = ((float) (this.bc * 100)) / ((float) j);
        }
        a aVar = this.aW;
        if (aVar != null) {
            aVar.c(this.aQ, this);
        }
    }
}
