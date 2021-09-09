package bsh;

import _m_j.kv;
import _m_j.kw;
import _m_j.kx;
import _m_j.lg;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

class BSHAllocationExpression extends SimpleNode {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f3058O000000o;

    BSHAllocationExpression() {
        super(23);
    }

    private Object O000000o(BSHArrayDimensions bSHArrayDimensions, Class cls, kv kvVar, Interpreter interpreter) throws EvalError {
        Object O000000o2 = bSHArrayDimensions.O000000o(cls, kvVar, interpreter);
        return O000000o2 != Primitive.O00000o0 ? O000000o2 : O000000o(cls, bSHArrayDimensions, kvVar);
    }

    private Object O000000o(Class cls, BSHArrayDimensions bSHArrayDimensions, kv kvVar) throws EvalError {
        if (bSHArrayDimensions.numUndefinedDims > 0) {
            cls = Array.newInstance(cls, new int[bSHArrayDimensions.numUndefinedDims]).getClass();
        }
        try {
            return Array.newInstance(cls, bSHArrayDimensions.definedDimensions);
        } catch (NegativeArraySizeException e) {
            throw new TargetError(e, this, kvVar);
        } catch (Exception e2) {
            StringBuffer stringBuffer = new StringBuffer("Can't construct primitive array: ");
            stringBuffer.append(e2.getMessage());
            throw new EvalError(stringBuffer.toString(), this, kvVar);
        }
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        boolean z = false;
        SimpleNode simpleNode = (SimpleNode) O000000o(0);
        SimpleNode simpleNode2 = (SimpleNode) O000000o(1);
        if (!(simpleNode instanceof BSHAmbiguousName)) {
            return O000000o((BSHArrayDimensions) simpleNode2, ((BSHPrimitiveType) simpleNode).type, kvVar, interpreter);
        }
        BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) simpleNode;
        if (simpleNode2 instanceof BSHArguments) {
            kvVar.O000000o(0);
            Object[] O00000Oo = ((BSHArguments) simpleNode2).O00000Oo(kvVar, interpreter);
            bSHAmbiguousName.O000000o(kvVar, interpreter, false);
            Object O000000o2 = bSHAmbiguousName.O000000o(kvVar, interpreter, true);
            if (O000000o2 instanceof kx) {
                Class cls = ((kx) O000000o2).f2158O000000o;
                if (O00000o0() > 2) {
                    z = true;
                }
                if (!z) {
                    return O000000o(cls, O00000Oo, kvVar);
                }
                return cls.isInterface() ? O000000o(cls, (BSHBlock) O000000o(2), kvVar, interpreter) : O000000o(O00000Oo, kvVar);
            }
            StringBuffer stringBuffer = new StringBuffer("Unknown class: ");
            stringBuffer.append(bSHAmbiguousName.text);
            throw new EvalError(stringBuffer.toString(), this, kvVar);
        }
        BSHArrayDimensions bSHArrayDimensions = (BSHArrayDimensions) simpleNode2;
        NameSpace O000000o3 = kvVar.O000000o(0);
        Class O000000o4 = bSHAmbiguousName.O000000o(kvVar);
        if (O000000o4 != null) {
            return O000000o(bSHArrayDimensions, O000000o4, kvVar, interpreter);
        }
        StringBuffer stringBuffer2 = new StringBuffer("Class ");
        stringBuffer2.append(bSHAmbiguousName.O000000o(O000000o3));
        stringBuffer2.append(" not found.");
        throw new EvalError(stringBuffer2.toString(), this, kvVar);
    }

    private Object O000000o(Class cls, Object[] objArr, kv kvVar) throws EvalError {
        NameSpace O000000o2;
        try {
            Object O000000o3 = lg.O000000o(cls, objArr);
            String name = cls.getName();
            if (!(name.indexOf("$") == -1 || (O000000o2 = Name.O000000o(kvVar.O000000o(0).O000000o((Interpreter) null).namespace)) == null)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(O000000o2.nsName);
                stringBuffer.append("$");
                if (name.startsWith(stringBuffer.toString())) {
                    try {
                        kw.O000000o();
                    } catch (UtilEvalError e) {
                        throw e.toEvalError(this, kvVar);
                    }
                }
            }
            return O000000o3;
        } catch (ReflectError e2) {
            StringBuffer stringBuffer2 = new StringBuffer("Constructor error: ");
            stringBuffer2.append(e2.getMessage());
            throw new EvalError(stringBuffer2.toString(), this, kvVar);
        } catch (InvocationTargetException e3) {
            StringBuffer stringBuffer3 = new StringBuffer("The constructor threw an exception:\n\t");
            stringBuffer3.append(e3.getTargetException());
            Interpreter.O00000Oo(stringBuffer3.toString());
            throw new TargetError("Object constructor", e3.getTargetException(), this, kvVar, true);
        }
    }

    private Object O000000o(Object[] objArr, kv kvVar) throws EvalError {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(kvVar.O000000o(0).nsName);
        stringBuffer.append("$");
        int i = f3058O000000o + 1;
        f3058O000000o = i;
        stringBuffer.append(i);
        new Modifiers().O000000o(0, "public");
        try {
            try {
                return lg.O000000o(kw.O000000o().O00000Oo(), objArr);
            } catch (Exception e) {
                e = e;
                if (e instanceof InvocationTargetException) {
                    e = (Exception) ((InvocationTargetException) e).getTargetException();
                }
                throw new EvalError("Error constructing inner class instance: ".concat(String.valueOf(e)), this, kvVar);
            }
        } catch (UtilEvalError e2) {
            throw e2.toEvalError(this, kvVar);
        }
    }

    private Object O000000o(Class cls, BSHBlock bSHBlock, kv kvVar, Interpreter interpreter) throws EvalError {
        NameSpace nameSpace = new NameSpace(kvVar.O000000o(0), "AnonymousBlock");
        kvVar.O000000o(nameSpace);
        bSHBlock.O000000o(kvVar, interpreter, true);
        kvVar.O000000o();
        nameSpace.O000000o(cls);
        try {
            return nameSpace.O000000o(interpreter).O000000o(cls);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }
}
