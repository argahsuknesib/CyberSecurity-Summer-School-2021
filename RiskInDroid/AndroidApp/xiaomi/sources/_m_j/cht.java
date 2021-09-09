package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.IRDTPanoramaListener;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class cht {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13831O000000o = "cht";
    public static String O00000oO = (Environment.getExternalStorageDirectory() + "/DCIM/mijiacamera/panoramic/");
    public ExecutorService O00000Oo = Executors.newSingleThreadExecutor();
    public AtomicInteger O00000o = new AtomicInteger();
    public cid O00000o0;
    public SparseArray<short[]> O00000oo = new SparseArray<>();
    public volatile short O0000O0o = 5;
    public Handler O0000OOo = new Handler(Looper.myLooper());
    public AtomicInteger O0000Oo = new AtomicInteger(0);
    public volatile long O0000Oo0;
    public volatile boolean O0000OoO = false;
    private IRDTPanoramaListener O0000Ooo = new O000000o();
    private Paint O0000o0 = new Paint(1);
    private BitmapFactory.Options O0000o00 = new BitmapFactory.Options();

    public cht(cid cid) {
        this.O00000o0 = cid;
        O00000oO = Environment.getExternalStorageDirectory() + "/DCIM/mijiacamera/panoramic/" + cid.getDid() + "/";
    }

    class O000000o implements IRDTPanoramaListener {

        /* renamed from: O000000o  reason: collision with root package name */
        public Callback<Object> f13839O000000o;
        public Context O00000Oo;
        public volatile Long O00000o0;

        O000000o() {
        }

        public final void init(Callback<Object> callback, Context context, long j) {
            this.f13839O000000o = callback;
            this.O00000Oo = context;
            this.O00000o0 = Long.valueOf(j);
        }

        public final void onPanoramaReceived(final byte[] bArr) {
            if (this.f13839O000000o != null && this.O00000Oo != null) {
                String str = cht.f13831O000000o;
                gsy.O00000Oo(str, "receive: data.length=" + bArr.length);
                final int[] iArr = {0};
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, iArr[0], bArr2, 0, 4);
                int byteArrayToInt = Packet.byteArrayToInt(bArr2, 0, false);
                gsy.O00000Oo(cht.f13831O000000o, "total panorama timeStamp = ".concat(String.valueOf(byteArrayToInt)));
                if (((long) byteArrayToInt) != this.O00000o0.longValue()) {
                    gsy.O00000Oo(cht.f13831O000000o, "total panorama timeStamp is not current");
                    return;
                }
                gsy.O00000Oo(cht.f13831O000000o, "total panorama timeStamp is current =".concat(String.valueOf(byteArrayToInt)));
                cht.this.O00000Oo.execute(new Runnable() {
                    /* class _m_j.cht.O000000o.AnonymousClass1 */

                    public final void run() {
                        String str = O000000o.this.O00000Oo.getExternalCacheDir() + "/panoramic/" + O000000o.this.O00000o0;
                        File file = new File(str);
                        if (!file.exists() || !file.isDirectory()) {
                            file.mkdirs();
                        }
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + 4;
                        byte[] bArr = new byte[2];
                        System.arraycopy(bArr, iArr[0], bArr, 0, 2);
                        cht.this.O0000O0o = Packet.byteArrayToShort(bArr, 0, false);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + 2;
                        byte[] bArr2 = new byte[2];
                        System.arraycopy(bArr, iArr2[0], bArr2, 0, 2);
                        short byteArrayToShort = Packet.byteArrayToShort(bArr2, 0, false);
                        gsy.O00000Oo(cht.f13831O000000o, "current panorama index = " + ((int) byteArrayToShort) + "/" + ((int) cht.this.O0000O0o));
                        cht.this.O00000o.addAndGet(1);
                        int[] iArr3 = iArr;
                        iArr3[0] = iArr3[0] + 2;
                        byte[] bArr3 = new byte[2];
                        System.arraycopy(bArr, iArr3[0], bArr3, 0, 2);
                        short byteArrayToShort2 = Packet.byteArrayToShort(bArr3, 0, false);
                        int[] iArr4 = iArr;
                        iArr4[0] = iArr4[0] + 2;
                        byte[] bArr4 = new byte[2];
                        System.arraycopy(bArr, iArr4[0], bArr4, 0, 2);
                        short byteArrayToShort3 = Packet.byteArrayToShort(bArr4, 0, false);
                        cht.this.O00000oo.put(byteArrayToShort, new short[]{byteArrayToShort2, byteArrayToShort3});
                        int[] iArr5 = iArr;
                        iArr5[0] = iArr5[0] + 2;
                        gsy.O00000Oo(cht.f13831O000000o, "current panorama hd / vd = " + ((int) byteArrayToShort2) + " / " + ((int) byteArrayToShort3));
                        File file2 = new File(str + "/" + (byteArrayToShort + 100) + ".jpeg");
                        try {
                            byte[] bArr5 = new byte[0];
                            if (bArr.length > 4) {
                                bArr5 = new byte[(bArr.length - 4)];
                                System.arraycopy(bArr, iArr[0], bArr5, 0, bArr.length - iArr[0]);
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            fileOutputStream.write(bArr5);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (cht.this.O00000o.get() >= cht.this.O0000O0o) {
                            gsy.O00000Oo(cht.f13831O000000o, "all panorama received");
                            O000000o.this.f13839O000000o.onSuccess(cht.this.O000000o(str));
                        }
                    }
                });
            }
        }
    }

    public final void O000000o(final long j, final Callback<String[]> callback) {
        this.O0000Oo.addAndGet(1);
        String str = f13831O000000o;
        gsy.O00000Oo(str, "currentTimeMillis=" + this.O0000Oo0);
        gsy.O00000Oo(f13831O000000o, "timeStamp=".concat(String.valueOf(j)));
        String str2 = f13831O000000o;
        gsy.O00000Oo(str2, "isCanceled=" + this.O0000OoO);
        if ((j == this.O0000Oo0 && !this.O0000OoO) || j == 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.O00000o0.getDid());
                jSONObject.put("model", this.O00000o0.getModel());
                jSONObject.put("timeStamp", j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String str3 = f13831O000000o;
            gsy.O00000Oo(str3, "mergePhotoMeta params=" + jSONObject.toString());
            XmPluginHostApi.instance().callSmartHomeApi(this.O00000o0.getModel(), "business.smartcamera.", "/common/app/get/mergePhotoMeta", "GET", jSONObject.toString(), new Callback<JSONObject>() {
                /* class _m_j.cht.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        String str = cht.f13831O000000o;
                        gsy.O00000Oo(str, "mergePhotoMeta onSuccess=" + jSONObject.toString());
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject.length() != 0) {
                            String optString = optJSONObject.optString("stoId");
                            if (optJSONObject.optLong("modifyTime") != j) {
                                if (j != 0) {
                                    if (cht.this.O0000Oo.get() > 11) {
                                        gsy.O00000Oo(cht.f13831O000000o, "mergePhotoMeta time out!");
                                        callback.onFailure(-999, "time out!");
                                        return;
                                    }
                                    cht.this.O0000OOo.postDelayed(new Runnable() {
                                        /* class _m_j.cht.AnonymousClass2.AnonymousClass2 */

                                        public final void run() {
                                            cht.this.O000000o(j, callback);
                                        }
                                    }, 5000);
                                    return;
                                }
                            }
                            int optInt = optJSONObject.optInt("borderLx", 90);
                            int optInt2 = optJSONObject.optInt("borderLy", 51);
                            int optInt3 = optJSONObject.optInt("borderRx", 19);
                            int optInt4 = optJSONObject.optInt("borderRy", 51);
                            cht.this.O00000oo.put(1, new short[]{(short) optInt, (short) optInt2});
                            cht.this.O00000oo.put(2, new short[]{(short) optInt3, (short) optInt4});
                            callback.onSuccess(new String[]{"0", optString});
                        } else if (j == 0) {
                            callback.onFailure(0, "no cache");
                            cht.this.O0000Oo.set(0);
                        } else if (cht.this.O0000Oo.get() > 11) {
                            gsy.O00000Oo(cht.f13831O000000o, "mergePhotoMeta time out!");
                            callback.onFailure(-999, "time out!");
                        } else {
                            cht.this.O0000OOo.postDelayed(new Runnable() {
                                /* class _m_j.cht.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    cht.this.O000000o(j, callback);
                                }
                            }, 5000);
                        }
                    } catch (Exception unused) {
                        if (cht.this.O0000Oo.get() > 11) {
                            gsy.O00000Oo(cht.f13831O000000o, "mergePhotoMeta time out!");
                            callback.onFailure(-999, "time out!");
                            return;
                        }
                        cht.this.O0000OOo.postDelayed(new Runnable() {
                            /* class _m_j.cht.AnonymousClass2.AnonymousClass3 */

                            public final void run() {
                                cht.this.O000000o(j, callback);
                            }
                        }, 5000);
                    }
                }

                public final void onFailure(int i, String str) {
                    String str2 = cht.f13831O000000o;
                    gsy.O00000Oo(str2, "mergePhotoMeta onFailure=" + str + " error=" + str);
                    if (cht.this.O0000Oo.get() > 11) {
                        gsy.O00000Oo(cht.f13831O000000o, "server error!");
                        callback.onFailure(i, "server error!");
                        return;
                    }
                    cht.this.O0000OOo.postDelayed(new Runnable() {
                        /* class _m_j.cht.AnonymousClass2.AnonymousClass4 */

                        public final void run() {
                            cht.this.O000000o(j, callback);
                        }
                    }, 5000);
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final String O000000o(String str) {
        Bitmap bitmap;
        int i;
        String str2 = str;
        File[] listFiles = new File(str2).listFiles();
        if (listFiles == null) {
            gsy.O00000Oo(f13831O000000o, "files=null");
            return null;
        }
        gsy.O00000Oo(f13831O000000o, "files=" + listFiles.length);
        this.O0000o00.inJustDecodeBounds = true;
        gsy.O00000Oo(f13831O000000o, "file name=" + listFiles[0].getAbsolutePath());
        Bitmap decodeFile = BitmapFactory.decodeFile(listFiles[0].getAbsolutePath(), this.O0000o00);
        if (listFiles.length > 5) {
            bitmap = Bitmap.createBitmap((this.O0000o00.outWidth * listFiles.length) / 2, this.O0000o00.outHeight * 2, Bitmap.Config.RGB_565);
        } else {
            bitmap = Bitmap.createBitmap(this.O0000o00.outWidth * listFiles.length, this.O0000o00.outHeight, Bitmap.Config.RGB_565);
        }
        if (decodeFile == null) {
            gsy.O000000o(6, f13831O000000o, "decode bitmap = null");
        }
        gsy.O00000Oo(f13831O000000o, "decode width=" + this.O0000o00.outWidth + " height=" + this.O0000o00.outHeight);
        gsy.O00000Oo(f13831O000000o, "bigBitmap width=" + bitmap.getWidth() + " height=" + bitmap.getHeight());
        Canvas canvas = new Canvas(bitmap);
        this.O0000o0.setFilterBitmap(true);
        this.O0000o0.setDither(true);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < listFiles.length; i4++) {
            gsy.O00000Oo(f13831O000000o, "right=" + i2 + " top=" + i3);
            File file = new File(str2 + "/" + (i4 + 101) + ".jpeg");
            if (file.exists()) {
                Rect rect = new Rect(i2, i3, this.O0000o00.outWidth + i2, (this.O0000o00.outHeight * 2) + i3);
                Bitmap decodeFile2 = BitmapFactory.decodeFile(file.getAbsolutePath());
                canvas.drawBitmap(decodeFile2, new Rect(0, 0, decodeFile2.getWidth(), bitmap.getHeight()), rect, (Paint) null);
                if (listFiles.length <= 5) {
                    i = this.O0000o00.outWidth;
                } else if (i4 < (listFiles.length >> 1) - 1) {
                    i2 += this.O0000o00.outWidth;
                } else if (i4 == (listFiles.length >> 1) - 1) {
                    i3 += this.O0000o00.outHeight;
                } else {
                    i = this.O0000o00.outWidth;
                }
                i2 -= i;
            }
        }
        File file2 = new File(O00000oO);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        String str3 = O00000oO + "panorama.jpeg";
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str3)));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str3;
    }
}
