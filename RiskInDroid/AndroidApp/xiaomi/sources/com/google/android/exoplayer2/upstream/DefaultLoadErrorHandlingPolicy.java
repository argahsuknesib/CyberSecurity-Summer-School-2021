package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    private final int minimumLoadableRetryCount;

    public /* synthetic */ long getBlacklistDurationMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return LoadErrorHandlingPolicy.CC.$default$getBlacklistDurationMsFor(this, loadErrorInfo);
    }

    public /* synthetic */ long getRetryDelayMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return LoadErrorHandlingPolicy.CC.$default$getRetryDelayMsFor(this, loadErrorInfo);
    }

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int i) {
        this.minimumLoadableRetryCount = i;
    }

    public long getBlacklistDurationMsFor(int i, long j, IOException iOException, int i2) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i3 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        if (i3 == 404 || i3 == 410 || i3 == 416) {
            return 60000;
        }
        return -9223372036854775807L;
    }

    public long getRetryDelayMsFor(int i, long j, IOException iOException, int i2) {
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return (long) Math.min((i2 - 1) * 1000, 5000);
    }

    public int getMinimumLoadableRetryCount(int i) {
        int i2 = this.minimumLoadableRetryCount;
        if (i2 == -1) {
            return i == 7 ? 6 : 3;
        }
        return i2;
    }
}
