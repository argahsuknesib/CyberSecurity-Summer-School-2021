package _m_j;

import android.os.Build;

public final class ckr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f13971O000000o = {"picasso"};

    public static boolean O000000o() {
        for (String equals : f13971O000000o) {
            if (Build.PRODUCT.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
