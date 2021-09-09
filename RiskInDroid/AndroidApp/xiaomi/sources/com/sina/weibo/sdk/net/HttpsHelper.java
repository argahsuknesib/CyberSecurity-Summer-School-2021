package com.sina.weibo.sdk.net;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class HttpsHelper {
    private SSLSocketFactory mSSLSocketFactory;

    private SSLSocketFactory getSSLSocketFactory(Context context) {
        if (this.mSSLSocketFactory == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                instance.setCertificateEntry("get_global_ca", loadCertificate(context));
                SSLContext instance2 = SSLContext.getInstance("TLS");
                instance2.init(null, new TrustManager[]{new CustomX509TrustManager(instance)}, null);
                this.mSSLSocketFactory = instance2.getSocketFactory();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            } catch (CertificateException e4) {
                e4.printStackTrace();
            } catch (KeyManagementException e5) {
                e5.printStackTrace();
            }
        }
        return this.mSSLSocketFactory;
    }

    private Certificate loadCertificate(Context context) throws CertificateException, IOException {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open("weibocn.cer"));
        try {
            return instance.generateCertificate(bufferedInputStream);
        } finally {
            bufferedInputStream.close();
        }
    }

    static class CustomX509TrustManager implements X509TrustManager {
        private List<X509TrustManager> mTrustManagers = new ArrayList();

        public CustomX509TrustManager(KeyStore... keyStoreArr) {
            ArrayList<TrustManagerFactory> arrayList = new ArrayList<>();
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                arrayList.add(instance);
                for (KeyStore init : keyStoreArr) {
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    instance2.init(init);
                    arrayList.add(instance2);
                }
                for (TrustManagerFactory trustManagers : arrayList) {
                    for (TrustManager trustManager : trustManagers.getTrustManagers()) {
                        if (trustManager instanceof X509TrustManager) {
                            this.mTrustManagers.add((X509TrustManager) trustManager);
                        }
                    }
                }
                if (this.mTrustManagers.size() == 0) {
                    throw new RuntimeException("Couldn't find any X509TrustManagers");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.mTrustManagers.get(0).checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            for (X509TrustManager checkServerTrusted : this.mTrustManagers) {
                checkServerTrusted.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.mTrustManagers) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        }
    }
}
