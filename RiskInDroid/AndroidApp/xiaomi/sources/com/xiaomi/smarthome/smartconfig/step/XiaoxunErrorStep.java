package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gnk;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class XiaoxunErrorStep extends SmartConfigStep {
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

    public final void O000000o(Message message) {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_base_left_right_ui);
        this.mIcon.setImageResource(R.drawable.config_failed_disconnect);
        this.mMainTitle.setText((int) R.string.xiaoxun_error);
        this.mSubMainTitle.setText("");
        this.mLeftBtn.setText((int) R.string.ok_button);
        this.mLeftBtn.setBackgroundResource(R.drawable.common_button);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.XiaoxunErrorStep.AnonymousClass1 */

            public final void onClick(View view) {
                gnk.O00000o0(String.format("Cancel Button Pressed", new Object[0]));
                XiaoxunErrorStep.this.b_(false);
            }
        });
        this.mRightBtn.setText((int) R.string.mj_retry);
        this.mRightBtn.setVisibility(8);
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.XiaoxunErrorStep.AnonymousClass2 */

            public final void onClick(View view) {
                XiaoxunErrorStep.this.O000O0o();
            }
        });
    }

    public final void H_() {
        gnk.O00000o0(String.format("%s.onResumeStep", getClass().getSimpleName()));
    }

    public final void I_() {
        gnk.O00000o0(String.format("%s.onPauseStep", getClass().getSimpleName()));
    }

    public final void O0000O0o() {
        gnk.O00000o0(String.format("%s.onFinishStep", getClass().getSimpleName()));
    }

    public final boolean G_() {
        gnk.O00000o0(String.format("%s.onBackPressed", getClass().getSimpleName()));
        return super.G_();
    }
}
