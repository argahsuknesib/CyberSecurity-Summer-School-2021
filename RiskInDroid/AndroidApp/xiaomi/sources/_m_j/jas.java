package _m_j;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

public final class jas extends jat {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f1713O000000o;
    private final PendingIntent O00000Oo;
    private long O00000o;
    private Context O00000o0;
    private long O00000oO;

    jas(PendingIntent pendingIntent, ScanSettings scanSettings) {
        this.O00000Oo = pendingIntent;
        this.O00000oO = scanSettings.O00000oO;
    }

    public jas(PendingIntent pendingIntent, ScanSettings scanSettings, Service service) {
        this.O00000Oo = pendingIntent;
        this.O00000oO = scanSettings.O00000oO;
        this.O00000o0 = service;
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        Context context = this.f1713O000000o;
        if (context == null) {
            context = this.O00000o0;
        }
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", i);
                intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList(Collections.singletonList(scanResult)));
                this.O00000Oo.send(context, 0, intent);
            } catch (PendingIntent.CanceledException unused) {
            }
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        Context context = this.f1713O000000o;
        if (context == null) {
            context = this.O00000o0;
        }
        if (context != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.O00000o <= (elapsedRealtime - this.O00000oO) + 5) {
                this.O00000o = elapsedRealtime;
                try {
                    Intent intent = new Intent();
                    intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1);
                    intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList(list));
                    intent.setExtrasClassLoader(ScanResult.class.getClassLoader());
                    this.O00000Oo.send(context, 0, intent);
                } catch (PendingIntent.CanceledException unused) {
                }
            }
        }
    }

    public final void onScanFailed(int i) {
        Context context = this.f1713O000000o;
        if (context == null) {
            context = this.O00000o0;
        }
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.putExtra("android.bluetooth.le.extra.ERROR_CODE", i);
                this.O00000Oo.send(context, 0, intent);
            } catch (PendingIntent.CanceledException unused) {
            }
        }
    }
}
