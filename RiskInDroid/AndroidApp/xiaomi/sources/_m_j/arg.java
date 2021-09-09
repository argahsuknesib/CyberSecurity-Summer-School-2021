package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

@akg
public final class arg extends apy<EnumMap<? extends Enum<?>, ?>> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final boolean f12544O000000o;
    protected final ajr O00000Oo;
    protected final ajv O00000o;
    protected final asz O00000o0;
    protected final ajz<Object> O00000oO;
    protected final aoi O00000oo;

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        EnumMap enumMap = (EnumMap) obj;
        jsonGenerator.O00000o();
        if (!enumMap.isEmpty()) {
            O000000o((EnumMap<? extends Enum<?>, ?>) enumMap, jsonGenerator, akf);
        }
        jsonGenerator.O00000oO();
    }

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        EnumMap enumMap = (EnumMap) obj;
        aoi.O00000Oo(enumMap, jsonGenerator);
        if (!enumMap.isEmpty()) {
            O000000o((EnumMap<? extends Enum<?>, ?>) enumMap, jsonGenerator, akf);
        }
        aoi.O00000oO(enumMap, jsonGenerator);
    }

    public final /* synthetic */ boolean O000000o(Object obj) {
        EnumMap enumMap = (EnumMap) obj;
        return enumMap == null || enumMap.isEmpty();
    }

    public final /* synthetic */ boolean O00000Oo(Object obj) {
        return ((EnumMap) obj).size() == 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public arg(ajv ajv, boolean z, asz asz, aoi aoi, ajz<Object> ajz) {
        super(EnumMap.class, (byte) 0);
        boolean z2 = false;
        this.O00000Oo = null;
        if (z || (ajv != null && ajv.O0000Oo())) {
            z2 = true;
        }
        this.f12544O000000o = z2;
        this.O00000o = ajv;
        this.O00000o0 = asz;
        this.O00000oo = aoi;
        this.O00000oO = ajz;
    }

    private arg(arg arg, ajr ajr, ajz<?> ajz) {
        super(arg);
        this.O00000Oo = ajr;
        this.f12544O000000o = arg.f12544O000000o;
        this.O00000o = arg.O00000o;
        this.O00000o0 = arg.O00000o0;
        this.O00000oo = arg.O00000oo;
        this.O00000oO = ajz;
    }

    private arg O000000o(ajr ajr, ajz<?> ajz) {
        if (this.O00000Oo == ajr && ajz == this.O00000oO) {
            return this;
        }
        return new arg(this, ajr, ajz);
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        ajz<Object> ajz = this.O00000oO;
        if (ajz == null) {
            if (this.f12544O000000o) {
                return O000000o(ajr, akf.O000000o(this.O00000o, ajr));
            }
        } else if (ajz instanceof apz) {
            return O000000o(ajr, ((apz) ajz).O000000o(akf, ajr));
        }
        return this;
    }

    private void O000000o(EnumMap<? extends Enum<?>, ?> enumMap, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        ajz<Object> ajz = this.O00000oO;
        if (ajz != null) {
            asz asz = this.O00000o0;
            for (Map.Entry next : enumMap.entrySet()) {
                Enum enumR = (Enum) next.getKey();
                if (asz == null) {
                    asz = ((arh) ((asb) akf.O000000o(enumR.getDeclaringClass(), this.O00000Oo))).O00000o();
                }
                jsonGenerator.O000000o((ain) asz.O000000o(enumR));
                Object value = next.getValue();
                if (value == null) {
                    akf.O000000o(jsonGenerator);
                } else {
                    try {
                        ajz.O000000o(value, jsonGenerator, akf);
                    } catch (Exception e) {
                        O000000o(akf, e, enumMap, ((Enum) next.getKey()).name());
                    }
                }
            }
            return;
        }
        asz asz2 = this.O00000o0;
        Class<?> cls = null;
        ajz<Object> ajz2 = null;
        for (Map.Entry next2 : enumMap.entrySet()) {
            Enum enumR2 = (Enum) next2.getKey();
            if (asz2 == null) {
                asz2 = ((arh) ((asb) akf.O000000o(enumR2.getDeclaringClass(), this.O00000Oo))).O00000o();
            }
            jsonGenerator.O000000o((ain) asz2.O000000o(enumR2));
            Object value2 = next2.getValue();
            if (value2 == null) {
                akf.O000000o(jsonGenerator);
            } else {
                Class<?> cls2 = value2.getClass();
                if (cls2 != cls) {
                    ajz2 = akf.O000000o(cls2, this.O00000Oo);
                    cls = cls2;
                }
                try {
                    ajz2.O000000o(value2, jsonGenerator, akf);
                } catch (Exception e2) {
                    O000000o(akf, e2, enumMap, ((Enum) next2.getKey()).name());
                }
            }
        }
    }

    public final /* synthetic */ apy O00000Oo(aoi aoi) {
        return new arg(this.O00000o, this.f12544O000000o, this.O00000o0, aoi, this.O00000oO);
    }
}
