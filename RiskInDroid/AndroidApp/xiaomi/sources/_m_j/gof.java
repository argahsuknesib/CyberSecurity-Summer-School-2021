package _m_j;

import _m_j.goe;
import _m_j.gsk;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.json.JSONException;

public final class gof {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f18087O000000o = (O00000Oo + O00000o0 + O00000o);
    private static String O00000Oo = "8007236f-";
    private static String O00000o = "c49395ad6d65";
    private static String O00000o0 = "a2d6-4847-ac83-";
    private static OkHttpClient O00000oO = gse.O000000o();
    private static HashMap<String, String> O00000oo = new HashMap<>();

    public interface O00000o {
        void O000000o(long j, long j2);
    }

    public interface O00000o0<T> {
        T O000000o(String str) throws JSONException;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r5.O000000o(com.xiaomi.smarthome.frame.ErrorCode.INVALID.getCode());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003a */
    public static <T> void O000000o(String str, String str2, List<gkw> list, final Callback<T> callback, final Parser<T> parser) {
        final AnonymousClass2 r0 = new O00000o0<T>() {
            /* class _m_j.gof.AnonymousClass2 */

            public final T O000000o(String str) throws JSONException {
                Parser parser = parser;
                if (parser != null) {
                    return parser.parse(str);
                }
                return null;
            }
        };
        final AnonymousClass3 r5 = new ftt<T>() {
            /* class _m_j.gof.AnonymousClass3 */

            public final void O000000o(T t) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(t);
                }
            }

