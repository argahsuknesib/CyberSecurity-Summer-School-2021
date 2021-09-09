package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class amg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ArrayList<alm> f12455O000000o = new ArrayList<>();

    public final void O000000o(alm alm) {
        this.f12455O000000o.add(alm);
    }

    public final void O000000o(atb atb) {
        ajw<Object> O000000o2;
        Iterator it = new ArrayList(this.f12455O000000o).iterator();
        this.f12455O000000o.clear();
        while (it.hasNext()) {
            alm alm = (alm) it.next();
            alm O000000o3 = alm.O000000o(atb.O000000o(alm.O00000o()));
            ajw<Object> O0000OOo = O000000o3.O0000OOo();
            if (!(O0000OOo == null || (O000000o2 = O0000OOo.O000000o(atb)) == O0000OOo)) {
                O000000o3 = O000000o3.O00000Oo(O000000o2);
            }
            this.f12455O000000o.add(O000000o3);
        }
    }

    public final Object O000000o(ajt ajt, Object obj, ath ath) throws IOException, JsonProcessingException {
        int size = this.f12455O000000o.size();
        for (int i = 0; i < size; i++) {
            JsonParser O0000OOo = ath.O0000OOo();
            O0000OOo.O00000Oo();
            this.f12455O000000o.get(i).O000000o(O0000OOo, ajt, obj);
        }
        return obj;
    }
}
