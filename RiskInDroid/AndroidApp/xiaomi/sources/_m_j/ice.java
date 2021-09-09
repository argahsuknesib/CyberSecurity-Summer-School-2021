package _m_j;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.other.http.KeyValuePair;
import java.net.CookieManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Request;

public final class ice {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final SimpleDateFormat f1174O000000o = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);

    public static void O000000o() {
    }

    public static icc O000000o(String str, final ibh<ibz, Error> ibh) {
        CookieManager cookieManager = icf.O000000o().f1176O000000o;
        if (cookieManager != null) {
            cookieManager.getCookieStore().removeAll();
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "https://api.io.mi.com/app/thirdlogin/weixintoken";
        arrayList.add(new KeyValuePair("code", str));
        Request.Builder builder = new Request.Builder();
        if (!arrayList.isEmpty()) {
            str2 = str2 + "?" + icq.O000000o(arrayList, "UTF-8");
        }
        Call newCall = icf.O000000o().O00000Oo().newCall(builder.url(str2).build());
        newCall.enqueue(new ibw<ica>() {
            /* class _m_j.ice.AnonymousClass1 */

            public final /* synthetic */ icb O000000o(String str) {
                return O00000Oo(str);
            }

            public final /* synthetic */ void O000000o(icb icb) {
                ibz ibz = (ibz) ((ica) icb).O00000Oo;
                if (ibz == null) {
                    ibh.sendFailureMessage(new Error(-7009, "data is null"));
                    return;
                }
                String str = ibz.f1169O000000o;
                String str2 = ibz.O00000Oo;
                long j = ibz.O00000o0;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    ibh ibh = ibh;
                    if (ibh != null) {
                        ibh.sendFailureMessage(new Error(-7009, "accessToken or openId is empty"));
                        return;
                    }
                    return;
                }
                ice.O000000o();
                ibz.f1169O000000o = str;
                ibz.O00000Oo = str2;
                ibz.O00000o0 = j;
                ibh ibh2 = ibh;
                if (ibh2 != null) {
                    ibh2.sendSuccessMessage(ibz);
                }
            }

            private static ica O00000Oo(String str) {
                try {
                    return (ica) new Gson().fromJson(str, ica.class);
                } catch (Exception unused) {
                    return null;
                }
            }

            public final void O000000o(Error error) {
                new StringBuilder("getWXAccessTokenByAuthCode ").append(error.O00000Oo);
                ice.O000000o();
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.sendFailureMessage(error);
                }
            }
        });
        return new icc(newCall);
    }
}
