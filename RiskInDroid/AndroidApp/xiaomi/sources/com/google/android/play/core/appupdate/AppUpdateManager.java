package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.tasks.Task;

public interface AppUpdateManager {
    Task<Void> completeUpdate();

    Task<AppUpdateInfo> getAppUpdateInfo();

    void registerListener(InstallStateUpdatedListener installStateUpdatedListener);

    Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions);

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) throws IntentSender.SendIntentException;

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException;

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException;

    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException;

    void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener);
}
