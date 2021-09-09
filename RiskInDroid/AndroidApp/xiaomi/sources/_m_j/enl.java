package _m_j;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class enl {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f15653O000000o = "";
    long O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    double O0000Oo = 0.1d;
    protected String O0000Oo0;
    String O0000OoO = "s.mi1.cc";
    long O0000Ooo = 86400000;
    private String O0000o0;
    private ArrayList<enu> O0000o00 = new ArrayList<>();

    public enl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000Oo = System.currentTimeMillis();
            this.O0000o00.add(new enu(str, -1));
            this.f15653O000000o = enp.m593a();
            this.O00000o0 = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private void O000000o(String str, int i, long j, long j2, Exception exc) {
        O000000o(str, new enk(i, j, j2, exc));
    }

    private synchronized void O00000o0(String str) {
        Iterator<enu> it = this.O0000o00.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f15659O000000o, str)) {
                it.remove();
            }
        }
    }

    public final synchronized enl O000000o(JSONObject jSONObject) {
        this.f15653O000000o = jSONObject.optString("net");
        this.O0000Ooo = jSONObject.getLong("ttl");
        this.O0000Oo = jSONObject.getDouble("pct");
        this.O00000Oo = jSONObject.getLong("ts");
        this.O00000oO = jSONObject.optString("city");
        this.O00000o = jSONObject.optString("prv");
        this.O0000OOo = jSONObject.optString("cty");
        this.O00000oo = jSONObject.optString("isp");
        this.O0000O0o = jSONObject.optString("ip");
        this.O00000o0 = jSONObject.optString("host");
        this.O0000Oo0 = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            O000000o(new enu().O000000o(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized ArrayList<String> O000000o(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        enu[] enuArr = new enu[this.O0000o00.size()];
        this.O0000o00.toArray(enuArr);
        Arrays.sort(enuArr);
        arrayList = new ArrayList<>();
        for (enu enu : enuArr) {
            if (z) {
                substring = enu.f15659O000000o;
            } else {
                int indexOf = enu.f15659O000000o.indexOf(":");
                substring = indexOf != -1 ? enu.f15659O000000o.substring(0, indexOf) : enu.f15659O000000o;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    public final void O000000o(long j) {
        if (j > 0) {
            this.O0000Ooo = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid ".concat(String.valueOf(j)));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(enu enu) {
        O00000o0(enu.f15659O000000o);
        this.O0000o00.add(enu);
    }

    public final void O000000o(String str, long j, long j2) {
        O000000o(str, 0, j, j2, null);
    }

    public final void O000000o(String str, long j, long j2, Exception exc) {
        try {
            O00000Oo(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public synchronized void O000000o(String str, enk enk) {
        Iterator<enu> it = this.O0000o00.iterator();
        while (it.hasNext()) {
            enu next = it.next();
            if (TextUtils.equals(str, next.f15659O000000o)) {
                next.O000000o(enk);
                return;
            }
        }
    }

    public final synchronized void O000000o(String[] strArr) {
        int i;
        int size = this.O0000o00.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (TextUtils.equals(this.O0000o00.get(size).f15659O000000o, strArr[i])) {
                    this.O0000o00.remove(size);
                    break;
                }
                i++;
            }
            size--;
        }
        Iterator<enu> it = this.O0000o00.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            enu next = it.next();
            if (next.O00000Oo > i2) {
                i2 = next.O00000Oo;
            }
        }
        while (i < strArr.length) {
            O000000o(new enu(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    public boolean O000000o() {
        return System.currentTimeMillis() - this.O00000Oo < this.O0000Ooo;
    }

    public final synchronized ArrayList<String> O00000Oo() {
        return O000000o(false);
    }

    public final synchronized void O00000Oo(String str) {
        O000000o(new enu(str));
    }

    public final void O00000Oo(String str, long j, long j2, Exception exc) {
        O000000o(str, -1, j, j2, exc);
    }

    public final synchronized JSONObject O00000o() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f15653O000000o);
        jSONObject.put("ttl", this.O0000Ooo);
        jSONObject.put("pct", this.O0000Oo);
        jSONObject.put("ts", this.O00000Oo);
        jSONObject.put("city", this.O00000oO);
        jSONObject.put("prv", this.O00000o);
        jSONObject.put("cty", this.O0000OOo);
        jSONObject.put("isp", this.O00000oo);
        jSONObject.put("ip", this.O0000O0o);
        jSONObject.put("host", this.O00000o0);
        jSONObject.put("xf", this.O0000Oo0);
        JSONArray jSONArray = new JSONArray();
        Iterator<enu> it = this.O0000o00.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().O000000o());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15653O000000o);
        sb.append("\n");
        sb.append(O00000o0());
        Iterator<enu> it = this.O0000o00.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public final ArrayList<String> O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.O00000o0)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = O000000o(true).iterator();
                while (it.hasNext()) {
                    enn O000000o2 = enn.O000000o(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), O000000o2.f15655O000000o, O000000o2.O00000Oo, url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public final synchronized String O00000o0() {
        if (!TextUtils.isEmpty(this.O0000o0)) {
            return this.O0000o0;
        } else if (TextUtils.isEmpty(this.O00000oo)) {
            return "hardcode_isp";
        } else {
            String[] strArr = {this.O00000oo, this.O00000o, this.O00000oO, this.O0000OOo, this.O0000O0o};
            StringBuffer stringBuffer = new StringBuffer(((strArr[0] == null ? 16 : strArr[0].toString().length()) + 1) * 5);
            for (int i = 0; i < 5; i++) {
                if (i > 0) {
                    stringBuffer.append("_");
                }
                if (strArr[i] != null) {
                    stringBuffer.append((Object) strArr[i]);
                }
            }
            this.O0000o0 = stringBuffer.toString();
            return this.O0000o0;
        }
    }
}
