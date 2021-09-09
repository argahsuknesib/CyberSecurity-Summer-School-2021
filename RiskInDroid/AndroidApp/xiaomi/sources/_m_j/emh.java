package _m_j;

import java.util.LinkedList;

public final class emh {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinkedList<O000000o> f15628O000000o = new LinkedList<>();

    public static class O000000o {
        /* access modifiers changed from: private */
        public static final emh O00000o = new emh();

        /* renamed from: O000000o  reason: collision with root package name */
        public int f15629O000000o = 0;
        public String O00000Oo;
        public Object O00000o0;

        O000000o(Object obj) {
            this.O00000o0 = obj;
        }
    }

    public final synchronized int O000000o() {
        return this.f15628O000000o.size();
    }

    public final synchronized LinkedList<O000000o> O00000Oo() {
        LinkedList<O000000o> linkedList;
        linkedList = this.f15628O000000o;
        this.f15628O000000o = new LinkedList<>();
        return linkedList;
    }

    public final synchronized void O000000o(Object obj) {
        this.f15628O000000o.add(new O000000o(obj));
        if (this.f15628O000000o.size() > 100) {
            this.f15628O000000o.removeFirst();
        }
    }
}
