package _m_j;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public final class km implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Object f2141O000000o;
    final List<kl> O00000Oo;
    private boolean O00000o;
    public ScheduledFuture<?> O00000o0;
    private boolean O00000oO;

    public final boolean O000000o() {
        boolean z;
        synchronized (this.f2141O000000o) {
            O00000Oo();
            z = this.O00000o;
        }
        return z;
    }

    public final void close() {
        synchronized (this.f2141O000000o) {
            if (!this.O00000oO) {
                if (this.O00000o0 != null) {
                    this.O00000o0.cancel(true);
                    this.O00000o0 = null;
                }
                for (kl close : this.O00000Oo) {
                    close.close();
                }
                this.O00000Oo.clear();
                this.O00000oO = true;
            }
        }
    }

    public final String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(O000000o()));
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        if (this.O00000oO) {
            throw new IllegalStateException("Object already closed");
        }
    }
}
