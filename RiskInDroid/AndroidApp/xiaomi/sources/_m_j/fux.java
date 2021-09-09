package _m_j;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class fux {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f17225O000000o = 200;

    public interface O000000o {
        void O000000o(boolean z);

        void O00000Oo(boolean z);

        void O00000o0(boolean z);
    }

    public static boolean O000000o(final Activity activity) {
        if (!fuy.O00000o()) {
            new MLAlertDialog.Builder(activity).O00000Oo(activity.getResources().getString(R.string.open_location_permission1)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                /* class _m_j.fux.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                }
            }).O00000o().show();
            return false;
        } else if (fuy.O00000oO()) {
            return true;
        } else {
            new MLAlertDialog.Builder(activity).O00000Oo(activity.getResources().getString(R.string.open_location_permission1)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                /* class _m_j.fux.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                    activity.startActivityForResult(intent, fux.f17225O000000o);
                }
            }).O00000o().show();
            return false;
        }
    }

    public static boolean O000000o() {
        if (fuy.O00000o() && fuy.O00000oO()) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(final Activity activity, boolean z, int i) {
        if (!fuy.O00000o()) {
            if (activity != null && z) {
                new MLAlertDialog.Builder(activity).O00000Oo(activity.getResources().getString(i)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class _m_j.fux.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    }
                }).O00000o().show();
            }
            return false;
        } else if (fuy.O00000oO()) {
            return true;
        } else {
            if (activity != null && z) {
                View inflate = LayoutInflater.from(activity).inflate((int) R.layout.permisson_request_dialog_view, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.subtitle1)).setText((int) R.string.permission_location_rational_desc_new);
                new MLAlertDialog.Builder(activity).O000000o(inflate).O000000o(false).O000000o((int) R.string.next, new DialogInterface.OnClickListener() {
                    /* class _m_j.fux.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (grr.O00000oO() || !Build.MANUFACTURER.toLowerCase().contains("xiaomi")) {
                            ind.O000000o(activity).O000000o(fux.f17225O000000o);
                            return;
                        }
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addFlags(268435456);
                        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                        activity.startActivityForResult(intent, fux.f17225O000000o);
                    }
                }).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O00000oo();
            }
            return false;
        }
    }

    public static boolean O000000o(final Activity activity, int i, final O000000o o000000o) {
        if (!fuy.O00000o()) {
            new MLAlertDialog.Builder(activity).O00000Oo(activity.getResources().getString(i)).O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener() {
                /* class _m_j.fux.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000Oo(true);
                    }
                }
            }).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                /* class _m_j.fux.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000o0(true);
                    }
                }
            }).O00000o().show();
            o000000o.O000000o(true);
            return false;
        } else if (fuy.O00000oO()) {
            return true;
        } else {
            View inflate = LayoutInflater.from(activity).inflate((int) R.layout.permisson_request_dialog_view, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.subtitle1)).setText((int) R.string.permission_location_rational_desc_new);
            new MLAlertDialog.Builder(activity).O000000o(inflate).O000000o(false).O000000o((int) R.string.next, new DialogInterface.OnClickListener() {
                /* class _m_j.fux.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (grr.O00000oO() || !Build.MANUFACTURER.toLowerCase().contains("xiaomi")) {
                        ind.O000000o(activity).O000000o(fux.f17225O000000o);
                    } else {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addFlags(268435456);
                        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                        activity.startActivityForResult(intent, fux.f17225O000000o);
                    }
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000o0(false);
                    }
                }
            }).O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener() {
                /* class _m_j.fux.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000Oo(false);
                    }
                }
            }).O00000oo();
            o000000o.O000000o(false);
            return false;
        }
    }
}
