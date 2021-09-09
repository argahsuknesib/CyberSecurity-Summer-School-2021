package com.xiaomi.smarthome.smartconfig;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class XiaofangResetConnection_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private XiaofangResetConnection f11486O000000o;

    public XiaofangResetConnection_ViewBinding(XiaofangResetConnection xiaofangResetConnection, View view) {
        this.f11486O000000o = xiaofangResetConnection;
        xiaofangResetConnection.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.kuailian_reset_web_view, "field 'mWebView'", WebView.class);
        xiaofangResetConnection.mButton = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mButton'", Button.class);
        xiaofangResetConnection.mCheck = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mCheck'", CheckBox.class);
        xiaofangResetConnection.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        xiaofangResetConnection.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
    }

    public void unbind() {
        XiaofangResetConnection xiaofangResetConnection = this.f11486O000000o;
        if (xiaofangResetConnection != null) {
            this.f11486O000000o = null;
            xiaofangResetConnection.mWebView = null;
            xiaofangResetConnection.mButton = null;
            xiaofangResetConnection.mCheck = null;
            xiaofangResetConnection.mReturnBtn = null;
            xiaofangResetConnection.mTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
