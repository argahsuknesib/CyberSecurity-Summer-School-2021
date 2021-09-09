package _m_j;

import android.text.TextUtils;

public final class gsh {
    public static long[] O000000o(String str) {
        long[] jArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("-");
        if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
            String[] split2 = split[1].split("/");
            if (split2.length > 1 && !TextUtils.isEmpty(split2[1])) {
                jArr = new long[3];
                try {
                    jArr[2] = Long.parseLong(split2[1].trim());
                    String[] split3 = split[0].split(" ");
                    if (split3.length > 1) {
                        if (!TextUtils.isEmpty(split3[1])) {
                            jArr[0] = Long.parseLong(split3[1].trim());
                            jArr[1] = Long.parseLong(split2[0].trim());
                        }
                    }
                    jArr[0] = 0;
                    jArr[1] = Long.parseLong(split2[0].trim());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jArr;
    }
}
