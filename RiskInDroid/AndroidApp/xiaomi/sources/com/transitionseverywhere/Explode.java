package com.transitionseverywhere;

import _m_j.drc;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

@TargetApi(14)
public class Explode extends Visibility {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final TimeInterpolator f5906O000000o = new DecelerateInterpolator();
    private static final TimeInterpolator O00000Oo = new AccelerateInterpolator();
    private int[] O00000o0 = new int[2];

    public Explode() {
        O000000o(new drc());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(new drc());
    }
}
