package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.Iterator;

@akg
public final class aql extends aqz<Iterator<?>> {
    public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
        return false;
    }

    public final /* synthetic */ boolean O000000o(Object obj) {
        Iterator it = (Iterator) obj;
        return it == null || !it.hasNext();
    }

    public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Iterator it = (Iterator) obj;
        if (it.hasNext()) {
            aoi aoi = this.O00000o0;
            Class<?> cls = null;
            ajz<Object> ajz = null;
            do {
                Object next = it.next();
                if (next == null) {
                    akf.O000000o(jsonGenerator);
                } else {
                    Class<?> cls2 = next.getClass();
                    if (cls2 != cls) {
                        ajz = akf.O000000o(cls2, this.O00000oO);
                        cls = cls2;
                    }
                    if (aoi == null) {
                        ajz.O000000o(next, jsonGenerator, akf);
                    } else {
                        ajz.O000000o(next, jsonGenerator, akf, aoi);
                    }
                }
            } while (it.hasNext());
        }
    }

    public aql(ajv ajv, boolean z, aoi aoi, ajr ajr) {
        super(Iterator.class, ajv, z, aoi, ajr, null);
    }

    private aql(aql aql, aoi aoi, ajz<?> ajz) {
        super(aql, aoi, ajz);
    }

    public final apy<?> O00000Oo(aoi aoi) {
        return new aql(this.O00000Oo, this.f12540O000000o, aoi, this.O00000oO);
    }

    public final /* synthetic */ aqz O000000o(ajr ajr, aoi aoi, ajz ajz) {
        return new aql(this, aoi, ajz);
    }
}
