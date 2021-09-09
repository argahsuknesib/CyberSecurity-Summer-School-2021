package _m_j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

final class jnh {

    /* renamed from: O000000o  reason: collision with root package name */
    char[] f1971O000000o = new char[4096];
    int[] O00000Oo = new int[4096];
    int O00000o;
    int O00000o0;
    int O00000oO;
    Set<String> O00000oo = new HashSet();
    jnr O0000O0o = new jnr();
    Map<Integer, jnq> O0000OOo = new HashMap();
    jnf O0000Oo;
    LinkedList<jnp> O0000Oo0 = new LinkedList<>();

    public jnh(jnf jnf) {
        this.O0000Oo = jnf;
    }

    /* access modifiers changed from: package-private */
    public final char O000000o() {
        return this.f1971O000000o[this.O00000o];
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo() {
        return this.O00000Oo[this.O00000o];
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        this.O00000oo.add(str);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(String str) {
        this.O00000oo.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o0() {
        return this.O00000o == this.O00000oO - 1;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jnp jnp) {
        this.O0000O0o.O00000o0(jnp);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jnq jnq) {
        if (jnq != null) {
            this.O0000OOo.put(Integer.valueOf(jnq.f1977O000000o), jnq);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        int[] iArr = this.O00000Oo;
        if (4 == iArr[i]) {
            this.O0000Oo0.add(new jnp(this.O00000o0, i, 1, 64));
        } else if (8 == iArr[i]) {
            this.O0000Oo0.add(new jnp(this.O00000o0, i, 1, 8));
        }
    }
}
