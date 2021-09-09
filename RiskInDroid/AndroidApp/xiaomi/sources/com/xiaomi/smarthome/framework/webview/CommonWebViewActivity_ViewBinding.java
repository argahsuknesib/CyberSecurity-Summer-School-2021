package com.xiaomi.smarthome.framework.webview;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class CommonWebViewActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CommonWebViewActivity f8795O000000o;

    public CommonWebViewActivity_ViewBinding(CommonWebViewActivity commonWebViewActivity, View view) {
        this.f8795O000000o = commonWebViewActivity;
        commonWebViewActivity.mActionBarBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mActionBarBack'", ImageView.class);
        commonWebViewActivity.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleView'", TextView.class);
        commonWebViewActivity.mTitleClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_extra_icon, "field 'mTitleClose'", ImageView.class);
        commonWebViewActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading_progress, "field 'mProgressBar'", ProgressBar.class);
        commonWebViewActivity.mWebView = (SmartHomeWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'mWebView'", SmartHomeWebView.class);
    }

    public void unbind() {
        CommonWebViewActivity commonWebViewActivity = this.f8795O000000o;
        if (commonWebViewActivity != null) {
            this.f8795O000000o = null;
            commonWebViewActivity.mActionBarBack = null;
            commonWebViewActivity.mTitleView = null;
            commonWebViewActivity.mTitleClose = null;
            commonWebViewActivity.mProgressBar = null;
            commonWebViewActivity.mWebView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
