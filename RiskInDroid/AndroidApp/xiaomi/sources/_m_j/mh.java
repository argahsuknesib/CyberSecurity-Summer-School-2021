package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public final class mh {
    private static mh O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f2182O000000o;
    private String O00000Oo;

    private mh(Context context, String str) {
        this.f2182O000000o = context.getSharedPreferences("mijiacamera021", 0);
        this.O00000Oo = str;
    }

    public mh(Context context, String str, String str2) {
        this.f2182O000000o = context.getSharedPreferences(str, 0);
        this.O00000Oo = str2;
    }

    public static mh O000000o(Context context, String str) {
        if (O00000o0 == null) {
            O00000o0 = new mh(context, str);
        }
        mh mhVar = O00000o0;
        mhVar.O00000Oo = str;
        return mhVar;
    }

    public final void O000000o(String str, int i) {
        SharedPreferences.Editor edit = this.f2182O000000o.edit();
        edit.putInt(str + this.O00000Oo, i);
        edit.apply();
    }

    public final int O000000o(String str) {
        SharedPreferences sharedPreferences = this.f2182O000000o;
        return sharedPreferences.getInt(str + this.O00000Oo, -1);
    }
}
