package bsh;

import _m_j.ld;
import _m_j.lg;
import _m_j.lk;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.Serializable;
import java.util.Hashtable;

public final class Primitive implements ld, Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Hashtable f3066O000000o;
    public static final Primitive O00000Oo = new Primitive(Special.f3067O000000o);
    static Class O00000o;
    public static final Primitive O00000o0 = new Primitive(Special.O00000Oo);
    static Class O00000oO;
    static Class O00000oo;
    static Class O0000O0o;
    static Class O0000Oo;
    static Class O0000Oo0;
    static Class O0000OoO;
    static Class O0000Ooo;
    static Class O0000o00;
    private Object value;

    static class Special implements Serializable {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final Special f3067O000000o = new Special();
        public static final Special O00000Oo = new Special();

        private Special() {
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        f3066O000000o = hashtable;
        Class cls = Boolean.TYPE;
        Class cls2 = O00000o;
        if (cls2 == null) {
            cls2 = O000000o("java.lang.Boolean");
            O00000o = cls2;
        }
        hashtable.put(cls, cls2);
        Hashtable hashtable2 = f3066O000000o;
        Class cls3 = Byte.TYPE;
        Class cls4 = O00000oO;
        if (cls4 == null) {
            cls4 = O000000o("java.lang.Byte");
            O00000oO = cls4;
        }
        hashtable2.put(cls3, cls4);
        Hashtable hashtable3 = f3066O000000o;
        Class cls5 = Short.TYPE;
        Class cls6 = O00000oo;
        if (cls6 == null) {
            cls6 = O000000o("java.lang.Short");
            O00000oo = cls6;
        }
        hashtable3.put(cls5, cls6);
        Hashtable hashtable4 = f3066O000000o;
        Class cls7 = Character.TYPE;
        Class cls8 = O0000O0o;
        if (cls8 == null) {
            cls8 = O000000o("java.lang.Character");
            O0000O0o = cls8;
        }
        hashtable4.put(cls7, cls8);
        Hashtable hashtable5 = f3066O000000o;
        Class cls9 = Integer.TYPE;
        Class cls10 = O0000Oo0;
        if (cls10 == null) {
            cls10 = O000000o("java.lang.Integer");
            O0000Oo0 = cls10;
        }
        hashtable5.put(cls9, cls10);
        Hashtable hashtable6 = f3066O000000o;
        Class cls11 = Long.TYPE;
        Class cls12 = O0000Oo;
        if (cls12 == null) {
            cls12 = O000000o("java.lang.Long");
            O0000Oo = cls12;
        }
        hashtable6.put(cls11, cls12);
        Hashtable hashtable7 = f3066O000000o;
        Class cls13 = Float.TYPE;
        Class cls14 = O0000OoO;
        if (cls14 == null) {
            cls14 = O000000o("java.lang.Float");
            O0000OoO = cls14;
        }
        hashtable7.put(cls13, cls14);
        Hashtable hashtable8 = f3066O000000o;
        Class cls15 = Double.TYPE;
        Class cls16 = O0000Ooo;
        if (cls16 == null) {
            cls16 = O000000o("java.lang.Double");
            O0000Ooo = cls16;
        }
        hashtable8.put(cls15, cls16);
        Hashtable hashtable9 = f3066O000000o;
        Class cls17 = O00000o;
        if (cls17 == null) {
            cls17 = O000000o("java.lang.Boolean");
            O00000o = cls17;
        }
        hashtable9.put(cls17, Boolean.TYPE);
        Hashtable hashtable10 = f3066O000000o;
        Class cls18 = O00000oO;
        if (cls18 == null) {
            cls18 = O000000o("java.lang.Byte");
            O00000oO = cls18;
        }
        hashtable10.put(cls18, Byte.TYPE);
        Hashtable hashtable11 = f3066O000000o;
        Class cls19 = O00000oo;
        if (cls19 == null) {
            cls19 = O000000o("java.lang.Short");
            O00000oo = cls19;
        }
        hashtable11.put(cls19, Short.TYPE);
        Hashtable hashtable12 = f3066O000000o;
        Class cls20 = O0000O0o;
        if (cls20 == null) {
            cls20 = O000000o("java.lang.Character");
            O0000O0o = cls20;
        }
        hashtable12.put(cls20, Character.TYPE);
        Hashtable hashtable13 = f3066O000000o;
        Class cls21 = O0000Oo0;
        if (cls21 == null) {
            cls21 = O000000o("java.lang.Integer");
            O0000Oo0 = cls21;
        }
        hashtable13.put(cls21, Integer.TYPE);
        Hashtable hashtable14 = f3066O000000o;
        Class cls22 = O0000Oo;
        if (cls22 == null) {
            cls22 = O000000o("java.lang.Long");
            O0000Oo = cls22;
        }
        hashtable14.put(cls22, Long.TYPE);
        Hashtable hashtable15 = f3066O000000o;
        Class cls23 = O0000OoO;
        if (cls23 == null) {
            cls23 = O000000o("java.lang.Float");
            O0000OoO = cls23;
        }
        hashtable15.put(cls23, Float.TYPE);
        Hashtable hashtable16 = f3066O000000o;
        Class cls24 = O0000Ooo;
        if (cls24 == null) {
            cls24 = O000000o("java.lang.Double");
            O0000Ooo = cls24;
        }
        hashtable16.put(cls24, Double.TYPE);
    }

    private Primitive(byte b) {
        this(Byte.valueOf(b));
    }

    public Primitive(char c) {
        this(Character.valueOf(c));
    }

    public Primitive(double d) {
        this(Double.valueOf(d));
    }

    public Primitive(float f) {
        this(Float.valueOf(f));
    }

    public Primitive(int i) {
        this(Integer.valueOf(i));
    }

    public Primitive(long j) {
        this(new Long(j));
    }

    private Primitive(Object obj) {
        if (obj == null) {
            throw new InterpreterError("Use Primitve.NULL instead of Primitive(null)");
        } else if (obj == Special.f3067O000000o || obj == Special.O00000Oo || O00000o0(obj.getClass())) {
            this.value = obj;
        } else {
            throw new InterpreterError("Not a wrapper type: ".concat(String.valueOf(obj)));
        }
    }

    private Primitive(short s) {
        this(Short.valueOf(s));
    }

    public Primitive(boolean z) {
        this(Boolean.valueOf(z));
    }

    static double O000000o(Double d, int i) {
        double doubleValue = d.doubleValue();
        if (i == 102) {
            return doubleValue;
        }
        if (i == 103) {
            return -doubleValue;
        }
        throw new InterpreterError("bad double unaryOperation");
    }

    static float O000000o(Float f, int i) {
        float floatValue = f.floatValue();
        if (i == 102) {
            return floatValue;
        }
        if (i == 103) {
            return -floatValue;
        }
        throw new InterpreterError("bad float unaryOperation");
    }

    static int O000000o(Integer num, int i) {
        int intValue = num.intValue();
        if (i == 87) {
            return intValue ^ -1;
        }
        switch (i) {
            case 100:
                return intValue + 1;
            case 101:
                return intValue - 1;
            case 102:
                return intValue;
            case 103:
                return -intValue;
            default:
                throw new InterpreterError("bad integer unaryOperation");
        }
    }

    static long O000000o(Long l, int i) {
        long longValue = l.longValue();
        if (i == 87) {
            return -1 ^ longValue;
        }
        switch (i) {
            case 100:
                return longValue + 1;
            case 101:
                return longValue - 1;
            case 102:
                return longValue;
            case 103:
                return -longValue;
            default:
                throw new InterpreterError("bad long unaryOperation");
        }
    }

    public static Primitive O000000o(Primitive primitive, int i) throws UtilEvalError {
        if (primitive == O00000Oo) {
            throw new UtilEvalError("illegal use of null object or 'null' literal");
        } else if (primitive != O00000o0) {
            Class O00000Oo2 = primitive.O00000Oo();
            Object O000000o2 = O000000o(primitive.O000000o());
            if (O000000o2 instanceof Boolean) {
                return new Primitive(O000000o((Boolean) O000000o2, i));
            }
            if (O000000o2 instanceof Integer) {
                int O000000o3 = O000000o((Integer) O000000o2, i);
                if (i == 100 || i == 101) {
                    if (O00000Oo2 == Byte.TYPE) {
                        return new Primitive((byte) O000000o3);
                    }
                    if (O00000Oo2 == Short.TYPE) {
                        return new Primitive((short) O000000o3);
                    }
                    if (O00000Oo2 == Character.TYPE) {
                        return new Primitive((char) O000000o3);
                    }
                }
                return new Primitive(O000000o3);
            } else if (O000000o2 instanceof Long) {
                return new Primitive(O000000o((Long) O000000o2, i));
            } else {
                if (O000000o2 instanceof Float) {
                    return new Primitive(O000000o((Float) O000000o2, i));
                }
                if (O000000o2 instanceof Double) {
                    return new Primitive(O000000o((Double) O000000o2, i));
                }
                throw new InterpreterError("An error occurred.  Please call technical support.");
            }
        } else {
            throw new UtilEvalError("illegal use of undefined object or 'void' literal");
        }
    }

    public static Primitive O000000o(Class cls, Class cls2, Primitive primitive, boolean z, int i) throws UtilEvalError {
        if (z && primitive != null) {
            throw new InterpreterError("bad cast param 1");
        } else if (!z && primitive == null) {
            throw new InterpreterError("bad cast param 2");
        } else if (cls2 != null && !cls2.isPrimitive()) {
            throw new InterpreterError("bad fromType:".concat(String.valueOf(cls2)));
        } else if (primitive == O00000Oo && cls2 != null) {
            throw new InterpreterError("inconsistent args 1");
        } else if (primitive == O00000o0 && cls2 != Void.TYPE) {
            throw new InterpreterError("inconsistent args 2");
        } else if (cls2 != Void.TYPE) {
            Object obj = null;
            if (primitive != null) {
                obj = primitive.O000000o();
            }
            if (cls.isPrimitive()) {
                if (cls2 == null) {
                    if (z) {
                        return lk.O00000Oo;
                    }
                    throw lk.O000000o("primitive type:".concat(String.valueOf(cls)), "Null value", i);
                } else if (cls2 == Boolean.TYPE) {
                    if (cls == Boolean.TYPE) {
                        return z ? lk.f2167O000000o : primitive;
                    }
                    if (z) {
                        return lk.O00000Oo;
                    }
                    throw lk.O000000o(cls, cls2, i);
                } else if (i != 1 || lk.O000000o(cls, cls2)) {
                    return z ? lk.f2167O000000o : new Primitive(O000000o(cls, obj));
                } else {
                    if (z) {
                        return lk.O00000Oo;
                    }
                    throw lk.O000000o(cls, cls2, i);
                }
            } else if (cls2 == null) {
                return z ? lk.f2167O000000o : O00000Oo;
            } else {
                if (z) {
                    return lk.O00000Oo;
                }
                throw lk.O000000o("object type:".concat(String.valueOf(cls)), "primitive value", i);
            }
        } else if (z) {
            return lk.O00000Oo;
        } else {
            throw lk.O000000o(lg.O000000o(cls), "void value", i);
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Object O000000o(Class cls, Object obj) {
        if (!cls.isPrimitive()) {
            throw new InterpreterError("invalid type in castWrapper: ".concat(String.valueOf(cls)));
        } else if (obj == null) {
            throw new InterpreterError("null value in castWrapper, guard");
        } else if (!(obj instanceof Boolean)) {
            if (obj instanceof Character) {
                obj = new Integer(((Character) obj).charValue());
            }
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (cls == Byte.TYPE) {
                    return new Byte(number.byteValue());
                }
                if (cls == Short.TYPE) {
                    return new Short(number.shortValue());
                }
                if (cls == Character.TYPE) {
                    return new Character((char) number.intValue());
                }
                if (cls == Integer.TYPE) {
                    return new Integer(number.intValue());
                }
                if (cls == Long.TYPE) {
                    return new Long(number.longValue());
                }
                if (cls == Float.TYPE) {
                    return new Float(number.floatValue());
                }
                if (cls == Double.TYPE) {
                    return new Double(number.doubleValue());
                }
                throw new InterpreterError("error in wrapper cast");
            }
            throw new InterpreterError("bad type in cast");
        } else if (cls == Boolean.TYPE) {
            return obj;
        } else {
            throw new InterpreterError("bad wrapper cast of boolean");
        }
    }

    static Object O000000o(Object obj) {
        return obj instanceof Character ? new Integer(((Character) obj).charValue()) : ((obj instanceof Byte) || (obj instanceof Short)) ? new Integer(((Number) obj).intValue()) : obj;
    }

    public static Object O000000o(Object obj, Class cls) {
        return cls == Void.TYPE ? O00000o0 : obj == null ? O00000Oo : cls.isPrimitive() ? new Primitive(obj) : obj;
    }

    static boolean O000000o(Boolean bool, int i) throws UtilEvalError {
        boolean booleanValue = bool.booleanValue();
        if (i == 86) {
            return !booleanValue;
        }
        throw new UtilEvalError("Operator inappropriate for boolean");
    }

    public static Object[] O000000o(Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = O00000Oo(objArr[i]);
        }
        return objArr2;
    }

    public static Class O00000Oo(Class cls) {
        Class cls2 = (Class) f3066O000000o.get(cls);
        if (cls2 != null) {
            return cls2;
        }
        throw new InterpreterError("Not a primitive wrapper type: ".concat(String.valueOf(cls)));
    }

    public static Object O00000Oo(Object obj) {
        if (obj == O00000o0) {
            return null;
        }
        return obj instanceof Primitive ? ((Primitive) obj).O000000o() : obj;
    }

    public static boolean O00000o0(Class cls) {
        return f3066O000000o.get(cls) != null && !cls.isPrimitive();
    }

    public final Object O000000o() {
        if (this.value == Special.f3067O000000o) {
            return null;
        }
        if (this.value != Special.O00000Oo) {
            return this.value;
        }
        throw new InterpreterError("attempt to unwrap void type");
    }

    public final Class O00000Oo() {
        if (this == O00000o0) {
            return Void.TYPE;
        }
        if (this == O00000Oo) {
            return null;
        }
        return O00000Oo((Class) this.value.getClass());
    }

    public final int O00000o0() throws UtilEvalError {
        Object obj = this.value;
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        throw new UtilEvalError("Primitive not a number");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Primitive) {
            return ((Primitive) obj).value.equals(this.value);
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() * 21;
    }

    public final String toString() {
        return this.value == Special.f3067O000000o ? "null" : this.value == Special.O00000Oo ? "void" : this.value.toString();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x03e6, code lost:
        if (r1 != r8) goto L_0x03e8;
     */
    public static Object O000000o(Object obj, Object obj2, int i) throws UtilEvalError {
        Object obj3;
        Primitive primitive = O00000Oo;
        if (obj == primitive || obj2 == primitive) {
            throw new UtilEvalError("Null value or 'null' literal in binary operation");
        }
        Primitive primitive2 = O00000o0;
        if (obj == primitive2 || obj2 == primitive2) {
            throw new UtilEvalError("Undefined variable, class, or 'void' literal in binary operation");
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (obj instanceof Primitive) {
            obj = ((Primitive) obj).O000000o();
        }
        if (obj2 instanceof Primitive) {
            obj2 = ((Primitive) obj2).O000000o();
        }
        Object O000000o2 = O000000o(obj);
        Object O000000o3 = O000000o(obj2);
        if ((O000000o2 instanceof Number) && (O000000o3 instanceof Number)) {
            Number number = (Number) O000000o2;
            Number number2 = (Number) O000000o3;
            boolean z = number instanceof Double;
            if (!z && !(number2 instanceof Double)) {
                boolean z2 = number instanceof Float;
                if (!z2 && !(number2 instanceof Float)) {
                    boolean z3 = number instanceof Long;
                    if (z3 || (number2 instanceof Long)) {
                        if (z3) {
                            O000000o3 = new Long(number2.longValue());
                        } else {
                            O000000o2 = new Long(number.longValue());
                        }
                    }
                } else if (z2) {
                    O000000o3 = new Float(number2.floatValue());
                } else {
                    O000000o2 = new Float(number.floatValue());
                }
            } else if (z) {
                O000000o3 = new Double(number2.doubleValue());
            } else {
                O000000o2 = new Double(number.doubleValue());
            }
        }
        boolean z4 = true;
        Object[] objArr = {O000000o2, O000000o3};
        Object obj4 = objArr[0];
        Object obj5 = objArr[1];
        if (obj4.getClass() == obj5.getClass()) {
            try {
                if (obj4 instanceof Boolean) {
                    boolean booleanValue = ((Boolean) obj4).booleanValue();
                    boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                    if (i != 90) {
                        switch (i) {
                            case 95:
                                if (booleanValue == booleanValue2) {
                                    z4 = false;
                                }
                                obj3 = new Boolean(z4);
                                break;
                            case 96:
                            case 97:
                                if (!booleanValue) {
                                    if (!booleanValue2) {
                                        z4 = false;
                                    }
                                }
                                obj3 = new Boolean(z4);
                                break;
                            case 98:
                            case 99:
                                if (!booleanValue || !booleanValue2) {
                                    z4 = false;
                                }
                                obj3 = new Boolean(z4);
                                break;
                            default:
                                throw new InterpreterError("unimplemented binary operator");
                        }
                    } else {
                        if (booleanValue != booleanValue2) {
                            z4 = false;
                        }
                        obj3 = new Boolean(z4);
                    }
                } else if (obj4 instanceof Integer) {
                    int intValue = ((Integer) obj4).intValue();
                    int intValue2 = ((Integer) obj5).intValue();
                    switch (i) {
                        case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                        case 83:
                            if (intValue <= intValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        case 84:
                        case 85:
                            if (intValue >= intValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        default:
                            switch (i) {
                                case 90:
                                    if (intValue != intValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 91:
                                case 92:
                                    if (intValue > intValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 93:
                                case 94:
                                    if (intValue < intValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 95:
                                    if (intValue == intValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                default:
                                    switch (i) {
                                        case 102:
                                            obj3 = new Integer(intValue + intValue2);
                                            break;
                                        case 103:
                                            obj3 = new Integer(intValue - intValue2);
                                            break;
                                        case 104:
                                            obj3 = new Integer(intValue * intValue2);
                                            break;
                                        case 105:
                                            obj3 = new Integer(intValue / intValue2);
                                            break;
                                        case 106:
                                        case 107:
                                            obj3 = new Integer(intValue & intValue2);
                                            break;
                                        case 108:
                                        case 109:
                                            obj3 = new Integer(intValue | intValue2);
                                            break;
                                        case 110:
                                            obj3 = new Integer(intValue ^ intValue2);
                                            break;
                                        case 111:
                                            obj3 = new Integer(intValue % intValue2);
                                            break;
                                        case 112:
                                        case 113:
                                            obj3 = new Integer(intValue << intValue2);
                                            break;
                                        case 114:
                                        case 115:
                                            obj3 = new Integer(intValue >> intValue2);
                                            break;
                                        case 116:
                                        case 117:
                                            obj3 = new Integer(intValue >>> intValue2);
                                            break;
                                        default:
                                            throw new InterpreterError("Unimplemented binary integer operator");
                                    }
                            }
                    }
                } else if (obj4 instanceof Long) {
                    long longValue = ((Long) obj4).longValue();
                    long longValue2 = ((Long) obj5).longValue();
                    switch (i) {
                        case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                        case 83:
                            if (longValue <= longValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        case 84:
                        case 85:
                            if (longValue >= longValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        default:
                            switch (i) {
                                case 90:
                                    if (longValue != longValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 91:
                                case 92:
                                    if (longValue > longValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 93:
                                case 94:
                                    if (longValue < longValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 95:
                                    if (longValue == longValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                default:
                                    switch (i) {
                                        case 102:
                                            obj3 = new Long(longValue + longValue2);
                                            break;
                                        case 103:
                                            obj3 = new Long(longValue - longValue2);
                                            break;
                                        case 104:
                                            obj3 = new Long(longValue * longValue2);
                                            break;
                                        case 105:
                                            obj3 = new Long(longValue / longValue2);
                                            break;
                                        case 106:
                                        case 107:
                                            obj3 = new Long(longValue & longValue2);
                                            break;
                                        case 108:
                                        case 109:
                                            obj3 = new Long(longValue | longValue2);
                                            break;
                                        case 110:
                                            obj3 = new Long(longValue ^ longValue2);
                                            break;
                                        case 111:
                                            obj3 = new Long(longValue % longValue2);
                                            break;
                                        case 112:
                                        case 113:
                                            obj3 = new Long(longValue << ((int) longValue2));
                                            break;
                                        case 114:
                                        case 115:
                                            obj3 = new Long(longValue >> ((int) longValue2));
                                            break;
                                        case 116:
                                        case 117:
                                            obj3 = new Long(longValue >>> ((int) longValue2));
                                            break;
                                        default:
                                            throw new InterpreterError("Unimplemented binary long operator");
                                    }
                            }
                    }
                } else if (obj4 instanceof Float) {
                    float floatValue = ((Float) obj4).floatValue();
                    float floatValue2 = ((Float) obj5).floatValue();
                    switch (i) {
                        case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                        case 83:
                            if (floatValue <= floatValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        case 84:
                        case 85:
                            if (floatValue >= floatValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        default:
                            switch (i) {
                                case 90:
                                    if (floatValue != floatValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 91:
                                case 92:
                                    if (floatValue > floatValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 93:
                                case 94:
                                    if (floatValue < floatValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 95:
                                    if (floatValue == floatValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                default:
                                    switch (i) {
                                        case 102:
                                            obj3 = new Float(floatValue + floatValue2);
                                            break;
                                        case 103:
                                            obj3 = new Float(floatValue - floatValue2);
                                            break;
                                        case 104:
                                            obj3 = new Float(floatValue * floatValue2);
                                            break;
                                        case 105:
                                            obj3 = new Float(floatValue / floatValue2);
                                            break;
                                        default:
                                            switch (i) {
                                                case 111:
                                                    obj3 = new Float(floatValue % floatValue2);
                                                    break;
                                                case 112:
                                                case 113:
                                                case 114:
                                                case 115:
                                                case 116:
                                                case 117:
                                                    throw new UtilEvalError("Can't shift floats ");
                                                default:
                                                    throw new InterpreterError("Unimplemented binary float operator");
                                            }
                                    }
                            }
                    }
                } else if (obj4 instanceof Double) {
                    double doubleValue = ((Double) obj4).doubleValue();
                    double doubleValue2 = ((Double) obj5).doubleValue();
                    switch (i) {
                        case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                        case 83:
                            if (doubleValue <= doubleValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        case 84:
                        case 85:
                            if (doubleValue >= doubleValue2) {
                                z4 = false;
                            }
                            obj3 = new Boolean(z4);
                            break;
                        default:
                            switch (i) {
                                case 90:
                                    if (doubleValue != doubleValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 91:
                                case 92:
                                    if (doubleValue > doubleValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 93:
                                case 94:
                                    if (doubleValue < doubleValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                case 95:
                                    if (doubleValue == doubleValue2) {
                                        z4 = false;
                                    }
                                    obj3 = new Boolean(z4);
                                    break;
                                default:
                                    switch (i) {
                                        case 102:
                                            obj3 = new Double(doubleValue + doubleValue2);
                                            break;
                                        case 103:
                                            obj3 = new Double(doubleValue - doubleValue2);
                                            break;
                                        case 104:
                                            obj3 = new Double(doubleValue * doubleValue2);
                                            break;
                                        case 105:
                                            obj3 = new Double(doubleValue / doubleValue2);
                                            break;
                                        default:
                                            switch (i) {
                                                case 111:
                                                    obj3 = new Double(doubleValue % doubleValue2);
                                                    break;
                                                case 112:
                                                case 113:
                                                case 114:
                                                case 115:
                                                case 116:
                                                case 117:
                                                    throw new UtilEvalError("Can't shift doubles");
                                                default:
                                                    throw new InterpreterError("Unimplemented binary double operator");
                                            }
                                    }
                            }
                    }
                } else {
                    throw new UtilEvalError("Invalid types in binary operator");
                }
                Class<?> cls3 = O0000o00;
                if (cls3 == null) {
                    cls3 = O000000o("bsh.Primitive");
                    O0000o00 = cls3;
                }
                if (cls == cls3) {
                    Class<?> cls4 = O0000o00;
                    if (cls4 == null) {
                        cls4 = O000000o("bsh.Primitive");
                        O0000o00 = cls4;
                    }
                }
                if (!(obj3 instanceof Boolean)) {
                    return obj3;
                }
                return new Primitive(obj3);
            } catch (ArithmeticException e) {
                throw new UtilTargetError("Arithemetic Exception in binary op", e);
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer("Type mismatch in operator.  ");
            stringBuffer.append(obj4.getClass());
            stringBuffer.append(" cannot be used with ");
            stringBuffer.append(obj5.getClass());
            throw new UtilEvalError(stringBuffer.toString());
        }
    }

    public static Primitive O000000o(Class cls) {
        if (cls == null || !cls.isPrimitive()) {
            return O00000Oo;
        }
        if (cls == Boolean.TYPE) {
            return new Primitive(false);
        }
        try {
            Primitive primitive = new Primitive(0);
            return O000000o(cls, primitive.O00000Oo(), primitive, false, 0);
        } catch (UtilEvalError unused) {
            throw new InterpreterError("bad cast");
        }
    }
}
