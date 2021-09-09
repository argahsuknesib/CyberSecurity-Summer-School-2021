package _m_j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

@TargetApi(24)
public final class ctv extends ctu {

    /* renamed from: O000000o  reason: collision with root package name */
    public Network f14351O000000o = null;
    public NetworkCapabilities O00000Oo = null;
    private final O000000o O00000o0 = new O000000o(this, (byte) 0);

    public ctv(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final void register() {
        try {
            getConnectivityManager().registerDefaultNetworkCallback(this.O00000o0);
        } catch (SecurityException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void unregister() {
        try {
            getConnectivityManager().unregisterNetworkCallback(this.O00000o0);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void O000000o() {
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        NetworkCapabilities networkCapabilities = this.O00000Oo;
        boolean z = false;
        CellularGeneration cellularGeneration = null;
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(2)) {
                connectionType = ConnectionType.BLUETOOTH;
            } else if (this.O00000Oo.hasTransport(0)) {
                connectionType = ConnectionType.CELLULAR;
            } else if (this.O00000Oo.hasTransport(3)) {
                connectionType = ConnectionType.ETHERNET;
            } else if (this.O00000Oo.hasTransport(1)) {
                connectionType = ConnectionType.WIFI;
            } else if (this.O00000Oo.hasTransport(4)) {
                connectionType = ConnectionType.VPN;
            }
            if (this.O00000Oo.hasCapability(12) && this.O00000Oo.hasCapability(16)) {
                z = true;
            }
            if (this.f14351O000000o != null && connectionType == ConnectionType.CELLULAR) {
                cellularGeneration = CellularGeneration.fromNetworkInfo(getConnectivityManager().getNetworkInfo(this.f14351O000000o));
            }
        } else {
            connectionType = ConnectionType.NONE;
        }
        updateConnectivity(connectionType, cellularGeneration, z);
    }

    class O000000o extends ConnectivityManager.NetworkCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(ctv ctv, byte b) {
            this();
        }

        public final void onAvailable(Network network) {
            ctv ctv = ctv.this;
            ctv.f14351O000000o = network;
            ctv.O00000Oo = ctv.getConnectivityManager().getNetworkCapabilities(network);
            ctv.this.O000000o();
        }

        public final void onLosing(Network network, int i) {
            ctv ctv = ctv.this;
            ctv.f14351O000000o = network;
            ctv.O00000Oo = ctv.getConnectivityManager().getNetworkCapabilities(network);
            ctv.this.O000000o();
        }

        public final void onLost(Network network) {
            ctv ctv = ctv.this;
            ctv.f14351O000000o = null;
            ctv.O00000Oo = null;
            ctv.O000000o();
        }

        public final void onUnavailable() {
            ctv ctv = ctv.this;
            ctv.f14351O000000o = null;
            ctv.O00000Oo = null;
            ctv.O000000o();
        }

        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            ctv ctv = ctv.this;
            ctv.f14351O000000o = network;
            ctv.O00000Oo = networkCapabilities;
            ctv.O000000o();
        }

        public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            ctv ctv = ctv.this;
            ctv.f14351O000000o = network;
            ctv.O00000Oo = ctv.getConnectivityManager().getNetworkCapabilities(network);
            ctv.this.O000000o();
        }
    }
}
