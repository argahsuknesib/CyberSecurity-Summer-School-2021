package _m_j;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public abstract class hwy extends ClickableSpan implements hwv {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f933O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private boolean O00000oo = false;

    public abstract void O000000o(View view);

    public final void onClick(View view) {
        if (cb.O000OO0o(view)) {
            O000000o(view);
        }
    }

    public hwy(int i, int i2, int i3, int i4) {
        this.O00000o = i;
        this.O00000oO = i2;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
    }

    public final void O000000o(boolean z) {
        this.f933O000000o = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f933O000000o ? this.O00000oO : this.O00000o);
        textPaint.bgColor = this.f933O000000o ? this.O00000o0 : this.O00000Oo;
        textPaint.setUnderlineText(this.O00000oo);
    }
}
