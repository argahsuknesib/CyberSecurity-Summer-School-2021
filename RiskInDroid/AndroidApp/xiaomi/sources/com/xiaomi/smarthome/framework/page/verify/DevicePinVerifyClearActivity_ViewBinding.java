package com.xiaomi.smarthome.framework.page.verify;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;

public class DevicePinVerifyClearActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DevicePinVerifyClearActivity f7958O000000o;
    private View O00000Oo;

    public DevicePinVerifyClearActivity_ViewBinding(final DevicePinVerifyClearActivity devicePinVerifyClearActivity, View view) {
        this.f7958O000000o = devicePinVerifyClearActivity;
        devicePinVerifyClearActivity.layoutDeviceContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pin_clear_device_container, "field 'layoutDeviceContainer'", LinearLayout.class);
        devicePinVerifyClearActivity.vPinSoftKeyboard = (PinSoftKeyboard) Utils.findRequiredViewAsType(view, R.id.pin_clear_soft_keyboard, "field 'vPinSoftKeyboard'", PinSoftKeyboard.class);
        devicePinVerifyClearActivity.vPinInputView = (PinInputView) Utils.findRequiredViewAsType(view, R.id.pin_clear_pin_inputs, "field 'vPinInputView'", PinInputView.class);
        devicePinVerifyClearActivity.tvErrorTips = (TextView) Utils.findRequiredViewAsType(view, R.id.pin_clear_incorrect_tips, "field 'tvErrorTips'", TextView.class);
        devicePinVerifyClearActivity.tvMore = (TextView) Utils.findRequiredViewAsType(view, R.id.more_than_3_devices_point, "field 'tvMore'", TextView.class);
        devicePinVerifyClearActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.pincode_clear_tip, "field 'tvTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClickBack'");
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyClearActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                devicePinVerifyClearActivity.onClickBack();
            }
        });
    }

    public void unbind() {
        DevicePinVerifyClearActivity devicePinVerifyClearActivity = this.f7958O000000o;
        if (devicePinVerifyClearActivity != null) {
            this.f7958O000000o = null;
            devicePinVerifyClearActivity.layoutDeviceContainer = null;
            devicePinVerifyClearActivity.vPinSoftKeyboard = null;
            devicePinVerifyClearActivity.vPinInputView = null;
            devicePinVerifyClearActivity.tvErrorTips = null;
            devicePinVerifyClearActivity.tvMore = null;
            devicePinVerifyClearActivity.tvTip = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
