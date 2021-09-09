package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dgr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ActivityManager f14614O000000o;

    static {
        "@buglyAllChannel@".split(",");
        "@buglyAllChannelPriority@".split(",");
    }

    public static String O000000o(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo O00000Oo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(O000000o(context), 0);
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static boolean O000000o(Context context, String str) {
        if (context != null && str.trim().length() > 0) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String equals : strArr) {
                        if (str.equals(equals)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[Catch:{ all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[SYNTHETIC, Splitter:B:27:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058 A[SYNTHETIC, Splitter:B:32:0x0058] */
    public static String O000000o(int i) {
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/" + i + "/cmdline");
            try {
                char[] cArr = new char[512];
                fileReader2.read(cArr);
                int i2 = 0;
                while (i2 < 512 && cArr[i2] != 0) {
                    i2++;
                }
                String substring = new String(cArr).substring(0, i2);
                try {
                    fileReader2.close();
                } catch (Throwable unused) {
                }
                return substring;
            } catch (Throwable th) {
                th = th;
                fileReader = fileReader2;
                if (fileReader != null) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!did.O000000o(th)) {
            }
            String valueOf = String.valueOf(i);
            if (fileReader != null) {
            }
            return valueOf;
        }
    }

    public static String O00000o0(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!(packageManager == null || applicationInfo == null || (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) == null)) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> O00000o(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                hashMap.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                hashMap.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                hashMap.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                hashMap.put("com.tencent.rdm.uuid", obj6.toString());
            }
            return hashMap;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<String> O000000o(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null) {
                if (str.length() != 0) {
                    String[] split = str.split(",");
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].trim();
                    }
                    return Arrays.asList(split);
                }
            }
            return null;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static String O000000o(byte[] bArr) {
        X509Certificate x509Certificate;
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                if (instance == null || (x509Certificate = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SHA1|");
                String O00000o0 = dif.O00000o0(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (O00000o0 == null || O00000o0.length() <= 0) {
                    sb.append("unknown");
                } else {
                    sb.append(O00000o0.toString());
                }
                sb.append("\n");
                sb.append("MD5|");
                String O00000o02 = dif.O00000o0(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (O00000o02 == null || O00000o02.length() <= 0) {
                    sb.append("unknown");
                } else {
                    sb.append(O00000o02.toString());
                }
            } catch (CertificateException e) {
                if (!did.O000000o(e)) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
        if (sb.length() == 0) {
            return "unknown";
        }
        return sb.toString();
    }

    public static String O00000oO(Context context) {
        Signature[] signatureArr;
        String O000000o2 = O000000o(context);
        if (O000000o2 == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(O000000o2, 64);
            if (!(packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0)) {
                return O000000o(packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static boolean O00000oo(Context context) {
        if (context == null) {
            return false;
        }
        if (f14614O000000o == null) {
            f14614O000000o = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f14614O000000o.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            did.O00000o0("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
