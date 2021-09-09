package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.HashMap;

@akg
public final class arh extends asa<Enum<?>> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final asz f12545O000000o;

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Enum enumR = (Enum) obj;
        if (akf.O000000o(SerializationFeature.WRITE_ENUMS_USING_INDEX)) {
            jsonGenerator.O000000o(enumR.ordinal());
        } else {
            jsonGenerator.O00000Oo(this.f12545O000000o.O000000o(enumR));
        }
    }

    private arh(asz asz) {
        super(Enum.class, (byte) 0);
        this.f12545O000000o = asz;
    }

    public static arh O000000o(Class<Enum<?>> cls, ake ake) {
        asz asz;
        AnnotationIntrospector O000000o2 = ake.O000000o();
        if (ake.O000000o(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
            Enum[] enumArr = (Enum[]) asw.O00000oo(cls).getEnumConstants();
            if (enumArr != null) {
                HashMap hashMap = new HashMap();
                for (Enum enumR : enumArr) {
                    hashMap.put(enumR, new aja(enumR.toString()));
                }
                asz = new asz(hashMap);
            } else {
                throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
            }
        } else {
            asz = asz.O000000o(cls, O000000o2);
        }
        return new arh(asz);
    }

    public final asz O00000o() {
        return this.f12545O000000o;
    }
}
