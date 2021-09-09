package _m_j;

import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.ComboDeviceManager$1;
import com.xiaomi.smarthome.device.bluetooth.ComboDeviceManager$2;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class fol {

    /* renamed from: O000000o  reason: collision with root package name */
    private static List<BleDevice> f16766O000000o = new ArrayList();
    private static HashMap<String, Future<String>> O00000Oo = new HashMap<>();

    private static boolean O000000o(Future<String> future) {
        gnk.O00000o0(String.format("checkFuture %s", future));
        if (future != null) {
            gnk.O00000o0(String.format(">>> isCanceled = %b", Boolean.valueOf(future.isCancelled())));
            gnk.O00000o0(String.format(">>> isDone = %b", Boolean.valueOf(future.isDone())));
        }
        if (future != null && !future.isCancelled()) {
            try {
                if (!future.isDone()) {
                    return true;
                }
                gnk.O00000o0(String.format(">>> result = %s", future.get()));
                if (!TextUtils.isEmpty(future.get())) {
                    return true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static Future<String> O000000o(ScanResult scanResult) {
        Future<String> future = O00000Oo.get(scanResult.BSSID);
        if (O000000o(future)) {
            return future;
        }
        FutureTask futureTask = new FutureTask(new ComboDeviceManager$1(scanResult));
        O00000Oo.put(scanResult.BSSID, futureTask);
        gqe.O000000o(futureTask, AsyncTask.THREAD_POOL_EXECUTOR);
        return futureTask;
    }

    public static String O00000Oo(ScanResult scanResult) {
        String O0000Oo = DeviceFactory.O0000Oo(scanResult);
        gsy.O00000Oo(LogType.BLUETOOTH, "BleComboStep", "searchComboDeviceSync kuailian device uid is ".concat(String.valueOf(O0000Oo)));
        Bundle bundle = new Bundle();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        fpo.O000000o(O0000Oo, new ComboDeviceManager$2(bundle, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bundle.getString("extra.mac", "");
    }
}
