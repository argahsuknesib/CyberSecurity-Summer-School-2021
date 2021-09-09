package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;

@akg
public final class aqs extends arv<Collection<String>> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final aqs f12536O000000o = new aqs();
    protected final ajz<String> O00000Oo;

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Collection collection = (Collection) obj;
        jsonGenerator.O00000Oo();
        if (this.O00000Oo == null) {
            O000000o((Collection<String>) collection, jsonGenerator, akf);
        } else {
            O00000Oo(collection, jsonGenerator, akf);
        }
        jsonGenerator.O00000o0();
    }

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        Collection collection = (Collection) obj;
        aoi.O00000o0(collection, jsonGenerator);
        if (this.O00000Oo == null) {
            O000000o((Collection<String>) collection, jsonGenerator, akf);
        } else {
            O00000Oo(collection, jsonGenerator, akf);
        }
        aoi.O00000oo(collection, jsonGenerator);
    }

    protected aqs() {
        this(null);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [_m_j.ajz<?>, _m_j.ajz<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private aqs(ajz<?> r2) {
        super(Collection.class);
        this.O00000Oo = r2;
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        ajz ajz = this.O00000Oo;
        if (ajz == null) {
            ajz = akf.O000000o(String.class, ajr);
        } else if (ajz instanceof apz) {
            ajz = ((apz) ajz).O000000o(akf, ajr);
        }
        if (O000000o((ajz<?>) ajz)) {
            ajz = null;
        }
        if (ajz == this.O00000Oo) {
            return this;
        }
        return new aqs(ajz);
    }

    private final void O000000o(Collection<String> collection, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        if (this.O00000Oo != null) {
            O00000Oo(collection, jsonGenerator, akf);
            return;
        }
        int i = 0;
        for (String next : collection) {
            if (next == null) {
                try {
                    akf.O000000o(jsonGenerator);
                } catch (Exception e) {
                    O000000o(akf, e, collection, i);
                }
            } else {
                jsonGenerator.O00000Oo(next);
            }
            i++;
        }
    }

    private void O00000Oo(Collection<String> collection, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        ajz<String> ajz = this.O00000Oo;
        for (String next : collection) {
            if (next == null) {
                try {
                    akf.O000000o(jsonGenerator);
                } catch (Exception e) {
                    O000000o(akf, e, collection, 0);
                }
            } else {
                ajz.O000000o(next, jsonGenerator, akf);
            }
        }
    }
}
