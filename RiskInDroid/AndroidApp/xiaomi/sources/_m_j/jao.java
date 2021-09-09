package _m_j;

import _m_j.jak;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import java.util.HashMap;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

@TargetApi(26)
public final class jao extends jan {

    /* renamed from: O000000o  reason: collision with root package name */
    public final HashMap<PendingIntent, O000000o> f1711O000000o = new HashMap<>();

    jao() {
    }

    public final O000000o O000000o(PendingIntent pendingIntent) {
        synchronized (this.f1711O000000o) {
            if (!this.f1711O000000o.containsKey(pendingIntent)) {
                return null;
            }
            O000000o o000000o = this.f1711O000000o.get(pendingIntent);
            if (o000000o != null) {
                return o000000o;
            }
            throw new IllegalStateException("Scanning has been stopped");
        }
    }

    /* access modifiers changed from: package-private */
    public final ScanSettings O000000o(BluetoothAdapter bluetoothAdapter, no.nordicsemi.android.support.v18.scanner.ScanSettings scanSettings) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (bluetoothAdapter.isOffloadedScanBatchingSupported() && scanSettings.O0000Oo0) {
            builder.setReportDelay(scanSettings.O00000oO);
        }
        if (scanSettings.O0000Oo) {
            builder.setCallbackType(scanSettings.O00000o).setMatchMode(scanSettings.O00000oo).setNumOfMatches(scanSettings.O0000O0o);
        }
        builder.setScanMode(scanSettings.O00000o0).setLegacy(scanSettings.O0000o00).setPhy(scanSettings.O0000o0);
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public final ScanResult O000000o(android.bluetooth.le.ScanResult scanResult) {
        return new ScanResult(scanResult.getDevice(), ((scanResult.getDataStatus() << 5) | (scanResult.isLegacy() ? 16 : 0)) | scanResult.isConnectable() ? 1 : 0, scanResult.getPrimaryPhy(), scanResult.getSecondaryPhy(), scanResult.getAdvertisingSid(), scanResult.getTxPower(), scanResult.getRssi(), scanResult.getPeriodicAdvertisingInterval(), jau.O000000o(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getTimestampNanos());
    }

    public static class O000000o extends jak.O000000o {
        public final jas O0000OoO = ((jas) this.O00000oo);

        public O000000o(boolean z, boolean z2, List<ScanFilter> list, no.nordicsemi.android.support.v18.scanner.ScanSettings scanSettings, PendingIntent pendingIntent) {
            super(z, z2, list, scanSettings, new jas(pendingIntent, scanSettings), new Handler());
        }
    }
}
