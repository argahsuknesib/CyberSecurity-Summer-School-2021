package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

@akg
public final class arb extends arn<Boolean> {

    /* renamed from: O000000o  reason: collision with root package name */
    final boolean f12541O000000o;

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        jsonGenerator.O000000o(((Boolean) obj).booleanValue());
    }

    public arb(boolean z) {
        super(Boolean.class);
        this.f12541O000000o = z;
    }
}
