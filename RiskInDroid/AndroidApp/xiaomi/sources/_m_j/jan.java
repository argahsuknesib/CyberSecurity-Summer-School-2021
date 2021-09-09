package _m_j;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanSettings;

@TargetApi(23)
class jan extends jam {
    jan() {
    }

    /* access modifiers changed from: package-private */
    public ScanSettings O000000o(BluetoothAdapter bluetoothAdapter, no.nordicsemi.android.support.v18.scanner.ScanSettings scanSettings) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (bluetoothAdapter.isOffloadedScanBatchingSupported() && scanSettings.O0000Oo0) {
            builder.setReportDelay(scanSettings.O00000oO);
        }
        if (scanSettings.O0000Oo) {
            builder.setCallbackType(scanSettings.O00000o).setMatchMode(scanSettings.O00000oo).setNumOfMatches(scanSettings.O0000O0o);
        }
        builder.setScanMode(scanSettings.O00000o0);
        return builder.build();
    }
}
