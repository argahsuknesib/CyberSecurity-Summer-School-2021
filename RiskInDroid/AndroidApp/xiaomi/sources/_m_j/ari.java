package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

public final class ari extends aqz<EnumSet<? extends Enum<?>>> {
    public final /* bridge */ /* synthetic */ apy O00000Oo(aoi aoi) {
        return this;
    }

    public final /* synthetic */ boolean O000000o(Object obj) {
        EnumSet enumSet = (EnumSet) obj;
        return enumSet == null || enumSet.isEmpty();
    }

    public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        ajz<Object> ajz = this.O00000o;
        Iterator it = ((EnumSet) obj).iterator();
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (ajz == null) {
                ajz = akf.O000000o(enumR.getDeclaringClass(), this.O00000oO);
            }
            ajz.O000000o(enumR, jsonGenerator, akf);
        }
    }

    public final /* synthetic */ boolean O00000Oo(Object obj) {
        return ((EnumSet) obj).size() == 1;
    }

    public ari(ajv ajv) {
        super(EnumSet.class, ajv, true, null, null, null);
    }

    private ari(ari ari, aoi aoi, ajz<?> ajz) {
        super(ari, aoi, ajz);
    }

    public final /* synthetic */ aqz O000000o(ajr ajr, aoi aoi, ajz ajz) {
        return new ari(this, aoi, ajz);
    }
}
