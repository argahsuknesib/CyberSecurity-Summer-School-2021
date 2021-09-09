package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public final class hrx {
    public static final Bitmap O000000o(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(O00000Oo(view));
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    private static Bitmap O00000Oo(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate((float) (-view.getScrollX()), (float) (-view.getScrollY()));
        view.draw(canvas);
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b  */
    public static final Bitmap O000000o(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100 && i - 10 >= 10) {
            while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
                while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
                }
            }
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    public static final Bitmap O000000o(List<Bitmap> list, int i, int i2) {
        Rect rect;
        RectF rectF;
        if (list.size() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(list.get(0).getWidth(), i, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Bitmap bitmap = list.get(i3);
            float height = (float) (bitmap.getHeight() * i3);
            if (i3 != size - 1 || i2 <= 0) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                rectF = new RectF(0.0f, height, (float) bitmap.getWidth(), ((float) bitmap.getHeight()) + height);
            } else {
                rect = new Rect(0, bitmap.getHeight() - i2, bitmap.getWidth(), bitmap.getHeight());
                rectF = new RectF(0.0f, height, (float) bitmap.getWidth(), ((float) i2) + height);
            }
            canvas.drawBitmap(bitmap, rect, rectF, paint);
        }
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0060 A[SYNTHETIC, Splitter:B:39:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public static final void O000000o(Bitmap bitmap, String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap);
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                e.printStackTrace();
                if (fileOutputStream == null) {
                }
            }
        }
    }
}
