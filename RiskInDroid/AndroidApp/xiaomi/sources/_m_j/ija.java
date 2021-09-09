package _m_j;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.Response;

public final class ija {

    /* renamed from: O000000o  reason: collision with root package name */
    public Response f1355O000000o;

    public ija(Response response) {
        this.f1355O000000o = response;
    }

    public final String O000000o() throws IOException {
        try {
            return this.f1355O000000o.body().string();
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException("cause:" + e.getMessage());
        }
    }

    public static Object O000000o(Type type, String str) throws Exception {
        try {
            return new Gson().fromJson(str, type);
        } catch (Throwable th) {
            th.printStackTrace();
            throw new RuntimeException(th);
        }
    }
}
