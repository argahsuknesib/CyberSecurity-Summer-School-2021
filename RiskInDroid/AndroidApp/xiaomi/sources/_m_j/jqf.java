package _m_j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import ss.q;

public final class jqf {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jot f2053O000000o;
    private final jqo O00000Oo;
    private InetSocketAddress O00000o;
    private Proxy O00000o0;
    private List<Proxy> O00000oO = Collections.emptyList();
    private int O00000oo;
    private List<InetSocketAddress> O0000O0o = Collections.emptyList();
    private int O0000OOo;
    private final List<jou> O0000Oo0 = new ArrayList();

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo() {
        return this.O00000oo < this.O00000oO.size();
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o() {
        return !this.O0000Oo0.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o0() {
        return this.O0000OOo < this.O0000O0o.size();
    }

    public jqf(jot jot, jqo jqo) {
        this.f2053O000000o = jot;
        this.O00000Oo = jqo;
        q qVar = jot.f2001O000000o;
        Proxy proxy = jot.O0000OOo;
        if (proxy != null) {
            this.O00000oO = Collections.singletonList(proxy);
        } else {
            this.O00000oO = new ArrayList();
            List<Proxy> select = this.f2053O000000o.O0000O0o.select(qVar.O000000o());
            if (select != null) {
                this.O00000oO.addAll(select);
            }
            this.O00000oO.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.O00000oO.add(Proxy.NO_PROXY);
        }
        this.O00000oo = 0;
    }

    public final jou O000000o() throws IOException {
        while (true) {
            if (!O00000o0()) {
                if (!O00000Oo()) {
                    if (O00000o()) {
                        return this.O0000Oo0.remove(0);
                    }
                    throw new NoSuchElementException();
                } else if (O00000Oo()) {
                    List<Proxy> list = this.O00000oO;
                    int i = this.O00000oo;
                    this.O00000oo = i + 1;
                    Proxy proxy = list.get(i);
                    O000000o(proxy);
                    this.O00000o0 = proxy;
                } else {
                    throw new SocketException("No route to " + this.f2053O000000o.f2001O000000o.O00000Oo + "; exhausted proxy configurations: " + this.O00000oO);
                }
            }
            if (O00000o0()) {
                List<InetSocketAddress> list2 = this.O0000O0o;
                int i2 = this.O0000OOo;
                this.O0000OOo = i2 + 1;
                this.O00000o = list2.get(i2);
                jou jou = new jou(this.f2053O000000o, this.O00000o0, this.O00000o);
                if (!this.O00000Oo.O00000o0(jou)) {
                    return jou;
                }
                this.O0000Oo0.add(jou);
            } else {
                throw new SocketException("No route to " + this.f2053O000000o.f2001O000000o.O00000Oo + "; exhausted inet socket addresses: " + this.O0000O0o);
            }
        }
    }

    public final void O000000o(jou jou, IOException iOException) {
        if (!(jou.O00000Oo.type() == Proxy.Type.DIRECT || this.f2053O000000o.O0000O0o == null)) {
            this.f2053O000000o.O0000O0o.connectFailed(this.f2053O000000o.f2001O000000o.O000000o(), jou.O00000Oo.address(), iOException);
        }
        this.O00000Oo.O000000o(jou);
    }

    private void O000000o(Proxy proxy) throws IOException {
        String str;
        int i;
        this.O0000O0o = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f2053O000000o.f2001O000000o.O00000Oo;
            i = this.f2053O000000o.f2001O000000o.O00000o0;
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                str = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i <= 0 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.O0000O0o.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List<InetAddress> O000000o2 = this.f2053O000000o.O00000Oo.O000000o(str);
            int size = O000000o2.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.O0000O0o.add(new InetSocketAddress(O000000o2.get(i2), i));
            }
        }
        this.O0000OOo = 0;
    }
}
