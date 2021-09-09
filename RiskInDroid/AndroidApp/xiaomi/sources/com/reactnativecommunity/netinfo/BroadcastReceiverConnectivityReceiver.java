package com.reactnativecommunity.netinfo;

import _m_j.ctu;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

public class BroadcastReceiverConnectivityReceiver extends ctu {
    private final O000000o mConnectivityBroadcastReceiver = new O000000o(this, (byte) 0);

    public /* bridge */ /* synthetic */ void getCurrentState(Promise promise) {
        super.getCurrentState(promise);
    }

    public BroadcastReceiverConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getReactContext().registerReceiver(this.mConnectivityBroadcastReceiver, intentFilter);
        this.mConnectivityBroadcastReceiver.f5496O000000o = true;
        updateAndSendConnectionType();
    }

    public void unregister() {
        if (this.mConnectivityBroadcastReceiver.f5496O000000o) {
            getReactContext().unregisterReceiver(this.mConnectivityBroadcastReceiver);
            this.mConnectivityBroadcastReceiver.f5496O000000o = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public void updateAndSendConnectionType() {
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        CellularGeneration cellularGeneration = null;
        boolean z = false;
        try {
            NetworkInfo activeNetworkInfo = getConnectivityManager().getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    z = activeNetworkInfo.isConnected();
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type == 1) {
                            connectionType = ConnectionType.WIFI;
                        } else if (type != 4) {
                            if (type == 9) {
                                connectionType = ConnectionType.ETHERNET;
                            } else if (type == 17) {
                                connectionType = ConnectionType.VPN;
                            } else if (type == 6) {
                                connectionType = ConnectionType.WIMAX;
                            } else if (type == 7) {
                                connectionType = ConnectionType.BLUETOOTH;
                            }
                        }
                        updateConnectivity(connectionType, cellularGeneration, z);
                    }
                    connectionType = ConnectionType.CELLULAR;
                    cellularGeneration = CellularGeneration.fromNetworkInfo(activeNetworkInfo);
                    updateConnectivity(connectionType, cellularGeneration, z);
                }
            }
            connectionType = ConnectionType.NONE;
        } catch (SecurityException unused) {
            connectionType = ConnectionType.UNKNOWN;
        }
        updateConnectivity(connectionType, cellularGeneration, z);
    }

    class O000000o extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f5496O000000o;

        private O000000o() {
            this.f5496O000000o = false;
        }

        /* synthetic */ O000000o(BroadcastReceiverConnectivityReceiver broadcastReceiverConnectivityReceiver, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                BroadcastReceiverConnectivityReceiver.this.updateAndSendConnectionType();
            }
        }
    }
}
