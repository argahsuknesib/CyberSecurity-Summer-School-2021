package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import java.util.List;

final /* synthetic */ class r implements t {

    /* renamed from: a  reason: collision with root package name */
    private final List f3827a;

    r(List list) {
        this.f3827a = list;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.deferredLanguageInstall(this.f3827a);
    }
}
