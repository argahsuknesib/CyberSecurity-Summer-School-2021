package com.squareup.okhttp.internal.framed;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbg;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

public final class FramedConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    public final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    public final IncomingStreamHandler handler;
    public final String hostName;
    private long idleStartTimeNs;
    public int lastGoodStreamId;
    private int nextPingId;
    public int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    public final PushObserver pushObserver;
    final Reader readerRunnable;
    public boolean receivedInitialPeerSettings;
    public boolean shutdown;
    final Socket socket;
    public final Map<Integer, FramedStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    private FramedConnection(Builder builder) throws IOException {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.handler = builder.handler;
        int i = 2;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = builder.client ? 1 : i;
        if (builder.client) {
            this.okHttpSettings.set(7, 0, 16777216);
        }
        this.hostName = builder.hostName;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", this.hostName), true));
            this.peerSettings.set(7, 0, 65535);
            this.peerSettings.set(5, 0, 16384);
        } else if (this.protocol == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(this.protocol);
        }
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(jbg.O000000o(jbg.O000000o(builder.socket)), this.client);
        this.readerRunnable = new Reader();
        new Thread(this.readerRunnable).start();
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public final synchronized FramedStream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public final synchronized FramedStream removeStream(int i) {
        FramedStream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        if (remove != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        notifyAll();
        return remove;
    }

    private synchronized void setIdle(boolean z) {
        long j;
        if (z) {
            try {
                j = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j = Long.MAX_VALUE;
        }
        this.idleStartTimeNs = j;
    }

    public final synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public final synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public final FramedStream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.protocol == Protocol.HTTP_2) {
            return newStream(i, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    public final FramedStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }

    private FramedStream newStream(int i, List<Header> list, boolean z, boolean z2) throws IOException {
        int i2;
        FramedStream framedStream;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    i2 = this.nextStreamId;
                    this.nextStreamId += 2;
                    framedStream = new FramedStream(i2, this, z3, z4, list);
                    if (framedStream.isOpen()) {
                        this.streams.put(Integer.valueOf(i2), framedStream);
                        setIdle(false);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            if (i == 0) {
                this.frameWriter.synStream(z3, z4, i2, i, list);
            } else if (!this.client) {
                this.frameWriter.pushPromise(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (!z) {
            this.frameWriter.flush();
        }
        return framedStream;
    }

    /* access modifiers changed from: package-private */
    public final void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.bytesLeftInWriteWindow), r8.frameWriter.maxDataLength());
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    public final void writeData(int i, boolean z, jax jax, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.frameWriter.data(z, i, jax, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    if (this.bytesLeftInWriteWindow > 0) {
                        break;
                    } else if (this.streams.containsKey(Integer.valueOf(i))) {
                        wait();
                    } else {
                        throw new IOException("stream closed");
                    }
                }
            }
            j -= j2;
            this.frameWriter.data(z && j == 0, i, jax, min);
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
    public final void writeSynResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass1 */

            public void execute() {
                try {
                    FramedConnection.this.writeSynReset(i2, errorCode2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    public final void writeWindowUpdateLater(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass2 */

            public void execute() {
                try {
                    FramedConnection.this.frameWriter.windowUpdate(i2, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    public final Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (!this.shutdown) {
                i = this.nextPingId;
                this.nextPingId += 2;
                if (this.pings == null) {
                    this.pings = new HashMap();
                }
                this.pings.put(Integer.valueOf(i), ping);
            } else {
                throw new IOException("shutdown");
            }
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public final void writePingLater(boolean z, int i, int i2, Ping ping) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final Ping ping2 = ping;
        executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}) {
            /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass3 */

            public void execute() {
                try {
                    FramedConnection.this.writePing(z2, i3, i4, ping2);
                } catch (IOException unused) {
                }
            }
        });
    }

    public final void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(z, i, i2);
        }
    }

    public final synchronized Ping removePing(int i) {
        if (this.pings == null) {
            return null;
        }
        return this.pings.remove(Integer.valueOf(i));
    }

    public final void flush() throws IOException {
        this.frameWriter.flush();
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i = this.lastGoodStreamId;
                    this.frameWriter.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public final void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public final void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i;
        FramedStream[] framedStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                framedStreamArr = (FramedStream[]) this.streams.values().toArray(new FramedStream[this.streams.size()]);
                this.streams.clear();
                setIdle(false);
            } else {
                framedStreamArr = null;
            }
            if (this.pings != null) {
                this.pings = null;
                pingArr = (Ping[]) this.pings.values().toArray(new Ping[this.pings.size()]);
            }
        }
        if (framedStreamArr != null) {
            IOException iOException = e;
            for (FramedStream close : framedStreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e2) {
                    if (iOException != null) {
                        iOException = e2;
                    }
                }
            }
            e = iOException;
        }
        if (pingArr != null) {
            for (Ping cancel : pingArr) {
                cancel.cancel();
            }
        }
        try {
            this.frameWriter.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public final void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int initialWindowSize = this.okHttpSettings.getInitialWindowSize(65536);
        if (initialWindowSize != 65536) {
            this.frameWriter.windowUpdate(0, (long) (initialWindowSize - 65536));
        }
    }

    public static class Builder {
        public boolean client;
        public IncomingStreamHandler handler;
        public String hostName;
        public Protocol protocol;
        public PushObserver pushObserver;
        public Socket socket;

        public Builder(boolean z, Socket socket2) throws IOException {
            this(((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), z, socket2);
        }

        public Builder(String str, boolean z, Socket socket2) throws IOException {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.protocol = Protocol.SPDY_3;
            this.pushObserver = PushObserver.CANCEL;
            this.hostName = str;
            this.client = z;
            this.socket = socket2;
        }

        public Builder handler(IncomingStreamHandler incomingStreamHandler) {
            this.handler = incomingStreamHandler;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public FramedConnection build() throws IOException {
            return new FramedConnection(this);
        }
    }

    class Reader extends NamedRunnable implements FrameReader.Handler {
        FrameReader frameReader;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        private Reader() {
            super("OkHttp %s", FramedConnection.this.hostName);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR;
            r1 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r5.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r5.this$0.close(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
            com.squareup.okhttp.internal.Util.closeQuietly(r5.frameReader);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0042 */
        public void execute() {
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            this.frameReader = FramedConnection.this.variant.newReader(jbg.O000000o(jbg.O00000Oo(FramedConnection.this.socket)), FramedConnection.this.client);
            if (!FramedConnection.this.client) {
                this.frameReader.readConnectionPreface();
            }
            do {
            } while (this.frameReader.nextFrame(this));
            errorCode = ErrorCode.NO_ERROR;
            ErrorCode errorCode3 = ErrorCode.CANCEL;
            try {
                FramedConnection framedConnection = FramedConnection.this;
                framedConnection.close(errorCode, errorCode3);
            } catch (IOException unused) {
            }
            Util.closeQuietly(this.frameReader);
        }

        public void data(boolean z, int i, jaz jaz, int i2) throws IOException {
            if (FramedConnection.this.pushedStream(i)) {
                FramedConnection.this.pushDataLater(i, jaz, i2, z);
                return;
            }
            FramedStream stream = FramedConnection.this.getStream(i);
            if (stream == null) {
                FramedConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                jaz.O0000Oo0((long) i2);
                return;
            }
            stream.receiveData(jaz, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
            if (r14.failIfStreamPresent() == false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0084, code lost:
            r0.closeLater(com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR);
            r8.this$0.removeStream(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x008e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
            r0.receiveHeaders(r13, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0094, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            if (FramedConnection.this.pushedStream(i)) {
                FramedConnection.this.pushHeadersLater(i, list, z2);
                return;
            }
            synchronized (FramedConnection.this) {
                if (!FramedConnection.this.shutdown) {
                    FramedStream stream = FramedConnection.this.getStream(i);
                    if (stream == null) {
                        if (headersMode.failIfStreamAbsent()) {
                            FramedConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                        } else if (i > FramedConnection.this.lastGoodStreamId) {
                            if (i % 2 != FramedConnection.this.nextStreamId % 2) {
                                final FramedStream framedStream = new FramedStream(i, FramedConnection.this, z, z2, list);
                                FramedConnection.this.lastGoodStreamId = i;
                                FramedConnection.this.streams.put(Integer.valueOf(i), framedStream);
                                FramedConnection.executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{FramedConnection.this.hostName, Integer.valueOf(i)}) {
                                    /* class com.squareup.okhttp.internal.framed.FramedConnection.Reader.AnonymousClass1 */

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
                                     arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
                                     candidates:
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
                                      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
                                    public void execute() {
                                        try {
                                            FramedConnection.this.handler.receive(framedStream);
                                        } catch (IOException e) {
                                            Logger logger = Internal.logger;
                                            Level level = Level.INFO;
                                            logger.log(level, "StreamHandler failure for " + FramedConnection.this.hostName, (Throwable) e);
                                            try {
                                                framedStream.close(ErrorCode.PROTOCOL_ERROR);
                                            } catch (IOException unused) {
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (FramedConnection.this.pushedStream(i)) {
                FramedConnection.this.pushResetLater(i, errorCode);
                return;
            }
            FramedStream removeStream = FramedConnection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        public void settings(boolean z, Settings settings) {
            FramedStream[] framedStreamArr;
            long j;
            synchronized (FramedConnection.this) {
                int initialWindowSize = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
                if (z) {
                    FramedConnection.this.peerSettings.clear();
                }
                FramedConnection.this.peerSettings.merge(settings);
                if (FramedConnection.this.getProtocol() == Protocol.HTTP_2) {
                    ackSettingsLater(settings);
                }
                int initialWindowSize2 = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
                framedStreamArr = null;
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    j = 0;
                } else {
                    j = (long) (initialWindowSize2 - initialWindowSize);
                    if (!FramedConnection.this.receivedInitialPeerSettings) {
                        FramedConnection.this.addBytesToWriteWindow(j);
                        FramedConnection.this.receivedInitialPeerSettings = true;
                    }
                    if (!FramedConnection.this.streams.isEmpty()) {
                        framedStreamArr = FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
                    }
                }
            }
            if (framedStreamArr != null && j != 0) {
                for (FramedStream framedStream : framedStreamArr) {
                    synchronized (framedStream) {
                        framedStream.addBytesToWriteWindow(j);
                    }
                }
            }
        }

        private void ackSettingsLater(final Settings settings) {
            FramedConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.hostName}) {
                /* class com.squareup.okhttp.internal.framed.FramedConnection.Reader.AnonymousClass2 */

                public void execute() {
                    try {
                        FramedConnection.this.frameWriter.ackSettings(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                Ping removePing = FramedConnection.this.removePing(i);
                if (removePing != null) {
                    removePing.receive();
                    return;
                }
                return;
            }
            FramedConnection.this.writePingLater(true, i, i2, null);
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            FramedStream[] framedStreamArr;
            synchronized (FramedConnection.this) {
                framedStreamArr = (FramedStream[]) FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
                FramedConnection.this.shutdown = true;
            }
            for (FramedStream framedStream : framedStreamArr) {
                if (framedStream.getId() > i && framedStream.isLocallyInitiated()) {
                    framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.removeStream(framedStream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (FramedConnection.this) {
                    FramedConnection.this.bytesLeftInWriteWindow += j;
                    FramedConnection.this.notifyAll();
                }
                return;
            }
            FramedStream stream = FramedConnection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            FramedConnection.this.pushRequestLater(i2, list);
        }
    }

    public final boolean pushedStream(int i) {
        return this.protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    public final void pushRequestLater(int i, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            final int i2 = i;
            final List<Header> list2 = list;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
                /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass4 */

                public void execute() {
                    if (FramedConnection.this.pushObserver.onRequest(i2, list2)) {
                        try {
                            FramedConnection.this.frameWriter.rstStream(i2, ErrorCode.CANCEL);
                            synchronized (FramedConnection.this) {
                                FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    public final void pushHeadersLater(int i, List<Header> list, boolean z) {
        final int i2 = i;
        final List<Header> list2 = list;
        final boolean z2 = z;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass5 */

            public void execute() {
                boolean onHeaders = FramedConnection.this.pushObserver.onHeaders(i2, list2, z2);
                if (onHeaders) {
                    try {
                        FramedConnection.this.frameWriter.rstStream(i2, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!onHeaders) {
                    if (!z2) {
                        return;
                    }
                }
                synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    public final void pushDataLater(int i, jaz jaz, int i2, boolean z) throws IOException {
        final jax jax = new jax();
        long j = (long) i2;
        jaz.O000000o(j);
        jaz.read(jax, j);
        if (jax.O00000Oo == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
                /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass6 */

                public void execute() {
                    try {
                        boolean onData = FramedConnection.this.pushObserver.onData(i3, jax, i4, z2);
                        if (onData) {
                            FramedConnection.this.frameWriter.rstStream(i3, ErrorCode.CANCEL);
                        }
                        if (!onData) {
                            if (!z2) {
                                return;
                            }
                        }
                        synchronized (FramedConnection.this) {
                            FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i3));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(jax.O00000Oo + " != " + i2);
    }

    public final void pushResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.framed.FramedConnection.AnonymousClass7 */

            public void execute() {
                FramedConnection.this.pushObserver.onReset(i2, errorCode2);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
