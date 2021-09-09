package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.gdt;
import _m_j.gdv;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.device.api.spec.operation.controller.DeviceController;
import java.util.HashMap;

public class MIOTSpecModule extends MIOTBaseJavaModule {
    private HashMap<String, DeviceController> mCacheController = new HashMap<>();

    public String getName() {
        return "MIOTSpec";
    }

    public MIOTSpecModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getSpecString(String str, Callback callback) {
        try {
            callback.invoke(Boolean.TRUE, ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(str));
        } catch (RemoteException e) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(e));
        }
    }

    @ReactMethod
    public void getProperty(String str, int i, int i2, Callback callback) {
        try {
            Object propertyValue = getSpecDeviceController(str).getPropertyValue(i, i2);
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.TRUE;
            objArr[1] = propertyValue == null ? "" : propertyValue.toString();
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public void setProperty(String str, int i, int i2, int i3, String str2) {
        PropertyParam newPropertyParam = getSpecDeviceController(str).newPropertyParam(i, i2);
        newPropertyParam.setResultCode(i3);
        newPropertyParam.setValue(str2);
        getSpecDeviceController(str).getPropertyController(i, i2).updateValue(newPropertyParam, false);
    }

    @ReactMethod
    public void getCurrentSpecValueWithDid(String str, Promise promise) {
        try {
            promise.resolve(((gdt) gdv.f17570O000000o.getServiceInterface()).O00000Oo(str));
        } catch (RemoteException e) {
            promise.reject(e);
        }
    }

    private DeviceController getSpecDeviceController(String str) {
        DeviceController deviceController = this.mCacheController.get(str);
        if (deviceController != null) {
            return deviceController;
        }
        DeviceController specDeviceController = XmPluginHostApi.instance().getSpecDeviceController(str);
        this.mCacheController.put(str, specDeviceController);
        return specDeviceController;
    }
}
