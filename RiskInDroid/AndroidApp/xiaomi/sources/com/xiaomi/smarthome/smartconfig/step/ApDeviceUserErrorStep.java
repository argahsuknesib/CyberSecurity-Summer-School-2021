package com.xiaomi.smarthome.smartconfig.step;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class ApDeviceUserErrorStep extends SmartConfigStep {
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
        this.mIcon.setImageResource(R.drawable.config_failed_timeout);
        this.mMainTitle.setText((int) R.string.smart_config_xiaofang_error_user_error_main_title);
        this.mSubMainTitle.setText((int) R.string.smart_config_xiaofang_error_user_error_sub_title);
        this.mLeftBtn.setText((int) R.string.sh_common_cancel);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApDeviceUserErrorStep.AnonymousClass1 */

            public final void onClick(View view) {
                ApDeviceUserErrorStep.this.b_(true);
            }
        });
        this.mRightBtn.setText((int) R.string.mj_retry);
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ApDeviceUserErrorStep.AnonymousClass2 */

            public final void onClick(View view) {
                ApDeviceUserErrorStep.this.O000O0o();
            }
        });
    }

    public final boolean G_() {
        return super.G_();
    }
}
