package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    private static final ConnectionPool systemDefault;
    private final Deque<Connection> connections = new ArrayDeque();
    private final Runnable connectionsCleanupRunnable = new Runnable() {
        /* class com.squareup.okhttp.ConnectionPool.AnonymousClass1 */

        public void run() {
            ConnectionPool.this.runCleanupUntilPoolIsEmpty();
        }
    };
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, parseLong);
        } else if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), parseLong);
        } else {
            systemDefault = new ConnectionPool(5, parseLong);
        }
    }

    public ConnectionPool(int i, long j) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = j * 1000 * 1000;
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    public final synchronized int getConnectionCount() {
        return this.connections.size();
    }

    @Deprecated
    public final synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    public final synchronized int getMultiplexedConnectionCount() {
        int i;
        i = 0;
        for (Connection isFramed : this.connections) {
            if (isFramed.isFramed()) {
                i++;
            }
        }
        return i;
    }

    public final synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    public final synchronized Connection get(Address address) {
        Connection connection;
        Connection next;
        connection = null;
        Iterator<Connection> descendingIterator = this.connections.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                break;
            }
            next = descendingIterator.next();
            if (next.getRoute().getAddress().equals(address) && next.isAlive() && System.nanoTime() - next.getIdleStartTimeNs() < this.keepAliveDurationNs) {
                descendingIterator.remove();
                if (next.isFramed()) {
                    break;
                }
                try {
                    Platform.get().tagSocket(next.getSocket());
                    break;
                } catch (SocketException e) {
                    Util.closeQuietly(next.getSocket());
                    Platform.get().logW("Unable to tagSocket(): ".concat(String.valueOf(e)));
                }
            }
        }
        connection = next;
        if (connection != null && connection.isFramed()) {
            this.connections.addFirst(connection);
        }
        return connection;
    }

    /* access modifiers changed from: package-private */
    public final void recycle(Connection connection) {
        if (connection.isFramed() || !connection.clearOwner()) {
            return;
        }
        if (!connection.isAlive()) {
            Util.closeQuietly(connection.getSocket());
            return;
        }
        try {
            Platform.get().untagSocket(connection.getSocket());
            synchronized (this) {
                addConnection(connection);
                connection.incrementRecycleCount();
                connection.resetIdleStartTime();
            }
        } catch (SocketException e) {
            Platform.get().logW("Unable to untagSocket(): ".concat(String.valueOf(e)));
            Util.closeQuietly(connection.getSocket());
        }
    }

    private void addConnection(Connection connection) {
        boolean isEmpty = this.connections.isEmpty();
        this.connections.addFirst(connection);
        if (isEmpty) {
            this.executor.execute(this.connectionsCleanupRunnable);
        } else {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public final void share(Connection connection) {
        if (!connection.isFramed()) {
            throw new IllegalArgumentException();
        } else if (connection.isAlive()) {
            synchronized (this) {
                addConnection(connection);
            }
        }
    }

    public final void evictAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
            this.connections.clear();
            notifyAll();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Util.closeQuietly(((Connection) arrayList.get(i)).getSocket());
        }
    }

    public final void runCleanupUntilPoolIsEmpty() {
        do {
        } while (performCleanup());
    }

    /* access modifiers changed from: package-private */
    public final boolean performCleanup() {
        synchronized (this) {
            if (this.connections.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            long nanoTime = System.nanoTime();
            long j = this.keepAliveDurationNs;
            Iterator<Connection> descendingIterator = this.connections.descendingIterator();
            long j2 = j;
            int i = 0;
            while (descendingIterator.hasNext()) {
                Connection next = descendingIterator.next();
                long idleStartTimeNs = (next.getIdleStartTimeNs() + this.keepAliveDurationNs) - nanoTime;
                if (idleStartTimeNs > 0) {
                    if (next.isAlive()) {
                        if (next.isIdle()) {
                            i++;
                            j2 = Math.min(j2, idleStartTimeNs);
                        }
                    }
                }
                descendingIterator.remove();
                arrayList.add(next);
            }
            Iterator<Connection> descendingIterator2 = this.connections.descendingIterator();
            while (descendingIterator2.hasNext() && i > this.maxIdleConnections) {
                Connection next2 = descendingIterator2.next();
                if (next2.isIdle()) {
                    arrayList.add(next2);
                    descendingIterator2.remove();
                    i--;
                }
            }
            if (arrayList.isEmpty()) {
                try {
                    long j3 = j2 / 1000000;
                    Long.signum(j3);
                    wait(j3, (int) (j2 - (1000000 * j3)));
                    return true;
                } catch (InterruptedException unused) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Util.closeQuietly(((Connection) arrayList.get(i2)).getSocket());
                    }
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void replaceCleanupExecutorForTests(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<Connection> getConnections() {
        return new ArrayList(this.connections);
    }
}
