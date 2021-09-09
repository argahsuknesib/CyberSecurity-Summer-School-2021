package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gwg;
import _m_j.htr;
import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class ApDevicePasswdChooseStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    private WifiManager f11631O000000o;
    private ScanResult O00000Oo;
    @BindView(6643)
    ImageView mDeviceIcon;
    @BindView(6925)
    TextView mDeviceInfo;
    @BindView(6986)
    Button mNextBtn;
    @BindView(7808)
    EditText mPasswordEditor;
    @BindView(7809)
    EditText mPasswordEditorAbove;
    @BindView(7810)
    TextView mPasswordToggle;
    @BindView(6920)
    View mReturnBtn;
    @BindView(7517)
    View mTitleBar;
    @BindView(6835)
    TextView mWifiChooser;
    @BindView(7813)
    View mWifiPassContainer;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(Context context) {
        htr.O000000o().O00000Oo("start_time", Long.valueOf(System.currentTimeMillis()));
        O000000o(context, (int) R.layout.smart_config_ap_passwd_choose_step);
        gwg.O000000o(this.mTitleBar);
        this.f11631O000000o = (WifiManager) context.getSystemService("wifi");
        this.mNextBtn.setText((int) R.string.next_button);
        this.mDeviceInfo.setText(String.format(context.getString(R.string.kuailian_main_title_2), new Object[0]));
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApDevicePasswdChooseStep.AnonymousClass1 */

            public final void onClick(View view) {
                ApDevicePasswdChooseStep.this.b_(false);
            }
        });
        this.mDeviceIcon.setImageResource(R.drawable.kuailian_wifi_icon);
        this.O00000Oo = (ScanResult) htr.O000000o().O000000o("device_ap", null);
        ScanResult scanResult = this.O00000Oo;
        if (scanResult == null) {
            b_(false);
            return;
        }
        this.mWifiChooser.setText(scanResult.SSID);
        this.mPasswordEditor.setVisibility(0);
        this.mPasswordEditorAbove.setVisibility(8);
        this.mPasswordToggle.setEnabled(true);
        this.mNextBtn.setEnabled(false);
        htr.O000000o().O00000Oo("miui_class");
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApDevicePasswdChooseStep.AnonymousClass2 */

            public final void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) ApDevicePasswdChooseStep.this.O000O0oo.getSystemService("input_method");
                if (inputMethodManager.isActive() && (ApDevicePasswdChooseStep.this.O000O0oo instanceof Activity) && ((Activity) ApDevicePasswdChooseStep.this.O000O0oo).getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(((Activity) ApDevicePasswdChooseStep.this.O000O0oo).getCurrentFocus().getWindowToken(), 2);
                }
                htr.O000000o().O00000Oo("selected_ap_passwd", ApDevicePasswdChooseStep.this.mPasswordEditor.getText().toString());
                ApDevicePasswdChooseStep.this.O000O0o();
            }
        });
        this.mPasswordEditor.setText("");
        this.mPasswordEditor.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApDevicePasswdChooseStep.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                ApDevicePasswdChooseStep apDevicePasswdChooseStep = ApDevicePasswdChooseStep.this;
                if (apDevicePasswdChooseStep.mWifiPassContainer.getVisibility() == 8 || apDevicePasswdChooseStep.mPasswordEditorAbove.getVisibility() == 0 || !TextUtils.isEmpty(apDevicePasswdChooseStep.mPasswordEditor.getText().toString())) {
                    apDevicePasswdChooseStep.mNextBtn.setEnabled(true);
                } else {
                    apDevicePasswdChooseStep.mNextBtn.setEnabled(false);
                }
            }
        });
        this.mPasswordToggle.setEnabled(true);
        this.mPasswordToggle.setSelected(true);
        this.mPasswordToggle.setText((int) R.string.smart_config_hide_passwd);
        this.mPasswordToggle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApDevicePasswdChooseStep.AnonymousClass4 */

            public final void onClick(View view) {
                int selectionStart = ApDevicePasswdChooseStep.this.mPasswordEditor.getSelectionStart();
                if (!ApDevicePasswdChooseStep.this.mPasswordToggle.isSelected()) {
                    ApDevicePasswdChooseStep.this.mPasswordEditor.setInputType(144);
                    ApDevicePasswdChooseStep.this.mPasswordToggle.setSelected(true);
                    ApDevicePasswdChooseStep.this.mPasswordToggle.setText((int) R.string.smart_config_hide_passwd);
                } else {
                    ApDevicePasswdChooseStep.this.mPasswordEditor.setInputType(129);
                    ApDevicePasswdChooseStep.this.mPasswordToggle.setSelected(false);
                    ApDevicePasswdChooseStep.this.mPasswordToggle.setText((int) R.string.smart_config_show_passwd);
                }
                ApDevicePasswdChooseStep.this.mPasswordEditor.setSelection(selectionStart);
            }
        });
    }

    public final boolean G_() {
        b_(false);
        return true;
    }
}
