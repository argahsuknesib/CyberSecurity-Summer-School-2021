package _m_j;

public final class bqv {

    /* renamed from: O000000o  reason: collision with root package name */
    final bqz f13206O000000o;
    final brc O00000Oo;
    private final String O00000o0;

    public bqv(String str, brc brc) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (brc != null) {
            this.O00000o0 = str;
            this.O00000Oo = brc;
            this.f13206O000000o = new bqz();
            O000000o("Content-Disposition", "form-data; name=\"" + this.O00000o0 + jdn.f1779O000000o);
            StringBuilder sb = new StringBuilder();
            sb.append(brc.O000000o());
            if (brc.O00000Oo() != null) {
                sb.append("; charset=");
                sb.append(brc.O00000Oo());
            }
            O000000o("Content-Type", sb.toString());
            O000000o("Content-Transfer-Encoding", brc.O00000o0());
        } else {
            throw new IllegalArgumentException("Body may not be null");
        }
    }

    private void O000000o(String str, String str2) {
        this.f13206O000000o.O000000o(new bqy(str, str2));
    }
}
