package com.xiaomi.smarthome.smartconfig.router;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView;

public class RouterConfigActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private RouterConfigActivity f11621O000000o;

    public RouterConfigActivity_ViewBinding(RouterConfigActivity routerConfigActivity, View view) {
        this.f11621O000000o = routerConfigActivity;
        routerConfigActivity.mBackImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackImage'", ImageView.class);
        routerConfigActivity.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleView'", TextView.class);
        routerConfigActivity.mChooseRouterPage = Utils.findRequiredView(view, R.id.choose_router_page, "field 'mChooseRouterPage'");
        routerConfigActivity.mChooseRouterItem = Utils.findRequiredView(view, R.id.choose_router_item, "field 'mChooseRouterItem'");
        routerConfigActivity.mChooseRouterButton = (TextView) Utils.findRequiredViewAsType(view, R.id.choose_router_button, "field 'mChooseRouterButton'", TextView.class);
        routerConfigActivity.mUnsupportRouterPage = Utils.findRequiredView(view, R.id.unsupport_router_page, "field 'mUnsupportRouterPage'");
        routerConfigActivity.mUnsupportRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.unsupport_router_image, "field 'mUnsupportRouterImage'", SimpleDraweeView.class);
        routerConfigActivity.mChooseRouterButton1 = (TextView) Utils.findRequiredViewAsType(view, R.id.choose_router_1_button, "field 'mChooseRouterButton1'", TextView.class);
        routerConfigActivity.mUninitRouterPage = Utils.findRequiredView(view, R.id.uninit_router_page, "field 'mUninitRouterPage'");
        routerConfigActivity.mUninitRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.uninit_router_image, "field 'mUninitRouterImage'", SimpleDraweeView.class);
        routerConfigActivity.mUninitRouterName = (TextView) Utils.findRequiredViewAsType(view, R.id.uninit_router_name, "field 'mUninitRouterName'", TextView.class);
        routerConfigActivity.mSetRouterButton = (TextView) Utils.findRequiredViewAsType(view, R.id.set_router_button, "field 'mSetRouterButton'", TextView.class);
        routerConfigActivity.mHasBoundRouterPage = Utils.findRequiredView(view, R.id.has_bound_router_page, "field 'mHasBoundRouterPage'");
        routerConfigActivity.mHasBoundRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.has_bound_router_image, "field 'mHasBoundRouterImage'", SimpleDraweeView.class);
        routerConfigActivity.mHasBoundRouterName = (TextView) Utils.findRequiredViewAsType(view, R.id.has_bound_router_name, "field 'mHasBoundRouterName'", TextView.class);
        routerConfigActivity.mHasBoundRouterButton = (TextView) Utils.findRequiredViewAsType(view, R.id.has_bound_router_button, "field 'mHasBoundRouterButton'", TextView.class);
        routerConfigActivity.mWaitBindRouterPage = Utils.findRequiredView(view, R.id.wait_bind_router_page, "field 'mWaitBindRouterPage'");
        routerConfigActivity.mWaitBindRouterNameView = (TextView) Utils.findRequiredViewAsType(view, R.id.wait_bind_router_name, "field 'mWaitBindRouterNameView'", TextView.class);
        routerConfigActivity.mWaitBindRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.wait_bind_router_image, "field 'mWaitBindRouterImage'", SimpleDraweeView.class);
        routerConfigActivity.mInputPwdEditText = (EditText) Utils.findRequiredViewAsType(view, R.id.input_admin_pwd, "field 'mInputPwdEditText'", EditText.class);
        routerConfigActivity.mStartBindButton = (TextView) Utils.findRequiredViewAsType(view, R.id.start_bind, "field 'mStartBindButton'", TextView.class);
        routerConfigActivity.mBindingPage = Utils.findRequiredView(view, R.id.binding_page, "field 'mBindingPage'");
        routerConfigActivity.mCommonBindView = (CommonBindView) Utils.findRequiredViewAsType(view, R.id.common_bind_view, "field 'mCommonBindView'", CommonBindView.class);
    }

    public void unbind() {
        RouterConfigActivity routerConfigActivity = this.f11621O000000o;
        if (routerConfigActivity != null) {
            this.f11621O000000o = null;
            routerConfigActivity.mBackImage = null;
            routerConfigActivity.mTitleView = null;
            routerConfigActivity.mChooseRouterPage = null;
            routerConfigActivity.mChooseRouterItem = null;
            routerConfigActivity.mChooseRouterButton = null;
            routerConfigActivity.mUnsupportRouterPage = null;
            routerConfigActivity.mUnsupportRouterImage = null;
            routerConfigActivity.mChooseRouterButton1 = null;
            routerConfigActivity.mUninitRouterPage = null;
            routerConfigActivity.mUninitRouterImage = null;
            routerConfigActivity.mUninitRouterName = null;
            routerConfigActivity.mSetRouterButton = null;
            routerConfigActivity.mHasBoundRouterPage = null;
            routerConfigActivity.mHasBoundRouterImage = null;
            routerConfigActivity.mHasBoundRouterName = null;
            routerConfigActivity.mHasBoundRouterButton = null;
            routerConfigActivity.mWaitBindRouterPage = null;
            routerConfigActivity.mWaitBindRouterNameView = null;
            routerConfigActivity.mWaitBindRouterImage = null;
            routerConfigActivity.mInputPwdEditText = null;
            routerConfigActivity.mStartBindButton = null;
            routerConfigActivity.mBindingPage = null;
            routerConfigActivity.mCommonBindView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
