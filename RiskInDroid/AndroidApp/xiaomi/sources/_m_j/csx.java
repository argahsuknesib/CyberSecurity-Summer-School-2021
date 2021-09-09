package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.qti.location.sdk.utils.IZatValidationResults;
import java.util.HashSet;
import java.util.Iterator;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class csx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14322O000000o = "IZatDataValidation";

    private static HashSet<Integer> O000000o(int[] iArr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int valueOf : iArr) {
            hashSet.add(Integer.valueOf(valueOf));
        }
        return hashSet;
    }

    private static boolean O000000o(int i, HashSet<Integer> hashSet) {
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i) {
                return true;
            }
        }
        return false;
    }

    public static IZatValidationResults O000000o(int i, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        String str;
        switch (AnonymousClass1.f14323O000000o[iZatDataTypes.ordinal()]) {
            case 1:
                if (O000000o(i, O000000o(new int[]{0, 1, 2}))) {
                    return new IZatValidationResults();
                }
                str = "[FLP STATUS]Value set: 0,1,2, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults = new IZatValidationResults(false, str);
                iZatValidationResults.O000000o();
                return iZatValidationResults;
            case 2:
                if (i > 0) {
                    return new IZatValidationResults();
                }
                str = "[FLP_DISTANCE_INTERVAL]Range: >0, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults2 = new IZatValidationResults(false, str);
                iZatValidationResults2.O000000o();
                return iZatValidationResults2;
            case 3:
                if (O000000o(i, O000000o(new int[]{1, 2, 3, 4, 5}))) {
                    return new IZatValidationResults();
                }
                str = "[FLP_POWER_MODE]Value Set:1,2,3,4,5, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults22 = new IZatValidationResults(false, str);
                iZatValidationResults22.O000000o();
                return iZatValidationResults22;
            case 4:
                if (i >= 1000 && i <= 65535000) {
                    return new IZatValidationResults();
                }
                str = "[GEO_RESPONSIVENESS]Range: [1000,65535000], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults222 = new IZatValidationResults(false, str);
                iZatValidationResults222.O000000o();
                return iZatValidationResults222;
            case 5:
                if (O000000o(i, O000000o(new int[]{1, 2, 4, 8, 16}))) {
                    return new IZatValidationResults();
                }
                str = "[GEO_EVENT]Value set:1,2,4,8,16, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults2222 = new IZatValidationResults(false, str);
                iZatValidationResults2222.O000000o();
                return iZatValidationResults2222;
            case 6:
                if (O000000o(i, O000000o(new int[]{1, 2, 3, 4, 5}))) {
                    return new IZatValidationResults();
                }
                str = "[GEO_REQUEST_TYPE]Value set:1,2,3,4,5, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults22222 = new IZatValidationResults(false, str);
                iZatValidationResults22222.O000000o();
                return iZatValidationResults22222;
            case 7:
                if (O000000o(i, O000000o(new int[]{-100, -102, -103, -149}))) {
                    return new IZatValidationResults();
                }
                str = "[GEO_ERROR_CODE]Value set:-100,-102,-103,-149,current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults222222 = new IZatValidationResults(false, str);
                iZatValidationResults222222.O000000o();
                return iZatValidationResults222222;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (O000000o(i, O000000o(new int[]{1, 2, 3, 4}))) {
                    return new IZatValidationResults();
                }
                str = "[GEO_ENGINE_STATUS]Value set:1,2,3,4, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults2222222 = new IZatValidationResults(false, str);
                iZatValidationResults2222222.O000000o();
                return iZatValidationResults2222222;
            case 9:
                if (i >= 0 && i < 65535) {
                    return new IZatValidationResults();
                }
                str = "[GEO_DWELL_TIME]Range: [0,65535), current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults22222222 = new IZatValidationResults(false, str);
                iZatValidationResults22222222.O000000o();
                return iZatValidationResults22222222;
            case 10:
                if (i >= 0) {
                    return new IZatValidationResults();
                }
                str = "[WIFI_EXPIRE_DAYS]Range: >=0, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults222222222 = new IZatValidationResults(false, str);
                iZatValidationResults222222222.O000000o();
                return iZatValidationResults222222222;
            case 11:
                if (i >= 0) {
                    return new IZatValidationResults();
                }
                str = "[WIFI_DAYS_VALID]Range: >=0, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults2222222222 = new IZatValidationResults(false, str);
                iZatValidationResults2222222222.O000000o();
                return iZatValidationResults2222222222;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                if (i > 0) {
                    return new IZatValidationResults();
                }
                str = "[WIFI_DELTA_TIME]Range: >0, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults22222222222 = new IZatValidationResults(false, str);
                iZatValidationResults22222222222.O000000o();
                return iZatValidationResults22222222222;
            case 13:
                if (i >= 0) {
                    return new IZatValidationResults();
                }
                str = "[WIFI_CHANNEL_NUM]Range: >=0, current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults222222222222.O000000o();
                return iZatValidationResults222222222222;
            case 14:
                if (i >= 0 && i <= 999) {
                    return new IZatValidationResults();
                }
                str = "[WWAN_CELL_REGIONID1]Range: [0,999], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults2222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults2222222222222.O000000o();
                return iZatValidationResults2222222222222;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                if (i >= 0 && i <= 32767) {
                    return new IZatValidationResults();
                }
                str = "[WWAN_CELL_REGIONID2_CDMA]Range: [0,32767], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults22222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults22222222222222.O000000o();
                return iZatValidationResults22222222222222;
            case 16:
                if (i >= 0 && i <= 999) {
                    return new IZatValidationResults();
                }
                str = "[WWAN_CELL_REGIONID2_OTHERS]Range: [0,999], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults222222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults222222222222222.O000000o();
                return iZatValidationResults222222222222222;
            case 17:
                if (i >= 0 && i <= 65535) {
                    return new IZatValidationResults();
                }
                "[WWAN_CELL_REGIONID3_CDMA_GSM]Range: [0,65535], current value: " + String.valueOf(i);
                str = "Cell ID3 out of range";
                IZatValidationResults iZatValidationResults2222222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults2222222222222222.O000000o();
                return iZatValidationResults2222222222222222;
            case 18:
                if (i > 0 && i <= 65535) {
                    return new IZatValidationResults();
                }
                "[WWAN_CELL_REGIONID3_WCDMA_LTE]Range: [1,65535], current value: " + String.valueOf(i);
                if (i < 0 && i <= 65535) {
                    return new IZatValidationResults();
                }
                str = "[WWAN_CELL_REGIONID4_CDMA_GSM]Range: [0,65535], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults22222222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults22222222222222222.O000000o();
                return iZatValidationResults22222222222222222;
            case 19:
                if (i < 0) {
                }
                str = "[WWAN_CELL_REGIONID4_CDMA_GSM]Range: [0,65535], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults222222222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults222222222222222222.O000000o();
                return iZatValidationResults222222222222222222;
            case 20:
                if (i >= 0 && i <= 268435455) {
                    return new IZatValidationResults();
                }
                str = "[WWAN_CELL_REGIONID4_WCDMA_LTE]Range: [1,268435455], current value: " + String.valueOf(i);
                IZatValidationResults iZatValidationResults2222222222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults2222222222222222222.O000000o();
                return iZatValidationResults2222222222222222222;
            default:
                str = "Unknown type to be validate";
                IZatValidationResults iZatValidationResults22222222222222222222 = new IZatValidationResults(false, str);
                iZatValidationResults22222222222222222222.O000000o();
                return iZatValidationResults22222222222222222222;
        }
    }

    public static IZatValidationResults O000000o(long j, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        String str;
        switch (iZatDataTypes) {
            case LOCATION_TIME:
                if (j <= 0) {
                    str = "[LOCATION_TIME]Range: >0, current value: " + String.valueOf(j);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case FLP_TIME_INTERVAL:
                if (j <= 0) {
                    str = "[FLP_TIME_INTERVAL]Range: >0, current value: " + String.valueOf(j);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case FLP_TRIP_DISTANCE:
                if (j <= 0) {
                    str = "[FLP_TRIP_DISTANCE]Range: >0, current value: " + String.valueOf(j);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case FLP_TBM_MILLIS:
                if (j <= 0) {
                    str = "[FLP_TBM_MILLIS]Range: >0, current value: " + String.valueOf(j);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            default:
                str = "Unknown type to be validate";
                break;
        }
        IZatValidationResults iZatValidationResults = new IZatValidationResults(false, str);
        iZatValidationResults.O000000o();
        return iZatValidationResults;
    }
}
