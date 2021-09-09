package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.google.android.exoplayer2.C;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;

public final class cof implements cog {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final boolean f14166O000000o;

    public cof(boolean z) {
        this.f14166O000000o = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[Catch:{ all -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[Catch:{ all -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    public final Bitmap O000000o(coh coh) throws IOException {
        O000000o o000000o;
        cod cod;
        ImageScaleType imageScaleType;
        int i;
        Bitmap decodeStream;
        coh coh2 = coh;
        InputStream O00000Oo2 = O00000Oo(coh);
        if (O00000Oo2 == null) {
            cou.O00000o("No stream for image [%s]", coh2.f14169O000000o);
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(O00000Oo2, null, options);
            String str = coh2.O00000Oo;
            if (coh2.O0000OOo) {
                if ("image/jpeg".equalsIgnoreCase(options.outMimeType) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE) {
                    o000000o = O000000o(str);
                    O00000Oo o00000Oo = new O00000Oo(new cod(options.outWidth, options.outHeight, o000000o.f14167O000000o), o000000o);
                    O00000Oo2 = O000000o(O00000Oo2, coh2);
                    cod = o00000Oo.f14168O000000o;
                    imageScaleType = coh2.O00000o;
                    if (imageScaleType != ImageScaleType.NONE) {
                        i = 1;
                    } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
                        i = cos.O000000o(cod);
                    } else {
                        i = cos.O000000o(cod, coh2.O00000o0, coh2.O00000oO, imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
                    }
                    if (i > 1 && this.f14166O000000o) {
                        cou.O000000o("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", cod, new cod(cod.f14165O000000o / i, cod.O00000Oo / i), Integer.valueOf(i), coh2.f14169O000000o);
                    }
                    BitmapFactory.Options options2 = coh2.O0000Oo0;
                    options2.inSampleSize = i;
                    decodeStream = BitmapFactory.decodeStream(O00000Oo2, null, options2);
                    if (decodeStream != null) {
                        cou.O00000o("Image can't be decoded [%s]", coh2.f14169O000000o);
                        return decodeStream;
                    }
                    int i2 = o00000Oo.O00000Oo.f14167O000000o;
                    boolean z = o00000Oo.O00000Oo.O00000Oo;
                    Matrix matrix = new Matrix();
                    ImageScaleType imageScaleType2 = coh2.O00000o;
                    if (imageScaleType2 == ImageScaleType.EXACTLY || imageScaleType2 == ImageScaleType.EXACTLY_STRETCHED) {
                        cod cod2 = new cod(decodeStream.getWidth(), decodeStream.getHeight(), i2);
                        float O00000Oo3 = cos.O00000Oo(cod2, coh2.O00000o0, coh2.O00000oO, imageScaleType2 == ImageScaleType.EXACTLY_STRETCHED);
                        if (Float.compare(O00000Oo3, 1.0f) != 0) {
                            matrix.setScale(O00000Oo3, O00000Oo3);
                            if (this.f14166O000000o) {
                                cou.O000000o("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", cod2, new cod((int) (((float) cod2.f14165O000000o) * O00000Oo3), (int) (((float) cod2.O00000Oo) * O00000Oo3)), Float.valueOf(O00000Oo3), coh2.f14169O000000o);
                            }
                        }
                    }
                    if (z) {
                        matrix.postScale(-1.0f, 1.0f);
                        if (this.f14166O000000o) {
                            cou.O000000o("Flip image horizontally [%s]", coh2.f14169O000000o);
                        }
                    }
                    if (i2 != 0) {
                        matrix.postRotate((float) i2);
                        if (this.f14166O000000o) {
                            cou.O000000o("Rotate image on %1$d° [%2$s]", Integer.valueOf(i2), coh2.f14169O000000o);
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                    if (createBitmap == decodeStream) {
                        return createBitmap;
                    }
                    decodeStream.recycle();
                    return createBitmap;
                }
            }
            o000000o = new O000000o();
            O00000Oo o00000Oo2 = new O00000Oo(new cod(options.outWidth, options.outHeight, o000000o.f14167O000000o), o000000o);
            O00000Oo2 = O000000o(O00000Oo2, coh2);
            cod = o00000Oo2.f14168O000000o;
            imageScaleType = coh2.O00000o;
            if (imageScaleType != ImageScaleType.NONE) {
            }
            cou.O000000o("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", cod, new cod(cod.f14165O000000o / i, cod.O00000Oo / i), Integer.valueOf(i), coh2.f14169O000000o);
            BitmapFactory.Options options22 = coh2.O0000Oo0;
            options22.inSampleSize = i;
            decodeStream = BitmapFactory.decodeStream(O00000Oo2, null, options22);
            if (decodeStream != null) {
            }
        } finally {
            cot.O000000o(O00000Oo2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: int} */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Multi-variable type inference failed */
    private static O000000o O000000o(String str) {
        boolean z;
        int i = 0;
        boolean z2 = true;
        try {
            switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt("Orientation", 1)) {
                case 1:
                    z2 = false;
                    z = z2;
                    break;
                case 2:
                    z = z2;
                    break;
                case 3:
                    z = i;
                    i = 180;
                    break;
                case 4:
                    i = 1;
                    z = i;
                    i = 180;
                    break;
                case 5:
                    i = 1;
                    z = i;
                    i = 270;
                    break;
                case 6:
                    z = i;
                    i = 90;
                    break;
                case 7:
                    i = 1;
                    z = i;
                    i = 90;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    z = i;
                    i = 270;
                    break;
                default:
                    z = false;
                    break;
            }
        } catch (IOException unused) {
            cou.O00000o0("Can't read EXIF tags from file [%s]", str);
        }
        return new O000000o(i, z);
    }

    private static InputStream O000000o(InputStream inputStream, coh coh) throws IOException {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        cot.O000000o(inputStream);
        return O00000Oo(coh);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f14167O000000o;
        public final boolean O00000Oo;

        protected O000000o() {
            this.f14167O000000o = 0;
            this.O00000Oo = false;
        }

        protected O000000o(int i, boolean z) {
            this.f14167O000000o = i;
            this.O00000Oo = z;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final cod f14168O000000o;
        public final O000000o O00000Oo;

        protected O00000Oo(cod cod, O000000o o000000o) {
            this.f14168O000000o = cod;
            this.O00000Oo = o000000o;
        }
    }

    private static InputStream O00000Oo(coh coh) throws IOException {
        return coh.O00000oo.getStream(coh.O00000Oo, coh.O0000O0o);
    }
}
