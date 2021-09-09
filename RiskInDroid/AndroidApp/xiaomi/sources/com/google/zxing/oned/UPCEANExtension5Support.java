package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    UPCEANExtension5Support() {
    }

    /* access modifiers changed from: package-private */
    public final Result decodeRow(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb2);
        float f = (float) i;
        Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, f), new ResultPoint((float) decodeMiddle, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && i < size) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (decodeDigit >= 10) {
                i3 |= 1 << (4 - i2);
            }
            i = i2 != 4 ? bitArray.getNextUnset(bitArray.getNextSet(i4)) : i4;
            i2++;
        }
        if (sb.length() == 5) {
            if (extensionChecksum(sb.toString()) == determineCheckDigit(i3)) {
                return i;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    private static int determineCheckDigit(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == CHECK_DIGIT_ENCODINGS[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.google.zxing.ResultMetadataType, java.lang.String]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        String parseExtension5String;
        if (str.length() != 5 || (parseExtension5String = parseExtension5String(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((MMKVRecoverStrategic) ResultMetadataType.SUGGESTED_PRICE, (Integer) parseExtension5String);
        return enumMap;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.equals("90000") != false) goto L_0x003d;
     */
    private static String parseExtension5String(String str) {
        char c = 0;
        char charAt = str.charAt(0);
        String str2 = "";
        if (charAt == '0') {
            str2 = "£";
        } else if (charAt == '5') {
            str2 = "$";
        } else if (charAt == '9') {
            switch (str.hashCode()) {
                case 54118329:
                    break;
                case 54395376:
                    if (str.equals("99990")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 54395377:
                    if (str.equals("99991")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                return null;
            }
            if (c == 1) {
                return "0.00";
            }
            if (c == 2) {
                return "Used";
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        int i = parseInt % 100;
        String concat = i < 10 ? "0".concat(String.valueOf(i)) : String.valueOf(i);
        return str2 + valueOf + '.' + concat;
    }
}
