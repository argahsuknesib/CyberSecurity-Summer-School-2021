package com.mobikwik.sdk;

import android.view.View;

class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentOptions f5298a;

    t(PaymentOptions paymentOptions) {
        this.f5298a = paymentOptions;
    }

    public void onClick(View view) {
        this.f5298a.payByDC(view);
    }
}
