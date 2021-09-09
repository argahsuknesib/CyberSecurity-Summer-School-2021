package _m_j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class jqi implements jqn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final X509TrustManager f2056O000000o;
    private final Method O00000Oo;

    private jqi(X509TrustManager x509TrustManager, Method method) {
        this.O00000Oo = method;
        this.f2056O000000o = x509TrustManager;
    }

    public static jqn O000000o(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new jqi(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final X509Certificate O000000o(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.O00000Oo.invoke(this.f2056O000000o, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException unused2) {
        }
        return null;
    }
}
