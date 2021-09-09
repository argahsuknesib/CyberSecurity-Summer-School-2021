package com.xiaomi.smarthome.device.choosedevice;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class CannotFindDeviceChildActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CannotFindDeviceChildActivity f7215O000000o;

    public CannotFindDeviceChildActivity_ViewBinding(CannotFindDeviceChildActivity cannotFindDeviceChildActivity, View view) {
        this.f7215O000000o = cannotFindDeviceChildActivity;
        cannotFindDeviceChildActivity.mBtnSure = (Button) Utils.findRequiredViewAsType(view, R.id.btn_sure, "field 'mBtnSure'", Button.class);
        cannotFindDeviceChildActivity.mTxtItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_item_title, "field 'mTxtItemTitle'", TextView.class);
        cannotFindDeviceChildActivity.mLayoutModelParent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_model_parent, "field 'mLayoutModelParent'", LinearLayout.class);
    }

    public void unbind() {
        CannotFindDeviceChildActivity cannotFindDeviceChildActivity = this.f7215O000000o;
        if (cannotFindDeviceChildActivity != null) {
            this.f7215O000000o = null;
            cannotFindDeviceChildActivity.mBtnSure = null;
            cannotFindDeviceChildActivity.mTxtItemTitle = null;
            cannotFindDeviceChildActivity.mLayoutModelParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
