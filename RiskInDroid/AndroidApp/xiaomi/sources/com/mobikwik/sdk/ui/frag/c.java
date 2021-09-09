package com.mobikwik.sdk.ui.frag;

import android.text.Editable;
import android.text.TextWatcher;

class c implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f5313a;

    c(a aVar) {
        this.f5313a = aVar;
    }

    public void afterTextChanged(Editable editable) {
        boolean unused = this.f5313a.a(true);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
