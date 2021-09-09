package _m_j;

import android.content.Intent;

public final class cuy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f14377O000000o = false;

    public static boolean O000000o(cvg cvg) {
        return f14377O000000o || ((Integer) cvg.O000000o(Integer.class, "com.sankuai.waimai.router.from", 2)).intValue() != 1;
    }

    public static void O000000o(Intent intent, cvg cvg) {
        Integer num;
        if (intent != null && cvg != null && (num = (Integer) cvg.O000000o(Integer.class, "com.sankuai.waimai.router.from", null)) != null) {
            int intValue = num.intValue();
            if (intent != null) {
                intent.putExtra("com.sankuai.waimai.router.from", intValue);
            }
        }
    }
}
