package _m_j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class arf<T> extends asa<T> implements apz {
    protected final boolean O00000Oo;
    protected final DateFormat O00000o0;

    public abstract arf<T> O000000o(boolean z, DateFormat dateFormat);

    /* access modifiers changed from: protected */
    public abstract long O00000Oo(T t);

    protected arf(Class<T> cls, boolean z, DateFormat dateFormat) {
        super(cls);
        this.O00000Oo = z;
        this.O00000o0 = dateFormat;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.arf.O000000o(boolean, java.text.DateFormat):_m_j.arf<T>
     arg types: [int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.arf.O000000o(_m_j.akf, _m_j.ajr):_m_j.ajz<?>
      _m_j.apz.O000000o(_m_j.akf, _m_j.ajr):_m_j.ajz<?>
      _m_j.arf.O000000o(boolean, java.text.DateFormat):_m_j.arf<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.arf.O000000o(boolean, java.text.DateFormat):_m_j.arf<T>
     arg types: [int, java.text.SimpleDateFormat]
     candidates:
      _m_j.arf.O000000o(_m_j.akf, _m_j.ajr):_m_j.ajz<?>
      _m_j.apz.O000000o(_m_j.akf, _m_j.ajr):_m_j.ajz<?>
      _m_j.arf.O000000o(boolean, java.text.DateFormat):_m_j.arf<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.arf.O000000o(boolean, java.text.DateFormat):_m_j.arf<T>
     arg types: [int, java.text.DateFormat]
     candidates:
      _m_j.arf.O000000o(_m_j.akf, _m_j.ajr):_m_j.ajz<?>
      _m_j.apz.O000000o(_m_j.akf, _m_j.ajr):_m_j.ajz<?>
      _m_j.arf.O000000o(boolean, java.text.DateFormat):_m_j.arf<T> */
    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        JsonFormat.O000000o O00000oO;
        DateFormat dateFormat;
        if (!(ajr == null || (O00000oO = akf.O00000o0().O00000oO(ajr.O00000Oo())) == null)) {
            if (O00000oO.O00000Oo.isNumeric()) {
                return O000000o(true, (DateFormat) null);
            }
            TimeZone timeZone = O00000oO.O00000o;
            String str = O00000oO.f3593O000000o;
            if (str.length() > 0) {
                Locale locale = O00000oO.O00000o0;
                if (locale == null) {
                    locale = akf.O00000oo();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                if (timeZone == null) {
                    timeZone = akf.O0000O0o();
                }
                simpleDateFormat.setTimeZone(timeZone);
                return O000000o(false, (DateFormat) simpleDateFormat);
            } else if (timeZone != null) {
                DateFormat O0000o0O = akf.O000000o().O0000o0O();
                if (O0000o0O.getClass() == StdDateFormat.class) {
                    dateFormat = StdDateFormat.O00000Oo(timeZone);
                } else {
                    dateFormat = (DateFormat) O0000o0O.clone();
                    dateFormat.setTimeZone(timeZone);
                }
                return O000000o(false, dateFormat);
            }
        }
        return this;
    }

    public final boolean O000000o(Object obj) {
        return obj == null || O00000Oo(obj) == 0;
    }
}
