package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import com.mi.util.Device;
import java.util.ArrayList;
import java.util.HashMap;

public final class cem {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f13689O000000o = 528;
    private static int O00000Oo = 5028;
    private static HashMap<Integer, cel> O00000o0 = new HashMap<>();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int
     arg types: [android.app.Activity, java.lang.String]
     candidates:
      _m_j.oOOO00o0.O000000o(android.app.Activity, _m_j.d):void
      _m_j.oOOO00o0.O000000o(android.app.Activity, java.lang.String):boolean
      androidx.core.content.ContextCompat.O000000o(android.content.Context, int):android.graphics.drawable.Drawable
      androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.Class):T
      androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int */
    public static void O000000o(Activity activity, cel cel, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            cel.O00000o0();
            cel.O000000o();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (oOOO00o0.O000000o((Context) activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            cel.O00000o0();
            cel.O000000o();
            return;
        }
        oOOO00o0.O000000o(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), f13689O000000o);
        O00000o0.put(Integer.valueOf(f13689O000000o), cel);
        f13689O000000o++;
    }

    public static void O000000o(int i, int[] iArr) {
        cel cel = O00000o0.get(Integer.valueOf(i));
        if (cel != null) {
            cel.O00000o0();
            int length = iArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                cel.O000000o();
            } else {
                cel.O00000Oo();
            }
            O00000o0.remove(Integer.valueOf(i));
        }
    }

    public static void O000000o(Activity activity, int i) {
        cel cel;
        boolean z;
        if (i == O00000Oo && (cel = O00000o0.get(Integer.valueOf(i))) != null) {
            cel.O00000o0();
            if (Build.VERSION.SDK_INT < 23) {
                z = true;
            } else {
                z = Settings.canDrawOverlays(activity);
            }
            if (z) {
                cel.O000000o();
            } else {
                cel.O00000Oo();
            }
        }
    }

    public static void O000000o(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + Device.O0000o));
        context.startActivity(intent);
    }

    public static boolean O000000o(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String O000000o2 : strArr) {
            if (oOOO00o0.O000000o(context, O000000o2) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void O000000o(final Context context, String str) {
        AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
            /* class _m_j.cem.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                cem.O000000o(context);
            }
        };
        AnonymousClass2 r1 = new DialogInterface.OnClickListener() {
            /* class _m_j.cem.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        if (O00000Oo(context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(str);
            builder.setCancelable(false);
            builder.setPositiveButton(17039370, r0);
            builder.setNegativeButton(17039369, r1);
            builder.create().show();
        }
    }

    public static void O000000o(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        if (O00000Oo(context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(str);
            builder.setCancelable(false);
            builder.setPositiveButton(17039370, onClickListener);
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.create().show();
        }
    }

    private static boolean O00000Oo(Context context) {
        if (context != null && (context instanceof Activity)) {
            if (Build.VERSION.SDK_INT >= 17) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return false;
                }
                return true;
            } else if (!((Activity) context).isFinishing()) {
                return true;
            }
        }
        return false;
    }
}
