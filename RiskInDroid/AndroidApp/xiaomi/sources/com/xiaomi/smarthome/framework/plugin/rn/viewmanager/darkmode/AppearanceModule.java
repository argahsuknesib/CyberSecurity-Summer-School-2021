package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.darkmode;

import _m_j.gbu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

@ReactModule(name = "Appearance")
public class AppearanceModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static volatile String sColorScheme = "light";
    private static volatile boolean sRegistered = false;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.darkmode.AppearanceModule.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppearanceModule.this.notifyForChange();
        }
    };
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return "Appearance";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    @ReactMethod
    public void removeListeners(double d) {
    }

    public AppearanceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        sColorScheme = colorSchemeForCurrentConfiguration(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
        if (!sRegistered) {
            sRegistered = true;
            reactApplicationContext.registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public static String colorSchemeForCurrentConfiguration(Context context) {
        int i = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        if (i == 16 || i != 32 || !XmPluginHostApi.instance().isRNPluginDarkMode()) {
            return "light";
        }
        return "dark";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getColorScheme() {
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(getReactApplicationContext());
        sColorScheme = colorSchemeForCurrentConfiguration;
        return colorSchemeForCurrentConfiguration;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void disableActivityDarkMode() {
        StringBuilder sb = new StringBuilder("disableActivityDarkMode: ");
        sb.append(getCurrentActivity() != null ? getCurrentActivity().getLocalClassName() : "null");
        gbu.O000000o(sb.toString());
    }

    public void onConfigurationChanged(Context context) {
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(context);
        if (!sColorScheme.equals(colorSchemeForCurrentConfiguration)) {
            sColorScheme = colorSchemeForCurrentConfiguration;
            emitAppearanceChanged(sColorScheme);
        }
    }

    public void notifyForChange() {
        if (this.reactContext.hasActiveCatalystInstance()) {
            String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(this.reactContext);
            if (!sColorScheme.equals(colorSchemeForCurrentConfiguration)) {
                sColorScheme = colorSchemeForCurrentConfiguration;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("colorScheme", sColorScheme);
                ReactApplicationContext reactApplicationContext = this.reactContext;
                if (reactApplicationContext != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("appearanceChanged", createMap);
                }
            }
        }
    }

    public void emitAppearanceChanged(String str) {
        ReactApplicationContext reactApplicationContext;
        WritableMap createMap = Arguments.createMap();
        createMap.putString("colorScheme", str);
        if (this.reactContext.hasActiveCatalystInstance() && (reactApplicationContext = this.reactContext) != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("appearanceChanged", createMap);
        }
    }

    public void onHostDestroy() {
        if (this.reactContext != null && sRegistered) {
            try {
                this.reactContext.unregisterReceiver(this.mReceiver);
                sRegistered = false;
            } catch (Exception unused) {
            }
        }
    }
}
