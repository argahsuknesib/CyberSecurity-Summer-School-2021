package com.mobikwik.sdk;

import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.tasks.GetSavedCards;

class b implements GetSavedCards.GetSavedCardsListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f5280a;

    b(a aVar) {
        this.f5280a = aVar;
    }

    public void onSavedCaredLoded(SavedCardResponse.CardDetails[] cardDetailsArr) {
        if (this.f5280a.e.b != null && this.f5280a.e.b.isShowing()) {
            this.f5280a.e.b.dismiss();
        }
        this.f5280a.e.a(this.f5280a.b, cardDetailsArr);
    }
}
