package _m_j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class amm {

    public static abstract class O00000Oo<T> extends anb<T> implements alc {
        protected final DateFormat O00000Oo;
        protected final String O00000o0;

        /* access modifiers changed from: protected */
        public abstract O00000Oo<T> O000000o(DateFormat dateFormat, String str);

        protected O00000Oo(Class<?> cls) {
            super(cls);
            this.O00000Oo = null;
            this.O00000o0 = null;
        }

        protected O00000Oo(O00000Oo<T> o00000Oo, DateFormat dateFormat, String str) {
            super(o00000Oo.O0000oOO);
            this.O00000Oo = dateFormat;
            this.O00000o0 = str;
        }

        public ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
            JsonFormat.O000000o O00000oO;
            DateFormat dateFormat;
            if (!(ajr == null || (O00000oO = ajt.O00000Oo().O00000oO(ajr.O00000Oo())) == null)) {
                TimeZone timeZone = O00000oO.O00000o;
                String str = O00000oO.f3593O000000o;
                if (str.length() > 0) {
                    Locale locale = O00000oO.O00000o0;
                    if (locale == null) {
                        locale = ajt.O0000OOo();
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                    if (timeZone == null) {
                        timeZone = ajt.O0000Oo0();
                    }
                    simpleDateFormat.setTimeZone(timeZone);
                    return O000000o(simpleDateFormat, str);
                } else if (timeZone != null) {
                    DateFormat O0000o0O = ajt.O000000o().O0000o0O();
                    if (O0000o0O.getClass() == StdDateFormat.class) {
                        dateFormat = StdDateFormat.O000000o(timeZone);
                    } else {
                        dateFormat = (DateFormat) O0000o0O.clone();
                        dateFormat.setTimeZone(timeZone);
                    }
                    return O000000o(dateFormat, str);
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public final Date O00000Oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            Date parse;
            if (this.O00000Oo == null || jsonParser.O00000oO() != JsonToken.VALUE_STRING) {
                return super.O00000Oo(jsonParser, ajt);
            }
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return (Date) O000000o();
            }
            synchronized (this.O00000Oo) {
                try {
                    parse = this.O00000Oo.parse(trim);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Failed to parse Date value '" + trim + "' (format: \"" + this.O00000o0 + "\"): " + e.getMessage());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parse;
        }
    }

    @akg
    public static class O000000o extends O00000Oo<Calendar> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final Class<? extends Calendar> f12458O000000o;

        public final /* bridge */ /* synthetic */ ajw O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
            return super.O000000o(ajt, ajr);
        }

        public O000000o() {
            super(Calendar.class);
            this.f12458O000000o = null;
        }

        public O000000o(Class<? extends Calendar> cls) {
            super(cls);
            this.f12458O000000o = cls;
        }

        private O000000o(O000000o o000000o, DateFormat dateFormat, String str) {
            super(o000000o, dateFormat, str);
            this.f12458O000000o = o000000o.f12458O000000o;
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public Calendar O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            Date O00000Oo = O00000Oo(jsonParser, ajt);
            if (O00000Oo == null) {
                return null;
            }
            Class<? extends Calendar> cls = this.f12458O000000o;
            if (cls == null) {
                return ajt.O000000o(O00000Oo);
            }
            try {
                Calendar calendar = (Calendar) cls.newInstance();
                calendar.setTimeInMillis(O00000Oo.getTime());
                return calendar;
            } catch (Exception e) {
                throw ajt.O000000o(this.f12458O000000o, e);
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ O00000Oo O000000o(DateFormat dateFormat, String str) {
            return new O000000o(this, dateFormat, str);
        }
    }

    public static class O00000o0 extends O00000Oo<Date> {
        public final /* bridge */ /* synthetic */ ajw O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
            return super.O000000o(ajt, ajr);
        }

        public O00000o0() {
            super(Date.class);
        }

        private O00000o0(O00000o0 o00000o0, DateFormat dateFormat, String str) {
            super(o00000o0, dateFormat, str);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ O00000Oo O000000o(DateFormat dateFormat, String str) {
            return new O00000o0(this, dateFormat, str);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O00000Oo(jsonParser, ajt);
        }
    }

    public static class O00000o extends O00000Oo<java.sql.Date> {
        public final /* bridge */ /* synthetic */ ajw O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
            return super.O000000o(ajt, ajr);
        }

        public O00000o() {
            super(java.sql.Date.class);
        }

        private O00000o(O00000o o00000o, DateFormat dateFormat, String str) {
            super(o00000o, dateFormat, str);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ O00000Oo O000000o(DateFormat dateFormat, String str) {
            return new O00000o(this, dateFormat, str);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            Date O00000Oo = O00000Oo(jsonParser, ajt);
            if (O00000Oo == null) {
                return null;
            }
            return new java.sql.Date(O00000Oo.getTime());
        }
    }

    public static class O0000OOo extends O00000Oo<Timestamp> {
        public final /* bridge */ /* synthetic */ ajw O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
            return super.O000000o(ajt, ajr);
        }

        public O0000OOo() {
            super(Timestamp.class);
        }

        private O0000OOo(O0000OOo o0000OOo, DateFormat dateFormat, String str) {
            super(o0000OOo, dateFormat, str);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ O00000Oo O000000o(DateFormat dateFormat, String str) {
            return new O0000OOo(this, dateFormat, str);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return new Timestamp(O00000Oo(jsonParser, ajt).getTime());
        }
    }

    public static class O0000O0o extends amq<TimeZone> {
        public O0000O0o() {
            super(TimeZone.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return TimeZone.getTimeZone(str);
        }
    }
}
