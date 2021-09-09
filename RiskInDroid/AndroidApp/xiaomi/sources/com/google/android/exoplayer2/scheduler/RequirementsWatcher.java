package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class RequirementsWatcher {
    private final Context context;
    public final Handler handler = new Handler(Util.getLooper());
    private final Listener listener;
    public NetworkCallback networkCallback;
    private int notMetRequirements;
    private DeviceStatusChangeReceiver receiver;
    private final Requirements requirements;

    public interface Listener {
        void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i);
    }

    public RequirementsWatcher(Context context2, Listener listener2, Requirements requirements2) {
        this.context = context2.getApplicationContext();
        this.listener = listener2;
        this.requirements = requirements2;
    }

    public final int start() {
        this.notMetRequirements = this.requirements.getNotMetRequirements(this.context);
        IntentFilter intentFilter = new IntentFilter();
        if (this.requirements.isNetworkRequired()) {
            if (Util.SDK_INT >= 24) {
                registerNetworkCallbackV24();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.requirements.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.requirements.isIdleRequired()) {
            if (Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        this.receiver = new DeviceStatusChangeReceiver();
        this.context.registerReceiver(this.receiver, intentFilter, null, this.handler);
        return this.notMetRequirements;
    }

    public final void stop() {
        this.context.unregisterReceiver((BroadcastReceiver) Assertions.checkNotNull(this.receiver));
        this.receiver = null;
        if (Util.SDK_INT >= 24 && this.networkCallback != null) {
            unregisterNetworkCallbackV24();
        }
    }

    public final Requirements getRequirements() {
        return this.requirements;
    }

    private void registerNetworkCallbackV24() {
        this.networkCallback = new NetworkCallback();
        ((ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) this.context.getSystemService("connectivity"))).registerDefaultNetworkCallback(this.networkCallback);
    }

    private void unregisterNetworkCallbackV24() {
        ((ConnectivityManager) this.context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.checkNotNull(this.networkCallback));
        this.networkCallback = null;
    }

    public final void checkRequirements() {
        int notMetRequirements2 = this.requirements.getNotMetRequirements(this.context);
        if (this.notMetRequirements != notMetRequirements2) {
            this.notMetRequirements = notMetRequirements2;
            this.listener.onRequirementsStateChanged(this, notMetRequirements2);
        }
    }

    class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                RequirementsWatcher.this.checkRequirements();
            }
        }
    }

    final class NetworkCallback extends ConnectivityManager.NetworkCallback {
        boolean networkValidated;
        boolean receivedCapabilitiesChange;

        private NetworkCallback() {
        }

        public final void onAvailable(Network network) {
            onNetworkCallback();
        }

        public final void onLost(Network network) {
            onNetworkCallback();
        }

        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (!this.receivedCapabilitiesChange || this.networkValidated != hasCapability) {
                this.receivedCapabilitiesChange = true;
                this.networkValidated = hasCapability;
                onNetworkCallback();
            }
        }

        private void onNetworkCallback() {
            RequirementsWatcher.this.handler.post(new Runnable() {
                /* class com.google.android.exoplayer2.scheduler.$$Lambda$RequirementsWatcher$NetworkCallback$791AAbo2y2AoEG_LWG4fQV9Ibc */

                public final void run() {
                    RequirementsWatcher.NetworkCallback.this.lambda$onNetworkCallback$0$RequirementsWatcher$NetworkCallback();
                }
            });
        }

        public /* synthetic */ void lambda$onNetworkCallback$0$RequirementsWatcher$NetworkCallback() {
            if (RequirementsWatcher.this.networkCallback != null) {
                RequirementsWatcher.this.checkRequirements();
            }
        }
    }
}
