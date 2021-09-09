package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.civ;
import _m_j.me;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownLoadTimeLapseDemo {
    private static volatile DownLoadTimeLapseDemo mInstance;
    private OkHttpClient client = new OkHttpClient();
    private Context mContext;
    private String mDid;
    private Handler mHandler;

    private DownLoadTimeLapseDemo(Context context, String str, Handler handler) {
        this.mContext = context;
        this.mDid = str;
        this.mHandler = handler;
        civ.O000000o("DownLoadTimeLapseDemo", "DownLoadTimeLapseDemo mDid=" + this.mDid);
    }

    public static DownLoadTimeLapseDemo getInstance(Context context, String str, Handler handler) {
        if (mInstance == null) {
            synchronized (DownLoadTimeLapseDemo.class) {
                if (mInstance == null) {
                    mInstance = new DownLoadTimeLapseDemo(context, str, handler);
                }
            }
        }
        return mInstance;
    }

    public void downLoadFile() {
        civ.O000000o("DownLoadTimeLapseDemo", "downLoadFile 开始下载");
        this.client.newCall(new Request.Builder().url("https://cnbj2.fds.api.xiaomi.com/firmwarehualai/timelaps_demo.gif").build()).enqueue(new Callback() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.DownLoadTimeLapseDemo.AnonymousClass1 */

            public void onFailure(Call call, IOException iOException) {
                civ.O000000o("DownLoadTimeLapseDemo", "下载失败");
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    civ.O000000o("DownLoadTimeLapseDemo", "Main Thread");
                } else {
                    civ.O000000o("DownLoadTimeLapseDemo", "Not Main Thread");
                }
                if (response.isSuccessful()) {
                    DownLoadTimeLapseDemo.this.writeFile(response);
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6 A[SYNTHETIC, Splitter:B:36:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae A[Catch:{ IOException -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba A[SYNTHETIC, Splitter:B:46:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2 A[Catch:{ IOException -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    public void writeFile(Response response) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[4096];
        String downloadFilePath = getDownloadFilePath();
        civ.O000000o("DownLoadTimeLapseDemo", "writeFile path=".concat(String.valueOf(downloadFilePath)));
        InputStream inputStream2 = null;
        try {
            inputStream = response.body().byteStream();
            try {
                fileOutputStream = new FileOutputStream(new File(downloadFilePath));
                try {
                    long contentLength = response.body().contentLength();
                    civ.O000000o("DownLoadTimeLapseDemo", "writeFile fileSize=".concat(String.valueOf(contentLength)));
                    civ.O000000o("DownLoadTimeLapseDemo", "writeFile fileSize=" + me.O000000o(contentLength));
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        j += (long) read;
                        civ.O000000o("DownLoadTimeLapseDemo", "download current------>sum=".concat(String.valueOf(j)));
                    }
                    fileOutputStream.flush();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(100);
                    }
                    civ.O000000o("DownLoadTimeLapseDemo", "下载成功");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        e.printStackTrace();
                        if (inputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                inputStream2 = inputStream;
                e.printStackTrace();
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            e.printStackTrace();
            if (inputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            inputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private String getDownloadFilePath() {
        String O000000o2 = me.O000000o();
        if (TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        File file = new File(O000000o2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return O000000o2 + File.separator + "timelaps_demo.gif";
    }
}
