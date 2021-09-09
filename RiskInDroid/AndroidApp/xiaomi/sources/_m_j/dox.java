package _m_j;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dox {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f14819O000000o = true;
    protected boolean O00000Oo = false;
    protected int O00000o;
    protected int O00000o0;
    protected int O00000oO;
    protected int O00000oo;
    protected dpb O0000O0o;
    protected O000000o O0000OOo;

    public dox(dpb dpb) {
        this.O0000O0o = dpb;
        this.O0000OOo = new O000000o();
        final View holderView = dpb.getHolderView();
        final dpf virtualView = dpb.getVirtualView();
        holderView.setOnTouchListener(new View.OnTouchListener() {
            /* class _m_j.dox.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                int action = motionEvent.getAction();
                if (action == 0) {
                    dox dox = dox.this;
                    dox.f14819O000000o = false;
                    dox.O00000Oo = false;
                    dox.O00000oO = (int) motionEvent.getX();
                    dox.this.O00000oo = (int) motionEvent.getY();
                    dox dox2 = dox.this;
                    dox2.O00000o0 = dox2.O00000oO;
                    dox dox3 = dox.this;
                    dox3.O00000o = dox3.O00000oo;
                    if (!virtualView.O000000o(dox.this.O00000oO, dox.this.O00000oo)) {
                        return false;
                    }
                    Handler handler = holderView.getHandler();
                    handler.removeCallbacks(dox.this.O0000OOo);
                    dox.this.O0000OOo.O000000o(dox.this.O0000O0o.getVirtualView());
                    dox.this.O0000OOo.O000000o(holderView);
                    handler.postDelayed(dox.this.O0000OOo, 500);
                    virtualView.O000000o(view, motionEvent);
                    return true;
                } else if (action == 1) {
                    dpf virtualView = dox.this.O0000O0o.getVirtualView();
                    if (virtualView == null || dox.this.O00000Oo) {
                        z = false;
                    } else {
                        z = virtualView.O000000o(dox.this.O00000oO, dox.this.O00000oo, false);
                        if (z) {
                            holderView.playSoundEffect(0);
                        }
                    }
                    virtualView.O000000o(view, motionEvent);
                    dox.this.f14819O000000o = true;
                    return z;
                } else if (action == 2) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (Math.sqrt(Math.pow((double) (x - dox.this.O00000o0), 2.0d) + Math.pow((double) (y - dox.this.O00000o), 2.0d)) > ((double) VafContext.O00000Oo)) {
                        holderView.removeCallbacks(dox.this.O0000OOo);
                    }
                    dox dox4 = dox.this;
                    dox4.O00000o0 = x;
                    dox4.O00000o = y;
                    virtualView.O000000o(view, motionEvent);
                    return false;
                } else if (action != 3) {
                    return false;
                } else {
                    virtualView.O000000o(view, motionEvent);
                    dox.this.f14819O000000o = true;
                    return false;
                }
            }
        });
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        protected dpf f14821O000000o;
        protected View O00000Oo;

        O000000o() {
        }

        public final void O000000o(View view) {
            this.O00000Oo = view;
        }

        public final void O000000o(dpf dpf) {
            this.f14821O000000o = dpf;
        }

        public final void run() {
            dpf dpf;
            View view;
            if (!dox.this.f14819O000000o && (dpf = this.f14821O000000o) != null && dpf.O000000o(dox.this.O00000oO, dox.this.O00000oo, true) && (view = this.O00000Oo) != null) {
                dox.this.O00000Oo = true;
                view.performHapticFeedback(0);
            }
        }
    }
}
