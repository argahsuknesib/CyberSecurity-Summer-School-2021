package com.xiaomi.smarthome.uwb.lib.processor;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.ft;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class MijiaProcessor {
    private static void initUWBIdmSdk(Context context) {
    }

    public static void processUWBScanResult(Context context, UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice != null) {
            initUWBIdmSdk(context);
            if (UwbDeviceUtil.isTagDeviceType(uwbScanDevice.getDeviceType())) {
                processTag(uwbScanDevice);
            } else {
                processBuiltin(uwbScanDevice);
            }
        }
    }

    private static void processTag(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "processTag");
        if (UwbDeviceUtil.isUsbInserted(uwbScanDevice)) {
            processTagUsbInserted(uwbScanDevice);
        } else {
            processTagNonTv(uwbScanDevice);
        }
    }

    private static void processBuiltin(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "processBuiltin");
        ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
        if (processorCallback != null) {
            if (UwbDeviceUtil.isBuiltinMitvDeviceType(uwbScanDevice) || UwbDeviceUtil.isThirdTagDevice(uwbScanDevice)) {
                processorCallback.handleTvType(uwbScanDevice);
            } else {
                handleIotBuiltinDeviceType(uwbScanDevice);
            }
        }
    }

    private static void handleIotBuiltinDeviceType(final UwbScanDevice uwbScanDevice) {
        final ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
        if (processorCallback != null) {
            if (UwbDeviceUtil.isLogin(uwbScanDevice)) {
                processorCallback.handleIotDeviceType(uwbScanDevice);
            } else {
                processorCallback.onBindBuiltin(uwbScanDevice, new DeviceBindHelper.BindDeviceListener() {
                    /* class com.xiaomi.smarthome.uwb.lib.processor.MijiaProcessor.AnonymousClass1 */

                    public final void onSuccess(String str, String str2, int i) {
                        UwbSdk.setBindDeviceListener(null);
                        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "handleIotBuiltinDeviceType bind device callback onSuccess ".concat(String.valueOf(str2)));
                        UwbDeviceUtil.updateUwbDeviceBindStatus(uwbScanDevice, str2, str, i);
                        UwbDeviceUtil.updateUwbDeviceLogin(uwbScanDevice, str);
                        UwbApi.getInstance().getUwbConEngine().startConnect();
                        processorCallback.handleIotDeviceType(uwbScanDevice);
                    }

                    public final void onCancel() {
                        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "handleIotBuiltinDeviceType bind device callback cancel ");
                    }

                    public final void onFail(int i, String str) {
                        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "handleIotBuiltinDeviceType bind device callback onFail " + i + "," + str);
                    }
                });
            }
        }
    }

    private static void processTagUsbInserted(UwbScanDevice uwbScanDevice) {
        if (!UwbDeviceUtil.isMitvDeviceTagType(uwbScanDevice)) {
            processTagUsbInsertedNonTv(uwbScanDevice);
        } else {
            processTagUsbInsertedMiTv(uwbScanDevice);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    private static void processTagUsbInsertedNonTv(final UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "processTagUsbInsertedNonTv");
        if (!UwbDeviceUtil.isLogin(uwbScanDevice)) {
            final UwbConEngine uwbConEngine = UwbApi.getInstance().getUwbConEngine();
            if (uwbConEngine instanceof UwbConnEngineMijia) {
                ((UwbConnEngineMijia) uwbConEngine).setNeedBindIotDevice(false);
            }
            ft.O000000o(UwbSdk.getApplication()).O000000o(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.uwb.lib.processor.MijiaProcessor.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    ft.O000000o(UwbSdk.getApplication()).O000000o(this);
                    int intExtra = intent.getIntExtra("arg_code", 1);
                    if (intExtra == 0) {
                        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "processTagUsbInsertedNonTv: bind success");
                        UwbDeviceUtil.updateUwbDeviceThirdTvLogin(uwbScanDevice, intent.getStringExtra("arg_uid"), intent.getStringExtra("arg_tag_id"));
                        uwbConEngine.startConnect();
                        ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
                        if (processorCallback != null) {
                            processorCallback.handleThirdTagType(uwbScanDevice);
                        }
                    } else if (intExtra == 1) {
                        UwbLogUtil.e("Mijia-UWB-ScanResultProcessor", "processTagUsbInsertedNonTv: bind cancel");
                    } else if (intExtra == -1) {
                        int intExtra2 = intent.getIntExtra("arg_error_code", -999);
                        String stringExtra = intent.getStringExtra("arg_error_msg");
                        UwbLogUtil.e("Mijia-UWB-ScanResultProcessor", "processTagUsbInsertedNonTv: bind fail code : " + intExtra2 + " ; msg: " + stringExtra);
                    }
                }
            }, new IntentFilter("UwbGeneralLoadingActivity-Action"));
            fbt fbt = new fbt(UwbSdk.getApplication(), "UwbTagBindLoadingActivity");
            fbt.O000000o("uwb_scan_result", (Parcelable) uwbScanDevice).O00000Oo(268435456);
            fbs.O000000o(fbt);
            return;
        }
        ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
        if (processorCallback != null) {
            processorCallback.handleThirdTagType(uwbScanDevice);
        }
    }

    private static void processTagUsbInsertedMiTv(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "processTagUsbInsertedMiTv");
        ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
        if (processorCallback != null) {
            processorCallback.handleTvType(uwbScanDevice);
        }
    }

    private static void processTagNonTv(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "processTagNonTv");
        ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
        if (processorCallback != null) {
            if (UwbDeviceUtil.getTagBindStatus(uwbScanDevice) == 0 || UwbDeviceUtil.getTagBindStatus(uwbScanDevice) == 1) {
                handleUnbindStatusTag(uwbScanDevice, processorCallback);
            } else if (processorCallback != null) {
                processorCallback.handleIotDeviceType(uwbScanDevice);
            }
        }
    }

    private static void handleUnbindStatusTag(final UwbScanDevice uwbScanDevice, ProcessorCallback processorCallback) {
        UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "handleUnbindStatusTag");
        final UwbConEngine uwbConEngine = UwbApi.getInstance().getUwbConEngine();
        if (uwbConEngine instanceof UwbConnEngineMijia) {
            ((UwbConnEngineMijia) uwbConEngine).setNeedBindIotDevice(false);
        }
        processorCallback.onBindTag(uwbScanDevice, new DeviceBindHelper.BindDeviceListener() {
            /* class com.xiaomi.smarthome.uwb.lib.processor.MijiaProcessor.AnonymousClass3 */

            public final void onSuccess(String str, String str2, int i) {
                UwbSdk.setBindDeviceListener(null);
                UwbLogUtil.d("Mijia-UWB-ScanResultProcessor", "handleUnbindStatus: bind success");
                UwbDeviceUtil.updateUwbDeviceLogin(uwbScanDevice, str);
                UwbDeviceUtil.updateUwbDeviceBindStatus(uwbScanDevice, str2, str, i);
                uwbConEngine.startConnect();
                MijiaProcessor.processUWBScanResult(UwbSdk.getApplication(), uwbScanDevice);
            }

            public final void onCancel() {
                UwbLogUtil.e("Mijia-UWB-ScanResultProcessor", "handleUnbindStatus: onCancel");
            }

            public final void onFail(int i, String str) {
                UwbLogUtil.e("Mijia-UWB-ScanResultProcessor", "handleUnbindStatus: onFail " + i + "," + str);
            }
        });
    }
}
