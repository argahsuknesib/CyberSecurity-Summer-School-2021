package com.xiaomi.smarthome.framework.page.verify;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;

public class DevicePinActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DevicePinActivity f7944O000000o;
    private View O00000Oo;

    public DevicePinActivity_ViewBinding(final DevicePinActivity devicePinActivity, View view) {
        this.f7944O000000o = devicePinActivity;
        devicePinActivity.vDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.xiaomi_sm_pin_inputs_desc, "field 'vDesc'", TextView.class);
        devicePinActivity.vPinInputView = (PinInputView) Utils.findRequiredViewAsType(view, R.id.xiaomi_sm_pin_inputs, "field 'vPinInputView'", PinInputView.class);
        devicePinActivity.vPinSoftKeyboard = (PinSoftKeyboard) Utils.findRequiredViewAsType(view, R.id.xiaomi_sm_pin_softkeyboard, "field 'vPinSoftKeyboard'", PinSoftKeyboard.class);
        devicePinActivity.vSubHint = (TextView) Utils.findRequiredViewAsType(view, R.id.xiaomi_sm_pin_sub_hint, "field 'vSubHint'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClickBack'");
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                devicePinActivity.onClickBack();
            }
        });
    }

    public void unbind() {
        DevicePinActivity devicePinActivity = this.f7944O000000o;
        if (devicePinActivity != null) {
            this.f7944O000000o = null;
            devicePinActivity.vDesc = null;
            devicePinActivity.vPinInputView = null;
            devicePinActivity.vPinSoftKeyboard = null;
            devicePinActivity.vSubHint = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
