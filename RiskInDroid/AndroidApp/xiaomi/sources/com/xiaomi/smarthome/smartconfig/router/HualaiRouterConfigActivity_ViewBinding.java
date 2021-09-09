package com.xiaomi.smarthome.smartconfig.router;

import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView;

public class HualaiRouterConfigActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private HualaiRouterConfigActivity f11578O000000o;

    public HualaiRouterConfigActivity_ViewBinding(HualaiRouterConfigActivity hualaiRouterConfigActivity, View view) {
        this.f11578O000000o = hualaiRouterConfigActivity;
        hualaiRouterConfigActivity.mBackImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackImage'", ImageView.class);
        hualaiRouterConfigActivity.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleView'", TextView.class);
        hualaiRouterConfigActivity.mChooseRouterPage = Utils.findRequiredView(view, R.id.choose_router_page, "field 'mChooseRouterPage'");
        hualaiRouterConfigActivity.mChooseRouterItem = Utils.findRequiredView(view, R.id.choose_router_item, "field 'mChooseRouterItem'");
        hualaiRouterConfigActivity.mChooseRouterButton = (TextView) Utils.findRequiredViewAsType(view, R.id.choose_router_button, "field 'mChooseRouterButton'", TextView.class);
        hualaiRouterConfigActivity.mUnsupportRouterPage = Utils.findRequiredView(view, R.id.unsupport_router_page, "field 'mUnsupportRouterPage'");
        hualaiRouterConfigActivity.mUnsupportRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.unsupport_router_image, "field 'mUnsupportRouterImage'", SimpleDraweeView.class);
        hualaiRouterConfigActivity.mChooseRouterButton1 = (TextView) Utils.findRequiredViewAsType(view, R.id.choose_router_1_button, "field 'mChooseRouterButton1'", TextView.class);
        hualaiRouterConfigActivity.mUninitRouterPage = Utils.findRequiredView(view, R.id.uninit_router_page, "field 'mUninitRouterPage'");
        hualaiRouterConfigActivity.mUninitRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.uninit_router_image, "field 'mUninitRouterImage'", SimpleDraweeView.class);
        hualaiRouterConfigActivity.mUninitRouterName = (TextView) Utils.findRequiredViewAsType(view, R.id.uninit_router_name, "field 'mUninitRouterName'", TextView.class);
        hualaiRouterConfigActivity.mSetRouterButton = (TextView) Utils.findRequiredViewAsType(view, R.id.set_router_button, "field 'mSetRouterButton'", TextView.class);
        hualaiRouterConfigActivity.mHasBoundRouterPage = Utils.findRequiredView(view, R.id.has_bound_router_page, "field 'mHasBoundRouterPage'");
        hualaiRouterConfigActivity.mHasBoundRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.has_bound_router_image, "field 'mHasBoundRouterImage'", SimpleDraweeView.class);
        hualaiRouterConfigActivity.mHasBoundRouterName = (TextView) Utils.findRequiredViewAsType(view, R.id.has_bound_router_name, "field 'mHasBoundRouterName'", TextView.class);
        hualaiRouterConfigActivity.mHasBoundRouterButton = (TextView) Utils.findRequiredViewAsType(view, R.id.has_bound_router_button, "field 'mHasBoundRouterButton'", TextView.class);
        hualaiRouterConfigActivity.mWaitBindRouterPage = Utils.findRequiredView(view, R.id.wait_bind_router_page, "field 'mWaitBindRouterPage'");
        hualaiRouterConfigActivity.mWaitBindRouterNameView = (TextView) Utils.findRequiredViewAsType(view, R.id.wait_bind_router_name, "field 'mWaitBindRouterNameView'", TextView.class);
        hualaiRouterConfigActivity.mWaitBindRouterImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.wait_bind_router_image, "field 'mWaitBindRouterImage'", SimpleDraweeView.class);
        hualaiRouterConfigActivity.mInputPwdEditText = (EditText) Utils.findRequiredViewAsType(view, R.id.input_admin_pwd, "field 'mInputPwdEditText'", EditText.class);
        hualaiRouterConfigActivity.mStartBindButton = (TextView) Utils.findRequiredViewAsType(view, R.id.start_bind, "field 'mStartBindButton'", TextView.class);
        hualaiRouterConfigActivity.mBindingPage = Utils.findRequiredView(view, R.id.binding_page, "field 'mBindingPage'");
        hualaiRouterConfigActivity.mCommonBindView = (CommonBindView) Utils.findRequiredViewAsType(view, R.id.common_bind_view, "field 'mCommonBindView'", CommonBindView.class);
        hualaiRouterConfigActivity.mInitPage = Utils.findRequiredView(view, R.id.init_page, "field 'mInitPage'");
        hualaiRouterConfigActivity.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'mWebView'", WebView.class);
    }

    public void unbind() {
        HualaiRouterConfigActivity hualaiRouterConfigActivity = this.f11578O000000o;
        if (hualaiRouterConfigActivity != null) {
            this.f11578O000000o = null;
            hualaiRouterConfigActivity.mBackImage = null;
            hualaiRouterConfigActivity.mTitleView = null;
            hualaiRouterConfigActivity.mChooseRouterPage = null;
            hualaiRouterConfigActivity.mChooseRouterItem = null;
            hualaiRouterConfigActivity.mChooseRouterButton = null;
            hualaiRouterConfigActivity.mUnsupportRouterPage = null;
            hualaiRouterConfigActivity.mUnsupportRouterImage = null;
            hualaiRouterConfigActivity.mChooseRouterButton1 = null;
            hualaiRouterConfigActivity.mUninitRouterPage = null;
            hualaiRouterConfigActivity.mUninitRouterImage = null;
            hualaiRouterConfigActivity.mUninitRouterName = null;
            hualaiRouterConfigActivity.mSetRouterButton = null;
            hualaiRouterConfigActivity.mHasBoundRouterPage = null;
            hualaiRouterConfigActivity.mHasBoundRouterImage = null;
            hualaiRouterConfigActivity.mHasBoundRouterName = null;
            hualaiRouterConfigActivity.mHasBoundRouterButton = null;
            hualaiRouterConfigActivity.mWaitBindRouterPage = null;
            hualaiRouterConfigActivity.mWaitBindRouterNameView = null;
            hualaiRouterConfigActivity.mWaitBindRouterImage = null;
            hualaiRouterConfigActivity.mInputPwdEditText = null;
            hualaiRouterConfigActivity.mStartBindButton = null;
            hualaiRouterConfigActivity.mBindingPage = null;
            hualaiRouterConfigActivity.mCommonBindView = null;
            hualaiRouterConfigActivity.mInitPage = null;
            hualaiRouterConfigActivity.mWebView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
