package com.xiaomi.smarthome.smartconfig;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class XiaofangChooseConnection_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private XiaofangChooseConnection f11481O000000o;

    public XiaofangChooseConnection_ViewBinding(XiaofangChooseConnection xiaofangChooseConnection, View view) {
        this.f11481O000000o = xiaofangChooseConnection;
        xiaofangChooseConnection.mMainIconContainer = Utils.findRequiredView(view, R.id.base_ui_main_icon, "field 'mMainIconContainer'");
        xiaofangChooseConnection.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        xiaofangChooseConnection.mInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mInfo'", TextView.class);
        xiaofangChooseConnection.mInfoSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mInfoSubTitle'", TextView.class);
        xiaofangChooseConnection.mBottomContainer = Utils.findRequiredView(view, R.id.bottom_btn_container, "field 'mBottomContainer'");
        xiaofangChooseConnection.mManualView = Utils.findRequiredView(view, R.id.base_ui_connect_manually, "field 'mManualView'");
        xiaofangChooseConnection.mManualText = (TextView) Utils.findRequiredViewAsType(view, R.id.manual_text, "field 'mManualText'", TextView.class);
        xiaofangChooseConnection.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        xiaofangChooseConnection.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
        xiaofangChooseConnection.mSettingWifiBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mSettingWifiBtn'", Button.class);
        xiaofangChooseConnection.mManualIcon = (TextView) Utils.findRequiredViewAsType(view, R.id.manual_connect_icon, "field 'mManualIcon'", TextView.class);
    }

    public void unbind() {
        XiaofangChooseConnection xiaofangChooseConnection = this.f11481O000000o;
        if (xiaofangChooseConnection != null) {
            this.f11481O000000o = null;
            xiaofangChooseConnection.mMainIconContainer = null;
            xiaofangChooseConnection.mIcon = null;
            xiaofangChooseConnection.mInfo = null;
            xiaofangChooseConnection.mInfoSubTitle = null;
            xiaofangChooseConnection.mBottomContainer = null;
            xiaofangChooseConnection.mManualView = null;
            xiaofangChooseConnection.mManualText = null;
            xiaofangChooseConnection.mLeftBtn = null;
            xiaofangChooseConnection.mRightBtn = null;
            xiaofangChooseConnection.mSettingWifiBtn = null;
            xiaofangChooseConnection.mManualIcon = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
