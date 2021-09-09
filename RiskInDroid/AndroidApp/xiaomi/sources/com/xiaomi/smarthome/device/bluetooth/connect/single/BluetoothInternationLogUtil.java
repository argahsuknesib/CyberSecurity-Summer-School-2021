package com.xiaomi.smarthome.device.bluetooth.connect.single;

import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.smarthome.application.ServiceApplication;

public final class BluetoothInternationLogUtil {
    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!ServiceApplication.shouldEnableBugly()) {
                    return;
                }
                if (ServiceApplication.isInternationalServer()) {
                    CrashReport.O000000o(new InternationalBluetoothException(str));
                } else {
                    CrashReport.O000000o(new MainlandBluetoothException(str));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class InternationalBluetoothException extends Exception {
        public InternationalBluetoothException(String str) {
            super(str);
        }
    }

    public static class MainlandBluetoothException extends Exception {
        public MainlandBluetoothException(String str) {
            super(str);
        }
    }
}
