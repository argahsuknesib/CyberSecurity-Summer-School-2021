package _m_j;

import android.content.Context;

public final class bxr {
    public static synchronized String O000000o(Context context) {
        String string;
        synchronized (bxr.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return string;
    }
}
