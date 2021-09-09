package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker;

import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ColorPickerLightModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "ColorPickerLight";
    }

    @ReactMethod
    public final void getDeviceName(Promise promise) {
        promise.resolve(Build.MODEL);
    }

    public ColorPickerLightModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
