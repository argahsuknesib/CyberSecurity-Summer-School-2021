package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;

final /* synthetic */ class n implements t {

    /* renamed from: a  reason: collision with root package name */
    private final int f3823a;

    n(int i) {
        this.f3823a = i;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.getSessionState(this.f3823a);
    }
}
