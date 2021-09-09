package com.facebook;

import _m_j.ft;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.Validate;

public abstract class ProfileTracker {
    private final ft broadcastManager;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;

    /* access modifiers changed from: protected */
    public abstract void onCurrentProfileChanged(Profile profile, Profile profile2);

    public ProfileTracker() {
        Validate.sdkInitialized();
        this.receiver = new ProfileBroadcastReceiver();
        this.broadcastManager = ft.O000000o(FacebookSdk.getApplicationContext());
        startTracking();
    }

    public void startTracking() {
        if (!this.isTracking) {
            addBroadcastReceiver();
            this.isTracking = true;
        }
    }

    public void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.O000000o(this.receiver);
            this.isTracking = false;
        }
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    class ProfileBroadcastReceiver extends BroadcastReceiver {
        private ProfileBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED".equals(intent.getAction())) {
                ProfileTracker.this.onCurrentProfileChanged((Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE"), (Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE"));
            }
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        this.broadcastManager.O000000o(this.receiver, intentFilter);
    }
}
