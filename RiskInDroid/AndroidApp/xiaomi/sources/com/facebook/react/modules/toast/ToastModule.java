package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "ToastAndroid")
public class ToastModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "ToastAndroid";
    }

    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap newHashMap = MapBuilder.newHashMap();
        newHashMap.put("SHORT", 0);
        newHashMap.put("LONG", 1);
        newHashMap.put("TOP", 49);
        newHashMap.put("BOTTOM", 81);
        newHashMap.put("CENTER", 17);
        return newHashMap;
    }

    @ReactMethod
    public void show(final String str, final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.modules.toast.ToastModule.AnonymousClass1 */

            public void run() {
                Toast.makeText(ToastModule.this.getReactApplicationContext(), str, i).show();
            }
        });
    }

    @ReactMethod
    public void showWithGravity(final String str, final int i, final int i2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.modules.toast.ToastModule.AnonymousClass2 */

            public void run() {
                Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), str, i);
                makeText.setGravity(i2, 0, 0);
                makeText.show();
            }
        });
    }

    @ReactMethod
    public void showWithGravityAndOffset(String str, int i, int i2, int i3, int i4) {
        final String str2 = str;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.modules.toast.ToastModule.AnonymousClass3 */

            public void run() {
                Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), str2, i5);
                makeText.setGravity(i6, i7, i8);
                makeText.show();
            }
        });
    }
}
