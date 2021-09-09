package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Home;

public final class fwl {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17315O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;
    String O00000oO;
    String O00000oo;
    public String O0000O0o;
    public boolean O0000OOo;

    public fwl(Device device) {
        String str;
        this.f17315O000000o = device.did;
        this.O0000O0o = device.model;
        this.O00000Oo = fml.O00000o0(device.model);
        this.O00000o0 = device.name;
        Home O0000o0 = ggb.O00000Oo().O0000o0(this.f17315O000000o);
        if (O0000o0 != null) {
            ggb.O00000Oo();
            str = ggb.O000000o(O0000o0);
        } else {
            str = "UnknownHome";
        }
        String O0000o0O = ggb.O00000Oo().O0000o0O(this.f17315O000000o);
        this.O00000oO = str;
        this.O00000oo = O0000o0O;
        this.O00000o = str + "-" + O0000o0O;
        this.O0000OOo = (device.pinCodeType & 2) == 2;
    }
}
