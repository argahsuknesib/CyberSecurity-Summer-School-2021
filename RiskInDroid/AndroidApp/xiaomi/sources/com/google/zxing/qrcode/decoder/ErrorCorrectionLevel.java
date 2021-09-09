package com.google.zxing.qrcode.decoder;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class ErrorCorrectionLevel extends Enum<ErrorCorrectionLevel> {
    private static final /* synthetic */ ErrorCorrectionLevel[] $VALUES;
    private static final ErrorCorrectionLevel[] FOR_BITS;
    public static final ErrorCorrectionLevel H = new ErrorCorrectionLevel("H", 3, 2);
    public static final ErrorCorrectionLevel L = new ErrorCorrectionLevel("L", 0, 1);
    public static final ErrorCorrectionLevel M = new ErrorCorrectionLevel("M", 1, 0);
    public static final ErrorCorrectionLevel Q = new ErrorCorrectionLevel("Q", 2, 3);
    private final int bits;

    public static ErrorCorrectionLevel valueOf(String str) {
        return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, str);
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) $VALUES.clone();
    }

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        ErrorCorrectionLevel errorCorrectionLevel4 = H;
        $VALUES = new ErrorCorrectionLevel[]{errorCorrectionLevel, errorCorrectionLevel2, errorCorrectionLevel3, errorCorrectionLevel4};
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4, errorCorrectionLevel3};
    }

    private ErrorCorrectionLevel(String str, int i, int i2) {
        this.bits = i2;
    }

    public final int getBits() {
        return this.bits;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
