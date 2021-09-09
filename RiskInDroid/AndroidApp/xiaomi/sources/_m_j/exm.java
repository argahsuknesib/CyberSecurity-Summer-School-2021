package _m_j;

import android.view.View;
import android.view.ViewGroup;

public final class exm {
    public static int O000000o(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        if (O0000OOo(view)) {
            if (!z) {
                return view.getLeft();
            }
            return O0000Oo0(view) + view.getLeft();
        } else if (z) {
            return view.getRight() - O0000Oo0(view);
        } else {
            return view.getRight();
        }
    }

    public static int O000000o(View view) {
        if (view == null) {
            return 0;
        }
        return bn.O00000Oo((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    public static int O00000Oo(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return bn.O00000Oo(marginLayoutParams) + bn.O000000o(marginLayoutParams);
    }

    public static int O00000o0(View view) {
        if (view == null) {
            return 0;
        }
        return bn.O000000o((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    public static int O00000o(View view) {
        if (view == null) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    private static int O0000Oo0(View view) {
        if (view == null) {
            return 0;
        }
        return view.getPaddingRight();
    }

    public static int O00000oO(View view) {
        if (view == null) {
            return 0;
        }
        return view.getPaddingLeft();
    }

    public static int O00000Oo(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        if (O0000OOo(view)) {
            if (z) {
                return view.getRight() - O00000oO(view);
            }
            return view.getRight();
        } else if (!z) {
            return view.getLeft();
        } else {
            return O00000oO(view) + view.getLeft();
        }
    }

    public static int O00000oo(View view) {
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public static int O0000O0o(View view) {
        return O00000oo(view) + O00000Oo(view);
    }

    public static boolean O0000OOo(View view) {
        return cb.O0000Oo0(view) == 1;
    }
}
