package com.xiaomi.mico.application;

import _m_j.ftn;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.application.ActivityLifecycleMonitor;
import com.xiaomi.mico.base.MicoHelperListener;
import com.xiaomi.mico.common.application.ApplicationConstants;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.util.Cache;
import com.xiaomi.mico.music.player.PlayerManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MicoApplication implements ActivityLifecycleMonitor.ValidAppStateMonitor {
    public static volatile boolean sAppValid;
    private static MicoApplication sInstance;
    Context mContext;
    private MicoHelperListener mMicoHelperListener;
    private final ActivityLifecycleMonitor micoActivityLifecycleMonitor = new ActivityLifecycleMonitor(this);

    public ActivityLifecycleMonitor getMicoActivityLifecycleMonitor() {
        return this.micoActivityLifecycleMonitor;
    }

    public static void init(Context context, MicoHelperListener micoHelperListener) {
        if (sInstance == null) {
            sInstance = new MicoApplication(context, micoHelperListener);
            return;
        }
        throw new IllegalStateException("ApiManager has already been initialized.");
    }

    public static MicoApplication getInstance() {
        MicoApplication micoApplication = sInstance;
        if (micoApplication != null) {
            return micoApplication;
        }
        throw new IllegalStateException("ApiManager has not been initialized.");
    }

    public MicoApplication(Context context, MicoHelperListener micoHelperListener) {
        this.mContext = context;
        this.mMicoHelperListener = micoHelperListener;
        ApplicationConstants.init();
        setupCache();
        MicoManager.getInstance().loadPersistentData();
        ApiManager.init(context, null, null);
        if (ftn.O00000oO(this.mContext)) {
            if (ftn.O0000Oo0(this.mContext) && !TextUtils.equals(AreaCode.getLocation().getCode(), "TW")) {
                AreaCode.setLocation(AreaCode.TW.getCode());
                LoginManager.getInstance().updateAccountInfo();
            }
        } else if (!TextUtils.equals(AreaCode.getLocation().getCode(), "CN")) {
            AreaCode.setLocation(AreaCode.CN.getCode());
            LoginManager.getInstance().updateAccountInfo();
        }
    }

    public Context getGlobalContext() {
        return this.mContext;
    }

    private void setupCache() {
        Observable.create(new Observable.OnSubscribe<Boolean>() {
            /* class com.xiaomi.mico.application.MicoApplication.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super Boolean>) ((Subscriber) obj));
            }

            public void call(Subscriber<? super Boolean> subscriber) {
                try {
                    File externalFilesDir = MicoApplication.this.mContext.getExternalFilesDir("mico_data_cache");
                    if (externalFilesDir == null) {
                        externalFilesDir = MicoApplication.this.mContext.getDir("mico_data_cache", 0);
                    }
                    Cache.init(externalFilesDir, 1, 10485760);
                    String str = Cache.get("CACHE_VERSION");
                    PackageInfo packageInfo = MicoApplication.this.mContext.getPackageManager().getPackageInfo(MicoApplication.this.mContext.getPackageName(), 0);
                    if (!TextUtils.isEmpty(str) && !str.equals(String.valueOf(packageInfo.versionCode))) {
                        Cache.deleteAll();
                        Cache.init(externalFilesDir, 1, 10485760);
                    }
                    Cache.put("CACHE_VERSION", String.valueOf(packageInfo.versionCode), TimeUnit.DAYS.toSeconds(30));
                } catch (PackageManager.NameNotFoundException | IOException unused) {
                }
                subscriber.onNext(Boolean.TRUE);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Boolean>() {
            /* class com.xiaomi.mico.application.MicoApplication.AnonymousClass1 */

            public void call(Boolean bool) {
            }
        });
    }

    public MicoHelperListener getMicoHelperListener() {
        return this.mMicoHelperListener;
    }

    public void onAppValid(boolean z) {
        sAppValid = z;
    }

    public void onValidAppEnterForeground() {
        PlayerManager.getInstance().startQuery();
    }

    public void onValidAppEnterBackground() {
        PlayerManager.getInstance().stopQuery();
    }
}
