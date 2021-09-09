package _m_j;

import android.app.Activity;

public final class gzb {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18610O000000o;
    private final Activity O00000Oo;
    private boolean O00000o0;

    public gzb(Activity activity) {
        this.O00000Oo = activity;
    }

    public final void O000000o() {
        this.O00000o0 = true;
        gsy.O00000Oo("ActivityControl", "finish");
        O00000o0();
    }

    public final void O00000Oo() {
        this.f18610O000000o = false;
        gsy.O00000Oo("ActivityControl", "onStop");
        O00000o0();
    }

    private void O00000o0() {
        Activity activity;
        if (!this.f18610O000000o && this.O00000o0 && (activity = this.O00000Oo) != null && !activity.isFinishing()) {
            Activity activity2 = this.O00000Oo;
            activity2.getClass();
            activity2.runOnUiThread(new Runnable(activity2) {
                /* class _m_j.$$Lambda$XeCnPwdojwLpShUsMcuhTw48jCk */
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    this.f$0.finish();
                }
            });
        }
    }
}
