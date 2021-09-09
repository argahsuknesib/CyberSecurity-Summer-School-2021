package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;

final class ao extends al<Void> {
    final /* synthetic */ as c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ao(as asVar, i<Void> iVar) {
        super(asVar, iVar);
        this.c = asVar;
    }

    public final void a(Bundle bundle, Bundle bundle2) {
        super.a(bundle, bundle2);
        if (!this.c.g.compareAndSet(true, false)) {
            as.f3638a.d("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.a();
        }
    }
}
