package com.payu.custombrowser.util;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.appcompat.app.NotificationCompat;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CBUtil {
    private static SharedPreferences sharedPreferences;

    public static String getSystemCurrentTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getLogMessage(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payu_id", getCookie("PAYUID", context));
            jSONObject.put("txnid", str5);
            jSONObject.put("merchant_key", str4);
            jSONObject.put("page_type", str6);
            jSONObject.put("event_key", str);
            jSONObject.put("event_value", URLEncoder.encode(str2, "UTF-8"));
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("bank", str3);
            jSONObject.put("package_name", context.getPackageName());
            jSONObject.put("ts", getSystemCurrentTime());
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static String decodeContents(FileInputStream fileInputStream) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            try {
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
                if (i % 2 == 0) {
                    sb.append((char) (read - ((i % 5) + 1)));
                } else {
                    sb.append((char) (read + (i % 5) + 1));
                }
                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileInputStream.close();
        return sb.toString();
    }

    public static void setAlpha(float f, View view) {
        if (Build.VERSION.SDK_INT < 11) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
            alphaAnimation.setDuration(10);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
            return;
        }
        view.setAlpha(f);
    }

    public static String updateLastUrl(String str) {
        try {
            if (!str.contains("||")) {
                return str.length() > 128 ? str.substring(0, 127) : str;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, "||");
            String nextToken = stringTokenizer.nextToken();
            String nextToken2 = stringTokenizer.nextToken();
            if (nextToken.length() > 128) {
                nextToken = nextToken.substring(0, 125);
            }
            if (nextToken2.length() > 128) {
                nextToken2 = nextToken2.substring(0, 125);
            }
            return nextToken + "||" + nextToken2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setVariableReflection(String str, String str2, String str3) {
        if (str2 != null) {
            try {
                if (!str2.trim().equals("")) {
                    Field declaredField = Class.forName(str).getDeclaredField(str3);
                    declaredField.setAccessible(true);
                    declaredField.set(null, str2);
                    declaredField.setAccessible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String filterSMS(JSONObject jSONObject, String str, Context context) {
        if (str == null) {
            return null;
        }
        try {
            if (!Pattern.compile(jSONObject.getString(context.getString(R.string.cb_detect_otp)), 2).matcher(str).find()) {
                return null;
            }
            Matcher matcher = Pattern.compile(jSONObject.getString(context.getString(R.string.cb_find_otp)), 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(1).replaceAll("[^0-9]", "");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HttpURLConnection getHttpsConn(String str, String str2) {
        try {
            return getHttpsConn(str, str2, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HttpURLConnection getHttpsConn(String str, String str2, int i, String str3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            if (i != -1) {
                httpURLConnection.setConnectTimeout(i);
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (str2 != null) {
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.length()));
            }
            if (str3 != null) {
                httpURLConnection.setRequestProperty("Cookie", str3);
            }
            httpURLConnection.setDoOutput(true);
            if (str2 != null) {
                httpURLConnection.getOutputStream().write(str2.getBytes());
            }
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HttpURLConnection getHttpsConn(String str, String str2, int i) {
        return getHttpsConn(str, str2, i, null);
    }

    public static HttpURLConnection getHttpsConn(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static StringBuffer getStringBufferFromInputStream(InputStream inputStream) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return stringBuffer;
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static List<String> updateRetryData(String str, Context context) {
        setRetryData(str, context);
        return processAndAddWhiteListedUrls(str);
    }

    private static void setRetryData(String str, Context context) {
        if (str == null) {
            SharedPreferenceUtil.addStringToSharedPreference(context, "RETRY_SETTINGS", "RETRY_WHITELISTED_URLS", "");
        } else {
            SharedPreferenceUtil.addStringToSharedPreference(context, "RETRY_SETTINGS", "RETRY_WHITELISTED_URLS", str);
        }
        L.v("#### PAYU", "DATA UPDATED IN SHARED PREFERENCES");
    }

    public void clearCookie() {
        CookieManager instance = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            instance.removeSessionCookies(null);
        } else {
            instance.removeSessionCookie();
        }
    }

    public static List<String> processAndAddWhiteListedUrls(String str) {
        if (str != null && !str.equalsIgnoreCase("")) {
            String[] split = str.split("\\|");
            for (String valueOf : split) {
                L.v("#### PAYU", "Split Url: ".concat(String.valueOf(valueOf)));
            }
            if (split != null && split.length > 0) {
                return Arrays.asList(split);
            }
            L.v("#### PAYU", "Whitelisted URLs from JS: ".concat(String.valueOf(str)));
        }
        return new ArrayList();
    }

    public boolean getBooleanSharedPreference(String str, Context context) {
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0);
        sharedPreferences = sharedPreferences2;
        return sharedPreferences2.getBoolean(str, false);
    }

    public boolean getBooleanSharedPreferenceDefaultTrue(String str, Context context) {
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0);
        sharedPreferences = sharedPreferences2;
        return sharedPreferences2.getBoolean(str, true);
    }

    public void setBooleanSharedPreference(String str, boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public String getDeviceDensity(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        StringBuilder sb = new StringBuilder();
        sb.append(displayMetrics.densityDpi);
        return sb.toString();
    }

    private void getDownloadSpeed() {
        String[] strArr = new String[2];
        long currentTimeMillis = System.currentTimeMillis();
        long totalTxBytes = TrafficStats.getTotalTxBytes();
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        long totalTxBytes2 = TrafficStats.getTotalTxBytes();
        long totalRxBytes2 = TrafficStats.getTotalRxBytes();
        double currentTimeMillis2 = (double) (System.currentTimeMillis() - currentTimeMillis);
        double d = (double) (totalRxBytes2 - totalRxBytes);
        double d2 = (double) (totalTxBytes2 - totalTxBytes);
        if (d == 0.0d || d2 == 0.0d) {
            strArr[0] = "No uploaded or downloaded bytes.";
            return;
        }
        Double.isNaN(currentTimeMillis2);
        double d3 = currentTimeMillis2 / 1000.0d;
        Double.isNaN(d);
        Double.isNaN(d2);
        strArr[0] = String.valueOf(d / d3) + "bps. Total rx = " + d;
        strArr[1] = String.valueOf(d2 / d3) + "bps. Total tx = " + d2;
    }

    public String getNetworkStatus(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "Not connected";
                }
                if (!activeNetworkInfo.isConnected()) {
                    return "Not connected";
                }
                if (activeNetworkInfo.getType() == 1) {
                    return "WIFI";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                            return "GPRS";
                        case 2:
                            return "EDGE";
                        case 3:
                        case 5:
                        case 6:
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        case 9:
                        case 10:
                            return "HSPA";
                        case 4:
                            return "CDMA";
                        case 7:
                        case 11:
                            return "2G";
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        case 14:
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "?";
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "?";
    }

    public NetworkInfo getNetWorkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        NetworkInfo networkInfo = null;
        if (Build.VERSION.SDK_INT >= 21) {
            Network[] allNetworks = connectivityManager.getAllNetworks();
            int length = allNetworks.length;
            while (i < length) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(allNetworks[i]);
                if (networkInfo2.getState().equals(NetworkInfo.State.CONNECTED)) {
                    networkInfo = networkInfo2;
                }
                i++;
            }
        } else {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                int length2 = allNetworkInfo.length;
                while (i < length2) {
                    NetworkInfo networkInfo3 = allNetworkInfo[i];
                    if (networkInfo3.getState() == NetworkInfo.State.CONNECTED) {
                        networkInfo = networkInfo3;
                    }
                    i++;
                }
            }
        }
        return networkInfo;
    }

    public int getNetworkStrength(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo != null) {
            if (netWorkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return getMobileStrength(context, netWorkInfo);
            }
            if (netWorkInfo.getTypeName().equalsIgnoreCase("wifi") && hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private int getMobileStrength(Context context, NetworkInfo networkInfo) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 18) {
                return 0;
            }
            int i = 0;
            for (CellInfo next : telephonyManager.getAllCellInfo()) {
                if (next.isRegistered()) {
                    if (next instanceof CellInfoGsm) {
                        i = ((CellInfoGsm) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoCdma) {
                        i = ((CellInfoCdma) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoLte) {
                        i = ((CellInfoLte) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoWcdma) {
                        i = ((CellInfoWcdma) next).getCellSignalStrength().getDbm();
                    }
                }
            }
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void setStringSharedPreferenceLastURL(Context context, String str, String str2) {
        String stringSharedPreference = getStringSharedPreference(context, str);
        if (!stringSharedPreference.equalsIgnoreCase("")) {
            if (!stringSharedPreference.contains("||")) {
                str2 = stringSharedPreference + "||" + str2;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(stringSharedPreference, "||");
                stringTokenizer.nextToken();
                str2 = stringTokenizer.nextToken() + "||" + str2;
            }
        }
        storeInSharedPreferences(context, str, str2);
    }

    public String getStringSharedPreference(Context context, String str) {
        return context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0).getString(str, "");
    }

    public void setStringSharedPreference(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public void deleteSharedPrefKey(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0).edit();
            edit.remove(str);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeInSharedPreferences(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void removeFromSharedPreferences(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.payu.custombrowser.payucustombrowser", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public Drawable getDrawableCB(Context context, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return context.getResources().getDrawable(i);
        }
        return context.getResources().getDrawable(i, context.getTheme());
    }

    public void cancelTimer(Timer timer) {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public String readFileInputStream(Context context, String str, int i) {
        String str2 = "";
        try {
            if (!new File(context.getFilesDir(), str).exists()) {
                context.openFileOutput(str, i);
            }
            FileInputStream openFileInput = context.openFileInput(str);
            while (true) {
                int read = openFileInput.read();
                if (read == -1) {
                    break;
                }
                str2 = str2 + Character.toString((char) read);
            }
            openFileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return str2;
    }

    public void writeFileOutputStream(InputStream inputStream, Context context, String str, int i) {
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
            byte[] bArr = new byte[1024];
            FileOutputStream openFileOutput = context.openFileOutput(str, i);
            while (true) {
                int read = gZIPInputStream.read(bArr);
                if (read > 0) {
                    openFileOutput.write(bArr, 0, read);
                } else {
                    gZIPInputStream.close();
                    openFileOutput.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resetPayuID() {
        clearCookie();
    }

    public String getCookieList(Context context, String str) {
        String str2 = "";
        try {
            CookieManager instance = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
                CookieSyncManager.getInstance().sync();
            }
            String cookie = instance.getCookie(str);
            if (cookie != null) {
                String[] split = cookie.split(";");
                int length = split.length;
                String str3 = str2;
                int i = 0;
                while (i < length) {
                    try {
                        String[] split2 = split[i].split("=");
                        str3 = str3 + split2[0] + "=" + split2[1] + ";";
                        i++;
                    } catch (Exception e) {
                        e = e;
                        str2 = str3;
                        e.printStackTrace();
                        return str2;
                    }
                }
                str2 = str3;
            }
            if (str2.length() > 0) {
                return str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str2;
        }
    }

    public String getCookie(String str, Context context) {
        String str2 = "";
        try {
            CookieManager instance = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
                CookieSyncManager.getInstance().sync();
            }
            String cookie = instance.getCookie("https://secure.payu.in");
            if (cookie != null) {
                for (String str3 : cookie.split(";")) {
                    if (str3.contains(str)) {
                        str2 = str3.split("=")[1];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    @Deprecated
    public String getDataFromPostData(String str, String str2) {
        for (String split : str.split("&")) {
            String[] split2 = split.split("=");
            if (split2.length >= 2 && split2[0].equalsIgnoreCase(str2)) {
                return split2[1];
            }
        }
        return "";
    }

    public HashMap<String, String> getDataFromPostData(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String[] split = stringTokenizer.nextToken().split("=");
                if (!(split == null || split.length <= 0 || split[0] == null)) {
                    hashMap.put(split[0], split.length > 1 ? split[1] : "");
                }
            }
        }
        return hashMap;
    }

    public void showNotification(Context context, Intent intent, String str, String str2, int i, boolean z, NotificationCompat.O00000o o00000o, int i2, int i3) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationCompat.Builder O000000o2 = builder.setContentTitle(str).O00000Oo(str2).O000000o(i);
        O000000o2.O0000Ooo = 1;
        O000000o2.O00000Oo(2);
        if (z) {
            builder.setAutoCancel(z);
        }
        if (o00000o != null) {
            builder.setStyle(o00000o);
        }
        if (i2 != -1) {
            builder.setColor(i2);
        }
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728));
        ((NotificationManager) context.getSystemService("notification")).notify(i3, builder.build());
    }

    public SnoozeConfigMap storeSnoozeConfigInSharedPref(Context context, String str) {
        SnoozeConfigMap snoozeConfigMap = new SnoozeConfigMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            SharedPreferenceUtil.removeAllFromSharedPref(context, "com.payu.custombrowser.snoozepref");
            SnoozeConfigMap storeSnoozeConfigInSharedPref = storeSnoozeConfigInSharedPref(context, jSONObject.getJSONArray("default"), snoozeConfigMap);
            jSONObject.remove("default");
            Iterator<String> keys = jSONObject.keys();
            if (keys.hasNext()) {
                return storeSnoozeConfigInSharedPref(context, jSONObject.getJSONArray(keys.next()), storeSnoozeConfigInSharedPref);
            }
            return storeSnoozeConfigInSharedPref;
        } catch (JSONException e) {
            e.printStackTrace();
            return snoozeConfigMap;
        }
    }

    private SnoozeConfigMap storeSnoozeConfigInSharedPref(Context context, JSONArray jSONArray, SnoozeConfigMap snoozeConfigMap) {
        String str;
        String str2;
        SnoozeConfigMap snoozeConfigMap2 = snoozeConfigMap;
        String str3 = "disable_sp_for";
        try {
            int length = jSONArray.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String obj = jSONObject.get("url").toString();
                String obj2 = jSONObject.get("progress_percent").toString();
                String obj3 = jSONObject.get("time_out").toString();
                if (jSONObject.has(str3)) {
                    try {
                        i = getSurePayEnableMode(jSONObject.getJSONObject(str3));
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        return snoozeConfigMap2;
                    }
                }
                StringTokenizer stringTokenizer = new StringTokenizer(obj, "||");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.contentEquals("*")) {
                        str = "*";
                    } else {
                        str = nextToken.trim();
                    }
                    StringBuilder sb = new StringBuilder();
                    String str4 = str3;
                    sb.append(obj2.trim());
                    sb.append("||");
                    sb.append(obj3.trim());
                    sb.append("||");
                    sb.append(i);
                    SharedPreferenceUtil.addStringToSharedPreference(context, "com.payu.custombrowser.snoozepref", str, sb.toString());
                    if (nextToken.contentEquals("*")) {
                        str2 = "*";
                    } else {
                        str2 = nextToken.trim();
                    }
                    snoozeConfigMap2.put(str2, obj2.trim() + "||" + obj3.trim() + "||" + i);
                    str3 = str4;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return snoozeConfigMap2;
        }
        return snoozeConfigMap2;
    }

    public SnoozeConfigMap convertToSnoozeConfigMap(Map<String, ?> map) {
        SnoozeConfigMap snoozeConfigMap = new SnoozeConfigMap();
        for (Map.Entry next : map.entrySet()) {
            snoozeConfigMap.put(next.getKey(), next.getValue());
        }
        return snoozeConfigMap;
    }

    public Set<String> getSurePayErrorCodes() {
        HashSet hashSet = new HashSet();
        hashSet.add("-7");
        hashSet.add("-8");
        hashSet.add("-15");
        return hashSet;
    }

    private int getSurePayEnableMode(JSONObject jSONObject) {
        try {
            if (jSONObject.has("warn")) {
                if (jSONObject.getBoolean("warn") && jSONObject.has("fail") && jSONObject.getBoolean("fail")) {
                    return 3;
                }
            }
            if (jSONObject.has("fail") && jSONObject.getBoolean("fail")) {
                return 2;
            }
            if (!jSONObject.has("warn") || !jSONObject.getBoolean("warn")) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getSurePayDisableStatus(SnoozeConfigMap snoozeConfigMap, String str) {
        if (snoozeConfigMap == null || str == null) {
            return 0;
        }
        for (Object next : snoozeConfigMap.keySet()) {
            if (str.startsWith(next.toString())) {
                return snoozeConfigMap.getPercentageAndTimeout(next.toString())[2];
            }
        }
        return snoozeConfigMap.getPercentageAndTimeout("*")[2];
    }

    public String getValueOfJSONKey(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(str2)) {
            return jSONObject.get(str2).toString();
        }
        throw new JSONException("Key not found");
    }
}
