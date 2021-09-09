package _m_j;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.zip.DataFormatException;

public final class fyp extends FilterInputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    private final fyq f17418O000000o;
    private final byte[] O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private long O00000oO = -1;
    private final long O00000oo;

    public fyp(InputStream inputStream, fyq fyq) {
        super(inputStream);
        fyq.O000000o();
        this.f17418O000000o = fyq;
        this.O00000Oo = new byte[8192];
        if (this.in instanceof fyt) {
            this.O00000oo = ((fyt) this.in).O000000o();
        } else {
            this.O00000oo = 0;
        }
    }

    public final int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.O00000o0) {
            throw new IOException("Stream is closed");
        } else if (bArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            if (i > bArr.length || i2 < 0 || i < 0 || bArr.length - i < i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            try {
                O000000o();
                int O000000o2 = this.f17418O000000o.O000000o(bArr, i, i2);
                if (O000000o2 > 0) {
                    return O000000o2;
                }
                if (this.O00000o) {
                    return -1;
                }
                if (this.O00000o) {
                    throw new EOFException();
                }
                throw ((IOException) new IOException().initCause(new DataFormatException("Failed read data from decoder.")));
            } catch (DataFormatException e) {
                if (this.O00000o) {
                    throw new EOFException();
                }
                throw ((IOException) new IOException().initCause(e));
            }
        }
    }

    private void O000000o() throws IOException, DataFormatException {
        int O00000o02;
        if (!this.O00000o0) {
            int i = Integer.MAX_VALUE;
            while (!this.O00000o && (O00000o02 = this.f17418O000000o.O00000o0()) > 0) {
                if (O00000o02 > i) {
                    throw new DataFormatException("Needed data is increased");
                } else if (!Thread.currentThread().isInterrupted()) {
                    int read = this.in.read(this.O00000Oo, 0, Math.min(O00000o02, this.O00000Oo.length));
                    if (read >= 0) {
                        this.f17418O000000o.O000000o(this.O00000Oo, read);
                    } else {
                        this.O00000o = true;
                    }
                    i = O00000o02;
                } else {
                    throw new InterruptedIOException();
                }
            }
            return;
        }
        throw new IOException("Stream is closed");
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        if (j >= 0) {
            while (j2 < j) {
                if (!Thread.currentThread().isInterrupted()) {
                    byte[] bArr = this.O00000Oo;
                    long j3 = j - j2;
                    int read = read(bArr, 0, j3 > ((long) bArr.length) ? bArr.length : (int) j3);
                    if (read == -1) {
                        return j2;
                    }
                    j2 += (long) read;
                } else {
                    throw new InterruptedIOException();
                }
            }
            return j2;
        }
        throw new IllegalArgumentException();
    }

    public final int available() throws IOException {
        if (!this.O00000o0) {
            return this.O00000o ? 0 : 1;
        }
        throw new IOException("Stream is closed");
    }

    public final void close() throws IOException {
        if (!this.O00000o0) {
            try {
                this.f17418O000000o.O00000Oo();
            } finally {
                this.O00000o0 = true;
                this.O00000o = true;
                super.close();
            }
        }
    }

    public final void mark(int i) {
        if (this.in instanceof fyt) {
            this.O00000oO = ((fyt) this.in).O000000o();
        }
    }

    public final void reset() throws IOException {
        if (!markSupported()) {
            throw new IOException();
        } else if (this.O00000oO >= 0) {
            if (((fyt) this.in).O000000o() > this.O00000oO) {
                this.O00000o = false;
            }
            ((fyt) this.in).O000000o(this.O00000oO);
            this.f17418O000000o.O000000o();
            this.f17418O000000o.O000000o(this.O00000oO - this.O00000oo);
        }
    }

    public final boolean markSupported() {
        return this.in instanceof fyt;
    }
}
