package com.hzy.tvmao.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.hzy.tvmao.KookongSDK;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4471a = false;

    public static boolean a() {
        NetworkInfo a2 = a(KookongSDK.getContext());
        boolean z = a2 != null && a2.isConnected();
        f4471a = z;
        return z;
    }

    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }
}
