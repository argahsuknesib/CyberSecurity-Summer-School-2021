package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import java.util.List;

final /* synthetic */ class s implements t {

    /* renamed from: a  reason: collision with root package name */
    private final List f3828a;

    s(List list) {
        this.f3828a = list;
    }

    public final Task a(SplitInstallManager splitInstallManager) {
        return splitInstallManager.deferredLanguageUninstall(this.f3828a);
    }
}
