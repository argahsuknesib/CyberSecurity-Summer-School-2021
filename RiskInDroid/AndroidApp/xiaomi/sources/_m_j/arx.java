package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class arx implements ate<Map.Entry<Class<?>, Object>> {
    public final Collection<Map.Entry<Class<?>, Object>> O000000o() {
        HashMap hashMap = new HashMap();
        ase ase = ase.f12568O000000o;
        hashMap.put(URL.class, ase);
        hashMap.put(URI.class, ase);
        hashMap.put(Currency.class, ase);
        hashMap.put(UUID.class, ase);
        hashMap.put(Pattern.class, ase);
        hashMap.put(Locale.class, ase);
        hashMap.put(Locale.class, ase);
        hashMap.put(AtomicReference.class, O00000o.class);
        hashMap.put(AtomicBoolean.class, O000000o.class);
        hashMap.put(AtomicInteger.class, O00000Oo.class);
        hashMap.put(AtomicLong.class, O00000o0.class);
        hashMap.put(File.class, O0000OOo.class);
        hashMap.put(Class.class, O0000O0o.class);
        hashMap.put(Void.TYPE, aro.class);
        return hashMap.entrySet();
    }

    public static final class O000000o extends asa<AtomicBoolean> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((AtomicBoolean) obj).get());
        }

        public O000000o() {
            super(AtomicBoolean.class, (byte) 0);
        }
    }

    public static final class O00000Oo extends asa<AtomicInteger> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((AtomicInteger) obj).get());
        }

        public O00000Oo() {
            super(AtomicInteger.class, (byte) 0);
        }
    }

    public static final class O00000o0 extends asa<AtomicLong> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((AtomicLong) obj).get());
        }

        public O00000o0() {
            super(AtomicLong.class, (byte) 0);
        }
    }

    public static final class O00000o extends asb<AtomicReference<?>> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            akf.O000000o(((AtomicReference) obj).get(), jsonGenerator);
        }

        public O00000o() {
            super(AtomicReference.class, (byte) 0);
        }
    }

    public static final class O0000OOo extends asa<File> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O00000Oo(((File) obj).getAbsolutePath());
        }

        public O0000OOo() {
            super(File.class);
        }
    }

    public static final class O0000O0o extends asa<Class<?>> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O00000Oo(((Class) obj).getName());
        }

        public O0000O0o() {
            super(Class.class, (byte) 0);
        }
    }
}
