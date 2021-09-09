package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsLogger;

public final class CampaignTrackingReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra != null && stringExtra.startsWith("fb")) {
            AppEventsLogger.setInstallReferrer(intent.getStringExtra("referrer"));
        }
    }
}
