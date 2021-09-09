package com.xiaomi.smarthome.smartconfig;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class CameraApChooseConnection_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CameraApChooseConnection f11404O000000o;

    public CameraApChooseConnection_ViewBinding(CameraApChooseConnection cameraApChooseConnection, View view) {
        this.f11404O000000o = cameraApChooseConnection;
        cameraApChooseConnection.mIvReturn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mIvReturn'", ImageView.class);
        cameraApChooseConnection.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTvTitle'", TextView.class);
        cameraApChooseConnection.mSettingWifiBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mSettingWifiBtn'", Button.class);
        cameraApChooseConnection.mTvAp = (TextView) Utils.findRequiredViewAsType(view, R.id.ap, "field 'mTvAp'", TextView.class);
    }

    public void unbind() {
        CameraApChooseConnection cameraApChooseConnection = this.f11404O000000o;
        if (cameraApChooseConnection != null) {
            this.f11404O000000o = null;
            cameraApChooseConnection.mIvReturn = null;
            cameraApChooseConnection.mTvTitle = null;
            cameraApChooseConnection.mSettingWifiBtn = null;
            cameraApChooseConnection.mTvAp = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
