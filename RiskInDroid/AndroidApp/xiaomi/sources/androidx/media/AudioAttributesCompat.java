package androidx.media;

import _m_j.fu;
import _m_j.jy;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class AudioAttributesCompat implements jy {
    private static final SparseIntArray O00000Oo;
    private static final int[] O00000o0 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: O000000o  reason: collision with root package name */
    fu f2892O000000o;

    public static int O000000o(int i, int i2) {
        if ((i & 1) == 1) {
            return 7;
        }
        if ((i & 4) == 4) {
            return 6;
        }
        switch (i2) {
            case 0:
            case 1:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
            default:
                return 3;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O00000Oo = sparseIntArray;
        sparseIntArray.put(5, 1);
        O00000Oo.put(6, 2);
        O00000Oo.put(7, 2);
        O00000Oo.put(8, 1);
        O00000Oo.put(9, 1);
        O00000Oo.put(10, 1);
    }

    AudioAttributesCompat() {
    }

    public int hashCode() {
        return this.f2892O000000o.hashCode();
    }

    public String toString() {
        return this.f2892O000000o.toString();
    }

    public static String O000000o(int i) {
        switch (i) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
            default:
                return "unknown usage ".concat(String.valueOf(i));
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        fu fuVar = this.f2892O000000o;
        if (fuVar != null) {
            return fuVar.equals(audioAttributesCompat.f2892O000000o);
        }
        if (audioAttributesCompat.f2892O000000o == null) {
            return true;
        }
        return false;
    }
}
