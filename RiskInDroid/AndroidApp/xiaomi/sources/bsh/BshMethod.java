package bsh;

import _m_j.kv;
import _m_j.lg;
import _m_j.li;
import _m_j.lj;
import _m_j.lk;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BshMethod implements Serializable {
    Class[] cparamTypes;
    private Class creturnType;
    NameSpace declaringNameSpace;
    private Method javaMethod;
    private Object javaObject;
    BSHBlock methodBody;
    Modifiers modifiers;
    private String name;
    private int numArgs;
    private String[] paramNames;

    BshMethod(BSHMethodDeclaration bSHMethodDeclaration, NameSpace nameSpace, Modifiers modifiers2) {
        this(bSHMethodDeclaration.name, bSHMethodDeclaration.returnType, bSHMethodDeclaration.paramsNode.O000000o(), bSHMethodDeclaration.paramsNode.paramTypes, bSHMethodDeclaration.blockNode, nameSpace, modifiers2);
    }

    private BshMethod(String str, Class cls, String[] strArr, Class[] clsArr, BSHBlock bSHBlock, NameSpace nameSpace, Modifiers modifiers2) {
        this.name = str;
        this.creturnType = cls;
        this.paramNames = strArr;
        if (strArr != null) {
            this.numArgs = strArr.length;
        }
        this.cparamTypes = clsArr;
        this.methodBody = bSHBlock;
        this.declaringNameSpace = nameSpace;
        this.modifiers = modifiers2;
    }

    BshMethod(Method method, Object obj) {
        this(method.getName(), method.getReturnType(), null, method.getParameterTypes(), null, null, null);
        this.javaMethod = method;
        this.javaObject = obj;
    }

    private Object O00000Oo(Object[] objArr, Interpreter interpreter, kv kvVar, SimpleNode simpleNode) throws EvalError {
        Object obj;
        Object O000000o2;
        if (objArr != null) {
            int i = 0;
            while (i < objArr.length) {
                if (objArr[i] != null) {
                    i++;
                } else {
                    throw new Error("HERE!");
                }
            }
        }
        Method method = this.javaMethod;
        if (method != null) {
            try {
                return lg.O000000o(method, this.javaObject, objArr);
            } catch (ReflectError e) {
                throw new EvalError("Error invoking Java method: ".concat(String.valueOf(e)), simpleNode, kvVar);
            } catch (InvocationTargetException e2) {
                throw new TargetError("Exception invoking imported object method.", e2, simpleNode, kvVar, true);
            }
        } else {
            Modifiers modifiers2 = this.modifiers;
            if (modifiers2 == null || !modifiers2.O000000o("synchronized")) {
                return O000000o(objArr, interpreter, kvVar, simpleNode, false);
            }
            if (this.declaringNameSpace.isClass) {
                try {
                    obj = this.declaringNameSpace.O000000o();
                } catch (UtilEvalError unused) {
                    throw new InterpreterError("Can't get class instance for synchronized method.");
                }
            } else {
                obj = this.declaringNameSpace.O000000o(interpreter);
            }
            synchronized (obj) {
                O000000o2 = O000000o(objArr, interpreter, kvVar, simpleNode, false);
            }
            return O000000o2;
        }
    }

    public final Object O000000o(Object[] objArr, Interpreter interpreter, kv kvVar, SimpleNode simpleNode) throws EvalError {
        return O00000Oo(objArr, interpreter, kvVar, simpleNode);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    private Object O000000o(Object[] objArr, Interpreter interpreter, kv kvVar, SimpleNode simpleNode, boolean z) throws EvalError {
        Class cls = this.creturnType;
        Class[] clsArr = this.cparamTypes;
        if (kvVar == null) {
            kvVar = new kv(this.declaringNameSpace);
        }
        int i = 0;
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (objArr.length == this.numArgs) {
            NameSpace nameSpace = new NameSpace(this.declaringNameSpace, this.name);
            nameSpace.isMethod = true;
            nameSpace.callerInfoNode = simpleNode;
            while (true) {
                li liVar = null;
                if (i >= this.numArgs) {
                    kvVar.O000000o(nameSpace);
                    Object O000000o2 = this.methodBody.O000000o(kvVar, interpreter, true);
                    kv O00000Oo = kvVar.O00000Oo();
                    kvVar.O000000o();
                    boolean z2 = O000000o2 instanceof li;
                    Object obj = O000000o2;
                    if (z2) {
                        liVar = O000000o2;
                        if (liVar.f2166O000000o == 46) {
                            Object obj2 = liVar.O00000Oo;
                            obj = obj2;
                            if (cls == Void.TYPE) {
                                obj = obj2;
                                if (obj2 != Primitive.O00000o0) {
                                    throw new EvalError("Cannot return value from void method", liVar.O00000o0, O00000Oo);
                                }
                            }
                        } else {
                            throw new EvalError("'continue' or 'break' in method body", liVar.O00000o0, O00000Oo);
                        }
                    }
                    if (cls == null) {
                        return obj;
                    }
                    if (cls == Void.TYPE) {
                        return Primitive.O00000o0;
                    }
                    try {
                        return lk.O000000o(obj, cls, 1);
                    } catch (UtilEvalError e) {
                        if (liVar != null) {
                            simpleNode = liVar.O00000o0;
                        }
                        StringBuffer stringBuffer = new StringBuffer("Incorrect type returned from method: ");
                        stringBuffer.append(this.name);
                        stringBuffer.append(e.getMessage());
                        throw e.toEvalError(stringBuffer.toString(), simpleNode, kvVar);
                    }
                } else {
                    if (clsArr[i] != null) {
                        try {
                            objArr[i] = lk.O000000o(objArr[i], clsArr[i], 1);
                            try {
                                nameSpace.O000000o(this.paramNames[i], clsArr[i], objArr[i], (Modifiers) null);
                            } catch (UtilEvalError e2) {
                                throw e2.toEvalError("Typed method parameter assignment", simpleNode, kvVar);
                            }
                        } catch (UtilEvalError e3) {
                            StringBuffer stringBuffer2 = new StringBuffer("Invalid argument: `");
                            stringBuffer2.append(this.paramNames[i]);
                            stringBuffer2.append("' for method: ");
                            stringBuffer2.append(this.name);
                            stringBuffer2.append(" : ");
                            stringBuffer2.append(e3.getMessage());
                            throw new EvalError(stringBuffer2.toString(), simpleNode, kvVar);
                        }
                    } else if (objArr[i] != Primitive.O00000o0) {
                        try {
                            nameSpace.O00000Oo(this.paramNames[i], objArr[i], interpreter.strictJava);
                        } catch (UtilEvalError e4) {
                            throw e4.toEvalError(simpleNode, kvVar);
                        }
                    } else {
                        StringBuffer stringBuffer3 = new StringBuffer("Undefined variable or class name, parameter: ");
                        stringBuffer3.append(this.paramNames[i]);
                        stringBuffer3.append(" to method: ");
                        stringBuffer3.append(this.name);
                        throw new EvalError(stringBuffer3.toString(), simpleNode, kvVar);
                    }
                    i++;
                }
            }
        } else {
            StringBuffer stringBuffer4 = new StringBuffer("Wrong number of arguments for local method: ");
            stringBuffer4.append(this.name);
            throw new EvalError(stringBuffer4.toString(), simpleNode, kvVar);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Scripted Method: ");
        stringBuffer.append(lj.O000000o(this.name, this.cparamTypes));
        return stringBuffer.toString();
    }
}
