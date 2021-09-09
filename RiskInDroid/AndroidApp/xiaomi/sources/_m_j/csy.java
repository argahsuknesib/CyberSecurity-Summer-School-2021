package _m_j;

import com.qti.location.sdk.utils.IZatValidationResults;

public final class csy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14324O000000o = "IZatDataValidation";

    /* renamed from: _m_j.csy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14325O000000o = new int[IZatValidationResults.IZatDataTypes.values().length];

        static {
            try {
                f14325O000000o[IZatValidationResults.IZatDataTypes.WIFI_MAC_ADDRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static IZatValidationResults O000000o(String str, IZatValidationResults.IZatDataTypes iZatDataTypes) {
        String str2;
        if (AnonymousClass1.f14325O000000o[iZatDataTypes.ordinal()] != 1) {
            str2 = "Unknown type to be validate";
        } else if (str.matches("[A-Fa-f0-9]{12}")) {
            return new IZatValidationResults();
        } else {
            str2 = "[WIFI_MAC_ADDRESS]Str with len 12, [0-F], current value: " + str;
        }
        IZatValidationResults iZatValidationResults = new IZatValidationResults(false, str2);
        iZatValidationResults.O000000o();
        return iZatValidationResults;
    }
}
