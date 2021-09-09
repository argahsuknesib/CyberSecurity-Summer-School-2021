package _m_j;

import _m_j.elo;
import _m_j.end;

final class ene extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ end f15649O000000o;

    ene(end end) {
        this.f15649O000000o = end;
    }

    public final String a() {
        return "100957";
    }

    public final void run() {
        enb enb;
        synchronized (this.f15649O000000o.O00000oo) {
            if (this.f15649O000000o.O00000oo.size() > 0) {
                if (this.f15649O000000o.O00000oo.size() > 1) {
                    this.f15649O000000o.O000000o(this.f15649O000000o.O00000oo);
                } else {
                    end end = this.f15649O000000o;
                    end.O000000o o000000o = (end.O000000o) this.f15649O000000o.O00000oo.get(0);
                    if (o000000o != null) {
                        if (end.O00000Oo != null) {
                            String str = o000000o.O00000o;
                            synchronized (end.O00000o0) {
                                enb = end.O00000o0.get(str);
                                if (enb == null) {
                                    enb = end.O00000Oo.O000000o();
                                    end.O00000o0.put(str, enb);
                                }
                            }
                            if (!end.O00000o.isShutdown()) {
                                o000000o.O000000o(enb, end.f15643O000000o);
                                end.O000000o((Runnable) o000000o);
                            }
                        } else {
                            throw new IllegalStateException("should exec init method first!");
                        }
                    }
                }
                this.f15649O000000o.O00000oo.clear();
                System.gc();
            }
        }
    }
}
