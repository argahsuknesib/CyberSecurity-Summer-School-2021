package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.safedata.hook.HookBean;
import com.xiaomi.safedata.util.SafeHolder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

public class eud {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15819O000000o = "eud";

    public static JSONObject O000000o(Context context, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        euh.O000000o(f15819O000000o, "Hook is start");
        HookBean hookBean = new HookBean();
        HookBean.XposedBean xposedBean = new HookBean.XposedBean();
        HookBean.SubstrateBean substrateBean = new HookBean.SubstrateBean();
        HookBean.FridaBean fridaBean = new HookBean.FridaBean();
        boolean z8 = true;
        if (z) {
            try {
                context.getApplicationContext().getPackageManager();
                for (ApplicationInfo applicationInfo : new ArrayList()) {
                    if ("de.robv.android.xposed.installer".equals(applicationInfo.packageName) || "io.va.exposed".equals(applicationInfo.packageName)) {
                        xposedBean.checkXposedPackage = true;
                    }
                    if ("com.saurik.substrate".equals(applicationInfo.packageName)) {
                        substrateBean.checkSubstratePackage = true;
                    }
                }
            } catch (Exception e) {
                euh.O00000Oo(f15819O000000o, e.toString());
            }
        }
        O000000o(xposedBean, substrateBean);
        O000000o(xposedBean, substrateBean, fridaBean);
        fridaBean.checkRunningProcesses = O000000o(context);
        xposedBean.checkClassLoader = O000000o();
        xposedBean.checkNativeMethod = O00000Oo();
        xposedBean.checkSystem = System.getProperty("vxp") != null;
        String O000000o2 = eug.O000000o("ls /system/lib");
        if (TextUtils.isEmpty(O000000o2)) {
            z6 = false;
        } else {
            z6 = O000000o2.contains("xposed");
        }
        xposedBean.checkExecLib = z6;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append("/checkman ");
        sb.append(Process.myPid());
        xposedBean.checkCheckman = !TextUtils.isEmpty(eug.O000000o(sb.toString()));
        String str = System.getenv("CLASSPATH");
        if (TextUtils.isEmpty(str)) {
            z7 = false;
        } else {
            z7 = str.contains("XposedBridge");
        }
        xposedBean.checkXposedBridge = z7;
        if (!z) {
            z3 = SafeHolder.checkSubstrateBySo() == 1;
            euh.O000000o(f15819O000000o, "Native checkSubstrateBySo value:".concat(String.valueOf(z3)));
            String checkHookByMap = SafeHolder.checkHookByMap();
            euh.O000000o(f15819O000000o, "Native checkHookByMap value:".concat(String.valueOf(checkHookByMap)));
            String checkHookByPackage = SafeHolder.checkHookByPackage();
            euh.O000000o(f15819O000000o, "Native checkHookByPackage value:".concat(String.valueOf(checkHookByPackage)));
            if (!TextUtils.isEmpty(checkHookByMap)) {
                z5 = checkHookByMap.contains("xposed");
                z4 = checkHookByMap.contains("frida");
                z2 = checkHookByMap.contains("substrate");
            } else {
                z2 = false;
                z5 = false;
                z4 = false;
            }
            if (!TextUtils.isEmpty(checkHookByPackage)) {
                if (checkHookByPackage.contains("xposed")) {
                    z5 = true;
                }
                if (checkHookByPackage.contains("substrate")) {
                    z2 = true;
                }
            }
        } else {
            z3 = false;
            z2 = false;
            z5 = false;
            z4 = false;
        }
        hookBean.isHaveXposed = xposedBean.checkXposedPackage || xposedBean.checkXposedHookMethod || xposedBean.checkXposedJars || xposedBean.checkClassLoader || xposedBean.checkNativeMethod || xposedBean.checkSystem || xposedBean.checkExecLib || xposedBean.checkCheckman || xposedBean.checkXposedBridge || z5;
        hookBean.isHaveSubstrate = substrateBean.checkSubstratePackage || substrateBean.checkSubstrateHookMethod || substrateBean.checkSubstrateJars || z3 || z2;
        if (!fridaBean.checkRunningProcesses && !fridaBean.checkFridaJars && !z4) {
            z8 = false;
        }
        hookBean.isHaveFrida = z8;
        return hookBean.O000000o();
    }

    private static boolean O000000o(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(300);
        if (runningServices == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).process.contains("fridaserver")) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        java.lang.ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XC_MethodHook");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000b */
    private static boolean O000000o() {
        ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedHelpers");
        return true;
    }

    private static boolean O00000Oo() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    private static void O000000o(HookBean.XposedBean xposedBean, HookBean.SubstrateBean substrateBean) {
        try {
            throw new Exception("Mob hook");
        } catch (Exception e) {
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName()) && (i = i + 1) == 2) {
                    substrateBean.checkSubstrateHookMethod = true;
                }
                if ("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoked".equals(stackTraceElement.getMethodName())) {
                    substrateBean.checkSubstrateHookMethod = true;
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) {
                    xposedBean.checkXposedHookMethod = true;
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())) {
                    xposedBean.checkXposedHookMethod = true;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c A[SYNTHETIC, Splitter:B:32:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092 A[SYNTHETIC, Splitter:B:38:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    private static void O000000o(HookBean.XposedBean xposedBean, HookBean.SubstrateBean substrateBean, HookBean.FridaBean fridaBean) {
        BufferedReader bufferedReader;
        HashSet<String> hashSet = new HashSet<>();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.toLowerCase().contains("frida")) {
                        fridaBean.checkFridaJars = true;
                    }
                    if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            for (String str : hashSet) {
                if (str.contains("com.saurik.substrate")) {
                    substrateBean.checkSubstrateJars = true;
                }
                if (str.contains("XposedBridge.jar")) {
                    xposedBean.checkXposedJars = true;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
        } catch (Exception unused3) {
            if (bufferedReader2 == null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }
}
