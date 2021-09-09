package com.nostra13.universalimageloader.cache.disc.impl.ext;

import _m_j.cnl;
import java.util.concurrent.Callable;

public class DiskLruCache$1 implements Callable<Void> {
    final /* synthetic */ cnl this$0;

    public DiskLruCache$1(cnl cnl) {
        this.this$0 = cnl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return null;
     */
    public Void call() throws Exception {
        synchronized (this.this$0) {
            if (this.this$0.O00000o == null) {
                return null;
            }
            this.this$0.O00000o0();
            this.this$0.O00000o();
            if (this.this$0.O00000Oo()) {
                this.this$0.O000000o();
                this.this$0.O00000oO = 0;
            }
        }
    }
}
