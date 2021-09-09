package bsh;

import _m_j.lk;
import java.io.Serializable;

public class Variable implements Serializable {
    LHS lhs;
    Modifiers modifiers;
    String name;
    Class type;
    String typeDescriptor;
    Object value;

    Variable(String str, Class cls, LHS lhs2) {
        this.type = null;
        this.name = str;
        this.lhs = lhs2;
        this.type = cls;
    }

    Variable(String str, Class cls, Object obj, Modifiers modifiers2) throws UtilEvalError {
        this.type = null;
        this.name = str;
        this.type = cls;
        this.modifiers = modifiers2;
        O000000o(obj, 0);
    }

    Variable(String str, Object obj) throws UtilEvalError {
        this(str, null, obj, null);
    }

    private boolean O000000o(String str) {
        Modifiers modifiers2 = this.modifiers;
        return modifiers2 != null && modifiers2.O000000o(str);
    }

    /* access modifiers changed from: package-private */
    public final Object O000000o() throws UtilEvalError {
        LHS lhs2 = this.lhs;
        return lhs2 != null ? lhs2.O000000o() : this.value;
    }

    public final void O000000o(Object obj, int i) throws UtilEvalError {
        if (!O000000o("final") || this.value == null) {
            if (obj == null) {
                obj = Primitive.O000000o(this.type);
            }
            LHS lhs2 = this.lhs;
            int i2 = 0;
            if (lhs2 != null) {
                lhs2.O000000o(obj, false);
                return;
            }
            Class cls = this.type;
            if (cls != null) {
                if (i != 0) {
                    i2 = 1;
                }
                obj = lk.O000000o(obj, cls, i2);
            }
            this.value = obj;
            return;
        }
        throw new UtilEvalError("Final variable, can't re-assign.");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Variable: ");
        stringBuffer.append(super.toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.name);
        stringBuffer.append(", type:");
        stringBuffer.append(this.type);
        stringBuffer.append(", value:");
        stringBuffer.append(this.value);
        stringBuffer.append(", lhs = ");
        stringBuffer.append(this.lhs);
        return stringBuffer.toString();
    }
}
