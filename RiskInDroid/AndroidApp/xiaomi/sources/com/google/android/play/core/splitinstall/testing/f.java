package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplitInstallSessionState f3835a;
    final /* synthetic */ FakeSplitInstallManager b;

    f(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.b = fakeSplitInstallManager;
        this.f3835a = splitInstallSessionState;
    }

    public final void run() {
        this.b.f.a(this.f3835a);
    }
}
