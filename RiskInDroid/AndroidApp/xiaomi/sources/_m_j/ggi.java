package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.FileInputStream;
import java.io.IOException;

public final class ggi {
    public static Bitmap O000000o(String str) {
        Context appContext = ServiceApplication.getAppContext();
        Bitmap O000000o2 = O000000o(str, gpc.O00000Oo(appContext), gpc.O000000o());
        gsy.O00000o0(LogType.HOME_ROOM, "zzzGetBitmapFromPath ", str);
        if (O000000o2 != null) {
            return O000000o2;
        }
        gsy.O00000o0(LogType.HOME_ROOM, "zzzGetBitmapFromPath ", "bitmap == null");
        return O000000o(gpc.O00000Oo(appContext), gpc.O000000o(), appContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r0 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0062, code lost:
        if (r0 != null) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[SYNTHETIC, Splitter:B:27:0x005d] */
    private static Bitmap O000000o(String str, int i, int i2) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i3 = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
                int i4 = options.outWidth;
                int i5 = options.outHeight;
                while (i4 > i && i5 > i2) {
                    i3++;
                    i4 = options.outWidth / i3;
                    i5 = options.outHeight / i3;
                }
                options.inSampleSize = i3;
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return decodeFileDescriptor;
            } catch (IOException unused2) {
            } catch (OutOfMemoryError e) {
                e = e;
                try {
                    gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException unused4) {
            fileInputStream = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            fileInputStream = null;
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
        return null;
    }

    private static Bitmap O000000o(int i, int i2, Context context) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), R.drawable.style_1_favorites, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            while (i4 > i && i5 > i2) {
                i3++;
                i4 = options.outWidth / i3;
                i5 = options.outHeight / i3;
            }
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inDensity = options.inTargetDensity;
            return BitmapFactory.decodeResource(context.getResources(), R.drawable.style_1_favorites, options);
        } catch (OutOfMemoryError e) {
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
            return null;
        }
    }
}
