package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction()) && FacebookSdk.isInitialized()) {
            AccessTokenManager.getInstance().currentAccessTokenChanged();
        }
    }
}
