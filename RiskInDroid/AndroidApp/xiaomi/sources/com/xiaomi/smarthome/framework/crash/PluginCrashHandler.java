package com.xiaomi.smarthome.framework.crash;

import _m_j.fur;
import _m_j.gsy;
import android.content.Context;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;

public class PluginCrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f7553O000000o;
    private Thread.UncaughtExceptionHandler O00000Oo = Thread.getDefaultUncaughtExceptionHandler();

    public PluginCrashHandler(Context context) {
        this.f7553O000000o = context;
    }

    public static void O000000o(Throwable th, long j, long j2) {
        String str;
        String str2;
        Throwable th2 = th;
        if (th2 != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            Context appContext = CommonApplication.getAppContext();
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
                StringWriter stringWriter2 = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter2));
                String str3 = "===plugin crash===\npluginId=" + j + "\npkgId=" + j2 + "\n";
                try {
                    str3 = str3 + "userId=" + CoreApi.O000000o().O0000o0() + "\n";
                } catch (Exception unused) {
                }
                String str4 = str3 + stringWriter2.toString();
                if (str4.length() > 5000) {
                    str4 = str4.substring(0, 5000);
                }
                fur.O000000o().O000000o(appContext, j, j2, str2, str, str4, null, -1);
            }
            gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "PluginCrashHandler", obj);
            gsy.O000000o();
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
            long j2 = 0;
            if (xmPluginPackage != null) {
                if (xmPluginPackage != null) {
                    j2 = xmPluginPackage.getPluginId();
                    j = xmPluginPackage.getPackageId();
                } else {
                    j = 0;
                }
                O000000o(th, j2, j);
            } else {
                O000000o(th, 0, 0);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.O00000Oo;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
