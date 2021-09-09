package com.xiaomi.mi_connect_service.util;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
    private ReflectUtil() {
    }

    public static class ReflAgent {
        private Class mClass;
        private Object mObject;
        private Object mResult;

        private ReflAgent() {
        }

        public static ReflAgent getClass(String str) {
            ReflAgent reflAgent = new ReflAgent();
            try {
                reflAgent.mClass = Class.forName(str);
            } catch (ClassNotFoundException e) {
                Log.e("ReflectUtil", "getClass error", e);
            }
            return reflAgent;
        }

        public static ReflAgent getObject(Object obj) {
            ReflAgent reflAgent = new ReflAgent();
            if (obj != null) {
                reflAgent.mObject = obj;
                reflAgent.mClass = obj.getClass();
            }
            return reflAgent;
        }

        public ReflAgent callMethod(String str, Class<?>[] clsArr, Object... objArr) {
            Object obj = this.mObject;
            if (obj != null) {
                try {
                    this.mResult = ReflectUtil.callObjectMethod(obj, str, clsArr, objArr);
                } catch (Exception e) {
                    Log.e("ReflectUtil", "callObjectMethod error", e);
                }
            }
            return this;
        }

        public ReflAgent callStaticMethod(String str, Class<?>[] clsArr, Object... objArr) {
            Class cls = this.mClass;
            if (cls != null) {
                try {
                    this.mResult = ReflectUtil.callStaticObjectMethod(cls, str, clsArr, objArr);
                } catch (Exception e) {
                    Log.e("ReflectUtil", "callStaticObjectMethod error", e);
                }
            }
            return this;
        }

        public ReflAgent getStaticFiled(String str) {
            Class cls = this.mClass;
            if (cls != null) {
                try {
                    this.mResult = ReflectUtil.getStaticObjectField(cls, str);
                } catch (Exception e) {
                    Log.e("ReflectUtil", "getStaticObjectField error", e);
                }
            }
            return this;
        }

        public ReflAgent getObjectFiled(String str) {
            Object obj = this.mObject;
            if (obj != null) {
                try {
                    this.mResult = ReflectUtil.getObjectField(obj, str);
                } catch (Exception e) {
                    Log.e("ReflectUtil", "getObjectFiled error", e);
                }
            }
            return this;
        }

        public ReflAgent setResultToSelf() {
            this.mObject = this.mResult;
            this.mResult = null;
            return this;
        }

        public String stringResult() {
            Object obj = this.mResult;
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }

        public boolean booleanResult() {
            Object obj = this.mResult;
            if (obj == null) {
                return false;
            }
            return Boolean.parseBoolean(obj.toString());
        }

        public int intResult() {
            Object obj = this.mResult;
            if (obj == null) {
                return 0;
            }
            try {
                return Integer.parseInt(obj.toString());
            } catch (NumberFormatException e) {
                Log.e("ReflectUtil", "intResult error", e);
                return 0;
            }
        }

        public long longResult() {
            Object obj = this.mResult;
            if (obj == null) {
                return 0;
            }
            try {
                return Long.parseLong(obj.toString());
            } catch (NumberFormatException e) {
                Log.e("ReflectUtil", "longResult error", e);
                return 0;
            }
        }

        public Object resultObject() {
            Object obj = this.mResult;
            if (obj == null) {
                return null;
            }
            return obj;
        }
    }

    public static Object callObjectMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        if (clsArr == null) {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        }
        Method declaredMethod2 = cls.getDeclaredMethod(str, clsArr);
        declaredMethod2.setAccessible(true);
        return declaredMethod2.invoke(obj, objArr);
    }

    public static Object callObjectMethod(Class cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Object callObjectMethod(Object obj, String str, Class<?> cls, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Object callObjectMethod(Object obj, String str) {
        try {
            return callObjectMethod(obj, str, null, null);
        } catch (Exception e) {
            Log.e("ReflectUtil", "callObjectMethod error", e);
            return null;
        }
    }

    public static Object callStaticObjectMethod(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(null, objArr);
    }

    public static Object getObjectField(Object obj, String str) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object getStaticObjectField(Class<?> cls, String str) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(str);
    }
}
