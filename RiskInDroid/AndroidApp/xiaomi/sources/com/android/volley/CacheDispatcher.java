package com.android.volley;

import android.os.Process;
import com.android.volley.Cache;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = VolleyLog.DEBUG;
    private final Cache mCache;
    private final BlockingQueue<Request<?>> mCacheQueue;
    private final ResponseDelivery mDelivery;
    public final BlockingQueue<Request<?>> mNetworkQueue;
    private volatile boolean mQuit = false;

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    public void run() {
        if (DEBUG) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                final Request take = this.mCacheQueue.take();
                take.addMarker("cache-queue-take");
                if (take.isCanceled()) {
                    take.finish("cache-discard-canceled");
                } else {
                    Cache.Entry entry = this.mCache.get(take.getCacheKey());
                    if (entry == null) {
                        take.addMarker("cache-miss");
                        this.mNetworkQueue.put(take);
                    } else if (entry.isExpired()) {
                        take.addMarker("cache-hit-expired");
                        take.setCacheEntry(entry);
                        this.mNetworkQueue.put(take);
                    } else {
                        take.addMarker("cache-hit");
                        Response parseNetworkResponse = take.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
                        take.addMarker("cache-hit-parsed");
                        if (!entry.refreshNeeded()) {
                            this.mDelivery.postResponse(take, parseNetworkResponse);
                        } else {
                            take.addMarker("cache-hit-refresh-needed");
                            take.setCacheEntry(entry);
                            parseNetworkResponse.intermediate = true;
                            this.mDelivery.postResponse(take, parseNetworkResponse, new Runnable() {
                                /* class com.android.volley.CacheDispatcher.AnonymousClass1 */

                                public void run() {
                                    try {
                                        CacheDispatcher.this.mNetworkQueue.put(take);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }
}
