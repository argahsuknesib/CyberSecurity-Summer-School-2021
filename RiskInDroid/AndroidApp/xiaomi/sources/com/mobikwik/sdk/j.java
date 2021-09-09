package com.mobikwik.sdk;

import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.model.TxnHashResponse;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.mobikwik.sdk.ui.data.b;

class j implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f5288a;

    j(PaymentActivity paymentActivity) {
        this.f5288a = paymentActivity;
    }

    /* renamed from: a */
    public void onTaskCompleted(TxnHashResponse txnHashResponse, GenerateOTPResponse generateOTPResponse) {
        if (txnHashResponse.getTxnHash() != null) {
            b.b(this.f5288a).b(txnHashResponse.getTxnHash());
            this.f5288a.h();
            return;
        }
        if (this.f5288a.f5277a != null && this.f5288a.f5277a.isShowing()) {
            this.f5288a.f5277a.dismiss();
        }
        this.f5288a.a(null, txnHashResponse.getStatuscode(), txnHashResponse.getStatusdescription());
    }

    public void onError(String str, String str2) {
        if (this.f5288a.f5277a != null && this.f5288a.f5277a.isShowing()) {
            this.f5288a.f5277a.dismiss();
        }
        this.f5288a.a(null, str, str2);
    }
}
