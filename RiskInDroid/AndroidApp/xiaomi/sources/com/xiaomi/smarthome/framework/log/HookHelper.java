package com.xiaomi.smarthome.framework.log;

import _m_j.ftn;
import _m_j.fuz;
import _m_j.fva;
import _m_j.gfr;
import _m_j.grr;
import _m_j.gsa;
import _m_j.gsy;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Keep
public final class HookHelper {
    private static long lastReportTime;

    public static void hookPackageManager(Context context) {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            fva.O000000o(cls);
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            fva.O000000o(declaredMethod);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("sPackageManager");
            fva.O000000o(declaredField);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            fva.O000000o(obj);
            Class<?> cls2 = Class.forName("android.content.pm.IPackageManager");
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new O0000o0(obj));
            fva.O000000o(newProxyInstance);
            declaredField.set(invoke, newProxyInstance);
            PackageManager packageManager = context.getPackageManager();
            fva.O000000o(packageManager);
            Field declaredField2 = packageManager.getClass().getDeclaredField("mPM");
            fva.O000000o(declaredField2);
            declaredField2.setAccessible(true);
            declaredField2.set(packageManager, newProxyInstance);
        } catch (Exception unused) {
        }
    }

    public static void hookTelephonyManager() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            fva.O000000o(cls);
            Method declaredMethod = cls.getDeclaredMethod("getService", String.class);
            fva.O000000o(declaredMethod);
            IBinder iBinder = (IBinder) declaredMethod.invoke(null, "phone");
            fva.O000000o(iBinder);
            IBinder iBinder2 = (IBinder) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IBinder.class}, new O0000o00(iBinder));
            fva.O000000o(iBinder2);
            Field declaredField = cls.getDeclaredField("sCache");
            fva.O000000o(declaredField);
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put("phone", iBinder2);
        } catch (Exception unused) {
        }
    }

    public static void hookSubscriptionManager() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            fva.O000000o(cls);
            Method declaredMethod = cls.getDeclaredMethod("getService", String.class);
            fva.O000000o(declaredMethod);
            IBinder iBinder = (IBinder) declaredMethod.invoke(null, "isub");
            fva.O000000o(iBinder);
            IBinder iBinder2 = (IBinder) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IBinder.class}, new O0000Oo0(iBinder));
            fva.O000000o(iBinder2);
            Field declaredField = cls.getDeclaredField("sCache");
            fva.O000000o(declaredField);
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put("isub", iBinder2);
        } catch (Exception unused) {
        }
    }

    public static void hookLocationManager() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            fva.O000000o(cls);
            Method declaredMethod = cls.getDeclaredMethod("getService", String.class);
            fva.O000000o(declaredMethod);
            IBinder iBinder = (IBinder) declaredMethod.invoke(null, "location");
            fva.O000000o(iBinder);
            ClassLoader classLoader = iBinder.getClass().getClassLoader();
            fva.O000000o(classLoader);
            IBinder iBinder2 = (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, new O0000O0o(iBinder));
            fva.O000000o(iBinder2);
            Field declaredField = cls.getDeclaredField("sCache");
            fva.O000000o(declaredField);
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put("location", iBinder2);
            declaredField.setAccessible(false);
        } catch (Exception unused) {
        }
    }

    public static void hookClipboardManager() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            Class[] clsArr = {IBinder.class};
            Field declaredField = cls.getDeclaredField("sCache");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(null);
            map.put("clipboard", (IBinder) Proxy.newProxyInstance(classLoader, clsArr, new O00000o0((IBinder) cls.getDeclaredMethod("getService", String.class).invoke(null, "clipboard"))));
        } catch (Exception unused) {
        }
    }

    public static void hookActivityManager() {
        gsy.O000000o(6, "tag", "hookActivityManager");
        try {
            Field declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<?> cls = Class.forName("android.app.IActivityManager");
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new O000000o(obj2)));
        } catch (Exception unused) {
            gsy.O000000o(6, "tag", "hookActivityManager--fail");
        }
    }

    public static String printTrack() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(System.getProperty("line.separator"));
            }
            stringBuffer.append(MessageFormat.format("{0}.{1}() -> {2}", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        }
        return "HookHelper:" + stringBuffer.toString();
    }

    public static void printAndUploadToBuglyInDebugMode(String str) {
        Throwable th;
        Throwable th2;
        if (ifReportable()) {
            String printTrack = printTrack();
            try {
                if (str.equals("LocationManagerHook")) {
                    ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
                    if (CommonApplication.getApplication().isAppForeground()) {
                        th2 = new HookForegroundLocationException(str + ":" + O000000o2 + ":" + printTrack);
                    } else {
                        th2 = new HookBackgroundLocationException(str + ":" + O000000o2 + ":" + printTrack);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(CommonApplication.getApplication().isAppForeground() ? ":ForegroundLocation:" : ":BackgroundLocation:");
                    sb.append(":");
                    sb.append(O000000o2);
                    sb.append(":");
                    sb.append(printTrack);
                    gsy.O00000Oo(str, sb.toString());
                    fuz.O000000o(th2);
                } else if (str.equals("ClipboardManagerHook")) {
                    fuz.O000000o(new ClipLogException(str + ":" + printTrack));
                } else if (str.equals("PackageManagerHook")) {
                    fuz.O000000o(new HookPackageManagerException(str + ":" + printTrack));
                } else {
                    if (ftn.O00000oo(CommonApplication.getAppContext())) {
                        if (CommonApplication.getApplication().isAppForeground()) {
                            th = new ForegroundLogException(str + ":" + printTrack);
                        } else {
                            th = new BackgroundLogException(str + ":" + printTrack);
                        }
                        fuz.O000000o(th);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(CommonApplication.getApplication().isAppForeground() ? ":ForegroundLog:" : ":BackgroundLog:");
                    sb2.append(":");
                    sb2.append(printTrack);
                    gsy.O00000Oo(str, sb2.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class O0000o0 implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f7563O000000o;

        public O0000o0(Object obj) {
            this.f7563O000000o = obj;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                String name = method.getName();
                if ((name.equals("getInstalledPackages") || name.equals("getInstalledApplications")) && HookHelper.interceptPackageManagerMethod()) {
                    HookHelper.printAndUploadToBuglyInDebugMode("PackageManagerHook");
                    return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(new ArrayList());
                }
            } catch (Throwable th) {
                fuz.O000000o(new GetInstallPackageFailException(th));
            }
            return method.invoke(this.f7563O000000o, objArr);
        }
    }

    static class O0000o00 implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private IBinder f7564O000000o;
        private Class<?> O00000Oo;
        private Class<?> O00000o0;

        public O0000o00(IBinder iBinder) {
            this.f7564O000000o = iBinder;
            try {
                this.O00000Oo = Class.forName("com.android.internal.telephony.ITelephony$Stub");
                this.O00000o0 = Class.forName("com.android.internal.telephony.ITelephony");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.f7564O000000o, objArr);
            }
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{this.O00000o0}, new O0000Oo(this.f7564O000000o, this.O00000Oo));
        }
    }

    static class O0000Oo implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f7561O000000o;
        private List<String> O00000Oo = Arrays.asList("getDeviceSoftwareVersionForSlot", "getLine1NumberForDisplay", "getNetworkTypeForSubscriber");

        public O0000Oo(IBinder iBinder, Class<?> cls) {
            try {
                this.f7561O000000o = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.O00000Oo.contains(method.getName())) {
                HookHelper.printAndUploadToBuglyInDebugMode("TelephonyManagerHook");
            }
            try {
                return method.invoke(this.f7561O000000o, objArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (method.getName().contains("getDeviceId")) {
                    return gsa.O000000o(CommonApplication.getAppContext());
                }
                return null;
            }
        }
    }

    static class O0000Oo0 implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private IBinder f7562O000000o;
        private Class<?> O00000Oo;
        private Class<?> O00000o0;

        public O0000Oo0(IBinder iBinder) {
            this.f7562O000000o = iBinder;
            try {
                this.O00000Oo = Class.forName("com.android.internal.telephony.ISub$Stub");
                this.O00000o0 = Class.forName("com.android.internal.telephony.ISub");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.f7562O000000o, objArr);
            }
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{this.O00000o0}, new O0000OOo(this.f7562O000000o, this.O00000Oo));
        }
    }

    public static boolean ifReportable() {
        if (gfr.O0000OOo) {
            lastReportTime = System.currentTimeMillis();
            return true;
        } else if (!gfr.O0000OOo || System.currentTimeMillis() - lastReportTime <= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            return false;
        } else {
            lastReportTime = System.currentTimeMillis();
            return true;
        }
    }

    static class O0000OOo implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f7560O000000o;

        public O0000OOo(IBinder iBinder, Class<?> cls) {
            try {
                this.f7560O000000o = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            } catch (Exception unused) {
                throw new RuntimeException("hooked failed!");
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            HookHelper.printAndUploadToBuglyInDebugMode("SubscriptionManagerHook");
            try {
                return method.invoke(this.f7560O000000o, objArr);
            } catch (Exception e) {
                if (HookHelper.ifReportable() && ftn.O00000oo(CommonApplication.getAppContext())) {
                    try {
                        fuz.O000000o(new SubscriptionInvokeException(e));
                    } catch (Exception unused) {
                    }
                }
                e.printStackTrace();
                return null;
            }
        }
    }

    static class O0000O0o implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private IBinder f7559O000000o;
        private Class O00000Oo;

        public O0000O0o(IBinder iBinder) {
            this.f7559O000000o = iBinder;
            try {
                this.O00000Oo = Class.forName("android.location.ILocationManager");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if (((name.hashCode() == -554320650 && name.equals("queryLocalInterface")) ? (char) 0 : 65535) != 0) {
                return method.invoke(this.f7559O000000o, objArr);
            }
            return Proxy.newProxyInstance(this.f7559O000000o.getClass().getClassLoader(), new Class[]{IInterface.class, IBinder.class, this.O00000Oo}, new O00000o(this.f7559O000000o));
        }
    }

    static class O00000o implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f7557O000000o;

        public O00000o(IBinder iBinder) {
            try {
                this.f7557O000000o = Class.forName("android.location.ILocationManager$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                HookHelper.printAndUploadToBuglyInDebugMode("LocationManagerHook");
                String name = method.getName();
                boolean interceptLocationRequestOnBackground = HookHelper.interceptLocationRequestOnBackground();
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "zhudong_hook_location:", "requestOnBackground:" + interceptLocationRequestOnBackground + "---methodName:" + name);
                if (interceptLocationRequestOnBackground) {
                    fuz.O000000o(new InterceptLocationRequestBackgroundException(name + ":" + HookHelper.printTrack()));
                    if (!name.equals("getLastKnownLocation") && !name.equals("requestLocationUpdates")) {
                        if (!name.equals("requestSingleUpdate")) {
                            if (name.equals("addProximityAlert")) {
                                return new Object();
                            }
                            if (name.equals("addGpsStatusListener") || name.equals("registerGnssStatusCallback") || name.equals("addNmeaListener") || name.equals("registerGnssMeasurementsCallback") || name.equals("registerGnssNavigationMessageCallback")) {
                                return Boolean.FALSE;
                            }
                        }
                    }
                    return new Location("");
                }
            } catch (Exception unused) {
            }
            return method.invoke(this.f7557O000000o, objArr);
        }
    }

    public static class O00000o0 implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private IBinder f7558O000000o;
        private Class<?> O00000Oo;
        private Class<?> O00000o0;

        public O00000o0(IBinder iBinder) {
            this.f7558O000000o = iBinder;
            try {
                this.O00000Oo = Class.forName("android.content.IClipboard$Stub");
                this.O00000o0 = Class.forName("android.content.IClipboard");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.f7558O000000o, objArr);
            }
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{this.O00000o0}, new O00000Oo(this.f7558O000000o, this.O00000Oo));
        }
    }

    public static class O00000Oo implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f7556O000000o;

        public O00000Oo(IBinder iBinder, Class<?> cls) {
            try {
                this.f7556O000000o = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            } catch (Exception unused) {
                throw new RuntimeException("hooked failed!");
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            HookHelper.printAndUploadToBuglyInDebugMode("ClipboardManagerHook");
            try {
                return method.invoke(this.f7556O000000o, objArr);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class O000000o implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private Object f7555O000000o;

        public O000000o(Object obj) {
            this.f7555O000000o = obj;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (method.getName().startsWith("getRunning")) {
                    boolean isAppBackgroundCompact = HookHelper.isAppBackgroundCompact();
                    String printTrack = HookHelper.printTrack();
                    gsy.O000000o(6, "tag", "getName-------->:" + method.getName());
                    StringBuilder sb = new StringBuilder();
                    sb.append(method.getName());
                    sb.append("--->");
                    sb.append(isAppBackgroundCompact ? ":BackgroundLog:" : ":ForegroundLog:");
                    sb.append(":");
                    sb.append(printTrack);
                    gsy.O00000Oo("ActivityManagerHook", sb.toString());
                }
            } catch (Exception unused) {
            }
            return method.invoke(this.f7555O000000o, objArr);
        }
    }

    public static boolean interceptPackageManagerMethod() {
        try {
            if (isAppBackgroundCompact()) {
                return true;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null) {
                for (StackTraceElement className : stackTrace) {
                    if (className.getClassName().startsWith("com.ishumei")) {
                        return true;
                    }
                }
            }
            return System.currentTimeMillis() - CommonApplication.sOnCreateTime <= 10000;
        } catch (Throwable unused) {
        }
    }

    public static boolean interceptLocationRequestOnBackground() {
        return isAppBackgroundCompact() && ftn.O00000oo(CommonApplication.getAppContext()) && grr.O00000o();
    }

    public static boolean isAppBackgroundCompact() {
        return !CommonApplication.getApplication().isAppForeground() || CommonApplication.getActivityStack().isEmpty();
    }

    static class BackgroundLogException extends Exception {
        public BackgroundLogException(String str) {
            super(str);
        }
    }

    static class ForegroundLogException extends Exception {
        public ForegroundLogException(String str) {
            super(str);
        }
    }

    static class InterceptLocationRequestBackgroundException extends Exception {
        public InterceptLocationRequestBackgroundException(String str) {
            super(str);
        }
    }

    static class HookBackgroundLocationException extends Exception {
        public HookBackgroundLocationException(String str) {
            super(str);
        }
    }

    static class HookForegroundLocationException extends Exception {
        public HookForegroundLocationException(String str) {
            super(str);
        }
    }

    static class TelephonyInvokeException extends Exception {
        public TelephonyInvokeException(Exception exc) {
            super(exc);
        }
    }

    static class SubscriptionInvokeException extends Exception {
        public SubscriptionInvokeException(Exception exc) {
            super(exc);
        }
    }

    static class ClipLogException extends Exception {
        public ClipLogException(String str) {
            super(str);
        }
    }

    static class GetInstallPackageFailException extends Exception {
        public GetInstallPackageFailException(Throwable th) {
            super(th);
        }
    }

    static class HookPackageManagerException extends Exception {
        public HookPackageManagerException(String str) {
            super(str);
        }
    }

    static class BackgroundActivityManagerException extends Exception {
        public BackgroundActivityManagerException(String str) {
            super(str);
        }
    }

    static class ForegroundActivityManagerException extends Exception {
        public ForegroundActivityManagerException(String str) {
            super(str);
        }
    }
}
