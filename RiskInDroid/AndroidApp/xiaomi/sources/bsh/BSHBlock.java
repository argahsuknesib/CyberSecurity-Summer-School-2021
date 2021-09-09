package bsh;

import _m_j.kv;
import _m_j.li;

class BSHBlock extends SimpleNode {
    public boolean isSynchronized = false;

    BSHBlock() {
        super(25);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        return O000000o(kvVar, interpreter, false);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter, boolean z) throws EvalError {
        Object O00000Oo;
        Object O000000o2 = this.isSynchronized ? ((SimpleNode) O000000o(0)).O000000o(kvVar, interpreter) : null;
        if (!this.isSynchronized) {
            return O00000Oo(kvVar, interpreter, z);
        }
        synchronized (O000000o2) {
            O00000Oo = O00000Oo(kvVar, interpreter, z);
        }
        return O00000Oo;
    }

    private Object O00000Oo(kv kvVar, Interpreter interpreter, boolean z) throws EvalError {
        NameSpace nameSpace;
        Object obj = Primitive.O00000o0;
        if (!z) {
            nameSpace = kvVar.O000000o(0);
            kvVar.O00000Oo(new BlockNameSpace(nameSpace));
        } else {
            nameSpace = null;
        }
        int i = this.isSynchronized;
        int O00000o0 = O00000o0();
        for (int i2 = i; i2 < O00000o0; i2++) {
            SimpleNode simpleNode = (SimpleNode) O000000o(i2);
            if (simpleNode instanceof BSHClassDeclaration) {
                simpleNode.O000000o(kvVar, interpreter);
            }
        }
        while (i < O00000o0) {
            try {
                SimpleNode simpleNode2 = (SimpleNode) O000000o(i);
                if (!(simpleNode2 instanceof BSHClassDeclaration)) {
                    obj = simpleNode2.O000000o(kvVar, interpreter);
                    if (obj instanceof li) {
                        break;
                    }
                }
                i++;
            } catch (Throwable th) {
                if (!z) {
                    kvVar.O00000Oo(nameSpace);
                }
                throw th;
            }
        }
        if (!z) {
            kvVar.O00000Oo(nameSpace);
        }
        return obj;
    }
}
