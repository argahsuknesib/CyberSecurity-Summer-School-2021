package _m_j;

import bsh.InterpreterError;
import bsh.NameSpace;
import java.util.Vector;

public final class kv {

    /* renamed from: O000000o  reason: collision with root package name */
    public Vector f2156O000000o = new Vector(2);

    public kv() {
    }

    public kv(NameSpace nameSpace) {
        O000000o(nameSpace);
    }

    public final void O000000o(NameSpace nameSpace) {
        this.f2156O000000o.insertElementAt(nameSpace, 0);
    }

    public final kv O00000Oo() {
        kv kvVar = new kv();
        kvVar.f2156O000000o = (Vector) this.f2156O000000o.clone();
        return kvVar;
    }

    public final NameSpace O00000Oo(NameSpace nameSpace) {
        NameSpace nameSpace2 = (NameSpace) this.f2156O000000o.elementAt(0);
        this.f2156O000000o.setElementAt(nameSpace, 0);
        return nameSpace2;
    }

    public final NameSpace O000000o(int i) {
        return i >= this.f2156O000000o.size() ? NameSpace.f3064O000000o : (NameSpace) this.f2156O000000o.elementAt(i);
    }

    public final NameSpace O000000o() {
        if (this.f2156O000000o.size() > 0) {
            NameSpace O000000o2 = O000000o(0);
            this.f2156O000000o.removeElementAt(0);
            return O000000o2;
        }
        throw new InterpreterError("pop on empty CallStack");
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallStack:\n");
        NameSpace[] nameSpaceArr = new NameSpace[this.f2156O000000o.size()];
        this.f2156O000000o.copyInto(nameSpaceArr);
        for (NameSpace append : nameSpaceArr) {
            StringBuffer stringBuffer2 = new StringBuffer("\t");
            stringBuffer2.append(append);
            stringBuffer2.append("\n");
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }
}
