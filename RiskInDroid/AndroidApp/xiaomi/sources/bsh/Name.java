package bsh;

import _m_j.kv;
import _m_j.kx;
import _m_j.lg;
import _m_j.lj;
import _m_j.lk;
import java.io.Serializable;
import java.lang.reflect.Array;

class Name implements Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f3063O000000o;
    Class asClass;
    private int callstackDepth;
    Class classOfStaticMethod;
    private Object evalBaseObject;
    private String evalName;
    private String lastEvalName;
    public NameSpace namespace;
    String value = null;

    Name(NameSpace nameSpace, String str) {
        this.namespace = nameSpace;
        this.value = str;
    }

    private Object O000000o(String str, String str2, Object obj) {
        if (obj != null) {
            this.lastEvalName = str;
            this.evalName = str2;
            this.evalBaseObject = obj;
            return obj;
        }
        throw new InterpreterError("lastEvalName = ".concat(String.valueOf(str)));
    }

    public static String O000000o(String str, int i) {
        if (i <= 0) {
            return null;
        }
        int i2 = 0;
        int length = str.length() + 1;
        do {
            length = str.lastIndexOf(46, length - 1);
            if (length == -1) {
                break;
            }
            i2++;
        } while (i2 < i);
        return length == -1 ? str : str.substring(length + 1);
    }

    public static boolean O000000o(String str) {
        return str.indexOf(46) != -1;
    }

    static int O00000Oo(String str) {
        if (str == null) {
            return 0;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            i = str.indexOf(46, i + 1);
            if (i == -1) {
                return i2 + 1;
            }
            i2++;
        }
    }

    private static String O00000Oo(String str, int i) {
        if (i <= 0) {
            return null;
        }
        int i2 = -1;
        int i3 = 0;
        do {
            i2 = str.indexOf(46, i2 + 1);
            if (i2 == -1) {
                break;
            }
            i3++;
        } while (i3 < i);
        return i2 == -1 ? str : str.substring(0, i2);
    }

    private void O00000Oo() {
        this.evalName = this.value;
        this.evalBaseObject = null;
        this.callstackDepth = 0;
    }

    private static String O00000o(String str) {
        if (!O000000o(str)) {
            return null;
        }
        return O000000o(str, O00000Oo(str) - 1);
    }

    static String O00000o0(String str) {
        if (!O000000o(str)) {
            return null;
        }
        return O00000Oo(str, O00000Oo(str) - 1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean, boolean):java.lang.Object
     arg types: [_m_j.kv, bsh.Interpreter, boolean, int]
     candidates:
      bsh.Name.O000000o(bsh.Interpreter, java.lang.Object[], _m_j.kv, bsh.SimpleNode):java.lang.Object
      bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean, boolean):java.lang.Object */
    public final synchronized Object O000000o(kv kvVar, Interpreter interpreter, boolean z) throws UtilEvalError {
        Object obj;
        O00000Oo();
        obj = null;
        while (this.evalName != null) {
            obj = O000000o(kvVar, interpreter, z, false);
        }
        if (obj == null) {
            throw new InterpreterError("null value in toObject()");
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final Object O000000o(Interpreter interpreter, Object[] objArr, kv kvVar, SimpleNode simpleNode) throws EvalError {
        if (Interpreter.f3062O000000o) {
            StringBuffer stringBuffer = new StringBuffer("invokeLocalMethod: ");
            stringBuffer.append(this.value);
            Interpreter.O00000Oo(stringBuffer.toString());
        }
        if (interpreter != null) {
            String str = this.value;
            Class[] O000000o2 = lk.O000000o(objArr);
            try {
                BshMethod O000000o3 = this.namespace.O000000o(str, O000000o2);
                if (O000000o3 != null) {
                    return O000000o3.O000000o(objArr, interpreter, kvVar, simpleNode);
                }
                interpreter.O00000o0();
                try {
                    Object O000000o4 = this.namespace.O000000o(str, O000000o2, interpreter);
                    if (O000000o4 == null) {
                        try {
                            BshMethod O000000o5 = this.namespace.O000000o("invoke", new Class[]{null, null});
                            if (O000000o5 != null) {
                                return O000000o5.O000000o(new Object[]{str, objArr}, interpreter, kvVar, simpleNode);
                            }
                            StringBuffer stringBuffer2 = new StringBuffer("Command not found: ");
                            stringBuffer2.append(lj.O000000o(str, O000000o2));
                            throw new EvalError(stringBuffer2.toString(), simpleNode, kvVar);
                        } catch (UtilEvalError e) {
                            throw e.toEvalError("Local method invocation", simpleNode, kvVar);
                        }
                    } else if (O000000o4 instanceof BshMethod) {
                        return ((BshMethod) O000000o4).O000000o(objArr, interpreter, kvVar, simpleNode);
                    } else {
                        if (O000000o4 instanceof Class) {
                            try {
                                return lg.O000000o((Class) O000000o4, objArr, interpreter, kvVar);
                            } catch (UtilEvalError e2) {
                                throw e2.toEvalError("Error invoking compiled command: ", simpleNode, kvVar);
                            }
                        } else {
                            throw new InterpreterError("invalid command type");
                        }
                    }
                } catch (UtilEvalError e3) {
                    throw e3.toEvalError("Error loading command: ", simpleNode, kvVar);
                }
            } catch (UtilEvalError e4) {
                throw e4.toEvalError("Local method invocation", simpleNode, kvVar);
            }
        } else {
            throw new InterpreterError("invokeLocalMethod: interpreter = null");
        }
    }

    public String toString() {
        return this.value;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, bsh.This, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], bsh.Interpreter):java.lang.Object
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(java.lang.Class, java.lang.Object, java.lang.String, boolean):java.lang.Object
     arg types: [java.lang.Class<?>, ?[OBJECT, ARRAY], java.lang.String, int]
     candidates:
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.Object
      _m_j.lg.O000000o(java.lang.Class, java.lang.Object[], bsh.Interpreter, _m_j.kv):java.lang.Object
      _m_j.lg.O000000o(java.lang.Class, java.lang.Object, java.lang.String, boolean):java.lang.Object */
    private Object O000000o(kv kvVar, Interpreter interpreter, boolean z, boolean z2) throws UtilEvalError {
        boolean z3;
        NameSpace nameSpace;
        Object O000000o2;
        if (this.evalBaseObject == null && !O000000o(this.evalName) && !z && (O000000o2 = O000000o(kvVar, this.namespace, interpreter, this.evalName, false)) != Primitive.O00000o0) {
            return O000000o(this.evalName, f3063O000000o, O000000o2);
        }
        String O00000Oo = O00000Oo(this.evalName, 1);
        Object obj = this.evalBaseObject;
        if ((obj == null || (obj instanceof This)) && !z) {
            if (Interpreter.f3062O000000o) {
                Interpreter.O00000Oo("trying to resolve variable: ".concat(String.valueOf(O00000Oo)));
            }
            Object obj2 = this.evalBaseObject;
            if (obj2 == null) {
                nameSpace = this.namespace;
                z3 = false;
            } else {
                nameSpace = ((This) obj2).namespace;
                z3 = true;
            }
            Object O000000o3 = O000000o(kvVar, nameSpace, interpreter, O00000Oo, z3);
            if (O000000o3 != Primitive.O00000o0) {
                if (Interpreter.f3062O000000o) {
                    StringBuffer stringBuffer = new StringBuffer("resolved variable: ");
                    stringBuffer.append(O00000Oo);
                    stringBuffer.append(" in namespace: ");
                    stringBuffer.append(this.namespace);
                    Interpreter.O00000Oo(stringBuffer.toString());
                }
                return O000000o(O00000Oo, O00000o(this.evalName), O000000o3);
            }
        }
        Object obj3 = null;
        if (this.evalBaseObject == null) {
            if (Interpreter.f3062O000000o) {
                StringBuffer stringBuffer2 = new StringBuffer("trying class: ");
                stringBuffer2.append(this.evalName);
                Interpreter.O00000Oo(stringBuffer2.toString());
            }
            Class cls = null;
            String str = null;
            int i = 1;
            while (i <= O00000Oo(this.evalName) && (cls = this.namespace.O00000o((str = O00000Oo(this.evalName, i)))) == null) {
                i++;
            }
            if (cls != null) {
                String str2 = this.evalName;
                return O000000o(str, O000000o(str2, O00000Oo(str2) - i), new kx(cls));
            } else if (Interpreter.f3062O000000o) {
                StringBuffer stringBuffer3 = new StringBuffer("not a class, trying var prefix ");
                stringBuffer3.append(this.evalName);
                Interpreter.O00000Oo(stringBuffer3.toString());
            }
        }
        Object obj4 = this.evalBaseObject;
        if ((obj4 == null || (obj4 instanceof This)) && !z && z2) {
            Object obj5 = this.evalBaseObject;
            NameSpace nameSpace2 = obj5 == null ? this.namespace : ((This) obj5).namespace;
            This O000000o4 = new NameSpace(nameSpace2, "auto: ".concat(String.valueOf(O00000Oo))).O000000o(interpreter);
            nameSpace2.O000000o(O00000Oo, (Object) O000000o4, false);
            return O000000o(O00000Oo, O00000o(this.evalName), O000000o4);
        }
        Object obj6 = this.evalBaseObject;
        if (obj6 == null) {
            if (!O000000o(this.evalName)) {
                return O000000o(this.evalName, f3063O000000o, Primitive.O00000o0);
            }
            StringBuffer stringBuffer4 = new StringBuffer("Class or variable not found: ");
            stringBuffer4.append(this.evalName);
            throw new UtilEvalError(stringBuffer4.toString());
        } else if (obj6 == Primitive.O00000Oo) {
            StringBuffer stringBuffer5 = new StringBuffer("Null Pointer while evaluating: ");
            stringBuffer5.append(this.value);
            throw new UtilTargetError(new NullPointerException(stringBuffer5.toString()));
        } else if (this.evalBaseObject != Primitive.O00000o0) {
            Object obj7 = this.evalBaseObject;
            if (obj7 instanceof Primitive) {
                StringBuffer stringBuffer6 = new StringBuffer("Can't treat primitive like an object. Error while evaluating: ");
                stringBuffer6.append(this.value);
                throw new UtilEvalError(stringBuffer6.toString());
            } else if (obj7 instanceof kx) {
                Class<?> cls2 = ((kx) obj7).f2158O000000o;
                String O00000Oo2 = O00000Oo(this.evalName, 1);
                if (O00000Oo2.equals("this")) {
                    for (NameSpace nameSpace3 = this.namespace; nameSpace3 != null; nameSpace3 = nameSpace3.parent) {
                        if (nameSpace3.classInstance != null && nameSpace3.classInstance.getClass() == cls2) {
                            return O000000o(O00000Oo2, O00000o(this.evalName), nameSpace3.classInstance);
                        }
                    }
                    throw new UtilEvalError("Can't find enclosing 'this' instance of class: ".concat(String.valueOf(cls2)));
                }
                try {
                    if (Interpreter.f3062O000000o) {
                        StringBuffer stringBuffer7 = new StringBuffer("Name call to getStaticFieldValue, class: ");
                        stringBuffer7.append(cls2);
                        stringBuffer7.append(", field:");
                        stringBuffer7.append(O00000Oo2);
                        Interpreter.O00000Oo(stringBuffer7.toString());
                    }
                    obj3 = lg.O000000o((Class) cls2, (Object) null, O00000Oo2, true);
                } catch (ReflectError e) {
                    if (Interpreter.f3062O000000o) {
                        Interpreter.O00000Oo("field reflect error: ".concat(String.valueOf(e)));
                    }
                }
                if (obj3 == null) {
                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append(cls2.getName());
                    stringBuffer8.append("$");
                    stringBuffer8.append(O00000Oo2);
                    Class O00000o = this.namespace.O00000o(stringBuffer8.toString());
                    if (O00000o != null) {
                        obj3 = new kx(O00000o);
                    }
                }
                if (obj3 != null) {
                    return O000000o(O00000Oo2, O00000o(this.evalName), obj3);
                }
                StringBuffer stringBuffer9 = new StringBuffer("No static field or inner class: ");
                stringBuffer9.append(O00000Oo2);
                stringBuffer9.append(" of ");
                stringBuffer9.append(cls2);
                throw new UtilEvalError(stringBuffer9.toString());
            } else if (!z) {
                String O00000Oo3 = O00000Oo(this.evalName, 1);
                if (O00000Oo3.equals("length") && this.evalBaseObject.getClass().isArray()) {
                    return O000000o(O00000Oo3, O00000o(this.evalName), new Primitive(Array.getLength(this.evalBaseObject)));
                }
                try {
                    return O000000o(O00000Oo3, O00000o(this.evalName), lg.O000000o(this.evalBaseObject, O00000Oo3));
                } catch (ReflectError unused) {
                    StringBuffer stringBuffer10 = new StringBuffer("Cannot access field: ");
                    stringBuffer10.append(O00000Oo3);
                    stringBuffer10.append(", on object: ");
                    stringBuffer10.append(this.evalBaseObject);
                    throw new UtilEvalError(stringBuffer10.toString());
                }
            } else {
                StringBuffer stringBuffer11 = new StringBuffer();
                stringBuffer11.append(this.value);
                stringBuffer11.append(" does not resolve to a class name.");
                throw new UtilEvalError(stringBuffer11.toString());
            }
        } else {
            StringBuffer stringBuffer12 = new StringBuffer("Undefined variable or class name while evaluating: ");
            stringBuffer12.append(this.value);
            throw new UtilEvalError(stringBuffer12.toString());
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:67:0x0102 */
    private Object O000000o(kv kvVar, NameSpace nameSpace, Interpreter interpreter, String str, boolean z) throws UtilEvalError {
        Object obj;
        if (str.equals("this")) {
            if (!z) {
                This O000000o2 = nameSpace.O000000o(interpreter);
                NameSpace O000000o3 = O000000o(O000000o2.namespace);
                return O000000o3 != null ? O000000o(this.evalName) ? O000000o3.O000000o(interpreter) : O000000o3.O000000o() : O000000o2;
            }
            throw new UtilEvalError("Redundant to call .this on This type");
        } else if (str.equals("super")) {
            This O00000Oo = nameSpace.O00000Oo(interpreter);
            NameSpace nameSpace2 = O00000Oo.namespace;
            return (nameSpace2.parent == null || !nameSpace2.parent.isClass) ? O00000Oo : nameSpace2.parent.O000000o(interpreter);
        } else {
            Object obj2 = null;
            if (str.equals("global")) {
                obj2 = nameSpace.O00000o0(interpreter);
            }
            if (obj2 == null && z) {
                if (str.equals("namespace")) {
                    obj2 = nameSpace;
                } else if (str.equals("variables")) {
                    obj2 = nameSpace.O00000Oo();
                } else if (str.equals("methods")) {
                    obj2 = nameSpace.O00000o0();
                } else if (str.equals("interpreter")) {
                    if (this.lastEvalName.equals("this")) {
                        obj2 = interpreter;
                    } else {
                        throw new UtilEvalError("Can only call .interpreter on literal 'this'");
                    }
                }
            }
            if (obj2 != null || !z || !str.equals("caller")) {
                if (obj2 != null || !z || !str.equals("callstack")) {
                    obj = obj2;
                } else {
                    obj = kvVar;
                    if (!this.lastEvalName.equals("this")) {
                        throw new UtilEvalError("Can only call .callstack on literal 'this'");
                    } else if (kvVar == null) {
                        throw new InterpreterError("no callstack");
                    }
                }
                if (obj == null) {
                    obj = nameSpace.O00000o0(str);
                }
                if (obj != null) {
                    return obj;
                }
                throw new InterpreterError("null this field ref:".concat(String.valueOf(str)));
            } else if (!this.lastEvalName.equals("this") && !this.lastEvalName.equals("caller")) {
                throw new UtilEvalError("Can only call .caller on literal 'this' or literal '.caller'");
            } else if (kvVar != null) {
                int i = this.callstackDepth + 1;
                this.callstackDepth = i;
                return kvVar.O000000o(i).O000000o(interpreter);
            } else {
                throw new InterpreterError("no callstack");
            }
        }
    }

    static NameSpace O000000o(NameSpace nameSpace) {
        if (nameSpace.isClass) {
            return nameSpace;
        }
        if (!nameSpace.isMethod || nameSpace.parent == null || !nameSpace.parent.isClass) {
            return null;
        }
        return nameSpace.parent;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean):java.lang.Object
     arg types: [?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      bsh.Name.O000000o(java.lang.String, java.lang.String, java.lang.Object):java.lang.Object
      bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean):java.lang.Object */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|18|19|20|(1:22)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e  */
    public final synchronized Class O000000o() throws ClassNotFoundException, UtilEvalError {
        if (this.asClass != null) {
            return this.asClass;
        }
        O00000Oo();
        Object obj = null;
        if (this.evalName.equals("var")) {
            this.asClass = null;
            return null;
        }
        Class O00000o = this.namespace.O00000o(this.evalName);
        if (O00000o == null) {
            obj = O000000o((kv) null, (Interpreter) null, true);
            if (obj instanceof kx) {
                O00000o = ((kx) obj).f2158O000000o;
            }
        }
        if (O00000o != null) {
            this.asClass = O00000o;
            return this.asClass;
        }
        StringBuffer stringBuffer = new StringBuffer("Class: ");
        stringBuffer.append(this.value);
        stringBuffer.append(" not found in namespace");
        throw new ClassNotFoundException(stringBuffer.toString());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean, boolean):java.lang.Object
     arg types: [_m_j.kv, bsh.Interpreter, int, int]
     candidates:
      bsh.Name.O000000o(bsh.Interpreter, java.lang.Object[], _m_j.kv, bsh.SimpleNode):java.lang.Object
      bsh.Name.O000000o(_m_j.kv, bsh.Interpreter, boolean, boolean):java.lang.Object */
    public final synchronized LHS O000000o(kv kvVar, Interpreter interpreter) throws UtilEvalError {
        O00000Oo();
        boolean z = false;
        if (O000000o(this.evalName)) {
            Object obj = null;
            while (true) {
                if (this.evalName != null) {
                    if (!O000000o(this.evalName)) {
                        break;
                    }
                    obj = O000000o(kvVar, interpreter, false, true);
                }
            }
            if (this.evalName == null) {
                if (obj instanceof kx) {
                    StringBuffer stringBuffer = new StringBuffer("Can't assign to class: ");
                    stringBuffer.append(this.value);
                    throw new UtilEvalError(stringBuffer.toString());
                }
            }
            if (obj == null) {
                StringBuffer stringBuffer2 = new StringBuffer("Error in LHS: ");
                stringBuffer2.append(this.value);
                throw new UtilEvalError(stringBuffer2.toString());
            } else if (obj instanceof This) {
                if (this.evalName.equals("namespace") || this.evalName.equals("variables") || this.evalName.equals("methods") || this.evalName.equals("caller")) {
                    StringBuffer stringBuffer3 = new StringBuffer("Can't assign to special variable: ");
                    stringBuffer3.append(this.evalName);
                    throw new UtilEvalError(stringBuffer3.toString());
                }
                Interpreter.O00000Oo("found This reference evaluating LHS");
                if (!this.lastEvalName.equals("super")) {
                    z = true;
                }
                return new LHS(((This) obj).namespace, this.evalName, z);
            } else if (this.evalName != null) {
                try {
                    if (obj instanceof kx) {
                        return new LHS(lg.O00000Oo(((kx) obj).f2158O000000o, this.evalName, true));
                    }
                    return lg.O00000Oo(obj, this.evalName);
                } catch (UtilEvalError e) {
                    StringBuffer stringBuffer4 = new StringBuffer("LHS evaluation: ");
                    stringBuffer4.append(e.getMessage());
                    throw new UtilEvalError(stringBuffer4.toString());
                } catch (ReflectError e2) {
                    throw new UtilEvalError("Field access: ".concat(String.valueOf(e2)));
                }
            } else {
                throw new InterpreterError("Internal error in lhs...");
            }
        } else if (!this.evalName.equals("this")) {
            return new LHS(this.namespace, this.evalName, false);
        } else {
            throw new UtilEvalError("Can't assign to 'this'.");
        }
    }
}
