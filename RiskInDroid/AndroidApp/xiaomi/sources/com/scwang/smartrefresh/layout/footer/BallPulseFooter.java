package com.scwang.smartrefresh.layout.footer;

import _m_j.czt;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import _m_j.q;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BallPulseFooter extends dae implements czt {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f5574O000000o;
    protected boolean O00000Oo;
    protected int O00000o;
    protected Paint O00000o0;
    protected int O00000oO;
    protected float O00000oo;
    protected float[] O0000O0o;
    protected boolean O0000OOo;
    protected Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> O0000Oo;
    protected ArrayList<ValueAnimator> O0000Oo0;

    public final boolean O000000o(boolean z) {
        return false;
    }

    public BallPulseFooter(Context context) {
        this(context, null);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = -1118482;
        this.O00000oO = -1615546;
        this.O0000O0o = new float[]{1.0f, 1.0f, 1.0f};
        this.O0000OOo = false;
        this.O0000Oo = new HashMap();
        setMinimumHeight(dao.O000000o(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.srlAnimatingColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlNormalColor});
        this.O00000o0 = new Paint();
        this.O00000o0.setColor(-1);
        this.O00000o0.setStyle(Paint.Style.FILL);
        this.O00000o0.setAntiAlias(true);
        this.O000OoOo = SpinnerStyle.Translate;
        this.O000OoOo = SpinnerStyle.values()[obtainStyledAttributes.getInt(1, this.O000OoOo.ordinal())];
        if (obtainStyledAttributes.hasValue(2)) {
            O000000o(obtainStyledAttributes.getColor(2, 0));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            O00000Oo(obtainStyledAttributes.getColor(0, 0));
        }
        obtainStyledAttributes.recycle();
        this.O00000oo = (float) dao.O000000o(4.0f);
        this.O0000Oo0 = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (final int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setTarget(Integer.valueOf(i2));
            ofFloat.setStartDelay((long) iArr[i2]);
            this.O0000Oo.put(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                /* class com.scwang.smartrefresh.layout.footer.BallPulseFooter.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseFooter.this.O0000O0o[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.postInvalidate();
                }
            });
            this.O0000Oo0.add(ofFloat);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O0000Oo0 != null) {
            for (int i = 0; i < this.O0000Oo0.size(); i++) {
                this.O0000Oo0.get(i).cancel();
                this.O0000Oo0.get(i).removeAllListeners();
                this.O0000Oo0.get(i).removeAllUpdateListeners();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = this.O00000oo;
        float min = (((float) Math.min(width, height)) - (f * 2.0f)) / 6.0f;
        float f2 = 2.0f * min;
        float f3 = ((float) (width / 2)) - (f + f2);
        float f4 = (float) (height / 2);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f5 = (float) i;
            canvas.translate((f2 * f5) + f3 + (this.O00000oo * f5), f4);
            float[] fArr = this.O0000O0o;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, min, this.O00000o0);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    public final void O00000Oo(czx czx, int i, int i2) {
        if (!this.O0000OOo) {
            for (int i3 = 0; i3 < this.O0000Oo0.size(); i3++) {
                ValueAnimator valueAnimator = this.O0000Oo0.get(i3);
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.O0000Oo.get(valueAnimator);
                if (animatorUpdateListener != null) {
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                }
                valueAnimator.start();
            }
            this.O0000OOo = true;
            this.O00000o0.setColor(this.O00000oO);
        }
    }

    public final int O000000o(czx czx, boolean z) {
        ArrayList<ValueAnimator> arrayList = this.O0000Oo0;
        if (arrayList != null && this.O0000OOo) {
            this.O0000OOo = false;
            this.O0000O0o = new float[]{1.0f, 1.0f, 1.0f};
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
        this.O00000o0.setColor(this.O00000o);
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (!this.O00000Oo && iArr.length > 1) {
            O00000Oo(iArr[0]);
            this.O00000Oo = false;
        }
        if (!this.f5574O000000o) {
            if (iArr.length > 1) {
                O000000o(iArr[1]);
            } else if (iArr.length > 0) {
                O000000o(q.O000000o(-1711276033, iArr[0]));
            }
            this.f5574O000000o = false;
        }
    }

    private BallPulseFooter O000000o(int i) {
        this.O00000o = i;
        this.f5574O000000o = true;
        if (!this.O0000OOo) {
            this.O00000o0.setColor(i);
        }
        return this;
    }

    private BallPulseFooter O00000Oo(int i) {
        this.O00000oO = i;
        this.O00000Oo = true;
        if (this.O0000OOo) {
            this.O00000o0.setColor(i);
        }
        return this;
    }
}
