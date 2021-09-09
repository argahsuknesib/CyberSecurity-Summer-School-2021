package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class azj {
    private static final int[] O0000OOo = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static int O0000Oo = 0;
    private static final int[] O0000Oo0 = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static String O0000OoO;
    private static boolean O0000Ooo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f12735O000000o;
    List<azs> O00000Oo;
    public String O00000o;
    public List<azo> O00000o0;
    public String O00000oO;
    String O00000oo;
    public azv O0000O0o;
    private final Object O0000o00;

    private azj() {
        this.O0000o00 = new Object();
        this.O00000Oo = new ArrayList();
        this.O00000o0 = new ArrayList();
        this.O00000oo = null;
        synchronized (azj.class) {
            if (O0000Oo <= 0) {
                O0000Oo++;
            } else {
                throw new RuntimeException("PushManager can't create again!");
            }
        }
        O000000o(new azl());
        O000000o(new azp());
        O000000o(new azm());
        O000000o(new azq());
        O000000o(new azt());
        O000000o(new azr());
    }

    /* synthetic */ azj(byte b) {
        this();
    }

    public static azj O000000o() {
        return azw.f12736O000000o;
    }

    public static String O000000o(Context context) {
        boolean z;
        if (O0000OoO == null) {
            String O00000o2 = O00000o(context);
            if (O00000o2 == null) {
                O0000OoO = bag.O000000o(O0000OOo);
                z = false;
            } else {
                O0000OoO = O00000o2;
                z = true;
            }
            O0000Ooo = z;
        }
        return O0000OoO;
    }

    private synchronized void O000000o(azo azo) {
        this.O00000o0.add(azo);
    }

    private synchronized void O000000o(azs azs) {
        this.O00000Oo.add(azs);
    }

    public static String O00000Oo(Context context) {
        if (O0000OoO == null) {
            O00000o(context);
        }
        return O0000Ooo ? "com.mcs.action.RECEIVE_SDK_MESSAGE" : bag.O000000o(O0000Oo0);
    }

    private static String O00000o(Context context) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.mcs.action.RECEIVE_SDK_MESSAGE"), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            try {
                boolean z = false;
                boolean z2 = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                if (context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0)) {
                    z = true;
                }
                if (z2 || z) {
                    return str;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean O00000o0(Context context) {
        String O000000o2 = O000000o(context);
        return bag.O000000o(context, O000000o2) && bag.O00000Oo(context, O000000o2) >= 1012 && bag.O000000o(context, O000000o2, "supportOpenPush");
    }

    public static void O000000o(Context context, azx azx, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(O00000Oo(context));
            intent.setPackage(O000000o(context));
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", azx.O0000Ooo);
            intent.putExtra("appPackage", azx.O0000OoO);
            intent.putExtra("messageID", String.valueOf(azx.O0000Oo));
            intent.putExtra("globalID", String.valueOf(azx.O0000Oo));
            intent.putExtra("messageType", 4098);
            intent.putExtra("eventID", str);
            context.startService(intent);
        } catch (Exception e) {
            bae.O00000Oo("statisticMessage--Exception" + e.getMessage());
        }
    }

    public static void O000000o(Context context, bab bab, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(O00000Oo(context));
            intent.setPackage(O000000o(context));
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", bab.O0000Ooo);
            intent.putExtra("appPackage", bab.O0000OoO);
            intent.putExtra("messageID", bab.O0000Oo);
            intent.putExtra("globalID", bab.f12741O000000o);
            intent.putExtra("messageType", 4103);
            intent.putExtra("eventID", str);
            context.startService(intent);
        } catch (Exception e) {
            bae.O00000Oo("statisticMessage--Exception" + e.getMessage());
        }
    }

    public void O000000o(int i, JSONObject jSONObject) {
        synchronized (this.O0000o00) {
            this.f12735O000000o.startService(O000000o(i, "", (JSONObject) null));
        }
    }

    private Intent O000000o(int i, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(O00000Oo(this.f12735O000000o));
        intent.setPackage(O000000o(this.f12735O000000o));
        intent.putExtra("type", i);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("versionName", bag.O00000o0(this.f12735O000000o, this.f12735O000000o.getPackageName()));
            jSONObject2.putOpt("versionCode", Integer.valueOf(bag.O00000Oo(this.f12735O000000o, this.f12735O000000o.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.f12735O000000o.getPackageName());
        intent.putExtra("appKey", this.O00000o);
        intent.putExtra("appSecret", this.O00000oO);
        intent.putExtra("registerID", this.O00000oo);
        intent.putExtra("sdkVersion", "2.0.2");
        return intent;
    }
}
