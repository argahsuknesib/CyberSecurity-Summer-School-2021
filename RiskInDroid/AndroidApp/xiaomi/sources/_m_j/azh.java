package _m_j;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.printservice.PrintService;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.printer.PrintJobProxy;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

public final class azh {
    public static String O00000o = "https://cnbj2.fds.api.xiaomi.com/";

    /* renamed from: O000000o  reason: collision with root package name */
    public String f12733O000000o = "servicetest";
    public String O00000Oo = "";
    public String O00000o0 = "";
    public OkHttpClient O00000oO = new OkHttpClient();
    public String O00000oo;

    public final void O000000o(String str, String str2, String str3, azi azi) {
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists() || new File(str).length() <= 52428800) {
                str.substring(str.lastIndexOf(".") + 1);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("PUT");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "");
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.flush();
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int read2 = inputStream.read();
                        if (read2 != -1) {
                            stringBuffer.append((char) read2);
                        } else {
                            Log.d(this.f12733O000000o, stringBuffer.toString());
                            dataOutputStream.close();
                            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                            azc azc = new azc(jSONObject.getString("accessKeyId"), jSONObject.getString("bucketName"), jSONObject.getString("expires"), jSONObject.getString("objectName"), jSONObject.getString("signature"));
                            azi.O000000o(O00000o + azc.O00000Oo + "/" + azc.O00000o + "?GalaxyAccessKeyId=" + azc.f12721O000000o + "&Expires=" + azc.O00000o0 + "&Signature=" + azc.O00000oO, str3, this.O00000oo);
                            return;
                        }
                    }
                } else {
                    azi.O000000o(1, XmPluginHostApi.instance().application().getString(R.string.service_upload_file_failed));
                }
            } else {
                String str4 = this.f12733O000000o;
                Log.e(str4, "uploadFile: new File(filePath).length() = " + new File(str).length());
                azi.O000000o(1, XmPluginHostApi.instance().application().getString(R.string.service_file_too_big));
            }
        } catch (IOException e) {
            e.printStackTrace();
            azi.O000000o(1, XmPluginHostApi.instance().application().getString(R.string.service_upload_file_failed));
        } catch (Exception e2) {
            e2.printStackTrace();
            azi.O000000o(1, XmPluginHostApi.instance().application().getString(R.string.service_upload_file_failed));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    @TargetApi(21)
    public final boolean O000000o(PrintService printService, PrintJobProxy printJobProxy, DeviceStat deviceStat, azi azi) throws Exception {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        Throwable th;
        Bitmap bitmap;
        File file;
        DeviceStat deviceStat2 = deviceStat;
        azi azi2 = azi;
        Bitmap bitmap2 = null;
        try {
            String name = printJobProxy.getDocumentInfo().getName();
            Log.d(this.f12733O000000o, "pringJobName = ".concat(String.valueOf(name)));
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(printJobProxy.getDocumentData());
            try {
                Log.e(this.f12733O000000o, "fileInputStream.available() = " + autoCloseInputStream.available() + " printJob.getDocumentInfo().getDataSize() = " + printJobProxy.getDocumentInfo().getDataSize());
                if (printJobProxy.getDocumentInfo().getDataSize() > 52428800) {
                    azi2.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_file_too_big));
                    try {
                        autoCloseInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                } else if ("hannto.printer.anise".equals(deviceStat2.model)) {
                    if (!TextUtils.isEmpty(name)) {
                        this.O00000oo = name;
                    } else {
                        this.O00000oo = "docu.pdf";
                    }
                    file = new File(printService.getCacheDir(), this.O00000oo);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (!file.createNewFile()) {
                        Log.w(this.f12733O000000o, "创建文件失败 mFileName1 = " + this.O00000oo);
                        this.O00000oo = "docu.pdf";
                        file = new File(printService.getCacheDir(), this.O00000oo);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                    }
                    byte[] bArr = new byte[1024];
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        int read = autoCloseInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    try {
                        autoCloseInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } else if ("hannto.printer.honey".equals(deviceStat2.model)) {
                    File file2 = new File(printService.getCacheDir(), "docu.pdf");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    byte[] bArr2 = new byte[1024];
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    while (true) {
                        int read2 = autoCloseInputStream.read(bArr2);
                        if (read2 <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr2, 0, read2);
                    }
                    fileOutputStream2.close();
                    PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(file2, 268435456));
                    if (pdfRenderer.getPageCount() > 1) {
                        azi2.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_file_too_many));
                        try {
                            autoCloseInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    } else if (pdfRenderer.getPageCount() <= 0) {
                        azi2.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_file_error));
                        try {
                            autoCloseInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return false;
                    } else {
                        PdfRenderer.Page openPage = pdfRenderer.openPage(0);
                        Bitmap createBitmap = Bitmap.createBitmap(openPage.getWidth() * 5, openPage.getHeight() * 5, Bitmap.Config.ARGB_8888);
                        openPage.render(createBitmap, null, null, 2);
                        if (createBitmap == null) {
                            Log.e("HanntoPrinterService", " getFinalBitmap bitmap == null");
                        } else {
                            int width = createBitmap.getWidth();
                            int height = createBitmap.getHeight();
                            Log.d("HanntoPrinterService", "getFinalBitmap originalWidth = " + width + " originalHeight = " + height);
                            if (createBitmap.getWidth() == createBitmap.getHeight()) {
                                bitmap2 = Bitmap.createBitmap(1200, 1800, Bitmap.Config.ARGB_8888);
                                bitmap2.eraseColor(Color.parseColor("#FFFFFF"));
                                Canvas canvas = new Canvas(bitmap2);
                                float height2 = 1142.0f / ((float) createBitmap.getHeight());
                                Matrix matrix = new Matrix();
                                matrix.postScale(height2, height2, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
                                canvas.drawBitmap(Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true), 29.0f, 29.0f, (Paint) null);
                            } else {
                                if (height > width) {
                                    Bitmap createBitmap2 = Bitmap.createBitmap(1200, 1800, Bitmap.Config.ARGB_8888);
                                    createBitmap2.eraseColor(Color.parseColor("#FFFFFF"));
                                    Canvas canvas2 = new Canvas(createBitmap2);
                                    if (height * 2 > width * 3) {
                                        Log.i("HanntoPrinterService", "getFinalBitmap height > width >3/2");
                                        float height3 = 1800.0f / ((float) createBitmap.getHeight());
                                        Matrix matrix2 = new Matrix();
                                        matrix2.postScale(height3, height3, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
                                        bitmap = createBitmap2;
                                        Bitmap createBitmap3 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix2, true);
                                        canvas2.drawBitmap(createBitmap3, (float) ((1200 - createBitmap3.getWidth()) / 2), 0.0f, (Paint) null);
                                    } else {
                                        bitmap = createBitmap2;
                                        Log.i("HanntoPrinterService", "getFinalBitmap height > width <3/2");
                                        float width2 = 1200.0f / ((float) createBitmap.getWidth());
                                        Matrix matrix3 = new Matrix();
                                        matrix3.postScale(width2, width2, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
                                        Bitmap createBitmap4 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix3, true);
                                        canvas2.drawBitmap(createBitmap4, 0.0f, (float) ((1800 - createBitmap4.getHeight()) / 2), (Paint) null);
                                    }
                                } else {
                                    bitmap = Bitmap.createBitmap(1800, 1200, Bitmap.Config.ARGB_8888);
                                    bitmap.eraseColor(Color.parseColor("#FFFFFF"));
                                    Canvas canvas3 = new Canvas(bitmap);
                                    if (width * 2 > height * 3) {
                                        Log.i("HanntoPrinterService", "getFinalBitmap width > height >3/2");
                                        float width3 = 1800.0f / ((float) createBitmap.getWidth());
                                        Matrix matrix4 = new Matrix();
                                        matrix4.postScale(width3, width3, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
                                        Bitmap createBitmap5 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix4, true);
                                        canvas3.drawBitmap(createBitmap5, 0.0f, (float) ((1200 - createBitmap5.getHeight()) / 2), (Paint) null);
                                    } else {
                                        Log.i("HanntoPrinterService", "getFinalBitmap width > height <3/2");
                                        float height4 = 1200.0f / ((float) createBitmap.getHeight());
                                        Matrix matrix5 = new Matrix();
                                        matrix5.postScale(height4, height4, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
                                        Bitmap createBitmap6 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix5, true);
                                        canvas3.drawBitmap(createBitmap6, (float) ((1800 - createBitmap6.getWidth()) / 2), 0.0f, (Paint) null);
                                    }
                                }
                                bitmap2 = bitmap;
                            }
                            Log.i("HanntoPrinterService", "getFinalBitmap  resultWidth = " + bitmap2.getWidth() + " resultHeight = " + bitmap2.getHeight());
                        }
                        Bitmap O000000o2 = O000000o(bitmap2);
                        if (!TextUtils.isEmpty(name)) {
                            this.O00000oo = name;
                        } else {
                            this.O00000oo = "img.jpg";
                        }
                        File file3 = new File(printService.getCacheDir(), this.O00000oo);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        try {
                            if (!file3.createNewFile()) {
                                Log.w(this.f12733O000000o, "创建文件失败1 mFileName = " + this.O00000oo);
                                this.O00000oo = "img.jpg";
                                file3 = new File(printService.getCacheDir(), this.O00000oo);
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                file3.createNewFile();
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            Log.e(this.f12733O000000o, "创建文件失败 = " + e5.getMessage());
                            Log.w(this.f12733O000000o, "创建文件失败2 mFileName = " + this.O00000oo);
                            this.O00000oo = "img.jpg";
                            file3 = new File(printService.getCacheDir(), this.O00000oo);
                            if (file3.exists()) {
                                file3.delete();
                            }
                            file3.createNewFile();
                        }
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                        O000000o2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream3);
                        fileOutputStream3.close();
                        openPage.close();
                        pdfRenderer.close();
                        try {
                            autoCloseInputStream.close();
                            return true;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return true;
                        }
                    }
                } else {
                    Log.e("HanntoPrinterService", "错误的model = " + deviceStat2.model);
                    try {
                        autoCloseInputStream.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    return false;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                Log.e(this.f12733O000000o, "创建文件失败 = " + e8.getMessage());
                Log.e(this.f12733O000000o, "创建文件失败 mFileName2 = " + this.O00000oo);
                this.O00000oo = "docu.pdf";
                file = new File(printService.getCacheDir(), this.O00000oo);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
            } catch (Throwable th2) {
                th = th2;
                try {
                    autoCloseInputStream.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            autoCloseInputStream = null;
            autoCloseInputStream.close();
            throw th;
        }
    }

    private static Bitmap O000000o(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int length = byteArrayOutputStream.toByteArray().length / 1024;
        if (length < 1024) {
            Log.i("HanntoPrinterService", "compressAndGenImage size = ".concat(String.valueOf(length)));
            return bitmap;
        }
        while (i > 20 && byteArrayOutputStream.toByteArray().length / 1024 > 1024) {
            byteArrayOutputStream.reset();
            i -= 4;
            Log.i("HanntoPrinterService", "compressAndGenImage options = ".concat(String.valueOf(i)));
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }
}
