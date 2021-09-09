package _m_j;

import java.util.ArrayList;
import java.util.Iterator;

final class enr extends enl {
    final /* synthetic */ enl O0000o0;
    enl O0000o00 = this.O0000o0;
    final /* synthetic */ enp O0000o0O;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    enr(enp enp, String str, enl enl) {
        super(str);
        this.O0000o0O = enp;
        this.O0000o0 = enl;
        this.O00000o0 = this.O00000o0;
        enl enl2 = this.O0000o0;
        if (enl2 != null) {
            this.O0000O0o = enl2.O0000O0o;
        }
    }

    public final synchronized ArrayList<String> O000000o(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.O0000o00 != null) {
            arrayList.addAll(this.O0000o00.O000000o(true));
        }
        synchronized (enp.b) {
            enl enl = enp.b.get(this.O00000o0);
            if (enl != null) {
                Iterator<String> it = enl.O000000o(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.O00000o0);
                arrayList.add(this.O00000o0);
            }
        }
        return arrayList;
    }

    public final synchronized void O000000o(String str, enk enk) {
        if (this.O0000o00 != null) {
            this.O0000o00.O000000o(str, enk);
        }
    }

    public final boolean O000000o() {
        return false;
    }
}
