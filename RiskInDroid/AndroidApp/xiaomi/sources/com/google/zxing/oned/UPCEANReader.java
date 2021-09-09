package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader {
    static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};
    static final int[][] L_AND_G_PATTERNS = new int[20][];
    static final int[][] L_PATTERNS = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    static final int[] START_END_PATTERN = {1, 1, 1};
    private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();

    /* access modifiers changed from: protected */
    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException;

    /* access modifiers changed from: package-private */
    public abstract BarcodeFormat getBarcodeFormat();

    static {
        System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = L_PATTERNS[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            L_AND_G_PATTERNS[i] = iArr2;
        }
    }

    protected UPCEANReader() {
    }

    static int[] findStartGuardPattern(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, START_END_PATTERN.length, 0);
            iArr2 = findGuardPattern(bitArray, i, false, START_END_PATTERN, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = bitArray.isRange(i4, i2, false);
            }
            i = i3;
        }
        return iArr2;
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return decodeRow(i, bitArray, findStartGuardPattern(bitArray), map);
    }

    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPointCallback resultPointCallback;
        int i2;
        String lookupCountryIdentifier;
        int[] iArr2 = null;
        if (map == null) {
            resultPointCallback = null;
        } else {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        boolean z = true;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((float) decodeMiddle, (float) i));
        }
        int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (decodeEnd[0] + decodeEnd[1])) / 2.0f, (float) i));
        }
        int i3 = decodeEnd[1];
        int i4 = (i3 - decodeEnd[0]) + i3;
        if (i4 >= bitArray.getSize() || !bitArray.isRange(i3, i4, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw FormatException.getFormatInstance();
        } else if (checkChecksum(sb2)) {
            BarcodeFormat barcodeFormat = getBarcodeFormat();
            float f = (float) i;
            Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint(((float) (iArr[1] + iArr[0])) / 2.0f, f), new ResultPoint(((float) (decodeEnd[1] + decodeEnd[0])) / 2.0f, f)}, barcodeFormat);
            try {
                Result decodeRow = this.extensionReader.decodeRow(i, bitArray, decodeEnd[1]);
                result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                result.putAllMetadata(decodeRow.getResultMetadata());
                result.addResultPoints(decodeRow.getResultPoints());
                i2 = decodeRow.getText().length();
            } catch (ReaderException unused) {
                i2 = 0;
            }
            if (map != null) {
                iArr2 = (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (i2 == iArr2[i5]) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if ((barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) && (lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(sb2)) != null) {
                result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
            }
            return result;
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkChecksum(String str) throws FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return getStandardUPCEANChecksum(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    static int getStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }

    /* access modifiers changed from: package-private */
    public int[] decodeEnd(BitArray bitArray, int i) throws NotFoundException {
        return findGuardPattern(bitArray, i, false, START_END_PATTERN);
    }

    static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        return findGuardPattern(bitArray, i, z, iArr, new int[iArr.length]);
    }

    private static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int size = bitArray.getSize();
        int nextUnset = z ? bitArray.getNextUnset(i) : bitArray.getNextSet(i);
        int length = iArr.length;
        int i2 = nextUnset;
        int i3 = 0;
        while (nextUnset < size) {
            boolean z2 = true;
            if (bitArray.get(nextUnset) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (patternMatchVariance(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i2, nextUnset};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            nextUnset++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int decodeDigit(BitArray bitArray, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float patternMatchVariance = patternMatchVariance(iArr, iArr2[i3], 0.7f);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
