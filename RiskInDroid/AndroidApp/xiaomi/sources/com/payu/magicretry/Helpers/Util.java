package com.payu.magicretry.Helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Util {
    public static boolean isNetworkAvailable(Context context) {
        boolean z = false;
        boolean z2 = false;
        for (NetworkInfo networkInfo : ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo()) {
            if (networkInfo.getTypeName().equalsIgnoreCase("WIFI") && networkInfo.isConnected()) {
                z = true;
            }
            if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE") && networkInfo.isConnected()) {
                z2 = true;
            }
        }
        return z || z2;
    }

    public static boolean isWifiConnected(Context context) {
        boolean z = false;
        for (NetworkInfo networkInfo : ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo()) {
            if (networkInfo.getTypeName().equalsIgnoreCase("WIFI") && networkInfo.isConnected()) {
                z = true;
            }
        }
        return z;
    }

    private boolean isMobileDataConnected(Context context) {
        boolean z = false;
        for (NetworkInfo networkInfo : ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo()) {
            if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE") && networkInfo.isConnected()) {
                z = true;
            }
        }
        return z;
    }

    public static void showNetworkNotAvailableError(Context context) {
        Toast.makeText(context, "Not connected to internet", 0).show();
    }
}
