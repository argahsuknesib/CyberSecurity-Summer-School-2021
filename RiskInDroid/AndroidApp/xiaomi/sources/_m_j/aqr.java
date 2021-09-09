package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

@akg
public final class aqr extends aqy<String[]> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final aqr f12535O000000o = new aqr();
    private static final ajv O00000o = asq.O000000o((Class<?>) String.class);
    protected final ajz<Object> O00000Oo;

    public final apy<?> O00000Oo(aoi aoi) {
        return this;
    }

    public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
        String[] strArr = (String[]) obj;
        return strArr == null || strArr.length == 0;
    }

    public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        String[] strArr = (String[]) obj;
        int length = strArr.length;
        if (length != 0) {
            ajz<Object> ajz = this.O00000Oo;
            int i = 0;
            if (ajz != null) {
                int length2 = strArr.length;
                while (i < length2) {
                    if (strArr[i] == null) {
                        akf.O000000o(jsonGenerator);
                    } else {
                        ajz.O000000o(strArr[i], jsonGenerator, akf);
                    }
                    i++;
                }
                return;
            }
            while (i < length) {
                if (strArr[i] == null) {
                    jsonGenerator.O00000oo();
                } else {
                    jsonGenerator.O00000Oo(strArr[i]);
                }
                i++;
            }
        }
    }

    public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
        return ((String[]) obj).length == 1;
    }

    static {
        asq.O000000o();
    }

    protected aqr() {
        super(String[].class, (byte) 0);
        this.O00000Oo = null;
    }

    private aqr(aqr aqr, ajr ajr, ajz<?> ajz) {
        super(aqr, ajr);
        this.O00000Oo = ajz;
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        ajz<?> ajz = this.O00000Oo;
        if (ajz == null) {
            ajz = akf.O000000o(String.class, ajr);
        } else if (ajz instanceof apz) {
            ajz = ((apz) ajz).O000000o(akf, ajr);
        }
        if (O000000o(ajz)) {
            ajz = null;
        }
        if (ajz == this.O00000Oo) {
            return this;
        }
        return new aqr(this, ajr, ajz);
    }
}
