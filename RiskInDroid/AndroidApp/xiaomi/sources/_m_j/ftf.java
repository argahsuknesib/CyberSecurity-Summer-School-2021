package _m_j;

import _m_j.dxi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class ftf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17092O000000o = null;
    public static String O00000Oo = "log.zip";
    static Context O00000o;
    public static SimpleDateFormat O00000o0 = new SimpleDateFormat("yyyy-MM-dd");
    private static volatile ftf O00000oo;
    private static Object O0000O0o = new Object();
    public volatile boolean O00000oO = false;
    private volatile OkHttpClient O0000OOo;

    private ftf() {
        Context appContext = CommonApplication.getAppContext();
        O00000o = appContext;
        File externalFilesDir = appContext.getExternalFilesDir("logs");
        if (externalFilesDir != null) {
            f17092O000000o = externalFilesDir.getAbsolutePath() + "/";
            if (new File(f17092O000000o).exists()) {
                O00000Oo();
            } else {
                goq.O000000o(new Runnable() {
                    /* class _m_j.ftf.AnonymousClass1 */

                    public final void run() {
                        File file = new File(ftf.f17092O000000o);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        ftf.this.O00000Oo();
                    }
                });
            }
        } else {
            gsy.O000000o(6, "InternalLogger", "=================getExternalFilesDir is null====================");
        }
    }

    public static ftf O000000o() {
        if (O00000oo == null) {
            synchronized (O0000O0o) {
                if (O00000oo == null) {
                    O00000oo = new ftf();
                }
            }
        }
        return O00000oo;
    }

    public final void O00000Oo() {
        File file = new File(f17092O000000o + "app");
        File externalCacheDir = O00000o.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = new File(f17092O000000o + "cache");
        }
        file.mkdirs();
        externalCacheDir.mkdirs();
        dxi.O000000o o000000o = new dxi.O000000o();
        o000000o.f15029O000000o = externalCacheDir.getAbsolutePath();
        o000000o.O00000Oo = file.getAbsolutePath();
        dxi.O000000o O00000Oo2 = o000000o.O000000o().O00000Oo();
        O00000Oo2.O00000oO = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6QMGnGAh1laPs8bqE/5V4Msk7wBdFEEB8hz0UqbE3oNxguH7TOHKuj9KkLXKDJcEDshnERsrGOoXMAQW66oor1xPIFTepswcqiJXeVtY5sXKZl0ALbVB9FJwiYoUGMrhj1cAsrW8ZXszdHkFdz1pH0YTkXInVWfvrijWYlAXh9RvZqxzZl7vuyy2CkfQLWzOqdS1bENLlkuZ+83+1395WeXveCkciUok0L6X9OLB5Kl4QGuEtXUacjAGS33gp/TOVr9sAef4SY5zGiC5sjVBqy7c7BdE6VmsI0eH2NtHF6pwxHER6BqWzMl1vuckGmDTfq1OXGmze4Qr09WCj4fzxwIDAQAB\n-----END PUBLIC KEY-----";
        dxh.O000000o(O00000Oo2.O00000o0());
        dxh.O000000o(gfr.f17662O000000o);
        dxh.O000000o(new dxn() {
            /* class _m_j.ftf.AnonymousClass2 */

            public final void O000000o(String str, int i) {
                gsy.O000000o(3, "InternalLogger", "log > cmd : " + str + " | code : " + i);
            }
        });
        this.O00000oO = true;
        goq.O000000o(new Runnable() {
            /* class _m_j.ftf.AnonymousClass3 */

            public final void run() {
                File[] listFiles;
                ftf ftf = ftf.this;
                File file = new File(ftf.O00000o0());
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile() && ((TextUtils.equals(file2.getName(), "RnApp.log") || TextUtils.equals(file2.getName(), "RnPlugin.log") || TextUtils.equals(file2.getName(), "plugin.log")) && Math.abs(System.currentTimeMillis() - file2.lastModified()) > 259200000)) {
                            file2.delete();
                        }
                        if (file2.isDirectory() && file2.getName().startsWith("plug_")) {
                            File[] listFiles2 = file2.listFiles();
                            if (listFiles2 == null || listFiles2.length <= 0) {
                                file2.delete();
                            } else {
                                ftf.O00000Oo(file2);
                                ftf.O00000o0(file2);
                            }
                        }
                    }
                }
                File externalFilesDir = ftf.O00000o.getExternalFilesDir("log");
                if (externalFilesDir != null && externalFilesDir.exists() && externalFilesDir.isDirectory()) {
                    File[] listFiles3 = externalFilesDir.listFiles();
                    if (listFiles3 == null || listFiles3.length <= 0) {
                        externalFilesDir.delete();
                        return;
                    }
                    for (File file3 : listFiles3) {
                        if (file3.getName().startsWith("miio-bluetooth") && Math.abs(System.currentTimeMillis() - file3.lastModified()) > 259200000) {
                            file3.delete();
                        }
                    }
                }
            }
        });
    }

    public static String O00000o0() {
        return f17092O000000o;
    }

    public final void O000000o(int i, String str, String str2, String str3) {
        if (i <= 0) {
            gsy.O000000o(6, "MyLogger", "logType is illegal");
        } else if (TextUtils.isEmpty(str3)) {
            gsy.O000000o(6, "MyLogger", "message is empty");
        } else if (this.O00000oO) {
            dxh.O000000o(str3, i, str, str2);
        }
    }

    public static boolean O000000o(File file) {
        if (!file.isFile() || !file.getName().endsWith(".txt")) {
            return true;
        }
        String name = file.getName();
        try {
            O00000o0.parse(name.substring(0, name.length() - 4)).getTime();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(File file) {
        File[] listFiles = file.listFiles(new FileFilter() {
            /* class _m_j.ftf.AnonymousClass4 */

            public final boolean accept(File file) {
                return ftf.O000000o(file);
            }
        });
        if (listFiles != null) {
            for (File path : listFiles) {
                ftd.O00000oo(path.getPath());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(File file) {
        if (file.isDirectory()) {
            final long currentTimeMillis = System.currentTimeMillis();
            File[] listFiles = file.listFiles(new FilenameFilter() {
                /* class _m_j.ftf.AnonymousClass5 */

                public final boolean accept(File file, String str) {
                    try {
                        long time = ftf.O00000o0.parse(str.substring(0, str.length() - 4)).getTime();
                        if (currentTimeMillis - time > 259200000 || currentTimeMillis - time < 0) {
                            return true;
                        }
                        return false;
                    } catch (ParseException unused) {
                        return false;
                    }
                }
            });
            if (listFiles != null) {
                for (File path : listFiles) {
                    ftd.O00000oo(path.getPath());
                }
                return;
            }
            return;
        }
        file.mkdirs();
    }

    public static boolean O00000o(File file) {
        if (file == null || file.isFile()) {
            return false;
        }
        if (file.getName().startsWith("plug_") || file.getName().startsWith("app")) {
            return true;
        }
        return false;
    }

    private static boolean O000000o(File file, String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(file.getPath());
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        return file.isFile() && !TextUtils.isEmpty(fileExtensionFromUrl) && mimeTypeFromExtension != null && mimeTypeFromExtension.contains(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(String str, String str2) {
        try {
            Response execute = O00000oO().newCall(new Request.Builder().url(str2).put(RequestBody.create(MediaType.parse(""), new File(str))).build()).execute();
            boolean isSuccessful = execute.isSuccessful();
            execute.close();
            return isSuccessful;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private OkHttpClient O00000oO() {
        if (this.O0000OOo == null) {
            synchronized (O0000O0o) {
                if (this.O0000OOo == null) {
                    this.O0000OOo = gse.O000000o();
                }
            }
        }
        return this.O0000OOo;
    }

    public final void O00000o() {
        if (this.O00000oO) {
            dxh.O000000o();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0223 A[Catch:{ Exception -> 0x0233 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0248 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0249 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x00b2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019b A[Catch:{ Exception -> 0x01ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ed A[Catch:{ Exception -> 0x01fd }] */
    public final String O000000o(String[] strArr, boolean z) {
        FileOutputStream fileOutputStream;
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3;
        FileOutputStream fileOutputStream2;
        Bitmap bitmap;
        String[] strArr2 = strArr;
        String str = f17092O000000o;
        String str2 = str + O00000Oo;
        try {
            for (File file : new File(str).listFiles()) {
                if (O000000o(file, "image") || O000000o(file, "zip")) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashSet hashSet = new HashSet();
        Bitmap bitmap2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            for (String str3 : strArr2) {
                try {
                    File file2 = new File(str, new File(str3).getName());
                    fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(str3, options);
                        int O000000o2 = gos.O000000o(options.outWidth, options.outHeight, 1080, 2700000);
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inJustDecodeBounds = false;
                        options2.inSampleSize = O000000o2;
                        bitmap = BitmapFactory.decodeFile(str3, options2);
                        try {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream2);
                            hashSet.add(file2);
                            gpg.O000000o(fileOutputStream2);
                            if (bitmap == null) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                gpg.O000000o(fileOutputStream2);
                                if (bitmap == null) {
                                }
                                bitmap.recycle();
                            } catch (Throwable th) {
                                th = th;
                                bitmap2 = bitmap;
                                gpg.O000000o(fileOutputStream2);
                                if (bitmap2 != null) {
                                    bitmap2.recycle();
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bitmap = null;
                        e.printStackTrace();
                        gpg.O000000o(fileOutputStream2);
                        if (bitmap == null) {
                        }
                        bitmap.recycle();
                    } catch (Throwable th2) {
                        th = th2;
                        gpg.O000000o(fileOutputStream2);
                        if (bitmap2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream2 = null;
                    bitmap = null;
                    e.printStackTrace();
                    gpg.O000000o(fileOutputStream2);
                    if (bitmap == null) {
                    }
                    bitmap.recycle();
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = null;
                    gpg.O000000o(fileOutputStream2);
                    if (bitmap2 != null) {
                    }
                    throw th;
                }
                bitmap.recycle();
            }
        }
        if (z) {
            try {
                AnonymousClass7 r0 = new FileFilter() {
                    /* class _m_j.ftf.AnonymousClass7 */

                    public final boolean accept(File file) {
                        if (file.isFile()) {
                            return true;
                        }
                        return ftf.O00000o(file);
                    }
                };
                ftd.O000000o(new File(str).listFiles(r0), new Comparator<File>() {
                    /* class _m_j.ftf.AnonymousClass8 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        return O000000o((File) obj, (File) obj2);
                    }

                    private static int O000000o(File file, File file2) {
                        String name = file.getName();
                        String name2 = file2.getName();
                        if (name.endsWith(".txt")) {
                            name = name.substring(0, name.length() - 4);
                        } else if (name.startsWith("mijia_log_v2_")) {
                            name = name.substring(13);
                        } else if (name.startsWith("mijia_log_v3_")) {
                            name = name.substring(13);
                        }
                        if (name2.endsWith(".txt")) {
                            name2 = name2.substring(0, name2.length() - 4);
                        } else if (name2.startsWith("mijia_log_v2_")) {
                            name2 = name2.substring(13);
                        } else if (name2.startsWith("mijia_log_v3_")) {
                            name2 = name2.substring(13);
                        }
                        try {
                            return (int) (ftf.O00000o0.parse(name).getTime() - ftf.O00000o0.parse(name2).getTime());
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });
                hashSet.addAll(Arrays.asList(new File(str).listFiles(r0)));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                File file3 = new File(str, "plugin.txt");
                fileOutputStream = new FileOutputStream(file3);
                try {
                    for (Map.Entry<String, PluginPackageInfo> value : fkl.O000000o().O0000OOo.entrySet()) {
                        PluginPackageInfo pluginPackageInfo = (PluginPackageInfo) value.getValue();
                        if (pluginPackageInfo != null) {
                            fileOutputStream.write(("Model - " + pluginPackageInfo.O0000OoO() + ", PackageId - " + pluginPackageInfo.O00000Oo() + "\n").getBytes());
                        }
                    }
                    fileOutputStream.close();
                    hashSet.add(file3);
                } catch (Exception e6) {
                    e = e6;
                    try {
                        e.printStackTrace();
                        gpg.O000000o(fileOutputStream);
                        File file4 = new File(O00000o.getFilesDir().getAbsolutePath() + File.separator + "tombstone");
                        while (r9 < r8) {
                        }
                        File file5 = new File(O00000o.getFilesDir().getParent() + File.separator + "app_bugly");
                        while (r9 < r8) {
                        }
                        File externalFilesDir = O00000o.getExternalFilesDir("MiPushLog");
                        while (r5 < r8) {
                        }
                        if (gpg.O000000o(new ArrayList(hashSet), str2)) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        gpg.O000000o(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                e.printStackTrace();
                gpg.O000000o(fileOutputStream);
                File file42 = new File(O00000o.getFilesDir().getAbsolutePath() + File.separator + "tombstone");
                while (r9 < r8) {
                }
                File file52 = new File(O00000o.getFilesDir().getParent() + File.separator + "app_bugly");
                while (r9 < r8) {
                }
                File externalFilesDir2 = O00000o.getExternalFilesDir("MiPushLog");
                while (r5 < r8) {
                }
                if (gpg.O000000o(new ArrayList(hashSet), str2)) {
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                gpg.O000000o(fileOutputStream);
                throw th;
            }
            gpg.O000000o(fileOutputStream);
            try {
                File file422 = new File(O00000o.getFilesDir().getAbsolutePath() + File.separator + "tombstone");
                if (file422.exists() && file422.isDirectory() && (listFiles3 = file422.listFiles()) != null && listFiles3.length > 0) {
                    for (File file6 : listFiles3) {
                        if (file6.length() > 0) {
                            hashSet.add(file6);
                        }
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                File file522 = new File(O00000o.getFilesDir().getParent() + File.separator + "app_bugly");
                if (file522.exists() && file522.isDirectory() && (listFiles2 = file522.listFiles()) != null && listFiles2.length > 0) {
                    for (File file7 : listFiles2) {
                        if (file7.length() > 0) {
                            hashSet.add(file7);
                        }
                    }
                }
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            try {
                File externalFilesDir22 = O00000o.getExternalFilesDir("MiPushLog");
                if (externalFilesDir22 != null && externalFilesDir22.exists() && externalFilesDir22.isDirectory() && (listFiles = externalFilesDir22.listFiles()) != null && listFiles.length > 0) {
                    for (File file8 : listFiles) {
                        if (file8.length() > 0) {
                            hashSet.add(file8);
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (gpg.O000000o(new ArrayList(hashSet), str2)) {
            return str2;
        }
        return null;
    }
}
