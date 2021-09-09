package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ax f3641a;
    private final Bundle b;
    private final AssetPackState c;

    av(ax axVar, Bundle bundle, AssetPackState assetPackState) {
        this.f3641a = axVar;
        this.b = bundle;
        this.c = assetPackState;
    }

    public final void run() {
        this.f3641a.a(this.b, this.c);
    }
}
