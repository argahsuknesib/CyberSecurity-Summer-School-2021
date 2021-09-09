package _m_j;

import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class gsy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f18226O000000o = new Object();
    public static List<gsx> O00000Oo = new ArrayList();
    private static final ThreadPoolExecutor O00000o;
    private static final int O00000o0 = Runtime.getRuntime().availableProcessors();
    private static volatile gsz O00000oO = null;

    static {
        int max = Math.max(5, O00000o0);
        O00000o = new ThreadPoolExecutor(max, Math.max(5, O00000o0), 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue((int) NotificationCompat.FLAG_HIGH_PRIORITY), Executors.defaultThreadFactory());
    }

    public static void O000000o(gsz gsz) {
        O00000oO = gsz;
        O00000o.execute(new Runnable() {
            /* class _m_j.gsy.AnonymousClass1 */

            public final void run() {
                synchronized (gsy.f18226O000000o) {
                    if (gsy.O00000Oo.size() > 0) {
                        for (gsx next : gsy.O00000Oo) {
                            String str = "delayTime(" + (System.currentTimeMillis() - next.O0000O0o) + "ms) " + next.O00000oo;
                            int i = next.f18225O000000o;
                            if (i == 1) {
                                gsy.O000000o(next.O00000o, next.O00000oO, str);
                            } else if (i == 2) {
                                gsy.O000000o(next.O00000Oo, next.O00000o0, next.O00000oO, str);
                            } else if (i == 3) {
                                gsy.O00000Oo(next.O00000Oo, next.O00000o0, next.O00000oO, str);
                            } else if (i == 4) {
                                gsy.O00000o0(next.O00000Oo, next.O00000o0, next.O00000oO, str);
                            }
                        }
                        gsy.O00000Oo.clear();
                    }
                }
            }
        });
    }

    public static void O000000o(String str, String str2) {
        if (O00000oO == null) {
            return;
        }
        if (O00000oO.O000000o() || O00000oO.O00000Oo()) {
            O00000o0(3, str, str2 + " " + Log.getStackTraceString(new Throwable()));
        }
    }

    private static int O00000o0(int i, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (O00000oO == null) {
            synchronized (f18226O000000o) {
                if (O00000Oo.size() > 200) {
                    O00000Oo.clear();
                }
                O00000Oo.add(new gsx(i, str, str2));
            }
            return 0;
        } else if (!O00000oO.O000000o() && !O00000oO.O00000Oo()) {
            return 0;
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "MiJiaLog";
            } else if (str.length() > 23) {
                str = str.substring(0, 23);
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                str3 = "main:";
            } else {
                str3 = Thread.currentThread().getId() + ":";
            }
            String str4 = str3 + str2;
            int length = str4.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 <= length / 2000) {
                int i4 = i2 * 2000;
                i2++;
                int min = Math.min(length, i2 * 2000);
                if (min < 0 || i4 >= min) {
                    return 0;
                }
                String substring = str4.substring(i4, min);
                if (i == 2) {
                    i3 = Log.v(str, substring);
                } else if (i == 3) {
                    i3 = Log.d(str, substring);
                } else if (i == 4) {
                    i3 = Log.i(str, substring);
                } else if (i == 5) {
                    i3 = Log.w(str, substring);
                } else if (i == 6) {
                    i3 = Log.e(str, substring);
                }
            }
            return i3;
        }
    }

    public static int O000000o(int i, String str, String str2) {
        return O00000o0(i, str, str2);
    }

    public static void O000000o(LogType logType, String str, String str2) {
        O000000o(logType, "", str, str2);
    }

    public static void O000000o(LogType logType, String str, String str2, String str3) {
        if (O00000oO == null) {
            synchronized (f18226O000000o) {
                if (O00000Oo.size() > 200) {
                    O00000Oo.clear();
                }
                O00000Oo.add(new gsx(2, logType, str, str2, str3));
            }
        } else if (O00000oO.O00000oO() || O00000oO.O000000o() || O00000oO.O00000Oo()) {
            O00000Oo(logType, str, 3, str2, str3);
        }
    }

    public static void O00000Oo(LogType logType, String str, String str2) {
        O00000Oo(logType, "", str, str2);
    }

    public static void O00000Oo(LogType logType, String str, String str2, String str3) {
        if (O00000oO == null) {
            synchronized (f18226O000000o) {
                if (O00000Oo.size() > 200) {
                    O00000Oo.clear();
                }
                O00000Oo.add(new gsx(3, logType, str, str2, str3));
            }
        } else if (O00000oO.O00000oO() || O00000oO.O000000o() || O00000oO.O00000Oo() || O00000oO.O00000o0() || O00000oO.O00000o()) {
            O00000Oo(logType, str, 3, str2, str3);
        }
    }

    public static void O00000o0(LogType logType, String str, String str2) {
        O00000o0(logType, "", str, str2);
    }

    public static void O00000o0(LogType logType, String str, String str2, String str3) {
        O000000o(logType, str, 3, str2, str3);
    }

    public static void O000000o(LogType logType, String str, int i, String str2, String str3) {
        if (O00000oO == null) {
            synchronized (f18226O000000o) {
                if (O00000Oo.size() > 200) {
                    O00000Oo.clear();
                }
                O00000Oo.add(new gsx(4, logType, str, str2, str3));
            }
            return;
        }
        O00000Oo(logType, str, i, str2, str3);
    }

    public static void O00000Oo(int i, String str, String str2) {
        try {
            O00000o0(LogType.LOG_ANALYSIS, String.valueOf(i), new JSONObject().put("code", str).put("msg", str2).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void O00000Oo(LogType logType, String str, int i, String str2, String str3) {
        if (logType == null) {
            Log.e("MiJiaLog", "logType is null");
        } else if (LogType.ILLEGAL_TYPE == logType) {
            Log.e("MiJiaLog", "logType is illegal");
        } else if (TextUtils.isEmpty(str3)) {
            Log.e("MiJiaLog", "message is empty");
        } else if (O00000oO == null) {
            Log.e("MiJiaLog", "writeLog failed, log adapter is null");
        } else {
            O00000o0(i, str2, str3);
            O00000oO.O000000o(logType.value(), str, str2, str3);
        }
    }

    public static void O000000o() {
        if (O00000oO == null) {
            Log.e("MiJiaLog", "flushLog failed, log adapter is null");
        } else {
            O00000oO.O00000oo();
        }
    }

    public static int O00000Oo(String str, String str2) {
        return O00000o0(3, str, str2);
    }
}