            public final void O000000o(int i) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, "");
                }
            }

            public final void O000000o(int i, Object obj) {
                String str;
                Callback callback = callback;
                if (callback != null) {
                    if (obj == null) {
                        str = "";
                    } else {
                        str = obj.toString();
                    }
                    callback.onFailure(i, str);
                }
            }
        };
        gsk O000000o2 = new gsk.O000000o().O000000o(str2).O00000Oo(str).O000000o(list).O000000o();
        if (Looper.myLooper() == null) {
            try {
                r5.O000000o(r0.O000000o((String) gsg.O000000o(O00000oO, O000000o2, new gsq())));
            } catch (Exception e) {
                r5.O000000o(ErrorCode.INVALID.getCode(), e.getMessage());
            }
        } else {
            try {
                gsg.O000000o(O00000oO, O000000o2, new gso() {
                    /* class _m_j.gof.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        O000000o((String) obj);
                    }

                    public final void O000000o(String str) {
                        Object obj = null;
                        try {
                            if (r0 != null) {
                                obj = r0.O000000o(str);
                            }
                            if (r5 != null) {
                                r5.O000000o(obj);
                            }
                        } catch (Exception e) {
                            ftt ftt = r5;
                            if (ftt != null) {
                                ftt.O000000o(ErrorCode.INVALID.getCode(), e.getMessage());
                            }
                        }
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        ftt ftt = r5;
                        if (ftt != null) {
                            ftt.O000000o(ErrorCode.INVALID.getCode());
                        }
                    }
                });
            } catch (Exception e2) {
                r5.O000000o(ErrorCode.INVALID.getCode(), e2.getMessage());
            }
        }
    }

    private static synchronized String O00000o() {
        synchronized (gof.class) {
        }
        return "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.7; rv:20.0) Gecko/20100101 Firefox/20.0";
    }

    private static void O000000o(HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
        httpURLConnection.setReadTimeout(15000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01da A[SYNTHETIC, Splitter:B:69:0x01da] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ec A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ed A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0216 A[SYNTHETIC, Splitter:B:81:0x0216] */
    public static byte[] O000000o(String str) {
        goe.O000000o o000000o;
        long j;
        Throwable th;
        byte[] bArr;
        boolean z;
        HttpURLConnection httpURLConnection;
        String str2 = str;
        long currentTimeMillis = System.currentTimeMillis();
        goe.O000000o o000000o2 = null;
        try {
            URL url = new URL(str2);
            String host = url.getHost();
            HttpURLConnection.setFollowRedirects(true);
            if (goe.O00000o(CommonApplication.getAppContext())) {
                try {
                    URL url2 = new URL(goe.O000000o(url));
                    dxx.O000000o();
                    httpURLConnection = (HttpURLConnection) dxx.O000000o(url2);
                    httpURLConnection.setRequestProperty("X-Online-Host", host);
                } catch (Exception e) {
                    e = e;
                    bArr = null;
                } catch (Throwable th2) {
                    th = th2;
                    o000000o = null;
                    j = 0;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis2 + "ms, download size = " + j);
                    if (o000000o != null) {
                        try {
                            o000000o.close();
                        } catch (IOException e2) {
                            gsy.O00000o0(LogType.NETWORK, "", e2.getMessage());
                        }
                    }
                    throw th;
                }
            } else {
                dxx.O000000o();
                httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            }
            CommonApplication.getAppContext();
            httpURLConnection.setRequestProperty("User-Agent", O00000o());
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            for (Map.Entry next : O00000oo.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            O000000o(httpURLConnection);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            gsy.O00000o0(LogType.NETWORK, "", "the response code is " + httpURLConnection.getHeaderFieldInt("content-length", -1) + ", connected in " + (System.currentTimeMillis() - currentTimeMillis));
            if (responseCode == -1) {
                gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, download size = 0");
                return null;
            }
            int contentLength = httpURLConnection.getContentLength();
            goe.O000000o o000000o3 = new goe.O000000o(httpURLConnection.getInputStream());
            try {
                gsy.O00000o0(LogType.NETWORK, "", "content bytes ".concat(String.valueOf(contentLength)));
                if (contentLength < 0) {
                    gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, download size = 0");
                    try {
                        o000000o3.close();
                    } catch (IOException e3) {
                        gsy.O00000o0(LogType.NETWORK, "", e3.getMessage());
                    }
                    return null;
                }
                byte[] bArr2 = new byte[contentLength];
                long j2 = 0;
                while (true) {
                    long j3 = (long) contentLength;
                    if (j2 >= j3) {
                        break;
                    }
                    try {
                        int read = o000000o3.read(bArr2, (int) j2, (int) (j3 - j2));
                        if (read == -1) {
                            break;
                        }
                        j2 += (long) read;
                    } catch (Exception e4) {
                        e = e4;
                        bArr = bArr2;
                        o000000o2 = o000000o3;
                        j = j2;
                        try {
                            gsy.O00000o0(LogType.NETWORK, "", "error to call url:" + str2 + " error:" + e.getMessage());
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                            gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis3 + "ms, download size = " + j);
                            if (o000000o2 != null) {
                            }
                            z = false;
                            if (!z) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            o000000o = o000000o2;
                            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                            gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis22 + "ms, download size = " + j);
                            if (o000000o != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        o000000o = o000000o3;
                        j = j2;
                        long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                        gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis222 + "ms, download size = " + j);
                        if (o000000o != null) {
                        }
                        throw th;
                    }
                }
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis4 + "ms, download size = " + j2);
                try {
                    o000000o3.close();
                } catch (IOException e5) {
                    gsy.O00000o0(LogType.NETWORK, "", e5.getMessage());
                }
                bArr = bArr2;
                z = true;
                if (!z) {
                    return bArr;
                }
                return null;
            } catch (Exception e6) {
                e = e6;
                o000000o2 = o000000o3;
                bArr = null;
                j = 0;
                gsy.O00000o0(LogType.NETWORK, "", "error to call url:" + str2 + " error:" + e.getMessage());
                long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis;
                gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis32 + "ms, download size = " + j);
                if (o000000o2 != null) {
                    try {
                        o000000o2.close();
                    } catch (IOException e7) {
                        gsy.O00000o0(LogType.NETWORK, "", e7.getMessage());
                    }
                }
                z = false;
                if (!z) {
                }
            } catch (Throwable th5) {
                th = th5;
                o000000o = o000000o3;
                j = 0;
                long currentTimeMillis2222 = System.currentTimeMillis() - currentTimeMillis;
                gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis2222 + "ms, download size = " + j);
                if (o000000o != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            bArr = null;
            o000000o2 = null;
            j = 0;
            gsy.O00000o0(LogType.NETWORK, "", "error to call url:" + str2 + " error:" + e.getMessage());
            long currentTimeMillis322 = System.currentTimeMillis() - currentTimeMillis;
            gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis322 + "ms, download size = " + j);
            if (o000000o2 != null) {
            }
            z = false;
            if (!z) {
            }
        } catch (Throwable th6) {
            th = th6;
            j = 0;
            o000000o = null;
            long currentTimeMillis22222 = System.currentTimeMillis() - currentTimeMillis;
            gsy.O00000o0(LogType.NETWORK, "", "http downloadFile to " + str2 + " cost " + currentTimeMillis22222 + "ms, download size = " + j);
            if (o000000o != null) {
            }
            throw th;
        }
    }

    public static boolean O000000o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static boolean O00000Oo() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean O00000o0() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f18091O000000o;
        public int O00000Oo;
        public Exception O00000o;
        public int O00000o0;

        public O000000o(int i, int i2, int i3, Exception exc) {
            this.f18091O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            this.O00000o = exc;
        }
    }

    public static class O00000Oo extends AsyncTask<Object, Long, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18092O000000o;
        File O00000Oo;
        O000000o O00000o;
        Context O00000o0;

        public interface O000000o {
            void O000000o();

            void O00000Oo();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            O000000o o000000o = (O000000o) obj;
            if (o000000o == null || o000000o.O00000Oo != 3) {
                O000000o o000000o2 = this.O00000o;
                if (o000000o2 != null) {
                    o000000o2.O00000Oo();
                    return;
                }
                return;
            }
            O000000o o000000o3 = this.O00000o;
            if (o000000o3 != null) {
                o000000o3.O000000o();
            }
        }

        public O00000Oo(Context context, String str, File file, O000000o o000000o) {
            this.f18092O000000o = str;
            this.O00000Oo = file;
            this.O00000o0 = context;
            this.O00000o = o000000o;
        }

        private O000000o O000000o() {
            if (isCancelled()) {
                return null;
            }
            try {
                return gof.O000000o(this.O00000o0, this.f18092O000000o, this.O00000Oo, null);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0254, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0255, code lost:
        _m_j.gsy.O00000o0(com.xiaomi.smarthome.library.log.LogType.NETWORK, r10, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0265, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0266, code lost:
        _m_j.gsy.O00000o0(com.xiaomi.smarthome.library.log.LogType.NETWORK, r10, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02b5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02b6, code lost:
        _m_j.gsy.O00000o0(com.xiaomi.smarthome.library.log.LogType.NETWORK, r10, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02c7, code lost:
        _m_j.gsy.O00000o0(com.xiaomi.smarthome.library.log.LogType.NETWORK, r10, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ef, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0200, code lost:
        r8 = r0;
        r6 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0250 A[SYNTHETIC, Splitter:B:106:0x0250] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0261 A[SYNTHETIC, Splitter:B:111:0x0261] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02b1 A[SYNTHETIC, Splitter:B:130:0x02b1] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02c2 A[SYNTHETIC, Splitter:B:135:0x02c2] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0027] */
    public static O000000o O000000o(Context context, String str, File file, O00000o o00000o) {
        goe.O000000o o000000o;
        FileOutputStream fileOutputStream;
        Throwable th;
        boolean z;
        IOException iOException;
        int i;
        long j;
        long j2;
        IOException iOException2;
        long j3;
        HttpURLConnection httpURLConnection;
        String str2;
        goe.O000000o o000000o2;
        goe.O000000o o000000o3;
        goe.O000000o o000000o4;
        goe.O000000o o000000o5;
        int i2;
        String str3 = str;
        O00000o o00000o2 = o00000o;
        String str4 = "";
        if ((!Environment.getExternalStorageState().equals("mounted")) || !goe.O00000oO(context)) {
            gsy.O00000o0(LogType.NETWORK, str4, "downloadFile isSDCardBusy:" + Environment.getExternalStorageState() + "  hasNetwork:" + goe.O00000oO(context));
            return new O000000o(0, 2, 0, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            URL url = new URL(str3);
            String host = url.getHost();
            HttpURLConnection.setFollowRedirects(true);
            if (goe.O00000o(context)) {
                URL url2 = new URL(goe.O000000o(url));
                dxx.O000000o();
                httpURLConnection = (HttpURLConnection) dxx.O000000o(url2);
                httpURLConnection.setRequestProperty("X-Online-Host", host);
            } else {
                dxx.O000000o();
                httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            }
            httpURLConnection.setRequestProperty("User-Agent", O00000o());
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            file.length();
            O000000o(httpURLConnection);
            httpURLConnection.connect();
            i = httpURLConnection.getResponseCode();
            gsy.O00000o0(LogType.NETWORK, str4, "the response code is " + i + ", connected in " + (System.currentTimeMillis() - currentTimeMillis));
            int i3 = -1;
            if (i == -1) {
                O000000o o000000o6 = new O000000o(-1, 2, 0, null);
                gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                return o000000o6;
            }
            int contentLength = httpURLConnection.getContentLength();
            if (o00000o2 != null) {
                str2 = str4;
                try {
                    o00000o2.O000000o(0, (long) contentLength);
                } catch (IOException e) {
                    iOException2 = e;
                    j3 = 0;
                    str4 = str2;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    str4 = str2;
                    fileOutputStream = null;
                    o000000o = null;
                    gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                    if (o000000o != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } else {
                str2 = str4;
            }
            try {
                o000000o2 = new goe.O000000o(httpURLConnection.getInputStream());
                try {
                    str4 = str2;
                } catch (IOException e2) {
                    e = e2;
                    o000000o3 = o000000o2;
                    str4 = str2;
                    iOException = e;
                    o000000o = o000000o3;
                    fileOutputStream = null;
                    j2 = 0;
                    try {
                        gsy.O00000o0(LogType.NETWORK, str4, "error to call url:" + str3 + " error:" + iOException.getMessage());
                        gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                        if (o000000o != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        j = j2;
                        z = false;
                        file.getAbsolutePath();
                        return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
                    } catch (Throwable th3) {
                        th = th3;
                        gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                        if (o000000o != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    o000000o4 = o000000o2;
                    str4 = str2;
                    th = th;
                    o000000o = o000000o4;
                    fileOutputStream = null;
                    gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                    if (o000000o != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                str4 = str2;
                iOException2 = e;
                fileOutputStream = null;
                j3 = 0;
                o000000o = null;
                gsy.O00000o0(LogType.NETWORK, str4, "error to call url:" + str3 + " error:" + iOException.getMessage());
                gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                if (o000000o != null) {
                }
                if (fileOutputStream != null) {
                }
                j = j2;
                z = false;
                file.getAbsolutePath();
                return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
            } catch (Throwable th5) {
                th = th5;
                str4 = str2;
                th = th;
                fileOutputStream = null;
                o000000o = null;
                gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                if (o000000o != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                gsy.O00000o0(LogType.NETWORK, str4, "content bytes ".concat(String.valueOf(contentLength)));
                byte[] bArr = new byte[10240];
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    j2 = 0;
                    while (true) {
                        try {
                            int read = o000000o2.read(bArr);
                            if (read == i3) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            int i4 = i;
                            long j4 = j2 + ((long) read);
                            if (o00000o2 != null) {
                                o000000o5 = o000000o2;
                                try {
                                    o00000o2.O000000o(j4, (long) contentLength);
                                } catch (IOException e4) {
                                    iOException = e4;
                                    j2 = j4;
                                    i = i4;
                                } catch (Throwable th6) {
                                    th = th6;
                                    th = th;
                                    o000000o = o000000o5;
                                    gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                                    if (o000000o != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                o000000o5 = o000000o2;
                            }
                            j2 = j4;
                            i = i4;
                            o000000o2 = o000000o5;
                            i3 = -1;
                        } catch (IOException e5) {
                            o000000o5 = o000000o2;
                            iOException = e5;
                            o000000o = o000000o5;
                            gsy.O00000o0(LogType.NETWORK, str4, "error to call url:" + str3 + " error:" + iOException.getMessage());
                            gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                            if (o000000o != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            j = j2;
                            z = false;
                            file.getAbsolutePath();
                            return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
                        } catch (Throwable th7) {
                            th = th7;
                            o000000o5 = o000000o2;
                            th = th;
                            o000000o = o000000o5;
                            gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                            if (o000000o != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                    i2 = i;
                    goe.O000000o o000000o7 = o000000o2;
                    gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                    try {
                        o000000o7.close();
                    } catch (IOException e6) {
                        gsy.O00000o0(LogType.NETWORK, str4, e6.getMessage());
                    }
                } catch (IOException e7) {
                    e = e7;
                    o000000o3 = o000000o2;
                    iOException = e;
                    o000000o = o000000o3;
                    fileOutputStream = null;
                    j2 = 0;
                    gsy.O00000o0(LogType.NETWORK, str4, "error to call url:" + str3 + " error:" + iOException.getMessage());
                    gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                    if (o000000o != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    j = j2;
                    z = false;
                    file.getAbsolutePath();
                    return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
                } catch (Throwable th8) {
                    th = th8;
                    o000000o4 = o000000o2;
                    th = th;
                    o000000o = o000000o4;
                    fileOutputStream = null;
                    gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                    if (o000000o != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                o000000o3 = o000000o2;
                iOException = e;
                o000000o = o000000o3;
                fileOutputStream = null;
                j2 = 0;
                gsy.O00000o0(LogType.NETWORK, str4, "error to call url:" + str3 + " error:" + iOException.getMessage());
                gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                if (o000000o != null) {
                }
                if (fileOutputStream != null) {
                }
                j = j2;
                z = false;
                file.getAbsolutePath();
                return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
            } catch (Throwable th9) {
                th = th9;
                o000000o4 = o000000o2;
                th = th;
                o000000o = o000000o4;
                fileOutputStream = null;
                gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
                if (o000000o != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                fileOutputStream.close();
                j = j2;
                i = i2;
                iOException = null;
                z = true;
            } catch (IOException e9) {
                gsy.O00000o0(LogType.NETWORK, str4, e9.getMessage());
                j = j2;
                i = i2;
                iOException = null;
                z = false;
                file.getAbsolutePath();
                return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
            }
            if (o00000o2 != null && z) {
                file.getAbsolutePath();
            }
            return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
        } catch (IOException e10) {
            e = e10;
            iOException2 = e;
            fileOutputStream = null;
            j3 = 0;
            o000000o = null;
            gsy.O00000o0(LogType.NETWORK, str4, "error to call url:" + str3 + " error:" + iOException.getMessage());
            gsy.O00000o0(LogType.NETWORK, str4, "http downloadFile to " + str3 + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, total size = " + file.length());
            if (o000000o != null) {
            }
            if (fileOutputStream != null) {
            }
            j = j2;
            z = false;
            file.getAbsolutePath();
            return new O000000o(i, !z ? 3 : 2, (int) j, iOException);
        } catch (Throwable th10) {
        }
    }
}
