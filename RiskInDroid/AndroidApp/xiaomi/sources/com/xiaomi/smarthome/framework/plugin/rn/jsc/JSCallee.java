package com.xiaomi.smarthome.framework.plugin.rn.jsc;

import _m_j.fxv;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class JSCallee extends BaseJavaModule {
    private AtomicLong callId = new AtomicLong(1000);
    private Map<String, fxv> callbackMap = new ConcurrentHashMap();

    public String getName() {
        return "JSCallee";
    }

    public String add(fxv fxv) {
        String str = "_" + this.callId.incrementAndGet();
        this.callbackMap.put(str, fxv);
        return str;
    }

    public boolean checkInvokedAndRemove(String str) {
        return this.callbackMap.remove(str) == null;
    }

    @ReactMethod
    public void receiveResult(String str, String str2, String str3) {
        fxv remove = this.callbackMap.remove(str);
        if (remove == null) {
            return;
        }
        if (str2 == null || str2.length() <= 0) {
            remove.O000000o(str3);
        } else {
            remove.O00000Oo(str2);
        }
    }
}
