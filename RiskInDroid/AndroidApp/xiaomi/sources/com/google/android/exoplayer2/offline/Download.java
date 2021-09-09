package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Download {
    public final long contentLength;
    public final int failureReason;
    final DownloadProgress progress;
    public final DownloadRequest request;
    public final long startTimeMs;
    public final int state;
    public final int stopReason;
    public final long updateTimeMs;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public Download(DownloadRequest downloadRequest, int i, long j, long j2, long j3, int i2, int i3) {
        this(downloadRequest, i, j, j2, j3, i2, i3, new DownloadProgress());
    }

    public Download(DownloadRequest downloadRequest, int i, long j, long j2, long j3, int i2, int i3, DownloadProgress downloadProgress) {
        Assertions.checkNotNull(downloadProgress);
        boolean z = true;
        Assertions.checkArgument((i3 == 0) == (i != 4));
        if (i2 != 0) {
            Assertions.checkArgument((i == 2 || i == 0) ? false : z);
        }
        this.request = downloadRequest;
        this.state = i;
        this.startTimeMs = j;
        this.updateTimeMs = j2;
        this.contentLength = j3;
        this.stopReason = i2;
        this.failureReason = i3;
        this.progress = downloadProgress;
    }

    public final boolean isTerminalState() {
        int i = this.state;
        return i == 3 || i == 4;
    }

    public final long getBytesDownloaded() {
        return this.progress.bytesDownloaded;
    }

    public final float getPercentDownloaded() {
        return this.progress.percentDownloaded;
    }
}
