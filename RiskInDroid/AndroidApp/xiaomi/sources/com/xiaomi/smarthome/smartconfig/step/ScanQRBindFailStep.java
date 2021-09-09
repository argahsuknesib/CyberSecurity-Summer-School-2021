package com.xiaomi.smarthome.smartconfig.step;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class ScanQRBindFailStep extends SmartConfigStep {
    @BindView(6210)
    Button mConfim;
    @BindView(7370)
    ImageView mIcon;
    @BindView(7372)
    TextView mMainTitle;
    @BindView(7371)
    TextView mSubMainTitle;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_scan_qr_bind_failed_ui);
        this.mIcon.setImageResource(R.drawable.config_failed_disconnect);
        this.mMainTitle.setText((int) R.string.smart_config_faile_qr_bind);
        this.mSubMainTitle.setText((int) R.string.smart_config_faile_qr_bind_detail);
        this.mConfim.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ScanQRBindFailStep.AnonymousClass1 */

            public final void onClick(View view) {
                ScanQRBindFailStep.this.b_(false);
            }
        });
    }
}
