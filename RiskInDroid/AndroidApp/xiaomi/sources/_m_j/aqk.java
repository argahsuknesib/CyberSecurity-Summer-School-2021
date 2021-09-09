package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.List;

@akg
public final class aqk extends arv<List<String>> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final aqk f12524O000000o = new aqk();
    protected final ajz<String> O00000Oo;

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        List list = (List) obj;
        jsonGenerator.O00000Oo();
        if (this.O00000Oo == null) {
            O000000o((List<String>) list, jsonGenerator, akf);
        } else {
            O00000Oo(list, jsonGenerator, akf);
        }
        jsonGenerator.O00000o0();
    }

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        List list = (List) obj;
        aoi.O00000o0(list, jsonGenerator);
        if (this.O00000Oo == null) {
            O000000o((List<String>) list, jsonGenerator, akf);
        } else {
            O00000Oo(list, jsonGenerator, akf);
        }
        aoi.O00000oo(list, jsonGenerator);
    }

    protected aqk() {
        this(null);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [_m_j.ajz<?>, _m_j.ajz<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private aqk(ajz<?> r2) {
        super(List.class);
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
        return new aqk(ajz);
    }

    private static void O000000o(List<String> list, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                if (str == null) {
                    akf.O000000o(jsonGenerator);
                } else {
                    jsonGenerator.O00000Oo(str);
                }
            }
        } catch (Exception e) {
            O000000o(akf, e, list, 0);
        }
    }

    private final void O00000Oo(List<String> list, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        try {
            int size = list.size();
            ajz<String> ajz = this.O00000Oo;
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                if (str == null) {
                    akf.O000000o(jsonGenerator);
                } else {
                    ajz.O000000o(str, jsonGenerator, akf);
                }
            }
        } catch (Exception e) {
            O000000o(akf, e, list, 0);
        }
    }
}
