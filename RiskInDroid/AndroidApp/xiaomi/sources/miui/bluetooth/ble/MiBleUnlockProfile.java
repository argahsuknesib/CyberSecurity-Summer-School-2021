package miui.bluetooth.ble;

import android.content.Context;
import android.os.RemoteException;
import miui.bluetooth.ble.MiBleProfile;

public class MiBleUnlockProfile extends MiBleProfile {

    public interface OnUnlockStateChangeListener {
        void onUnlocked(byte b);
    }

    public MiBleUnlockProfile(Context context, String str, MiBleProfile.IProfileStateChangeCallback iProfileStateChangeCallback) {
        super(context, str, iProfileStateChangeCallback);
    }

    public boolean setLock(String str) {
        if (!isReady()) {
            return false;
        }
        try {
            return this.mService.authorize(this.mDevice, this.mClientId, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setRssiThreshold(int i) {
        if (!isReady()) {
            return false;
        }
        try {
            return this.mService.setRssiThreshold(this.mDevice, this.mClientId, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unlock() {
        if (!isReady()) {
            return false;
        }
        try {
            return this.mService.authenticate(this.mDevice, this.mClientId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void registerUnlockListener(final OnUnlockStateChangeListener onUnlockStateChangeListener) {
        if (onUnlockStateChangeListener != null) {
            registerPropertyNotifyCallback(1, new MiBleProfile.IPropertyNotifyCallback() {
                /* class miui.bluetooth.ble.MiBleUnlockProfile.AnonymousClass1 */

                public void notifyProperty(int i, byte[] bArr) {
                    if (i == 1) {
                        OnUnlockStateChangeListener onUnlockStateChangeListener = onUnlockStateChangeListener;
                        byte b = 0;
                        if (bArr != null) {
                            b = bArr[0];
                        }
                        onUnlockStateChangeListener.onUnlocked(b);
                    }
                }
            });
        }
    }

    public void unregisterUnlockListener() {
        unregisterPropertyNotifyCallback(1);
    }
}
