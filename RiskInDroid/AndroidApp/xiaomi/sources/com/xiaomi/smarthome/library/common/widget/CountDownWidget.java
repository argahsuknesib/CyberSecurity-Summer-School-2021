package com.xiaomi.smarthome.library.common.widget;

import _m_j.gno;
import _m_j.gqf;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class CountDownWidget extends DragCircleProgressView {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f9160O000000o = "fonts/DINCond-Medium.otf";
    protected Typeface O00000Oo;
    private boolean O0000ooO;
    private Drawable O0000ooo;
    private Drawable O00oOooO;

    public CountDownWidget(Context context) {
        super(context);
        O00000o0();
    }

    public CountDownWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o0();
    }

    public CountDownWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o0();
    }

    private void O00000o0() {
        this.O0000ooo = this.O0000oo.getDrawable(R.drawable.count_down_timer_thumb_on);
        this.O00oOooO = this.O0000oo.getDrawable(R.drawable.count_down_timer_thumb_off);
        this.O00000Oo = gno.O000000o(getContext(), f9160O000000o);
    }

    public void setStatus(boolean z) {
        this.O0000ooO = z;
    }

    public final void O000000o() {
        this.O00000o0 = this.O00oOooO;
        int intrinsicHeight = this.O00000o0.getIntrinsicHeight() / 2;
        int intrinsicWidth = this.O00000o0.getIntrinsicWidth() / 2;
        this.O00000o0.setBounds(-intrinsicWidth, -intrinsicHeight, intrinsicWidth, intrinsicHeight);
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Canvas canvas, int i) {
        String str;
        String str2;
        this.O0000oO0.setTypeface(this.O00000Oo);
        StringBuilder sb = new StringBuilder();
        if (i < 60) {
            str = i + this.O0000oo.getString(R.string.minute) + this.O0000oo.getString(R.string.later);
        } else {
            int i2 = i % 60;
            if (i2 == 0) {
                str = (i / 60) + this.O0000oo.getString(R.string.hour) + this.O0000oo.getString(R.string.later);
            } else {
                str = (i / 60) + this.O0000oo.getString(R.string.hour) + i2 + this.O0000oo.getString(R.string.minute) + this.O0000oo.getString(R.string.later);
            }
        }
        sb.append(str);
        if (this.O0000ooO) {
            str2 = this.O0000oo.getString(R.string.mj_close);
        } else {
            str2 = this.O0000oo.getString(R.string.mj_open);
        }
        sb.append(str2);
        String sb2 = sb.toString();
        canvas.drawText(sb2, (float) (this.O0000Ooo - (gqf.O000000o(this.O0000oO0, sb2) / 2)), ((float) this.O0000o00) + (this.O0000oO0.getTextSize() / 2.0f), this.O0000oO0);
    }
}
