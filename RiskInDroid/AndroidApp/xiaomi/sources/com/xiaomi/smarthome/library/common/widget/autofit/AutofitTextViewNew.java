package com.xiaomi.smarthome.library.common.widget.autofit;

import _m_j.gqx;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class AutofitTextViewNew extends TextView {
    private final gqx mAutofitHelper = new gqx(this);

    public AutofitTextViewNew(Context context) {
        super(context);
        this.mAutofitHelper.O000000o(null, 0);
    }

    public AutofitTextViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAutofitHelper.O000000o(attributeSet, 0);
    }

    public AutofitTextViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAutofitHelper.O000000o(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        gqx gqx = this.mAutofitHelper;
        if (gqx != null && !gqx.O00000Oo) {
            Context context = gqx.f18163O000000o.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            gqx.O000000o(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
    }
}
