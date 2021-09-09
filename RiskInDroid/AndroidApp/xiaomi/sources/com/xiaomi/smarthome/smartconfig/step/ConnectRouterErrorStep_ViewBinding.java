package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ConnectRouterErrorStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ConnectRouterErrorStep f11748O000000o;

    public ConnectRouterErrorStep_ViewBinding(ConnectRouterErrorStep connectRouterErrorStep, View view) {
        this.f11748O000000o = connectRouterErrorStep;
        connectRouterErrorStep.mMainIconContainer = Utils.findRequiredView(view, R.id.base_ui_main_icon, "field 'mMainIconContainer'");
        connectRouterErrorStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        connectRouterErrorStep.mInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mInfo'", TextView.class);
        connectRouterErrorStep.mInfoSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mInfoSubTitle'", TextView.class);
        connectRouterErrorStep.mBottomContainer = Utils.findRequiredView(view, R.id.bottom_btn_container, "field 'mBottomContainer'");
        connectRouterErrorStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        connectRouterErrorStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        ConnectRouterErrorStep connectRouterErrorStep = this.f11748O000000o;
        if (connectRouterErrorStep != null) {
            this.f11748O000000o = null;
            connectRouterErrorStep.mMainIconContainer = null;
            connectRouterErrorStep.mIcon = null;
            connectRouterErrorStep.mInfo = null;
            connectRouterErrorStep.mInfoSubTitle = null;
            connectRouterErrorStep.mBottomContainer = null;
            connectRouterErrorStep.mLeftBtn = null;
            connectRouterErrorStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
