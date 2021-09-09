package com.xiaomi.smarthome.miio.page.msgcentersetting;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.TimePicker;

public class InterruptPushTimerSettingActiviy_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private InterruptPushTimerSettingActiviy f9923O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;

    public InterruptPushTimerSettingActiviy_ViewBinding(final InterruptPushTimerSettingActiviy interruptPushTimerSettingActiviy, View view) {
        this.f9923O000000o = interruptPushTimerSettingActiviy;
        interruptPushTimerSettingActiviy.mExecuteFromPicker = (TimePicker) Utils.findRequiredViewAsType(view, R.id.execute_from_picker, "field 'mExecuteFromPicker'", TimePicker.class);
        interruptPushTimerSettingActiviy.mExecuteToPicker = (TimePicker) Utils.findRequiredViewAsType(view, R.id.execute_to_picker, "field 'mExecuteToPicker'", TimePicker.class);
        interruptPushTimerSettingActiviy.mExecuteFrom = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_from_hint, "field 'mExecuteFrom'", TextView.class);
        interruptPushTimerSettingActiviy.mExecuteTo = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_to_hint, "field 'mExecuteTo'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_right_text_btn, "field 'mConfirmView' and method 'onClick'");
        interruptPushTimerSettingActiviy.mConfirmView = (TextView) Utils.castView(findRequiredView, R.id.module_a_3_right_text_btn, "field 'mConfirmView'", TextView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.InterruptPushTimerSettingActiviy_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                interruptPushTimerSettingActiviy.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'onClick'");
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.InterruptPushTimerSettingActiviy_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                interruptPushTimerSettingActiviy.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.execute_from_layout, "method 'onClick'");
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.InterruptPushTimerSettingActiviy_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                interruptPushTimerSettingActiviy.onClick(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.execute_to_layout, "method 'onClick'");
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.InterruptPushTimerSettingActiviy_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                interruptPushTimerSettingActiviy.onClick(view);
            }
        });
    }

    public void unbind() {
        InterruptPushTimerSettingActiviy interruptPushTimerSettingActiviy = this.f9923O000000o;
        if (interruptPushTimerSettingActiviy != null) {
            this.f9923O000000o = null;
            interruptPushTimerSettingActiviy.mExecuteFromPicker = null;
            interruptPushTimerSettingActiviy.mExecuteToPicker = null;
            interruptPushTimerSettingActiviy.mExecuteFrom = null;
            interruptPushTimerSettingActiviy.mExecuteTo = null;
            interruptPushTimerSettingActiviy.mConfirmView = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            this.O00000oO.setOnClickListener(null);
            this.O00000oO = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
