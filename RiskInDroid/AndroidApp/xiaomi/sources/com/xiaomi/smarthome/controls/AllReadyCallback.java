package com.xiaomi.smarthome.controls;

import _m_j.faw;
import _m_j.fno;
import _m_j.ft;
import _m_j.ggb;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Map;

public class AllReadyCallback {
    public AllReadyCallback(Runnable runnable) {
        this(7, runnable);
    }

    public AllReadyCallback(final int i, final Runnable runnable) {
        final int hashCode = hashCode();
        Context appContext = CommonApplication.getAppContext();
        CoreApi.O000000o().O000000o(appContext, new CoreApi.O0000o0(hashCode, i, new fno.O00000o(hashCode, i, new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.controls.AllReadyCallback.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    ft.O000000o(context).O000000o(this);
                }
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "AllReadyCallback", hashCode + " onHomeReady check:" + i);
                if ((i & 1) == 0) {
                    runnable.run();
                } else {
                    faw.O000000o().isReady(runnable);
                }
            }
        }, appContext) {
            /* class com.xiaomi.smarthome.controls.$$Lambda$AllReadyCallback$20klOJ28mj8ZtH358OB4_Ic6Ss */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ BroadcastReceiver f$2;
            private final /* synthetic */ Context f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onDeviceReady(Map map) {
                AllReadyCallback.lambda$new$0(this.f$0, this.f$1, this.f$2, this.f$3, map);
            }
        }) {
            /* class com.xiaomi.smarthome.controls.$$Lambda$AllReadyCallback$5W7wmuAbiBi5EoMf143tb0oYjI */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ fno.O00000o f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onCoreReady() {
                AllReadyCallback.lambda$new$1(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    static /* synthetic */ void lambda$new$0(int i, int i2, BroadcastReceiver broadcastReceiver, Context context, Map map) {
        LogType logType = LogType.CARD;
        gsy.O00000o0(logType, "AllReadyCallback", i + " onDeviceReady home check:" + i2);
        if ((i2 & 2) == 0) {
            broadcastReceiver.onReceive(context, null);
            return;
        }
        boolean z = ggb.O00000Oo().O0000OoO.O00000oo;
        LogType logType2 = LogType.CARD;
        gsy.O00000o0(logType2, "AllReadyCallback", i + " onDeviceReady home Inited:" + z);
        if (z) {
            broadcastReceiver.onReceive(context, null);
        } else {
            ft.O000000o(context).O000000o(broadcastReceiver, new IntentFilter("home_room_updated"));
        }
    }

    static /* synthetic */ void lambda$new$1(int i, int i2, fno.O00000o o00000o) {
        LogType logType = LogType.CARD;
        gsy.O00000o0(logType, "AllReadyCallback", i + " isCoreReady  check:" + i2);
        if ((i2 & 4) == 0) {
            o00000o.onDeviceReady(null);
        } else {
            fno.O000000o().O000000o(o00000o);
        }
    }
}
