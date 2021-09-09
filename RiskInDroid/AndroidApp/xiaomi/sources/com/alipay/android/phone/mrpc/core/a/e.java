package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.f;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class e extends b {
    private int c;
    private Object d;

    public e(int i, String str, Object obj) {
        super(str, obj);
        this.c = i;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.d != null) {
                arrayList.add(new BasicNameValuePair("extParam", f.a(this.d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f3128a));
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            arrayList.add(new BasicNameValuePair("id", sb.toString()));
            new StringBuilder("mParams is:").append(this.b);
            arrayList.add(new BasicNameValuePair("requestData", this.b == null ? "[]" : f.a(this.b)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("request  =");
            sb2.append(this.b);
            sb2.append(":");
            sb2.append(e);
            throw new RpcException(9, sb2.toString() == null ? "" : e.getMessage(), e);
        }
    }
}
