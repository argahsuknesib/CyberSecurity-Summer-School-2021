package _m_j;

import com.xiaomi.push.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class eou {

    public static final class O000000o extends eor {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f15683O000000o = 0;
        public List<String> O00000Oo = Collections.emptyList();
        private boolean O00000o;
        private boolean O00000o0;
        private boolean O00000oO = false;
        private boolean O00000oo;
        private int O0000O0o = 0;
        private boolean O0000OOo;
        private int O0000Oo = -1;
        private boolean O0000Oo0 = false;

        public static O000000o O00000Oo(elx elx) {
            return new O000000o().O000000o(elx);
        }

        public final int O000000o() {
            if (this.O0000Oo < 0) {
                O00000Oo();
            }
            return this.O0000Oo;
        }

        public final void O000000o(c cVar) {
            if (this.O00000o0) {
                cVar.O000000o(this.f15683O000000o);
            }
            if (this.O00000o) {
                cVar.O000000o(2, this.O00000oO);
            }
            if (this.O00000oo) {
                cVar.O000000o(3, this.O0000O0o);
            }
            if (this.O0000OOo) {
                cVar.O000000o(4, this.O0000Oo0);
            }
            for (String O000000o2 : this.O00000Oo) {
                cVar.O000000o(5, O000000o2);
            }
        }

        public final int O00000Oo() {
            int i = 0;
            int O00000Oo2 = this.O00000o0 ? c.O00000Oo(this.f15683O000000o) + 0 : 0;
            if (this.O00000o) {
                O00000Oo2 += c.O00000o0(2) + 1;
            }
            if (this.O00000oo) {
                O00000Oo2 += c.O00000Oo(3, this.O0000O0o);
            }
            if (this.O0000OOo) {
                O00000Oo2 += c.O00000o0(4) + 1;
            }
            for (String O000000o2 : this.O00000Oo) {
                i += c.O000000o(O000000o2);
            }
            int size = O00000Oo2 + i + (this.O00000Oo.size() * 1);
            this.O0000Oo = size;
            return size;
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public O000000o O000000o(elx elx) {
            while (true) {
                int O000000o2 = elx.O000000o();
                if (O000000o2 == 0) {
                    return this;
                }
                if (O000000o2 == 8) {
                    int O00000oO2 = elx.O00000oO();
                    this.O00000o0 = true;
                    this.f15683O000000o = O00000oO2;
                } else if (O000000o2 == 16) {
                    boolean O00000Oo2 = elx.O00000Oo();
                    this.O00000o = true;
                    this.O00000oO = O00000Oo2;
                } else if (O000000o2 == 24) {
                    int O00000oO3 = elx.O00000oO();
                    this.O00000oo = true;
                    this.O0000O0o = O00000oO3;
                } else if (O000000o2 == 32) {
                    boolean O00000Oo3 = elx.O00000Oo();
                    this.O0000OOo = true;
                    this.O0000Oo0 = O00000Oo3;
                } else if (O000000o2 == 42) {
                    String O00000o02 = elx.O00000o0();
                    if (this.O00000Oo.isEmpty()) {
                        this.O00000Oo = new ArrayList();
                    }
                    this.O00000Oo.add(O00000o02);
                } else if (!elx.O00000Oo(O000000o2)) {
                    return this;
                }
            }
        }
    }
}
