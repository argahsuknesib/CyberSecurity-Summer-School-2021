package com.mobikwik.sdk.ui.frag;

import android.view.View;
import android.widget.AdapterView;

class e implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f5315a;

    e(d dVar) {
        this.f5315a = dVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        d dVar = this.f5315a;
        dVar.a(dVar.c.getIntent(), false, i);
    }
}
