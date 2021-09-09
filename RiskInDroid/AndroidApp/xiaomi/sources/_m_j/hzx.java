package _m_j;

import _m_j.ddt;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.keyretriever.MitvStrangerSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public final class hzx extends MitvStrangerSpecificKeyRetriever {
    public hzx(String str) {
        this.uid = str;
    }

    public final void clearCacheKey(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-MitvStrangerKeyRetriever", "stranger clearCacheKey");
        UwbDeviceUtil.saveUwbDeviceKey("", O000000o(this.tvKey));
        ddt.O0000O0o.O000000o();
    }

    public final void startKeyRetrieve() {
        if (this.useCache) {
            UwbLogUtil.w("stranger", "UwbLogUtilPlus startKeyRetrieve useCache");
            String uwbDeviceKey = UwbDeviceUtil.getUwbDeviceKey(O000000o(this.tvKey));
            if (TextUtils.isEmpty(uwbDeviceKey)) {
                this.keyRetrieverListener.onError(-1020, "there is no cached stranger spec key");
            } else {
                this.keyRetrieverListener.onSuccess(uwbDeviceKey, 1, this.uid);
            }
            release();
            return;
        }
        UwbLogUtil.w("stranger", "UwbLogUtilPlus startSecurityCodeActivity");
        UwbDeviceUtil.saveUwbDeviceKey("", O000000o(this.tvKey));
        onStartKeyRetrieve(this.uid, this.tvKey);
        release();
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "1-" + str + "-" + CoreApi.O000000o().O0000o0();
    }
}
