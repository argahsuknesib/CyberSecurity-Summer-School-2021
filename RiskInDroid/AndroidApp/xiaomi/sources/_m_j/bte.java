package _m_j;

import android.content.Context;

public final class bte {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f13263O000000o;
    brr O00000Oo;
    String O00000o0;

    public bte(Context context, brr brr, String str) {
        this.f13263O000000o = context.getApplicationContext();
        this.O00000Oo = brr;
        this.O00000o0 = str;
    }

    static String O000000o(Context context, brr brr, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(brr.O00000Oo());
            sb.append("\",\"product\":\"");
            sb.append(brr.O000000o());
            sb.append("\",\"nt\":\"");
            sb.append(bww.O00000o(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
