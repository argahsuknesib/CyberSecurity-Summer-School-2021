package _m_j;

import android.view.MotionEvent;
import android.view.View;

public abstract class hhg implements View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final long f18939O000000o = 2000;
    private long O00000Oo;

    public abstract void O000000o();

    public hhg(long j) {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.O00000Oo = System.currentTimeMillis();
        } else if (motionEvent.getAction() == 1 || System.currentTimeMillis() - this.O00000Oo > this.f18939O000000o) {
            this.O00000Oo = System.currentTimeMillis();
            O000000o();
        }
        return true;
    }
}
