package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.exp;
import _m_j.foc;
import _m_j.fpo;
import _m_j.fpp;
import _m_j.fsp;
import _m_j.ft;
import _m_j.fte;
import _m_j.fwz;
import _m_j.fyf;
import _m_j.gbq;
import _m_j.gbu;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.glb;
import _m_j.glc;
import _m_j.gle;
import _m_j.gnk;
import _m_j.got;
import _m_j.gsy;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MIOTBluetoothModule extends MIOTBaseJavaModule {
    private boolean connect;
    public Callback mCallback;
    private Handler mHandler;
    public volatile boolean mIsTimeOut = false;
    private Map<String, UUID> mUUIDCacheMap = new HashMap();

    public String getName() {
        return "MIOTBluetooth";
    }

    public MIOTBluetoothModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void initHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.what == 1001 && MIOTBluetoothModule.this.mCallback != null) {
                        MIOTBluetoothModule mIOTBluetoothModule = MIOTBluetoothModule.this;
                        mIOTBluetoothModule.mIsTimeOut = true;
                        mIOTBluetoothModule.mCallback.invoke(Boolean.FALSE, "timeout...");
                        MIOTBluetoothModule.this.mCallback = null;
                    }
                }
            };
        }
    }

    public void clearHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1001);
        }
        this.mHandler = null;
        this.mCallback = null;
    }

    public boolean isConnect() {
        return this.connect;
    }

    @ReactMethod
    public void connect(final String str, final int i, ReadableMap readableMap, final Callback callback) {
        connectDevice(str, i, readableMap, new Callback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass13 */

            public final void invoke(Object... objArr) {
                int i;
                if (callback != null) {
                    String O00000o02 = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o0(str);
                    if (((Boolean) objArr[0]).booleanValue()) {
                        hxi.O0000Oo.O000000o(O00000o02, "login", str);
                    } else {
                        try {
                            WritableMap writableMap = (WritableMap) objArr[1];
                            if (!(writableMap == null || (i = writableMap.getInt("code")) == -2)) {
                                hxi.O0000Oo.O000000o(O00000o02, "login", i, "", String.valueOf(i), str);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    callback.invoke(objArr);
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    public void connectDevice(String str, int i, ReadableMap readableMap, Callback callback) {
        final String str2 = str;
        ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        PluginDeviceInfo pluginInfo = getPluginInfo();
        if (pluginInfo == null) {
            callback2.invoke(Boolean.FALSE, "no pluginRecord");
            return;
        }
        int i2 = i;
        int i3 = i2 == -1 ? (pluginInfo == null || pluginInfo.O000O00o() != 1) ? 0 : ((getDevice().permitLevel & 30) & 16) != 0 ? 1 : 2 : i2;
        double O000000o2 = fyf.O000000o(readableMap2, "timeout", 35000.0d);
        int O000000o3 = fyf.O000000o(readableMap2, "discoverRetry", 2);
        double max = (double) Math.max(O000000o3, 1);
        Double.isNaN(max);
        double O000000o4 = fyf.O000000o(readableMap2, "discoverTimeout", O000000o2 / max);
        int O000000o5 = fyf.O000000o(readableMap2, "connectRetry", 1);
        boolean O000000o6 = fyf.O000000o(readableMap2, "checkFirmwareVersion");
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = O000000o5;
        o000000o.O00000o0 = (int) O000000o2;
        o000000o.O00000Oo = O000000o3;
        o000000o.O00000o = (int) O000000o4;
        BleConnectOptions O000000o7 = o000000o.O000000o();
        String O00000o0 = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o0(str2);
        if (i3 == 0) {
            final String str3 = str;
            final ReadableMap readableMap3 = readableMap;
            final Callback callback3 = callback;
            final int i4 = i;
            final boolean z = O000000o6;
            final int i5 = i3;
            fpp.O000000o(O00000o0, str2, O000000o7, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass24 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Bundle bundle = (Bundle) obj;
                    gnk.O000000o("connect  " + i + "  " + bundle);
                    if (-10 == i) {
                        XmBluetoothManager.getInstance().removeToken(str3);
                        MIOTBluetoothModule.this.connect(str3, 0, readableMap3, callback3);
                    } else if (i4 != -1) {
                        MIOTBluetoothModule.this.callbackBundle(i, bundle, callback3);
                        if (i == 0 && z) {
                            MIOTBluetoothModule.checkFirmwareVersion(i5, str3);
                        }
                    } else if (i == 0) {
                        MIOTBluetoothModule.this.callbackBundle(i, bundle, callback3);
                        if (i == 0 && z) {
                            MIOTBluetoothModule.checkFirmwareVersion(i5, str3);
                        }
                    } else {
                        MIOTBluetoothModule.this.connect(str3, 3, readableMap3, callback3);
                    }
                }
            });
        } else if (i3 == 1) {
            final Callback callback4 = callback;
            final boolean z2 = O000000o6;
            final int i6 = i3;
            final String str4 = str;
            fpp.O000000o(fwz.O000000o().O00000Oo().O0000o00, getCurrentActivity(), O00000o0, str, O000000o7, new gle() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass30 */

                public final void O000000o(int i, Bundle bundle) {
                }

                public final void O00000Oo(int i, Bundle bundle) {
                }

                public final void O00000o0(int i, Bundle bundle) {
                }

                public final void O00000o(int i, Bundle bundle) {
                    gnk.O000000o("connect  " + i + "  " + bundle);
                    MIOTBluetoothModule.this.callbackBundle(i, bundle, callback4);
                    if (i == 0 && z2) {
                        MIOTBluetoothModule.checkFirmwareVersion(i6, str4);
                    }
                }
            });
        } else if (i3 == 2) {
            fpp.O000000o(O00000o0, str2, O000000o7, new gle() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass31 */

                public final void O000000o(int i, Bundle bundle) {
                }

                public final void O00000Oo(int i, Bundle bundle) {
                }

                public final void O00000o0(int i, Bundle bundle) {
                }

                public final void O00000o(int i, Bundle bundle) {
                    if (i == 0) {
                        Intent intent = new Intent("action.online.status.changed");
                        intent.putExtra("extra_mac", str2);
                        intent.putExtra("extra_online_status", 80);
                        glc.O0000O0o.sendBroadcast(intent);
                    }
                    gnk.O000000o("connect  " + i + "  " + bundle);
                    MIOTBluetoothModule.this.callbackBundle(i, bundle, callback2);
                }
            });
        } else if (i3 == 3) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key.options", O000000o7);
            CoreApi.O000000o().O000000o(str2, 1, bundle, new BluetoothResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass6 */

                public void onResponse(int i, Bundle bundle) throws RemoteException {
                    gnk.O000000o("connect  " + i + "  " + bundle);
                    MIOTBluetoothModule.this.callbackBundle(i, bundle, callback2);
                }
            });
        } else if (i3 == 4) {
            final Callback callback5 = callback;
            final boolean z3 = O000000o6;
            final int i7 = i3;
            final String str5 = str;
            fpp.O00000Oo(O00000o0, str2, O000000o7, new gle() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass32 */

                public final void O000000o(int i, Bundle bundle) {
                }

                public final void O00000Oo(int i, Bundle bundle) {
                }

                public final void O00000o0(int i, Bundle bundle) {
                }

                public final void O00000o(int i, Bundle bundle) {
                    MIOTBluetoothModule.this.callbackBundle(i, bundle, callback5);
                    if (i == 0 && z3) {
                        MIOTBluetoothModule.checkFirmwareVersion(i7, str5);
                    }
                }
            });
        } else if (i3 == 5) {
            String O000000o8 = fyf.O000000o(readableMap2, "did", "");
            fte.O00000Oo("ble mesh did =".concat(String.valueOf(O000000o8)));
            fpp.O000000o(O00000o0, str2, O000000o8, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass33 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    MIOTBluetoothModule.this.callbackBundle(i, (Bundle) obj, callback2);
                }
            });
        }
    }

    @ReactMethod
    public void getVersion(final String str, boolean z, final Callback callback) {
        if (getPluginInfo() == null) {
            callback.invoke(Boolean.FALSE, "no device pluginRecord ");
            return;
        }
        XmBluetoothManager.getInstance().read(str, glb.f17954O000000o, glb.O00000oO, new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass34 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                final byte[] bArr = (byte[]) obj;
                if (i != 0 || got.O00000o(bArr)) {
                    MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
                } else {
                    XmBluetoothManager.getInstance().isBleCharacterExist(str, glb.f17954O000000o, glb.O00000o0, new Response.BleResponse<Void>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass34.AnonymousClass1 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            byte[] bArr = bArr;
                            if (i == 0) {
                                gbu.O000000o("miio-bluetooth getVersion RC4 需要解密...");
                                bArr = BLECipher.O000000o(foc.O0000OoO(str), bArr);
                            } else {
                                gbu.O000000o("miio-bluetooth getVersion 非RC4 不需要解密...");
                            }
                            byte[] O0000OOo = got.O0000OOo(bArr);
                            callback.invoke(Boolean.TRUE, new String(O0000OOo));
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void callbackBundle(int i, Bundle bundle, Callback callback) {
        UUID uuid;
        UUID uuid2;
        if (callback != null) {
            WritableMap createMap = Arguments.createMap();
            if (bundle != null) {
                for (String next : bundle.keySet()) {
                    Object obj = bundle.get(next);
                    if (obj == null) {
                        createMap.putNull(next);
                    } else if (obj instanceof byte[]) {
                        createMap.putString(next, fyf.O000000o((byte[]) obj));
                    } else if (obj.getClass().isArray()) {
                        try {
                            createMap.putArray(next, Arguments.fromArray(obj));
                        } catch (Throwable unused) {
                        }
                    } else if (obj instanceof String) {
                        createMap.putString(next, (String) obj);
                    } else if (obj instanceof Number) {
                        if (obj instanceof Integer) {
                            createMap.putInt(next, ((Integer) obj).intValue());
                        } else {
                            createMap.putDouble(next, ((Number) obj).doubleValue());
                        }
                    } else if (obj instanceof Boolean) {
                        createMap.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof List) {
                        createMap.putArray(next, Arguments.fromList((List) obj));
                    } else if (obj instanceof BleGattProfile) {
                        WritableArray createArray = Arguments.createArray();
                        for (BleGattService next2 : ((BleGattProfile) obj).O000000o()) {
                            if (!(next2 == null || (uuid = next2.f9075O000000o) == null)) {
                                WritableMap createMap2 = Arguments.createMap();
                                String lowerCase = uuid.toString().toLowerCase();
                                this.mUUIDCacheMap.put(lowerCase, uuid);
                                createMap2.putString("uuid", lowerCase);
                                List<ParcelUuid> O000000o2 = next2.O000000o();
                                if (O000000o2 != null) {
                                    WritableArray createArray2 = Arguments.createArray();
                                    for (ParcelUuid next3 : O000000o2) {
                                        if (!(next3 == null || (uuid2 = next3.getUuid()) == null)) {
                                            String lowerCase2 = uuid2.toString().toLowerCase();
                                            this.mUUIDCacheMap.put(lowerCase2, uuid2);
                                            createArray2.pushString(lowerCase2);
                                        }
                                    }
                                    createMap2.putArray("chars", createArray2);
                                    createArray.pushMap(createMap2);
                                }
                            }
                        }
                        createMap.putArray("services", createArray);
                    }
                }
            }
            createMap.putInt("code", i);
            if (i != -55) {
                switch (i) {
                    case -35:
                        createMap.putString("msg", "REQUEST_SC_REGISTER_PAIR_CODE_EXPIRED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -34:
                        createMap.putString("msg", "REQUEST_SC_REGISTER_PAIR_CODE_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -33:
                        createMap.putString("msg", "REQUEST_SC_REGISTER_INPUT_PAIR_CODE");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -32:
                        createMap.putString("msg", "REQUEST_STATUS_DISCONNECTED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -31:
                        createMap.putString("msg", "REQUEST_TOKEN_VERIFY_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -30:
                        createMap.putString("msg", "REQUEST_BIND_DID_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -29:
                        createMap.putString("msg", "REQUEST_GET_DID_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -28:
                        createMap.putString("msg", "REQUEST_WRITE_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -27:
                        createMap.putString("msg", "REQUEST_NOTIFY_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -26:
                        createMap.putString("msg", "REQUEST_SC_BIND_LTMK_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -25:
                        createMap.putString("msg", "REQUEST_SC_SHARED_LOGIN_KEY_ID_EMPTY");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -24:
                        createMap.putString("msg", "REQUEST_SC_SHARED_LOGIN_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -23:
                        createMap.putString("msg", "REQUEST_SC_SHARED_LOGIN_ENCRYPT_DATA_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -22:
                        createMap.putString("msg", "REQUEST_SC_LOGIN_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -21:
                        createMap.putString("msg", "REQUEST_SC_LOGIN_ENCRYPT_DATA_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -20:
                        createMap.putString("msg", "REQUEST_SC_REGISTER_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -19:
                        createMap.putString("msg", "REQUEST_SC_SHARED_KEY_FAILED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -18:
                        createMap.putString("msg", "REQUEST_SHARED_KEY_EXPIRED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -17:
                        createMap.putString("msg", "REQUEST_REGISTERED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -16:
                        createMap.putString("msg", "REQUEST_NOT_REGISTERED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -15:
                        createMap.putString("msg", "REQUEST_EXCEPTION");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -14:
                        createMap.putString("msg", "REQUEST_DENIED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -13:
                        createMap.putString("msg", "REQUEST_ONGOING");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -12:
                        createMap.putString("msg", "CONFIG_UNREADY");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -11:
                        createMap.putString("msg", "REQUEST_OVERFLOW");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    case -10:
                        createMap.putString("msg", "TOKEN_NOT_MATCHED");
                        callback.invoke(Boolean.FALSE, createMap);
                        return;
                    default:
                        switch (i) {
                            case -7:
                                break;
                            case -6:
                                createMap.putString("msg", "CONNECTION_NOT_READY");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                            case -5:
                                createMap.putString("msg", "BLUETOOTH_DISABLED");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                            case -4:
                                createMap.putString("msg", "BLE_NOT_SUPPORTED");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                            case -3:
                                createMap.putString("msg", "ILLEGAL_ARGUMENT");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                            case -2:
                                createMap.putString("msg", "REQUEST_CANCELED");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                            case -1:
                                createMap.putString("msg", "REQUEST_FAILED");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                            case 0:
                                callback.invoke(Boolean.TRUE, createMap);
                                this.connect = true;
                                return;
                            default:
                                createMap.putString("msg", "unknow");
                                callback.invoke(Boolean.FALSE, createMap);
                                return;
                        }
                }
            }
            createMap.putString("msg", "REQUEST_TIMEDOUT");
            callback.invoke(Boolean.FALSE, createMap);
        }
    }

    @ReactMethod
    public void discoverServices(String str, ReadableArray readableArray) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && readableArray != null) {
            String[] strArr = new String[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                strArr[i] = readableArray.getString(i);
            }
            ft.O000000o(reactApplicationContext).O000000o(new Intent().setAction("discoverservices_callback").putExtra("emit_mac", str).putExtra("emit_uuid", strArr));
        }
    }

    @ReactMethod
    public void discoverCharacteristics(String str, ReadableArray readableArray, String str2) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && readableArray != null) {
            String[] strArr = new String[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                strArr[i] = readableArray.getString(i);
            }
            ft.O000000o(reactApplicationContext).O000000o(new Intent().setAction("discovercharacteristics_callback").putExtra("emit_mac", str).putExtra("emit_serviceid", str2).putExtra("emit_uuid", strArr));
        }
    }

    @ReactMethod
    public void bindDevice(String str) {
        XmBluetoothManager.getInstance().bindDevice(str);
    }

    @ReactMethod
    public void unBindDevice(String str) {
        XmBluetoothManager.getInstance().unBindDevice(str);
    }

    @ReactMethod
    public void call(String str, int i, ReadableMap readableMap, final Callback callback) {
        XmBluetoothManager.getInstance().call(str, i, Arguments.toBundle(readableMap), new Response.BleCallResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (i == 0) {
                    callback.invoke(Boolean.TRUE, Arguments.createMap());
                    return;
                }
                MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
            }
        });
    }

    @ReactMethod
    public void doSpecOperation(String str, int i, String str2, final Callback callback) {
        gbu.O00000o0("doSpecOperation opcode =" + i + ",json params =" + str2);
        XmPluginHostApi.instance().bleSpecOperation(str, i, str2, new com.xiaomi.smarthome.device.api.Callback<Bundle>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                Bundle bundle = (Bundle) obj;
                if (bundle == null) {
                    callback.invoke(Boolean.TRUE, Arguments.createMap());
                    return;
                }
                String string = bundle.getString("key_spec_json_resp");
                callback.invoke(Boolean.TRUE, string);
            }

            public final void onFailure(int i, String str) {
                if (callback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("code", i);
                    createMap.putString("message", str);
                    callback.invoke(Boolean.FALSE, createMap);
                }
            }
        });
    }

    @ReactMethod
    public void oneTimePassword(String str, int i, int i2, final Callback callback) {
        XmBluetoothManager.getInstance().getOneTimePassword(str, i, i2, new Response.BleResponseV2<int[]>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass4 */

            /* JADX INFO: additional move instructions added (1) to help type inference */
            public final /* synthetic */ void onResponse(int i, String str, Object obj) {
                int[] iArr = (int[]) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (i == 0) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.TRUE;
                    Object obj2 = str;
                    if (iArr != null) {
                        obj2 = Arguments.fromArray(iArr);
                    }
                    objArr[1] = obj2;
                    callback.invoke(objArr);
                    return;
                }
                MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
            }
        });
    }

    @ReactMethod
    public void getTokenMd5(String str, Callback callback) {
        callback.invoke(XmBluetoothManager.getInstance().getTokenMd5(str));
    }

    @ReactMethod
    public void removeToken(String str) {
        XmBluetoothManager.getInstance().removeToken(str);
    }

    @ReactMethod
    public void isAutoReconnect(String str, Callback callback) {
        callback.invoke(Boolean.valueOf(XmBluetoothManager.getInstance().isAutoReconnect(str)));
    }

    @ReactMethod
    public void isBluetoothOpen(Callback callback) {
        callback.invoke(Boolean.valueOf(XmBluetoothManager.getInstance().isBluetoothOpen()));
    }

    @ReactMethod
    public void openBluetooth(boolean z) {
        if (z) {
            XmBluetoothManager.getInstance().openBluetoothSilently();
        } else {
            XmBluetoothManager.getInstance().openBluetooth(getCurrentActivity());
        }
    }

    @ReactMethod
    public void isShareSecureKeyValid(String str, Callback callback) {
        try {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(XmBluetoothManager.getInstance().isSecurityChipSharedKeyValid(str) ? 1 : 0);
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(0, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public void isBleGatewayConnected(String str, final Callback callback) {
        XmBluetoothManager.getInstance().isBleGatewayConnected(str, new Response.BleResponse<Void>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass5 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Integer.valueOf(i));
                }
            }
        });
    }

    @ReactMethod
    public void isBleOrMeshGatewayConnected(final String str, boolean z, final Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "mac is null or empty."));
            return;
        }
        List<DeviceStat> bleGatewayDeviceList = XmPluginHostApi.instance().getBleGatewayDeviceList();
        ArrayList arrayList = new ArrayList();
        if (bleGatewayDeviceList != null && bleGatewayDeviceList.size() > 0) {
            for (DeviceStat next : bleGatewayDeviceList) {
                if (next != null && !TextUtils.isEmpty(next.did)) {
                    arrayList.add(next.did);
                }
            }
        }
        if (arrayList.size() == 0) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "cann't find any gateway device."));
            return;
        }
        XmPluginHostApi.instance().getBleGatewaySubDevices(arrayList, new com.xiaomi.smarthome.device.api.Callback<List<DeviceStat>>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List<DeviceStat> list = (List) obj;
                if (list == null || list.size() == 0) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("connected", false);
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                    return;
                }
                for (DeviceStat deviceStat : list) {
                    if (deviceStat != null && str.equalsIgnoreCase(deviceStat.mac)) {
                        WritableMap createMap2 = Arguments.createMap();
                        createMap2.putBoolean("connected", true);
                        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(deviceStat.parentId);
                        if (deviceByDid != null) {
                            createMap2.putString("mac", deviceByDid.mac);
                        }
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap2));
                        return;
                    }
                }
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putBoolean("connected", false);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap3));
            }

            public final void onFailure(int i, String str) {
                String format = String.format("internal error,code:%d,info:%s", Integer.valueOf(i), str);
                callback.invoke(Boolean.FALSE, gbq.O000000o(-3, format));
            }
        });
    }

    @ReactMethod
    public void readHexStringWithCallback(String str, String str2, String str3, final Callback callback) {
        XmBluetoothManager.getInstance().read(str, getUUid(str3), getUUid(str2), new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass8 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (i == 0) {
                    callback.invoke(Boolean.TRUE, fyf.O000000o(bArr));
                    return;
                }
                MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
            }
        });
    }

    @ReactMethod
    public void readRSSI(String str, final Callback callback) {
        XmBluetoothManager.getInstance().readRemoteRssi(str, new Response.BleReadRssiResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass9 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Integer num = (Integer) obj;
                Callback callback = callback;
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(i == 0);
                objArr[1] = num;
                callback.invoke(objArr);
            }
        });
    }

    @ReactMethod
    public void writeHexStringWithCallback(String str, String str2, String str3, String str4, int i, Callback callback) {
        String str5 = str3;
        String str6 = str4;
        final Callback callback2 = callback;
        if (i == 1) {
            XmBluetoothManager.getInstance().writeNoRsp(str, getUUid(str6), getUUid(str5), fyf.O000000o(str2), new Response.BleWriteResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass10 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Callback callback = callback2;
                    if (callback != null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(i == 0);
                        objArr[1] = XmBluetoothManager.Code.toString(i);
                        callback.invoke(objArr);
                    }
                }
            });
            return;
        }
        XmBluetoothManager.getInstance().write(str, getUUid(str6), getUUid(str5), fyf.O000000o(str2), new Response.BleWriteResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass11 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Callback callback = callback2;
                if (callback != null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(i == 0);
                    objArr[1] = XmBluetoothManager.Code.toString(i);
                    callback.invoke(objArr);
                }
            }
        });
    }

    @ReactMethod
    public void writeBlock(String str, String str2, final Callback callback) {
        XmBluetoothManager.getInstance().writeBlock(str, fyf.O000000o(str2), new Response.BleWriteResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass12 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Integer.valueOf(i));
                }
            }
        });
    }

    @ReactMethod
    public void setNotifyWithCallback(String str, boolean z, String str2, String str3, final Callback callback) {
        gnk.O00000o0("miot-->setNotify...mac is " + str + "  flag is " + z + " serviceId is " + str3 + "  characterId is " + str2);
        if (z) {
            XmBluetoothManager.getInstance().notify(str, getUUid(str3), getUUid(str2), new Response.BleNotifyResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass14 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Callback callback = callback;
                    if (callback != null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(i == 0);
                        objArr[1] = XmBluetoothManager.Code.toString(i);
                        callback.invoke(objArr);
                    }
                }
            });
            return;
        }
        XmBluetoothManager.getInstance().unnotify(str, getUUid(str3), getUUid(str2));
        callback.invoke(Boolean.TRUE, 0);
    }

    @ReactMethod
    public void setIndicationWithCallback(String str, boolean z, String str2, String str3, final Callback callback) {
        if (z) {
            XmBluetoothManager.getInstance().indication(str, getUUid(str3), getUUid(str2), new Response.BleNotifyResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass15 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Callback callback = callback;
                    if (callback != null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(i == 0);
                        objArr[1] = XmBluetoothManager.Code.toString(i);
                        callback.invoke(objArr);
                    }
                }
            });
            return;
        }
        XmBluetoothManager.getInstance().unindication(str, getUUid(str3), getUUid(str2));
        callback.invoke(Boolean.TRUE, 0);
    }

    @ReactMethod
    public void registerBlockListener(String str, final Callback callback) {
        XmBluetoothManager.getInstance().registerBlockListener(str, new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass16 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (i == 0) {
                    callback.invoke(Boolean.TRUE, fyf.O000000o(bArr));
                    return;
                }
                MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
            }
        });
    }

    @ReactMethod
    public void unregisterBlockListener(String str) {
        XmBluetoothManager.getInstance().unregisterBlockListener(str);
    }

    @ReactMethod
    public void unregisterCharacterChanged(String str, String str2, String str3) {
        XmBluetoothManager.getInstance().unregisterCharacterChanged(str, getUUid(str2), getUUid(str3));
    }

    @ReactMethod
    public void registerCharacterChanged(String str, String str2, String str3, final Callback callback) {
        XmBluetoothManager.getInstance().registerCharacterChanged(str, getUUid(str2), getUUid(str3), new Response.BleWriteResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass17 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Integer.valueOf(i));
                }
            }
        });
    }

    @ReactMethod
    public void registerMediaButtonReceiver(String str) {
        XmBluetoothManager.getInstance().registerMediaButtonReceiver(str);
    }

    @ReactMethod
    public void unRegisterMediaButtonReceiver(String str) {
        XmBluetoothManager.getInstance().unRegisterMediaButtonReceiver(str);
    }

    @ReactMethod
    public void decryptMessageXiaoMiBLE(String str, String str2, final Callback callback) {
        XmBluetoothManager.getInstance().securityChipDecrypt(str, fyf.O000000o(str2), new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass18 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (i == 0) {
                    callback.invoke(Boolean.TRUE, fyf.O000000o(bArr));
                    return;
                }
                MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
            }
        });
    }

    @ReactMethod
    public void encryptMessageXiaoMiBLE(String str, String str2, final Callback callback) {
        XmBluetoothManager.getInstance().securityChipEncrypt(str, fyf.O000000o(str2), new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass19 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (i == 0) {
                    callback.invoke(Boolean.TRUE, fyf.O000000o(bArr));
                    return;
                }
                MIOTBluetoothModule.this.callbackBundle(i, new Bundle(), callback);
            }
        });
    }

    @ReactMethod
    public void toggleLockXiaoMiBLE(String str, int i, int i2, final Callback callback) {
        initHandler();
        final long currentTimeMillis = System.currentTimeMillis();
        this.mIsTimeOut = false;
        Handler handler = this.mHandler;
        if (handler != null && i2 > 0) {
            this.mCallback = callback;
            handler.sendEmptyMessageDelayed(1001, (long) i2);
        }
        XmBluetoothManager.getInstance().securityChipOperate(str, i, new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass20 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                gbu.O000000o("toggle cost time:  " + (System.currentTimeMillis() - currentTimeMillis));
                MIOTBluetoothModule.this.clearHandler();
                if (MIOTBluetoothModule.this.mIsTimeOut) {
                    gbu.O00000Oo("toggle is timeout...");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putByteArray("result", bArr);
                MIOTBluetoothModule.this.callbackBundle(i, bundle, callback);
            }
        });
    }

    @ReactMethod
    public void setAlertConfigs(String str, int i, boolean z, Callback callback) {
        boolean alertConfigs = XmBluetoothManager.getInstance().setAlertConfigs(str, i, z);
        if (callback != null) {
            callback.invoke(Boolean.valueOf(alertConfigs));
        }
    }

    @ReactMethod
    public void setAutoReconnect(String str, boolean z, Callback callback) {
        boolean autoReconnect = XmBluetoothManager.getInstance().setAutoReconnect(str, z);
        if (callback != null) {
            callback.invoke(Boolean.valueOf(autoReconnect));
        }
    }

    @Deprecated
    @ReactMethod
    public void startScan(int i, int i2) {
        XmBluetoothManager.getInstance().startScan(i, i2, new XmBluetoothManager.BluetoothSearchResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass21 */

            public final void onSearchCanceled() {
            }

            public final void onSearchStarted() {
            }

            public final void onSearchStopped() {
            }

            public final void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice) {
                ReactApplicationContext reactApplicationContext = MIOTBluetoothModule.this.getReactApplicationContext();
                if (reactApplicationContext != null && xmBluetoothDevice != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", xmBluetoothDevice.name);
                    bundle.putInt("deviceType", xmBluetoothDevice.deviceType);
                    bundle.putInt("rssi", xmBluetoothDevice.rssi);
                    bundle.putString("scanRecord", fyf.O000000o(xmBluetoothDevice.scanRecord));
                    bundle.putBoolean("isConnected", xmBluetoothDevice.isConnected);
                    String address = xmBluetoothDevice.getAddress();
                    bundle.putString("address", address);
                    bundle.putString("mac", address);
                    bundle.putString("uuid", address);
                    ft.O000000o(reactApplicationContext).O000000o(new Intent().setAction("startscan_callback").putExtras(bundle));
                }
            }
        });
    }

    @ReactMethod
    public void startLeScan(int i, ReadableArray readableArray) {
        final int size = readableArray == null ? 0 : readableArray.size();
        final UUID[] uuidArr = new UUID[size];
        if (size != 0) {
            for (int i2 = 0; i2 < size; i2++) {
                uuidArr[i2] = getUUid(readableArray.getString(i2));
            }
        }
        XmBluetoothManager.getInstance().startLeScan(i, null, new XmBluetoothManager.BluetoothSearchResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass22 */

            public final void onSearchCanceled() {
            }

            public final void onSearchStarted() {
            }

            public final void onSearchStopped() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[RETURN] */
            public final void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice) {
                boolean z = false;
                if (size > 0) {
                    UUID[] uuidArr = uuidArr;
                    int length = uuidArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            if (exp.O000000o(uuidArr[i], xmBluetoothDevice.scanRecord)) {
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        gsy.O000000o(4, "ReactNativeModule", size + "> startLeScan:" + xmBluetoothDevice);
                        ReactApplicationContext reactApplicationContext = MIOTBluetoothModule.this.getReactApplicationContext();
                        if (reactApplicationContext != null && xmBluetoothDevice != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("name", xmBluetoothDevice.name);
                            bundle.putInt("deviceType", xmBluetoothDevice.deviceType);
                            bundle.putInt("rssi", xmBluetoothDevice.rssi);
                            bundle.putString("scanRecord", fyf.O000000o(xmBluetoothDevice.scanRecord));
                            bundle.putBoolean("isConnected", xmBluetoothDevice.isConnected);
                            String address = xmBluetoothDevice.getAddress();
                            bundle.putString("address", xmBluetoothDevice.getAddress());
                            bundle.putString("mac", address);
                            bundle.putString("uuid", address);
                            ft.O000000o(reactApplicationContext).O000000o(new Intent().setAction("startscan_callback").putExtras(bundle));
                            return;
                        }
                        return;
                    }
                    return;
                }
                z = true;
                if (!z) {
                }
            }
        });
    }

    @ReactMethod
    public void stopScan() {
        XmBluetoothManager.getInstance().stopScan();
    }

    @ReactMethod
    public void disconnectDeviceWithDelay(String str, double d) {
        this.connect = false;
        XmBluetoothManager.getInstance().disconnectFromRN(str, d > 0.0d ? (long) d : 0);
    }

    @ReactMethod
    public void miotBleEncrypt(String str, String str2, final Callback callback) {
        XmBluetoothManager.getInstance().miotBleEncrypt(str, fyf.O000000o(str2), new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass23 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("result", (byte[]) obj);
                MIOTBluetoothModule.this.callbackBundle(i, bundle, callback);
            }
        });
    }

    @ReactMethod
    public void miotBleDecrypt(String str, String str2, final Callback callback) {
        XmBluetoothManager.getInstance().miotBleDecrypt(str, fyf.O000000o(str2), new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass25 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("result", (byte[]) obj);
                MIOTBluetoothModule.this.callbackBundle(i, bundle, callback);
            }
        });
    }

    private UUID getUUid(String str) {
        UUID uuid;
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        UUID uuid2 = this.mUUIDCacheMap.get(lowerCase);
        if (uuid2 != null) {
            return uuid2;
        }
        Map<String, UUID> map = this.mUUIDCacheMap;
        if (lowerCase.contains("-")) {
            uuid = UUID.fromString(lowerCase);
        } else {
            uuid = UUID.fromString(String.format("0000%4s-0000-1000-8000-00805f9b34fb", lowerCase));
        }
        map.put(lowerCase, uuid);
        return uuid;
    }

    public void onCatalystInstanceDestroy() {
        gsy.O000000o(4, "MIOTBlueToothModule", "onCatalystInstanceDestroy!");
        clearHandler();
        if (getDevice() != null) {
            fpp.O000000o(getDevice().model);
        }
        super.onCatalystInstanceDestroy();
    }

    public static void checkFirmwareVersion(final int i, final String str) {
        readFirmwareVersion(str, new com.xiaomi.smarthome.device.api.Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass26 */

            public final /* synthetic */ void onSuccess(Object obj) {
                MIOTBluetoothModule.requestFirmwareUpgradeInfo((String) obj, i, foc.O00000o(str), foc.O000000o(str));
            }

            public final void onFailure(int i, String str) {
                MIOTBluetoothModule.sendCheckUpgradeResultBroadcast(false, null, null, false, str);
            }
        });
    }

    private static void sendEventToJs(String str, WritableMap writableMap) {
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

    public static void sendCheckUpgradeResultBroadcast(boolean z, String str, String str2, boolean z2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("request_success", z);
        if (!TextUtils.isEmpty(str)) {
            createMap.putString("current_version", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            createMap.putString("latest_version", str2);
        }
        createMap.putBoolean("support_common_ble_ota_upgrade", z2);
        if (!TextUtils.isEmpty(str3)) {
            createMap.putString("error_msg", str3);
        }
        sendEventToJs("action.com.miot.check.upgrade.result", createMap);
    }

    public static void requestFirmwareUpgradeInfo(final String str, final int i, String str2, String str3) {
        XmPluginHostApi.instance().getBleMeshFirmwareUpdateInfo(str2, str3, new com.xiaomi.smarthome.device.api.Callback<BleMeshFirmwareUpdateInfo>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass27 */

            public final /* synthetic */ void onSuccess(Object obj) {
                MIOTBluetoothModule.sendCheckUpgradeResultBroadcast(true, str, ((BleMeshFirmwareUpdateInfo) obj).version, fpo.O000000o(i, str), null);
            }

            public final void onFailure(int i, String str) {
                MIOTBluetoothModule.sendCheckUpgradeResultBroadcast(false, null, null, false, str);
            }
        });
    }

    public static void readFirmwareVersion(final String str, final com.xiaomi.smarthome.device.api.Callback<String> callback) {
        XmBluetoothManager.getInstance().read(str, glb.f17954O000000o, glb.O00000oO, new Response.BleReadResponse() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass28 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                final byte[] bArr = (byte[]) obj;
                if (i != 0 || got.O00000o(bArr)) {
                    callback.onFailure(-1, "read firmware version fail");
                } else {
                    XmBluetoothManager.getInstance().isBleCharacterExist(str, glb.f17954O000000o, glb.O00000o0, new Response.BleResponse<Void>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass28.AnonymousClass1 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            byte[] bArr = bArr;
                            if (i == 0) {
                                bArr = BLECipher.O000000o(foc.O0000OoO(str), bArr);
                            }
                            byte[] O0000OOo = got.O0000OOo(bArr);
                            if (callback != null) {
                                callback.onSuccess(new String(O0000OOo));
                            }
                        }
                    });
                }
            }
        });
    }

    @ReactMethod
    public void goToWifiConfigStep(final String str) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule.AnonymousClass29 */

            public final void run() {
                fsp.O000000o().O0000Oo.goToLockWifiConfigStep(MIOTBluetoothModule.this.getCurrentActivity(), str, foc.O0000Oo(str));
            }
        });
    }
}
