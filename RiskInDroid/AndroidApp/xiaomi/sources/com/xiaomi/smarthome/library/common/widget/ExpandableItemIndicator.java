package com.xiaomi.smarthome.library.common.widget;

import _m_j.gqo;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;

public class ExpandableItemIndicator extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f9179O000000o;

    public static abstract class O000000o {
        public abstract void O000000o(Context context, ExpandableItemIndicator expandableItemIndicator);

        public abstract void O000000o(boolean z);

        protected O000000o() {
        }
    }

    public ExpandableItemIndicator(Context context) {
        super(context);
        O000000o(context);
    }

    public ExpandableItemIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public ExpandableItemIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.f9179O000000o = new gqo();
        this.f9179O000000o.O000000o(context, this);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    public final void setExpandedState$25decb5(boolean z) {
        this.f9179O000000o.O000000o(z);
    }
}
