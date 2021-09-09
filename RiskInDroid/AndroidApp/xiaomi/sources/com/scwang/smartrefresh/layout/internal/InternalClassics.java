package com.scwang.smartrefresh.layout.internal;

import _m_j.czv;
import _m_j.czw;
import _m_j.czx;
import _m_j.dad;
import _m_j.dae;
import _m_j.dag;
import _m_j.dao;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

public abstract class InternalClassics<T extends InternalClassics> extends dae implements czv {
    protected ImageView O0000o;
    protected TextView O0000o0O;
    protected ImageView O0000o0o;
    protected czw O0000oO;
    protected LinearLayout O0000oO0;
    protected dad O0000oOO;
    protected dag O0000oOo;
    protected Integer O0000oo;
    protected Integer O0000oo0;
    protected int O0000ooO;
    protected int O0000ooo = 500;
    protected int O00oOooO = 20;
    protected int O00oOooo = 20;

    public InternalClassics(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O000OoOo = SpinnerStyle.Translate;
        this.O0000o0o = new ImageView(context);
        this.O0000o = new ImageView(context);
        this.O0000o0O = new TextView(context);
        this.O0000o0O.setTextColor(-10066330);
        this.O0000oO0 = new LinearLayout(context);
        this.O0000oO0.setGravity(1);
        this.O0000oO0.setOrientation(1);
        ImageView imageView = this.O0000o0o;
        TextView textView = this.O0000o0O;
        ImageView imageView2 = this.O0000o;
        LinearLayout linearLayout = this.O0000oO0;
        dao dao = new dao();
        textView.setId(1);
        imageView.setId(2);
        imageView2.setId(3);
        linearLayout.setId(16908312);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dao.O00000Oo(20.0f), dao.O00000Oo(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, 16908312);
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(imageView2, layoutParams3);
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int O00000Oo = dao.O00000Oo(20.0f);
                this.O00oOooO = O00000Oo;
                int paddingRight = getPaddingRight();
                int O00000Oo2 = dao.O00000Oo(20.0f);
                this.O00oOooo = O00000Oo2;
                setPadding(paddingLeft, O00000Oo, paddingRight, O00000Oo2);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int O00000Oo3 = dao.O00000Oo(20.0f);
                this.O00oOooO = O00000Oo3;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.O00oOooo = paddingBottom;
                setPadding(paddingLeft2, O00000Oo3, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.O00oOooO = paddingTop;
            int paddingRight3 = getPaddingRight();
            int O00000Oo4 = dao.O00000Oo(20.0f);
            this.O00oOooo = O00000Oo4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, O00000Oo4);
        } else {
            this.O00oOooO = getPaddingTop();
            this.O00oOooo = getPaddingBottom();
        }
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.O00oOooO, getPaddingRight(), this.O00oOooo);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.O0000o0o;
            ImageView imageView2 = this.O0000o;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Drawable drawable = this.O0000o.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    public final void O000000o(czw czw, int i, int i2) {
        this.O0000oO = czw;
        this.O0000oO.O000000o(this, this.O0000ooO);
    }

    public void O00000Oo(czx czx, int i, int i2) {
        ImageView imageView = this.O0000o;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.O0000o.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000);
            }
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        O00000Oo(czx, i, i2);
    }

    public int O000000o(czx czx, boolean z) {
        ImageView imageView = this.O0000o;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0);
        }
        imageView.setVisibility(8);
        return this.O0000ooo;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && this.O0000oo == null) {
                O00000Oo(iArr[0]);
                this.O0000oo = null;
            }
            if (this.O0000oo0 == null) {
                if (iArr.length > 1) {
                    O000000o(iArr[1]);
                }
                this.O0000oo0 = null;
            }
        }
    }

    public final T O00000Oo(int i) {
        Integer valueOf = Integer.valueOf(i);
        this.O0000oo = valueOf;
        this.O0000ooO = valueOf.intValue();
        czw czw = this.O0000oO;
        if (czw != null) {
            czw.O000000o(this, this.O0000oo.intValue());
        }
        return this;
    }

    public T O000000o(int i) {
        this.O0000oo0 = Integer.valueOf(i);
        this.O0000o0O.setTextColor(i);
        dad dad = this.O0000oOO;
        if (dad != null) {
            dad.O00000Oo(i);
        }
        dag dag = this.O0000oOo;
        if (dag != null) {
            dag.O00000Oo(i);
        }
        return this;
    }
}
