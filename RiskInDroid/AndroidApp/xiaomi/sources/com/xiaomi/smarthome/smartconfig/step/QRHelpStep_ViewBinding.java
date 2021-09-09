package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class QRHelpStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private QRHelpStep f11799O000000o;

    public QRHelpStep_ViewBinding(QRHelpStep qRHelpStep, View view) {
        this.f11799O000000o = qRHelpStep;
        qRHelpStep.mOkButton = (Button) Utils.findRequiredViewAsType(view, R.id.ok_btn, "field 'mOkButton'", Button.class);
    }

    public void unbind() {
        QRHelpStep qRHelpStep = this.f11799O000000o;
        if (qRHelpStep != null) {
            this.f11799O000000o = null;
            qRHelpStep.mOkButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
