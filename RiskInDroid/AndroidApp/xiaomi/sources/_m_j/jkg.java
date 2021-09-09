package _m_j;

import java.util.Arrays;
import java.util.List;

public final class jkg {

    /* renamed from: O000000o  reason: collision with root package name */
    public jkf[] f1900O000000o;
    public jkf[] O00000Oo;

    public final String toString() {
        List list;
        StringBuilder sb = new StringBuilder("ScalingMatrix{ScalingList4x4=");
        jkf[] jkfArr = this.f1900O000000o;
        List list2 = null;
        if (jkfArr == null) {
            list = null;
        } else {
            list = Arrays.asList(jkfArr);
        }
        sb.append(list);
        sb.append("\n, ScalingList8x8=");
        jkf[] jkfArr2 = this.O00000Oo;
        if (jkfArr2 != null) {
            list2 = Arrays.asList(jkfArr2);
        }
        sb.append(list2);
        sb.append("\n}");
        return sb.toString();
    }
}
