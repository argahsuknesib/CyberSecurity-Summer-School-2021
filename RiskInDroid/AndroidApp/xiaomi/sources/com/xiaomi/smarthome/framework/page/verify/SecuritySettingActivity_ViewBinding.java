package com.xiaomi.smarthome.framework.page.verify;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class SecuritySettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SecuritySettingActivity f8003O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private View O0000Oo;
    private View O0000Oo0;

    public SecuritySettingActivity_ViewBinding(final SecuritySettingActivity securitySettingActivity, View view) {
        this.f8003O000000o = securitySettingActivity;
        securitySettingActivity.vTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'vTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.xiaomi_sm_open_password, "field 'vPasswordOpen' and method 'onClickPasswordOpen'");
        securitySettingActivity.vPasswordOpen = findRequiredView;
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                securitySettingActivity.onClickPasswordOpen();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.xiaomi_sm_close_password, "field 'vPasswordClose' and method 'onClickPasswordClose'");
        securitySettingActivity.vPasswordClose = findRequiredView2;
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                securitySettingActivity.onClickPasswordClose();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.xiaomi_sm_change_password, "field 'vPasswordChange' and method 'onClickPasswordChange'");
        securitySettingActivity.vPasswordChange = findRequiredView3;
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                securitySettingActivity.onClickPasswordChange();
            }
        });
        securitySettingActivity.vPasswordChangeTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.xiaomi_sm_change_password_title, "field 'vPasswordChangeTitle'", TextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.xiaomi_sm_show_secure_pin, "field 'vShowSecurePin' and method 'onClickSecurePin'");
        securitySettingActivity.vShowSecurePin = findRequiredView4;
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                securitySettingActivity.onClickSecurePin();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.xiaomi_sm_show_secure_pin_switch, "field 'vSecurePinSwitch' and method 'onClickSecurePin'");
        securitySettingActivity.vSecurePinSwitch = (SwitchButton) Utils.castView(findRequiredView5, R.id.xiaomi_sm_show_secure_pin_switch, "field 'vSecurePinSwitch'", SwitchButton.class);
        this.O00000oo = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass5 */

            public final void doClick(View view) {
                securitySettingActivity.onClickSecurePin();
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.xiaomi_sm_change_secure_pin, "field 'vChangeSecurePin' and method 'onClickChangeSecurePin'");
        securitySettingActivity.vChangeSecurePin = findRequiredView6;
        this.O0000O0o = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass6 */

            public final void doClick(View view) {
                securitySettingActivity.onClickChangeSecurePin();
            }
        });
        securitySettingActivity.vFingerPrintTitle = Utils.findRequiredView(view, R.id.xiaomi_sm_fingerprint_title, "field 'vFingerPrintTitle'");
        View findRequiredView7 = Utils.findRequiredView(view, R.id.xiaomi_sm_fingerprint_setting, "field 'vFingerPrintSetting' and method 'onClickFingerPrintSetting'");
        securitySettingActivity.vFingerPrintSetting = findRequiredView7;
        this.O0000OOo = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass7 */

            public final void doClick(View view) {
                securitySettingActivity.onClickFingerPrintSetting();
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.xiaomi_sm_fingerprint_setting_switch, "field 'vFingerPrintSwitch' and method 'onClickFingerPrintSetting'");
        securitySettingActivity.vFingerPrintSwitch = (SwitchButton) Utils.castView(findRequiredView8, R.id.xiaomi_sm_fingerprint_setting_switch, "field 'vFingerPrintSwitch'", SwitchButton.class);
        this.O0000Oo0 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass8 */

            public final void doClick(View view) {
                securitySettingActivity.onClickFingerPrintSetting();
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClickBack'");
        this.O0000Oo = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity_ViewBinding.AnonymousClass9 */

            public final void doClick(View view) {
                securitySettingActivity.onClickBack();
            }
        });
    }

    public void unbind() {
        SecuritySettingActivity securitySettingActivity = this.f8003O000000o;
        if (securitySettingActivity != null) {
            this.f8003O000000o = null;
            securitySettingActivity.vTitle = null;
            securitySettingActivity.vPasswordOpen = null;
            securitySettingActivity.vPasswordClose = null;
            securitySettingActivity.vPasswordChange = null;
            securitySettingActivity.vPasswordChangeTitle = null;
            securitySettingActivity.vShowSecurePin = null;
            securitySettingActivity.vSecurePinSwitch = null;
            securitySettingActivity.vChangeSecurePin = null;
            securitySettingActivity.vFingerPrintTitle = null;
            securitySettingActivity.vFingerPrintSetting = null;
            securitySettingActivity.vFingerPrintSwitch = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            this.O00000oO.setOnClickListener(null);
            this.O00000oO = null;
            this.O00000oo.setOnClickListener(null);
            this.O00000oo = null;
            this.O0000O0o.setOnClickListener(null);
            this.O0000O0o = null;
            this.O0000OOo.setOnClickListener(null);
            this.O0000OOo = null;
            this.O0000Oo0.setOnClickListener(null);
            this.O0000Oo0 = null;
            this.O0000Oo.setOnClickListener(null);
            this.O0000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
