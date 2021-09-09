package _m_j;

import _m_j.dje;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class diz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static diz f14710O000000o = null;
    private static boolean O00000o = false;
    protected djb O00000Oo = new djb(new djc(O00000o0(), djd.O0000o00, djd.O0000O0o, djd.O0000OOo, djd.O00000o0, (long) djd.O0000Oo0, djd.O00000oO, djd.O0000o0));
    private dja O00000o0;

    private static diz O00000Oo() {
        if (f14710O000000o == null) {
            synchronized (diz.class) {
                if (f14710O000000o == null) {
                    f14710O000000o = new diz();
                    O00000o = true;
                }
            }
        }
        return f14710O000000o;
    }

    private diz() {
    }

    private void O000000o(int i, String str, String str2, Throwable th) {
        String str3 = str2;
        boolean z = false;
        if (O00000o) {
            String O00000Oo2 = djk.O00000Oo();
            if (!TextUtils.isEmpty(O00000Oo2)) {
                String str4 = O00000Oo2 + " SDK_VERSION:3.5.2.lite";
                if (this.O00000Oo != null) {
                    String str5 = str4;
                    djf.O00000Oo.O000000o(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str5, null);
                    this.O00000Oo.O000000o(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str5, null);
                    O00000o = false;
                } else {
                    return;
                }
            }
        }
        djf.O00000Oo.O000000o(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (dje.O000000o.O000000o(djd.O00000Oo, i)) {
            djb djb = this.O00000Oo;
            if (djb != null) {
                djb.O000000o(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            } else {
                return;
            }
        }
        dja dja = this.O00000o0;
        if (dja != null) {
            try {
                Thread currentThread = Thread.currentThread();
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(str2)) {
                    str3 = "";
                } else {
                    if (str3.contains("access_token") || str3.contains("pay_token") || str3.contains("pfkey") || str3.contains("expires_in") || str3.contains("openid") || str3.contains("proxy_code") || str3.contains("proxy_expires_in")) {
                        z = true;
                    }
                    if (z) {
                        str3 = "xxxxxx";
                    }
                }
                dja.O000000o(i, currentThread, currentTimeMillis, str, str3, th);
            } catch (Exception e) {
                Log.e(str, "Exception", e);
            }
        }
    }

    public static final void O000000o(String str, String str2) {
        O00000Oo().O000000o(1, str, str2, null);
    }

    public static final void O00000Oo(String str, String str2) {
        O00000Oo().O000000o(2, str, str2, null);
    }

    public static final void O000000o(String str, String str2, Throwable th) {
        O00000Oo().O000000o(2, str, str2, th);
    }

    public static final void O00000o0(String str, String str2) {
        O00000Oo().O000000o(4, str, str2, null);
    }

    public static final void O00000o(String str, String str2) {
        O00000Oo().O000000o(8, str, str2, null);
    }

    public static final void O00000oO(String str, String str2) {
        O00000Oo().O000000o(16, str, str2, null);
    }

    public static final void O00000Oo(String str, String str2, Throwable th) {
        O00000Oo().O000000o(16, str, str2, th);
    }

    public static void O000000o() {
        synchronized (diz.class) {
            diz O00000Oo2 = O00000Oo();
            if (O00000Oo2.O00000Oo != null) {
                O00000Oo2.O00000Oo.O000000o();
                djb djb = O00000Oo2.O00000Oo;
                djb.O00000Oo();
                djb.O00000o0();
                djb.O00000Oo.quit();
                O00000Oo2.O00000Oo = null;
            }
            if (f14710O000000o != null) {
                f14710O000000o = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Throwable -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[Catch:{ Throwable -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[Catch:{ Throwable -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[Catch:{ Throwable -> 0x007a }] */
    private static File O00000o0() {
        boolean z;
        dje.O00000Oo o00000Oo;
        File file;
        String str = djd.O00000o;
        try {
            String externalStorageState = Environment.getExternalStorageState();
            boolean z2 = true;
            if (!"mounted".equals(externalStorageState)) {
                if (!"mounted_ro".equals(externalStorageState)) {
                    z = false;
                    if (z) {
                        o00000Oo = null;
                    } else {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        o00000Oo = new dje.O00000Oo();
                        o00000Oo.f14714O000000o = externalStorageDirectory;
                        StatFs statFs = new StatFs(externalStorageDirectory.getAbsolutePath());
                        long blockSize = (long) statFs.getBlockSize();
                        o00000Oo.O00000Oo = ((long) statFs.getBlockCount()) * blockSize;
                        o00000Oo.O00000o0 = ((long) statFs.getAvailableBlocks()) * blockSize;
                    }
                    if (o00000Oo != null || o00000Oo.O00000o0 <= djd.O00000oo) {
                        z2 = false;
                    }
                    if (!z2) {
                        return new File(Environment.getExternalStorageDirectory(), str);
                    }
                    if (djk.O000000o() == null) {
                        file = null;
                    } else {
                        file = djk.O000000o().getFilesDir();
                    }
                    return new File(file, str);
                }
            }
            z = true;
            if (z) {
            }
            if (o00000Oo != null) {
            }
            z2 = false;
            if (!z2) {
            }
        } catch (Throwable th) {
            O00000Oo("openSDK_LOG", "getLogFilePath:", th);
            return null;
        }
    }
}
