package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.sql.Time;

@akg
public final class aru extends asa<Time> {
    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        jsonGenerator.O00000Oo(((Time) obj).toString());
    }

    public aru() {
        super(Time.class);
    }
}
