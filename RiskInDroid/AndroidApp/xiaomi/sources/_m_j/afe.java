package _m_j;

import java.io.IOException;
import java.util.ArrayList;

public final class afe extends afd {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f12369O000000o;
    public long O00000Oo;
    public ArrayList<String> O00000o0 = new ArrayList<>();

    public afe(xm xmVar, afd afd) throws IOException {
        super(afd);
        this.f12369O000000o = xmVar.O00000Oo(4);
        this.O00000Oo = xmVar.O0000O0o();
        for (int i = 16; ((long) i) < this.O00000o; i += 4) {
            this.O00000o0.add(xmVar.O00000Oo(4));
        }
    }
}
