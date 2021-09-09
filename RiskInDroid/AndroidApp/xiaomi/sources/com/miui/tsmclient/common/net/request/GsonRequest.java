package com.miui.tsmclient.common.net.request;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.net.RequestCallback;
import java.io.IOException;
import java.io.InputStream;

public abstract class GsonRequest<T> extends BaseRequest<T> {
    private Gson mGson;
    private TypeToken<T> mTypeToken;

    public GsonRequest(int i, String str, TypeToken<T> typeToken) {
        this(i, str, typeToken, (RequestCallback) null);
    }

    public GsonRequest(int i, String str, Class<T> cls) {
        this(i, str, TypeToken.get((Class) cls), (RequestCallback) null);
    }

    public GsonRequest(int i, String str, Class cls, RequestCallback requestCallback) {
        this(i, str, TypeToken.get(cls), requestCallback);
    }

    public GsonRequest(int i, String str, TypeToken typeToken, RequestCallback requestCallback) {
        super(i, str, requestCallback);
        this.mGson = getGson();
        this.mTypeToken = typeToken;
    }

    public T parseBody(InputStream inputStream, long j) throws IOException {
        throw new UnsupportedOperationException();
    }

    public T parseBody(String str) throws IOException {
        try {
            return this.mGson.fromJson(str, this.mTypeToken.getType());
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public Gson getGson() {
        return new Gson();
    }
}
