package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OAIDUtil {
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sIdProviderImpl = cls.newInstance();
            try {
                sGetOAID = cls.getMethod("getOAID", Context.class);
            } catch (NoSuchMethodException e) {
                Log.e("OAIDUtil", "getOAID not avaliable", e);
            }
        } catch (ClassNotFoundException e2) {
            Log.e("OAIDUtil", "provider not avaliable", e2);
        } catch (InstantiationException e3) {
            Log.e("OAIDUtil", "provider not avaliable", e3);
        } catch (IllegalAccessException e4) {
            Log.e("OAIDUtil", "provider not avaliable", e4);
        }
    }

    private OAIDUtil() {
    }

    public static String getOAID(Context context) {
        return getId(context, sGetOAID);
    }

    private static String getId(Context context, Method method) {
        Object obj = sIdProviderImpl;
        if (obj == null || method == null) {
            return null;
        }
        try {
            return (String) method.invoke(obj, context);
        } catch (IllegalAccessException e) {
            Log.e("OAIDUtil", "exception invoking".concat(String.valueOf(method)), e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e("OAIDUtil", "exception invoking".concat(String.valueOf(method)), e2);
            return null;
        }
    }
}
