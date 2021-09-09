package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.dxx;
import _m_j.gsy;
import _m_j.jfr;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloadAndDecryptTask extends AsyncTask<String, Integer, Integer> {
    private IFileDownloadCallback callback;

    public class AjcClosure1 extends jfr {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return FileDownloadAndDecryptTask.openConnection_aroundBody0((FileDownloadAndDecryptTask) objArr2[0], (URL) objArr2[1]);
        }
    }

    public interface IFileDownloadCallback {
        void onFailure(int i);

        void onProgress(int i);

        void onSuccess();
    }

    public FileDownloadAndDecryptTask(IFileDownloadCallback iFileDownloadCallback) {
        this.callback = iFileDownloadCallback;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:48:0x00d4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
        if (r3.exists() != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c4, code lost:
        r3.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
        r0 = e;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d9, code lost:
        r1 = r0;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        r9 = r3;
        r3 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0147, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0148, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x014e, code lost:
        r8.exists();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be A[SYNTHETIC, Splitter:B:40:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4 A[SYNTHETIC, Splitter:B:48:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8 A[ExcHandler: all (r0v16 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r3 r8 10  PHI: (r3v4 ?) = (r3v5 ?), (r3v5 ?), (r3v0 ?) binds: [B:48:0x00d4, B:49:?, B:22:0x0098] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r8v9 java.io.File) = (r8v10 java.io.File), (r8v10 java.io.File), (r8v13 java.io.File) binds: [B:48:0x00d4, B:49:?, B:22:0x0098] A[DONT_GENERATE, DONT_INLINE], Splitter:B:22:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e2 A[SYNTHETIC, Splitter:B:55:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0125 A[SYNTHETIC, Splitter:B:77:0x0125] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0143 A[SYNTHETIC, Splitter:B:91:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public Integer doInBackground(String... strArr) {
        File file;
        Throwable th;
        FileOutputStream fileOutputStream;
        int i = 101;
        ? r3 = 0;
        int i2 = -3;
        try {
            URL url = new URL(strArr[0]);
            dxx.O000000o();
            HttpURLConnection httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Cookie", "yetAnotherServiceToken=" + CloudVideoNetUtils.getInstance().getTokenInfo().O00000o0);
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            int contentLength = httpURLConnection.getContentLength();
            if (contentLength > 0) {
                byte[] bArr = new byte[contentLength];
                int i3 = 0;
                int i4 = 0;
                while (i3 < contentLength) {
                    int read = inputStream.read(bArr, i3, contentLength - i3);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                    int i5 = (int) ((((float) i3) / ((float) contentLength)) * 100.0f);
                    gsy.O00000Oo("FileDownloadAndDecryptTask", "progress=".concat(String.valueOf(i5)));
                    if (i5 > i4) {
                        try {
                            publishProgress(Integer.valueOf(i5));
                            i4 = i5;
                        } catch (Exception unused) {
                            fileOutputStream = null;
                            if (r3 != 0) {
                            }
                            file = r3;
                            r3 = fileOutputStream;
                            responseCode = -3;
                            if (inputStream != null) {
                            }
                            if (r3 != 0) {
                            }
                            i2 = responseCode;
                            i = i2;
                            return Integer.valueOf(i);
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            file = null;
                            if (r3 != 0) {
                            }
                            if (file != null) {
                            }
                            throw th;
                        }
                    }
                }
                byte[] decrypt = CloudVideoCryptoUtils.getInstance().decrypt(bArr);
                file = new File(strArr[1]);
                try {
                    if (file.exists()) {
                        file.deleteOnExit();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(decrypt, 0, decrypt.length);
                        fileOutputStream.flush();
                        r3 = fileOutputStream;
                    } catch (Exception unused2) {
                        r3 = file;
                        if (r3 != 0) {
                        }
                        file = r3;
                        r3 = fileOutputStream;
                        responseCode = -3;
                        if (inputStream != null) {
                        }
                        if (r3 != 0) {
                        }
                        i2 = responseCode;
                        i = i2;
                        return Integer.valueOf(i);
                    } catch (Throwable th3) {
                        th = th3;
                        r3 = fileOutputStream;
                        if (r3 != 0) {
                        }
                        if (file != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                    fileOutputStream = null;
                    r3 = file;
                    if (r3 != 0) {
                    }
                    file = r3;
                    r3 = fileOutputStream;
                    responseCode = -3;
                    if (inputStream != null) {
                    }
                    if (r3 != 0) {
                    }
                    i2 = responseCode;
                    i = i2;
                    return Integer.valueOf(i);
                } catch (Throwable th4) {
                }
            } else {
                file = null;
                responseCode = -1;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i2 = responseCode;
            if (file == null || !file.exists()) {
                i = i2;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
            try {
                gsy.O000000o(6, "FileDownloadAndDecryptTask", "error:" + e.getLocalizedMessage());
                if (r3 != 0 && r3.exists()) {
                    r3.delete();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (r3 == 0 || !r3.exists()) {
                    i = -3;
                }
                return Integer.valueOf(i);
            } catch (Throwable th5) {
                th = th5;
                file = r3;
                r3 = fileOutputStream;
                if (r3 != 0) {
                }
                if (file != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
        }
        return Integer.valueOf(i);
    }

    static final URLConnection openConnection_aroundBody0(FileDownloadAndDecryptTask fileDownloadAndDecryptTask, URL url) {
        return url.openConnection();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Integer num) {
        super.onPostExecute((Object) num);
        if (this.callback == null) {
            return;
        }
        if (num.intValue() == 101) {
            this.callback.onSuccess();
        } else {
            this.callback.onFailure(num.intValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        IFileDownloadCallback iFileDownloadCallback = this.callback;
        if (iFileDownloadCallback != null) {
            iFileDownloadCallback.onProgress(numArr[0].intValue());
        }
    }
}
