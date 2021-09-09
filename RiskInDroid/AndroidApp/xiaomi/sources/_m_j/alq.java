package _m_j;

import java.lang.reflect.Member;
import java.util.HashMap;

public final class alq {

    /* renamed from: O000000o  reason: collision with root package name */
    final ajq f12437O000000o;
    final boolean O00000Oo;
    protected anq O00000o;
    protected ank O00000o0;
    protected anq O00000oO;
    protected anq O00000oo;
    protected anq O0000O0o;
    protected anq O0000OOo;
    protected ale[] O0000Oo;
    protected anq O0000Oo0;
    protected anq O0000OoO;
    protected ale[] O0000Ooo = null;

    public alq(ajq ajq, boolean z) {
        this.f12437O000000o = ajq;
        this.O00000Oo = z;
    }

    public final aln O000000o(ajs ajs) {
        ajv O000000o2;
        anc anc = new anc(ajs, this.f12437O000000o.O000000o());
        if (this.O0000Oo0 == null) {
            O000000o2 = null;
        } else {
            ale[] aleArr = this.O0000Oo;
            int i = 0;
            if (aleArr != null) {
                int length = aleArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (this.O0000Oo[i2] == null) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            O000000o2 = this.f12437O000000o.O00000oo().O000000o(this.O0000Oo0.O000000o(i));
        }
        anc.O000000o(this.O00000o0, this.O0000Oo0, O000000o2, this.O0000Oo, this.O0000OoO, this.O0000Ooo);
        anc.O000000o(this.O00000o);
        anc.O00000Oo(this.O00000oO);
        anc.O00000o0(this.O00000oo);
        anc.O00000o(this.O0000O0o);
        anc.O00000oO(this.O0000OOo);
        return anc;
    }

    public final void O000000o(ank ank) {
        this.O00000o0 = ank;
    }

    public final void O000000o(anq anq) {
        this.O00000o = O000000o(anq, this.O00000o, "String");
    }

    public final void O00000Oo(anq anq) {
        this.O00000oO = O000000o(anq, this.O00000oO, "int");
    }

    public final void O00000o0(anq anq) {
        this.O00000oo = O000000o(anq, this.O00000oo, "long");
    }

    public final void O00000o(anq anq) {
        this.O0000O0o = O000000o(anq, this.O0000O0o, "double");
    }

    public final void O00000oO(anq anq) {
        this.O0000OOo = O000000o(anq, this.O0000OOo, "boolean");
    }

    public final void O000000o(anq anq, ale[] aleArr) {
        this.O0000Oo0 = O000000o(anq, this.O0000Oo0, "delegate");
        this.O0000Oo = aleArr;
    }

    public final void O00000Oo(anq anq, ale[] aleArr) {
        Integer num;
        this.O0000OoO = O000000o(anq, this.O0000OoO, "property-based");
        if (aleArr.length > 1) {
            HashMap hashMap = new HashMap();
            int length = aleArr.length;
            for (int i = 0; i < length; i++) {
                String O00000o2 = aleArr[i].O00000o();
                if ((O00000o2.length() != 0 || aleArr[i].O00000o0() == null) && (num = (Integer) hashMap.put(O00000o2, Integer.valueOf(i))) != null) {
                    throw new IllegalArgumentException("Duplicate creator property \"" + O00000o2 + "\" (index " + num + " vs " + i + ")");
                }
            }
        }
        this.O0000Ooo = aleArr;
    }

    private anq O000000o(anq anq, anq anq2, String str) {
        if (anq2 == null || anq2.getClass() != anq.getClass()) {
            if (this.O00000Oo) {
                asw.O000000o((Member) anq.O000000o());
            }
            return anq;
        }
        throw new IllegalArgumentException("Conflicting " + str + " creators: already had " + anq2 + ", encountered " + anq);
    }
}
