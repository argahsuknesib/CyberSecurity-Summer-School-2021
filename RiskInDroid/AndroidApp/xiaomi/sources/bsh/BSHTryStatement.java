package bsh;

import _m_j.kv;
import _m_j.li;
import _m_j.lk;
import java.util.Vector;

class BSHTryStatement extends SimpleNode {
    BSHTryStatement() {
        super(37);
    }

    /* JADX INFO: finally extract failed */
    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        Node node;
        Object obj;
        BSHFormalParameter bSHFormalParameter;
        BSHBlock bSHBlock = (BSHBlock) O000000o(0);
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        int O00000o0 = O00000o0();
        int i = 1;
        while (true) {
            if (i >= O00000o0) {
                node = null;
                break;
            }
            int i2 = i + 1;
            node = O000000o(i);
            if (!(node instanceof BSHFormalParameter)) {
                break;
            }
            vector.addElement(node);
            i = i2 + 1;
            vector2.addElement(O000000o(i2));
        }
        BSHBlock bSHBlock2 = node != null ? (BSHBlock) node : null;
        int size = kvVar.f2156O000000o.size();
        try {
            obj = bSHBlock.O000000o(kvVar, interpreter);
            e = null;
        } catch (TargetError e) {
            e = e;
            String str = "Bsh Stack: ";
            while (kvVar.f2156O000000o.size() > size) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("\t");
                stringBuffer.append(kvVar.O000000o());
                stringBuffer.append("\n");
                str = stringBuffer.toString();
            }
            obj = null;
        }
        Throwable target = e != null ? e.getTarget() : null;
        if (target != null) {
            int size2 = vector.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    break;
                }
                bSHFormalParameter = (BSHFormalParameter) vector.elementAt(i3);
                bSHFormalParameter.O000000o(kvVar, interpreter);
                if (bSHFormalParameter.type != null || !interpreter.strictJava) {
                    if (bSHFormalParameter.type == null) {
                        break;
                    }
                    try {
                        target = (Throwable) lk.O000000o(target, bSHFormalParameter.type, 1);
                        break;
                    } catch (UtilEvalError unused) {
                        i3++;
                    }
                } else {
                    throw new EvalError("(Strict Java) Untyped catch block", this, kvVar);
                }
            }
            BSHBlock bSHBlock3 = (BSHBlock) vector2.elementAt(i3);
            NameSpace O000000o2 = kvVar.O000000o(0);
            BlockNameSpace blockNameSpace = new BlockNameSpace(O000000o2);
            try {
                if (bSHFormalParameter.type == BSHFormalParameter.f3060O000000o) {
                    blockNameSpace.O000000o(bSHFormalParameter.name, target);
                } else {
                    new Modifiers();
                    blockNameSpace.O000000o(bSHFormalParameter.name, bSHFormalParameter.type, target, new Modifiers());
                }
                kvVar.O00000Oo(blockNameSpace);
                try {
                    obj = bSHBlock3.O000000o(kvVar, interpreter);
                    kvVar.O00000Oo(O000000o2);
                    e = null;
                } catch (Throwable th) {
                    kvVar.O00000Oo(O000000o2);
                    throw th;
                }
            } catch (UtilEvalError unused2) {
                throw new InterpreterError("Unable to set var in catch block namespace.");
            }
        }
        if (bSHBlock2 != null) {
            obj = bSHBlock2.O000000o(kvVar, interpreter);
        }
        if (e == null) {
            return obj instanceof li ? obj : Primitive.O00000o0;
        }
        throw e;
    }
}
