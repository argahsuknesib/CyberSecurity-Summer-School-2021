package _m_j;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public final class ik implements TypeEvaluator<Rect> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Rect f1380O000000o;

    public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        int i = rect.left + ((int) (((float) (rect2.left - rect.left)) * f));
        int i2 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f));
        int i3 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f));
        int i4 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f));
        Rect rect3 = this.f1380O000000o;
        if (rect3 == null) {
            return new Rect(i, i2, i3, i4);
        }
        rect3.set(i, i2, i3, i4);
        return this.f1380O000000o;
    }

    public ik() {
    }

    public ik(Rect rect) {
        this.f1380O000000o = rect;
    }
}
