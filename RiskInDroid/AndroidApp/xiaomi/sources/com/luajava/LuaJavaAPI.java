package com.luajava;

import com.google.android.exoplayer2.C;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class LuaJavaAPI {
    static HashMap<String, Method[]> methodCache = new HashMap<>();
    static HashMap<String, Method[]> methodsMap = new HashMap<>();

    private LuaJavaAPI() {
    }

    public static int objectIndex(int i, Object obj, String str, int i2) throws LuaException {
        int checkField;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            if (i2 == 0) {
                try {
                    if (checkMethod(existingState, obj, str) != 0) {
                        return 2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if ((i2 == 0 || i2 == 1 || i2 == 5) && (checkField = checkField(existingState, obj, str)) != 0) {
                return checkField;
            }
            if ((i2 == 0 || i2 == 4) && javaGetter(existingState, obj, str) != 0) {
                return 4;
            }
            if ((i2 == 0 || i2 == 3) && checkClass(existingState, obj, str) != 0) {
                return 3;
            }
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2 = r12[r4];
     */
    public static int callMethod(int i, Object obj, String str) throws LuaException {
        boolean z;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            Method[] methodArr = methodCache.get(str);
            int top = existingState.getTop();
            Object[] objArr = new Object[top];
            Method method = null;
            int i2 = 0;
            while (true) {
                if (i2 >= methodArr.length) {
                    break;
                }
                Class<?>[] parameterTypes = methodArr[i2].getParameterTypes();
                if (parameterTypes.length == top) {
                    int i3 = 0;
                    while (i3 < parameterTypes.length) {
                        try {
                            int i4 = i3 + 1;
                            objArr[i3] = compareTypes(existingState, parameterTypes[i3], i4);
                            i3 = i4;
                        } catch (Exception unused) {
                            z = false;
                        }
                    }
                    z = true;
                    if (z) {
                        break;
                    }
                }
                i2++;
            }
            if (method == null) {
                StringBuilder sb = new StringBuilder();
                for (Method method2 : methodArr) {
                    sb.append(method2.toString());
                    sb.append("\n");
                }
                throw new LuaException("Invalid method call. Invalid Parameters.\n" + sb.toString());
            }
            try {
                if (!Modifier.isPublic(method.getModifiers())) {
                    method.setAccessible(true);
                }
                Object invoke = method.invoke(obj, objArr);
                if (invoke == null) {
                    if (method.getReturnType().equals(Void.TYPE)) {
                        return 0;
                    }
                }
                existingState.pushObjectValue(invoke);
                return 1;
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
    }

    public static int objectNewIndex(int i, Object obj, String str) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            if (setFieldValue(existingState, obj, str) != 0) {
                return 1;
            }
            if (javaSetter(existingState, obj, str) != 0) {
                return 1;
            }
            return 0;
        }
    }

    public static int setFieldValue(LuaState luaState, Object obj, String str) throws LuaException {
        boolean z;
        Class<?> cls;
        synchronized (luaState) {
            if (obj == null) {
                return 0;
            }
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            try {
                Field field = cls.getField(str);
                if (field == null) {
                    return 0;
                }
                if (z && !Modifier.isStatic(field.getModifiers())) {
                    return 0;
                }
                Class<?> type = field.getType();
                try {
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    field.set(obj, compareTypes(luaState, type, 3));
                } catch (LuaException unused) {
                    argError(luaState, str, 3, type);
                } catch (Exception e) {
                    throw new LuaException(e);
                }
            } catch (NoSuchFieldException unused2) {
                return 0;
            }
        }
        return 1;
    }

    private static String argError(LuaState luaState, String str, int i, Class cls) throws LuaException {
        throw new LuaException("bad argument to '" + str + "' (" + cls.getName() + " expected, got " + typeName(luaState, 3) + " value)");
    }

    private static String typeName(LuaState luaState, int i) throws LuaException {
        if (luaState.isObject(i)) {
            return luaState.getObjectFromUserdata(i).getClass().getName();
        }
        switch (luaState.type(i)) {
            case 1:
                return "boolean";
            case 2:
            case 7:
                return "userdata";
            case 3:
                return "number";
            case 4:
                return "string";
            case 5:
                return "table";
            case 6:
                return "function";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return "thread";
            default:
                return "unkown";
        }
    }

    public static int setArrayValue(int i, Object obj, int i2) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType != null) {
                try {
                    Array.set(obj, i2, compareTypes(existingState, componentType, 3));
                } catch (LuaException unused) {
                    argError(existingState, obj.getClass().getName() + " [" + i2 + "]", 3, componentType);
                } catch (Exception e) {
                    throw new LuaException("can not set array value: " + e.getMessage());
                }
            } else {
                throw new LuaException(obj.toString() + " is not a array");
            }
        }
        return 0;
    }

    public static int getArrayValue(int i, Object obj, int i2) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                existingState.pushObjectValue(Array.get(obj, i2));
            } catch (Exception e) {
                throw new LuaException("can not get array value: " + e.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int asTable(int i, Object obj) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                existingState.newTable();
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    int i2 = 0;
                    while (i2 <= length - 1) {
                        existingState.pushObjectValue(Array.get(obj, i2));
                        i2++;
                        existingState.rawSetI(-2, (long) i2);
                    }
                } else if (obj instanceof Collection) {
                    int i3 = 1;
                    for (Object pushObjectValue : (Collection) obj) {
                        existingState.pushObjectValue(pushObjectValue);
                        existingState.rawSetI(-2, (long) i3);
                        i3++;
                    }
                } else if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        existingState.pushObjectValue(entry.getKey());
                        existingState.pushObjectValue(entry.getValue());
                        existingState.setTable(-3);
                    }
                }
                existingState.pushValue(-1);
            } catch (Exception e) {
                throw new LuaException("can not astable: " + e.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int newArray(int i, Class<?> cls, int i2) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                existingState.pushJavaObject(Array.newInstance(cls, i2));
            } catch (Exception e) {
                throw new LuaException("can not create a array: " + e.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int newArray(int i, Class<?> cls) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                int top = existingState.getTop() - 1;
                int[] iArr = new int[top];
                for (int i2 = 0; i2 < top; i2++) {
                    iArr[i2] = (int) existingState.toInteger(i2 + 2);
                }
                existingState.pushJavaObject(Array.newInstance(cls, iArr));
            } catch (Exception e) {
                throw new LuaException("can not create a array: " + e.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static Class javaBindClass(String str) throws LuaException {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            if (str.equals("boolean")) {
                return Boolean.TYPE;
            }
            if (str.equals("byte")) {
                return Byte.TYPE;
            }
            if (str.equals("char")) {
                return Character.TYPE;
            }
            if (str.equals("short")) {
                return Short.TYPE;
            }
            if (str.equals("int")) {
                return Integer.TYPE;
            }
            if (str.equals("long")) {
                return Long.TYPE;
            }
            if (str.equals("float")) {
                return Float.TYPE;
            }
            if (str.equals("double")) {
                return Double.TYPE;
            }
            throw new LuaException("Class not found: ".concat(String.valueOf(str)));
        }
    }

    public static int javaNewInstance(int i, String str) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            Class javaBindClass = javaBindClass(str);
            if (javaBindClass.isPrimitive()) {
                int primitive = toPrimitive(existingState, javaBindClass, -1);
                return primitive;
            }
            int objInstance = getObjInstance(existingState, javaBindClass);
            return objInstance;
        }
    }

    public static int javaNew(int i, Class cls) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            if (cls.isPrimitive()) {
                int primitive = toPrimitive(existingState, cls, -1);
                return primitive;
            }
            int objInstance = getObjInstance(existingState, cls);
            return objInstance;
        }
    }

    public static int javaCreate(int i, Class cls) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            if (cls.isInterface()) {
                int createProxyObject = createProxyObject(existingState, cls);
                return createProxyObject;
            }
            if (cls.getSuperclass() != AbstractMap.class) {
                if (cls.getSuperclass() != HashMap.class) {
                    int createArray = createArray(existingState, cls);
                    return createArray;
                }
            }
            int createMap = createMap(existingState, cls);
            return createMap;
        }
    }

    public static int createProxy(int i, String str) throws LuaException {
        int createProxyObject;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            createProxyObject = createProxyObject(existingState, str);
        }
        return createProxyObject;
    }

    public static int createArray(int i, String str) throws LuaException {
        int createArray;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            createArray = createArray(existingState, javaBindClass(str));
        }
        return createArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        return 0;
     */
    public static int javaLoadLib(int i, String str, String str2) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                Object invoke = Class.forName(str).getMethod(str2, LuaState.class).invoke(null, existingState);
                if (invoke != null && (invoke instanceof Integer)) {
                    int intValue = ((Integer) invoke).intValue();
                    return intValue;
                }
            } catch (ClassNotFoundException e) {
                throw new LuaException(e);
            } catch (Exception e2) {
                throw new LuaException("Error on calling method. Library could not be loaded. " + e2.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int javaToString(int i, Object obj) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            if (obj == null) {
                existingState.pushString("null");
            } else {
                existingState.pushString(obj.toString());
            }
        }
        return 1;
    }

    public static int javaEquals(int i, Object obj, Object obj2) throws LuaException {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            existingState.pushBoolean(obj.equals(obj2));
        }
        return 1;
    }

    public static int javaObjectLength(int i, Object obj) throws LuaException {
        int i2;
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                if (obj instanceof CharSequence) {
                    i2 = ((CharSequence) obj).length();
                } else if (obj instanceof Collection) {
                    i2 = ((Collection) obj).size();
                } else if (obj instanceof Map) {
                    i2 = ((Map) obj).size();
                } else {
                    i2 = Array.getLength(obj);
                }
                existingState.pushInteger((long) i2);
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r11[r5];
     */
    private static int getObjInstance(LuaState luaState, Class cls) throws LuaException {
        boolean z;
        synchronized (luaState) {
            int top = luaState.getTop() - 1;
            Object[] objArr = new Object[top];
            Constructor<?>[] constructors = cls.getConstructors();
            Constructor<?> constructor = null;
            int i = 0;
            while (true) {
                if (i >= constructors.length) {
                    break;
                }
                Class<?>[] parameterTypes = constructors[i].getParameterTypes();
                if (parameterTypes.length == top) {
                    int i2 = 0;
                    while (i2 < parameterTypes.length) {
                        try {
                            objArr[i2] = compareTypes(luaState, parameterTypes[i2], i2 + 2);
                            i2++;
                        } catch (Exception unused) {
                            z = false;
                        }
                    }
                    z = true;
                    if (z) {
                        break;
                    }
                }
                i++;
            }
            if (constructor == null) {
                StringBuilder sb = new StringBuilder();
                for (Constructor<?> constructor2 : constructors) {
                    sb.append(constructor2.toString());
                    sb.append("\n");
                }
                throw new LuaException("Invalid constructor method call. Invalid Parameters.\n" + sb.toString());
            }
            try {
                Object newInstance = constructor.newInstance(objArr);
                if (newInstance != null) {
                    luaState.pushJavaObject(newInstance);
                } else {
                    throw new LuaException("Couldn't instantiate java Object");
                }
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return 1;
    }

    public static int checkField(LuaState luaState, Object obj, String str) throws LuaException {
        boolean z;
        Class<?> cls;
        synchronized (luaState) {
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            try {
                Field field = cls.getField(str);
                if (field == null) {
                    return 0;
                }
                if (z && !Modifier.isStatic(field.getModifiers())) {
                    return 0;
                }
                try {
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    luaState.pushObjectValue(field.get(obj));
                    if (Modifier.isFinal(field.getModifiers())) {
                        return 5;
                    }
                    return 1;
                } catch (Exception e) {
                    throw new LuaException(e);
                }
            } catch (NoSuchFieldException unused) {
                return 0;
            }
        }
    }

    public static int checkMethod(LuaState luaState, Object obj, String str) throws LuaException {
        Class<?> cls;
        boolean z;
        synchronized (luaState) {
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            String name = cls.getName();
            String luaState2 = luaState.toString(-1);
            Method[] methodArr = methodCache.get(luaState2);
            if (methodArr == null) {
                Method[] methodArr2 = methodsMap.get(name);
                if (methodArr2 == null) {
                    methodArr2 = cls.getMethods();
                    methodsMap.put(name, methodArr2);
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < methodArr2.length; i++) {
                    if (methodArr2[i].getName().equals(str) && (!z || Modifier.isStatic(methodArr2[i].getModifiers()))) {
                        arrayList.add(methodArr2[i]);
                    }
                }
                if (arrayList.isEmpty() && z) {
                    Method[] methods = cls.getClass().getMethods();
                    for (int i2 = 0; i2 < methods.length; i2++) {
                        if (methods[i2].getName().equals(str)) {
                            arrayList.add(methods[i2]);
                        }
                    }
                }
                methodArr = new Method[arrayList.size()];
                arrayList.toArray(methodArr);
                methodCache.put(luaState2, methodArr);
            }
            if (methodArr.length == 0) {
                return 0;
            }
            return 2;
        }
    }

    public static int checkClass(LuaState luaState, Object obj, String str) throws LuaException {
        synchronized (luaState) {
            if (!(obj instanceof Class)) {
                return 0;
            }
            Class<?>[] classes = ((Class) obj).getClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getSimpleName().equals(str)) {
                    luaState.pushJavaObject(classes[i]);
                    return 3;
                }
            }
            return 0;
        }
    }

    public static int javaGetter(LuaState luaState, Object obj, String str) throws LuaException {
        boolean z;
        Class<?> cls;
        synchronized (luaState) {
            if (obj instanceof Map) {
                luaState.pushObjectValue(((Map) obj).get(str));
                return 1;
            }
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            try {
                Method method = cls.getMethod("get".concat(String.valueOf(str)), new Class[0]);
                if (z) {
                    if (!Modifier.isStatic(method.getModifiers())) {
                        return 0;
                    }
                }
                try {
                    luaState.pushObjectValue(method.invoke(obj, new Object[0]));
                    return 1;
                } catch (Exception e) {
                    throw new LuaException(e);
                }
            } catch (NoSuchMethodException unused) {
                return 0;
            }
        }
    }

    public static int javaSetter(LuaState luaState, Object obj, String str) throws LuaException {
        Class<?> cls;
        synchronized (luaState) {
            boolean z = true;
            if (obj instanceof Map) {
                ((Map) obj).put(str, luaState.toJavaObject(2));
                return 1;
            }
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
                z = false;
            }
            String name = cls.getName();
            Method[] methodArr = methodsMap.get(name);
            if (methodArr == null) {
                methodArr = cls.getMethods();
                methodsMap.put(name, methodArr);
            }
            if (str.length() <= 2 || !str.substring(0, 2).equals("on") || luaState.type(-1) != 6) {
                int javaSetMethod = javaSetMethod(luaState, obj, str, methodArr, z);
                return javaSetMethod;
            }
            int javaSetListener = javaSetListener(luaState, obj, str, methodArr, z);
            return javaSetListener;
        }
    }

    private static int javaSetListener(LuaState luaState, Object obj, String str, Method[] methodArr, boolean z) throws LuaException {
        synchronized (luaState) {
            String str2 = "setOn" + str.substring(2) + "Listener";
            for (Method method : methodArr) {
                if (method.getName().equals(str2) && (!z || Modifier.isStatic(method.getModifiers()))) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].isInterface()) {
                        luaState.newTable();
                        luaState.pushValue(-2);
                        luaState.setField(-2, str);
                        try {
                            method.invoke(obj, luaState.getLuaObject(-1).createProxy(parameterTypes[0]));
                            return 1;
                        } catch (Exception e) {
                            throw new LuaException(e);
                        }
                    }
                }
            }
            return 0;
        }
    }

    private static int javaSetMethod(LuaState luaState, Object obj, String str, Method[] methodArr, boolean z) throws LuaException {
        synchronized (luaState) {
            String concat = "set".concat(String.valueOf(str));
            StringBuilder sb = new StringBuilder();
            for (Method method : methodArr) {
                if (method.getName().equals(concat) && (!z || Modifier.isStatic(method.getModifiers()))) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        try {
                            try {
                                method.invoke(obj, compareTypes(luaState, parameterTypes[0], -1));
                                return 1;
                            } catch (Exception e) {
                                throw new LuaException(e);
                            }
                        } catch (LuaException unused) {
                            sb.append(parameterTypes[0]);
                            sb.append("\n");
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (sb.length() <= 0) {
                return 0;
            }
            throw new LuaException("Invalid setter " + str + ". Invalid Parameters.\n" + sb.toString() + luaState.typeName(-1));
        }
    }

    private static int createProxyObject(LuaState luaState, String str) throws LuaException {
        synchronized (luaState) {
            try {
                luaState.pushJavaObject(luaState.getLuaObject(2).createProxy(str));
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    private static int createProxyObject(LuaState luaState, Class cls) throws LuaException {
        synchronized (luaState) {
            luaState.pushJavaObject(createProxyObject(luaState, cls, 2));
        }
        return 1;
    }

    private static Object createProxyObject(LuaState luaState, Class cls, int i) throws LuaException {
        Object createProxy;
        synchronized (luaState) {
            try {
                createProxy = luaState.getLuaObject(i).createProxy(cls);
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return createProxy;
    }

    private static int createArray(LuaState luaState, Class cls) throws LuaException {
        synchronized (luaState) {
            luaState.pushJavaObject(createArray(luaState, cls, 2));
        }
        return 1;
    }

    private static Object createArray(LuaState luaState, Class cls, int i) throws LuaException {
        Object newInstance;
        synchronized (luaState) {
            try {
                int objLen = luaState.objLen(i);
                newInstance = Array.newInstance(cls, objLen);
                if (cls == String.class) {
                    for (int i2 = 1; i2 <= objLen; i2++) {
                        luaState.pushNumber((double) i2);
                        luaState.getTable(i);
                        Array.set(newInstance, i2 - 1, luaState.toString(-1));
                        luaState.pop(1);
                    }
                } else if (cls == Double.TYPE) {
                    for (int i3 = 1; i3 <= objLen; i3++) {
                        luaState.pushNumber((double) i3);
                        luaState.getTable(i);
                        Array.set(newInstance, i3 - 1, Double.valueOf(luaState.toNumber(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Float.TYPE) {
                    for (int i4 = 1; i4 <= objLen; i4++) {
                        luaState.pushNumber((double) i4);
                        luaState.getTable(i);
                        Array.set(newInstance, i4 - 1, Float.valueOf((float) luaState.toNumber(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Long.TYPE) {
                    for (int i5 = 1; i5 <= objLen; i5++) {
                        luaState.pushNumber((double) i5);
                        luaState.getTable(i);
                        Array.set(newInstance, i5 - 1, Long.valueOf(luaState.toInteger(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Integer.TYPE) {
                    for (int i6 = 1; i6 <= objLen; i6++) {
                        luaState.pushNumber((double) i6);
                        luaState.getTable(i);
                        Array.set(newInstance, i6 - 1, Integer.valueOf((int) luaState.toInteger(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Short.TYPE) {
                    for (int i7 = 1; i7 <= objLen; i7++) {
                        luaState.pushNumber((double) i7);
                        luaState.getTable(i);
                        Array.set(newInstance, i7 - 1, Short.valueOf((short) ((int) luaState.toInteger(-1))));
                        luaState.pop(1);
                    }
                } else if (cls == Character.TYPE) {
                    for (int i8 = 1; i8 <= objLen; i8++) {
                        luaState.pushNumber((double) i8);
                        luaState.getTable(i);
                        Array.set(newInstance, i8 - 1, Character.valueOf((char) ((int) luaState.toInteger(-1))));
                        luaState.pop(1);
                    }
                } else if (cls == Byte.TYPE) {
                    for (int i9 = 1; i9 <= objLen; i9++) {
                        luaState.pushNumber((double) i9);
                        luaState.getTable(i);
                        Array.set(newInstance, i9 - 1, Byte.valueOf((byte) ((int) luaState.toInteger(-1))));
                        luaState.pop(1);
                    }
                } else {
                    for (int i10 = 1; i10 <= objLen; i10++) {
                        luaState.pushNumber((double) i10);
                        luaState.getTable(i);
                        Array.set(newInstance, i10 - 1, compareTypes(luaState, cls, -1));
                        luaState.pop(1);
                    }
                }
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return newInstance;
    }

    private static int createMap(LuaState luaState, Class cls) throws LuaException {
        synchronized (luaState) {
            luaState.pushJavaObject(createMap(luaState, cls, 2));
        }
        return 1;
    }

    private static Object createMap(LuaState luaState, Class cls, int i) throws LuaException {
        Map map;
        synchronized (luaState) {
            try {
                map = (Map) cls.newInstance();
                luaState.pushNil();
                while (luaState.next(i) != 0) {
                    map.put(luaState.toJavaObject(-2), luaState.toJavaObject(-1));
                    luaState.pop(1);
                }
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00da, code lost:
        if (r1 == null) goto L_0x00b1;
     */
    private static Object compareTypes(LuaState luaState, Class cls, int i) throws LuaException {
        Number number;
        int type = luaState.type(i);
        Object obj = null;
        boolean z = true;
        if (type != 0) {
            if (type != 1) {
                if (type == 3) {
                    if (luaState.isInteger(i)) {
                        number = LuaState.convertLuaNumber(new Long(luaState.toInteger(i)), cls);
                    } else {
                        number = LuaState.convertLuaNumber(new Double(luaState.toNumber(i)), cls);
                    }
                    obj = number;
                } else if (type != 4) {
                    if (type != 5) {
                        if (type != 6) {
                            if (type != 7) {
                                throw new LuaException("Invalid Parameters.");
                            } else if (luaState.isObject(i)) {
                                Object objectFromUserdata = luaState.getObjectFromUserdata(i);
                                if ((cls.isPrimitive() && Number.class.isAssignableFrom(objectFromUserdata.getClass())) || cls.isAssignableFrom(objectFromUserdata.getClass())) {
                                    obj = objectFromUserdata;
                                }
                            } else if (cls.isAssignableFrom(LuaObject.class)) {
                                obj = luaState.getLuaObject(i);
                            }
                        } else if (cls.isAssignableFrom(LuaObject.class)) {
                            obj = luaState.getLuaObject(i);
                        }
                    } else if (cls.isAssignableFrom(LuaObject.class)) {
                        obj = luaState.getLuaObject(i);
                    } else if (cls.isArray()) {
                        obj = createArray(luaState, cls.getComponentType(), i);
                    } else if (cls.isInterface()) {
                        obj = createProxyObject(luaState, cls, i);
                    } else if (cls.getSuperclass() == AbstractMap.class || cls.getSuperclass() == HashMap.class) {
                        obj = createMap(luaState, cls, i);
                    }
                } else if (cls.isAssignableFrom(String.class)) {
                    obj = luaState.toString(i);
                }
                z = false;
            } else {
                obj = cls.isPrimitive() ? Boolean.valueOf(luaState.toBoolean(i)) : Boolean.valueOf(luaState.toBoolean(i));
                z = false;
            }
        }
        if (z) {
            return obj;
        }
        throw new LuaException("Invalid Parameter.");
    }

    private static int toPrimitive(LuaState luaState, Class cls, int i) throws LuaException {
        Object obj;
        if (cls == Character.TYPE && luaState.isString(i)) {
            String luaState2 = luaState.toString(i);
            if (luaState2.length() == 1) {
                obj = Character.valueOf(luaState2.charAt(0));
            } else {
                obj = luaState2.toCharArray();
            }
        } else if (!luaState.isNumber(i)) {
            throw new LuaException(luaState.toString(i) + " is not number");
        } else if (cls == Double.TYPE) {
            obj = Double.valueOf(luaState.toNumber(i));
        } else if (cls == Float.TYPE) {
            obj = Float.valueOf((float) luaState.toNumber(i));
        } else if (cls == Long.TYPE) {
            obj = Long.valueOf(luaState.toInteger(i));
        } else if (cls == Integer.TYPE) {
            obj = Integer.valueOf((int) luaState.toInteger(i));
        } else if (cls == Short.TYPE) {
            obj = Short.valueOf((short) ((int) luaState.toInteger(i)));
        } else if (cls == Character.TYPE) {
            obj = Character.valueOf((char) ((int) luaState.toInteger(i)));
        } else if (cls == Byte.TYPE) {
            obj = Byte.valueOf((byte) ((int) luaState.toInteger(i)));
        } else {
            obj = cls == Boolean.TYPE ? Boolean.valueOf(luaState.toBoolean(i)) : null;
        }
        luaState.pushJavaObject(obj);
        return 1;
    }
}
