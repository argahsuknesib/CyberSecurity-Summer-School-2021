package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

@akg
public final class asc extends arn<String> {
    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        jsonGenerator.O00000Oo((String) obj);
    }

    public final /* synthetic */ boolean O000000o(Object obj) {
        String str = (String) obj;
        return str == null || str.length() == 0;
    }

    public asc() {
        super(String.class);
    }
}
