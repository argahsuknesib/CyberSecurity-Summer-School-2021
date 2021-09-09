package com.reactnativecommunity.netinfo;

import _m_j.ctu;
import _m_j.ctv;
import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "RNCNetInfo")
public class NetInfoModule extends ReactContextBaseJavaModule {
    private final ctu mConnectivityReceiver;

    public String getName() {
        return "RNCNetInfo";
    }

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mConnectivityReceiver = new ctv(reactApplicationContext);
        } else {
            this.mConnectivityReceiver = new BroadcastReceiverConnectivityReceiver(reactApplicationContext);
        }
    }

    public void initialize() {
        this.mConnectivityReceiver.register();
    }

    public void onCatalystInstanceDestroy() {
        this.mConnectivityReceiver.unregister();
    }

    @ReactMethod
    public void getCurrentState(Promise promise) {
        this.mConnectivityReceiver.getCurrentState(promise);
    }
}
