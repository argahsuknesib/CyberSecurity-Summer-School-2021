package _m_j;

import android.os.Build;
import android.text.TextUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.task.PriorityExecutor;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class boi {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bqg f13166O000000o = new bqg();
    private static final PriorityExecutor O0000O0o = new PriorityExecutor(3);
    private final DefaultHttpClient O00000Oo;
    private bql O00000o;
    private final HttpContext O00000o0;
    private String O00000oO;
    private long O00000oo;

    public boi() {
        this(15000, null);
    }

    public boi(byte b) {
        this(15000, null);
    }

    private boi(int i, String str) {
        this.O00000o0 = new BasicHttpContext();
        this.O00000oO = "UTF-8";
        this.O00000oo = bqg.O000000o();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
        String str2 = null;
        if (TextUtils.isEmpty(null)) {
            str2 = TextUtils.isEmpty(null) ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : str2;
            Locale locale = Locale.getDefault();
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = Build.VERSION.RELEASE;
            if (str3.length() > 0) {
                stringBuffer.append(str3);
            } else {
                stringBuffer.append("1.0");
            }
            stringBuffer.append("; ");
            String language = locale.getLanguage();
            if (language != null) {
                stringBuffer.append(language.toLowerCase());
                String country = locale.getCountry();
                if (country != null) {
                    stringBuffer.append("-");
                    stringBuffer.append(country.toLowerCase());
                }
            } else {
                stringBuffer.append("en");
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String str4 = Build.MODEL;
                if (str4.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(str4);
                }
            }
            String str5 = Build.ID;
            if (str5.length() > 0) {
                stringBuffer.append(" Build/");
                stringBuffer.append(str5);
            }
            str = String.format(str2, stringBuffer, "Mobile ");
        }
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", bqp.O000000o(), 443));
        this.O00000Oo = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.O00000Oo.setHttpRequestRetryHandler(new bqq());
        this.O00000Oo.addRequestInterceptor(new HttpRequestInterceptor() {
            /* class _m_j.boi.AnonymousClass1 */

            public final void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
                if (!httpRequest.containsHeader("Accept-Encoding")) {
                    httpRequest.addHeader("Accept-Encoding", "gzip");
                }
            }
        });
        this.O00000Oo.addResponseInterceptor(new HttpResponseInterceptor() {
            /* class _m_j.boi.AnonymousClass2 */

            public final void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                    for (HeaderElement name : contentEncoding.getElements()) {
                        if (name.getName().equalsIgnoreCase("gzip")) {
                            httpResponse.setEntity(new bqt(httpResponse.getEntity()));
                            return;
                        }
                    }
                }
            }
        });
    }

    public final <T> HttpHandler<T> O000000o(HttpRequest.HttpMethod httpMethod, String str, bqh bqh, bqm<T> bqm) {
        if (str != null) {
            com.lidroid.xutils.http.client.HttpRequest httpRequest = new com.lidroid.xutils.http.client.HttpRequest(httpMethod, str);
            HttpHandler<T> httpHandler = new HttpHandler<>(this.O00000Oo, this.O00000o0, this.O00000oO, bqm);
            httpHandler.O00000Oo = this.O00000oo;
            bql bql = this.O00000o;
            if (bql != null) {
                httpHandler.f4510O000000o = bql;
            }
            httpRequest.O000000o(bqh, httpHandler);
            httpHandler.O00000oo = bqh.O00000o;
            httpHandler.O000000o(O0000O0o, httpRequest);
            return httpHandler;
        }
        throw new IllegalArgumentException("url may not be null");
    }
}
