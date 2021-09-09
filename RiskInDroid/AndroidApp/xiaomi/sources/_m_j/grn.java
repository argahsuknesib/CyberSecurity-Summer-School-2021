package _m_j;

import android.view.View;

public final class grn extends grm {

    /* renamed from: O000000o  reason: collision with root package name */
    private final float[] f18184O000000o = {0.7f, 0.9f, 1.0f};
    private float[] O00000Oo;
    private float[] O00000o0;

    public final void O000000o(View view, float f, float f2) {
        float max = Math.max(f, f2);
        float[] fArr = {0.9f, 1.0f};
        float O000000o2 = gro.O000000o(max, fArr, fArr);
        view.setScaleX(O000000o2);
        view.setScaleY(O000000o2);
        view.setRotationX(gro.O000000o(max, this.f18184O000000o, this.O00000Oo));
        view.setRotationY(gro.O000000o(max, this.f18184O000000o, this.O00000o0));
    }

    public final void O000000o(View view, int i) {
        float[] fArr;
        int[] iArr;
        if (i == -4) {
            fArr = new float[]{-4.75f, 0.0f};
        } else if (i == -3) {
            fArr = new float[]{4.75f, 0.0f};
        } else if (i == -2) {
            fArr = new float[]{0.0f, -4.75f};
        } else if (i != -1) {
            fArr = new float[]{0.0f, 0.0f};
        } else {
            fArr = new float[]{0.0f, 4.75f};
        }
        this.O00000Oo = new float[]{0.0f, fArr[0], 0.0f};
        this.O00000o0 = new float[]{0.0f, fArr[1], 0.0f};
        if (i == -4) {
            iArr = new int[]{view.getMeasuredWidth() / 2, view.getMeasuredHeight()};
        } else if (i == -3) {
            iArr = new int[]{view.getMeasuredWidth() / 2, 0};
        } else if (i != -2) {
            iArr = i != -1 ? new int[]{0, 0} : new int[]{view.getMeasuredWidth(), view.getMeasuredHeight() / 2};
        } else {
            iArr = new int[]{0, view.getMeasuredHeight() / 2};
        }
        view.setPivotX((float) iArr[0]);
        view.setPivotY((float) iArr[1]);
    }
}
