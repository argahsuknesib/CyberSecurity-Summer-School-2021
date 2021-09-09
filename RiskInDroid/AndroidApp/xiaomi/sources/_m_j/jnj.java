package _m_j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class jnj implements jnn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f1973O000000o = "一二两三四五六七八九十零壹贰叁肆伍陆柒捌玖拾百千万亿拾佰仟萬億兆卅廿";
    private static Set<Character> O00000Oo = new HashSet();
    private int O00000o = -1;
    private int O00000o0 = -1;
    private List<jnu> O00000oO = new LinkedList();

    static {
        for (char valueOf : f1973O000000o.toCharArray()) {
            O00000Oo.add(Character.valueOf(valueOf));
        }
    }

    jnj() {
    }

    public final void O000000o() {
        this.O00000o0 = -1;
        this.O00000o = -1;
        this.O00000oO.clear();
    }

    private void O00000Oo(jnh jnh) {
        if (this.O00000o0 >= 0 && this.O00000o >= 0) {
            int i = jnh.O00000o0;
            int i2 = this.O00000o0;
            jnh.O000000o(new jnp(i, i2, (this.O00000o - i2) + 1, 16));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008b, code lost:
        if (2 != r0.O00000o) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0094, code lost:
        if ((r0.f1976O000000o + r0.O00000Oo) != r13.O00000o) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    public final void O000000o(jnh jnh) {
        boolean z;
        if (this.O00000o0 == -1 && this.O00000o == -1) {
            if (4 == jnh.O00000Oo() && O00000Oo.contains(Character.valueOf(jnh.O000000o()))) {
                this.O00000o0 = jnh.O00000o;
                this.O00000o = jnh.O00000o;
            }
        } else if (4 != jnh.O00000Oo() || !O00000Oo.contains(Character.valueOf(jnh.O000000o()))) {
            O00000Oo(jnh);
            this.O00000o0 = -1;
            this.O00000o = -1;
        } else {
            this.O00000o = jnh.O00000o;
        }
        if (!(!jnh.O00000o0() || this.O00000o0 == -1 || this.O00000o == -1)) {
            O00000Oo(jnh);
            this.O00000o0 = -1;
            this.O00000o = -1;
        }
        if ((this.O00000o0 == -1 || this.O00000o == -1) && this.O00000oO.isEmpty()) {
            if (!jnh.O0000O0o.O00000o()) {
                jnp O00000o02 = jnh.O0000O0o.O00000o0();
                if (16 != O00000o02.O00000o) {
                }
            }
            z = false;
            if (z) {
                if (4 == jnh.O00000Oo()) {
                    if (!this.O00000oO.isEmpty()) {
                        List<jnu> list = this.O00000oO;
                        for (jnu O000000o2 : (jnu[]) list.toArray(new jnu[list.size()])) {
                            jnt.O000000o();
                            jnu O000000o3 = jnt.O000000o(jnh.f1971O000000o, jnh.O00000o, O000000o2);
                            if (O000000o3.O000000o()) {
                                jnh.O000000o(new jnp(jnh.O00000o0, O000000o3.O00000o0, (jnh.O00000o - O000000o3.O00000o0) + 1, 32));
                                if (!O000000o3.O00000o0()) {
                                    this.O00000oO.remove(O000000o3);
                                }
                            } else if (O000000o3.O00000oO()) {
                                this.O00000oO.remove(O000000o3);
                            }
                        }
                    }
                    jnt.O000000o();
                    jnu O00000Oo2 = jnt.O00000Oo(jnh.f1971O000000o, jnh.O00000o);
                    if (O00000Oo2.O000000o()) {
                        jnh.O000000o(new jnp(jnh.O00000o0, jnh.O00000o, 1, 32));
                        if (O00000Oo2.O00000o0()) {
                            this.O00000oO.add(O00000Oo2);
                        }
                    } else if (O00000Oo2.O00000o0()) {
                        this.O00000oO.add(O00000Oo2);
                    }
                } else {
                    this.O00000oO.clear();
                }
                if (jnh.O00000o0()) {
                    this.O00000oO.clear();
                }
            }
            if (this.O00000o0 == -1 || this.O00000o != -1 || !this.O00000oO.isEmpty()) {
                jnh.O000000o("QUAN_SEGMENTER");
            } else {
                jnh.O00000Oo("QUAN_SEGMENTER");
                return;
            }
        }
        z = true;
        if (z) {
        }
        if (this.O00000o0 == -1) {
        }
        jnh.O000000o("QUAN_SEGMENTER");
    }
}
