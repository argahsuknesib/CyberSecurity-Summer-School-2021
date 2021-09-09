package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gri;
import _m_j.gwg;
import _m_j.htr;
import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class DeviceInfoStep extends SmartConfigStep {
    @BindView(7370)
    SimpleDraweeView mDeviceIcon;
    @BindView(7372)
    TextView mDeviceInfo;
    @BindView(7371)
    TextView mDeviceInfoSubTitle;
    @BindView(6986)
    Button mNextBtn;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6925)
    TextView mTitle;
    @BindView(7517)
    View mTitleBar;

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_DEVICE_INFO;
    }

    public final void O000000o(Context context) {
        String str;
        O000000o(context, (int) R.layout.smart_config_device_info_ui);
        if ((context instanceof Activity) && !gwg.O000000o((Activity) context)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleBar.getLayoutParams();
            this.mTitleBar.setPadding(0, 0, 0, 0);
            layoutParams.height = gri.O000000o(45.0f);
            this.mTitleBar.setLayoutParams(layoutParams);
        }
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.DeviceInfoStep.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceInfoStep.this.b_(false);
            }
        });
        String str2 = (String) htr.O000000o().O000000o("device_model");
        if (str2 == null) {
            this.mDeviceInfo.setText((int) R.string.terminal_feedback);
            DeviceFactory.O000000o("", this.mDeviceIcon, (int) R.drawable.kuailian_common_icon);
            return;
        }
        Device O0000o0O = DeviceFactory.O0000o0O(str2);
        if (O0000o0O != null) {
            str = O0000o0O.name;
        } else {
            str = this.O000O0oo.getString(R.string.other_device);
        }
        this.mTitle.setText(O0000o0O.name);
        this.mDeviceInfo.setText(String.format(context.getString(R.string.kuailian_main_title_3), str));
        this.mDeviceInfoSubTitle.setText((int) R.string.kuailian_sub_main_title_1);
        DeviceFactory.O000000o(str2, this.mDeviceIcon, (int) R.drawable.kuailian_common_icon);
        this.mNextBtn.setText((int) R.string.next_button);
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.DeviceInfoStep.AnonymousClass2 */

            public final void onClick(View view) {
                if (((Boolean) htr.O000000o().O000000o("mi_router_in_device_list", Boolean.FALSE)).booleanValue()) {
                    DeviceInfoStep.this.O000000o(SmartConfigStep.Step.STEP_GET_ROUTER_INFO);
                } else {
                    DeviceInfoStep.this.O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
                }
            }
        });
    }

    public final boolean G_() {
        b_(false);
        return true;
    }
}
