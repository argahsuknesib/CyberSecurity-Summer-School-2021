package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.alibaba.android.arouter.thread.DefaultPoolExecutor;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class oa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f2336O000000o = ("code_cache" + File.separator + "secondary-dexes");

    public static Set<String> O000000o(Context context, final String str) throws PackageManager.NameNotFoundException, IOException, InterruptedException {
        final HashSet hashSet = new HashSet();
        List<String> O000000o2 = O000000o(context);
        final CountDownLatch countDownLatch = new CountDownLatch(O000000o2.size());
        for (final String next : O000000o2) {
            DefaultPoolExecutor.getInstance().execute(new Runnable() {
                /* class _m_j.oa.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
                    if (r0 != null) goto L_0x004e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                    r0.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
                    if (r0 == null) goto L_0x0051;
                 */
                public final void run() {
                    DexFile dexFile = null;
                    try {
                        if (next.endsWith(".zip")) {
                            String str = next;
                            dexFile = DexFile.loadDex(str, next + ".tmp", 0);
                        } else {
                            dexFile = new DexFile(next);
                        }
                        Enumeration<String> entries = dexFile.entries();
                        while (entries.hasMoreElements()) {
                            String nextElement = entries.nextElement();
                            if (nextElement.startsWith(str)) {
                                hashSet.add(nextElement);
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            Log.e("ARouter", "Scan map file in dex files made error.", th);
                        } catch (Throwable unused) {
                        }
                    }
                    countDownLatch.countDown();
                    return;
                    countDownLatch.countDown();
                    throw th;
                }
            });
        }
        countDownLatch.await();
        Log.d("ARouter::", "Filter " + hashSet.size() + " classes by packageName <" + str + ">");
        return hashSet;
    }

    private static List<String> O000000o(Context context) throws PackageManager.NameNotFoundException, IOException {
        int i = 0;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        if (!O000000o()) {
            if (Build.VERSION.SDK_INT >= 11) {
                i = 4;
            }
            int i2 = context.getSharedPreferences("multidex.version", i).getInt("dex.number", 1);
            File file2 = new File(applicationInfo.dataDir, f2336O000000o);
            int i3 = 2;
            while (i3 <= i2) {
                File file3 = new File(file2, str + i3 + ".zip");
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                    i3++;
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
        }
        if (ny.O00000Oo()) {
            arrayList.addAll(O000000o(applicationInfo));
        }
        return arrayList;
    }

    private static List<String> O000000o(ApplicationInfo applicationInfo) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null) {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", String.class).invoke(null, applicationInfo.packageName));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(".dex")) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                    Log.d("ARouter::", "Found InstantRun support");
                }
            } catch (Exception e) {
                Log.e("ARouter::", "InstantRun support error, " + e.getMessage());
            }
        } else {
            arrayList.addAll(Arrays.asList(applicationInfo.splitSourceDirs));
            Log.d("ARouter::", "Found InstantRun support");
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        if (r3 <= 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (java.lang.Integer.valueOf(java.lang.System.getProperty("ro.build.version.sdk")).intValue() >= 21) goto L_0x001c;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    private static boolean O000000o() {
        String str;
        boolean z = false;
        try {
            if (O00000Oo()) {
                str = "'YunOS'";
            } else {
                str = "'Android'";
                String property = System.getProperty("java.vm.version");
                if (property != null) {
                    Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
                    if (matcher.matches()) {
                        try {
                            int parseInt = Integer.parseInt(matcher.group(1));
                            int parseInt2 = Integer.parseInt(matcher.group(2));
                            if (parseInt <= 2) {
                                if (parseInt == 2) {
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                StringBuilder sb = new StringBuilder("VM with name ");
                sb.append(str);
                sb.append(!z ? " has multidex support" : " does not have multidex support");
                Log.i("ARouter::", sb.toString());
                return z;
            }
            z = true;
        } catch (Exception unused2) {
            str = null;
        }
        StringBuilder sb2 = new StringBuilder("VM with name ");
        sb2.append(str);
        sb2.append(!z ? " has multidex support" : " does not have multidex support");
        Log.i("ARouter::", sb2.toString());
        return z;
    }

    private static boolean O00000Oo() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if ((property2 == null || !property2.toLowerCase().contains("lemur")) && (property == null || property.trim().length() <= 0)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
