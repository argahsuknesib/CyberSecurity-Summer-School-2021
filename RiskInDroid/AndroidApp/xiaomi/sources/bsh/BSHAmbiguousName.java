package bsh;

import _m_j.kv;

class BSHAmbiguousName extends SimpleNode {
    public String text;

    BSHAmbiguousName() {
        super(12);
    }

    public final Name O000000o(NameSpace nameSpace) {
        return nameSpace.O00000oO(this.text);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        throw new InterpreterError("Don't know how to eval an ambiguous name!  Use toObject() if you want an object.");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AmbigousName: ");
        stringBuffer.append(this.text);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final Object O000000o(kv kvVar, Interpreter interpreter, boolean z) throws EvalError {
        try {
            return O000000o(kvVar.O000000o(0)).O000000o(kvVar, interpreter, z);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }

    public final Class O000000o(kv kvVar) throws EvalError {
        try {
            return O000000o(kvVar.O000000o(0)).O000000o();
        } catch (ClassNotFoundException e) {
            throw new EvalError(e.getMessage(), this, kvVar);
        } catch (UtilEvalError e2) {
            throw e2.toEvalError(this, kvVar);
        }
    }

    public final LHS O00000Oo(kv kvVar, Interpreter interpreter) throws EvalError {
        try {
            return O000000o(kvVar.O000000o(0)).O000000o(kvVar, interpreter);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }
}
