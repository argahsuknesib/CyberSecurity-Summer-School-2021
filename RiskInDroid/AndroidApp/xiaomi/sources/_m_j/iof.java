package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

public final class iof implements inj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f1515O000000o = Build.MANUFACTURER.toLowerCase();
    private ioh O00000Oo;

    public iof(ioh ioh) {
        this.O00000Oo = ioh;
    }

    public final void O000000o() {
        try {
            this.O00000Oo.O000000o(O00000o(), 199);
        } catch (Exception unused) {
            ioh ioh = this.O00000Oo;
            ioh.O000000o(O000000o(ioh.O000000o()));
        }
    }

    public final void O00000Oo() {
        try {
            this.O00000Oo.O000000o(O00000o(), 4000);
        } catch (Exception unused) {
            ioh ioh = this.O00000Oo;
            ioh.O000000o(O000000o(ioh.O000000o()), 4000);
        }
    }

    public final void O000000o(int i) {
        Intent O00000o = O00000o();
        O00000o.addFlags(268435456);
        try {
            this.O00000Oo.O000000o(O00000o, i);
        } catch (Exception unused) {
            ioh ioh = this.O00000Oo;
            ioh.O000000o(O000000o(ioh.O000000o()), i);
        }
    }

    public final void O00000o0() {
        ioh ioh = this.O00000Oo;
        ioh.O000000o(O000000o(ioh.O000000o()), 199);
    }

    private Intent O00000o() {
        if (f1515O000000o.contains("huawei")) {
            return O00000Oo(this.O00000Oo.O000000o());
        }
        if (f1515O000000o.contains("xiaomi") && grr.O00000oO()) {
            return O00000o0(this.O00000Oo.O000000o());
        }
        if (f1515O000000o.contains("oppo")) {
            return O000000o(this.O00000Oo.O000000o());
        }
        if (f1515O000000o.contains("vivo")) {
            return O00000o(this.O00000Oo.O000000o());
        }
        if (f1515O000000o.contains("samsung")) {
            return O000000o(this.O00000Oo.O000000o());
        }
        if (f1515O000000o.contains("meizu")) {
            return O00000oO(this.O00000Oo.O000000o());
        }
        if (f1515O000000o.contains("smartisan")) {
            return O000000o(this.O00000Oo.O000000o());
        }
        return O000000o(this.O00000Oo.O000000o());
    }

    private static Intent O000000o(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private static Intent O00000Oo(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return O000000o(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    private static Intent O00000o0(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }

    private static Intent O00000o(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        if (Build.VERSION.SDK_INT >= 25) {
            intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        } else {
            intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        }
        return intent;
    }

    private static Intent O00000oO(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            return O000000o(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }
}
