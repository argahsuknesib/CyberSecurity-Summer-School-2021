package com.mobikwik.sdk;

import android.content.DialogInterface;
import com.mobikwik.sdk.lib.SDKErrorCodes;

class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentOptions f5351a;

    x(PaymentOptions paymentOptions) {
        this.f5351a = paymentOptions;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5351a.a(null, SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorCode(), SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorDescription());
    }
}
