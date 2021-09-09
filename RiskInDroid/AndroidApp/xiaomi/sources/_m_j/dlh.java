package _m_j;

final class dlh implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ int f14765O000000o;
    final /* synthetic */ dkz O00000Oo;

    dlh(dkz dkz, int i) {
        this.O00000Oo = dkz;
        this.f14765O000000o = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dkz.O000000o(_m_j.dkz, int, boolean):void
     arg types: [_m_j.dkz, int, int]
     candidates:
      _m_j.dkz.O000000o(_m_j.dkz, java.util.List, boolean):void
      _m_j.dkz.O000000o(java.util.List<_m_j.dlj>, int, boolean):void
      _m_j.dkz.O000000o(_m_j.dkz, int, boolean):void */
    public final void run() {
        dkz.O000000o(this.O00000Oo, this.f14765O000000o, true);
        dkz.O000000o(this.O00000Oo, this.f14765O000000o, false);
    }
}
