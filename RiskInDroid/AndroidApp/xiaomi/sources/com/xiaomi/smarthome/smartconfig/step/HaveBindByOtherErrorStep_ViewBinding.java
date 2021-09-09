package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class HaveBindByOtherErrorStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private HaveBindByOtherErrorStep f11766O000000o;

    public HaveBindByOtherErrorStep_ViewBinding(HaveBindByOtherErrorStep haveBindByOtherErrorStep, View view) {
        this.f11766O000000o = haveBindByOtherErrorStep;
        haveBindByOtherErrorStep.mOkBtn = Utils.findRequiredView(view, R.id.ok_btn, "field 'mOkBtn'");
    }

    public void unbind() {
        HaveBindByOtherErrorStep haveBindByOtherErrorStep = this.f11766O000000o;
        if (haveBindByOtherErrorStep != null) {
            this.f11766O000000o = null;
            haveBindByOtherErrorStep.mOkBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
