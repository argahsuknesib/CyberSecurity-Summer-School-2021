package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.e;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.lang.reflect.Type;
import org.json.JSONObject;

public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.alipay.android.phone.mrpc.core.RpcException.<init>(java.lang.Integer, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      com.alipay.android.phone.mrpc.core.RpcException.<init>(java.lang.Integer, java.lang.Throwable):void
      com.alipay.android.phone.mrpc.core.RpcException.<init>(java.lang.Integer, java.lang.String):void */
    public final Object a() {
        try {
            String str = new String(this.b);
            StringBuilder sb = new StringBuilder("threadid = ");
            sb.append(Thread.currentThread().getId());
            sb.append("; rpc response:  ");
            sb.append(str);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("resultStatus");
            if (i == 1000) {
                return this.f3127a == String.class ? jSONObject.optString("result") : e.a(jSONObject.optString("result"), this.f3127a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.b));
            sb2.append(":");
            sb2.append(e);
            throw new RpcException((Integer) 10, sb2.toString() == null ? "" : e.getMessage());
        }
    }
}
