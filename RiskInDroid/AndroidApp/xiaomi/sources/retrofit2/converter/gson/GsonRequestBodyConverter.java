package retrofit2.converter.gson;

import _m_j.jax;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public final RequestBody convert(T t) throws IOException {
        jax jax = new jax();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(jax.O00000Oo(), UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return RequestBody.create(MEDIA_TYPE, jax.O0000o0o());
    }
}
