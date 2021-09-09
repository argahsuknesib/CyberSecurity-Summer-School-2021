package com.xiaomi.util;

import _m_j.iam;
import java.util.concurrent.Callable;

public class DiskLruCache$1 implements Callable<Void> {
    final /* synthetic */ iam this$0;

    public DiskLruCache$1(iam iam) {
        this.this$0 = iam;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return null;
     */
    public Void call() throws Exception {
        synchronized (this.this$0) {
            if (this.this$0.O00000o == null) {
                return null;
            }
            this.this$0.O00000o();
            if (this.this$0.O00000Oo()) {
                this.this$0.O000000o();
                this.this$0.O00000oO = 0;
            }
        }
    }
}
