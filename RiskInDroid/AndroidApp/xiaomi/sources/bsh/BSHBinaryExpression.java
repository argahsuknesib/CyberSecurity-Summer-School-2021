package bsh;

import _m_j.kv;
import _m_j.ld;
import _m_j.lk;

class BSHBinaryExpression extends SimpleNode implements ld {

    /* renamed from: O000000o  reason: collision with root package name */
    static Class f3059O000000o;
    public int kind;

    BSHBinaryExpression() {
        super(15);
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static boolean O000000o(Object obj) {
        return (!(obj instanceof Primitive) || obj == Primitive.O00000o0 || obj == Primitive.O00000Oo) ? false : true;
    }

    private static boolean O00000Oo(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Number);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        boolean z = false;
        Object O000000o2 = ((SimpleNode) O000000o(0)).O000000o(kvVar, interpreter);
        int i = this.kind;
        if (i != 35) {
            if (i == 98 || i == 99) {
                Object O000000o3 = O000000o(O000000o2) ? ((Primitive) O000000o2).O000000o() : O000000o2;
                if ((O000000o3 instanceof Boolean) && !((Boolean) O000000o3).booleanValue()) {
                    return new Primitive(false);
                }
            }
            int i2 = this.kind;
            if (i2 == 96 || i2 == 97) {
                Object O000000o4 = O000000o(O000000o2) ? ((Primitive) O000000o2).O000000o() : O000000o2;
                if ((O000000o4 instanceof Boolean) && ((Boolean) O000000o4).booleanValue()) {
                    return new Primitive(true);
                }
            }
            boolean O00000Oo = O00000Oo(O000000o2);
            Object O000000o5 = ((SimpleNode) O000000o(1)).O000000o(kvVar, interpreter);
            boolean O00000Oo2 = O00000Oo(O000000o5);
            if ((O00000Oo || O000000o(O000000o2)) && ((O00000Oo2 || O000000o(O000000o5)) && (!O00000Oo || !O00000Oo2 || this.kind != 90))) {
                try {
                    return Primitive.O000000o(O000000o2, O000000o5, this.kind);
                } catch (UtilEvalError e) {
                    throw e.toEvalError(this, kvVar);
                }
            } else {
                int i3 = this.kind;
                if (i3 == 90) {
                    if (O000000o2 == O000000o5) {
                        z = true;
                    }
                    return new Primitive(z);
                } else if (i3 == 95) {
                    if (O000000o2 != O000000o5) {
                        z = true;
                    }
                    return new Primitive(z);
                } else if (i3 == 102 && ((O000000o2 instanceof String) || (O000000o5 instanceof String))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(O000000o2.toString());
                    stringBuffer.append(O000000o5.toString());
                    return stringBuffer.toString();
                } else {
                    if ((O000000o2 instanceof Primitive) || (O000000o5 instanceof Primitive)) {
                        if (O000000o2 == Primitive.O00000o0 || O000000o5 == Primitive.O00000o0) {
                            throw new EvalError("illegal use of undefined variable, class, or 'void' literal", this, kvVar);
                        } else if (O000000o2 == Primitive.O00000Oo || O000000o5 == Primitive.O00000Oo) {
                            throw new EvalError("illegal use of null value or 'null' literal", this, kvVar);
                        }
                    }
                    StringBuffer stringBuffer2 = new StringBuffer("Operator: '");
                    stringBuffer2.append(ld.a_[this.kind]);
                    stringBuffer2.append("' inappropriate for objects");
                    throw new EvalError(stringBuffer2.toString(), this, kvVar);
                }
            }
        } else if (O000000o2 == Primitive.O00000Oo) {
            return new Primitive(false);
        } else {
            Class O00000Oo3 = ((BSHType) O000000o(1)).O00000Oo(kvVar, interpreter);
            if (!(O000000o2 instanceof Primitive)) {
                return new Primitive(lk.O00000Oo(O00000Oo3, O000000o2.getClass()));
            }
            Class cls = f3059O000000o;
            if (cls == null) {
                cls = O000000o("bsh.Primitive");
                f3059O000000o = cls;
            }
            return O00000Oo3 == cls ? new Primitive(true) : new Primitive(false);
        }
    }
}
