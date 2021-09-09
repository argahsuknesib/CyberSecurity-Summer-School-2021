package com.xiaomi.smarthome.scene.geofence;

import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.goz;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hny;
import _m_j.hod;
import _m_j.hpf;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.geofence.GeoActionService;

@RouterService
public class GeoActionService extends Service {
    public static Handler mHandler;
    private int count = 0;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        gsy.O00000Oo(LogType.SCENE, "GeoActionService", "onCreate");
        this.count = 0;
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        gsy.O00000Oo(LogType.SCENE, "GeoActionService", "onStartCommand");
        showNotification(getString(R.string.scene_manage), getString(R.string.device_more_security_loading_operation));
        CoreApi.O000000o().O000000o(this, new CoreApi.O0000o0(intent, System.currentTimeMillis()) {
            /* class com.xiaomi.smarthome.scene.geofence.$$Lambda$GeoActionService$wrzuO5LEKNos2RjqRm5MEWcs3qI */
            private final /* synthetic */ Intent f$1;
            private final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onCoreReady() {
                GeoActionService.this.lambda$onStartCommand$0$GeoActionService(this.f$1, this.f$2);
            }
        });
        return super.onStartCommand(intent, i, i2);
    }

    public /* synthetic */ void lambda$onStartCommand$0$GeoActionService(Intent intent, long j) {
        gsy.O00000Oo(LogType.SCENE, "GeoActionService", "onStartCommand onCoreReady in");
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            gsy.O00000Oo(LogType.SCENE, "GeoActionService", "not login!");
            cancelNotification();
            return;
        }
        trySceneList(intent, 3, new int[]{0, 0, 10}, j, 60000);
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "onDestroy stopForeground");
        stopForeground(true);
        ((NotificationManager) getSystemService("notification")).cancel(996);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "onTaskRemoved");
    }

    public void handleIntent(Intent intent, long j) {
        gsy.O00000o0(LogType.SCENE, "GeoActionService", "handleIntent in");
        if (intent == null) {
            cancelNotification();
        } else if (TextUtils.equals("geofence_trigered", intent.getAction())) {
            int intExtra = intent.getIntExtra("trans_event", -90);
            String stringExtra = intent.getStringExtra("geofence_id");
            hpf.O000000o().O00000Oo();
            hpf.O000000o();
            if (!hpf.O000000o(stringExtra, j)) {
                gsy.O00000o0(LogType.GENERAL, "GeoActionService", "there is no GeoFenceItem for ".concat(String.valueOf(stringExtra)));
                cancelNotification();
                return;
            }
            Location location = (Location) intent.getParcelableExtra("location");
            if (intExtra == -90 || TextUtils.isEmpty(stringExtra) || location == null) {
                cancelNotification();
                LogType logType = LogType.SCENE;
                StringBuilder sb = new StringBuilder("extra has null:");
                String str = "";
                sb.append(intExtra == -90 ? "transevent is null  " : str);
                sb.append(TextUtils.isEmpty(stringExtra) ? "id is null  " : str);
                if (location == null) {
                    str = "location is null  ";
                }
                sb.append(str);
                gsy.O00000Oo(logType, "GeoActionService", sb.toString());
                return;
            }
            gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "handleIntent start onTriggerFence");
            hod O0000OoO = hod.O0000OoO();
            AnonymousClass1 r10 = new fsm() {
                /* class com.xiaomi.smarthome.scene.geofence.GeoActionService.AnonymousClass1 */

                public final void onSuccess(Object obj) {
                    gsy.O00000o0(LogType.SCENE, "GeoActionService", "handleIntent onTriggerFence onSuccess");
                    GeoActionService.this.cancelNotification();
                }

                public final void onFailure(fso fso) {
                    gsy.O00000o0(LogType.SCENE, "GeoActionService", "handleIntent onTriggerFence onFailure");
                    GeoActionService.this.cancelNotification();
                }
            };
            gsy.O00000Oo(LogType.GENERAL, "GEO_FENCE", "triggerFence，prepare to execute----");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(stringExtra + "****" + intExtra + "****" + location);
            if (gfr.f17662O000000o) {
                gqg.O00000Oo(stringExtra + "****" + intExtra + "****" + location);
            }
            if (!hpf.O000000o().O00000o0()) {
                sb2.append("\nPhone not supported");
                gsy.O00000Oo(LogType.GENERAL, "GEO_FENCE", sb2.toString());
                r10.onFailure(new fso(-90, "not support"));
                return;
            }
            O0000OoO.O000000o(stringExtra, sb2.toString(), r10);
        } else {
            cancelNotification();
        }
    }

    public void cancelNotification() {
        this.count--;
        gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "cancelNotification " + this.count);
        if (this.count <= 0) {
            gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "cancelNotification stopForeground");
            stopForeground(true);
            ((NotificationManager) getSystemService("notification")).cancel(996);
        }
    }

    private void showNotification(String str, String str2) {
        Notification.Builder builder;
        this.count++;
        gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "showNotification " + this.count);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("SmartHome", "app", 2);
            if (Build.VERSION.SDK_INT >= 28) {
                if (notificationManager.getNotificationChannelGroup("other") == null) {
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("other", getString(R.string.notification_channel_other)));
                }
                if (TextUtils.isEmpty(notificationChannel.getGroup())) {
                    notificationChannel.setGroup("other");
                }
            }
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(this, "app");
        } else {
            builder = new Notification.Builder(this);
        }
        builder.setSmallIcon((int) R.drawable.mj_notify_icon).setContentTitle(str).setContentText(str2);
        Notification build = builder.build();
        build.flags |= 16;
        if (Build.VERSION.SDK_INT < 24) {
            notificationManager.notify(996, build);
        } else {
            startForeground(996, build);
        }
    }

    public void trySceneList(Intent intent, int i, int[] iArr, long j, long j2) {
        int i2 = i;
        long currentTimeMillis = System.currentTimeMillis();
        LogType logType = LogType.SCENE;
        StringBuilder sb = new StringBuilder("start retry(");
        sb.append(i);
        sb.append(") scene list at ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(currentTimeMillis / 1000);
        sb.append(goz.O000000o(sb2.toString()));
        sb.append("----");
        sb.append(j);
        gsy.O00000o0(logType, "GeoActionService", sb.toString());
        if (i2 <= 1) {
            cancelNotification();
            return;
        }
        final long j3 = j;
        final Intent intent2 = intent;
        final int i3 = i;
        final int[] iArr2 = iArr;
        final long j4 = j2;
        hod.O0000OoO().O000000o(new hny() {
            /* class com.xiaomi.smarthome.scene.geofence.GeoActionService.AnonymousClass2 */

            public final void onRefreshScenceSuccess(int i) {
                LogType logType = LogType.SCENE;
                StringBuilder sb = new StringBuilder("scene list sucess at ");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis() / 1000);
                sb.append(goz.O000000o(sb2.toString()));
                sb.append("----");
                sb.append(j3);
                gsy.O00000o0(logType, "GeoActionService", sb.toString());
                GeoActionService.this.handleIntent(intent2, j3);
            }

            public final void onRefreshScenceFailed(int i) {
                long currentTimeMillis = System.currentTimeMillis();
                LogType logType = LogType.SCENE;
                StringBuilder sb = new StringBuilder("scene list onRefreshScenceFailed at ");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(currentTimeMillis / 1000);
                sb.append(goz.O000000o(sb2.toString()));
                sb.append("----");
                sb.append(j3);
                gsy.O00000o0(logType, "GeoActionService", sb.toString());
                int i2 = i3 - 1;
                GeoActionService.mHandler.postDelayed(new Runnable(intent2, i2, iArr2, j3, j4) {
                    /* class com.xiaomi.smarthome.scene.geofence.$$Lambda$GeoActionService$2$tCwGhkZXza0x7t1_WTZdfjHidU */
                    private final /* synthetic */ Intent f$1;
                    private final /* synthetic */ int f$2;
                    private final /* synthetic */ int[] f$3;
                    private final /* synthetic */ long f$4;
                    private final /* synthetic */ long f$5;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r7;
                    }

                    public final void run() {
                        GeoActionService.AnonymousClass2.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                    }
                }, (long) (iArr2[i2] * 1000));
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(Intent intent, int i, int[] iArr, long j, long j2) {
                GeoActionService.this.trySceneList(intent, i, iArr, j, j2);
            }
        });
    }
}
