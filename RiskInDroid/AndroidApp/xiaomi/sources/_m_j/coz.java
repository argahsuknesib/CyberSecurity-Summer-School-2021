package _m_j;

import android.view.View;
import android.view.ViewGroup;

public final class coz {
    public static int O000000o(View view) {
        if (view == null) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    public static int O00000Oo(View view) {
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public static int O00000o0(View view) {
        return O00000Oo(view) + O0000OOo(view);
    }

    public static int O000000o(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        return O0000Oo0(view) ? z ? view.getRight() - O00000o(view) : view.getRight() : z ? view.getLeft() + O00000o(view) : view.getLeft();
    }

    public static int O00000Oo(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        return O0000Oo0(view) ? z ? view.getLeft() + O0000Oo(view) : view.getLeft() : z ? view.getRight() - O0000Oo(view) : view.getRight();
    }

    public static int O00000o(View view) {
        if (view == null) {
            return 0;
        }
        return cb.O0000OoO(view);
    }

    private static int O0000Oo(View view) {
        if (view == null) {
            return 0;
        }
        return cb.O0000Ooo(view);
    }

    public static int O00000oO(View view) {
        return view.getPaddingLeft() + view.getPaddingRight();
    }

    public static int O00000oo(View view) {
        if (view == null) {
            return 0;
        }
        return bn.O000000o((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    public static int O0000O0o(View view) {
        if (view == null) {
            return 0;
        }
        return bn.O00000Oo((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    public static int O0000OOo(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return bn.O000000o(marginLayoutParams) + bn.O00000Oo(marginLayoutParams);
    }

    public static boolean O0000Oo0(View view) {
        return cb.O0000Oo0(view) == 1;
    }
}
