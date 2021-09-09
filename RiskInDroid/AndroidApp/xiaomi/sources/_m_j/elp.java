package _m_j;

import _m_j.elo;

final class elp extends elo.O00000Oo {
    final /* synthetic */ boolean O00000Oo = false;
    final /* synthetic */ elo O00000o;
    final /* synthetic */ String O00000o0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    elp(elo elo, elo.O000000o o000000o, boolean z, String str) {
        super(o000000o);
        this.O00000o = elo;
        this.O00000o0 = str;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (!this.O00000Oo) {
            this.O00000o.O00000oO.edit().putLong(this.O00000o0, System.currentTimeMillis()).commit();
        }
    }
}
