package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class PlayerEmsgHandler implements Handler.Callback {
    private final Allocator allocator;
    public final EventMessageDecoder decoder = new EventMessageDecoder();
    private long expiredManifestPublishTimeUs;
    public final Handler handler = Util.createHandler(this);
    private boolean isWaitingForManifestRefresh;
    private long lastLoadedChunkEndTimeBeforeRefreshUs = -9223372036854775807L;
    private long lastLoadedChunkEndTimeUs = -9223372036854775807L;
    private DashManifest manifest;
    private final TreeMap<Long, Long> manifestPublishTimeToExpiryTimeUs = new TreeMap<>();
    private final PlayerEmsgCallback playerEmsgCallback;
    private boolean released;

    public interface PlayerEmsgCallback {
        void onDashManifestPublishTimeExpired(long j);

        void onDashManifestRefreshRequested();
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback2, Allocator allocator2) {
        this.manifest = dashManifest;
        this.playerEmsgCallback = playerEmsgCallback2;
        this.allocator = allocator2;
    }

    public final void updateManifest(DashManifest dashManifest) {
        this.isWaitingForManifestRefresh = false;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.manifest = dashManifest;
        removePreviouslyExpiredManifestPublishTimeValues();
    }

    /* access modifiers changed from: package-private */
    public final boolean maybeRefreshManifestBeforeLoadingNextChunk(long j) {
        boolean z = false;
        if (!this.manifest.dynamic) {
            return false;
        }
        if (this.isWaitingForManifestRefresh) {
            return true;
        }
        Map.Entry<Long, Long> ceilingExpiryEntryForPublishTime = ceilingExpiryEntryForPublishTime(this.manifest.publishTimeMs);
        if (ceilingExpiryEntryForPublishTime != null && ceilingExpiryEntryForPublishTime.getValue().longValue() < j) {
            this.expiredManifestPublishTimeUs = ceilingExpiryEntryForPublishTime.getKey().longValue();
            notifyManifestPublishTimeExpired();
            z = true;
        }
        if (z) {
            maybeNotifyDashManifestRefreshNeeded();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean maybeRefreshManifestOnLoadingError(Chunk chunk) {
        if (!this.manifest.dynamic) {
            return false;
        }
        if (this.isWaitingForManifestRefresh) {
            return true;
        }
        long j = this.lastLoadedChunkEndTimeUs;
        if (!(j != -9223372036854775807L && j < chunk.startTimeUs)) {
            return false;
        }
        maybeNotifyDashManifestRefreshNeeded();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void onChunkLoadCompleted(Chunk chunk) {
        if (this.lastLoadedChunkEndTimeUs != -9223372036854775807L || chunk.endTimeUs > this.lastLoadedChunkEndTimeUs) {
            this.lastLoadedChunkEndTimeUs = chunk.endTimeUs;
        }
    }

    public static boolean isPlayerEmsgEvent(String str, String str2) {
        if ("urn:mpeg:dash:event:2012".equals(str)) {
            return "1".equals(str2) || "2".equals(str2) || "3".equals(str2);
        }
        return false;
    }

    public final PlayerTrackEmsgHandler newPlayerTrackEmsgHandler() {
        return new PlayerTrackEmsgHandler(this.allocator);
    }

    public final void release() {
        this.released = true;
        this.handler.removeCallbacksAndMessages(null);
    }

    public final boolean handleMessage(Message message) {
        if (this.released) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        ManifestExpiryEventInfo manifestExpiryEventInfo = (ManifestExpiryEventInfo) message.obj;
        handleManifestExpiredMessage(manifestExpiryEventInfo.eventTimeUs, manifestExpiryEventInfo.manifestPublishTimeMsInEmsg);
        return true;
    }

    private void handleManifestExpiredMessage(long j, long j2) {
        Long l = this.manifestPublishTimeToExpiryTimeUs.get(Long.valueOf(j2));
        if (l == null) {
            this.manifestPublishTimeToExpiryTimeUs.put(Long.valueOf(j2), Long.valueOf(j));
        } else if (l.longValue() > j) {
            this.manifestPublishTimeToExpiryTimeUs.put(Long.valueOf(j2), Long.valueOf(j));
        }
    }

    private Map.Entry<Long, Long> ceilingExpiryEntryForPublishTime(long j) {
        return this.manifestPublishTimeToExpiryTimeUs.ceilingEntry(Long.valueOf(j));
    }

    private void removePreviouslyExpiredManifestPublishTimeValues() {
        Iterator<Map.Entry<Long, Long>> it = this.manifestPublishTimeToExpiryTimeUs.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) it.next().getKey()).longValue() < this.manifest.publishTimeMs) {
                it.remove();
            }
        }
    }

    private void notifyManifestPublishTimeExpired() {
        this.playerEmsgCallback.onDashManifestPublishTimeExpired(this.expiredManifestPublishTimeUs);
    }

    private void maybeNotifyDashManifestRefreshNeeded() {
        long j = this.lastLoadedChunkEndTimeBeforeRefreshUs;
        if (j == -9223372036854775807L || j != this.lastLoadedChunkEndTimeUs) {
            this.isWaitingForManifestRefresh = true;
            this.lastLoadedChunkEndTimeBeforeRefreshUs = this.lastLoadedChunkEndTimeUs;
            this.playerEmsgCallback.onDashManifestRefreshRequested();
        }
    }

    public static long getManifestPublishTimeMsInEmsg(EventMessage eventMessage) {
        try {
            return Util.parseXsDateTime(Util.fromUtf8Bytes(eventMessage.messageData));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    public final class PlayerTrackEmsgHandler implements TrackOutput {
        private final MetadataInputBuffer buffer = new MetadataInputBuffer();
        private final FormatHolder formatHolder = new FormatHolder();
        private final SampleQueue sampleQueue;

        PlayerTrackEmsgHandler(Allocator allocator) {
            this.sampleQueue = new SampleQueue(allocator, DrmSessionManager.CC.getDummyDrmSessionManager(), new MediaSourceEventDispatcher());
        }

        public final void format(Format format) {
            this.sampleQueue.format(format);
        }

        public final int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
            return this.sampleQueue.sampleData(dataReader, i, z);
        }

        public final void sampleData(ParsableByteArray parsableByteArray, int i) {
            this.sampleQueue.sampleData(parsableByteArray, i);
        }

        public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            this.sampleQueue.sampleMetadata(j, i, i2, i3, cryptoData);
            parseAndDiscardSamples();
        }

        public final boolean maybeRefreshManifestBeforeLoadingNextChunk(long j) {
            return PlayerEmsgHandler.this.maybeRefreshManifestBeforeLoadingNextChunk(j);
        }

        public final void onChunkLoadCompleted(Chunk chunk) {
            PlayerEmsgHandler.this.onChunkLoadCompleted(chunk);
        }

        public final boolean maybeRefreshManifestOnLoadingError(Chunk chunk) {
            return PlayerEmsgHandler.this.maybeRefreshManifestOnLoadingError(chunk);
        }

        public final void release() {
            this.sampleQueue.release();
        }

        private void parseAndDiscardSamples() {
            while (this.sampleQueue.isReady(false)) {
                MetadataInputBuffer dequeueSample = dequeueSample();
                if (dequeueSample != null) {
                    long j = dequeueSample.timeUs;
                    EventMessage eventMessage = (EventMessage) PlayerEmsgHandler.this.decoder.decode(dequeueSample).get(0);
                    if (PlayerEmsgHandler.isPlayerEmsgEvent(eventMessage.schemeIdUri, eventMessage.value)) {
                        parsePlayerEmsgEvent(j, eventMessage);
                    }
                }
            }
            this.sampleQueue.discardToRead();
        }

        private MetadataInputBuffer dequeueSample() {
            this.buffer.clear();
            if (this.sampleQueue.read(this.formatHolder, this.buffer, false, false, 0) != -4) {
                return null;
            }
            this.buffer.flip();
            return this.buffer;
        }

        private void parsePlayerEmsgEvent(long j, EventMessage eventMessage) {
            long manifestPublishTimeMsInEmsg = PlayerEmsgHandler.getManifestPublishTimeMsInEmsg(eventMessage);
            if (manifestPublishTimeMsInEmsg != -9223372036854775807L) {
                onManifestExpiredMessageEncountered(j, manifestPublishTimeMsInEmsg);
            }
        }

        private void onManifestExpiredMessageEncountered(long j, long j2) {
            PlayerEmsgHandler.this.handler.sendMessage(PlayerEmsgHandler.this.handler.obtainMessage(1, new ManifestExpiryEventInfo(j, j2)));
        }
    }

    static final class ManifestExpiryEventInfo {
        public final long eventTimeUs;
        public final long manifestPublishTimeMsInEmsg;

        public ManifestExpiryEventInfo(long j, long j2) {
            this.eventTimeUs = j;
            this.manifestPublishTimeMsInEmsg = j2;
        }
    }
}
