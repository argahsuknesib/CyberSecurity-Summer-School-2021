package com.xiaomi.smarthome.framework.page.verify.view;

import _m_j.gri;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class PinInputView extends LinearLayout {
    private static final long[] O0000OOo = {100, 500};

    /* renamed from: O000000o  reason: collision with root package name */
    public int f8026O000000o;
    public int O00000Oo;
    public PinInputItem O00000o;
    public int O00000o0;
    public boolean O00000oO;
    public Handler O00000oo;
    public Runnable O0000O0o;
    private int O0000Oo;
    private int O0000Oo0;
    private String O0000OoO;
    private PinInputItem[] O0000Ooo;

    public PinInputView(Context context) {
        this(context, null);
    }

    public PinInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = 4;
        this.f8026O000000o = R.drawable.miconnect_pin_input_item;
        this.O0000Oo = 47;
        this.O00000o0 = 0;
        this.O0000OoO = "";
        this.O00000oO = false;
        this.O0000O0o = new Runnable() {
            /* class com.xiaomi.smarthome.framework.page.verify.view.PinInputView.AnonymousClass1 */

            public final void run() {
                if (PinInputView.this.O00000oO) {
                    if (PinInputView.this.O00000o != null) {
                        if (PinInputView.this.O00000o.isEnabled()) {
                            PinInputView.this.O00000o.setEnabled(false);
                        } else {
                            PinInputView.this.O00000o.setEnabled(true);
                        }
                    }
                    PinInputView.this.O00000oo.postDelayed(PinInputView.this.O0000O0o, 600);
                }
            }
        };
        this.O00000oo = new Handler();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.input_height, R.attr.input_view_res_id, R.attr.input_width, R.attr.number, R.attr.spacing}, i, 0);
            this.f8026O000000o = obtainStyledAttributes.getResourceId(1, R.drawable.miconnect_pin_input_item);
            this.O0000Oo = obtainStyledAttributes.getInt(2, 47);
            setSpacing(obtainStyledAttributes.getDimensionPixelSize(4, 0));
            setPincodeNumber(obtainStyledAttributes.getInt(3, 4));
            obtainStyledAttributes.recycle();
        }
        this.O00000oo.postDelayed(this.O0000O0o, 1000);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int i3 = this.O00000o0;
        int i4 = this.O0000Oo0;
        this.O00000Oo = (measuredWidth - (i3 * (i4 - 1))) / i4;
        setMeasuredDimension(measuredWidth, this.O00000Oo + getPaddingTop() + getPaddingBottom());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).measure(0, 0);
        }
    }

    public void setSpacing(int i) {
        this.O00000o0 = i;
    }

    public void setPincodeNumber(int i) {
        this.O0000Oo0 = i;
        removeAllViews();
        this.O0000Ooo = new PinInputItem[this.O0000Oo0];
        setOrientation(0);
        for (int i2 = 0; i2 < this.O0000Oo0; i2++) {
            this.O0000Ooo[i2] = new PinInputItem(getContext());
            addView(this.O0000Ooo[i2]);
            if (this.O00000o0 > 0 && i2 != this.O0000Oo0 - 1) {
                addView(new O000000o(getContext()));
            }
        }
        this.O0000Ooo[0].showHighlight();
        this.O00000o = this.O0000Ooo[0];
    }

    public int getPincodeNumber() {
        return this.O0000Oo0;
    }

    public final String O000000o(int i) {
        if (this.O0000OoO.length() < this.O0000Oo0) {
            this.O0000OoO += i;
        }
        this.O0000Ooo[this.O0000OoO.length() - 1].showPin();
        this.O0000Ooo[this.O0000OoO.length() - 1].clearHighlight();
        if (this.O0000OoO.length() < this.O0000Oo0) {
            this.O0000Ooo[this.O0000OoO.length()].showHighlight();
            this.O00000o = this.O0000Ooo[this.O0000OoO.length()];
        } else {
            this.O00000o = null;
        }
        return this.O0000OoO;
    }

    public final String O000000o() {
        if (TextUtils.isEmpty(this.O0000OoO)) {
            return "";
        }
        this.O00000o = this.O0000Ooo[this.O0000OoO.length() - 1];
        this.O0000Ooo[this.O0000OoO.length() - 1].clearPin();
        this.O0000Ooo[this.O0000OoO.length() - 1].showHighlight();
        if (this.O0000OoO.length() < this.O0000Oo0) {
            this.O0000Ooo[this.O0000OoO.length()].clearPin();
            this.O0000Ooo[this.O0000OoO.length()].clearHighlight();
        }
        if (this.O0000OoO.length() == 1) {
            this.O0000OoO = "";
        } else {
            String str = this.O0000OoO;
            this.O0000OoO = str.substring(0, str.length() - 1);
        }
        return this.O0000OoO;
    }

    public final void O00000Oo() {
        for (PinInputItem pinInputItem : this.O0000Ooo) {
            pinInputItem.clearPin();
            pinInputItem.clearHighlight();
        }
        this.O0000Ooo[0].showHighlight();
        this.O00000o = this.O0000Ooo[0];
        this.O0000OoO = "";
    }

    public final void O00000o0() {
        O00000Oo();
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake));
        ((Vibrator) getContext().getSystemService("vibrator")).vibrate(O0000OOo, -1);
    }

    public String getPinCode() {
        return this.O0000OoO;
    }

    class O000000o extends View {
        public O000000o(Context context) {
            super(context);
            setLayoutParams(new LinearLayout.LayoutParams(gri.O000000o((float) PinInputView.this.O00000o0), -2));
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i, int i2) {
            setMeasuredDimension(PinInputView.this.O00000o0, 1);
        }
    }

    class PinInputItem extends ImageView {
        public PinInputItem(Context context) {
            super(context);
            init();
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            setMeasuredDimension(PinInputView.this.O00000Oo, PinInputView.this.O00000Oo);
        }

        private void init() {
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setImageResource(PinInputView.this.f8026O000000o);
            setEnabled(false);
            setSelected(false);
        }

        public void showPin() {
            setEnabled(true);
        }

        public void clearPin() {
            setEnabled(false);
        }

        public void showHighlight() {
            setSelected(true);
        }

        public void clearHighlight() {
            setSelected(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O00000oO = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O00000oO = false;
    }
}
