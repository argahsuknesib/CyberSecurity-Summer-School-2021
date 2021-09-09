package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f3741a;

    public a(ByteBuffer byteBuffer) {
        this.f3741a = byteBuffer.slice();
    }

    public final long a() {
        return (long) this.f3741a.capacity();
    }

    public final void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f3741a) {
            int i2 = (int) j;
            this.f3741a.position(i2);
            this.f3741a.limit(i2 + i);
            slice = this.f3741a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
