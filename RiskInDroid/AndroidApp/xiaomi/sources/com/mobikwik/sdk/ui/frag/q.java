package com.mobikwik.sdk.ui.frag;

import android.text.Editable;
import android.text.TextWatcher;

class q implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f5328a;

    q(o oVar) {
        this.f5328a = oVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.ui.frag.o, boolean):boolean
     arg types: [com.mobikwik.sdk.ui.frag.o, int]
     candidates:
      com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.ui.frag.o, int):int
      com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.ui.frag.o, android.app.ProgressDialog):android.app.ProgressDialog
      com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.ui.frag.o, com.mobikwik.sdk.lib.model.SavedCardResponse$CardDetails):com.mobikwik.sdk.lib.model.SavedCardResponse$CardDetails
      com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.lib.model.SavedCardResponse$CardDetails, android.view.View):void
      com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.lib.model.SavedCardResponse$CardDetails, java.lang.String):void
      com.mobikwik.sdk.ui.frag.o.a(com.mobikwik.sdk.ui.frag.o, boolean):boolean */
    public void afterTextChanged(Editable editable) {
        boolean unused = this.f5328a.a(true);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
