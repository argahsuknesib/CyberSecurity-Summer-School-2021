package _m_j;

import _m_j.O00O0Oo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Base64;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.TitleParams;
import com.xiaomi.smarthome.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class ayy {

    public interface O000000o {
        void O000000o(int i, String str);

        void O000000o(String str);
    }

    private static int O000000o(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap O000000o(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap O000000o(String str) {
        ExifInterface exifInterface;
        Bitmap O00000o0 = O00000o0(str);
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        int i = 0;
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt == 8) {
                i = 270;
            }
        }
        if (i == 0) {
            return O00000o0;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(O00000o0, 0, 0, O00000o0.getWidth(), O00000o0.getHeight(), matrix, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[SYNTHETIC, Splitter:B:16:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b A[SYNTHETIC, Splitter:B:22:0x003b] */
    public static String O000000o(Bitmap bitmap) {
        String str;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (IOException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream2 != null) {
                }
                throw th;
            }
        } else {
            str = null;
        }
        if (byteArrayOutputStream2 == null) {
            return str;
        }
        try {
            byteArrayOutputStream2.close();
            return str;
        } catch (IOException e5) {
            e5.printStackTrace();
            return str;
        }
    }

    public static void O000000o(FragmentActivity fragmentActivity, int i, int i2, View.OnClickListener onClickListener) {
        String format = String.format(fragmentActivity.getString(R.string.ht_image_resolution_txt), String.valueOf(i), String.valueOf(i2));
        O00O0Oo.O000000o o000000o = new O00O0Oo.O000000o(fragmentActivity);
        String string = fragmentActivity.getString(R.string.ht_default_alert_title);
        CircleParams circleParams = o000000o.O00000o0;
        if (circleParams.O00000o0 == null) {
            circleParams.O00000o0 = new TitleParams();
        }
        o000000o.O00000o0.O00000o0.f4345O000000o = string;
        o000000o.O00000o();
        o000000o.O00000o0.O00000o.O00000Oo = format;
        o000000o.O00000Oo(fragmentActivity.getString(R.string.ht_button_cancel), null).O000000o(fragmentActivity.getString(R.string.ht_button_confirm), onClickListener).O00000o0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static boolean O000000o(String str, int i, int i2) {
        int[] iArr = new int[0];
        try {
            iArr = O00000Oo(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (iArr.length < 2) {
            return false;
        }
        if (iArr[0] == iArr[1]) {
            return iArr[0] < i;
        }
        if (iArr[0] >= i2 && iArr[1] >= i && iArr[0] >= i && iArr[1] >= i2) {
            return false;
        }
    }

    public static boolean O000000o(String str, String str2, String str3, O000000o o000000o) {
        if (str2.replace("file://", "").isEmpty()) {
            o000000o.O000000o(-4, "imagePath is null");
            return false;
        } else if (str3.isEmpty()) {
            o000000o.O000000o(-5, "imagePath is null");
            return false;
        } else if (O00000o(str)) {
            return true;
        } else {
            o000000o.O000000o(-2, "create parent folder failed");
            return false;
        }
    }

    private static int[] O00000Oo(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        boolean z = exifInterface != null && ((attributeInt = exifInterface.getAttributeInt("Orientation", 0)) == 6 || attributeInt == 8);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return z ? new int[]{options.outHeight, options.outWidth} : new int[]{options.outWidth, options.outHeight};
    }

    private static boolean O00000o(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    private static Bitmap O00000o0(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = false;
        Bitmap bitmap = null;
        int i = 1;
        while (!z && i <= 64) {
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
                if (bitmap == null) {
                    i *= 2;
                    options.inSampleSize = i;
                } else {
                    z = true;
                }
            } catch (OutOfMemoryError unused) {
                i *= 2;
                options.inSampleSize = i;
            }
        }
        return bitmap;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static void O000000o(String str, String str2, String str3, int i, int i2, int i3, O000000o o000000o) {
        if (O000000o(str2, str, str3, o000000o)) {
            String replace = str.replace("file://", "");
            String str4 = str3 + ".jpg";
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(replace, options);
                options.inSampleSize = O000000o(options, i, i2);
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(replace, options);
                int attributeInt = new ExifInterface(replace).getAttributeInt("Orientation", 0);
                Matrix matrix = new Matrix();
                if (attributeInt == 6) {
                    matrix.postRotate(90.0f);
                } else if (attributeInt == 3) {
                    matrix.postRotate(180.0f);
                } else if (attributeInt == 8) {
                    matrix.postRotate(270.0f);
                }
                Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i4 = 100;
                while (true) {
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                    if (byteArrayOutputStream.toByteArray().length / 1024 > i3) {
                        byteArrayOutputStream.reset();
                        i4 -= 10;
                    } else {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2, str4));
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        o000000o.O000000o(new File(str2, str4).getAbsolutePath());
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                o000000o.O000000o(-1, e.getMessage());
            }
        }
    }
}
