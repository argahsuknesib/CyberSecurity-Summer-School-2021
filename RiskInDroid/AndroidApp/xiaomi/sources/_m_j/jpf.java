package _m_j;

import java.util.ArrayDeque;
import java.util.Deque;

public final class jpf {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2017O000000o = 64;
    private int O00000Oo = 5;
    private final Deque<Object> O00000o = new ArrayDeque();
    private final Deque<Object> O00000o0 = new ArrayDeque();
    private final Deque<jrh> O00000oO = new ArrayDeque();

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(joy joy) {
        if (!this.O00000oO.remove(joy)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(jrh jrh) {
        this.O00000oO.add(jrh);
    }
}
