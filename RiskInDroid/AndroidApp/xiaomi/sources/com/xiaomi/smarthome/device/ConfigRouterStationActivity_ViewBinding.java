package com.xiaomi.smarthome.device;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ConfigRouterStationActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ConfigRouterStationActivity f6934O000000o;

    public ConfigRouterStationActivity_ViewBinding(ConfigRouterStationActivity configRouterStationActivity, View view) {
        this.f6934O000000o = configRouterStationActivity;
        configRouterStationActivity.mIvReturn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mIvReturn'", ImageView.class);
        configRouterStationActivity.mNextButton = (Button) Utils.findRequiredViewAsType(view, R.id.heard_qr_scaned, "field 'mNextButton'", Button.class);
        configRouterStationActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        configRouterStationActivity.mLayoutWireView = Utils.findRequiredView(view, R.id.rbtn_wire_connection, "field 'mLayoutWireView'");
        configRouterStationActivity.mLayoutWirelessView = Utils.findRequiredView(view, R.id.rbtn_wireless_connection, "field 'mLayoutWirelessView'");
        configRouterStationActivity.mWireTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wire_title, "field 'mWireTitleTV'", TextView.class);
        configRouterStationActivity.mWireSubTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wire_sub_title, "field 'mWireSubTitleTV'", TextView.class);
        configRouterStationActivity.mWirelessTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wireless_title, "field 'mWirelessTitleTV'", TextView.class);
        configRouterStationActivity.mWirelessSubTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wireless_sub_title, "field 'mWirelessSubTitleTV'", TextView.class);
        configRouterStationActivity.mWireImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.image_wire_choose, "field 'mWireImageView'", ImageView.class);
        configRouterStationActivity.mWirelessImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.image_wireless_choose, "field 'mWirelessImageView'", ImageView.class);
    }

    public void unbind() {
        ConfigRouterStationActivity configRouterStationActivity = this.f6934O000000o;
        if (configRouterStationActivity != null) {
            this.f6934O000000o = null;
            configRouterStationActivity.mIvReturn = null;
            configRouterStationActivity.mNextButton = null;
            configRouterStationActivity.mTitleBar = null;
            configRouterStationActivity.mLayoutWireView = null;
            configRouterStationActivity.mLayoutWirelessView = null;
            configRouterStationActivity.mWireTitleTV = null;
            configRouterStationActivity.mWireSubTitleTV = null;
            configRouterStationActivity.mWirelessTitleTV = null;
            configRouterStationActivity.mWirelessSubTitleTV = null;
            configRouterStationActivity.mWireImageView = null;
            configRouterStationActivity.mWirelessImageView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
