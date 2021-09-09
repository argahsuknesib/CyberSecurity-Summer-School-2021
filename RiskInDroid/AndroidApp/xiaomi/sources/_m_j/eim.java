package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class eim extends BitmapFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    static Object f15322O000000o = new Object();
    private static byte[] O00000Oo = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final Paint O00000o;
    private static final ThreadLocal<Canvas> O00000o0 = new ThreadLocal<>();

    static {
        Paint paint = new Paint(1);
        O00000o = paint;
        paint.setFilterBitmap(true);
        O00000o.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static Bitmap O000000o(Context context, Bitmap bitmap) {
        return O000000o(context, bitmap, context.getResources().getDimensionPixelSize(R.dimen.contact_photo_width));
    }

    public static Bitmap O000000o(Context context, Bitmap bitmap, int i) {
        Resources resources = context.getResources();
        return O000000o(bitmap, resources.getDrawable(R.drawable.ic_contact_photo_mask), resources.getDrawable(R.drawable.ic_contact_photo_fg), resources.getDrawable(R.drawable.ic_contact_photo_bg), i);
    }

    public static boolean O000000o(Bitmap bitmap, String str) throws IOException {
        return O00000Oo(bitmap, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a  */
    private static boolean O00000Oo(Bitmap bitmap, String str) throws IOException {
        if (bitmap == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.close();
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static Canvas O000000o() {
        Canvas canvas = O00000o0.get();
        if (canvas != null) {
            return canvas;
        }
        Canvas canvas2 = new Canvas();
        O00000o0.set(canvas2);
        return canvas2;
    }

    private static Bitmap O000000o(Bitmap bitmap, Drawable drawable, Drawable drawable2, Drawable drawable3, int i) {
        return O000000o(bitmap, null, drawable, drawable2, drawable3, new Rect(0, 0, i, i));
    }

    private static Bitmap O000000o(Bitmap bitmap, Bitmap bitmap2, Drawable drawable, Drawable drawable2, Drawable drawable3, Rect rect) {
        if (rect.height() <= 0 || rect.width() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Bitmap O000000o2 = O000000o(bitmap, drawable, null, rect);
        Canvas O000000o3 = O000000o();
        O000000o3.setBitmap(createBitmap);
        if (drawable3 != null) {
            drawable3.setBounds(rect);
            drawable3.draw(O000000o3);
        }
        O000000o3.drawBitmap(O000000o2, rect, rect, (Paint) null);
        O000000o2.recycle();
        if (drawable2 != null) {
            drawable2.setBounds(rect);
            drawable2.draw(O000000o3);
        }
        return createBitmap;
    }

    private static Bitmap O000000o(Bitmap bitmap, Drawable drawable, Rect rect, Rect rect2) {
        int i;
        int i2;
        Bitmap bitmap2 = null;
        if (rect2 == null) {
            return null;
        }
        if (rect2.height() > 0 && rect2.width() > 0) {
            bitmap2 = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
            Canvas O000000o2 = O000000o();
            O000000o2.setBitmap(bitmap2);
            int i3 = 0;
            O000000o2.drawColor(0, PorterDuff.Mode.CLEAR);
            if (drawable != null) {
                drawable.setBounds(rect2);
                drawable.draw(O000000o2);
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = rect2.width();
            float height2 = (float) rect2.height();
            float f = (float) width2;
            float f2 = height2 / f;
            float f3 = (float) width;
            float f4 = f3 / f;
            float f5 = (float) height;
            float f6 = f5 / height2;
            if (f4 > f6) {
                int i4 = (int) (f5 / f2);
                i3 = (width - i4) / 2;
                width = i4;
            } else if (f4 < f6) {
                i = (int) (f2 * f3);
                i2 = (height - i) / 2;
                O000000o2.drawBitmap(bitmap, new Rect(i3, i2, width + i3, i + i2), rect2, O00000o);
            }
            i = height;
            i2 = 0;
            O000000o2.drawBitmap(bitmap, new Rect(i3, i2, width + i3, i + i2), rect2, O00000o);
        }
        return bitmap2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|11) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
    public static File O000000o(Context context, InputStream inputStream, String str) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(context.openFileOutput(str, 0));
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return context.getFileStreamPath(str);
                }
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        }
    }
}
