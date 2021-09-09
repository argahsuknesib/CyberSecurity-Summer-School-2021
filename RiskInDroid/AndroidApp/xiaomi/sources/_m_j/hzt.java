package _m_j;

import _m_j.fno;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.IEngineSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public abstract class hzt implements IEngineSpecificKeyRetriever {
    /* access modifiers changed from: protected */
    public abstract void O00000Oo(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener, boolean z);

    public void startRetrieveSpecificKey(final UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, final boolean z) {
        UwbLogUtil.d("Mijia-UWB-HomeDeviceAwareSpecificKeyRetriever", "start retrieve key: useCache=".concat(String.valueOf(z)));
        AnonymousClass1 r0 = new BroadcastReceiver() {
            /* class _m_j.hzt.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                ft.O000000o(UwbSdk.getApplication()).O000000o(this);
                hzt.this.O000000o(uwbScanDevice, keyRetrieverListener, z);
            }
        };
        ft.O000000o(UwbSdk.getApplication()).O000000o(r0, new IntentFilter("home_room_sync"));
        if (ggb.O00000Oo().O0000OoO.O00000oo) {
            ft.O000000o(UwbSdk.getApplication()).O000000o(r0);
            O000000o(uwbScanDevice, keyRetrieverListener, z);
            return;
        }
        ggb.O00000Oo().O00000o0();
    }

    public final void O000000o(final UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, final boolean z) {
        UwbLogUtil.d("Mijia-UWB-HomeDeviceAwareSpecificKeyRetriever", "handleKeyRetrieve: useCache=".concat(String.valueOf(z)));
        AnonymousClass2 r0 = new fno.O000000o() {
            /* class _m_j.hzt.AnonymousClass2 */

            public final void onRefreshClientDeviceChanged(int i, Device device) {
            }

            public final void onRefreshClientDeviceSuccess(int i) {
                fno.O000000o().O00000Oo(this);
                hzt.this.O00000Oo(uwbScanDevice, keyRetrieverListener, z);
            }
        };
        fno.O000000o().O000000o(r0);
        if (fno.O000000o().O0000o00()) {
            fno.O000000o().O00000Oo(r0);
            O00000Oo(uwbScanDevice, keyRetrieverListener, z);
            return;
        }
        fno.O000000o().O0000o0O();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hzq.O000000o(com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, boolean):java.lang.String
     arg types: [com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, int]
     candidates:
      _m_j.hzq.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>):void
      _m_j.hzq.O000000o(java.lang.String, java.lang.String):boolean
      _m_j.hzq.O000000o(com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, boolean):java.lang.String */
    public static boolean O000000o(UwbScanDevice uwbScanDevice) {
        String accountInfo = uwbScanDevice.getAccountInfo();
        UwbLogUtil.d("Mijia-UWB-HomeDeviceAwareSpecificKeyRetriever", "isStranger hashAccount=".concat(String.valueOf(accountInfo)));
        if (accountInfo.equalsIgnoreCase(UwbDeviceUtil.getUwbHashFirst3B(CoreApi.O000000o().O0000o0()))) {
            return false;
        }
        if (UwbDeviceUtil.isTagDeviceType(uwbScanDevice.getDeviceType())) {
            if (TextUtils.isEmpty(hzq.O00000oo(uwbScanDevice))) {
                String O000000o2 = hzq.O000000o(uwbScanDevice, true);
                if (TextUtils.isEmpty(O000000o2)) {
                    return true;
                }
                UwbLogUtil.d("Mijia-UWB-HomeDeviceAwareSpecificKeyRetriever", "isStranger return as home share case did=" + uwbScanDevice.getDid() + ",homeid=" + O000000o2);
                return false;
            }
        } else if (!UwbDeviceUtil.isBuiltinDeviceType(uwbScanDevice.getDeviceType()) || !TextUtils.isEmpty(hzq.O00000o0(uwbScanDevice.getDidInfo().getDid()))) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    public static String O00000Oo(UwbScanDevice uwbScanDevice) {
        if (O000000o(uwbScanDevice)) {
            return "1-" + UwbDeviceUtil.getUwbDeviceID(uwbScanDevice) + "-" + CoreApi.O000000o().O0000o0();
        }
        return "0-" + UwbDeviceUtil.getUwbDeviceID(uwbScanDevice);
    }
}
