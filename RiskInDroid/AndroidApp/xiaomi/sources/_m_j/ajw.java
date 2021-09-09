package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Collection;

public abstract class ajw<T> {
    public ajw<T> O000000o(atb atb) {
        return this;
    }

    public T O000000o() {
        return null;
    }

    public abstract T O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException;

    public Collection<Object> O00000Oo() {
        return null;
    }

    public boolean O00000o0() {
        return false;
    }

    public T O000000o(JsonParser jsonParser, ajt ajt, T t) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException("Can not update object of type " + t.getClass().getName());
    }

    public Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O00000o(jsonParser, ajt);
    }

    public static abstract class O000000o extends ajw<Object> {
        private O000000o() {
        }
    }
}
