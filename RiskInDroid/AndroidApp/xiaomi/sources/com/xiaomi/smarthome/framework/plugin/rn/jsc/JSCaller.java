package com.xiaomi.smarthome.framework.plugin.rn.jsc;

import com.facebook.react.bridge.JavaScriptModule;

public interface JSCaller extends JavaScriptModule {
    void invoke(String str, String str2, String str3);
}
