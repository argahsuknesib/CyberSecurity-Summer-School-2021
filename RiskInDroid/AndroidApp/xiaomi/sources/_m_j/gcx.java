package _m_j;

import android.os.AsyncTask;
import android.os.Build;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gcx extends AsyncTask<gcv, long[], gcw> {

    /* renamed from: O000000o  reason: collision with root package name */
    public gcv f17545O000000o;
    public AtomicBoolean O00000Oo = new AtomicBoolean(false);
    gcw O00000o0;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        this.f17545O000000o = ((gcv[]) objArr)[0];
        this.O00000o0 = new gcw();
        new Thread(new Runnable() {
            /* class _m_j.gcx.AnonymousClass1 */

            public final void run() {
                try {
                    gcx.this.O000000o(gcx.this.f17545O000000o, gcx.this.O00000o0);
                    gcx.this.f17545O000000o.O0000OOo.O000000o(gcx.this.O00000o0);
                } catch (Exception e) {
                    gcx.this.O00000o0.O00000o0 = e;
                    gcx.this.f17545O000000o.O0000OOo.O000000o(gcx.this.O00000o0);
                }
            }
        }).start();
        return this.O00000o0;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        long[][] jArr = (long[][]) objArr;
        super.onProgressUpdate(jArr);
        if (this.f17545O000000o.O0000Oo != null) {
            this.f17545O000000o.O0000Oo.O000000o(jArr[0][0], jArr[0][1]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0242  */
    public final void O000000o(gcv gcv, gcw gcw) throws Exception {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection2;
        int i;
        int i2;
        HttpURLConnection httpURLConnection3;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        int i3;
        int i4;
        int i5;
        int i6;
        gcv gcv2 = gcv;
        gcw gcw2 = gcw;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = gcv2.f17543O000000o;
            dxx.O000000o();
            HttpURLConnection httpURLConnection4 = (HttpURLConnection) dxx.O000000o(url);
            try {
                ReadableMapKeySetIterator keySetIterator = gcv2.O00000o0.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    httpURLConnection4.setRequestProperty(nextKey, gcv2.O00000o0.getString(nextKey));
                }
                httpURLConnection4.setConnectTimeout(gcv2.O0000O0o);
                httpURLConnection4.setReadTimeout(gcv2.O00000oo);
                httpURLConnection4.connect();
                int responseCode = httpURLConnection4.getResponseCode();
                long O000000o2 = O000000o(httpURLConnection4);
                if (responseCode != 200 && (responseCode == 301 || responseCode == 302 || responseCode == 307 || responseCode == 308)) {
                    String headerField = httpURLConnection4.getHeaderField("Location");
                    httpURLConnection4.disconnect();
                    URL url2 = new URL(headerField);
                    dxx.O000000o();
                    httpURLConnection2 = (HttpURLConnection) dxx.O000000o(url2);
                    try {
                        httpURLConnection2.setConnectTimeout(5000);
                        httpURLConnection2.connect();
                        i = httpURLConnection2.getResponseCode();
                        O000000o2 = O000000o(httpURLConnection2);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = null;
                        httpURLConnection = httpURLConnection2;
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } else {
                    int i7 = responseCode;
                    httpURLConnection2 = httpURLConnection4;
                    i = i7;
                }
                if (i < 200 || i >= 300) {
                    i2 = i;
                    httpURLConnection3 = httpURLConnection2;
                    bufferedInputStream2 = null;
                } else {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                        HashMap hashMap = new HashMap();
                        for (Map.Entry next : headerFields.entrySet()) {
                            String str = (String) next.getKey();
                            String str2 = (String) ((List) next.getValue()).get(0);
                            if (!(str == null || str2 == null)) {
                                hashMap.put(str, str2);
                            }
                        }
                        if (this.f17545O000000o.O0000Oo0 != null) {
                            this.f17545O000000o.O0000Oo0.O000000o(i, O000000o2, hashMap);
                        }
                        bufferedInputStream3 = new BufferedInputStream(httpURLConnection2.getInputStream(), 8192);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        bufferedInputStream = null;
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(gcv2.O00000Oo);
                        try {
                            byte[] bArr = new byte[8192];
                            boolean z = this.f17545O000000o.O0000Oo != null;
                            long j = 0;
                            long j2 = 0;
                            double d = 0.0d;
                            while (true) {
                                int read = bufferedInputStream3.read(bArr);
                                if (read == -1) {
                                    i2 = i;
                                    httpURLConnection3 = httpURLConnection2;
                                    bufferedInputStream2 = bufferedInputStream3;
                                    fileOutputStream2.flush();
                                    gcw2.O00000Oo = j2;
                                    fileOutputStream = fileOutputStream2;
                                    break;
                                } else if (!this.O00000Oo.get()) {
                                    bufferedInputStream = bufferedInputStream3;
                                    j2 += (long) read;
                                    if (z) {
                                        try {
                                            if (gcv2.O00000o > 0) {
                                                long currentTimeMillis = System.currentTimeMillis();
                                                int i8 = read;
                                                if (currentTimeMillis - j > ((long) gcv2.O00000o)) {
                                                    publishProgress(new long[]{O000000o2, j2});
                                                    j = currentTimeMillis;
                                                }
                                                i3 = i;
                                                httpURLConnection = httpURLConnection2;
                                                i5 = i8;
                                                i4 = 0;
                                                fileOutputStream2.write(bArr, i4, i5);
                                                gcv2 = gcv;
                                                i = i3;
                                                bufferedInputStream3 = bufferedInputStream;
                                                httpURLConnection2 = httpURLConnection;
                                            } else {
                                                i6 = read;
                                                if (gcv2.O00000oO <= 0.0f) {
                                                    publishProgress(new long[]{O000000o2, j2});
                                                    i3 = i;
                                                    httpURLConnection = httpURLConnection2;
                                                } else {
                                                    double d2 = (double) j2;
                                                    Double.isNaN(d2);
                                                    i3 = i;
                                                    httpURLConnection = httpURLConnection2;
                                                    double d3 = (double) O000000o2;
                                                    Double.isNaN(d3);
                                                    double round = (double) Math.round((d2 * 100.0d) / d3);
                                                    double d4 = (double) gcv2.O00000oO;
                                                    Double.isNaN(round);
                                                    Double.isNaN(d4);
                                                    if (round % d4 == 0.0d && (round != d || j2 == O000000o2)) {
                                                        gsy.O000000o(3, "Downloader", "EMIT: " + String.valueOf(round) + ", TOTAL:" + String.valueOf(j2));
                                                        publishProgress(new long[]{O000000o2, j2});
                                                        d = round;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                            }
                                            if (bufferedInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        httpURLConnection = httpURLConnection2;
                                        i6 = read;
                                        i3 = i;
                                    }
                                    i5 = i6;
                                    i4 = 0;
                                    fileOutputStream2.write(bArr, i4, i5);
                                    gcv2 = gcv;
                                    i = i3;
                                    bufferedInputStream3 = bufferedInputStream;
                                    httpURLConnection2 = httpURLConnection;
                                } else {
                                    HttpURLConnection httpURLConnection5 = httpURLConnection2;
                                    BufferedInputStream bufferedInputStream4 = bufferedInputStream3;
                                    throw new Exception("Download has been aborted");
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            httpURLConnection = httpURLConnection2;
                            bufferedInputStream = bufferedInputStream3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = httpURLConnection2;
                        bufferedInputStream = bufferedInputStream3;
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                try {
                    gcw2.f17544O000000o = i2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (fileOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection4;
                if (fileOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedInputStream = null;
            httpURLConnection = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static long O000000o(HttpURLConnection httpURLConnection) {
        if (Build.VERSION.SDK_INT >= 24) {
            return httpURLConnection.getContentLengthLong();
        }
        return (long) httpURLConnection.getContentLength();
    }
}
