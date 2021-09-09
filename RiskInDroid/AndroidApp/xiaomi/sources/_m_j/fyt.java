package _m_j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;

public final class fyt extends InputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    private RandomAccessFile f17421O000000o;
    private final File O00000Oo;
    private long O00000o = 0;
    private long O00000o0 = 0;
    private boolean O00000oO = false;

    public final boolean markSupported() {
        return true;
    }

    public fyt(File file) throws FileNotFoundException {
        this.O00000Oo = file;
        this.f17421O000000o = new RandomAccessFile(file, "r");
    }

    public final synchronized int read() throws IOException {
        int read;
        if (!Thread.currentThread().isInterrupted()) {
            read = this.f17421O000000o.read();
            if (read >= 0) {
                this.O00000o0++;
            }
        } else {
            throw new InterruptedIOException();
        }
        return read;
    }

    public final synchronized int available() throws IOException {
        return (int) (this.f17421O000000o.length() - this.O00000o0);
    }

    public final synchronized void close() throws IOException {
        this.f17421O000000o.close();
        this.O00000oO = true;
    }

    public final synchronized void O000000o(long j) throws IOException {
        if (j < this.f17421O000000o.length()) {
            this.f17421O000000o.seek(j);
            this.O00000o0 = j;
        } else {
            throw new IOException("Seek possion is not availabel");
        }
    }

    public final synchronized long O000000o() {
        return this.O00000o0;
    }

    public final void mark(int i) {
        if (!this.O00000oO) {
            this.O00000o = this.O00000o0;
        }
    }

    public final synchronized int read(byte[] bArr) throws IOException {
        int read;
        if (!Thread.currentThread().isInterrupted()) {
            read = this.f17421O000000o.read(bArr);
            if (read > 0) {
                this.O00000o0 += (long) read;
            }
        } else {
            throw new InterruptedIOException();
        }
        return read;
    }

    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (!Thread.currentThread().isInterrupted()) {
            read = this.f17421O000000o.read(bArr, i, i2);
            if (read > 0) {
                this.O00000o0 += (long) read;
            }
        } else {
            throw new InterruptedIOException();
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (this.O00000oO) {
            this.O00000oO = false;
            this.f17421O000000o = new RandomAccessFile(this.O00000Oo, "r");
        }
        this.f17421O000000o.seek(this.O00000o);
        this.O00000o0 = this.O00000o;
    }

    public final long skip(long j) throws IOException {
        if (j == 0) {
            return 0;
        }
        if (j >= 0) {
            int i = j < 8192 ? (int) j : 8192;
            synchronized (this) {
                long j2 = (long) i;
                long j3 = j / j2;
                long j4 = 0;
                while (j3 >= 0) {
                    if (!Thread.currentThread().isInterrupted()) {
                        long skipBytes = (long) this.f17421O000000o.skipBytes(i);
                        j4 += skipBytes;
                        this.O00000o0 += skipBytes;
                        if (skipBytes < j2) {
                            return j4;
                        }
                        j3--;
                    } else {
                        throw new InterruptedIOException();
                    }
                }
                return j4;
            }
        }
        throw new IOException("Number of bytes to skip cannot be negative");
    }
}
