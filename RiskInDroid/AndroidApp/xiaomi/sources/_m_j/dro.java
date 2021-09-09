package _m_j;

import _m_j.drn;
import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@TargetApi(21)
class dro extends drn.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Class f14878O000000o;
    private static final Method O00000Oo;
    private static final Method O00000o = drl.O000000o(View.class, "transformMatrixToGlobal", Matrix.class);
    private static final Method O00000o0 = drl.O000000o(f14878O000000o, "removeGhost", View.class);
    private static final Method O00000oO = drl.O000000o(View.class, "transformMatrixToLocal", Matrix.class);
    private static final Method O00000oo = drl.O000000o(View.class, "setAnimationMatrix", Matrix.class);

    dro() {
    }

    static {
        Class<?> O000000o2 = drl.O000000o("android.view.GhostView");
        f14878O000000o = O000000o2;
        O00000Oo = drl.O000000o(O000000o2, "addGhost", View.class, ViewGroup.class, Matrix.class);
    }

    public final void O000000o(View view, Matrix matrix) {
        drl.O000000o(view, O00000oo, matrix);
    }
}
