package com.xiaomi.smarthome.core.server.internal.bluetooth;

import _m_j.fec;
import _m_j.ffb;
import _m_j.ffc;
import _m_j.flh;
import _m_j.gnk;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.IntentFilter;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback;
import com.xiaomi.smarthome.core.server.internal.bluetooth.classicbt.BondStateReceiver;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClassicBtService extends IClassicBtRequest.Stub implements ffc.O000000o, BondStateReceiver.O000000o {
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothManager mBluetoothManager;
    private BondStateReceiver mBondStateReceiver;
    private ffc mBtProvider;
    private Context mContext;
    public Map<Integer, BluetoothProfile> mProfileMap;
    private boolean mRegisterReceiver;
    private IClassicBtResponse mResponse;

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final ClassicBtService f6796O000000o = new ClassicBtService();
    }

    private ClassicBtService() {
        this.mResponse = null;
        this.mBondStateReceiver = new BondStateReceiver(this);
        this.mBluetoothManager = null;
        this.mBluetoothAdapter = null;
        this.mBtProvider = null;
        this.mProfileMap = new HashMap();
        this.mRegisterReceiver = false;
        this.mContext = fec.O00000Oo();
    }

    public static ClassicBtService getInstance() {
        return O000000o.f6796O000000o;
    }

    public void setClassicBtResponse(IClassicBtResponse iClassicBtResponse) {
        this.mResponse = iClassicBtResponse;
    }

    public void createClassicBTService() throws RemoteException {
        initBT();
        initBondStateReceiver();
    }

    /* access modifiers changed from: package-private */
    public void initBT() {
        this.mBluetoothManager = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        ffc ffc = this.mBtProvider;
        if (ffc != null) {
            ffc.O000000o();
            this.mBtProvider = null;
        }
        this.mBtProvider = new ffc(this.mBluetoothManager);
        this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
        this.mBtProvider.O0000O0o = this;
    }

    /* access modifiers changed from: package-private */
    public void initBondStateReceiver() {
        if (!this.mRegisterReceiver) {
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            this.mContext.registerReceiver(this.mBondStateReceiver, intentFilter);
            this.mRegisterReceiver = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void checkBondedState(String str) {
        BluetoothDevice remoteDevice;
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && (remoteDevice = bluetoothAdapter.getRemoteDevice(str)) != null) {
            try {
                onBondStateChange(remoteDevice, remoteDevice.getBondState());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean connectClassicBTSocket(String str, String str2) throws RemoteException {
        ffc ffc = this.mBtProvider;
        boolean z = false;
        if (ffc != null) {
            UUID fromString = UUID.fromString(str2);
            if (str == null) {
                ffb.O00000Oo("AbsClassicBTProvider:connection failed: Bluetooth address is null.");
            } else if (str.length() == 0) {
                ffb.O00000Oo("AbsClassicBTProvider:connection failed: Bluetooth address null or empty.");
            } else if (!ffc.O00000o()) {
                ffb.O00000Oo("AbsClassicBTProvider:connection failed: unable to get the adapter to get the device object from BT address.");
            } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
                ffb.O00000Oo("AbsClassicBTProvider:connection failed: unknown BT address.");
            } else {
                BluetoothDevice remoteDevice = ffc.O00000Oo.getRemoteDevice(str);
                if (remoteDevice == null) {
                    ffb.O00000Oo("AbsClassicBTProvider:connection failed: get device from BT address failed.");
                } else if (ffc.O00000oo == 2) {
                    ffb.O00000Oo("AbsClassicBTProvider:connection failed: a device is already connected");
                } else {
                    if (!(remoteDevice.getType() == 1 || remoteDevice.getType() == 3)) {
                        ffb.O00000Oo("AbsClassicBTProvider:connection failed: the device is not BR/EDR compatible.");
                    }
                    if (!ffc.O00000o()) {
                        ffb.O00000Oo("AbsClassicBTProvider:connection failed: Bluetooth is not available.");
                    } else if (!BluetoothAdapter.checkBluetoothAddress(remoteDevice.getAddress())) {
                        ffb.O00000Oo("AbsClassicBTProvider:connection failed: device address not found in list of devices known by the system.");
                    } else if (fromString == null) {
                        ffb.O00000Oo("AbsClassicBTProvider:connection failed: device bonded and no compatible UUID available.");
                    } else if (ffc.O00000oo != 2 || ffc.O00000o == null) {
                        ffc.O00000Oo();
                        ffc.O00000o0();
                        ffc.O00000Oo(1);
                        BluetoothSocket O000000o2 = ffb.O000000o(remoteDevice, fromString);
                        if (O000000o2 == null) {
                            ffb.O00000Oo("AbsClassicBTProvider:connection failed: creation of a Bluetooth socket failed.");
                        } else {
                            ffc.O00000oO = fromString;
                            ffc.f16208O000000o = remoteDevice;
                            ffc.O00000o0 = new ffb.O00000Oo(ffc, O000000o2, (byte) 0);
                            ffc.O00000o0.start();
                            z = true;
                        }
                    } else {
                        ffb.O00000Oo("AbsClassicBTProvider:connection failed: Provider is already connected to a device with an active communication.");
                    }
                }
            }
            checkBondedState(str);
            return z;
        }
        warn("ClassBtProvider is null!!!");
        return false;
    }

    public void disconnectClassicBtSocket() throws RemoteException {
        ffc ffc = this.mBtProvider;
        if (ffc == null) {
            warn("disconnect socket ,but bt provider is null");
        } else {
            ffc.O000000o();
        }
    }

    public boolean write(byte[] bArr) throws RemoteException {
        ffc ffc = this.mBtProvider;
        if (ffc != null) {
            return ffc.O000000o(bArr);
        }
        return false;
    }

    public void prepareBluetoothProfile(int i, final IProfileProxyPrepareCallback iProfileProxyPrepareCallback) throws RemoteException {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            warn("mBluetoothAdapter is null");
        } else {
            bluetoothAdapter.getProfileProxy(this.mContext, new BluetoothProfile.ServiceListener() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.ClassicBtService.AnonymousClass1 */

                public final void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                    ClassicBtService.this.mProfileMap.put(Integer.valueOf(i), bluetoothProfile);
                    IProfileProxyPrepareCallback iProfileProxyPrepareCallback = iProfileProxyPrepareCallback;
                    if (iProfileProxyPrepareCallback != null) {
                        try {
                            iProfileProxyPrepareCallback.onServiceConnected(i);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void onServiceDisconnected(int i) {
                    ClassicBtService.this.mProfileMap.remove(Integer.valueOf(i));
                    IProfileProxyPrepareCallback iProfileProxyPrepareCallback = iProfileProxyPrepareCallback;
                    if (iProfileProxyPrepareCallback != null) {
                        try {
                            iProfileProxyPrepareCallback.onServiceDisconnected(i);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, i);
        }
    }

    public boolean connectBluetoothProfile(String str, int i) throws RemoteException {
        if (this.mBluetoothAdapter == null) {
            warn("mBluetoothAdapter is null");
            return false;
        } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            error(str + " is not a valid Bluetooth address");
            return false;
        } else {
            BluetoothProfile bluetoothProfile = this.mProfileMap.get(Integer.valueOf(i));
            if (bluetoothProfile != null) {
                return flh.O000000o(this.mBluetoothAdapter.getRemoteDevice(str), bluetoothProfile);
            }
            warn(" connectBluetoothProfile ,but profile is null");
            return false;
        }
    }

    public boolean disconnectBluetoothProfile(String str, int i) throws RemoteException {
        if (this.mBluetoothAdapter == null) {
            warn("mBluetoothAdapter is null");
            return false;
        } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            error(str + " is not a valid Bluetooth address");
            return false;
        } else {
            BluetoothProfile bluetoothProfile = this.mProfileMap.get(Integer.valueOf(i));
            if (bluetoothProfile != null) {
                return flh.O00000Oo(this.mBluetoothAdapter.getRemoteDevice(str), bluetoothProfile);
            }
            warn("disconnectBluetoothProfile , but profile is null,profile is ".concat(String.valueOf(i)));
            return false;
        }
    }

    public int getBluetoothProfileState(String str, int i) throws RemoteException {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            warn("getBluetoothProfileState fail ,address invalid,address is " + str + ",profile is " + i);
            return 0;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            warn("getBluetoothProfileState fail ,device is null,address is " + str + ",profile is " + i);
            return 0;
        }
        BluetoothProfile bluetoothProfile = this.mProfileMap.get(Integer.valueOf(i));
        if (bluetoothProfile != null) {
            return bluetoothProfile.getConnectionState(remoteDevice);
        }
        warn("getBluetoothProfileState fail , because proxy is null,address is " + str + ",profile is " + i);
        return 0;
    }

    public void destroy() throws RemoteException {
        BondStateReceiver bondStateReceiver = this.mBondStateReceiver;
        if (bondStateReceiver != null && this.mRegisterReceiver) {
            this.mContext.unregisterReceiver(bondStateReceiver);
            this.mRegisterReceiver = false;
        }
        ffc ffc = this.mBtProvider;
        if (ffc != null) {
            ffc.O000000o();
        }
        this.mResponse = null;
    }

    public void onBondStateChange(BluetoothDevice bluetoothDevice, int i) throws RemoteException {
        if (bluetoothDevice == null) {
            warn("onBondStateChange device is null");
        } else if (this.mResponse != null) {
            log("onBondStateChange ,mac address=" + bluetoothDevice.getAddress() + ", state =" + i);
            this.mResponse.onBondStateChange(bluetoothDevice.getAddress(), i);
        } else {
            warn("onBondStateChange response is null");
        }
    }

    public void onConnectionStateChanged(String str, int i) throws RemoteException {
        if (this.mResponse != null) {
            log("onConnectionStateChanged macAddress =" + str + ", state =" + i);
            this.mResponse.onConnectionStateChanged(str, i);
            return;
        }
        warn("onConnectionStateChanged response is null");
    }

    public void onReceiveData(String str, byte[] bArr) throws RemoteException {
        if (bArr == null || bArr.length <= 0) {
            warn("onReceiveData data is empty");
        } else if (this.mResponse != null) {
            log("onReceiveData address =" + str + ",data str =" + new String(bArr));
            this.mResponse.onReceiveData(str, bArr);
        } else {
            warn("onReceiveData response is null");
        }
    }

    public static void log(String str) {
        gnk.O00000o("classic-bluetooth::".concat(String.valueOf(str)));
    }

    public static void warn(String str) {
        gnk.O00000oO("classic-bluetooth::".concat(String.valueOf(str)));
    }

    public static void error(String str) {
        gnk.O00000Oo("classic-bluetooth::".concat(String.valueOf(str)));
    }
}
