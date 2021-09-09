package miui.bluetooth.ble;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.util.UUID;
import miui.bluetooth.ble.IBluetoothMiBle;
import miui.bluetooth.ble.IBluetoothMiBleCallback;
import miui.bluetooth.ble.IBluetoothMiBlePropertyCallback;

public class MiBleProfile {
    protected IProfileStateChangeCallback mCallback;
    protected final ParcelUuid mClientId;
    public boolean mConnectWhenBind;
    protected Context mContext;
    protected String mDevice;
    public Handler mHandler;
    public int mProfileState;
    private IBluetoothMiBlePropertyCallback mPropertyCallback;
    public SparseArray<IPropertyNotifyCallback> mPropertyCallbacks;
    protected IBluetoothMiBle mService;
    public IBluetoothMiBleCallback mServiceCallback;
    private ServiceConnection mServiceConnection;
    public final IBinder mToken;

    public interface IProfileStateChangeCallback {
        void onState(int i);
    }

    public interface IPropertyNotifyCallback {
        void notifyProperty(int i, byte[] bArr);
    }

    public MiBleProfile(Context context, String str) {
        this(context, str, null);
    }

    public MiBleProfile(Context context, String str, IProfileStateChangeCallback iProfileStateChangeCallback) {
        this.mClientId = new ParcelUuid(UUID.randomUUID());
        this.mToken = new Binder();
        this.mConnectWhenBind = false;
        this.mPropertyCallbacks = new SparseArray<>();
        this.mProfileState = 0;
        this.mServiceConnection = new ServiceConnection() {
            /* class miui.bluetooth.ble.MiBleProfile.AnonymousClass1 */

            public void onServiceDisconnected(ComponentName componentName) {
                MiBleProfile miBleProfile = MiBleProfile.this;
                miBleProfile.mService = null;
                miBleProfile.mProfileState = 0;
                miBleProfile.mHandler.sendMessage(MiBleProfile.this.mHandler.obtainMessage(1, 0, 0));
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("MiBleProfile", "onServiceConnected()");
                MiBleProfile.this.mService = IBluetoothMiBle.Stub.asInterface(iBinder);
                MiBleProfile.this.mHandler.sendMessage(MiBleProfile.this.mHandler.obtainMessage(1, 2, 0));
                try {
                    MiBleProfile.this.mService.registerClient(MiBleProfile.this.mToken, MiBleProfile.this.mDevice, MiBleProfile.this.mClientId, MiBleProfile.this.mServiceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    MiBleProfile.this.mHandler.sendMessage(MiBleProfile.this.mHandler.obtainMessage(1, -1, 0));
                }
                if (MiBleProfile.this.mConnectWhenBind) {
                    MiBleProfile miBleProfile = MiBleProfile.this;
                    miBleProfile.mConnectWhenBind = false;
                    miBleProfile.connect();
                }
            }
        };
        this.mServiceCallback = new IBluetoothMiBleCallback.Stub() {
            /* class miui.bluetooth.ble.MiBleProfile.AnonymousClass2 */

            public void onConnectionState(ParcelUuid parcelUuid, int i) throws RemoteException {
                Log.d("MiBleProfile", "onConnectionState() sate=".concat(String.valueOf(i)));
                if (MiBleProfile.this.mClientId.equals(parcelUuid)) {
                    MiBleProfile miBleProfile = MiBleProfile.this;
                    miBleProfile.mProfileState = i;
                    miBleProfile.mHandler.sendMessage(MiBleProfile.this.mHandler.obtainMessage(1, i, 0));
                }
            }
        };
        this.mPropertyCallback = new IBluetoothMiBlePropertyCallback.Stub() {
            /* class miui.bluetooth.ble.MiBleProfile.AnonymousClass3 */

            public void notifyProperty(ParcelUuid parcelUuid, int i, byte[] bArr) throws RemoteException {
                Log.d("MiBleProfile", "mPropertyCallback() property=".concat(String.valueOf(i)));
                if (MiBleProfile.this.mClientId.equals(parcelUuid)) {
                    Message obtainMessage = MiBleProfile.this.mHandler.obtainMessage(2);
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = bArr;
                    MiBleProfile.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.mDevice = str;
        this.mContext = context;
        this.mCallback = iProfileStateChangeCallback;
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        this.mHandler = new Handler(new Handler.Callback() {
            /* class miui.bluetooth.ble.MiBleProfile.AnonymousClass4 */

            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    if (MiBleProfile.this.mCallback != null) {
                        MiBleProfile.this.mCallback.onState(message.arg1);
                    }
                    return true;
                } else if (i != 2) {
                    return false;
                } else {
                    int i2 = message.arg1;
                    IPropertyNotifyCallback iPropertyNotifyCallback = MiBleProfile.this.mPropertyCallbacks.get(i2);
                    if (iPropertyNotifyCallback != null) {
                        iPropertyNotifyCallback.notifyProperty(i2, (byte[]) message.obj);
                    }
                    return true;
                }
            }
        });
    }

    public int getServiceVersion() {
        IBluetoothMiBle iBluetoothMiBle = this.mService;
        if (iBluetoothMiBle == null) {
            return -1;
        }
        try {
            return iBluetoothMiBle.getServiceVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setProfileStateChangeCallback(IProfileStateChangeCallback iProfileStateChangeCallback) {
        this.mCallback = iProfileStateChangeCallback;
    }

    public String getDeviceAddress() {
        return this.mDevice;
    }

    public void connect() {
        IBluetoothMiBle iBluetoothMiBle = this.mService;
        if (iBluetoothMiBle == null) {
            this.mConnectWhenBind = true;
            Intent intent = new Intent("miui.bluetooth.mible.Service");
            intent.setClassName("com.android.bluetooth", "com.android.bluetooth.ble.BluetoothMiBleService");
            intent.setPackage("com.android.bluetooth");
            if (!this.mContext.bindService(intent, this.mServiceConnection, 1)) {
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(1, -1, 0));
                return;
            }
            return;
        }
        try {
            iBluetoothMiBle.connect(this.mDevice, this.mClientId);
        } catch (RemoteException e) {
            e.printStackTrace();
            Handler handler2 = this.mHandler;
            handler2.sendMessage(handler2.obtainMessage(1, -1, 0));
        }
    }

    public void disconnect() {
        IBluetoothMiBle iBluetoothMiBle = this.mService;
        if (iBluetoothMiBle != null) {
            try {
                iBluetoothMiBle.unregisterClient(this.mToken, this.mDevice, this.mClientId);
                this.mContext.unbindService(this.mServiceConnection);
            } catch (RemoteException e) {
                e.printStackTrace();
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(1, -1, 0));
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                Handler handler2 = this.mHandler;
                handler2.sendMessage(handler2.obtainMessage(1, -1, 0));
            }
        }
    }

    public boolean isReady() {
        return this.mProfileState == 4;
    }

    public boolean isSupportProperty(int i) {
        try {
            return this.mService != null && this.mService.supportProperty(this.mDevice, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] getProperty(int i) {
        IBluetoothMiBle iBluetoothMiBle = this.mService;
        if (iBluetoothMiBle == null) {
            return null;
        }
        try {
            return iBluetoothMiBle.getProperty(this.mDevice, this.mClientId, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean setProperty(int i, byte[] bArr) {
        IBluetoothMiBle iBluetoothMiBle = this.mService;
        if (iBluetoothMiBle == null) {
            return false;
        }
        try {
            return iBluetoothMiBle.setProperty(this.mDevice, this.mClientId, i, bArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    public boolean registerPropertyNotifyCallback(int i, IPropertyNotifyCallback iPropertyNotifyCallback) {
        boolean z;
        this.mPropertyCallbacks.put(i, iPropertyNotifyCallback);
        IBluetoothMiBle iBluetoothMiBle = this.mService;
        if (iBluetoothMiBle != null) {
            try {
                z = iBluetoothMiBle.registerPropertyCallback(this.mDevice, this.mClientId, i, this.mPropertyCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (!z) {
                return true;
            }
            this.mPropertyCallbacks.remove(i);
            return false;
        }
        z = false;
        if (!z) {
        }
    }

    public boolean unregisterPropertyNotifyCallback(int i) {
        this.mPropertyCallbacks.remove(i);
        if (this.mPropertyCallbacks.get(i) != null) {
            return true;
        }
        try {
            if (this.mService != null) {
                return this.mService.unregisterPropertyCallback(this.mDevice, this.mClientId, i, this.mPropertyCallback);
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRssi() {
        if (!isReady()) {
            return Integer.MIN_VALUE;
        }
        try {
            return this.mService.getRssi(this.mDevice, this.mClientId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }
}
