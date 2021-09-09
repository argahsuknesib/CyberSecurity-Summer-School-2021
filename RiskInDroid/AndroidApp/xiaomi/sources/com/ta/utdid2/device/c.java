package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f5808a = null;
    private static final Object e = new Object();
    private static final String k = (".UTSystemConfig" + File.separator + "Global");

    /* renamed from: a  reason: collision with other field name */
    private com.ta.utdid2.b.a.c f20a = null;

    /* renamed from: a  reason: collision with other field name */
    private d f21a = null;
    private com.ta.utdid2.b.a.c b = null;

    /* renamed from: b  reason: collision with other field name */
    private Pattern f22b = Pattern.compile("[^0-9a-zA-Z=/+]+");
    private String h = null;
    private String i = "xx_utdid_key";
    private String j = "xx_utdid_domain";
    private Context mContext = null;

    private c(Context context) {
        this.mContext = context;
        this.b = new com.ta.utdid2.b.a.c(context, k, "Alvin2", false, true);
        this.f20a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f21a = new d();
        this.i = String.format("K_%d", Integer.valueOf(g.a(this.i)));
        this.j = String.format("D_%d", Integer.valueOf(g.a(this.j)));
    }

    private void c() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            if (g.m101a(cVar.getString("UTDID2"))) {
                String string = this.b.getString("UTDID");
                if (!g.m101a(string)) {
                    f(string);
                }
            }
            boolean z = false;
            if (!g.m101a(this.b.getString("DID"))) {
                this.b.remove("DID");
                z = true;
            }
            if (!g.m101a(this.b.getString("EI"))) {
                this.b.remove("EI");
                z = true;
            }
            if (!g.m101a(this.b.getString("SI"))) {
                this.b.remove("SI");
                z = true;
            }
            if (z) {
                this.b.commit();
            }
        }
    }

    public static c a(Context context) {
        if (context != null && f5808a == null) {
            synchronized (e) {
                if (f5808a == null) {
                    c cVar = new c(context);
                    f5808a = cVar;
                    cVar.c();
                }
            }
        }
        return f5808a;
    }

    private void f(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (cVar = this.b) != null) {
                cVar.putString("UTDID2", str);
                this.b.commit();
            }
        }
    }

    private void g(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (str != null && (cVar = this.f20a) != null && !str.equals(cVar.getString(this.i))) {
            this.f20a.putString(this.i, str);
            this.f20a.commit();
        }
    }

    private void h(String str) {
        if (f() && b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (!b(str2)) {
                    try {
                        Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    private void i(String str) {
        String str2;
        try {
            str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str2 = null;
        }
        if (!str.equals(str2)) {
            try {
                Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
            } catch (Exception unused2) {
            }
        }
    }

    private void j(String str) {
        if (f() && str != null) {
            i(str);
        }
    }

    private String g() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        String string = cVar.getString("UTDID2");
        if (g.m101a(string) || this.f21a.c(string) == null) {
            return null;
        }
        return string;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && !this.f22b.matcher(str).find();
        }
    }

    public synchronized String getValue() {
        if (this.h != null) {
            return this.h;
        }
        return h();
    }

    public synchronized String h() {
        this.h = i();
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        try {
            byte[] c = m105c();
            if (c != null) {
                this.h = b.encodeToString(c, 2);
                f(this.h);
                String c2 = this.f21a.c(c);
                if (c2 != null) {
                    j(c2);
                    g(c2);
                }
                return this.h;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e4, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[SYNTHETIC, Splitter:B:9:0x0017] */
    public synchronized String i() {
        String str;
        String str2 = "";
        str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
        if (!b(str2)) {
            return str2;
        }
        e eVar = new e();
        boolean z = false;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str = null;
        }
        if (!g.m101a(str)) {
            String e2 = eVar.e(str);
            if (b(e2)) {
                h(e2);
                return e2;
            }
            String d = eVar.d(str);
            if (b(d)) {
                String c = this.f21a.c(d);
                if (!g.m101a(c)) {
                    j(c);
                    str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                }
            }
            String d2 = this.f21a.d(str);
            if (b(d2)) {
                this.h = d2;
                f(d2);
                g(str);
                h(this.h);
                return this.h;
            }
        } else {
            z = true;
        }
        String g = g();
        if (b(g)) {
            String c2 = this.f21a.c(g);
            if (z) {
                j(c2);
            }
            h(g);
            g(c2);
            this.h = g;
            return g;
        }
        String string = this.f20a.getString(this.i);
        if (!g.m101a(string)) {
            String d3 = eVar.d(string);
            if (!b(d3)) {
                d3 = this.f21a.d(string);
            }
            if (b(d3)) {
                String c3 = this.f21a.c(d3);
                if (!g.m101a(d3)) {
                    this.h = d3;
                    if (z) {
                        j(c3);
                    }
                    f(this.h);
                    return this.h;
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private byte[] m105c() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = d.getBytes(currentTimeMillis);
        byte[] bytes2 = d.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = e.a(this.mContext);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(new Random().nextInt());
            str = sb.toString();
        }
        byteArrayOutputStream.write(d.getBytes(g.a(str)), 0, 4);
        byteArrayOutputStream.write(d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(byte[] bArr) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(f.a(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), instance.getAlgorithm()));
        return b.encodeToString(instance.doFinal(bArr), 2);
    }

    private boolean f() {
        return this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }
}
