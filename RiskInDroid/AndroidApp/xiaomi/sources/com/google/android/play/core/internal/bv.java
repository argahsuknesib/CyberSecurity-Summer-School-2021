package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public abstract class bv implements Closeable {
    public abstract long a();

    /* access modifiers changed from: protected */
    public abstract InputStream a(long j, long j2) throws IOException;

    public synchronized InputStream b() throws IOException {
        return a(0, a());
    }
}
