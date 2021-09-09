package okhttp3.internal.ws;

import _m_j.jay;
import _m_j.jaz;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.ws.WebSocketReader;
import okio.ByteString;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random2, long j) {
        if ("GET".equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random2;
            this.pingIntervalMillis = j;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            this.key = ByteString.O000000o(bArr).O00000Oo();
            this.writerRunnable = new Runnable() {
                /* class okhttp3.internal.ws.RealWebSocket.AnonymousClass1 */

                public void run() {
                    do {
                        try {
                        } catch (IOException e) {
                            RealWebSocket.this.failWebSocket(e, null);
                            return;
                        }
                    } while (RealWebSocket.this.writeOneFrame());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    public final Request request() {
        return this.originalRequest;
    }

    public final synchronized long queueSize() {
        return this.queueSize;
    }

    public final void cancel() {
        this.call.cancel();
    }

    public final void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        this.call = Internal.instance.newWebSocketCall(build, build2);
        this.call.timeout().clearTimeout();
        this.call.enqueue(new Callback() {
            /* class okhttp3.internal.ws.RealWebSocket.AnonymousClass2 */

            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.listener.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void checkResponse(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String O00000Oo = ByteString.O000000o(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").O00000o().O00000Oo();
                    if (!O00000Oo.equals(header3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + O00000Oo + "' but was '" + header3 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        synchronized (this) {
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.client, streams2.sink, this.random);
            this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            if (this.pingIntervalMillis != 0) {
                this.executor.scheduleAtFixedRate(new PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams2.client, streams2.source, this);
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination((long) i, timeUnit);
    }

    /* access modifiers changed from: package-private */
    public final void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public final void onReadMessage(String str) throws IOException {
        this.listener.onMessage(this, str);
    }

    public final void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage(this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    public final synchronized void onReadPing(ByteString byteString) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                this.receivedPingCount++;
            }
        }
    }

    public final synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final void onReadClose(int i, String str) {
        Streams streams2;
        if (i != -1) {
            synchronized (this) {
                if (this.receivedCloseCode == -1) {
                    this.receivedCloseCode = i;
                    this.receivedCloseReason = str;
                    if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                        streams2 = null;
                    } else {
                        streams2 = this.streams;
                        this.streams = null;
                        if (this.cancelFuture != null) {
                            this.cancelFuture.cancel(false);
                        }
                        this.executor.shutdown();
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.listener.onClosing(this, i, str);
                if (streams2 != null) {
                    this.listener.onClosed(this, i, str);
                }
            } finally {
                Util.closeQuietly(streams2);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final boolean send(String str) {
        if (str != null) {
            return send(ByteString.O000000o(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public final boolean send(ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    private synchronized boolean send(ByteString byteString, int i) {
        if (!this.failed) {
            if (!this.enqueuedClose) {
                if (this.queueSize + ((long) byteString.O0000OOo()) > 16777216) {
                    close(1001, null);
                    return false;
                }
                this.queueSize += (long) byteString.O0000OOo();
                this.messageAndCloseQueue.add(new Message(i, byteString));
                runWriter();
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean pong(ByteString byteString) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return false;
    }

    public final boolean close(int i, String str) {
        return close(i, str, 60000);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.validateCloseCode(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.O000000o(str);
            if (((long) byteString.O0000OOo()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: ".concat(String.valueOf(str)));
            }
        }
        if (!this.failed) {
            if (!this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, byteString, j));
                runWriter();
                return true;
            }
        }
        return false;
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r2 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        r1 = ((okhttp3.internal.ws.RealWebSocket.Message) r4).data;
        r0 = _m_j.jbg.O000000o(r0.newMessageSink(((okhttp3.internal.ws.RealWebSocket.Message) r4).formatOpcode, (long) r1.O0000OOo()));
        r0.O00000o0(r1);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r11.queueSize -= (long) r1.O0000OOo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4;
        r0.writeClose(r4.code, r4.reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
        if (r3 == null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        r11.listener.onClosed(r11, r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        okhttp3.internal.Util.closeQuietly(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a3, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a5, code lost:
        okhttp3.internal.Util.closeQuietly(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a8, code lost:
        throw r0;
     */
    public final boolean writeOneFrame() throws IOException {
        String str;
        Object obj;
        synchronized (this) {
            int i = 0;
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            ByteString poll = this.pongQueue.poll();
            Streams streams2 = null;
            if (poll == null) {
                obj = this.messageAndCloseQueue.poll();
                if (obj instanceof Close) {
                    i = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i != -1) {
                        Streams streams3 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        streams2 = streams3;
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) obj).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                } else {
                    str = null;
                }
            } else {
                obj = null;
                str = null;
            }
        }
    }

    final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public final void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1 == -1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.writePing(okio.ByteString.O00000Oo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        failWebSocket(r0, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return;
     */
    public final void writePingFrame() {
        synchronized (this) {
            if (!this.failed) {
                WebSocketWriter webSocketWriter = this.writer;
                int i = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.listener.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        okhttp3.internal.Util.closeQuietly(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r4;
     */
    public final void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            if (!this.failed) {
                this.failed = true;
                Streams streams2 = this.streams;
                this.streams = null;
                if (this.cancelFuture != null) {
                    this.cancelFuture.cancel(false);
                }
                if (this.executor != null) {
                    this.executor.shutdown();
                }
            }
        }
    }

    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final jay sink;
        public final jaz source;

        public Streams(boolean z, jaz jaz, jay jay) {
            this.client = z;
            this.source = jaz;
            this.sink = jay;
        }
    }

    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public final void run() {
            RealWebSocket.this.cancel();
        }
    }
}
