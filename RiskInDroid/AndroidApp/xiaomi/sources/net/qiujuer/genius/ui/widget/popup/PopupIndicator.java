package net.qiujuer.genius.ui.widget.popup;

import _m_j.izn;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import net.qiujuer.genius.ui.widget.BalloonMarker;

public class PopupIndicator {

    /* renamed from: O000000o  reason: collision with root package name */
    public final WindowManager f15412O000000o;
    public Point O00000Oo = new Point();
    public O000000o O00000o;
    public boolean O00000o0;
    public izn.O000000o O00000oO;
    public int[] O00000oo = new int[2];

    public static int O00000oo(int i) {
        return (i & -426521) | 32768 | 8 | 16 | 512;
    }

    public PopupIndicator(Context context) {
        this.f15412O000000o = (WindowManager) context.getSystemService("window");
        this.O00000o = new O000000o(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.O00000Oo.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public final void O000000o(ColorStateList colorStateList) {
        if (colorStateList != null) {
            O00000Oo();
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.f15413O000000o.setBackgroundColor(colorStateList);
            }
        }
    }

    public final void O000000o(Typeface typeface) {
        O00000Oo();
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.f15413O000000o.setTypeface(typeface);
        }
    }

    public final void O000000o(int i) {
        O00000Oo();
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.f15413O000000o.setSeparation(i);
        }
    }

    public final void O00000Oo(int i) {
        O00000Oo();
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.f15413O000000o.setTextPadding(i);
        }
    }

    public final void O00000o0(int i) {
        O00000Oo();
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.f15413O000000o.setTextAppearance(i);
        }
    }

    public final void O000000o(float f) {
        O00000Oo();
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.f15413O000000o.setClosedSize(f);
        }
    }

    public final void O000000o(CharSequence charSequence) {
        this.O00000o.f15413O000000o.setValue(charSequence);
    }

    public final void O000000o() {
        this.O00000o.f15413O000000o.O00000o();
    }

    public final void O00000oO(int i) {
        this.O00000o.setFloatOffset(i + this.O00000oo[0]);
    }

    public class O000000o extends FrameLayout implements izn.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public BalloonMarker f15413O000000o;
        private int O00000o0;

        public O000000o(Context context) {
            super(context);
            this.f15413O000000o = new BalloonMarker(context);
            addView(this.f15413O000000o, new FrameLayout.LayoutParams(-2, -2, 51));
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i, int i2) {
            measureChildren(i, i2);
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.f15413O000000o.getMeasuredHeight());
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredWidth = this.O00000o0 - (this.f15413O000000o.getMeasuredWidth() / 2);
            BalloonMarker balloonMarker = this.f15413O000000o;
            balloonMarker.layout(measuredWidth, 0, balloonMarker.getMeasuredWidth() + measuredWidth, this.f15413O000000o.getMeasuredHeight());
        }

        public final void setFloatOffset(int i) {
            this.O00000o0 = i;
            int measuredWidth = i - (this.f15413O000000o.getMeasuredWidth() / 2);
            BalloonMarker balloonMarker = this.f15413O000000o;
            balloonMarker.offsetLeftAndRight(measuredWidth - balloonMarker.getLeft());
            if (!isHardwareAccelerated()) {
                invalidate();
            }
        }

        public final void O000000o() {
            if (PopupIndicator.this.O00000oO != null) {
                PopupIndicator.this.O00000oO.O000000o();
            }
            PopupIndicator.this.O00000Oo();
        }

        public final void O00000Oo() {
            if (PopupIndicator.this.O00000oO != null) {
                PopupIndicator.this.O00000oO.O00000Oo();
            }
        }
    }

    public final void O00000o(int i) {
        if (this.O00000o0) {
            O00000oO(i);
        }
    }

    public final void O00000Oo() {
        if (this.O00000o0) {
            this.O00000o0 = false;
            this.f15412O000000o.removeViewImmediate(this.O00000o);
        }
    }
}
