package _m_j;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class buy {

    /* renamed from: O000000o  reason: collision with root package name */
    static boolean f13302O000000o = false;
    private static Context O00000Oo;
    /* access modifiers changed from: private */
    public static String O00000o0;

    static /* synthetic */ String O000000o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) O00000Oo.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "None_Network";
        }
        String typeName = activeNetworkInfo.getTypeName();
        buu.O000000o("[detectCurrentNetwork] - Network name:" + typeName + " subType name: " + activeNetworkInfo.getSubtypeName());
        return typeName != null ? typeName : "None_Network";
    }

    public static void O000000o(Context context) {
        if (context != null) {
            O00000Oo = context;
            buz buz = new buz();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            O00000Oo.registerReceiver(buz, intentFilter);
            return;
        }
        throw new IllegalStateException("Context can't be null");
    }
}
