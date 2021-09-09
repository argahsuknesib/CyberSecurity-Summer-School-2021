package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ax f3642a;
    private final Bundle b;

    aw(ax axVar, Bundle bundle) {
        this.f3642a = axVar;
        this.b = bundle;
    }

    public final void run() {
        this.f3642a.a(this.b);
    }
}
