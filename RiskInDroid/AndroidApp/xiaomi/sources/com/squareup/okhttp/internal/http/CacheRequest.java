package com.squareup.okhttp.internal.http;

import _m_j.jbm;
import java.io.IOException;

public interface CacheRequest {
    void abort();

    jbm body() throws IOException;
}
