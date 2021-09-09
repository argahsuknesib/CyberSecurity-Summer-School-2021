package okhttp3.internal.cache;

import _m_j.jbm;
import java.io.IOException;

public interface CacheRequest {
    void abort();

    jbm body() throws IOException;
}
