package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import java.util.List;

final /* synthetic */ class q implements t {

    /* renamed from: a  reason: collision with root package name */
    private final List f3826a;

    q(List list) {
        this.f3826a = list;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.deferredInstall(this.f3826a);
    }
}
