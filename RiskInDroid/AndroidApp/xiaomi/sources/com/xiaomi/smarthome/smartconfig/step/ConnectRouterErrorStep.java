package com.xiaomi.smarthome.smartconfig.step;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class ConnectRouterErrorStep extends SmartConfigStep {
    @BindView(6198)
    View mBottomContainer;
    @BindView(7370)
    ImageView mIcon;
    @BindView(7372)
    TextView mInfo;
    @BindView(7371)
    TextView mInfoSubTitle;
    @BindView(6779)
    TextView mLeftBtn;
    @BindView(6171)
    View mMainIconContainer;
    @BindView(7210)
    TextView mRightBtn;

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_CONNECT_ROUTER_ERROR;
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_connect_router_failed);
        this.mMainIconContainer.setVisibility(0);
        this.mBottomContainer.setVisibility(0);
        this.mIcon.setImageResource(R.drawable.config_failed_unable_connect);
        this.mInfo.setText((int) R.string.dianlimao_connect_failed_title);
        this.mInfoSubTitle.setText((int) R.string.dianlimao_connect_failed_subtitle);
        this.mLeftBtn.setText((int) R.string.sh_common_cancel);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ConnectRouterErrorStep.AnonymousClass1 */

            public final void onClick(View view) {
                ConnectRouterErrorStep.this.b_(true);
            }
        });
        this.mRightBtn.setText((int) R.string.mj_retry);
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ConnectRouterErrorStep.AnonymousClass2 */

            public final void onClick(View view) {
                ConnectRouterErrorStep.this.O000O0o();
            }
        });
    }
}
