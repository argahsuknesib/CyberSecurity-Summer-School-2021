package _m_j;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class oOOO00Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadLocal<Matrix> f2310O000000o = new ThreadLocal<>();
    private static final ThreadLocal<RectF> O00000Oo = new ThreadLocal<>();

    public static void O000000o(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = f2310O000000o.get();
        if (matrix == null) {
            matrix = new Matrix();
            f2310O000000o.set(matrix);
        } else {
            matrix.reset();
        }
        O000000o(viewGroup, view, matrix);
        RectF rectF = O00000Oo.get();
        if (rectF == null) {
            rectF = new RectF();
            O00000Oo.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    private static void O000000o(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            O000000o(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
