package com.mobikwik.sdk.ui.util;

import android.content.DialogInterface;
import com.mobikwik.sdk.ui.util.d;

class f implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f5343a;

    f(d.b bVar) {
        this.f5343a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5343a.f();
        this.f5343a.b();
        if (this.f5343a.f != null) {
            this.f5343a.f.c();
        }
    }
}
