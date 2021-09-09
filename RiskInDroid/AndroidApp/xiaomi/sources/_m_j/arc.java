package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

@akg
public final class arc extends arf<Calendar> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static arc f12542O000000o = new arc();

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Calendar calendar = (Calendar) obj;
        if (this.O00000Oo) {
            jsonGenerator.O000000o(O000000o(calendar));
        } else if (this.O00000o0 != null) {
            synchronized (this.O00000o0) {
                jsonGenerator.O00000Oo(this.O00000o0.format(calendar));
            }
        } else {
            akf.O000000o(calendar.getTime(), jsonGenerator);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ long O00000Oo(Object obj) {
        return O000000o((Calendar) obj);
    }

    public arc() {
        this(false, null);
    }

    private arc(boolean z, DateFormat dateFormat) {
        super(Calendar.class, z, dateFormat);
    }

    private static long O000000o(Calendar calendar) {
        if (calendar == null) {
            return 0;
        }
        return calendar.getTimeInMillis();
    }

    public final /* synthetic */ arf O000000o(boolean z, DateFormat dateFormat) {
        if (z) {
            return new arc(true, null);
        }
        return new arc(false, dateFormat);
    }
}
