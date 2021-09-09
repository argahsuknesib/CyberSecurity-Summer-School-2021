package _m_j;

import java.util.Formatter;

class igm {

    /* renamed from: O000000o  reason: collision with root package name */
    final igj f1275O000000o;
    final igk[] O00000Oo;

    igm(igj igj) {
        this.f1275O000000o = new igj(igj);
        this.O00000Oo = new igk[((igj.O0000Oo0 - igj.O0000OOo) + 1)];
    }

    /* access modifiers changed from: package-private */
    public final igk O000000o(int i) {
        igk igk;
        igk igk2;
        igk O00000o0 = O00000o0(i);
        if (O00000o0 != null) {
            return O00000o0;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int O00000Oo2 = O00000Oo(i) - i2;
            if (O00000Oo2 >= 0 && (igk2 = this.O00000Oo[O00000Oo2]) != null) {
                return igk2;
            }
            int O00000Oo3 = O00000Oo(i) + i2;
            igk[] igkArr = this.O00000Oo;
            if (O00000Oo3 < igkArr.length && (igk = igkArr[O00000Oo3]) != null) {
                return igk;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo(int i) {
        return i - this.f1275O000000o.O0000OOo;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, igk igk) {
        this.O00000Oo[O00000Oo(i)] = igk;
    }

    /* access modifiers changed from: package-private */
    public final igk O00000o0(int i) {
        return this.O00000Oo[O00000Oo(i)];
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i = 0;
        for (igk igk : this.O00000Oo) {
            if (igk == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i));
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(igk.O00000oO), Integer.valueOf(igk.O00000o));
                i++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
