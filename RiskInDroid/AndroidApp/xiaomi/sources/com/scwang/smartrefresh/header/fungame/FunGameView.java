package com.scwang.smartrefresh.header.fungame;

import _m_j.czw;
import _m_j.czx;
import _m_j.dao;
import _m_j.q;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.xiaomi.smarthome.R;

public abstract class FunGameView<T extends FunGameView> extends FunGameBase {
    protected float O000O0OO = 1.0f;
    protected View O000O0Oo;
    public String O000O0o;
    protected TextView O000O0o0;
    public String O000O0oO;
    public String O000O0oo;
    public String O000OO;
    protected int O000OO00;
    public String O000OO0o;
    public String O000OOOo;
    protected Paint O000OOo;
    public String O000OOo0;
    protected Paint O000OOoO;
    protected float O000OOoo;
    protected int O000Oo0 = 0;
    protected int O000Oo00;
    protected int O000Oo0O;
    protected int O000Oo0o;
    protected int O000OoO = -10461088;
    protected int O000OoO0;
    protected int O00O0Oo;
    protected TextView O00oOoOo;

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public abstract void O000000o(Canvas canvas, int i);

    public FunGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.fghBackColor, R.attr.fghLeftColor, R.attr.fghMaskTextBottom, R.attr.fghMaskTextSizeBottom, R.attr.fghMaskTextSizeTop, R.attr.fghMaskTextTop, R.attr.fghMaskTextTopPull, R.attr.fghMaskTextTopRelease, R.attr.fghMiddleColor, R.attr.fghRightColor, R.attr.fghTextGameOver, R.attr.fghTextLoading, R.attr.fghTextLoadingFailed, R.attr.fghTextLoadingFinished});
        this.O000O0o = getResources().getString(R.string.fgh_mask_bottom);
        this.O000O0oO = getResources().getString(R.string.fgh_mask_top_pull);
        this.O000O0oo = getResources().getString(R.string.fgh_mask_top_release);
        if (obtainStyledAttributes.hasValue(5)) {
            String string = obtainStyledAttributes.getString(5);
            this.O000O0oo = string;
            this.O000O0oO = string;
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.O000O0oO = obtainStyledAttributes.getString(6);
        }
        if (obtainStyledAttributes.hasValue(7)) {
            this.O000O0oo = obtainStyledAttributes.getString(7);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.O000O0o = obtainStyledAttributes.getString(2);
        }
        int applyDimension = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, applyDimension);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(3, (applyDimension * 14) / 16);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.O000O0Oo = new RelativeLayout(context);
        this.O000O0Oo.setBackgroundColor(-12961222);
        this.O00oOoOo = O000000o(context, this.O000O0oO, dimensionPixelSize, 80);
        this.O000O0o0 = O000000o(context, this.O000O0o, dimensionPixelSize2, 48);
        if (!isInEditMode()) {
            int O000000o2 = dao.O000000o(100.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, O000000o2);
            addView(this.O000O0Oo, layoutParams);
            addView(relativeLayout, layoutParams);
            this.O000OO00 = (int) (((float) O000000o2) * 0.5f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.O000OO00);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.O000OO00);
            layoutParams3.topMargin = O000000o2 - this.O000OO00;
            relativeLayout.addView(this.O00oOoOo, layoutParams2);
            relativeLayout.addView(this.O000O0o0, layoutParams3);
        }
        this.O000O0OO = (float) Math.max(1, dao.O000000o(0.5f));
        this.O000OOo = new Paint(1);
        this.O000OOo.setStrokeWidth(this.O000O0OO);
        this.O000OOoo = this.O000O0OO;
        this.O000OOoO = new TextPaint(1);
        this.O000OOoO.setColor(-4078910);
        this.O000OO0o = context.getString(R.string.fgh_text_game_over);
        this.O000OO = context.getString(R.string.fgh_text_loading);
        this.O000OOOo = context.getString(R.string.fgh_text_loading_finish);
        this.O000OOo0 = context.getString(R.string.fgh_text_loading_failed);
        this.O00O0Oo = obtainStyledAttributes.getColor(0, 0);
        this.O000Oo0O = obtainStyledAttributes.getColor(1, -16777216);
        this.O000OoO0 = obtainStyledAttributes.getColor(8, -16777216);
        this.O000Oo0o = obtainStyledAttributes.getColor(9, -5921371);
        if (obtainStyledAttributes.hasValue(10)) {
            this.O000OO0o = obtainStyledAttributes.getString(10);
        }
        if (obtainStyledAttributes.hasValue(11)) {
            this.O000OO = obtainStyledAttributes.getString(11);
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.O000OOOo = obtainStyledAttributes.getString(13);
        }
        if (obtainStyledAttributes.hasValue(12)) {
            this.O000OOo0 = obtainStyledAttributes.getString(12);
        }
        obtainStyledAttributes.recycle();
    }

    private static TextView O000000o(Context context, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTextColor(-16777216);
        textView.setGravity(i2 | 1);
        textView.setTextSize(0, (float) i);
        textView.setText(str);
        textView.setBackgroundColor(-1);
        return textView;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i = this.O0000oO;
        this.O000OOo.setColor(this.O00O0Oo);
        float f = (float) i;
        float f2 = (float) width;
        canvas.drawRect(0.0f, 0.0f, f2, f, this.O000OOo);
        this.O000OOo.setColor(this.O000OoO);
        canvas.drawLine(0.0f, 0.0f, f2, 0.0f, this.O000OOo);
        float f3 = this.O000O0OO;
        canvas.drawLine(0.0f, f - f3, f2, f - f3, this.O000OOo);
        int i2 = this.O000Oo0;
        if (i2 == 0 || i2 == 1) {
            this.O000OOoO.setTextSize((float) dao.O000000o(25.0f));
            O000000o(canvas, this.O000OO, width, i);
        } else if (i2 == 2) {
            this.O000OOoO.setTextSize((float) dao.O000000o(25.0f));
            O000000o(canvas, this.O000OO0o, width, i);
        } else if (i2 == 3) {
            this.O000OOoO.setTextSize((float) dao.O000000o(20.0f));
            O000000o(canvas, this.O000OOOo, width, i);
        } else if (i2 == 4) {
            this.O000OOoO.setTextSize((float) dao.O000000o(20.0f));
            O000000o(canvas, this.O000OOo0, width, i);
        }
        O000000o(canvas, width);
        super.dispatchDraw(canvas);
    }

    private void O000000o(Canvas canvas, String str, int i, int i2) {
        canvas.drawText(str, (((float) i) - this.O000OOoO.measureText(str)) * 0.5f, (((float) i2) * 0.5f) - ((this.O000OOoO.ascent() + this.O000OOoO.descent()) * 0.5f), this.O000OOoO);
    }

    public final void O00000Oo(int i) {
        this.O000Oo0 = i;
        if (i == 0) {
            O000000o();
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        float max = (float) Math.max(i, 0);
        float f = (((float) this.O0000oO) - (this.O000O0OO * 2.0f)) - ((float) this.O000Oo00);
        if (max > f) {
            max = f;
        }
        this.O000OOoo = max;
        postInvalidate();
    }

    public void O000000o(czw czw, int i, int i2) {
        if (this.O0000oO != i && !isInEditMode()) {
            TextView textView = this.O00oOoOo;
            TextView textView2 = this.O000O0o0;
            this.O000OO00 = (int) (((float) i) * 0.5f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            int i3 = this.O000OO00;
            layoutParams2.height = i3;
            layoutParams.height = i3;
            layoutParams2.topMargin = i - i3;
            textView.setLayoutParams(layoutParams);
            textView2.setLayoutParams(layoutParams2);
        }
        super.O000000o(czw, i, i2);
        O00000Oo(0);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.O00oOoOo.setTextColor(iArr[0]);
            this.O000O0o0.setTextColor(iArr[0]);
            int i = iArr[0];
            this.O00O0Oo = i;
            this.O000OoO = i;
            int i2 = this.O00O0Oo;
            if (i2 == 0 || i2 == -1) {
                this.O000OoO = -10461088;
            }
            if (iArr.length > 1) {
                TextView textView = this.O00oOoOo;
                TextView textView2 = this.O000O0o0;
                this.O000O0Oo.setBackgroundColor(iArr[1]);
                textView.setBackgroundColor(iArr[1]);
                textView2.setBackgroundColor(iArr[1]);
                this.O000OoO0 = iArr[1];
                this.O000Oo0O = q.O00000Oo(iArr[1], 225);
                this.O000Oo0o = q.O00000Oo(iArr[1], 200);
                this.O000OOoO.setColor(q.O00000Oo(iArr[1], 150));
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.fungame.FunGameView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5548O000000o = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f5548O000000o[RefreshState.PullDownToRefresh.ordinal()] = 1;
            f5548O000000o[RefreshState.ReleaseToRefresh.ordinal()] = 2;
        }
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        super.O000000o(czx, refreshState, refreshState2);
        int i = AnonymousClass2.f5548O000000o[refreshState2.ordinal()];
        if (i == 1) {
            this.O00oOoOo.setText(this.O000O0oO);
        } else if (i == 2) {
            this.O00oOoOo.setText(this.O000O0oo);
        }
    }

    public final void O00000Oo(czx czx, int i, int i2) {
        super.O00000Oo(czx, i, i2);
        final TextView textView = this.O00oOoOo;
        final TextView textView2 = this.O000O0o0;
        final View view = this.O000O0Oo;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), (float) (-this.O000OO00))).with(ObjectAnimator.ofFloat(textView2, "translationY", textView2.getTranslationY(), (float) this.O000OO00)).with(ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f));
        animatorSet.addListener(new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.header.fungame.FunGameView.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                textView.setVisibility(8);
                textView2.setVisibility(8);
                view.setVisibility(8);
                FunGameView.this.O00000Oo(1);
            }
        });
        animatorSet.setDuration(800L);
        animatorSet.setStartDelay(200);
        animatorSet.start();
    }

    public final int O000000o(czx czx, boolean z) {
        if (this.O0000ooO) {
            O00000Oo(z ? 3 : 4);
        } else {
            O00000Oo(0);
            TextView textView = this.O00oOoOo;
            TextView textView2 = this.O000O0o0;
            View view = this.O000O0Oo;
            textView.setTranslationY(textView.getTranslationY() + ((float) this.O000OO00));
            textView2.setTranslationY(textView2.getTranslationY() - ((float) this.O000OO00));
            view.setAlpha(1.0f);
            textView.setVisibility(0);
            textView2.setVisibility(0);
            view.setVisibility(0);
        }
        return super.O000000o(czx, z);
    }
}
