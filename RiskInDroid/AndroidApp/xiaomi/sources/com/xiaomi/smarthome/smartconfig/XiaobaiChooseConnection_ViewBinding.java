package com.xiaomi.smarthome.smartconfig;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class XiaobaiChooseConnection_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private XiaobaiChooseConnection f11477O000000o;

    public XiaobaiChooseConnection_ViewBinding(XiaobaiChooseConnection xiaobaiChooseConnection, View view) {
        this.f11477O000000o = xiaobaiChooseConnection;
        xiaobaiChooseConnection.mDeviceIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mDeviceIcon'", SimpleDraweeView.class);
        xiaobaiChooseConnection.mDeviceInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mDeviceInfo'", TextView.class);
        xiaobaiChooseConnection.mDeviceInfoSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mDeviceInfoSubTitle'", TextView.class);
        xiaobaiChooseConnection.mNextBtn1 = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn_1, "field 'mNextBtn1'", Button.class);
        xiaobaiChooseConnection.mNextBtn2 = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn_2, "field 'mNextBtn2'", Button.class);
        xiaobaiChooseConnection.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        xiaobaiChooseConnection.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        xiaobaiChooseConnection.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
    }

    public void unbind() {
        XiaobaiChooseConnection xiaobaiChooseConnection = this.f11477O000000o;
        if (xiaobaiChooseConnection != null) {
            this.f11477O000000o = null;
            xiaobaiChooseConnection.mDeviceIcon = null;
            xiaobaiChooseConnection.mDeviceInfo = null;
            xiaobaiChooseConnection.mDeviceInfoSubTitle = null;
            xiaobaiChooseConnection.mNextBtn1 = null;
            xiaobaiChooseConnection.mNextBtn2 = null;
            xiaobaiChooseConnection.mTitleBar = null;
            xiaobaiChooseConnection.mReturnBtn = null;
            xiaobaiChooseConnection.mTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
