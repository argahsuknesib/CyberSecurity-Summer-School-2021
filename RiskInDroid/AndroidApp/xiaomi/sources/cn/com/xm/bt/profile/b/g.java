package cn.com.xm.bt.profile.b;

import cn.com.xm.bt.a.a;

public class g {
    public static int a(String str) {
        a.b("ProfileUtils", "fw version:".concat(String.valueOf(str)));
        try {
            String[] split = str.substring(1).split("\\.");
            int length = split.length;
            if (length == 0) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i |= (Integer.parseInt(split[i2]) & 255) << (((length - i2) - 1) * 8);
            }
            return i;
        } catch (Exception e) {
            a.b("ProfileUtils", "exception:" + e.getMessage());
            return -1;
        }
    }
}
