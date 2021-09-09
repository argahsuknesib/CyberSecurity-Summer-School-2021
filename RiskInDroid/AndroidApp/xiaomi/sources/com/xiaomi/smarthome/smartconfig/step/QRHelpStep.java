package com.xiaomi.smarthome.smartconfig.step;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class QRHelpStep extends SmartConfigStep {
    @BindView(7016)
    Button mOkButton;

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
        O000000o(context, (int) R.layout.activity_camera_gen_barcode_help);
        this.mOkButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRHelpStep.AnonymousClass1 */

            public final void onClick(View view) {
                QRHelpStep.this.O000O0o();
            }
        });
    }
}
