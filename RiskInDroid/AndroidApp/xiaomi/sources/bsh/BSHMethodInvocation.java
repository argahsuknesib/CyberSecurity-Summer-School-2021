package bsh;

import _m_j.kt;
import _m_j.kv;
import _m_j.kw;
import _m_j.kx;
import _m_j.lg;
import java.lang.reflect.InvocationTargetException;

class BSHMethodInvocation extends SimpleNode {
    BSHMethodInvocation() {
        super(19);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean):java.lang.Object
     arg types: [_m_j.kv, bsh.Interpreter, int]
     candidates:
      bsh.Name.O000000o(java.lang.String, java.lang.String, java.lang.Object):java.lang.Object
      bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean):java.lang.Object */
    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        NameSpace O000000o2;
        NameSpace O000000o3 = kvVar.O000000o(0);
        BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) O000000o(0);
        if (O000000o3.parent != null && O000000o3.parent.isClass && (bSHAmbiguousName.text.equals("super") || bSHAmbiguousName.text.equals("this"))) {
            return Primitive.O00000o0;
        }
        Name O000000o4 = bSHAmbiguousName.O000000o(O000000o3);
        Object[] O00000Oo = ((BSHArguments) O000000o(1)).O00000Oo(kvVar, interpreter);
        try {
            String O000000o5 = Name.O000000o(O000000o4.value, 1);
            kt O00000o = interpreter.globalNameSpace.O00000o();
            NameSpace O000000o6 = kvVar.O000000o(0);
            if (O000000o4.classOfStaticMethod != null) {
                return lg.O000000o(O00000o, O000000o4.classOfStaticMethod, O000000o5, O00000Oo);
            }
            if (!Name.O000000o(O000000o4.value)) {
                return O000000o4.O000000o(interpreter, O00000Oo, kvVar, this);
            }
            String O00000o0 = Name.O00000o0(O000000o4.value);
            if (!O00000o0.equals("super") || Name.O00000Oo(O000000o4.value) != 2 || (O000000o2 = Name.O000000o(O000000o6.O000000o(interpreter).namespace)) == null) {
                Name O00000oO = O000000o6.O00000oO(O00000o0);
                Object O000000o7 = O00000oO.O000000o(kvVar, interpreter, false);
                if (O000000o7 == Primitive.O00000o0) {
                    StringBuffer stringBuffer = new StringBuffer("Attempt to resolve method: ");
                    stringBuffer.append(O000000o5);
                    stringBuffer.append("() on undefined variable or class name: ");
                    stringBuffer.append(O00000oO);
                    throw new UtilEvalError(stringBuffer.toString());
                } else if (!(O000000o7 instanceof kx)) {
                    if (O000000o7 instanceof Primitive) {
                        if (O000000o7 == Primitive.O00000Oo) {
                            throw new UtilTargetError(new NullPointerException("Null Pointer in Method Invocation"));
                        } else if (Interpreter.f3062O000000o) {
                            Interpreter.O00000Oo("Attempt to access method on primitive... allowing bsh.Primitive to peek through for debugging");
                        }
                    }
                    return lg.O000000o(O000000o7, O000000o5, O00000Oo, interpreter, kvVar, this);
                } else {
                    if (Interpreter.f3062O000000o) {
                        Interpreter.O00000Oo("invokeMethod: trying static - ".concat(String.valueOf(O00000oO)));
                    }
                    Class cls = ((kx) O000000o7).f2158O000000o;
                    O000000o4.classOfStaticMethod = cls;
                    if (cls != null) {
                        return lg.O000000o(O00000o, cls, O000000o5, O00000Oo);
                    }
                    throw new UtilEvalError("invokeMethod: unknown target: ".concat(String.valueOf(O00000oO)));
                }
            } else {
                O000000o2.O000000o();
                return kw.O000000o().O00000o0();
            }
        } catch (ReflectError e) {
            StringBuffer stringBuffer2 = new StringBuffer("Error in method invocation: ");
            stringBuffer2.append(e.getMessage());
            throw new EvalError(stringBuffer2.toString(), this, kvVar);
        } catch (InvocationTargetException e2) {
            String concat = "Method Invocation ".concat(String.valueOf(O000000o4));
            Throwable targetException = e2.getTargetException();
            throw new TargetError(concat, targetException, this, kvVar, targetException instanceof EvalError ? targetException instanceof TargetError ? ((TargetError) targetException).inNativeCode() : false : true);
        } catch (UtilEvalError e3) {
            throw e3.toEvalError(this, kvVar);
        }
    }
}
