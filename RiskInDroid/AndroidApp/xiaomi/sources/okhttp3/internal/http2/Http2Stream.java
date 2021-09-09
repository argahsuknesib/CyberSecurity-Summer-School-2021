package okhttp3.internal.http2;

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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;

public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode = null;
    private boolean hasResponseHeaders;
    public Header.Listener headersListener;
    public final Deque<Headers> headersQueue = new ArrayDeque();
    final int id;
    final StreamTimeout readTimeout = new StreamTimeout();
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout writeTimeout = new StreamTimeout();

    Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        if (http2Connection != null) {
            this.id = i;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = (long) http2Connection.peerSettings.getInitialWindowSize();
            this.source = new FramingSource((long) http2Connection.okHttpSettings.getInitialWindowSize());
            this.sink = new FramingSink();
            this.source.finished = z2;
            this.sink.finished = z;
            if (headers != null) {
                this.headersQueue.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    public final int getId() {
        return this.id;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && ((this.sink.finished || this.sink.closed) && this.hasResponseHeaders)) {
            return false;
        }
        return true;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            waitForIo();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
        } else {
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public final synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final void writeHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        if (list != null) {
            synchronized (this) {
                this.hasResponseHeaders = true;
                if (!z) {
                    this.sink.finished = true;
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = false;
                    z3 = false;
                }
            }
            if (!z2) {
                synchronized (this.connection) {
                    z2 = this.connection.bytesLeftInWriteWindow == 0;
                }
            }
            this.connection.writeSynReply(this.id, z3, list);
            if (z2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
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
            if (!this.hasResponseHeaders) {
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
    public final void receiveHeaders(List<Header> list) {
        boolean isOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
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

    public final synchronized void setHeadersListener(Header.Listener listener) {
        this.headersListener = listener;
        if (!this.headersQueue.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    final class FramingSource implements jbn {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final jax readBuffer = new jax();
        private final jax receiveBuffer = new jax();

        static {
            Class<Http2Stream> cls = Http2Stream.class;
        }

        FramingSource(long j) {
            this.maxByteCount = j;
        }

        public final long read(jax jax, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            Header.Listener listener;
            Headers headers;
            long j3 = j;
            if (j3 >= 0) {
                while (true) {
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            errorCode = Http2Stream.this.errorCode != null ? Http2Stream.this.errorCode : null;
                            if (!this.closed) {
                                if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                                    if (this.readBuffer.O00000Oo > 0) {
                                        j2 = this.readBuffer.read(jax, Math.min(j3, this.readBuffer.O00000Oo));
                                        Http2Stream.this.unacknowledgedBytesRead += j2;
                                        if (errorCode == null && Http2Stream.this.unacknowledgedBytesRead >= ((long) (Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2))) {
                                            Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
                                            Http2Stream.this.unacknowledgedBytesRead = 0;
                                        }
                                    } else {
                                        jax jax2 = jax;
                                        if (this.finished || errorCode != null) {
                                            j2 = -1;
                                        } else {
                                            Http2Stream.this.waitForIo();
                                        }
                                    }
                                    headers = null;
                                    listener = null;
                                } else {
                                    headers = Http2Stream.this.headersQueue.removeFirst();
                                    listener = Http2Stream.this.headersListener;
                                    jax jax3 = jax;
                                    j2 = -1;
                                }
                                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                                if (headers != null && listener != null) {
                                    listener.onHeaders(headers);
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        }
                    }
                }
                if (j2 != -1) {
                    updateConnectionFlowControl(j2);
                    return j2;
                } else if (errorCode == null) {
                    return -1;
                } else {
                    throw new StreamResetException(errorCode);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        /* access modifiers changed from: package-private */
        public final void receive(jaz jaz, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.O00000Oo + j > this.maxByteCount;
                }
                if (z3) {
                    jaz.O0000Oo0(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    jaz.O0000Oo0(j);
                    return;
                } else {
                    long read = jaz.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (Http2Stream.this) {
                            if (this.readBuffer.O00000Oo != 0) {
                                z2 = false;
                            }
                            this.readBuffer.O000000o((jbn) this.receiveBuffer);
                            if (z2) {
                                Http2Stream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public final jbo timeout() {
            return Http2Stream.this.readTimeout;
        }

        public final void close() throws IOException {
            long j;
            ArrayList<Headers> arrayList;
            Header.Listener listener;
            synchronized (Http2Stream.this) {
                this.closed = true;
                j = this.readBuffer.O00000Oo;
                this.readBuffer.O0000oOo();
                arrayList = null;
                if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                    listener = null;
                } else {
                    arrayList = new ArrayList<>(Http2Stream.this.headersQueue);
                    Http2Stream.this.headersQueue.clear();
                    listener = Http2Stream.this.headersListener;
                }
                Http2Stream.this.notifyAll();
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary();
            if (listener != null) {
                for (Headers onHeaders : arrayList) {
                    listener.onHeaders(onHeaders);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
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

    final class FramingSink implements jbm {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final jax sendBuffer = new jax();

        static {
            Class<Http2Stream> cls = Http2Stream.class;
        }

        FramingSink() {
        }

        public final void write(jax jax, long j) throws IOException {
            this.sendBuffer.write(jax, j);
            while (this.sendBuffer.O00000Oo >= 16384) {
                emitFrame(false);
            }
        }

        /* JADX INFO: finally extract failed */
        private void emitFrame(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                    try {
                        Http2Stream.this.waitForIo();
                    } catch (Throwable th) {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                min = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.O00000Oo);
                Http2Stream.this.bytesLeftInWriteWindow -= min;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream.this.connection.writeData(Http2Stream.this.id, z && min == this.sendBuffer.O00000Oo, this.sendBuffer, min);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        public final void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.O00000Oo > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        public final jbo timeout() {
            return Http2Stream.this.writeTimeout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            if (r8.sendBuffer.O00000Oo <= 0) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r8.sendBuffer.O00000Oo <= 0) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            emitFrame(true);
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
            synchronized (Http2Stream.this) {
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

    /* access modifiers changed from: package-private */
    public final void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (!this.sink.finished) {
            ErrorCode errorCode2 = this.errorCode;
            if (errorCode2 != null) {
                throw new StreamResetException(errorCode2);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* access modifiers changed from: package-private */
    public final void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    class StreamTimeout extends jav {
        StreamTimeout() {
        }

        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
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
