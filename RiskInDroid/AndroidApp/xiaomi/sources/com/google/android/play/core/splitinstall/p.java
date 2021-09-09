package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import java.util.List;

final /* synthetic */ class p implements t {

    /* renamed from: a  reason: collision with root package name */
    private final List f3825a;

    p(List list) {
        this.f3825a = list;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.deferredUninstall(this.f3825a);
    }
}
