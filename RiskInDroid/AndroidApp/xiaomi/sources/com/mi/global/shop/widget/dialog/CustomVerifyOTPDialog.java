package com.mi.global.shop.widget.dialog;

import _m_j.byl;
import _m_j.cec;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CustomVerifyOTPDialog extends Dialog implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4995O000000o;
    public String O00000Oo;
    private O000000o O00000o;
    public CountDownTimer O00000o0;
    @BindView(2131493021)
    CustomButtonView mCancelBtn;
    @BindView(2131493023)
    CustomButtonView mCloseBtn;
    @BindView(2131493024)
    CustomButtonView mConfirmBtn;
    @BindView(2131494226)
    CustomTextView mLoanAgreeDetailView;
    @BindView(2131494241)
    CustomEditTextView mOtpNumView;
    @BindView(2131494242)
    CustomButtonView mOtpSendView;
    @BindView(2131494245)
    CustomTextView mPhoneView;

    public interface O000000o {
        void O000000o(String str);

        void O00000Oo();
    }

    public CustomVerifyOTPDialog(Context context, O000000o o000000o) {
        super(context, R.style.Dialog);
        this.f4995O000000o = context;
        this.O00000o = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.shop_custom_verify_otp_dialog);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        this.mCloseBtn.setOnClickListener(this);
        this.mOtpSendView.setOnClickListener(this);
        this.mLoanAgreeDetailView.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
        this.mConfirmBtn.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            this.mPhoneView.setText(this.O00000Oo);
        }
    }

    public final void O000000o() {
        CountDownTimer countDownTimer = this.O00000o0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        O00000Oo();
        this.O00000o0 = new CountDownTimer() {
            /* class com.mi.global.shop.widget.dialog.CustomVerifyOTPDialog.AnonymousClass1 */

            public final void onFinish() {
                CustomVerifyOTPDialog customVerifyOTPDialog = CustomVerifyOTPDialog.this;
                customVerifyOTPDialog.mOtpSendView.setText(customVerifyOTPDialog.f4995O000000o.getString(R.string.cardless_emi_otp_down_time_resend_));
                customVerifyOTPDialog.mOtpSendView.setBackgroundResource(R.drawable.shop_cardless_plan_select_item_bg);
                customVerifyOTPDialog.mOtpSendView.setTextColor(customVerifyOTPDialog.f4995O000000o.getResources().getColor(R.color.orange_red));
                customVerifyOTPDialog.mOtpSendView.setEnabled(true);
                CustomVerifyOTPDialog.this.O00000o0 = null;
            }

            public final void onTick(long j) {
                CustomVerifyOTPDialog customVerifyOTPDialog = CustomVerifyOTPDialog.this;
                CustomButtonView customButtonView = customVerifyOTPDialog.mOtpSendView;
                String string = customVerifyOTPDialog.f4995O000000o.getString(R.string.cardless_emi_otp_down_time_resend);
                StringBuilder sb = new StringBuilder();
                sb.append(j / 1000);
                customButtonView.setText(String.format(string, sb.toString()));
            }
        }.start();
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
    }

    private void O00000Oo() {
        this.mOtpSendView.setBackgroundResource(R.drawable.shop_cardless_plan_item_bg);
        this.mOtpSendView.setTextColor(this.f4995O000000o.getResources().getColor(R.color.home_footer_text_color));
        this.mOtpSendView.setEnabled(false);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            O00000o0();
        } else if (id == R.id.tv_otp_send) {
            O000000o();
        } else if (id == R.id.btn_cancel) {
            O00000o0();
        } else if (id == R.id.btn_confirm) {
            String obj = this.mOtpNumView.getText().toString();
            if (TextUtils.isEmpty(obj) || !TextUtils.isDigitsOnly(obj)) {
                cec.O000000o(byl.O00000oO(), this.f4995O000000o.getString(R.string.cardless_emi_otp_input_tips), 0);
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f4995O000000o.getSystemService("input_method");
            if (!(!inputMethodManager.isActive() || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null)) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O000000o(this.mOtpNumView.getText().toString());
            }
        }
    }

    private void O00000o0() {
        if (BaseActivity.isActivityAlive(this.f4995O000000o)) {
            dismiss();
        }
        CountDownTimer countDownTimer = this.O00000o0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.O00000o0 = null;
        }
    }
}
