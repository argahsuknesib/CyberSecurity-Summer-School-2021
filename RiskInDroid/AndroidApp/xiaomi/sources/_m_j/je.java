package _m_j;

import android.annotation.SuppressLint;
import android.view.View;

class je extends jj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1783O000000o = true;

    public final void O00000Oo(View view) {
    }

    public final void O00000o0(View view) {
    }

    je() {
    }

    @SuppressLint({"NewApi"})
    public void O000000o(View view, float f) {
        if (f1783O000000o) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f1783O000000o = false;
            }
        }
        view.setAlpha(f);
    }

    @SuppressLint({"NewApi"})
    public float O000000o(View view) {
        if (f1783O000000o) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1783O000000o = false;
            }
        }
        return view.getAlpha();
    }
}
