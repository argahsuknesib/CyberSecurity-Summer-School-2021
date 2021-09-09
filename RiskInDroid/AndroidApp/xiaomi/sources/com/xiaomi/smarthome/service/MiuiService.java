package com.xiaomi.smarthome.service;

import _m_j.ezo;
import _m_j.ezu;
import _m_j.fad;
import _m_j.faw;
import _m_j.fno;
import _m_j.ft;
import _m_j.gsy;
import _m_j.hda;
import _m_j.hsf;
import _m_j.hsl;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.service.tasks.ServiceManager;

public class MiuiService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    ServiceManager f11346O000000o = new ServiceManager();
    BroadcastReceiver O00000Oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.service.MiuiService.AnonymousClass1 */

        public final void onReceive(Context context, final Intent intent) {
            ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.service.MiuiService.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    String stringExtra = intent.getStringExtra("did");
                    gsy.O000000o(4, "mijia-card", "MiuiService ACTION_RENAME_NOTIFY onReceive did:".concat(String.valueOf(stringExtra)));
                    if (!TextUtils.isEmpty(stringExtra)) {
                        fad.O000000o().sendBrodCard(stringExtra);
                    }
                }
            });
        }
    };
    public BroadcastReceiver mCTA = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.service.MiuiService.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("param_key", -1) == 1) {
                MiuiService miuiService = MiuiService.this;
                miuiService.mCTA = null;
                ft.O000000o(miuiService.getApplicationContext()).O000000o(MiuiService.this.mCTA);
                IntentFilter intentFilter = new IntentFilter("action.more.rename.notify");
                MiuiService miuiService2 = MiuiService.this;
                miuiService2.registerReceiver(miuiService2.O00000Oo, intentFilter);
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("miui.action_open_card");
                ft.O000000o(MiuiService.this.getApplicationContext()).O000000o(MiuiService.this.mReceiver, intentFilter2);
                faw.O000000o().registerStateChangedListener(MiuiService.this.mListener);
                faw.O00000Oo().registerStateChangedListener(MiuiService.this.mListener);
            }
        }
    };
    public hda mListener = $$Lambda$MiuiService$xhMDoN3RHmivitH8h2GeKQ28k5s.INSTANCE;
    public BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.service.MiuiService.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("param_did");
            gsy.O000000o(4, "mijia-card", "MiuiService onReceive ACTION_OPENCARD did:".concat(String.valueOf(stringExtra)));
            if (!"miui.action_open_card".equals(action)) {
                return;
            }
            if (fno.O000000o().O000000o(stringExtra) == null) {
                try {
                    ezo.O000000o().registerPushService();
                } catch (Throwable th) {
                    gsy.O00000o0(LogType.PUSH, "MiuiService", "fatal", Log.getStackTraceString(th));
                }
                MiuiService.this.forseRefreshDevice();
            } else if (!hsl.O00000Oo().isDeviceListSwitchInit()) {
                MiuiService.this.forseRefreshDevice();
            }
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(String str, String str2, Object obj) {
        gsy.O000000o(4, "mijia-card", "MiuiService onStateChanged notify 负一屏 did:".concat(String.valueOf(str)));
        fad.O000000o().sendBrodCard(str);
    }

    public void forseRefreshDevice() {
        CommonApplication.getGlobalWorkerHandler().post(new hsf(null, true, false));
    }

    public IBinder onBind(Intent intent) {
        return this.f11346O000000o;
    }

    public void onCreate() {
        super.onCreate();
        CardActive.instance.create();
        if (ezu.O000000o()) {
            this.mCTA.onReceive(this, new Intent("action_disclaim_local_broadcast_complete").putExtra("param_key", 1));
        } else {
            ft.O000000o(this).O000000o(this.mCTA, new IntentFilter("action_disclaim_local_broadcast_complete"));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CardActive.instance.destory();
        try {
            if (this.mCTA == null) {
                unregisterReceiver(this.O00000Oo);
            } else {
                ft.O000000o(this).O000000o(this.mCTA);
            }
        } catch (Exception e) {
            Log.e("MiuiService", "onDestroy", e);
        }
    }
}
