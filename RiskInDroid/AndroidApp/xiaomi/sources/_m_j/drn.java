package _m_j;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(14)
public final class drn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O000000o f14876O000000o;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final Field f14877O000000o = drl.O000000o(View.class, "mViewFlags");
        private static final Field O00000Oo = drl.O000000o(View.class, "mLayoutParams");
        private static final Method O00000o0 = drl.O00000Oo(View.class, "setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);

        public Rect O000000o(View view) {
            return null;
        }

        public void O000000o(View view, Matrix matrix) {
        }

        public void O000000o(View view, Rect rect) {
        }

        O000000o() {
        }

        public void O000000o(View view, int i, int i2, int i3, int i4) {
            drl.O000000o(view, O00000o0, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }

        public static void O000000o(View view, ViewGroup.LayoutParams layoutParams) {
            drl.O000000o(view, O00000Oo, layoutParams);
        }
    }

    @TargetApi(16)
    static class O00000Oo extends O000000o {
        O00000Oo() {
        }
    }

    @TargetApi(17)
    static class O00000o0 extends O00000Oo {
        O00000o0() {
        }
    }

    @TargetApi(18)
    static class O00000o extends O00000o0 {
        O00000o() {
        }

        public final void O000000o(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        public final Rect O000000o(View view) {
            return view.getClipBounds();
        }
    }

    @TargetApi(19)
    static class O0000O0o extends O00000o {
        O0000O0o() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f14876O000000o = new drp();
        } else if (i >= 21) {
            f14876O000000o = new dro();
        } else if (i >= 19) {
            f14876O000000o = new O0000O0o();
        } else if (i >= 18) {
            f14876O000000o = new O00000o();
        } else if (i >= 17) {
            f14876O000000o = new O00000o0();
        } else if (i >= 16) {
            f14876O000000o = new O00000Oo();
        } else {
            f14876O000000o = new O000000o();
        }
    }

    public static void O000000o(View view, Rect rect) {
        f14876O000000o.O000000o(view, rect);
    }

    public static Rect O000000o(View view) {
        return f14876O000000o.O000000o(view);
    }

    public static void O000000o(View view, Matrix matrix) {
        f14876O000000o.O000000o(view, matrix);
    }

    public static void O000000o(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            f14876O000000o.O000000o(view, i, i2, i3, i4);
        }
    }

    public static void O000000o(View view, ViewGroup.LayoutParams layoutParams) {
        O000000o.O000000o(view, layoutParams);
    }
}
