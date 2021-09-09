package _m_j;

import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.List;

public final class fnz extends fnw {
    public boolean O00000oO = true;
    public boolean O00000oo = true;
    public boolean O0000O0o = true;
    public String O0000OOo;
    public List<String> O0000Oo0 = new ArrayList();

    public static fnz O000000o(String str, String str2) {
        fnz fnz = new fnz();
        fnz.f16727O000000o = str;
        Home O00000o = ggb.O00000Oo().O00000o(str2);
        if (O00000o != null) {
            fnz.O0000OOo = O00000o.getId();
            if (O00000o.getRoomList() != null) {
                for (Room id : O00000o.getRoomList()) {
                    fnz.O0000Oo0.add(id.getId());
                }
            }
        }
        fnz.O00000oo = true;
        fnz.O0000O0o = true;
        fnz.O00000oO = true;
        return fnz;
    }
}
