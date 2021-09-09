package com.xiaomi.smarthome.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class AuthCheckActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AuthCheckActivity f4247O000000o;

    public AuthCheckActivity_ViewBinding(AuthCheckActivity authCheckActivity, View view) {
        this.f4247O000000o = authCheckActivity;
        authCheckActivity.mAppIconIV = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.auth_check_app_icon, "field 'mAppIconIV'", SimpleDraweeView.class);
        authCheckActivity.mAppNameTV = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_check_app_name, "field 'mAppNameTV'", TextView.class);
        authCheckActivity.mAppDescTV = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_check_app_des, "field 'mAppDescTV'", TextView.class);
        authCheckActivity.mConfigTV = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_check_config, "field 'mConfigTV'", TextView.class);
        authCheckActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        authCheckActivity.mTitleReturn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mTitleReturn'", ImageView.class);
    }

    public void unbind() {
        AuthCheckActivity authCheckActivity = this.f4247O000000o;
        if (authCheckActivity != null) {
            this.f4247O000000o = null;
            authCheckActivity.mAppIconIV = null;
            authCheckActivity.mAppNameTV = null;
            authCheckActivity.mAppDescTV = null;
            authCheckActivity.mConfigTV = null;
            authCheckActivity.mTitle = null;
            authCheckActivity.mTitleReturn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
