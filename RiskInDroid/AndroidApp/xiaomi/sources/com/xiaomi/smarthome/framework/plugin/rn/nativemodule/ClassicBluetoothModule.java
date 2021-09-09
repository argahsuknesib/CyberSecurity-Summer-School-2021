package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.ft;
import _m_j.fwz;
import _m_j.fyf;
import _m_j.gbu;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback;
import com.xiaomi.smarthome.frame.core.CoreApi;

public class ClassicBluetoothModule extends MIOTBaseJavaModule {
    private Context mContext;
    private IClassicBtRequest mRequest = null;

    public String getName() {
        return "ClassicBluetooth";
    }

    public ClassicBluetoothModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
    }

    /* access modifiers changed from: package-private */
    public boolean checkInit() {
        if (this.mRequest == null) {
            this.mRequest = CoreApi.O000000o().O000O0oo();
            try {
                CoreApi.O000000o().O00000Oo().addClassicBtResponse(new ClassicBtResponseImpl(this.mContext));
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (CoreApi.CoreNotReadyException e2) {
                e2.printStackTrace();
            }
        }
        return this.mRequest != null;
    }

    @ReactMethod
    public void create(Callback callback) {
        if (checkInit()) {
            try {
                this.mRequest.createClassicBTService();
                callbackString(callback, true, "create success...");
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "create func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void connectSocket(String str, String str2, Callback callback) {
        if (checkInit()) {
            try {
                boolean connectClassicBTSocket = this.mRequest.connectClassicBTSocket(str, str2);
                callbackString(callback, connectClassicBTSocket, "connect socket is ".concat(String.valueOf(connectClassicBTSocket)));
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "connectSocket func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void disconnectSocket(Callback callback) {
        if (checkInit()) {
            try {
                this.mRequest.disconnectClassicBtSocket();
                callbackString(callback, true, "disconnect socket...");
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "disconnectSocket func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void write(String str, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, "data is null");
        } else if (checkInit()) {
            try {
                boolean write = this.mRequest.write(fyf.O000000o(str));
                callbackString(callback, write, "write is ".concat(String.valueOf(write)));
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "write func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void prepareBluetoothProfile(int i, final Callback callback) {
        if (checkInit()) {
            try {
                this.mRequest.prepareBluetoothProfile(i, new IProfileProxyPrepareCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.ClassicBluetoothModule.AnonymousClass1 */

                    public void onServiceConnected(int i) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, Integer.valueOf(i));
                        }
                    }

                    public void onServiceDisconnected(int i) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.invoke(Boolean.FALSE, Integer.valueOf(i));
                        }
                    }
                });
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "prepareBluetoothProfile func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void connectBluetoothProfile(String str, int i, Callback callback) {
        if (checkInit()) {
            try {
                boolean connectBluetoothProfile = this.mRequest.connectBluetoothProfile(str, i);
                callbackString(callback, connectBluetoothProfile, "connect bluetooth profile is ".concat(String.valueOf(connectBluetoothProfile)));
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "connectBluetoothProfile func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void disconnectBluetoothProfile(String str, int i, Callback callback) {
        if (checkInit()) {
            try {
                boolean disconnectBluetoothProfile = this.mRequest.disconnectBluetoothProfile(str, i);
                callbackString(callback, disconnectBluetoothProfile, "disconnect bluetooth profile is ".concat(String.valueOf(disconnectBluetoothProfile)));
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "disconnectBluetoothProfile func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void getBluetoothProfileState(String str, int i, Callback callback) {
        if (checkInit()) {
            try {
                int bluetoothProfileState = this.mRequest.getBluetoothProfileState(str, i);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("state", bluetoothProfileState);
                callbackMap(callback, true, createMap);
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "getBluetoothProfileState func exec, request init error, request is null...");
        }
    }

    @ReactMethod
    public void destroy(Callback callback) {
        if (checkInit()) {
            try {
                this.mRequest.destroy();
                callbackString(callback, true, "destroy...");
            } catch (RemoteException e) {
                callbackString(callback, false, e.toString());
            }
        } else {
            callbackString(callback, false, "destroy func exec, request init error, request is null...");
        }
    }

    private void callbackString(Callback callback, boolean z, String str) {
        if (callback != null) {
            callback.invoke(Boolean.valueOf(z), str);
        }
    }

    private void callbackMap(Callback callback, boolean z, WritableMap writableMap) {
        if (callback != null) {
            callback.invoke(Boolean.valueOf(z), writableMap);
        }
    }

    static class ClassicBtResponseImpl extends IClassicBtResponse.Stub {
        private Context mContext;

        ClassicBtResponseImpl(Context context) {
            this.mContext = context;
        }

        public void onBondStateChange(String str, int i) throws RemoteException {
            gbu.O000000o("exec onBondStateChange...");
            WritableMap createMap = Arguments.createMap();
            createMap.putString("macAddress", str);
            createMap.putInt("state", i);
            sendEventToJs("classicBlueBondStateChanged_36621", createMap);
        }

        public void onConnectionStateChanged(String str, int i) throws RemoteException {
            gbu.O000000o("exec onConnectionStateChanged...");
            WritableMap createMap = Arguments.createMap();
            createMap.putString("macAddress", str);
            createMap.putInt("state", i);
            sendEventToJs("classicBlueConnectionStateChanged_36621", createMap);
        }

        public void onReceiveData(String str, byte[] bArr) throws RemoteException {
            gbu.O000000o("exec onReceiveData...");
            if (bArr == null || bArr.length == 0) {
                gbu.O000000o("ClassicBluetoothModule onReceiveData,  data is empty...");
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("macAddress", str);
            createMap.putString("data", fyf.O000000o(bArr));
            sendEventToJs("classicBlueReceivedData_36621", createMap);
        }

        private void sendLocalBroadcast(Bundle bundle) {
            Intent intent = new Intent("miot.classic.bluetooth.action.method_notify");
            intent.putExtras(bundle);
            ft.O000000o(this.mContext).O000000o(intent);
        }

        private void sendEventToJs(String str, WritableMap writableMap) {
            ReactContext currentReactContext;
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("ReactInstanceManager is null, can not send event, eventName: ".concat(String.valueOf(str)));
            } else if (fwz.O000000o().O00000Oo().O00000o0()) {
                if (writableMap == null) {
                    writableMap = Arguments.createMap();
                }
                gbu.O000000o("will send event, eventName: ".concat(String.valueOf(str)));
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
            } else {
                gbu.O00000Oo("can not send event, eventName: ".concat(String.valueOf(str)));
            }
        }
    }
}
