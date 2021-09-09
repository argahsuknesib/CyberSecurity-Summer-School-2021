package _m_j;

import android.view.View;

public abstract class jk extends iq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f1892O000000o = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public final void O000000o(is isVar) {
        View view = isVar.O00000Oo;
        Integer num = (Integer) isVar.f1596O000000o.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        isVar.f1596O000000o.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        isVar.f1596O000000o.put("android:visibilityPropagation:center", iArr);
    }

    public final String[] O000000o() {
        return f1892O000000o;
    }

    public static int O00000Oo(is isVar) {
        Integer num;
        if (isVar == null || (num = (Integer) isVar.f1596O000000o.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    static int O000000o(is isVar, int i) {
        int[] iArr;
        if (isVar == null || (iArr = (int[]) isVar.f1596O000000o.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }
}
