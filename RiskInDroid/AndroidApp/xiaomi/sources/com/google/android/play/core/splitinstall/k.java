package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

final /* synthetic */ class k implements t {

    /* renamed from: a  reason: collision with root package name */
    private final SplitInstallStateUpdatedListener f3819a;

    k(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f3819a = splitInstallStateUpdatedListener;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        splitInstallManager.unregisterListener(this.f3819a);
        return Tasks.a((Object) null);
    }
}
