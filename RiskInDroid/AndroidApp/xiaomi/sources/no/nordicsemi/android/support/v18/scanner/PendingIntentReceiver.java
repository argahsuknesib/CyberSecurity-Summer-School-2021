package no.nordicsemi.android.support.v18.scanner;

import _m_j.jak;
import _m_j.jao;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

public class PendingIntentReceiver extends BroadcastReceiver {
    /* JADX WARNING: Can't wrap try/catch for region: R(3:71|72|73) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0164, code lost:
        r3.O0000OoO.f1713O000000o = r22;
        r4 = r23;
        r2 = r4.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0172, code lost:
        if (r2 == null) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0174, code lost:
        r1 = r1.O000000o(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x017c, code lost:
        if (r0.O00000oO <= 0) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017e, code lost:
        r3.O000000o(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0186, code lost:
        if (r1.isEmpty() != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0188, code lost:
        r3.O000000o(r4.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1), r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0199, code lost:
        r0 = r4.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019f, code lost:
        if (r0 == 0) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a1, code lost:
        r3.O000000o(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a4, code lost:
        r3.O0000OoO.f1713O000000o = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ad, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01ac */
    public void onReceive(Context context, Intent intent) {
        PendingIntent pendingIntent;
        Intent intent2 = intent;
        if (context != null && intent2 != null && (pendingIntent = (PendingIntent) intent2.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT")) != null) {
            ArrayList parcelableArrayListExtra = intent2.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
            ScanSettings scanSettings = (ScanSettings) intent2.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
            if (parcelableArrayListExtra != null && scanSettings != null) {
                boolean booleanExtra = intent2.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_BATCHING", true);
                boolean booleanExtra2 = intent2.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_FILTERING", true);
                boolean booleanExtra3 = intent2.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_CALLBACK_TYPES", true);
                long longExtra = intent2.getLongExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_LOST_TIMEOUT", 10000);
                long longExtra2 = intent2.getLongExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_LOST_INTERVAL", 10000);
                int intExtra = intent2.getIntExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_MODE", 1);
                int intExtra2 = intent2.getIntExtra("no.nordicsemi.android.support.v18.EXTRA_NUM_OF_MATCHES", 3);
                jak O000000o2 = jak.O000000o();
                jao jao = (jao) O000000o2;
                ArrayList arrayList = new ArrayList();
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    ScanFilter scanFilter = (ScanFilter) it.next();
                    Iterator it2 = it;
                    ScanFilter.O000000o o000000o = new ScanFilter.O000000o();
                    ScanFilter.O000000o O000000o3 = o000000o.O000000o(scanFilter.getDeviceAddress());
                    O000000o3.f15415O000000o = scanFilter.getDeviceName();
                    PendingIntent pendingIntent2 = pendingIntent;
                    jao jao2 = jao;
                    O000000o3.O000000o(scanFilter.getServiceUuid(), scanFilter.getServiceUuidMask()).O000000o(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask());
                    if (scanFilter.getServiceDataUuid() != null) {
                        o000000o.O000000o(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
                    }
                    arrayList.add(o000000o.O000000o());
                    it = it2;
                    pendingIntent = pendingIntent2;
                    jao = jao2;
                }
                PendingIntent pendingIntent3 = pendingIntent;
                jao jao3 = jao;
                ScanSettings.O000000o o000000o2 = new ScanSettings.O000000o();
                o000000o2.O00000oO = scanSettings.getLegacy();
                o000000o2.O00000oo = scanSettings.getPhy();
                int callbackType = scanSettings.getCallbackType();
                if (callbackType == 1 || callbackType == 2 || callbackType == 4 || callbackType == 6) {
                    o000000o2.f15418O000000o = callbackType;
                    ScanSettings.O000000o O000000o4 = o000000o2.O000000o(scanSettings.getScanMode());
                    long reportDelayMillis = scanSettings.getReportDelayMillis();
                    if (reportDelayMillis >= 0) {
                        O000000o4.O00000Oo = reportDelayMillis;
                        O000000o4.O0000OOo = booleanExtra;
                        O000000o4.O0000O0o = booleanExtra2;
                        O000000o4.O0000Oo0 = booleanExtra3;
                        if (longExtra <= 0 || longExtra2 <= 0) {
                            throw new IllegalArgumentException("maxDeviceAgeMillis and taskIntervalMillis must be > 0");
                        }
                        O000000o4.O0000Oo = longExtra;
                        O000000o4.O0000OoO = longExtra2;
                        if (intExtra <= 0 || intExtra > 2) {
                            throw new IllegalArgumentException("invalid matchMode ".concat(String.valueOf(intExtra)));
                        }
                        O000000o4.O00000o0 = intExtra;
                        if (intExtra2 <= 0 || intExtra2 > 3) {
                            throw new IllegalArgumentException("invalid numOfMatches ".concat(String.valueOf(intExtra2)));
                        }
                        O000000o4.O00000o = intExtra2;
                        ScanSettings O000000o5 = O000000o4.O000000o();
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        boolean isOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
                        boolean isOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
                        synchronized (O000000o2) {
                            PendingIntent pendingIntent4 = pendingIntent3;
                            jao jao4 = jao3;
                            jao.O000000o O000000o6 = jao4.O000000o(pendingIntent4);
                            if (O000000o6 == null) {
                                jao.O000000o o000000o3 = new jao.O000000o(isOffloadedScanBatchingSupported, isOffloadedFilteringSupported, arrayList, O000000o5, pendingIntent4);
                                synchronized (jao4.f1711O000000o) {
                                    jao4.f1711O000000o.put(pendingIntent4, o000000o3);
                                }
                                O000000o6 = o000000o3;
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("reportDelay must be > 0");
                    }
                } else {
                    throw new IllegalArgumentException("invalid callback type - ".concat(String.valueOf(callbackType)));
                }
            }
        }
    }
}
