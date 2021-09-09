package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface MediaSourceEventListener {

    /* renamed from: com.google.android.exoplayer2.source.MediaSourceEventListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDownstreamFormatChanged(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        }

        public static void $default$onLoadCanceled(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        }

        public static void $default$onLoadCompleted(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        }

        public static void $default$onLoadError(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        }

        public static void $default$onLoadStarted(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        }

        public static void $default$onMediaPeriodCreated(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        public static void $default$onMediaPeriodReleased(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        public static void $default$onReadingStarted(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        }

        public static void $default$onUpstreamDiscarded(MediaSourceEventListener mediaSourceEventListener, int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        }
    }

    void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z);

    void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    @Deprecated
    public static final class EventDispatcher extends MediaSourceEventDispatcher {
        public EventDispatcher() {
        }

        private EventDispatcher(CopyOnWriteMultiset<MediaSourceEventDispatcher.ListenerInfo> copyOnWriteMultiset, int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
            super(copyOnWriteMultiset, i, mediaPeriodId, j);
        }

        public final EventDispatcher withParameters(int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
            return new EventDispatcher(this.listenerInfos, i, mediaPeriodId, j);
        }

        public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            addEventListener(handler, mediaSourceEventListener, MediaSourceEventListener.class);
        }

        public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            removeEventListener(mediaSourceEventListener, MediaSourceEventListener.class);
        }

        public final void mediaPeriodCreated() {
            dispatch($$Lambda$MediaSourceEventListener$EventDispatcher$BSABueoK3ofLZMEn1Wj6ryFbyrY.INSTANCE, MediaSourceEventListener.class);
        }

        public final void mediaPeriodReleased() {
            dispatch($$Lambda$MediaSourceEventListener$EventDispatcher$vlz4NUVKOY8bnHdhfwJGjjr3kDk.INSTANCE, MediaSourceEventListener.class);
        }

        public final void loadStarted(DataSpec dataSpec, int i, long j) {
            loadStarted(dataSpec, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public final void loadStarted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            DataSpec dataSpec2 = dataSpec;
            loadStarted(new LoadEventInfo(dataSpec2, dataSpec2.uri, Collections.emptyMap(), j3, 0, 0), new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public final void loadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId(mediaLoadData) {
                /* class com.google.android.exoplayer2.source.$$Lambda$MediaSourceEventListener$EventDispatcher$vTl_7nvWHtQz__m0XkoSvyC45EU */
                private final /* synthetic */ MediaLoadData f$1;

                {
                    this.f$1 = r2;
                }

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadStarted(i, mediaPeriodId, LoadEventInfo.this, this.f$1);
                }
            }, MediaSourceEventListener.class);
        }

        public final void loadCompleted(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int i, long j, long j2, long j3) {
            loadCompleted(dataSpec, uri, map, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void loadCompleted(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            loadCompleted(new LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public final void loadCompleted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId(mediaLoadData) {
                /* class com.google.android.exoplayer2.source.$$Lambda$MediaSourceEventListener$EventDispatcher$OzX_FFYZFDmhdwoYNuvzWAahKM */
                private final /* synthetic */ MediaLoadData f$1;

                {
                    this.f$1 = r2;
                }

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadCompleted(i, mediaPeriodId, LoadEventInfo.this, this.f$1);
                }
            }, MediaSourceEventListener.class);
        }

        public final void loadCanceled(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int i, long j, long j2, long j3) {
            loadCanceled(dataSpec, uri, map, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void loadCanceled(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            loadCanceled(new LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public final void loadCanceled(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId(mediaLoadData) {
                /* class com.google.android.exoplayer2.source.$$Lambda$MediaSourceEventListener$EventDispatcher$d7dtqSMogmZi4SFb7eEAPAGvFck */
                private final /* synthetic */ MediaLoadData f$1;

                {
                    this.f$1 = r2;
                }

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadCanceled(i, mediaPeriodId, LoadEventInfo.this, this.f$1);
                }
            }, MediaSourceEventListener.class);
        }

        public final void loadError(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            loadError(dataSpec, uri, map, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public final void loadError(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            loadError(new LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)), iOException, z);
        }

        public final void loadError(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId(mediaLoadData, iOException, z) {
                /* class com.google.android.exoplayer2.source.$$Lambda$MediaSourceEventListener$EventDispatcher$jfO1RmKBteeXHPKaCoLB5lNKLU */
                private final /* synthetic */ MediaLoadData f$1;
                private final /* synthetic */ IOException f$2;
                private final /* synthetic */ boolean f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadError(i, mediaPeriodId, LoadEventInfo.this, this.f$1, this.f$2, this.f$3);
                }
            }, MediaSourceEventListener.class);
        }

        public final void readingStarted() {
            dispatch($$Lambda$MediaSourceEventListener$EventDispatcher$N1B7VYHNXvjDJdSJHEaHdlLEKBo.INSTANCE, MediaSourceEventListener.class);
        }

        public final void upstreamDiscarded(int i, long j, long j2) {
            upstreamDiscarded(new MediaLoadData(1, i, null, 3, null, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public final void upstreamDiscarded(MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() {
                /* class com.google.android.exoplayer2.source.$$Lambda$MediaSourceEventListener$EventDispatcher$kR0U2wJv0e4HsjIeRNXVknvigHQ */

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onUpstreamDiscarded(i, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId), MediaLoadData.this);
                }
            }, MediaSourceEventListener.class);
        }

        public final void downstreamFormatChanged(int i, Format format, int i2, Object obj, long j) {
            downstreamFormatChanged(new MediaLoadData(1, i, format, i2, obj, adjustMediaTime(j), -9223372036854775807L));
        }

        public final void downstreamFormatChanged(MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() {
                /* class com.google.android.exoplayer2.source.$$Lambda$MediaSourceEventListener$EventDispatcher$Ez7ifp4AhUDdXDDMq9a6tDPYEls */

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onDownstreamFormatChanged(i, mediaPeriodId, MediaLoadData.this);
                }
            }, MediaSourceEventListener.class);
        }

        private long adjustMediaTime(long j) {
            return adjustMediaTime(j, this.mediaTimeOffsetMs);
        }
    }
}
