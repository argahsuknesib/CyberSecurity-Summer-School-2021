package _m_j;

import android.graphics.Matrix;
import android.view.View;

final class ji extends jh {
    ji() {
    }

    public final void O000000o(View view, float f) {
        view.setTransitionAlpha(f);
    }

    public final float O000000o(View view) {
        return view.getTransitionAlpha();
    }

    public final void O000000o(View view, int i) {
        view.setTransitionVisibility(i);
    }

    public final void O000000o(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    public final void O000000o(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public final void O00000Oo(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    public final void O00000o0(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }
}
