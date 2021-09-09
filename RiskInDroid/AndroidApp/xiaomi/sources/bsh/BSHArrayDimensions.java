package bsh;

import _m_j.kv;
import _m_j.lg;
import java.lang.reflect.Array;

class BSHArrayDimensions extends SimpleNode {
    public Class baseType;
    public int[] definedDimensions;
    public int numDefinedDims;
    public int numUndefinedDims;

    BSHArrayDimensions() {
        super(24);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        int i = 0;
        SimpleNode simpleNode = (SimpleNode) O000000o(0);
        if (simpleNode instanceof BSHArrayInitializer) {
            Class cls = this.baseType;
            if (cls != null) {
                Object O000000o2 = ((BSHArrayInitializer) simpleNode).O000000o(cls, this.numUndefinedDims, kvVar, interpreter);
                int O00000Oo = lg.O00000Oo(O000000o2.getClass());
                this.definedDimensions = new int[O00000Oo];
                if (this.definedDimensions.length == this.numUndefinedDims) {
                    Object obj = O000000o2;
                    int i2 = 0;
                    while (true) {
                        int[] iArr = this.definedDimensions;
                        if (i2 >= iArr.length) {
                            return O000000o2;
                        }
                        iArr[i2] = Array.getLength(obj);
                        if (this.definedDimensions[i2] > 0) {
                            obj = Array.get(obj, 0);
                        }
                        i2++;
                    }
                } else {
                    StringBuffer stringBuffer = new StringBuffer("Incompatible initializer. Allocation calls for a ");
                    stringBuffer.append(this.numUndefinedDims);
                    stringBuffer.append(" dimensional array, but initializer is a ");
                    stringBuffer.append(O00000Oo);
                    stringBuffer.append(" dimensional array");
                    throw new EvalError(stringBuffer.toString(), this, kvVar);
                }
            } else {
                throw new EvalError("Internal Array Eval err:  unknown base type", this, kvVar);
            }
        } else {
            this.definedDimensions = new int[this.numDefinedDims];
            while (i < this.numDefinedDims) {
                try {
                    this.definedDimensions[i] = ((Primitive) ((SimpleNode) O000000o(i)).O000000o(kvVar, interpreter)).O00000o0();
                    i++;
                } catch (Exception unused) {
                    StringBuffer stringBuffer2 = new StringBuffer("Array index: ");
                    stringBuffer2.append(i);
                    stringBuffer2.append(" does not evaluate to an integer");
                    throw new EvalError(stringBuffer2.toString(), this, kvVar);
                }
            }
            return Primitive.O00000o0;
        }
    }

    public final Object O000000o(Class cls, kv kvVar, Interpreter interpreter) throws EvalError {
        if (Interpreter.f3062O000000o) {
            Interpreter.O00000Oo("array base type = ".concat(String.valueOf(cls)));
        }
        this.baseType = cls;
        return O000000o(kvVar, interpreter);
    }

    public final void O000000o() {
        this.numDefinedDims++;
    }

    public final void O00000Oo() {
        this.numUndefinedDims++;
    }
}
