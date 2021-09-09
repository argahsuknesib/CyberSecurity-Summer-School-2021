package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class bpu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Class<?> f13187O000000o;
    protected String O00000Oo;
    protected List<O000000o> O00000o;
    protected bpx O00000o0;
    protected int O00000oO = 0;
    protected int O00000oo = 0;

    private bpu(Class<?> cls) {
        this.f13187O000000o = cls;
        this.O00000Oo = bqf.O000000o(cls);
    }

    public static bpu O000000o(Class<?> cls) {
        return new bpu(cls);
    }

    public final bpu O000000o(bpx bpx) {
        this.O00000o0 = bpx;
        return this;
    }

    public final bpu O000000o(String str, String str2, Object obj) {
        this.O00000o0 = bpx.O000000o(str, str2, obj);
        return this;
    }

    public final bpu O00000Oo(bpx bpx) {
        bpx bpx2 = this.O00000o0;
        bpx2.O000000o("AND (" + bpx.toString() + ")");
        return this;
    }

    public final bpu O00000o0(bpx bpx) {
        bpx bpx2 = this.O00000o0;
        bpx2.O000000o("OR (" + bpx.toString() + ")");
        return this;
    }

    public final bpu O000000o(String str) {
        if (this.O00000o == null) {
            this.O00000o = new ArrayList(2);
        }
        this.O00000o.add(new O000000o(str));
        return this;
    }

    public final bpu O000000o() {
        this.O00000oO = 1;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM ");
        sb.append(this.O00000Oo);
        bpx bpx = this.O00000o0;
        if (bpx != null && bpx.O000000o() > 0) {
            sb.append(" WHERE ");
            sb.append(this.O00000o0.toString());
        }
        if (this.O00000o != null) {
            for (int i = 0; i < this.O00000o.size(); i++) {
                sb.append(" ORDER BY ");
                sb.append(this.O00000o.get(i).toString());
            }
        }
        if (this.O00000oO > 0) {
            sb.append(" LIMIT ");
            sb.append(this.O00000oO);
            sb.append(" OFFSET ");
            sb.append(this.O00000oo);
        }
        return sb.toString();
    }

    public final Class<?> O00000Oo() {
        return this.f13187O000000o;
    }

    public class O000000o {
        private String O00000Oo;
        private boolean O00000o0;

        public O000000o(String str) {
            this.O00000Oo = str;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(this.O00000Oo));
            sb.append(this.O00000o0 ? " DESC" : " ASC");
            return sb.toString();
        }
    }
}
