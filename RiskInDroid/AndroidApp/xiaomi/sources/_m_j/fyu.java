package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

public class fyu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17422O000000o = "MiWifiHttpClientManager";
    private static volatile fyu O00000oO;
    private static final Pattern O0000O0o = Pattern.compile("^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])$");
    public Object O00000Oo = new Object();
    public OkHttpClient O00000o = null;
    public OkHttpClient O00000o0 = null;
    private TrustManager[] O00000oo;
    private final HostnameVerifier O0000OOo = new HostnameVerifier() {
        /* class _m_j.fyu.AnonymousClass1 */

        public final boolean verify(String str, SSLSession sSLSession) {
            String str2 = fyu.f17422O000000o;
            fyc.O000000o(str2, "hostname : " + str + " ,sslSession : " + sSLSession.getPeerHost());
            if (fyu.this.O000000o(str)) {
                return true;
            }
            return str.equals(sSLSession.getPeerHost());
        }
    };

    public static fyu O000000o() {
        if (O00000oO == null) {
            synchronized (fyu.class) {
                O00000oO = new fyu();
            }
        }
        return O00000oO;
    }

    public final OkHttpClient O000000o(boolean z) {
        if (z) {
            return O00000o0();
        }
        return O00000Oo();
    }

    private OkHttpClient O00000Oo() {
        if (this.O00000o0 == null) {
            synchronized (this.O00000Oo) {
                if (this.O00000o0 == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    fkb.O000000o(builder);
                    this.O00000o0 = builder.connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
                }
            }
        }
        return this.O00000o0;
    }

    private OkHttpClient O00000o0() {
        if (this.O00000o == null) {
            synchronized (this.O00000Oo) {
                if (this.O00000o == null) {
                    try {
                        TrustManager[] O00000o2 = O00000o();
                        SSLContext instance = SSLContext.getInstance("TLS");
                        instance.init(null, new TrustManager[]{O00000o2[0]}, null);
                        SSLSocketFactory socketFactory = instance.getSocketFactory();
                        OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        fkb.O000000o(builder);
                        this.O00000o = builder.connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).sslSocketFactory(socketFactory, (X509TrustManager) O00000o2[0]).hostnameVerifier(this.O0000OOo).build();
                    } catch (NoSuchAlgorithmException e) {
                        fyc.O000000o(f17422O000000o, "callSpecificAPI,init httpClient error:", e);
                    } catch (KeyManagementException e2) {
                        fyc.O000000o(f17422O000000o, "callSpecificAPI,init httpClient error:", e2);
                    }
                }
            }
        }
        OkHttpClient okHttpClient = this.O00000o;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        fyc.O00000o0(f17422O000000o, "getPrivateCAHttpClient error,try getDefaultHttpClient");
        return O00000Oo();
    }

    public final HttpURLConnection O000000o(String str, boolean z) throws IOException {
        if (z) {
            return O00000Oo(str);
        }
        return O00000o0(str);
    }

    private HttpURLConnection O00000Oo(String str) throws IOException {
        HttpsURLConnection httpsURLConnection;
        try {
            if (this.O00000oo == null || this.O00000oo.length == 0) {
                this.O00000oo = O00000o();
            }
            SSLSocketFactory O000000o2 = O000000o(this.O00000oo);
            URL url = new URL(str);
            dxx.O000000o();
            httpsURLConnection = (HttpsURLConnection) dxx.O000000o(url);
            httpsURLConnection.setSSLSocketFactory(O000000o2);
            httpsURLConnection.setHostnameVerifier(this.O0000OOo);
        } catch (Exception e) {
            fyc.O00000Oo(f17422O000000o, "init HttpsURLConnection error : ", e);
            httpsURLConnection = null;
        }
        if (httpsURLConnection != null) {
            return httpsURLConnection;
        }
        return O00000o0(str);
    }

    private static HttpURLConnection O00000o0(String str) throws IOException {
        URL url = new URL(str);
        dxx.O000000o();
        return (HttpURLConnection) dxx.O000000o(url);
    }

    private static TrustManager[] O00000o() {
        BufferedInputStream bufferedInputStream = null;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(CommonApplication.getAppContext().getAssets().open("cert/miwifi_bundle.pem"));
            try {
                Certificate generateCertificate = instance.generateCertificate(bufferedInputStream2);
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load(null, null);
                instance2.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                TrustManager[] trustManagers = instance3.getTrustManagers();
                gbi.O000000o(bufferedInputStream2);
                return trustManagers;
            } catch (IOException e) {
                e = e;
                bufferedInputStream = bufferedInputStream2;
                fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,read cert error:", e);
                gbi.O000000o(bufferedInputStream);
                fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
                return new TrustManager[0];
            } catch (CertificateException e2) {
                e = e2;
                bufferedInputStream = bufferedInputStream2;
                fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,read cert error:", e);
                gbi.O000000o(bufferedInputStream);
                fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
                return new TrustManager[0];
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                bufferedInputStream = bufferedInputStream2;
                fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,init KeyStore error:", e);
                gbi.O000000o(bufferedInputStream);
                fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
                return new TrustManager[0];
            } catch (KeyStoreException e4) {
                e = e4;
                bufferedInputStream = bufferedInputStream2;
                fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,init KeyStore error:", e);
                gbi.O000000o(bufferedInputStream);
                fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
                return new TrustManager[0];
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                gbi.O000000o(bufferedInputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,read cert error:", e);
            gbi.O000000o(bufferedInputStream);
            fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
            return new TrustManager[0];
        } catch (CertificateException e6) {
            e = e6;
            fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,read cert error:", e);
            gbi.O000000o(bufferedInputStream);
            fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
            return new TrustManager[0];
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,init KeyStore error:", e);
            gbi.O000000o(bufferedInputStream);
            fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
            return new TrustManager[0];
        } catch (KeyStoreException e8) {
            e = e8;
            fyc.O000000o(f17422O000000o, "getMiWifiTrustManager,init KeyStore error:", e);
            gbi.O000000o(bufferedInputStream);
            fyc.O00000o(f17422O000000o, "getMiWifiTrustManager,return empty trust manager");
            return new TrustManager[0];
        } catch (Throwable th2) {
            th = th2;
            gbi.O000000o(bufferedInputStream);
            throw th;
        }
    }

    private static SSLSocketFactory O000000o(TrustManager[] trustManagerArr) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{trustManagerArr[0]}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (Exception e) {
            fyc.O00000Oo(f17422O000000o, "init SSLSocketFactory error : ", e);
            return null;
        }
    }

    public final boolean O000000o(String str) {
        synchronized (this.O00000Oo) {
            if (O0000O0o == null) {
                return false;
            }
            boolean matches = O0000O0o.matcher(str).matches();
            return matches;
        }
    }
}
