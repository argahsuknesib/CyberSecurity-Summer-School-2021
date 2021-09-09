package com.xiaomi.smarthome.fastvideo.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.exoplayer2.C;

@TargetApi(16)
public final class MediaCodecInfo {
    public final boolean adaptive;
    private final MediaCodecInfo.CodecCapabilities capabilities;
    private final String mimeType;
    public final String name;
    public final boolean tunneling;

    private static int avcLevelToMaxFrameSize(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case NotificationCompat.FLAG_HIGH_PRIORITY:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            default:
                return -1;
        }
    }

    public static MediaCodecInfo newPassthroughInstance(String str) {
        return new MediaCodecInfo(str, null, null);
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new MediaCodecInfo(str, str2, codecCapabilities);
    }

    private MediaCodecInfo(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        this.name = str;
        this.mimeType = str2;
        this.capabilities = codecCapabilities;
        boolean z = true;
        this.adaptive = codecCapabilities != null && isAdaptive(codecCapabilities);
        this.tunneling = (codecCapabilities == null || !isTunneling(codecCapabilities)) ? false : z;
    }

    public final MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.capabilities.profileLevels;
    }

    /* access modifiers changed from: package-private */
    public final boolean isVideoSizeSupportedV21(int i, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            int i3 = 0;
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                i3 = Math.max(avcLevelToMaxFrameSize(codecProfileLevel.level), i3);
            }
            if (Math.max(i3, Util.SDK_INT >= 21 ? 345600 : 172800) > i * i2) {
                return true;
            }
            return false;
        } else if (this.capabilities == null) {
            logNoSupport("sizeAndRate.caps");
            return false;
        } else {
            return this.capabilities.isFormatSupported(MediaFormat.createVideoFormat(this.mimeType, i, i2));
        }
    }

    private void logNoSupport(String str) {
        Log.d("GpuUtil", "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private void logAssumedSupport(String str) {
        Log.d("GpuUtil", "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    @TargetApi(21)
    private static boolean areSizeAndRateSupported(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 21 && isTunnelingV21(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }
}
