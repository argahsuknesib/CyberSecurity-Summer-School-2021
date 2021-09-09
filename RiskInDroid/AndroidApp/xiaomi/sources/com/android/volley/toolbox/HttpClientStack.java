package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientStack implements HttpStack {
    protected final HttpClient mClient;

    /* access modifiers changed from: protected */
    public void onPrepareRequest(HttpUriRequest httpUriRequest) throws IOException {
    }

    public HttpClientStack(HttpClient httpClient) {
        this.mClient = httpClient;
    }

    private static void addHeaders(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    private static List<NameValuePair> getPostParameterPairs(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String next : map.keySet()) {
            arrayList.add(new BasicNameValuePair(next, map.get(next)));
        }
        return arrayList;
    }

    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest createHttpRequest = createHttpRequest(request, map);
        addHeaders(createHttpRequest, map);
        addHeaders(createHttpRequest, request.getHeaders());
        onPrepareRequest(createHttpRequest);
        HttpParams params = createHttpRequest.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return this.mClient.execute(createHttpRequest);
    }

    static HttpUriRequest createHttpRequest(Request<?> request, Map<String, String> map) throws AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody == null) {
                    return new HttpGet(request.getUrl());
                }
                HttpPost httpPost = new HttpPost(request.getUrl());
                httpPost.addHeader("Content-Type", request.getPostBodyContentType());
                httpPost.setEntity(new ByteArrayEntity(postBody));
                return httpPost;
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.getUrl());
                httpPost2.addHeader("Content-Type", request.getBodyContentType());
                setEntityIfNonEmptyBody(httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.getUrl());
                httpPut.addHeader("Content-Type", request.getBodyContentType());
                setEntityIfNonEmptyBody(httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.getUrl());
            case 4:
                return new HttpHead(request.getUrl());
            case 5:
                return new HttpOptions(request.getUrl());
            case 6:
                return new HttpTrace(request.getUrl());
            case 7:
                HttpPatch httpPatch = new HttpPatch(request.getUrl());
                httpPatch.addHeader("Content-Type", request.getBodyContentType());
                setEntityIfNonEmptyBody(httpPatch, request);
                return httpPatch;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void setEntityIfNonEmptyBody(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public final String getMethod() {
            return "PATCH";
        }

        public HttpPatch() {
        }

        public HttpPatch(URI uri) {
            setURI(uri);
        }

        public HttpPatch(String str) {
            setURI(URI.create(str));
        }
    }
}
