package com.xiaomi.smarthome.framework.page.verify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class RNSecuritySettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private RNSecuritySettingActivity f7977O000000o;
    private View O00000Oo;

    public RNSecuritySettingActivity_ViewBinding(final RNSecuritySettingActivity rNSecuritySettingActivity, View view) {
        this.f7977O000000o = rNSecuritySettingActivity;
        rNSecuritySettingActivity.switchButton = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.security_setting_rn_pincode_switch, "field 'switchButton'", SwitchButton.class);
        rNSecuritySettingActivity.imgArrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.security_setting_rn_pincode_arrow, "field 'imgArrow'", ImageView.class);
        rNSecuritySettingActivity.vOpenPinCode = Utils.findRequiredView(view, R.id.security_setting_rn_pincode_item, "field 'vOpenPinCode'");
        rNSecuritySettingActivity.tvPinStatusTip = (TextView) Utils.findRequiredViewAsType(view, R.id.security_setting_rn_pincode_status_tip, "field 'tvPinStatusTip'", TextView.class);
        rNSecuritySettingActivity.tvBigTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.security_setting_rn_title_big, "field 'tvBigTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClickBack'");
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.RNSecuritySettingActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                rNSecuritySettingActivity.onClickBack();
            }
        });
    }

    public void unbind() {
        RNSecuritySettingActivity rNSecuritySettingActivity = this.f7977O000000o;
        if (rNSecuritySettingActivity != null) {
            this.f7977O000000o = null;
            rNSecuritySettingActivity.switchButton = null;
            rNSecuritySettingActivity.imgArrow = null;
            rNSecuritySettingActivity.vOpenPinCode = null;
            rNSecuritySettingActivity.tvPinStatusTip = null;
            rNSecuritySettingActivity.tvBigTitle = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
