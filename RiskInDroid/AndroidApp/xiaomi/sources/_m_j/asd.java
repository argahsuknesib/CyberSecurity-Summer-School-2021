package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.TimeZone;

public final class asd extends asa<TimeZone> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final asd f12567O000000o = new asd();

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        O000000o((TimeZone) obj, jsonGenerator);
    }

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        TimeZone timeZone = (TimeZone) obj;
        aoi.O000000o(timeZone, jsonGenerator, TimeZone.class);
        O000000o(timeZone, jsonGenerator);
        aoi.O00000o(timeZone, jsonGenerator);
    }

    public asd() {
        super(TimeZone.class);
    }

    private static void O000000o(TimeZone timeZone, JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.O00000Oo(timeZone.getID());
    }
}
