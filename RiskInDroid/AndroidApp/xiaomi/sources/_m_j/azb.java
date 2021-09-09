package _m_j;

import O000000o.O000000o.O00000Oo.O0000Oo.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

public final class azb {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f12719O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public int O00000oO;
    public int O00000oo;
    public a O0000O0o;
    public int O0000OOo;
    public float O0000Oo;
    public int O0000Oo0;
    public double O0000OoO;
    public int O0000Ooo;
    public float O0000o;
    public int O0000o0;
    public int O0000o00;
    public float O0000o0O = 1.0f;
    public float O0000o0o = 1.0f;
    public int O0000oO;
    public BitmapFactory.Options O0000oO0;
    public double O0000oOO;
    public double O0000oOo;
    public aza O0000oo0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f12720O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public int O00000oO;
        public int O00000oo;
        public a O0000O0o = a.TEXT;
        public int O0000OOo;
        public float O0000Oo = 12.0f;
        public int O0000Oo0;
        public double O0000OoO = 1.0d;
        public int O0000Ooo = -1;
        public aza O0000o;
        public int O0000o0 = 153600;
        public int O0000o00 = 2097152;
        public double O0000o0O = 10.0d;
        public double O0000o0o = 10.0d;
    }

    public azb(O000000o o000000o) {
        this.f12719O000000o = o000000o.f12720O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
        this.O0000O0o = o000000o.O0000O0o;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo0;
        this.O0000Oo = o000000o.O0000Oo;
        this.O0000OoO = o000000o.O0000OoO;
        this.O0000Ooo = o000000o.O0000Ooo;
        this.O0000oO = o000000o.O0000o00;
        this.O0000oOO = o000000o.O0000o0O;
        this.O0000oOo = o000000o.O0000o0o;
        this.O0000oo0 = o000000o.O0000o;
    }

    private static float O000000o(Context context, double d, double d2, double d3) {
        return TypedValue.applyDimension(2, (float) (d > 0.0d ? d * d3 : d2 * d3), context.getResources().getDisplayMetrics());
    }

    private static ByteArrayOutputStream O000000o(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                inputStream.close();
                return byteArrayOutputStream;
            }
        }
    }

    private static void O000000o(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
     arg types: [java.io.ByteArrayInputStream, int]
     candidates:
      ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.FileDescriptor, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
      ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.lang.String, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
      ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException} */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02b3, code lost:
        if (r0 != null) goto L_0x02b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02b5, code lost:
        r0.O00000Oo("图片转base64出错,请检查代码");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02bb, code lost:
        if (r2 != null) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02bd, code lost:
        r2.O000000o(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x027c, code lost:
        if (r0 != null) goto L_0x02b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0281, code lost:
        if (r2 != null) goto L_0x02bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02ed  */
    public final void O000000o() {
        Bitmap bitmap;
        aza aza;
        Bitmap bitmap2;
        aza aza2;
        String str;
        aza aza3;
        Bitmap bitmap3;
        InputStream inputStream;
        int i;
        int i2;
        int i3;
        int i4;
        aza aza4;
        if (!TextUtils.isEmpty(this.O00000Oo) || (aza4 = this.O0000oo0) == null) {
            try {
                this.O0000oO0 = new BitmapFactory.Options();
                this.O0000oO0.inJustDecodeBounds = true;
                if (!TextUtils.isEmpty(this.O00000o0)) {
                    String str2 = this.O00000o0;
                    inputStream = new ByteArrayInputStream(TextUtils.isEmpty(str2) ? null : str2.contains(",") ? Base64.decode(str2.split(",")[1], 0) : Base64.decode(str2, 0));
                } else if (!TextUtils.isEmpty(this.O00000o)) {
                    inputStream = Build.VERSION.SDK_INT >= 28 ? ayz.O000000o(this.f12719O000000o, this.O00000o) : new FileInputStream(this.O00000o);
                } else {
                    inputStream = this.f12719O000000o.getResources().getAssets().open("cat.jpg");
                }
                ByteArrayOutputStream O000000o2 = O000000o(inputStream);
                BitmapFactory.decodeStream(new ByteArrayInputStream(O000000o2.toByteArray()), null, this.O0000oO0);
                BitmapFactory.Options options = this.O0000oO0;
                this.O0000o00 = options.outWidth;
                this.O0000o0 = options.outHeight;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inJustDecodeBounds = false;
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance((InputStream) new ByteArrayInputStream(O000000o2.toByteArray()), false);
                if (newInstance != null) {
                    if (this.O00000oO <= 0 || this.O00000oo <= 0) {
                        this.O00000oO = this.O0000o00;
                        this.O00000oo = this.O0000o0;
                    }
                    BigDecimal bigDecimal = new BigDecimal(this.O0000o00);
                    BigDecimal bigDecimal2 = new BigDecimal(this.O0000o0);
                    BigDecimal bigDecimal3 = new BigDecimal(this.O00000oO);
                    BigDecimal bigDecimal4 = new BigDecimal(this.O00000oo);
                    this.O0000o0O = bigDecimal3.divide(bigDecimal, 4, 4).floatValue();
                    this.O0000o0o = bigDecimal4.divide(bigDecimal2, 4, 4).floatValue();
                    try {
                        bitmap2 = Bitmap.createBitmap(this.O00000oO, this.O00000oo, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        StringBuilder sb = new StringBuilder();
                        sb.append("=================================不能输出");
                        sb.append(this.O00000oO);
                        sb.append("x");
                        sb.append(this.O00000oo);
                        sb.append("像素的图片====================================");
                        double d = (double) (this.O00000oO * this.O00000oo * 4);
                        Double.isNaN(d);
                        double d2 = d * 1.0d;
                        double d3 = (double) this.O0000oO;
                        Double.isNaN(d3);
                        double sqrt = Math.sqrt(d2 / d3);
                        double d4 = (double) this.O00000oO;
                        Double.isNaN(d4);
                        this.O00000oO = (int) ((d4 * 1.0d) / sqrt);
                        double d5 = (double) this.O00000oo;
                        Double.isNaN(d5);
                        this.O00000oo = (int) ((d5 * 1.0d) / sqrt);
                        O000000o();
                        bitmap2 = null;
                    }
                    try {
                        double d6 = (double) this.O00000oO;
                        Double.isNaN(d6);
                        double d7 = (d6 * 1.0d) / 1080.0d;
                        float O000000o3 = O000000o(this.f12719O000000o, (double) this.O0000Oo, 12.0d, d7);
                        float O000000o4 = O000000o(this.f12719O000000o, this.O0000oOO, 10.0d, d7);
                        BitmapRegionDecoder bitmapRegionDecoder = newInstance;
                        float O000000o5 = O000000o(this.f12719O000000o, this.O0000oOo, 10.0d, d7);
                        Canvas canvas = new Canvas(bitmap2);
                        canvas.drawColor(0);
                        Paint paint = new Paint(1);
                        paint.setTextSize(O000000o3);
                        paint.setColor(this.O0000Ooo);
                        Rect rect = new Rect();
                        paint.getTextBounds(this.O00000Oo, 0, this.O00000Oo.length(), rect);
                        rect.width();
                        int height = rect.height();
                        paint.setStyle(Paint.Style.FILL);
                        paint.setAlpha((int) (this.O0000OoO * 255.0d));
                        this.O0000o = Math.max(this.O0000o0O, this.O0000o0o);
                        if (this.O0000o0O >= this.O0000o0o) {
                            double d8 = (double) this.O0000o0;
                            double d9 = (double) this.O00000oo;
                            Double.isNaN(d9);
                            double d10 = d9 * 1.0d;
                            double d11 = (double) this.O0000o;
                            Double.isNaN(d11);
                            double d12 = d10 / d11;
                            Double.isNaN(d8);
                            int i5 = (int) (((d8 - d12) * 1.0d) / 2.0d);
                            int i6 = this.O0000o00;
                            double d13 = (double) i5;
                            Double.isNaN(d13);
                            i = (int) (d12 + d13);
                            i2 = i6;
                            i4 = i5;
                            i3 = 0;
                        } else {
                            double d14 = (double) this.O0000o00;
                            double d15 = (double) this.O00000oO;
                            Double.isNaN(d15);
                            double d16 = d15 * 1.0d;
                            double d17 = (double) this.O0000o;
                            Double.isNaN(d17);
                            double d18 = d16 / d17;
                            Double.isNaN(d14);
                            i3 = (int) (((d14 - d18) * 1.0d) / 2.0d);
                            double d19 = (double) i3;
                            Double.isNaN(d19);
                            int i7 = (int) (d18 + d19);
                            i = this.O0000o0;
                            i2 = i7;
                            i4 = 0;
                        }
                        Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(new Rect(i3, i4, i2, i), this.O0000oO0);
                        Matrix matrix = new Matrix();
                        matrix.setScale(this.O0000o, this.O0000o);
                        canvas.drawBitmap(decodeRegion, matrix, null);
                        canvas.drawText(this.O00000Oo, O000000o4, ((float) height) + O000000o5, paint);
                        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                        canvas.save();
                        if (bitmap2 != null) {
                            str = ayy.O000000o(bitmap2);
                            if (TextUtils.isEmpty(str)) {
                                aza3 = this.O0000oo0;
                            } else {
                                aza2 = this.O0000oo0;
                            }
                            O000000o(bitmap2);
                            return;
                        }
                        aza = this.O0000oo0;
                        if (aza == null) {
                            return;
                        }
                        aza.O00000Oo("图片加水印失败，请检查代码");
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            e.getMessage();
                            if (bitmap2 != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            bitmap = bitmap2;
                            if (bitmap != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    bitmap3 = null;
                    try {
                        throw new NullPointerException("图片数据(path/base64)为空");
                    } catch (Exception e3) {
                        e = e3;
                        bitmap2 = bitmap3;
                        e.printStackTrace();
                        e.getMessage();
                        if (bitmap2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap = bitmap3;
                        if (bitmap != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                bitmap3 = null;
                bitmap2 = bitmap3;
                e.printStackTrace();
                e.getMessage();
                if (bitmap2 != null) {
                    str = ayy.O000000o(bitmap2);
                    if (TextUtils.isEmpty(str)) {
                        aza3 = this.O0000oo0;
                    } else {
                        aza2 = this.O0000oo0;
                    }
                    O000000o(bitmap2);
                    return;
                }
                aza = this.O0000oo0;
                if (aza == null) {
                    return;
                }
                aza.O00000Oo("图片加水印失败，请检查代码");
            } catch (Throwable th3) {
                th = th3;
                bitmap3 = null;
                bitmap = bitmap3;
                if (bitmap != null) {
                    String O000000o6 = ayy.O000000o(bitmap);
                    if (TextUtils.isEmpty(O000000o6)) {
                        aza aza5 = this.O0000oo0;
                        if (aza5 != null) {
                            aza5.O00000Oo("图片转base64出错,请检查代码");
                        }
                    } else {
                        aza aza6 = this.O0000oo0;
                        if (aza6 != null) {
                            aza6.O000000o(O000000o6);
                        }
                    }
                    O000000o(bitmap);
                } else {
                    aza aza7 = this.O0000oo0;
                    if (aza7 != null) {
                        aza7.O00000Oo("图片加水印失败，请检查代码");
                    }
                }
                throw th;
            }
        } else {
            aza4.O00000Oo("水印文本(text)不能为空");
        }
    }
}
