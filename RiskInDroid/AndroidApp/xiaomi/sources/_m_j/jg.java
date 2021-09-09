package _m_j;

import android.annotation.SuppressLint;
import android.view.View;

class jg extends jf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1810O000000o = true;

    jg() {
    }

    @SuppressLint({"NewApi"})
    public void O000000o(View view, int i, int i2, int i3, int i4) {
        if (f1810O000000o) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f1810O000000o = false;
            }
        }
    }
}
