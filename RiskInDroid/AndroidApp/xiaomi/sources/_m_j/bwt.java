package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

public final class bwt {

    /* renamed from: O000000o  reason: collision with root package name */
    static String f13355O000000o = null;
    static boolean O00000Oo = false;
    private static String O00000o = "";
    private static String O00000o0 = "";
    private static String O00000oO = "";
    private static String O00000oo = "";

    public static String O000000o(Context context) {
        try {
            return O0000OOo(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return O00000oo;
        }
    }

    static void O000000o(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            O00000oo = str;
            if (context != null) {
                bsf.O00000o().submit(new Runnable() {
                    /* class _m_j.bwt.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c A[SYNTHETIC, Splitter:B:24:0x004c] */
                    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[SYNTHETIC, Splitter:B:30:0x0057] */
                    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
                    public final void run() {
                        FileOutputStream fileOutputStream = null;
                        try {
                            File file = new File(bsd.O00000o0(context, "k.store"));
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(brs.O000000o(str));
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            } catch (Throwable th2) {
                                FileOutputStream fileOutputStream3 = fileOutputStream2;
                                th = th2;
                                fileOutputStream = fileOutputStream3;
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bsc.O000000o(th, "AI", "stf");
                            if (fileOutputStream == null) {
                            }
                        }
                    }
                });
            }
        }
    }

    public static void O000000o(String str) {
        O00000o = str;
    }

    static boolean O000000o() {
        try {
            if (O00000Oo) {
                return true;
            }
            if (O00000Oo(f13355O000000o)) {
                O00000Oo = true;
                return true;
            } else if (!TextUtils.isEmpty(f13355O000000o)) {
                O00000Oo = false;
                f13355O000000o = null;
                return false;
            } else if (O00000Oo(O00000o)) {
                O00000Oo = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(O00000o)) {
                    O00000Oo = false;
                    O00000o = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    public static String O00000Oo(Context context) {
        try {
            if (!"".equals(O00000o0)) {
                return O00000o0;
            }
            PackageManager packageManager = context.getPackageManager();
            O00000o0 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return O00000o0;
        } catch (Throwable th) {
            bsc.O000000o(th, "AI", "gAN");
        }
    }

    private static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c : str.toCharArray()) {
            if (('A' > c || c > 'z') && (('0' > c || c > ':') && c != '.')) {
                try {
                    bsf.O00000Oo(brs.O000000o(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String O00000o(Context context) {
        try {
            if (!"".equals(O00000oO)) {
                return O00000oO;
            }
            O00000oO = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = O00000oO;
            return str == null ? "" : str;
        } catch (Throwable th) {
            bsc.O000000o(th, "AI", "gAV");
        }
    }

    public static String O00000o0(Context context) {
        try {
            if (O00000o != null && !"".equals(O00000o)) {
                return O00000o;
            }
            String packageName = context.getPackageName();
            O00000o = packageName;
            if (!O00000Oo(packageName)) {
                O00000o = context.getPackageName();
            }
            return O00000o;
        } catch (Throwable th) {
            bsc.O000000o(th, "AI", "gpck");
        }
    }

    public static String O00000oO(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (O00000Oo(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(O00000o)) {
                str = O00000o0(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f13355O000000o = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            bsc.O000000o(th, "AI", "gsp");
            return f13355O000000o;
        }
    }

    public static String O00000oo(Context context) {
        try {
            return O0000OOo(context);
        } catch (Throwable th) {
            bsc.O000000o(th, "AI", "gKy");
            return O00000oo;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[Catch:{ Throwable -> 0x0055, all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A[SYNTHETIC, Splitter:B:39:0x0067] */
    private static String O0000O0o(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(bsd.O00000o0(context, "k.store"));
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String O000000o2 = brs.O000000o(bArr);
                if (O000000o2.length() != 32) {
                    O000000o2 = "";
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return O000000o2;
            } catch (Throwable th3) {
                th = th3;
                try {
                    bsc.O000000o(th, "AI", "gKe");
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

    private static String O0000OOo(Context context) throws PackageManager.NameNotFoundException {
        String str = O00000oo;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return O00000oo;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            O00000oo = string;
            if (string == null) {
                O00000oo = O0000O0o(context);
            }
        }
        return O00000oo;
    }
}
