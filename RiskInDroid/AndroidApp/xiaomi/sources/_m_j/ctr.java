package _m_j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class ctr extends AsyncTask<Void, Void, WritableMap> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Promise f14349O000000o;
    private byte[] O00000Oo;
    private File O00000o;
    private ReadableMap O00000o0;
    private Bitmap O00000oO;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        WritableMap writableMap = (WritableMap) obj;
        super.onPostExecute(writableMap);
        if (writableMap != null) {
            this.f14349O000000o.resolve(writableMap);
        }
    }

    public ctr(byte[] bArr, Promise promise, ReadableMap readableMap) {
        this.f14349O000000o = promise;
        this.O00000o0 = readableMap;
        this.O00000Oo = bArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    private WritableMap O000000o() {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        WritableMap createMap = Arguments.createMap();
        if (this.O00000oO == null) {
            byte[] bArr = this.O00000Oo;
            this.O00000oO = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            byteArrayInputStream = new ByteArrayInputStream(this.O00000Oo);
        } else {
            byteArrayInputStream = null;
        }
        if (byteArrayInputStream != null) {
            try {
                dx dxVar = new dx(byteArrayInputStream);
                int O000000o2 = dxVar.O000000o("Orientation", 0);
                if (this.O00000o0.hasKey("width")) {
                    Bitmap bitmap = this.O00000oO;
                    int i = this.O00000o0.getInt("width");
                    this.O00000oO = Bitmap.createScaledBitmap(bitmap, i, (int) (((float) bitmap.getHeight()) * (((float) i) / ((float) bitmap.getWidth()))), true);
                }
                if (this.O00000o0.hasKey("fixOrientation") && this.O00000o0.getBoolean("fixOrientation") && O000000o2 != 0) {
                    Bitmap bitmap2 = this.O00000oO;
                    int i2 = O000000o2 != 3 ? O000000o2 != 6 ? O000000o2 != 8 ? 0 : 270 : 90 : 180;
                    Matrix matrix = new Matrix();
                    matrix.postRotate((float) i2);
                    this.O00000oO = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                }
                if (this.O00000o0.hasKey("mirrorImage") && this.O00000o0.getBoolean("mirrorImage")) {
                    Bitmap bitmap3 = this.O00000oO;
                    Matrix matrix2 = new Matrix();
                    matrix2.preScale(-1.0f, 1.0f);
                    this.O00000oO = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap3.getHeight(), matrix2, true);
                }
                if (this.O00000o0.hasKey("exif") && this.O00000o0.getBoolean("exif")) {
                    createMap.putMap("exif", cte.O000000o(dxVar));
                }
            } catch (Resources.NotFoundException e) {
                this.f14349O000000o.reject("E_TAKING_PICTURE_FAILED", "Documents directory of the app could not be found.", e);
                e.printStackTrace();
                if (byteArrayInputStream == null) {
                    return null;
                }
                byteArrayInputStream.close();
                return null;
            } catch (IOException e2) {
                this.f14349O000000o.reject("E_TAKING_PICTURE_FAILED", "An unknown I/O exception has occurred.", e2);
                e2.printStackTrace();
                if (byteArrayInputStream == null) {
                    return null;
                }
                try {
                    byteArrayInputStream.close();
                    return null;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th2;
            }
        }
        createMap.putInt("width", this.O00000oO.getWidth());
        createMap.putInt("height", this.O00000oO.getHeight());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.O00000oO.compress(Bitmap.CompressFormat.JPEG, (int) (this.O00000o0.getDouble("quality") * 100.0d), byteArrayOutputStream);
        createMap.putString("uri", Uri.fromFile(new File(O000000o(byteArrayOutputStream))).toString());
        if (this.O00000o0.hasKey("base64") && this.O00000o0.getBoolean("base64")) {
            createMap.putString("base64", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        }
        byteArrayOutputStream.close();
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
            byteArrayInputStream2 = null;
        } else {
            byteArrayInputStream2 = byteArrayInputStream;
        }
        if (byteArrayInputStream2 != null) {
            try {
                byteArrayInputStream2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        return createMap;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:21:0x002a */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r4 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0035 A[SYNTHETIC, Splitter:B:29:0x0035] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private String O000000o(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        String str;
        FileOutputStream fileOutputStream;
        ? r0 = 0;
        try {
            str = ctt.O000000o(this.O00000o, ".jpg");
            fileOutputStream = new FileOutputStream(str);
            try {
                byteArrayOutputStream.writeTo(fileOutputStream);
            } catch (IOException e) {
                e = e;
                r0 = e;
                try {
                    r0.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (r0 != 0) {
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = fileOutputStream;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
                r0 = r0;
            }
        } catch (IOException e4) {
            e = e4;
            str = null;
            fileOutputStream = null;
            r0 = e;
            r0.printStackTrace();
            if (fileOutputStream != null) {
            }
            if (r0 != 0) {
            }
        } catch (Throwable th2) {
        }
        if (r0 != 0) {
            return str;
        }
        throw r0;
    }
}
