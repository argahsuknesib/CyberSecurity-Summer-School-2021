package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

public abstract class gfl {
    public int O0000oO;

    public abstract void O000000o(BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo);

    public abstract boolean O000000o();

    public abstract void O00000Oo();

    public abstract void O0000O0o();

    public abstract boolean O0000OOo();

    public final void O000000o(final String str, final Response.FirmwareUpgradeResponse firmwareUpgradeResponse) {
        XmPluginHostApi.instance().downloadFirmware(str, new Response.FirmwareUpgradeResponse() {
            /* class _m_j.gfl.AnonymousClass1 */

            public final void onResponse(int i, String str, String str2) {
                if (i == 0 && !TextUtils.isEmpty(str)) {
                    firmwareUpgradeResponse.onResponse(i, str, str2);
                    gfl.this.O0000oO = 0;
                } else if (gfl.this.O0000oO == 2) {
                    firmwareUpgradeResponse.onResponse(i, str, str2);
                    gfl.this.O0000oO = 0;
                } else {
                    gfl.this.O0000oO++;
                    gfl.this.O000000o(str, firmwareUpgradeResponse);
                }
            }

            public final void onProgress(int i) {
                firmwareUpgradeResponse.onProgress(i);
            }
        });
    }
}
