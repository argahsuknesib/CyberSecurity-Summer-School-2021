package com.mobikwik.sdk;

import android.view.View;

class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentOptions f5296a;

    r(PaymentOptions paymentOptions) {
        this.f5296a = paymentOptions;
    }

    public void onClick(View view) {
        this.f5296a.payBySC(view);
    }
}
