package _m_j;

import _m_j.jak;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

@TargetApi(21)
public class jam extends jak {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<jat, O000000o> f1706O000000o = new HashMap();

    jam() {
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(List<ScanFilter> list, ScanSettings scanSettings, jat jat, Handler handler) {
        O000000o o000000o;
        ScanSettings scanSettings2 = scanSettings;
        jat jat2 = jat;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        jap.O000000o(defaultAdapter);
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            boolean isOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
            boolean isOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
            synchronized (this.f1706O000000o) {
                if (!this.f1706O000000o.containsKey(jat2)) {
                    o000000o = new O000000o(isOffloadedScanBatchingSupported, isOffloadedFilteringSupported, list, scanSettings, jat, handler, (byte) 0);
                    this.f1706O000000o.put(jat2, o000000o);
                } else {
                    throw new IllegalArgumentException("scanner already started with given callback");
                }
            }
            android.bluetooth.le.ScanSettings O000000o2 = O000000o(defaultAdapter, scanSettings2);
            ArrayList<android.bluetooth.le.ScanFilter> arrayList = null;
            if (!list.isEmpty() && isOffloadedFilteringSupported && scanSettings2.O0000OOo) {
                arrayList = O00000Oo(list);
            }
            bluetoothLeScanner.startScan(arrayList, O000000o2, o000000o.O0000OoO);
            return;
        }
        throw new IllegalStateException("BT le scanner not available");
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(jat jat) {
        O000000o remove;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        jap.O000000o(defaultAdapter);
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            synchronized (this.f1706O000000o) {
                remove = this.f1706O000000o.remove(jat);
            }
            if (remove != null) {
                remove.O000000o();
                bluetoothLeScanner.stopScan(remove.O0000OoO);
                return;
            }
            return;
        }
        throw new IllegalStateException("BT le scanner not available");
    }

    /* access modifiers changed from: package-private */
    public android.bluetooth.le.ScanSettings O000000o(BluetoothAdapter bluetoothAdapter, ScanSettings scanSettings) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (bluetoothAdapter.isOffloadedScanBatchingSupported() && scanSettings.O0000Oo0) {
            builder.setReportDelay(scanSettings.O00000oO);
        }
        if (scanSettings.O00000o0 != -1) {
            builder.setScanMode(scanSettings.O00000o0);
        } else {
            builder.setScanMode(0);
        }
        scanSettings.O0000Oo = false;
        return builder.build();
    }

    private static ArrayList<android.bluetooth.le.ScanFilter> O00000Oo(List<ScanFilter> list) {
        ArrayList<android.bluetooth.le.ScanFilter> arrayList = new ArrayList<>();
        for (ScanFilter next : list) {
            ScanFilter.Builder builder = new ScanFilter.Builder();
            builder.setDeviceAddress(next.O00000Oo).setDeviceName(next.f15414O000000o).setServiceUuid(next.O00000o0, next.O00000o).setManufacturerData(next.O0000OOo, next.O0000Oo0, next.O0000Oo);
            if (next.O00000oO != null) {
                builder.setServiceData(next.O00000oO, next.O00000oo, next.O0000O0o);
            }
            arrayList.add(builder.build());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ScanResult O000000o(android.bluetooth.le.ScanResult scanResult) {
        return new ScanResult(scanResult.getDevice(), jau.O000000o(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getRssi(), scanResult.getTimestampNanos());
    }

    public final ArrayList<ScanResult> O000000o(List<android.bluetooth.le.ScanResult> list) {
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        for (android.bluetooth.le.ScanResult O000000o2 : list) {
            arrayList.add(O000000o(O000000o2));
        }
        return arrayList;
    }

    static class O000000o extends jak.O000000o {
        public final ScanCallback O0000OoO;

        /* synthetic */ O000000o(boolean z, boolean z2, List list, no.nordicsemi.android.support.v18.scanner.ScanSettings scanSettings, jat jat, Handler handler, byte b) {
            this(z, z2, list, scanSettings, jat, handler);
        }

        private O000000o(boolean z, boolean z2, List<no.nordicsemi.android.support.v18.scanner.ScanFilter> list, no.nordicsemi.android.support.v18.scanner.ScanSettings scanSettings, jat jat, Handler handler) {
            super(z, z2, list, scanSettings, jat, handler);
            this.O0000OoO = new ScanCallback() {
                /* class _m_j.jam.O000000o.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                public long f1707O000000o;

                public final void onScanResult(final int i, final android.bluetooth.le.ScanResult scanResult) {
                    O000000o.this.O0000O0o.post(new Runnable() {
                        /* class _m_j.jam.O000000o.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            O000000o.this.O000000o(i, ((jam) jak.O000000o()).O000000o(scanResult));
                        }
                    });
                }

                public final void onBatchScanResults(final List<android.bluetooth.le.ScanResult> list) {
                    O000000o.this.O0000O0o.post(new Runnable() {
                        /* class _m_j.jam.O000000o.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (AnonymousClass1.this.f1707O000000o <= (elapsedRealtime - O000000o.this.O00000oO.O00000oO) + 5) {
                                AnonymousClass1.this.f1707O000000o = elapsedRealtime;
                                O000000o.this.O000000o(((jam) jak.O000000o()).O000000o(list));
                            }
                        }
                    });
                }

                public final void onScanFailed(final int i) {
                    O000000o.this.O0000O0o.post(new Runnable() {
                        /* class _m_j.jam.O000000o.AnonymousClass1.AnonymousClass3 */

                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
                        public final void run() {
                            if (!O000000o.this.O00000oO.O0000Oo || O000000o.this.O00000oO.O00000o == 1) {
                                O000000o.this.O000000o(i);
                                return;
                            }
                            O000000o.this.O00000oO.O0000Oo = false;
                            jak O000000o2 = jak.O000000o();
                            O000000o2.O000000o(O000000o.this.O00000oo);
                            try {
                                O000000o2.O000000o(O000000o.this.O00000o, O000000o.this.O00000oO, O000000o.this.O00000oo, O000000o.this.O0000O0o);
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            };
        }
    }
}
