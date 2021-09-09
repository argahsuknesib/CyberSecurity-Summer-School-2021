package com.mobikwik.sdk;

import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.model.QueryWalletResponse;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;

class k implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f5289a;

    k(PaymentActivity paymentActivity) {
        this.f5289a = paymentActivity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mobikwik.sdk.PaymentActivity.a(com.mobikwik.sdk.PaymentActivity, boolean, java.lang.String):void
     arg types: [com.mobikwik.sdk.PaymentActivity, int, java.lang.String]
     candidates:
      com.mobikwik.sdk.PaymentActivity.a(android.content.Intent, java.lang.String, java.lang.String):void
      com.mobikwik.sdk.PaymentActivity.a(com.mobikwik.sdk.PaymentActivity, boolean, java.lang.String):void */
    /* renamed from: a */
    public void onTaskCompleted(QueryWalletResponse queryWalletResponse, GenerateOTPResponse generateOTPResponse) {
        if (this.f5289a.f5277a != null && this.f5289a.f5277a.isShowing()) {
            this.f5289a.f5277a.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(queryWalletResponse.getStatuscode())) {
            this.f5289a.d.d().updateUser(new User(queryWalletResponse.getEmail(), queryWalletResponse.getCell()));
            if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
                this.f5289a.a(false, generateOTPResponse.getStatusdescription());
                return;
            }
            PaymentActivity paymentActivity = this.f5289a;
            paymentActivity.a(null, generateOTPResponse.getStatuscode(), generateOTPResponse.getStatusdescription());
        } else if (!SDKErrorCodes.USER_NOT_REGISTERED.getErrorCode().equals(queryWalletResponse.getStatuscode())) {
            PaymentActivity paymentActivity2 = this.f5289a;
            paymentActivity2.a(null, queryWalletResponse.getStatuscode(), queryWalletResponse.getStatusdescription());
        } else if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
            this.f5289a.a(true, generateOTPResponse.getStatusdescription());
        } else {
            PaymentActivity paymentActivity3 = this.f5289a;
            paymentActivity3.a(null, generateOTPResponse.getStatuscode(), generateOTPResponse.getStatusdescription());
        }
    }

    public void onError(String str, String str2) {
        if (this.f5289a.f5277a != null && this.f5289a.f5277a.isShowing()) {
            this.f5289a.f5277a.dismiss();
        }
        this.f5289a.a(null, str, str2);
    }
}
