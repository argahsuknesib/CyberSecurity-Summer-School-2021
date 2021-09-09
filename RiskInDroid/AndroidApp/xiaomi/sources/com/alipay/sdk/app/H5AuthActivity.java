package com.alipay.sdk.app;

public class H5AuthActivity extends H5PayActivity {
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    public void a() {
        Object obj = AuthTask.f3167a;
        synchronized (obj) {
            obj.notify();
        }
    }
}
