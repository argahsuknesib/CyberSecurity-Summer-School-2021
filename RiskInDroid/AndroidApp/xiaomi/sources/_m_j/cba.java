package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.mi.global.shop.activity.LaunchWebActivity;
import com.mi.global.shop.model.HomeThemeItem;

public final class cba {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13585O000000o = "native";
    public static String O00000Oo = "inner_web";
    public static String O00000o = "full_web";
    public static String O00000o0 = "single_web";
    public static String O00000oO = "browser";
    public static String O00000oo = "land_web";

    public static void O000000o(Context context, HomeThemeItem homeThemeItem) {
        String str = homeThemeItem.mLinkUrl;
        if (!TextUtils.isEmpty(str)) {
            LaunchWebActivity.startActivityStandard(context, str);
        }
    }
}
