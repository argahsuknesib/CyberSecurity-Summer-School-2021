package com.xiaomi.smarthome.library.common.floatingview;

import _m_j.gns;
import _m_j.gnu;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.application.CommonApplication;
import java.lang.ref.WeakReference;

public class FloatingMagnetView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f9123O000000o;
    float O00000Oo;
    float O00000o;
    float O00000o0;
    float O00000oO;
    gnu O00000oo;
    long O0000O0o;
    protected O000000o O0000OOo;
    int O0000Oo;
    protected int O0000Oo0;
    int O0000OoO;
    public boolean O0000Ooo;
    protected Handler O0000o0;
    float O0000o00;
    public WeakReference<Activity> O0000o0O;
    private final int O0000o0o;

    public void setMagnetViewListener(gnu gnu) {
        this.O00000oo = gnu;
    }

    public FloatingMagnetView(Context context) {
        this(context, null);
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9123O000000o = 1;
        this.O0000o0o = 150;
        this.O0000Ooo = true;
        this.O0000o0 = new Handler(Looper.getMainLooper());
        this.O0000OOo = new O000000o();
        Context context2 = getContext();
        int identifier = context2.getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.O0000OoO = identifier > 0 ? context2.getResources().getDimensionPixelSize(identifier) : 0;
        setClickable(true);
        O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        this.O0000Oo0 = CommonApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
        this.O0000Oo = CommonApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
    }

    public final void O00000Oo() {
        O000000o(O00000o0(), false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void O000000o(boolean z, boolean z2) {
        float f;
        float measuredWidth = z ? 1.0f : (float) ((this.O0000Oo0 - getMeasuredWidth()) - 1);
        float y = getY();
        if (!z2) {
            f = this.O0000o00;
            if (f != 0.0f) {
                this.O0000o00 = 0.0f;
                this.O0000OOo.O000000o(measuredWidth, Math.min(Math.max(0.0f, f), (float) (this.O0000Oo - getHeight())));
            }
        }
        f = y;
        this.O0000OOo.O000000o(measuredWidth, Math.min(Math.max(0.0f, f), (float) (this.O0000Oo - getHeight())));
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o0() {
        int i = this.O0000Oo0 / 2;
        FloatPositionEntity O00000oO2 = gns.O00000oO();
        boolean z = true;
        if (getX() > 0.0f) {
            if (getX() >= ((float) i)) {
                z = false;
            }
            this.O0000Ooo = z;
        } else {
            if (O00000oO2.x >= ((float) i)) {
                z = false;
            }
            this.O0000Ooo = z;
        }
        return this.O0000Ooo;
    }

    public class O000000o implements Runnable {
        private float O00000Oo;
        private long O00000o;
        private float O00000o0;

        protected O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(float f, float f2) {
            this.O00000Oo = f;
            this.O00000o0 = f2;
            gns.O000000o(f, f2);
            this.O00000o = System.currentTimeMillis();
            FloatingMagnetView.this.O0000o0.post(this);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        public final void run() {
            if (FloatingMagnetView.this.getRootView() != null && FloatingMagnetView.this.getRootView().getParent() != null) {
                float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O00000o)) / 400.0f);
                FloatingMagnetView floatingMagnetView = FloatingMagnetView.this;
                floatingMagnetView.setX(floatingMagnetView.getX() + ((this.O00000Oo - FloatingMagnetView.this.getX()) * min));
                floatingMagnetView.setY(floatingMagnetView.getY() + ((this.O00000o0 - FloatingMagnetView.this.getY()) * min));
                if (min < 1.0f) {
                    FloatingMagnetView.this.O0000o0.post(this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void O000000o() {
            FloatingMagnetView.this.O0000o0.removeCallbacks(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            final boolean z = configuration.orientation == 2;
            if (z) {
                this.O0000o00 = getY();
            }
            ((ViewGroup) getParent()).post(new Runnable() {
                /* class com.xiaomi.smarthome.library.common.floatingview.FloatingMagnetView.AnonymousClass1 */

                public final void run() {
                    FloatingMagnetView.this.O000000o();
                    FloatingMagnetView floatingMagnetView = FloatingMagnetView.this;
                    floatingMagnetView.O000000o(floatingMagnetView.O0000Ooo, z);
                }
            });
        }
    }

    public Activity getAttachActivity() {
        WeakReference<Activity> weakReference = this.O0000o0O;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.O0000o0O.get();
    }
}
