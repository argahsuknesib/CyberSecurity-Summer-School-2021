package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class BleErrorStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private BleErrorStep f11642O000000o;

    public BleErrorStep_ViewBinding(BleErrorStep bleErrorStep, View view) {
        this.f11642O000000o = bleErrorStep;
        bleErrorStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        bleErrorStep.mMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mMainTitle'", TextView.class);
        bleErrorStep.mSubMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mSubMainTitle'", TextView.class);
        bleErrorStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        bleErrorStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        BleErrorStep bleErrorStep = this.f11642O000000o;
        if (bleErrorStep != null) {
            this.f11642O000000o = null;
            bleErrorStep.mIcon = null;
            bleErrorStep.mMainTitle = null;
            bleErrorStep.mSubMainTitle = null;
            bleErrorStep.mLeftBtn = null;
            bleErrorStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
