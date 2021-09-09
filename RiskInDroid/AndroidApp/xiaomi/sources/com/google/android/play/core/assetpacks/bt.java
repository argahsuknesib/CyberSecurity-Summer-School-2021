package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.bl;

public final class bt {

    /* renamed from: a  reason: collision with root package name */
    private n f3663a;

    private bt() {
    }

    /* synthetic */ bt(byte[] bArr) {
    }

    public final a a() {
        n nVar = this.f3663a;
        if (nVar != null) {
            return new bu(nVar);
        }
        throw new IllegalStateException(String.valueOf(n.class.getCanonicalName()).concat(" must be set"));
    }

    public final void a(n nVar) {
        bl.a(nVar);
        this.f3663a = nVar;
    }
}
