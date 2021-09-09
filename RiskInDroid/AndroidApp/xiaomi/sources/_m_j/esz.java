package _m_j;

import android.annotation.SuppressLint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.xiaomi.qrcode.CaptureActivityHandler;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;

@SuppressLint({"InvalidR2Usage"})
public final class esz extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15783O000000o = "esz";
    private final CaptureActivityHandler O00000Oo;
    private final MultiFormatReader O00000o = new MultiFormatReader();
    private boolean O00000o0 = true;
    private ImageScanner O00000oO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.google.zxing.DecodeHintType, java.util.ArrayList]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    esz(CaptureActivityHandler captureActivityHandler) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.put((MMKVRecoverStrategic) DecodeHintType.POSSIBLE_FORMATS, (Integer) arrayList);
        this.O00000o.setHints(enumMap);
        this.O00000Oo = captureActivityHandler;
        this.O00000oO = new ImageScanner();
        this.O00000oO.setConfig(0, 256, 3);
        this.O00000oO.setConfig(0, 257, 3);
        this.O00000oO.setConfig(0, 0, 0);
        this.O00000oO.setConfig(64, 0, 1);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        byte[] f15784O000000o;
        RectF O00000Oo;

        public O000000o(byte[] bArr, RectF rectF) {
            this.f15784O000000o = bArr;
            this.O00000Oo = rectF;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    public final void handleMessage(Message message) {
        if (this.O00000o0) {
            boolean z = false;
            if (message.what == R.id.decode) {
                O000000o o000000o = (O000000o) message.obj;
                int i = message.arg1;
                int i2 = message.arg2;
                CaptureActivityHandler captureActivityHandler = this.O00000Oo;
                if (captureActivityHandler != null) {
                    if (captureActivityHandler.O00000Oo == CaptureActivityHandler.State.SUCCESS) {
                        z = true;
                    }
                    if (!z) {
                        if (o000000o == null) {
                            gsy.O00000o0(LogType.CAMERA, f15783O000000o, "decodeInfo is null");
                            return;
                        } else if (o000000o.O00000Oo == null) {
                            gsy.O00000o0(LogType.CAMERA, f15783O000000o, "clipRectRatio is null");
                            return;
                        } else {
                            float f = (float) i;
                            int i3 = (int) (o000000o.O00000Oo.left * f);
                            float f2 = (float) i2;
                            int i4 = (int) (o000000o.O00000Oo.top * f2);
                            int width = (int) (o000000o.O00000Oo.width() * f);
                            int height = (int) (o000000o.O00000Oo.height() * f2);
                            byte[] bArr = o000000o.f15784O000000o;
                            Image image = new Image(i, i2, "Y800");
                            image.setData(bArr);
                            image.setCrop(i3, i4, width, height);
                            int scanImage = this.O00000oO.scanImage(image);
                            String str = null;
                            if (scanImage != 0) {
                                Iterator<Symbol> it = this.O00000oO.getResults().iterator();
                                while (it.hasNext()) {
                                    str = it.next().getData();
                                }
                            }
                            if (TextUtils.isEmpty(str)) {
                                try {
                                    Result decodeWithState = this.O00000o.decodeWithState(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(o000000o.f15784O000000o, i, i2, i3, i4, width, height, false))));
                                    if (decodeWithState != null) {
                                        String text = decodeWithState.getText();
                                        try {
                                            gsy.O00000o0(LogType.CAMERA, f15783O000000o, "decode from zxing result:".concat(String.valueOf(text)));
                                            str = text;
                                        } catch (ReaderException e) {
                                            e = e;
                                            str = text;
                                            try {
                                                gsy.O000000o(LogType.CAMERA, f15783O000000o, "ReaderException:".concat(String.valueOf(e)));
                                                this.O00000o.reset();
                                                if (!TextUtils.isEmpty(str)) {
                                                }
                                            } catch (Throwable th) {
                                                this.O00000o.reset();
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (ReaderException e2) {
                                    e = e2;
                                    gsy.O000000o(LogType.CAMERA, f15783O000000o, "ReaderException:".concat(String.valueOf(e)));
                                    this.O00000o.reset();
                                    if (!TextUtils.isEmpty(str)) {
                                    }
                                }
                                this.O00000o.reset();
                            } else {
                                gsy.O00000o0(LogType.CAMERA, f15783O000000o, "decode from zbar result:".concat(String.valueOf(str)));
                            }
                            if (!TextUtils.isEmpty(str)) {
                                Message.obtain(this.O00000Oo, R.id.decode_succeeded, str).sendToTarget();
                                return;
                            }
                            return;
                        }
                    }
                }
                gsy.O000000o(LogType.CAMERA, f15783O000000o, "mActivityHandler return");
            } else if (message.what == R.id.quit) {
                this.O00000o0 = false;
                Looper.myLooper().quit();
            }
        }
    }
}
