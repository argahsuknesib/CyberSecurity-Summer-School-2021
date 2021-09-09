package com.xiaomi.smarthome.framework.page.verify;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class SecuritySettingActivityV2_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SecuritySettingActivityV2 f7995O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;

    public SecuritySettingActivityV2_ViewBinding(final SecuritySettingActivityV2 securitySettingActivityV2, View view) {
        this.f7995O000000o = securitySettingActivityV2;
        securitySettingActivityV2.container = Utils.findRequiredView(view, R.id.security_setting_main_container, "field 'container'");
        securitySettingActivityV2.vTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'vTitle'", TextView.class);
        securitySettingActivityV2.vBigTitle = Utils.findRequiredView(view, R.id.security_setting_title_big, "field 'vBigTitle'");
        securitySettingActivityV2.tvBigTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.security_setting_title_big_text, "field 'tvBigTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.security_setting_open_pincode, "field 'vOpenPinCode' and method 'onClickOpenPinCode'");
        securitySettingActivityV2.vOpenPinCode = findRequiredView;
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                securitySettingActivityV2.onClickOpenPinCode();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.security_setting_close_pincode, "field 'vClosePinCode' and method 'onClickClosePinCode'");
        securitySettingActivityV2.vClosePinCode = findRequiredView2;
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                securitySettingActivityV2.onClickClosePinCode();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.security_setting_change_pincode, "field 'vChangePinCode' and method 'onClickChangePinCode'");
        securitySettingActivityV2.vChangePinCode = findRequiredView3;
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                securitySettingActivityV2.onClickChangePinCode();
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.security_setting_fingerprint_item, "field 'vFingerPrintSetting' and method 'onClickFingerPrintSetting'");
        securitySettingActivityV2.vFingerPrintSetting = findRequiredView4;
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                securitySettingActivityV2.onClickFingerPrintSetting();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.security_setting_fingerprint_switch, "field 'vFingerPrintSwitch' and method 'onClickFingerPrintSetting'");
        securitySettingActivityV2.vFingerPrintSwitch = (SwitchButton) Utils.castView(findRequiredView5, R.id.security_setting_fingerprint_switch, "field 'vFingerPrintSwitch'", SwitchButton.class);
        this.O00000oo = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass5 */

            public final void doClick(View view) {
                securitySettingActivityV2.onClickFingerPrintSetting();
            }
        });
        securitySettingActivityV2.vDivider = Utils.findRequiredView(view, R.id.security_setting_divider, "field 'vDivider'");
        View findRequiredView6 = Utils.findRequiredView(view, R.id.security_setting_apply_all_devices_item, "field 'vApplyDeviceSetting' and method 'showSelectFilterDialog'");
        securitySettingActivityV2.vApplyDeviceSetting = findRequiredView6;
        this.O0000O0o = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass6 */

            public final void doClick(View view) {
                securitySettingActivityV2.showSelectFilterDialog();
            }
        });
        securitySettingActivityV2.rvAllDevices = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.security_setting_rv_apply_devices, "field 'rvAllDevices'", RecyclerView.class);
        securitySettingActivityV2.mAppBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.app_bar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
        securitySettingActivityV2.mFilterResultEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_filter_result_empty, "field 'mFilterResultEmpty'", LinearLayout.class);
        securitySettingActivityV2.mFilterNoDeviceText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_setting_filter_no_device, "field 'mFilterNoDeviceText'", TextView.class);
        securitySettingActivityV2.mFilterTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.security_filter_title, "field 'mFilterTitle'", TextView.class);
        securitySettingActivityV2.mFilterIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_setting_filter_icon, "field 'mFilterIcon'", ImageView.class);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClickBack'");
        this.O0000OOo = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2_ViewBinding.AnonymousClass7 */

            public final void doClick(View view) {
                securitySettingActivityV2.onClickBack();
            }
        });
    }

    public void unbind() {
        SecuritySettingActivityV2 securitySettingActivityV2 = this.f7995O000000o;
        if (securitySettingActivityV2 != null) {
            this.f7995O000000o = null;
            securitySettingActivityV2.container = null;
            securitySettingActivityV2.vTitle = null;
            securitySettingActivityV2.vBigTitle = null;
            securitySettingActivityV2.tvBigTitle = null;
            securitySettingActivityV2.vOpenPinCode = null;
            securitySettingActivityV2.vClosePinCode = null;
            securitySettingActivityV2.vChangePinCode = null;
            securitySettingActivityV2.vFingerPrintSetting = null;
            securitySettingActivityV2.vFingerPrintSwitch = null;
            securitySettingActivityV2.vDivider = null;
            securitySettingActivityV2.vApplyDeviceSetting = null;
            securitySettingActivityV2.rvAllDevices = null;
            securitySettingActivityV2.mAppBarLayout = null;
            securitySettingActivityV2.mFilterResultEmpty = null;
            securitySettingActivityV2.mFilterNoDeviceText = null;
            securitySettingActivityV2.mFilterTitle = null;
            securitySettingActivityV2.mFilterIcon = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
