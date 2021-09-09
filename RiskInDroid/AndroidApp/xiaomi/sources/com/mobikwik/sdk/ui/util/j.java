package com.mobikwik.sdk.ui.util;

import android.content.DialogInterface;
import com.mobikwik.sdk.ui.util.d;

class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f5347a;

    j(d.b bVar) {
        this.f5347a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5347a.f != null) {
            this.f5347a.f.a();
        }
    }
}
