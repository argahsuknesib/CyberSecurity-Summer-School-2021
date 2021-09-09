package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.push.providers.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class erf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static elr f15740O000000o = new elr(true);
    private static volatile int O00000Oo = -1;
    /* access modifiers changed from: private */
    public static final Object O00000o = new Object();
    private static long O00000o0 = System.currentTimeMillis();
    /* access modifiers changed from: private */
    public static List<O000000o> O00000oO = Collections.synchronizedList(new ArrayList());
    private static String O00000oo = "";
    private static a O0000O0o = null;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15741O000000o = "";
        public long O00000Oo = 0;
        public int O00000o = -1;
        public int O00000o0 = -1;
        public String O00000oO = "";
        public long O00000oo = 0;

        public O000000o(String str, long j, int i, int i2, String str2, long j2) {
            this.f15741O000000o = str;
            this.O00000Oo = j;
            this.O00000o0 = i;
            this.O00000o = i2;
            this.O00000oO = str2;
            this.O00000oo = j2;
        }
    }

    public static void O000000o(Context context) {
        O00000Oo = O00000o0(context);
    }

    public static synchronized void O000000o(String str) {
        synchronized (erf.class) {
            if (!esl.O00000oo() && !TextUtils.isEmpty(str)) {
                O00000oo = str;
            }
        }
    }

    public static int O00000Oo(Context context) {
        if (O00000Oo == -1) {
            O00000Oo = O00000o0(context);
        }
        return O00000Oo;
    }

    public static int O00000Oo(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static int O00000o0(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static synchronized String O00000o0() {
        synchronized (erf.class) {
            if (TextUtils.isEmpty(O00000oo)) {
                return "";
            }
            String str = O00000oo;
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9 A[SYNTHETIC] */
    public static void O000000o(Context context, String str, long j, boolean z, boolean z2, long j2) {
        long j3;
        int O00000Oo2;
        boolean isEmpty;
        boolean z3;
        Context context2 = context;
        int O00000Oo3 = O00000Oo(context);
        if (z && z2) {
            long j4 = O00000o0;
            O00000o0 = j2;
            if (j2 - j4 > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS && j > 1024) {
                j3 = 2 * j;
                long j5 = j3;
                if (context2 != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context.getPackageName()) && !"com.xiaomi.xmsf".equals(str) && -1 != (O00000Oo2 = O00000Oo(context))) {
                    synchronized (O00000o) {
                        isEmpty = O00000oO.isEmpty();
                        O000000o o000000o = new O000000o(str, j2, O00000Oo2, z ? 1 : 0, O00000Oo2 == 0 ? O00000o0() : "", j5);
                        Iterator<O000000o> it = O00000oO.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                O00000oO.add(o000000o);
                                break;
                            }
                            O000000o next = it.next();
                            if (TextUtils.equals(o000000o.f15741O000000o, next.f15741O000000o) && TextUtils.equals(o000000o.O00000oO, next.O00000oO) && o000000o.O00000o0 == next.O00000o0 && o000000o.O00000o == next.O00000o) {
                                if (Math.abs(o000000o.O00000Oo - next.O00000Oo) <= 5000) {
                                    z3 = true;
                                    continue;
                                    if (z3) {
                                        next.O00000oo += o000000o.O00000oo;
                                        break;
                                    }
                                }
                            }
                            z3 = false;
                            continue;
                            if (z3) {
                            }
                        }
                    }
                    if (isEmpty) {
                        f15740O000000o.O000000o(new erg(context), 5000);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        j3 = (((long) (O00000Oo3 == 0 ? 13 : 11)) * j) / 10;
        long j52 = j3;
        if (context2 != null) {
        }
    }

    static /* synthetic */ void O000000o(Context context, List list) {
        a aVar;
        try {
            synchronized (a.f6459O000000o) {
                if (O0000O0o != null) {
                    aVar = O0000O0o;
                } else {
                    a aVar2 = new a(context);
                    O0000O0o = aVar2;
                    aVar = aVar2;
                }
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        O000000o o000000o = (O000000o) it.next();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", o000000o.f15741O000000o);
                        contentValues.put("message_ts", Long.valueOf(o000000o.O00000Oo));
                        contentValues.put("network_type", Integer.valueOf(o000000o.O00000o0));
                        contentValues.put("bytes", Long.valueOf(o000000o.O00000oo));
                        contentValues.put("rcv", Integer.valueOf(o000000o.O00000o));
                        contentValues.put("imsi", o000000o.O00000oO);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            duv.O000000o(th);
        }
    }
}
