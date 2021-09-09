package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.app.NotificationCompat;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.lang.reflect.Field;
import java.util.Hashtable;

public final class etp {
    public static boolean O000000o(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
            window.setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O00000Oo(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            int i3 = i2 | i;
            cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int O000000o(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static idf O000000o(int[] iArr, int i, int i2) {
        icy icy = new icy(new idt(new idd(i, i2, iArr)));
        igv igv = new igv();
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        try {
            return igv.O000000o(icy, hashtable);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (ChecksumException e2) {
            e2.printStackTrace();
            return null;
        } catch (FormatException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static idf O000000o(byte[] bArr, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            icy icy = new icy(new idt(new idc(bArr, i, i2, 0, 0, i, i2, true)));
            igv igv = new igv();
            Hashtable hashtable = new Hashtable();
            hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
            return igv.O000000o(icy, hashtable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void O000000o(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = i3 * i4;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i4) {
            int i9 = i5;
            int i10 = i7;
            int i11 = 0;
            while (i11 < i3) {
                int i12 = (iArr[i8] & 16711680) >> 16;
                int i13 = (iArr[i8] & 65280) >> 8;
                int i14 = iArr[i8] & 255;
                i8++;
                int i15 = (((((i12 * -38) - (i13 * 74)) + (i14 * 112)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                int i16 = (((((i12 * 112) - (i13 * 94)) - (i14 * 18)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                int max = Math.max(0, Math.min((((((i12 * 66) + (i13 * 129)) + (i14 * 25)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + 16, 255));
                int max2 = Math.max(0, Math.min(i15, 255));
                int max3 = Math.max(0, Math.min(i16, 255));
                int i17 = i10 + 1;
                bArr[i10] = (byte) max;
                if (i6 % 2 == 0 && i11 % 2 == 0) {
                    int i18 = i9 + 1;
                    bArr[i9] = (byte) max3;
                    i9 = i18 + 1;
                    bArr[i18] = (byte) max2;
                }
                i11++;
                i10 = i17;
            }
            i6++;
            i7 = i10;
            i5 = i9;
        }
    }

    public static String O00000Oo(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void O000000o(Canvas canvas, Paint paint, idg idg, idg idg2, float f) {
        if (idg != null && idg2 != null) {
            canvas.drawLine(f * idg.f1209O000000o, f * idg.O00000Oo, f * idg2.f1209O000000o, f * idg2.O00000Oo, paint);
        }
    }
}
