package _m_j;

import com.typesafe.config.ConfigException;
import java.util.Stack;

final class dtc {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Stack<String> f14917O000000o = new Stack<>();
    private dtb O00000Oo;

    dtc() {
    }

    private void O00000Oo() {
        if (this.O00000Oo != null) {
            throw new ConfigException.BugOrBroken("Adding to PathBuilder after getting result");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        O00000Oo();
        this.f14917O000000o.push(str);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dtb dtb) {
        O00000Oo();
        String str = dtb.f14916O000000o;
        dtb dtb2 = dtb.O00000Oo;
        while (true) {
            this.f14917O000000o.push(str);
            if (dtb2 != null) {
                str = dtb2.f14916O000000o;
                dtb2 = dtb2.O00000Oo;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final dtb O000000o() {
        if (this.O00000Oo == null) {
            dtb dtb = null;
            while (!this.f14917O000000o.isEmpty()) {
                dtb = new dtb(this.f14917O000000o.pop(), dtb);
            }
            this.O00000Oo = dtb;
        }
        return this.O00000Oo;
    }
}
