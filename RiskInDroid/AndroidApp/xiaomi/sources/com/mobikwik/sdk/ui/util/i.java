package com.mobikwik.sdk.ui.util;

import android.content.DialogInterface;
import com.mobikwik.sdk.ui.util.d;

class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f5346a;

    i(d.b bVar) {
        this.f5346a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5346a.f != null) {
            this.f5346a.f.b();
        }
    }
}
