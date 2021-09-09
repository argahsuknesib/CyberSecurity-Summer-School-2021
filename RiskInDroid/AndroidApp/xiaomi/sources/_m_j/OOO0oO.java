package _m_j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public final class OOO0oO {

    /* renamed from: O000000o  reason: collision with root package name */
    private final View f12324O000000o;
    private final OOO0o0 O00000Oo;
    private Oo00 O00000o;
    private int O00000o0 = -1;
    private Oo00 O00000oO;
    private Oo00 O00000oo;

    public OOO0oO(View view) {
        this.f12324O000000o = view;
        this.O00000Oo = OOO0o0.O00000Oo();
    }

    public final void O000000o(AttributeSet attributeSet, int i) {
        Oo O000000o2 = Oo.O000000o(this.f12324O000000o.getContext(), attributeSet, new int[]{16842964, R.attr.backgroundTint, R.attr.backgroundTintMode}, i, 0);
        View view = this.f12324O000000o;
        cb.O000000o(view, view.getContext(), new int[]{16842964, R.attr.backgroundTint, R.attr.backgroundTintMode}, attributeSet, O000000o2.f12340O000000o, i);
        try {
            if (O000000o2.O0000O0o(0)) {
                this.O00000o0 = O000000o2.O0000O0o(0, -1);
                ColorStateList O00000o02 = this.O00000Oo.O00000o0(this.f12324O000000o.getContext(), this.O00000o0);
                if (O00000o02 != null) {
                    O00000Oo(O00000o02);
                }
            }
            if (O000000o2.O0000O0o(1)) {
                cb.O000000o(this.f12324O000000o, O000000o2.O00000oO(1));
            }
            if (O000000o2.O0000O0o(2)) {
                cb.O000000o(this.f12324O000000o, OOOOOo0.O000000o(O000000o2.O000000o(2, -1), null));
            }
        } finally {
            O000000o2.f12340O000000o.recycle();
        }
    }

    public final void O000000o(int i) {
        this.O00000o0 = i;
        OOO0o0 oOO0o0 = this.O00000Oo;
        O00000Oo(oOO0o0 != null ? oOO0o0.O00000o0(this.f12324O000000o.getContext(), i) : null);
        O00000o();
    }

    public final void O000000o() {
        this.O00000o0 = -1;
        O00000Oo(null);
        O00000o();
    }

    public final void O000000o(ColorStateList colorStateList) {
        if (this.O00000oO == null) {
            this.O00000oO = new Oo00();
        }
        Oo00 oo00 = this.O00000oO;
        oo00.f12342O000000o = colorStateList;
        oo00.O00000o = true;
        O00000o();
    }

    public final ColorStateList O00000Oo() {
        Oo00 oo00 = this.O00000oO;
        if (oo00 != null) {
            return oo00.f12342O000000o;
        }
        return null;
    }

    public final void O000000o(PorterDuff.Mode mode) {
        if (this.O00000oO == null) {
            this.O00000oO = new Oo00();
        }
        Oo00 oo00 = this.O00000oO;
        oo00.O00000Oo = mode;
        oo00.O00000o0 = true;
        O00000o();
    }

    public final PorterDuff.Mode O00000o0() {
        Oo00 oo00 = this.O00000oO;
        if (oo00 != null) {
            return oo00.O00000Oo;
        }
        return null;
    }

    public final void O00000o() {
        Drawable background = this.f12324O000000o.getBackground();
        if (background == null) {
            return;
        }
        if (!O00000oO() || !O000000o(background)) {
            Oo00 oo00 = this.O00000oO;
            if (oo00 != null) {
                OOO0o0.O000000o(background, oo00, this.f12324O000000o.getDrawableState());
                return;
            }
            Oo00 oo002 = this.O00000o;
            if (oo002 != null) {
                OOO0o0.O000000o(background, oo002, this.f12324O000000o.getDrawableState());
            }
        }
    }

    private void O00000Oo(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.O00000o == null) {
                this.O00000o = new Oo00();
            }
            Oo00 oo00 = this.O00000o;
            oo00.f12342O000000o = colorStateList;
            oo00.O00000o = true;
        } else {
            this.O00000o = null;
        }
        O00000o();
    }

    private boolean O00000oO() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.O00000o != null : i == 21;
    }

    private boolean O000000o(Drawable drawable) {
        if (this.O00000oo == null) {
            this.O00000oo = new Oo00();
        }
        Oo00 oo00 = this.O00000oo;
        oo00.O000000o();
        ColorStateList O000O0OO = cb.O000O0OO(this.f12324O000000o);
        if (O000O0OO != null) {
            oo00.O00000o = true;
            oo00.f12342O000000o = O000O0OO;
        }
        PorterDuff.Mode O000O0Oo = cb.O000O0Oo(this.f12324O000000o);
        if (O000O0Oo != null) {
            oo00.O00000o0 = true;
            oo00.O00000Oo = O000O0Oo;
        }
        if (!oo00.O00000o && !oo00.O00000o0) {
            return false;
        }
        OOO0o0.O000000o(drawable, oo00, this.f12324O000000o.getDrawableState());
        return true;
    }
}
