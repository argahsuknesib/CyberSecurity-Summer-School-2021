package com.smarthome.connect.stepview;

import android.content.Context;
import android.view.View;

public abstract class BaseStepView {

    /* renamed from: O000000o  reason: collision with root package name */
    protected View f5631O000000o;
    private Context O00000Oo;

    /* access modifiers changed from: protected */
    public abstract View O000000o(Context context);

    public BaseStepView(Context context) {
        this.O00000Oo = context;
        this.f5631O000000o = O000000o(context);
    }

    public final View O000000o() {
        return this.f5631O000000o;
    }
}
