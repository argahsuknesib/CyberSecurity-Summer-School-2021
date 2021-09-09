package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableMap;

public abstract class HTReactContextBaseJavaModule extends ReactContextBaseJavaModule {
    protected static String RESULT_CODE = "code";
    protected static String RESULT_DATA = "data";
    protected static String RESULT_MESSAGE = "message";
    protected static int SUCCESS_CODE;

    public HTReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public boolean isNoNull(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) && !readableMap.isNull(str);
    }

    /* access modifiers changed from: protected */
    public void showMessage(String str) {
        Toast.makeText(getCurrentActivity(), str, 0).show();
    }
}
