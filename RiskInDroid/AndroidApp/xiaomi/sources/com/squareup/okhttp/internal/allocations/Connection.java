package com.squareup.okhttp.internal.allocations;

import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.internal.Internal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public final class Connection {
    private int allocationLimit = 1;
    private final List<StreamAllocationReference> allocations = new ArrayList();
    long idleAt = Long.MAX_VALUE;
    private boolean noNewAllocations;
    public final ConnectionPool pool;

    public Connection(ConnectionPool connectionPool) {
        this.pool = connectionPool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return null;
     */
    public final StreamAllocation reserve(String str) {
        synchronized (this.pool) {
            if (!this.noNewAllocations) {
                if (this.allocations.size() < this.allocationLimit) {
                    StreamAllocation streamAllocation = new StreamAllocation();
                    this.allocations.add(new StreamAllocationReference(streamAllocation, str));
                    return streamAllocation;
                }
            }
        }
    }

    public final void release(StreamAllocation streamAllocation) {
        synchronized (this.pool) {
            if (!streamAllocation.released) {
                streamAllocation.released = true;
                if (streamAllocation.stream == null) {
                    remove(streamAllocation);
                }
            } else {
                throw new IllegalStateException("already released");
            }
        }
    }

    public final void remove(StreamAllocation streamAllocation) {
        int size = this.allocations.size();
        for (int i = 0; i < size; i++) {
            if (this.allocations.get(i).get() == streamAllocation) {
                this.allocations.remove(i);
                if (this.allocations.isEmpty()) {
                    this.idleAt = System.nanoTime();
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("unexpected allocation: ".concat(String.valueOf(streamAllocation)));
    }

    public final void noNewStreams() {
        synchronized (this.pool) {
            this.noNewAllocations = true;
            for (int i = 0; i < this.allocations.size(); i++) {
                this.allocations.get(i).rescind();
            }
        }
    }

    public final void setAllocationLimit(int i) {
        synchronized (this.pool) {
            if (i >= 0) {
                try {
                    this.allocationLimit = i;
                    while (i < this.allocations.size()) {
                        this.allocations.get(i).rescind();
                        i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public final void pruneLeakedAllocations() {
        synchronized (this.pool) {
            Iterator<StreamAllocationReference> it = this.allocations.iterator();
            while (it.hasNext()) {
                StreamAllocationReference next = it.next();
                if (next.get() == null) {
                    Logger logger = Internal.logger;
                    logger.warning("Call " + next.name + " leaked a connection. Did you forget to close a response body?");
                    this.noNewAllocations = true;
                    it.remove();
                    if (this.allocations.isEmpty()) {
                        this.idleAt = System.nanoTime();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        int size;
        synchronized (this.pool) {
            size = this.allocations.size();
        }
        return size;
    }

    public final class StreamAllocation {
        public boolean released;
        public boolean rescinded;
        public Stream stream;

        private StreamAllocation() {
        }

        public final Stream newStream(String str) {
            synchronized (Connection.this.pool) {
                if (this.stream != null || this.released) {
                    throw new IllegalStateException();
                } else if (this.rescinded) {
                    return null;
                } else {
                    this.stream = new Stream(str);
                    Stream stream2 = this.stream;
                    return stream2;
                }
            }
        }

        public final void streamComplete(Stream stream2) {
            synchronized (Connection.this.pool) {
                if (stream2 != null) {
                    if (stream2 == this.stream) {
                        this.stream = null;
                        if (this.released) {
                            Connection.this.remove(this);
                        }
                    }
                }
                throw new IllegalArgumentException();
            }
        }
    }

    static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final String name;

        public StreamAllocationReference(StreamAllocation streamAllocation, String str) {
            super(streamAllocation);
            this.name = str;
        }

        public final void rescind() {
            StreamAllocation streamAllocation = (StreamAllocation) get();
            if (streamAllocation != null) {
                streamAllocation.rescinded = true;
            }
        }
    }

    public static class Stream {
        public final String name;

        public Stream(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }
}
