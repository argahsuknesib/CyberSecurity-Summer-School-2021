package com.xiaomi.smarthome.smartconfig.step;

import android.content.Context;
import android.os.Message;
import android.view.View;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class HaveBindByOtherErrorStep extends SmartConfigStep {
    @BindView(7016)
    View mOkBtn;

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
        O000000o(context, (int) R.layout.smart_config_bind_by_other);
        this.mOkBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.HaveBindByOtherErrorStep.AnonymousClass1 */

            public final void onClick(View view) {
                HaveBindByOtherErrorStep.this.b_(false);
            }
        });
    }
}
