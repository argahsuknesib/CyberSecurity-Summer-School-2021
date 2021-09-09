package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final MediaSource.MediaPeriodId DUMMY_CONTENT_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    private MediaSource[][] adGroupMediaSources;
    private Timeline[][] adGroupTimelines;
    private final MediaSourceFactory adMediaSourceFactory;
    private AdPlaybackState adPlaybackState;
    private final AdsLoader.AdViewProvider adViewProvider;
    public final AdsLoader adsLoader;
    private ComponentListener componentListener;
    private final MediaSource contentMediaSource;
    private Timeline contentTimeline;
    public final Handler mainHandler;
    private final Map<MediaSource, List<MaskingMediaPeriod>> maskingMediaPeriodByAdMediaSource;
    private final Timeline.Period period;

    public static final class AdLoadException extends IOException {
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException("Failed to load ad group ".concat(String.valueOf(i)), exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public final RuntimeException getRuntimeExceptionForUnexpected() {
            Assertions.checkState(this.type == 3);
            return (RuntimeException) Assertions.checkNotNull(getCause());
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader2, AdsLoader.AdViewProvider adViewProvider2) {
        this(mediaSource, new ProgressiveMediaSource.Factory(factory), adsLoader2, adViewProvider2);
    }

    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader2, AdsLoader.AdViewProvider adViewProvider2) {
        this.contentMediaSource = mediaSource;
        this.adMediaSourceFactory = mediaSourceFactory;
        this.adsLoader = adsLoader2;
        this.adViewProvider = adViewProvider2;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.maskingMediaPeriodByAdMediaSource = new HashMap();
        this.period = new Timeline.Period();
        this.adGroupMediaSources = new MediaSource[0][];
        this.adGroupTimelines = new Timeline[0][];
        adsLoader2.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }

    public final Object getTag() {
        return this.contentMediaSource.getTag();
    }

    public final void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        ComponentListener componentListener2 = new ComponentListener();
        this.componentListener = componentListener2;
        prepareChildSource(DUMMY_CONTENT_MEDIA_PERIOD_ID, this.contentMediaSource);
        this.mainHandler.post(new Runnable(componentListener2) {
            /* class com.google.android.exoplayer2.source.ads.$$Lambda$AdsMediaSource$zcXBZahV9Fk_KJACPObl_WWX0 */
            private final /* synthetic */ AdsMediaSource.ComponentListener f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AdsMediaSource.this.lambda$prepareSourceInternal$0$AdsMediaSource(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$prepareSourceInternal$0$AdsMediaSource(ComponentListener componentListener2) {
        this.adsLoader.start(componentListener2, this.adViewProvider);
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        AdPlaybackState adPlaybackState2 = (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackState);
        if (adPlaybackState2.adGroupCount <= 0 || !mediaPeriodId.isAd()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.contentMediaSource, mediaPeriodId, allocator, j);
            maskingMediaPeriod.createPeriod(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i = mediaPeriodId2.adGroupIndex;
        int i2 = mediaPeriodId2.adIndexInAdGroup;
        Uri uri = (Uri) Assertions.checkNotNull(adPlaybackState2.adGroups[i].uris[i2]);
        MediaSource[][] mediaSourceArr = this.adGroupMediaSources;
        if (mediaSourceArr[i].length <= i2) {
            int i3 = i2 + 1;
            mediaSourceArr[i] = (MediaSource[]) Arrays.copyOf(mediaSourceArr[i], i3);
            Timeline[][] timelineArr = this.adGroupTimelines;
            timelineArr[i] = (Timeline[]) Arrays.copyOf(timelineArr[i], i3);
        }
        MediaSource mediaSource = this.adGroupMediaSources[i][i2];
        if (mediaSource == null) {
            mediaSource = this.adMediaSourceFactory.createMediaSource(uri);
            this.adGroupMediaSources[i][i2] = mediaSource;
            this.maskingMediaPeriodByAdMediaSource.put(mediaSource, new ArrayList());
            prepareChildSource(mediaPeriodId, mediaSource);
        }
        MediaSource mediaSource2 = mediaSource;
        MaskingMediaPeriod maskingMediaPeriod2 = new MaskingMediaPeriod(mediaSource2, mediaPeriodId, allocator, j);
        maskingMediaPeriod2.setPrepareErrorListener(new AdPrepareErrorListener(uri, i, i2));
        List list = this.maskingMediaPeriodByAdMediaSource.get(mediaSource2);
        if (list == null) {
            maskingMediaPeriod2.createPeriod(new MediaSource.MediaPeriodId(((Timeline) Assertions.checkNotNull(this.adGroupTimelines[i][i2])).getUidOfPeriod(0), mediaPeriodId2.windowSequenceNumber));
        } else {
            list.add(maskingMediaPeriod2);
        }
        return maskingMediaPeriod2;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        List list = this.maskingMediaPeriodByAdMediaSource.get(maskingMediaPeriod.mediaSource);
        if (list != null) {
            list.remove(maskingMediaPeriod);
        }
        maskingMediaPeriod.releasePeriod();
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        ((ComponentListener) Assertions.checkNotNull(this.componentListener)).release();
        this.componentListener = null;
        this.maskingMediaPeriodByAdMediaSource.clear();
        this.contentTimeline = null;
        this.adPlaybackState = null;
        this.adGroupMediaSources = new MediaSource[0][];
        this.adGroupTimelines = new Timeline[0][];
        Handler handler = this.mainHandler;
        AdsLoader adsLoader2 = this.adsLoader;
        adsLoader2.getClass();
        handler.post(new Runnable() {
            /* class com.google.android.exoplayer2.source.ads.$$Lambda$yBzHoZM9PK06K3WjH43AIns_6eA */

            public final void run() {
                AdsLoader.this.stop();
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline) {
        if (mediaPeriodId.isAd()) {
            onAdSourceInfoRefreshed(mediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, timeline);
        } else {
            onContentSourceInfoRefreshed(timeline);
        }
    }

    /* access modifiers changed from: protected */
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    public final void onAdPlaybackState(AdPlaybackState adPlaybackState2) {
        if (this.adPlaybackState == null) {
            this.adGroupMediaSources = new MediaSource[adPlaybackState2.adGroupCount][];
            Arrays.fill(this.adGroupMediaSources, new MediaSource[0]);
            this.adGroupTimelines = new Timeline[adPlaybackState2.adGroupCount][];
            Arrays.fill(this.adGroupTimelines, new Timeline[0]);
        }
        this.adPlaybackState = adPlaybackState2;
        maybeUpdateSourceInfo();
    }

    private void onContentSourceInfoRefreshed(Timeline timeline) {
        boolean z = true;
        if (timeline.getPeriodCount() != 1) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.contentTimeline = timeline;
        maybeUpdateSourceInfo();
    }

    private void onAdSourceInfoRefreshed(MediaSource mediaSource, int i, int i2, Timeline timeline) {
        boolean z = true;
        if (timeline.getPeriodCount() != 1) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.adGroupTimelines[i][i2] = timeline;
        List remove = this.maskingMediaPeriodByAdMediaSource.remove(mediaSource);
        if (remove != null) {
            Object uidOfPeriod = timeline.getUidOfPeriod(0);
            for (int i3 = 0; i3 < remove.size(); i3++) {
                MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) remove.get(i3);
                maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(uidOfPeriod, maskingMediaPeriod.id.windowSequenceNumber));
            }
        }
        maybeUpdateSourceInfo();
    }

    private void maybeUpdateSourceInfo() {
        Timeline timeline = this.contentTimeline;
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 != null && timeline != null) {
            this.adPlaybackState = adPlaybackState2.withAdDurationsUs(getAdDurations(this.adGroupTimelines, this.period));
            if (this.adPlaybackState.adGroupCount != 0) {
                timeline = new SinglePeriodAdTimeline(timeline, this.adPlaybackState);
            }
            refreshSourceInfo(timeline);
        }
    }

    private static long[][] getAdDurations(Timeline[][] timelineArr, Timeline.Period period2) {
        long j;
        long[][] jArr = new long[timelineArr.length][];
        for (int i = 0; i < timelineArr.length; i++) {
            jArr[i] = new long[timelineArr[i].length];
            for (int i2 = 0; i2 < timelineArr[i].length; i2++) {
                long[] jArr2 = jArr[i];
                if (timelineArr[i][i2] == null) {
                    j = -9223372036854775807L;
                } else {
                    j = timelineArr[i][i2].getPeriod(0, period2).getDurationUs();
                }
                jArr2[i2] = j;
            }
        }
        return jArr;
    }

    final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler = Util.createHandler();
        private volatile boolean released;

        public /* synthetic */ void onAdClicked() {
            AdsLoader.EventListener.CC.$default$onAdClicked(this);
        }

        public /* synthetic */ void onAdTapped() {
            AdsLoader.EventListener.CC.$default$onAdTapped(this);
        }

        public ComponentListener() {
        }

        public final void release() {
            this.released = true;
            this.playerHandler.removeCallbacksAndMessages(null);
        }

        public final void onAdPlaybackState(AdPlaybackState adPlaybackState) {
            if (!this.released) {
                this.playerHandler.post(new Runnable(adPlaybackState) {
                    /* class com.google.android.exoplayer2.source.ads.$$Lambda$AdsMediaSource$ComponentListener$EnOXLA4Xyh_hsc2De4jHB6dR5vU */
                    private final /* synthetic */ AdPlaybackState f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AdsMediaSource.ComponentListener.this.lambda$onAdPlaybackState$0$AdsMediaSource$ComponentListener(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onAdPlaybackState$0$AdsMediaSource$ComponentListener(AdPlaybackState adPlaybackState) {
            if (!this.released) {
                AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
            }
        }

        public final void onAdLoadError(AdLoadException adLoadException, DataSpec dataSpec) {
            if (!this.released) {
                AdsMediaSource.this.createEventDispatcher(null).loadError(dataSpec, dataSpec.uri, Collections.emptyMap(), 6, -1, 0, 0, adLoadException, true);
            }
        }
    }

    final class AdPrepareErrorListener implements MaskingMediaPeriod.PrepareErrorListener {
        private final int adGroupIndex;
        private final int adIndexInAdGroup;
        private final Uri adUri;

        public AdPrepareErrorListener(Uri uri, int i, int i2) {
            this.adUri = uri;
            this.adGroupIndex = i;
            this.adIndexInAdGroup = i2;
        }

        public final void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new DataSpec(this.adUri), this.adUri, Collections.emptyMap(), 6, -1, 0, 0, AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.mainHandler.post(new Runnable(iOException) {
                /* class com.google.android.exoplayer2.source.ads.$$Lambda$AdsMediaSource$AdPrepareErrorListener$JESn0be9jt8rlP1WMBP87BIkQ8 */
                private final /* synthetic */ IOException f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AdsMediaSource.AdPrepareErrorListener.this.lambda$onPrepareError$0$AdsMediaSource$AdPrepareErrorListener(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onPrepareError$0$AdsMediaSource$AdPrepareErrorListener(IOException iOException) {
            AdsMediaSource.this.adsLoader.handlePrepareError(this.adGroupIndex, this.adIndexInAdGroup, iOException);
        }
    }
}
