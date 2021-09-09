package com.mobikwik.sdk;

import android.view.View;

class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentOptions f5349a;

    v(PaymentOptions paymentOptions) {
        this.f5349a = paymentOptions;
    }

    public void onClick(View view) {
        this.f5349a.payByMkWallet(view);
    }
}
