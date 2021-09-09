package com.scwang.smartrefresh.header;

import _m_j.czh;
import _m_j.czu;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;

public class MaterialHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f5527O000000o;
    protected int O00000Oo;
    protected czh O00000o;
    protected ImageView O00000o0;
    protected int O00000oO;
    protected int O00000oo;
    protected Path O0000O0o;
    protected Paint O0000OOo;
    protected RefreshState O0000Oo;
    protected boolean O0000Oo0;

    public MaterialHeader(Context context) {
        this(context, null);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [float, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    public MaterialHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = false;
        this.O000OoOo = SpinnerStyle.MatchLayout;
        setMinimumHeight(dao.O000000o(100.0f));
        this.O00000o = new czh(this);
        this.O00000o.O00000Oo(-328966);
        this.O00000o.setAlpha(255);
        this.O00000o.O000000o(-16737844, -48060, -10053376, -5609780, -30720);
        this.O00000o0 = new CircleImageView(context, -328966);
        this.O00000o0.setImageDrawable(this.O00000o);
        addView(this.O00000o0);
        this.O00000Oo = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.O0000O0o = new Path();
        this.O0000OOo = new Paint();
        this.O0000OOo.setAntiAlias(true);
        this.O0000OOo.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mhPrimaryColor, R.attr.mhShadowColor, R.attr.mhShadowRadius, R.attr.mhShowBezierWave});
        this.O0000Oo0 = obtainStyledAttributes.getBoolean(3, this.O0000Oo0);
        this.O0000OOo.setColor(obtainStyledAttributes.getColor(0, -15614977));
        if (obtainStyledAttributes.hasValue(2)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.O0000OOo.setShadowLayer((float) dimensionPixelOffset, 0.0f, 0.0f, obtainStyledAttributes.getColor(1, -16777216));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.O00000o0.measure(View.MeasureSpec.makeMeasureSpec(this.O00000Oo, 1073741824), View.MeasureSpec.makeMeasureSpec(this.O00000Oo, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (getChildCount() != 0) {
            ImageView imageView = this.O00000o0;
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = imageView.getMeasuredWidth();
            int measuredHeight = imageView.getMeasuredHeight();
            if (!isInEditMode() || (i5 = this.O00000oo) <= 0) {
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.O00000Oo;
                imageView.layout(i6 - i7, -i8, i6 + i7, measuredHeight - i8);
                return;
            }
            int i9 = i5 - (measuredHeight / 2);
            int i10 = measuredWidth / 2;
            int i11 = measuredWidth2 / 2;
            imageView.layout(i10 - i11, i9, i10 + i11, measuredHeight + i9);
            this.O00000o.O000000o(true);
            this.O00000o.O000000o(0.0f, 0.8f);
            this.O00000o.O000000o(1.0f);
            imageView.setAlpha(1.0f);
            imageView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.O0000Oo0) {
            this.O0000O0o.reset();
            this.O0000O0o.lineTo(0.0f, (float) this.O00000oo);
            this.O0000O0o.quadTo((float) (getMeasuredWidth() / 2), ((float) this.O00000oo) + (((float) this.O00000oO) * 1.9f), (float) getMeasuredWidth(), (float) this.O00000oo);
            this.O0000O0o.lineTo((float) getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.O0000O0o, this.O0000OOo);
        }
        super.dispatchDraw(canvas);
    }

    public final void O000000o(czw czw, int i, int i2) {
        if (!this.O0000Oo0) {
            czw.O000000o(this);
        }
        if (isInEditMode()) {
            int i3 = i / 2;
            this.O00000oo = i3;
            this.O00000oO = i3;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (this.O0000Oo0) {
            this.O00000oo = Math.min(i, i2);
            this.O00000oO = Math.max(0, i - i2);
            postInvalidate();
        }
        if (z || (!this.O00000o.isRunning() && !this.f5527O000000o)) {
            ImageView imageView = this.O00000o0;
            if (this.O0000Oo != RefreshState.Refreshing) {
                float f2 = (float) i2;
                float f3 = (((float) i) * 1.0f) / f2;
                double min = (double) Math.min(1.0f, Math.abs(f3));
                Double.isNaN(min);
                float max = (Math.max((float) (min - 0.4d), 0.0f) * 5.0f) / 3.0f;
                double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i) - i2), f2 * 2.0f) / f2) / 4.0f);
                double pow = Math.pow(max2, 2.0d);
                Double.isNaN(max2);
                this.O00000o.O000000o(true);
                this.O00000o.O000000o(0.0f, Math.min(0.8f, max * 0.8f));
                this.O00000o.O000000o(Math.min(1.0f, max));
                this.O00000o.O00000Oo((((max * 0.4f) - 16.0f) + (((float) (max2 - pow)) * 2.0f * 2.0f)) * 0.5f);
                imageView.setAlpha(Math.min(1.0f, f3 * 2.0f));
            }
            imageView.setTranslationY(Math.min((float) i, (float) ((i / 2) + (this.O00000Oo / 2))));
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        this.O00000o.start();
        ImageView imageView = this.O00000o0;
        int i3 = i / 2;
        if (((int) imageView.getTranslationY()) != (this.O00000Oo / 2) + i3) {
            imageView.animate().translationY((float) (i3 + (this.O00000Oo / 2)));
        }
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.O00000o0;
        this.O0000Oo = refreshState2;
        int i = AnonymousClass1.f5528O000000o[refreshState2.ordinal()];
        if (i != 1 && i == 2) {
            this.f5527O000000o = false;
            imageView.setVisibility(0);
            imageView.setScaleX(1.0f);
            imageView.setScaleY(1.0f);
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.MaterialHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5528O000000o = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f5528O000000o[RefreshState.None.ordinal()] = 1;
            f5528O000000o[RefreshState.PullDownToRefresh.ordinal()] = 2;
            f5528O000000o[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            try {
                f5528O000000o[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final int O000000o(czx czx, boolean z) {
        ImageView imageView = this.O00000o0;
        this.O00000o.stop();
        imageView.animate().scaleX(0.0f).scaleY(0.0f);
        this.f5527O000000o = true;
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.O0000OOo.setColor(iArr[0]);
        }
    }
}
