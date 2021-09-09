package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class bdr {
    public static String O000000o(int i) {
        switch (i) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return "string";
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return "false";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "{";
            case 13:
                return "}";
            case 14:
                return "[";
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return "]";
            case 16:
                return ",";
            case 17:
                return ":";
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            default:
                return "Unkown";
        }
    }
}
