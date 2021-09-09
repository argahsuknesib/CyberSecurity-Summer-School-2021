package com.mobikwik.sdk.ui.frag;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

class ac implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f5304a;
    final /* synthetic */ ViewGroup b;
    final /* synthetic */ y c;

    ac(y yVar, View view, ViewGroup viewGroup) {
        this.c = yVar;
        this.f5304a = view;
        this.b = viewGroup;
    }

    public void onGlobalLayout() {
        int unused = this.c.g = this.f5304a.getHeight();
        this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.b.removeView(this.f5304a);
    }
}
