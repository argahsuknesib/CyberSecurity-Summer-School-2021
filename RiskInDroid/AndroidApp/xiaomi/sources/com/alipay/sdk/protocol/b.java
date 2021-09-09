package com.alipay.sdk.protocol;

import _m_j.jdn;
import android.text.TextUtils;
import com.alipay.sdk.tid.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f3199a;
    private String b;
    private String[] c;

    public b(String str) {
        this.b = str;
    }

    public b(String str, a aVar) {
        this.b = str;
        this.f3199a = aVar;
    }

    public static void a(b bVar) {
        String[] c2 = bVar.c();
        if (c2.length == 3 && TextUtils.equals("tid", c2[0])) {
            a a2 = a.a(com.alipay.sdk.sys.b.a().b());
            if (!TextUtils.isEmpty(c2[1]) && !TextUtils.isEmpty(c2[2])) {
                a2.a(c2[1], c2[2]);
            }
        }
    }

    public static List<b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] b2 = b(jSONObject.optString("name", ""));
        for (int i = 0; i < b2.length; i++) {
            a a2 = a.a(b2[i]);
            if (a2 != a.None) {
                b bVar = new b(b2[i], a2);
                bVar.c = a(b2[i]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private static String[] a(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String trim : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(trim.trim().replaceAll("'", "").replaceAll(jdn.f1779O000000o, ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String[] b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split(";");
        }
        return null;
    }

    public String a() {
        return this.b;
    }

    public a b() {
        return this.f3199a;
    }

    public String[] c() {
        return this.c;
    }
}
