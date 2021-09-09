package _m_j;

import com.google.android.exoplayer2.C;
import com.qti.location.sdk.utils.IZatValidationResults;

public final class csw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14320O000000o = "IZatDataValidation";

    /* renamed from: _m_j.csw$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14321O000000o = new int[IZatValidationResults.IZatDataTypes.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f14321O000000o[IZatValidationResults.IZatDataTypes.LOCATION_LATITUDE.ordinal()] = 1;
            f14321O000000o[IZatValidationResults.IZatDataTypes.LOCATION_LONGITUDE.ordinal()] = 2;
            f14321O000000o[IZatValidationResults.IZatDataTypes.LOCATION_SPEED.ordinal()] = 3;
            f14321O000000o[IZatValidationResults.IZatDataTypes.LOCATION_BEARING.ordinal()] = 4;
            f14321O000000o[IZatValidationResults.IZatDataTypes.LOCATION_ACCURACY.ordinal()] = 5;
            f14321O000000o[IZatValidationResults.IZatDataTypes.GEO_RADIUS.ordinal()] = 6;
            f14321O000000o[IZatValidationResults.IZatDataTypes.WIFI_MAX_ANTENARANGE.ordinal()] = 7;
            f14321O000000o[IZatValidationResults.IZatDataTypes.WIFI_RSSI.ordinal()] = 8;
            f14321O000000o[IZatValidationResults.IZatDataTypes.WWAN_HORIZONTAL_COV_RADIUS.ordinal()] = 9;
        }
    }

    public static IZatValidationResults O000000o(float f, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        String str;
        switch (AnonymousClass1.f14321O000000o[iZatDataTypes.ordinal()]) {
            case 1:
                if (f < -90.0f || f > 90.0f) {
                    str = "[LOCATION_LATITUDE]Range: [-90,90], current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
                break;
            case 2:
                if (f < -180.0f || f > 180.0f) {
                    str = "[LOCATION_LONGITUDE]Range: [-180,180], current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case 3:
                if (f < 0.0f) {
                    str = "[LOCATION_SPEED]Range: >=0, current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case 4:
                if (f <= 0.0f || f > 360.0f) {
                    str = "[LOCATION_BEARING]Range: (0,360], current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
                break;
            case 5:
                if (f <= 0.0f) {
                    str = "[LOCATION_ACCURACY]Range: >0, current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case 6:
                if (f <= 0.0f) {
                    str = "[GEO_RADIUS]Range: >0, current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case 7:
                if (f <= 0.0f) {
                    "[WIFI_MAX_ANTENARANGE]Range: >0, current value: " + String.valueOf(f);
                    str = "Wrong wifi max antena range";
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (f <= -128.0f || f >= 127.0f) {
                    str = "[WIFI_RSSI]Range: (-128,127), current value: " + String.valueOf(f);
                    break;
                } else {
                    return new IZatValidationResults();
                }
            case 9:
                if (f <= 0.0f) {
                    str = "[WWAN_HORIZONTAL_COV_RADIUS]Range: >0, current value: " + String.valueOf(f);
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
