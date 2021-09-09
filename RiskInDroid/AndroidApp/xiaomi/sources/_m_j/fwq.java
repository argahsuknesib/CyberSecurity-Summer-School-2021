package _m_j;

import _m_j.ing;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import miui.os.SystemProperties;

public final class fwq {
    public static boolean O000000o(final Activity activity, boolean z, final inc inc, final String str) {
        if (TextUtils.isEmpty(str)) {
            str = activity.getApplication().getResources().getString(R.string.open_location_permission1);
        }
        if (!O00000Oo()) {
            if (z) {
                new MLAlertDialog.Builder(activity).O00000Oo(str).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class _m_j.fwq.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    }
                }).O00000o().show();
            }
            return false;
        } else if (!O000000o()) {
            if (z) {
                View inflate = LayoutInflater.from(activity).inflate((int) R.layout.permisson_request_dialog_view, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.subtitle1)).setText((int) R.string.permission_location_rational_desc_new);
                new MLAlertDialog.Builder(activity).O000000o(inflate).O00000Oo(true).O000000o((int) R.string.next, new DialogInterface.OnClickListener() {
                    /* class _m_j.fwq.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Activity activity = activity;
                        activity.getApplication().getResources().getString(R.string.permission_successfully);
                        fwq.O000000o(activity, activity.getApplication().getResources().getString(R.string.permission_failure), activity.getApplication().getResources().getString(R.string.tips), str, inc, ing.O000000o.O00000o);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class _m_j.fwq.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).O00000oo();
            }
            return false;
        } else {
            if (inc != null) {
                inc.onAction(Arrays.asList(ing.O000000o.O00000o));
            }
            return true;
        }
    }

    public static boolean O000000o(final Activity activity, boolean z, final inc inc) {
        if (O000000o(ing.O000000o.O00000Oo)) {
            if (inc != null) {
                inc.onAction(Arrays.asList(ing.O000000o.O00000Oo));
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            View inflate = LayoutInflater.from(activity).inflate((int) R.layout.permisson_request_dialog_view, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.subtitle1)).setText((int) R.string.permission_camera_desc_new);
            new MLAlertDialog.Builder(activity).O000000o(inflate).O00000Oo(true).O000000o((int) R.string.next, new DialogInterface.OnClickListener() {
                /* class _m_j.fwq.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Activity activity = activity;
                    activity.getApplication().getResources().getString(R.string.permission_successfully);
                    fwq.O000000o(activity, activity.getApplication().getResources().getString(R.string.permission_failure), activity.getApplication().getResources().getString(R.string.tips), activity.getApplication().getResources().getString(R.string.permission_tips_camera_msg), inc, ing.O000000o.O00000Oo);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class _m_j.fwq.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).O00000oo();
            return false;
        }
    }

    public static boolean O000000o(Activity activity, inc inc) {
        if (!O000000o(ing.O000000o.O0000Oo0)) {
            activity.getApplication().getResources().getString(R.string.permission_successfully);
            O000000o(activity, activity.getApplication().getResources().getString(R.string.permission_failure), activity.getApplication().getResources().getString(R.string.tips), activity.getApplication().getResources().getString(R.string.permission_tips_denied_msg), inc, ing.O000000o.O0000Oo0);
            return false;
        } else if (inc == null) {
            return true;
        } else {
            inc.onAction(Arrays.asList(ing.O000000o.O0000Oo0));
            return true;
        }
    }

    public static boolean O00000Oo(Activity activity, inc inc) {
        if (!O000000o(ing.O000000o.O0000Oo)) {
            activity.getApplication().getResources().getString(R.string.permission_successfully);
            O000000o(activity, activity.getApplication().getResources().getString(R.string.permission_failure), activity.getApplication().getResources().getString(R.string.tips), activity.getApplication().getResources().getString(R.string.permission_tips_denied_msg), inc, ing.O000000o.O0000Oo);
            return false;
        } else if (inc == null) {
            return true;
        } else {
            inc.onAction(Arrays.asList(ing.O000000o.O0000Oo));
            return true;
        }
    }

    public static void O000000o(Activity activity, String str, String str2, String str3, inc inc, String... strArr) {
        WeakReference weakReference = new WeakReference(activity);
        ind.O00000Oo((Activity) weakReference.get()).O000000o(strArr).O000000o((inh) null).O000000o(inc).O00000Oo(new inc(true, activity, str, weakReference, str2, str3) {
            /* class _m_j.fwq.AnonymousClass7 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f17328O000000o = true;
            final /* synthetic */ Activity O00000Oo;
            final /* synthetic */ WeakReference O00000o;
            final /* synthetic */ String O00000o0;
            final /* synthetic */ String O00000oO;
            final /* synthetic */ String O00000oo;

            {
                this.O00000Oo = r2;
                this.O00000o0 = r3;
                this.O00000o = r4;
                this.O00000oO = r5;
                this.O00000oo = r6;
            }

            public final void onAction(List<String> list) {
                if (!this.f17328O000000o) {
                    hte.O000000o(this.O00000Oo, this.O00000o0);
                    return;
                }
                Activity activity = (Activity) this.O00000o.get();
                if (activity != null && !activity.isFinishing()) {
                    if (Build.VERSION.SDK_INT < 17 || activity.isDestroyed()) {
                        if (ind.O000000o(activity, list)) {
                            fwq.O000000o(activity, this.O00000oO, this.O00000oo, list);
                        } else {
                            hte.O000000o(activity, this.O00000o0);
                        }
                    } else if (ind.O000000o(activity, list)) {
                        fwq.O000000o(activity, this.O00000oO, this.O00000oo, list);
                    } else {
                        hte.O000000o(activity, this.O00000o0);
                    }
                }
            }
        }).O000000o();
    }

    public static void O000000o(Activity activity, String str, String str2, List<String> list) {
        if (activity != null && !activity.isFinishing()) {
            if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
                String format = String.format(str2, TextUtils.join("\n", ing.O000000o(activity, list)));
                final inj O000000o2 = ind.O000000o(activity);
                new MLAlertDialog.Builder(activity).O000000o(false).O000000o(str).O00000Oo(format).O000000o((int) R.string.mj_setting, new DialogInterface.OnClickListener() {
                    /* class _m_j.fwq.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (fwq.O00000o0()) {
                            O000000o2.O00000o0();
                        } else {
                            O000000o2.O000000o();
                        }
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class _m_j.fwq.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).O00000o().show();
            }
        }
    }

    public static boolean O000000o() {
        if (!O00000Oo(CommonApplication.getAppContext(), "android.permission.ACCESS_FINE_LOCATION") && !O00000Oo(CommonApplication.getAppContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
            return false;
        }
        return true;
    }

    public static boolean O000000o(String... strArr) {
        if (strArr == null) {
            return true;
        }
        for (String O00000Oo : strArr) {
            if (!O00000Oo(CommonApplication.getAppContext(), O00000Oo)) {
                return false;
            }
        }
        return true;
    }

    public static boolean O00000Oo() {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                return !TextUtils.isEmpty(Settings.Secure.getString(CommonApplication.getAppContext().getContentResolver(), "location_providers_allowed"));
            }
            try {
                return Settings.Secure.getInt(CommonApplication.getAppContext().getContentResolver(), "location_mode") != 0;
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean O000000o(Context context, String str) {
        return ContextCompat.O000000o(context, str) == 0;
    }

    public static boolean O00000Oo(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context.getApplicationInfo().targetSdkVersion < 23) {
            if (g.O000000o(context, str, Binder.getCallingPid(), Binder.getCallingUid(), context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean O00000o0() {
        if (!grr.O00000oO()) {
            return false;
        }
        try {
            return SystemProperties.get("ro.product.mod_device", "").contains("_global");
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
