package com.squareup.okhttp.internal.framed;

import _m_j.jav;
import _m_j.jax;
import _m_j.jaz;
import _m_j.jbm;
import _m_j.jbn;
import _m_j.jbo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class FramedStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    public final FramedConnection connection;
    public ErrorCode errorCode = null;
    public final int id;
    public final StreamTimeout readTimeout = new StreamTimeout();
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramedDataSink sink;
    private final FramedDataSource source;
    long unacknowledgedBytesRead = 0;
    public final StreamTimeout writeTimeout = new StreamTimeout();

    FramedStream(int i, FramedConnection framedConnection, boolean z, boolean z2, List<Header> list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.id = i;
            this.connection = framedConnection;
            this.bytesLeftInWriteWindow = (long) framedConnection.peerSettings.getInitialWindowSize(65536);
            this.source = new FramedDataSource((long) framedConnection.okHttpSettings.getInitialWindowSize(65536));
            this.sink = new FramedDataSink();
            this.source.finished = z2;
            this.sink.finished = z;
            this.requestHeaders = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    public final int getId() {
        return this.id;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && ((this.sink.finished || this.sink.closed) && this.responseHeaders != null)) {
            return false;
        }
        return true;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public final FramedConnection getConnection() {
        return this.connection;
    }

    public final List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r3.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized List<Header> getResponseHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            waitForIo();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.responseHeaders != null) {
        } else {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return this.responseHeaders;
    }

    public final synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final void reply(List<Header> list, boolean z) throws IOException {
        boolean z2 = false;
        synchronized (this) {
            if (list != null) {
                try {
                    if (this.responseHeaders == null) {
                        this.responseHeaders = list;
                        if (!z) {
                            this.sink.finished = true;
                            z2 = true;
                        }
                    } else {
                        throw new IllegalStateException("reply already sent");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new NullPointerException("responseHeaders == null");
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public final jbo readTimeout() {
        return this.readTimeout;
    }

    public final jbo writeTimeout() {
        return this.writeTimeout;
    }

    public final jbn getSource() {
        return this.source;
    }

    public final jbm getSink() {
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public final void close(ErrorCode errorCode2) throws IOException {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public final void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode2;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void receiveHeaders(List<Header> list, HeadersMode headersMode) {
        ErrorCode errorCode2 = null;
        boolean z = true;
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.responseHeaders = list;
                    z = isOpen();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode2 = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (errorCode2 != null) {
            closeLater(errorCode2);
        } else if (!z) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public final void receiveData(jaz jaz, int i) throws IOException {
        this.source.receive(jaz, (long) i);
    }

    /* access modifiers changed from: package-private */
    public final void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    final class FramedDataSource implements jbn {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        private final long maxByteCount;
        private final jax readBuffer;
        private final jax receiveBuffer;

        static {
            Class<FramedStream> cls = FramedStream.class;
        }

        private FramedDataSource(long j) {
            this.receiveBuffer = new jax();
            this.readBuffer = new jax();
            this.maxByteCount = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
            r11 = r8.this$0.connection;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            monitor-enter(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8.this$0.connection.unacknowledgedBytesRead += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
            if (r8.this$0.connection.unacknowledgedBytesRead < ((long) (r8.this$0.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
            r8.this$0.connection.writeWindowUpdateLater(0, r8.this$0.connection.unacknowledgedBytesRead);
            r8.this$0.connection.unacknowledgedBytesRead = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0094, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
            return r9;
         */
        public final long read(jax jax, long j) throws IOException {
            if (j >= 0) {
                synchronized (FramedStream.this) {
                    waitUntilReadable();
                    checkNotClosed();
                    if (this.readBuffer.O00000Oo == 0) {
                        return -1;
                    }
                    long read = this.readBuffer.read(jax, Math.min(j, this.readBuffer.O00000Oo));
                    FramedStream.this.unacknowledgedBytesRead += read;
                    if (FramedStream.this.unacknowledgedBytesRead >= ((long) (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) {
                        FramedStream.this.connection.writeWindowUpdateLater(FramedStream.this.id, FramedStream.this.unacknowledgedBytesRead);
                        FramedStream.this.unacknowledgedBytesRead = 0;
                    }
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
        }

        private void waitUntilReadable() throws IOException {
            FramedStream.this.readTimeout.enter();
            while (this.readBuffer.O00000Oo == 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                try {
                    FramedStream.this.waitForIo();
                } finally {
                    FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void receive(jaz jaz, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (FramedStream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.O00000Oo + j > this.maxByteCount;
                }
                if (z3) {
                    jaz.O0000Oo0(j);
                    FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    jaz.O0000Oo0(j);
                    return;
                } else {
                    long read = jaz.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (FramedStream.this) {
                            if (this.readBuffer.O00000Oo != 0) {
                                z2 = false;
                            }
                            this.readBuffer.O000000o((jbn) this.receiveBuffer);
                            if (z2) {
                                FramedStream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public final jbo timeout() {
            return FramedStream.this.readTimeout;
        }

        public final void close() throws IOException {
            synchronized (FramedStream.this) {
                this.closed = true;
                this.readBuffer.O0000oOo();
                FramedStream.this.notifyAll();
            }
            FramedStream.this.cancelStreamIfNecessary();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (FramedStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + FramedStream.this.errorCode);
            }
        }
    }

    public final void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    final class FramedDataSink implements jbm {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        private final jax sendBuffer = new jax();

        FramedDataSink() {
        }

        public final void write(jax jax, long j) throws IOException {
            this.sendBuffer.write(jax, j);
            while (this.sendBuffer.O00000Oo >= 16384) {
                emitDataFrame(false);
            }
        }

        /* JADX INFO: finally extract failed */
        private void emitDataFrame(boolean z) throws IOException {
            long min;
            synchronized (FramedStream.this) {
                FramedStream.this.writeTimeout.enter();
                while (FramedStream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                    try {
                        FramedStream.this.waitForIo();
                    } catch (Throwable th) {
                        FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                FramedStream.this.checkOutNotClosed();
                min = Math.min(FramedStream.this.bytesLeftInWriteWindow, this.sendBuffer.O00000Oo);
                FramedStream.this.bytesLeftInWriteWindow -= min;
            }
            FramedStream.this.writeTimeout.enter();
            try {
                FramedStream.this.connection.writeData(FramedStream.this.id, z && min == this.sendBuffer.O00000Oo, this.sendBuffer, min);
            } finally {
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        public final void flush() throws IOException {
            synchronized (FramedStream.this) {
                FramedStream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.O00000Oo > 0) {
                emitDataFrame(false);
                FramedStream.this.connection.flush();
            }
        }

        public final jbo timeout() {
            return FramedStream.this.writeTimeout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            if (r8.sendBuffer.O00000Oo <= 0) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r8.sendBuffer.O00000Oo <= 0) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            emitDataFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            r8.this$0.connection.writeData(r8.this$0.id, true, null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
            r2 = r8.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
            r8.this$0.connection.flush();
            r8.this$0.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.this$0.sink.finished != false) goto L_0x0038;
         */
        public final void close() throws IOException {
            synchronized (FramedStream.this) {
                if (this.closed) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
    }

    public final void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class StreamTimeout extends jav {
        StreamTimeout() {
        }

        public void timedOut() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }

        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}
