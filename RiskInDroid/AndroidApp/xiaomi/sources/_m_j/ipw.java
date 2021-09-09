package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ipw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f1544O000000o;
    private static List<String> O00000o0;
    public ipz O00000Oo;

    public interface O000000o {
        ipv O000000o(ipz ipz);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f1544O000000o = new ipu();
        } else {
            f1544O000000o = new ips();
        }
    }

    public ipw(ipz ipz) {
        this.O00000Oo = ipz;
    }

    public final void O000000o(String... strArr) {
        if (O00000o0 == null) {
            O00000o0 = O000000o(this.O00000Oo.O000000o());
        }
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Please enter at least one permission.");
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (O00000o0.contains(str)) {
                i++;
            } else {
                throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", str));
            }
        }
    }

    private static List<String> O000000o(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length != 0) {
                return Collections.unmodifiableList(Arrays.asList(strArr));
            }
            throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Package name cannot be found.");
        }
    }
}
