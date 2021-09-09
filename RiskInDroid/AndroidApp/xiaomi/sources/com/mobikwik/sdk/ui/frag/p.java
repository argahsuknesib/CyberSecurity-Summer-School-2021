package com.mobikwik.sdk.ui.frag;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.mobikwik.sdk.lib.model.SavedCardResponse;

class p implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f5327a;
    final /* synthetic */ LinearLayout b;
    final /* synthetic */ o c;

    p(o oVar, View view, LinearLayout linearLayout) {
        this.c = oVar;
        this.f5327a = view;
        this.b = linearLayout;
    }

    public void onGlobalLayout() {
        this.f5327a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.b.removeView(this.f5327a);
        int unused = this.c.v = this.f5327a.getHeight();
        if (this.c.w != null) {
            o oVar = this.c;
            oVar.a(oVar.w, this.c.getView());
            SavedCardResponse.CardDetails unused2 = this.c.w = (SavedCardResponse.CardDetails) null;
        }
    }
}
