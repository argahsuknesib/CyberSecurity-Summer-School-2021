package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.net.InetAddress;

public final class arj extends asa<InetAddress> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final arj f12546O000000o = new arj();

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        O000000o((InetAddress) obj, jsonGenerator);
    }

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        InetAddress inetAddress = (InetAddress) obj;
        aoi.O000000o(inetAddress, jsonGenerator, InetAddress.class);
        O000000o(inetAddress, jsonGenerator);
        aoi.O00000o(inetAddress, jsonGenerator);
    }

    public arj() {
        super(InetAddress.class);
    }

    private static void O000000o(InetAddress inetAddress, JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        String trim = inetAddress.toString().trim();
        int indexOf = trim.indexOf(47);
        if (indexOf >= 0) {
            if (indexOf == 0) {
                trim = trim.substring(1);
            } else {
                trim = trim.substring(0, indexOf);
            }
        }
        jsonGenerator.O00000Oo(trim);
    }
}
