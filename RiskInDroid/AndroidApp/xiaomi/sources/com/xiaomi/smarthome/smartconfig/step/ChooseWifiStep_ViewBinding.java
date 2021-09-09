package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.library.common.widget.ResizeLayout;

public class ChooseWifiStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ChooseWifiStep f11730O000000o;

    public ChooseWifiStep_ViewBinding(ChooseWifiStep chooseWifiStep, View view) {
        this.f11730O000000o = chooseWifiStep;
        chooseWifiStep.mDeviceIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'mDeviceIcon'", ImageView.class);
        chooseWifiStep.mDeviceInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mDeviceInfo'", TextView.class);
        chooseWifiStep.mNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextBtn'", Button.class);
        chooseWifiStep.mWifiChooser = (TextView) Utils.findRequiredViewAsType(view, R.id.login_wifi_ssid_chooser, "field 'mWifiChooser'", TextView.class);
        chooseWifiStep.mScanResultList = (CustomPullDownRefreshLinearLayout) Utils.findRequiredViewAsType(view, R.id.wifi_refresh_container, "field 'mScanResultList'", CustomPullDownRefreshLinearLayout.class);
        chooseWifiStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        chooseWifiStep.mPasswordEditor = (EditText) Utils.findRequiredViewAsType(view, R.id.wifi_password_editor, "field 'mPasswordEditor'", EditText.class);
        chooseWifiStep.mPasswordEditorAbove = (EditText) Utils.findRequiredViewAsType(view, R.id.wifi_password_editor_above, "field 'mPasswordEditorAbove'", EditText.class);
        chooseWifiStep.mCheckbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_save_passwd, "field 'mCheckbox'", CheckBox.class);
        chooseWifiStep.mScanWifi = Utils.findRequiredView(view, R.id.searching_text, "field 'mScanWifi'");
        chooseWifiStep.mWifiPassContainer = Utils.findRequiredView(view, R.id.wifi_setting_pass_container, "field 'mWifiPassContainer'");
        chooseWifiStep.mConnectList = (ListView) Utils.findRequiredViewAsType(view, R.id.conn_wifi_list, "field 'mConnectList'", ListView.class);
        chooseWifiStep.mUnConnectList = (ListView) Utils.findRequiredViewAsType(view, R.id.unconn_wifi_list, "field 'mUnConnectList'", ListView.class);
        chooseWifiStep.mPasswordToggle = (TextView) Utils.findRequiredViewAsType(view, R.id.wifi_password_toggle, "field 'mPasswordToggle'", TextView.class);
        chooseWifiStep.mShowScanResultToggle = (ImageView) Utils.findRequiredViewAsType(view, R.id.wifi_ssid_toggle, "field 'mShowScanResultToggle'", ImageView.class);
        chooseWifiStep.mResizeLayout = (ResizeLayout) Utils.findRequiredViewAsType(view, R.id.choose_wifi_ui, "field 'mResizeLayout'", ResizeLayout.class);
        chooseWifiStep.mScrollWifiList = (ScrollView) Utils.findRequiredViewAsType(view, R.id.wifi_list_scroll_view, "field 'mScrollWifiList'", ScrollView.class);
        chooseWifiStep.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        chooseWifiStep.mTopContainer = Utils.findRequiredView(view, R.id.choose_wifi_top_container, "field 'mTopContainer'");
        chooseWifiStep.mTvSubDesc = Utils.findRequiredView(view, R.id.sub_desc, "field 'mTvSubDesc'");
        chooseWifiStep.mTopMask = Utils.findRequiredView(view, R.id.top_mask, "field 'mTopMask'");
        chooseWifiStep.mLicenseCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mLicenseCheckBox'", CheckBox.class);
        chooseWifiStep.mLicenseTv = (TextView) Utils.findRequiredViewAsType(view, R.id.agree_license, "field 'mLicenseTv'", TextView.class);
    }

    public void unbind() {
        ChooseWifiStep chooseWifiStep = this.f11730O000000o;
        if (chooseWifiStep != null) {
            this.f11730O000000o = null;
            chooseWifiStep.mDeviceIcon = null;
            chooseWifiStep.mDeviceInfo = null;
            chooseWifiStep.mNextBtn = null;
            chooseWifiStep.mWifiChooser = null;
            chooseWifiStep.mScanResultList = null;
            chooseWifiStep.mTitleBar = null;
            chooseWifiStep.mPasswordEditor = null;
            chooseWifiStep.mPasswordEditorAbove = null;
            chooseWifiStep.mCheckbox = null;
            chooseWifiStep.mScanWifi = null;
            chooseWifiStep.mWifiPassContainer = null;
            chooseWifiStep.mConnectList = null;
            chooseWifiStep.mUnConnectList = null;
            chooseWifiStep.mPasswordToggle = null;
            chooseWifiStep.mShowScanResultToggle = null;
            chooseWifiStep.mResizeLayout = null;
            chooseWifiStep.mScrollWifiList = null;
            chooseWifiStep.mReturnBtn = null;
            chooseWifiStep.mTopContainer = null;
            chooseWifiStep.mTvSubDesc = null;
            chooseWifiStep.mTopMask = null;
            chooseWifiStep.mLicenseCheckBox = null;
            chooseWifiStep.mLicenseTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
