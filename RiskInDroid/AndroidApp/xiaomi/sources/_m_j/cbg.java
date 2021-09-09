package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.MainTabActivity;
import com.mi.global.shop.activity.OrderListAcitvity;
import com.mi.global.shop.activity.OrderViewActivity;
import com.mi.global.shop.activity.ReviewListAcitvity;
import com.mi.global.shop.activity.TrackAcitvity;
import com.mi.global.shop.user.CouponActivity;

public final class cbg {
    public static boolean O000000o(Context context, String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String path = parse.getPath();
            if (cad.O00000o()) {
                if (path.contains("/user/orderview")) {
                    if (O000000o(context)) {
                        return true;
                    }
                    String O000000o2 = O000000o(path, "order_id");
                    Intent intent = new Intent(context, OrderViewActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("orderview_orderid", O000000o2);
                    context.startActivity(intent);
                    return true;
                } else if (path.contains("/user/coupon")) {
                    if (O000000o(context)) {
                        return true;
                    }
                    Intent intent2 = new Intent(context, CouponActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("com.mi.global.shop.extra_user_coupon_type", "coupon_manage");
                    context.startActivity(intent2);
                    return true;
                } else if (path.contains("/user/orderlist")) {
                    if (O000000o(context)) {
                        return true;
                    }
                    try {
                        i = Integer.parseInt(O000000o(path, "type"));
                    } catch (Exception unused) {
                        i = -1;
                    }
                    Intent intent3 = new Intent(context, OrderListAcitvity.class);
                    if (i != -1) {
                        intent3.addFlags(268435456);
                        intent3.putExtra("type", i);
                        context.startActivity(intent3);
                        return true;
                    }
                } else if (path.contains("/comment/myreview")) {
                    if (O000000o(context)) {
                        return true;
                    }
                    Intent intent4 = new Intent(context, ReviewListAcitvity.class);
                    intent4.addFlags(268435456);
                    context.startActivity(intent4);
                    return true;
                } else if (path.contains("#track")) {
                    if (O000000o(context)) {
                        return true;
                    }
                    String O000000o3 = O000000o(path, "package_id");
                    Intent intent5 = new Intent(context, TrackAcitvity.class);
                    intent5.addFlags(268435456);
                    intent5.putExtra("orderview_orderid", O000000o3);
                    context.startActivity(intent5);
                    return true;
                } else if (path.contains("/discover")) {
                    Intent intent6 = new Intent(context, MainTabActivity.class);
                    intent6.putExtra("change_tab", 2);
                    intent6.addFlags(268435456);
                    context.startActivity(intent6);
                    return true;
                }
            }
            if (path.contains("/index")) {
                Intent intent7 = new Intent(context, MainTabActivity.class);
                intent7.putExtra("change_tab", 0);
                intent7.addFlags(268435456);
                context.startActivity(intent7);
                return true;
            } else if (path.contains("/category")) {
                Intent intent8 = new Intent(context, MainTabActivity.class);
                intent8.putExtra("change_tab", 1);
                intent8.addFlags(268435456);
                context.startActivity(intent8);
                return true;
            } else {
                if (path.endsWith("/user")) {
                    Intent intent9 = new Intent(context, MainTabActivity.class);
                    intent9.putExtra("change_tab", 3);
                    intent9.addFlags(268435456);
                    context.startActivity(intent9);
                    return true;
                }
                return false;
            }
        } catch (Exception unused2) {
        }
    }

    private static String O000000o(String str, String str2) {
        if (str.indexOf(str2) != -1) {
            try {
                return str.substring(str.indexOf(str2)).split("&")[0].split("=")[1];
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static boolean O000000o(Context context) {
        if (!ccn.O0000o00().O0000o0O()) {
            try {
                if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                    ((BaseActivity) context).gotoAccount();
                    return true;
                }
                byl.O00000Oo();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
