package _m_j;

import android.content.ComponentName;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.qti.location.sdk.IZatGeofenceService;
import com.qti.location.sdk.IZatManager;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class hpf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile hpf f464O000000o;
    public Map<Object, Object> O00000Oo = new ConcurrentHashMap();
    private Map<String, GeoFenceItem> O00000o = new ConcurrentHashMap();
    private IZatGeofenceService O00000o0;
    private Map<Object, Object> O00000oO = new ConcurrentHashMap();
    private AtomicBoolean O00000oo = new AtomicBoolean(false);

    private hpf() {
        if (gfr.f17662O000000o && !(ContextCompat.O000000o(ServiceApplication.getAppContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && oOOO00o0.O000000o(ServiceApplication.getAppContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0)) {
            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "location permission deny");
        }
        hpd.O00000Oo();
        O00000oo();
    }

    public static hpf O000000o() {
        if (f464O000000o == null) {
            synchronized (hpf.class) {
                if (f464O000000o == null) {
                    f464O000000o = new hpf();
                }
            }
        }
        return f464O000000o;
    }

    public final void O00000Oo() {
        if (O00000oo() != null && !this.O00000oo.getAndSet(true)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                O00000oO();
                O00000o();
            } catch (Throwable th) {
                th.printStackTrace();
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "MIUIGeoFenceManager", "IZatManager init exception:" + th.getMessage());
            }
            this.O00000oo.set(true);
            LogType logType2 = LogType.GENERAL;
            gsy.O00000Oo(logType2, "MIUIGeoFenceManager", "MIUIGeoFenceManager init cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void O00000o() {
        if (O00000o0()) {
            try {
                Map<IZatGeofenceService.O00000Oo, IZatGeofenceService.O00000o> O000000o2 = this.O00000o0.O000000o();
                LogType logType = LogType.GENERAL;
                StringBuilder sb = new StringBuilder("recoverGeofenceFromMIUI size=");
                sb.append(O000000o2 == null ? null : Integer.valueOf(O000000o2.size()));
                gsy.O00000Oo(logType, "MIUIGeoFenceManager", sb.toString());
                if (O000000o2 != null) {
                    if (!O000000o2.isEmpty()) {
                        this.O00000oO = new ConcurrentHashMap(O000000o2);
                        Set<Object> keySet = this.O00000oO.keySet();
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        Iterator<Object> it = keySet.iterator();
                        while (it.hasNext()) {
                            IZatGeofenceService.O00000Oo o00000Oo = (IZatGeofenceService.O00000Oo) it.next();
                            Object O000000o3 = o00000Oo.O000000o();
                            if (O000000o3 != null && (O000000o3 instanceof String)) {
                                String str = (String) O000000o3;
                                if (!TextUtils.isEmpty(str)) {
                                    gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "recoverGeofences:".concat(String.valueOf(str)));
                                    if (!hpe.O000000o(str)) {
                                        gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "recoverGeofences is not mihome:".concat(String.valueOf(str)));
                                    } else {
                                        concurrentHashMap.put(str, o00000Oo);
                                    }
                                }
                            }
                        }
                        if (gfr.f17662O000000o) {
                            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManagerstart recover all", "************************");
                            for (IZatGeofenceService.O00000Oo o00000Oo2 : concurrentHashMap.values()) {
                                if (gfr.O0000Ooo || gfr.O0000OOo) {
                                    if (O000000o2.get(o00000Oo2) == null) {
                                        gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "map.get(key) == null");
                                    } else {
                                        LogType logType2 = LogType.GENERAL;
                                        gsy.O00000Oo(logType2, "MIUIGeoFenceManager", "id = " + o00000Oo2 + ",lat=" + O000000o2.get(o00000Oo2).O000000o() + ",lng=" + O000000o2.get(o00000Oo2).O00000Oo() + ",radius=" + O000000o2.get(o00000Oo2).O00000o0());
                                    }
                                }
                            }
                            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManagerrecover all end", "************************");
                        }
                        LogType logType3 = LogType.GENERAL;
                        gsy.O00000Oo(logType3, "MIUIGeoFenceManager", "recoverGeofenceFromMIUI mihome's size:" + concurrentHashMap.size());
                        this.O00000Oo = concurrentHashMap;
                        return;
                    }
                }
                this.O00000oO.clear();
            } catch (Throwable th) {
                th.printStackTrace();
                LogType logType4 = LogType.GENERAL;
                gsy.O00000Oo(logType4, "MIUIGeoFenceManager", "recoverGeofence exception:" + th.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c5, code lost:
        if (r0 == false) goto L_0x00c7;
     */
    public final boolean O00000o0() {
        boolean z;
        String[] split;
        if (!grr.O00000oO() || "GooglePlay".toLowerCase().equals(gfr.O00000o.toLowerCase()) || ftn.O00000oO(ServiceApplication.getAppContext())) {
            return false;
        }
        try {
            z = IZatManager.O000000o();
        } catch (Throwable th) {
            th.printStackTrace();
            if (gfr.O0000Ooo || gfr.O0000OOo) {
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "MIUIGeoFenceManager", "connectGeofenceService exception " + th.getMessage() + ",Build.DEVICE=" + Build.DEVICE);
            } else {
                LogType logType2 = LogType.GENERAL;
                gsy.O00000Oo(logType2, "MIUIGeoFenceManager", "connectGeofenceService exception " + th.getMessage());
            }
            z = false;
        }
        gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "issupprotIZatManager=".concat(String.valueOf(z)));
        if (!z) {
            return false;
        }
        if (!gfr.f17662O000000o) {
            try {
                String O00000Oo2 = IZatManager.O000000o(ServiceApplication.getAppContext()).O00000Oo();
                if (!TextUtils.isEmpty(O00000Oo2) && (split = O00000Oo2.split(":")) != null) {
                    if (split.length >= 3) {
                        if (Integer.parseInt(split[2]) <= 3) {
                            return false;
                        }
                        boolean O000000o2 = hpd.O000000o();
                        gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "issupprotMIUIGeoFenceConfigHelper=".concat(String.valueOf(O000000o2)));
                    }
                }
                return false;
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (gfr.O0000Ooo || gfr.O0000OOo) {
                    LogType logType3 = LogType.GENERAL;
                    gsy.O00000Oo(logType3, "MIUIGeoFenceManager", "IZatManager getVersion exception " + th2.getMessage() + ",Build.DEVICE=" + Build.DEVICE);
                } else {
                    LogType logType4 = LogType.GENERAL;
                    gsy.O00000Oo(logType4, "MIUIGeoFenceManager", "IZatManager getVersion exception " + th2.getMessage());
                }
                return false;
            }
        }
        this.O00000o0 = O00000oo();
        LogType logType5 = LogType.GENERAL;
        gsy.O00000Oo(logType5, "MIUIGeoFenceManager", "mZatGFService=" + this.O00000o0);
        if (this.O00000o0 != null) {
            return true;
        }
        return false;
    }

    public final void O000000o(Map<String, GeoFenceItem> map) {
        if (O00000oo() != null) {
            for (String next : map.keySet()) {
                if (this.O00000o.containsKey(next)) {
                    map.get(next).O00000o = this.O00000o.get(next).O00000o;
                }
            }
            this.O00000o = map;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.O00000oo.get()) {
                    O00000Oo();
                }
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "MIUIGeoFenceManager", "expunge mGeoFenceMap:" + this.O00000o.size() + ",mHandleMapOnlyMihome:" + this.O00000Oo.size() + ",mMIUIStoredGeoFence:" + this.O00000oO.size());
                for (String next2 : this.O00000o.keySet()) {
                    if (this.O00000Oo.containsKey(next2)) {
                        IZatGeofenceService.O00000o O000000o2 = hpe.O000000o(this.O00000o.get(next2));
                        if (O000000o2 == null) {
                            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "update fence exception");
                        } else if (O000000o((IZatGeofenceService.O00000Oo) this.O00000Oo.get(next2), O000000o2)) {
                            IZatGeofenceService.O00000o o00000o = (IZatGeofenceService.O00000o) this.O00000oO.get(this.O00000Oo.get(next2));
                            ((IZatGeofenceService.O00000Oo) this.O00000Oo.get(next2)).O000000o(O000000o2);
                            this.O00000o.get(next2);
                            if (o00000o != null) {
                                LogType logType2 = LogType.GENERAL;
                                gsy.O00000Oo(logType2, "MIUIGeoFenceManager", "update GeoFence:lat=" + o00000o.O000000o() + ",lng=" + o00000o.O00000Oo() + ",radius=" + o00000o.O00000o0() + ",id=" + next2);
                            } else {
                                gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "update GeoFence:lat=null");
                            }
                        }
                    } else {
                        hashMap.put(next2, this.O00000o.get(next2));
                    }
                }
                LogType logType3 = LogType.GENERAL;
                gsy.O00000Oo(logType3, "MIUIGeoFenceManager", "expunge toBeAdded:" + hashMap.size());
                for (Object next3 : this.O00000Oo.keySet()) {
                    if (!this.O00000o.containsKey(next3)) {
                        hashMap2.put(String.valueOf(next3), (IZatGeofenceService.O00000Oo) this.O00000Oo.get(next3));
                    }
                }
                LogType logType4 = LogType.GENERAL;
                gsy.O00000Oo(logType4, "MIUIGeoFenceManager", "expunge toBeDeleted:" + hashMap2.size());
                for (Map.Entry entry : hashMap.entrySet()) {
                    O000000o((String) entry.getKey(), (GeoFenceItem) entry.getValue());
                }
                for (Map.Entry key : hashMap2.entrySet()) {
                    O000000o((String) key.getKey());
                }
                LogType logType5 = LogType.GENERAL;
                gsy.O00000Oo(logType5, "MIUIGeoFenceManager", "expunge costs:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th) {
                th.printStackTrace();
                LogType logType6 = LogType.GENERAL;
                gsy.O00000Oo(logType6, "MIUIGeoFenceManager", "expunge exception:" + th.getMessage());
            }
        }
    }

    public final boolean O000000o(String str, GeoFenceItem geoFenceItem) {
        if (O00000oo() != null && !TextUtils.isEmpty(str) && geoFenceItem != null && O00000o0()) {
            if (!this.O00000oo.get()) {
                O00000Oo();
            }
            try {
                IZatGeofenceService.O00000o O000000o2 = hpe.O000000o(geoFenceItem);
                if (O000000o2 == null) {
                    gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "add GeoFence failed: cannot generate IzatGeofence");
                    return false;
                }
                if (this.O00000Oo.containsKey(str)) {
                    if (O000000o((IZatGeofenceService.O00000Oo) this.O00000Oo.get(str), O000000o2)) {
                        ((IZatGeofenceService.O00000Oo) this.O00000Oo.get(str)).O000000o(O000000o2);
                        GeoFenceItem geoFenceItem2 = this.O00000o.get(str);
                        if (geoFenceItem2 != null) {
                            geoFenceItem2.O00000o = System.currentTimeMillis();
                        }
                        LogType logType = LogType.GENERAL;
                        gsy.O00000Oo(logType, "MIUIGeoFenceManager", "update GeoFence:lat=" + geoFenceItem.f11139O000000o + ",lng=" + geoFenceItem.O00000Oo + ",radius=" + geoFenceItem.O00000o0 + ",id=" + str);
                        return false;
                    }
                }
                IZatGeofenceService.O00000Oo O000000o3 = this.O00000o0.O000000o(str, O000000o2);
                if (O000000o3 == null) {
                    gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "IZatManager add Geofence handle==null");
                    return false;
                }
                geoFenceItem.O00000o = System.currentTimeMillis();
                this.O00000o.put(str, geoFenceItem);
                this.O00000Oo.put(str, O000000o3);
                this.O00000oO.put(O000000o3, O000000o2);
                LogType logType2 = LogType.GENERAL;
                gsy.O00000Oo(logType2, "MIUIGeoFenceManager", "IZatManager add Geofence success:lat=" + geoFenceItem.f11139O000000o + ",lng=" + geoFenceItem.O00000Oo + ",radius=" + geoFenceItem.O00000o0 + ",id=" + str);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                LogType logType3 = LogType.GENERAL;
                gsy.O00000Oo(logType3, "MIUIGeoFenceManager", "IZatManager add Geofence exception:" + th.getMessage());
            }
        }
        return false;
    }

    public final boolean O000000o(String str) {
        IZatGeofenceService.O00000Oo o00000Oo;
        if (O00000oo() == null || (o00000Oo = (IZatGeofenceService.O00000Oo) this.O00000Oo.get(str)) == null) {
            return false;
        }
        try {
            this.O00000o0.O000000o(o00000Oo);
            this.O00000Oo.remove(str);
            this.O00000o.remove(str);
            this.O00000oO.remove(o00000Oo);
            if (!gfr.O0000Ooo) {
                if (!gfr.O0000OOo) {
                    gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "IZatManager removeGeoFence");
                    return true;
                }
            }
            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "IZatManager removeGeoFence id=".concat(String.valueOf(str)));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "MIUIGeoFenceManager", "IZatManager removeGeoFence exception:" + th.getMessage());
            return false;
        }
    }

    private void O00000oO() {
        this.O00000o0.O000000o(new ComponentName("com.xiaomi.smarthome", "com.xiaomi.smarthome.scene.geofence.manager.MIUIGeoFenceBroadcastReceiver"));
        gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "mZatGFService registerIntent");
        this.O00000o0.O000000o(new IZatGeofenceService.O000000o() {
            /* class _m_j.hpf.AnonymousClass1 */

            public final void O000000o(int i) {
                String str = i == 1 ? "GEOFENCE_EVENT_ENTERED" : i == 2 ? "GEOFENCE_EVENT_EXITED" : i == 4 ? "GEOFENCE_EVENT_UNCERTAIN" : null;
                if (str == null) {
                    str = "未知类型：".concat(String.valueOf(i));
                }
                gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "MIUIGeoFenceManager mZatGFService onTransitionEvent event= ".concat(String.valueOf(str)));
            }

            public final void O000000o(int i, int i2) {
                String concat = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "未知请求类型requestType: ".concat(String.valueOf(i)) : "GEOFENCE_REQUEST_TYPE_UPDATE" : "GEOFENCE_REQUEST_TYPE_RESUME" : "GEOFENCE_REQUEST_TYPE_PAUSE" : "GEOFENCE_REQUEST_TYPE_REMOVE" : "GEOFENCE_REQUEST_TYPE_ADD";
                String concat2 = i != -149 ? i != -100 ? i != -103 ? i != -102 ? "未知错误类型rerrorCode: ".concat(String.valueOf(i2)) : "GEOFENCE_RESULT_ERROR_ID_UNKNOWN" : "GEOFENCE_RESULT_ERROR_INVALID_TRANSITION" : "GEOFENCE_RESULT_ERROR_TOO_MANY_GEOFENCES" : "GEOFENCE_RESULT_ERROR_GENERIC";
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "MIUIGeoFenceManager", "MIUIGeoFenceManager mZatGFService onRequestFailed requestType=" + concat + ",errorCode=" + concat2);
            }

            public final void O00000Oo(int i) {
                gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "MIUIGeoFenceManager mZatGFService onEngineReportStatus status=".concat(String.valueOf(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "未知状态类型status: ".concat(String.valueOf(i)) : "GEOFENCE_GEN_ALERT_TIME_INVALID" : "GEOFENCE_GEN_ALERT_OOS" : "GEOFENCE_GEN_ALERT_GNSS_AVAILABLE" : "GEOFENCE_GEN_ALERT_GNSS_UNAVAILABLE")));
            }
        });
        gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "mZatGFService registerForGeofenceCallbacks");
    }

    private boolean O000000o(IZatGeofenceService.O00000Oo o00000Oo, IZatGeofenceService.O00000o o00000o) {
        IZatGeofenceService.O00000o o00000o2 = (IZatGeofenceService.O00000o) this.O00000oO.get(o00000Oo);
        if (o00000o2 != null && o00000o2.O000000o() == o00000o.O000000o() && o00000o2.O00000Oo() == o00000o.O00000Oo() && o00000o2.O00000o0() == o00000o.O00000o0() && o00000o2.O00000o() == o00000o.O00000o()) {
            return false;
        }
        return true;
    }

    private IZatGeofenceService O00000oo() {
        IZatGeofenceService iZatGeofenceService = this.O00000o0;
        if (iZatGeofenceService != null) {
            return iZatGeofenceService;
        }
        try {
            this.O00000o0 = IZatManager.O000000o(ServiceApplication.getAppContext()).O00000o0();
            gsy.O00000Oo(LogType.GENERAL, "MIUIGeoFenceManager", "connectGeofenceService success");
            return this.O00000o0;
        } catch (Throwable th) {
            th.printStackTrace();
            if (gfr.O0000Ooo || gfr.O0000OOo) {
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "MIUIGeoFenceManager", "connectGeofenceService exception " + th.getMessage() + ",Build.DEVICE=" + Build.DEVICE);
                return null;
            }
            LogType logType2 = LogType.GENERAL;
            gsy.O00000Oo(logType2, "MIUIGeoFenceManager", "connectGeofenceService exception " + th.getMessage());
            return null;
        }
    }

    public static boolean O000000o(String str, long j) {
        hpf O000000o2 = O000000o();
        GeoFenceItem geoFenceItem = (TextUtils.isEmpty(str) || !O000000o2.O00000o0()) ? null : O000000o2.O00000o.get(str);
        if (geoFenceItem == null) {
            return false;
        }
        if (j - geoFenceItem.O00000o >= 60000) {
            return true;
        }
        gsy.O00000Oo(LogType.GENERAL, "GeoActionService", "trigger in 1 min after add");
        return true;
    }
}
