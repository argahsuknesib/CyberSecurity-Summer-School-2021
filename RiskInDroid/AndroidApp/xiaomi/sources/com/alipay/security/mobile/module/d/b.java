package com.alipay.security.mobile.module.d;

import com.alipay.security.mobile.module.http.v2.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private File f3239a = null;
    private a b = null;

    public b(String str, a aVar) {
        this.f3239a = new File(str);
        this.b = aVar;
    }

    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
        return;
     */
    public synchronized void b() {
        if (this.f3239a != null) {
            if (this.f3239a.exists() && this.f3239a.isDirectory()) {
                if (this.f3239a.list().length != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String add : this.f3239a.list()) {
                        arrayList.add(add);
                    }
                    Collections.sort(arrayList);
                    String str = (String) arrayList.get(arrayList.size() - 1);
                    int size = arrayList.size();
                    if (str.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                        if (arrayList.size() >= 2) {
                            str = (String) arrayList.get(arrayList.size() - 2);
                            size--;
                        } else {
                            return;
                        }
                    }
                    if (!this.b.a(a(com.alipay.security.mobile.module.a.b.a(this.f3239a.getAbsolutePath(), str)))) {
                        size--;
                    }
                    for (int i = 0; i < size; i++) {
                        new File(this.f3239a, (String) arrayList.get(i)).delete();
                    }
                }
            }
        }
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
