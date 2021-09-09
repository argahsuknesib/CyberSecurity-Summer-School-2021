package no.nordicsemi.android.support.v18.scanner;

import _m_j.jak;
import _m_j.jas;
import _m_j.jat;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

public class ScannerService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f15419O000000o = new Object();
    private HashMap<PendingIntent, jat> O00000Oo;
    private Handler O00000o0;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.O00000Oo = new HashMap<>();
        this.O00000o0 = new Handler();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        boolean containsKey;
        jat remove;
        boolean isEmpty;
        boolean isEmpty2;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT");
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_START", false);
        boolean z = !booleanExtra;
        if (pendingIntent == null) {
            synchronized (this.f15419O000000o) {
                isEmpty2 = this.O00000Oo.isEmpty();
            }
            if (isEmpty2) {
                stopSelf();
            }
            return 2;
        }
        synchronized (this.f15419O000000o) {
            containsKey = this.O00000Oo.containsKey(pendingIntent);
        }
        if (booleanExtra && !containsKey) {
            List parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
            ScanSettings scanSettings = (ScanSettings) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = Collections.emptyList();
            }
            if (scanSettings == null) {
                scanSettings = new ScanSettings.O000000o().O000000o();
            }
            jas jas = new jas(pendingIntent, scanSettings, this);
            synchronized (this.f15419O000000o) {
                this.O00000Oo.put(pendingIntent, jas);
            }
            try {
                jak.O000000o().O000000o(parcelableArrayListExtra, scanSettings, jas, this.O00000o0);
            } catch (Exception e) {
                Log.e("ScannerService", "Starting scanning failed", e);
            }
        } else if (z && containsKey) {
            synchronized (this.f15419O000000o) {
                remove = this.O00000Oo.remove(pendingIntent);
                isEmpty = this.O00000Oo.isEmpty();
            }
            if (remove != null) {
                try {
                    jak.O000000o().O000000o(remove);
                } catch (Exception e2) {
                    Log.e("ScannerService", "Stopping scanning failed", e2);
                }
                if (isEmpty) {
                    stopSelf();
                }
            }
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    public void onDestroy() {
        jak O000000o2 = jak.O000000o();
        for (jat O000000o3 : this.O00000Oo.values()) {
            try {
                O000000o2.O000000o(O000000o3);
            } catch (Exception unused) {
            }
        }
        this.O00000Oo.clear();
        this.O00000Oo = null;
        this.O00000o0 = null;
        super.onDestroy();
    }
}
