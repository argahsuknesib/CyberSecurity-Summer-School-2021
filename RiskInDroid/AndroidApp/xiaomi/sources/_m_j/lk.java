package _m_j;

import bsh.Capabilities;
import bsh.InterpreterError;
import bsh.Primitive;
import bsh.This;
import bsh.UtilEvalError;
import bsh.UtilTargetError;

public final class lk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Primitive f2167O000000o = new Primitive(1);
    public static Primitive O00000Oo = new Primitive(-1);
    static Class O00000o;
    static Class O00000o0;
    static Class O00000oO;
    static Class O00000oo;

    public static UtilEvalError O000000o(Class cls, Class cls2, int i) {
        return O000000o(lg.O000000o(cls), lg.O000000o(cls2), i);
    }

    public static UtilEvalError O000000o(String str, String str2, int i) {
        if (i == 1) {
            StringBuffer stringBuffer = new StringBuffer("Can't assign ");
            stringBuffer.append(str2);
            stringBuffer.append(" to ");
            stringBuffer.append(str);
            return new UtilEvalError(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer("Cannot cast ");
        stringBuffer2.append(str2);
        stringBuffer2.append(" to ");
        stringBuffer2.append(str);
        return new UtilTargetError(new ClassCastException(stringBuffer2.toString()));
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static Object O000000o(Class cls, Class cls2, Object obj, int i, boolean z) throws UtilEvalError {
        if (z && obj != null) {
            throw new InterpreterError("bad cast params 1");
        } else if (z || obj != null) {
            Class cls3 = O00000oO;
            if (cls3 == null) {
                cls3 = O000000o("bsh.Primitive");
                O00000oO = cls3;
            }
            if (cls2 == cls3) {
                throw new InterpreterError("bad from Type, need to unwrap");
            } else if (obj == Primitive.O00000Oo && cls2 != null) {
                throw new InterpreterError("inconsistent args 1");
            } else if (obj == Primitive.O00000o0 && cls2 != Void.TYPE) {
                throw new InterpreterError("inconsistent args 2");
            } else if (cls == Void.TYPE) {
                throw new InterpreterError("loose toType should be null");
            } else if (cls == null || cls == cls2) {
                return z ? f2167O000000o : obj;
            } else {
                if (cls.isPrimitive()) {
                    if (cls2 == Void.TYPE || cls2 == null || cls2.isPrimitive()) {
                        return Primitive.O000000o(cls, cls2, (Primitive) obj, z, i);
                    }
                    if (Primitive.O00000o0(cls2)) {
                        Class O00000Oo2 = Primitive.O00000Oo(cls2);
                        return Primitive.O000000o(cls, O00000Oo2, z ? null : (Primitive) Primitive.O000000o(obj, O00000Oo2), z, i);
                    } else if (z) {
                        return O00000Oo;
                    } else {
                        throw O000000o(cls, cls2, i);
                    }
                } else if (cls2 == Void.TYPE || cls2 == null || cls2.isPrimitive()) {
                    if (Primitive.O00000o0(cls) && cls2 != Void.TYPE && cls2 != null) {
                        return z ? f2167O000000o : Primitive.O000000o(Primitive.O00000Oo(cls), ((Primitive) obj).O000000o());
                    }
                    Class cls4 = O00000o0;
                    if (cls4 == null) {
                        cls4 = O000000o("java.lang.Object");
                        O00000o0 = cls4;
                    }
                    return (cls != cls4 || cls2 == Void.TYPE || cls2 == null) ? Primitive.O000000o(cls, cls2, (Primitive) obj, z, i) : z ? f2167O000000o : ((Primitive) obj).O000000o();
                } else if (cls.isAssignableFrom(cls2)) {
                    return z ? f2167O000000o : obj;
                } else {
                    if (cls.isInterface()) {
                        Class cls5 = O00000oo;
                        if (cls5 == null) {
                            cls5 = O000000o("bsh.This");
                            O00000oo = cls5;
                        }
                        if (cls5.isAssignableFrom(cls2) && Capabilities.O00000Oo()) {
                            return z ? f2167O000000o : ((This) obj).O000000o(cls);
                        }
                    }
                    if (Primitive.O00000o0(cls) && Primitive.O00000o0(cls2)) {
                        return z ? f2167O000000o : Primitive.O000000o(cls, obj);
                    }
                    if (z) {
                        return O00000Oo;
                    }
                    throw O000000o(cls, cls2, i);
                }
            }
        } else {
            throw new InterpreterError("bad cast params 2");
        }
    }

    public static Object O000000o(Object obj, Class cls, int i) throws UtilEvalError {
        if (obj != null) {
            return O000000o(cls, obj instanceof Primitive ? ((Primitive) obj).O00000Oo() : obj.getClass(), obj, i, false);
        }
        throw new InterpreterError("null fromValue");
    }

    public static boolean O000000o(Class cls, Class cls2) {
        return O00000Oo(cls, cls2) || O00000o0(cls, cls2);
    }

    static boolean O000000o(Class[] clsArr, Class[] clsArr2, int i) {
        if (i != 3 && clsArr.length != clsArr2.length) {
            return false;
        }
        if (i == 1) {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                if (!O00000Oo(clsArr2[i2], clsArr[i2])) {
                    return false;
                }
            }
            return true;
        } else if (i == 2) {
            for (int i3 = 0; i3 < clsArr.length; i3++) {
                if (!O00000o0(clsArr2[i3], clsArr[i3])) {
                    return false;
                }
            }
            return true;
        } else if (i == 3) {
            return false;
        } else {
            if (i == 4) {
                for (int i4 = 0; i4 < clsArr.length; i4++) {
                    if (!O00000o(clsArr2[i4], clsArr[i4])) {
                        return false;
                    }
                }
                return true;
            }
            throw new InterpreterError("bad case");
        }
    }

    public static Class[] O000000o(Object[] objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                clsArr[i] = null;
            } else if (objArr[i] instanceof Primitive) {
                clsArr[i] = ((Primitive) objArr[i]).O00000Oo();
            } else {
                clsArr[i] = objArr[i].getClass();
            }
        }
        return clsArr;
    }

    public static boolean O00000Oo(Class cls, Class cls2) {
        if (cls == null) {
            return false;
        }
        if (cls2 == null) {
            return !cls.isPrimitive();
        }
        if (!cls.isPrimitive() || !cls2.isPrimitive()) {
            if (cls.isAssignableFrom(cls2)) {
                return true;
            }
        } else if (cls == cls2) {
            return true;
        } else {
            if (cls2 == Byte.TYPE && (cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Short.TYPE && (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Character.TYPE && (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Integer.TYPE && (cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Long.TYPE && (cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            return cls2 == Float.TYPE && cls == Double.TYPE;
        }
    }

    private static boolean O00000o(Class cls, Class cls2) {
        try {
            return O000000o(cls, cls2, null, 1, true) == f2167O000000o;
        } catch (UtilEvalError e) {
            throw new InterpreterError("err in cast check: ".concat(String.valueOf(e)));
        }
    }

    private static boolean O00000o0(Class cls, Class cls2) {
        if (cls == null) {
            return false;
        }
        Class cls3 = O00000o0;
        if (cls3 == null) {
            cls3 = O000000o("java.lang.Object");
            O00000o0 = cls3;
        }
        if (cls == cls3) {
            return true;
        }
        Class cls4 = O00000o;
        if (cls4 == null) {
            cls4 = O000000o("java.lang.Number");
            O00000o = cls4;
        }
        return !(cls != cls4 || cls2 == Character.TYPE || cls2 == Boolean.TYPE) || Primitive.f3066O000000o.get(cls) == cls2;
    }
}
