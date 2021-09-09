package com.google.android.play.core.assetpacks;

final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ax f3640a;
    private final AssetPackState b;

    au(ax axVar, AssetPackState assetPackState) {
        this.f3640a = axVar;
        this.b = assetPackState;
    }

    public final void run() {
        this.f3640a.a((Object) this.b);
    }
}
