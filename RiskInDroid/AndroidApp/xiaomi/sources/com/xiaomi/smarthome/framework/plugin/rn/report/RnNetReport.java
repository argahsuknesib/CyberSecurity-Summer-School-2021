package com.xiaomi.smarthome.framework.plugin.rn.report;

import _m_j.fwz;
import _m_j.gat;
import _m_j.gbj;
import _m_j.gku;
import _m_j.gow;
import _m_j.gpv;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.react.modules.network.NetRequestReporter;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.pluginhook.config.DNSHookConfigManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONArray;

public class RnNetReport implements NetRequestReporter {
    public void reportNetRequest(String str) {
        reportRequest("js_fetch", str);
    }

    public static void reportWebViewURL(String str) {
        reportRequest("rn_webview", str);
    }

    public static boolean isInWhiteListHost(String str) {
        String hostOfUrl = getHostOfUrl(str);
        return DNSHookConfigManager.getInstance().isInWhiteList(hostOfUrl) || DNSHookConfigManager.getInstance().isNumericHost(hostOfUrl);
    }

    public static String getInterceptHtmlStr(Context context) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(context.getResources().getAssets().open("html/redirect.html"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    gow.O000000o(bufferedReader2, inputStreamReader);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    gow.O000000o(bufferedReader2, inputStreamReader);
                    throw th;
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append("\r\n");
                    } else {
                        String sb2 = sb.toString();
                        gow.O000000o(bufferedReader, inputStreamReader);
                        return sb2;
                    }
                }
            } catch (IOException e2) {
                IOException iOException = e2;
                bufferedReader2 = bufferedReader;
                e = iOException;
                e.printStackTrace();
                gow.O000000o(bufferedReader2, inputStreamReader);
                return "";
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedReader2 = bufferedReader;
                th = th3;
                gow.O000000o(bufferedReader2, inputStreamReader);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamReader = null;
            e.printStackTrace();
            gow.O000000o(bufferedReader2, inputStreamReader);
            return "";
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            gow.O000000o(bufferedReader2, inputStreamReader);
            throw th;
        }
    }

    public static boolean allowSetFileAccess() {
        return !((Boolean) gat.O000000o("webview_file_access_enable", Boolean.FALSE)).booleanValue() || gbj.O000000o((JSONArray) gat.O000000o("webview_access_allow_model", null), fwz.O000000o().O00000Oo().O0000o00.model);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, long):void
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String, boolean):void
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public static boolean isDarkMode() {
        if (!gpv.O000000o(CommonApplication.getAppContext(), "lab_rn_plugin_darkmode", false) || !gku.O000000o(CommonApplication.getAppContext())) {
            return false;
        }
        return true;
    }

    public static void reportWebPageURL(String str) {
        reportRequest("open_webpage", str);
    }

    public static void reportUploadFileURL(String str) {
        reportRequest("upload_file", str);
    }

    public static void reportDownloadFileURL(String str) {
        reportRequest("download_file", str);
    }

    public static void reportRequest(String str, String str2) {
        long j;
        String hostOfUrl = getHostOfUrl(str2);
        boolean isInvalidHost = isInvalidHost(hostOfUrl);
        StringBuilder sb = new StringBuilder("catch host: ");
        sb.append(hostOfUrl);
        sb.append(" isReport=");
        sb.append(!isInvalidHost);
        sb.append(" action=");
        sb.append(str);
        gsy.O000000o(4, "NetRequestReport", sb.toString());
        if (!isInvalidHost) {
            PluginPackageInfo pluginPackageInfo = fwz.O000000o().O00000Oo().O0000OoO;
            DeviceStat deviceStat = fwz.O000000o().O00000Oo().O0000o00;
            String str3 = deviceStat != null ? deviceStat.model : "";
            long j2 = 0;
            if (pluginPackageInfo != null) {
                long O00000Oo = pluginPackageInfo.O00000Oo();
                j2 = pluginPackageInfo.O000000o();
                j = O00000Oo;
            } else {
                j = 0;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("plugin_id", Long.valueOf(j2));
            hashMap.put("package_id", Long.valueOf(j));
            hashMap.put("device_model", str3);
            hashMap.put("request", hostOfUrl);
            hashMap.put("tip", "6.7.0.1.4466");
            hashMap.put("action", str);
            PluginHostApi.instance().statReport("rn_plugin_framework", "plugin_fetch_request", hashMap);
        }
    }

    private static boolean isInvalidHost(String str) {
        return TextUtils.isEmpty(str) || DNSHookConfigManager.getInstance().isInWhiteList(str) || DNSHookConfigManager.getInstance().isNumericHost(str);
    }

    private static String getHostOfUrl(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }
}
