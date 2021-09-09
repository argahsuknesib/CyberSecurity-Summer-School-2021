package com.loc;

import _m_j.bss;
import java.util.concurrent.Callable;

public class bc$2 implements Callable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bss f4519a;

    public bc$2(bss bss) {
        this.f4519a = bss;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return null;
     */
    /* renamed from: a */
    public Void call() throws Exception {
        synchronized (this.f4519a) {
            if (this.f4519a.O0000OoO == null) {
                return null;
            }
            this.f4519a.O0000OoO();
            if (this.f4519a.O0000Oo0()) {
                this.f4519a.O0000OOo();
                int unused = this.f4519a.O0000o0 = 0;
            }
        }
    }
}
