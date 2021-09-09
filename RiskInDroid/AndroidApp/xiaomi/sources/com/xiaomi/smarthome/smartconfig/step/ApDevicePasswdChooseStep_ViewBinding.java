package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ApDevicePasswdChooseStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ApDevicePasswdChooseStep f11636O000000o;

    public ApDevicePasswdChooseStep_ViewBinding(ApDevicePasswdChooseStep apDevicePasswdChooseStep, View view) {
        this.f11636O000000o = apDevicePasswdChooseStep;
        apDevicePasswdChooseStep.mDeviceIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'mDeviceIcon'", ImageView.class);
        apDevicePasswdChooseStep.mDeviceInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mDeviceInfo'", TextView.class);
        apDevicePasswdChooseStep.mNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextBtn'", Button.class);
        apDevicePasswdChooseStep.mWifiChooser = (TextView) Utils.findRequiredViewAsType(view, R.id.login_wifi_ssid_chooser, "field 'mWifiChooser'", TextView.class);
        apDevicePasswdChooseStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        apDevicePasswdChooseStep.mPasswordEditor = (EditText) Utils.findRequiredViewAsType(view, R.id.wifi_password_editor, "field 'mPasswordEditor'", EditText.class);
        apDevicePasswdChooseStep.mPasswordEditorAbove = (EditText) Utils.findRequiredViewAsType(view, R.id.wifi_password_editor_above, "field 'mPasswordEditorAbove'", EditText.class);
        apDevicePasswdChooseStep.mWifiPassContainer = Utils.findRequiredView(view, R.id.wifi_setting_pass_container, "field 'mWifiPassContainer'");
        apDevicePasswdChooseStep.mPasswordToggle = (TextView) Utils.findRequiredViewAsType(view, R.id.wifi_password_toggle, "field 'mPasswordToggle'", TextView.class);
        apDevicePasswdChooseStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
    }

    public void unbind() {
        ApDevicePasswdChooseStep apDevicePasswdChooseStep = this.f11636O000000o;
        if (apDevicePasswdChooseStep != null) {
            this.f11636O000000o = null;
            apDevicePasswdChooseStep.mDeviceIcon = null;
            apDevicePasswdChooseStep.mDeviceInfo = null;
            apDevicePasswdChooseStep.mNextBtn = null;
            apDevicePasswdChooseStep.mWifiChooser = null;
            apDevicePasswdChooseStep.mTitleBar = null;
            apDevicePasswdChooseStep.mPasswordEditor = null;
            apDevicePasswdChooseStep.mPasswordEditorAbove = null;
            apDevicePasswdChooseStep.mWifiPassContainer = null;
            apDevicePasswdChooseStep.mPasswordToggle = null;
            apDevicePasswdChooseStep.mReturnBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
