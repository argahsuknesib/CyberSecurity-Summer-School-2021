package com.squareup.okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher {
    private final Deque<Call> executedCalls = new ArrayDeque();
    private ExecutorService executorService;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque();
    private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    public Dispatcher() {
    }

    public final synchronized ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public final synchronized void setMaxRequests(int i) {
        if (i > 0) {
            this.maxRequests = i;
            promoteCalls();
        } else {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized void setMaxRequestsPerHost(int i) {
        if (i > 0) {
            this.maxRequestsPerHost = i;
            promoteCalls();
        } else {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void enqueue(Call.AsyncCall asyncCall) {
        if (this.runningCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
            this.readyCalls.add(asyncCall);
            return;
        }
        this.runningCalls.add(asyncCall);
        getExecutorService().execute(asyncCall);
    }

    public final synchronized void cancel(Object obj) {
        for (Call.AsyncCall next : this.readyCalls) {
            if (Util.equal(obj, next.tag())) {
                next.cancel();
            }
        }
        for (Call.AsyncCall next2 : this.runningCalls) {
            if (Util.equal(obj, next2.tag())) {
                next2.get().canceled = true;
                HttpEngine httpEngine = next2.get().engine;
                if (httpEngine != null) {
                    httpEngine.disconnect();
                }
            }
        }
        for (Call next3 : this.executedCalls) {
            if (Util.equal(obj, next3.tag())) {
                next3.cancel();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void finished(Call.AsyncCall asyncCall) {
        if (this.runningCalls.remove(asyncCall)) {
            promoteCalls();
        } else {
            throw new AssertionError("AsyncCall wasn't running!");
        }
    }

    private void promoteCalls() {
        if (this.runningCalls.size() < this.maxRequests && !this.readyCalls.isEmpty()) {
            Iterator<Call.AsyncCall> it = this.readyCalls.iterator();
            while (it.hasNext()) {
                Call.AsyncCall next = it.next();
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningCalls.add(next);
                    getExecutorService().execute(next);
                }
                if (this.runningCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }

    private int runningCallsForHost(Call.AsyncCall asyncCall) {
        int i = 0;
        for (Call.AsyncCall host : this.runningCalls) {
            if (host.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void executed(Call call) {
        this.executedCalls.add(call);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void finished(Call call) {
        if (!this.executedCalls.remove(call)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }

    public final synchronized int getRunningCallCount() {
        return this.runningCalls.size();
    }

    public final synchronized int getQueuedCallCount() {
        return this.readyCalls.size();
    }
}
