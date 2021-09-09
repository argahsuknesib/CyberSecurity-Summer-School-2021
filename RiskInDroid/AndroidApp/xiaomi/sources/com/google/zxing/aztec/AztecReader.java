package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

public final class AztecReader implements Reader {
    public final void reset() {
    }

    public final Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[LOOP:0: B:29:0x005c->B:30:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        FormatException formatException;
        List<byte[]> byteSegments;
        String eCLevel;
        ResultPointCallback resultPointCallback;
        ResultPoint[] resultPointArr2;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        DecoderResult decoderResult = null;
        try {
            AztecDetectorResult detect = detector.detect(false);
            resultPointArr2 = detect.getPoints();
            try {
                resultPointArr = resultPointArr2;
                formatException = null;
                decoderResult = new Decoder().decode(detect);
                e = null;
            } catch (NotFoundException e) {
                e = e;
                resultPointArr = resultPointArr2;
                formatException = null;
                if (decoderResult == null) {
                }
                ResultPoint[] resultPointArr3 = resultPointArr;
                while (r13 < r0) {
                }
                Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                }
                return result;
            } catch (FormatException e2) {
                e = e2;
                resultPointArr = resultPointArr2;
                formatException = e;
                e = null;
                if (decoderResult == null) {
                }
                ResultPoint[] resultPointArr32 = resultPointArr;
                while (r13 < r0) {
                }
                Result result2 = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr32, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                }
                return result2;
            }
        } catch (NotFoundException e3) {
            e = e3;
            resultPointArr2 = null;
            resultPointArr = resultPointArr2;
            formatException = null;
            if (decoderResult == null) {
            }
            ResultPoint[] resultPointArr322 = resultPointArr;
            while (r13 < r0) {
            }
            Result result22 = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr322, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
            }
            return result22;
        } catch (FormatException e4) {
            e = e4;
            resultPointArr2 = null;
            resultPointArr = resultPointArr2;
            formatException = e;
            e = null;
            if (decoderResult == null) {
            }
            ResultPoint[] resultPointArr3222 = resultPointArr;
            while (r13 < r0) {
            }
            Result result222 = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr3222, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
            }
            return result222;
        }
        if (decoderResult == null) {
            try {
                AztecDetectorResult detect2 = detector.detect(true);
                resultPointArr = detect2.getPoints();
                decoderResult = new Decoder().decode(detect2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                } else if (formatException != null) {
                    throw formatException;
                } else {
                    throw e5;
                }
            }
        }
        ResultPoint[] resultPointArr32222 = resultPointArr;
        if (!(map == null || (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) == null)) {
            for (ResultPoint foundPossibleResultPoint : resultPointArr32222) {
                resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
            }
        }
        Result result2222 = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr32222, BarcodeFormat.AZTEC, System.currentTimeMillis());
        byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result2222.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result2222.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result2222;
    }
}
