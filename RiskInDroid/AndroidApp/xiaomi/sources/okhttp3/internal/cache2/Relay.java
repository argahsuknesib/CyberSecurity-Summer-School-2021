package okhttp3.internal.cache2;

import _m_j.jax;
import _m_j.jbn;
import _m_j.jbo;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.ByteString;

final class Relay {
    static final ByteString PREFIX_CLEAN = ByteString.O000000o("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.O000000o("OkHttp DIRTY :(\n");
    final jax buffer = new jax();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    jbn upstream;
    final jax upstreamBuffer = new jax();
    long upstreamPos;
    Thread upstreamReader;

    private Relay(RandomAccessFile randomAccessFile, jbn jbn, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = jbn;
        this.complete = jbn == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file2, jbn jbn, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, jbn, 0, byteString, j);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        jax jax = new jax();
        fileOperator.read(0, jax, 32);
        if (jax.O00000o((long) PREFIX_CLEAN.O0000OOo()).equals(PREFIX_CLEAN)) {
            long O0000Oo = jax.O0000Oo();
            long O0000Oo2 = jax.O0000Oo();
            jax jax2 = new jax();
            fileOperator.read(O0000Oo + 32, jax2, O0000Oo2);
            return new Relay(randomAccessFile, null, O0000Oo, jax2.O0000o0o(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        jax jax = new jax();
        jax.O00000o0(byteString);
        jax.O0000Oo(j);
        jax.O0000Oo(j2);
        if (jax.O00000Oo == 32) {
            new FileOperator(this.file.getChannel()).write(0, jax, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) throws IOException {
        jax jax = new jax();
        jax.O00000o0(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, jax, (long) this.metadata.O0000OOo());
    }

    /* access modifiers changed from: package-private */
    public final void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.O0000OOo());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final jbn newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    class RelaySource implements jbn {
        private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
        private long sourcePos;
        private final jbo timeout = new jbo();

        RelaySource() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            r5 = r7 - r1.this$0.buffer.O00000Oo;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
            if (r1.sourcePos >= r5) goto L_0x0115;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r1.sourcePos);
            r1.this$0.buffer.O000000o(r22, r1.sourcePos - r5, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0130, code lost:
            return r2;
         */
        public long read(jax jax, long j) throws IOException {
            long j2;
            char c;
            long j3 = j;
            if (this.fileOperator != null) {
                synchronized (Relay.this) {
                    while (true) {
                        long j4 = this.sourcePos;
                        j2 = Relay.this.upstreamPos;
                        if (j4 != j2) {
                            break;
                        } else if (Relay.this.complete) {
                            return -1;
                        } else {
                            if (Relay.this.upstreamReader != null) {
                                this.timeout.waitUntilNotified(Relay.this);
                            } else {
                                Relay.this.upstreamReader = Thread.currentThread();
                                c = 1;
                            }
                        }
                    }
                    if (c == 2) {
                        long min = Math.min(j3, j2 - this.sourcePos);
                        this.fileOperator.read(this.sourcePos + 32, jax, min);
                        this.sourcePos += min;
                        return min;
                    }
                    try {
                        long read = Relay.this.upstream.read(Relay.this.upstreamBuffer, Relay.this.bufferMaxSize);
                        if (read == -1) {
                            Relay.this.commit(j2);
                            synchronized (Relay.this) {
                                Relay.this.upstreamReader = null;
                                Relay.this.notifyAll();
                            }
                            return -1;
                        }
                        long min2 = Math.min(read, j3);
                        Relay.this.upstreamBuffer.O000000o(jax, 0, min2);
                        this.sourcePos += min2;
                        this.fileOperator.write(j2 + 32, Relay.this.upstreamBuffer.clone(), read);
                        synchronized (Relay.this) {
                            Relay.this.buffer.write(Relay.this.upstreamBuffer, read);
                            if (Relay.this.buffer.O00000Oo > Relay.this.bufferMaxSize) {
                                Relay.this.buffer.O0000Oo0(Relay.this.buffer.O00000Oo - Relay.this.bufferMaxSize);
                            }
                            Relay.this.upstreamPos += read;
                        }
                        synchronized (Relay.this) {
                            Relay.this.upstreamReader = null;
                            Relay.this.notifyAll();
                        }
                        return min2;
                    } catch (Throwable th) {
                        synchronized (Relay.this) {
                            Relay.this.upstreamReader = null;
                            Relay.this.notifyAll();
                            throw th;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public jbo timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile2 = Relay.this.file;
                        Relay.this.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly(randomAccessFile);
                }
            }
        }
    }
}
