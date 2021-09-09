package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;

final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3834a;

    e(int i) {
        this.f3834a = i;
    }

    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        if (splitInstallSessionState != null && this.f3834a == splitInstallSessionState.sessionId() && splitInstallSessionState.status() == 1) {
            return SplitInstallSessionState.create(this.f3834a, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }
}
