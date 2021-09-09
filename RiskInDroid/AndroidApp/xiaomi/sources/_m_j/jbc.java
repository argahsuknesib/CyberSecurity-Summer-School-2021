package _m_j;

import java.io.IOException;

public abstract class jbc implements jbn {
    private final jbn delegate;

    public jbc(jbn jbn) {
        if (jbn != null) {
            this.delegate = jbn;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final jbn delegate() {
        return this.delegate;
    }

    public long read(jax jax, long j) throws IOException {
        return this.delegate.read(jax, j);
    }

    public jbo timeout() {
        return this.delegate.timeout();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
