package com.xiaomi.smarthome.scene.geofence.manager;

import _m_j.ezu;
import _m_j.fbs;
import _m_j.fsm;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.hpe;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;

public class MIUIGeoFenceBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    static int f11138O000000o = 453544;
    private List<fsm> O00000Oo = new ArrayList();

    public void onReceive(Context context, Intent intent) {
        String str;
        LogType logType = LogType.SCENE;
        StringBuilder sb = new StringBuilder("receive action: ");
        if (intent == null) {
            str = "action==null";
        } else if (intent.getComponent() == null) {
            str = "component==null";
        } else {
            str = intent.getComponent().getPackageName() + " , " + intent.getComponent().getClassName();
        }
        sb.append(str);
        gsy.O00000o0(logType, "MIUIGeoFenceBroadcastReceiver", sb.toString());
        if (!ezu.O000000o()) {
            gsy.O00000o0(LogType.SCENE, "MIUIGeoFenceBroadcastReceiver", "StartupCheckList.isAllPass==false");
        } else {
            O000000o(context, intent);
        }
    }

    private void O000000o(Context context, Intent intent) {
        Service service;
        if (!this.O00000Oo.isEmpty()) {
            for (fsm next : this.O00000Oo) {
                if (next != null) {
                    next.onSuccess(intent);
                }
            }
        }
        String stringExtra = intent.getStringExtra("context-data");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                int intExtra = intent.getIntExtra("transition-event", -1);
                Location location = (Location) intent.getParcelableExtra("transition-location");
                if (gfr.f17662O000000o || gfr.O0000Ooo) {
                    String str = null;
                    if (intExtra == 1) {
                        str = "GEOFENCE_EVENT_ENTERED";
                    } else if (intExtra == 2) {
                        str = "GEOFENCE_EVENT_EXITED";
                    } else if (intExtra == 4) {
                        str = "GEOFENCE_EVENT_UNCERTAIN";
                    }
                    if (str == null) {
                        str = "unknown:".concat(String.valueOf(intExtra));
                    }
                    LogType logType = LogType.SCENE;
                    gsy.O00000o0(logType, "MIUIGeoFenceBroadcastReceiver", "processGeoFenceIntent id=" + stringExtra + ",transEvent=" + str + ",location= release");
                }
                if (hpe.O000000o(stringExtra) && (service = (Service) fbs.O000000o(Service.class, "com.xiaomi.smarthome.scene.geofence.GeoActionService")) != null) {
                    Intent intent2 = new Intent(context, service.getClass());
                    intent2.setAction("geofence_trigered");
                    intent2.putExtra("trans_event", intExtra);
                    intent2.putExtra("geofence_id", stringExtra);
                    intent2.putExtra("location", location);
                    if (Build.VERSION.SDK_INT >= 26) {
                        context.startForegroundService(intent2);
                        gsy.O00000Oo(LogType.SCENE, "MIUIGeoFenceBroadcastReceiver", "startForegroundService called");
                        return;
                    }
                    context.startService(intent2);
                    gsy.O00000Oo(LogType.SCENE, "MIUIGeoFenceBroadcastReceiver", "startService called");
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogType logType2 = LogType.SCENE;
                gsy.O00000o0(logType2, "MIUIGeoFenceBroadcastReceiver", "exception:" + e.getMessage());
            }
        }
    }
}
