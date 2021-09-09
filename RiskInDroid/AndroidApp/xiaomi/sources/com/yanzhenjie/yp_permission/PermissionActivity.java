package com.yanzhenjie.yp_permission;

import _m_j.ipp;
import _m_j.ipq;
import _m_j.ipy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import com.yanzhenjie.yp_permission.source.ContextSource;

public final class PermissionActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f12247O000000o;

    public interface O000000o {
        void O000000o();
    }

    public static void requestPermission(Context context, String[] strArr, O000000o o000000o) {
        f12247O000000o = o000000o;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("KEY_INPUT_OPERATION", 1);
        intent.putExtra("KEY_INPUT_PERMISSIONS", strArr);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void permissionSetting(Context context, O000000o o000000o) {
        f12247O000000o = o000000o;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("KEY_INPUT_OPERATION", 2);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestInstall(Context context, O000000o o000000o) {
        f12247O000000o = o000000o;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("KEY_INPUT_OPERATION", 3);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestOverlay(Context context, O000000o o000000o) {
        f12247O000000o = o000000o;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("KEY_INPUT_OPERATION", 4);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestAlertWindow(Context context, O000000o o000000o) {
        f12247O000000o = o000000o;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("KEY_INPUT_OPERATION", 5);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        Intent intent;
        Intent intent2;
        super.onCreate(bundle);
        Intent intent3 = getIntent();
        int intExtra = intent3.getIntExtra("KEY_INPUT_OPERATION", 0);
        if (intExtra == 1) {
            String[] stringArrayExtra = intent3.getStringArrayExtra("KEY_INPUT_PERMISSIONS");
            if (stringArrayExtra == null || f12247O000000o == null) {
                finish();
            } else {
                requestPermissions(stringArrayExtra, 1);
            }
        } else if (intExtra != 2) {
            if (intExtra != 3) {
                if (intExtra != 4) {
                    if (intExtra != 5) {
                        throw new AssertionError("This should not be the case.");
                    } else if (f12247O000000o != null) {
                        ipp ipp = new ipp(new ContextSource(this));
                        if (ipp.f1538O000000o.contains("huawei")) {
                            intent2 = ipp.O00000Oo(ipp.O00000Oo.O000000o());
                        } else if (ipp.f1538O000000o.contains("xiaomi")) {
                            intent2 = ipp.O00000o0(ipp.O00000Oo.O000000o());
                        } else if (ipp.f1538O000000o.contains("oppo")) {
                            intent2 = ipp.O00000o(ipp.O00000Oo.O000000o());
                        } else if (ipp.f1538O000000o.contains("vivo")) {
                            intent2 = ipp.O00000oO(ipp.O00000Oo.O000000o());
                        } else if (ipp.f1538O000000o.contains("meizu")) {
                            intent2 = ipp.O00000oo(ipp.O00000Oo.O000000o());
                        } else {
                            intent2 = ipp.O000000o(ipp.O00000Oo.O000000o());
                        }
                        try {
                            ipp.O00000Oo.O000000o(intent2, 5);
                        } catch (Exception unused) {
                            ipp.O00000Oo.O000000o(ipp.O000000o(ipp.O00000Oo.O000000o()), 5);
                        }
                    } else {
                        finish();
                    }
                } else if (f12247O000000o != null) {
                    ipq ipq = new ipq(new ContextSource(this));
                    if (ipq.f1539O000000o.contains("meizu")) {
                        if (!ipq.O000000o(4) && !ipq.O00000Oo(4)) {
                            ipq.O00000o0(4);
                        }
                    } else if (!ipq.O00000Oo(4)) {
                        ipq.O00000o0(4);
                    }
                } else {
                    finish();
                }
            } else if (f12247O000000o != null) {
                Intent intent4 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                intent4.setData(Uri.fromParts("package", getPackageName(), null));
                startActivityForResult(intent4, 3);
            } else {
                finish();
            }
        } else if (f12247O000000o != null) {
            ipy ipy = new ipy(new ContextSource(this));
            if (ipy.f1547O000000o.contains("huawei")) {
                intent = ipy.O00000Oo(ipy.O00000Oo.O000000o());
            } else if (ipy.f1547O000000o.contains("xiaomi")) {
                intent = ipy.O00000o0(ipy.O00000Oo.O000000o());
            } else if (ipy.f1547O000000o.contains("oppo")) {
                intent = ipy.O00000oO(ipy.O00000Oo.O000000o());
            } else if (ipy.f1547O000000o.contains("vivo")) {
                intent = ipy.O00000o(ipy.O00000Oo.O000000o());
            } else if (ipy.f1547O000000o.contains("meizu")) {
                intent = ipy.O00000oo(ipy.O00000Oo.O000000o());
            } else {
                intent = ipy.O000000o(ipy.O00000Oo.O000000o());
            }
            try {
                ipy.O00000Oo.O000000o(intent, 2);
            } catch (Exception unused2) {
                ipy.O00000Oo.O000000o(ipy.O000000o(ipy.O00000Oo.O000000o()), 2);
            }
        } else {
            finish();
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        O000000o o000000o = f12247O000000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        O000000o o000000o = f12247O000000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        finish();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void finish() {
        f12247O000000o = null;
        super.finish();
    }
}
