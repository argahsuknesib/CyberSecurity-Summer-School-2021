package com.mobikwik.sdk.ui.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class a extends Animation implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f5338a;
    View b;
    int c;
    int d;
    int e;
    boolean f;
    private boolean g;

    public a(ViewGroup viewGroup, View view, int i, int i2, int i3) {
        this.f5338a = viewGroup;
        this.b = view;
        this.c = i;
        this.d = i2;
        this.e = i3;
        viewGroup.getLayoutParams().height = i;
        viewGroup.requestLayout();
        setDuration(300);
        setInterpolator(new LinearInterpolator());
        setAnimationListener(this);
    }

    public void a(boolean z) {
        this.f = z;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        if (!this.g) {
            ViewGroup.LayoutParams layoutParams = this.f5338a.getLayoutParams();
            int i = this.d;
            int i2 = this.c;
            layoutParams.height = i2 + ((int) (((float) (i - i2)) * f2));
            if (f2 == 1.0f) {
                if (this.e == 2) {
                    this.b.setVisibility(8);
                }
                layoutParams.height = -2;
            }
            this.f5338a.requestLayout();
        }
    }

    public void onAnimationEnd(Animation animation) {
        this.g = true;
        if (this.f) {
            this.f5338a.postDelayed(new b(this), 30);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.g = false;
    }
}
