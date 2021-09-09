package com.xiaomi.smarthome.uwb.lib.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class MijiaPlusProcessor {
    private static void initUWBIdmSdk(Context context) {
    }

    public static void processUWBScanResult(Context context, UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice != null) {
            initUWBIdmSdk(context);
            if (UwbDeviceUtil.shouldOpenInMijiaPlus(uwbScanDevice)) {
                processScanResultInMijiaPlus(uwbScanDevice);
                return;
            }
            int mijiaStatus = UwbDeviceUtil.getMijiaStatus();
            uwbScanDevice.getDeviceType();
            UwbDeviceUtil.isUsbInserted(uwbScanDevice);
            if (mijiaStatus != 0) {
                downloadMijiaGuide(mijiaStatus);
            } else {
                sendIntentToMijia(context, uwbScanDevice);
            }
        }
    }

    private static void processScanResultInMijiaPlus(UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice != null) {
            UwbSdk.getProcessorCallback().handleTvType(uwbScanDevice);
        }
    }

    private static void sendIntentToMijia(Context context, UwbScanDevice uwbScanDevice) {
        UwbLogUtil.e("Mijia-UWB-timestamp", UwbSdk.getApplication().getPackageName() + ":uwb device selected, will goto Mijia");
        Intent intent = new Intent();
        intent.setPackage("com.xiaomi.smarthome");
        intent.setData(Uri.parse("mihome://home.mi.com/uwb/scan-result"));
        intent.putExtra("uwb_scan_result", uwbScanDevice.toJSON().toString());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 1001);
            return;
        }
        intent.addFlags(268435456);
        intent.addFlags(131072);
        context.startActivity(intent);
    }

    public static void downloadMijiaGuide(int i) {
        ProcessorCallback processorCallback = UwbSdk.getProcessorCallback();
        if (processorCallback != null) {
            processorCallback.onDownloadMijia(i);
        }
    }
}
