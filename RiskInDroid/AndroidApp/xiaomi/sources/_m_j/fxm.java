package _m_j;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class fxm {
    private static volatile fxm O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    View f17375O000000o;
    FrameLayout O00000Oo;
    FrameLayout.LayoutParams O00000o;
    int O00000o0;
    public boolean O00000oO = false;

    public static fxm O000000o() {
        if (O00000oo == null) {
            synchronized (fxm.class) {
                if (O00000oo == null) {
                    O00000oo = new fxm();
                }
            }
        }
        return O00000oo;
    }

    public final void O000000o(Activity activity) {
        this.O00000Oo = (FrameLayout) activity.findViewById(16908290);
        this.f17375O000000o = this.O00000Oo.getChildAt(0);
        this.f17375O000000o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class _m_j.fxm.AnonymousClass1 */

            public final void onGlobalLayout() {
                if (fxm.this.O00000oO) {
                    fxm fxm = fxm.this;
                    if (fxm.f17375O000000o != null && fxm.O00000o != null) {
                        Rect rect = new Rect();
                        fxm.f17375O000000o.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom;
                        if (i != fxm.O00000o0) {
                            int height = fxm.f17375O000000o.getRootView().getHeight();
                            int i2 = height - i;
                            if (i2 > height / 4) {
                                fxm.O00000o.height = height - i2;
                            } else {
                                fxm.O00000o.height = fxm.O00000Oo.getHeight();
                            }
                            fxm.f17375O000000o.requestLayout();
                            fxm.O00000o0 = i;
                        }
                    }
                }
            }
        });
        this.O00000o = (FrameLayout.LayoutParams) this.f17375O000000o.getLayoutParams();
    }

    private fxm() {
    }

    public final void O00000Oo() {
        this.f17375O000000o = null;
        this.O00000o = null;
        this.O00000Oo = null;
        O00000oo = null;
    }
}
