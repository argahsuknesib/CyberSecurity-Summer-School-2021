package com.xiaomi.mico.api.interceptor;

import java.io.IOException;
import java.util.Random;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ParamsInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (request.method().equals("GET")) {
            newBuilder.url(request.url().newBuilder().addQueryParameter("requestId", randomRequestId()).build());
        } else if (request.method().equals("POST")) {
            RequestBody body = request.body();
            if (body instanceof FormBody) {
                FormBody.Builder builder = new FormBody.Builder();
                FormBody formBody = (FormBody) body;
                for (int i = 0; i < formBody.size(); i++) {
                    builder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                }
                newBuilder.post(builder.addEncoded("requestId", randomRequestId()).build());
            }
        }
        return chain.proceed(newBuilder.build());
    }

    private static String randomRequestId() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }
}
