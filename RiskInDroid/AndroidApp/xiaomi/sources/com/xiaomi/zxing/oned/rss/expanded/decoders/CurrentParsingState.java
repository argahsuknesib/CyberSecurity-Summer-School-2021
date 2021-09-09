package com.xiaomi.zxing.oned.rss.expanded.decoders;

public final class CurrentParsingState {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12116O000000o = 0;
    public State O00000Oo = State.NUMERIC;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public final void O000000o(int i) {
        this.f12116O000000o += i;
    }

    public final boolean O000000o() {
        return this.O00000Oo == State.ALPHA;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo == State.ISO_IEC_646;
    }
}
