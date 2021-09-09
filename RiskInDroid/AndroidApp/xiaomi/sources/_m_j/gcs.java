package _m_j;

import java.util.List;

public final class gcs {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17542O000000o;
    public int O00000Oo;
    private boolean O00000o = false;
    public int O00000o0;

    public gcs() {
    }

    public gcs(int i, int i2, int i3) {
        this.f17542O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
    }

    public final String O000000o() {
        return this.f17542O000000o + "##" + this.O00000Oo;
    }

    public static gcs O000000o(gcs gcs, float f) {
        if (gcs != null && !gcs.O00000o && f > 0.0f && f != 1.0f) {
            gcs.f17542O000000o = (int) (((float) gcs.f17542O000000o) * f);
            gcs.O00000Oo = (int) (((float) gcs.O00000Oo) * f);
            gcs.O00000o = true;
        }
        return gcs;
    }

    public static List<gcs> O000000o(List<gcs> list, float f) {
        if (!(list == null || list.size() == 0)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                O000000o(list.get(i), f);
            }
        }
        return list;
    }
}
