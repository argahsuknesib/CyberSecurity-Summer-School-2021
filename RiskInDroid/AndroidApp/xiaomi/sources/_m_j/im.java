package _m_j;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

public final class im extends jk {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f1458O000000o = 80;
    private float O00000Oo = 3.0f;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r4 != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        r15 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r4 != false) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc  */
    public final long O000000o(ViewGroup viewGroup, Transition transition, is isVar, is isVar2) {
        int i;
        is isVar3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long duration;
        if (isVar == null && isVar2 == null) {
            return 0;
        }
        Rect epicenter = transition.getEpicenter();
        boolean z = true;
        if (isVar2 == null || O00000Oo(isVar) == 0) {
            isVar3 = isVar;
            i = -1;
        } else {
            isVar3 = isVar2;
            i = 1;
        }
        int O000000o2 = jk.O000000o(isVar3, 0);
        int O000000o3 = jk.O000000o(isVar3, 1);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = viewGroup.getWidth() + round;
        int height = viewGroup.getHeight() + round2;
        if (epicenter != null) {
            int centerX = epicenter.centerX();
            i2 = epicenter.centerY();
            i3 = centerX;
        } else {
            i3 = (round + width) / 2;
            i2 = (round2 + height) / 2;
        }
        int i7 = this.f1458O000000o;
        if (i7 != 8388611) {
            if (i7 == 8388613) {
                if (cb.O0000Oo0(viewGroup) != 1) {
                    z = false;
                }
            }
            if (i7 != 3) {
                i4 = Math.abs(i2 - O000000o3) + (width - O000000o2);
            } else if (i7 == 5) {
                i4 = Math.abs(i2 - O000000o3) + (O000000o2 - round);
            } else if (i7 == 48) {
                i4 = Math.abs(i3 - O000000o2) + (height - O000000o3);
            } else if (i7 != 80) {
                i4 = 0;
            } else {
                i4 = Math.abs(i3 - O000000o2) + (O000000o3 - round2);
            }
            float f = (float) i4;
            i5 = this.f1458O000000o;
            if (i5 != 3 || i5 == 5 || i5 == 8388611 || i5 == 8388613) {
                i6 = viewGroup.getWidth();
            } else {
                i6 = viewGroup.getHeight();
            }
            float f2 = f / ((float) i6);
            duration = transition.getDuration();
            if (duration < 0) {
                duration = 300;
            }
            return (long) Math.round((((float) (duration * ((long) i))) / this.O00000Oo) * f2);
        } else if (cb.O0000Oo0(viewGroup) != 1) {
            z = false;
        }
        i7 = 5;
        if (i7 != 3) {
        }
        float f3 = (float) i4;
        i5 = this.f1458O000000o;
        if (i5 != 3) {
        }
        i6 = viewGroup.getWidth();
        float f22 = f3 / ((float) i6);
        duration = transition.getDuration();
        if (duration < 0) {
        }
        return (long) Math.round((((float) (duration * ((long) i))) / this.O00000Oo) * f22);
    }
}
