package _m_j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

class jh extends jg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1833O000000o = true;

    jh() {
    }

    @SuppressLint({"NewApi"})
    public void O000000o(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.O000000o(view, i);
        } else if (f1833O000000o) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f1833O000000o = false;
            }
        }
    }
}
