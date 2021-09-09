package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class iik {
    public static boolean O000000o(Context context) {
        NetworkInfo O00000Oo = O00000Oo(context);
        return O00000Oo != null && O00000Oo.isConnected();
    }

    private static NetworkInfo O00000Oo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }
}
