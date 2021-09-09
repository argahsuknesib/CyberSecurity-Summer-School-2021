package com.mi.global.shop.widget.dialog;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CustomVerifyOTPDialog_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CustomVerifyOTPDialog f4997O000000o;

    public CustomVerifyOTPDialog_ViewBinding(CustomVerifyOTPDialog customVerifyOTPDialog, View view) {
        this.f4997O000000o = customVerifyOTPDialog;
        customVerifyOTPDialog.mCloseBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'mCloseBtn'", CustomButtonView.class);
        customVerifyOTPDialog.mPhoneView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_phone, "field 'mPhoneView'", CustomTextView.class);
        customVerifyOTPDialog.mOtpNumView = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.tv_otp_num, "field 'mOtpNumView'", CustomEditTextView.class);
        customVerifyOTPDialog.mOtpSendView = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.tv_otp_send, "field 'mOtpSendView'", CustomButtonView.class);
        customVerifyOTPDialog.mLoanAgreeDetailView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_loan_agree_detail, "field 'mLoanAgreeDetailView'", CustomTextView.class);
        customVerifyOTPDialog.mCancelBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_cancel, "field 'mCancelBtn'", CustomButtonView.class);
        customVerifyOTPDialog.mConfirmBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mConfirmBtn'", CustomButtonView.class);
    }

    public void unbind() {
        CustomVerifyOTPDialog customVerifyOTPDialog = this.f4997O000000o;
        if (customVerifyOTPDialog != null) {
            this.f4997O000000o = null;
            customVerifyOTPDialog.mCloseBtn = null;
            customVerifyOTPDialog.mPhoneView = null;
            customVerifyOTPDialog.mOtpNumView = null;
            customVerifyOTPDialog.mOtpSendView = null;
            customVerifyOTPDialog.mLoanAgreeDetailView = null;
            customVerifyOTPDialog.mCancelBtn = null;
            customVerifyOTPDialog.mConfirmBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
