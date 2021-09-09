package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitcompat.q;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManagerFactory;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;

final class u implements SplitInstallManager {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3838a;
    private final Context b;
    private volatile SplitInstallManager c;
    private final ag d;

    private u(Context context, Executor executor, ag agVar, byte[] bArr) {
        this.b = v.a(context);
        this.f3838a = executor;
        this.d = agVar;
    }

    static u a(Context context, Executor executor) {
        return new u(context, executor, new ag(null), null);
    }

    private final <T> Task<T> a(t<T> tVar) {
        SplitInstallManager splitInstallManager = this.c;
        if (splitInstallManager != null) {
            return tVar.a(splitInstallManager);
        }
        i iVar = new i();
        i iVar2 = new i();
        iVar2.a().addOnCompleteListener(new h(tVar, iVar));
        this.f3838a.execute(new i(this, iVar2));
        return iVar.a();
    }

    /* access modifiers changed from: package-private */
    public final synchronized SplitInstallManager a() {
        SplitInstallManager splitInstallManager = this.c;
        if (splitInstallManager != null) {
            return splitInstallManager;
        }
        Context context = this.b;
        File a2 = FakeSplitInstallManagerFactory.a(context);
        SplitInstallManager fakeSplitInstallManager = a2 != null ? new FakeSplitInstallManager(context, a2, q.a()) : new af(new az(context), context);
        this.c = fakeSplitInstallManager;
        return fakeSplitInstallManager;
    }

    public final Task<Void> cancelInstall(int i) {
        return a(new m(i));
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return a(new q(list));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return a(new r(list));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return a(new s(list));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return a(new p(list));
    }

    public final Set<String> getInstalledLanguages() {
        return a().getInstalledLanguages();
    }

    public final Set<String> getInstalledModules() {
        return a().getInstalledModules();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return a(new n(i));
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return a(o.f3824a);
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        a(new g(splitInstallStateUpdatedListener));
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return a().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return a().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        return a(new l(splitInstallRequest));
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        a(new k(splitInstallStateUpdatedListener));
    }
}
