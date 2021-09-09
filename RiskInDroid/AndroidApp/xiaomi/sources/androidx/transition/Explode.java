package androidx.transition;

import _m_j.hy;
import _m_j.is;
import _m_j.iu;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.xiaomi.smarthome.R;

public class Explode extends Visibility {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final TimeInterpolator f3011O000000o = new DecelerateInterpolator();
    private static final TimeInterpolator O00000Oo = new AccelerateInterpolator();
    private int[] O00000o0 = new int[2];

    public Explode() {
        setPropagation(new hy());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPropagation(new hy());
    }

    private void O000000o(is isVar) {
        View view = isVar.O00000Oo;
        view.getLocationOnScreen(this.O00000o0);
        int[] iArr = this.O00000o0;
        int i = iArr[0];
        int i2 = iArr[1];
        isVar.f1596O000000o.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    public void captureStartValues(is isVar) {
        super.captureStartValues(isVar);
        O000000o(isVar);
    }

    public void captureEndValues(is isVar) {
        super.captureEndValues(isVar);
        O000000o(isVar);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        if (isVar2 == null) {
            return null;
        }
        Rect rect = (Rect) isVar2.f1596O000000o.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        O000000o(viewGroup, rect, this.O00000o0);
        int[] iArr = this.O00000o0;
        return iu.O000000o(view, isVar2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, f3011O000000o, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        float f;
        float f2;
        if (isVar == null) {
            return null;
        }
        Rect rect = (Rect) isVar.f1596O000000o.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) isVar.O00000Oo.getTag(R.id.transition_position);
        if (iArr != null) {
            f2 = ((float) (iArr[0] - rect.left)) + translationX;
            f = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f2 = translationX;
            f = translationY;
        }
        O000000o(viewGroup, rect, this.O00000o0);
        int[] iArr2 = this.O00000o0;
        return iu.O000000o(view, isVar, i, i2, translationX, translationY, f2 + ((float) iArr2[0]), f + ((float) iArr2[1]), O00000Oo, this);
    }

    private void O000000o(View view, Rect rect, int[] iArr) {
        int i;
        int i2;
        View view2 = view;
        view2.getLocationOnScreen(this.O00000o0);
        int[] iArr2 = this.O00000o0;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i2 = (view.getWidth() / 2) + i3 + Math.round(view.getTranslationX());
            i = (view.getHeight() / 2) + i4 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            i = epicenter.centerY();
            i2 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i2);
        float centerY = (float) (rect.centerY() - i);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float O000000o2 = O000000o(centerX2, centerY);
        float O000000o3 = O000000o(view2, i2 - i3, i - i4);
        iArr[0] = Math.round((centerX2 / O000000o2) * O000000o3);
        iArr[1] = Math.round(O000000o3 * (centerY / O000000o2));
    }

    private static float O000000o(View view, int i, int i2) {
        return O000000o((float) Math.max(i, view.getWidth() - i), (float) Math.max(i2, view.getHeight() - i2));
    }

    private static float O000000o(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
