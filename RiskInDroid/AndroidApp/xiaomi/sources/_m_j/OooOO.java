package _m_j;

import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.drawerlayout.widget.DrawerLayout;

public final class OooOO implements DrawerLayout.O00000o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f12347O000000o;
    private final O000000o O00000Oo;
    private boolean O00000o;
    private DrawerArrowDrawable O00000o0;
    private final int O00000oO;
    private final int O00000oo;

    public interface O000000o {
        void O000000o(int i);
    }

    public final void onDrawerStateChanged(int i) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void onDrawerSlide(View view, float f) {
        if (this.O00000o) {
            O000000o(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            O000000o(0.0f);
        }
    }

    public final void onDrawerOpened(View view) {
        O000000o(1.0f);
        if (this.f12347O000000o) {
            O000000o(this.O00000oo);
        }
    }

    public final void onDrawerClosed(View view) {
        O000000o(0.0f);
        if (this.f12347O000000o) {
            O000000o(this.O00000oO);
        }
    }

    private void O000000o(int i) {
        this.O00000Oo.O000000o(i);
    }

    private void O000000o(float f) {
        if (f == 1.0f) {
            this.O00000o0.O000000o(true);
        } else if (f == 0.0f) {
            this.O00000o0.O000000o(false);
        }
        this.O00000o0.O000000o(f);
    }
}
