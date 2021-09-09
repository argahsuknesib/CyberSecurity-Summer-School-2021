package com.xiaomi.smarthome.uwb.lib;

import android.app.Application;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.IDMUwbDevice;
import com.xiaomi.idm.uwb.constant.UwbResultCode;
import com.xiaomi.smarthome.uwb.lib.UwbSdkConfig;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.processor.ProcessorCallback;
import com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper;
import java.util.List;

public class UwbSdk {
    private static Application sApplication = null;
    private static DeviceBindHelper.BindDeviceListener sBindDeviceListener = null;
    private static ProcessorCallback sProcessorCallback = null;
    private static volatile UwbSdkConfig sSdkConfig = null;
    private static volatile boolean sUsingEncrypt = true;

    public interface UwbInitCallback {
        void onError(int i);

        void onSuccess();
    }

    public static void processUWBScanResult(UwbScanDevice uwbScanDevice) {
    }

    public static void init(Application application, UwbSdkConfig uwbSdkConfig, final UwbInitCallback uwbInitCallback) {
        if (sApplication == null || sSdkConfig == null) {
            sApplication = application;
            sSdkConfig = uwbSdkConfig;
            UwbIdmManager.getInstance().addDelegateCallback(new IDMUwb.UwbCallback() {
                /* class com.xiaomi.smarthome.uwb.lib.UwbSdk.AnonymousClass1 */

                public final void onConnectionState(String str, UwbResultCode uwbResultCode) {
                }

                public final void onEstablishSecurityLine(UwbResultCode uwbResultCode) {
                }

                public final void onPayloadReceived(String str, IDMUwb.Payload payload) {
                }

                public final void onScanState(UwbResultCode uwbResultCode) {
                }

                public final void onScanning(List<IDMUwbDevice> list) {
                }

                public final void onSendPayload(UwbResultCode uwbResultCode, int i) {
                }

                public final void onSetServerSecurityKey(UwbResultCode uwbResultCode) {
                }

                public final void onSwitchCommunicationType(UwbResultCode uwbResultCode) {
                }

                public final void onTagOTA(UwbResultCode uwbResultCode, int i) {
                }

                public final void onTagPluggedIn() {
                }

                public final void onTagUnplugged() {
                }

                public final void onMiConnectConnectionState(UwbResultCode uwbResultCode) {
                    UwbIdmManager.getInstance().removeDelegateCallback(this);
                    UwbInitCallback uwbInitCallback = uwbInitCallback;
                    if (uwbInitCallback != null) {
                        uwbInitCallback.onSuccess();
                    }
                }
            });
            UwbIdmManager.getInstance().init(application);
        }
    }

    public static UwbSdkConfig getSdkConfig() {
        if (sSdkConfig == null) {
            sSdkConfig = new UwbSdkConfig.Builder().setLogLevel(5).build();
        }
        return sSdkConfig;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static void setProcessorCallback(ProcessorCallback processorCallback) {
        sProcessorCallback = processorCallback;
    }

    public static ProcessorCallback getProcessorCallback() {
        return sProcessorCallback;
    }

    public static DeviceBindHelper.BindDeviceListener getBindDeviceListener() {
        return sBindDeviceListener;
    }

    public static void setBindDeviceListener(DeviceBindHelper.BindDeviceListener bindDeviceListener) {
        sBindDeviceListener = bindDeviceListener;
    }

    public static boolean isUsingEncrypt() {
        if (getSdkConfig().getLogLevel() >= 5) {
            return true;
        }
        return sUsingEncrypt;
    }

    public static void setUsingEncrypt(boolean z) {
        if (getSdkConfig().getLogLevel() >= 5) {
            z = true;
        }
        sUsingEncrypt = z;
    }
}
