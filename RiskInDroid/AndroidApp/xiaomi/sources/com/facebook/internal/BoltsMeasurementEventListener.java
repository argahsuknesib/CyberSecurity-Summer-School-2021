package com.facebook.internal;

import _m_j.ft;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    private void open() {
        ft.O000000o(this.applicationContext).O000000o(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void close() {
        ft.O000000o(this.applicationContext).O000000o(this);
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        BoltsMeasurementEventListener boltsMeasurementEventListener = _instance;
        if (boltsMeasurementEventListener != null) {
            return boltsMeasurementEventListener;
        }
        BoltsMeasurementEventListener boltsMeasurementEventListener2 = new BoltsMeasurementEventListener(context);
        _instance = boltsMeasurementEventListener2;
        boltsMeasurementEventListener2.open();
        return _instance;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        String str = "bf_" + intent.getStringExtra("event_name");
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        for (String next : bundleExtra.keySet()) {
            bundle.putString(next.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(next));
        }
        internalAppEventsLogger.logEvent(str, bundle);
    }
}
