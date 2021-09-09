package com.loc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class bc$1 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f4518a = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "disklrucache#" + this.f4518a.getAndIncrement());
    }
}
