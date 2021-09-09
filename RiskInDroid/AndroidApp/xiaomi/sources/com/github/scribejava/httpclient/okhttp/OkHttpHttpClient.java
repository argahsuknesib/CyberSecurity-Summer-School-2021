package com.github.scribejava.httpclient.okhttp;

import _m_j.auy;
import _m_j.avg;
import com.github.scribejava.core.model.Verb;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;

public final class OkHttpHttpClient implements auy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final MediaType f3609O000000o = MediaType.parse("application/x-www-form-urlencoded");
    private final OkHttpClient O00000Oo;

    enum BodyType {
        BYTE_ARRAY {
            /* access modifiers changed from: package-private */
            public final RequestBody createBody(MediaType mediaType, Object obj) {
                return RequestBody.create(mediaType, (byte[]) obj);
            }
        },
        STRING {
            /* access modifiers changed from: package-private */
            public final RequestBody createBody(MediaType mediaType, Object obj) {
                return RequestBody.create(mediaType, (String) obj);
            }
        },
        FILE {
            /* access modifiers changed from: package-private */
            public final RequestBody createBody(MediaType mediaType, Object obj) {
                return RequestBody.create(mediaType, (File) obj);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract RequestBody createBody(MediaType mediaType, Object obj);
    }

    public OkHttpHttpClient(OkHttpClient okHttpClient) {
        this.O00000Oo = okHttpClient;
    }

    public final void O000000o() throws IOException {
        this.O00000Oo.dispatcher().executorService().shutdown();
        this.O00000Oo.connectionPool().evictAll();
        Cache cache = this.O00000Oo.cache();
        if (cache != null) {
            cache.close();
        }
    }

    public final avg O000000o(String str, Map<String, String> map, Verb verb, String str2, byte[] bArr) throws InterruptedException, ExecutionException, IOException {
        return O000000o(str, map, verb, str2, BodyType.BYTE_ARRAY, bArr);
    }

    public final avg O000000o(String str, Map<String, String> map, Verb verb, String str2, String str3) throws InterruptedException, ExecutionException, IOException {
        return O000000o(str, map, verb, str2, BodyType.STRING, str3);
    }

    public final avg O000000o(String str, Map<String, String> map, Verb verb, String str2, File file) throws InterruptedException, ExecutionException, IOException {
        return O000000o(str, map, verb, str2, BodyType.FILE, file);
    }

    private avg O000000o(String str, Map<String, String> map, Verb verb, String str2, BodyType bodyType, Object obj) throws IOException {
        return O000000o(O00000Oo(str, map, verb, str2, bodyType, obj).execute());
    }

    private Call O00000Oo(String str, Map<String, String> map, Verb verb, String str2, BodyType bodyType, Object obj) {
        RequestBody requestBody;
        Request.Builder builder = new Request.Builder();
        builder.url(str2);
        String name = verb.name();
        if (obj == null || !HttpMethod.permitsRequestBody(name)) {
            requestBody = null;
        } else {
            requestBody = bodyType.createBody(map.containsKey("Content-Type") ? MediaType.parse(map.get("Content-Type")) : f3609O000000o, obj);
        }
        builder.method(name, requestBody);
        for (Map.Entry next : map.entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        if (str != null) {
            builder.header("User-Agent", str);
        }
        return this.O00000Oo.newCall(builder.build());
    }

    private static avg O000000o(Response response) {
        InputStream inputStream;
        Headers headers = response.headers();
        HashMap hashMap = new HashMap();
        for (String next : headers.names()) {
            hashMap.put(next, headers.get(next));
        }
        ResponseBody body = response.body();
        int code = response.code();
        String message = response.message();
        if (body == null) {
            inputStream = null;
        } else {
            inputStream = body.byteStream();
        }
        return new avg(code, message, hashMap, inputStream);
    }
}
