package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;

public class RouterInfoStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private RouterInfoStep f11810O000000o;

    public RouterInfoStep_ViewBinding(RouterInfoStep routerInfoStep, View view) {
        this.f11810O000000o = routerInfoStep;
        routerInfoStep.mProgressContainer = Utils.findRequiredView(view, R.id.base_ui_progress, "field 'mProgressContainer'");
        routerInfoStep.mProgressBar = (PieProgressBar) Utils.findRequiredViewAsType(view, R.id.base_ui_progress_bar, "field 'mProgressBar'", PieProgressBar.class);
        routerInfoStep.mBarText = (TextView) Utils.findRequiredViewAsType(view, R.id.base_ui_progress_bar_text, "field 'mBarText'", TextView.class);
        routerInfoStep.mRouterInfoTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.base_ui_progress_bar_title, "field 'mRouterInfoTitle'", TextView.class);
        routerInfoStep.mRouterInfoView = Utils.findRequiredView(view, R.id.base_ui_main_icon, "field 'mRouterInfoView'");
        routerInfoStep.mDeviceIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mDeviceIcon'", SimpleDraweeView.class);
        routerInfoStep.mRouterInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mRouterInfo'", TextView.class);
        routerInfoStep.mRouterInfoSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mRouterInfoSubTitle'", TextView.class);
        routerInfoStep.mSwitchRouterBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.router_switch_btn, "field 'mSwitchRouterBtn'", TextView.class);
        routerInfoStep.mNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextBtn'", Button.class);
    }

    public void unbind() {
        RouterInfoStep routerInfoStep = this.f11810O000000o;
        if (routerInfoStep != null) {
            this.f11810O000000o = null;
            routerInfoStep.mProgressContainer = null;
            routerInfoStep.mProgressBar = null;
            routerInfoStep.mBarText = null;
            routerInfoStep.mRouterInfoTitle = null;
            routerInfoStep.mRouterInfoView = null;
            routerInfoStep.mDeviceIcon = null;
            routerInfoStep.mRouterInfo = null;
            routerInfoStep.mRouterInfoSubTitle = null;
            routerInfoStep.mSwitchRouterBtn = null;
            routerInfoStep.mNextBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
