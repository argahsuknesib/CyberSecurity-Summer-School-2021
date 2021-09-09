package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

final class bp extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3660a = new byte[4096];
    private long b;
    private boolean c = false;
    private boolean d = false;

    bp(InputStream inputStream) {
        super(inputStream);
    }

    private final int a(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    private final dx a(int i, String str, long j, int i2, boolean z) {
        return dx.a(str, j, i2, z, Arrays.copyOf(this.f3660a, i));
    }

    private final void a(long j) {
        int length = this.f3660a.length;
        if (j > ((long) length)) {
            do {
                length += length;
            } while (((long) length) < j);
            this.f3660a = Arrays.copyOf(this.f3660a, length);
        }
    }

    private final boolean a(int i, int i2) throws IOException {
        return a(this.f3660a, i, i2) == i2;
    }

    /* access modifiers changed from: package-private */
    public final dx a() throws IOException {
        byte[] bArr;
        if (this.b > 0) {
            do {
                bArr = this.f3660a;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.c || this.d) {
            return dx.a(null, -1, -1, false, null);
        }
        int a2 = a(this.f3660a, 0, 30);
        if (a2 != 30 && !a(a2, 30 - a2)) {
            this.c = true;
            return a(a2, null, -1, -1, true);
        } else if (dd.b(this.f3660a, 0) != 67324752) {
            this.d = true;
            return a(a2, null, -1, -1, false);
        } else {
            long b2 = dd.b(this.f3660a, 18);
            if (b2 != 4294967295L) {
                int c2 = dd.c(this.f3660a, 8);
                int c3 = dd.c(this.f3660a, 26);
                int i = c3 + 30;
                a((long) i);
                int a3 = a(this.f3660a, 30, c3);
                int i2 = a3 + 30;
                if (a3 == c3 || a(i2, c3 - a3)) {
                    String str = new String(this.f3660a, 30, c3);
                    int c4 = dd.c(this.f3660a, 28);
                    int i3 = i + c4;
                    a((long) i3);
                    int a4 = a(this.f3660a, i, c4);
                    int i4 = i + a4;
                    if (a4 == c4 || a(i4, c4 - a4)) {
                        this.b = dd.b(this.f3660a, 18);
                        return a(i3, str, b2, c2, false);
                    }
                    this.c = true;
                    return a(i4, str, b2, c2, true);
                }
                this.c = true;
                return a(i2, null, b2, c2, true);
            }
            throw new by("Files bigger than 4GiB are not supported.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final long d() {
        return this.b;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.b;
        if (j <= 0 || this.c) {
            return -1;
        }
        int a2 = a(bArr, i, (int) Math.min(j, (long) i2));
        this.b -= (long) a2;
        if (a2 != 0) {
            return a2;
        }
        this.c = true;
        return 0;
    }
}
