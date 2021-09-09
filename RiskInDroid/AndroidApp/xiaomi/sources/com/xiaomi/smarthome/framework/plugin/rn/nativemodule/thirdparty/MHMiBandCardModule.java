package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty;

import _m_j.fyc;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.mitsmsdk.NfcChannelManager;

public class MHMiBandCardModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "MHMiBandCardModule";
    }

    public MHMiBandCardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public final void initBandManager(String str, String str2, final Callback callback) {
        fyc.O000000o("MHMiBandCardModule", " RN initBandManager");
        XmPluginHostApi.instance().initBandManager(str, str2, new com.xiaomi.smarthome.device.api.Callback<Boolean>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass1 */

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                callback.invoke(0, "");
            }
        });
    }

    @ReactMethod
    public final void deInitBandManager() {
        XmPluginHostApi.instance().deInitBandManager();
    }

    @ReactMethod
    public final void connectBand(String str, final Callback callback) {
        fyc.O000000o("MHMiBandCardModule", " RN connectBracelet");
        XmPluginHostApi.instance().connectBand(str, new com.xiaomi.smarthome.device.api.Callback<Integer>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                Integer num = (Integer) obj;
                fyc.O000000o("MHMiBandCardModule", " RN connectBand result = ".concat(String.valueOf(num)));
                if (num.intValue() == 3) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) MHMiBandCardModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("miband_nfc_confirm_ui_show", 3);
                } else if (num.intValue() == 2) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) MHMiBandCardModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("miband_nfc_confirm_ui_show", 2);
                } else {
                    callback.invoke(num, "");
                }
            }

            public final void onFailure(int i, String str) {
                fyc.O000000o("MHMiBandCardModule", " RN connectBand fail error = ".concat(String.valueOf(i)));
                callback.invoke(Integer.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public final void getAllCards(final Callback callback) {
        XmPluginHostApi.instance().getAllCards(new com.xiaomi.smarthome.device.api.Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                WritableArray transferStrToCardInfos = NfcChannelManager.transferStrToCardInfos((String) obj);
                callback.invoke(0, transferStrToCardInfos);
            }

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public final void issueDoorCard(final Callback callback) {
        XmPluginHostApi.instance().issueDoorCard(new com.xiaomi.smarthome.device.api.Callback<Boolean>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass4 */

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                callback.invoke(0, "");
            }
        });
    }

    @ReactMethod
    public final void deleteCard(String str, final Callback callback) {
        XmPluginHostApi.instance().deleteCard(str, new com.xiaomi.smarthome.device.api.Callback<Boolean>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass5 */

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                callback.invoke(0, "");
            }
        });
    }

    @ReactMethod
    public final void setDefaultCard(String str, final Callback callback) {
        XmPluginHostApi.instance().setDefaultCard(str, new com.xiaomi.smarthome.device.api.Callback<Boolean>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass6 */

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                callback.invoke(0, "");
            }
        });
    }

    @ReactMethod
    public final void updateCard(ReadableMap readableMap, final Callback callback) {
        XmPluginHostApi.instance().updateCard(readableMap.toString(), new com.xiaomi.smarthome.device.api.Callback<Boolean>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass7 */

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                callback.invoke(0, "");
            }
        });
    }

    @ReactMethod
    public final void getDefaultCardAndActivateInfo(final Callback callback) {
        XmPluginHostApi.instance().getDefaultCardAndActivateInfo(new com.xiaomi.smarthome.device.api.Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                WritableArray transferStrToActivateInfo = NfcChannelManager.transferStrToActivateInfo((String) obj);
                callback.invoke(0, transferStrToActivateInfo);
            }

            public final void onFailure(int i, String str) {
                callback.invoke(Integer.valueOf(i), str);
            }
        });
    }
}
