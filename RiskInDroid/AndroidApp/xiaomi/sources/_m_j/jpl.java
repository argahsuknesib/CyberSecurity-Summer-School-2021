package _m_j;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class jpl {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f2023O000000o;
    public boolean O00000Oo;
    private int O00000o = 0;
    private final List<jpc> O00000o0;

    public jpl(List<jpc> list) {
        this.O00000o0 = list;
    }

    private boolean O00000Oo(SSLSocket sSLSocket) {
        for (int i = this.O00000o; i < this.O00000o0.size(); i++) {
            if (this.O00000o0.get(i).O000000o(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final jpc O000000o(SSLSocket sSLSocket) throws IOException {
        jpc jpc;
        int i = this.O00000o;
        int size = this.O00000o0.size();
        while (true) {
            if (i >= size) {
                jpc = null;
                break;
            }
            jpc = this.O00000o0.get(i);
            if (jpc.O000000o(sSLSocket)) {
                this.O00000o = i + 1;
                break;
            }
            i++;
        }
        if (jpc != null) {
            this.f2023O000000o = O00000Oo(sSLSocket);
            jpn.O00000Oo.O000000o(jpc, sSLSocket, this.O00000Oo);
            return jpc;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.O00000Oo + ", modes=" + this.O00000o0 + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }
}
