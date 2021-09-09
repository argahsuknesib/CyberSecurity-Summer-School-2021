package _m_j;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

public final class ipq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f1539O000000o = Build.MANUFACTURER.toLowerCase();
    private ipz O00000Oo;

    public ipq(ipz ipz) {
        this.O00000Oo = ipz;
    }

    public final boolean O000000o(int i) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", this.O00000Oo.O000000o().getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        try {
            this.O00000Oo.O000000o(intent, 4);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean O00000Oo(int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", this.O00000Oo.O000000o().getPackageName(), null));
        try {
            this.O00000Oo.O000000o(intent, 4);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void O00000o0(int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.O00000Oo.O000000o().getPackageName(), null));
        this.O00000Oo.O000000o(intent, 4);
    }
}
