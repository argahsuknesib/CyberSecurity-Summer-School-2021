package com.mobikwik.sdk.ui.frag;

import android.view.View;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;

class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f5334a;

    w(t tVar) {
        this.f5334a = tVar;
    }

    public void onClick(View view) {
        this.f5334a.c.a(PaymentInstrumentType.DEBIT_CARD);
    }
}
