package com.xiaomi.smarthome.uwb.kuailian.tag;

import android.content.Context;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.kuailian.tag.KuailianUwbTagManger;

public class UwbTagTest {
    private void Test(final Context context, BleDevice bleDevice) {
        if (!KuailianUwbTagManger.getInstance(context).isOngoing()) {
            KuailianUwbTagManger.getInstance(context).init(bleDevice);
            KuailianUwbTagManger.getInstance(context).startConfig(new KuailianUwbTagManger.KuailianUwbTagListener() {
                /* class com.xiaomi.smarthome.uwb.kuailian.tag.UwbTagTest.AnonymousClass1 */

                public void onError(int i, Object obj) {
                }

                public void onStepSuccess(int i) {
                }

                public void onLastResponse(int i, Device device) {
                    KuailianUwbTagManger.getInstance(context).release();
                }
            });
        }
    }
}
