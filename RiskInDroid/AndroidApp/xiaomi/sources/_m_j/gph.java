package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class gph {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f18118O000000o = (CommonApplication.getAppContext().getCacheDir().getPath() + "/img-cache");
    public Map<String, AsyncTask<Void, Void, Bitmap>> O00000Oo;

    public interface O00000Oo {
        void O000000o();

        void O000000o(Bitmap bitmap);
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static gph f18122O000000o = new gph((byte) 0);
    }

    /* synthetic */ gph(byte b) {
        this();
    }

    public static gph O000000o() {
        return O00000o0.f18122O000000o;
    }

    private gph() {
        this.O00000Oo = Collections.synchronizedMap(new HashMap());
        O00000Oo();
    }

    public static void O00000Oo() {
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "notifyStart()");
        O00000o();
    }

    private static void O00000o() {
        File file = new File(f18118O000000o);
        if (file.exists() && file.isDirectory()) {
            return;
        }
        if (file.mkdirs()) {
            gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "createCacheDirectoryIfNeeded(): create img-cache directory success");
        } else {
            gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "createCacheDirectoryIfNeeded(): create img-cache directory failed");
        }
    }

    public final boolean O000000o(String str) {
        boolean O00000oo = O00000oo(str);
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "ImageDownloadManager", "isDownloaded(): " + O00000oo + ", url = " + str);
        return O00000oo;
    }

    private static boolean O00000oo(String str) {
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "findCacheImageByUrl(): ".concat(String.valueOf(str)));
        return O0000O0o(O00000oO(str));
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static boolean O0000O0o(String str) {
        File file = new File(f18118O000000o);
        ? r2 = 0;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            boolean z = false;
            while (r2 < length) {
                if (listFiles[r2].getName().equals(str)) {
                    z = true;
                }
                r2++;
            }
            r2 = z;
        }
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "ImageDownloadManager", "findCacheImageByKey(): " + ((boolean) r2) + ", diskKey = " + str);
        return r2;
    }

    public final boolean O00000Oo(String str) {
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "load(): url = ".concat(String.valueOf(str)));
        if (str != null && O00000o0(str) < 0) {
            O000000o(str, null);
        }
        return false;
    }

    public final int O00000o0(String str) {
        int i;
        if (this.O00000Oo.get(str) != null) {
            i = 0;
        } else {
            i = O00000oo(str) ? 1 : -1;
        }
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "checkStatus(): ".concat(String.valueOf(i)));
        return i;
    }

    public final void O000000o(String str, O00000Oo o00000Oo) {
        int O00000o02;
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "fetch(): url = ".concat(String.valueOf(str)));
        if (str != null && (O00000o02 = O00000o0(str)) != 1) {
            if (!O000000o(CommonApplication.getAppContext())) {
                gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "fetch(): no available network");
            } else if (O00000o02 < 0) {
                O000000o o000000o = new O000000o(str, o00000Oo);
                this.O00000Oo.put(str, o000000o);
                o000000o.execute(new Void[0]);
            }
        }
    }

    public final synchronized Bitmap O00000o(String str) {
        Bitmap bitmap;
        bitmap = null;
        if (!TextUtils.isEmpty(str)) {
            String str2 = f18118O000000o + "/" + O00000oO(str);
            try {
                File file = new File(str2);
                Bitmap decodeFile = file.exists() ? BitmapFactory.decodeFile(str2) : null;
                if (decodeFile == null) {
                    try {
                        if (file.exists()) {
                            gsc.O00000Oo(file);
                        }
                        String str3 = str2 + "_temp";
                        File file2 = new File(str3);
                        if (gof.O000000o(CommonApplication.getAppContext(), str, file2, null).O00000Oo == 3) {
                            Bitmap decodeFile2 = BitmapFactory.decodeFile(str3);
                            try {
                                file2.renameTo(file);
                                bitmap = decodeFile2;
                            } catch (Exception e) {
                                bitmap = decodeFile2;
                                e = e;
                                e.printStackTrace();
                                return bitmap;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bitmap = decodeFile;
                        e.printStackTrace();
                        return bitmap;
                    }
                }
                bitmap = decodeFile;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return bitmap;
            }
        }
        return bitmap;
    }

    public static String O00000oO(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf("id=");
        if (lastIndexOf > 0) {
            str2 = str.substring(lastIndexOf + 3);
        } else {
            str2 = gpp.O000000o(str);
        }
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "generateDiskKey(): ".concat(String.valueOf(str2)));
        return str2;
    }

    class O000000o extends AsyncTask<Void, Void, Bitmap> {
        private final String O00000Oo;
        private final O00000Oo O00000o0;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            O00000Oo o00000Oo = this.O00000o0;
            if (o00000Oo == null) {
                return;
            }
            if (bitmap != null) {
                o00000Oo.O000000o(bitmap);
            } else {
                o00000Oo.O000000o();
            }
        }

        public O000000o(String str, O00000Oo o00000Oo) {
            this.O00000Oo = str;
            this.O00000o0 = o00000Oo;
        }

        private Bitmap O000000o() {
            String str = gph.f18118O000000o + "/" + gph.O00000oO(this.O00000Oo);
            gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "doInBackground(): url = " + this.O00000Oo + ", diskPath = " + str);
            Bitmap bitmap = null;
            if (gof.O000000o(CommonApplication.getAppContext(), this.O00000Oo, new File(str), null).O00000Oo == 3) {
                gph.this.O00000Oo.remove(this.O00000Oo);
                try {
                    bitmap = BitmapFactory.decodeFile(str);
                    if (bitmap == null) {
                        if (new File(str).delete()) {
                            gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "load(): clean success, ".concat(String.valueOf(str)));
                        } else {
                            gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "load(): clean failed, ".concat(String.valueOf(str)));
                        }
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
            return bitmap;
        }
    }

    public static boolean O00000o0() {
        gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "cleanCacheIfNeeded()");
        File file = new File(f18118O000000o);
        if (!file.exists() || !file.isDirectory() || file.listFiles() == null || file.listFiles().length <= 10) {
            return false;
        }
        for (File file2 : file.listFiles()) {
            if (file2.delete()) {
                gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "cleanCacheIfNeeded(): clean success, " + file2.getName());
            } else {
                gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "cleanCacheIfNeeded(): clean failed, " + file2.getName());
            }
        }
        return true;
    }

    private static boolean O000000o(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
