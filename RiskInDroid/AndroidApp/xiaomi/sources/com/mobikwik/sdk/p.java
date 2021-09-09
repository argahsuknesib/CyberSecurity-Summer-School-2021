package com.mobikwik.sdk;

import android.content.Intent;

class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f5294a;
    final /* synthetic */ PaymentActivity b;

    p(PaymentActivity paymentActivity, Intent intent) {
        this.b = paymentActivity;
        this.f5294a = intent;
    }

    public void run() {
        this.b.a(Double.valueOf(Double.parseDouble(this.f5294a.getStringExtra("walletBalance"))));
    }
}
