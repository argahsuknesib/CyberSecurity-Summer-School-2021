package _m_j;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.dj;
import java.lang.Thread;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class eny {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile eny f15662O000000o;
    /* access modifiers changed from: private */
    public static ThreadPoolExecutor O00000Oo = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private Context O00000o;
    /* access modifiers changed from: private */
    public final Object O00000o0 = new Object();
    private Thread.UncaughtExceptionHandler O00000oO;
    private dj O00000oo;

    private eny(Context context) {
        this.O00000o = context.getApplicationContext();
        this.O00000oO = Thread.getDefaultUncaughtExceptionHandler();
        this.O00000oo = new dj(context);
        Thread.setDefaultUncaughtExceptionHandler(new enz(this));
    }

    /* access modifiers changed from: private */
    public void O000000o(Thread thread, Throwable th) {
        if (this.O00000oO != null) {
            duv.O00000Oo("scr dispatch to " + this.O00000oO);
            this.O00000oO.uncaughtException(thread, th);
            return;
        }
        duv.O000000o("scr kill process " + Process.myPid());
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    private static eny O00000Oo(Context context) {
        if (f15662O000000o == null) {
            synchronized (eny.class) {
                if (f15662O000000o == null) {
                    f15662O000000o = new eny(context);
                }
            }
        }
        return f15662O000000o;
    }

    public static void O000000o(Context context) {
        if (context == null || esl.O000000o(context)) {
            duv.O00000Oo("scr the conditions are not met");
            return;
        }
        try {
            eny O00000Oo2 = O00000Oo(context);
            duv.O000000o("scr init in " + Process.myPid());
            O00000Oo.execute(new eob(O00000Oo2));
        } catch (Throwable th) {
            duv.O000000o("scr init error ".concat(String.valueOf(th)));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036 A[Catch:{ Throwable -> 0x00d1, Throwable -> 0x00f4 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A[Catch:{ Throwable -> 0x00d1, Throwable -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090 A[Catch:{ Throwable -> 0x00d1, Throwable -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3 A[Catch:{ Throwable -> 0x00d1, Throwable -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[Catch:{  }, RETURN, SYNTHETIC] */
    public void O00000Oo() {
        String str;
        emd O00000Oo2;
        int i;
        String str2;
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.O00000oo.O00000Oo.getLong("k_t", 0);
            boolean z = false;
            if (currentTimeMillis < 180000) {
                str2 = "scr not rep because time ".concat(String.valueOf(currentTimeMillis));
            } else if (!emf.O00000o(this.O00000o)) {
                str2 = "scr not rep because net is other";
            } else {
                z = true;
                if (!z) {
                    JSONArray O000000o2 = this.O00000oo.O000000o(true);
                    if (O000000o2 != null) {
                        if (O000000o2.length() > 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("report", O000000o2.toString());
                            Context context = this.O00000o;
                            if (elk.f15608O000000o && esu.O00000Oo(this.O00000o)) {
                                str = est.O000000o("log.tag.debug.sdk.cr", "");
                                if (!TextUtils.isEmpty(str)) {
                                    duv.O000000o("[debug] scr rep url：".concat(String.valueOf(str)));
                                    O00000Oo2 = emf.O00000Oo(context, str, hashMap);
                                    i = -1;
                                    if (O00000Oo2 != null) {
                                        i = O00000Oo2.f15623O000000o;
                                    }
                                    duv.O00000Oo("scr response code ".concat(String.valueOf(i)));
                                    if (i != 200) {
                                        int i2 = new JSONObject(O00000Oo2.O00000o0).getInt("code");
                                        if (i2 == 0) {
                                            dj djVar = this.O00000oo;
                                            duv.O00000Oo("scr delete");
                                            djVar.O00000Oo.edit().remove("k_e").putLong("k_t", System.currentTimeMillis()).commit();
                                            return;
                                        }
                                        duv.O00000Oo("scr error code ".concat(String.valueOf(i2)));
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = eoc.O00000o0() ? "https://api.xmpush.xiaomi.com/v1/trace/report/sdk" : null;
                            O00000Oo2 = emf.O00000Oo(context, str, hashMap);
                            i = -1;
                            if (O00000Oo2 != null) {
                            }
                            duv.O00000Oo("scr response code ".concat(String.valueOf(i)));
                            if (i != 200) {
                            }
                        }
                    }
                    duv.O00000Oo("scr no data to rep");
                    return;
                }
                return;
            }
            duv.O00000Oo(str2);
            if (!z) {
            }
        } catch (Throwable th) {
            duv.O000000o("scr rep error ".concat(String.valueOf(th)));
        }
    }

    static /* synthetic */ void O000000o(eny eny, Thread thread, Throwable th, int i) {
        try {
            if (!(eoc.O00000Oo(eny.O00000o) && eoc.O00000o0())) {
                duv.O000000o("scr not enabled, dispatch this ex");
                eny.O000000o(thread, th);
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (!eoc.O00000Oo(stackTraceString)) {
                duv.O000000o("scr not found, dispatch this ex");
                eny.O000000o(thread, th);
                return;
            }
            dj djVar = eny.O00000oo;
            String O00000o02 = eoc.O00000o0(stackTraceString);
            JSONArray O000000o2 = djVar.O000000o(false);
            if (O000000o2.length() >= 20) {
                duv.O000000o("scr too max count, ignore this ex");
            } else {
                JSONObject jSONObject = null;
                int i2 = 0;
                while (true) {
                    if (i2 >= O000000o2.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = O000000o2.getJSONObject(i2);
                    if (O00000o02.equalsIgnoreCase(jSONObject2.optString(enx.O0000OOo, ""))) {
                        jSONObject2.put(enx.O0000Oo0, jSONObject2.optInt(enx.O0000Oo0, 1) + 1);
                        jSONObject2.put(enx.O0000Ooo, System.currentTimeMillis());
                        duv.O00000Oo("scr update");
                        jSONObject = jSONObject2;
                        break;
                    }
                    i2++;
                }
                if (jSONObject == null) {
                    duv.O00000Oo("scr insert");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(enx.f15661O000000o, 40020);
                    jSONObject3.put(enx.O00000Oo, eoc.O000000o(djVar.f6373O000000o));
                    jSONObject3.put(enx.O00000o0, eoc.O00000Oo());
                    jSONObject3.put(enx.O00000o, eoc.O000000o());
                    jSONObject3.put(enx.O00000oo, 0);
                    jSONObject3.put(enx.O0000O0o, i);
                    jSONObject3.put(enx.O0000OOo, O00000o02);
                    jSONObject3.put(enx.O0000Oo0, 1);
                    jSONObject3.put(enx.O0000Oo, eoc.O000000o(O00000o02));
                    jSONObject3.put(enx.O0000OoO, System.currentTimeMillis());
                    jSONObject3.put(enx.O0000Ooo, System.currentTimeMillis());
                    O000000o2.put(jSONObject3);
                }
                djVar.O00000Oo.edit().putString("k_e", O000000o2.toString()).commit();
            }
            eny.O00000Oo();
            eny.O000000o(thread, th);
        } catch (Throwable unused) {
            try {
                duv.O000000o("scr handle error ".concat(String.valueOf(th)));
            } finally {
                eny.O000000o(thread, th);
            }
        }
    }
}
