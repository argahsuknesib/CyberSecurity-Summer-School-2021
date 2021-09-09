package _m_j;

import bsh.Node;
import java.util.Stack;

public final class lb {

    /* renamed from: O000000o  reason: collision with root package name */
    private Stack f2162O000000o = new Stack();
    private Stack O00000Oo = new Stack();
    private int O00000o = 0;
    private int O00000o0 = 0;
    private boolean O00000oO;

    private void O000000o(Node node) {
        this.f2162O000000o.push(node);
        this.O00000o0++;
    }

    public final void O000000o() {
        this.f2162O000000o.removeAllElements();
        this.O00000Oo.removeAllElements();
        this.O00000o0 = 0;
        this.O00000o = 0;
    }

    public final void O000000o(Node node, int i) {
        this.O00000o = ((Integer) this.O00000Oo.pop()).intValue();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                O000000o(node);
                this.O00000oO = true;
                return;
            }
            Node O00000o02 = O00000o0();
            O00000o02.O000000o(node);
            node.O000000o(O00000o02, i2);
            i = i2;
        }
    }

    public final void O000000o(Node node, boolean z) {
        boolean z2;
        if (z) {
            int O00000o2 = O00000o();
            this.O00000o = ((Integer) this.O00000Oo.pop()).intValue();
            while (true) {
                int i = O00000o2 - 1;
                if (O00000o2 <= 0) {
                    break;
                }
                Node O00000o02 = O00000o0();
                O00000o02.O000000o(node);
                node.O000000o(O00000o02, i);
                O00000o2 = i;
            }
            O000000o(node);
            z2 = true;
        } else {
            this.O00000o = ((Integer) this.O00000Oo.pop()).intValue();
            z2 = false;
        }
        this.O00000oO = z2;
    }

    public final Node O00000Oo() {
        return (Node) this.f2162O000000o.elementAt(0);
    }

    public final int O00000o() {
        return this.O00000o0 - this.O00000o;
    }

    public final Node O00000o0() {
        int i = this.O00000o0 - 1;
        this.O00000o0 = i;
        if (i < this.O00000o) {
            this.O00000o = ((Integer) this.O00000Oo.pop()).intValue();
        }
        return (Node) this.f2162O000000o.pop();
    }

    public final void O00000oO() {
        while (this.O00000o0 > this.O00000o) {
            O00000o0();
        }
        this.O00000o = ((Integer) this.O00000Oo.pop()).intValue();
    }

    public final void O00000oo() {
        this.O00000Oo.push(Integer.valueOf(this.O00000o));
        this.O00000o = this.O00000o0;
    }
}
