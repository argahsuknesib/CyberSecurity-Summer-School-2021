package _m_j;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import ss.q;
import ss.u;

public final class jot {

    /* renamed from: O000000o  reason: collision with root package name */
    public final q f2001O000000o;
    public final jpg O00000Oo;
    final jov O00000o;
    public final SocketFactory O00000o0;
    public final List<u> O00000oO;
    public final List<jpc> O00000oo;
    public final ProxySelector O0000O0o;
    public final Proxy O0000OOo;
    public final HostnameVerifier O0000Oo;
    public final SSLSocketFactory O0000Oo0;
    public final joz O0000OoO;

    public final boolean equals(Object obj) {
        if (obj instanceof jot) {
            jot jot = (jot) obj;
            return this.f2001O000000o.equals(jot.f2001O000000o) && this.O00000Oo.equals(jot.O00000Oo) && this.O00000o.equals(jot.O00000o) && this.O00000oO.equals(jot.O00000oO) && this.O00000oo.equals(jot.O00000oo) && this.O0000O0o.equals(jot.O0000O0o) && jqp.O000000o(this.O0000OOo, jot.O0000OOo) && jqp.O000000o(this.O0000Oo0, jot.O0000Oo0) && jqp.O000000o(this.O0000Oo, jot.O0000Oo) && jqp.O000000o(this.O0000OoO, jot.O0000OoO);
        }
    }

    public final int hashCode() {
        int hashCode = (((((((((((this.f2001O000000o.hashCode() + 527) * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o.hashCode()) * 31) + this.O00000oO.hashCode()) * 31) + this.O00000oo.hashCode()) * 31) + this.O0000O0o.hashCode()) * 31;
        Proxy proxy = this.O0000OOo;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.O0000Oo0;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.O0000Oo;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        joz joz = this.O0000OoO;
        if (joz != null) {
            i = joz.hashCode();
        }
        return hashCode4 + i;
    }

    public jot(String str, int i, jpg jpg, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, joz joz, jov jov, Proxy proxy, List<u> list, List<jpc> list2, ProxySelector proxySelector) {
        String str2 = str;
        int i2 = i;
        jpg jpg2 = jpg;
        SocketFactory socketFactory2 = socketFactory;
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        jov jov2 = jov;
        ProxySelector proxySelector2 = proxySelector;
        q.a aVar = new q.a();
        String str3 = sSLSocketFactory2 != null ? "https" : "http";
        if (str3.equalsIgnoreCase("http")) {
            aVar.f15492O000000o = "http";
        } else if (str3.equalsIgnoreCase("https")) {
            aVar.f15492O000000o = "https";
        } else {
            throw new IllegalArgumentException("unexpected scheme: ".concat(str3));
        }
        if (str2 != null) {
            String O000000o2 = q.a.O000000o(str, 0, str.length());
            if (O000000o2 != null) {
                aVar.O00000o = O000000o2;
                if (i2 <= 0 || i2 > 65535) {
                    throw new IllegalArgumentException("unexpected port: ".concat(String.valueOf(i)));
                }
                aVar.O00000oO = i2;
                this.f2001O000000o = aVar.O00000Oo();
                if (jpg2 != null) {
                    this.O00000Oo = jpg2;
                    if (socketFactory2 != null) {
                        this.O00000o0 = socketFactory2;
                        if (jov2 != null) {
                            this.O00000o = jov2;
                            if (list != null) {
                                this.O00000oO = jqp.O000000o(list);
                                if (list2 != null) {
                                    this.O00000oo = jqp.O000000o(list2);
                                    if (proxySelector2 != null) {
                                        this.O0000O0o = proxySelector2;
                                        this.O0000OOo = proxy;
                                        this.O0000Oo0 = sSLSocketFactory2;
                                        this.O0000Oo = hostnameVerifier;
                                        this.O0000OoO = joz;
                                        return;
                                    }
                                    throw new NullPointerException("proxySelector == null");
                                }
                                throw new NullPointerException("connectionSpecs == null");
                            }
                            throw new NullPointerException("protocols == null");
                        }
                        throw new NullPointerException("proxyAuthenticator == null");
                    }
                    throw new NullPointerException("socketFactory == null");
                }
                throw new NullPointerException("dns == null");
            }
            throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
        }
        throw new NullPointerException("host == null");
    }
}
