package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;

public class ad extends k<String, Integer> {
    private Context i;
    private String j;

    public ad(Context context, String str) {
        super(context, str);
        this.i = context;
        this.j = str;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bp.f(this.i));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.j);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Integer a(String str) throws AMapException {
        return 0;
    }

    public String i() {
        return r.c() + "/nearby/data/delete";
    }
}
