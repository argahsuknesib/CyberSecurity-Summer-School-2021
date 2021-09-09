package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public final class iay {

    /* renamed from: O000000o  reason: collision with root package name */
    public final SharedPreferences f1142O000000o;

    public iay(Context context, String str) {
        this.f1142O000000o = context.getSharedPreferences(str, 0);
    }

    public final long O000000o(String str) {
        return this.f1142O000000o.getLong(str, 0);
    }

    public final int O000000o(String str, int i) {
        return this.f1142O000000o.getInt(str, i);
    }

    public final void O00000Oo(String str, int i) {
        this.f1142O000000o.edit().putInt(str, i).commit();
    }
}
