package _m_j;

import java.io.Closeable;
import java.io.IOException;

public interface jbn extends Closeable {
    void close() throws IOException;

    long read(jax jax, long j) throws IOException;

    jbo timeout();
}
