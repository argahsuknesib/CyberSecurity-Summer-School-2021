package _m_j;

import bsh.Capabilities;
import bsh.EvalError;
import bsh.Interpreter;
import bsh.InterpreterError;
import bsh.LHS;
import bsh.Primitive;
import bsh.ReflectError;
import bsh.SimpleNode;
import bsh.This;
import bsh.UtilEvalError;
import bsh.UtilTargetError;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

public final class lg {
    private static int O000000o(Class[] clsArr, Constructor[] constructorArr) {
        Class[][] clsArr2 = new Class[constructorArr.length][];
        for (int i = 0; i < clsArr2.length; i++) {
            clsArr2[i] = constructorArr[i].getParameterTypes();
        }
        return O000000o(clsArr, clsArr2);
    }

    public static int O000000o(Class[] clsArr, Class[][] clsArr2) {
        int i = 1;
        while (true) {
            int i2 = -1;
            if (i > 4) {
                return -1;
            }
            Class[] clsArr3 = null;
            for (int i3 = 0; i3 < clsArr2.length; i3++) {
                Class[] clsArr4 = clsArr2[i3];
                if (lk.O000000o(clsArr, clsArr4, i) && (clsArr3 == null || lk.O000000o(clsArr4, clsArr3, 1))) {
                    i2 = i3;
                    clsArr3 = clsArr4;
                }
            }
            if (clsArr3 != null) {
                return i2;
            }
            i++;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method
     arg types: [_m_j.kt, java.lang.Class, ?[OBJECT, ARRAY], java.lang.String, java.lang.Object[], int]
     candidates:
      _m_j.lg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[], bsh.Interpreter, _m_j.kv, bsh.SimpleNode):java.lang.Object
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method */
    public static Object O000000o(kt ktVar, Class cls, String str, Object[] objArr) throws ReflectError, UtilEvalError, InvocationTargetException {
        Interpreter.O00000Oo("invoke static Method");
        return O000000o(O000000o(ktVar, cls, (Object) null, str, objArr, true), (Object) null, objArr);
    }

    public static Object O000000o(Class cls, Object obj, String str, boolean z) throws UtilEvalError, ReflectError {
        try {
            Field O00000Oo = O00000Oo(cls, str, z);
            return Primitive.O000000o(O00000Oo.get(obj), O00000Oo.getType());
        } catch (NullPointerException unused) {
            StringBuffer stringBuffer = new StringBuffer("???");
            stringBuffer.append(str);
            stringBuffer.append(" is not a static field.");
            throw new ReflectError(stringBuffer.toString());
        } catch (IllegalAccessException unused2) {
            throw new ReflectError("Can't access field: ".concat(String.valueOf(str)));
        }
    }

    public static Object O000000o(Object obj, int i) throws ReflectError, UtilTargetError {
        if (Interpreter.f3062O000000o) {
            StringBuffer stringBuffer = new StringBuffer("getIndex: ");
            stringBuffer.append(obj);
            stringBuffer.append(", index=");
            stringBuffer.append(i);
            Interpreter.O00000Oo(stringBuffer.toString());
        }
        try {
            return Primitive.O000000o(Array.get(obj, i), obj.getClass().getComponentType());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UtilTargetError(e);
        } catch (Exception e2) {
            throw new ReflectError("Array access:".concat(String.valueOf(e2)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(java.lang.Class, java.lang.Object, java.lang.String, boolean):java.lang.Object
     arg types: [java.lang.Class<?>, java.lang.Object, java.lang.String, int]
     candidates:
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.Object
      _m_j.lg.O000000o(java.lang.Class, java.lang.Object[], bsh.Interpreter, _m_j.kv):java.lang.Object
      _m_j.lg.O000000o(java.lang.Class, java.lang.Object, java.lang.String, boolean):java.lang.Object */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O00000Oo(java.lang.Class, java.lang.String):boolean
     arg types: [java.lang.Class<?>, java.lang.String]
     candidates:
      _m_j.lg.O00000Oo(java.lang.Object, java.lang.String):bsh.LHS
      _m_j.lg.O00000Oo(java.lang.Class, java.lang.String):boolean */
    public static Object O000000o(Object obj, String str) throws UtilEvalError, ReflectError {
        if (obj instanceof This) {
            return ((This) obj).namespace.O00000o0(str);
        }
        try {
            return O000000o((Class) obj.getClass(), obj, str, false);
        } catch (ReflectError e) {
            if (O00000Oo((Class) obj.getClass(), str)) {
                return O00000o0(obj, str);
            }
            throw e;
        }
    }

    public static Object O000000o(Method method, Object obj, Object[] objArr) throws ReflectError, InvocationTargetException {
        int i = 0;
        if (objArr == null) {
            objArr = new Object[0];
        }
        O000000o("Invoking method (entry): ", method, objArr);
        Object[] objArr2 = new Object[objArr.length];
        Class<?>[] parameterTypes = method.getParameterTypes();
        while (i < objArr.length) {
            try {
                objArr2[i] = lk.O000000o(objArr[i], parameterTypes[i], 1);
                i++;
            } catch (UtilEvalError e) {
                throw new InterpreterError("illegal argument type in method invocation: ".concat(String.valueOf(e)));
            }
        }
        Object[] O000000o2 = Primitive.O000000o(objArr2);
        O000000o("Invoking method (after massaging values): ", method, O000000o2);
        try {
            Object invoke = method.invoke(obj, O000000o2);
            if (invoke == null) {
                invoke = Primitive.O00000Oo;
            }
            return Primitive.O000000o(invoke, method.getReturnType());
        } catch (IllegalAccessException e2) {
            StringBuffer stringBuffer = new StringBuffer("Cannot access method ");
            stringBuffer.append(lj.O000000o(method.getName(), method.getParameterTypes()));
            stringBuffer.append(" in '");
            stringBuffer.append(method.getDeclaringClass());
            stringBuffer.append("' :");
            stringBuffer.append(e2);
            throw new ReflectError(stringBuffer.toString());
        }
    }

    public static String O000000o(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(String.valueOf(Character.toUpperCase(str2.charAt(0))));
        stringBuffer.append(str2.substring(1));
        return stringBuffer.toString();
    }

    public static Field O000000o(Class cls, String str, boolean z) throws UtilEvalError {
        try {
            return O00000Oo(cls, str, z);
        } catch (ReflectError unused) {
            return null;
        }
    }

    public static Method O000000o(kt ktVar, Class cls, Object obj, String str, Object[] objArr, boolean z) throws ReflectError, UtilEvalError {
        if (obj != Primitive.O00000Oo) {
            Class[] O000000o2 = lk.O000000o(objArr);
            Method O000000o3 = O000000o(ktVar, cls, str, O000000o2, z);
            if (O000000o3 != null) {
                return O000000o3;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(z ? "Static method " : "Method ");
            stringBuffer.append(lj.O000000o(str, O000000o2));
            stringBuffer.append(" not found in class'");
            stringBuffer.append(cls.getName());
            stringBuffer.append("'");
            throw new ReflectError(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer("Attempt to invoke method ");
        stringBuffer2.append(str);
        stringBuffer2.append(" on null value");
        throw new UtilTargetError(new NullPointerException(stringBuffer2.toString()));
    }

    private static Method O000000o(Class[] clsArr, Method[] methodArr) {
        Class[][] clsArr2 = new Class[methodArr.length][];
        for (int i = 0; i < methodArr.length; i++) {
            clsArr2[i] = methodArr[i].getParameterTypes();
        }
        int O000000o2 = O000000o(clsArr, clsArr2);
        if (O000000o2 == -1) {
            return null;
        }
        return methodArr[O000000o2];
    }

    private static void O000000o(String str, Method method, Object[] objArr) {
        if (Interpreter.f3062O000000o) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(method);
            stringBuffer.append(" with args:");
            Interpreter.O00000Oo(stringBuffer.toString());
            for (int i = 0; i < objArr.length; i++) {
                StringBuffer stringBuffer2 = new StringBuffer("args[");
                stringBuffer2.append(i);
                stringBuffer2.append("] = ");
                stringBuffer2.append(objArr[i]);
                stringBuffer2.append(" type = ");
                stringBuffer2.append(objArr[i].getClass());
                Interpreter.O00000Oo(stringBuffer2.toString());
            }
        }
    }

    public static int O00000Oo(Class cls) {
        if (!cls.isArray()) {
            return 0;
        }
        return cls.getName().lastIndexOf(91) + 1;
    }

    public static Field O00000Oo(Class cls, String str, boolean z) throws UtilEvalError, ReflectError {
        try {
            Field O000000o2 = Capabilities.O00000o0() ? O000000o(cls, str) : cls.getField(str);
            if (!z || Modifier.isStatic(O000000o2.getModifiers())) {
                return O000000o2;
            }
            StringBuffer stringBuffer = new StringBuffer("Can't reach instance field: ");
            stringBuffer.append(str);
            stringBuffer.append(" from static context: ");
            stringBuffer.append(cls.getName());
            throw new UtilEvalError(stringBuffer.toString());
        } catch (NoSuchFieldException unused) {
            throw new ReflectError("No such field: ".concat(String.valueOf(str)));
        } catch (SecurityException e) {
            throw new UtilTargetError("Security Exception while searching fields of: ".concat(String.valueOf(cls)), e);
        }
    }

    private static boolean O00000Oo(Class cls, String str) {
        try {
            cls.getMethod(O000000o("get", str), new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            try {
                return cls.getMethod(O000000o("is", str), new Class[0]).getReturnType() == Boolean.TYPE;
            } catch (NoSuchMethodException unused2) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method
     arg types: [?[OBJECT, ARRAY], java.lang.Class<?>, java.lang.Object, java.lang.String, java.lang.Object[], int]
     candidates:
      _m_j.lg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[], bsh.Interpreter, _m_j.kv, bsh.SimpleNode):java.lang.Object
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method */
    public static Object O00000o0(Object obj, String str) throws UtilEvalError, ReflectError {
        Exception exc;
        Method method;
        Object[] objArr = new Object[0];
        Interpreter.O00000Oo("property access: ");
        Exception exc2 = null;
        try {
            method = O000000o((kt) null, (Class) obj.getClass(), obj, O000000o("get", str), objArr, false);
            exc = null;
        } catch (Exception e) {
            exc = e;
            method = null;
        }
        if (method == null) {
            try {
                Method O000000o2 = O000000o((kt) null, (Class) obj.getClass(), obj, O000000o("is", str), objArr, false);
                try {
                    method = O000000o2.getReturnType() != Boolean.TYPE ? null : O000000o2;
                } catch (Exception e2) {
                    method = O000000o2;
                    exc2 = e2;
                }
            } catch (Exception e3) {
                exc2 = e3;
            }
        }
        if (method == null) {
            StringBuffer stringBuffer = new StringBuffer("Error in property getter: ");
            stringBuffer.append(exc);
            stringBuffer.append(exc2 != null ? " : ".concat(String.valueOf(exc2)) : "");
            throw new ReflectError(stringBuffer.toString());
        }
        try {
            return O000000o(method, obj, objArr);
        } catch (InvocationTargetException e4) {
            StringBuffer stringBuffer2 = new StringBuffer("Property accessor threw exception: ");
            stringBuffer2.append(e4.getTargetException());
            throw new UtilEvalError(stringBuffer2.toString());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method
     arg types: [_m_j.kt, java.lang.Class<?>, java.lang.Object, java.lang.String, java.lang.Object[], int]
     candidates:
      _m_j.lg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[], bsh.Interpreter, _m_j.kv, bsh.SimpleNode):java.lang.Object
      _m_j.lg.O000000o(_m_j.kt, java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[], boolean):java.lang.reflect.Method */
    public static Object O000000o(Object obj, String str, Object[] objArr, Interpreter interpreter, kv kvVar, SimpleNode simpleNode) throws ReflectError, EvalError, InvocationTargetException {
        kt O00000o;
        if ((obj instanceof This) && !This.O000000o(str)) {
            return ((This) obj).O000000o(str, objArr, interpreter, kvVar, simpleNode);
        }
        if (interpreter == null) {
            O00000o = null;
        } else {
            try {
                O00000o = interpreter.globalNameSpace.O00000o();
            } catch (UtilEvalError e) {
                throw e.toEvalError(simpleNode, kvVar);
            }
        }
        return O000000o(O000000o(O00000o, (Class) obj.getClass(), obj, str, objArr, false), obj, objArr);
    }

    public static LHS O00000Oo(Object obj, String str) throws UtilEvalError, ReflectError {
        boolean z = false;
        if (obj instanceof This) {
            return new LHS(((This) obj).namespace, str, false);
        }
        try {
            return new LHS(obj, O00000Oo(obj.getClass(), str, false));
        } catch (ReflectError e) {
            Class<?> cls = obj.getClass();
            String O000000o2 = O000000o("set", str);
            Method[] methods = cls.getMethods();
            int i = 0;
            while (true) {
                if (i >= methods.length) {
                    break;
                } else if (methods[i].getName().equals(O000000o2)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return new LHS(obj, str);
            }
            throw e;
        }
    }

    private static Field O000000o(Class cls, String str) throws UtilEvalError, NoSuchFieldException {
        try {
            Field field = cls.getField(str);
            lh.O000000o();
            return field;
        } catch (NoSuchFieldException unused) {
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    lh.O000000o();
                    return declaredField;
                } catch (NoSuchFieldException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchFieldException(str);
        }
    }

    public static Method O000000o(kt ktVar, Class cls, String str, Class[] clsArr, boolean z) throws UtilEvalError {
        Method method;
        if (cls != null) {
            if (ktVar == null) {
                Interpreter.O00000Oo("resolveJavaMethod UNOPTIMIZED lookup");
                method = null;
            } else {
                method = ktVar.O000000o(cls, str, clsArr, z);
            }
            if (method != null) {
                return method;
            }
            boolean z2 = !Capabilities.O00000o0();
            try {
                if (Interpreter.f3062O000000o) {
                    StringBuffer stringBuffer = new StringBuffer("Searching for method: ");
                    stringBuffer.append(lj.O000000o(str, clsArr));
                    stringBuffer.append(" in '");
                    stringBuffer.append(cls.getName());
                    stringBuffer.append("'");
                    Interpreter.O00000Oo(stringBuffer.toString());
                }
                Vector O000000o2 = O000000o(cls, str, clsArr.length, z2, (Vector) null);
                Method[] methodArr = new Method[O000000o2.size()];
                O000000o2.copyInto(methodArr);
                if (Interpreter.f3062O000000o) {
                    Interpreter.O00000Oo("Looking for most specific method: ".concat(String.valueOf(str)));
                }
                Method O000000o3 = O000000o(clsArr, methodArr);
                if (O000000o3 == null || !z || Modifier.isStatic(O000000o3.getModifiers())) {
                    if (O000000o3 != null && !z2) {
                        try {
                            lh.O000000o();
                        } catch (UtilEvalError unused) {
                        }
                    }
                    if (O000000o3 == null || ktVar == null) {
                        return O000000o3;
                    }
                    ktVar.O000000o(cls, clsArr, O000000o3);
                    return O000000o3;
                }
                StringBuffer stringBuffer2 = new StringBuffer("Cannot reach instance method: ");
                stringBuffer2.append(lj.O000000o(O000000o3.getName(), O000000o3.getParameterTypes()));
                stringBuffer2.append(" from static context: ");
                stringBuffer2.append(cls.getName());
                throw new UtilEvalError(stringBuffer2.toString());
            } catch (SecurityException e) {
                throw new UtilTargetError("Security Exception while searching methods of: ".concat(String.valueOf(cls)), e);
            }
        } else {
            throw new InterpreterError("null class");
        }
    }

    private static Vector O000000o(Class cls, String str, int i, boolean z, Vector vector) {
        if (vector == null) {
            vector = new Vector();
        }
        if (!z) {
            O000000o(cls.getDeclaredMethods(), str, i, z, vector);
        } else if (Modifier.isPublic(cls.getModifiers())) {
            O000000o(cls.getMethods(), str, i, z, vector);
        }
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> O000000o2 : interfaces) {
            O000000o(O000000o2, str, i, z, vector);
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            O000000o(superclass, str, i, z, vector);
        }
        return vector;
    }

    private static Vector O000000o(Method[] methodArr, String str, int i, boolean z, Vector vector) {
        for (Method method : methodArr) {
            if (method.getName().equals(str) && method.getParameterTypes().length == i && (!z || Modifier.isPublic(method.getModifiers()))) {
                vector.add(method);
            }
        }
        return vector;
    }

    public static Object O000000o(Class cls, Object[] objArr) throws ReflectError, InvocationTargetException {
        ReflectError reflectError;
        if (!cls.isInterface()) {
            Class[] O000000o2 = lk.O000000o(objArr);
            Constructor<?>[] declaredConstructors = Capabilities.O00000o0() ? cls.getDeclaredConstructors() : cls.getConstructors();
            if (Interpreter.f3062O000000o) {
                Interpreter.O00000Oo("Looking for most specific constructor: ".concat(String.valueOf(cls)));
            }
            int O000000o3 = O000000o(O000000o2, declaredConstructors);
            Constructor<?> constructor = O000000o3 == -1 ? null : declaredConstructors[O000000o3];
            if (constructor == null) {
                if (O000000o2.length == 0) {
                    reflectError = new ReflectError("Can't find default constructor for: ".concat(String.valueOf(cls)));
                } else {
                    StringBuffer stringBuffer = new StringBuffer("Can't find constructor: ");
                    stringBuffer.append(lj.O000000o(cls.getName(), O000000o2));
                    stringBuffer.append(" in class: ");
                    stringBuffer.append(cls.getName());
                    reflectError = new ReflectError(stringBuffer.toString());
                }
                throw reflectError;
            }
            if (!Modifier.isPublic(constructor.getModifiers())) {
                try {
                    lh.O000000o();
                } catch (UtilEvalError unused) {
                }
            }
            try {
                Object newInstance = constructor.newInstance(Primitive.O000000o(objArr));
                if (newInstance != null) {
                    return newInstance;
                }
                throw new ReflectError("Couldn't construct the object");
            } catch (InstantiationException unused2) {
                StringBuffer stringBuffer2 = new StringBuffer("The class ");
                stringBuffer2.append(cls);
                stringBuffer2.append(" is abstract ");
                throw new ReflectError(stringBuffer2.toString());
            } catch (IllegalAccessException unused3) {
                throw new ReflectError("We don't have permission to create an instance.Use setAccessibility(true) to enable access.");
            } catch (IllegalArgumentException unused4) {
                throw new ReflectError("The number of arguments was wrong");
            }
        } else {
            throw new ReflectError("Can't create instance of an interface: ".concat(String.valueOf(cls)));
        }
    }

    public static String O000000o(Class cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            if (cls.isArray()) {
                stringBuffer2.append(cls.getComponentType().getName());
                stringBuffer2.append(" ");
                stringBuffer.append(stringBuffer2.toString());
                for (int i = 0; i < O00000Oo(cls); i++) {
                    stringBuffer.append("[]");
                }
                return stringBuffer.toString();
            }
            throw new ReflectError("The class is not an array.");
        } catch (ReflectError unused) {
        }
    }

    public static Object O000000o(Class cls, Object[] objArr, Interpreter interpreter, kv kvVar) throws UtilEvalError {
        Object[] objArr2 = new Object[(objArr.length + 2)];
        objArr2[0] = interpreter;
        objArr2[1] = kvVar;
        System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
        try {
            return O000000o(interpreter.globalNameSpace.O00000o(), cls, "invoke", objArr2);
        } catch (InvocationTargetException e) {
            StringBuffer stringBuffer = new StringBuffer("Error in compiled command: ");
            stringBuffer.append(e.getTargetException());
            throw new UtilEvalError(stringBuffer.toString());
        } catch (ReflectError e2) {
            throw new UtilEvalError("Error invoking compiled command: ".concat(String.valueOf(e2)));
        }
    }
}
