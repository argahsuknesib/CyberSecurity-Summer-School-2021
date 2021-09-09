package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public final class cpr {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[SYNTHETIC, Splitter:B:31:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[SYNTHETIC, Splitter:B:42:0x0088] */
    public static Bitmap O000000o(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        boolean z;
        int i;
        Bitmap decodeByteArray;
        IOException e;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                z = true;
                Integer valueOf = Integer.valueOf(new dx(byteArrayInputStream).O000000o("Orientation", 1));
                switch (valueOf.intValue()) {
                    case 1:
                    case 2:
                        i = 0;
                        break;
                    case 3:
                    case 4:
                        i = 180;
                        break;
                    case 5:
                    case 6:
                        i = 90;
                        break;
                    case 7:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        i = 270;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (!(valueOf.intValue() == 2 || valueOf.intValue() == 4 || valueOf.intValue() == 5 || valueOf.intValue() == 7)) {
                    z = false;
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    i = 0;
                    z = false;
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (i != 0) {
                    }
                    Matrix matrix = new Matrix();
                    matrix.setRotate((float) i);
                    Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                    decodeByteArray.recycle();
                    return createBitmap;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            byteArrayInputStream = null;
            e = iOException;
            e.printStackTrace();
            if (byteArrayInputStream != null) {
            }
            i = 0;
            z = false;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (i != 0) {
            }
            Matrix matrix2 = new Matrix();
            matrix2.setRotate((float) i);
            Bitmap createBitmap2 = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix2, true);
            decodeByteArray.recycle();
            return createBitmap2;
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
            }
            throw th;
        }
        decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (i != 0 && !z) {
            return decodeByteArray;
        }
        Matrix matrix22 = new Matrix();
        matrix22.setRotate((float) i);
        Bitmap createBitmap22 = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix22, true);
        decodeByteArray.recycle();
        return createBitmap22;
    }
}
