package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.ArrayList;

public final class MimeTypes {
    private static final ArrayList<CustomMimeType> customMimeTypes = new ArrayList<>();

    public static String getMimeTypeFromMp4ObjectType(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static void registerCustomMimeType(String str, String str2, int i) {
        CustomMimeType customMimeType = new CustomMimeType(str, str2, i);
        int size = customMimeTypes.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (str.equals(customMimeTypes.get(i2).mimeType)) {
                customMimeTypes.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        customMimeTypes.add(customMimeType);
    }

    public static boolean isAudio(String str) {
        return "audio".equals(getTopLevelType(str));
    }

    public static boolean isVideo(String str) {
        return "video".equals(getTopLevelType(str));
    }

    public static boolean isText(String str) {
        return "text".equals(getTopLevelType(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean allSamplesAreSyncSamples(String str) {
        if (str == null) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c = 2;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c = 3;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c = 0;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c = 1;
                    break;
                }
                break;
        }
        return c == 0 || c == 1 || c == 2 || c == 3;
    }

    public static String getVideoMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String mediaMimeType : Util.splitCodecs(str)) {
            String mediaMimeType2 = getMediaMimeType(mediaMimeType);
            if (mediaMimeType2 != null && isVideo(mediaMimeType2)) {
                return mediaMimeType2;
            }
        }
        return null;
    }

    public static String getAudioMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String mediaMimeType : Util.splitCodecs(str)) {
            String mediaMimeType2 = getMediaMimeType(mediaMimeType);
            if (mediaMimeType2 != null && isAudio(mediaMimeType2)) {
                return mediaMimeType2;
            }
        }
        return null;
    }

    public static String getTextMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String mediaMimeType : Util.splitCodecs(str)) {
            String mediaMimeType2 = getMediaMimeType(mediaMimeType);
            if (mediaMimeType2 != null && isText(mediaMimeType2)) {
                return mediaMimeType2;
            }
        }
        return null;
    }

    public static String getMediaMimeType(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String lowerInvariant = Util.toLowerInvariant(str.trim());
        if (lowerInvariant.startsWith("avc1") || lowerInvariant.startsWith("avc3")) {
            return "video/avc";
        }
        if (lowerInvariant.startsWith("hev1") || lowerInvariant.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (lowerInvariant.startsWith("dvav") || lowerInvariant.startsWith("dva1") || lowerInvariant.startsWith("dvhe") || lowerInvariant.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (lowerInvariant.startsWith("av01")) {
            return "video/av01";
        }
        if (lowerInvariant.startsWith("vp9") || lowerInvariant.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (lowerInvariant.startsWith("vp8") || lowerInvariant.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (lowerInvariant.startsWith("mp4a")) {
            if (lowerInvariant.startsWith("mp4a.")) {
                String substring = lowerInvariant.substring(5);
                if (substring.length() >= 2) {
                    try {
                        str2 = getMimeTypeFromMp4ObjectType(Integer.parseInt(Util.toUpperInvariant(substring.substring(0, 2)), 16));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        } else if (lowerInvariant.startsWith("ac-3") || lowerInvariant.startsWith("dac3")) {
            return "audio/ac3";
        } else {
            if (lowerInvariant.startsWith("ec-3") || lowerInvariant.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (lowerInvariant.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (lowerInvariant.startsWith("ac-4") || lowerInvariant.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (lowerInvariant.startsWith("dtsc") || lowerInvariant.startsWith("dtse")) {
                return "audio/vnd.dts";
            }
            if (lowerInvariant.startsWith("dtsh") || lowerInvariant.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (lowerInvariant.startsWith("opus")) {
                return "audio/opus";
            }
            if (lowerInvariant.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (lowerInvariant.startsWith("flac")) {
                return "audio/flac";
            }
            if (lowerInvariant.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (lowerInvariant.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (lowerInvariant.contains("cea708")) {
                return "application/cea-708";
            }
            return (lowerInvariant.contains("eia608") || lowerInvariant.contains("cea608")) ? "application/cea-608" : getCustomMimeTypeForCodec(lowerInvariant);
        }
    }

    public static int getTrackType(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        return getTrackTypeForCustomMimeType(str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getEncoding(String str) {
        char c;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c = 7;
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
                return 9;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 18;
            case 4:
                return 17;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 14;
            default:
                return 0;
        }
    }

    public static int getTrackTypeOfCodec(String str) {
        return getTrackType(getMediaMimeType(str));
    }

    private static String getTopLevelType(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    private static String getCustomMimeTypeForCodec(String str) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (str.startsWith(customMimeType.codecPrefix)) {
                return customMimeType.mimeType;
            }
        }
        return null;
    }

    private static int getTrackTypeForCustomMimeType(String str) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (str.equals(customMimeType.mimeType)) {
                return customMimeType.trackType;
            }
        }
        return -1;
    }

    private MimeTypes() {
    }

    static final class CustomMimeType {
        public final String codecPrefix;
        public final String mimeType;
        public final int trackType;

        public CustomMimeType(String str, String str2, int i) {
            this.mimeType = str;
            this.codecPrefix = str2;
            this.trackType = i;
        }
    }
}
