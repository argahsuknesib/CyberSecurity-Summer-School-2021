package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public final class hhl extends ImageSpan {
    public hhl(Drawable drawable) {
        super(drawable);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.ascent + ((fontMetricsInt2.descent - fontMetricsInt2.ascent) / 2);
            int i4 = (bounds.bottom - bounds.top) / 2;
            fontMetricsInt.ascent = i3 - i4;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = i3 + i4;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        return bounds.right;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f, (float) (((i4 + fontMetricsInt.descent) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2)));
        drawable.draw(canvas);
        canvas.restore();
    }
}
