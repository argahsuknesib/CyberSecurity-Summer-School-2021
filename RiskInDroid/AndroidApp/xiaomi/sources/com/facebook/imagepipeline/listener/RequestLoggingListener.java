package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestLoggingListener implements RequestListener {
    private final Map<Pair<String, String>, Long> mProducerStartTimeMap = new HashMap();
    private final Map<String, Long> mRequestStartTimeMap = new HashMap();

    public synchronized void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (FLog.isLoggable(2)) {
            FLog.v("RequestLoggingListener", "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(getTime()), str, obj, Boolean.valueOf(z));
            this.mRequestStartTimeMap.put(str, Long.valueOf(getTime()));
        }
    }

    public synchronized void onProducerStart(String str, String str2) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long time = getTime();
            this.mProducerStartTimeMap.put(create, Long.valueOf(time));
            FLog.v("RequestLoggingListener", "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(time), str, str2);
        }
    }

    public synchronized void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long time = getTime();
            FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), map);
        }
    }

    public synchronized void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        if (FLog.isLoggable(5)) {
            Pair create = Pair.create(str, str2);
            long time = getTime();
            FLog.w("RequestLoggingListener", th, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), map, th.toString());
        }
    }

    public synchronized void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long time = getTime();
            FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), map);
        }
    }

    public synchronized void onProducerEvent(String str, String str2, String str3) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            FLog.v("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(getTime()), str, str2, str3, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.get(create), getTime())));
        }
    }

    public synchronized void onUltimateProducerReached(String str, String str2, boolean z) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long time = getTime();
            FLog.v("RequestLoggingListener", "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), Boolean.valueOf(z));
        }
    }

    public synchronized void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        if (FLog.isLoggable(2)) {
            long time = getTime();
            FLog.v("RequestLoggingListener", "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(time), str, Long.valueOf(getElapsedTime(this.mRequestStartTimeMap.remove(str), time)));
        }
    }

    public synchronized void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        if (FLog.isLoggable(5)) {
            long time = getTime();
            FLog.w("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(time), str, Long.valueOf(getElapsedTime(this.mRequestStartTimeMap.remove(str), time)), th.toString());
        }
    }

    public synchronized void onRequestCancellation(String str) {
        if (FLog.isLoggable(2)) {
            long time = getTime();
            FLog.v("RequestLoggingListener", "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(time), str, Long.valueOf(getElapsedTime(this.mRequestStartTimeMap.remove(str), time)));
        }
    }

    public boolean requiresExtraMap(String str) {
        return FLog.isLoggable(2);
    }

    private static long getElapsedTime(Long l, long j) {
        if (l != null) {
            return j - l.longValue();
        }
        return -1;
    }

    private static long getTime() {
        return SystemClock.uptimeMillis();
    }
}
