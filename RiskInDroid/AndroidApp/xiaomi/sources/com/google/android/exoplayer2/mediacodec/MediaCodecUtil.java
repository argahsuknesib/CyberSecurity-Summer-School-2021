package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {
    private static final SparseIntArray AV1_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final SparseIntArray MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final SparseIntArray VP9_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray VP9_PROFILE_NUMBER_TO_CONST;
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    interface ScoreProvider<T> {
        int getScore(T t);
    }

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
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static class DecoderQueryException extends Exception {
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
        AVC_PROFILE_NUMBER_TO_CONST.put(110, 16);
        AVC_PROFILE_NUMBER_TO_CONST.put(122, 32);
        AVC_PROFILE_NUMBER_TO_CONST.put(244, 64);
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
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        VP9_PROFILE_NUMBER_TO_CONST = sparseIntArray3;
        sparseIntArray3.put(0, 1);
        VP9_PROFILE_NUMBER_TO_CONST.put(1, 2);
        VP9_PROFILE_NUMBER_TO_CONST.put(2, 4);
        VP9_PROFILE_NUMBER_TO_CONST.put(3, 8);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        VP9_LEVEL_NUMBER_TO_CONST = sparseIntArray4;
        sparseIntArray4.put(10, 1);
        VP9_LEVEL_NUMBER_TO_CONST.put(11, 2);
        VP9_LEVEL_NUMBER_TO_CONST.put(20, 4);
        VP9_LEVEL_NUMBER_TO_CONST.put(21, 8);
        VP9_LEVEL_NUMBER_TO_CONST.put(30, 16);
        VP9_LEVEL_NUMBER_TO_CONST.put(31, 32);
        VP9_LEVEL_NUMBER_TO_CONST.put(40, 64);
        VP9_LEVEL_NUMBER_TO_CONST.put(41, NotificationCompat.FLAG_HIGH_PRIORITY);
        VP9_LEVEL_NUMBER_TO_CONST.put(50, 256);
        VP9_LEVEL_NUMBER_TO_CONST.put(51, 512);
        VP9_LEVEL_NUMBER_TO_CONST.put(60, 2048);
        VP9_LEVEL_NUMBER_TO_CONST.put(61, 4096);
        VP9_LEVEL_NUMBER_TO_CONST.put(62, 8192);
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
        HashMap hashMap2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = hashMap2;
        hashMap2.put("00", 1);
        DOLBY_VISION_STRING_TO_PROFILE.put("01", 2);
        DOLBY_VISION_STRING_TO_PROFILE.put("02", 4);
        DOLBY_VISION_STRING_TO_PROFILE.put("03", 8);
        DOLBY_VISION_STRING_TO_PROFILE.put("04", 16);
        DOLBY_VISION_STRING_TO_PROFILE.put("05", 32);
        DOLBY_VISION_STRING_TO_PROFILE.put("06", 64);
        DOLBY_VISION_STRING_TO_PROFILE.put("07", Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY));
        DOLBY_VISION_STRING_TO_PROFILE.put("08", 256);
        DOLBY_VISION_STRING_TO_PROFILE.put("09", 512);
        HashMap hashMap3 = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = hashMap3;
        hashMap3.put("01", 1);
        DOLBY_VISION_STRING_TO_LEVEL.put("02", 2);
        DOLBY_VISION_STRING_TO_LEVEL.put("03", 4);
        DOLBY_VISION_STRING_TO_LEVEL.put("04", 8);
        DOLBY_VISION_STRING_TO_LEVEL.put("05", 16);
        DOLBY_VISION_STRING_TO_LEVEL.put("06", 32);
        DOLBY_VISION_STRING_TO_LEVEL.put("07", 64);
        DOLBY_VISION_STRING_TO_LEVEL.put("08", Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY));
        DOLBY_VISION_STRING_TO_LEVEL.put("09", 256);
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        AV1_LEVEL_NUMBER_TO_CONST = sparseIntArray5;
        sparseIntArray5.put(0, 1);
        AV1_LEVEL_NUMBER_TO_CONST.put(1, 2);
        AV1_LEVEL_NUMBER_TO_CONST.put(2, 4);
        AV1_LEVEL_NUMBER_TO_CONST.put(3, 8);
        AV1_LEVEL_NUMBER_TO_CONST.put(4, 16);
        AV1_LEVEL_NUMBER_TO_CONST.put(5, 32);
        AV1_LEVEL_NUMBER_TO_CONST.put(6, 64);
        AV1_LEVEL_NUMBER_TO_CONST.put(7, NotificationCompat.FLAG_HIGH_PRIORITY);
        AV1_LEVEL_NUMBER_TO_CONST.put(8, 256);
        AV1_LEVEL_NUMBER_TO_CONST.put(9, 512);
        AV1_LEVEL_NUMBER_TO_CONST.put(10, 1024);
        AV1_LEVEL_NUMBER_TO_CONST.put(11, 2048);
        AV1_LEVEL_NUMBER_TO_CONST.put(12, 4096);
        AV1_LEVEL_NUMBER_TO_CONST.put(13, 8192);
        AV1_LEVEL_NUMBER_TO_CONST.put(14, 16384);
        AV1_LEVEL_NUMBER_TO_CONST.put(15, 32768);
        AV1_LEVEL_NUMBER_TO_CONST.put(16, 65536);
        AV1_LEVEL_NUMBER_TO_CONST.put(17, 131072);
        AV1_LEVEL_NUMBER_TO_CONST.put(18, 262144);
        AV1_LEVEL_NUMBER_TO_CONST.put(19, 524288);
        AV1_LEVEL_NUMBER_TO_CONST.put(20, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        AV1_LEVEL_NUMBER_TO_CONST.put(21, 2097152);
        AV1_LEVEL_NUMBER_TO_CONST.put(22, 4194304);
        AV1_LEVEL_NUMBER_TO_CONST.put(23, 8388608);
        SparseIntArray sparseIntArray6 = new SparseIntArray();
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE = sparseIntArray6;
        sparseIntArray6.put(1, 1);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(2, 2);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(3, 3);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(4, 4);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(5, 5);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(6, 6);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(17, 17);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(20, 20);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(23, 23);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(29, 29);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(39, 39);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(42, 42);
    }

    private MediaCodecUtil() {
    }

    public static void warmDecoderInfoCache(String str, boolean z, boolean z2) {
        try {
            getDecoderInfos(str, z, z2);
        } catch (DecoderQueryException e) {
            Log.e("MediaCodecUtil", "Codec warming failed", e);
        }
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() throws DecoderQueryException {
        return getDecoderInfo("audio/raw", false, false);
    }

    public static MediaCodecInfo getDecoderInfo(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z, z2);
            List<MediaCodecInfo> list = decoderInfosCache.get(codecKey);
            if (list != null) {
                return list;
            }
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, Util.SDK_INT >= 21 ? new MediaCodecListCompatV21(z, z2) : new MediaCodecListCompatV16());
            if (z && decoderInfosInternal.isEmpty() && 21 <= Util.SDK_INT && Util.SDK_INT <= 23) {
                decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV16());
                if (!decoderInfosInternal.isEmpty()) {
                    Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
                }
            }
            applyWorkarounds(str, decoderInfosInternal);
            List<MediaCodecInfo> unmodifiableList = Collections.unmodifiableList(decoderInfosInternal);
            decoderInfosCache.put(codecKey, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new ScoreProvider() {
            /* class com.google.android.exoplayer2.mediacodec.$$Lambda$MediaCodecUtil$DM_fEJX1iZ51J6IPGblMN7NcC5Y */

            public final int getScore(Object obj) {
                return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(Format.this, (MediaCodecInfo) obj);
            }
        });
        return arrayList;
    }

    static /* synthetic */ int lambda$getDecoderInfosSortedByFormatSupport$0(Format format, MediaCodecInfo mediaCodecInfo) {
        try {
            return mediaCodecInfo.isFormatSupported(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int i = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(avcLevelToMaxFrameSize(profileLevels[i].level), i2);
                    i++;
                }
                i = Math.max(i2, Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            maxH264DecodableFrameSize = i;
        }
        return maxH264DecodableFrameSize;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        if (r3.equals("avc1") != false) goto L_0x0071;
     */
    public static Pair<Integer, Integer> getCodecProfileAndLevel(Format format) {
        if (format.codecs == null) {
            return null;
        }
        String[] split = format.codecs.split("\\.");
        if ("video/dolby-vision".equals(format.sampleMimeType)) {
            return getDolbyVisionProfileAndLevel(format.codecs, split);
        }
        char c = 0;
        String str = split[0];
        switch (str.hashCode()) {
            case 3004662:
                if (str.equals("av01")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3006243:
                break;
            case 3006244:
                if (str.equals("avc2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3199032:
                if (str.equals("hev1")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3214780:
                if (str.equals("hvc1")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3356560:
                if (str.equals("mp4a")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3624515:
                if (str.equals("vp09")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return getAvcProfileAndLevel(format.codecs, split);
            case 2:
                return getVp9ProfileAndLevel(format.codecs, split);
            case 3:
            case 4:
                return getHevcProfileAndLevel(format.codecs, split);
            case 5:
                return getAv1ProfileAndLevel(format.codecs, split, format.colorInfo);
            case 6:
                return getAacCodecProfileAndLevel(format.codecs, split);
            default:
                return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r1.secure == false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0100 A[SYNTHETIC, Splitter:B:60:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d A[SYNTHETIC] */
    private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        int i;
        boolean z;
        int i2;
        String str;
        String str2;
        String codecMimeType;
        String str3;
        CodecKey codecKey2 = codecKey;
        MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
            String str4 = codecKey2.mimeType;
            boolean secureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
            int i3 = 0;
            for (int codecCount = mediaCodecListCompat.getCodecCount(); i3 < codecCount; codecCount = i) {
                MediaCodecInfo codecInfoAt = mediaCodecListCompat2.getCodecInfoAt(i3);
                if (!isAlias(codecInfoAt)) {
                    String name = codecInfoAt.getName();
                    if (isCodecUsableDecoder(codecInfoAt, name, secureDecodersExplicit, str4) && (codecMimeType = getCodecMimeType(codecInfoAt, name, str4)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(codecMimeType);
                            boolean isFeatureSupported = mediaCodecListCompat2.isFeatureSupported("tunneled-playback", codecMimeType, capabilitiesForType);
                            boolean isFeatureRequired = mediaCodecListCompat2.isFeatureRequired("tunneled-playback", codecMimeType, capabilitiesForType);
                            if (codecKey2.tunneling || !isFeatureRequired) {
                                if (!codecKey2.tunneling || isFeatureSupported) {
                                    boolean isFeatureSupported2 = mediaCodecListCompat2.isFeatureSupported("secure-playback", codecMimeType, capabilitiesForType);
                                    boolean isFeatureRequired2 = mediaCodecListCompat2.isFeatureRequired("secure-playback", codecMimeType, capabilitiesForType);
                                    if (codecKey2.secure || !isFeatureRequired2) {
                                        if (!codecKey2.secure || isFeatureSupported2) {
                                            boolean isHardwareAccelerated = isHardwareAccelerated(codecInfoAt);
                                            boolean isSoftwareOnly = isSoftwareOnly(codecInfoAt);
                                            boolean isVendor = isVendor(codecInfoAt);
                                            boolean codecNeedsDisableAdaptationWorkaround = codecNeedsDisableAdaptationWorkaround(name);
                                            if (!secureDecodersExplicit || codecKey2.secure != isFeatureSupported2) {
                                                if (!secureDecodersExplicit) {
                                                    try {
                                                    } catch (Exception e) {
                                                        e = e;
                                                        str2 = codecMimeType;
                                                        i2 = i3;
                                                        z = secureDecodersExplicit;
                                                        i = codecCount;
                                                        str3 = name;
                                                        if (Util.SDK_INT > 23) {
                                                        }
                                                        Log.e("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                        throw e;
                                                    }
                                                }
                                                str2 = codecMimeType;
                                                str = name;
                                                i2 = i3;
                                                z = secureDecodersExplicit;
                                                i = codecCount;
                                                if (!z && isFeatureSupported2) {
                                                    StringBuilder sb = new StringBuilder();
                                                    String str5 = str;
                                                    try {
                                                        sb.append(str5);
                                                        sb.append(".secure");
                                                        str3 = str5;
                                                        try {
                                                            arrayList.add(MediaCodecInfo.newInstance(sb.toString(), str4, str2, capabilitiesForType, isHardwareAccelerated, isSoftwareOnly, isVendor, codecNeedsDisableAdaptationWorkaround, true));
                                                            return arrayList;
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str3 = str5;
                                                        if (Util.SDK_INT > 23) {
                                                        }
                                                        Log.e("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                        throw e;
                                                    }
                                                }
                                                i3 = i2 + 1;
                                                codecKey2 = codecKey;
                                                secureDecodersExplicit = z;
                                            }
                                            str2 = codecMimeType;
                                            str = name;
                                            i2 = i3;
                                            z = secureDecodersExplicit;
                                            i = codecCount;
                                            try {
                                                arrayList.add(MediaCodecInfo.newInstance(name, str4, codecMimeType, capabilitiesForType, isHardwareAccelerated, isSoftwareOnly, isVendor, codecNeedsDisableAdaptationWorkaround, false));
                                            } catch (Exception e4) {
                                                e = e4;
                                                str3 = str;
                                                if (Util.SDK_INT > 23) {
                                                    if (!arrayList.isEmpty()) {
                                                        Log.e("MediaCodecUtil", "Skipping codec " + str3 + " (failed to query capabilities)");
                                                        i3 = i2 + 1;
                                                        codecKey2 = codecKey;
                                                        secureDecodersExplicit = z;
                                                    }
                                                }
                                                Log.e("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                throw e;
                                            }
                                            i3 = i2 + 1;
                                            codecKey2 = codecKey;
                                            secureDecodersExplicit = z;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str2 = codecMimeType;
                            str3 = name;
                            i2 = i3;
                            z = secureDecodersExplicit;
                            i = codecCount;
                            if (Util.SDK_INT > 23) {
                            }
                            Log.e("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                            throw e;
                        }
                    }
                }
                i2 = i3;
                z = secureDecodersExplicit;
                i = codecCount;
                i3 = i2 + 1;
                codecKey2 = codecKey;
                secureDecodersExplicit = z;
            }
            return arrayList;
        } catch (Exception e6) {
            throw new DecoderQueryException(e6);
        }
    }

    private static String getCodecMimeType(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (!str2.equals("audio/flac") || !"OMX.lge.flac.decoder".equals(str)) {
                return null;
            }
            return "audio/x-lg-flac";
        }
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (Util.SDK_INT < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (Util.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(Util.DEVICE) || ("Xiaomi".equals(Util.MANUFACTURER) && Util.DEVICE.startsWith("HM")))) {
            return false;
        }
        if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(Util.DEVICE) || "protou".equals(Util.DEVICE) || "ville".equals(Util.DEVICE) || "villeplus".equals(Util.DEVICE) || "villec2".equals(Util.DEVICE) || Util.DEVICE.startsWith("gee") || "C6602".equals(Util.DEVICE) || "C6603".equals(Util.DEVICE) || "C6606".equals(Util.DEVICE) || "C6616".equals(Util.DEVICE) || "L36h".equals(Util.DEVICE) || "SO-02E".equals(Util.DEVICE))) {
            return false;
        }
        if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(Util.DEVICE) || "C1505".equals(Util.DEVICE) || "C1604".equals(Util.DEVICE) || "C1605".equals(Util.DEVICE))) {
            return false;
        }
        if (Util.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("zerolte") || Util.DEVICE.startsWith("zenlte") || "SC-05G".equals(Util.DEVICE) || "marinelteatt".equals(Util.DEVICE) || "404SC".equals(Util.DEVICE) || "SC-04G".equals(Util.DEVICE) || "SCV31".equals(Util.DEVICE)))) {
            return false;
        }
        if (Util.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("d2") || Util.DEVICE.startsWith("serrano") || Util.DEVICE.startsWith("jflte") || Util.DEVICE.startsWith("santos") || Util.DEVICE.startsWith("t0"))) {
            return false;
        }
        if (Util.SDK_INT <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (!"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    private static void applyWorkarounds(String str, List<MediaCodecInfo> list) {
        if ("audio/raw".equals(str)) {
            if (Util.SDK_INT < 26 && Util.DEVICE.equals("R9") && list.size() == 1 && list.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.newInstance("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            sortByScore(list, $$Lambda$MediaCodecUtil$cCWO3tN34TxRUMGlkaLU13g9pw.INSTANCE);
        }
        if (Util.SDK_INT < 21 && list.size() > 1) {
            String str2 = list.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                sortByScore(list, $$Lambda$MediaCodecUtil$5ZWFpP5Ck4Hyp9KyuAYDjY5c2U.INSTANCE);
            }
        }
        if (Util.SDK_INT < 30 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            list.add(list.remove(0));
        }
    }

    static /* synthetic */ int lambda$applyWorkarounds$1(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    static /* synthetic */ int lambda$applyWorkarounds$2(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.name.startsWith("OMX.google") ? 1 : 0;
    }

    private static boolean isAlias(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 29 && isAliasV29(mediaCodecInfo);
    }

    private static boolean isAliasV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 29) {
            return isHardwareAcceleratedV29(mediaCodecInfo);
        }
        return !isSoftwareOnly(mediaCodecInfo);
    }

    private static boolean isHardwareAcceleratedV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 29) {
            return isSoftwareOnlyV29(mediaCodecInfo);
        }
        String lowerInvariant = Util.toLowerInvariant(mediaCodecInfo.getName());
        if (lowerInvariant.startsWith("arc.")) {
            return false;
        }
        if (lowerInvariant.startsWith("omx.google.") || lowerInvariant.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((lowerInvariant.startsWith("omx.sec.") && lowerInvariant.contains(".sw.")) || lowerInvariant.equals("omx.qcom.video.decoder.hevcswvdec") || lowerInvariant.startsWith("c2.android.") || lowerInvariant.startsWith("c2.google.")) {
            return true;
        }
        if (lowerInvariant.startsWith("omx.") || lowerInvariant.startsWith("c2.")) {
            return false;
        }
        return true;
    }

    private static boolean isSoftwareOnlyV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean isVendor(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 29) {
            return isVendorV29(mediaCodecInfo);
        }
        String lowerInvariant = Util.toLowerInvariant(mediaCodecInfo.getName());
        return !lowerInvariant.startsWith("omx.google.") && !lowerInvariant.startsWith("c2.android.") && !lowerInvariant.startsWith("c2.google.");
    }

    private static boolean isVendorV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(String str) {
        if (Util.SDK_INT > 22) {
            return false;
        }
        if ("ODROID-XU3".equals(Util.MODEL) || "Nexus 10".equals(Util.MODEL)) {
            return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
        }
        return false;
    }

    private static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(group);
        if (num == null) {
            Log.w("MediaCodecUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(group)));
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        Log.w("MediaCodecUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str2)));
        return null;
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        int i = 1;
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if ("2".equals(group)) {
                i = 2;
            } else {
                Log.w("MediaCodecUtil", "Unknown HEVC profile string: ".concat(String.valueOf(group)));
                return null;
            }
        }
        String str2 = strArr[3];
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(str2);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i), num);
        }
        Log.w("MediaCodecUtil", "Unknown HEVC level string: ".concat(String.valueOf(str2)));
        return null;
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                int parseInt = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
                i2 = parseInt;
            } else if (strArr.length >= 3) {
                i2 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str)));
                return null;
            }
            int i3 = AVC_PROFILE_NUMBER_TO_CONST.get(i2, -1);
            if (i3 == -1) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: ".concat(String.valueOf(i2)));
                return null;
            }
            int i4 = AVC_LEVEL_NUMBER_TO_CONST.get(i, -1);
            if (i4 != -1) {
                return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i4));
            }
            Log.w("MediaCodecUtil", "Unknown AVC level: ".concat(String.valueOf(i)));
            return null;
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private static Pair<Integer, Integer> getVp9ProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str)));
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int i = VP9_PROFILE_NUMBER_TO_CONST.get(parseInt, -1);
            if (i == -1) {
                Log.w("MediaCodecUtil", "Unknown VP9 profile: ".concat(String.valueOf(parseInt)));
                return null;
            }
            int i2 = VP9_LEVEL_NUMBER_TO_CONST.get(parseInt2, -1);
            if (i2 != -1) {
                return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
            }
            Log.w("MediaCodecUtil", "Unknown VP9 level: ".concat(String.valueOf(parseInt2)));
            return null;
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private static Pair<Integer, Integer> getAv1ProfileAndLevel(String str, String[] strArr, ColorInfo colorInfo) {
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str)));
            return null;
        }
        int i = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                Log.w("MediaCodecUtil", "Unknown AV1 profile: ".concat(String.valueOf(parseInt)));
                return null;
            } else if (parseInt3 == 8 || parseInt3 == 10) {
                if (parseInt3 != 8) {
                    i = (colorInfo == null || !(colorInfo.hdrStaticInfo != null || colorInfo.colorTransfer == 7 || colorInfo.colorTransfer == 6)) ? 2 : 4096;
                }
                int i2 = AV1_LEVEL_NUMBER_TO_CONST.get(parseInt2, -1);
                if (i2 != -1) {
                    return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
                }
                Log.w("MediaCodecUtil", "Unknown AV1 level: ".concat(String.valueOf(parseInt2)));
                return null;
            } else {
                Log.w("MediaCodecUtil", "Unknown AV1 bit depth: ".concat(String.valueOf(parseInt3)));
                return null;
            }
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private static Pair<Integer, Integer> getAacCodecProfileAndLevel(String str, String[] strArr) {
        int i;
        if (strArr.length != 3) {
            Log.w("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str)));
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(strArr[1], 16))) && (i = MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.get(Integer.parseInt(strArr[2]), -1)) != -1) {
                return new Pair<>(Integer.valueOf(i), 0);
            }
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str)));
        }
        return null;
    }

    static /* synthetic */ int lambda$sortByScore$3(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.getScore(obj2) - scoreProvider.getScore(obj);
    }

    private static <T> void sortByScore(List<T> list, ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new Comparator() {
            /* class com.google.android.exoplayer2.mediacodec.$$Lambda$MediaCodecUtil$w6BjIcrs1D5BowK8PBZdBwa6Apk */

            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.lambda$sortByScore$3(MediaCodecUtil.ScoreProvider.this, obj, obj2);
            }
        });
    }

    static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private MediaCodecInfo[] mediaCodecInfos;

        public final boolean secureDecodersExplicit() {
            return true;
        }

        public MediaCodecListCompatV21(boolean z, boolean z2) {
            this.codecKind = (z || z2) ? 1 : 0;
        }

        public final int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i];
        }

        public final boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public final boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }
    }

    static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        public final boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

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

        public final boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }
    }

    static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String str, boolean z, boolean z2) {
            this.mimeType = str;
            this.secure = z;
            this.tunneling = z2;
        }

        public final int hashCode() {
            int i = 1231;
            int hashCode = (((this.mimeType.hashCode() + 31) * 31) + (this.secure ? 1231 : 1237)) * 31;
            if (!this.tunneling) {
                i = 1237;
            }
            return hashCode + i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                return TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling;
            }
        }
    }
}
