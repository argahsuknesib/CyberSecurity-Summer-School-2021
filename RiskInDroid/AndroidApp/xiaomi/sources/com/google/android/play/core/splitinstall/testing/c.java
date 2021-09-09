package com.google.android.play.core.splitinstall.testing;

import java.util.List;

final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3832a;
    final /* synthetic */ List b;
    final /* synthetic */ FakeSplitInstallManager c;

    c(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.c = fakeSplitInstallManager;
        this.f3832a = list;
        this.b = list2;
    }

    public final void run() {
        FakeSplitInstallManager.a(this.c, this.f3832a, this.b);
    }
}
