package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

public final class MediaCodecInfo {
    public final boolean adaptive;
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    private final boolean isVideo;
    public final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    public static MediaCodecInfo newInstance(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, z4, z5);
    }

    private MediaCodecInfo(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.codecMimeType = str3;
        this.capabilities = codecCapabilities;
        this.hardwareAccelerated = z;
        this.softwareOnly = z2;
        this.vendor = z3;
        boolean z6 = true;
        this.adaptive = !z4 && codecCapabilities != null && isAdaptive(codecCapabilities);
        this.tunneling = codecCapabilities != null && isTunneling(codecCapabilities);
        if (!z5 && (codecCapabilities == null || !isSecure(codecCapabilities))) {
            z6 = false;
        }
        this.secure = z6;
        this.isVideo = MimeTypes.isVideo(str2);
    }

    public final String toString() {
        return this.name;
    }

    public final MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.capabilities.profileLevels;
    }

    public final int getMaxSupportedInstances() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (Util.SDK_INT < 23 || (codecCapabilities = this.capabilities) == null) {
            return -1;
        }
        return getMaxSupportedInstancesV23(codecCapabilities);
    }

    public final boolean isFormatSupported(Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z = false;
        if (!isCodecSupported(format)) {
            return false;
        }
        if (this.isVideo) {
            if (format.width <= 0 || format.height <= 0) {
                return true;
            }
            if (Util.SDK_INT >= 21) {
                return isVideoSizeAndRateSupportedV21(format.width, format.height, (double) format.frameRate);
            }
            if (format.width * format.height <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                z = true;
            }
            if (!z) {
                logNoSupport("legacyFrameSize, " + format.width + "x" + format.height);
            }
            return z;
        } else if (Util.SDK_INT < 21 || ((format.sampleRate == -1 || isAudioSampleRateSupportedV21(format.sampleRate)) && (format.channelCount == -1 || isAudioChannelCountSupportedV21(format.channelCount)))) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean isCodecSupported(Format format) {
        String mediaMimeType;
        if (format.codecs == null || this.mimeType == null || (mediaMimeType = MimeTypes.getMediaMimeType(format.codecs)) == null) {
            return true;
        }
        if (!this.mimeType.equals(mediaMimeType)) {
            logNoSupport("codec.mime " + format.codecs + ", " + mediaMimeType);
            return false;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int intValue = ((Integer) codecProfileAndLevel.first).intValue();
        int intValue2 = ((Integer) codecProfileAndLevel.second).intValue();
        if (!this.isVideo && intValue != 42) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                return true;
            }
        }
        logNoSupport("codec.profileLevel, " + format.codecs + ", " + mediaMimeType);
        return false;
    }

    public final boolean isHdr10PlusOutOfBandMetadataSupported() {
        if (Util.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(this.mimeType)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isSeamlessAdaptationSupported(Format format) {
        if (this.isVideo) {
            return this.adaptive;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    public final boolean isSeamlessAdaptationSupported(Format format, Format format2, boolean z) {
        if (this.isVideo) {
            return format.sampleMimeType.equals(format2.sampleMimeType) && format.rotationDegrees == format2.rotationDegrees && (this.adaptive || (format.width == format2.width && format.height == format2.height)) && ((!z && format2.colorInfo == null) || Util.areEqual(format.colorInfo, format2.colorInfo));
        }
        if ("audio/mp4a-latm".equals(this.mimeType) && format.sampleMimeType.equals(format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
            Pair<Integer, Integer> codecProfileAndLevel2 = MediaCodecUtil.getCodecProfileAndLevel(format2);
            if (!(codecProfileAndLevel == null || codecProfileAndLevel2 == null)) {
                return ((Integer) codecProfileAndLevel.first).intValue() == 42 && ((Integer) codecProfileAndLevel2.first).intValue() == 42;
            }
        }
    }

    public final boolean isVideoSizeAndRateSupportedV21(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("sizeAndRate.vCaps");
            return false;
        } else if (areSizeAndRateSupportedV21(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || !enableRotatedVerticalResolutionWorkaround(this.name) || !areSizeAndRateSupportedV21(videoCapabilities, i2, i, d)) {
                logNoSupport("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            }
            logAssumedSupport("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
            return true;
        }
    }

    public final Point alignVideoSizeV21(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return alignVideoSizeV21(videoCapabilities, i, i2);
    }

    public final boolean isAudioSampleRateSupportedV21(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            logNoSupport("sampleRate.support, ".concat(String.valueOf(i)));
            return false;
        }
    }

    public final boolean isAudioChannelCountSupportedV21(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("channelCount.aCaps");
            return false;
        } else if (adjustMaxInputChannelCount(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        } else {
            logNoSupport("channelCount.support, ".concat(String.valueOf(i)));
            return false;
        }
    }

    private void logNoSupport(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private void logAssumedSupport(String str) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private static int adjustMaxInputChannelCount(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((Util.SDK_INT >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        if ("audio/ac3".equals(str2)) {
            i2 = 6;
        } else {
            i2 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities);
    }

    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 21 && isTunnelingV21(codecCapabilities);
    }

    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 21 && isSecureV21(codecCapabilities);
    }

    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point alignVideoSizeV21 = alignVideoSizeV21(videoCapabilities, i, i2);
        int i3 = alignVideoSizeV21.x;
        int i4 = alignVideoSizeV21.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private static Point alignVideoSizeV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.ceilDivide(i, widthAlignment) * widthAlignment, Util.ceilDivide(i2, heightAlignment) * heightAlignment);
    }

    private static int getMaxSupportedInstancesV23(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    private static final boolean enableRotatedVerticalResolutionWorkaround(String str) {
        return !"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Util.DEVICE);
    }
}
