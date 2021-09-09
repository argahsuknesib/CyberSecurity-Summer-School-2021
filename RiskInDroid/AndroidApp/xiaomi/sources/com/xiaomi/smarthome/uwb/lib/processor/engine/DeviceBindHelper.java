package com.xiaomi.smarthome.uwb.lib.processor.engine;

import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.MijiaProcessor;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;

public class DeviceBindHelper {

    public interface BindDeviceListener {
        void onCancel();

        void onFail(int i, String str);

        void onSuccess(String str, String str2, int i);
    }

    public static void bindDevice(final UwbScanDevice uwbScanDevice, final BindDeviceListener bindDeviceListener) {
        if (UwbSdk.getProcessorCallback() == null) {
            bindDeviceListener.onFail(-1, "UwbSdk processor call is null, just return");
            return;
        }
        AnonymousClass1 r0 = new BindDeviceListener() {
            /* class com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper.AnonymousClass1 */

            public final void onSuccess(String str, String str2, int i) {
                UwbDeviceUtil.updateUwbDeviceBindStatus(uwbScanDevice, str2, str, i);
                bindDeviceListener.onSuccess(str, str2, i);
                UwbApi.getInstance().isEngineReady(new UwbConEngine.IEngineStateCallback() {
                    /* class com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper.AnonymousClass1.AnonymousClass1 */

                    public void onConnectionError(int i, String str) {
                    }

                    public void onEstablishSecurityError(int i, String str) {
                    }

                    public void onRetryKeyRetrieve() {
                    }

                    public void onSwitchCommunication(int i, String str) {
                    }

                    public void onConnEstablished() {
                        MijiaProcessor.processUWBScanResult(UwbSdk.getApplication(), uwbScanDevice);
                    }
                });
            }

            public final void onCancel() {
                bindDeviceListener.onCancel();
            }

            public final void onFail(int i, String str) {
                bindDeviceListener.onFail(i, str);
            }
        };
        if (UwbDeviceUtil.isTagDeviceType(uwbScanDevice.getDeviceType())) {
            UwbSdk.getProcessorCallback().onBindTag(uwbScanDevice, r0);
        } else if (UwbDeviceUtil.isBuiltinDeviceType(uwbScanDevice.getDeviceType())) {
            UwbSdk.getProcessorCallback().onBindBuiltin(uwbScanDevice, r0);
        }
    }
}
