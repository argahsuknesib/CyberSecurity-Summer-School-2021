package com.qti.location.sdk;

import _m_j.css;
import _m_j.cst;
import _m_j.csu;
import _m_j.csv;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import com.qti.debugreport.IDebugReportCallback;
import com.qti.flp.IFlpService;
import com.qti.flp.ILocationCallback;
import com.qti.flp.IMaxPowerAllocatedCallback;
import com.qti.flp.ISessionStatusCallback;
import com.qti.geofence.GeofenceData;
import com.qti.geofence.IGeofenceCallback;
import com.qti.geofence.IGeofenceService;
import com.qti.gnssconfig.IGnssConfigCallback;
import com.qti.izat.IIzatService;
import com.qti.location.sdk.IZatDBCommon;
import com.qti.location.sdk.IZatFlpService;
import com.qti.location.sdk.IZatGeofenceService;
import com.qti.location.sdk.IZatGnssConfigService;
import com.qti.location.sdk.IZatWWANDBReceiver;
import com.qti.location.sdk.IZatWiFiDBReceiver;
import com.qti.location.sdk.utils.IZatValidationResults;
import com.qti.wifidbprovider.APObsLocData;
import com.qti.wifidbprovider.APScan;
import com.qti.wifidbprovider.IWiFiDBProviderResponseListener;
import com.qti.wifidbreceiver.APInfo;
import com.qti.wifidbreceiver.APInfoExt;
import com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener;
import com.qti.wwandbprovider.BSObsLocationData;
import com.qti.wwandbprovider.IWWANDBProviderResponseListener;
import com.qti.wwandbreceiver.BSInfo;
import com.qti.wwandbreceiver.IWWANDBReceiverResponseListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class IZatManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f5442O000000o = "IZatManager";
    public static final boolean O00000Oo = Log.isLoggable("IZatManager", 2);
    public static final Object O0000o = new Object();
    public static volatile int O0000o0O = 0;
    public static final Object O0000o0o = new Object();
    public static final Object O0000oO = new Object();
    public static final Object O0000oO0 = new Object();
    public static final Object O0000oOO = new Object();
    public static final Object O0000oOo = new Object();
    public static final Object O0000oo = new Object();
    public static final Object O0000oo0 = new Object();
    public static final Object O0000ooO = new Object();
    private static final HashSet<String> O000O0o;
    private static final Object O000O0oO = new Object();
    private static final Object O000O0oo = new Object();
    private static final Object O000OO00 = new Object();
    private static final Object O000OO0o = new Object();
    private static IZatManager O000OOOo = null;
    private static IIzatService O000OOo0 = null;
    public Map<O00000o.O000000o, O000000o> O00000o = Collections.synchronizedMap(new HashMap());
    public int O00000o0 = -1;
    public Map<IZatFlpService.O000000o, LocationCallbackWrapper> O00000oO = Collections.synchronizedMap(new HashMap());
    public Map<css.O000000o, MaxPowerAllocatedCallbackWrapper> O00000oo = Collections.synchronizedMap(new HashMap());
    public Map<O0000O0o, IZatGeofenceService.O000000o> O0000O0o = Collections.synchronizedMap(new HashMap());
    public Map<O0000O0o.O000000o, O00000Oo> O0000OOo = Collections.synchronizedMap(new HashMap());
    public Map<O0000OOo, Object> O0000Oo = Collections.synchronizedMap(new HashMap());
    public Map<O00000o0, Object> O0000Oo0 = Collections.synchronizedMap(new HashMap());
    public O0000o0 O0000OoO = null;
    public O0000Oo O0000Ooo = null;
    public O0000Oo0 O0000o0 = null;
    public O0000o00 O0000o00 = null;
    public GnssConfigCallbackWrapper O0000ooo = new GnssConfigCallbackWrapper();
    private final int O000O00o = 4;
    private final int O000O0OO = 8;
    private final int O000O0Oo = 16;
    private final int O000O0o0 = 64;
    private Context O000OO;
    private GeofenceStatusCallbackWrapper O000OOo = new GeofenceStatusCallbackWrapper();
    private DebugReportCallbackWrapper O000OOoO = new DebugReportCallbackWrapper();
    private WiFiDBReceiverRespListenerWrapper O000OOoo = new WiFiDBReceiverRespListenerWrapper();
    private WWANDBReceiverRespListenerWrapper O000Oo0 = new WWANDBReceiverRespListenerWrapper();
    private WiFiDBProviderRespListenerWrapper O000Oo00 = new WiFiDBProviderRespListenerWrapper();
    private WWANDBProviderRespListenerWrapper O000Oo0O = new WWANDBProviderRespListenerWrapper();
    private final int O00oOoOo = 32;
    private final int O00oOooO = 1;
    private final int O00oOooo = 2;

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public NotificationType f5443O000000o;
        public LocationCallbackWrapper O00000Oo;
        public long O00000o;
        public FlpStatusCallbackWrapper O00000o0;
        public int O00000oO;
        public long O00000oo;
        public int O0000O0o;
        long O0000OOo;
        NotificationType O0000Oo;
        boolean O0000Oo0;
    }

    class O00000o implements IZatFlpService {

        /* renamed from: O000000o  reason: collision with root package name */
        IFlpService f5445O000000o;
        final /* synthetic */ IZatManager O00000Oo;

        class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o f5446O000000o;
        }
    }

    public class O00000o0 {
    }

    public class O0000OOo implements IZatGnssConfigService {
    }

    class O0000Oo extends IZatWWANDBReceiver {
    }

    class O0000Oo0 extends cst {
    }

    class O0000o0 extends IZatWiFiDBReceiver {
    }

    class O0000o00 extends csu {
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        O000O0o = hashSet;
        hashSet.add("umi");
        O000O0o.add("lmi");
        O000O0o.add("cmi");
    }

    public static synchronized IZatManager O000000o(Context context) throws IZatIllegalArgumentException {
        IZatManager iZatManager;
        synchronized (IZatManager.class) {
            if (!O000000o()) {
                throw new RuntimeException("Not support IZat for this device");
            } else if (context != null) {
                if (O000OOOo == null) {
                    O000OOOo = new IZatManager(context);
                }
                iZatManager = O000OOOo;
            } else {
                throw new IZatIllegalArgumentException("null argument");
            }
        }
        return iZatManager;
    }

    private IZatManager(Context context) {
        O0000o0O = Process.myTid() << 8;
        if (O00000Oo) {
            String str = f5442O000000o;
            int i = O0000o0O;
            Log.v(str, "IZatManager ctor sFlpRequestsCnt=" + i);
        }
        this.O000OO = context;
    }

    public static final boolean O000000o() {
        if ((O000O0o.contains(Build.DEVICE.toLowerCase()) && Build.VERSION.SDK_INT >= 29) || SystemProperties.getBoolean("persist.sys.gps.fence", false)) {
            return true;
        }
        if (O00000Oo) {
            Log.d(f5442O000000o, "Not support!!");
        }
        return false;
    }

    public final String O00000Oo() throws IZatServiceUnavailableException {
        if (O000OOo0 == null) {
            O00000o();
        }
        try {
            String version = O000OOo0.getVersion();
            if (version == null) {
                version = "1.0.0";
            }
            return "7.3.1.2:" + version;
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to get IzatService version", e);
        }
    }

    private synchronized void O00000o() {
        if (O000OOo0 == null) {
            if (O00000Oo) {
                Log.d(f5442O000000o, "Connecting to Izat service by name [com.qualcomm.location.izat.IzatService]");
            }
            if (this.O000OO.getPackageManager().resolveService(new Intent("com.qualcomm.location.izat.IzatService"), 0) == null) {
                Log.e(f5442O000000o, "Izat service (com.qualcomm.location.izat.IzatService) not installed");
                throw new IZatServiceUnavailableException("Izat service unavailable.");
            } else if (ServiceManager.getService("com.qualcomm.location.izat.IzatService") != null) {
                IIzatService asInterface = IIzatService.Stub.asInterface(ServiceManager.getService("com.qualcomm.location.izat.IzatService"));
                O000OOo0 = asInterface;
                if (asInterface == null) {
                    Log.e(f5442O000000o, "Izat service (com.qualcomm.location.izat.IzatService) not started");
                    throw new IZatServiceUnavailableException("Izat service unavailable.");
                }
            } else {
                Log.e(f5442O000000o, "Izat service (com.qualcomm.location.izat.IzatService) is not started");
                throw new IZatServiceUnavailableException("Izat service not started.");
            }
        }
        String str = f5442O000000o;
        String O00000Oo2 = O00000Oo();
        Log.d(str, "Version is " + O00000Oo2);
    }

    public final IZatGeofenceService O00000o0() throws IZatServiceUnavailableException {
        if (O000OOo0 == null) {
            O00000o();
        }
        try {
            IGeofenceService geofenceService = O000OOo0.getGeofenceService();
            if (geofenceService != null) {
                synchronized (O0000oO0) {
                    geofenceService.registerCallback(this.O000OOo);
                }
                return new O0000O0o(geofenceService);
            }
            throw new IZatServiceUnavailableException("Geofence Service is not available.");
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to get IGeofenceService", e);
        }
    }

    class O0000O0o implements IZatGeofenceService {

        /* renamed from: O000000o  reason: collision with root package name */
        IGeofenceService f5447O000000o;

        public O0000O0o(IGeofenceService iGeofenceService) {
            this.f5447O000000o = iGeofenceService;
        }

        public final void O000000o(IZatGeofenceService.O000000o o000000o) throws IZatIllegalArgumentException {
            synchronized (IZatManager.O0000oOO) {
                IZatManager.this.O0000O0o.put(this, o000000o);
            }
        }

        public final void O000000o(ComponentName componentName) throws IZatIllegalArgumentException {
            synchronized (IZatManager.O0000oO0) {
                try {
                    this.f5447O000000o.registerComponent(componentName);
                } catch (RemoteException unused) {
                    throw new RuntimeException("Failed registerComponent");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Map<IZatGeofenceService.O00000Oo, IZatGeofenceService.O00000o> O000000o() {
            IZatGeofenceService.O000000o o000000o = IZatManager.this.O0000O0o.get(this);
            if (o000000o == null) {
                Log.e(IZatManager.f5442O000000o, "callback is not registered");
                return null;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            try {
                synchronized (IZatManager.O0000oO0) {
                    this.f5447O000000o.recoverGeofences(arrayList);
                }
                synchronized (IZatManager.O0000oO) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        GeofenceData geofenceData = (GeofenceData) it.next();
                        IZatGeofenceService.O00000o o00000o = new IZatGeofenceService.O00000o(geofenceData.O00000Oo, geofenceData.O00000o0, geofenceData.O00000o);
                        o00000o.O000000o(geofenceData.f5436O000000o);
                        o00000o.O000000o(IZatGeofenceService.IzatGeofenceTransitionTypes.values()[geofenceData.O00000oO.getValue()]);
                        boolean z = true;
                        o00000o.O000000o(IZatGeofenceService.IzatGeofenceConfidence.values()[geofenceData.O00000oo.getValue() - 1]);
                        o00000o.O000000o(new IZatGeofenceService.O00000o0(geofenceData.O0000OOo, geofenceData.O0000O0o.getValue()));
                        Iterator<Map.Entry<O000000o, O00000Oo>> it2 = IZatManager.this.O0000OOo.entrySet().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            Map.Entry next = it2.next();
                            if (((O00000Oo) next.getValue()).O00000Oo == geofenceData.O0000OoO) {
                                hashMap.put((IZatGeofenceService.O00000Oo) next.getKey(), o00000o);
                                break;
                            }
                        }
                        if (!z) {
                            O000000o o000000o2 = new O000000o(this, (byte) 0);
                            Object obj = geofenceData.O0000Oo0;
                            if (obj == null) {
                                obj = geofenceData.O0000Oo;
                            }
                            IZatManager.this.O0000OOo.put(o000000o2, new O00000Oo(obj, geofenceData.O0000OoO, o000000o));
                            hashMap.put(o000000o2, o00000o);
                        }
                    }
                }
                return hashMap;
            } catch (RemoteException e) {
                throw new RuntimeException("Failed to recover geofences", e);
            }
        }

        public final void O000000o(IZatGeofenceService.O00000Oo o00000Oo) throws IZatIllegalArgumentException {
            if (o00000Oo == null || !(o00000Oo instanceof O000000o)) {
                throw new IZatIllegalArgumentException("invalid input parameter");
            }
            try {
                synchronized (IZatManager.O0000oO0) {
                    O00000Oo o00000Oo2 = IZatManager.this.O0000OOo.get(o00000Oo);
                    if (o00000Oo2 == null) {
                        Log.e(IZatManager.f5442O000000o, "this request ID is unknown.");
                        IZatGeofenceService.O000000o o000000o = IZatManager.this.O0000O0o.get(this);
                        if (o000000o != null) {
                            o000000o.O000000o(2, -102);
                            return;
                        }
                        throw new IZatIllegalArgumentException("Invalid Geofence handle");
                    }
                    this.f5447O000000o.removeGeofence(o00000Oo2.O00000Oo);
                    synchronized (IZatManager.O0000oO) {
                        IZatManager.this.O0000OOo.remove(o00000Oo);
                    }
                }
            } catch (RemoteException e) {
                throw new RuntimeException("Failed removeGeofence", e);
            }
        }

        class O000000o implements IZatGeofenceService.O00000Oo {
            private O000000o() {
            }

            /* synthetic */ O000000o(O0000O0o o0000O0o, byte b) {
                this();
            }

            public final Object O000000o() {
                O00000Oo o00000Oo = IZatManager.this.O0000OOo.get(this);
                if (o00000Oo != null) {
                    return o00000Oo.f5444O000000o;
                }
                return null;
            }

            public final void O000000o(IZatGeofenceService.O00000o o00000o) throws IZatIllegalArgumentException {
                IZatGeofenceService.O00000o o00000o2 = o00000o;
                try {
                    synchronized (IZatManager.O0000oO0) {
                        O00000Oo o00000Oo = IZatManager.this.O0000OOo.get(this);
                        if (o00000Oo == null) {
                            Log.e(IZatManager.f5442O000000o, "this request ID is unknown.");
                            IZatGeofenceService.O000000o o000000o = IZatManager.this.O0000O0o.get(this);
                            if (o000000o != null) {
                                o000000o.O000000o(5, -102);
                                return;
                            }
                            throw new IZatIllegalArgumentException("Invalid Geofence handle");
                        }
                        O0000O0o.this.f5447O000000o.updateGeofenceData(o00000Oo.O00000Oo, o00000o2.O00000Oo, o00000o2.O00000o0, o00000o2.O00000o, o00000o2.O00000oO.getValue(), o00000o2.f5440O000000o, o00000o2.O00000oo.getValue(), o00000o2.O0000O0o.f5441O000000o, o00000o2.O0000O0o.O00000Oo, o00000o2.O0000OOo);
                        o00000o2.O0000OOo = 0;
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException("Failed update", e);
                }
            }
        }

        public final IZatGeofenceService.O00000Oo O000000o(Object obj, IZatGeofenceService.O00000o o00000o) throws IZatIllegalArgumentException {
            int i;
            int i2;
            int i3;
            byte b;
            Object obj2 = obj;
            IZatGeofenceService.O00000o o00000o2 = o00000o;
            if (o00000o2 == null) {
                throw new IZatIllegalArgumentException("invalid null geofence");
            } else if (o00000o2.O00000Oo < -90.0d || o00000o2.O00000Oo > 90.0d) {
                throw new IZatIllegalArgumentException("invalid geofence latitude. Expected in range -90..90.");
            } else if (o00000o2.O00000o0 < -180.0d || o00000o2.O00000o0 > 180.0d) {
                throw new IZatIllegalArgumentException("invalid geofence longitude. Expected in range -180..180.");
            } else {
                csv.O000000o(o00000o);
                IZatGeofenceService.O000000o o000000o = IZatManager.this.O0000O0o.get(this);
                String str = null;
                if (o000000o == null) {
                    Log.e(IZatManager.f5442O000000o, "callback is not registered.");
                    return null;
                }
                try {
                    synchronized (IZatManager.O0000oO0) {
                        double d = o00000o2.O00000Oo;
                        double d2 = o00000o2.O00000o0;
                        double d3 = o00000o2.O00000o;
                        int value = o00000o2.O00000oO.getValue();
                        int i4 = o00000o2.f5440O000000o;
                        int value2 = o00000o2.O00000oo.getValue();
                        if (o00000o2.O0000O0o != null) {
                            int i5 = o00000o2.O0000O0o.f5441O000000o;
                            i = o00000o2.O0000O0o.O00000Oo;
                            i2 = i5;
                        } else {
                            i2 = 0;
                            i = 0;
                        }
                        if (obj2 == null || !(obj2 instanceof String)) {
                            b = 0;
                            i3 = this.f5447O000000o.addGeofence(d, d2, d3, value, i4, value2, i2, i);
                        } else {
                            if (obj2 instanceof String) {
                                str = obj.toString();
                            }
                            String str2 = str;
                            IGeofenceService iGeofenceService = this.f5447O000000o;
                            GeofenceData geofenceData = r6;
                            b = 0;
                            GeofenceData geofenceData2 = new GeofenceData(i4, d, d2, d3, value, value2, i, i2, str2, null);
                            i3 = iGeofenceService.addGeofenceObjWithFlag(geofenceData, 1);
                        }
                    }
                    O000000o o000000o2 = new O000000o(this, b);
                    synchronized (IZatManager.O0000oO) {
                        IZatManager.this.O0000OOo.put(o000000o2, new O00000Oo(obj, i3, o000000o));
                    }
                    return o000000o2;
                } catch (RemoteException e) {
                    throw new RuntimeException("Failed addGeofence", e);
                }
            }
        }
    }

    class LocationCallbackWrapper extends ILocationCallback.Stub {
        IZatFlpService.O000000o mCallback;

        public LocationCallbackWrapper(IZatFlpService.O000000o o000000o) {
            this.mCallback = o000000o;
        }

        public void onLocationAvailable(Location[] locationArr) {
            if (this.mCallback == null) {
                Log.w(IZatManager.f5442O000000o, "mCallback is NULL in LocationCallbackWrapper");
            } else {
                csv.O000000o(locationArr);
            }
        }
    }

    class FlpStatusCallbackWrapper extends ISessionStatusCallback.Stub {
        IZatFlpService.O00000Oo mCallback;
        IFlpService mService;

        public FlpStatusCallbackWrapper(IZatFlpService.O00000Oo o00000Oo, IFlpService iFlpService) {
            this.mCallback = o00000Oo;
            this.mService = iFlpService;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0112, code lost:
            return;
         */
        public void onBatchingStatusCb(int i) {
            O00000o.O000000o o000000o;
            if (this.mCallback == null) {
                Log.w(IZatManager.f5442O000000o, "mCallback is NULL in FlpStatusCallbackWrapper");
            }
            csv.O000000o(i, IZatValidationResults.IZatDataTypes.FLP_STATUS);
            try {
                synchronized (IZatManager.O0000o0o) {
                    IZatFlpService.IzatFlpStatus izatFlpStatus = IZatFlpService.IzatFlpStatus.values()[i];
                    if (izatFlpStatus == IZatFlpService.IzatFlpStatus.OUTDOOR_TRIP_COMPLETED) {
                        Iterator<O00000o.O000000o> it = IZatManager.this.O00000o.keySet().iterator();
                        O000000o o000000o2 = null;
                        while (true) {
                            if (!it.hasNext()) {
                                o000000o = null;
                                break;
                            }
                            O00000o.O000000o next = it.next();
                            O000000o o000000o3 = IZatManager.this.O00000o.get(next);
                            if (o000000o3.O00000o0 == this) {
                                o000000o = next;
                                o000000o2 = o000000o3;
                                break;
                            }
                            o000000o2 = o000000o3;
                        }
                        if (o000000o2 == null) {
                            Log.w(IZatManager.f5442O000000o, "no flp session undergoing");
                            return;
                        }
                        NotificationType notificationType = o000000o2.f5443O000000o;
                        if (IZatFlpService.IzatFlpStatus.OUTDOOR_TRIP_COMPLETED == izatFlpStatus && NotificationType.NOTIFICATION_WHEN_TRIP_IS_COMPLETED == notificationType) {
                            if (!o000000o2.O0000Oo0) {
                                this.mService.unregisterCallback(1, o000000o2.O00000Oo);
                                if ((o000000o.f5446O000000o.O00000Oo.O00000o0 & 16) != 0) {
                                    try {
                                        synchronized (IZatManager.O0000o0o) {
                                            O000000o o000000o4 = o000000o.f5446O000000o.O00000Oo.O00000o.get(o000000o);
                                            if (o000000o4 == null) {
                                                Log.w(IZatManager.f5442O000000o, "no flp session undergoing");
                                            } else {
                                                FlpStatusCallbackWrapper flpStatusCallbackWrapper = o000000o4.O00000o0;
                                                if (flpStatusCallbackWrapper == null) {
                                                    Log.w(IZatManager.f5442O000000o, "no status callback wrapper is registered.");
                                                } else {
                                                    o000000o.f5446O000000o.f5445O000000o.unregisterForSessionStatus(flpStatusCallbackWrapper);
                                                    o000000o4.O00000o0 = null;
                                                }
                                            }
                                        }
                                        IZatManager.this.O00000o.remove(o000000o);
                                    } catch (RemoteException e) {
                                        throw new RuntimeException("Failed unregisterForSessionStatus", e);
                                    }
                                } else {
                                    throw new IZatFeatureNotSupportedException("Session status not supported.");
                                }
                            } else if (this.mService.startFlpSession(o000000o2.O0000O0o, o000000o2.O0000Oo.getCode(), o000000o2.O00000o, o000000o2.O00000oO, o000000o2.O00000oo) == 0) {
                                NotificationType notificationType2 = o000000o2.O0000Oo;
                                o000000o2.f5443O000000o = notificationType2;
                                if (NotificationType.NOTIFICATION_WHEN_TRIP_IS_COMPLETED != notificationType2) {
                                    o000000o2.O0000Oo = notificationType2;
                                }
                                o000000o2.O0000Oo0 = false;
                                if ((IZatManager.this.O00000o0 & 8) > 0 && NotificationType.NOTIFICATION_ON_EVERY_LOCATION_FIX == o000000o2.f5443O000000o) {
                                    this.mService.unregisterCallback(1, o000000o2.O00000Oo);
                                    this.mService.registerCallback(2, o000000o2.O0000O0o, o000000o2.O00000Oo, o000000o2.O0000OOo);
                                }
                            } else {
                                Log.v(IZatManager.f5442O000000o, "mService.updateFlpSession on trip completed failed.");
                            }
                        }
                    }
                }
            } catch (RemoteException unused) {
                throw new RuntimeException("Failed to handle onBatchingStatusCb for status:" + i);
            }
        }
    }

    enum NotificationType {
        NOTIFICATION_WHEN_BUFFER_IS_FULL(1),
        NOTIFICATION_ON_EVERY_LOCATION_FIX(2),
        NOTIFICATION_WHEN_TRIP_IS_COMPLETED(3);
        
        private final int mCode;

        private NotificationType(int i) {
            this.mCode = i;
        }

        public final int getCode() {
            return this.mCode;
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        Object f5444O000000o;
        int O00000Oo;
        IZatGeofenceService.O000000o O00000o0;

        public O00000Oo(Object obj, int i, IZatGeofenceService.O000000o o000000o) {
            this.f5444O000000o = obj;
            this.O00000Oo = i;
            this.O00000o0 = o000000o;
        }
    }

    class MaxPowerAllocatedCallbackWrapper extends IMaxPowerAllocatedCallback.Stub {
        css.O000000o mCallback;

        public MaxPowerAllocatedCallbackWrapper(css.O000000o o000000o) {
            this.mCallback = o000000o;
        }

        public void onMaxPowerAllocatedChanged(double d) {
            if (this.mCallback == null) {
                Log.w(IZatManager.f5442O000000o, "mCallback is NULL in MaxPowerAllocatedCallbackWrapper");
            }
        }
    }

    class GeofenceStatusCallbackWrapper extends IGeofenceCallback.Stub {
        private GeofenceStatusCallbackWrapper() {
        }

        public void onTransitionEvent(int i, int i2, Location location) {
            if (IZatManager.O00000Oo) {
                String str = IZatManager.f5442O000000o;
                Log.d(str, "onTransitionEvent - geofenceHwId is " + i + "; event is " + i2);
            }
            csv.O000000o(location);
            csv.O000000o(i2, IZatValidationResults.IZatDataTypes.GEO_EVENT);
            synchronized (IZatManager.O0000oO) {
                for (O0000O0o.O000000o o000000o : IZatManager.this.O0000OOo.keySet()) {
                    O00000Oo o00000Oo = IZatManager.this.O0000OOo.get(o000000o);
                    if (o00000Oo.O00000Oo == i) {
                        o00000Oo.O00000o0.O000000o(i2);
                        return;
                    }
                }
            }
        }

        public void onRequestResultReturned(int i, int i2, int i3) {
            if (IZatManager.O00000Oo) {
                String str = IZatManager.f5442O000000o;
                Log.d(str, "onRequestResultReturned - geofenceHwId is " + i + "; requestType is " + i2 + "; result is " + i3);
            }
            csv.O000000o(i2, IZatValidationResults.IZatDataTypes.GEO_REQUEST_TYPE);
            csv.O000000o(i3, IZatValidationResults.IZatDataTypes.GEO_ERROR_CODE);
            if (i3 != 0) {
                synchronized (IZatManager.O0000oO) {
                    for (O0000O0o.O000000o next : IZatManager.this.O0000OOo.keySet()) {
                        O00000Oo o00000Oo = IZatManager.this.O0000OOo.get(next);
                        if (o00000Oo.O00000Oo == i) {
                            if (1 == i2) {
                                IZatManager.this.O0000OOo.remove(next);
                            }
                            o00000Oo.O00000o0.O000000o(i2, i3);
                            return;
                        }
                    }
                }
            }
        }

        public void onEngineReportStatus(int i, Location location) {
            if (IZatManager.O00000Oo) {
                String str = IZatManager.f5442O000000o;
                Log.d(str, "onEngineReportStatus - status is " + i);
            }
            csv.O000000o(location);
            csv.O000000o(i, IZatValidationResults.IZatDataTypes.GEO_ENGINE_STATUS);
            synchronized (IZatManager.O0000oOO) {
                for (O0000O0o o0000O0o : IZatManager.this.O0000O0o.keySet()) {
                    IZatManager.this.O0000O0o.get(o0000O0o).O00000Oo(i);
                }
            }
        }
    }

    class DebugReportCallbackWrapper extends IDebugReportCallback.Stub {
        private DebugReportCallbackWrapper() {
        }

        public void onDebugDataAvailable(Bundle bundle) {
            if (IZatManager.O00000Oo) {
                Log.v(IZatManager.f5442O000000o, "onDebugDataAvailable");
            }
            synchronized (IZatManager.O0000oo0) {
                for (O00000o0 o00000o0 : IZatManager.this.O0000Oo0.keySet()) {
                    IZatManager.this.O0000Oo0.get(o00000o0);
                }
            }
        }
    }

    class WiFiDBReceiverRespListenerWrapper extends IWiFiDBReceiverResponseListener.Stub {
        private WiFiDBReceiverRespListenerWrapper() {
        }

        public void onAPListAvailable(List<APInfo> list) {
            IZatDBCommon.O00000Oo o00000Oo;
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onAPListAvailable");
            }
            if (IZatManager.this.O0000OoO != null) {
                ArrayList<IZatWiFiDBReceiver.IZatAPInfo> arrayList = new ArrayList<>();
                Iterator<APInfo> it = list.iterator();
                while (true) {
                    IZatDBCommon.O000000o o000000o = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    APInfo next = it.next();
                    if (next.O00000o0 == 0 && next.O00000o == 0 && next.O00000oO == 0 && next.O00000oo == 0) {
                        o00000Oo = null;
                    } else {
                        o00000Oo = new IZatDBCommon.O00000Oo(next.O00000o0, next.O00000o, next.O00000oO, next.O00000oo, Integer.valueOf(next.O00000Oo));
                    }
                    if (next.O0000O0o != null && next.O0000O0o.length > 0) {
                        o000000o = new IZatDBCommon.O000000o(next.O0000O0o, (short) next.O0000O0o.length);
                    }
                    arrayList.add(new IZatWiFiDBReceiver.IZatAPInfo(next.f5458O000000o, 0, new IZatWiFiDBReceiver.O000000o(o00000Oo, o000000o)));
                }
                if (IZatManager.O00000Oo) {
                    IZatManager.O000000o(arrayList, null, null);
                }
                for (IZatWiFiDBReceiver.IZatAPInfo O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
            }
        }

        private IZatWiFiDBReceiver.IZatAPInfo iZatAPInfoFromAPInfoExt(APInfoExt aPInfoExt) {
            IZatDBCommon.O00000Oo o00000Oo;
            IZatWiFiDBReceiver.O000000o o000000o = null;
            if (aPInfoExt.O00000o0 == 0 && aPInfoExt.O00000o == 0 && aPInfoExt.O00000oO == 0 && aPInfoExt.O00000oo == 0) {
                o00000Oo = null;
            } else {
                o00000Oo = new IZatDBCommon.O00000Oo(aPInfoExt.O00000o0, aPInfoExt.O00000o, aPInfoExt.O00000oO, aPInfoExt.O00000oo, Integer.valueOf(aPInfoExt.O00000Oo));
            }
            IZatDBCommon.O000000o o000000o2 = (aPInfoExt.O0000O0o == null || aPInfoExt.O0000O0o.length <= 0) ? null : new IZatDBCommon.O000000o(aPInfoExt.O0000O0o, (short) aPInfoExt.O0000O0o.length);
            if (!(o00000Oo == null || o000000o2 == null)) {
                o000000o = new IZatWiFiDBReceiver.O000000o(o00000Oo, o000000o2);
            }
            return new IZatWiFiDBReceiver.IZatAPInfo(aPInfoExt.f5459O000000o, aPInfoExt.O0000OOo, o000000o);
        }

        public void onAPListAvailableExt(List<APInfoExt> list, int i, Location location) {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onAPListAvailable");
            }
            if (IZatManager.this.O0000OoO != null) {
                ArrayList<IZatWiFiDBReceiver.IZatAPInfo> arrayList = new ArrayList<>();
                for (APInfoExt iZatAPInfoFromAPInfoExt : list) {
                    arrayList.add(iZatAPInfoFromAPInfoExt(iZatAPInfoFromAPInfoExt));
                }
                if (IZatManager.O00000Oo) {
                    IZatManager.O000000o(arrayList, IZatDBCommon.IZatApBsListStatus.fromInt(i), location);
                }
                for (IZatWiFiDBReceiver.IZatAPInfo O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
                if (IZatManager.this.O0000OoO.f5452O000000o != null) {
                    IZatDBCommon.IZatApBsListStatus.fromInt(i);
                }
            }
        }

        public void onLookupRequest(List<APInfoExt> list, Location location) {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onLookupRequest");
            }
            if (IZatManager.this.O0000OoO != null) {
                ArrayList<IZatWiFiDBReceiver.IZatAPInfo> arrayList = new ArrayList<>();
                for (APInfoExt next : list) {
                    IZatWiFiDBReceiver.IZatAPInfo iZatAPInfoFromAPInfoExt = iZatAPInfoFromAPInfoExt(next);
                    if (IZatManager.O00000Oo) {
                        String str = IZatManager.f5442O000000o;
                        int i = next.O0000Oo0;
                        Log.d(str, "onLookupRequest ap.mFdalStatus: " + i);
                    }
                    iZatAPInfoFromAPInfoExt.O000000o(next.O0000Oo0);
                    arrayList.add(iZatAPInfoFromAPInfoExt);
                }
                if (IZatManager.O00000Oo) {
                    IZatManager.O000000o(arrayList, IZatDBCommon.IZatApBsListStatus.STD_FINAL, location);
                }
                for (IZatWiFiDBReceiver.IZatAPInfo O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
                csv.O000000o(location);
            }
        }

        public void onStatusUpdate(boolean z, String str) {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onStatusUpdate");
            }
        }

        public void onServiceRequest() {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onServiceRequest");
            }
        }
    }

    class WiFiDBProviderRespListenerWrapper extends IWiFiDBProviderResponseListener.Stub {
        private WiFiDBProviderRespListenerWrapper() {
        }

        public void onApObsLocDataAvailable(List<APObsLocData> list, int i) {
            IZatDBCommon.O00000Oo o00000Oo;
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onApObsLocDataAvailable");
            }
            if (IZatManager.this.O0000o00 != null) {
                ArrayList<csu.O000000o> arrayList = new ArrayList<>();
                for (APObsLocData next : list) {
                    ArrayList arrayList2 = new ArrayList();
                    APScan[] aPScanArr = next.O00000o;
                    int length = aPScanArr.length;
                    int i2 = 0;
                    while (true) {
                        IZatDBCommon.O000000o o000000o = null;
                        if (i2 >= length) {
                            break;
                        }
                        APScan aPScan = aPScanArr[i2];
                        if (aPScan.O00000o != null && aPScan.O00000o.length > 0) {
                            o000000o = new IZatDBCommon.O000000o(aPScan.O00000o, (short) aPScan.O00000o.length);
                        }
                        arrayList2.add(new csu.O00000Oo(aPScan.f5457O000000o, aPScan.O00000Oo, aPScan.O00000o0, o000000o, aPScan.O00000oO));
                        i2++;
                    }
                    if (next.O00000Oo.O00000Oo == 0 && next.O00000Oo.O00000o0 == 0 && next.O00000Oo.O00000o == 0 && next.O00000Oo.O00000oO == 0) {
                        o00000Oo = null;
                    } else {
                        o00000Oo = new IZatDBCommon.O00000Oo(next.O00000Oo.O00000Oo, next.O00000Oo.O00000o0, next.O00000Oo.O00000o, next.O00000Oo.O00000oO, Integer.valueOf(next.O00000Oo.f5463O000000o));
                    }
                    arrayList.add(new csu.O000000o(next.f5456O000000o, o00000Oo, (long) next.O00000o0, arrayList2));
                }
                if (IZatManager.O00000Oo) {
                    IZatManager.O00000Oo(arrayList, IZatDBCommon.IZatApBsListStatus.values()[i]);
                }
                for (csu.O000000o O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
                IZatDBCommon.IZatApBsListStatus.values();
            }
        }

        public void onServiceRequest() {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onServiceRequest");
            }
        }
    }

    class WWANDBReceiverRespListenerWrapper extends IWWANDBReceiverResponseListener.Stub {
        private WWANDBReceiverRespListenerWrapper() {
        }

        public void onBSListAvailable(List<BSInfo> list) {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onBSListAvailable legacy");
            }
            if (IZatManager.this.O0000Ooo != null) {
                ArrayList<IZatWWANDBReceiver.O00000Oo> arrayList = new ArrayList<>();
                for (BSInfo next : list) {
                    arrayList.add(new IZatWWANDBReceiver.O00000Oo(new IZatDBCommon.O00000Oo(next.O00000Oo, next.O00000o0, next.O00000o, next.O00000oO, Integer.valueOf(next.f5463O000000o))));
                }
                for (IZatWWANDBReceiver.O00000Oo O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
            }
        }

        public void onBSListAvailableExt(List<BSInfo> list, int i, Location location) {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onBSListAvailable");
            }
            if (IZatManager.this.O0000Ooo != null) {
                ArrayList<IZatDBCommon.O00000Oo> arrayList = new ArrayList<>();
                for (BSInfo next : list) {
                    IZatDBCommon.O00000Oo o00000Oo = new IZatDBCommon.O00000Oo(next.O00000Oo, next.O00000o0, next.O00000o, next.O00000oO, Integer.valueOf(next.f5463O000000o));
                    o00000Oo.O000000o(next.O00000oo);
                    arrayList.add(o00000Oo);
                }
                for (IZatDBCommon.O00000Oo O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
                if (IZatManager.this.O0000Ooo.f5449O000000o != null) {
                    IZatDBCommon.IZatApBsListStatus.fromInt(i);
                }
            }
        }

        public void onStatusUpdate(boolean z, String str) {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onStatusUpdate");
            }
        }

        public void onServiceRequest() {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onServiceRequest");
            }
        }
    }

    class GnssConfigCallbackWrapper extends IGnssConfigCallback.Stub {
        private GnssConfigCallbackWrapper() {
        }

        public void getGnssSvTypeConfigCb(int[] iArr) {
            if (IZatManager.O00000Oo) {
                Log.v(IZatManager.f5442O000000o, "getGnssSvTypeConfigCb");
            }
            synchronized (IZatManager.O0000ooO) {
                for (O0000OOo next : IZatManager.this.O0000Oo.keySet()) {
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    for (int i : iArr) {
                        IZatGnssConfigService.IzatGnssSvType fromInt = IZatGnssConfigService.IzatGnssSvType.fromInt(i);
                        if (fromInt != null) {
                            hashSet2.add(fromInt);
                        } else {
                            IZatGnssConfigService.IzatGnssSvType fromInt2 = IZatGnssConfigService.IzatGnssSvType.fromInt((i ^ -1) & 255);
                            if (fromInt2 != null) {
                                hashSet.add(fromInt2);
                            } else {
                                Log.e(IZatManager.f5442O000000o, "Invalid sv type: " + i);
                            }
                        }
                    }
                    IZatManager.this.O0000Oo.get(next);
                }
            }
        }
    }

    class WWANDBProviderRespListenerWrapper extends IWWANDBProviderResponseListener.Stub {
        private WWANDBProviderRespListenerWrapper() {
        }

        public void onBsObsLocDataAvailable(List<BSObsLocationData> list, int i) throws RemoteException {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onBsObsLocDataAvailable");
            }
            if (IZatManager.this.O0000o0 != null) {
                ArrayList<cst.O000000o> arrayList = new ArrayList<>();
                for (BSObsLocationData next : list) {
                    IZatDBCommon.O00000Oo o00000Oo = new IZatDBCommon.O00000Oo(next.O00000Oo.O00000Oo, next.O00000Oo.O00000o0, next.O00000Oo.O00000o, next.O00000Oo.O00000oO, Integer.valueOf(next.O00000Oo.f5463O000000o));
                    o00000Oo.O000000o(next.O00000Oo.O00000oo);
                    Location location = next.f5462O000000o;
                    IZatWWANDBReceiver.IZatBSLocationDataBase.IZatReliablityTypes iZatReliablityTypes = IZatWWANDBReceiver.IZatBSLocationDataBase.IZatReliablityTypes.MEDIUM;
                    cst.O000000o o000000o = new cst.O000000o(o00000Oo, location, iZatReliablityTypes, iZatReliablityTypes);
                    o000000o.O000000o((long) next.O00000o0);
                    arrayList.add(o000000o);
                }
                if (IZatManager.O00000Oo) {
                    IZatManager.O000000o(arrayList, IZatDBCommon.IZatApBsListStatus.fromInt(i));
                }
                for (cst.O000000o O000000o2 : arrayList) {
                    csv.O000000o(O000000o2);
                }
                if (IZatManager.this.O0000o0.f14316O000000o != null) {
                    IZatDBCommon.IZatApBsListStatus.fromInt(i);
                }
            }
        }

        public void onServiceRequest() {
            if (IZatManager.O00000Oo) {
                Log.d(IZatManager.f5442O000000o, "onServiceRequest");
            }
        }
    }

    public static void O000000o(List<cst.O000000o> list, IZatDBCommon.IZatApBsListStatus iZatApBsListStatus) {
        String str = f5442O000000o;
        int size = list.size();
        Log.v(str, "BS ObsLocData Available size: " + size + " status:" + iZatApBsListStatus);
        int i = 1;
        for (cst.O000000o next : list) {
            String str2 = f5442O000000o;
            Log.v(str2, "Entry IZatBSObsLocationData num. " + i);
            Log.v(f5442O000000o, "Location data: ");
            O000000o(next.O00000Oo());
            String str3 = f5442O000000o;
            IZatDBCommon.O00000Oo O00000o02 = next.O00000o0();
            Log.v(str3, "Cell data: " + O00000o02);
            O000000o(next.O00000o0());
            Log.v(f5442O000000o, "Scan data: ");
            String str4 = f5442O000000o;
            long O000000o2 = next.O000000o();
            Log.v(str4, "Scan timestamp: " + O000000o2);
            i++;
        }
    }

    public static void O00000Oo(List<csu.O000000o> list, IZatDBCommon.IZatApBsListStatus iZatApBsListStatus) {
        String str = f5442O000000o;
        int size = list.size();
        Log.v(str, "Ap ObsLocData Available size: " + size + " status:" + iZatApBsListStatus);
        int i = 1;
        for (csu.O000000o next : list) {
            String str2 = f5442O000000o;
            Log.v(str2, "Entry IZatAPObsLocData num. " + i + " Location data:");
            O000000o(next.f14317O000000o);
            String str3 = f5442O000000o;
            IZatDBCommon.O00000Oo o00000Oo = next.O00000Oo;
            Log.v(str3, "Cell data: " + o00000Oo);
            O000000o(next.O00000Oo);
            String str4 = f5442O000000o;
            long j = next.O00000o0;
            int size2 = next.O00000o.size();
            Log.v(str4, "Scan timestamp: " + j + "Number of APScan entries: " + size2);
            int i2 = 1;
            for (csu.O00000Oo next2 : next.O00000o) {
                StringBuilder sb = new StringBuilder("===  Entry IZatAPScan num. ");
                sb.append(i2);
                sb.append("Mac address: ");
                sb.append(next2.f14318O000000o);
                sb.append("Rssi: ");
                sb.append(next2.O00000Oo);
                if (next2.O00000o != null) {
                    try {
                        sb.append("SSID utf8: ");
                        sb.append(new String(next2.O00000o.f5438O000000o, "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                        sb.append("SSID utf8: invalid utf8");
                    }
                } else {
                    sb.append("SSID utf8: null");
                }
                sb.append("Channel number: ");
                sb.append(next2.O00000oO);
                sb.append("Delta time:  ");
                sb.append(next2.O00000o0);
                Log.v(f5442O000000o, sb.toString());
                i2++;
            }
            i++;
        }
    }

    public static void O000000o(List<IZatWiFiDBReceiver.IZatAPInfo> list, IZatDBCommon.IZatApBsListStatus iZatApBsListStatus, Location location) {
        String str = f5442O000000o;
        int size = list.size();
        Log.v(str, "AP List size:" + size + " status: " + iZatApBsListStatus);
        O000000o(location);
        for (IZatWiFiDBReceiver.IZatAPInfo next : list) {
            StringBuilder sb = new StringBuilder("AP Info mac: ");
            sb.append(next.f5453O000000o);
            sb.append("AP Info timestamp: ");
            sb.append(next.O000000o());
            if (next.O00000Oo()) {
                IZatWiFiDBReceiver.O000000o o000000o = next.O00000Oo;
                if (o000000o.O00000Oo != null) {
                    try {
                        sb.append("SSID utf8: ");
                        sb.append(new String(o000000o.O00000Oo.f5438O000000o, "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                        sb.append("SSID utf8: invalid utf8");
                    }
                } else {
                    sb.append("SSID utf8: null");
                }
                O000000o(o000000o.f5454O000000o);
            } else {
                sb.append("AP info no extra data available.");
            }
            Log.v(f5442O000000o, sb.toString());
        }
    }

    private static void O000000o(Location location) {
        if (location == null) {
            Log.v(f5442O000000o, "Location is null");
            return;
        }
        String str = f5442O000000o;
        String provider = location.getProvider();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        Object obj = "EMPTY";
        Object valueOf = location.hasAltitude() ? Double.valueOf(location.getAltitude()) : obj;
        Object valueOf2 = location.hasAccuracy() ? Float.valueOf(location.getAccuracy()) : obj;
        long time = location.getTime();
        if (location.hasVerticalAccuracy()) {
            obj = Float.valueOf(location.getVerticalAccuracyMeters());
        }
        Log.v(str, "Provider: " + provider + "Longitude: " + longitude + "Latitude: " + latitude + "Altitude: " + valueOf + "Accuracy: " + valueOf2 + "loc. Timestamp: " + time + "VerticalAccuracy: " + obj);
    }

    private static void O000000o(IZatDBCommon.O00000Oo o00000Oo) {
        if (o00000Oo == null) {
            Log.v(f5442O000000o, "cellInfo is null");
            return;
        }
        StringBuilder sb = new StringBuilder("RegionID1: ");
        sb.append(o00000Oo.O00000Oo());
        sb.append("RegionID2: ");
        sb.append(o00000Oo.O00000o0());
        sb.append("RegionID3: ");
        sb.append(o00000Oo.O00000o());
        sb.append("RegionID4: ");
        sb.append(o00000Oo.O00000oO());
        sb.append("Type:      ");
        sb.append(o00000Oo.O00000oo());
        try {
            sb.append(o00000Oo.O000000o());
        } catch (IZatStaleDataException unused) {
            sb.append("Timestamp: invalid");
        }
        Log.v(f5442O000000o, sb.toString());
    }
}
