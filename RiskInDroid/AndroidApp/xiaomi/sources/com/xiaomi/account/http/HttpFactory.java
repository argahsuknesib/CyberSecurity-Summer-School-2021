package com.xiaomi.account.http;

import android.net.Network;
import com.xiaomi.account.http.HttpClientConfig;

public abstract class HttpFactory {
    public abstract HttpClient createHttpClient(HttpClientConfig httpClientConfig);

    public HttpClient createHttpClient() {
        return createHttpClient(new HttpClientConfig.Builder().build());
    }

    public HttpClient createHttpClient(Network network) {
        return createHttpClient(new HttpClientConfig.Builder().network(network).build());
    }
}
