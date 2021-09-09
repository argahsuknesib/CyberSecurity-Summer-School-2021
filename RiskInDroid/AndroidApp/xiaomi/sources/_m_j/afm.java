package _m_j;

import java.io.IOException;
import java.util.ArrayList;

public final class afm extends aff {

    /* renamed from: O000000o  reason: collision with root package name */
    long f12375O000000o;
    public ArrayList<O000000o> O00000Oo = new ArrayList<>();

    public afm(xm xmVar, afd afd) throws IOException {
        super(xmVar, afd);
        this.f12375O000000o = xmVar.O0000O0o();
        for (int i = 0; ((long) i) < this.f12375O000000o; i++) {
            this.O00000Oo.add(new O000000o(xmVar.O0000O0o(), xmVar.O0000O0o()));
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        long f12376O000000o;
        public long O00000Oo;

        public O000000o(long j, long j2) {
            this.f12376O000000o = j;
            this.O00000Oo = j2;
        }
    }
}
