package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ekj {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f15573O000000o;
    private final String O00000Oo;

    public ekj(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("context or userId cannot be null");
        } else if (MiAccountManager.O00000Oo(context).O00000Oo() || !ekg.O000000o(context)) {
            this.f15573O000000o = context;
            this.O00000Oo = O00000Oo(str);
        } else {
            throw new IllegalStateException("cannot use this class when am.isUseSystem() is false");
        }
    }

    private static String O00000Oo(String str) {
        try {
            return eke.O000000o(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public final String O000000o(String str) {
        String string = O000000o().getString(eke.O000000o(str), null);
        if (string == null) {
            return null;
        }
        return eke.O00000Oo(string);
    }

    public final boolean O000000o(String str, String str2) {
        String str3;
        String O000000o2 = eke.O000000o(str);
        if (str2 == null) {
            str3 = null;
        } else {
            str3 = eke.O000000o(str2);
        }
        return O000000o().edit().putString(O000000o2, str3).commit();
    }

    private SharedPreferences O000000o() {
        Context context = this.f15573O000000o;
        return context.getSharedPreferences("local_user_data_" + this.O00000Oo, 0);
    }
}
