package bsh;

import _m_j.kv;
import _m_j.lg;
import _m_j.lj;
import _m_j.lk;
import java.io.Serializable;

public class This implements Serializable, Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    transient Interpreter f3068O000000o;
    public NameSpace namespace;

    private This(NameSpace nameSpace, Interpreter interpreter) {
        this.namespace = nameSpace;
        this.f3068O000000o = interpreter;
    }

    static This O000000o(NameSpace nameSpace, Interpreter interpreter) {
        String str;
        try {
            if (Capabilities.O00000Oo()) {
                str = "bsh.XThis";
            } else if (!Capabilities.O000000o()) {
                return new This(nameSpace, interpreter);
            } else {
                str = "bsh.JThis";
            }
            return (This) lg.O000000o(Class.forName(str), new Object[]{nameSpace, interpreter});
        } catch (Exception e) {
            throw new InterpreterError("internal error 1 in This: ".concat(String.valueOf(e)));
        }
    }

    public static boolean O000000o(String str) {
        return str.equals("getClass") || str.equals("invokeMethod") || str.equals("getInterface") || str.equals("wait") || str.equals("notify") || str.equals("notifyAll");
    }

    public Object O000000o(Class cls) throws UtilEvalError {
        if (cls.isInstance(this)) {
            return this;
        }
        throw new UtilEvalError("Dynamic proxy mechanism not available. Cannot construct interface type: ".concat(String.valueOf(cls)));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("'this' reference to Bsh object: ");
        stringBuffer.append(this.namespace);
        return stringBuffer.toString();
    }

    public void run() {
        try {
            O000000o("run", new Object[0], null, null, null);
        } catch (EvalError e) {
            this.f3068O000000o.O00000Oo((Object) "Exception in runnable:".concat(String.valueOf(e)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod
     arg types: [java.lang.String, java.lang.Class[], int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], bsh.Interpreter):java.lang.Object
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod */
    public final Object O000000o(String str, Object[] objArr, Interpreter interpreter, kv kvVar, SimpleNode simpleNode) throws EvalError {
        BshMethod bshMethod;
        boolean z = false;
        if (objArr != null) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                objArr2[i] = objArr[i] == null ? Primitive.O00000Oo : objArr[i];
            }
            objArr = objArr2;
        }
        if (interpreter == null) {
            interpreter = this.f3068O000000o;
        }
        if (kvVar == null) {
            kvVar = new kv(this.namespace);
        }
        if (simpleNode == null) {
            simpleNode = SimpleNode.O00000Oo;
        }
        Class[] O000000o2 = lk.O000000o(objArr);
        try {
            bshMethod = this.namespace.O000000o(str, O000000o2, false);
        } catch (UtilEvalError unused) {
            bshMethod = null;
        }
        if (bshMethod != null) {
            return bshMethod.O000000o(objArr, interpreter, kvVar, simpleNode);
        }
        if (str.equals("toString")) {
            return toString();
        }
        if (str.equals("hashCode")) {
            return new Integer(hashCode());
        }
        if (str.equals("equals")) {
            if (this == objArr[0]) {
                z = true;
            }
            return new Boolean(z);
        }
        try {
            bshMethod = this.namespace.O000000o("invoke", new Class[]{null, null});
        } catch (UtilEvalError unused2) {
        }
        if (bshMethod != null) {
            return bshMethod.O000000o(new Object[]{str, objArr}, interpreter, kvVar, simpleNode);
        }
        StringBuffer stringBuffer = new StringBuffer("Method ");
        stringBuffer.append(lj.O000000o(str, O000000o2));
        stringBuffer.append(" not found in bsh scripted object: ");
        stringBuffer.append(this.namespace.nsName);
        throw new EvalError(stringBuffer.toString(), simpleNode, kvVar);
    }
}
