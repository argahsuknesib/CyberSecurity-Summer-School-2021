package com.transitionseverywhere;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

@TargetApi(14)
public abstract class Visibility extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f5912O000000o = {"android:visibility:visibility", "android:visibility:parent"};
    private int O00000Oo = -1;
    private int O00000o0 = -1;
    int O00oOoOo = 3;

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.transitionVisibilityMode});
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            O000000o(i);
        }
    }

    public final Visibility O000000o(int i) {
        if ((i & -4) == 0) {
            this.O00oOoOo = i;
            return this;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
