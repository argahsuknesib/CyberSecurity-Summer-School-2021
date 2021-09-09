package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class l implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadFactory f3724a = new l();

    private l() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
