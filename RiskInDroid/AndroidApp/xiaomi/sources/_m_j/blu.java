package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class blu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HandlerThread f13077O000000o = null;
    private static Handler O00000Oo = null;
    private static boolean O00000o = true;
    private static boolean O00000o0 = false;
    private static String O00000oO = "";
    /* access modifiers changed from: private */
    public static String O00000oo;

    public static void O000000o(String str) {
        O00000oo = str;
    }

    public static void O000000o(Throwable th) {
        try {
            Context context = blw.f13081O000000o;
            String str = "";
            if (context != null) {
                str = context.getPackageName();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sdkver", "2.9.4");
            hashMap.put("model", Build.MODEL);
            hashMap.put("osver", Build.VERSION.RELEASE);
            hashMap.put("org", O00000oO);
            hashMap.put("appId", str);
            hashMap.put("e", O00000Oo(th));
            O000000o(hashMap);
        } catch (Throwable unused) {
        }
    }

    private static void O000000o(final Map<String, String> map) {
        if (O00000o) {
            if (!O00000o0) {
                synchronized (blu.class) {
                    if (!O00000o0) {
                        HandlerThread handlerThread = new HandlerThread("exception upload thread");
                        f13077O000000o = handlerThread;
                        handlerThread.setDaemon(true);
                        f13077O000000o.start();
                        O00000Oo = new Handler(f13077O000000o.getLooper());
                        O00000o0 = true;
                    }
                }
            }
            if (map.size() != 0) {
                O00000Oo.post(new Runnable() {
                    /* class _m_j.blu.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3 A[SYNTHETIC, Splitter:B:27:0x00a3] */
                    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9 A[SYNTHETIC, Splitter:B:31:0x00a9] */
                    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
                    public final void run() {
                        HttpURLConnection httpURLConnection = null;
                        try {
                            StringBuilder sb = new StringBuilder(blu.O00000oo);
                            for (Map.Entry entry : map.entrySet()) {
                                String str = (String) entry.getValue();
                                if (str == null) {
                                    str = "";
                                }
                                sb.append("&");
                                sb.append((String) entry.getKey());
                                sb.append("=");
                                sb.append(bne.O00000oO(str));
                            }
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
                            try {
                                httpURLConnection2.setRequestMethod("GET");
                                httpURLConnection2.setRequestProperty("Connection", "close");
                                httpURLConnection2.setRequestProperty("Content-Type", "application/octet-stream");
                                httpURLConnection2.setConnectTimeout(2000);
                                httpURLConnection2.setReadTimeout(5000);
                                bmz.O00000Oo("ExceptionTracker", "response %d", Integer.valueOf(httpURLConnection2.getResponseCode()));
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (Exception unused) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                httpURLConnection = httpURLConnection2;
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bmz.O00000Oo("ExceptionTracker", "upload failed", new Object[0]);
                            bmz.O000000o(th);
                            if (httpURLConnection == null) {
                            }
                        }
                    }
                });
            }
        }
    }

    public static void O000000o(boolean z) {
        O00000o = z;
    }

    private static String O00000Oo(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            while (true) {
                th.printStackTrace(printWriter);
                th = th.getCause();
                if (th == null) {
                    break;
                }
            }
            printWriter.close();
            String obj = stringWriter.toString();
            return obj.length() > 4096 ? obj.substring(0, 4096) : obj;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void O00000Oo(String str) {
        O00000oO = str;
    }
}
