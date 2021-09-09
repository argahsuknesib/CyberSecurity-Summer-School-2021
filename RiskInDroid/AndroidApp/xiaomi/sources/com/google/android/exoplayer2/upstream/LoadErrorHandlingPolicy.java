package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

public interface LoadErrorHandlingPolicy {
    long getBlacklistDurationMsFor(int i, long j, IOException iOException, int i2);

    long getBlacklistDurationMsFor(LoadErrorInfo loadErrorInfo);

    int getMinimumLoadableRetryCount(int i);

    long getRetryDelayMsFor(int i, long j, IOException iOException, int i2);

    long getRetryDelayMsFor(LoadErrorInfo loadErrorInfo);

    public static final class LoadErrorInfo {
        public final int errorCount;
        public final IOException exception;
        public final LoadEventInfo loadEventInfo;
        public final MediaLoadData mediaLoadData;

        public LoadErrorInfo(LoadEventInfo loadEventInfo2, MediaLoadData mediaLoadData2, IOException iOException, int i) {
            this.loadEventInfo = loadEventInfo2;
            this.mediaLoadData = mediaLoadData2;
            this.exception = iOException;
            this.errorCount = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$getBlacklistDurationMsFor(LoadErrorHandlingPolicy _this, LoadErrorInfo loadErrorInfo) {
            return _this.getBlacklistDurationMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
        }

        public static long $default$getRetryDelayMsFor(LoadErrorHandlingPolicy _this, LoadErrorInfo loadErrorInfo) {
            return _this.getRetryDelayMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
        }
    }
}
