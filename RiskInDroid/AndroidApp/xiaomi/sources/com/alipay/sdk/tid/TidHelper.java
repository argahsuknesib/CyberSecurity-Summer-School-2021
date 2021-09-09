package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.data.b;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.c;
import org.json.JSONObject;

public class TidHelper {
    public static Tid loadTID(Context context) {
        a(context);
        Tid a2 = a(context, a.a(context));
        if (a2 == null) {
            c.a("mspl", "load_tid null");
        }
        return a2;
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        Tid loadTID;
        synchronized (TidHelper.class) {
            c.a("mspl", "load_create_tid");
            a(context);
            loadTID = loadTID(context);
            if (Tid.isEmpty(loadTID)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return null;
                }
                try {
                    loadTID = b(context);
                } catch (Throwable unused) {
                }
            }
        }
        return loadTID;
    }

    public static synchronized String getTIDValue(Context context) {
        synchronized (TidHelper.class) {
            Tid loadOrCreateTID = loadOrCreateTID(context);
            if (Tid.isEmpty(loadOrCreateTID)) {
                return "";
            }
            String tid = loadOrCreateTID.getTid();
            return tid;
        }
    }

    public static boolean resetTID(Context context) throws Exception {
        c.a("mspl", "reset_tid");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a(context);
            clearTID(context);
            Tid tid = null;
            try {
                tid = b(context);
            } catch (Throwable unused) {
            }
            return !Tid.isEmpty(tid);
        }
        throw new Exception("Must be called on worker thread");
    }

    public static void clearTID(Context context) {
        a.a(context).g();
    }

    public static String getIMEI(Context context) {
        a(context);
        return a.a(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return a.a(context).a();
    }

    public static String getVirtualImei(Context context) {
        a(context);
        b.b();
        return b.c();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        b.b();
        return b.d();
    }

    private static void a(Context context) {
        if (context != null) {
            com.alipay.sdk.sys.b.a().a(context);
        }
    }

    private static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.c().a(com.alipay.sdk.sys.a.a(), context);
            if (a2 != null) {
                JSONObject jSONObject = new JSONObject(a2.b());
                a a3 = a.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString("client_key");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                    a3.a(optString, string);
                }
                return a(context, a3);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static Tid a(Context context, a aVar) {
        if (aVar == null || aVar.e()) {
            return null;
        }
        return new Tid(aVar.a(), aVar.b(), aVar.i().longValue());
    }

    public static Tid loadLocalTid(Context context) {
        a a2 = a.a(context);
        if (a2.h()) {
            return null;
        }
        return new Tid(a2.a(), a2.b(), a2.i().longValue());
    }
}
