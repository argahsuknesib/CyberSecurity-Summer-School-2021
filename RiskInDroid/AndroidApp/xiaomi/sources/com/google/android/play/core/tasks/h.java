package com.google.android.play.core.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class h<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3850a = new Object();
    private Queue<g<ResultT>> b;
    private boolean c;

    h() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r2.b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        if (r0 != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r2.c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        r0.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        r1 = r2.f3850a;
     */
    public final void a(Task task) {
        synchronized (this.f3850a) {
            if (this.b != null && !this.c) {
                this.c = true;
            }
        }
    }

    public final void a(g gVar) {
        synchronized (this.f3850a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(gVar);
        }
    }
}
