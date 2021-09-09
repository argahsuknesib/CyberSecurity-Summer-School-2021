package com.xiaomi.smarthome.service;

import java.util.concurrent.atomic.AtomicInteger;

public enum CardActive {
    instance;
    
    private AtomicInteger count = new AtomicInteger();

    public final boolean isActive() {
        return this.count.get() > 0;
    }

    public final void create() {
        this.count.incrementAndGet();
    }

    public final void destory() {
        this.count.decrementAndGet();
    }
}
