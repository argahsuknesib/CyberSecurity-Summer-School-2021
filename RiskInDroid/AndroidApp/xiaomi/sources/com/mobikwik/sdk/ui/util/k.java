package com.mobikwik.sdk.ui.util;

import android.content.DialogInterface;
import com.mobikwik.sdk.ui.util.d;

class k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f5348a;

    k(d.b bVar) {
        this.f5348a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5348a.f != null) {
            this.f5348a.f.c();
        }
    }
}
