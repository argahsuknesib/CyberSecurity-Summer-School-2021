package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.xiaomi.smarthome.R;

public final class OOO0o00 {

    /* renamed from: O000000o  reason: collision with root package name */
    public ColorStateList f12323O000000o = null;
    public PorterDuff.Mode O00000Oo = null;
    private boolean O00000o = false;
    private final CompoundButton O00000o0;
    private boolean O00000oO = false;
    private boolean O00000oo;

    public OOO0o00(CompoundButton compoundButton) {
        this.O00000o0 = compoundButton;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043 A[SYNTHETIC, Splitter:B:11:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065 A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075 A[Catch:{ all -> 0x008a }] */
    public final void O000000o(AttributeSet attributeSet, int i) {
        int O0000O0o;
        int O0000O0o2;
        Oo O000000o2 = Oo.O000000o(this.O00000o0.getContext(), attributeSet, new int[]{16843015, R.attr.buttonCompat, R.attr.buttonTint, R.attr.buttonTintMode}, i, 0);
        CompoundButton compoundButton = this.O00000o0;
        cb.O000000o(compoundButton, compoundButton.getContext(), new int[]{16843015, R.attr.buttonCompat, R.attr.buttonTint, R.attr.buttonTintMode}, attributeSet, O000000o2.f12340O000000o, i);
        boolean z = true;
        try {
            if (O000000o2.O0000O0o(1) && (O0000O0o2 = O000000o2.O0000O0o(1, 0)) != 0) {
                try {
                    this.O00000o0.setButtonDrawable(OO0000o.O00000Oo(this.O00000o0.getContext(), O0000O0o2));
                } catch (Resources.NotFoundException unused) {
                }
                if (!z) {
                    if (O000000o2.O0000O0o(0) && (O0000O0o = O000000o2.O0000O0o(0, 0)) != 0) {
                        this.O00000o0.setButtonDrawable(OO0000o.O00000Oo(this.O00000o0.getContext(), O0000O0o));
                    }
                }
                if (O000000o2.O0000O0o(2)) {
                    ct.O000000o(this.O00000o0, O000000o2.O00000oO(2));
                }
                if (O000000o2.O0000O0o(3)) {
                    ct.O000000o(this.O00000o0, OOOOOo0.O000000o(O000000o2.O000000o(3, -1), null));
                }
            }
            z = false;
            if (!z) {
            }
            if (O000000o2.O0000O0o(2)) {
            }
            if (O000000o2.O0000O0o(3)) {
            }
        } finally {
            O000000o2.f12340O000000o.recycle();
        }
    }

    public final void O000000o(ColorStateList colorStateList) {
        this.f12323O000000o = colorStateList;
        this.O00000o = true;
        O00000Oo();
    }

    public final void O000000o(PorterDuff.Mode mode) {
        this.O00000Oo = mode;
        this.O00000oO = true;
        O00000Oo();
    }

    public final void O000000o() {
        if (this.O00000oo) {
            this.O00000oo = false;
            return;
        }
        this.O00000oo = true;
        O00000Oo();
    }

    private void O00000Oo() {
        Drawable O00000Oo2 = ct.O00000Oo(this.O00000o0);
        if (O00000Oo2 == null) {
            return;
        }
        if (this.O00000o || this.O00000oO) {
            Drawable mutate = ab.O00000oo(O00000Oo2).mutate();
            if (this.O00000o) {
                ab.O000000o(mutate, this.f12323O000000o);
            }
            if (this.O00000oO) {
                ab.O000000o(mutate, this.O00000Oo);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.O00000o0.getDrawableState());
            }
            this.O00000o0.setButtonDrawable(mutate);
        }
    }

    public final int O000000o(int i) {
        Drawable O00000Oo2;
        return (Build.VERSION.SDK_INT >= 17 || (O00000Oo2 = ct.O00000Oo(this.O00000o0)) == null) ? i : i + O00000Oo2.getIntrinsicWidth();
    }
}
