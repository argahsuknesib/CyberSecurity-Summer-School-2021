package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.bbx;
import _m_j.bbz;
import _m_j.bcb;
import _m_j.bcm;
import _m_j.bcn;
import _m_j.bct;
import _m_j.bcu;
import _m_j.cik;
import _m_j.cjn;
import _m_j.cki;
import _m_j.dxx;
import _m_j.ftd;
import _m_j.gkv;
import _m_j.gsy;
import _m_j.jfr;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.Format;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

public class M3U8DownloadAndDecryptTask extends AsyncTask<String, Integer, Integer> {
    private IFileDownloadCallback callback;
    private boolean isFileDownloadSuccess = false;
    private String m3u8FileFolder = null;
    private String postfix = "";
    private int trackDataSize = 0;
    private boolean transcode = false;
    private List<TrackDataLite> tsFileList = new ArrayList();

    public class AjcClosure1 extends jfr {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return M3U8DownloadAndDecryptTask.openConnection_aroundBody0((M3U8DownloadAndDecryptTask) objArr2[0], (URL) objArr2[1]);
        }
    }

    public interface IFileDownloadCallback {
        void onFailure(int i);

        void onProgress(int i);

        void onSuccess(List<String> list, String str);
    }

    public void setTranscode(boolean z) {
        this.transcode = z;
    }

    class TrackDataLite {
        public float duration;
        public boolean isContinue;
        public String title;
        public String uri;

        private TrackDataLite() {
        }
    }

    public M3U8DownloadAndDecryptTask(IFileDownloadCallback iFileDownloadCallback) {
        this.callback = iFileDownloadCallback;
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.CharSequence, com.xiaomi.smarthome.miio.camera.cloudstorage.utils.M3U8DownloadAndDecryptTask$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0109, code lost:
        r15 = -104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0202, code lost:
        if (r1.isFileDownloadSuccess != false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0204, code lost:
        r11 = 101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0227, code lost:
        if (r1.isFileDownloadSuccess == false) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x022e, code lost:
        return java.lang.Integer.valueOf(r11);
     */
    public Integer doInBackground(String... strArr) {
        int i;
        int i2;
        String str;
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        StringBuilder sb = new StringBuilder();
        ? r9 = 0;
        sb.append(gkv.f17949O000000o.getExternalFilesDir(null));
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(str4);
        sb.append("/");
        sb.append(str4);
        sb.append(".m3u8");
        String sb2 = sb.toString();
        String substring = sb2.substring(0, sb2.lastIndexOf("/"));
        this.m3u8FileFolder = substring;
        File file = new File(substring);
        cjn.O000000o(file);
        if (!file.exists()) {
            file.mkdirs();
        }
        publishProgress(0);
        try {
            if (downloadFile(str2, sb2)) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new String(ftd.O00000Oo(sb2)).replace("#EXT-X-VERSION:7", "#EXT-X-VERSION:3").getBytes());
                List<bct> list = new bbz(byteArrayInputStream, Format.EXT_M3U, Encoding.UTF_8, bbx.O00000Oo).O00000Oo().O00000Oo.f12860O000000o;
                this.trackDataSize = list.size();
                String str5 = substring + "/" + str3 + ".key";
                if (list != null && list.size() > 0) {
                    if (list.get(0).f12871O000000o.contains("/ts") || !list.get(0).f12871O000000o.contains("/mp4")) {
                        this.postfix = ".ts";
                    } else {
                        this.postfix = ".mp4";
                    }
                }
                cki.O000000o("M3U8DownloadAndDecryptTask", "need transcode =" + this.transcode);
                Iterator<bct> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = 0;
                        break;
                    }
                    bct next = it.next();
                    if (isCancelled()) {
                        break;
                    }
                    if (!TextUtils.isEmpty(next.f12871O000000o)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(substring);
                        sb3.append("/");
                        String str6 = str5;
                        sb3.append(System.currentTimeMillis());
                        sb3.append(this.postfix);
                        String sb4 = sb3.toString();
                        String replace = sb4.replace(this.postfix, "_plain" + this.postfix);
                        downloadFile(next.f12871O000000o, sb4);
                        if (isCancelled()) {
                            break;
                        }
                        String str7 = next.O00000o0.O00000Oo;
                        TrackDataLite trackDataLite = new TrackDataLite();
                        if (TextUtils.isEmpty(r9) || TextUtils.isEmpty(str7) || !str7.equals(r9)) {
                            str = str6;
                            downloadFile(str7, str);
                            if (decryptTS(sb4, str, replace, next.O00000o0.O00000o0)) {
                                trackDataLite.uri = replace;
                                trackDataLite.duration = next.O00000Oo.f12873O000000o;
                                trackDataLite.isContinue = false;
                                this.tsFileList.add(trackDataLite);
                            }
                        } else {
                            str = str6;
                            if (decryptTS(sb4, str, replace, next.O00000o0.O00000o0)) {
                                trackDataLite.uri = replace;
                                trackDataLite.duration = next.O00000Oo.f12873O000000o;
                                trackDataLite.isContinue = false;
                                this.tsFileList.add(trackDataLite);
                            }
                        }
                        if (list != null && list.size() > 0) {
                            publishProgress(Integer.valueOf((int) ((((float) this.tsFileList.size()) / ((float) list.size())) * 100.0f)));
                        }
                    } else {
                        str = str5;
                    }
                    str5 = str;
                    r9 = 0;
                }
                if (this.tsFileList.size() >= list.size()) {
                    publishProgress(100);
                    generateNewM3U8(sb2.replace(".m3u8", "_plain.m3u8"));
                }
                byteArrayInputStream.close();
                i = i2;
            } else {
                i = 0;
            }
        } catch (Exception e) {
            gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "common exception:" + e.getLocalizedMessage());
            e.printStackTrace();
            i = -103;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0 A[SYNTHETIC, Splitter:B:27:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8 A[SYNTHETIC, Splitter:B:32:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    private void generateNewM3U8(String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        if (!TextUtils.isEmpty(str)) {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    bcb bcb = new bcb(fileOutputStream, Format.EXT_M3U, Encoding.UTF_8);
                    ArrayList arrayList = new ArrayList();
                    Iterator<TrackDataLite> it = this.tsFileList.iterator();
                    while (true) {
                        boolean z = true;
                        if (it.hasNext()) {
                            TrackDataLite next = it.next();
                            bct.O000000o o000000o = new bct.O000000o();
                            o000000o.O00000Oo = new bcu(next.duration, null);
                            if (next.isContinue) {
                                z = false;
                            }
                            o000000o.O00000oO = z;
                            o000000o.f12872O000000o = next.uri;
                            arrayList.add(o000000o.O000000o());
                        } else {
                            bcm.O000000o o000000o2 = new bcm.O000000o();
                            o000000o2.O00000o = 1;
                            o000000o2.O00000o0 = 3;
                            o000000o2.f12861O000000o = arrayList;
                            bcm O000000o2 = o000000o2.O000000o();
                            bcn.O000000o o000000o3 = new bcn.O000000o();
                            o000000o3.O00000o = 7;
                            o000000o3.O00000Oo = O000000o2;
                            o000000o3.O00000o0 = true;
                            bcb.O000000o(o000000o3.O000000o());
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "generateNewM3U8 error:" + e.getLocalizedMessage());
                        if (fileOutputStream == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "generateNewM3U8 error:" + e.getLocalizedMessage());
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0105 A[SYNTHETIC, Splitter:B:54:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a A[Catch:{ IOException -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0111 A[SYNTHETIC, Splitter:B:61:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0116 A[Catch:{ IOException -> 0x0119 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    private boolean decryptTS(String str, String str2, String str3, List<Byte> list) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream = null;
        try {
            byte[] O00000Oo = cjn.O00000Oo(str);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ftd.O00000Oo(str2), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(CloudVideoUtils.parseHexBinary(CloudVideoUtils.byteList2String(list)));
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = instance.doFinal(O00000Oo);
            if (doFinal == null || doFinal.length <= 0) {
                bufferedOutputStream = null;
            } else {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str3);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        bufferedOutputStream.write(doFinal);
                        bufferedOutputStream.flush();
                        fileOutputStream = fileOutputStream2;
                    } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "decrypt error:" + e.getLocalizedMessage());
                            if (fileOutputStream != null) {
                            }
                            if (bufferedOutputStream == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                            }
                            if (bufferedOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "decrypt error:" + e.getLocalizedMessage());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (bufferedOutputStream == null) {
                        return false;
                    }
                    bufferedOutputStream.close();
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                            throw th;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            }
            try {
                gsy.O00000Oo("M3U8DownloadAndDecryptTask", "decryptTS success");
                ftd.O00000oo(str);
                if (this.transcode) {
                    try {
                        int lastIndexOf = str3.lastIndexOf(".");
                        if (lastIndexOf != -1) {
                            cki.O000000o("M3U8DownloadAndDecryptTask", "transcode =".concat(String.valueOf(cik.O000000o(str3, str3.substring(0, lastIndexOf) + "_360" + str3.substring(lastIndexOf)))));
                        }
                    } catch (Exception e3) {
                        cki.O00000oO("M3U8DownloadAndDecryptTask", e3.toString());
                    }
                    ftd.O00000oo(str3);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        return false;
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                return true;
            } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e4) {
                e = e4;
            } catch (Throwable th4) {
                ftd.O00000oo(str3);
                throw th4;
            }
        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e5) {
            e = e5;
            bufferedOutputStream = null;
            gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "decrypt error:" + e.getLocalizedMessage());
            if (fileOutputStream != null) {
            }
            if (bufferedOutputStream == null) {
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            if (fileOutputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        if (r4 != null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c2, code lost:
        if (r4 != null) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bf A[SYNTHETIC, Splitter:B:42:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8 A[SYNTHETIC, Splitter:B:47:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cd A[Catch:{ IOException -> 0x00d0 }] */
    private boolean downloadFile(String str, String str2) {
        InputStream inputStream;
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gsy.O00000Oo("M3U8DownloadAndDecryptTask", "urlString:" + str + " filePath:" + str2);
        } else {
            File file = new File(str2);
            FileOutputStream fileOutputStream = null;
            try {
                URL url = new URL(str);
                dxx.O000000o();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) dxx.O000000o(url);
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setRequestProperty("Cookie", "yetAnotherServiceToken=" + CloudVideoNetUtils.getInstance().getTokenInfo().O00000o0);
                httpsURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                inputStream = httpsURLConnection.getInputStream();
                try {
                    int contentLength = httpsURLConnection.getContentLength();
                    if (contentLength > 0 && responseCode == 200) {
                        if (file.exists()) {
                            file.deleteOnExit();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[contentLength];
                            int i = 0;
                            while (i < contentLength) {
                                int read = inputStream.read(bArr, i, contentLength - i);
                                if (read == -1) {
                                    break;
                                }
                                i += read;
                            }
                            fileOutputStream2.write(bArr, 0, contentLength);
                            fileOutputStream2.flush();
                            fileOutputStream = fileOutputStream2;
                            z = true;
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            try {
                                gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "downloadFile error:" + e.getLocalizedMessage());
                                if (fileOutputStream != null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused) {
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "downloadFile error:" + e.getLocalizedMessage());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                gsy.O000000o(6, "M3U8DownloadAndDecryptTask", "downloadFile error:" + e.getLocalizedMessage());
                if (fileOutputStream != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        }
        return z;
    }

    static final URLConnection openConnection_aroundBody0(M3U8DownloadAndDecryptTask m3U8DownloadAndDecryptTask, URL url) {
        return url.openConnection();
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        IFileDownloadCallback iFileDownloadCallback = this.callback;
        if (iFileDownloadCallback != null) {
            iFileDownloadCallback.onProgress(numArr[0].intValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Integer num) {
        Integer num2;
        super.onPostExecute((Object) num);
        if (this.callback != null) {
            if (this.trackDataSize > 0 && this.tsFileList.size() == this.trackDataSize) {
                num2 = 101;
            } else if (num.intValue() == -104) {
                num2 = -104;
            } else {
                num2 = -102;
            }
            if (num2.intValue() == 101) {
                ArrayList arrayList = new ArrayList();
                for (TrackDataLite trackDataLite : this.tsFileList) {
                    arrayList.add(trackDataLite.uri);
                }
                IFileDownloadCallback iFileDownloadCallback = this.callback;
                iFileDownloadCallback.onSuccess(arrayList, this.m3u8FileFolder);
                return;
            }
            this.callback.onFailure(num2.intValue());
        }
    }
}
