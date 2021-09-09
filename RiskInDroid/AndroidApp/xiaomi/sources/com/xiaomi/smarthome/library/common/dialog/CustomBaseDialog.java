package com.xiaomi.smarthome.library.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public abstract class CustomBaseDialog extends Dialog {
    protected DisplayMetrics O00000o;
    protected Context O00000o0;
    protected float O00000oO;
    protected LinearLayout O00000oo;
    protected LinearLayout O0000O0o;
    protected View O0000OOo;
    protected AnimationSet O0000Oo;
    protected boolean O0000Oo0;
    protected int O0000OoO = 17;

    public abstract View O000000o();

    public CustomBaseDialog(Context context) {
        super(context);
        this.O00000o0 = context;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.O0000OoO = 80;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000o = this.O00000o0.getResources().getDisplayMetrics();
        int i = this.O00000o.heightPixels;
        Context context = this.O00000o0;
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        boolean z = false;
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        if ("4.4.4".equals(Build.VERSION.RELEASE)) {
            String str = Build.VERSION.INCREMENTAL;
            String str2 = Build.DISPLAY;
            if (!TextUtils.isEmpty(str)) {
                z = str.contains("Flyme_OS_4");
            } else {
                z = str2.contains("Flyme OS 4");
            }
        }
        if (z) {
            dimensionPixelSize *= 2;
        }
        this.O00000oO = (float) (i - dimensionPixelSize);
        this.O00000oo = new LinearLayout(this.O00000o0);
        this.O00000oo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.O00000oo.setGravity(17);
        this.O0000O0o = new LinearLayout(this.O00000o0);
        this.O0000O0o.setOrientation(1);
        this.O0000OOo = O000000o();
        this.O0000O0o.addView(this.O0000OOo);
        this.O00000oo.addView(this.O0000O0o);
        setContentView(this.O00000oo, new ViewGroup.LayoutParams(this.O00000o.widthPixels, -1));
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.CustomBaseDialog.AnonymousClass1 */

            public final void onClick(View view) {
                if (CustomBaseDialog.this.O0000Oo0) {
                    CustomBaseDialog.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.O00000oo.setGravity(this.O0000OoO);
        getWindow().setGravity(this.O0000OoO);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O000000o((int) R.anim.alpha_in);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        this.O0000Oo = new AnimationSet(true);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.O00000o0, i);
        loadAnimation.setDuration(200);
        this.O0000Oo.addAnimation(loadAnimation);
        this.O0000Oo.setDuration(200);
        this.O0000OOo.setAnimation(this.O0000Oo);
        this.O0000Oo.start();
    }

    public void dismiss() {
        O00000Oo(R.anim.alpha_out);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i) {
        this.O0000OOo.clearAnimation();
        this.O0000Oo = new AnimationSet(true);
        this.O0000Oo.addAnimation(AnimationUtils.loadAnimation(this.O00000o0, i));
        this.O0000Oo.setDuration(200);
        this.O0000OOo.setAnimation(this.O0000Oo);
        this.O0000Oo.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.CustomBaseDialog.AnonymousClass2 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                CustomBaseDialog.super.dismiss();
            }
        });
        this.O0000Oo.start();
    }
}
