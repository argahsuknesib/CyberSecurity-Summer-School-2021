package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mi.global.shop.activity.MainTabActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;

public final class ccd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13618O000000o = "keyword";
    public static String O00000Oo = "native";
    public static String O00000o = "full_web";
    public static String O00000o0 = "inner_web";
    public static String O00000oO = "open_web";
    public static String O00000oo = "recharge";
    public static String O0000O0o = "plugin";

    public static void O000000o(NewHomeBlockInfoItem newHomeBlockInfoItem) {
        if (newHomeBlockInfoItem != null && !TextUtils.isEmpty(newHomeBlockInfoItem.mViewId)) {
            cbe.O00000o0(newHomeBlockInfoItem.mViewId, MainTabActivity.class.getSimpleName());
        }
    }

    public static void O000000o(Context context, NewHomeBlockInfoItem newHomeBlockInfoItem) {
        if (newHomeBlockInfoItem != null) {
            if (!TextUtils.isEmpty(newHomeBlockInfoItem.mViewId)) {
                cbe.O00000Oo(newHomeBlockInfoItem.mViewId, MainTabActivity.class.getSimpleName());
            }
            if (!TextUtils.isEmpty(newHomeBlockInfoItem.mPath)) {
                String str = newHomeBlockInfoItem.mPath;
                if (str.equals("app://feedback")) {
                    return;
                }
                if (TextUtils.isEmpty(str) || !cav.O00000Oo(str)) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("url", str);
                    context.startActivity(intent);
                    return;
                }
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        }
    }
}
