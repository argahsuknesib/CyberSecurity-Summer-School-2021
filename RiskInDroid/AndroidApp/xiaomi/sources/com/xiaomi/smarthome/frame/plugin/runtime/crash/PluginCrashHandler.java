package com.xiaomi.smarthome.frame.plugin.runtime.crash;

import _m_j.fsp;
import _m_j.fsr;
import _m_j.ftc;
import _m_j.ftm;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;

public class PluginCrashHandler implements Thread.UncaughtExceptionHandler {
    private Context mAppContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

    public PluginCrashHandler(Context context) {
        this.mAppContext = context;
    }

    public static void handlePluginException(Throwable th, long j, long j2) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            if (obj.length() > 5000) {
                obj = obj.substring(0, 5000);
            }
            sendCrashLogInternal(fsp.O000000o().O00000Oo, th, j, j2);
            gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "PluginCrashRuntime", obj);
            gsy.O000000o();
        }
    }

    private static void sendCrashLogInternal(Context context, Throwable th, long j, long j2) {
        String str;
        String str2;
        Throwable th2 = th;
        if (th2 != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                str2 = "";
                str = str2;
            } else {
                String className = stackTrace[0].getClassName();
                str = stackTrace[0].getMethodName();
                str2 = className;
            }
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String str3 = "===plugin crash===\npluginId=" + j + "\npkgId=" + j2 + "\n";
            try {
                str3 = str3 + "userId=" + CoreApi.O000000o().O0000o0() + "\n";
            } catch (Exception unused) {
            }
            String str4 = str3 + stringWriter.toString();
            if (str4.length() > 5000) {
                str4 = str4.substring(0, 5000);
            }
            String str5 = str4;
            String O00000o0 = ftm.O00000o0(context);
            if (!TextUtils.isEmpty(O00000o0) && O00000o0.startsWith("com.xiaomi.smarthome:")) {
                O00000o0 = O00000o0.replace("com.xiaomi.smarthome:", "");
            }
            ftc.O000000o().O000000o(context, str2, str, str5, O00000o0, fsr.O0000Oo, j, j2);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        XmPluginPackage xmPluginPackage;
        long j;
        PluginHostActivity topPluginHostActivity;
        if (th != null) {
            th.printStackTrace();
            try {
                StackTraceElement[] stackTrace = th.getStackTrace();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                int length = stackTrace.length;
                while (i < length && i < 6) {
                    arrayList.add(stackTrace[i].getClassName());
                    i++;
                }
                xmPluginPackage = PluginRuntimeManager.getInstance().getXmPluginPackageByCrashClassName(arrayList);
            } catch (Exception unused) {
                xmPluginPackage = null;
            }
            if (xmPluginPackage == null && (topPluginHostActivity = PluginHostActivity.getTopPluginHostActivity()) != null) {
                xmPluginPackage = topPluginHostActivity.getXmPluginPackage();
            }
            if (xmPluginPackage != null) {
                long j2 = 0;
                if (xmPluginPackage != null) {
                    j2 = xmPluginPackage.getPluginId();
                    j = xmPluginPackage.getPackageId();
                } else {
                    j = 0;
                }
                handlePluginException(th, j2, j);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
