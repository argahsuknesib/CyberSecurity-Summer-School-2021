package com.mi.global.shop.user;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomEditTextView;
import com.xiaomi.smarthome.R;

public class FeedbackActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private FeedbackActivity f4923O000000o;

    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity, View view) {
        this.f4923O000000o = feedbackActivity;
        feedbackActivity.feedbackContent = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.feedback_content, "field 'feedbackContent'", CustomEditTextView.class);
        feedbackActivity.feedbackInfo = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.feedback_info, "field 'feedbackInfo'", CustomEditTextView.class);
        feedbackActivity.btnSubmit = (CommonButton) Utils.findRequiredViewAsType(view, R.id.btn_submit, "field 'btnSubmit'", CommonButton.class);
    }

    public void unbind() {
        FeedbackActivity feedbackActivity = this.f4923O000000o;
        if (feedbackActivity != null) {
            this.f4923O000000o = null;
            feedbackActivity.feedbackContent = null;
            feedbackActivity.feedbackInfo = null;
            feedbackActivity.btnSubmit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
