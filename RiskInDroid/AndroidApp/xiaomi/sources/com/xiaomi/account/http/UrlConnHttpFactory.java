package com.xiaomi.account.http;

import android.text.TextUtils;
import com.xiaomi.account.http.Response;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class UrlConnHttpFactory extends HttpFactory {

    class HttpUrlConnClient implements HttpClient {
        HttpClientConfig config;

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2 A[SYNTHETIC, Splitter:B:35:0x00f2] */
        public Response excute(Request request) throws IOException {
            Throwable th;
            BufferedReader bufferedReader;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.url).openConnection();
            try {
                httpURLConnection.setConnectTimeout((int) this.config.connectTimeoutMs);
                httpURLConnection.setReadTimeout((int) this.config.readTimeoutMs);
                if (request.formBody != null) {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                httpURLConnection.setInstanceFollowRedirects(request.followRedirects);
                if (request.headers != null) {
                    for (Map.Entry next : request.headers.entrySet()) {
                        httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                }
                httpURLConnection.connect();
                if (request.formBody != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(UrlConnHttpFactory.joinToQuery(request.formBody));
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Response.Builder headers = new Response.Builder().code(responseCode).location(httpURLConnection.getHeaderField("Location")).setCookie(httpURLConnection.getHeaderField("Set-Cookie")).headers(httpURLConnection.getHeaderFields());
                if (responseCode == 200) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()), 1024);
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                } else {
                                    Response build = headers.body(sb.toString()).build();
                                    bufferedReader.close();
                                    return build;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                } else {
                    Response build2 = headers.build();
                    httpURLConnection.disconnect();
                    return build2;
                }
            } finally {
                httpURLConnection.disconnect();
            }
        }

        private HttpUrlConnClient(HttpClientConfig httpClientConfig) {
            this.config = httpClientConfig;
            CookieHandler.setDefault(new CookieManager());
            ((CookieManager) CookieHandler.getDefault()).setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        }
    }

    public HttpClient createHttpClient(HttpClientConfig httpClientConfig) {
        return new HttpUrlConnClient(httpClientConfig);
    }

    public static String joinToQuery(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(str);
                sb.append("=");
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
