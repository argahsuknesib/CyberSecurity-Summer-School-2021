package _m_j;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ss.u;

public class jpr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final jpr f2030O000000o = O00000o0();

    static class O00000Oo extends jpr {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Method f2032O000000o;
        private final Method O00000Oo;
        private final Class<?> O00000o;
        private final Method O00000o0;
        private final Class<?> O00000oO;

        public O00000Oo(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.f2032O000000o = method;
            this.O00000Oo = method2;
            this.O00000o0 = method3;
            this.O00000o = cls;
            this.O00000oO = cls2;
        }

        public final void O000000o(SSLSocket sSLSocket) {
            try {
                this.O00000o0.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        public final void O000000o(SSLSocket sSLSocket, String str, List<u> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                u uVar = list.get(i);
                if (uVar != u.HTTP_1_0) {
                    arrayList.add(uVar.toString());
                }
            }
            try {
                Object newProxyInstance = Proxy.newProxyInstance(jpr.class.getClassLoader(), new Class[]{this.O00000o, this.O00000oO}, new O00000o0(arrayList));
                this.f2032O000000o.invoke(null, sSLSocket, newProxyInstance);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }

        public final String O00000Oo(SSLSocket sSLSocket) {
            try {
                O00000o0 o00000o0 = (O00000o0) Proxy.getInvocationHandler(this.O00000Oo.invoke(null, sSLSocket));
                if (!o00000o0.O00000Oo && o00000o0.O00000o0 == null) {
                    jpn.f2027O000000o.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                } else if (o00000o0.O00000Oo) {
                    return null;
                } else {
                    return o00000o0.O00000o0;
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    static class O00000o0 implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private final List<String> f2033O000000o;
        /* access modifiers changed from: private */
        public boolean O00000Oo;
        /* access modifiers changed from: private */
        public String O00000o0;

        public O00000o0(List<String> list) {
            this.f2033O000000o = list;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = jqp.O00000Oo;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.O00000Oo = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f2033O000000o;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            obj2 = this.f2033O000000o.get(0);
                            break;
                        } else if (this.f2033O000000o.contains(list.get(i))) {
                            obj2 = list.get(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    String str = (String) obj2;
                    this.O00000o0 = str;
                    return str;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.O00000o0 = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public static jpr O000000o() {
        return f2030O000000o;
    }

    static <T> T O000000o(Object obj, Class cls, String str) {
        do {
            Class<?> cls2 = obj.getClass();
            while (cls2 != Object.class) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null) {
                        if (cls.isInstance(obj2)) {
                            return cls.cast(obj2);
                        }
                    }
                    return null;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            }
            if (str.equals("delegate")) {
                break;
            }
            obj = O000000o(obj, Object.class, "delegate");
        } while (obj != null);
        return null;
    }

    public static String O00000Oo() {
        return "OkHttp";
    }

    private static jpr O00000o0() {
        Class<?> cls;
        jpq jpq;
        jpq jpq2;
        jpq jpq3;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                try {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
                    return new O00000Oo(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider"));
                } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                    return new jpr();
                }
            }
        }
        Class<?> cls4 = cls;
        jpq jpq4 = new jpq(null, "setUseSessionTickets", Boolean.TYPE);
        jpq jpq5 = new jpq(null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            jpq3 = new jpq(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            try {
                jpq = new jpq(null, "setAlpnProtocols", byte[].class);
                jpq2 = jpq3;
            } catch (ClassNotFoundException unused4) {
                jpq2 = jpq3;
                jpq = null;
                return new O000000o(cls4, jpq4, jpq5, jpq2, jpq);
            }
        } catch (ClassNotFoundException unused5) {
            jpq3 = null;
            jpq2 = jpq3;
            jpq = null;
            return new O000000o(cls4, jpq4, jpq5, jpq2, jpq);
        }
        return new O000000o(cls4, jpq4, jpq5, jpq2, jpq);
    }

    public jqn O000000o(X509TrustManager x509TrustManager) {
        return new jqm(x509TrustManager.getAcceptedIssuers());
    }

    public X509TrustManager O000000o(SSLSocketFactory sSLSocketFactory) {
        try {
            Object O000000o2 = O000000o(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (O000000o2 == null) {
                return null;
            }
            return (X509TrustManager) O000000o(O000000o2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void O000000o(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void O000000o(SSLSocket sSLSocket) {
    }

    public void O000000o(SSLSocket sSLSocket, String str, List<u> list) {
    }

    public String O00000Oo(SSLSocket sSLSocket) {
        return null;
    }

    static class O000000o extends jpr {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Class<?> f2031O000000o;
        private final jpq<Socket> O00000Oo;
        private final jpq<Socket> O00000o;
        private final jpq<Socket> O00000o0;
        private final jpq<Socket> O00000oO;

        public O000000o(Class<?> cls, jpq<Socket> jpq, jpq<Socket> jpq2, jpq<Socket> jpq3, jpq<Socket> jpq4) {
            this.f2031O000000o = cls;
            this.O00000Oo = jpq;
            this.O00000o0 = jpq2;
            this.O00000o = jpq3;
            this.O00000oO = jpq4;
        }

        public final jqn O000000o(X509TrustManager x509TrustManager) {
            jqn O000000o2 = jqi.O000000o(x509TrustManager);
            return O000000o2 != null ? O000000o2 : jpr.super.O000000o(x509TrustManager);
        }

        public final X509TrustManager O000000o(SSLSocketFactory sSLSocketFactory) {
            Object O000000o2 = O000000o(sSLSocketFactory, this.f2031O000000o, "sslParameters");
            if (O000000o2 == null) {
                try {
                    O000000o2 = O000000o(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException unused) {
                    return jpr.super.O000000o(sSLSocketFactory);
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) O000000o(O000000o2, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) O000000o(O000000o2, X509TrustManager.class, "trustManager");
        }

        public final void O000000o(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e) {
                if (jqp.O000000o(e)) {
                    throw new IOException(e);
                }
                throw e;
            } catch (SecurityException e2) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
        }

        public final String O00000Oo(SSLSocket sSLSocket) {
            byte[] bArr;
            jpq<Socket> jpq = this.O00000o;
            if (jpq == null || !jpq.O000000o(sSLSocket) || (bArr = (byte[]) this.O00000o.O00000Oo(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, jqp.O00000o0);
        }

        public final void O000000o(SSLSocket sSLSocket, String str, List<u> list) {
            if (str != null) {
                this.O00000Oo.O000000o(sSLSocket, Boolean.TRUE);
                this.O00000o0.O000000o(sSLSocket, str);
            }
            jpq<Socket> jpq = this.O00000oO;
            if (jpq != null && jpq.O000000o(sSLSocket)) {
                Object[] objArr = new Object[1];
                iql iql = new iql();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    u uVar = list.get(i);
                    if (uVar != u.HTTP_1_0) {
                        iql.O0000OOo(uVar.toString().length());
                        iql.O00000Oo(uVar.toString());
                    }
                }
                objArr[0] = iql.O0000o0O();
                this.O00000oO.O00000Oo(sSLSocket, objArr);
            }
        }
    }
}
