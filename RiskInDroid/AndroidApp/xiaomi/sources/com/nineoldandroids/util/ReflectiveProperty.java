package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(1:22)(2:23|24)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|5|7|8|9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|11|(4:13|14|15|28)(2:17|18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r9.mGetter = r10.getDeclaredMethod(r6, null);
        r9.mGetter.setAccessible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r9.mField = r10.getField(r12);
        r10 = r9.mField.getType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b1, code lost:
        if (typesMatch(r11, r10) != false) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ce, code lost:
        throw new com.nineoldandroids.util.NoSuchPropertyException("Underlying type (" + r10 + ") does not match Property type (" + r11 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00de, code lost:
        throw new com.nineoldandroids.util.NoSuchPropertyException("No accessor method or field found for property with name ".concat(java.lang.String.valueOf(r12)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0044, code lost:
        r6 = "is".concat(java.lang.String.valueOf(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r9.mGetter = r10.getMethod(r6, null);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0055 */
    public ReflectiveProperty(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String concat = "get".concat(String.valueOf(str2));
        this.mGetter = cls.getMethod(concat, null);
        this.mGetter = cls.getDeclaredMethod(concat, null);
        this.mGetter.setAccessible(true);
        Class<?> returnType = this.mGetter.getReturnType();
        if (typesMatch(cls2, returnType)) {
            try {
                this.mSetter = cls.getDeclaredMethod("set".concat(String.valueOf(str2)), returnType);
                this.mSetter.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
        } else {
            throw new NoSuchPropertyException("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        if (cls2 != cls) {
            return cls2.isPrimitive() && ((cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))))));
        }
        return true;
    }

    public void set(T t, V v) {
        Method method = this.mSetter;
        if (method != null) {
            try {
                method.invoke(t, v);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else {
            Field field = this.mField;
            if (field != null) {
                try {
                    field.set(t, v);
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else {
                throw new UnsupportedOperationException("Property " + getName() + " is read-only");
            }
        }
    }

    public V get(T t) {
        Method method = this.mGetter;
        if (method != null) {
            try {
                return method.invoke(t, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else {
            Field field = this.mField;
            if (field != null) {
                try {
                    return field.get(t);
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }
}
