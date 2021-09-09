package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ConnectivityManagerCompat {
    private static final ConnectivityManagerCompatImpl IMPL;

    interface ConnectivityManagerCompatImpl {
        int getRestrictBackgroundStatus(ConnectivityManager connectivityManager);

        boolean isActiveNetworkMetered(ConnectivityManager connectivityManager);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictBackgroundStatus {
    }

    static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        public int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
            return 3;
        }

        BaseConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return true;
            }
            switch (activeNetworkInfo.getType()) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return true;
                case 1:
                    return false;
                default:
                    return true;
            }
        }
    }

    static class HoneycombMR2ConnectivityManagerCompatImpl extends BaseConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(connectivityManager);
        }
    }

    static class JellyBeanConnectivityManagerCompatImpl extends HoneycombMR2ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(connectivityManager);
        }
    }

    static class Api24ConnectivityManagerCompatImpl extends JellyBeanConnectivityManagerCompatImpl {
        Api24ConnectivityManagerCompatImpl() {
        }

        public int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatApi24.getRestrictBackgroundStatus(connectivityManager);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            IMPL = new Api24ConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new JellyBeanConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 13) {
            IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else {
            IMPL = new BaseConnectivityManagerCompatImpl();
        }
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return IMPL.isActiveNetworkMetered(connectivityManager);
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
        return IMPL.getRestrictBackgroundStatus(connectivityManager);
    }

    private ConnectivityManagerCompat() {
    }
}
