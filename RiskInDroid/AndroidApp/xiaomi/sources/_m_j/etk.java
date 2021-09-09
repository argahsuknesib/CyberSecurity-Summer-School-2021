package _m_j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.ReaderException;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

public final class etk extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile boolean f15797O000000o = false;
    private static final String O00000Oo = "etk";
    private final idb O00000o = new idb();
    private final ScanBarcodeActivity O00000o0;
    private boolean O00000oO = true;

    etk(ScanBarcodeActivity scanBarcodeActivity, Map<DecodeHintType, Object> map) {
        this.O00000o.O000000o(map);
        this.O00000o0 = scanBarcodeActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    public final void handleMessage(Message message) {
        idc idc;
        if (this.O00000oO) {
            int i = message.what;
            if (i == 5) {
                byte[] bArr = (byte[]) message.obj;
                int i2 = message.arg1;
                int i3 = message.arg2;
                long currentTimeMillis = System.currentTimeMillis();
                idf idf = null;
                try {
                    Rect O00000oo = this.O00000o0.f6601O000000o.O00000oo();
                    if (O00000oo == null) {
                        idc = null;
                        if (idc != null) {
                            try {
                                idf = this.O00000o.O000000o(new icy(new idt(idc)));
                            } catch (ReaderException unused) {
                            } catch (Throwable th) {
                                this.O00000o.O000000o();
                                throw th;
                            }
                            this.O00000o.O000000o();
                        }
                        Handler handler = this.O00000o0.getHandler();
                        if (idf == null) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            Log.d(O00000Oo, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms");
                            if (handler != null) {
                                Message obtain = Message.obtain(handler, 7, idf);
                                O000000o(idc);
                                obtain.sendToTarget();
                                return;
                            }
                            return;
                        }
                        if (f15797O000000o) {
                            f15797O000000o = false;
                            O000000o(idc);
                        }
                        if (handler != null) {
                            Message.obtain(handler, 6).sendToTarget();
                            return;
                        }
                        return;
                    }
                    idc = new idc(bArr, i2, i3, O00000oo.left, O00000oo.top, O00000oo.width(), O00000oo.height(), false);
                    if (idc != null) {
                    }
                    Handler handler2 = this.O00000o0.getHandler();
                    if (idf == null) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (i == 9) {
                this.O00000oO = false;
                Looper.myLooper().quit();
            }
        }
    }

    private static void O000000o(idc idc) {
        if (idc != null) {
            int[] O00000oO2 = idc.O00000oO();
            int i = idc.f1206O000000o / 2;
            Bitmap createBitmap = Bitmap.createBitmap(O00000oO2, 0, i, i, idc.O00000Oo / 2, Bitmap.Config.ARGB_8888);
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsoluteFile() + "/barcoder");
            file.mkdirs();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile() + "/" + currentTimeMillis + ".jpg");
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                createBitmap.recycle();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
