package _m_j;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class deh extends dec<deh> {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f14546O000000o;
    public boolean O00000Oo;

    public deh() {
        this.O0000Ooo = true;
    }

    public final boolean O00000Oo(dec dec) {
        return super.O00000Oo(dec);
    }

    public final boolean O00000o(dec dec) {
        if (dec instanceof deh) {
            deh deh = (deh) dec;
            if (deh.O0000O0o == 4 && deh.O00000Oo) {
                return false;
            }
        }
        boolean z = !this.O00000Oo;
        int i = this.O0000O0o;
        int i2 = dec.O0000O0o;
        if ((i != 4 || i2 != 4 || !z) && i == 4 && z) {
            return true;
        }
        return false;
    }

    public final boolean O00000oO(dec dec) {
        return !this.O00000Oo;
    }

    private static boolean O000000o(View view, MotionEvent motionEvent) {
        return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        this.O00000oo.onTouchEvent(obtain);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(MotionEvent motionEvent) {
        View view = this.O00000oo;
        int i = this.O0000O0o;
        if (motionEvent.getActionMasked() == 1) {
            view.onTouchEvent(motionEvent);
            if ((i == 0 || i == 2) && view.isPressed()) {
                O00000oO();
            }
            O0000O0o();
        } else if (i == 0 || i == 2) {
            if (this.f14546O000000o) {
                O000000o(view, motionEvent);
                view.onTouchEvent(motionEvent);
                O00000oO();
            } else if (O000000o(view, motionEvent)) {
                view.onTouchEvent(motionEvent);
                O00000oO();
            } else if (i != 2) {
                O00000oo();
            }
        } else if (i == 4) {
            view.onTouchEvent(motionEvent);
        }
    }
}
