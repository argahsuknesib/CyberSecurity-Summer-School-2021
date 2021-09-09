package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.io.File;

public final class dim {

    /* renamed from: O000000o  reason: collision with root package name */
    public dij f14689O000000o;
    private dii O00000Oo = new dii(this.f14689O000000o);

    public dim(String str, Context context) {
        diz.O00000o0("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f14689O000000o = new dij(str);
        dih.O000000o(context, this.f14689O000000o);
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("bcb3903995", "3.5.2.lite");
        edit.apply();
        diz.O00000o0("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public final int O000000o(Activity activity, Fragment fragment, String str, djz djz, boolean z) {
        try {
            String O000000o2 = djn.O000000o(activity);
            if (O000000o2 != null) {
                String O000000o3 = dji.O000000o(new File(O000000o2));
                if (!TextUtils.isEmpty(O000000o3)) {
                    diz.O000000o("openSDK_LOG.QQAuth", "-->login channelId: ".concat(String.valueOf(O000000o3)));
                    diz.O00000o0("openSDK_LOG.QQAuth", "loginWithOEM");
                    dio.O0000Oo0 = true;
                    String str2 = O000000o3.equals("") ? "null" : O000000o3;
                    if (O000000o3.equals("")) {
                        O000000o3 = "null";
                    }
                    dio.O0000O0o = O000000o3;
                    dio.O00000oo = str2;
                    dio.O0000OOo = "null";
                    return this.O00000Oo.O000000o(activity, str, djz, false, null, false, null);
                }
            }
        } catch (Throwable th) {
            diz.O00000Oo("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        diz.O00000Oo("openSDK_LOG.QQAuth", "-->login channelId is null ");
        dio.O0000Oo0 = false;
        return this.O00000Oo.O000000o(activity, str, djz, false, null, false, null);
    }
}
