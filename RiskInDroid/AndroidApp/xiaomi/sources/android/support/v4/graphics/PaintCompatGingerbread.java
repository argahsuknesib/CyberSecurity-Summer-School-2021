package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;

@RequiresApi(9)
class PaintCompatGingerbread {
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal<>();

    PaintCompatGingerbread() {
    }

    static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("󟿽");
        float measureText2 = paint.measureText(str);
        if (measureText2 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText2 > 2.0f * measureText) {
                return false;
            }
            int i = 0;
            float f = 0.0f;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText2 >= f) {
                return false;
            }
        }
        if (measureText2 != measureText) {
            return true;
        }
        Pair<Rect, Rect> obtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds("󟿽", 0, 2, (Rect) obtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, (Rect) obtainEmptyRects.second);
        return !((Rect) obtainEmptyRects.first).equals(obtainEmptyRects.second);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        Pair<Rect, Rect> pair = sRectThreadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            sRectThreadLocal.set(pair2);
            return pair2;
        }
        ((Rect) pair.first).setEmpty();
        ((Rect) pair.second).setEmpty();
        return pair;
    }
}
