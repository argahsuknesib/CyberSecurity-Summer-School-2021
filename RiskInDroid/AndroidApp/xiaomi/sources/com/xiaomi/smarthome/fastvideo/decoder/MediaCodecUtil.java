package com.xiaomi.smarthome.fastvideo.decoder;

import _m_j.cki;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class MediaCodecUtil {
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final MediaCodecInfo PASSTHROUGH_DECODER_INFO = MediaCodecInfo.newPassthroughInstance("OMX.google.raw.decoder");
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();

    interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    public static class DecoderQueryException extends Exception {
        private static final long serialVersionUID = 6613450476861624673L;

        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray;
        sparseIntArray.put(66, 1);
        AVC_PROFILE_NUMBER_TO_CONST.put(77, 2);
        AVC_PROFILE_NUMBER_TO_CONST.put(88, 4);
        AVC_PROFILE_NUMBER_TO_CONST.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        AVC_LEVEL_NUMBER_TO_CONST.put(11, 4);
        AVC_LEVEL_NUMBER_TO_CONST.put(12, 8);
        AVC_LEVEL_NUMBER_TO_CONST.put(13, 16);
        AVC_LEVEL_NUMBER_TO_CONST.put(20, 32);
        AVC_LEVEL_NUMBER_TO_CONST.put(21, 64);
        AVC_LEVEL_NUMBER_TO_CONST.put(22, NotificationCompat.FLAG_HIGH_PRIORITY);
        AVC_LEVEL_NUMBER_TO_CONST.put(30, 256);
        AVC_LEVEL_NUMBER_TO_CONST.put(31, 512);
        AVC_LEVEL_NUMBER_TO_CONST.put(32, 1024);
        AVC_LEVEL_NUMBER_TO_CONST.put(40, 2048);
        AVC_LEVEL_NUMBER_TO_CONST.put(41, 4096);
        AVC_LEVEL_NUMBER_TO_CONST.put(42, 8192);
        AVC_LEVEL_NUMBER_TO_CONST.put(50, 16384);
        AVC_LEVEL_NUMBER_TO_CONST.put(51, 32768);
        AVC_LEVEL_NUMBER_TO_CONST.put(52, 65536);
        HashMap hashMap = new HashMap();
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = hashMap;
        hashMap.put("L30", 1);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L60", 4);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L63", 16);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L90", 64);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L93", 256);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L120", 1024);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L123", 4096);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L150", 16384);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L153", 65536);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L156", 262144);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L180", Integer.valueOf((int) ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES));
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L183", 4194304);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L186", 16777216);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H30", 2);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H60", 8);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H63", 32);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H90", Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY));
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H93", 512);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H120", 2048);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H123", 8192);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H150", 32768);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H153", 131072);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H156", 524288);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H180", 2097152);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H183", 8388608);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H186", 33554432);
    }

    private MediaCodecUtil() {
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() {
        return PASSTHROUGH_DECODER_INFO;
    }

    public static MediaCodecInfo getDecoderInfo(CodecKey codecKey) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(codecKey);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(CodecKey codecKey) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            List<MediaCodecInfo> list = decoderInfosCache.get(codecKey);
            if (list != null) {
                return list;
            }
            List<MediaCodecInfo> unmodifiableList = Collections.unmodifiableList(getDecoderInfosInternal(codecKey, Build.VERSION.SDK_INT >= 21 ? new MediaCodecListCompatV21(false) : new MediaCodecListCompatV16()));
            decoderInfosCache.put(codecKey, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7 A[Catch:{ Exception -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c4 A[ADDED_TO_REGION, SYNTHETIC] */
    private static List<MediaCodecInfo> getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        MediaCodecInfo mediaCodecInfo;
        String str;
        boolean z;
        CodecKey codecKey2 = codecKey;
        try {
            ArrayList arrayList = new ArrayList();
            String mimeType = codecKey.getMimeType();
            int codecCount = mediaCodecListCompat.getCodecCount();
            boolean z2 = false;
            int i = 0;
            while (i < codecCount) {
                MediaCodecInfo codecInfoAt = mediaCodecListCompat.getCodecInfoAt(i);
                String name = codecInfoAt.getName();
                if (isCodecUsableDecoder(codecInfoAt, name, z2)) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = supportedTypes[i2];
                        if (str2.equalsIgnoreCase(mimeType)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                                MediaCodecInfo newInstance = MediaCodecInfo.newInstance(name, mimeType, capabilitiesForType);
                                str = mimeType;
                                if (Build.VERSION.SDK_INT >= 21) {
                                    try {
                                        mediaCodecInfo = codecInfoAt;
                                    } catch (Exception e) {
                                        e = e;
                                        mediaCodecInfo = codecInfoAt;
                                        if (Util.SDK_INT > 23) {
                                        }
                                        Log.e("video", "Failed to query codec " + name + " (" + str2 + ")");
                                        throw e;
                                    }
                                    try {
                                        z = capabilitiesForType.getVideoCapabilities().areSizeAndRateSupported(codecKey2.mMaxWidth, codecKey2.mMaxHeight, 20.0d);
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (Util.SDK_INT > 23) {
                                        }
                                        Log.e("video", "Failed to query codec " + name + " (" + str2 + ")");
                                        throw e;
                                    }
                                } else {
                                    mediaCodecInfo = codecInfoAt;
                                    z = true;
                                }
                                if (codecKey2.mMaxWidth > 0 && codecKey2.mMaxHeight > 0 && z) {
                                    if (newInstance.isVideoSizeSupportedV21(codecKey2.mMaxWidth, codecKey2.mMaxHeight)) {
                                        arrayList.add(newInstance);
                                        cki.O00000o("video", "find support:" + newInstance.name);
                                    } else {
                                        Log.e("video", "find not support  " + newInstance.name);
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = mimeType;
                                mediaCodecInfo = codecInfoAt;
                                if (Util.SDK_INT > 23 || arrayList.isEmpty()) {
                                    Log.e("video", "Failed to query codec " + name + " (" + str2 + ")");
                                    throw e;
                                }
                                Log.e("video", "Skipping codec " + name + " (failed to query capabilities)");
                                i2++;
                                mimeType = str;
                                codecInfoAt = mediaCodecInfo;
                            }
                        } else {
                            str = mimeType;
                            mediaCodecInfo = codecInfoAt;
                        }
                        i2++;
                        mimeType = str;
                        codecInfoAt = mediaCodecInfo;
                    }
                    continue;
                }
                i++;
                mimeType = mimeType;
                z2 = false;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new DecoderQueryException(e4);
        }
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (Util.SDK_INT <= 19 && ((Util.DEVICE.startsWith("d2") || Util.DEVICE.startsWith("serrano") || Util.DEVICE.startsWith("jflte") || Util.DEVICE.startsWith("santos")) && "samsung".equals(Util.MANUFACTURER) && "OMX.SEC.vp8.dec".equals(str))) {
            return false;
        }
        if (Util.SDK_INT > 19 || !Util.DEVICE.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) {
            return true;
        }
        return false;
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr) {
        int i;
        if (strArr.length < 4) {
            Log.w("video", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("video", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i = 1;
        } else if ("2".equals(group)) {
            i = 2;
        } else {
            Log.w("video", "Unknown HEVC profile string: ".concat(String.valueOf(group)));
            return null;
        }
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(strArr[3]);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i), num);
        }
        Log.w("video", "Unknown HEVC level string: " + matcher.group(1));
        return null;
    }

    @TargetApi(21)
    static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private MediaCodecInfo[] mediaCodecInfos;

        public final boolean secureDecodersExplicit() {
            return true;
        }

        public MediaCodecListCompatV21(boolean z) {
            this.codecKind = z ? 1 : 0;
        }

        public final int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i];
        }

        public final boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }
    }

    static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        public final boolean secureDecodersExplicit() {
            return false;
        }

        private MediaCodecListCompatV16() {
        }

        public final int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public final boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    public static final class CodecKey {
        public final int mMaxHeight;
        public final int mMaxWidth;
        public final int mimeType;

        public final String getMimeType() {
            return this.mimeType == 1 ? "video/avc" : "video/hevc";
        }

        public CodecKey(int i, int i2, int i3) {
            this.mimeType = i;
            this.mMaxWidth = i2;
            this.mMaxHeight = i3;
        }

        public final int hashCode() {
            return ((this.mimeType + 31) * 31) + this.mMaxHeight + this.mMaxWidth;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                return codecKey.mMaxHeight == this.mMaxHeight && codecKey.mMaxWidth == this.mMaxWidth && this.mimeType == codecKey.mimeType;
            }
        }
    }
}
