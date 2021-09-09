package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoLoader {
    private static String SO_STORE_NAME_MAIN = "lib-main";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    private static int sFlags;
    private static final Set<String> sLoadedLibraries = new HashSet();
    private static final Map<String, Object> sLoadingLibraries = new HashMap();
    static SoFileLoader sSoFileLoader;
    private static SoSource[] sSoSources;
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, null);
    }

    public static void init(Context context, int i, SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            initImpl(context, i, soFileLoader);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void initImpl(Context context, int i, SoFileLoader soFileLoader) throws IOException {
        synchronized (SoLoader.class) {
            if (sSoSources == null) {
                Log.d("SoLoader", "init start");
                sFlags = i;
                initSoLoader(soFileLoader);
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = "/vendor/lib:/system/lib";
                }
                String[] split = str.split(":");
                for (String file : split) {
                    arrayList.add(new DirectorySoSource(new File(file), 2));
                }
                if (context != null) {
                    int i2 = 1;
                    if ((i & 1) != 0) {
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if ((applicationInfo.flags & 1) != 0 && (applicationInfo.flags & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                            i2 = 0;
                        } else {
                            arrayList.add(0, new DirectorySoSource(new File(applicationInfo.nativeLibraryDir), Build.VERSION.SDK_INT <= 17 ? 1 : 0));
                        }
                        arrayList.add(0, new ApkSoSource(context, SO_STORE_NAME_MAIN, i2));
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i3 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    Log.d("SoLoader", "Preparing SO source: " + soSourceArr[i3]);
                    soSourceArr[i3].prepare(makePrepareFlags);
                    length = i3;
                }
                sSoSources = soSourceArr;
                Log.d("SoLoader", "init finish: " + sSoSources.length + " SO sources prepared");
            }
        }
    }

    private static int makePrepareFlags() {
        return (sFlags & 2) != 0 ? 1 : 0;
    }

    private static synchronized void initSoLoader(SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                /* class com.facebook.soloader.SoLoader.AnonymousClass1 */

                public final void load(String str, int i) {
                    if (z) {
                        String str2 = (i & 4) == 4 ? classLoaderLdLoadLibrary : makeNonZipPath;
                        try {
                            synchronized (runtime) {
                                String str3 = (String) nativeLoadRuntimeMethod.invoke(runtime, str, SoLoader.class.getClassLoader(), str2);
                                if (str3 != null) {
                                    Log.e("SoLoader", "Error when loading lib: ".concat(String.valueOf(str3)));
                                    throw new UnsatisfiedLinkError(str3);
                                }
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            String concat = "Error: Cannot load ".concat(String.valueOf(str));
                            Log.e("SoLoader", concat);
                            throw new RuntimeException(concat, e);
                        }
                    } else {
                        System.load(str);
                    }
                }
            };
        }
    }

    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | SecurityException e) {
            Log.w("SoLoader", "Cannot get nativeLoad method", e);
            return null;
        }
    }

    public static void setInTestMode() {
        setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        setSoSources(null);
    }

    public static synchronized void setSoSources(SoSource[] soSourceArr) {
        synchronized (SoLoader.class) {
            sSoSources = soSourceArr;
        }
    }

    public static void setSoFileLoader(SoFileLoader soFileLoader) {
        sSoFileLoader = soFileLoader;
    }

    public static synchronized void resetStatus() {
        synchronized (SoLoader.class) {
            sLoadedLibraries.clear();
            sLoadingLibraries.clear();
            sSoFileLoader = null;
            sSoSources = null;
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            initCause(th);
        }
    }

    public static void loadLibrary(String str) {
        loadLibrary(str, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r0 = com.facebook.soloader.MergedSoMapping.mapLibName(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r0 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        loadLibraryBySoName(java.lang.System.mapLibraryName(r1), r3, r0, r4, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        return;
     */
    public static void loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        synchronized (SoLoader.class) {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else if (sSystemLoadLibraryWrapper != null) {
                    sSystemLoadLibraryWrapper.loadLibrary(str);
                } else {
                    System.loadLibrary(str);
                }
            }
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoName(str, null, null, i, threadPolicy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r1 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        r0 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (com.facebook.soloader.SoLoader.sLoadedLibraries.contains(r5) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r7 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0042, code lost:
        if (r1 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        android.util.Log.d("SoLoader", "About to load: ".concat(java.lang.String.valueOf(r5)));
        doLoadLibraryBySoName(r5, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0056, code lost:
        r8 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        android.util.Log.d("SoLoader", "Loaded: ".concat(java.lang.String.valueOf(r5)));
        com.facebook.soloader.SoLoader.sLoadedLibraries.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006d, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0072, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0073, code lost:
        r6 = r5.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0077, code lost:
        if (r6 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0086, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0087, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0088, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x008e, code lost:
        throw new java.lang.RuntimeException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0092, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0094, code lost:
        if (r7 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0098, code lost:
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x009a, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[" + r6 + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        android.util.Log.d("SoLoader", "About to merge: " + r6 + " / " + r5);
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d0, code lost:
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING == false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00d2, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d6, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d9, code lost:
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING != false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00db, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00de, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00df, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00e0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00e2, code lost:
        throw r5;
     */
    private static void loadLibraryBySoName(String str, String str2, String str3, int i, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        synchronized (SoLoader.class) {
            if (!sLoadedLibraries.contains(str)) {
                z = false;
            } else if (str3 != null) {
                z = true;
            } else {
                return;
            }
            if (sLoadingLibraries.containsKey(str)) {
                obj = sLoadingLibraries.get(str);
            } else {
                obj = new Object();
                sLoadingLibraries.put(str, obj);
            }
        }
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doLoadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        SoSource[] soSourceArr;
        int i2;
        boolean z;
        synchronized (SoLoader.class) {
            if (sSoSources != null) {
                soSourceArr = new SoSource[sSoSources.length];
                i2 = 0;
                System.arraycopy(sSoSources, 0, soSourceArr, 0, sSoSources.length);
            } else {
                Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                throw new UnsatisfiedLinkError("couldn't find DSO to load: ".concat(String.valueOf(str)));
            }
        }
        if (threadPolicy == null) {
            threadPolicy = StrictMode.allowThreadDiskReads();
            z = true;
        } else {
            z = false;
        }
        if (SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[" + str + "]");
        }
        int i3 = 0;
        while (i2 == 0) {
            try {
                if (i3 >= soSourceArr.length) {
                    break;
                }
                i2 = soSourceArr[i3].loadLibrary(str, i, threadPolicy);
                if (i2 == 0) {
                    Log.d("SoLoader", "Result " + i2 + " for " + str + " in source " + soSourceArr[i3]);
                }
                if (soSourceArr[i3] instanceof ExtractFromZipSoSource) {
                    Log.d("SoLoader", "Extraction logs: " + ((ExtractFromZipSoSource) soSourceArr[i3]).getExtractLogs(str));
                }
                i3++;
            } catch (Throwable th) {
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i2 == 0) {
                    Log.e("SoLoader", "Could not load: ".concat(String.valueOf(str)));
                    throw new UnsatisfiedLinkError("couldn't find DSO to load: ".concat(String.valueOf(str)));
                }
                throw th;
            }
        }
        if (SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.endSection();
        }
        if (z) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        if (i2 == 0) {
            Log.e("SoLoader", "Could not load: ".concat(String.valueOf(str)));
            throw new UnsatisfiedLinkError("couldn't find DSO to load: ".concat(String.valueOf(str)));
        }
    }

    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    public static Set<String> getLoadedLibrariesNames() {
        return sLoadedLibraries;
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        int i = 0;
        while (true) {
            SoSource[] soSourceArr = sSoSources;
            if (i < soSourceArr.length) {
                File unpackLibrary = soSourceArr[i].unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
                i++;
            } else {
                throw new FileNotFoundException(str);
            }
        }
    }

    private static void assertInitialized() {
        if (sSoSources == null) {
            throw new RuntimeException("SoLoader.init() not yet called");
        }
    }

    public static synchronized void prependSoSource(SoSource soSource) throws IOException {
        synchronized (SoLoader.class) {
            Log.d("SoLoader", "Prepending to SO sources: ".concat(String.valueOf(soSource)));
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[(sSoSources.length + 1)];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            Log.d("SoLoader", "Prepended to SO sources: ".concat(String.valueOf(soSource)));
        }
    }

    public static synchronized String makeLdLibraryPath() {
        String join;
        synchronized (SoLoader.class) {
            assertInitialized();
            Log.d("SoLoader", "makeLdLibraryPath");
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            for (SoSource addToLdLibraryPath : soSourceArr) {
                addToLdLibraryPath.addToLdLibraryPath(arrayList);
            }
            join = TextUtils.join(":", arrayList);
            Log.d("SoLoader", "makeLdLibraryPath final path: ".concat(String.valueOf(join)));
        }
        return join;
    }

    public static boolean areSoSourcesAbisSupported() {
        SoSource[] soSourceArr = sSoSources;
        if (soSourceArr == null) {
            return false;
        }
        String[] supportedAbis = SysUtil.getSupportedAbis();
        for (SoSource soSourceAbis : soSourceArr) {
            String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
            for (int i = 0; i < soSourceAbis2.length; i++) {
                boolean z = false;
                for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                    z = soSourceAbis2[i].equals(supportedAbis[i2]);
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    @DoNotOptimize
    @TargetApi(14)
    static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
        }
    }
}
