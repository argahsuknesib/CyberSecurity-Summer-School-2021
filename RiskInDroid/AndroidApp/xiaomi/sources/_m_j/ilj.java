package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.util.NetworkType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public class ilj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f1440O000000o;
    public static Bitmap O00000Oo;
    private static String O00000o;
    public static Map<String, Set<O00000o0>> O00000o0 = new ConcurrentHashMap();
    private static String O00000oO;
    private static ExecutorService O00000oo = Executors.newCachedThreadPool();
    private static OkHttpClient O0000O0o;
    private static Cache O0000OOo;

    public interface O00000Oo {
        void O000000o(Bitmap bitmap);
    }

    public static String O000000o(Context context, String str) {
        String str2;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            str2 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName() + "/files/soundtiepian";
        } else {
            str2 = context.getFilesDir().getPath() + "/soundtiepian";
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + str;
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public O00000Oo f1443O000000o;
        public int O00000Oo;
        public int O00000o0;

        public O00000o0(O00000Oo o00000Oo, int i, int i2) {
            this.f1443O000000o = o00000Oo;
            this.O00000Oo = i;
            this.O00000o0 = i2;
        }
    }

    public static void O000000o(Bitmap bitmap, String str) {
        Set<O00000o0> set = O00000o0.get(str);
        if (set != null) {
            for (O00000o0 o00000o0 : set) {
                if (o00000o0 == null || o00000o0.f1443O000000o == null || (bitmap != null && (bitmap == null || bitmap.isRecycled()))) {
                    if (o00000o0 != null) {
                        O000000o(o00000o0.f1443O000000o, (Bitmap) null);
                    }
                } else if (o00000o0.O00000Oo <= 0 || o00000o0.O00000o0 <= 0) {
                    O000000o(o00000o0.f1443O000000o, bitmap);
                } else {
                    O000000o(o00000o0.f1443O000000o, ThumbnailUtils.extractThumbnail(bitmap, o00000o0.O00000Oo, o00000o0.O00000o0));
                }
            }
            O00000o0.remove(str);
        }
    }

    static void O000000o(final O00000Oo o00000Oo, final Bitmap bitmap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class _m_j.ilj.AnonymousClass1 */

            public final void run() {
                if (o00000Oo != null) {
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        o00000Oo.O000000o(null);
                        return;
                    }
                    try {
                        o00000Oo.O000000o(bitmap);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        });
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f1442O000000o;
        int O00000Oo;
        private Context O00000o;
        O00000Oo O00000o0;
        private String O00000oO;
        private Track O00000oo;
        private long O0000O0o;

        public O000000o(Context context, String str, Track track) {
            this.O00000o = context;
            this.O00000oO = str;
            this.O00000oo = track;
            if (track != null) {
                this.O0000O0o = track.f12166O000000o;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
            if (r0.toString().equals(_m_j.ilj.f1440O000000o) != false) goto L_0x0080;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
        public final void run() {
            boolean z;
            O00000Oo o00000Oo;
            String str = this.O00000oO;
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.O0000O0o);
                if (str.equals(sb.toString())) {
                    Track O000000o2 = iiu.O000000o(this.O0000O0o);
                    if (O000000o2 != null) {
                        this.O00000oo.O0000o00 = O000000o2.O0000o00;
                        this.O00000oo.O0000Ooo = O000000o2.O0000Ooo;
                        this.O00000oo.O0000OoO = O000000o2.O0000OoO;
                    }
                    this.O00000oO = ilj.O000000o(O000000o2);
                    z = true;
                    Bitmap bitmap = null;
                    bitmap = ilj.O000000o(this.O00000o, this.O00000oO, this.f1442O000000o, this.O00000Oo);
                    o00000Oo = this.O00000o0;
                    if (o00000Oo == null) {
                        ilj.O000000o(o00000Oo, bitmap);
                        return;
                    }
                    if (!this.O00000oO.equals(ilj.f1440O000000o)) {
                        if (z) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.O0000O0o);
                        }
                        ilj.O00000o0.remove(this.O00000oO);
                        return;
                    }
                    ilj.O00000Oo = bitmap;
                    ilj.O000000o(bitmap, ilj.f1440O000000o);
                    return;
                }
            }
            z = false;
            Bitmap bitmap2 = null;
            try {
                bitmap2 = ilj.O000000o(this.O00000o, this.O00000oO, this.f1442O000000o, this.O00000Oo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            o00000Oo = this.O00000o0;
            if (o00000Oo == null) {
            }
        }
    }

    static Bitmap O000000o(Context context, String str, int i, int i2) {
        boolean z;
        CacheControl cacheControl;
        String str2;
        O00000o = context.getCacheDir().getAbsolutePath() + File.separator + "picasso-cache";
        File externalFilesDir = context.getExternalFilesDir("images");
        if (externalFilesDir == null || !externalFilesDir.exists()) {
            O00000oO = O00000o;
        } else {
            O00000oO = externalFilesDir.getAbsolutePath() + File.separator + "images";
        }
        String str3 = O00000o + File.separator + imd.O000000o(str) + ".1";
        boolean exists = new File(str3).exists();
        boolean z2 = true;
        if (!exists) {
            StringBuilder sb = new StringBuilder();
            sb.append(O00000oO);
            sb.append(File.separator);
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str2 = null;
            } else {
                str2 = imd.O000000o(str) + str.substring(lastIndexOf + 1);
            }
            sb.append(str2);
            String sb2 = sb.toString();
            z = new File(sb2).exists();
            if (z) {
                str3 = sb2;
            }
        } else {
            z = exists;
        }
        if (z) {
            return O000000o(str3, i, i2);
        }
        if (NetworkType.O000000o(context) == NetworkType.NetWorkType.NETWORKTYPE_INVALID) {
            z2 = false;
        }
        if (!z2) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            cacheControl = new CacheControl.Builder().build();
        }
        try {
            Request.Builder tag = iiy.O000000o(O000000o(str), (Map<String, String>) null).tag(str);
            if (cacheControl != null) {
                tag.cacheControl(cacheControl);
            }
            try {
                Response execute = O000000o(context).newCall(tag.build()).execute();
                if (execute != null && execute.code() == 200) {
                    if (new File(str3).exists()) {
                        execute.body().close();
                        return O000000o(str3, i, i2);
                    }
                    InputStream byteStream = execute.body().byteStream();
                    Bitmap decodeStream = BitmapFactory.decodeStream(byteStream);
                    Util.closeQuietly(byteStream);
                    return decodeStream;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (XimalayaException | Exception unused) {
        }
        return null;
    }

    public static void O000000o() {
        f1440O000000o = null;
        O00000o = null;
        O00000Oo = null;
        O00000o0.clear();
        O0000O0o = null;
        O0000OOo = null;
    }

    private static OkHttpClient O000000o(Context context) {
        if (O0000O0o == null) {
            synchronized (ilj.class) {
                if (O0000O0o == null) {
                    OkHttpClient O000000o2 = iiz.O000000o().O000000o((URL) null);
                    O0000O0o = O000000o2;
                    OkHttpClient.Builder newBuilder = O000000o2.newBuilder();
                    newBuilder.cache(O00000Oo(context));
                    O0000O0o = newBuilder.build();
                }
            }
        }
        return O0000O0o;
    }

    public static void O000000o(Config config) {
        OkHttpClient okHttpClient = O0000O0o;
        if (okHttpClient != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            ijk.O000000o(config, newBuilder, false);
            O0000O0o = newBuilder.build();
        }
    }

    private static Cache O00000Oo(Context context) {
        if (O0000OOo == null) {
            synchronized (ilj.class) {
                if (O0000OOo == null) {
                    File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    O0000OOo = new Cache(file, O00000Oo(file));
                }
            }
        }
        return O0000OOo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    private static long O00000Oo(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800L), 5242880L);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    private static Bitmap O000000o(String str, int i, int i2) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i3 = 0;
        if (i > 0 || i2 > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = O000000o(options, i, i2);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
        } else {
            try {
                bitmap = BitmapFactory.decodeFile(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        ExifInterface O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 == null) {
            return bitmap;
        }
        int attributeInt = O00000Oo2.getAttributeInt("Orientation", 1);
        if (attributeInt == 6) {
            i3 = 90;
        } else if (attributeInt == 3) {
            i3 = 180;
        } else if (attributeInt == 8) {
            i3 = 270;
        }
        if (!(bitmap == null || i3 == 0)) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i3, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap != createBitmap) {
                return createBitmap;
            }
        }
        return bitmap;
    }

    private static int O000000o(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    private static ExifInterface O00000Oo(String str) {
        try {
            return new ExifInterface(str);
        } catch (IOException unused) {
            return null;
        }
    }

    public static void O000000o(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File O000000o2 : listFiles) {
                        O000000o(O000000o2);
                    }
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://")) {
        }
        return str;
    }

    public static String O000000o(Track track) {
        if (track != null) {
            if (!TextUtils.isEmpty(track.O0000o00)) {
                return track.O0000o00;
            }
            if (!TextUtils.isEmpty(track.O0000Ooo)) {
                return track.O0000Ooo;
            }
            if (!TextUtils.isEmpty(track.O0000OoO)) {
                return track.O0000OoO;
            }
        }
        return "";
    }

    public static void O000000o(Context context, Track track, int i, int i2, O00000Oo o00000Oo) {
        String str;
        if (ilg.O000000o()) {
            str = "";
            if (track != null) {
                if (!TextUtils.isEmpty(track.O0000o00)) {
                    str = track.O0000o00;
                }
                if (TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(track.f12166O000000o);
                    str = sb.toString();
                }
            }
        } else {
            str = O000000o(track);
        }
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            o00000Oo.O000000o(null);
        } else if (context == null) {
            o00000Oo.O000000o(null);
        } else {
            synchronized (ilj.class) {
                boolean z = false;
                if (!str.equals(f1440O000000o)) {
                    f1440O000000o = str;
                    O00000o0.clear();
                    O00000Oo = null;
                } else if (O00000Oo != null) {
                    o00000Oo.O000000o(O00000Oo);
                    return;
                }
                Object obj = O00000o0.get(str);
                if (obj == null) {
                    obj = new CopyOnWriteArraySet();
                    z = true;
                }
                obj.add(new O00000o0(o00000Oo, i, i2));
                O00000o0.put(str, obj);
                if (z) {
                    if (O00000oo == null || O00000oo.isShutdown()) {
                        O00000oo = Executors.newCachedThreadPool();
                    }
                    try {
                        O00000oo.execute(new O000000o(context, str, track));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
