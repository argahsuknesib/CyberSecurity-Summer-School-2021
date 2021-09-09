package _m_j;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class cvg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f14384O000000o;
    public Uri O00000Oo;
    boolean O00000o;
    public final HashMap<String, Object> O00000o0;
    private String O00000oO;

    public cvg(Context context, String str) {
        this(context, O00000Oo(str), new HashMap());
    }

    public cvg(Context context, Uri uri) {
        this(context, uri, new HashMap());
    }

    public cvg(Context context, String str, HashMap<String, Object> hashMap) {
        this(context, O00000Oo(str), hashMap);
    }

    public cvg(Context context, Uri uri, HashMap<String, Object> hashMap) {
        this.O00000o = false;
        this.O00000oO = null;
        this.f14384O000000o = context;
        this.O00000Oo = uri == null ? Uri.EMPTY : uri;
        this.O00000o0 = hashMap == null ? new HashMap<>() : hashMap;
    }

    private static Uri O00000Oo(String str) {
        return TextUtils.isEmpty(str) ? Uri.EMPTY : Uri.parse(str);
    }

    public cvg O000000o(String str) {
        O000000o("com.sankuai.waimai.router.core.error.msg", str);
        return this;
    }

    public final cvc O00000Oo() {
        return (cvc) O000000o(cvc.class, "com.sankuai.waimai.router.core.CompleteListener", null);
    }

    public final String O00000o0() {
        if (this.O00000oO == null) {
            this.O00000oO = czf.O000000o(this.O00000Oo);
        }
        return this.O00000oO;
    }

    public final boolean O00000o() {
        return Uri.EMPTY.equals(this.O00000Oo);
    }

    public final <T> cvg O000000o(String str, Object obj) {
        if (obj != null) {
            this.O00000o0.put(str, obj);
        }
        return this;
    }

    public final synchronized <T> cvg O00000Oo(String str, T t) {
        if (t != null) {
            if (!this.O00000o0.containsKey(str)) {
                this.O00000o0.put(str, t);
            }
        }
        return this;
    }

    public final boolean O000000o(String str, boolean z) {
        return ((Boolean) O000000o(Boolean.class, str, Boolean.valueOf(z))).booleanValue();
    }

    public final <T> T O000000o(Class<T> cls, String str, T t) {
        Object obj = this.O00000o0.get(str);
        if (obj != null) {
            try {
                return cls.cast(obj);
            } catch (ClassCastException unused) {
                cvb.O0000OOo();
            }
        }
        return t;
    }

    public String toString() {
        return this.O00000Oo.toString();
    }

    public final String O00000oO() {
        StringBuilder sb = new StringBuilder(this.O00000Oo.toString());
        sb.append(", fields = {");
        boolean z = true;
        for (Map.Entry next : this.O00000o0.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append((String) next.getKey());
            sb.append(" = ");
            sb.append(next.getValue());
        }
        sb.append("}");
        return sb.toString();
    }
}
