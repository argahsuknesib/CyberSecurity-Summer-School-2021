package _m_j;

import com.adobe.xmp.XMPException;
import java.util.HashMap;

public class ahe extends xr {
    protected static final HashMap<Integer, String> O0000O0o;
    mo O0000OOo;

    public final String O000000o() {
        return "XMP";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(65535, "XMP Value Count");
    }

    public ahe() {
        O000000o(new ahd(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }

    public final void O000000o(mo moVar) {
        this.O0000OOo = moVar;
        int i = 0;
        try {
            mn O000000o2 = this.O0000OOo.O000000o();
            while (O000000o2.hasNext()) {
                if (((nt) O000000o2.next()).O000000o() != null) {
                    i++;
                }
            }
            O000000o(65535, i);
        } catch (XMPException unused) {
        }
    }
}
