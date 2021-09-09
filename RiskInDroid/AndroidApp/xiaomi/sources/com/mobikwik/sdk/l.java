package com.mobikwik.sdk;

import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;

class l implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f5290a;
    final /* synthetic */ PaymentActivity b;

    l(PaymentActivity paymentActivity, boolean z) {
        this.b = paymentActivity;
        this.f5290a = z;
    }

    /* renamed from: a */
    public void onTaskCompleted(GenerateOTPResponse generateOTPResponse, GenerateOTPResponse generateOTPResponse2) {
        if (this.b.f5277a != null && this.b.f5277a.isShowing()) {
            this.b.f5277a.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
            this.b.a(this.f5290a, generateOTPResponse.getStatusdescription());
            return;
        }
        PaymentActivity paymentActivity = this.b;
        paymentActivity.a(null, generateOTPResponse.getStatuscode(), generateOTPResponse.getStatusdescription());
    }

    public void onError(String str, String str2) {
        if (this.b.f5277a != null && this.b.f5277a.isShowing()) {
            this.b.f5277a.dismiss();
        }
        this.b.a(null, str, str2);
    }
}
