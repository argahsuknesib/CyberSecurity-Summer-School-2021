package com.loc;

import _m_j.buq;
import _m_j.bur;
import _m_j.but;
import _m_j.buu;
import _m_j.buv;
import _m_j.buw;
import _m_j.bva;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public final class dq implements Callable {
    private static buq c = buq.O000000o();
    /* access modifiers changed from: private */
    public static Context d;

    /* renamed from: a  reason: collision with root package name */
    private String f4528a;
    private int b = 1;

    public dq(String str) {
        this.f4528a = str;
    }

    public static void a(Context context) {
        d = context;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0127 A[Catch:{ all -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0168 A[SYNTHETIC, Splitter:B:84:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0170 A[Catch:{ IOException -> 0x016c }] */
    /* renamed from: b */
    public String[] call() {
        BufferedReader bufferedReader;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        int i;
        try {
            if (!buv.O000000o()) {
                Thread thread = new Thread(new bva(this));
                thread.setUncaughtExceptionHandler(new buw());
                thread.start();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(40965);
            }
            buq.O00000Oo(this.f4528a);
            httpURLConnection = (HttpURLConnection) new URL("http://203.107.1.1:80/" + but.f13298O000000o + "/d?host=" + this.f4528a).openConnection();
            try {
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                if (httpURLConnection.getResponseCode() != 200) {
                    buu.O00000Oo("response code is " + httpURLConnection.getResponseCode() + " expect 200");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    buq.O00000o0(this.f4528a);
                    return but.O00000Oo;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    bufferedReader = null;
                    th = th3;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    buu.O000000o("resolve host: " + this.f4528a + ", return: " + sb.toString());
                    bur bur = new bur(sb.toString());
                    if (buq.O00000Oo() < 100) {
                        buq.O000000o(this.f4528a, bur);
                        buq.O00000o0(this.f4528a);
                        String[] strArr = bur.f13296O000000o;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                buu.O000000o(e);
                            }
                        }
                        bufferedReader.close();
                        return strArr;
                    }
                    throw new Exception("the total number of hosts is exceed 100");
                } catch (Throwable th4) {
                    th = th4;
                    buu.O000000o(th);
                    i = this.b;
                    this.b = i - 1;
                    if (i <= 0) {
                        String[] b2 = call();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                buu.O000000o(e2);
                                return b2;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return b2;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            buu.O000000o(e3);
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    buq.O00000o0(this.f4528a);
                    return but.O00000Oo;
                }
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
                inputStream = null;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            inputStream = null;
            bufferedReader = null;
            th = th6;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }
}
