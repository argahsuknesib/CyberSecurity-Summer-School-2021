package _m_j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class ccc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13617O000000o = "ccc";
    public final Context O00000Oo;
    public boolean O00000o;
    public final O000000o O00000o0;
    public MotionEvent O00000oO;
    public float O00000oo;
    public float O0000O0o;
    public float O0000OOo;
    public float O0000Oo;
    public float O0000Oo0;
    public float O0000OoO;
    public float O0000Ooo;
    public long O0000o;
    public float O0000o0;
    public float O0000o00;
    public float O0000o0O;
    public float O0000o0o;
    public float O0000oO;
    public final float O0000oO0;
    public float O0000oOO;
    public boolean O0000oOo;
    private MotionEvent O0000oo0;

    public interface O000000o {
        boolean O000000o();

        boolean O000000o(ccc ccc, float f, float f2);

        void O00000Oo();
    }

    public ccc(Context context, O000000o o000000o) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O00000Oo = context;
        this.O00000o0 = o000000o;
        this.O0000oO0 = (float) viewConfiguration.getScaledEdgeSlop();
    }

    public static float O000000o(MotionEvent motionEvent) {
        return motionEvent.getX(Math.min(1, motionEvent.getPointerCount() - 1)) + (motionEvent.getRawX() - motionEvent.getX());
    }

    public static float O00000Oo(MotionEvent motionEvent) {
        return motionEvent.getY(Math.min(1, motionEvent.getPointerCount() - 1)) + (motionEvent.getRawY() - motionEvent.getY());
    }

    public final void O00000o0(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.O0000oo0;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.O0000oo0 = MotionEvent.obtain(motionEvent);
        this.O0000Ooo = -1.0f;
        this.O0000o00 = -1.0f;
        this.O0000o0 = -1.0f;
        MotionEvent motionEvent3 = this.O00000oO;
        float x = motionEvent3.getX(0);
        float y = motionEvent3.getY(0);
        float x2 = motionEvent3.getX(1);
        float y2 = motionEvent3.getY(1);
        float x3 = motionEvent.getX(0);
        float y3 = motionEvent.getY(0);
        float x4 = motionEvent.getX(1);
        this.O0000OOo = x2 - x;
        this.O0000Oo0 = y2 - y;
        this.O0000Oo = x4 - x3;
        this.O0000OoO = motionEvent.getY(1) - y3;
        this.O0000o = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.O0000o0O = motionEvent.getPressure(0) + motionEvent.getPressure(1);
        this.O0000o0o = motionEvent3.getPressure(0) + motionEvent3.getPressure(1);
    }

    public final void O000000o() {
        MotionEvent motionEvent = this.O00000oO;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.O00000oO = null;
        }
        MotionEvent motionEvent2 = this.O0000oo0;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.O0000oo0 = null;
        }
        this.O0000oOo = false;
        this.O00000o = false;
    }
}
