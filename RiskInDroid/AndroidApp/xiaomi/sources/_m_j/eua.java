package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.safedata.complete.CompleteBean;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

public class eua {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15816O000000o = "eua";

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x005a */
    public static JSONObject O000000o(Context context) {
        euh.O000000o(f15816O000000o, "Complete is start");
        CompleteBean completeBean = new CompleteBean();
        Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(signature.toByteArray());
        completeBean.signMD5 = new BigInteger(1, instance.digest()).toString(16);
        MessageDigest instance2 = MessageDigest.getInstance("SHA1");
        instance2.update(signature.toByteArray());
        completeBean.signSHA1 = new BigInteger(1, instance2.digest()).toString(16);
        try {
            completeBean.fileCRC32 = O00000Oo(context);
            completeBean.apkSHA1 = O00000o(context);
        } catch (Exception e) {
            euh.O00000Oo(f15816O000000o, e.toString());
        }
        return completeBean.O000000o();
    }

    private static String O00000Oo(Context context) {
        ZipEntry zipEntry;
        try {
            zipEntry = new ZipFile(O00000o0(context)).getEntry("classes.dex");
        } catch (Exception unused) {
            zipEntry = null;
        }
        if (zipEntry == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(zipEntry.getCrc());
        return sb.toString();
    }

    private static String O00000o0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), (int) NotificationCompat.FLAG_HIGH_PRIORITY).applicationInfo.publicSourceDir;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[SYNTHETIC, Splitter:B:17:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[SYNTHETIC, Splitter:B:26:0x004f] */
    private static String O00000o(Context context) {
        FileInputStream fileInputStream;
        String O00000o0 = O00000o0(context);
        FileInputStream fileInputStream2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            fileInputStream = new FileInputStream(new File(O00000o0));
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                } catch (Exception unused) {
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    throw th;
                }
            }
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bigInteger;
        } catch (Exception unused2) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
