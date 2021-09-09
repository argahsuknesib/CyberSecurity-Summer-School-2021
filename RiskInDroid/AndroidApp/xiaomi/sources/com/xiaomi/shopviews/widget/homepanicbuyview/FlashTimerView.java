package com.xiaomi.shopviews.widget.homepanicbuyview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class FlashTimerView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private CountDownTimer f3963O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private String O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;

    public FlashTimerView(Context context) {
        this(context, null);
    }

    public FlashTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate((int) R.layout.panic_buy_flash_timer_view, this);
        this.O00000oo = (TextView) findViewById(R.id.flash_timer_hour);
        this.O0000O0o = (TextView) findViewById(R.id.flash_timer_min);
        this.O0000OOo = (TextView) findViewById(R.id.flash_timer_sec);
        this.O00000o = (TextView) findViewById(R.id.flash_span_one);
        this.O00000oO = (TextView) findViewById(R.id.flash_span_two);
        this.O00000Oo = (TextView) findViewById(R.id.flash_timer_end_desc);
    }

    public final void O000000o() {
        CountDownTimer countDownTimer = this.f3963O000000o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setEndTitle(String str) {
        this.O00000o0 = str;
        if (TextUtils.isEmpty(str)) {
            this.O00000Oo.setVisibility(8);
            this.O00000Oo.setText("");
            return;
        }
        TextView textView = this.O00000Oo;
        textView.setText("后" + this.O00000o0);
        this.O00000Oo.setVisibility(0);
    }

    public void setItemBackground(Drawable drawable) {
        this.O00000oo.setBackgroundDrawable(drawable);
        this.O0000O0o.setBackgroundDrawable(drawable);
        this.O0000OOo.setBackgroundDrawable(drawable);
        this.O00000Oo.setBackgroundDrawable(drawable);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.O00000oo.setTextColor(colorStateList);
        this.O0000O0o.setTextColor(colorStateList);
        this.O0000OOo.setTextColor(colorStateList);
        this.O00000o.setTextColor(colorStateList);
        this.O00000oO.setTextColor(colorStateList);
        this.O00000Oo.setTextColor(colorStateList);
    }

    public void setItemTextSize(int i) {
        float f = (float) i;
        this.O00000oo.setTextSize(1, f);
        this.O0000O0o.setTextSize(1, f);
        this.O0000OOo.setTextSize(1, f);
        this.O00000o.setTextSize(1, f);
        this.O00000oO.setTextSize(1, f);
        this.O00000Oo.setTextSize(1, f);
    }

    public final void O00000Oo() {
        this.O00000oo.setVisibility(8);
        this.O00000o.setVisibility(8);
    }
}
