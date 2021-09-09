package miui.bluetooth.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;
import java.util.UUID;
import miui.bluetooth.ble.IMiBleDeviceManager;
import miui.bluetooth.ble.IScanDeviceCallback;

public class MiBleDeviceManager {
    private ParcelUuid mClientId;
    private Context mContext;
    public MiBleDeviceManagerListener mListener;
    private IMiBleDeviceManager mService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        /* class miui.bluetooth.ble.MiBleDeviceManager.AnonymousClass1 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MiBleDeviceManager.this.setServie(IMiBleDeviceManager.Stub.asInterface(iBinder));
            if (MiBleDeviceManager.this.mListener != null) {
                MiBleDeviceManager.this.mListener.onInit(MiBleDeviceManager.this);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            MiBleDeviceManager.this.setServie(null);
            if (MiBleDeviceManager.this.mListener != null) {
                MiBleDeviceManager.this.mListener.onDestroy();
            }
        }
    };
    private IBinder mToken;

    public interface MiBleDeviceManagerListener {
        void onDestroy();

        void onInit(MiBleDeviceManager miBleDeviceManager);
    }

    private MiBleDeviceManager(Context context, MiBleDeviceManagerListener miBleDeviceManagerListener) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("context not valid");
        }
        this.mClientId = new ParcelUuid(UUID.randomUUID());
        this.mToken = new Binder();
        this.mContext = context.getApplicationContext();
        this.mListener = miBleDeviceManagerListener;
    }

    public void setServie(IMiBleDeviceManager iMiBleDeviceManager) {
        this.mService = iMiBleDeviceManager;
    }

    public static MiBleDeviceManager createManager(Context context, MiBleDeviceManagerListener miBleDeviceManagerListener) {
        MiBleDeviceManager miBleDeviceManager = new MiBleDeviceManager(context, miBleDeviceManagerListener);
        miBleDeviceManager.init();
        return miBleDeviceManager;
    }

    private void init() {
        Intent intent = new Intent("miui.bluetooth.mible.DeviceManagerService");
        intent.setComponent(new ComponentName("com.android.bluetooth", "com.android.bluetooth.ble.app.MiBleDeviceManagerService"));
        if (!this.mContext.bindService(intent, this.mServiceConnection, 1)) {
            Log.e("MiBleDeviceManager", "bind manager service error: ".concat(String.valueOf(intent)));
            if (this.mListener != null) {
                new Handler().post(new Runnable() {
                    /* class miui.bluetooth.ble.MiBleDeviceManager.AnonymousClass2 */

                    public void run() {
                        MiBleDeviceManager.this.mListener.onDestroy();
                    }
                });
            }
        }
    }

    public void close() {
        try {
            this.mContext.unbindService(this.mServiceConnection);
        } catch (Exception e) {
            Log.e("MiBleDeviceManager", "Close manager service error", e);
        }
    }

    private boolean checkReady() {
        if (this.mService != null) {
            return true;
        }
        Log.w("MiBleDeviceManager", "Manager is not ready");
        return false;
    }

    public int getServiceVersion() {
        if (!checkReady()) {
            return -1;
        }
        try {
            return this.mService.getServiceVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<String> getBoundDevices() {
        if (!checkReady()) {
            return null;
        }
        try {
            return this.mService.getBoundDevices();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean setSettings(String str, String str2, boolean z) {
        if (checkReady()) {
            try {
                return this.mService.setSettingInteger(str, str2, z ? 1 : 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean setSettings(String str, String str2, int i) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.setSettingInteger(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setSettings(String str, String str2, String str3) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.setSettingString(str, str2, str3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getSettingsBoolean(String str, String str2) {
        if (checkReady()) {
            try {
                if (this.mService.getSettingInteger(str, str2) != 0) {
                    return true;
                }
                return false;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int getSettingsInteger(String str, String str2) {
        if (!checkReady()) {
            return 0;
        }
        try {
            return this.mService.getSettingInteger(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getSettingsString(String str, String str2) {
        if (!checkReady()) {
            return null;
        }
        try {
            return this.mService.getSettingString(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean bindDevice(String str) {
        if (checkReady()) {
            try {
                return this.mService.setSettingInteger(str, "device_type", 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean bindDevice(String str, byte[] bArr) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.setToken(str, bArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unbindDevice(String str) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.deleteSettings(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getDeviceType(String str) {
        if (!checkReady()) {
            return 0;
        }
        try {
            return this.mService.getDeviceType(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ScanResult getScanResult(String str) {
        if (!checkReady()) {
            return null;
        }
        try {
            return this.mService.getScanResult(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean startScanDevice(final int i, final BluetoothAdapter.LeScanCallback leScanCallback) {
        if (!checkReady()) {
            return false;
        }
        try {
            this.mService.startScanDevice(this.mToken, this.mClientId, i, new IScanDeviceCallback.Stub() {
                /* class miui.bluetooth.ble.MiBleDeviceManager.AnonymousClass3 */

                public void onScanDevice(int i, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) throws RemoteException {
                    if (i == i) {
                        leScanCallback.onLeScan(bluetoothDevice, i2, bArr);
                    }
                }
            });
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void stopScanDevice() {
        if (checkReady()) {
            try {
                this.mService.stopScanDevice(this.mClientId);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean registerAppForBleEvent(String str, int i) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.setSettingString(str, getSettingKeyForEvent(i), this.mContext.getPackageName());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unregisterAppForBleEvent(String str, int i) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.setSettingString(str, getSettingKeyForEvent(i), null);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getRegisterAppForBleEvent(String str, int i) {
        if (!checkReady()) {
            return null;
        }
        try {
            return this.mService.getRegisterAppForBleEvent(str, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean registerBleEventListener(String str, int i, IBleEventCallback iBleEventCallback) {
        if (iBleEventCallback != null && checkReady()) {
            try {
                return this.mService.registerBleEventListener(str, i, iBleEventCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean unregisterBleEventListener(String str, int i, IBleEventCallback iBleEventCallback) {
        if (!checkReady()) {
            return false;
        }
        try {
            return this.mService.unregisterBleEventListener(str, i, iBleEventCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getSettingKeyForEvent(int i) {
        return String.format("miui_ble_event_%d", Integer.valueOf(i));
    }
}
