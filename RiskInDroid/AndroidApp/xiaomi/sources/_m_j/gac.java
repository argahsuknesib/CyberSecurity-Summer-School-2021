package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public final class gac {
    public static Bitmap O000000o(int i, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColor(i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRect(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
