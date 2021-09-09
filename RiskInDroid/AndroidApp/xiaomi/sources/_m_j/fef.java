package _m_j;

import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.ComboDeviceManager$1;
import com.xiaomi.smarthome.core.server.internal.bluetooth.ComboDeviceManager$2;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class fef {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<String, Future<String>> f16182O000000o = new HashMap<>();

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
        Future<String> future = f16182O000000o.get(scanResult.BSSID);
        if (O000000o(future)) {
            return future;
        }
        FutureTask futureTask = new FutureTask(new ComboDeviceManager$1(scanResult));
        f16182O000000o.put(scanResult.BSSID, futureTask);
        gqe.O000000o(futureTask, AsyncTask.THREAD_POOL_EXECUTOR);
        return futureTask;
    }

    public static String O00000Oo(ScanResult scanResult) {
        String O00000o0 = O00000o0(scanResult);
        gsy.O00000Oo(LogType.BLUETOOTH, "BleComboStep", "searchComboDeviceSync kuailian device uid is ".concat(String.valueOf(O00000o0)));
        Bundle bundle = new Bundle();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        fea.O00000oo(O00000o0, new ComboDeviceManager$2(bundle, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bundle.getString("extra.mac", "");
    }

    public static String O00000o0(ScanResult scanResult) {
        return O000000o(scanResult.BSSID, scanResult.SSID);
    }

    private static String O000000o(String str, String str2) {
        String replace;
        int length;
        String O000000o2 = str2 != null ? O000000o(str2) : null;
        return ((O000000o2 == null || O000000o2.length() != 4) && str != null && (length = (replace = str.replace(":", "")).length()) >= 4) ? replace.substring(length - 4) : O000000o2;
    }

    private static String O000000o(String str) {
        int indexOf = str.indexOf("_miio");
        if (indexOf > 0) {
            return str.substring(indexOf + 5);
        }
        int indexOf2 = str.indexOf("_miap");
        if (indexOf2 > 0) {
            return str.substring(indexOf2 + 5);
        }
        int indexOf3 = str.indexOf("_mibt");
        if (indexOf3 > 0) {
            return str.substring(indexOf3 + 5);
        }
        int indexOf4 = str.indexOf("_midev");
        if (indexOf4 > 0) {
            return str.substring(indexOf4 + 6);
        }
        if (O00000Oo(str) != null) {
            return "";
        }
        int indexOf5 = str.indexOf("midea_ac_");
        return indexOf5 >= 0 ? str.substring(indexOf5 + 9) : str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    private static String O00000Oo(String str) {
        int indexOf = str.indexOf("_miio");
        if (indexOf > 1) {
            return str.substring(0, indexOf).replace('-', '.');
        }
        int indexOf2 = str.indexOf("_miap");
        if (indexOf2 > 1) {
            return str.substring(0, indexOf2).replace('-', '.');
        }
        int indexOf3 = str.indexOf("_mibt");
        if (indexOf3 > 1) {
            return str.substring(0, indexOf3).replace('-', '.');
        }
        int indexOf4 = str.indexOf("_midev");
        if (indexOf4 > 1) {
            return str.substring(0, indexOf4).replace('-', '.');
        }
        return (str.contains("midea_AC") || str.contains("midea_ac")) ? "midea.aircondition.v1" : "";
    }
}
