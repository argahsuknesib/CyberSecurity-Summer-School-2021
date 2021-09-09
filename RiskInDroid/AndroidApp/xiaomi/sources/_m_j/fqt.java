package _m_j;

import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Home;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"getHomeAndRoomInfo", "", "Lcom/xiaomi/smarthome/device/Device;", "smarthome-home_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class fqt {
    public static final String O000000o(Device device) {
        if (device == null) {
            return "";
        }
        Home O0000o0 = ggb.O00000Oo().O0000o0(device.did);
        if (O0000o0 != null) {
            String O0000o0O = ggb.O00000Oo().O0000o0O(device.did);
            ggb.O00000Oo();
            CharSequence O000000o2 = ggb.O000000o(O0000o0);
            boolean z = false;
            if (!(O000000o2 == null || O000000o2.length() == 0)) {
                CharSequence charSequence = O0000o0O;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(O0000o0O);
                    sb.append("-");
                    ggb.O00000Oo();
                    sb.append(ggb.O000000o(O0000o0));
                    if (!O0000o0.isOwner()) {
                        sb.append(" ");
                        sb.append("(");
                        sb.append(CommonApplication.getAppContext().getString(R.string.tag_share));
                        sb.append(")");
                    }
                    String sb2 = sb.toString();
                    ixe.O00000Oo(sb2, "with(builder) {\n        append(roomName)\n        append(\"-\")\n        append(HomeManager.getInstance().getSanitizedHomeName(home))\n\n        if (!home.isOwner) {\n            append(\" \")\n            append(\"(\")\n            append(CommonApplication.getAppContext().getString(R.string.tag_share))\n            append(\")\")\n        }\n        toString()\n    }");
                    return sb2;
                }
            }
            return "";
        } else if (!fno.O000000o().O00000o(device)) {
            return "";
        } else {
            String string = CommonApplication.getAppContext().getString(R.string.smarthome_device_device);
            ixe.O00000Oo(string, "getAppContext().getString(R.string.smarthome_device_device)");
            return string;
        }
    }
}
