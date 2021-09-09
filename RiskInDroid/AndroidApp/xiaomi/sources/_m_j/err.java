package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bs;
import com.xiaomi.push.service.bt;
import java.util.HashMap;
import java.util.Map;

public class err {
    private static volatile err O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f15755O000000o;
    public Map<String, ers> O00000Oo = new HashMap();

    private err(Context context) {
        this.f15755O000000o = context;
    }

    public static err O000000o(Context context) {
        if (context == null) {
            duv.O00000o("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (O00000o0 == null) {
            synchronized (err.class) {
                if (O00000o0 == null) {
                    O00000o0 = new err(context);
                }
            }
        }
        return O00000o0;
    }

    public final boolean O000000o(ht htVar, String str) {
        if (TextUtils.isEmpty(str)) {
            duv.O000000o("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (bs.a(htVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(htVar.f)) {
                htVar.f = bs.a();
            }
            htVar.g = str;
            bt.a(this.f15755O000000o, htVar);
            return true;
        }
    }
}
