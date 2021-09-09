package com.amap.api.services.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;

public class bp {

    /* renamed from: a  reason: collision with root package name */
    static String f3340a = null;
    static boolean b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    cl.b(bz.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (b(f3340a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(f3340a)) {
                b = false;
                f3340a = null;
                return false;
            } else if (b(d)) {
                b = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(d)) {
                    b = false;
                    d = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public static String b(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            PackageManager packageManager = context.getPackageManager();
            c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return c;
        } catch (Throwable th) {
            ci.a(th, "AI", "gAN");
        }
    }

    public static String c(Context context) {
        try {
            if (d != null && !"".equals(d)) {
                return d;
            }
            String packageName = context.getPackageName();
            d = packageName;
            if (!b(packageName)) {
                d = context.getPackageName();
            }
            return d;
        } catch (Throwable th) {
            ci.a(th, "AI", "gpck");
        }
    }

    public static String d(Context context) {
        try {
            if (!"".equals(e)) {
                return e;
            }
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = e;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable th) {
            ci.a(th, "AI", "gAV");
        }
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (b(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f3340a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            ci.a(th, "AI", "gsp");
            return f3340a;
        }
    }

    static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
        }
    }

    public static String f(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            ci.a(th, "AI", "gKy");
            return f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[Catch:{ Throwable -> 0x0055, all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A[SYNTHETIC, Splitter:B:39:0x0067] */
    private static String g(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(cj.c(context, "k.store"));
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String a2 = bz.a(bArr);
                if (a2.length() != 32) {
                    a2 = "";
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return a2;
            } catch (Throwable th3) {
                th = th3;
                try {
                    ci.a(th, "AI", "gKe");
                    if (file.exists()) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                if (fileInputStream != null) {
                }
                return "";
            }
        } catch (Throwable th5) {
            fileInputStream = null;
            th = th5;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        String str = f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }
}
