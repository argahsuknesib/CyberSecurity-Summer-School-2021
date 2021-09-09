package com.mobikwik.sdk;

import android.view.View;

class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentOptions f5297a;

    s(PaymentOptions paymentOptions) {
        this.f5297a = paymentOptions;
    }

    public void onClick(View view) {
        this.f5297a.payByCC(view);
    }
}
