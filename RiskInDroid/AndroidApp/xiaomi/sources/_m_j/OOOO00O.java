package _m_j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public final class OOOO00O {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ImageView f12326O000000o;
    private Oo00 O00000Oo;
    private Oo00 O00000o;
    private Oo00 O00000o0;

    public OOOO00O(ImageView imageView) {
        this.f12326O000000o = imageView;
    }

    public final void O000000o(AttributeSet attributeSet, int i) {
        int O0000O0o;
        Oo O000000o2 = Oo.O000000o(this.f12326O000000o.getContext(), attributeSet, new int[]{16843033, R.attr.srcCompat, R.attr.tint, R.attr.tintMode}, i, 0);
        ImageView imageView = this.f12326O000000o;
        cb.O000000o(imageView, imageView.getContext(), new int[]{16843033, R.attr.srcCompat, R.attr.tint, R.attr.tintMode}, attributeSet, O000000o2.f12340O000000o, i);
        try {
            Drawable drawable = this.f12326O000000o.getDrawable();
            if (!(drawable != null || (O0000O0o = O000000o2.O0000O0o(1, -1)) == -1 || (drawable = OO0000o.O00000Oo(this.f12326O000000o.getContext(), O0000O0o)) == null)) {
                this.f12326O000000o.setImageDrawable(drawable);
            }
            if (drawable != null) {
                OOOOOo0.O00000Oo(drawable);
            }
            if (O000000o2.O0000O0o(2)) {
                cu.O000000o(this.f12326O000000o, O000000o2.O00000oO(2));
            }
            if (O000000o2.O0000O0o(3)) {
                cu.O000000o(this.f12326O000000o, OOOOOo0.O000000o(O000000o2.O000000o(3, -1), null));
            }
        } finally {
            O000000o2.f12340O000000o.recycle();
        }
    }

    public final void O000000o(int i) {
        if (i != 0) {
            Drawable O00000Oo2 = OO0000o.O00000Oo(this.f12326O000000o.getContext(), i);
            if (O00000Oo2 != null) {
                OOOOOo0.O00000Oo(O00000Oo2);
            }
            this.f12326O000000o.setImageDrawable(O00000Oo2);
        } else {
            this.f12326O000000o.setImageDrawable(null);
        }
        O00000o();
    }

    public final boolean O000000o() {
        return Build.VERSION.SDK_INT < 21 || !(this.f12326O000000o.getBackground() instanceof RippleDrawable);
    }

    public final void O000000o(ColorStateList colorStateList) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new Oo00();
        }
        Oo00 oo00 = this.O00000o0;
        oo00.f12342O000000o = colorStateList;
        oo00.O00000o = true;
        O00000o();
    }

    public final ColorStateList O00000Oo() {
        Oo00 oo00 = this.O00000o0;
        if (oo00 != null) {
            return oo00.f12342O000000o;
        }
        return null;
    }

    public final void O000000o(PorterDuff.Mode mode) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new Oo00();
        }
        Oo00 oo00 = this.O00000o0;
        oo00.O00000Oo = mode;
        oo00.O00000o0 = true;
        O00000o();
    }

    public final PorterDuff.Mode O00000o0() {
        Oo00 oo00 = this.O00000o0;
        if (oo00 != null) {
            return oo00.O00000Oo;
        }
        return null;
    }

    public final void O00000o() {
        Drawable drawable = this.f12326O000000o.getDrawable();
        if (drawable != null) {
            OOOOOo0.O00000Oo(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!O00000oO() || !O000000o(drawable)) {
            Oo00 oo00 = this.O00000o0;
            if (oo00 != null) {
                OOO0o0.O000000o(drawable, oo00, this.f12326O000000o.getDrawableState());
                return;
            }
            Oo00 oo002 = this.O00000Oo;
            if (oo002 != null) {
                OOO0o0.O000000o(drawable, oo002, this.f12326O000000o.getDrawableState());
            }
        }
    }

    private boolean O00000oO() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.O00000Oo != null : i == 21;
    }

    private boolean O000000o(Drawable drawable) {
        if (this.O00000o == null) {
            this.O00000o = new Oo00();
        }
        Oo00 oo00 = this.O00000o;
        oo00.O000000o();
        ColorStateList O000000o2 = cu.O000000o(this.f12326O000000o);
        if (O000000o2 != null) {
            oo00.O00000o = true;
            oo00.f12342O000000o = O000000o2;
        }
        PorterDuff.Mode O00000Oo2 = cu.O00000Oo(this.f12326O000000o);
        if (O00000Oo2 != null) {
            oo00.O00000o0 = true;
            oo00.O00000Oo = O00000Oo2;
        }
        if (!oo00.O00000o && !oo00.O00000o0) {
            return false;
        }
        OOO0o0.O000000o(drawable, oo00, this.f12326O000000o.getDrawableState());
        return true;
    }
}
