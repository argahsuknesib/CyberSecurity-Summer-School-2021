package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class HurlStack implements HttpStack {
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.mUrlRewriter = urlRewriter;
        this.mSslSocketFactory = sSLSocketFactory;
    }

    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String str;
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.getHeaders());
        hashMap.putAll(map);
        UrlRewriter urlRewriter = this.mUrlRewriter;
        if (urlRewriter != null) {
            str = urlRewriter.rewriteUrl(url);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: ".concat(String.valueOf(url)));
            }
        } else {
            str = url;
        }
        HttpURLConnection openConnection = openConnection(new URL(str), request);
        for (String str2 : hashMap.keySet()) {
            openConnection.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        setConnectionParametersForRequest(openConnection, request);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (openConnection.getResponseCode() != -1) {
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, openConnection.getResponseCode(), openConnection.getResponseMessage()));
            basicHttpResponse.setEntity(entityFromConnection(openConnection));
            for (Map.Entry next : openConnection.getHeaderFields().entrySet()) {
                if (next.getKey() != null) {
                    for (int i = 0; i < ((List) next.getValue()).size(); i++) {
                        basicHttpResponse.addHeader(new BasicHeader((String) next.getKey(), (String) ((List) next.getValue()).get(i)));
                    }
                }
            }
            return basicHttpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    private static HttpEntity entityFromConnection(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection createConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection openConnection(URL url, Request<?> request) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection createConnection = createConnection(url);
        int timeoutMs = request.getTimeoutMs();
        createConnection.setConnectTimeout(timeoutMs);
        createConnection.setReadTimeout(timeoutMs);
        createConnection.setUseCaches(false);
        createConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.mSslSocketFactory) != null) {
            ((HttpsURLConnection) createConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return createConnection;
    }

    static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", request.getPostBodyContentType());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(postBody);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                addBodyIfExists(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                addBodyIfExists(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                addBodyIfExists(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void addBodyIfExists(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", request.getBodyContentType());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(body);
            dataOutputStream.close();
        }
    }
}
