package com.mobikwik.sdk.ui.frag;

import android.view.View;
import android.widget.Spinner;

class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Spinner f5324a;
    final /* synthetic */ m b;

    n(m mVar, Spinner spinner) {
        this.b = mVar;
        this.f5324a = spinner;
    }

    public void onClick(View view) {
        this.b.a(this.f5324a.getSelectedItemPosition() + 1);
    }
}
