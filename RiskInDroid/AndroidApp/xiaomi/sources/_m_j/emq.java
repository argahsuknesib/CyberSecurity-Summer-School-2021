package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public class emq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile emq f15632O000000o;
    private Context O00000Oo;

    private emq(Context context) {
        this.O00000Oo = context;
    }

    public static emq O000000o(Context context) {
        if (f15632O000000o == null) {
            synchronized (emq.class) {
                if (f15632O000000o == null) {
                    f15632O000000o = new emq(context);
                }
            }
        }
        return f15632O000000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return 0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized long O000000o(String str, String str2) {
        return this.O00000Oo.getSharedPreferences(str, 4).getLong(str2, 0);
    }

    public final synchronized void O000000o(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.O00000Oo.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    public final synchronized void O000000o(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.O00000Oo.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized String O00000Oo(String str, String str2, String str3) {
        return this.O00000Oo.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
