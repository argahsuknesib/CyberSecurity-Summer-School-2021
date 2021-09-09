package _m_j;

import android.net.ConnectivityManager;

public final class cbf {
    public static String O000000o() {
        ConnectivityManager connectivityManager = (ConnectivityManager) byl.O00000oO().getSystemService("connectivity");
        return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) ? "NO_NETWORK" : connectivityManager.getActiveNetworkInfo().getTypeName();
    }

    public static boolean O00000Oo() {
        return O000000o().toUpperCase().equals("WIFI");
    }

    public static boolean O00000o0() {
        String upperCase = O000000o().toUpperCase();
        if (!upperCase.equals("WIFI") && !upperCase.endsWith("NO_NETWORK")) {
            return true;
        }
        return false;
    }

    public static boolean O00000o() {
        return O000000o().toUpperCase().equals("NO_NETWORK");
    }
}
