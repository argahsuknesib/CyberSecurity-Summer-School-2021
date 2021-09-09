package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;

final class d implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplitInstallRequest f3833a;

    d(SplitInstallRequest splitInstallRequest) {
        this.f3833a = splitInstallRequest;
    }

    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        if (splitInstallSessionState == null || splitInstallSessionState.hasTerminalStatus()) {
            return SplitInstallSessionState.create(splitInstallSessionState != null ? 1 + splitInstallSessionState.sessionId() : 1, 1, 0, 0, 0, this.f3833a.getModuleNames(), new ArrayList());
        }
        throw new SplitInstallException(-1);
    }
}
