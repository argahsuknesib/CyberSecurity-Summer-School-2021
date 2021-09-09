package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.v;
import java.util.Arrays;
import java.util.HashSet;

public final class ebl implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15149O000000o;

    ebl(Context context) {
        this.f15149O000000o = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0075 A[Catch:{ Throwable -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8 A[Catch:{ Throwable -> 0x00c8 }] */
    public final void run() {
        boolean z;
        try {
            PackageInfo packageInfo = this.f15149O000000o.getPackageManager().getPackageInfo(this.f15149O000000o.getPackageName(), 4612);
            v.O000000o(this.f15149O000000o);
            v.O000000o(this.f15149O000000o, packageInfo);
            Context context = this.f15149O000000o;
            HashSet hashSet = new HashSet();
            String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
            hashSet.addAll(Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
            if (packageInfo.permissions != null) {
                PermissionInfo[] permissionInfoArr = packageInfo.permissions;
                int length = permissionInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (str.equals(permissionInfoArr[i].name)) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    if (packageInfo.requestedPermissions != null) {
                        for (String str2 : packageInfo.requestedPermissions) {
                            if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                                hashSet.remove(str2);
                                if (hashSet.isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        throw new v.a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
                    }
                    return;
                }
                throw new v.a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
            }
            z = false;
            if (!z) {
            }
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
