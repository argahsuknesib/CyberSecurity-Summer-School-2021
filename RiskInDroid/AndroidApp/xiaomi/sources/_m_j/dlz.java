package _m_j;

import java.io.File;

final class dlz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f14777O000000o = -1;

    public static boolean O000000o() {
        int i = f14777O000000o;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i2 = 0;
        while (i2 < 6) {
            try {
                if (new File(strArr[i2] + "su").exists()) {
                    f14777O000000o = 1;
                    return true;
                }
                i2++;
            } catch (Exception unused) {
            }
        }
        f14777O000000o = 0;
        return false;
    }
}
