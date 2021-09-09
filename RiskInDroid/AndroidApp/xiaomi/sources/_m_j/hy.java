package _m_j;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

public final class hy extends jk {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f966O000000o = 3.0f;

    public final long O000000o(ViewGroup viewGroup, Transition transition, is isVar, is isVar2) {
        int i;
        int i2;
        int i3;
        if (isVar == null && isVar2 == null) {
            return 0;
        }
        if (isVar2 == null || O00000Oo(isVar) == 0) {
            i = -1;
        } else {
            isVar = isVar2;
            i = 1;
        }
        int O000000o2 = jk.O000000o(isVar, 0);
        int O000000o3 = jk.O000000o(isVar, 1);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i3 = epicenter.centerX();
            i2 = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i2 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i3 = round;
        }
        float O000000o4 = O000000o((float) O000000o2, (float) O000000o3, (float) i3, (float) i2) / O000000o(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i))) / this.f966O000000o) * O000000o4);
    }

    private static float O000000o(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }
}
