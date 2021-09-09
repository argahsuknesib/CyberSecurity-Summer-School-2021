package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@akg
public final class are extends arf<Date> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static are f12543O000000o = new are();

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Date date = (Date) obj;
        if (this.O00000Oo) {
            jsonGenerator.O000000o(O000000o(date));
        } else if (this.O00000o0 != null) {
            synchronized (this.O00000o0) {
                jsonGenerator.O00000Oo(this.O00000o0.format(date));
            }
        } else {
            akf.O000000o(date, jsonGenerator);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ long O00000Oo(Object obj) {
        return O000000o((Date) obj);
    }

    public are() {
        this(false, null);
    }

    private are(boolean z, DateFormat dateFormat) {
        super(Date.class, z, dateFormat);
    }

    private static long O000000o(Date date) {
        if (date == null) {
            return 0;
        }
        return date.getTime();
    }

    public final /* synthetic */ arf O000000o(boolean z, DateFormat dateFormat) {
        if (z) {
            return new are(true, null);
        }
        return new are(false, dateFormat);
    }
}
