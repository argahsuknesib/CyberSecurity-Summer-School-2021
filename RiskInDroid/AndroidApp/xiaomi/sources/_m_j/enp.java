package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.module.PushChannelRegion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class enp {

    /* renamed from: a  reason: collision with root package name */
    private static O000000o f15656a;

    /* renamed from: a  reason: collision with other field name */
    private static enp f360a;

    /* renamed from: a  reason: collision with other field name */
    protected static Context f361a;

    /* renamed from: a  reason: collision with other field name */
    protected static boolean f362a = false;
    protected static final Map<String, enl> b = new HashMap();
    private static String c;
    private static String d;

    /* renamed from: a  reason: collision with other field name */
    private long f363a;

    /* renamed from: a  reason: collision with other field name */
    private eno f364a;

    /* renamed from: a  reason: collision with other field name */
    protected O00000Oo f365a;

    /* renamed from: a  reason: collision with other field name */
    private String f366a;

    /* renamed from: a  reason: collision with other field name */
    protected final Map<String, enm> f367a;

    /* renamed from: b  reason: collision with other field name */
    private final long f368b;

    /* renamed from: b  reason: collision with other field name */
    private String f369b;

    /* renamed from: c  reason: collision with other field name */
    private long f370c;

    public interface O000000o {
        enp a(Context context, eno eno, O00000Oo o00000Oo, String str);
    }

    public interface O00000Oo {
        String a(String str);
    }

    protected enp(Context context, eno eno, O00000Oo o00000Oo, String str) {
        this(context, eno, o00000Oo, str, null, null);
    }

    protected enp(Context context, eno eno, O00000Oo o00000Oo, String str, String str2, String str3) {
        this.f367a = new HashMap();
        this.f366a = "0";
        this.f363a = 0;
        this.f368b = 15;
        this.f370c = 0;
        this.f369b = "isp_prov_city_country_ip";
        this.f365a = o00000Oo;
        this.f364a = eno == null ? new enq(this) : eno;
        this.f366a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized enp a() {
        enp enp;
        synchronized (enp.class) {
            if (f360a != null) {
                enp = f360a;
            } else {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return enp;
    }

    /* renamed from: a  reason: collision with other method in class */
    static String m593a() {
        NetworkInfo activeNetworkInfo;
        Context context = f361a;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) f361a.getSystemService("wifi");
                if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                    return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                return "unknown";
            }
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
        }
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                byte b3 = b2 & 240;
                if (b3 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | b3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static synchronized void a(O000000o o000000o) {
        synchronized (enp.class) {
            f15656a = o000000o;
            f360a = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return;
     */
    public static synchronized void a(Context context, eno eno, O00000Oo o00000Oo, String str, String str2, String str3) {
        synchronized (enp.class) {
            Context applicationContext = context.getApplicationContext();
            f361a = applicationContext;
            if (applicationContext == null) {
                f361a = context;
            }
            if (f360a == null) {
                if (f15656a == null) {
                    f360a = new enp(context, eno, o00000Oo, str, str2, str3);
                    return;
                }
                f360a = f15656a.a(context, eno, o00000Oo, str);
            }
        }
    }

    public static void a(String str, String str2) {
        enl enl = b.get(str);
        synchronized (b) {
            if (enl == null) {
                enl enl2 = new enl(str);
                enl2.O000000o(604800000);
                enl2.O00000Oo(str2);
                b.put(str, enl2);
            } else {
                enl.O00000Oo(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = f361a.getPackageManager().getPackageInfo(f361a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.enp.a(java.lang.String, boolean):_m_j.enl
     arg types: [java.lang.String, int]
     candidates:
      _m_j.enp.a(java.lang.String, java.lang.String):void
      _m_j.enp.a(java.lang.String, _m_j.enl):void
      _m_j.enp.a(java.lang.String, boolean):_m_j.enl */
    /* renamed from: a  reason: collision with other method in class */
    public enl m594a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    public enl a(String str, boolean z) {
        enl e;
        if (!TextUtils.isEmpty(str)) {
            enl c2 = c(str);
            return (c2 == null || !c2.O000000o()) ? (!z || !emf.O000000o(f361a) || (e = e(str)) == null) ? new enr(this, str, c2) : e : c2;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    /* access modifiers changed from: protected */
    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<eme> arrayList3 = new ArrayList<>();
        arrayList3.add(new emc("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new emc("conpt", a(emf.O0000Oo0(f361a))));
        }
        if (z) {
            arrayList3.add(new emc("reserved", "1"));
        }
        arrayList3.add(new emc("uuid", str2));
        arrayList3.add(new emc("list", eml.O000000o(arrayList, ",")));
        arrayList3.add(new emc("countrycode", a.a(f361a).b()));
        enl c2 = c(b());
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (b) {
                enl enl = b.get("resolver.msg.xiaomi.net");
                if (enl != null) {
                    Iterator<String> it = enl.O000000o(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.O000000o(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (eme eme : arrayList3) {
                buildUpon.appendQueryParameter(eme.O000000o(), eme.O00000Oo());
            }
            try {
                return this.f365a == null ? emf.O000000o(f361a, new URL(buildUpon.toString())) : this.f365a.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        duv.O000000o("network exception: " + e.getMessage());
        throw e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m595a() {
        JSONObject jSONObject;
        synchronized (this.f367a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (enm O00000o0 : this.f367a.values()) {
                jSONArray.put(O00000o0.O00000o0());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (enl O00000o : b.values()) {
                jSONArray2.put(O00000o.O00000o());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m596a() {
        synchronized (this.f367a) {
            this.f367a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m597a(String str) {
        this.f369b = str;
    }

    public void a(String str, enl enl) {
        if (TextUtils.isEmpty(str) || enl == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + enl);
        }
        synchronized (this.f367a) {
            m598a();
            if (this.f367a.containsKey(str)) {
                this.f367a.get(str).O000000o(enl);
            } else {
                enm enm = new enm(str);
                enm.O000000o(enl);
                this.f367a.put(str, enm);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public boolean m598a() {
        synchronized (this.f367a) {
            if (f362a) {
                return true;
            }
            f362a = true;
            this.f367a.clear();
            try {
                String d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    m600b(d2);
                    duv.O00000Oo("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                duv.O000000o("load bucket failure: " + th.getMessage());
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.enp.a(java.lang.String, boolean):_m_j.enl
     arg types: [java.lang.String, int]
     candidates:
      _m_j.enp.a(java.lang.String, java.lang.String):void
      _m_j.enp.a(java.lang.String, _m_j.enl):void
      _m_j.enp.a(java.lang.String, boolean):_m_j.enl */
    public enl b(String str) {
        return a(str, true);
    }

    /* access modifiers changed from: protected */
    public String b() {
        String a2 = a.a(f361a).a();
        return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m599b() {
        ArrayList arrayList;
        synchronized (this.f367a) {
            m598a();
            arrayList = new ArrayList(this.f367a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                enm enm = this.f367a.get(arrayList.get(size));
                if (!(enm == null || enm.O000000o() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<enl> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a((String) arrayList.get(i), a2.get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public enl c(String str) {
        enm enm;
        enl O000000o2;
        synchronized (this.f367a) {
            m598a();
            enm = this.f367a.get(str);
        }
        if (enm == null || (O000000o2 = enm.O000000o()) == null) {
            return null;
        }
        return O000000o2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f367a) {
            for (Map.Entry next : this.f367a.entrySet()) {
                sb.append((String) next.getKey());
                sb.append(":\n");
                sb.append(((enm) next.getValue()).toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m601c() {
        synchronized (this.f367a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f361a.openFileOutput(e(), 0)));
                String jSONObject = m595a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                duv.O000000o("persist bucket failure: " + e.getMessage());
            }
        }
    }

    public enl d(String str) {
        enl enl;
        synchronized (b) {
            enl = b.get(str);
        }
        return enl;
    }

    /* access modifiers changed from: protected */
    public String d() {
        BufferedReader bufferedReader;
        try {
            File file = new File(f361a.getFilesDir(), e());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            ele.O000000o(bufferedReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        duv.O000000o("load host exception " + th.getMessage());
                        ele.O000000o(bufferedReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        ele.O000000o(bufferedReader);
                        throw th;
                    }
                }
            } else {
                ele.O000000o((Closeable) null);
                return null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            ele.O000000o(bufferedReader);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public enl e(String str) {
        if (System.currentTimeMillis() - this.f370c <= this.f363a * 60 * 1000) {
            return null;
        }
        this.f370c = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        enl enl = a(arrayList).get(0);
        if (enl != null) {
            this.f363a = 0;
            return enl;
        }
        long j = this.f363a;
        if (j >= 15) {
            return null;
        }
        this.f363a = j + 1;
        return null;
    }

    /* access modifiers changed from: protected */
    public String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f361a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "com.xiaomi";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        return "com.xiaomi";
    }

    private ArrayList<enl> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList<String> arrayList2 = arrayList;
        m602d();
        synchronized (this.f367a) {
            m598a();
            for (String next : this.f367a.keySet()) {
                if (!arrayList2.contains(next)) {
                    arrayList2.add(next);
                }
            }
        }
        synchronized (b) {
            for (Object obj : b.values().toArray()) {
                enl enl = (enl) obj;
                if (!enl.O000000o()) {
                    b.remove(enl.O00000o0);
                }
            }
        }
        if (!arrayList2.contains(b())) {
            arrayList2.add(b());
        }
        ArrayList<enl> arrayList3 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add(null);
        }
        try {
            String str = emf.O00000o(f361a) ? "wifi" : "wap";
            String a2 = a(arrayList2, str, this.f366a, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                duv.O00000Oo(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    duv.O00000o0("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str2 = arrayList2.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str2);
                        if (optJSONArray == null) {
                            duv.O000000o("no bucket found for ".concat(String.valueOf(str2)));
                            jSONObject = jSONObject5;
                        } else {
                            enl enl2 = new enl(str2);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    enl2.O000000o(new enu(string6, optJSONArray.length() - i3));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList3.set(i2, enl2);
                            enl2.O0000OOo = string5;
                            enl2.O00000o = string;
                            enl2.O00000oo = string3;
                            enl2.O0000O0o = string4;
                            enl2.O00000oO = string2;
                            if (jSONObject4.has("stat-percent")) {
                                enl2.O0000Oo = jSONObject4.getDouble("stat-percent");
                            }
                            if (jSONObject4.has("stat-domain")) {
                                enl2.O0000OoO = jSONObject4.getString("stat-domain");
                            }
                            if (jSONObject4.has("ttl")) {
                                enl2.O000000o(((long) jSONObject4.getInt("ttl")) * 1000);
                            }
                            m597a(enl2.O00000o0());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = 604800000;
                        if (jSONObject4.has("reserved-ttl")) {
                            j = ((long) jSONObject4.getInt("reserved-ttl")) * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next2 = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next2);
                            if (optJSONArray2 == null) {
                                duv.O000000o("no bucket found for ".concat(String.valueOf(next2)));
                            } else {
                                enl enl3 = new enl(next2);
                                enl3.O000000o(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        enl3.O000000o(new enu(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                synchronized (b) {
                                    b.put(next2, enl3);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            duv.O000000o("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            enl enl4 = arrayList3.get(i5);
            if (enl4 != null) {
                a(arrayList2.get(i5), enl4);
            }
        }
        m601c();
        return arrayList3;
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m602d() {
        String next;
        synchronized (this.f367a) {
            for (enm O00000Oo2 : this.f367a.values()) {
                O00000Oo2.O00000Oo();
            }
            while (true) {
                boolean z = false;
                while (!z) {
                    z = true;
                    Iterator<String> it = this.f367a.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (this.f367a.get(next).O00000Oo.isEmpty()) {
                                break;
                            }
                        }
                    }
                }
                this.f367a.remove(next);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b  reason: collision with other method in class */
    public void m600b(String str) {
        synchronized (this.f367a) {
            this.f367a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        enm O000000o2 = new enm().O000000o(optJSONArray.getJSONObject(i));
                        this.f367a.put(O000000o2.f15654O000000o, O000000o2);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                enl O000000o3 = new enl(optString).O000000o(jSONObject2);
                                b.put(O000000o3.O00000o0, O000000o3);
                                duv.O000000o("load local reserved host for " + O000000o3.O00000o0);
                            } catch (JSONException unused) {
                                duv.O000000o("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }
}
