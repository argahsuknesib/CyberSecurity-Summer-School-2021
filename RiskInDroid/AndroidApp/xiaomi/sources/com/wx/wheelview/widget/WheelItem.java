package com.wx.wheelview.widget;

import _m_j.dtx;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WheelItem extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f5940O000000o;
    private TextView O00000Oo;

    public WheelItem(Context context) {
        super(context);
        O000000o();
    }

    public WheelItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public WheelItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, dtx.O000000o(getContext(), 45.0f));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(20, 20, 20, 20);
        linearLayout.setGravity(17);
        addView(linearLayout, layoutParams);
        this.f5940O000000o = new ImageView(getContext());
        this.f5940O000000o.setTag(100);
        this.f5940O000000o.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = 20;
        linearLayout.addView(this.f5940O000000o, layoutParams2);
        this.O00000Oo = new TextView(getContext());
        this.O00000Oo.setTag(101);
        this.O00000Oo.setEllipsize(TextUtils.TruncateAt.END);
        this.O00000Oo.setSingleLine();
        this.O00000Oo.setIncludeFontPadding(false);
        this.O00000Oo.setGravity(17);
        this.O00000Oo.setTextColor(-16777216);
        linearLayout.addView(this.O00000Oo, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setText(CharSequence charSequence) {
        this.O00000Oo.setText(charSequence);
    }

    public void setImage(int i) {
        this.f5940O000000o.setVisibility(0);
        this.f5940O000000o.setImageResource(i);
    }
}
