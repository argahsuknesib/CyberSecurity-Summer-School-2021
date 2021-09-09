package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class DeviceSceneEmptyActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceSceneEmptyActivity f10668O000000o;

    public DeviceSceneEmptyActivity_ViewBinding(DeviceSceneEmptyActivity deviceSceneEmptyActivity, View view) {
        this.f10668O000000o = deviceSceneEmptyActivity;
        deviceSceneEmptyActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
        deviceSceneEmptyActivity.mReturnIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnIV'", ImageView.class);
    }

    public void unbind() {
        DeviceSceneEmptyActivity deviceSceneEmptyActivity = this.f10668O000000o;
        if (deviceSceneEmptyActivity != null) {
            this.f10668O000000o = null;
            deviceSceneEmptyActivity.mTitleTV = null;
            deviceSceneEmptyActivity.mReturnIV = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
