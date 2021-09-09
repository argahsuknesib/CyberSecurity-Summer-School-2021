package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;

final /* synthetic */ class m implements t {

    /* renamed from: a  reason: collision with root package name */
    private final int f3821a;

    m(int i) {
        this.f3821a = i;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.cancelInstall(this.f3821a);
    }
}
