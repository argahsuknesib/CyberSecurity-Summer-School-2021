package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplitInstallRequest f3797a;
    final /* synthetic */ af b;

    ad(af afVar, SplitInstallRequest splitInstallRequest) {
        this.b = afVar;
        this.f3797a = splitInstallRequest;
    }

    public final void run() {
        ac a2 = this.b.b;
        List<String> moduleNames = this.f3797a.getModuleNames();
        List a3 = af.b(this.f3797a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(moduleNames));
        }
        if (!a3.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(a3));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        a2.a(SplitInstallSessionState.a(bundle));
    }
}
