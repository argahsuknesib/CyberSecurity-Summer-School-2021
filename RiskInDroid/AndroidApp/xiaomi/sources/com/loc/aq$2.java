package com.loc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class aq$2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f4517a = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "pama#" + this.f4517a.getAndIncrement());
    }
}
