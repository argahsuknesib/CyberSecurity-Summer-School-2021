package com.xiaomi.smarthome.newui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

public class MiSimpleDraweeView extends SimpleDraweeView {
    public String model;

    public MiSimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
    }

    public MiSimpleDraweeView(Context context) {
        super(context);
    }

    public MiSimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MiSimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MiSimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
