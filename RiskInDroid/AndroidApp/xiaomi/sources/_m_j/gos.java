package _m_j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class gos {
    private static int O000000o(int i) {
        if (i <= 0 || i > 1073741824) {
            throw new IllegalArgumentException();
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 16);
        int i4 = i3 | (i3 >> 8);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 2);
        return (i6 | (i6 >> 1)) + 1;
    }

    public static int O000000o(int i, int i2, int i3, int i4) {
        int O00000Oo = O00000Oo(i, i2, i3, i4);
        return O00000Oo <= 8 ? O000000o(O00000Oo) : ((O00000Oo + 7) / 8) * 8;
    }

    private static int O00000Oo(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i4 == -1 && i3 == -1) {
            return 1;
        }
        if (i4 != -1) {
            i5 = (int) Math.ceil(Math.sqrt((double) (((float) (i * i2)) / ((float) i4))));
        }
        if (i3 == -1) {
            return i5;
        }
        return Math.max(Math.min(i / i3, i2 / i3), i5);
    }

    public static Bitmap O000000o(Resources resources, int i, int i2, int i3) {
        int i4;
        int i5;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inJustDecodeBounds = false;
        if (i2 > 0) {
            i4 = (int) (((float) i2) / 1.0f);
        } else {
            i4 = options.outWidth;
        }
        if (i3 > 0) {
            i5 = (int) (((float) i3) / 1.0f);
        } else {
            i5 = options.outHeight;
        }
        options.inSampleSize = O000000o(options, i4 * i5);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        InputStream openRawResource = resources.openRawResource(i);
        Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
        try {
            openRawResource.close();
        } catch (IOException unused) {
        }
        return decodeStream;
    }

    public static void O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                bitmap.recycle();
            } catch (Throwable th) {
                Log.w("BitmapUtils", "unable recycle bitmap", th);
            }
        }
    }

    public static int O000000o(Bitmap bitmap, String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                return 0;
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private static int O000000o(BitmapFactory.Options options, int i) {
        int i2;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int i3 = 1;
        if (i == -1) {
            i2 = 1;
        } else {
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d * d2;
            double d4 = (double) i;
            Double.isNaN(d4);
            i2 = (int) Math.ceil(Math.sqrt(d3 / d4));
        }
        if (128 >= i2 && i == -1) {
            i2 = 1;
        }
        if (i2 > 8) {
            return ((i2 + 7) / 8) * 8;
        }
        while (i3 < i2) {
            i3 <<= 1;
        }
        return i3;
    }
}
