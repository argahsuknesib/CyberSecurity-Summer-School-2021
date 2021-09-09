package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeAppUpdateManager implements AppUpdateManager {

    /* renamed from: a  reason: collision with root package name */
    private final a f3622a;
    private final Context b;
    @InstallStatus
    private int c = 0;
    @InstallErrorCode
    private int d = 0;
    private boolean e = false;
    private int f = 0;
    private Integer g = null;
    private int h = 0;
    private long i = 0;
    private long j = 0;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    @AppUpdateType
    private Integer n;

    public FakeAppUpdateManager(Context context) {
        this.f3622a = new a(context);
        this.b = context;
    }

    @UpdateAvailability
    private final int a() {
        if (!this.e) {
            return 1;
        }
        int i2 = this.c;
        return (i2 == 0 || i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3;
    }

    private final boolean a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i2;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.l = true;
            i2 = 1;
        } else {
            this.k = true;
            i2 = 0;
        }
        this.n = i2;
        return true;
    }

    private final void b() {
        this.f3622a.a(InstallState.a(this.c, this.i, this.j, this.d, this.b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        int i2 = this.d;
        if (i2 != 0) {
            return Tasks.a((Exception) new InstallException(i2));
        }
        int i3 = this.c;
        if (i3 != 11) {
            return i3 == 3 ? Tasks.a((Exception) new InstallException(-8)) : Tasks.a((Exception) new InstallException(-7));
        }
        this.c = 3;
        this.m = true;
        Integer num = 0;
        if (num.equals(this.n)) {
            b();
        }
        return Tasks.a((Object) null);
    }

    public void downloadCompletes() {
        int i2 = this.c;
        if (i2 == 2 || i2 == 1) {
            this.c = 11;
            this.i = 0;
            this.j = 0;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.n)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i2 = this.c;
        if (i2 == 1 || i2 == 2) {
            this.c = 5;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.l = false;
            this.c = 0;
        }
    }

    public void downloadStarts() {
        if (this.c == 1) {
            this.c = 2;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        int i2 = this.d;
        if (i2 != 0) {
            return Tasks.a((Exception) new InstallException(i2));
        }
        PendingIntent broadcast = (a() == 2 && this.d == 0) ? PendingIntent.getBroadcast(this.b, 0, new Intent(), 0) : null;
        PendingIntent broadcast2 = (a() == 2 && this.d == 0) ? PendingIntent.getBroadcast(this.b, 0, new Intent(), 0) : null;
        if (a() == 2 && this.d == 0) {
            PendingIntent broadcast3 = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);
            pendingIntent2 = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);
            pendingIntent = broadcast3;
        } else {
            pendingIntent2 = null;
            pendingIntent = null;
        }
        return Tasks.a(AppUpdateInfo.a(this.b.getPackageName(), this.f, a(), this.c, this.g, this.h, this.i, this.j, 0, 0, broadcast2, broadcast, pendingIntent2, pendingIntent));
    }

    @AppUpdateType
    public Integer getTypeForUpdateInProgress() {
        return this.n;
    }

    public void installCompletes() {
        if (this.c == 3) {
            this.c = 4;
            this.e = false;
            this.f = 0;
            this.g = null;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.l = false;
            this.m = false;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.c = 0;
        }
    }

    public void installFails() {
        if (this.c == 3) {
            this.c = 5;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.m = false;
            this.l = false;
            this.c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.k;
    }

    public boolean isImmediateFlowVisible() {
        return this.l;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.m;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f3622a.a((StateUpdatedListener) installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j2) {
        if (this.c == 2 && j2 <= this.j) {
            this.i = j2;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
        }
    }

    public void setClientVersionStalenessDays(Integer num) {
        if (this.e) {
            this.g = num;
        }
    }

    public void setInstallErrorCode(@InstallErrorCode int i2) {
        this.d = i2;
    }

    public void setTotalBytesToDownload(long j2) {
        if (this.c == 2) {
            this.j = j2;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
        }
    }

    public void setUpdateAvailable(int i2) {
        this.e = true;
        this.f = i2;
    }

    public void setUpdateNotAvailable() {
        this.e = false;
        this.g = null;
    }

    public void setUpdatePriority(int i2) {
        if (this.e) {
            this.h = i2;
        }
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return a(appUpdateInfo, appUpdateOptions) ? Tasks.a((Object) -1) : Tasks.a((Exception) new InstallException(-6));
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, Activity activity, int i3) {
        return a(appUpdateInfo, AppUpdateOptions.newBuilder(i2).build());
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, IntentSenderForResultStarter intentSenderForResultStarter, int i3) {
        return a(appUpdateInfo, AppUpdateOptions.newBuilder(i2).build());
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i2) {
        return a(appUpdateInfo, appUpdateOptions);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i2) {
        return a(appUpdateInfo, appUpdateOptions);
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f3622a.b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.k || this.l) {
            this.k = false;
            this.c = 1;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
        }
    }

    public void userCancelsDownload() {
        int i2 = this.c;
        if (i2 == 1 || i2 == 2) {
            this.c = 6;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.l = false;
            this.c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.k || this.l) {
            this.k = false;
            this.l = false;
            this.n = null;
            this.c = 0;
        }
    }
}
