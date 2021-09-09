package com.lidroid.xutils.cache;

import _m_j.boq;
import java.util.concurrent.Callable;

public class LruDiskCache$1 implements Callable<Void> {
    final /* synthetic */ boq this$0;

    public LruDiskCache$1(boq boq) {
        this.this$0 = boq;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return null;
     */
    public Void call() throws Exception {
        synchronized (this.this$0) {
            if (this.this$0.O00000o0 == null) {
                return null;
            }
            this.this$0.O00000oO();
            if (this.this$0.O00000Oo()) {
                this.this$0.O000000o();
                this.this$0.O00000o = 0;
            }
        }
    }
}
