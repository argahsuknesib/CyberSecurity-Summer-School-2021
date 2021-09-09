package com.mi.multimonitor;

import android.text.TextUtils;
import com.mi.multimonitor.CrashReportBean;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonMaker {
    private static String APP_DATA = "APP_DATA";
    private static String APP_ID = "APP_ID";
    private static String APP_VERSION_NAME = "APP_VERSION_NAME";
    private static String APP_VERSION_NAME_TRUE = "APP_VERSION_NAME_TRUE";
    private static String AVAILABLE_MEM_SIZE = "AVAILABLE_MEM_SIZE";
    private static String DEVICE = "DEVICE";
    private static String DISPLAY = "DISPLAY";
    private static String EXCEPTION_TAG = "EXCEPTION_TAG";
    private static String INSTALLATION_ID = "INSTALLATION_ID";
    private static String LAST_INSTALL_TIME = "LAST_INSTALL_TIME";
    private static String OS = "OS";
    private static String OS_VERSION = "OS_VERSION";
    private static String PACKAGE_NAME = "PACKAGE_NAME";
    private static String SIGNATURE = "SIGNATURE";
    private static String STACK_TRACE = "STACK_TRACE";
    private static String TOTAL_MEM_SIZE = "TOTAL_MEM_SIZE";
    private static String UPTIME = "UPTIME";
    private static String USER_CRASH_TIME = "USER_CRASH_TIME";
    private static String USER_ID = "USER_ID";
    private static String USER_IP = "USER_IP";
    private static String height = "height";
    private static String width = "width";

    public static JSONObject json(CrashReportBean crashReportBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SIGNATURE, crashReportBean.mExceptionSignature);
            jSONObject.put(STACK_TRACE, makeStackArray(crashReportBean.mStackTraces));
            jSONObject.put(UPTIME, crashReportBean.mCrashReportTime);
            jSONObject.put(LAST_INSTALL_TIME, crashReportBean.mAppLastModifyTime);
            jSONObject.put(USER_CRASH_TIME, crashReportBean.mCrashOccurredTime);
            jSONObject.put(USER_ID, "");
            jSONObject.put(INSTALLATION_ID, crashReportBean.mAppSignature);
            jSONObject.put(PACKAGE_NAME, crashReportBean.mPackageName);
            jSONObject.put(APP_VERSION_NAME, crashReportBean.mAppVersion);
            jSONObject.put(APP_ID, crashReportBean.mAppId);
            jSONObject.put(USER_IP, crashReportBean.mUserIp);
            jSONObject.put(OS_VERSION, crashReportBean.mOsVersion);
            jSONObject.put(APP_DATA, "");
            jSONObject.put(TOTAL_MEM_SIZE, crashReportBean.mTotalMemory);
            jSONObject.put(AVAILABLE_MEM_SIZE, crashReportBean.mAvailableMemory);
            jSONObject.put(DEVICE, crashReportBean.mDeviceName);
            jSONObject.put(OS, crashReportBean.mOsName);
            jSONObject.put(DISPLAY, makeDisplayJson(crashReportBean.mDisplay));
            jSONObject.put(APP_VERSION_NAME_TRUE, crashReportBean.mVersionNameTrue);
            if (!TextUtils.isEmpty(crashReportBean.tag)) {
                jSONObject.put(EXCEPTION_TAG, crashReportBean.tag);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject makeDisplayJson(CrashReportBean.Display display) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(width, display.width);
        jSONObject.put(height, display.height);
        return jSONObject;
    }

    private static JSONArray makeStackArray(ArrayList<String> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }
}
