package _m_j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.reactnativecommunity.netinfo.NetInfoUtils;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;

public abstract class ctu {
    private CellularGeneration mCellularGeneration = null;
    private ConnectionType mConnectionType = ConnectionType.UNKNOWN;
    private final ConnectivityManager mConnectivityManager;
    private boolean mIsInternetReachable = false;
    private final ReactApplicationContext mReactContext;
    private final TelephonyManager mTelephonyManager;
    private final WifiManager mWifiManager;

    public abstract void register();

    public abstract void unregister();

    protected ctu(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        this.mConnectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.mWifiManager = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) reactApplicationContext.getSystemService("phone");
    }

    public void getCurrentState(Promise promise) {
        promise.resolve(createConnectivityEventMap());
    }

    /* access modifiers changed from: protected */
    public ReactApplicationContext getReactContext() {
        return this.mReactContext;
    }

    /* access modifiers changed from: protected */
    public ConnectivityManager getConnectivityManager() {
        return this.mConnectivityManager;
    }

    /* access modifiers changed from: protected */
    public void updateConnectivity(ConnectionType connectionType, CellularGeneration cellularGeneration, boolean z) {
        boolean z2 = true;
        boolean z3 = connectionType != this.mConnectionType;
        boolean z4 = cellularGeneration != this.mCellularGeneration;
        if (z == this.mIsInternetReachable) {
            z2 = false;
        }
        if (z3 || z4 || z2) {
            this.mConnectionType = connectionType;
            this.mCellularGeneration = cellularGeneration;
            this.mIsInternetReachable = z;
            sendConnectivityChangedEvent();
        }
    }

    private void sendConnectivityChangedEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", createConnectivityEventMap());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:29|30|(1:34)|35|36|37|38|39|40) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00dd */
    private WritableMap createConnectivityEventMap() {
        boolean z;
        WifiInfo connectionInfo;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("type", this.mConnectionType.label);
        boolean z2 = !this.mConnectionType.equals(ConnectionType.NONE) && !this.mConnectionType.equals(ConnectionType.UNKNOWN);
        writableNativeMap.putBoolean("isConnected", z2);
        writableNativeMap.putBoolean("isInternetReachable", this.mIsInternetReachable);
        WritableNativeMap writableNativeMap2 = null;
        if (z2) {
            writableNativeMap2 = new WritableNativeMap();
            ConnectivityManager connectivityManager = getConnectivityManager();
            if (Build.VERSION.SDK_INT >= 16) {
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    switch (activeNetworkInfo.getType()) {
                        case 1:
                        case 7:
                        case 9:
                            z = false;
                            break;
                    }
                }
                z = true;
            }
            writableNativeMap2.putBoolean("isConnectionExpensive", z);
            if (this.mConnectionType.equals(ConnectionType.CELLULAR)) {
                CellularGeneration cellularGeneration = this.mCellularGeneration;
                if (cellularGeneration != null) {
                    writableNativeMap2.putString("cellularGeneration", cellularGeneration.label);
                }
                String networkOperatorName = this.mTelephonyManager.getNetworkOperatorName();
                if (networkOperatorName != null) {
                    writableNativeMap2.putString("carrier", networkOperatorName);
                }
            } else if (this.mConnectionType.equals(ConnectionType.WIFI) && (connectionInfo = this.mWifiManager.getConnectionInfo()) != null) {
                String ssid = connectionInfo.getSSID();
                if (ssid != null && !ssid.contains("<unknown ssid>")) {
                    writableNativeMap2.putString("ssid", ssid.replace(jdn.f1779O000000o, ""));
                }
                writableNativeMap2.putInt("strength", WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100));
                byte[] byteArray = BigInteger.valueOf((long) connectionInfo.getIpAddress()).toByteArray();
                NetInfoUtils.reverseByteArray(byteArray);
                writableNativeMap2.putString("ipAddress", InetAddress.getByAddress(byteArray).getHostAddress());
                byte[] byteArray2 = BigInteger.valueOf((long) connectionInfo.getIpAddress()).toByteArray();
                NetInfoUtils.reverseByteArray(byteArray2);
                int networkPrefixLength = -1 << (32 - NetworkInterface.getByInetAddress(InetAddress.getByAddress(byteArray2)).getInterfaceAddresses().get(1).getNetworkPrefixLength());
                writableNativeMap2.putString("subnet", String.format("%d.%d.%d.%d", Integer.valueOf((networkPrefixLength >> 24) & 255), Integer.valueOf((networkPrefixLength >> 16) & 255), Integer.valueOf((networkPrefixLength >> 8) & 255), Integer.valueOf(networkPrefixLength & 255)));
            }
        }
        writableNativeMap.putMap("details", writableNativeMap2);
        return writableNativeMap;
    }
}
