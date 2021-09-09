package com.xiaomi.smarthome.smartconfig.step;

import _m_j.htr;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class FindDeviceFailedStep extends SmartConfigStep {
    @BindView(7370)
    ImageView mIcon;
    @BindView(6779)
    TextView mLeftBtn;
    @BindView(7372)
    TextView mMainTitle;
    @BindView(7210)
    TextView mRightBtn;
    @BindView(7371)
    TextView mSubMainTitle;

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_base_left_right_ui);
        O000O0OO();
        SmartConfigRouterFactory.getStatPageV2Manager().page_failovertime(this.O000OOOo, 0);
        this.mIcon.setImageResource(R.drawable.config_failed_timeout);
        this.mMainTitle.setText((int) R.string.smart_config_connect_timeout_first);
        this.mSubMainTitle.setText((int) R.string.smart_config_find_new_device_error);
        this.mLeftBtn.setText((int) R.string.sh_common_cancel);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.FindDeviceFailedStep.AnonymousClass1 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatPageV2Manager().page_failovertime(FindDeviceFailedStep.this.O000OOOo, FindDeviceFailedStep.this.O000OO);
                SmartConfigRouterFactory.getStatClickManager().kuaiLianClick("adddevice_failovertime_cancel.AP", FindDeviceFailedStep.this.O000OOOo);
                htr.O000000o().O00000Oo("restore_wifi", Boolean.TRUE);
                FindDeviceFailedStep.this.b_(true);
            }
        });
        this.mRightBtn.setText((int) R.string.mj_retry);
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.FindDeviceFailedStep.AnonymousClass2 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatPageV2Manager().page_failovertime(FindDeviceFailedStep.this.O000OOOo, FindDeviceFailedStep.this.O000OO);
                SmartConfigRouterFactory.getStatClickManager().kuaiLianClick("adddevice_failovertime_retry.AP", FindDeviceFailedStep.this.O000OOOo);
                FindDeviceFailedStep.this.O000O0o();
            }
        });
    }

    public final boolean G_() {
        htr.O000000o().O00000Oo("restore_wifi", Boolean.TRUE);
        return super.G_();
    }
}
