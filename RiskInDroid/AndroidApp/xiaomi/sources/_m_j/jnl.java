package _m_j;

import _m_j.jnr;
import java.util.Stack;
import java.util.TreeSet;

final class jnl {
    jnl() {
    }

    static jnq O000000o(jnr.O000000o o000000o) {
        TreeSet treeSet = new TreeSet();
        jnq jnq = new jnq();
        Stack<jnr.O000000o> O000000o2 = O000000o(o000000o, jnq);
        treeSet.add(jnq.O000000o());
        while (!O000000o2.isEmpty()) {
            jnr.O000000o pop = O000000o2.pop();
            O000000o(pop.O00000o0, jnq);
            O000000o(pop, jnq);
            treeSet.add(jnq.O000000o());
        }
        return (jnq) treeSet.first();
    }

    private static Stack<jnr.O000000o> O000000o(jnr.O000000o o000000o, jnq jnq) {
        Stack<jnr.O000000o> stack = new Stack<>();
        while (o000000o != null && o000000o.O00000o0 != null) {
            jnp jnp = o000000o.O00000o0;
            boolean z = true;
            if (jnq.O00000o()) {
                jnq.O00000o0(jnp);
                jnq.f1977O000000o = jnp.f1976O000000o;
                jnq.O00000Oo = jnp.f1976O000000o + jnp.O00000Oo;
                jnq.O00000o0 += jnp.O00000Oo;
            } else if (jnq.O00000Oo(jnp)) {
                z = false;
            } else {
                jnq.O00000o0(jnp);
                jnq.O00000o0 += jnp.O00000Oo;
                jnq.f1977O000000o = (jnq.O00000o != null ? jnq.O00000o.O00000o0 : null).f1976O000000o;
                jnp O00000o0 = jnq.O00000o0();
                jnq.O00000Oo = O00000o0.f1976O000000o + O00000o0.O00000Oo;
            }
            if (!z) {
                stack.push(o000000o);
            }
            o000000o = o000000o.O00000Oo;
        }
        return stack;
    }

    private static void O000000o(jnp jnp, jnq jnq) {
        while (jnq.O00000Oo(jnp)) {
            jnp jnp2 = null;
            if (jnq.O00000oo == 1) {
                jnp jnp3 = jnq.O00000o.O00000o0;
                jnq.O00000o = null;
                jnq.O00000oO = null;
                jnq.O00000oo--;
                jnp2 = jnp3;
            } else if (jnq.O00000oo > 1) {
                jnp2 = jnq.O00000oO.O00000o0;
                jnq.O00000oO = jnq.O00000oO.f1978O000000o;
                jnq.O00000oo--;
            }
            if (jnq.O00000o()) {
                jnq.f1977O000000o = -1;
                jnq.O00000Oo = -1;
                jnq.O00000o0 = 0;
            } else {
                jnq.O00000o0 -= jnp2.O00000Oo;
                jnp O00000o0 = jnq.O00000o0();
                jnq.O00000Oo = O00000o0.f1976O000000o + O00000o0.O00000Oo;
            }
        }
    }
}
