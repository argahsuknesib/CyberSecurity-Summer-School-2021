package _m_j;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

public final class jd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Property<View, Float> f1771O000000o = new Property<View, Float>(Float.class, "translationAlpha") {
        /* class _m_j.jd.AnonymousClass1 */

        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(jd.O00000o0((View) obj));
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            jd.O000000o((View) obj, ((Float) obj2).floatValue());
        }
    };
    public static final Property<View, Rect> O00000Oo = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* class _m_j.jd.AnonymousClass2 */

        public final /* synthetic */ Object get(Object obj) {
            return cb.O000OO00((View) obj);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            cb.O000000o((View) obj, (Rect) obj2);
        }
    };
    private static final jj O00000o0;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            O00000o0 = new ji();
        } else if (Build.VERSION.SDK_INT >= 23) {
            O00000o0 = new jh();
        } else if (Build.VERSION.SDK_INT >= 22) {
            O00000o0 = new jg();
        } else if (Build.VERSION.SDK_INT >= 21) {
            O00000o0 = new jf();
        } else if (Build.VERSION.SDK_INT >= 19) {
            O00000o0 = new je();
        } else {
            O00000o0 = new jj();
        }
    }

    public static jc O000000o(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new jb(view);
        }
        return ja.O00000o0(view);
    }

    public static jn O00000Oo(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new jm(view);
        }
        return new jl(view.getWindowToken());
    }

    public static void O000000o(View view, float f) {
        O00000o0.O000000o(view, f);
    }

    public static float O00000o0(View view) {
        return O00000o0.O000000o(view);
    }

    public static void O00000o(View view) {
        O00000o0.O00000Oo(view);
    }

    public static void O00000oO(View view) {
        O00000o0.O00000o0(view);
    }

    public static void O000000o(View view, int i) {
        O00000o0.O000000o(view, i);
    }

    public static void O000000o(View view, Matrix matrix) {
        O00000o0.O000000o(view, matrix);
    }

    public static void O00000Oo(View view, Matrix matrix) {
        O00000o0.O00000Oo(view, matrix);
    }

    public static void O00000o0(View view, Matrix matrix) {
        O00000o0.O00000o0(view, matrix);
    }

    public static void O000000o(View view, int i, int i2, int i3, int i4) {
        O00000o0.O000000o(view, i, i2, i3, i4);
    }
}
