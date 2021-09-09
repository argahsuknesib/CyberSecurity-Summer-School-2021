package _m_j;

import _m_j.emh;
import com.xiaomi.push.fg;
import com.xiaomi.push.fh;
import com.xiaomi.push.fi;
import com.xiaomi.push.jf;
import com.xiaomi.push.jr;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public final class erm {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15748O000000o = false;
    int O00000Oo;
    private String O00000o;
    long O00000o0;
    private erl O00000oO;
    private emh O00000oo = emh.O000000o.O00000o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final erm f15749O000000o = new erm();
    }

    public static erl O000000o() {
        erl erl;
        synchronized (O000000o.f15749O000000o) {
            erl = O000000o.f15749O000000o.O00000oO;
        }
        return erl;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(fh fhVar) {
        this.O00000oo.O000000o(fhVar);
    }

    public final synchronized void O000000o(XMPushService xMPushService) {
        this.O00000oO = new erl(xMPushService);
        this.O00000o = "";
        bo.a().a(new ern(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized fi O00000Oo() {
        fi fiVar;
        fiVar = null;
        boolean z = false;
        if (this.f15748O000000o && System.currentTimeMillis() - this.O00000o0 > ((long) this.O00000Oo)) {
            this.f15748O000000o = false;
            this.O00000o0 = 0;
        }
        if (this.f15748O000000o && this.O00000oo.O000000o() > 0) {
            z = true;
        }
        if (z) {
            int i = 750;
            if (!emf.O00000o(this.O00000oO.f15747O000000o)) {
                i = 375;
            }
            fiVar = O000000o(i);
        }
        return fiVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.xiaomi.push.fh} */
    /* JADX WARNING: Multi-variable type inference failed */
    private fi O000000o(int i) {
        ArrayList arrayList = new ArrayList();
        fi fiVar = new fi(this.O00000o, arrayList);
        if (!emf.O00000o(this.O00000oO.f15747O000000o)) {
            fiVar.b = erv.O0000Oo(this.O00000oO.f15747O000000o);
        }
        esi esi = new esi(i);
        esd O000000o2 = new jr.a().O000000o(esi);
        try {
            fiVar.O00000Oo(O000000o2);
        } catch (jf unused) {
        }
        LinkedList<emh.O000000o> O00000Oo2 = this.O00000oo.O00000Oo();
        while (O00000Oo2.size() > 0) {
            try {
                emh.O000000o last = O00000Oo2.getLast();
                fh fhVar = null;
                if (last.f15629O000000o != 0) {
                    fhVar = O00000o0();
                    fhVar.O000000o(fg.k.a());
                    fhVar.O00000o0(last.f15629O000000o);
                    fhVar.f37c = last.O00000Oo;
                } else if (last.O00000o0 instanceof fh) {
                    fhVar = last.O00000o0;
                }
                if (fhVar != null) {
                    fhVar.O00000Oo(O000000o2);
                }
                if (esi.f15771O000000o.size() > i) {
                    break;
                }
                if (fhVar != null) {
                    arrayList.add(fhVar);
                }
                O00000Oo2.removeLast();
            } catch (jf | NoSuchElementException unused2) {
            }
        }
        return fiVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized fh O00000o0() {
        fh fhVar;
        fhVar = new fh();
        fhVar.f34a = emf.O0000Oo0(this.O00000oO.f15747O000000o);
        fhVar.f6380a = 0;
        fhVar.b = 1;
        fhVar.O00000o((int) (System.currentTimeMillis() / 1000));
        return fhVar;
    }
}
