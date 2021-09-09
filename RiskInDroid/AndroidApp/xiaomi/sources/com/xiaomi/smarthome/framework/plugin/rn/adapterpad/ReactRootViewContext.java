package com.xiaomi.smarthome.framework.plugin.rn.adapterpad;

import _m_j.fxh;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

public class ReactRootViewContext extends ContextWrapper {

    /* renamed from: O000000o  reason: collision with root package name */
    private fxh f8184O000000o;
    private Activity O00000Oo;

    public ReactRootViewContext(Context context) {
        super(context);
    }

    public Resources getResources() {
        if (this.f8184O000000o == null) {
            synchronized (this) {
                if (this.f8184O000000o == null) {
                    this.f8184O000000o = new fxh(getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
                    this.f8184O000000o.O000000o(this.O00000Oo);
                }
            }
        }
        return this.f8184O000000o;
    }

    public ReactRootViewContext setCurrentActivity(Activity activity) {
        this.O00000Oo = activity;
        fxh fxh = this.f8184O000000o;
        if (fxh != null) {
            fxh.O000000o(activity);
        }
        return this;
    }
}
