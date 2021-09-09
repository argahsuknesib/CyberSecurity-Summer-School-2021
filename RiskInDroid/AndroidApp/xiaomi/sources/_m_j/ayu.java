package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.hannto.opencv.SmartCropper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ayu {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (r2.getWidth() >= r2.getHeight()) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static Bitmap O000000o(String str) {
        ExifInterface exifInterface;
        if (!TextUtils.isEmpty(str) && str.contains(",")) {
            str = str.split(",")[1];
        }
        int i = 0;
        byte[] decode = Base64.decode(str, 0);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
                exifInterface = new ExifInterface(byteArrayInputStream);
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                exifInterface = null;
            }
            if (exifInterface != null) {
                int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
                if (attributeInt == 3) {
                    i = 180;
                } else if (attributeInt != 6) {
                    if (attributeInt == 8) {
                        i = 270;
                    }
                }
            }
            if (i != 0) {
                return decodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate((float) i);
            return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
        }
        i = 90;
        if (i != 0) {
        }
    }

    public static String O000000o(String str, Point[] pointArr) {
        return O000000o(SmartCropper.O000000o(O000000o(str), pointArr, O00o0000.O00000Oo, O00o0000.O00000o0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[SYNTHETIC, Splitter:B:16:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e A[SYNTHETIC, Splitter:B:22:0x003e] */
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
                        str = null;
                        return "data:image/jpeg;base64,".concat(String.valueOf(str));
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.flush();
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
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                str = null;
                return "data:image/jpeg;base64,".concat(String.valueOf(str));
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream2 != null) {
                }
                throw th;
            }
        } else {
            str = null;
        }
        if (byteArrayOutputStream2 != null) {
            try {
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        return "data:image/jpeg;base64,".concat(String.valueOf(str));
    }
}
