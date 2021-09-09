package com.xiaomi.smarthome.framework.page;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class GeneralOneTimePasswordActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private GeneralOneTimePasswordActivity f7760O000000o;

    public GeneralOneTimePasswordActivity_ViewBinding(GeneralOneTimePasswordActivity generalOneTimePasswordActivity, View view) {
        this.f7760O000000o = generalOneTimePasswordActivity;
        generalOneTimePasswordActivity.mBackBt = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackBt'", ImageView.class);
        generalOneTimePasswordActivity.mContainerView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.container, "field 'mContainerView'", LinearLayout.class);
        generalOneTimePasswordActivity.mGenerateTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.generate_title, "field 'mGenerateTitleView'", TextView.class);
        generalOneTimePasswordActivity.mGenerateTipsView = (TextView) Utils.findRequiredViewAsType(view, R.id.generate_tips, "field 'mGenerateTipsView'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText1 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_1, "field 'mPasswordText1'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText2 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_2, "field 'mPasswordText2'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText3 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_3, "field 'mPasswordText3'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText4 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_4, "field 'mPasswordText4'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText5 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_5, "field 'mPasswordText5'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText6 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_6, "field 'mPasswordText6'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText7 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_7, "field 'mPasswordText7'", TextView.class);
        generalOneTimePasswordActivity.mPasswordText8 = (TextView) Utils.findRequiredViewAsType(view, R.id.password_text_8, "field 'mPasswordText8'", TextView.class);
        generalOneTimePasswordActivity.mCopyPasswordBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.copy_password, "field 'mCopyPasswordBtn'", TextView.class);
        generalOneTimePasswordActivity.mCopySuccessHint = (TextView) Utils.findRequiredViewAsType(view, R.id.copy_success_hint, "field 'mCopySuccessHint'", TextView.class);
        generalOneTimePasswordActivity.mShareBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.share_weixin, "field 'mShareBtn'", TextView.class);
        generalOneTimePasswordActivity.mFinishBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.finish, "field 'mFinishBtn'", TextView.class);
        generalOneTimePasswordActivity.mGenerateBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.click_generate, "field 'mGenerateBtn'", TextView.class);
    }

    public void unbind() {
        GeneralOneTimePasswordActivity generalOneTimePasswordActivity = this.f7760O000000o;
        if (generalOneTimePasswordActivity != null) {
            this.f7760O000000o = null;
            generalOneTimePasswordActivity.mBackBt = null;
            generalOneTimePasswordActivity.mContainerView = null;
            generalOneTimePasswordActivity.mGenerateTitleView = null;
            generalOneTimePasswordActivity.mGenerateTipsView = null;
            generalOneTimePasswordActivity.mPasswordText1 = null;
            generalOneTimePasswordActivity.mPasswordText2 = null;
            generalOneTimePasswordActivity.mPasswordText3 = null;
            generalOneTimePasswordActivity.mPasswordText4 = null;
            generalOneTimePasswordActivity.mPasswordText5 = null;
            generalOneTimePasswordActivity.mPasswordText6 = null;
            generalOneTimePasswordActivity.mPasswordText7 = null;
            generalOneTimePasswordActivity.mPasswordText8 = null;
            generalOneTimePasswordActivity.mCopyPasswordBtn = null;
            generalOneTimePasswordActivity.mCopySuccessHint = null;
            generalOneTimePasswordActivity.mShareBtn = null;
            generalOneTimePasswordActivity.mFinishBtn = null;
            generalOneTimePasswordActivity.mGenerateBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
