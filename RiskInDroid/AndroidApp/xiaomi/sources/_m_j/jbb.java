package _m_j;

import java.io.IOException;

public abstract class jbb implements jbm {
    private final jbm delegate;

    public jbb(jbm jbm) {
        if (jbm != null) {
            this.delegate = jbm;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final jbm delegate() {
        return this.delegate;
    }

    public void write(jax jax, long j) throws IOException {
        this.delegate.write(jax, j);
    }

    public void flush() throws IOException {
        this.delegate.flush();
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
