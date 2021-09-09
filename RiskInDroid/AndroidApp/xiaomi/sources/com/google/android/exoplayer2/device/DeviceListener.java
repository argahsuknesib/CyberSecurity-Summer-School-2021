package com.google.android.exoplayer2.device;

public interface DeviceListener {

    /* renamed from: com.google.android.exoplayer2.device.DeviceListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDeviceInfoChanged(DeviceListener deviceListener, DeviceInfo deviceInfo) {
        }

        public static void $default$onDeviceVolumeChanged(DeviceListener deviceListener, int i, boolean z) {
        }
    }

    void onDeviceInfoChanged(DeviceInfo deviceInfo);

    void onDeviceVolumeChanged(int i, boolean z);
}
