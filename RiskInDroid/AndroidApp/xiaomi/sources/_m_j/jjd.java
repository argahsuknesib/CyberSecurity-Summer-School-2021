package _m_j;

import java.util.Arrays;
import java.util.List;

public final class jjd {

    /* renamed from: O000000o  reason: collision with root package name */
    public jjc[] f1877O000000o;
    public jjc[] O00000Oo;

    public final String toString() {
        List list;
        StringBuilder sb = new StringBuilder("ScalingMatrix{ScalingList4x4=");
        jjc[] jjcArr = this.f1877O000000o;
        List list2 = null;
        if (jjcArr == null) {
            list = null;
        } else {
            list = Arrays.asList(jjcArr);
        }
        sb.append(list);
        sb.append("\n, ScalingList8x8=");
        jjc[] jjcArr2 = this.O00000Oo;
        if (jjcArr2 != null) {
            list2 = Arrays.asList(jjcArr2);
        }
        sb.append(list2);
        sb.append("\n}");
        return sb.toString();
    }
}
