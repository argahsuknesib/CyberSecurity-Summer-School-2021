package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public class ecn {

    /* renamed from: O000000o  reason: collision with root package name */
    private SharedPreferences f15168O000000o;

    public final String O000000o(Context context, String str, String str2) {
        return O00000o0(context).getString(str, str2);
    }

    public final void O00000Oo(Context context, String str, String str2) {
        O00000o0(context).edit().putString(str, str2).commit();
    }

    /* access modifiers changed from: package-private */
    public final SharedPreferences O00000o0(Context context) {
        if (this.f15168O000000o == null && context != null) {
            this.f15168O000000o = context.getSharedPreferences("__XiaoMi_Stat_SendRem", 0);
        }
        return this.f15168O000000o;
    }
}
