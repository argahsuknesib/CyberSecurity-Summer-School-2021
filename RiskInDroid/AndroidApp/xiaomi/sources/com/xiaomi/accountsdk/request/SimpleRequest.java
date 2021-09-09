package com.xiaomi.accountsdk.request;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.request.intercept.NetworkInterceptor;
import com.xiaomi.accountsdk.request.log.TransportLogHelper;
import com.xiaomi.accountsdk.utils.AccountRecentExceptionRecorder;
import com.xiaomi.accountsdk.utils.DiagnosisLog;
import com.xiaomi.accountsdk.utils.DiagnosisLogInterface;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.IOUtils;
import com.xiaomi.accountsdk.utils.ObjectUtils;
import com.xiaomi.accountsdk.utils.ServerTimeUtil;
import com.xiaomi.accountsdk.utils.VersionUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public final class SimpleRequest {
    public static final Logger log = Logger.getLogger(SimpleRequest.class.getSimpleName());
    public static ConnectivityListener sConnectivityListener;
    private static HttpURLConnectionFactory sHttpURLConnectionFactory = new HttpURLConnectionFactory() {
        /* class com.xiaomi.accountsdk.request.SimpleRequest.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.security.KeyManagementException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.lang.IllegalStateException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.security.KeyStoreException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.security.NoSuchAlgorithmException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        public final HttpURLConnection makeConn(URL url) throws IOException {
            if (SimpleRequest.sConnectivityListener != null) {
                SimpleRequest.sConnectivityListener.onOpenUrlConnection(url);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (Build.VERSION.SDK_INT <= 19 && (httpURLConnection instanceof HttpsURLConnection)) {
                try {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(TlsCompatSocketFactory.sslSocketFactory());
                } catch (NoSuchAlgorithmException e) {
                    SimpleRequest.log.log(Level.SEVERE, "SimpleRequest", (Throwable) e);
                } catch (KeyStoreException e2) {
                    SimpleRequest.log.log(Level.SEVERE, "SimpleRequest", (Throwable) e2);
                } catch (IllegalStateException e3) {
                    SimpleRequest.log.log(Level.SEVERE, "SimpleRequest", (Throwable) e3);
                } catch (KeyManagementException e4) {
                    SimpleRequest.log.log(Level.SEVERE, "SimpleRequest", (Throwable) e4);
                }
            }
            return httpURLConnection;
        }
    };
    private static RequestLoggerForTest sRequestLoggerForTest = null;

    public interface HttpURLConnectionFactory {
        HttpURLConnection makeConn(URL url) throws IOException;
    }

    public interface RequestLoggerForTest {
        void log(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z, Integer num, Map<String, String> map4);
    }

    public static void setConnectivityListener(ConnectivityListener connectivityListener) {
        sConnectivityListener = connectivityListener;
    }

    static void injectHttpURLConnectionFactoryForTest(HttpURLConnectionFactory httpURLConnectionFactory) {
        sHttpURLConnectionFactory = httpURLConnectionFactory;
    }

    static HttpURLConnectionFactory getHttpURLConnectionFactoryForTest() {
        return sHttpURLConnectionFactory;
    }

    public static void setRequestLoggerForTest(RequestLoggerForTest requestLoggerForTest) {
        sRequestLoggerForTest = requestLoggerForTest;
    }

    public static void resetRequestLoggerForTest() {
        setRequestLoggerForTest(null);
    }

    private static String appendUrl(String str, Map<String, String> map) {
        if (str != null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
            }
            return buildUpon.build().toString();
        }
        throw new NullPointerException("origin is not allowed null");
    }

    public static StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return getAsString(str, map, null, map2, z, null);
    }

    public static StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return getAsString(str, map, map2, map3, z, null);
    }

    public static StringContent getAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z, Integer num) throws IOException, AccessDeniedException, AuthenticationFailureException {
        Integer num2;
        BufferedReader bufferedReader;
        String headerField;
        String str2 = str;
        RequestLoggerForTest requestLoggerForTest = sRequestLoggerForTest;
        if (requestLoggerForTest != null) {
            requestLoggerForTest.log(str, map, map2, map3, z, num, null);
        }
        String appendUrl = appendUrl(str, map);
        String logGetRequest = getDiagnosisLogger().logGetRequest(str, map, appendUrl, map2, map3);
        long currentTimeMillis = System.currentTimeMillis();
        NetworkInterceptor.get().onBegin(logGetRequest, "GET", str2);
        TransportLogHelper.logRequestStarted();
        HttpURLConnection makeConn = makeConn(appendUrl, map3, map2, num);
        if (makeConn != null) {
            try {
                makeConn.setDoInput(true);
                makeConn.setRequestMethod("GET");
                makeConn.connect();
                int responseCode = makeConn.getResponseCode();
                Integer valueOf = Integer.valueOf(responseCode);
                try {
                    getDiagnosisLogger().logResponseCode(logGetRequest, responseCode);
                    if (!(ServerTimeUtil.getComputer() == null || (headerField = makeConn.getHeaderField("Date")) == null)) {
                        ServerTimeUtil.getComputer().alignWithServerDateHeader(str2, headerField);
                    }
                    if (responseCode != 200) {
                        if (responseCode != 302) {
                            if (responseCode == 403) {
                                throw new AccessDeniedException(responseCode, "access denied, encrypt error or user is forbidden to access the resource");
                            } else if (responseCode == 401 || responseCode == 400) {
                                AuthenticationFailureException authenticationFailureException = new AuthenticationFailureException(responseCode, "authentication failure for get, code: ".concat(String.valueOf(responseCode)));
                                authenticationFailureException.setWwwAuthenticateHeader(makeConn.getHeaderField("WWW-Authenticate"));
                                authenticationFailureException.setCaDisableSecondsHeader(makeConn.getHeaderField("CA-DISABLE-SECONDS"));
                                throw authenticationFailureException;
                            } else {
                                log.info("http status error when GET: ".concat(String.valueOf(responseCode)));
                                if (responseCode == 301) {
                                    log.info("unexpected redirect from " + makeConn.getURL().getHost() + " to " + makeConn.getHeaderField("Location"));
                                }
                                throw new IOException("unexpected http res code: ".concat(String.valueOf(responseCode)));
                            }
                        }
                    }
                    Map<String, List<String>> headerFields = makeConn.getHeaderFields();
                    CookieManager cookieManager = new CookieManager();
                    URI create = URI.create(appendUrl);
                    cookieManager.put(create, headerFields);
                    Map<String, String> parseCookies = parseCookies(cookieManager.getCookieStore().get(create));
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        bufferedReader = new BufferedReader(new InputStreamReader(makeConn.getInputStream()), 1024);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        IOUtils.closeQuietly(bufferedReader);
                    }
                    String sb2 = sb.toString();
                    String str3 = sb2;
                    Map<String, List<String>> map4 = headerFields;
                    NetworkInterceptor.get().onSuccess(logGetRequest, "GET", str, currentTimeMillis, responseCode, sb2.length());
                    StringContent stringContent = new StringContent(str3);
                    stringContent.putCookies(parseCookies);
                    stringContent.putHeaders(ObjectUtils.listToMap(map4));
                    stringContent.setHttpCode(responseCode);
                    getDiagnosisLogger().logResponse(logGetRequest, str3, map4, parseCookies);
                    TransportLogHelper.logRequestSuccessed();
                    makeConn.disconnect();
                    return stringContent;
                } catch (Exception e) {
                    e = e;
                    num2 = valueOf;
                    try {
                        NetworkInterceptor.get().onException(logGetRequest, "GET", str, currentTimeMillis, e, num2);
                        getDiagnosisLogger().logRequestException(e);
                        TransportLogHelper.logRequestException(e);
                        AccountRecentExceptionRecorder.getInstance().recordAccountRequestException(e);
                        throw e;
                    } catch (Throwable th) {
                        makeConn.disconnect();
                        throw th;
                    }
                } catch (Throwable th2) {
                    IOUtils.closeQuietly(bufferedReader);
                    throw th2;
                }
            } catch (Exception e2) {
                e = e2;
                num2 = null;
                NetworkInterceptor.get().onException(logGetRequest, "GET", str, currentTimeMillis, e, num2);
                getDiagnosisLogger().logRequestException(e);
                TransportLogHelper.logRequestException(e);
                AccountRecentExceptionRecorder.getInstance().recordAccountRequestException(e);
                throw e;
            }
        } else {
            log.severe("failed to create URLConnection");
            throw new IOException("failed to create connection");
        }
    }

    private static DiagnosisLogInterface getDiagnosisLogger() {
        return DiagnosisLog.get();
    }

    public static StreamContent getAsStream(String str, Map<String, String> map, Map<String, String> map2) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return getAsStream(str, map, map2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0110, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0111, code lost:
        r9 = java.lang.Integer.valueOf(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x013b, code lost:
        throw new java.io.IOException("protocol error");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ExcHandler: ProtocolException (unused java.net.ProtocolException), SYNTHETIC, Splitter:B:3:0x002f] */
    public static StreamContent getAsStream(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws IOException, AccessDeniedException, AuthenticationFailureException {
        String appendUrl = appendUrl(str, map);
        Map<String, String> map4 = map3;
        String logGetRequest = getDiagnosisLogger().logGetRequest(str, map, appendUrl, map4, map2);
        long currentTimeMillis = System.currentTimeMillis();
        NetworkInterceptor.get().onBegin(logGetRequest, "GET", str);
        TransportLogHelper.logRequestStarted();
        HttpURLConnection makeConn = makeConn(appendUrl, map2, map4, null);
        if (makeConn != null) {
            try {
                makeConn.setDoInput(true);
                makeConn.setRequestMethod("GET");
                makeConn.setInstanceFollowRedirects(true);
                makeConn.connect();
                int responseCode = makeConn.getResponseCode();
                getDiagnosisLogger().logResponseCode(logGetRequest, responseCode);
                if (responseCode == 200) {
                    Map<String, List<String>> headerFields = makeConn.getHeaderFields();
                    CookieManager cookieManager = new CookieManager();
                    URI create = URI.create(appendUrl);
                    cookieManager.put(create, headerFields);
                    Map<String, String> parseCookies = parseCookies(cookieManager.getCookieStore().get(create));
                    parseCookies.putAll(ObjectUtils.listToMap(headerFields));
                    StreamContent streamContent = new StreamContent(makeConn.getInputStream());
                    streamContent.putHeaders(parseCookies);
                    NetworkInterceptor.get().onSuccess(logGetRequest, "GET", str, currentTimeMillis, responseCode, 0);
                    TransportLogHelper.logRequestSuccessed();
                    return streamContent;
                } else if (responseCode == 403) {
                    throw new AccessDeniedException(responseCode, "access denied, encrypt error or user is forbidden to access the resource");
                } else if (responseCode == 401 || responseCode == 400) {
                    AuthenticationFailureException authenticationFailureException = new AuthenticationFailureException(responseCode, "authentication failure for get, code: ".concat(String.valueOf(responseCode)));
                    authenticationFailureException.setWwwAuthenticateHeader(makeConn.getHeaderField("WWW-Authenticate"));
                    authenticationFailureException.setCaDisableSecondsHeader(makeConn.getHeaderField("CA-DISABLE-SECONDS"));
                    throw authenticationFailureException;
                } else {
                    log.info("http status error when GET: ".concat(String.valueOf(responseCode)));
                    if (responseCode == 301) {
                        log.info("unexpected redirect from " + makeConn.getURL().getHost() + " to " + makeConn.getHeaderField("Location"));
                    }
                    throw new IOException("unexpected http res code: ".concat(String.valueOf(responseCode)));
                }
            } catch (ProtocolException unused) {
            } catch (Exception e) {
                e = e;
                Integer num = null;
                NetworkInterceptor.get().onException(logGetRequest, "GET", str, currentTimeMillis, e, num);
                getDiagnosisLogger().logRequestException(e);
                TransportLogHelper.logRequestException(e);
                AccountRecentExceptionRecorder.getInstance().recordAccountRequestException(e);
                throw e;
            }
        } else {
            log.severe("failed to create URLConnection");
            throw new IOException("failed to create connection");
        }
    }

    public static MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return getAsMap(str, map, map2, null, z);
    }

    public static MapContent getAsMap(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return convertStringToMap(getAsString(str, map, map3, map2, z));
    }

    public static StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return postAsString(str, map, map2, null, null, z, null);
    }

    public static StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z, Integer num) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return postAsString(str, map, map2, map3, null, z, num);
    }

    public static StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return postAsString(str, map, map2, map3, map4, z, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b9, code lost:
        com.xiaomi.accountsdk.utils.IOUtils.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01bc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01f8, code lost:
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        throw new java.io.IOException("protocol error");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[ExcHandler: ProtocolException (unused java.net.ProtocolException), SYNTHETIC, Splitter:B:9:0x0057] */
    public static StringContent postAsString(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, boolean z, Integer num) throws IOException, AccessDeniedException, AuthenticationFailureException {
        BufferedOutputStream bufferedOutputStream;
        String str2 = str;
        Map<String, String> map5 = map;
        Map<String, String> map6 = map3;
        Map<String, String> map7 = map4;
        RequestLoggerForTest requestLoggerForTest = sRequestLoggerForTest;
        if (requestLoggerForTest != null) {
            requestLoggerForTest.log(str, map, map3, map2, z, num, map4);
        }
        String appendUrl = map7 != null ? appendUrl(str2, map7) : str2;
        String logPostRequest = getDiagnosisLogger().logPostRequest(str, map4, appendUrl, map, map2, map3);
        long currentTimeMillis = System.currentTimeMillis();
        NetworkInterceptor.get().onBegin(logPostRequest, "POST", str2);
        TransportLogHelper.logRequestStarted();
        HttpURLConnection makeConn = makeConn(appendUrl, map2, map6, num);
        if (makeConn != null) {
            try {
                makeConn.setDoInput(true);
                makeConn.setDoOutput(true);
                makeConn.setRequestMethod("POST");
                makeConn.connect();
                if (map5 != null && !map.isEmpty()) {
                    String encodeFormatAndJoinMap = encodeFormatAndJoinMap(map5, "&");
                    bufferedOutputStream = new BufferedOutputStream(makeConn.getOutputStream());
                    bufferedOutputStream.write(encodeFormatAndJoinMap.getBytes("utf-8"));
                    IOUtils.closeQuietly(bufferedOutputStream);
                }
                int responseCode = makeConn.getResponseCode();
                Integer valueOf = Integer.valueOf(responseCode);
                getDiagnosisLogger().logResponseCode(logPostRequest, responseCode);
                if (responseCode != 200) {
                    if (responseCode != 302) {
                        if (responseCode == 403) {
                            throw new AccessDeniedException(responseCode, "access denied, encrypt error or user is forbidden to access the resource");
                        } else if (responseCode == 401 || responseCode == 400) {
                            AuthenticationFailureException authenticationFailureException = new AuthenticationFailureException(responseCode, "authentication failure for post, code: ".concat(String.valueOf(responseCode)));
                            authenticationFailureException.setWwwAuthenticateHeader(makeConn.getHeaderField("WWW-Authenticate"));
                            authenticationFailureException.setCaDisableSecondsHeader(makeConn.getHeaderField("CA-DISABLE-SECONDS"));
                            throw authenticationFailureException;
                        } else {
                            log.info("http status error when POST: ".concat(String.valueOf(responseCode)));
                            if (responseCode == 301) {
                                log.info("unexpected redirect from " + makeConn.getURL().getHost() + " to " + makeConn.getHeaderField("Location"));
                            }
                            throw new IOException("unexpected http res code: ".concat(String.valueOf(responseCode)));
                        }
                    }
                }
                Map<String, List<String>> headerFields = makeConn.getHeaderFields();
                URI create = URI.create(appendUrl);
                String host = create.getHost();
                final HashSet hashSet = new HashSet();
                hashSet.add(host);
                if (map6 != null && map6.containsKey("host")) {
                    hashSet.add(map6.get("host"));
                }
                if (hashSet.contains("c.id.mi.com")) {
                    hashSet.add("account.xiaomi.com");
                }
                CookieManager cookieManager = new CookieManager(null, new CookiePolicy() {
                    /* class com.xiaomi.accountsdk.request.SimpleRequest.AnonymousClass2 */

                    public final boolean shouldAccept(URI uri, HttpCookie httpCookie) {
                        String domain = httpCookie.getDomain();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            if (HttpCookie.domainMatches(domain, (String) it.next())) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
                cookieManager.put(create, headerFields);
                HashMap hashMap = new HashMap();
                CookieStore cookieStore = cookieManager.getCookieStore();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Map<String, String> parseCookies = parseCookies(cookieStore.get(URI.create(appendUrl.replaceFirst(host, (String) it.next()))));
                    if (parseCookies != null) {
                        hashMap.putAll(parseCookies);
                    }
                }
                StringBuilder sb = new StringBuilder();
                if (z) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(makeConn.getInputStream()), 1024);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    IOUtils.closeQuietly(bufferedReader);
                }
                String sb2 = sb.toString();
                Map<String, List<String>> map8 = headerFields;
                NetworkInterceptor.get().onSuccess(logPostRequest, "POST", str, currentTimeMillis, responseCode, sb2.length());
                StringContent stringContent = new StringContent(sb2);
                stringContent.putCookies(hashMap);
                stringContent.setHttpCode(responseCode);
                stringContent.putHeaders(ObjectUtils.listToMap(map8));
                getDiagnosisLogger().logResponse(logPostRequest, sb2, map8, hashMap);
                TransportLogHelper.logRequestSuccessed();
                makeConn.disconnect();
                return stringContent;
            } catch (ProtocolException unused) {
            } catch (Exception e) {
                e = e;
                Integer num2 = null;
                try {
                    NetworkInterceptor.get().onException(logPostRequest, "POST", str, currentTimeMillis, e, num2);
                    getDiagnosisLogger().logRequestException(e);
                    TransportLogHelper.logRequestException(e);
                    AccountRecentExceptionRecorder.getInstance().recordAccountRequestException(e);
                    throw e;
                } catch (Throwable th) {
                    makeConn.disconnect();
                    throw th;
                }
            } catch (Throwable th2) {
                IOUtils.closeQuietly(bufferedOutputStream);
                throw th2;
            }
        } else {
            log.severe("failed to create URLConnection");
            throw new IOException("failed to create connection");
        }
    }

    public static MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return postAsMap(str, map, map2, null, z);
    }

    public static MapContent postAsMap(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z) throws IOException, AccessDeniedException, AuthenticationFailureException {
        return convertStringToMap(postAsString(str, map, map2, map3, (Map<String, String>) null, z));
    }

    protected static MapContent convertStringToMap(StringContent stringContent) {
        JSONObject jSONObject;
        if (stringContent == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(stringContent.getBody());
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        MapContent mapContent = new MapContent(ObjectUtils.jsonToMap(jSONObject));
        mapContent.putHeaders(stringContent.getHeaders());
        return mapContent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (android.text.TextUtils.isEmpty(r5.get("User-Agent")) != false) goto L_0x0053;
     */
    protected static HttpURLConnection makeConn(String str, Map<String, String> map, Map<String, String> map2, Integer num) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        if (url == null) {
            log.severe("failed to init url");
            return null;
        }
        if (num == null) {
            num = 30000;
        }
        try {
            CookieHandler.setDefault(null);
            HttpURLConnection makeConn = sHttpURLConnectionFactory.makeConn(url);
            boolean z = false;
            makeConn.setInstanceFollowRedirects(false);
            makeConn.setConnectTimeout(num.intValue());
            makeConn.setReadTimeout(num.intValue());
            makeConn.setUseCaches(false);
            makeConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (map2 != null) {
            }
            z = true;
            if (z && !TextUtils.isEmpty(XMPassportSettings.getUserAgent())) {
                makeConn.setRequestProperty("User-Agent", XMPassportSettings.getUserAgent());
            }
            if (map == null) {
                map = new EasyMap<>();
            }
            map.put("sdkVersion", VersionUtils.getVersion());
            makeConn.setRequestProperty("Cookie", joinMap(map, "; "));
            if (map2 != null) {
                for (String next : map2.keySet()) {
                    makeConn.setRequestProperty(next, map2.get(next));
                }
            }
            return makeConn;
        } catch (Exception e2) {
            e2.printStackTrace();
            AccountRecentExceptionRecorder.getInstance().recordAccountRequestException(e2);
            return null;
        }
    }

    private static String encodeFormatAndJoinMap(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(str);
            }
            String encode = encode((String) next.getKey());
            String encode2 = !TextUtils.isEmpty((CharSequence) next.getValue()) ? encode((String) next.getValue()) : "";
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected static String joinMap(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(str);
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
        }
        return sb.toString();
    }

    protected static Map<String, String> parseCookies(List<HttpCookie> list) {
        HashMap hashMap = new HashMap();
        for (HttpCookie next : list) {
            if (!next.hasExpired()) {
                String name = next.getName();
                String value = next.getValue();
                if (name != null) {
                    hashMap.put(name, value);
                }
            }
        }
        return hashMap;
    }

    public static class HeaderContent {
        private final Set<String> cookieKeys = new HashSet();
        private final Map<String, String> headers = new HashMap();
        private int httpCode = -1;

        public void putHeader(String str, String str2) {
            this.headers.put(str, str2);
        }

        public String getHeader(String str) {
            return this.headers.get(str);
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public void putHeaders(Map<String, String> map) {
            this.headers.putAll(map);
        }

        public void putCookies(Map<String, String> map) {
            putHeaders(map);
            if (map != null) {
                this.cookieKeys.addAll(map.keySet());
            }
        }

        public Set<String> getCookieKeys() {
            return this.cookieKeys;
        }

        public int getHttpCode() {
            return this.httpCode;
        }

        public void setHttpCode(int i) {
            this.httpCode = i;
        }

        public String toString() {
            return "HeaderContent{headers=" + this.headers + '}';
        }
    }

    public static class StringContent extends HeaderContent {
        private String body;

        public StringContent(String str) {
            this.body = str;
        }

        public String getBody() {
            return this.body;
        }

        public String toString() {
            return "StringContent{body='" + this.body + '\'' + '}';
        }
    }

    public static class MapContent extends HeaderContent {
        private Map<String, Object> bodies;

        public MapContent(Map<String, Object> map) {
            this.bodies = map;
        }

        public Object getFromBody(String str) {
            return this.bodies.get(str);
        }

        public Map<String, Object> getBodies() {
            return this.bodies;
        }

        public String toString() {
            return "MapContent{bodies=" + this.bodies + '}';
        }
    }

    public static class StreamContent extends HeaderContent {
        private InputStream stream;

        public StreamContent(InputStream inputStream) {
            this.stream = inputStream;
        }

        public InputStream getStream() {
            return this.stream;
        }

        public void closeStream() {
            IOUtils.closeQuietly(this.stream);
        }
    }
}
