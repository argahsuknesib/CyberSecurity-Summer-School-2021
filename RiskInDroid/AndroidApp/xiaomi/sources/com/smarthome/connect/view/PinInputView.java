package com.smarthome.connect.view;

import _m_j.gpc;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class PinInputView extends LinearLayout {
    private static final long[] O0000OoO = {100, 500};

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5649O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public String O00000oO;
    public PinInputItem[] O00000oo;
    public PinInputItem O0000O0o;
    public boolean O0000OOo;
    public Runnable O0000Oo;
    public Handler O0000Oo0;
    private int O0000Ooo;

    public PinInputView(Context context) {
        this(context, null);
    }

    public PinInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5649O000000o = 4;
        this.O00000Oo = R.drawable.miconnect_pin_input_item;
        this.O0000Ooo = 47;
        this.O00000o = 0;
        this.O00000oO = "";
        this.O0000OOo = false;
        this.O0000Oo = new Runnable() {
            /* class com.smarthome.connect.view.PinInputView.AnonymousClass1 */

            public final void run() {
                if (PinInputView.this.O0000OOo) {
                    if (PinInputView.this.O0000O0o != null) {
                        if (PinInputView.this.O0000O0o.isEnabled()) {
                            PinInputView.this.O0000O0o.setEnabled(false);
                        } else {
                            PinInputView.this.O0000O0o.setEnabled(true);
                        }
                    }
                    PinInputView.this.O0000Oo0.postDelayed(PinInputView.this.O0000Oo, 600);
                }
            }
        };
        this.O0000Oo0 = new Handler();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.input_height, R.attr.input_view_res_id, R.attr.input_width, R.attr.number, R.attr.spacing}, i, 0);
            this.O00000Oo = obtainStyledAttributes.getResourceId(1, R.drawable.miconnect_pin_input_item);
            this.O0000Ooo = obtainStyledAttributes.getInt(2, 47);
            setSpacing(obtainStyledAttributes.getDimensionPixelSize(4, 0));
            setPincodeNumber(obtainStyledAttributes.getInt(3, 4));
            obtainStyledAttributes.recycle();
        }
        this.O0000Oo0.postDelayed(this.O0000Oo, 1000);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int i3 = this.O00000o;
        int i4 = this.f5649O000000o;
        this.O00000o0 = (measuredWidth - (i3 * (i4 - 1))) / i4;
        setMeasuredDimension(measuredWidth, this.O00000o0 + getPaddingTop() + getPaddingBottom());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).measure(0, 0);
        }
    }

    public void setSpacing(int i) {
        this.O00000o = i;
    }

    public void setPincodeNumber(int i) {
        this.f5649O000000o = i;
        removeAllViews();
        this.O00000oo = new PinInputItem[this.f5649O000000o];
        setOrientation(0);
        for (int i2 = 0; i2 < this.f5649O000000o; i2++) {
            this.O00000oo[i2] = new PinInputItem(getContext());
            addView(this.O00000oo[i2]);
            if (this.O00000o > 0 && i2 != this.f5649O000000o - 1) {
                addView(new O000000o(getContext()));
            }
        }
        this.O00000oo[0].showHighlight();
        this.O0000O0o = this.O00000oo[0];
    }

    public int getPincodeNumber() {
        return this.f5649O000000o;
    }

    public final void O000000o() {
        for (PinInputItem pinInputItem : this.O00000oo) {
            pinInputItem.clearPin();
            pinInputItem.clearHighlight();
        }
        this.O00000oo[0].showHighlight();
        this.O0000O0o = this.O00000oo[0];
        this.O00000oO = "";
    }

    public String getPinCode() {
        return this.O00000oO;
    }

    class O000000o extends View {
        public O000000o(Context context) {
            super(context);
            setLayoutParams(new LinearLayout.LayoutParams(gpc.O000000o(getContext(), (float) PinInputView.this.O00000o), -2));
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i, int i2) {
            setMeasuredDimension(PinInputView.this.O00000o, 1);
        }
    }

    public class PinInputItem extends ImageView {
        public PinInputItem(Context context) {
            super(context);
            init();
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            setMeasuredDimension(PinInputView.this.O00000o0, PinInputView.this.O00000o0);
        }

        private void init() {
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setImageResource(PinInputView.this.O00000Oo);
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
        this.O0000OOo = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000OOo = false;
    }
}
