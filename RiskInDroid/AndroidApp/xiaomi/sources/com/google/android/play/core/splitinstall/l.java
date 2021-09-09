package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;

final /* synthetic */ class l implements t {

    /* renamed from: a  reason: collision with root package name */
    private final SplitInstallRequest f3820a;

    l(SplitInstallRequest splitInstallRequest) {
        this.f3820a = splitInstallRequest;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.startInstall(this.f3820a);
    }
}
