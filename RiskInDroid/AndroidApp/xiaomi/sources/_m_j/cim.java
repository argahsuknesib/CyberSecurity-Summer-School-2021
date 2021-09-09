package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;

public final class cim {
    public static boolean O000000o() {
        if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
    }
}
