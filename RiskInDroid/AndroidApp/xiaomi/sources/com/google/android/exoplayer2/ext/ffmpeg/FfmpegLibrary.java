package com.google.android.exoplayer2.ext.ffmpeg;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.LibraryLoader;
import com.google.android.exoplayer2.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class FfmpegLibrary {
    private static final LibraryLoader LOADER = new LibraryLoader("ijkffmpeg", "ffmpeg_jni");

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ffmpeg");
    }

    private FfmpegLibrary() {
    }

    public static void setLibraries(String... strArr) {
        LOADER.setLibraries(strArr);
    }

    public static boolean isAvailable() {
        return LOADER.isAvailable();
    }

    public static String getVersion() {
        if (isAvailable()) {
            return ffmpegGetVersion();
        }
        return null;
    }

    public static boolean supportsFormat(String str) {
        String codecName;
        if (!isAvailable() || (codecName = getCodecName(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(codecName)) {
            return true;
        }
        Log.w("FfmpegLibrary", "No " + codecName + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static String getCodecName(String str) {
        char c;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case 1504470054:
                if (str.equals("audio/alac")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c = 9;
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
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c = 16;
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
                return "aac";
            case 1:
            case 2:
            case 3:
                return "mp3";
            case 4:
                return "ac3";
            case 5:
            case 6:
                return "eac3";
            case 7:
                return "truehd";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return "dca";
            case 10:
                return "vorbis";
            case 11:
                return "opus";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "amrnb";
            case 13:
                return "amrwb";
            case 14:
                return "flac";
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return "alac";
            case 16:
                return "pcm_mulaw";
            case 17:
                return "pcm_alaw";
            case 18:
                return "h264";
            case 19:
                return "hevc";
            default:
                return null;
        }
    }
}
