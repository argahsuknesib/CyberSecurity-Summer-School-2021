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
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class jmm extends AsyncTask<Void, Void, WritableMap> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Promise f1959O000000o;
    private Bitmap O00000Oo;
    private ReadableMap O00000o;
    private byte[] O00000o0;
    private File O00000oO;
    private int O00000oo;
    private jml O0000O0o;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O00000Oo();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        WritableMap writableMap = (WritableMap) obj;
        super.onPostExecute(writableMap);
        if (writableMap == null) {
            return;
        }
        if (!this.O00000o.hasKey("fastMode") || !this.O00000o.getBoolean("fastMode")) {
            this.f1959O000000o.resolve(writableMap);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.O00000o.getInt("id"));
        createMap.putMap("data", writableMap);
        this.O0000O0o.O000000o(createMap);
    }

    public jmm(byte[] bArr, Promise promise, ReadableMap readableMap, File file, int i, jml jml) {
        this.f1959O000000o = promise;
        this.O00000o = readableMap;
        this.O00000o0 = bArr;
        this.O00000oO = file;
        this.O00000oo = i;
        this.O0000O0o = jml;
    }

    private void O000000o() throws IOException {
        if (this.O00000Oo == null) {
            byte[] bArr = this.O00000o0;
            this.O00000Oo = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        if (this.O00000Oo == null) {
            throw new IOException("Failed to decode Image Bitmap");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02ba A[SYNTHETIC, Splitter:B:129:0x02ba] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02cc A[SYNTHETIC, Splitter:B:136:0x02cc] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02dc A[SYNTHETIC, Splitter:B:143:0x02dc] */
    /* JADX WARNING: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fc A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0110 A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0139 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0146 A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0147 A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015d A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0177 A[Catch:{ NotFoundException -> 0x02a5, IOException -> 0x02a2, all -> 0x029f }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:133:0x02c0=Splitter:B:133:0x02c0, B:126:0x02ae=Splitter:B:126:0x02ae} */
    private WritableMap O00000Oo() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3;
        boolean z;
        dx dxVar;
        boolean z2;
        boolean z3;
        ReadableMap readableMap;
        WritableMap writableMap;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("deviceOrientation", this.O00000oo);
        createMap.putInt("pictureOrientation", this.O00000o.hasKey("orientation") ? this.O00000o.getInt("orientation") : this.O00000oo);
        try {
            byteArrayInputStream = new ByteArrayInputStream(this.O00000o0);
            try {
                if (this.O00000o.hasKey("fixOrientation")) {
                    if (this.O00000o.getBoolean("fixOrientation")) {
                        dxVar = new dx(byteArrayInputStream);
                        int O000000o2 = dxVar.O000000o("Orientation", 0);
                        if (O000000o2 != 0) {
                            O000000o();
                            Bitmap bitmap = this.O00000Oo;
                            int i = O000000o2 != 3 ? O000000o2 != 6 ? O000000o2 != 8 ? 0 : 270 : 90 : 180;
                            Matrix matrix = new Matrix();
                            matrix.postRotate((float) i);
                            this.O00000Oo = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            z = true;
                            if (this.O00000o.hasKey("width")) {
                                O000000o();
                                Bitmap bitmap2 = this.O00000Oo;
                                int i2 = this.O00000o.getInt("width");
                                this.O00000Oo = Bitmap.createScaledBitmap(bitmap2, i2, (int) (((float) bitmap2.getHeight()) * (((float) i2) / ((float) bitmap2.getWidth()))), true);
                            }
                            if (this.O00000o.hasKey("mirrorImage") && this.O00000o.getBoolean("mirrorImage")) {
                                O000000o();
                                Bitmap bitmap3 = this.O00000Oo;
                                Matrix matrix2 = new Matrix();
                                matrix2.preScale(-1.0f, 1.0f);
                                this.O00000Oo = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap3.getHeight(), matrix2, true);
                            }
                            z2 = !this.O00000o.hasKey("exif") && this.O00000o.getBoolean("exif");
                            if (this.O00000o.hasKey("writeExif")) {
                                int i3 = AnonymousClass1.f1960O000000o[this.O00000o.getType("writeExif").ordinal()];
                                if (i3 == 1) {
                                    z3 = this.O00000o.getBoolean("writeExif");
                                    readableMap = null;
                                    if (!z2) {
                                    }
                                    if (!z2) {
                                    }
                                } else if (i3 == 2) {
                                    readableMap = this.O00000o.getMap("writeExif");
                                    z3 = true;
                                    if (!z2 || z3) {
                                        if (this.O00000Oo == null && readableMap == null) {
                                            if (!z2) {
                                                writableMap = null;
                                                if (this.O00000Oo != null) {
                                                    writableMap.putInt("width", this.O00000Oo.getWidth());
                                                    writableMap.putInt("height", this.O00000Oo.getHeight());
                                                    if (z) {
                                                        writableMap.putInt("Orientation", 1);
                                                    }
                                                }
                                                if (z2) {
                                                    createMap.putMap("exif", writableMap);
                                                }
                                            }
                                        }
                                        if (dxVar == null) {
                                            dxVar = new dx(byteArrayInputStream);
                                        }
                                        writableMap = jlu.O000000o(dxVar);
                                        if (readableMap != null) {
                                            writableMap.merge(readableMap);
                                        }
                                        if (this.O00000Oo != null) {
                                        }
                                        if (z2) {
                                        }
                                    } else {
                                        writableMap = null;
                                    }
                                    if (this.O00000Oo == null) {
                                        BitmapFactory.Options options = new BitmapFactory.Options();
                                        options.inJustDecodeBounds = true;
                                        BitmapFactory.decodeByteArray(this.O00000o0, 0, this.O00000o0.length, options);
                                        createMap.putInt("width", options.outWidth);
                                        createMap.putInt("height", options.outHeight);
                                        if (!this.O00000o.hasKey("doNotSave") || !this.O00000o.getBoolean("doNotSave")) {
                                            File file = new File(jmr.O000000o(this.O00000oO, ".jpg"));
                                            file.createNewFile();
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            fileOutputStream.write(this.O00000o0);
                                            fileOutputStream.flush();
                                            fileOutputStream.close();
                                            if (z3 && readableMap != null) {
                                                dx dxVar2 = new dx(file.getAbsolutePath());
                                                jlu.O000000o(dxVar2, readableMap);
                                                dxVar2.O000000o();
                                            } else if (!z3) {
                                                dx dxVar3 = new dx(file.getAbsolutePath());
                                                jlu.O00000Oo(dxVar3);
                                                dxVar3.O000000o();
                                            }
                                            createMap.putString("uri", Uri.fromFile(file).toString());
                                        }
                                        if (this.O00000o.hasKey("base64") && this.O00000o.getBoolean("base64")) {
                                            createMap.putString("base64", Base64.encodeToString(this.O00000o0, 2));
                                        }
                                    } else {
                                        createMap.putInt("width", this.O00000Oo.getWidth());
                                        createMap.putInt("height", this.O00000Oo.getHeight());
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        this.O00000Oo.compress(Bitmap.CompressFormat.JPEG, (int) (this.O00000o.getDouble("quality") * 100.0d), byteArrayOutputStream);
                                        if (!this.O00000o.hasKey("doNotSave") || !this.O00000o.getBoolean("doNotSave")) {
                                            String O000000o3 = O000000o(byteArrayOutputStream);
                                            if (z3 && writableMap != null) {
                                                dx dxVar4 = new dx(O000000o3);
                                                jlu.O000000o(dxVar4, writableMap);
                                                dxVar4.O000000o();
                                            }
                                            createMap.putString("uri", Uri.fromFile(new File(O000000o3)).toString());
                                        }
                                        if (this.O00000o.hasKey("base64") && this.O00000o.getBoolean("base64")) {
                                            createMap.putString("base64", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                                        }
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return createMap;
                                }
                            }
                            readableMap = null;
                            z3 = true;
                            if (!z2) {
                            }
                            if (!z2) {
                            }
                        }
                        z = false;
                        if (this.O00000o.hasKey("width")) {
                        }
                        O000000o();
                        Bitmap bitmap32 = this.O00000Oo;
                        Matrix matrix22 = new Matrix();
                        matrix22.preScale(-1.0f, 1.0f);
                        this.O00000Oo = Bitmap.createBitmap(bitmap32, 0, 0, bitmap32.getWidth(), bitmap32.getHeight(), matrix22, true);
                        if (!this.O00000o.hasKey("exif")) {
                        }
                        if (this.O00000o.hasKey("writeExif")) {
                        }
                        readableMap = null;
                        z3 = true;
                        if (!z2) {
                        }
                        if (!z2) {
                        }
                    }
                }
                dxVar = null;
                z = false;
                if (this.O00000o.hasKey("width")) {
                }
                O000000o();
                Bitmap bitmap322 = this.O00000Oo;
                Matrix matrix222 = new Matrix();
                matrix222.preScale(-1.0f, 1.0f);
                this.O00000Oo = Bitmap.createBitmap(bitmap322, 0, 0, bitmap322.getWidth(), bitmap322.getHeight(), matrix222, true);
                if (!this.O00000o.hasKey("exif")) {
                }
                if (this.O00000o.hasKey("writeExif")) {
                }
                readableMap = null;
                z3 = true;
                if (!z2) {
                }
                if (!z2) {
                }
            } catch (Resources.NotFoundException e2) {
                e = e2;
                byteArrayInputStream3 = byteArrayInputStream;
                this.f1959O000000o.reject("E_TAKING_PICTURE_FAILED", "Documents directory of the app could not be found.", e);
                e.printStackTrace();
                if (byteArrayInputStream2 != null) {
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayInputStream2 = byteArrayInputStream;
                try {
                    this.f1959O000000o.reject("E_TAKING_PICTURE_FAILED", "An unknown I/O exception has occurred.", e);
                    e.printStackTrace();
                    if (byteArrayInputStream2 != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (byteArrayInputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayInputStream != null) {
                }
                throw th;
            }
        } catch (Resources.NotFoundException e4) {
            e = e4;
            byteArrayInputStream3 = null;
            this.f1959O000000o.reject("E_TAKING_PICTURE_FAILED", "Documents directory of the app could not be found.", e);
            e.printStackTrace();
            if (byteArrayInputStream2 != null) {
                return null;
            }
            byteArrayInputStream2.close();
            return null;
        } catch (IOException e5) {
            e = e5;
            byteArrayInputStream2 = null;
            this.f1959O000000o.reject("E_TAKING_PICTURE_FAILED", "An unknown I/O exception has occurred.", e);
            e.printStackTrace();
            if (byteArrayInputStream2 != null) {
                return null;
            }
            try {
                byteArrayInputStream2.close();
                return null;
            } catch (IOException e6) {
                e6.printStackTrace();
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* renamed from: _m_j.jmm$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1960O000000o = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f1960O000000o[ReadableType.Boolean.ordinal()] = 1;
            f1960O000000o[ReadableType.Map.ordinal()] = 2;
        }
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
            str = jmr.O000000o(this.O00000oO, ".jpg");
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
