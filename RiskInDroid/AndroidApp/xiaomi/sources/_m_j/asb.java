package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class asb<T> extends ajz<T> {
    protected final Class<T> O0000OoO;

    public abstract void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException;

    protected asb(Class cls) {
        this.O0000OoO = cls;
    }

    protected asb(ajv ajv) {
        this.O0000OoO = ajv.O00000Oo();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Class<?>, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    protected asb(Class<?> r1, byte b) {
        this.O0000OoO = r1;
    }

    public final Class<T> O00000Oo() {
        return this.O0000OoO;
    }

    public static void O000000o(akf akf, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = akf == null || akf.O000000o(SerializationFeature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                if (!z || !(th instanceof JsonMappingException)) {
                    throw ((IOException) th);
                }
            } else if (!z && (th instanceof RuntimeException)) {
                throw ((RuntimeException) th);
            }
            throw JsonMappingException.wrapWithPath(th, obj, str);
        }
        throw ((Error) th);
    }

    public static void O000000o(akf akf, Throwable th, Object obj, int i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = akf == null || akf.O000000o(SerializationFeature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                if (!z || !(th instanceof JsonMappingException)) {
                    throw ((IOException) th);
                }
            } else if (!z && (th instanceof RuntimeException)) {
                throw ((RuntimeException) th);
            }
            throw JsonMappingException.wrapWithPath(th, obj, i);
        }
        throw ((Error) th);
    }

    protected static boolean O000000o(ajz<?> ajz) {
        return (ajz == null || ajz.getClass().getAnnotation(akg.class) == null) ? false : true;
    }
}
