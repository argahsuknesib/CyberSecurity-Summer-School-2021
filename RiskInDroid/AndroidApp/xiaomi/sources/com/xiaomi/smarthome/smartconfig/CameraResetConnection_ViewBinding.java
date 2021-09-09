package com.xiaomi.smarthome.smartconfig;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class CameraResetConnection_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CameraResetConnection f11416O000000o;

    public CameraResetConnection_ViewBinding(CameraResetConnection cameraResetConnection, View view) {
        this.f11416O000000o = cameraResetConnection;
        cameraResetConnection.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.kuailian_reset_web_view, "field 'mWebView'", WebView.class);
        cameraResetConnection.mButton = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mButton'", Button.class);
        cameraResetConnection.mCheck = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mCheck'", CheckBox.class);
        cameraResetConnection.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        cameraResetConnection.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        cameraResetConnection.mTvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.step_desc_text, "field 'mTvDesc'", TextView.class);
    }

    public void unbind() {
        CameraResetConnection cameraResetConnection = this.f11416O000000o;
        if (cameraResetConnection != null) {
            this.f11416O000000o = null;
            cameraResetConnection.mWebView = null;
            cameraResetConnection.mButton = null;
            cameraResetConnection.mCheck = null;
            cameraResetConnection.mReturnBtn = null;
            cameraResetConnection.mTitle = null;
            cameraResetConnection.mTvDesc = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
