package com.weibo.ssosdk;

import _m_j.dtq;
import _m_j.dtr;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class WeiboSsoSdk {
    private static WeiboSsoSdk O00000o;
    private static dtr O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f5931O000000o = true;
    public O000000o O00000Oo;
    private volatile ReentrantLock O00000o0 = new ReentrantLock(true);
    private int O00000oo;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        dtr dtr = O00000oO;
        if (dtr == null || !dtr.O00000Oo()) {
            throw new Exception("config error");
        }
        this.O00000oo = 0;
        new Thread(new Runnable() {
            /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass1 */

            public final void run() {
                String str;
                while (true) {
                    try {
                        Thread.sleep(86400000);
                        if (WeiboSsoSdk.this.O00000Oo == null || TextUtils.isEmpty(WeiboSsoSdk.this.O00000Oo.f5936O000000o)) {
                            str = WeiboSsoSdk.O00000o();
                        } else {
                            str = WeiboSsoSdk.this.O00000Oo.f5936O000000o;
                        }
                        WeiboSsoSdk.O000000o().O000000o(str, 2);
                    } catch (Exception unused) {
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass2 */

            public final void run() {
                String str;
                try {
                    Thread.sleep(60000);
                    if (WeiboSsoSdk.this.f5931O000000o) {
                        if (WeiboSsoSdk.this.O00000Oo == null || TextUtils.isEmpty(WeiboSsoSdk.this.O00000Oo.f5936O000000o)) {
                            str = WeiboSsoSdk.O00000o();
                        } else {
                            str = WeiboSsoSdk.this.O00000Oo.f5936O000000o;
                        }
                        WeiboSsoSdk.this.O000000o(str, 2);
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public static synchronized boolean O000000o(dtr dtr) {
        synchronized (WeiboSsoSdk.class) {
            if (!dtr.O00000Oo()) {
                return false;
            }
            if (O00000oO != null) {
                return false;
            }
            O00000oO = (dtr) dtr.clone();
            return true;
        }
    }

    public static synchronized WeiboSsoSdk O000000o() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (O00000o == null) {
                O00000o = new WeiboSsoSdk();
            }
            weiboSsoSdk = O00000o;
        }
        return weiboSsoSdk;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5936O000000o;
        private String O00000Oo;

        static O000000o O000000o(String str) throws Exception {
            O000000o o000000o = new O000000o();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                o000000o.f5936O000000o = jSONObject2.optString("aid", "");
                o000000o.O00000Oo = jSONObject2.optString("sub", "");
                return o000000o;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static String O000000o(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final void O000000o(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(O00000oO.O000000o(false))) {
            if (!this.O00000o0.tryLock()) {
                this.O00000o0.lock();
                this.O00000o0.unlock();
                return;
            }
            this.f5931O000000o = false;
            String O000000o2 = dtq.O000000o(O00000oO.f14937O000000o);
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                str2 = "";
            }
            String O000000o3 = O000000o(riseWind(O00000oO.O000000o(true), O00000oO.f14937O000000o.getPackageName(), str2, O000000o2, dtr.O000000o(O00000oO.O00000o), dtr.O000000o(O00000oO.O00000oo), dtr.O000000o(O00000oO.O00000oO), dtr.O000000o(O00000oO.O0000O0o), dtr.O000000o(O00000oO.O00000o0), O00000oO.O000000o(), i, this.O00000oo));
            this.O00000oo++;
            if (O000000o3 != null) {
                try {
                    O000000o O000000o4 = O000000o.O000000o(O000000o3);
                    if (!TextUtils.isEmpty(O000000o4.f5936O000000o)) {
                        O00000Oo(O000000o4.f5936O000000o);
                    }
                    if (i == 1) {
                        this.O00000Oo = O000000o4;
                    }
                    this.O00000o0.unlock();
                } catch (Exception e) {
                    Exception exc = e;
                    this.O00000o0.unlock();
                    throw exc;
                }
            } else {
                this.O00000o0.unlock();
                throw new Exception("network error.");
            }
        }
    }

    public final O000000o O00000Oo() throws Exception {
        if (this.O00000Oo == null) {
            Thread thread = new Thread(new Runnable() {
                /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass3 */

                public final void run() {
                    try {
                        WeiboSsoSdk.this.O000000o("", 1);
                    } catch (Exception unused) {
                    }
                }
            });
            thread.start();
            thread.join();
        }
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            return o000000o;
        }
        throw new Exception("visitor login failed");
    }

    public final String O00000o0() throws Exception {
        String O00000o2 = O00000o();
        if (!TextUtils.isEmpty(O00000o2)) {
            return O00000o2;
        }
        O000000o o000000o = this.O00000Oo;
        if (o000000o == null || TextUtils.isEmpty(o000000o.f5936O000000o)) {
            Thread thread = new Thread(new Runnable() {
                /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass4 */

                public final void run() {
                    try {
                        WeiboSsoSdk.this.O000000o("", 1);
                    } catch (Exception unused) {
                    }
                }
            });
            thread.start();
            thread.join();
        }
        O000000o o000000o2 = this.O00000Oo;
        if (o000000o2 != null) {
            return o000000o2.f5936O000000o;
        }
        throw new Exception("visitor login failed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[SYNTHETIC, Splitter:B:15:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b A[SYNTHETIC, Splitter:B:21:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static String O00000o() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(O00000oO());
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            if (fileInputStream2 != null) {
                return "";
            }
            try {
                fileInputStream2.close();
                return "";
            } catch (IOException unused4) {
                return "";
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static File O00000oO() {
        return new File(O00000oO.f14937O000000o.getFilesDir(), new StringBuilder("weibo_sso_sdk_aid1").toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|(0)|26|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x002c */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0029 A[SYNTHETIC, Splitter:B:24:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x002f A[SYNTHETIC, Splitter:B:30:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0036 A[DONT_GENERATE] */
    private synchronized void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(O00000oO());
                try {
                    fileOutputStream2.write(str.getBytes());
                    try {
                        fileOutputStream2.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException unused4) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } else {
            return;
        }
    }
}
