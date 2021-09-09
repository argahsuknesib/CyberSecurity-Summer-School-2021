package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import com.facebook.react.bridge.ReadableMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

public final class bdb {
    public static File O000000o(Context context, ReadableMap readableMap, boolean z) {
        bdc.O000000o(ReadableMap.class, readableMap, "storageOptions");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(externalFilesDir, "image-" + UUID.randomUUID().toString() + ".jpg");
        try {
            externalFilesDir.mkdirs();
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static bcx O000000o(Context context, ReadableMap readableMap, bcx bcx, int i, int i2, int i3) {
        int i4;
        int i5;
        bcx bcx2;
        bcx bcx3;
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable th2;
        Throwable th3;
        bcx bcx4 = bcx;
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        if (bcx4.O00000o0 == 0 && bcx4.O00000o == 0) {
            i5 = i;
            i4 = i2;
        } else {
            i5 = i;
            int i6 = i2;
            while (true) {
                if ((bcx4.O00000o0 == 0 || i5 > bcx4.O00000o0 * 2) && (bcx4.O00000o == 0 || i6 > bcx4.O00000o * 2)) {
                    options.inSampleSize *= 2;
                    i6 /= 2;
                    i5 /= 2;
                }
            }
            i4 = i6;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(bcx4.f12875O000000o.getAbsolutePath(), options);
        if (decodeFile == null) {
            return null;
        }
        if (bcx4.O00000o0 == 0 || bcx4.O00000o0 > i5) {
            bcx2 = new bcx(bcx4.f12875O000000o, bcx4.O00000Oo, i5, bcx4.O00000o, bcx4.O00000oO, bcx4.O00000oo, bcx4.O0000O0o);
        } else {
            bcx2 = bcx4;
        }
        if (bcx4.O00000o == 0 || bcx4.O00000o0 > i4) {
            bcx3 = new bcx(bcx2.f12875O000000o, bcx2.O00000Oo, bcx2.O00000o0, i4, bcx2.O00000oO, bcx2.O00000oo, bcx2.O0000O0o);
        } else {
            bcx3 = bcx2;
        }
        double d = (double) bcx3.O00000o0;
        double d2 = (double) i5;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) bcx3.O00000o;
        double d5 = (double) i4;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        if (d3 >= d6) {
            d3 = d6;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) bcx3.O00000oo);
        float f = (float) d3;
        matrix.postScale(f, f);
        try {
            int attributeInt = new ExifInterface(bcx3.f12875O000000o.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else if (attributeInt == 8) {
                matrix.postRotate(270.0f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, bcx3.O00000oO, byteArrayOutputStream);
        if (i3 == 13001) {
            z = true;
        }
        File O000000o2 = O000000o(context, readableMap, !z);
        if (O000000o2 == null) {
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            if (createBitmap != null) {
                createBitmap.recycle();
            }
            return bcx4;
        }
        bcx O00000Oo2 = bcx3.O00000Oo(O000000o2);
        try {
            fileOutputStream = new FileOutputStream(O00000Oo2.O00000Oo);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable th4) {
            th3.addSuppressed(th4);
        }
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        if (createBitmap != null) {
            createBitmap.recycle();
        }
        return O00000Oo2;
        throw th2;
    }

    public static void O000000o(int i, bcx bcx) {
        if (i == 13001) {
            if (bcx.f12875O000000o != null && bcx.f12875O000000o.exists()) {
                bcx.f12875O000000o.delete();
            }
            if (bcx.O00000Oo != null && bcx.O00000Oo.exists()) {
                bcx.O00000Oo.delete();
            }
        }
    }

    public static void O000000o(Context context, String str) {
        if (context != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, new MediaScannerConnection.OnScanCompletedListener() {
                /* class _m_j.bdb.AnonymousClass1 */

                public final void onScanCompleted(String str, Uri uri) {
                    gsy.O000000o(4, "TAG", "Finished scanning ".concat(String.valueOf(str)));
                }
            });
        }
    }

    public static O000000o O000000o(bcw bcw, bcx bcx) {
        int i = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(bcx.f12875O000000o.getAbsolutePath());
            float[] fArr = new float[2];
            exifInterface.getLatLong(fArr);
            float f = fArr[0];
            boolean z = true;
            float f2 = fArr[1];
            if (!(f == 0.0f && f2 == 0.0f)) {
                bcw.O000000o("latitude", (double) f);
                bcw.O000000o("longitude", (double) f2);
            }
            String attribute = exifInterface.getAttribute("DateTime");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                bcw.O000000o("timestamp", simpleDateFormat2.format(simpleDateFormat.parse(attribute)) + "Z");
            } catch (Exception unused) {
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt == 6) {
                    i = 90;
                } else if (attributeInt == 8) {
                    i = 270;
                }
                z = false;
            } else {
                i = 180;
            }
            bcw.O000000o("originalRotation", i);
            bcw.f12874O000000o.putBoolean("isVertical", z);
            return new O000000o(i, null);
        } catch (IOException e) {
            e.printStackTrace();
            return new O000000o(0, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a A[SYNTHETIC, Splitter:B:32:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072 A[Catch:{ IOException -> 0x006e }] */
    public static O00000Oo O000000o(bcx bcx) {
        FileChannel fileChannel;
        FileChannel channel;
        bcx bcx2;
        File file = bcx.O00000Oo == null ? bcx.f12875O000000o : bcx.O00000Oo;
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath(), file.getName());
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                }
                if (fileChannel2 != null) {
                }
                throw th;
            }
            try {
                fileChannel.transferTo(0, fileChannel.size(), channel);
                file.delete();
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e) {
                        try {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return new O00000Oo(bcx, e2);
                        }
                    }
                }
                if (channel != null) {
                    channel.close();
                }
                if (bcx.O00000Oo != null) {
                    bcx2 = bcx.O00000Oo(file2);
                } else {
                    bcx2 = bcx.O000000o(file2);
                }
                return new O00000Oo(bcx2, null);
            } catch (Throwable th2) {
                th = th2;
                fileChannel2 = channel;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        throw th;
                    }
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            if (fileChannel != null) {
            }
            if (fileChannel2 != null) {
            }
            throw th;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final bcx f12881O000000o;
        public final Throwable O00000Oo;

        public O00000Oo(bcx bcx, Throwable th) {
            this.f12881O000000o = bcx;
            this.O00000Oo = th;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f12880O000000o;
        public final Throwable O00000Oo;

        public O000000o(int i, Throwable th) {
            this.f12880O000000o = i;
            this.O00000Oo = th;
        }
    }
}
