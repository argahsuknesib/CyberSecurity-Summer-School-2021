package bsh;

import _m_j.kv;
import _m_j.ld;
import _m_j.li;

class BSHWhileStatement extends SimpleNode implements ld {
    public boolean isDoStatement;

    BSHWhileStatement() {
        super(30);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[EDGE_INSN: B:30:0x0059->B:25:0x0059 ?: BREAK  , SYNTHETIC] */
    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        SimpleNode simpleNode;
        SimpleNode simpleNode2;
        boolean z;
        int O00000o0 = O00000o0();
        if (this.isDoStatement) {
            SimpleNode simpleNode3 = (SimpleNode) O000000o(0);
            simpleNode = (SimpleNode) O000000o(1);
            simpleNode2 = simpleNode3;
        } else {
            simpleNode = (SimpleNode) O000000o(0);
            simpleNode2 = O00000o0 > 1 ? (SimpleNode) O000000o(1) : null;
        }
        boolean z2 = this.isDoStatement;
        while (true) {
            if (!z2 && !BSHIfStatement.O000000o(simpleNode, kvVar, interpreter)) {
                break;
            } else if (simpleNode2 != null) {
                Object O000000o2 = simpleNode2.O000000o(kvVar, interpreter);
                if (O000000o2 instanceof li) {
                    int i = ((li) O000000o2).f2166O000000o;
                    if (i == 12) {
                        z = true;
                        if (!z) {
                            break;
                        }
                        z2 = false;
                    } else if (i == 19) {
                        continue;
                    } else if (i == 46) {
                        return O000000o2;
                    }
                }
                z = false;
                if (!z) {
                }
            }
        }
        return Primitive.O00000o0;
    }
}
