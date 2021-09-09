package com.mobikwik.sdk;

import android.view.View;

class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentOptions f5299a;

    u(PaymentOptions paymentOptions) {
        this.f5299a = paymentOptions;
    }

    public void onClick(View view) {
        this.f5299a.payByNetbanking(view);
    }
}
