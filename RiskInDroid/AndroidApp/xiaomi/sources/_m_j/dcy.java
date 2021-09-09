package _m_j;

public final class dcy {

    /* renamed from: O000000o  reason: collision with root package name */
    String f14491O000000o;
    public long O00000Oo = 0;
    private hyg O00000o0 = new hyg("stay");

    public final void O000000o(long j) {
        this.O00000o0.O000000o("closeto_connect_stay", "connect_stay", Long.valueOf(j));
    }

    public final void O000000o() {
        if (this.O00000Oo > 0) {
            this.O00000o0.O000000o("closeto_whole_stay", "whole_stay", Long.valueOf(System.currentTimeMillis() - this.O00000Oo));
        }
    }
}
