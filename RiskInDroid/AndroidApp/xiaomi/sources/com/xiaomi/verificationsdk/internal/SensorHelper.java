package com.xiaomi.verificationsdk.internal;

import _m_j.iar;
import _m_j.ias;
import _m_j.iat;
import _m_j.iaz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.verificationsdk.internal.ErrorInfo;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorHelper implements SensorEventListener {
    private static HandlerThread O0000o0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f12046O000000o;
    public Context O00000Oo;
    public int O00000o;
    public int O00000o0;
    public long O00000oO;
    public JSONArray O00000oo;
    public JSONArray O0000O0o;
    public JSONArray O0000OOo;
    public JSONArray O0000Oo;
    public JSONArray O0000Oo0;
    public String O0000OoO;
    volatile boolean O0000Ooo = false;
    private TelephonyManager O0000o;
    private SensorManager O0000o0;
    private final String O0000o00 = "SensorHelper";
    private int O0000o0O;
    private volatile boolean O0000oO = false;
    private BatteryReceiver O0000oO0;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    static {
        HandlerThread handlerThread = new HandlerThread("sensor");
        O0000o0o = handlerThread;
        handlerThread.start();
    }

    public SensorHelper(Context context) {
        if (context != null) {
            this.O00000Oo = context;
            this.O0000o0 = (SensorManager) context.getSystemService("sensor");
            this.f12046O000000o = new Handler(O0000o0o.getLooper());
            this.O0000o = (TelephonyManager) context.getSystemService("phone");
            return;
        }
        throw new IllegalArgumentException("SensorHelper init : context  should not be null");
    }

    public static void O000000o(iar.O000000o o000000o, IOException iOException) {
        AccountLog.e("SensorHelper", "", iOException);
        if (iOException instanceof ConnectException) {
            int code = ErrorInfo.ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION.getCode();
            o000000o.O000000o(O000000o(code, "uploadData:" + iOException.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION)));
        } else if (iOException instanceof SocketTimeoutException) {
            int code2 = ErrorInfo.ErrorCode.ERROR_SOCKET_TIMEOUT_EXCEPTION.getCode();
            o000000o.O000000o(O000000o(code2, "uploadData:" + iOException.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_SOCKET_TIMEOUT_EXCEPTION)));
        } else if (iOException instanceof ConnectTimeoutException) {
            int code3 = ErrorInfo.ErrorCode.ERROR_CONNECT_TIMEOUT_EXCEPTION.getCode();
            o000000o.O000000o(O000000o(code3, "uploadData:" + iOException.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_CONNECT_TIMEOUT_EXCEPTION)));
        } else {
            int code4 = ErrorInfo.ErrorCode.ERROR_IO_EXCEPTION.getCode();
            o000000o.O000000o(O000000o(code4, "uploadData:" + iOException.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_IO_EXCEPTION)));
        }
    }

    public final void O000000o(int i, int i2) {
        this.O0000o0O = i;
        final long currentTimeMillis = System.currentTimeMillis();
        O0000OOo();
        this.f12046O000000o.postDelayed(new Runnable() {
            /* class com.xiaomi.verificationsdk.internal.SensorHelper.AnonymousClass3 */

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                SensorHelper.this.O000000o();
                SensorHelper.this.O0000OoO = SensorHelper.this.O000000o(currentTimeMillis, currentTimeMillis);
            }
        }, (long) i2);
    }

    public final String O000000o(long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.put("type", 2);
            jSONObject.put("startTs", j);
            jSONObject.put("endTs", j2);
            jSONObject2.put("battery", this.O00000o0);
            jSONObject2.put("device_id", new HashedDeviceIdUtil(this.O00000Oo).getHashedDeviceIdNoThrow());
            jSONObject2.put("app_version", O00000Oo());
            jSONObject2.put("sdk_version", "3.1.8");
            jSONObject2.put("vpn", O00000oO());
            jSONObject2.put("brand_model", Build.MODEL);
            jSONObject2.put("system_version", "Android " + Build.VERSION.RELEASE);
            jSONObject2.put("customed_system", Build.FINGERPRINT);
            jSONObject2.put("screen_brightness", O00000oo());
            int i = 1;
            jSONObject2.put("debug", Settings.Secure.getInt(this.O00000Oo.getContentResolver(), "adb_enabled", 0) > 0 ? 1 : 0);
            jSONObject2.put("simulator", ((TelephonyManager) this.O00000Oo.getSystemService("phone")).getNetworkOperatorName().toLowerCase().equals("android") ? 1 : 0);
            jSONObject2.put("charging", this.O00000o);
            jSONObject2.put("never_lock_screen", O0000O0o());
            JSONArray jSONArray = new JSONArray();
            WifiInfo connectionInfo = ((WifiManager) this.O00000Oo.getSystemService("wifi")).getConnectionInfo();
            String O00000Oo2 = EnvEncryptUtils.O00000Oo(connectionInfo.getSSID());
            String O00000Oo3 = EnvEncryptUtils.O00000Oo(connectionInfo.getBSSID());
            String O00000Oo4 = EnvEncryptUtils.O00000Oo(!TextUtils.isEmpty(connectionInfo.getMacAddress()) ? connectionInfo.getMacAddress().toLowerCase() : "");
            int rssi = connectionInfo.getRssi();
            jSONArray.put(O00000Oo2);
            jSONArray.put(O00000Oo3);
            jSONArray.put(O00000Oo4);
            jSONArray.put(rssi);
            jSONObject2.put("aps", jSONArray);
            jSONObject2.put("xposed", O00000o0());
            jSONObject2.put("substrate", O00000o());
            jSONObject2.put("root", ias.O000000o() ? 1 : 0);
            jSONObject2.put("boot_time", System.currentTimeMillis() - SystemClock.elapsedRealtime());
            jSONObject2.put("install_time", O000000o(this.O00000Oo));
            jSONObject2.put("package_name", this.O00000Oo.getPackageName());
            jSONObject2.put("app_name", O000000o(this.O00000Oo, this.O00000Oo.getPackageName()));
            try {
                if (!iat.O000000o()) {
                    i = 0;
                }
                jSONObject2.put("virtualapp", i);
            } catch (UnknownValueException e) {
                e.printStackTrace();
            }
            jSONObject.put("env", jSONObject2);
            if (this.O00000oo == null) {
                this.O00000oo = new JSONArray();
            }
            jSONObject3.put("rotation_speed", this.O00000oo);
            if (this.O0000O0o == null) {
                this.O0000O0o = new JSONArray();
            }
            jSONObject3.put("acceleration", this.O0000O0o);
            if (this.O0000OOo == null) {
                this.O0000OOo = new JSONArray();
            }
            jSONObject3.put("magnetic", this.O0000OOo);
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new JSONArray();
            }
            jSONObject3.put("light", this.O0000Oo0);
            if (this.O0000Oo == null) {
                this.O0000Oo = new JSONArray();
            }
            jSONObject3.put("barometer", this.O0000Oo);
            jSONObject.put("action", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String O00000Oo() {
        String str = "";
        try {
            String str2 = this.O00000Oo.getPackageManager().getPackageInfo(this.O00000Oo.getPackageName(), 0).versionName;
            if (str2 != null) {
                try {
                    if (str2.length() > 0) {
                        return str2;
                    }
                } catch (Exception e) {
                    String str3 = str2;
                    e = e;
                    str = str3;
                    Log.e("VersionInfo", "Exception", e);
                    return str;
                }
            }
            return str;
        } catch (Exception e2) {
            e = e2;
            Log.e("VersionInfo", "Exception", e);
            return str;
        }
    }

    private static String O000000o(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static long O000000o(Context context) {
        try {
            return new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int O00000o0() {
        this.O00000Oo.getPackageManager();
        for (ApplicationInfo applicationInfo : new ArrayList()) {
            if (applicationInfo.packageName.equals("de.robv.android.xposed.installer")) {
                return 1;
            }
        }
        return 0;
    }

    private int O00000o() {
        this.O00000Oo.getPackageManager();
        for (ApplicationInfo applicationInfo : new ArrayList()) {
            if (applicationInfo.packageName.equals("com.saurik.substrate")) {
                return 1;
            }
        }
        return 0;
    }

    private static int O00000oO() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return 0;
            }
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0) {
                    if ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName())) {
                        return 1;
                    }
                }
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private int O00000oo() {
        try {
            return Settings.System.getInt(this.O00000Oo.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int O0000O0o() {
        int i;
        try {
            i = Settings.System.getInt(this.O00000Oo.getContentResolver(), "screen_off_timeout");
        } catch (Exception unused) {
            i = 0;
        }
        return i == Integer.MAX_VALUE ? 1 : 0;
    }

    private void O0000OOo() {
        this.O0000Ooo = true;
        O000000o(1);
        O000000o(4);
        O000000o(2);
        O000000o(5);
        O000000o(6);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (!this.O0000oO) {
            this.O0000oO0 = new BatteryReceiver();
            this.O00000Oo.registerReceiver(this.O0000oO0, intentFilter);
            this.O0000oO = true;
            this.O00000oO = System.currentTimeMillis();
        }
    }

    public final void O000000o() {
        if (this.O0000Ooo) {
            this.O0000Ooo = false;
            O0000Oo0();
        }
    }

    private void O000000o(int i) {
        Sensor defaultSensor = this.O0000o0.getDefaultSensor(i);
        if (defaultSensor != null) {
            this.O0000o0.registerListener(this, defaultSensor, this.O0000o0O * 1000);
        }
    }

    private synchronized void O0000Oo0() {
        try {
            this.O0000o0.unregisterListener(this);
            if (this.O0000oO) {
                this.O00000Oo.unregisterReceiver(this.O0000oO0);
                this.O0000oO = false;
            }
        } catch (Exception e) {
            Log.e("SensorHelper", e.toString());
        }
    }

    public void onSensorChanged(final SensorEvent sensorEvent) {
        this.f12046O000000o.post(new Runnable() {
            /* class com.xiaomi.verificationsdk.internal.SensorHelper.AnonymousClass4 */

            public final void run() {
                SensorHelper sensorHelper = SensorHelper.this;
                O000000o o000000o = new O000000o(sensorEvent);
                if (sensorHelper.O0000Ooo) {
                    if (sensorHelper.O00000oo == null) {
                        sensorHelper.O00000oo = new JSONArray();
                    }
                    if (sensorHelper.O0000O0o == null) {
                        sensorHelper.O0000O0o = new JSONArray();
                    }
                    if (sensorHelper.O0000OOo == null) {
                        sensorHelper.O0000OOo = new JSONArray();
                    }
                    if (sensorHelper.O0000Oo0 == null) {
                        sensorHelper.O0000Oo0 = new JSONArray();
                    }
                    if (sensorHelper.O0000Oo == null) {
                        sensorHelper.O0000Oo = new JSONArray();
                    }
                    try {
                        int i = o000000o.f12052O000000o;
                        if (i == 1) {
                            sensorHelper.O0000O0o.put(o000000o.O000000o());
                        } else if (i == 2) {
                            sensorHelper.O0000OOo.put(o000000o.O000000o());
                        } else if (i == 4) {
                            sensorHelper.O00000oo.put(o000000o.O000000o());
                        } else if (i == 5) {
                            sensorHelper.O0000Oo0.put(o000000o.O000000o());
                        } else if (i == 6) {
                            sensorHelper.O0000Oo.put(o000000o.O000000o());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f12052O000000o;
        private final float[] O00000o0;

        O000000o(SensorEvent sensorEvent) {
            this.O00000o0 = sensorEvent.values;
            this.f12052O000000o = sensorEvent.sensor.getType();
        }

        /* access modifiers changed from: package-private */
        public final JSONArray O000000o() throws JSONException {
            double d;
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(System.currentTimeMillis() - SensorHelper.this.O00000oO);
            DecimalFormat decimalFormat = new DecimalFormat("##0.0");
            double d2 = 0.0d;
            if (this.f12052O000000o == 5) {
                try {
                    d2 = Double.parseDouble(decimalFormat.format((double) this.O00000o0[0]));
                } catch (Exception unused) {
                }
                jSONArray.put(d2);
            } else {
                for (float f : this.O00000o0) {
                    try {
                        d = Double.parseDouble(new DecimalFormat("##0.0000").format((double) f));
                    } catch (Exception e) {
                        Log.e("SensorHelper", e.toString());
                        d = 0.0d;
                    }
                    jSONArray.put(d);
                }
            }
            return jSONArray;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (float append : this.O00000o0) {
                sb.append(append);
                sb.append(",");
            }
            int i2 = this.f12052O000000o;
            if (i2 == 1) {
                i = 2;
            } else if (i2 == 2) {
                i = 3;
            } else if (i2 == 4) {
                i = 1;
            } else if (i2 == 5) {
                i = 4;
            } else if (i2 == 6) {
                i = 5;
            }
            sb.append(i);
            sb.append(",");
            sb.append(System.currentTimeMillis());
            return sb.toString();
        }
    }

    public class BatteryReceiver extends BroadcastReceiver {
        public BatteryReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras() != null) {
                SensorHelper.this.O00000o0 = intent.getExtras().getInt("level");
            }
            if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                SensorHelper.this.O00000o = 0;
            } else if (intent.getIntExtra("status", 1) == 2) {
                SensorHelper.this.O00000o = 1;
            }
        }
    }

    public static iaz O000000o(int i, String str, int i2) {
        iaz.O000000o o000000o = new iaz.O000000o();
        o000000o.f1144O000000o = i;
        o000000o.O00000Oo = str;
        o000000o.O00000o0 = i2;
        return o000000o.O000000o();
    }
}
