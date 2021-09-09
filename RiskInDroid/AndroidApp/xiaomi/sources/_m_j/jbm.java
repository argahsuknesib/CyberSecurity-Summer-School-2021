package _m_j;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface jbm extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    jbo timeout();

    void write(jax jax, long j) throws IOException;
}
