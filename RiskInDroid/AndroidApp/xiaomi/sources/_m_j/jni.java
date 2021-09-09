package _m_j;

import java.util.LinkedList;
import java.util.List;

final class jni implements jnn {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<jnu> f1972O000000o = new LinkedList();

    jni() {
    }

    public final void O000000o(jnh jnh) {
        if (jnh.O00000Oo() != 0) {
            if (!this.f1972O000000o.isEmpty()) {
                List<jnu> list = this.f1972O000000o;
                for (jnu O000000o2 : (jnu[]) list.toArray(new jnu[list.size()])) {
                    jnt.O000000o();
                    jnu O000000o3 = jnt.O000000o(jnh.f1971O000000o, jnh.O00000o, O000000o2);
                    if (O000000o3.O000000o()) {
                        jnh.O000000o(new jnp(jnh.O00000o0, O000000o3.O00000o0, (jnh.O00000o - O000000o3.O00000o0) + 1, 4));
                        if (!O000000o3.O00000o0()) {
                            this.f1972O000000o.remove(O000000o3);
                        }
                    } else if (O000000o3.O00000oO()) {
                        this.f1972O000000o.remove(O000000o3);
                    }
                }
            }
            jnt.O000000o();
            jnu O000000o4 = jnt.O000000o(jnh.f1971O000000o, jnh.O00000o);
            if (O000000o4.O000000o()) {
                jnh.O000000o(new jnp(jnh.O00000o0, jnh.O00000o, 1, 4));
                if (O000000o4.O00000o0()) {
                    this.f1972O000000o.add(O000000o4);
                }
            } else if (O000000o4.O00000o0()) {
                this.f1972O000000o.add(O000000o4);
            }
        } else {
            this.f1972O000000o.clear();
        }
        if (jnh.O00000o0()) {
            this.f1972O000000o.clear();
        }
        if (this.f1972O000000o.size() == 0) {
            jnh.O00000Oo("CJK_SEGMENTER");
        } else {
            jnh.O000000o("CJK_SEGMENTER");
        }
    }

    public final void O000000o() {
        this.f1972O000000o.clear();
    }
}
