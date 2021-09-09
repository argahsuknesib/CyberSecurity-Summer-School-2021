package com.sdu.didi.openapi.pK;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sdu.didi.openapi.ss.d;
import com.sdu.didi.openapi.utils.Utils;

public class a extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5602O000000o;
    private TextView O00000Oo;
    private LinearLayout O00000o = new LinearLayout(this.f5602O000000o);
    private ImageView O00000o0;

    public void dismiss() {
        super.dismiss();
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.O00000Oo;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void show() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setStartOffset(0);
        rotateAnimation.setDuration(1500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        ImageView imageView = this.O00000o0;
        if (imageView != null) {
            imageView.startAnimation(rotateAnimation);
        }
        super.show();
        getWindow().setLayout(Utils.O000000o(this.f5602O000000o, 150.0f), Utils.O000000o(this.f5602O000000o, 100.0f));
    }

    public a(Context context) {
        super(context);
        this.f5602O000000o = context;
        d dVar = new d(this.f5602O000000o);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) Utils.O000000o(this.f5602O000000o, 4.0f));
        gradientDrawable.setAlpha(150);
        gradientDrawable.setColor(-16777216);
        getWindow().setBackgroundDrawable(gradientDrawable);
        getWindow().requestFeature(1);
        getWindow().setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.O00000o.setLayoutParams(layoutParams);
        this.O00000o.setGravity(17);
        this.O00000o.setOrientation(1);
        this.O00000o0 = new ImageView(this.f5602O000000o);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Utils.O000000o(this.f5602O000000o, 30.0f), Utils.O000000o(this.f5602O000000o, 30.0f));
        layoutParams2.gravity = 1;
        this.O00000o0.setLayoutParams(layoutParams2);
        this.O00000o0.setImageResource(dVar.O00000Oo("didi_loading_icon"));
        this.O00000Oo = new TextView(this.f5602O000000o);
        this.O00000Oo.setTextColor(Color.parseColor("#666666"));
        this.O00000Oo.setTextSize(2, 13.0f);
        this.O00000Oo.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.topMargin = Utils.O000000o(this.f5602O000000o, 10.0f);
        this.O00000Oo.setLayoutParams(layoutParams3);
        this.O00000o.addView(this.O00000o0);
        this.O00000o.addView(this.O00000Oo);
        setContentView(this.O00000o);
    }
}
