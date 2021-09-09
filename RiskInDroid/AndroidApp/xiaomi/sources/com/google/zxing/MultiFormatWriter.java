package com.google.zxing;

import com.google.android.exoplayer2.C;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class MultiFormatWriter implements Writer {
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    /* renamed from: com.google.zxing.MultiFormatWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$BarcodeFormat = new int[BarcodeFormat.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.EAN_8.ordinal()] = 1;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.UPC_E.ordinal()] = 2;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.EAN_13.ordinal()] = 3;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.UPC_A.ordinal()] = 4;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.QR_CODE.ordinal()] = 5;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODE_39.ordinal()] = 6;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODE_93.ordinal()] = 7;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODE_128.ordinal()] = 8;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.ITF.ordinal()] = 9;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.PDF_417.ordinal()] = 10;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.CODABAR.ordinal()] = 11;
            $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            try {
                $SwitchMap$com$google$zxing$BarcodeFormat[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        Writer writer;
        switch (AnonymousClass1.$SwitchMap$com$google$zxing$BarcodeFormat[barcodeFormat.ordinal()]) {
            case 1:
                writer = new EAN8Writer();
                break;
            case 2:
                writer = new UPCEWriter();
                break;
            case 3:
                writer = new EAN13Writer();
                break;
            case 4:
                writer = new UPCAWriter();
                break;
            case 5:
                writer = new QRCodeWriter();
                break;
            case 6:
                writer = new Code39Writer();
                break;
            case 7:
                writer = new Code93Writer();
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                writer = new Code128Writer();
                break;
            case 9:
                writer = new ITFWriter();
                break;
            case 10:
                writer = new PDF417Writer();
                break;
            case 11:
                writer = new CodaBarWriter();
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                writer = new DataMatrixWriter();
                break;
            case 13:
                writer = new AztecWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return writer.encode(str, barcodeFormat, i, i2, map);
    }
}
