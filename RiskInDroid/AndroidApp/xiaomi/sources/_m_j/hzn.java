package _m_j;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.smarthome.uwb.ui.UwbNoPermissionActivity;
import com.smarthome.uwb.ui.auth.CloseAuthActivity;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.UwbDevice;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb_mijia.UwbLoadingActivity;
import java.util.Map;

public final class hzn {
    public static void O000000o(UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice == null) {
            UwbLogUtil.e("Mijia-UWB-OpenIotDevice", "openIotDevice uwbDevice = null");
            return;
        }
        UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleIotDeviceType in");
        new AllReadyCallback(new Runnable() {
            /* class _m_j.$$Lambda$hzn$i540pDv2MUI1pXU1x7N2f5hR8pM */

            public final void run() {
                hzn.O00000o0(UwbScanDevice.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleIotDeviceType AllReadyCallback in");
        if (!O00000Oo(uwbScanDevice)) {
            UwbNoPermissionActivity.startUwbNoPermissionActivity(UwbSdk.getApplication(), uwbScanDevice);
            UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleIotDeviceType:stranger no permission, return");
        } else if (!hzu.O00000o0(uwbScanDevice)) {
            UwbLogUtil.e("Mijia-UWB-OpenIotDevice", "AllReadyCallback checkHasPermission isStranger true".concat(String.valueOf(uwbScanDevice)));
            for (Map.Entry next : fno.O000000o().O00000oO().entrySet()) {
                if (UwbDeviceUtil.isUwbHashEnd(uwbScanDevice.getDidInfo().getDid(), ((Device) next.getValue()).did)) {
                    UwbLogUtil.e("Mijia-UWB-OpenIotDevice", "AllReadyCallback matchDevice " + next.getValue());
                    O000000o(new UwbDevice(uwbScanDevice, (Device) next.getValue()));
                    return;
                }
            }
            O000000o(new UwbDevice(uwbScanDevice, null));
        } else {
            String uwbDeviceKey = UwbDeviceUtil.getUwbDeviceKey(hzu.O00000o(uwbScanDevice));
            UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleIotDeviceType distance: " + uwbScanDevice.getDistance() + " keyStr: " + uwbDeviceKey);
            if (uwbScanDevice.getDistance() <= 200) {
                O000000o(new UwbDevice(uwbScanDevice, null));
            } else if (TextUtils.isEmpty(uwbDeviceKey)) {
                CloseAuthActivity.startCardActivity(UwbSdk.getApplication(), uwbScanDevice);
            } else {
                UwbLoadingActivity.startCardActivity(UwbSdk.getApplication(), uwbScanDevice);
            }
        }
    }

    public static boolean O00000Oo(UwbScanDevice uwbScanDevice) {
        if (!hzu.O00000o0(uwbScanDevice)) {
            return true;
        }
        if (uwbScanDevice.getDeviceState() == null || uwbScanDevice.getDeviceState().getAuth() != 0) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
     arg types: [java.lang.String, com.xiaomi.smarthome.uwb.UwbDevice]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent} */
    public static void O000000o(UwbDevice uwbDevice) {
        Intent intent;
        Intent intent2;
        if ((uwbDevice.getUwbDevice() != null ? PluginDeviceManager.instance.getModelByProductId((int) uwbDevice.getUwbDevice().getPid()) : "").contains(".wifispeaker.")) {
            UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "openIotDevice open mico");
            try {
                intent2 = new Intent(UwbSdk.getApplication(), Class.forName("com.xiaomi.smarthome.uwb.mico.UwbMicoActivity"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                intent2 = null;
            }
            intent2.putExtra("uwb_scan_device", uwbDevice.getUwbDevice());
            intent2.addFlags(268435456);
            UwbSdk.getApplication().startActivity(intent2);
            UwbLogUtil.e("Mijia-UWB-timestamp", "openIotDevice: will start XiaoAi page");
            return;
        }
        UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "openIotDevice open iot device");
        try {
            intent = new Intent(UwbSdk.getApplication(), Class.forName("com.xiaomi.smarthome.uwb.UwbCardActivity"));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            intent = null;
        }
        intent.putExtra("uwb_scan_device", (Parcelable) uwbDevice);
        intent.addFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
        UwbLogUtil.e("Mijia-UWB-timestamp", "openIotDevice: will start IoT card page");
    }
}
