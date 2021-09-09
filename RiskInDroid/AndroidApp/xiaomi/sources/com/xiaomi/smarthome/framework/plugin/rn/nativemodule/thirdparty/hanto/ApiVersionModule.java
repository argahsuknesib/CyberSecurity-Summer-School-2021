package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.ayt;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;

public class ApiVersionModule extends HTReactContextBaseJavaModule {
    public String getName() {
        return "HTRCTApiVersionModule";
    }

    public ApiVersionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getApiVersion(Callback callback) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap.putString("version", ayt.f12712O000000o);
        writableNativeMap2.putInt(RESULT_CODE, SUCCESS_CODE);
        writableNativeMap2.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(writableNativeMap2);
    }
}
