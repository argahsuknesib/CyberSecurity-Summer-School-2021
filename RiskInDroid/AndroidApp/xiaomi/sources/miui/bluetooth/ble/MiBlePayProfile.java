package miui.bluetooth.ble;

import android.content.Context;
import android.os.RemoteException;
import java.nio.ByteBuffer;
import miui.bluetooth.ble.MiBleProfile;

public class MiBlePayProfile extends MiBleProfile {

    public interface OnRSSIChangedListerner {
        void onRssi(int i);
    }

    public MiBlePayProfile(Context context, String str, MiBleProfile.IProfileStateChangeCallback iProfileStateChangeCallback) {
        super(context, str, iProfileStateChangeCallback);
    }

    public boolean setEncryptionKey(byte[] bArr) {
        if (!isReady()) {
            return false;
        }
        try {
            return this.mService.setEncryptionKey(this.mDevice, this.mClientId, bArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] encrypt(byte[] bArr) {
        if (!isReady()) {
            return null;
        }
        try {
            return this.mService.encrypt(this.mDevice, this.mClientId, bArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registerRssiChangedListener(final OnRSSIChangedListerner onRSSIChangedListerner) {
        if (onRSSIChangedListerner != null) {
            registerPropertyNotifyCallback(4, new MiBleProfile.IPropertyNotifyCallback() {
                /* class miui.bluetooth.ble.MiBlePayProfile.AnonymousClass1 */

                public void notifyProperty(int i, byte[] bArr) {
                    if (i == 4 && bArr != null && bArr.length == 4) {
                        onRSSIChangedListerner.onRssi(ByteBuffer.wrap(bArr).getInt());
                    }
                }
            });
        }
    }

    public void unregisterRssiChangedListener() {
        unregisterPropertyNotifyCallback(4);
    }
}
