package com.j256.ormlite.dao;

import java.io.Closeable;
import java.io.IOException;

public interface CloseableWrappedIterable<T> extends CloseableIterable<T>, Closeable {
    void close() throws IOException;
}
