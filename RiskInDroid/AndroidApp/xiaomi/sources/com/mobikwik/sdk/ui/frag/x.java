package com.mobikwik.sdk.ui.frag;

import android.view.View;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;

class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f5335a;

    x(t tVar) {
        this.f5335a = tVar;
    }

    public void onClick(View view) {
        this.f5335a.c.a(PaymentInstrumentType.NETBANKING);
    }
}
