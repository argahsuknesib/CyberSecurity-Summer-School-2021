package com.xiaomi.smarthome.framework.crash;

import _m_j.eyu;
import _m_j.fke;
import _m_j.fur;
import _m_j.gfr;
import _m_j.gox;
import _m_j.gpm;
import _m_j.gsy;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainCrashHandler implements Thread.UncaughtExceptionHandler {
    private static gpm<String> O00000o = new gpm<>(30);
    private static Map<String, String> O00000o0 = new LinkedHashMap();

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f7552O000000o;
    private Thread.UncaughtExceptionHandler O00000Oo = Thread.getDefaultUncaughtExceptionHandler();

    public MainCrashHandler(Context context) {
        this.f7552O000000o = context;
    }

    public static void O000000o(Throwable th) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            Context appContext = CommonApplication.getAppContext();
            String str = "";
            boolean z = false;
            String className = th == null ? str : th.getStackTrace()[0].getClassName();
            if (th != null) {
                str = th.getStackTrace()[0].getMethodName();
            }
            String str2 = str;
            StringBuilder sb = new StringBuilder();
            O000000o(sb);
            if (th instanceof OutOfMemoryError) {
                if (gfr.O0000OOo || gfr.O0000o0o) {
                    z = true;
                }
                sb.append(gox.O000000o(appContext, z));
                sb.append(gox.O000000o());
                gsy.O00000o0(LogType.GENERAL, "pidStatus", sb.toString());
            }
            StringWriter stringWriter2 = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter2));
            sb.append(stringWriter2.toString());
            String sb2 = sb.toString();
            if (sb2.length() > 10000) {
                sb2 = sb2.substring(sb2.length() - C.MSG_CUSTOM_BASE, sb2.length() - 1);
            }
            fur.O000000o().O000000o(appContext, 0, 0, className, str2, sb2, null, 3000);
            gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "MainCrashHandler", obj);
            gsy.O000000o();
        }
    }

    public static void O000000o(String str) {
        O00000o.O000000o(str);
    }

    public static StringBuilder O000000o(StringBuilder sb) {
        sb.append("===activity tracking info start===\n");
        for (String str : O00000o.O000000o()) {
            sb.append(str + "\n");
        }
        sb.append("===activity tracking info end===\n");
        try {
            sb.append("===memory analysis start===\n");
            Runtime runtime = Runtime.getRuntime();
            sb.append("最大可用内存:");
            sb.append(runtime.maxMemory() / 1048576);
            sb.append("M\n");
            sb.append("当前可用内存:");
            sb.append(runtime.totalMemory() / 1048576);
            sb.append("M\n");
            sb.append("当前空闲内存:");
            sb.append(runtime.freeMemory() / 1048576);
            sb.append("M\n");
            sb.append("当前已使用内存:");
            sb.append((runtime.totalMemory() - runtime.freeMemory()) / 1048576);
            sb.append("M\n");
            sb.append("剩余可用内存:");
            sb.append(runtime.maxMemory() - ((runtime.totalMemory() - runtime.freeMemory()) / 1048576));
            sb.append("M\n");
            sb.append("===memory analysis end===\n");
            sb.append("===file descriptor analysis start===\n");
            File file = new File("/proc/self/fd/");
            if (file.exists() && file.listFiles() != null) {
                int length = file.listFiles().length;
                sb.append("file descriptor size:");
                sb.append(length);
                sb.append("\n");
            }
            sb.append("===file descriptor analysis end===\n");
            sb.append("===thread analysis start===\n");
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            sb.append("threadMap:");
            sb.append(allStackTraces.entrySet().size());
            sb.append("\n");
            sb.append("===thread analysis end===\n");
        } catch (Exception e) {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "Exception:", e.getLocalizedMessage());
        }
        return sb;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        long j;
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) CommonApplication.getAppContext().getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
                Map<String, String> map = O00000o0;
                StringBuilder sb = new StringBuilder();
                sb.append(runningTaskInfo.numActivities);
                map.put("t_acti_num", sb.toString());
                O00000o0.put("t_base_acti", runningTaskInfo.baseActivity.getClassName());
                O00000o0.put("t_top_acti", runningTaskInfo.topActivity.getClassName());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        CommonApplication.getGlobalHandler().removeCallbacks(CommonApplication.getApplication().mResetRepeatedCrashRunnable);
        if (th != null) {
            th.printStackTrace();
            XmPluginPackage xmPluginPackage = null;
            PluginHostActivity topPluginHostActivity = PluginHostActivity.getTopPluginHostActivity();
            if (topPluginHostActivity != null) {
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
                PluginCrashHandler.O000000o(th, j2, j);
            } else {
                O000000o(th);
            }
        } else {
            O000000o(th);
        }
        try {
            String message = th.getMessage();
            if (th != null && (th instanceof SecurityException) && !TextUtils.isEmpty(message) && message.equalsIgnoreCase("Permission denied (missing INTERNET permission?)")) {
                Notification.Builder smallIcon = new Notification.Builder(CommonApplication.getAppContext()).setContentTitle("程序运行异常").setContentText("请给米家打开网络权限").setSmallIcon((int) R.drawable.mj_notify_icon);
                NotificationManager notificationManager = (NotificationManager) CommonApplication.getAppContext().getSystemService("notification");
                if (notificationManager != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        smallIcon.setChannelId(fke.O000000o(notificationManager, this.f7552O000000o));
                    }
                    notificationManager.notify(4321, smallIcon.build());
                }
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            eyu.O000000o(CommonApplication.getAppContext(), stringWriter.toString());
        } catch (Exception unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.O00000Oo;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
