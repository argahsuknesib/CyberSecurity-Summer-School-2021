package com.mibi.sdk.common;

import android.app.ActivityManager;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.DhcpInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.mibi.sdk.common.os.SystemProperties;
import com.mibi.sdk.common.utils.IdentifierManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class Client {
    private static AppInfo sAppInfo;
    private static Context sApplicationContext;
    private static DisplayInfo sDisplayInfo;
    private static TelephonyInfo sTelephonyInfo;

    public static String getApkChannel() {
        return "";
    }

    public static int getMibiUiVersionCode() {
        return 6;
    }

    public static String getPlatform() {
        return "MIUI";
    }

    public static String getRomChannel() {
        return "";
    }

    public static void init(Context context) {
        sApplicationContext = context.getApplicationContext();
    }

    private static Context getContext() {
        return sApplicationContext;
    }

    public static boolean isNetworkMetered(Context context) {
        if (isLaterThanJellyBean()) {
            return Utils.isNetworkMetered(context);
        }
        return Utils.isMobileConnected(context);
    }

    public static int getNetworkType(Context context) {
        return Utils.getNetworkType(context);
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static boolean isLaterThanHoneycomb() {
        return getBuildSdkVersion() >= 11;
    }

    public static boolean isLaterThanJellyBean() {
        return getBuildSdkVersion() >= 16;
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.code", ""));
    }

    public static String getBuildModel() {
        return Build.MODEL;
    }

    public static String getBuildDevice() {
        return Build.DEVICE;
    }

    public static String getBuildProduct() {
        return Build.PRODUCT;
    }

    public static String getBuildManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getBuildBrand() {
        return Build.BRAND;
    }

    public static String getBuildType() {
        return Build.TYPE;
    }

    public static int getBuildSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getMiuiVersion() {
        if (MiuiBuild.isAlphaBuild()) {
            return "alpha";
        }
        if (MiuiBuild.isDevelopmentVersion()) {
            return "development";
        }
        if (MiuiBuild.isStableVersion()) {
            return "stable";
        }
        return !isMiui() ? "android" : "";
    }

    public static String getBuildSystemVersion() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String getBuildSystemRelease() {
        return Build.VERSION.RELEASE;
    }

    public static String getOS() {
        return isMiui() ? "MIUI" : "Android";
    }

    public static String getBuildHardware() {
        return Build.HARDWARE;
    }

    public static String getBuildDisplay() {
        return Build.DISPLAY;
    }

    public static String getBuildTags() {
        return Build.TAGS;
    }

    public static String getBuildHost() {
        return Build.HOST;
    }

    public static String getBuildVersionCodename() {
        return Build.VERSION.CODENAME;
    }

    public static String getMiuiUiVersion() {
        String str = SystemProperties.get("ro.miui.ui.version.name");
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int getMiuiUiVersionCode() {
        return SystemProperties.getInt("ro.miui.ui.version.code", 0);
    }

    public static class DisplayInfo {
        public float mDensity;
        public int mDisplayDensity;
        public int mDisplayHeight;
        public int mDisplayWidth;
        public int mScreenSize;

        public int getDisplayWidth() {
            return this.mDisplayWidth;
        }

        public int getDisplayHeight() {
            return this.mDisplayHeight;
        }

        public String getDisplayResolution() {
            return this.mDisplayHeight + "*" + this.mDisplayWidth;
        }

        public int getDisplayDensity() {
            return this.mDisplayDensity;
        }

        public float getDensity() {
            return this.mDensity;
        }

        public int getScreenSize() {
            return this.mScreenSize;
        }
    }

    public static DisplayInfo getDisplayInfo() {
        DisplayInfo displayInfo = sDisplayInfo;
        if (displayInfo != null) {
            return displayInfo;
        }
        sDisplayInfo = new DisplayInfo();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        sDisplayInfo.mDisplayHeight = displayMetrics.heightPixels;
        sDisplayInfo.mDisplayWidth = displayMetrics.widthPixels;
        sDisplayInfo.mDisplayDensity = displayMetrics.densityDpi;
        sDisplayInfo.mDensity = displayMetrics.density;
        Configuration configuration = getContext().getResources().getConfiguration();
        sDisplayInfo.mScreenSize = configuration.screenLayout & 15;
        return sDisplayInfo;
    }

    public static class TelephonyInfo {
        public String mNetworkCountryIso = "";
        public String mNetworkOperator = "";
        public String mNetworkOperatorName = "";
        public int mPhoneType;
        public String mSimCountryIso = "";
        public String mSimOperator = "";
        public String mSimOperatorName = "";

        public String getSimOperator() {
            return this.mSimOperator;
        }

        public String getSimOperatorName() {
            return this.mSimOperatorName;
        }

        public String getSimCountryIso() {
            return this.mSimCountryIso;
        }

        public String getNetworkOperator() {
            return this.mNetworkOperator;
        }

        public String getNetworkOperatorName() {
            return this.mNetworkOperatorName;
        }

        public String getNetworkCountryIso() {
            return this.mNetworkCountryIso;
        }

        public int getPhoneType() {
            return this.mPhoneType;
        }
    }

    private static void updateTelephoneInfo() {
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            sTelephonyInfo.mSimOperator = telephonyManager.getSimOperator();
            sTelephonyInfo.mSimOperatorName = telephonyManager.getSimOperatorName();
            sTelephonyInfo.mSimCountryIso = telephonyManager.getSimCountryIso();
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            TelephonyInfo telephonyInfo = sTelephonyInfo;
            telephonyInfo.mNetworkOperator = networkOperator;
            telephonyInfo.mNetworkOperatorName = telephonyManager.getNetworkOperatorName();
            sTelephonyInfo.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        }
    }

    public static TelephonyInfo getTelephonyInfo() {
        if (sTelephonyInfo != null) {
            updateTelephoneInfo();
            return sTelephonyInfo;
        }
        TelephonyInfo telephonyInfo = new TelephonyInfo();
        sTelephonyInfo = telephonyInfo;
        telephonyInfo.mPhoneType = ((TelephonyManager) getContext().getSystemService("phone")).getPhoneType();
        updateTelephoneInfo();
        return sTelephonyInfo;
    }

    public static class WifiNetworkInfo {
        public String mWifiBssid = "";
        public String mWifiGateway = "";
        public String mWifiMac = "";
        public String mWifiSsid = "";

        public String getWifiMac() {
            return this.mWifiMac;
        }

        public String getWifiSsid() {
            return this.mWifiSsid;
        }

        public String getWifiBssid() {
            return this.mWifiBssid;
        }

        public String getWifiGateway() {
            return this.mWifiGateway;
        }
    }

    private static String acquireGateWay(WifiManager wifiManager) {
        int i;
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        if (dhcpInfo == null || (i = dhcpInfo.gateway) == 0) {
            return "";
        }
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
            i = Integer.reverseBytes(i);
        }
        try {
            return InetAddress.getByAddress(BigInteger.valueOf((long) i).toByteArray()).getHostAddress();
        } catch (UnknownHostException e) {
            Log.e("Client", "exception: " + e.toString() + " message: " + e.getMessage());
            return "";
        }
    }

    public static WifiNetworkInfo getWifiNetworkInfo() {
        WifiNetworkInfo wifiNetworkInfo = new WifiNetworkInfo();
        WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            wifiNetworkInfo.mWifiMac = connectionInfo.getMacAddress();
            wifiNetworkInfo.mWifiSsid = connectionInfo.getSSID();
            wifiNetworkInfo.mWifiBssid = connectionInfo.getBSSID();
        }
        wifiNetworkInfo.mWifiGateway = acquireGateWay(wifiManager);
        return wifiNetworkInfo;
    }

    public static String getAndroidId() {
        return Settings.Secure.getString(getContext().getContentResolver(), "android_id");
    }

    public static String getOaid() {
        return IdentifierManager.isSupported() ? IdentifierManager.getOAID(getContext()) : "";
    }

    public static class AppInfo {
        public String mAppName = "";
        public String mPackage = "";
        public String mSignature = "";
        public String mVersion = "";
        public int mVersionCode = -1;
        public String mVersionName = "";

        public String getVersion() {
            return this.mVersion;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String getVersionName() {
            return this.mVersionName;
        }

        public String getAppName() {
            return this.mAppName;
        }

        public String getPackage() {
            return this.mPackage;
        }

        public String getSignature() {
            return this.mSignature;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084  */
    public static AppInfo getAppInfo() {
        ApplicationInfo applicationInfo;
        AppInfo appInfo = sAppInfo;
        if (appInfo != null) {
            return appInfo;
        }
        AppInfo appInfo2 = new AppInfo();
        sAppInfo = appInfo2;
        appInfo2.mPackage = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        PackageInfo packageInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(sAppInfo.mPackage, NotificationCompat.FLAG_HIGH_PRIORITY);
            try {
                packageInfo = packageManager.getPackageInfo(sAppInfo.mPackage, 64);
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                Log.e("Client", "exception: " + e.toString() + " message: " + e.getMessage());
                sAppInfo.mVersion = applicationInfo.metaData.getString("payment_version");
                Log.d("Client", "old_version:" + sAppInfo.mVersion);
                if (packageInfo != null) {
                }
                return sAppInfo;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            applicationInfo = null;
            Log.e("Client", "exception: " + e.toString() + " message: " + e.getMessage());
            sAppInfo.mVersion = applicationInfo.metaData.getString("payment_version");
            Log.d("Client", "old_version:" + sAppInfo.mVersion);
            if (packageInfo != null) {
            }
            return sAppInfo;
        }
        if (!(applicationInfo == null || applicationInfo.metaData == null)) {
            sAppInfo.mVersion = applicationInfo.metaData.getString("payment_version");
            Log.d("Client", "old_version:" + sAppInfo.mVersion);
        }
        if (packageInfo != null) {
            sAppInfo.mAppName = getContext().getResources().getString(packageInfo.applicationInfo.labelRes);
            sAppInfo.mSignature = Coder.encodeMD5(String.valueOf(packageInfo.signatures[0].toChars()));
            sAppInfo.mVersionName = packageInfo.versionName;
            sAppInfo.mVersionCode = packageInfo.versionCode;
        }
        return sAppInfo;
    }

    public static String getDeviceConfig() {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) getContext().getSystemService("activity")).getDeviceConfigurationInfo();
        return deviceConfigurationInfo != null ? deviceConfigurationInfo.toString() : "";
    }

    public static String getSensorList() {
        ArrayList arrayList = new ArrayList();
        for (Sensor type : ((SensorManager) getContext().getSystemService("sensor")).getSensorList(-1)) {
            arrayList.add(Integer.valueOf(type.getType()));
        }
        return TextUtils.join(",", arrayList);
    }

    public static long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public static long getUpTime() {
        return SystemClock.uptimeMillis();
    }

    public static long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static class CPUInfo {
        public String mCpuHardware = "";
        public String mCpuSerial = "";
        public String mCpuSpeed = "";
        public String mCpuType = "";

        public String getCpuType() {
            return this.mCpuType;
        }

        public String getCpuSpeed() {
            return this.mCpuSpeed;
        }

        public String getCpuHardware() {
            return this.mCpuHardware;
        }

        public String getCpuSerial() {
            return this.mCpuSerial;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        if (r2 != null) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0085 A[SYNTHETIC, Splitter:B:39:0x0085] */
    public static CPUInfo getCPUInfo() {
        BufferedReader bufferedReader;
        IOException e;
        CPUInfo cPUInfo = new CPUInfo();
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!TextUtils.isEmpty(readLine)) {
                            String[] split = readLine.split(":");
                            if (split.length == 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (TextUtils.equals(trim, "Processor")) {
                                    cPUInfo.mCpuType = trim2;
                                } else if (TextUtils.isEmpty(cPUInfo.mCpuSpeed) && TextUtils.equals(trim, "BogoMIPS")) {
                                    cPUInfo.mCpuSpeed = trim2;
                                } else if (TextUtils.equals(trim, "Hardware")) {
                                    cPUInfo.mCpuHardware = trim2;
                                } else if (TextUtils.equals(trim, "Serial")) {
                                    cPUInfo.mCpuSerial = trim2;
                                }
                            }
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.e("Client", "Error when fetch cpu info", e);
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                try {
                    break;
                } catch (IOException unused2) {
                }
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            bufferedReader = null;
            e = iOException;
            Log.e("Client", "Error when fetch cpu info", e);
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
        bufferedReader.close();
        return cPUInfo;
    }

    public static String getXiaomiDeviceToken() {
        ContentProviderClient contentProviderClient = null;
        try {
            ContentProviderClient acquireContentProviderClient = getContext().getContentResolver().acquireContentProviderClient(Uri.parse("content://com.miui.analytics.server.AnalyticsProvider"));
            String innerGetDeviceToken = innerGetDeviceToken(acquireContentProviderClient);
            if (acquireContentProviderClient == null) {
                return innerGetDeviceToken;
            }
            acquireContentProviderClient.release();
            return innerGetDeviceToken;
        } catch (Exception e) {
            Log.e("Client", "Error when get device token", e);
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
            return "";
        } catch (Throwable th) {
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
            throw th;
        }
    }

    private static String innerGetDeviceToken(ContentProviderClient contentProviderClient) throws RemoteException, JSONException {
        Bundle call;
        String string;
        if (contentProviderClient == null || (call = contentProviderClient.call("getDeviceValidationToken", "", new Bundle())) == null || (string = call.getString("device_token_json")) == null) {
            return "";
        }
        return new JSONObject(string).getString("token");
    }
}
