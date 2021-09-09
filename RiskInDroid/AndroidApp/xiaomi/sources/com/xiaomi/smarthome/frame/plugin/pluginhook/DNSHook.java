package com.xiaomi.smarthome.frame.plugin.pluginhook;

import _m_j.gfr;
import _m_j.gsy;
import _m_j.hte;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.plugin.pluginhook.config.DNSHookConfigManager;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;

public class DNSHook {
    private static boolean sHooked = false;

    public static void install(boolean z) {
        if (z) {
            hook();
        }
    }

    public static void hook() {
        if (!sHooked) {
            sHooked = true;
            try {
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Field field = cls.getField("os");
                Object obj = field.get(null);
                field.set(null, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{Class.forName("libcore.io.Os")}, new OsInvokeHandler(obj)));
                gsy.O00000o0(LogType.PLUGIN, "DNSHook", "DNSHook hook success.");
            } catch (Exception e) {
                e.printStackTrace();
                gsy.O00000o0(LogType.PLUGIN, "DNSHook", "DNSHook hook failed.");
            }
        }
    }

    static class OsInvokeHandler implements InvocationHandler {
        private Object mOrigin;

        OsInvokeHandler(Object obj) {
            this.mOrigin = obj;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ((method.getName().equals("android_getaddrinfo") || method.getName().equals("getaddrinfo")) && (objArr[0] instanceof String) && !DNSHookConfigManager.getInstance().isNumericHost((String) objArr[0])) {
                String str = (String) objArr[0];
                if (!DNSHookConfigManager.getInstance().isInWhiteList(str)) {
                    gsy.O00000o0(LogType.PLUGIN, "DNSHook", "block host:".concat(String.valueOf(str)));
                    if (gfr.O0000OOo || gfr.O0000Ooo || gfr.O0000Oo || gfr.O0000o00) {
                        gsy.O000000o(6, "DNSHook", "block host:".concat(String.valueOf(str)));
                        if (gfr.O0000Oo || gfr.O0000OOo) {
                            hte.O000000o(CommonApplication.getAppContext(), "block host:".concat(String.valueOf(str)), CommonApplication.getGlobalHandler());
                        }
                    }
                    logHostNotInWL(str);
                    return new InetAddress[]{InetAddress.getLoopbackAddress()};
                }
            }
            try {
                return method.invoke(this.mOrigin, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }

        private void logHostNotInWL(String str) {
            gsy.O00000o0(LogType.PLUGIN, "DNSHook", "block host: ".concat(String.valueOf(str)));
            if (gfr.O0000OOo) {
                gsy.O000000o(6, "DNSHook", "block host: ".concat(String.valueOf(str)));
                hte.O000000o(CommonApplication.getAppContext(), "Plugin:block host: ".concat(String.valueOf(str)), CommonApplication.getGlobalHandler());
            }
        }
    }
}
