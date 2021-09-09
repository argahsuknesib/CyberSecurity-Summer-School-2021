package _m_j;

import android.view.MotionEvent;

public final class dek {

    /* renamed from: O000000o  reason: collision with root package name */
    long f14549O000000o;
    long O00000Oo;
    double O00000o;
    double O00000o0;
    public float O00000oO;
    public float O00000oo;
    boolean O0000O0o;
    int[] O0000OOo = new int[2];
    O000000o O0000Oo0;

    public interface O000000o {
        void O000000o();

        boolean O000000o(dek dek);
    }

    public dek(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(MotionEvent motionEvent) {
        this.O00000Oo = this.f14549O000000o;
        this.f14549O000000o = motionEvent.getEventTime();
        int findPointerIndex = motionEvent.findPointerIndex(this.O0000OOo[0]);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.O0000OOo[1]);
        float x = motionEvent.getX(findPointerIndex);
        float y = motionEvent.getY(findPointerIndex);
        float x2 = motionEvent.getX(findPointerIndex2);
        float y2 = motionEvent.getY(findPointerIndex2);
        float f = y2 - y;
        this.O00000oO = (x + x2) * 0.5f;
        this.O00000oo = (y + y2) * 0.5f;
        double d = -Math.atan2((double) f, (double) (x2 - x));
        if (Double.isNaN(this.O00000o0)) {
            this.O00000o = 0.0d;
        } else {
            this.O00000o = this.O00000o0 - d;
        }
        this.O00000o0 = d;
        double d2 = this.O00000o;
        if (d2 > 3.141592653589793d) {
            this.O00000o = d2 - 3.141592653589793d;
        } else if (d2 < -3.141592653589793d) {
            this.O00000o = d2 + 3.141592653589793d;
        }
        double d3 = this.O00000o;
        if (d3 > 1.5707963267948966d) {
            this.O00000o = d3 - 3.141592653589793d;
        } else if (d3 < -1.5707963267948966d) {
            this.O00000o = d3 + 3.141592653589793d;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O0000O0o) {
            this.O0000O0o = false;
            O000000o o000000o = this.O0000Oo0;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
    }
}
