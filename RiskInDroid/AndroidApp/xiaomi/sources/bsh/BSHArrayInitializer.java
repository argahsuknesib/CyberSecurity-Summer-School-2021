package bsh;

import _m_j.kv;
import _m_j.lg;
import _m_j.lk;
import java.lang.reflect.Array;

class BSHArrayInitializer extends SimpleNode {
    BSHArrayInitializer() {
        super(6);
    }

    private void O000000o(Class cls, Object obj, int i, kv kvVar) throws EvalError {
        String name = obj instanceof Primitive ? ((Primitive) obj).O00000Oo().getName() : lg.O000000o(obj.getClass());
        StringBuffer stringBuffer = new StringBuffer("Incompatible type: ");
        stringBuffer.append(name);
        stringBuffer.append(" in initializer of array type: ");
        stringBuffer.append(cls);
        stringBuffer.append(" at position: ");
        stringBuffer.append(i);
        throw new EvalError(stringBuffer.toString(), this, kvVar);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        throw new EvalError("Array initializer has no base type.", this, kvVar);
    }

    public final Object O000000o(Class cls, int i, kv kvVar, Interpreter interpreter) throws EvalError {
        Object obj;
        Object obj2;
        String str;
        String str2;
        int O00000o0 = O00000o0();
        int[] iArr = new int[i];
        iArr[0] = O00000o0;
        Object newInstance = Array.newInstance(cls, iArr);
        int i2 = 0;
        while (i2 < O00000o0) {
            SimpleNode simpleNode = (SimpleNode) O000000o(i2);
            if (!(simpleNode instanceof BSHArrayInitializer)) {
                obj = simpleNode.O000000o(kvVar, interpreter);
            } else if (i >= 2) {
                obj = ((BSHArrayInitializer) simpleNode).O000000o(cls, i - 1, kvVar, interpreter);
            } else {
                throw new EvalError("Invalid Location for Intializer, position: ".concat(String.valueOf(i2)), this, kvVar);
            }
            if (obj != Primitive.O00000o0) {
                if (i == 1) {
                    try {
                        obj2 = Primitive.O00000Oo(lk.O000000o(obj, cls, 0));
                    } catch (UtilEvalError e) {
                        throw e.toEvalError("Error in array initializer", this, kvVar);
                    }
                } else {
                    obj2 = obj;
                }
                try {
                    Array.set(newInstance, i2, obj2);
                } catch (IllegalArgumentException e2) {
                    str2 = String.valueOf(e2);
                    str = "illegal arg";
                } catch (ArrayStoreException e3) {
                    str2 = String.valueOf(e3);
                    str = "arraystore";
                }
                i2++;
            } else {
                throw new EvalError("Void in array initializer, position".concat(String.valueOf(i2)), this, kvVar);
            }
        }
        return newInstance;
        Interpreter.O00000Oo(str.concat(str2));
        O000000o(cls, obj, i2, kvVar);
        i2++;
    }
}
