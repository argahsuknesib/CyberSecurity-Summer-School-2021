package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem {
    public final ClippingProperties clippingProperties;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    public final PlaybackProperties playbackProperties;

    public static MediaItem fromUri(String str) {
        return new Builder().setSourceUri(str).build();
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setSourceUri(uri).build();
    }

    public static final class Builder {
        private long clipEndPositionMs;
        private boolean clipRelativeToDefaultPosition;
        private boolean clipRelativeToLiveWindow;
        private long clipStartPositionMs;
        private boolean clipStartsAtKeyFrame;
        private String customCacheKey;
        private Map<String, String> drmLicenseRequestHeaders;
        private Uri drmLicenseUri;
        private boolean drmMultiSession;
        private boolean drmPlayClearContentWithoutKey;
        private List<Integer> drmSessionForClearTypes;
        private UUID drmUuid;
        private String mediaId;
        private MediaMetadata mediaMetadata;
        private String mimeType;
        private Uri sourceUri;
        private List<StreamKey> streamKeys;
        private List<Subtitle> subtitles;
        private Object tag;

        public Builder() {
            this.clipEndPositionMs = Long.MIN_VALUE;
            this.drmSessionForClearTypes = Collections.emptyList();
            this.drmLicenseRequestHeaders = Collections.emptyMap();
            this.streamKeys = Collections.emptyList();
            this.subtitles = Collections.emptyList();
        }

        private Builder(MediaItem mediaItem) {
            this();
            this.clipEndPositionMs = mediaItem.clippingProperties.endPositionMs;
            this.clipRelativeToLiveWindow = mediaItem.clippingProperties.relativeToLiveWindow;
            this.clipRelativeToDefaultPosition = mediaItem.clippingProperties.relativeToDefaultPosition;
            this.clipStartsAtKeyFrame = mediaItem.clippingProperties.startsAtKeyFrame;
            this.clipStartPositionMs = mediaItem.clippingProperties.startPositionMs;
            this.mediaId = mediaItem.mediaId;
            this.mediaMetadata = mediaItem.mediaMetadata;
            PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                this.customCacheKey = playbackProperties.customCacheKey;
                this.mimeType = playbackProperties.mimeType;
                this.sourceUri = playbackProperties.sourceUri;
                this.streamKeys = playbackProperties.streamKeys;
                this.subtitles = playbackProperties.subtitles;
                this.tag = playbackProperties.tag;
                DrmConfiguration drmConfiguration = playbackProperties.drmConfiguration;
                if (drmConfiguration != null) {
                    this.drmLicenseUri = drmConfiguration.licenseUri;
                    this.drmLicenseRequestHeaders = drmConfiguration.requestHeaders;
                    this.drmMultiSession = drmConfiguration.multiSession;
                    this.drmPlayClearContentWithoutKey = drmConfiguration.playClearContentWithoutKey;
                    this.drmSessionForClearTypes = drmConfiguration.sessionForClearTypes;
                    this.drmUuid = drmConfiguration.uuid;
                }
            }
        }

        public final Builder setMediaId(String str) {
            this.mediaId = str;
            return this;
        }

        public final Builder setSourceUri(String str) {
            return setSourceUri(str == null ? null : Uri.parse(str));
        }

        public final Builder setSourceUri(Uri uri) {
            this.sourceUri = uri;
            return this;
        }

        public final Builder setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public final Builder setClipStartPositionMs(long j) {
            Assertions.checkArgument(j >= 0);
            this.clipStartPositionMs = j;
            return this;
        }

        public final Builder setClipEndPositionMs(long j) {
            Assertions.checkArgument(j == Long.MIN_VALUE || j >= 0);
            this.clipEndPositionMs = j;
            return this;
        }

        public final Builder setClipRelativeToLiveWindow(boolean z) {
            this.clipRelativeToLiveWindow = z;
            return this;
        }

        public final Builder setClipRelativeToDefaultPosition(boolean z) {
            this.clipRelativeToDefaultPosition = z;
            return this;
        }

        public final Builder setClipStartsAtKeyFrame(boolean z) {
            this.clipStartsAtKeyFrame = z;
            return this;
        }

        public final Builder setDrmLicenseUri(Uri uri) {
            this.drmLicenseUri = uri;
            return this;
        }

        public final Builder setDrmLicenseUri(String str) {
            this.drmLicenseUri = str == null ? null : Uri.parse(str);
            return this;
        }

        public final Builder setDrmLicenseRequestHeaders(Map<String, String> map) {
            Map<String, String> map2;
            if (map == null || map.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(new HashMap(map));
            }
            this.drmLicenseRequestHeaders = map2;
            return this;
        }

        public final Builder setDrmUuid(UUID uuid) {
            this.drmUuid = uuid;
            return this;
        }

        public final Builder setDrmMultiSession(boolean z) {
            this.drmMultiSession = z;
            return this;
        }

        public final Builder setDrmPlayClearContentWithoutKey(boolean z) {
            this.drmPlayClearContentWithoutKey = z;
            return this;
        }

        public final Builder setDrmSessionForClearPeriods(boolean z) {
            List list;
            if (z) {
                list = Arrays.asList(2, 1);
            } else {
                list = Collections.emptyList();
            }
            setDrmSessionForClearTypes(list);
            return this;
        }

        public final Builder setDrmSessionForClearTypes(List<Integer> list) {
            List<Integer> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.drmSessionForClearTypes = list2;
            return this;
        }

        public final Builder setStreamKeys(List<StreamKey> list) {
            List<StreamKey> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.streamKeys = list2;
            return this;
        }

        public final Builder setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
        }

        public final Builder setSubtitles(List<Subtitle> list) {
            List<Subtitle> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.subtitles = list2;
            return this;
        }

        public final Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public final Builder setMediaMetadata(MediaMetadata mediaMetadata2) {
            this.mediaMetadata = mediaMetadata2;
            return this;
        }

        public final MediaItem build() {
            PlaybackProperties playbackProperties;
            Assertions.checkState(this.drmLicenseUri == null || this.drmUuid != null);
            Uri uri = this.sourceUri;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.mimeType;
                UUID uuid = this.drmUuid;
                if (uuid != null) {
                    drmConfiguration = new DrmConfiguration(uuid, this.drmLicenseUri, this.drmLicenseRequestHeaders, this.drmMultiSession, this.drmPlayClearContentWithoutKey, this.drmSessionForClearTypes);
                }
                PlaybackProperties playbackProperties2 = new PlaybackProperties(uri, str, drmConfiguration, this.streamKeys, this.customCacheKey, this.subtitles, this.tag);
                String str2 = this.mediaId;
                if (str2 == null) {
                    str2 = this.sourceUri.toString();
                }
                this.mediaId = str2;
                playbackProperties = playbackProperties2;
            } else {
                playbackProperties = null;
            }
            String str3 = (String) Assertions.checkNotNull(this.mediaId);
            ClippingProperties clippingProperties = new ClippingProperties(this.clipStartPositionMs, this.clipEndPositionMs, this.clipRelativeToLiveWindow, this.clipRelativeToDefaultPosition, this.clipStartsAtKeyFrame);
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            if (mediaMetadata2 == null) {
                mediaMetadata2 = new MediaMetadata.Builder().build();
            }
            return new MediaItem(str3, clippingProperties, playbackProperties, mediaMetadata2);
        }
    }

    public static final class DrmConfiguration {
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final Map<String, String> requestHeaders;
        public final List<Integer> sessionForClearTypes;
        public final UUID uuid;

        private DrmConfiguration(UUID uuid2, Uri uri, Map<String, String> map, boolean z, boolean z2, List<Integer> list) {
            this.uuid = uuid2;
            this.licenseUri = uri;
            this.requestHeaders = map;
            this.multiSession = z;
            this.playClearContentWithoutKey = z2;
            this.sessionForClearTypes = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.uuid.equals(drmConfiguration.uuid) && Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) && Util.areEqual(this.requestHeaders, drmConfiguration.requestHeaders) && this.multiSession == drmConfiguration.multiSession && this.playClearContentWithoutKey == drmConfiguration.playClearContentWithoutKey && this.sessionForClearTypes.equals(drmConfiguration.sessionForClearTypes);
        }

        public final int hashCode() {
            int hashCode = this.uuid.hashCode() * 31;
            Uri uri = this.licenseUri;
            return ((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.requestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.sessionForClearTypes.hashCode();
        }
    }

    public static final class PlaybackProperties {
        public final String customCacheKey;
        public final DrmConfiguration drmConfiguration;
        public final String mimeType;
        public final Uri sourceUri;
        public final List<StreamKey> streamKeys;
        public final List<Subtitle> subtitles;
        public final Object tag;

        private PlaybackProperties(Uri uri, String str, DrmConfiguration drmConfiguration2, List<StreamKey> list, String str2, List<Subtitle> list2, Object obj) {
            this.sourceUri = uri;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration2;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitles = list2;
            this.tag = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackProperties)) {
                return false;
            }
            PlaybackProperties playbackProperties = (PlaybackProperties) obj;
            return this.sourceUri.equals(playbackProperties.sourceUri) && Util.areEqual(this.mimeType, playbackProperties.mimeType) && Util.areEqual(this.drmConfiguration, playbackProperties.drmConfiguration) && this.streamKeys.equals(playbackProperties.streamKeys) && Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey) && this.subtitles.equals(playbackProperties.subtitles) && Util.areEqual(this.tag, playbackProperties.tag);
        }

        public final int hashCode() {
            int hashCode = this.sourceUri.hashCode() * 31;
            String str = this.mimeType;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration2 = this.drmConfiguration;
            int hashCode3 = (((hashCode2 + (drmConfiguration2 == null ? 0 : drmConfiguration2.hashCode())) * 31) + this.streamKeys.hashCode()) * 31;
            String str2 = this.customCacheKey;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subtitles.hashCode()) * 31;
            Object obj = this.tag;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode4 + i;
        }
    }

    public static final class Subtitle {
        public final String language;
        public final String mimeType;
        public final int selectionFlags;
        public final Uri uri;

        public Subtitle(Uri uri2, String str, String str2) {
            this(uri2, str, str2, 0);
        }

        public Subtitle(Uri uri2, String str, String str2, int i) {
            this.uri = uri2;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) obj;
            return this.uri.equals(subtitle.uri) && this.mimeType.equals(subtitle.mimeType) && Util.areEqual(this.language, subtitle.language) && this.selectionFlags == subtitle.selectionFlags;
        }

        public final int hashCode() {
            int hashCode = ((this.uri.hashCode() * 31) + this.mimeType.hashCode()) * 31;
            String str = this.language;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.selectionFlags;
        }
    }

    public static final class ClippingProperties {
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        private ClippingProperties(long j, long j2, boolean z, boolean z2, boolean z3) {
            this.startPositionMs = j;
            this.endPositionMs = j2;
            this.relativeToLiveWindow = z;
            this.relativeToDefaultPosition = z2;
            this.startsAtKeyFrame = z3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingProperties)) {
                return false;
            }
            ClippingProperties clippingProperties = (ClippingProperties) obj;
            return this.startPositionMs == clippingProperties.startPositionMs && this.endPositionMs == clippingProperties.endPositionMs && this.relativeToLiveWindow == clippingProperties.relativeToLiveWindow && this.relativeToDefaultPosition == clippingProperties.relativeToDefaultPosition && this.startsAtKeyFrame == clippingProperties.startsAtKeyFrame;
        }

        public final int hashCode() {
            return (((((((Long.valueOf(this.startPositionMs).hashCode() * 31) + Long.valueOf(this.endPositionMs).hashCode()) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }
    }

    private MediaItem(String str, ClippingProperties clippingProperties2, PlaybackProperties playbackProperties2, MediaMetadata mediaMetadata2) {
        this.mediaId = str;
        this.playbackProperties = playbackProperties2;
        this.mediaMetadata = mediaMetadata2;
        this.clippingProperties = clippingProperties2;
    }

    public final Builder buildUpon() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Util.areEqual(this.mediaId, mediaItem.mediaId) && this.clippingProperties.equals(mediaItem.clippingProperties) && Util.areEqual(this.playbackProperties, mediaItem.playbackProperties) && Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata);
    }

    public final int hashCode() {
        int hashCode = this.mediaId.hashCode() * 31;
        PlaybackProperties playbackProperties2 = this.playbackProperties;
        return ((((hashCode + (playbackProperties2 != null ? playbackProperties2.hashCode() : 0)) * 31) + this.clippingProperties.hashCode()) * 31) + this.mediaMetadata.hashCode();
    }
}
