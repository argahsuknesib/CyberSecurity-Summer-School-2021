package com.mi.global.shop.widget;

import _m_j.cay;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class CommonButton extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private CustomTextView f4949O000000o;
    private ViewGroup O00000Oo;

    public CommonButton(Context context) {
        super(context);
        O000000o(context, null, 0);
    }

    public CommonButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet, 0);
    }

    public CommonButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    @SuppressLint({"NewApi"})
    private void O000000o(Context context, AttributeSet attributeSet, int i) {
        int i2;
        setPadding(0, 0, 0, 0);
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate((int) R.layout.shop_layout_common_button, (ViewGroup) null, false);
        this.f4949O000000o = (CustomTextView) inflate.findViewById(R.id.common_button_middletext);
        this.O00000Oo = (ViewGroup) inflate.findViewById(R.id.common_button_rootview);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842766, 16842901, 16842904, 16842996, 16843087, R.attr.cb_bgcolor_disabled, R.attr.cb_bgcolor_nomal, R.attr.cb_bgcolor_pressed, R.attr.cb_corners_left_radius, R.attr.cb_corners_radius, R.attr.cb_corners_right_radius, R.attr.cb_stroke_width, R.attr.cb_strokecolor_disabled, R.attr.cb_strokecolor_nomal, R.attr.cb_strokecolor_pressed}, i, 0);
        try {
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(2))) {
                this.f4949O000000o.setTextColor(obtainStyledAttributes.getColor(2, Color.rgb(255, 255, 255)));
            }
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(4))) {
                this.f4949O000000o.setText(obtainStyledAttributes.getString(4).toUpperCase());
            }
            float f = 14.0f;
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(1))) {
                f = obtainStyledAttributes.getDimension(1, 14.0f);
            }
            this.f4949O000000o.setTextSize(0, f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(11))) {
                obtainStyledAttributes.getDimensionPixelOffset(11, 0);
                obtainStyledAttributes.getDimension(11, 0.0f);
                i2 = obtainStyledAttributes.getDimensionPixelSize(11, 0);
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                if (!TextUtils.isEmpty(obtainStyledAttributes.getString(13))) {
                    gradientDrawable.setStroke(i2, obtainStyledAttributes.getColor(13, 0));
                }
                if (!TextUtils.isEmpty(obtainStyledAttributes.getString(14))) {
                    gradientDrawable2.setStroke(i2, obtainStyledAttributes.getColor(14, 0));
                }
                if (!TextUtils.isEmpty(obtainStyledAttributes.getString(12))) {
                    gradientDrawable3.setStroke(i2, obtainStyledAttributes.getColor(12, 0));
                }
            }
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(6))) {
                gradientDrawable.setColor(obtainStyledAttributes.getColor(6, 0));
            }
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(7))) {
                gradientDrawable2.setColor(obtainStyledAttributes.getColor(7, 0));
            }
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(5))) {
                gradientDrawable3.setColor(obtainStyledAttributes.getColor(5, 0));
            }
            if (!TextUtils.isEmpty(obtainStyledAttributes.getString(9))) {
                gradientDrawable.setCornerRadius((float) obtainStyledAttributes.getDimensionPixelOffset(9, 0));
                gradientDrawable2.setCornerRadius((float) obtainStyledAttributes.getDimensionPixelOffset(9, 0));
                gradientDrawable3.setCornerRadius((float) obtainStyledAttributes.getDimensionPixelOffset(9, 0));
            } else {
                boolean z = !TextUtils.isEmpty(obtainStyledAttributes.getString(8));
                boolean z2 = !TextUtils.isEmpty(obtainStyledAttributes.getString(10));
                if (!z || !z2) {
                    throw new RuntimeException("Must be set Radius, just add cb_corners_radius or add cb_corners_left_radius and cb_corners_right_radius");
                }
                float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(8, 0);
                float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(10, 0);
                float[] fArr = {dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize};
                gradientDrawable.setCornerRadii(fArr);
                gradientDrawable2.setCornerRadii(fArr);
                gradientDrawable3.setCornerRadii(fArr);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable3);
            stateListDrawable.addState(new int[0], gradientDrawable);
            if (Build.VERSION.SDK_INT >= 16) {
                this.O00000Oo.setBackground(stateListDrawable);
            } else {
                this.O00000Oo.setBackgroundDrawable(stateListDrawable);
            }
            cay.O000000o(this.f4949O000000o, context);
            setEnabled(!TextUtils.isEmpty(obtainStyledAttributes.getString(0)) ? obtainStyledAttributes.getBoolean(0, true) : true);
            setClickable(true);
            addView(inflate);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public CharSequence getText() {
        return this.f4949O000000o.getText();
    }

    public void setTextColor(int i) {
        this.f4949O000000o.setTextColor(i);
    }

    public void setText(String str) {
        this.f4949O000000o.setText(str);
    }

    public void setText(int i) {
        this.f4949O000000o.setText(i);
    }
}
