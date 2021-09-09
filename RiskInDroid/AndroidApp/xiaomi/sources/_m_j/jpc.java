package _m_j;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import ss.ab;
import ss.g;

public final class jpc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jpc f2013O000000o;
    public static final jpc O00000Oo = new O000000o(f2013O000000o).O000000o(ab.TLS_1_0).O000000o().O00000Oo();
    public static final jpc O00000o0 = new O000000o(false).O00000Oo();
    private static final g[] O0000OOo = {g.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, g.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, g.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, g.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, g.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, g.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, g.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, g.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, g.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, g.TLS_RSA_WITH_AES_128_GCM_SHA256, g.TLS_RSA_WITH_AES_128_CBC_SHA, g.TLS_RSA_WITH_AES_256_CBC_SHA, g.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    /* access modifiers changed from: package-private */
    public final boolean O00000o;
    public final boolean O00000oO;
    /* access modifiers changed from: package-private */
    public final String[] O00000oo;
    /* access modifiers changed from: package-private */
    public final String[] O0000O0o;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2014O000000o;
        String[] O00000Oo;
        boolean O00000o;
        String[] O00000o0;

        public O000000o(jpc jpc) {
            this.f2014O000000o = jpc.O00000o;
            this.O00000Oo = jpc.O00000oo;
            this.O00000o0 = jpc.O0000O0o;
            this.O00000o = jpc.O00000oO;
        }

        O000000o(boolean z) {
            this.f2014O000000o = z;
        }

        public final O000000o O000000o() {
            if (this.f2014O000000o) {
                this.O00000o = true;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public final O000000o O000000o(String... strArr) {
            if (!this.f2014O000000o) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.O00000Oo = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public final O000000o O000000o(ab... abVarArr) {
            if (this.f2014O000000o) {
                String[] strArr = new String[abVarArr.length];
                for (int i = 0; i < abVarArr.length; i++) {
                    strArr[i] = abVarArr[i].e;
                }
                return O00000Oo(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final O000000o O00000Oo(String... strArr) {
            if (!this.f2014O000000o) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.O00000o0 = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public final jpc O00000Oo() {
            return new jpc(this, (byte) 0);
        }
    }

    /* synthetic */ jpc(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private static boolean O000000o(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String O000000o2 : strArr) {
                if (jqp.O000000o(strArr2, O000000o2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean O000000o(SSLSocket sSLSocket) {
        if (!this.O00000o) {
            return false;
        }
        String[] strArr = this.O0000O0o;
        if (strArr != null && !O000000o(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.O00000oo;
        return strArr2 == null || O000000o(strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jpc)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        jpc jpc = (jpc) obj;
        boolean z = this.O00000o;
        if (z != jpc.O00000o) {
            return false;
        }
        return !z || (Arrays.equals(this.O00000oo, jpc.O00000oo) && Arrays.equals(this.O0000O0o, jpc.O0000O0o) && this.O00000oO == jpc.O00000oO);
    }

    public final int hashCode() {
        if (this.O00000o) {
            return ((((Arrays.hashCode(this.O00000oo) + 527) * 31) + Arrays.hashCode(this.O0000O0o)) * 31) + (this.O00000oO ^ true ? 1 : 0);
        }
        return 17;
    }

    private jpc(O000000o o000000o) {
        this.O00000o = o000000o.f2014O000000o;
        this.O00000oo = o000000o.O00000Oo;
        this.O0000O0o = o000000o.O00000o0;
        this.O00000oO = o000000o.O00000o;
    }

    public final String toString() {
        String str;
        List list;
        if (!this.O00000o) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.O00000oo;
        List list2 = null;
        int i = 0;
        String str2 = "[all enabled]";
        if (strArr != null) {
            if (strArr == null) {
                list = null;
            } else {
                g[] gVarArr = new g[strArr.length];
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.O00000oo;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    gVarArr[i2] = g.a(strArr2[i2]);
                    i2++;
                }
                list = jqp.O000000o(gVarArr);
            }
            str = list.toString();
        } else {
            str = str2;
        }
        String[] strArr3 = this.O0000O0o;
        if (strArr3 != null) {
            if (strArr3 != null) {
                ab[] abVarArr = new ab[strArr3.length];
                while (true) {
                    String[] strArr4 = this.O0000O0o;
                    if (i >= strArr4.length) {
                        break;
                    }
                    abVarArr[i] = ab.a(strArr4[i]);
                    i++;
                }
                list2 = jqp.O000000o(abVarArr);
            }
            str2 = list2.toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.O00000oO + ")";
    }

    static {
        O000000o o000000o = new O000000o(true);
        g[] gVarArr = O0000OOo;
        if (o000000o.f2014O000000o) {
            String[] strArr = new String[gVarArr.length];
            for (int i = 0; i < gVarArr.length; i++) {
                strArr[i] = gVarArr[i].aS;
            }
            f2013O000000o = o000000o.O000000o(strArr).O000000o(ab.TLS_1_2, ab.TLS_1_1, ab.TLS_1_0).O000000o().O00000Oo();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }
}
