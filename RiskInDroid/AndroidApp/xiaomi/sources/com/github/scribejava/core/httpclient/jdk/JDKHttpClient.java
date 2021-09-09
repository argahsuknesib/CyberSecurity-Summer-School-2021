package com.github.scribejava.core.httpclient.jdk;

import _m_j.auy;
import _m_j.avb;
import _m_j.avg;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.Verb;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class JDKHttpClient implements auy {

    /* renamed from: O000000o  reason: collision with root package name */
    private final avb f3608O000000o;

    enum BodyType {
        BYTE_ARRAY {
            /* access modifiers changed from: package-private */
            public final void setBody(HttpURLConnection httpURLConnection, Object obj, boolean z) throws IOException {
                JDKHttpClient.O000000o(httpURLConnection, (byte[]) obj, z);
            }
        },
        STRING {
            /* access modifiers changed from: package-private */
            public final void setBody(HttpURLConnection httpURLConnection, Object obj, boolean z) throws IOException {
                JDKHttpClient.O000000o(httpURLConnection, ((String) obj).getBytes(), z);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract void setBody(HttpURLConnection httpURLConnection, Object obj, boolean z) throws IOException;
    }

    public final void O000000o() throws IOException {
    }

    public JDKHttpClient(avb avb) {
        this.f3608O000000o = avb;
    }

    public final avg O000000o(String str, Map<String, String> map, Verb verb, String str2, byte[] bArr) throws InterruptedException, ExecutionException, IOException {
        return O000000o(str, map, verb, str2, BodyType.BYTE_ARRAY, bArr);
    }

    public final avg O000000o(String str, Map<String, String> map, Verb verb, String str2, String str3) throws InterruptedException, ExecutionException, IOException {
        return O000000o(str, map, verb, str2, BodyType.STRING, str3);
    }

    public final avg O000000o(String str, Map<String, String> map, Verb verb, String str2, File file) throws InterruptedException, ExecutionException, IOException {
        throw new UnsupportedOperationException("JDKHttpClient do not support File payload for the moment");
    }

    private avg O000000o(String str, Map<String, String> map, Verb verb, String str2, BodyType bodyType, Object obj) throws IOException {
        InputStream inputStream;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        httpURLConnection.setInstanceFollowRedirects(this.f3608O000000o.O00000o0);
        httpURLConnection.setRequestMethod(verb.name());
        if (this.f3608O000000o.f12634O000000o != null) {
            httpURLConnection.setConnectTimeout(this.f3608O000000o.f12634O000000o.intValue());
        }
        if (this.f3608O000000o.O00000Oo != null) {
            httpURLConnection.setReadTimeout(this.f3608O000000o.O00000Oo.intValue());
        }
        O000000o(httpURLConnection, map, str);
        if (verb.isPermitBody()) {
            bodyType.setBody(httpURLConnection, obj, verb.isRequiresBody());
        }
        try {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            Map<String, String> O000000o2 = O000000o(httpURLConnection);
            if (responseCode < 200 || responseCode >= 400) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            return new avg(responseCode, responseMessage, O000000o2, inputStream);
        } catch (UnknownHostException e) {
            throw new OAuthException("The IP address of a host could not be determined.", e);
        }
    }

    private static Map<String, String> O000000o(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : httpURLConnection.getHeaderFields().entrySet()) {
            String str = (String) next.getKey();
            if ("Content-Encoding".equalsIgnoreCase(str)) {
                hashMap.put("Content-Encoding", ((List) next.getValue()).get(0));
            } else {
                hashMap.put(str, ((List) next.getValue()).get(0));
            }
        }
        return hashMap;
    }

    private static void O000000o(HttpURLConnection httpURLConnection, Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
    }

    public static void O000000o(HttpURLConnection httpURLConnection, byte[] bArr, boolean z) throws IOException {
        int length = bArr.length;
        if (z || length > 0) {
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
            if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(bArr);
        }
    }
}
