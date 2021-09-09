package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.sql.Date;

@akg
public final class art extends asa<Date> {
    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        jsonGenerator.O00000Oo(((Date) obj).toString());
    }

    public art() {
        super(Date.class);
    }
}
