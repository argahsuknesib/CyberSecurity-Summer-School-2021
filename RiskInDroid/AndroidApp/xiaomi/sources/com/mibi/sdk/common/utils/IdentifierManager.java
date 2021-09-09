package com.mibi.sdk.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.Method;

@SuppressLint({"PrivateApi"})
public class IdentifierManager {
    private static Class<?> sClass;
    private static Method sGetAAID;
    private static Method sGetOAID;
    private static Method sGetUDID;
    private static Method sGetVAID;
    private static Object sIdProivderImpl;

    public static boolean isSupported() {
        return (sClass == null || sIdProivderImpl == null) ? false : true;
    }

    public static String getUDID(Context context) {
        return invokeMethod(context, sGetUDID);
    }

    public static String getOAID(Context context) {
        return invokeMethod(context, sGetOAID);
    }

    public static String getVAID(Context context) {
        return invokeMethod(context, sGetVAID);
    }

    public static String getAAID(Context context) {
        return invokeMethod(context, sGetAAID);
    }

    private static String invokeMethod(Context context, Method method) {
        Object obj = sIdProivderImpl;
        if (obj == null || method == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return "";
        } catch (Exception e) {
            MibiLog.e("IdentifierManager", "invoke exception!", e);
            return "";
        }
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProivderImpl = cls.newInstance();
            sGetUDID = sClass.getMethod("getUDID", Context.class);
            sGetOAID = sClass.getMethod("getOAID", Context.class);
            sGetVAID = sClass.getMethod("getVAID", Context.class);
            sGetAAID = sClass.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            MibiLog.e("IdentifierManager", "reflect exception!", e);
        }
    }
}
