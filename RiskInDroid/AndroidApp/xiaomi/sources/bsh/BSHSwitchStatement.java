package bsh;

import _m_j.kv;
import _m_j.ld;
import _m_j.li;

class BSHSwitchStatement extends SimpleNode implements ld {
    public BSHSwitchStatement() {
        super(27);
    }

    private boolean O000000o(Object obj, Object obj2, kv kvVar, SimpleNode simpleNode) throws EvalError {
        if (!(obj instanceof Primitive) && !(obj2 instanceof Primitive)) {
            return obj.equals(obj2);
        }
        try {
            return Primitive.O00000Oo(Primitive.O000000o(obj, obj2, 90)).equals(Boolean.TRUE);
        } catch (UtilEvalError e) {
            StringBuffer stringBuffer = new StringBuffer("Switch value: ");
            stringBuffer.append(simpleNode.O00000oo());
            stringBuffer.append(": ");
            throw e.toEvalError(stringBuffer.toString(), this, kvVar);
        }
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10, types: [bsh.Node] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        int i;
        int O00000o0 = O00000o0();
        SimpleNode simpleNode = (SimpleNode) O000000o(0);
        Object O000000o2 = simpleNode.O000000o(kvVar, interpreter);
        if (1 < O00000o0) {
            int i2 = 2;
            BSHSwitchLabel bSHSwitchLabel = (BSHSwitchLabel) O000000o(1);
            li liVar = null;
            while (i2 < O00000o0 && liVar == null) {
                if (bSHSwitchLabel.isDefault || O000000o(O000000o2, bSHSwitchLabel.O000000o(kvVar, interpreter), kvVar, simpleNode)) {
                    while (true) {
                        if (i2 >= O00000o0) {
                            break;
                        }
                        i = i2 + 1;
                        Node O000000o3 = O000000o(i2);
                        if (!(O000000o3 instanceof BSHSwitchLabel)) {
                            ? O000000o4 = ((SimpleNode) O000000o3).O000000o(kvVar, interpreter);
                            if (O000000o4 instanceof li) {
                                liVar = O000000o4;
                                break;
                            }
                        }
                        i2 = i;
                    }
                } else {
                    while (true) {
                        if (i2 >= O00000o0) {
                            break;
                        }
                        i = i2 + 1;
                        ? O000000o5 = O000000o(i2);
                        if (O000000o5 instanceof BSHSwitchLabel) {
                            bSHSwitchLabel = O000000o5;
                            break;
                        }
                        i2 = i;
                    }
                }
                i2 = i;
            }
            return (liVar == null || liVar.f2166O000000o != 46) ? Primitive.O00000o0 : liVar;
        }
        throw new EvalError("Empty switch statement.", this, kvVar);
    }
}
