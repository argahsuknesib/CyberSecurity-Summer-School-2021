package com.google.android.play.core.internal;

public final class cg<T> implements ce, ci {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3764a = new Object();
    private volatile ci<T> b;
    private volatile Object c = f3764a;

    private cg(ci<T> ciVar) {
        this.b = ciVar;
    }

    public static <P extends ci<T>, T> ci<T> a(P p) {
        bl.a(p);
        return !(p instanceof cg) ? new cg(p) : p;
    }

    public static <P extends ci<T>, T> ce<T> b(P p) {
        if (p instanceof ce) {
            return (ce) p;
        }
        bl.a(p);
        return new cg(p);
    }

    public final T a() {
        T t = this.c;
        if (t == f3764a) {
            synchronized (this) {
                t = this.c;
                if (t == f3764a) {
                    t = this.b.a();
                    T t2 = this.c;
                    if (t2 == f3764a || (t2 instanceof ch) || t2 == t) {
                        this.c = t;
                        this.b = null;
                    } else {
                        String valueOf = String.valueOf(t2);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
        }
        return t;
    }
}
