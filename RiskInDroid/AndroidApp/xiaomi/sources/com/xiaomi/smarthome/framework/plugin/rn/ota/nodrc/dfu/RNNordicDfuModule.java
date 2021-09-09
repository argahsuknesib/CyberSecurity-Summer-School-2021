package com.xiaomi.smarthome.framework.plugin.rn.ota.nodrc.dfu;

import _m_j.gbq;
import _m_j.gbu;
import _m_j.gbv;
import _m_j.gsy;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import java.util.List;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

public class RNNordicDfuModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String name = "RNNordicDfu";
    private final String dfuStateEvent = "DFUStateChanged";
    private final DfuProgressListener mDfuProgressListener = new DfuProgressListenerAdapter() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.ota.nodrc.dfu.RNNordicDfuModule.AnonymousClass1 */

        public final void onDeviceConnecting(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onDeviceConnecting, onEnablingDfuMode: ".concat(String.valueOf(str)));
            RNNordicDfuModule.this.sendStateUpdate("CONNECTING", str);
        }

        public final void onDfuProcessStarting(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onDfuProcessStarting, onEnablingDfuMode: ".concat(String.valueOf(str)));
            RNNordicDfuModule.this.sendStateUpdate("DFU_PROCESS_STARTING", str);
        }

        public final void onEnablingDfuMode(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onEnablingDfuMode, deviceAddress: ".concat(String.valueOf(str)));
            RNNordicDfuModule.this.sendStateUpdate("ENABLING_DFU_MODE", str);
        }

        public final void onFirmwareValidating(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onFirmwareValidating, deviceAddress: ".concat(String.valueOf(str)));
            RNNordicDfuModule.this.sendStateUpdate("FIRMWARE_VALIDATING", str);
        }

        public final void onDeviceDisconnecting(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onDeviceDisconnecting, deviceAddress: ".concat(String.valueOf(str)));
            RNNordicDfuModule.this.sendStateUpdate("DEVICE_DISCONNECTING", str);
        }

        public final void onDfuCompleted(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onDfuCompleted, deviceAddress: ".concat(String.valueOf(str)));
            if (RNNordicDfuModule.this.mPromise != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("deviceAddress", str);
                RNNordicDfuModule.this.mPromise.resolve(writableNativeMap);
                RNNordicDfuModule.this.mPromise = null;
            }
            RNNordicDfuModule.this.sendStateUpdate("DFU_COMPLETED", str);
            new Handler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.ota.nodrc.dfu.RNNordicDfuModule.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    ((NotificationManager) RNNordicDfuModule.this.reactContext.getSystemService("notification")).cancel(283);
                }
            }, 200);
        }

        public final void onDfuAborted(String str) {
            gbu.O00000Oo("rn-nodrc-dfu onDfuAborted, deviceAddress: ".concat(String.valueOf(str)));
            RNNordicDfuModule.this.sendStateUpdate("DFU_ABORTED", str);
            if (RNNordicDfuModule.this.mPromise != null) {
                RNNordicDfuModule.this.mPromise.reject("2", "DFU ABORTED");
                RNNordicDfuModule.this.mPromise = null;
            }
        }

        public final void onProgressChanged(String str, int i, float f, float f2, int i2, int i3) {
            gbu.O00000Oo("rn-nodrc-dfu onProgressChanged, percent: ".concat(String.valueOf(i)));
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("deviceAddress", str);
            writableNativeMap.putInt("percent", i);
            writableNativeMap.putDouble("speed", (double) f);
            writableNativeMap.putDouble("avgSpeed", (double) f2);
            writableNativeMap.putInt("currentPart", i2);
            writableNativeMap.putInt("partsTotal", i3);
            RNNordicDfuModule.this.sendEvent("DFUProgress", writableNativeMap);
        }

        public final void onError(String str, int i, int i2, String str2) {
            gbu.O00000Oo("rn-nodrc-dfu onError, deviceAddress: " + str + "  error： " + i + "  errorType：" + i2 + "  message：" + str2);
            RNNordicDfuModule.this.sendStateUpdate("DFU_FAILED", str);
            if (RNNordicDfuModule.this.mPromise != null) {
                RNNordicDfuModule.this.mPromise.reject(Integer.toString(i), str2);
                RNNordicDfuModule.this.mPromise = null;
            }
        }
    };
    private boolean mDisableNotification = false;
    private boolean mInit = false;
    public Promise mPromise = null;
    private final String progressEvent = "DFUProgress";
    public final ReactApplicationContext reactContext;

    public String getName() {
        return name;
    }

    public void onHostPause() {
    }

    public RNNordicDfuModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
        this.reactContext = reactApplicationContext;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    @ReactMethod
    public void initDFU(ReadableMap readableMap, Promise promise) {
        if (!this.mInit) {
            if (readableMap != null) {
                boolean O00000o0 = gbv.O00000o0(readableMap, "notificationEnabled");
                gbu.O000000o("rn-nodrc-dfu, notificationEnabled: ".concat(String.valueOf(O00000o0)));
                initNotification(O00000o0);
            }
            this.mInit = true;
        }
        if (promise != null) {
            promise.resolve(gbq.O000000o(0, (Object) "init success"));
        }
    }

    private void initNotification(boolean z) {
        if (Build.VERSION.SDK_INT >= 26 && z) {
            DfuServiceInitiator.createDfuNotificationChannel(this.reactContext);
        }
        this.mDisableNotification = !z;
    }

    @ReactMethod
    public void startDFU(String str, String str2, String str3, Promise promise) {
        this.mPromise = promise;
        if (!this.mInit) {
            initNotification(true);
            this.mInit = true;
        }
        DfuServiceInitiator keepBond = new DfuServiceInitiator(str).setKeepBond(false);
        if (str2 != null) {
            keepBond.setDeviceName(str2);
        }
        keepBond.setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
        keepBond.setZip(str3);
        if (this.mDisableNotification) {
            keepBond.setDisableNotification(true);
            keepBond.setForeground(false);
        }
        Class dfuServiceClass = getDfuServiceClass(getCurrentActivity());
        if (dfuServiceClass != null) {
            gbu.O000000o("rn-nodrc-dfu, will start a service, " + dfuServiceClass.getName());
            keepBond.start(this.reactContext, dfuServiceClass);
            return;
        }
        gbu.O00000Oo("rn-nodrc-dfu, service is null...");
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ((RCTNativeAppEventEmitter) getReactApplicationContext().getJSModule(RCTNativeAppEventEmitter.class)).emit(str, writableMap);
    }

    public void sendStateUpdate(String str, String str2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        gsy.O000000o(3, name, "State: ".concat(String.valueOf(str)));
        writableNativeMap.putString("state", str);
        writableNativeMap.putString("deviceAddress", str2);
        sendEvent("DFUStateChanged", writableNativeMap);
    }

    public void onHostResume() {
        DfuServiceListenerHelper.registerProgressListener(this.reactContext, this.mDfuProgressListener);
    }

    public void onHostDestroy() {
        DfuServiceListenerHelper.unregisterProgressListener(this.reactContext, this.mDfuProgressListener);
    }

    private Class getDfuServiceClass(Context context) {
        String str;
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        int size = runningAppProcesses.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
                break;
            }
            i++;
        }
        gbu.O000000o("rn-nodrc-dfu, processName: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith(":plugin0")) {
            return DfuService.class;
        }
        if (str.endsWith(":plugin1")) {
            return DfuService1.class;
        }
        if (str.endsWith(":plugin2")) {
            return DfuService2.class;
        }
        if (str.endsWith(":plugin3")) {
            return DfuService3.class;
        }
        return null;
    }
}
