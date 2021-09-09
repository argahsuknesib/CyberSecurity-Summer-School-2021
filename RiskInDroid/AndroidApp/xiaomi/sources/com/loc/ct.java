package com.loc;

import _m_j.bvo;
import _m_j.bvy;
import _m_j.bvz;
import _m_j.bwb;
import _m_j.bwc;
import _m_j.bwt;
import _m_j.bwx;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ct {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4524O000000o = null;
    public boolean O00000Oo = true;
    public s O00000o = null;
    public boolean O00000o0 = false;
    public ServiceConnection O00000oO = null;
    public ServiceConnection O00000oo = null;
    public ServiceConnection O0000O0o = null;
    public boolean O0000OOo = false;
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    public boolean O0000OoO = false;
    public boolean O0000Ooo = false;
    private Intent O0000o = new Intent();
    public List<Intent> O0000o0 = new ArrayList();
    public boolean O0000o00 = false;
    public boolean O0000o0O = false;
    private String O0000o0o = null;
    private String O0000oO = "com.amap.api.service.AMapService";
    private String O0000oO0 = "com.autonavi.minimap";
    private String O0000oOO = "com.autonavi.minimap.LBSConnectionService";

    public ct(Context context) {
        this.f4524O000000o = context;
        try {
            this.O0000o0o = bwx.O00000Oo(bvo.O000000o(bwt.O00000oo(context).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            bvz.O000000o(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    private AMapLocationServer O000000o(Bundle bundle) {
        byte[] bArr;
        if (!bundle.containsKey("key")) {
            return null;
        }
        try {
            bArr = bvo.O00000Oo(bwx.O00000Oo(bundle.getString("key")), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
        } catch (Throwable th) {
            bvz.O000000o(th, "ConnectionServiceManager", "parseData part");
            bArr = null;
        }
        if (bundle.containsKey("result")) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bvo.O000000o(bArr, bwx.O00000Oo(bundle.getString("result"))), "utf-8"));
                if (jSONObject.has("error")) {
                    String string = jSONObject.getString("error");
                    if ("invaid type".equals(string)) {
                        this.O00000Oo = false;
                    }
                    if ("empty appkey".equals(string)) {
                        this.O00000Oo = false;
                    }
                    if ("refused".equals(string)) {
                        this.O00000Oo = false;
                    }
                    "failed".equals(string);
                    return null;
                }
                AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.b(jSONObject);
                aMapLocationServer.setProvider("lbs");
                aMapLocationServer.setLocationType(7);
                if ("WGS84".equals(aMapLocationServer.e()) && bvz.O000000o(aMapLocationServer.getLatitude(), aMapLocationServer.getLongitude())) {
                    DPoint O000000o2 = bwb.O000000o(this.f4524O000000o, aMapLocationServer.getLongitude(), aMapLocationServer.getLatitude());
                    aMapLocationServer.setLatitude(O000000o2.getLatitude());
                    aMapLocationServer.setLongitude(O000000o2.getLongitude());
                }
                return aMapLocationServer;
            } catch (Throwable th2) {
                bvz.O000000o(th2, ct.class.getName(), "parseData");
            }
        }
        return null;
    }

    private void O00000o() {
        ArrayList<String> O0000OOo2;
        if (bvy.O00000o0(this.f4524O000000o)) {
            Intent intent = new Intent();
            intent.putExtra("appkey", this.O0000o0o);
            intent.setComponent(new ComponentName(this.O0000oO0, this.O0000oOO));
            try {
                this.O0000Oo0 = this.f4524O000000o.bindService(intent, this.O00000oo, 1);
            } catch (Throwable unused) {
            }
            if (!this.O0000Oo0 && (O0000OOo2 = bvy.O0000OOo()) != null) {
                Iterator<String> it = O0000OOo2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!next.equals(this.O0000oOO)) {
                        intent.setComponent(new ComponentName(this.O0000oO0, next));
                        try {
                            this.O0000Oo0 = this.f4524O000000o.bindService(intent, this.O00000oo, 1);
                        } catch (Throwable unused2) {
                        }
                        if (this.O0000OOo) {
                            break;
                        }
                    }
                }
            }
            this.O0000Ooo = true;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045 A[Catch:{ Throwable -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[EDGE_INSN: B:33:0x006f->B:26:0x006f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x003f A[SYNTHETIC] */
    public final void O000000o() {
        ArrayList<String> O0000O0o2;
        if (!this.O0000o0O) {
            if (bvy.O00000Oo(this.f4524O000000o)) {
                this.O0000o.putExtra("appkey", this.O0000o0o);
                this.O0000o.setComponent(new ComponentName(this.O0000oO0, this.O0000oO));
                this.O0000OOo = this.f4524O000000o.bindService(this.O0000o, this.O00000oO, 1);
                try {
                    if (!this.O0000OOo && (O0000O0o2 = bvy.O0000O0o()) != null) {
                        Iterator<String> it = O0000O0o2.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!next.equals(this.O0000oO)) {
                                this.O0000o.setComponent(new ComponentName(this.O0000oO0, next));
                                this.O0000OOo = this.f4524O000000o.bindService(this.O0000o, this.O00000oO, 1);
                                if (!this.O0000OOo) {
                                    break;
                                }
                            }
                        }
                    }
                    this.O0000OoO = true;
                } catch (Throwable unused) {
                }
            }
            O00000o();
            O00000Oo();
            this.O0000o0O = true;
        }
    }

    public final AMapLocationServer O00000o0() {
        try {
            if (!this.O00000Oo) {
                return null;
            }
            if (!this.O0000OOo) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "corse");
            bundle.putString("appkey", this.O0000o0o);
            bundle.putInt("opensdk", 1);
            if (this.O00000o != null) {
                this.O00000o.a(bundle);
                if (bundle.size() > 0) {
                    return O000000o(bundle);
                }
            }
            return null;
        } catch (Throwable th) {
            bvz.O000000o(th, "ConnectionServiceManager", "sendCommand");
        }
    }

    public final void O00000Oo() {
        if (!this.O0000o00 && !this.O0000o0O) {
            try {
                if (bvy.O00000oo(this.f4524O000000o)) {
                    List<bwc> O0000o0o2 = bvy.O0000o0o();
                    if (O0000o0o2 != null && O0000o0o2.size() > 0) {
                        for (bwc next : O0000o0o2) {
                            if (next != null) {
                                if (next.f13329O000000o) {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(next.O00000Oo, next.O00000o0));
                                    if (!TextUtils.isEmpty(next.O00000oO)) {
                                        intent.setAction(next.O00000oO);
                                    }
                                    List<Map<String, String>> list = next.O00000o;
                                    if (list != null && list.size() > 0) {
                                        for (int i = 0; i < list.size(); i++) {
                                            Iterator it = list.get(i).entrySet().iterator();
                                            if (it.hasNext()) {
                                                Map.Entry entry = (Map.Entry) it.next();
                                                intent.putExtra(((String) entry.getKey()).toString(), ((String) entry.getValue()).toString());
                                            }
                                        }
                                    }
                                    if (next.O00000oo) {
                                        this.f4524O000000o.startService(intent);
                                        this.O0000o0.add(intent);
                                    }
                                    if (this.f4524O000000o.bindService(intent, this.O0000O0o, 1)) {
                                        this.O0000Oo = true;
                                    }
                                }
                            }
                        }
                    }
                    this.O0000o00 = true;
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ConnectionServiceManager", "bindOtherService");
            }
        }
    }
}
