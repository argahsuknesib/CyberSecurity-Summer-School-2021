package _m_j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.View;

public final class o0O00o00 implements o0O0oo0o {
    public final void O000000o() {
    }

    public final void O000000o(o0oO0O0o o0oo0o0o, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        o0oo0o0o.O000000o(new o0O0O0Oo(colorStateList, f));
        View O00000o = o0oo0o0o.O00000o();
        O00000o.setClipToOutline(true);
        O00000o.setElevation(f2);
        O00000Oo(o0oo0o0o, f3);
    }

    public final void O000000o(o0oO0O0o o0oo0o0o, float f) {
        o0O0O0Oo O0000Oo = O0000Oo(o0oo0o0o);
        if (f != O0000Oo.f2235O000000o) {
            O0000Oo.f2235O000000o = f;
            O0000Oo.O000000o((Rect) null);
            O0000Oo.invalidateSelf();
        }
    }

    public final void O00000Oo(o0oO0O0o o0oo0o0o, float f) {
        O0000Oo(o0oo0o0o).O000000o(f, o0oo0o0o.O000000o(), o0oo0o0o.O00000Oo());
        O00000oo(o0oo0o0o);
    }

    public final float O000000o(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000Oo;
    }

    public final float O00000o(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).f2235O000000o;
    }

    public final void O00000o0(o0oO0O0o o0oo0o0o, float f) {
        o0oo0o0o.O00000o().setElevation(f);
    }

    public final float O00000oO(o0oO0O0o o0oo0o0o) {
        return o0oo0o0o.O00000o().getElevation();
    }

    public final void O00000oo(o0oO0O0o o0oo0o0o) {
        if (!o0oo0o0o.O000000o()) {
            o0oo0o0o.O000000o(0, 0, 0, 0);
            return;
        }
        float f = O0000Oo(o0oo0o0o).O00000Oo;
        float f2 = O0000Oo(o0oo0o0o).f2235O000000o;
        int ceil = (int) Math.ceil((double) o0O0O0o0.O00000Oo(f, f2, o0oo0o0o.O00000Oo()));
        int ceil2 = (int) Math.ceil((double) o0O0O0o0.O000000o(f, f2, o0oo0o0o.O00000Oo()));
        o0oo0o0o.O000000o(ceil, ceil2, ceil, ceil2);
    }

    public final void O000000o(o0oO0O0o o0oo0o0o, ColorStateList colorStateList) {
        o0O0O0Oo O0000Oo = O0000Oo(o0oo0o0o);
        O0000Oo.O000000o(colorStateList);
        O0000Oo.invalidateSelf();
    }

    public final ColorStateList O0000Oo0(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000o0;
    }

    private static o0O0O0Oo O0000Oo(o0oO0O0o o0oo0o0o) {
        return (o0O0O0Oo) o0oo0o0o.O00000o0();
    }

    public final float O00000Oo(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).f2235O000000o * 2.0f;
    }

    public final float O00000o0(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).f2235O000000o * 2.0f;
    }

    public final void O0000O0o(o0oO0O0o o0oo0o0o) {
        O00000Oo(o0oo0o0o, O0000Oo(o0oo0o0o).O00000Oo);
    }

    public final void O0000OOo(o0oO0O0o o0oo0o0o) {
        O00000Oo(o0oo0o0o, O0000Oo(o0oo0o0o).O00000Oo);
    }
}
