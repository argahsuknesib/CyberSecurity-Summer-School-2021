package com.mibi.sdk.payment;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

class AccountManager {
    AccountManager() {
    }

    static void initAccount(Context context) {
        tryInjectAccount(context);
    }

    private static void tryInjectAccount(Context context) {
        try {
            Class.forName("com.mibi.sdk.account.AccountInjector").getMethod("inject", Context.class).invoke(null, context);
            Log.d("AccountManager", "tryInjectAccount success");
        } catch (ClassNotFoundException unused) {
            Log.e("AccountManager", "AccountInjector is not founded.Use no account");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    static void tryClearAccount() {
        try {
            Class.forName("com.mibi.sdk.account.AccountInjector").getMethod("release", new Class[0]).invoke(null, new Object[0]);
            Log.d("AccountManager", "tryInjectAccount success");
        } catch (ClassNotFoundException unused) {
            Log.e("AccountManager", "AccountInjector is not founded.Use no account");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    static boolean isLogined(Context context) {
        Boolean bool;
        Boolean bool2 = Boolean.FALSE;
        try {
            bool = (Boolean) Class.forName("com.mibi.sdk.account.AccountInjector").getMethod("isLogined", Context.class).invoke(null, context);
            try {
                Log.d("AccountManager", "isLogin:".concat(String.valueOf(bool)));
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e) {
                e = e;
                e.printStackTrace();
                return bool.booleanValue();
            } catch (NoSuchMethodException e2) {
                e = e2;
                e.printStackTrace();
                return bool.booleanValue();
            } catch (InvocationTargetException e3) {
                e = e3;
                e.printStackTrace();
                return bool.booleanValue();
            }
        } catch (ClassNotFoundException unused2) {
            bool = bool2;
            Log.e("AccountManager", "AccountInjector is not founded.Use no account");
            return bool.booleanValue();
        } catch (IllegalAccessException e4) {
            e = e4;
            bool = bool2;
            e.printStackTrace();
            return bool.booleanValue();
        } catch (NoSuchMethodException e5) {
            e = e5;
            bool = bool2;
            e.printStackTrace();
            return bool.booleanValue();
        } catch (InvocationTargetException e6) {
            e = e6;
            bool = bool2;
            e.printStackTrace();
            return bool.booleanValue();
        }
        return bool.booleanValue();
    }
}
