package com.mibi.sdk.pay.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mibi.sdk.component.recharge.RechargeType;

public class PayListItem extends LinearLayout implements Checkable {
    private static final int[] O00000oO = {16842912};

    /* renamed from: O000000o  reason: collision with root package name */
    public ImageView f5160O000000o;
    public TextView O00000Oo;
    public RechargeType O00000o;
    public TextView O00000o0;
    private boolean O00000oo;

    public PayListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RechargeType getPayType() {
        return this.O00000o;
    }

    public void setChecked(boolean z) {
        if (this.O00000oo != z) {
            this.O00000oo = z;
            refreshDrawableState();
        }
    }

    public boolean isChecked() {
        return this.O00000oo;
    }

    public void toggle() {
        setChecked(!this.O00000oo);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        if (!this.O00000oo) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        mergeDrawableStates(onCreateDrawableState, O00000oO);
        return onCreateDrawableState;
    }
}
