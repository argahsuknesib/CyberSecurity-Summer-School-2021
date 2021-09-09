package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class af implements SplitInstallManager {

    /* renamed from: a  reason: collision with root package name */
    private final az f3799a;
    /* access modifiers changed from: private */
    public final ac b;
    private final z c;
    private final ba d;
    private final Handler e = new Handler(Looper.getMainLooper());

    af(az azVar, Context context) {
        String packageName = context.getPackageName();
        this.c = new z(context, packageName);
        this.f3799a = azVar;
        this.b = ac.a(context);
        this.d = new ba(context);
    }

    /* access modifiers changed from: private */
    public static List<String> b(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Locale next : list) {
            if (Build.VERSION.SDK_INT >= 21) {
                arrayList.add(next.toLanguageTag());
            }
        }
        return arrayList;
    }

    public final Task<Void> cancelInstall(int i) {
        return this.f3799a.b(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return this.f3799a.b(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Build.VERSION.SDK_INT < 21 ? Tasks.a((Exception) new SplitInstallException(-5)) : this.f3799a.c(b(list));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Build.VERSION.SDK_INT < 21 ? Tasks.a((Exception) new SplitInstallException(-5)) : this.f3799a.d(b(list));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        this.d.a(list);
        return this.f3799a.a(list);
    }

    public final Set<String> getInstalledLanguages() {
        Set<String> b2 = this.c.b();
        return b2 == null ? Collections.emptySet() : b2;
    }

    public final Set<String> getInstalledModules() {
        return this.c.a();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return this.f3799a.a(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return this.f3799a.a();
    }

    public final synchronized void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.a((StateUpdatedListener) splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return startConfirmationDialogForResult(splitInstallSessionState, new ae(activity), i);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(splitInstallSessionState.resolutionIntent().getIntentSender(), i, null, 0, 0, 0, null);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        if (r2.containsAll(r3) != false) goto L_0x004b;
     */
    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        if (!splitInstallRequest.getLanguages().isEmpty() && Build.VERSION.SDK_INT < 21) {
            return Tasks.a((Exception) new SplitInstallException(-5));
        }
        List<Locale> languages = splitInstallRequest.getLanguages();
        Set<String> b2 = this.c.b();
        if (b2 != null) {
            HashSet hashSet = new HashSet();
            for (Locale language : languages) {
                hashSet.add(language.getLanguage());
            }
        }
        if (getInstalledModules().containsAll(splitInstallRequest.getModuleNames()) && (Build.VERSION.SDK_INT < 21 || Collections.disjoint(splitInstallRequest.getModuleNames(), this.d.a()))) {
            this.e.post(new ad(this, splitInstallRequest));
            return Tasks.a((Object) 0);
        }
        return this.f3799a.a(splitInstallRequest.getModuleNames(), b(splitInstallRequest.getLanguages()));
    }

    public final synchronized void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.b.b(splitInstallStateUpdatedListener);
    }
}
