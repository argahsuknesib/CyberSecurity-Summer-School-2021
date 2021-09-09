package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

@Deprecated
public abstract class DefaultMediaSourceEventListener implements MediaSourceEventListener {
    public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.CC.$default$onDownstreamFormatChanged(this, i, mediaPeriodId, mediaLoadData);
    }

    public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.CC.$default$onLoadCanceled(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.CC.$default$onLoadCompleted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        MediaSourceEventListener.CC.$default$onLoadError(this, i, mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
    }

    public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.CC.$default$onLoadStarted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSourceEventListener.CC.$default$onMediaPeriodCreated(this, i, mediaPeriodId);
    }

    public /* synthetic */ void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSourceEventListener.CC.$default$onMediaPeriodReleased(this, i, mediaPeriodId);
    }

    public /* synthetic */ void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSourceEventListener.CC.$default$onReadingStarted(this, i, mediaPeriodId);
    }

    public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.CC.$default$onUpstreamDiscarded(this, i, mediaPeriodId, mediaLoadData);
    }
}
