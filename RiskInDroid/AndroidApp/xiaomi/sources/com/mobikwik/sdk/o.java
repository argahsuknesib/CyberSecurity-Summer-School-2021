package com.mobikwik.sdk;

import android.content.DialogInterface;
import com.mobikwik.sdk.lib.SDKErrorCodes;

class o implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f5293a;

    o(PaymentActivity paymentActivity) {
        this.f5293a = paymentActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5293a.a(null, SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorCode(), SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorDescription());
    }
}
