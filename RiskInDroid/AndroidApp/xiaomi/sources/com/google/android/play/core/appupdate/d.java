package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;

final class d implements AppUpdateManager {

    /* renamed from: a  reason: collision with root package name */
    private final k f3612a;
    private final a b;
    private final Context c;
    private final Handler d = new Handler(Looper.getMainLooper());

    d(k kVar, Context context) {
        this.f3612a = kVar;
        this.b = new a(context);
        this.c = context;
    }

    public final Task<Void> completeUpdate() {
        return this.f3612a.b(this.c.getPackageName());
    }

    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.f3612a.a(this.c.getPackageName());
    }

    public final synchronized void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.b.a((StateUpdatedListener) installStateUpdatedListener);
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        PlayCoreDialogWrapperActivity.a(this.c);
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return Tasks.a((Exception) new InstallException(-6));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", appUpdateInfo.a(appUpdateOptions));
        i iVar = new i();
        intent.putExtra("result_receiver", new b(this.d, iVar));
        activity.startActivity(intent);
        return iVar.a();
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, new c(activity), AppUpdateOptions.defaultOptions(i), i2);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, intentSenderForResultStarter, AppUpdateOptions.defaultOptions(i), i2);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, new c(activity), appUpdateOptions, i);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException {
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(appUpdateInfo.a(appUpdateOptions).getIntentSender(), i, null, 0, 0, 0, null);
        return true;
    }

    public final synchronized void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.b.b(installStateUpdatedListener);
    }
}
