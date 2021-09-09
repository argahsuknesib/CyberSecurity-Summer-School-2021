package cn.com.xm.bt.sdk;

import android.content.Context;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.profile.nfc.HMNFCStatus;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void test(Context context) {
        final HMBleDevice hMBleDevice = new HMBleDevice(context, "F2:19:CA:80:20:7A");
        hMBleDevice.setPair(true);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        hMBleDevice.connect(new IDeviceCallback() {
            /* class cn.com.xm.bt.sdk.Test.AnonymousClass1 */

            public final void onAuthStateChanged(int i, int i2) {
            }

            public final byte[] onSignature(String str, String str2) {
                return null;
            }

            public final void onConnectionStateChanged(int i) {
                if (i == 0) {
                    hMBleDevice.setPair(false);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(120, TimeUnit.SECONDS);
        } catch (Exception unused) {
        }
        a.b("test", "key:" + hMBleDevice.getKey());
        HMNFCStatus openApduChannel = hMBleDevice.openApduChannel();
        a.b("test", "open status:".concat(String.valueOf(openApduChannel)));
        if (openApduChannel.getStatus() == 0) {
            a.b("test", "realtime step:".concat(String.valueOf(hMBleDevice.getRealtimeStep())));
            a.b("test", "response:".concat(String.valueOf(hMBleDevice.sendApduData(new byte[]{0, -92, 4, 0, 8, -96, 0, 0, 1, 81, 0, 0, 0}, 13, false))));
            a.b("test", "close status:".concat(String.valueOf(hMBleDevice.closeApduChannel())));
            hMBleDevice.disconnect();
        }
    }
}
