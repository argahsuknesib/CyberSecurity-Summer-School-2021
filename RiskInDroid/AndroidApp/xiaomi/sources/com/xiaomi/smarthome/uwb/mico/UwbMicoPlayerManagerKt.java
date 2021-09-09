package com.xiaomi.smarthome.uwb.mico;

import _m_j.ixe;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import com.xiaomi.miplay.audioclient.sdk.MiPlayClient;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"(\u0010\r\u001a\u00020\u0001*\u00020\t2\u0006\u0010\f\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"MiPlayVolume", "", "getMiPlayVolume", "()I", "setMiPlayVolume", "(I)V", "TAG", "", "RelayType", "Lcom/xiaomi/miplay/audioclient/MiPlayDevice;", "getRelayType", "(Lcom/xiaomi/miplay/audioclient/MiPlayDevice;)I", "value", "volume", "getVolume", "setVolume", "(Lcom/xiaomi/miplay/audioclient/MiPlayDevice;I)V", "uwb-mico_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoPlayerManagerKt {
    private static int MiPlayVolume;

    public static final int getRelayType(MiPlayDevice miPlayDevice) {
        DidInfo didInfo;
        ixe.O00000o(miPlayDevice, "<this>");
        UwbScanDevice mUwbScanDevice = UwbMicoPlayerManager.INSTANCE.getMUwbScanDevice();
        Boolean bool = null;
        String did = (mUwbScanDevice == null || (didInfo = mUwbScanDevice.getDidInfo()) == null) ? null : didInfo.getDid();
        MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
        if (UwbDeviceUtil.isUwbHashEnd(did, value == null ? null : value.O0000O0o)) {
            if (miPlayDevice.O0000o0 == 1) {
                return 2;
            }
            MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
            if (mMiPlayClient != null) {
                bool = Boolean.valueOf(mMiPlayClient.f6040O000000o.O000000o());
            }
            if (ixe.O000000o(bool, Boolean.TRUE)) {
                return 1;
            }
        }
        return 0;
    }

    public static final int getMiPlayVolume() {
        return MiPlayVolume;
    }

    public static final void setMiPlayVolume(int i) {
        MiPlayVolume = i;
    }

    public static final int getVolume(MiPlayDevice miPlayDevice) {
        ixe.O00000o(miPlayDevice, "<this>");
        return MiPlayVolume;
    }

    public static final void setVolume(MiPlayDevice miPlayDevice, int i) {
        ixe.O00000o(miPlayDevice, "<this>");
        MiPlayVolume = i;
    }
}
