package bsh;

import _m_j.kv;
import _m_j.ky;
import _m_j.lg;
import _m_j.lk;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

class BSHPrimarySuffix extends SimpleNode {
    public String field;
    Object index;
    public int operation;

    BSHPrimarySuffix() {
        super(20);
    }

    private static int O000000o(Object obj, kv kvVar, Interpreter interpreter, SimpleNode simpleNode) throws EvalError {
        if (obj.getClass().isArray()) {
            try {
                Object O000000o2 = ((SimpleNode) simpleNode.O000000o(0)).O000000o(kvVar, interpreter);
                if (!(O000000o2 instanceof Primitive)) {
                    O000000o2 = lk.O000000o(O000000o2, Integer.TYPE, 1);
                }
                return ((Primitive) O000000o2).O00000o0();
            } catch (UtilEvalError e) {
                Interpreter.O00000Oo("doIndex: ".concat(String.valueOf(e)));
                throw e.toEvalError("Arrays may only be indexed by integer types.", simpleNode, kvVar);
            }
        } else {
            throw new EvalError("Not an array", simpleNode, kvVar);
        }
    }

    private Object O00000Oo(Object obj, boolean z, kv kvVar, Interpreter interpreter) throws EvalError, ReflectError, InvocationTargetException {
        try {
            if (!this.field.equals("length") || !obj.getClass().isArray()) {
                if (O00000o0() == 0) {
                    return z ? lg.O00000Oo(obj, this.field) : lg.O000000o(obj, this.field);
                }
                return lg.O000000o(obj, this.field, ((BSHArguments) O000000o(0)).O00000Oo(kvVar, interpreter), interpreter, kvVar, this);
            } else if (!z) {
                return new Primitive(Array.getLength(obj));
            } else {
                throw new EvalError("Can't assign array length", this, kvVar);
            }
        } catch (ReflectError e) {
            StringBuffer stringBuffer = new StringBuffer("Error in method invocation: ");
            stringBuffer.append(e.getMessage());
            throw new EvalError(stringBuffer.toString(), this, kvVar);
        } catch (InvocationTargetException e2) {
            StringBuffer stringBuffer2 = new StringBuffer("Method Invocation ");
            stringBuffer2.append(this.field);
            String stringBuffer3 = stringBuffer2.toString();
            Throwable targetException = e2.getTargetException();
            throw new TargetError(stringBuffer3, targetException, this, kvVar, targetException instanceof EvalError ? targetException instanceof TargetError ? ((TargetError) targetException).inNativeCode() : false : true);
        } catch (UtilEvalError e3) {
            throw e3.toEvalError(this, kvVar);
        }
    }

    private Object O00000o0(Object obj, boolean z, kv kvVar, Interpreter interpreter) throws EvalError, ReflectError {
        int O000000o2 = O000000o(obj, kvVar, interpreter, this);
        if (z) {
            return new LHS(obj, O000000o2);
        }
        try {
            return lg.O000000o(obj, O000000o2);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }

    public final Object O000000o(Object obj, boolean z, kv kvVar, Interpreter interpreter) throws EvalError {
        if (this.operation != 0) {
            if (obj instanceof SimpleNode) {
                obj = obj instanceof BSHAmbiguousName ? ((BSHAmbiguousName) obj).O000000o(kvVar, interpreter, false) : ((SimpleNode) obj).O000000o(kvVar, interpreter);
            } else if (obj instanceof LHS) {
                try {
                    obj = ((LHS) obj).O000000o();
                } catch (UtilEvalError e) {
                    throw e.toEvalError(this, kvVar);
                }
            }
            try {
                int i = this.operation;
                if (i == 1) {
                    return O00000o0(obj, z, kvVar, interpreter);
                }
                if (i == 2) {
                    return O00000Oo(obj, z, kvVar, interpreter);
                }
                if (i == 3) {
                    return O000000o(z, obj, kvVar, interpreter);
                }
                throw new InterpreterError("Unknown suffix type");
            } catch (ReflectError e2) {
                throw new EvalError("reflection error: ".concat(String.valueOf(e2)), this, kvVar);
            } catch (InvocationTargetException e3) {
                throw new TargetError("target exception", e3.getTargetException(), this, kvVar, true);
            }
        } else if (!(obj instanceof BSHType)) {
            throw new EvalError("Attempt to use .class suffix on non class.", this, kvVar);
        } else if (!z) {
            kvVar.O000000o(0);
            return ((BSHType) obj).O00000Oo(kvVar, interpreter);
        } else {
            throw new EvalError("Can't assign .class", this, kvVar);
        }
    }

    private Object O000000o(boolean z, Object obj, kv kvVar, Interpreter interpreter) throws EvalError {
        if (obj == Primitive.O00000o0) {
            throw new EvalError("Attempt to access property on undefined variable or class name", this, kvVar);
        } else if (!(obj instanceof Primitive)) {
            Object O000000o2 = ((SimpleNode) O000000o(0)).O000000o(kvVar, interpreter);
            if (!(O000000o2 instanceof String)) {
                throw new EvalError("Property expression must be a String or identifier.", this, kvVar);
            } else if (z) {
                return new LHS(obj, (String) O000000o2);
            } else {
                ky.O000000o();
                if (obj instanceof Hashtable) {
                    Object obj2 = ((Hashtable) obj).get(O000000o2);
                    return obj2 == null ? Primitive.O00000Oo : obj2;
                }
                try {
                    return lg.O00000o0(obj, (String) O000000o2);
                } catch (UtilEvalError e) {
                    throw e.toEvalError("Property: ".concat(String.valueOf(O000000o2)), this, kvVar);
                } catch (ReflectError unused) {
                    throw new EvalError("No such property: ".concat(String.valueOf(O000000o2)), this, kvVar);
                }
            }
        } else {
            throw new EvalError("Attempt to access property on a primitive", this, kvVar);
        }
    }
}
