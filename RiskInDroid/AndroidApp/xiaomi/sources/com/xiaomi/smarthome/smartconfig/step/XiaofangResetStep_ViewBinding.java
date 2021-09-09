package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;

public class XiaofangResetStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private XiaofangResetStep f11845O000000o;

    public XiaofangResetStep_ViewBinding(XiaofangResetStep xiaofangResetStep, View view) {
        this.f11845O000000o = xiaofangResetStep;
        xiaofangResetStep.mWebView = (SmartHomeWebView) Utils.findRequiredViewAsType(view, R.id.kuailian_reset_web_view, "field 'mWebView'", SmartHomeWebView.class);
        xiaofangResetStep.mButton = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mButton'", Button.class);
        xiaofangResetStep.mCheck = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mCheck'", CheckBox.class);
        xiaofangResetStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        xiaofangResetStep.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
    }

    public void unbind() {
        XiaofangResetStep xiaofangResetStep = this.f11845O000000o;
        if (xiaofangResetStep != null) {
            this.f11845O000000o = null;
            xiaofangResetStep.mWebView = null;
            xiaofangResetStep.mButton = null;
            xiaofangResetStep.mCheck = null;
            xiaofangResetStep.mReturnBtn = null;
            xiaofangResetStep.mTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
