package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ResizeLayout;

public class WifiExtApPasswdInputStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private WifiExtApPasswdInputStep f11840O000000o;

    public WifiExtApPasswdInputStep_ViewBinding(WifiExtApPasswdInputStep wifiExtApPasswdInputStep, View view) {
        this.f11840O000000o = wifiExtApPasswdInputStep;
        wifiExtApPasswdInputStep.mDeviceIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'mDeviceIcon'", ImageView.class);
        wifiExtApPasswdInputStep.mDeviceInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mDeviceInfo'", TextView.class);
        wifiExtApPasswdInputStep.mNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextBtn'", Button.class);
        wifiExtApPasswdInputStep.mWifiChooser = (EditText) Utils.findRequiredViewAsType(view, R.id.login_wifi_ssid_inputer, "field 'mWifiChooser'", EditText.class);
        wifiExtApPasswdInputStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        wifiExtApPasswdInputStep.mPasswordEditor = (EditText) Utils.findRequiredViewAsType(view, R.id.wifi_password_editor, "field 'mPasswordEditor'", EditText.class);
        wifiExtApPasswdInputStep.mIvPwdShow = (ImageView) Utils.findRequiredViewAsType(view, R.id.pwd_show, "field 'mIvPwdShow'", ImageView.class);
        wifiExtApPasswdInputStep.mWifiPassContainer = Utils.findRequiredView(view, R.id.wifi_setting_pass_container, "field 'mWifiPassContainer'");
        wifiExtApPasswdInputStep.mReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'", ImageView.class);
        wifiExtApPasswdInputStep.mContentView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.choose_wifi_ui, "field 'mContentView'", RelativeLayout.class);
        wifiExtApPasswdInputStep.mHeadView = (ResizeLayout) Utils.findRequiredViewAsType(view, R.id.icon_container, "field 'mHeadView'", ResizeLayout.class);
    }

    public void unbind() {
        WifiExtApPasswdInputStep wifiExtApPasswdInputStep = this.f11840O000000o;
        if (wifiExtApPasswdInputStep != null) {
            this.f11840O000000o = null;
            wifiExtApPasswdInputStep.mDeviceIcon = null;
            wifiExtApPasswdInputStep.mDeviceInfo = null;
            wifiExtApPasswdInputStep.mNextBtn = null;
            wifiExtApPasswdInputStep.mWifiChooser = null;
            wifiExtApPasswdInputStep.mTitleBar = null;
            wifiExtApPasswdInputStep.mPasswordEditor = null;
            wifiExtApPasswdInputStep.mIvPwdShow = null;
            wifiExtApPasswdInputStep.mWifiPassContainer = null;
            wifiExtApPasswdInputStep.mReturnBtn = null;
            wifiExtApPasswdInputStep.mContentView = null;
            wifiExtApPasswdInputStep.mHeadView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
