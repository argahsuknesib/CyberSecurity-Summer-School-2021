package _m_j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class ine implements ini {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final inu f1493O000000o = new ioe();
    private ioh O00000Oo;
    private inc O00000o;
    private String[] O00000o0;
    private inc O00000oO;

    public final ini O000000o(inh inh) {
        return this;
    }

    ine(ioh ioh) {
        this.O00000Oo = ioh;
    }

    public final ini O000000o(String... strArr) {
        this.O00000o0 = strArr;
        return this;
    }

    public final ini O000000o(inc inc) {
        this.O00000o = inc;
        return this;
    }

    public final ini O00000Oo(inc inc) {
        this.O00000oO = inc;
        return this;
    }

    public final void O000000o() {
        ioh ioh = this.O00000Oo;
        String[] strArr = this.O00000o0;
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!f1493O000000o.O000000o(ioh.O000000o(), str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            inc inc = this.O00000oO;
            if (inc != null) {
                inc.onAction(arrayList);
            }
        } else if (this.O00000o != null) {
            List asList = Arrays.asList(this.O00000o0);
            try {
                this.O00000o.onAction(asList);
            } catch (Exception unused) {
                inc inc2 = this.O00000oO;
                if (inc2 != null) {
                    inc2.onAction(asList);
                }
            }
        }
    }
}
