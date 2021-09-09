package _m_j;

import _m_j.bwf;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.location.UmidtokenInfo;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.google.android.exoplayer2.C;
import com.loc.n;
import com.loc.r;
import java.util.ArrayList;
import java.util.Iterator;

public final class bwq implements LocationManagerBase {
    /* access modifiers changed from: private */
    public static boolean O00oOoOo = false;

    /* renamed from: O000000o  reason: collision with root package name */
    AMapLocationClientOption f13342O000000o = new AMapLocationClientOption();
    public O00000o0 O00000Oo;
    ArrayList<AMapLocationListener> O00000o = new ArrayList<>();
    bwr O00000o0 = null;
    boolean O00000oO = false;
    public boolean O00000oo = true;
    r O0000O0o;
    Messenger O0000OOo = null;
    Intent O0000Oo = null;
    Messenger O0000Oo0 = null;
    int O0000OoO = 0;
    O00000Oo O0000Ooo = null;
    boolean O0000o = false;
    AMapLocationClientOption.AMapLocationMode O0000o0 = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    boolean O0000o00 = false;
    Object O0000o0O = new Object();
    bwf O0000o0o = null;
    String O0000oO = null;
    n O0000oO0 = null;
    AMapLocationQualityReport O0000oOO = null;
    boolean O0000oOo = false;
    O000000o O0000oo = null;
    boolean O0000oo0 = false;
    String O0000ooO = null;
    boolean O0000ooo = false;
    private volatile boolean O000O00o = false;
    private boolean O000O0OO = true;
    /* access modifiers changed from: private */
    public boolean O000O0Oo = true;
    private ServiceConnection O000O0o = new ServiceConnection() {
        /* class _m_j.bwq.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.bwq.O000000o(_m_j.bwq, boolean):boolean
         arg types: [_m_j.bwq, int]
         candidates:
          _m_j.bwq.O000000o(int, android.os.Bundle):void
          _m_j.bwq.O000000o(_m_j.bud, com.autonavi.aps.amapapi.model.AMapLocationServer):void
          _m_j.bwq.O000000o(_m_j.bwq, android.os.Bundle):void
          _m_j.bwq.O000000o(_m_j.bwq, android.os.Message):void
          _m_j.bwq.O000000o(_m_j.bwq, com.amap.api.location.AMapLocationListener):void
          _m_j.bwq.O000000o(android.content.Intent, boolean):void
          _m_j.bwq.O000000o(com.amap.api.location.AMapLocation, long):void
          _m_j.bwq.O000000o(_m_j.bwq, boolean):boolean */
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                bwq.this.O0000OOo = new Messenger(iBinder);
                boolean unused = bwq.this.O00oOooo = true;
                bwq.this.O0000o = true;
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "onServiceConnected");
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.bwq.O000000o(_m_j.bwq, boolean):boolean
         arg types: [_m_j.bwq, int]
         candidates:
          _m_j.bwq.O000000o(int, android.os.Bundle):void
          _m_j.bwq.O000000o(_m_j.bud, com.autonavi.aps.amapapi.model.AMapLocationServer):void
          _m_j.bwq.O000000o(_m_j.bwq, android.os.Bundle):void
          _m_j.bwq.O000000o(_m_j.bwq, android.os.Message):void
          _m_j.bwq.O000000o(_m_j.bwq, com.amap.api.location.AMapLocationListener):void
          _m_j.bwq.O000000o(android.content.Intent, boolean):void
          _m_j.bwq.O000000o(com.amap.api.location.AMapLocation, long):void
          _m_j.bwq.O000000o(_m_j.bwq, boolean):boolean */
        public final void onServiceDisconnected(ComponentName componentName) {
            bwq bwq = bwq.this;
            bwq.O0000OOo = null;
            boolean unused = bwq.O00oOooo = false;
        }
    };
    private bws O000O0o0 = null;
    private Context O00oOooO;
    /* access modifiers changed from: private */
    public boolean O00oOooo = false;

    /* renamed from: _m_j.bwq$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f13344O000000o = new int[AMapLocationClientOption.AMapLocationMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f13344O000000o[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            f13344O000000o[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            try {
                f13344O000000o[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                switch (message.what) {
                    case 1002:
                        try {
                            bwq.O000000o(bwq.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th) {
                            bvz.O000000o(th, "AMapLocationManage$MHandlerr", "handleMessage SET_LISTENER");
                            return;
                        }
                    case 1003:
                        try {
                            bwq.this.O00000o0();
                            return;
                        } catch (Throwable th2) {
                            bvz.O000000o(th2, "AMapLocationManage$MHandlerr", "handleMessage START_LOCATION");
                            return;
                        }
                    case 1004:
                        try {
                            bwq.this.O00000o();
                            return;
                        } catch (Throwable th3) {
                            bvz.O000000o(th3, "AMapLocationManage$MHandlerr", "handleMessage STOP_LOCATION");
                            return;
                        }
                    case 1005:
                        try {
                            bwq.O00000Oo(bwq.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th4) {
                            bvz.O000000o(th4, "AMapLocationManage$MHandlerr", "handleMessage REMOVE_LISTENER");
                            return;
                        }
                    case 1006:
                    case 1007:
                        return;
                    case 1008:
                        try {
                            bwq.O0000O0o(bwq.this);
                            return;
                        } catch (Throwable th5) {
                            bvz.O000000o(th5, "AMapLocationManage$MHandlerr", "handleMessage START_SOCKET");
                            return;
                        }
                    case 1009:
                        try {
                            bwq.O0000OOo(bwq.this);
                            return;
                        } catch (Throwable th6) {
                            bvz.O000000o(th6, "AMapLocationManage$MHandlerr", "handleMessage STOP_SOCKET");
                            return;
                        }
                    case 1010:
                        return;
                    case 1011:
                        try {
                            bwq.this.O000000o();
                            return;
                        } catch (Throwable th7) {
                            bvz.O000000o(th7, "AMapLocationManage$MHandlerr", "handleMessage DESTROY");
                            return;
                        }
                    case 1012:
                    case 1013:
                    default:
                        return;
                    case 1014:
                        bwq.O00000Oo(bwq.this, message);
                        return;
                    case 1015:
                        try {
                            bwq.this.O00000o0.O000000o(bwq.this.f13342O000000o);
                            bwq.this.O000000o(1025, (Object) null, 300000);
                            return;
                        } catch (Throwable th8) {
                            bvz.O000000o(th8, "AMapLocationManage$MHandlerr", "handleMessage START_GPS_LOCATION");
                            return;
                        }
                    case 1016:
                        try {
                            if (bwq.this.O00000o0.O00000Oo()) {
                                bwq.this.O000000o(1016, (Object) null, 1000);
                                return;
                            } else {
                                bwq.O00000o(bwq.this);
                                return;
                            }
                        } catch (Throwable th9) {
                            bvz.O000000o(th9, "AMapLocationManage$MHandlerr", "handleMessage START_LBS_LOCATION");
                            return;
                        }
                    case 1017:
                        try {
                            bwq.this.O00000o0.O000000o();
                            bwq.this.O000000o(1025);
                            return;
                        } catch (Throwable th10) {
                            bvz.O000000o(th10, "AMapLocationManage$MHandlerr", "handleMessage STOP_GPS_LOCATION");
                            return;
                        }
                    case 1018:
                        try {
                            bwq.this.f13342O000000o = (AMapLocationClientOption) message.obj;
                            if (bwq.this.f13342O000000o != null) {
                                bwq.O00000oo(bwq.this);
                                return;
                            }
                            return;
                        } catch (Throwable th11) {
                            bvz.O000000o(th11, "AMapLocationManage$MHandlerr", "handleMessage SET_OPTION");
                            return;
                        }
                    case 1019:
                    case 1020:
                    case 1021:
                    case 1022:
                        return;
                    case 1023:
                        try {
                            bwq.O00000o0(bwq.this, message);
                            return;
                        } catch (Throwable th12) {
                            bvz.O000000o(th12, "AMapLocationManage$MHandlerr", "handleMessage ACTION_ENABLE_BACKGROUND");
                            return;
                        }
                    case 1024:
                        try {
                            bwq.O00000o(bwq.this, message);
                            return;
                        } catch (Throwable th13) {
                            bvz.O000000o(th13, "AMapLocationManage$MHandlerr", "handleMessage ACTION_DISABLE_BACKGROUND");
                            return;
                        }
                    case 1025:
                        if (bwq.this.O00000o0 != null) {
                            if (bwi.O00000o0() - bwq.this.O00000o0.O00000oO > 300000) {
                                bwq.this.O00000o0.O000000o();
                                bwq.this.O00000o0.O000000o(bwq.this.f13342O000000o);
                            }
                            bwq.this.O000000o(1025, (Object) null, 300000);
                            return;
                        }
                        return;
                }
            } catch (Throwable th14) {
                bvz.O000000o(th14, "AMapLocationManage$MHandlerr", "handleMessage");
            }
            bvz.O000000o(th14, "AMapLocationManage$MHandlerr", "handleMessage");
        }
    }

    static class O00000Oo extends HandlerThread {

        /* renamed from: O000000o  reason: collision with root package name */
        bwq f13346O000000o = null;

        public O00000Oo(String str, bwq bwq) {
            super(str);
            this.f13346O000000o = bwq;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.f13346O000000o.O0000O0o.O000000o();
                this.f13346O000000o.O00000oo();
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public class O00000o0 extends Handler {
        public O00000o0() {
        }

        public O00000o0(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (!bwq.this.O0000o00 || bvz.O00000o()) {
                    switch (message.what) {
                        case 1:
                            try {
                                bwq.O000000o(bwq.this, message.getData());
                                return;
                            } catch (Throwable th) {
                                bvz.O000000o(th, "AmapLocationManager$ActionHandler", "handleMessage RESULT_LBS_LOCATIONSUCCESS");
                                return;
                            }
                        case 2:
                            try {
                                bwq.O000000o(bwq.this, message);
                                return;
                            } catch (Throwable th2) {
                                bvz.O000000o(th2, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONSUCCESS");
                                return;
                            }
                        case 3:
                            return;
                        case 4:
                        default:
                            return;
                        case 5:
                            try {
                                Bundle data = message.getData();
                                data.putBundle("optBundle", bvz.O000000o(bwq.this.f13342O000000o));
                                bwq.this.O000000o(10, data);
                                return;
                            } catch (Throwable th3) {
                                bvz.O000000o(th3, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONCHANGE");
                                return;
                            }
                        case 6:
                            try {
                                Bundle data2 = message.getData();
                                if (bwq.this.O00000o0 != null) {
                                    bwr bwr = bwq.this.O00000o0;
                                    if (data2 != null) {
                                        try {
                                            data2.setClassLoader(AMapLocation.class.getClassLoader());
                                            bwr.O0000OOo = data2.getInt("I_MAX_GEO_DIS");
                                            bwr.O0000Oo0 = data2.getInt("I_MIN_GEO_DIS");
                                            AMapLocation aMapLocation = (AMapLocation) data2.getParcelable("loc");
                                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                                synchronized (bwr.O0000o0o) {
                                                    bwr.O00oOooo = aMapLocation;
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th4) {
                                            bvz.O000000o(th4, "GpsLocation", "setLastGeoLocation");
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (Throwable th5) {
                                bvz.O000000o(th5, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_GEO_SUCCESS");
                                return;
                            }
                        case 7:
                            try {
                                boolean unused = bwq.this.O000O0Oo = message.getData().getBoolean("ngpsAble");
                                return;
                            } catch (Throwable th6) {
                                bvz.O000000o(th6, "AmapLocationManager$ActionHandler", "handleMessage RESULT_NGPS_ABLE");
                                return;
                            }
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            bwf.O000000o((String) null, 2141);
                            bwq.O000000o(bwq.this, message);
                            return;
                        case 9:
                            boolean unused2 = bwq.O00oOoOo = message.getData().getBoolean("installMockApp");
                            return;
                    }
                }
            } catch (Throwable th7) {
                bvz.O000000o(th7, "AmapLocationManager$MainHandler", "handleMessage");
            }
        }
    }

    public bwq(Context context, Intent intent) {
        this.O00oOooO = context;
        this.O0000Oo = intent;
        try {
            this.O00000Oo = Looper.myLooper() == null ? new O00000o0(this.O00oOooO.getMainLooper()) : new O00000o0();
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "init 1");
        }
        try {
            this.O0000O0o = new r(this.O00oOooO);
        } catch (Throwable th2) {
            bvz.O000000o(th2, "AmapLocationManager", "init 5");
        }
        this.O0000Ooo = new O00000Oo("amapLocManagerThread", this);
        this.O0000Ooo.setPriority(5);
        this.O0000Ooo.start();
        this.O0000oo = O000000o(this.O0000Ooo.getLooper());
        try {
            this.O00000o0 = new bwr(this.O00oOooO, this.O00000Oo);
        } catch (Throwable th3) {
            bvz.O000000o(th3, "AmapLocationManager", "init 3");
        }
        if (this.O0000o0o == null) {
            this.O0000o0o = new bwf();
        }
    }

    private O000000o O000000o(Looper looper) {
        O000000o o000000o;
        synchronized (this.O0000o0O) {
            this.O0000oo = new O000000o(looper);
            o000000o = this.O0000oo;
        }
        return o000000o;
    }

    /* access modifiers changed from: private */
    public void O000000o(int i) {
        synchronized (this.O0000o0O) {
            if (this.O0000oo != null) {
                this.O0000oo.removeMessages(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.O0000OOo = null;
                    this.O00oOooo = false;
                }
                bvz.O000000o(th, "AmapLocationManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.O0000oO)) {
            this.O0000oO = bvz.O00000Oo(this.O00oOooO);
        }
        bundle.putString("c", this.O0000oO);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setData(bundle);
        obtain.replyTo = this.O0000Oo0;
        if (this.O0000OOo != null) {
            this.O0000OOo.send(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(int i, Object obj, long j) {
        synchronized (this.O0000o0O) {
            if (this.O0000oo != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.O0000oo.sendMessageDelayed(obtain, j);
            }
        }
    }

    private static void O000000o(bud bud, AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            try {
                if (aMapLocationServer.getErrorCode() == 0) {
                    bud.O00000Oo(aMapLocationServer);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    static /* synthetic */ void O000000o(bwq bwq, Bundle bundle) {
        AMapLocation aMapLocation;
        long j = 0;
        AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                bwq.O0000ooO = bundle.getString("nb");
                j = bundle.getLong("netUseTime", 0);
                if (!(aMapLocation == null || aMapLocation.getErrorCode() != 0 || bwq.O00000o0 == null)) {
                    bwq.O00000o0.O0000ooO = 0;
                    if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                        bwq.O00000o0.O00oOooo = aMapLocation;
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "resultLbsLocationSuccess");
            }
        } else {
            aMapLocation = null;
        }
        aMapLocation2 = bwq.O00000o0 != null ? bwq.O00000o0.O000000o(aMapLocation, bwq.O0000ooO) : aMapLocation;
        bwq.O000000o(aMapLocation2, j);
    }

    static /* synthetic */ void O000000o(bwq bwq, Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (bwq.O00000oo && bwq.O0000OOo != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", bvz.O000000o(bwq.f13342O000000o));
                bwq.O000000o(0, bundle);
                bwq.O00000oo = false;
            }
            bwq.O000000o(aMapLocation, 0);
            if (bwq.O000O0Oo) {
                bwq.O000000o(7, (Bundle) null);
            }
            bwq.O000000o(1025);
            bwq.O000000o(1025, (Object) null, 300000);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "resultGpsLocationSuccess");
        }
    }

    static /* synthetic */ void O000000o(bwq bwq, AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (bwq.O00000o == null) {
                bwq.O00000o = new ArrayList<>();
            }
            if (!bwq.O00000o.contains(aMapLocationListener)) {
                bwq.O00000o.add(aMapLocationListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    private void O000000o(Intent intent, boolean z) {
        if (this.O00oOooO != null) {
            if (Build.VERSION.SDK_INT >= 26 && z) {
                try {
                    this.O00oOooO.getClass().getMethod("startForegroundService", Intent.class).invoke(this.O00oOooO, intent);
                } catch (Throwable unused) {
                }
                this.O0000ooo = true;
            }
            this.O00oOooO.startService(intent);
            this.O0000ooo = true;
        }
    }

    private void O000000o(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    bwf.O000000o("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || !this.O00000o0.O00000Oo()) {
                aMapLocation.setAltitude(bwi.O00000Oo(aMapLocation.getAltitude()));
                aMapLocation.setBearing(bwi.O000000o(aMapLocation.getBearing()));
                aMapLocation.setSpeed(bwi.O000000o(aMapLocation.getSpeed()));
                Iterator<AMapLocationListener> it = this.O00000o.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    static /* synthetic */ void O00000Oo(bwq bwq, AMapLocationListener aMapLocationListener) {
        if (!bwq.O00000o.isEmpty() && bwq.O00000o.contains(aMapLocationListener)) {
            bwq.O00000o.remove(aMapLocationListener);
        }
        if (bwq.O00000o.isEmpty()) {
            bwq.O00000o();
        }
    }

    private boolean O00000Oo() {
        boolean z = false;
        int i = 0;
        do {
            try {
                if (this.O0000OOo != null) {
                    break;
                }
                Thread.sleep(100);
                i++;
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "checkAPSManager");
            }
        } while (i < 50);
        if (this.O0000OOo == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail(!bwi.O0000Ooo(this.O00oOooO.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.O00000Oo.sendMessage(obtain);
        } else {
            z = true;
        }
        if (!z) {
            bwf.O000000o((String) null, !bwi.O0000Ooo(this.O00oOooO.getApplicationContext()) ? 2103 : 2101);
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void O00000o() {
        try {
            O000000o(1025);
            if (this.O00000o0 != null) {
                this.O00000o0.O000000o();
            }
            O000000o(1016);
            this.O000O00o = false;
            this.O0000OoO = 0;
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "stopLocation");
        }
    }

    static /* synthetic */ void O00000o(bwq bwq) {
        try {
            if (bwq.O000O0OO) {
                bwq.O000O0OO = false;
                AMapLocationServer O00000Oo2 = bwq.O00000Oo(new bud());
                if (bwq.O00000Oo()) {
                    Bundle bundle = new Bundle();
                    String str = "0";
                    if (O00000Oo2 != null && (O00000Oo2.getLocationType() == 2 || O00000Oo2.getLocationType() == 4)) {
                        str = "1";
                    }
                    bundle.putBundle("optBundle", bvz.O000000o(bwq.f13342O000000o));
                    bundle.putString("isCacheLoc", str);
                    bwq.O000000o(0, bundle);
                }
            } else {
                if (bwq.O0000o && !bwq.isStarted() && !bwq.O0000oo0) {
                    bwq.O0000oo0 = true;
                    bwq.O00000oo();
                }
                if (bwq.O00000Oo()) {
                    bwq.O0000oo0 = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("optBundle", bvz.O000000o(bwq.f13342O000000o));
                    bundle2.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!bwq.O00000o0.O00000Oo()) {
                        bwq.O000000o(1, bundle2);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                bvz.O000000o(th, "AmapLocationManager", "doLBSLocation");
                try {
                    if (!bwq.f13342O000000o.isOnceLocation()) {
                        bwq.O00000oO();
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        try {
            if (!bwq.f13342O000000o.isOnceLocation()) {
                bwq.O00000oO();
                return;
            }
            return;
        } catch (Throwable unused3) {
            return;
        }
        throw th;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwq.O000000o(android.content.Intent, boolean):void
     arg types: [android.content.Intent, int]
     candidates:
      _m_j.bwq.O000000o(int, android.os.Bundle):void
      _m_j.bwq.O000000o(_m_j.bud, com.autonavi.aps.amapapi.model.AMapLocationServer):void
      _m_j.bwq.O000000o(_m_j.bwq, android.os.Bundle):void
      _m_j.bwq.O000000o(_m_j.bwq, android.os.Message):void
      _m_j.bwq.O000000o(_m_j.bwq, com.amap.api.location.AMapLocationListener):void
      _m_j.bwq.O000000o(com.amap.api.location.AMapLocation, long):void
      _m_j.bwq.O000000o(_m_j.bwq, boolean):boolean
      _m_j.bwq.O000000o(android.content.Intent, boolean):void */
    static /* synthetic */ void O00000o(bwq bwq, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    boolean z = data.getBoolean("j", true);
                    Intent O0000O0o2 = bwq.O0000O0o();
                    O0000O0o2.putExtra("j", z);
                    O0000O0o2.putExtra("g", 2);
                    bwq.O000000o(O0000O0o2, false);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "doDisableBackgroundLocation");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        return;
     */
    public synchronized void O00000o0() {
        if (this.f13342O000000o == null) {
            this.f13342O000000o = new AMapLocationClientOption();
        }
        if (!this.O000O00o) {
            this.O000O00o = true;
            int i = AnonymousClass2.f13344O000000o[this.f13342O000000o.getLocationMode().ordinal()];
            long j = 0;
            if (i == 1) {
                O000000o(1017, (Object) null, 0);
                O000000o(1016, (Object) null, 0);
            } else if (i == 2) {
                O000000o(1016);
                O000000o(1015, (Object) null, 0);
            } else if (i == 3) {
                O000000o(1015, (Object) null, 0);
                if (this.f13342O000000o.isGpsFirst() && this.f13342O000000o.isOnceLocation()) {
                    j = this.f13342O000000o.getGpsFirstTimeout();
                }
                O000000o(1016, (Object) null, j);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwq.O000000o(android.content.Intent, boolean):void
     arg types: [android.content.Intent, int]
     candidates:
      _m_j.bwq.O000000o(int, android.os.Bundle):void
      _m_j.bwq.O000000o(_m_j.bud, com.autonavi.aps.amapapi.model.AMapLocationServer):void
      _m_j.bwq.O000000o(_m_j.bwq, android.os.Bundle):void
      _m_j.bwq.O000000o(_m_j.bwq, android.os.Message):void
      _m_j.bwq.O000000o(_m_j.bwq, com.amap.api.location.AMapLocationListener):void
      _m_j.bwq.O000000o(com.amap.api.location.AMapLocation, long):void
      _m_j.bwq.O000000o(_m_j.bwq, boolean):boolean
      _m_j.bwq.O000000o(android.content.Intent, boolean):void */
    static /* synthetic */ void O00000o0(bwq bwq, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    int i = data.getInt("i", 0);
                    Intent O0000O0o2 = bwq.O0000O0o();
                    O0000O0o2.putExtra("i", i);
                    O0000O0o2.putExtra("h", (Notification) data.getParcelable("h"));
                    O0000O0o2.putExtra("g", 1);
                    bwq.O000000o(O0000O0o2, true);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "doEnableBackgroundLocation");
            }
        }
    }

    private void O00000oO() {
        if (this.f13342O000000o.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j = 1000;
            if (this.f13342O000000o.getInterval() >= 1000) {
                j = this.f13342O000000o.getInterval();
            }
            O000000o(1016, (Object) null, j);
        }
    }

    /* access modifiers changed from: private */
    public void O00000oo() {
        try {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new Messenger(this.O00000Oo);
            }
            this.O00oOooO.bindService(O0000O0o(), this.O000O0o, 1);
        } catch (Throwable unused) {
        }
    }

    private Intent O0000O0o() {
        String str;
        if (this.O0000Oo == null) {
            this.O0000Oo = new Intent(this.O00oOooO, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : bwt.O00000oo(this.O00oOooO);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "startServiceImpl p2");
            str = "";
        }
        this.O0000Oo.putExtra("a", str);
        this.O0000Oo.putExtra("b", bwt.O00000o0(this.O00oOooO));
        this.O0000Oo.putExtra("d", UmidtokenInfo.getUmidtoken());
        this.O0000Oo.putExtra("f", AMapLocationClientOption.isDownloadCoordinateConvertLibrary());
        return this.O0000Oo;
    }

    static /* synthetic */ void O0000O0o(bwq bwq) {
        try {
            if (bwq.O0000OOo != null) {
                bwq.O0000OoO = 0;
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", bvz.O000000o(bwq.f13342O000000o));
                bwq.O000000o(2, bundle);
                return;
            }
            bwq.O0000OoO++;
            if (bwq.O0000OoO < 10) {
                bwq.O000000o(1008, (Object) null, 50);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "startAssistantLocationImpl");
        }
    }

    static /* synthetic */ void O0000OOo(bwq bwq) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("optBundle", bvz.O000000o(bwq.f13342O000000o));
            bwq.O000000o(3, bundle);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "stopAssistantLocationImpl");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        O000000o(12, (Bundle) null);
        this.O000O0OO = true;
        this.O00000oo = true;
        this.O00oOooo = false;
        this.O0000o = false;
        O00000o();
        bwf bwf = this.O0000o0o;
        if (bwf != null) {
            bwf.O00000Oo(this.O00oOooO);
        }
        bwf.O000000o(this.O00oOooO);
        n nVar = this.O0000oO0;
        if (nVar != null) {
            nVar.O00000o.sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.O000O0o;
            if (serviceConnection != null) {
                this.O00oOooO.unbindService(serviceConnection);
            }
        }
        try {
            if (this.O0000ooo) {
                this.O00oOooO.stopService(O0000O0o());
            }
        } catch (Throwable unused) {
        }
        this.O0000ooo = false;
        ArrayList<AMapLocationListener> arrayList = this.O00000o;
        if (arrayList != null) {
            arrayList.clear();
            this.O00000o = null;
        }
        this.O000O0o = null;
        synchronized (this.O0000o0O) {
            if (this.O0000oo != null) {
                this.O0000oo.removeCallbacksAndMessages(null);
            }
            this.O0000oo = null;
        }
        if (this.O0000Ooo != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    bwd.O000000o(this.O0000Ooo, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                }
            }
            this.O0000Ooo.quit();
        }
        this.O0000Ooo = null;
        O00000o0 o00000o0 = this.O00000Oo;
        if (o00000o0 != null) {
            o00000o0.removeCallbacksAndMessages(null);
        }
        r rVar = this.O0000O0o;
        if (rVar != null) {
            rVar.O00000o0();
            this.O0000O0o = null;
        }
    }

    public final void disableBackgroundLocation(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z);
            O000000o(1024, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "disableBackgroundLocation");
        }
    }

    public final void enableBackgroundLocation(int i, Notification notification) {
        if (i != 0 && notification != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("i", i);
                bundle.putParcelable("h", notification);
                O000000o(1023, bundle, 0);
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "disableBackgroundLocation");
            }
        }
    }

    public final AMapLocation getLastKnownLocation() {
        AMapLocation aMapLocation = null;
        try {
            if (!(this.O0000O0o == null || (aMapLocation = this.O0000O0o.O00000Oo()) == null)) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final boolean isStarted() {
        return this.O00oOooo;
    }

    public final void onDestroy() {
        try {
            if (this.O000O0o0 != null) {
                this.O000O0o0.O000000o();
                this.O000O0o0 = null;
            }
            O000000o(1011, (Object) null, 0);
            this.O0000o00 = true;
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "onDestroy");
        }
    }

    public final void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            O000000o(1002, aMapLocationListener, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "setLocationListener");
        }
    }

    public final void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            O000000o(1018, aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "setLocationOption");
        }
    }

    public final void startAssistantLocation() {
        try {
            O000000o(1008, (Object) null, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "startAssistantLocation");
        }
    }

    public final void startLocation() {
        try {
            O000000o(1003, (Object) null, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "startLocation");
        }
    }

    public final void stopAssistantLocation() {
        try {
            if (this.O000O0o0 != null) {
                this.O000O0o0.O000000o();
                this.O000O0o0 = null;
            }
            O000000o(1009, (Object) null, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "stopAssistantLocation");
        }
    }

    public final void stopLocation() {
        try {
            O000000o(1004, (Object) null, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "stopLocation");
        }
    }

    public final void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            O000000o(1005, aMapLocationListener, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "unRegisterLocationListener");
        }
    }

    public final void startAssistantLocation(WebView webView) {
        if (this.O000O0o0 == null) {
            this.O000O0o0 = new bws(this.O00oOooO, webView);
        }
        bws bws = this.O000O0o0;
        if (bws.O00000o != null && bws.O00000Oo != null && Build.VERSION.SDK_INT >= 17 && !bws.O0000O0o) {
            try {
                bws.O00000o.getSettings().setJavaScriptEnabled(true);
                bws.O00000o.addJavascriptInterface(bws, "AMapAndroidLoc");
                if (!TextUtils.isEmpty(bws.O00000o.getUrl())) {
                    bws.O00000o.reload();
                }
                if (bws.O00000o0 == null) {
                    bws.O00000o0 = new AMapLocationClient(bws.O00000Oo);
                    bws.O00000o0.setLocationListener(bws.O0000OOo);
                }
                bws.O0000O0o = true;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (r2.O00000o0.isProviderEnabled("gps") == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0115, code lost:
        return;
     */
    private synchronized void O000000o(AMapLocation aMapLocation, long j) {
        int i;
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLocationManager", "handlerLocation part3");
                return;
            }
        }
        if (!"gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.O0000oOO == null) {
            this.O0000oOO = new AMapLocationQualityReport();
        }
        this.O0000oOO.setLocationMode(this.f13342O000000o.getLocationMode());
        if (this.O00000o0 != null) {
            this.O0000oOO.setGPSSatellites(this.O00000o0.O00oOooO);
            AMapLocationQualityReport aMapLocationQualityReport = this.O0000oOO;
            bwr bwr = this.O00000o0;
            if (bwr.O00000o0 != null) {
                if (bwr.O000000o(bwr.O00000o0)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        int i2 = Settings.Secure.getInt(bwr.O00000Oo.getContentResolver(), "location_mode", 0);
                        if (i2 != 0) {
                            if (i2 == 2) {
                                i = 3;
                                aMapLocationQualityReport.setGpsStatus(i);
                            }
                            i = !bwr.O0000oOO ? 4 : 0;
                            aMapLocationQualityReport.setGpsStatus(i);
                        }
                    }
                    i = 2;
                    aMapLocationQualityReport.setGpsStatus(i);
                }
            }
            i = 1;
            aMapLocationQualityReport.setGpsStatus(i);
        }
        this.O0000oOO.setWifiAble(bwi.O0000OOo(this.O00oOooO));
        this.O0000oOO.setNetworkType(bwi.O0000Oo0(this.O00oOooO));
        if (aMapLocation.getLocationType() == 1 || "gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            j = 0;
        }
        this.O0000oOO.setNetUseTime(j);
        this.O0000oOO.setInstallHighDangerMockApp(O00oOoOo);
        aMapLocation.setLocationQualityReport(this.O0000oOO);
        if (this.O000O00o) {
            String str = this.O0000ooO;
            Bundle bundle = new Bundle();
            bundle.putParcelable("loc", aMapLocation);
            bundle.putString("lastLocNb", str);
            O000000o(1014, bundle, 0);
            bwf.O000000o(this.O00oOooO, aMapLocation);
            bwf.O00000Oo(this.O00oOooO, aMapLocation);
            O000000o(aMapLocation.clone());
        }
        if (this.O0000o00 && !bvz.O00000o()) {
            return;
        }
        if (this.f13342O000000o.isOnceLocation()) {
            O00000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bvp.O000000o(android.content.Context, java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer
     arg types: [android.content.Context, java.lang.String, java.lang.StringBuilder, int]
     candidates:
      _m_j.bvp.O000000o(java.lang.String, com.amap.api.location.AMapLocation, java.lang.StringBuilder, android.content.Context):void
      _m_j.bvp.O000000o(android.content.Context, java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer */
    private AMapLocationServer O000000o(bud bud) {
        if (!this.f13342O000000o.isLocationCacheEnable()) {
            return null;
        }
        try {
            if (bud.O00000o0.O0000Oo0) {
                return bud.O000000o(15, "networkLocation has been mocked!#1502");
            }
            if (TextUtils.isEmpty(bud.O0000ooO)) {
                return bud.O000000o(bud.O000O00o, bud.O0000o0o.toString());
            }
            AMapLocationServer O000000o2 = bud.O00000oO.O000000o(bud.f13281O000000o, bud.O0000ooO, bud.O0000ooo, true);
            if (bwi.O000000o(O000000o2)) {
                bud.O000000o(O000000o2);
            }
            return O000000o2;
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "doFirstCacheLoc");
            return null;
        }
    }

    private AMapLocationServer O00000Oo(bud bud) {
        AMapLocationServer aMapLocationServer;
        Throwable th;
        bwe bwe;
        String str;
        AMapLocation aMapLocation = null;
        try {
            bwe = new bwe();
            bwe.f13330O000000o = bwi.O00000o0();
            String apikey = AMapLocationClientOption.getAPIKEY();
            if (!TextUtils.isEmpty(apikey)) {
                bwu.O000000o(this.O00oOooO, apikey);
            }
        } catch (Throwable th2) {
            aMapLocationServer = null;
            th = th2;
            try {
                bvz.O000000o(th, "AmapLocationManager", "apsLocation");
                bud.O00000oO();
                return aMapLocationServer;
            } catch (Throwable unused) {
            }
        }
        try {
            String umidtoken = UmidtokenInfo.getUmidtoken();
            if (!TextUtils.isEmpty(umidtoken)) {
                bww.O000000o(umidtoken);
            }
        } catch (Throwable th3) {
            bvz.O000000o(th3, "AmapLocationManager", "apsLocation setUmidToken");
        }
        try {
            bud.O000000o(this.O00oOooO);
            bud.O000000o(this.f13342O000000o);
            bud.O0000O0o();
        } catch (Throwable th4) {
            bvz.O000000o(th4, "AmapLocationManager", "initApsBase");
        }
        long j = 0;
        boolean O0000oo02 = bvy.O0000oo0();
        aMapLocationServer = O000000o(bud);
        boolean z = false;
        if (aMapLocationServer == null) {
            if (!O0000oo02) {
                z = true;
            }
            try {
                aMapLocationServer = bud.O000000o(z);
                if (aMapLocationServer != null) {
                    j = aMapLocationServer.k();
                }
                if (!O0000oo02) {
                    O000000o(bud, aMapLocationServer);
                }
            } catch (Throwable th5) {
                th = th5;
                bvz.O000000o(th, "AmapLocationManager", "apsLocation");
                bud.O00000oO();
                return aMapLocationServer;
            }
            z = true;
        }
        bwe.O00000Oo = bwi.O00000o0();
        bwe.O00000o0 = aMapLocationServer;
        if (aMapLocationServer != null) {
            str = aMapLocationServer.l();
            aMapLocation = aMapLocationServer.clone();
        } else {
            str = null;
        }
        try {
            if (this.f13342O000000o.isLocationCacheEnable() && this.O0000O0o != null) {
                aMapLocation = this.O0000O0o.O000000o(aMapLocation, str, this.f13342O000000o.getLastLocationLifeCycle());
            }
        } catch (Throwable th6) {
            bvz.O000000o(th6, "AmapLocationManager", "fixLastLocation");
        }
        try {
            Bundle bundle = new Bundle();
            if (aMapLocation != null) {
                bundle.putParcelable("loc", aMapLocation);
                bundle.putString("nb", aMapLocationServer.l());
                bundle.putLong("netUseTime", j);
            }
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            obtain.what = 1;
            this.O00000Oo.sendMessage(obtain);
        } catch (Throwable th7) {
            bvz.O000000o(th7, "AmapLocationManager", "apsLocation:callback");
        }
        bwf.O000000o(this.O00oOooO, bwe);
        if (z && O0000oo02) {
            try {
                bud.O00000Oo();
                O000000o(bud, bud.O000000o(true));
            } catch (Throwable th8) {
                bvz.O000000o(th8, "AmapLocationManager", "apsLocation:doFirstNetLocate 2");
            }
        }
        try {
            bud.O00000oO();
        } catch (Throwable unused2) {
        }
        return aMapLocationServer;
        throw th;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[Catch:{ Throwable -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    static /* synthetic */ void O00000Oo(bwq bwq, Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            if (aMapLocation != null) {
                AMapLocation aMapLocation2 = null;
                if (r.O00000Oo != null) {
                    aMapLocation2 = r.O00000Oo.O00000o;
                } else if (bwq.O0000O0o != null) {
                    aMapLocation2 = bwq.O0000O0o.O00000Oo();
                }
                bwf.O000000o(aMapLocation2, aMapLocation);
            }
            if (!bwq.O0000O0o.O000000o(aMapLocation, string)) {
                bwq.O0000O0o.O00000o();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLocationManager", "doSaveLastLocation");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    static /* synthetic */ void O00000oo(bwq bwq) {
        bwr bwr = bwq.O00000o0;
        AMapLocationClientOption aMapLocationClientOption = bwq.f13342O000000o;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        bwr.O00000o = aMapLocationClientOption;
        if (!(bwr.O00000o.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors || bwr.f13348O000000o == null)) {
            bwr.f13348O000000o.removeMessages(8);
        }
        if (bwr.O0000oO != bwr.O00000o.getGeoLanguage()) {
            synchronized (bwr.O0000o0o) {
                bwr.O00oOooo = null;
            }
        }
        bwr.O0000oO = bwr.O00000o.getGeoLanguage();
        if (bwq.O000O00o && !bwq.f13342O000000o.getLocationMode().equals(bwq.O0000o0)) {
            bwq.O00000o();
            bwq.O00000o0();
        }
        bwq.O0000o0 = bwq.f13342O000000o.getLocationMode();
        if (bwq.O0000o0o != null) {
            if (bwq.f13342O000000o.isOnceLocation()) {
                bwq.O0000o0o.O000000o(bwq.O00oOooO, 0);
            } else {
                bwq.O0000o0o.O000000o(bwq.O00oOooO, 1);
            }
            bwf bwf = bwq.O0000o0o;
            Context context = bwq.O00oOooO;
            try {
                int i = bwf.AnonymousClass1.f13332O000000o[bwq.f13342O000000o.getLocationMode().ordinal()];
                int i2 = 3;
                if (i == 1) {
                    i2 = 4;
                } else if (i == 2) {
                    i2 = 5;
                } else if (i != 3) {
                    i2 = -1;
                }
                if (bwf.O00000oO != i2) {
                    if (!(bwf.O00000oO == -1 || bwf.O00000oO == i2)) {
                        bwf.f13331O000000o.append(bwf.O00000oO, Long.valueOf((bwi.O00000o0() - bwf.O00000oo) + bwf.f13331O000000o.get(bwf.O00000oO, 0L).longValue()));
                    }
                    bwf.O00000oo = bwi.O00000o0() - bwg.O00000Oo(context, "pref", bwf.O00000o[i2], 0L);
                    bwf.O00000oO = i2;
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "setLocationMode");
            }
        }
    }
}
