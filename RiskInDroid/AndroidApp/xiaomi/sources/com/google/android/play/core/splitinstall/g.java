package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

final /* synthetic */ class g implements t {

    /* renamed from: a  reason: collision with root package name */
    private final SplitInstallStateUpdatedListener f3815a;

    g(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f3815a = splitInstallStateUpdatedListener;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        splitInstallManager.registerListener(this.f3815a);
        return Tasks.a((Object) null);
    }
}
