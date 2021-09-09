package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public final class ard extends aqz<Collection<?>> {
    public final /* synthetic */ boolean O000000o(Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.isEmpty();
    }

    public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        ajz<Object> ajz;
        Collection collection = (Collection) obj;
        int i = 0;
        if (this.O00000o != null) {
            ajz ajz2 = this.O00000o;
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                aoi aoi = this.O00000o0;
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            akf.O000000o(jsonGenerator);
                        } catch (Exception e) {
                            O000000o(akf, e, collection, i);
                        }
                    } else if (aoi == null) {
                        ajz2.O000000o(next, jsonGenerator, akf);
                    } else {
                        ajz2.O000000o(next, jsonGenerator, akf, aoi);
                    }
                    i++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator it2 = collection.iterator();
        if (it2.hasNext()) {
            aqp aqp = this.O00000oo;
            aoi aoi2 = this.O00000o0;
            do {
                try {
                    Object next2 = it2.next();
                    if (next2 == null) {
                        akf.O000000o(jsonGenerator);
                    } else {
                        Class<?> cls = next2.getClass();
                        ajz<Object> O000000o2 = aqp.O000000o(cls);
                        if (O000000o2 == null) {
                            if (this.O00000Oo.O0000o0()) {
                                ajz = O000000o(aqp, akf.O000000o(this.O00000Oo, cls), akf);
                            } else {
                                ajz = O000000o(aqp, cls, akf);
                            }
                            O000000o2 = ajz;
                            aqp = this.O00000oo;
                        }
                        if (aoi2 == null) {
                            O000000o2.O000000o(next2, jsonGenerator, akf);
                        } else {
                            O000000o2.O000000o(next2, jsonGenerator, akf, aoi2);
                        }
                    }
                    i++;
                } catch (Exception e2) {
                    O000000o(akf, e2, collection, i);
                    return;
                }
            } while (it2.hasNext());
        }
    }

    public final /* synthetic */ boolean O00000Oo(Object obj) {
        Iterator it = ((Collection) obj).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    public ard(ajv ajv, boolean z, aoi aoi, ajr ajr, ajz<Object> ajz) {
        super(Collection.class, ajv, z, aoi, ajr, ajz);
    }

    private ard(ard ard, aoi aoi, ajz<?> ajz) {
        super(ard, aoi, ajz);
    }

    public final apy<?> O00000Oo(aoi aoi) {
        return new ard(this.O00000Oo, this.f12540O000000o, aoi, this.O00000oO, this.O00000o);
    }

    public final /* synthetic */ aqz O000000o(ajr ajr, aoi aoi, ajz ajz) {
        return new ard(this, aoi, ajz);
    }
}
