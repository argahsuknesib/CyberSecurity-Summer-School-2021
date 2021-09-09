package com.google.android.play.core.internal;

final class ca extends bx {

    /* renamed from: a  reason: collision with root package name */
    private final bz f3761a = new bz();

    ca() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f3761a.a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
