package _m_j;

import android.text.TextUtils;

public final class gop implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f18095O000000o;
    private Runnable O00000Oo;

    public gop(Runnable runnable, String str) {
        this.O00000Oo = runnable;
        this.f18095O000000o = str;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.f18095O000000o)) {
            Thread.currentThread().setName(this.f18095O000000o);
        }
        this.O00000Oo.run();
    }
}
