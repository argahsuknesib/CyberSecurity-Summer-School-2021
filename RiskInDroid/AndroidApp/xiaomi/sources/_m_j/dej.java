package _m_j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

public class dej extends dec<dej> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ScaleGestureDetector f14547O000000o;
    public double O00000Oo;
    public double O0000oOO;
    public float O0000oOo;
    private ScaleGestureDetector.OnScaleGestureListener O0000oo = new ScaleGestureDetector.OnScaleGestureListener() {
        /* class _m_j.dej.AnonymousClass1 */

        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            double d = dej.this.O00000Oo;
            dej dej = dej.this;
            double d2 = dej.O00000Oo;
            double scaleFactor = (double) scaleGestureDetector.getScaleFactor();
            Double.isNaN(scaleFactor);
            dej.O00000Oo = d2 * scaleFactor;
            long timeDelta = scaleGestureDetector.getTimeDelta();
            if (timeDelta > 0) {
                dej dej2 = dej.this;
                double d3 = dej2.O00000Oo - d;
                double d4 = (double) timeDelta;
                Double.isNaN(d4);
                dej2.O0000oOO = d3 / d4;
            }
            if (Math.abs(dej.this.O0000oOo - scaleGestureDetector.getCurrentSpan()) < dej.this.O0000oo0 || dej.this.O0000O0o != 2) {
                return true;
            }
            dej.this.O00000oO();
            return true;
        }

        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            dej.this.O0000oOo = scaleGestureDetector.getCurrentSpan();
            return true;
        }
    };
    public float O0000oo0;

    public dej() {
        this.O0000Ooo = false;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.f14547O000000o = null;
        this.O0000oOO = 0.0d;
        this.O00000Oo = 1.0d;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(MotionEvent motionEvent) {
        if (this.O0000O0o == 0) {
            Context context = this.O00000oo.getContext();
            this.O0000oOO = 0.0d;
            this.O00000Oo = 1.0d;
            this.f14547O000000o = new ScaleGestureDetector(context, this.O0000oo);
            this.O0000oo0 = (float) ViewConfiguration.get(context).getScaledTouchSlop();
            O00000oo();
        }
        ScaleGestureDetector scaleGestureDetector = this.f14547O000000o;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        if (motionEvent.getActionMasked() == 6) {
            pointerCount--;
        }
        if (this.O0000O0o == 4 && pointerCount < 2) {
            O0000O0o();
        } else if (motionEvent.getActionMasked() == 1) {
            O00000o();
        }
    }
}
