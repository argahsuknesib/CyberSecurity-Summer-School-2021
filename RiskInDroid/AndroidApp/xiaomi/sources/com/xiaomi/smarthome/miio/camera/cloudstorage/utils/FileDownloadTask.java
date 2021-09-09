package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.dxx;
import _m_j.gsy;
import _m_j.jfr;
import android.os.AsyncTask;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloadTask extends AsyncTask<String, Void, Integer> {
    private ICloudDataCallback callback;

    public class AjcClosure1 extends jfr {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return FileDownloadTask.openConnection_aroundBody0((FileDownloadTask) objArr2[0], (URL) objArr2[1]);
        }
    }

    public FileDownloadTask(ICloudDataCallback iCloudDataCallback) {
        this.callback = iCloudDataCallback;
    }

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        if (r6.exists() != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        if (r3.exists() == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
        r0 = 1003;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1 A[SYNTHETIC, Splitter:B:38:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce A[SYNTHETIC, Splitter:B:50:0x00ce] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public Integer doInBackground(String... strArr) {
        File file;
        FileOutputStream fileOutputStream;
        int i = 1001;
        ? r3 = 0;
        try {
            URL url = new URL(strArr[0]);
            dxx.O000000o();
            HttpURLConnection httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Cookie", "yetAnotherServiceToken=" + CloudVideoNetUtils.getInstance().getTokenInfo().O00000o0);
            httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            file = new File(strArr[1]);
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream2;
                    e = e;
                    r3 = file;
                    try {
                        gsy.O000000o(6, "FileDownloadTask", "error:" + e.getLocalizedMessage());
                        r3.delete();
                        if (fileOutputStream != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        file = r3;
                        r3 = fileOutputStream;
                        if (r3 != 0) {
                        }
                        file.exists();
                        throw th;
                    }
                } catch (Throwable th2) {
                    r3 = fileOutputStream2;
                    th = th2;
                    if (r3 != 0) {
                    }
                    file.exists();
                    throw th;
                }
                try {
                    fileOutputStream2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i = 1002;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                r3 = file;
                gsy.O000000o(6, "FileDownloadTask", "error:" + e.getLocalizedMessage());
                r3.delete();
                if (fileOutputStream != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (r3 != 0) {
                }
                file.exists();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            gsy.O000000o(6, "FileDownloadTask", "error:" + e.getLocalizedMessage());
            if (r3 != 0 && r3.exists()) {
                r3.delete();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            file = null;
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                    throw th;
                }
            }
            file.exists();
            throw th;
        }
        return Integer.valueOf(i);
    }

    static final URLConnection openConnection_aroundBody0(FileDownloadTask fileDownloadTask, URL url) {
        return url.openConnection();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Integer num) {
        super.onPostExecute((Object) num);
        if (this.callback == null) {
            return;
        }
        if (num.intValue() == 1001) {
            this.callback.onCloudDataSuccess(null, null);
        } else if (num.intValue() == 1002) {
            this.callback.onCloudDataFailed(num.intValue(), "exception CODE_FAILURE");
        } else if (num.intValue() == 1003) {
            this.callback.onCloudDataFailed(num.intValue(), "CODE_FILE_NOT_EXIST");
        } else {
            this.callback.onCloudDataFailed(num.intValue(), "unknown error");
        }
    }
}
