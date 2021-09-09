package _m_j;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;

public final class hca {
    public static void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            gsy.O00000Oo("CameraCardDeviceUtil", "controlId isEmpty");
            return;
        }
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            gsy.O00000Oo("CameraCardDeviceUtil", "device == null");
            return;
        }
        hcc gridCard = eyi.getInstance().getGridCard(O000000o2);
        if (gridCard == null) {
            gsy.O00000Oo("CameraCardDeviceUtil", "gridCard == null");
            return;
        }
        ArrayList<Pair> deviceRenderData = eyi.getInstance().getDeviceRenderData(O000000o2, gridCard);
        if (deviceRenderData == null) {
            gsy.O00000Oo("CameraCardDeviceUtil", "data == null");
            return;
        }
        Pair O000000o3 = gzt.O000000o(O000000o2, deviceRenderData);
        if (O000000o3 == null) {
            gsy.O00000Oo("CameraCardDeviceUtil", "deviceControl == null");
        } else {
            O000000o(O000000o2, O000000o3 != null && O000000o3.first == State.SELECTED);
        }
    }

    private static void O000000o(Device device, boolean z) {
        if (z) {
            O000000o(device);
            return;
        }
        try {
            O00000Oo(device);
        } catch (Exception e) {
            O000000o();
            gsy.O000000o(6, "CameraCardDeviceUtil", "exception handle:" + e.getLocalizedMessage());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    private static void O000000o(Device device) {
        DeviceStat O000000o2;
        if (device != null && !TextUtils.isEmpty(device.did) && (O000000o2 = fbr.O000000o(device)) != null) {
            if (!gqd.O000000o(CommonApplication.getAppContext())) {
                hte.O000000o(CommonApplication.getAppContext(), CommonApplication.getAppContext().getResources().getString(R.string.float_tip));
            } else if (O000000o2.isSetPinCode != 0) {
                Bundle bundle = new Bundle();
                bundle.putString("extra_device_did", device.did);
                fbt fbt = new fbt(CommonApplication.getAppContext(), "DevicePinVerifyEnterActivity");
                fbt.O000000o(bundle);
                fbt.O000000o("verfy_pincode_first", true);
                fbt.O000000o("from_system_ui", true);
                fbt.O00000Oo(268468224);
                fbs.O000000o(fbt);
            } else {
                XmPluginHostApi.instance().openCameraFloatingView(device.did);
            }
        }
    }

    private static void O00000Oo(Device device) throws Exception {
        Intent O000000o2 = fbr.O000000o(device, CommonApplication.getAppContext());
        if (O000000o2 != null) {
            O000000o2.addFlags(268468224);
            CommonApplication.getAppContext().startActivity(O000000o2);
        }
    }

    private static void O000000o() {
        try {
            fbt fbt = new fbt(CommonApplication.getAppContext(), "SmartHomeMainActivity");
            fbt.O00000Oo(268468224);
            fbs.O000000o(fbt);
        } catch (Exception e) {
            gsy.O000000o(6, "CameraCardDeviceUtil", "openSmartHome:" + e.getLocalizedMessage());
        }
    }
}
