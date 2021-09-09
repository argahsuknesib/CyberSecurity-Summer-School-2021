package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

class jf extends je {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1801O000000o = true;
    private static boolean O00000Oo = true;
    private static boolean O00000o0 = true;

    jf() {
    }

    @SuppressLint({"NewApi"})
    public void O000000o(View view, Matrix matrix) {
        if (O00000Oo) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                O00000Oo = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void O00000Oo(View view, Matrix matrix) {
        if (O00000o0) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                O00000o0 = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void O00000o0(View view, Matrix matrix) {
        if (f1801O000000o) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f1801O000000o = false;
            }
        }
    }
}
