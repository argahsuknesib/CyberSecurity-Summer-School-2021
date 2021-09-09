package _m_j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.xiaomi.smarthome.R;

public final class OOOOo0 extends OOOO0 {
    public final SeekBar O00000Oo;
    private ColorStateList O00000o = null;
    public Drawable O00000o0;
    private PorterDuff.Mode O00000oO = null;
    private boolean O00000oo = false;
    private boolean O0000O0o = false;

    public OOOOo0(SeekBar seekBar) {
        super(seekBar);
        this.O00000Oo = seekBar;
    }

    public final void O000000o(AttributeSet attributeSet, int i) {
        super.O000000o(attributeSet, i);
        Oo O000000o2 = Oo.O000000o(this.O00000Oo.getContext(), attributeSet, new int[]{16843074, R.attr.tickMark, R.attr.tickMarkTint, R.attr.tickMarkTintMode}, i, 0);
        SeekBar seekBar = this.O00000Oo;
        cb.O000000o(seekBar, seekBar.getContext(), new int[]{16843074, R.attr.tickMark, R.attr.tickMarkTint, R.attr.tickMarkTintMode}, attributeSet, O000000o2.f12340O000000o, i);
        Drawable O00000Oo2 = O000000o2.O00000Oo(0);
        if (O00000Oo2 != null) {
            this.O00000Oo.setThumb(O00000Oo2);
        }
        Drawable O000000o3 = O000000o2.O000000o(1);
        Drawable drawable = this.O00000o0;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.O00000o0 = O000000o3;
        if (O000000o3 != null) {
            O000000o3.setCallback(this.O00000Oo);
            ab.O00000Oo(O000000o3, cb.O0000Oo0(this.O00000Oo));
            if (O000000o3.isStateful()) {
                O000000o3.setState(this.O00000Oo.getDrawableState());
            }
            O000000o();
        }
        this.O00000Oo.invalidate();
        if (O000000o2.O0000O0o(3)) {
            this.O00000oO = OOOOOo0.O000000o(O000000o2.O000000o(3, -1), this.O00000oO);
            this.O0000O0o = true;
        }
        if (O000000o2.O0000O0o(2)) {
            this.O00000o = O000000o2.O00000oO(2);
            this.O00000oo = true;
        }
        O000000o2.f12340O000000o.recycle();
        O000000o();
    }

    private void O000000o() {
        if (this.O00000o0 == null) {
            return;
        }
        if (this.O00000oo || this.O0000O0o) {
            this.O00000o0 = ab.O00000oo(this.O00000o0.mutate());
            if (this.O00000oo) {
                ab.O000000o(this.O00000o0, this.O00000o);
            }
            if (this.O0000O0o) {
                ab.O000000o(this.O00000o0, this.O00000oO);
            }
            if (this.O00000o0.isStateful()) {
                this.O00000o0.setState(this.O00000Oo.getDrawableState());
            }
        }
    }
}
