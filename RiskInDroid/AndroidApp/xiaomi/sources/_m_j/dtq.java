package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Collections;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class dtq {

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Intent f14936O000000o;

        /* synthetic */ O000000o(Context context, byte b) {
            this(context);
        }

        private O000000o(Context context) {
            this.f14936O000000o = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    public static String O000000o(Context context) {
        try {
            return new String(O00000o0(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static String O00000Oo(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "ssosdk" : "weibo";
        sb.append(Build.MANUFACTURER);
        sb.append("-");
        sb.append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        sb.append("__android__android");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static String O00000o0(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String O000000o2 = O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                jSONObject.put("os", O000000o2);
            }
            String O00000o = O00000o(context);
            if (!TextUtils.isEmpty(O00000o)) {
                jSONObject.put("imei", O00000o);
            }
            String O00000oO = O00000oO(context);
            if (!TextUtils.isEmpty(O00000oO)) {
                jSONObject.put("meid", O00000oO);
            }
            String O00000oo = O00000oo(context);
            if (!TextUtils.isEmpty(O00000oo)) {
                jSONObject.put("imsi", O00000oo);
            }
            String O0000O0o = O0000O0o(context);
            if (!TextUtils.isEmpty(O0000O0o)) {
                jSONObject.put("mac", O0000O0o);
            }
            String O0000OOo = O0000OOo(context);
            if (!TextUtils.isEmpty(O0000OOo)) {
                jSONObject.put("iccid", O0000OOo);
            }
            String O00000o0 = O00000o0();
            if (!TextUtils.isEmpty(O00000o0)) {
                jSONObject.put("serial", O00000o0);
            }
            String O0000Oo = O0000Oo(context);
            if (!TextUtils.isEmpty(O0000Oo)) {
                jSONObject.put("androidid", O0000Oo);
            }
            String O00000oO2 = O00000oO();
            if (!TextUtils.isEmpty(O00000oO2)) {
                jSONObject.put("cpu", O00000oO2);
            }
            String O00000oo2 = O00000oo();
            if (!TextUtils.isEmpty(O00000oo2)) {
                jSONObject.put("model", O00000oo2);
            }
            String O0000O0o2 = O0000O0o();
            if (!TextUtils.isEmpty(O0000O0o2)) {
                jSONObject.put("sdcard", O0000O0o2);
            }
            String O0000OoO = O0000OoO(context);
            if (!TextUtils.isEmpty(O0000OoO)) {
                jSONObject.put("resolution", O0000OoO);
            }
            String O0000Ooo = O0000Ooo(context);
            if (!TextUtils.isEmpty(O0000Ooo)) {
                jSONObject.put("ssid", O0000Ooo);
            }
            String O0000o00 = O0000o00(context);
            if (!TextUtils.isEmpty(O0000o00)) {
                jSONObject.put("bssid", O0000o00);
            }
            String O0000OOo2 = O0000OOo();
            if (!TextUtils.isEmpty(O0000OOo2)) {
                jSONObject.put("deviceName", O0000OOo2);
            }
            String O0000o0 = O0000o0(context);
            if (!TextUtils.isEmpty(O0000o0)) {
                jSONObject.put("connecttype", O0000o0);
            }
            try {
                str = O00000Oo(context);
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("ua", str);
            }
            double O0000Oo0 = O0000Oo0(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(O0000Oo0));
            jSONObject.put("batterycurrentcapacity", String.valueOf(O0000Oo0));
            O000000o o000000o = new O000000o(context, (byte) 0);
            jSONObject.put("batterycurrentvoltage", o000000o.f14936O000000o.getIntExtra("voltage", 0));
            jSONObject.put("batterycurrenttemperature", o000000o.f14936O000000o.getIntExtra("temperature", 0));
            double intExtra = (double) o000000o.f14936O000000o.getIntExtra("level", 0);
            Double.isNaN(intExtra);
            double d = O0000Oo0 * intExtra;
            double intExtra2 = (double) o000000o.f14936O000000o.getIntExtra("scale", 0);
            Double.isNaN(intExtra2);
            jSONObject.put("batterycurrentcapacity", d / intExtra2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static String O000000o() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000o(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000oO(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000oo(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000Oo() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O0000O0o(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return O00000Oo();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
                return connectionInfo.getMacAddress();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String O0000OOo(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000o0() {
        if (Build.VERSION.SDK_INT >= 26) {
            return O00000o();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return "";
        }
    }

    private static double O0000Oo0(Context context) {
        Object obj;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (Exception unused2) {
            return 0.0d;
        }
    }

    @TargetApi(26)
    private static String O00000o() {
        try {
            return Build.getSerial();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String O0000Oo(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000oO() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O00000oo() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O0000O0o() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O0000OoO(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O0000Ooo(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O0000o00(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    private static String O0000OOo() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String O0000o0(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "none";
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    case 9:
                    case 10:
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    case 14:
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return "none";
                }
            } else if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            } else {
                return "none";
            }
        } catch (Exception unused) {
            return "none";
        }
    }
}
