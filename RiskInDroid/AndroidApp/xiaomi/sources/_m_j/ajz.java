package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public abstract class ajz<T> {

    public static abstract class O000000o extends ajz<Object> {
    }

    public ajz<T> O000000o(atb atb) {
        return this;
    }

    public abstract void O000000o(T t, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException;

    public boolean O000000o() {
        return false;
    }

    public boolean O000000o(T t) {
        return t == null;
    }

    public Class<T> O00000Oo() {
        return null;
    }

    public boolean O00000o0() {
        return false;
    }

    public void O000000o(T t, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        Class<?> O00000Oo = O00000Oo();
        if (O00000Oo == null) {
            O00000Oo = t.getClass();
        }
        throw new UnsupportedOperationException("Type id handling not implemented for type " + O00000Oo.getName());
    }
}
