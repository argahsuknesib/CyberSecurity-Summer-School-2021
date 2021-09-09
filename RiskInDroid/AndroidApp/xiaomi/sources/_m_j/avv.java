package _m_j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.xiaomi.smarthome.R;

final class avv {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f12648O000000o;
    final int O00000Oo;
    final int O00000o;
    final boolean O00000o0;
    final int O00000oO;
    private final boolean O00000oo;
    private final float O0000O0o;

    avv(Activity activity) {
        int i;
        int i2;
        int i3;
        boolean z = true;
        this.O00000oo = activity.getResources().getConfiguration().orientation == 1;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.O0000O0o = Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        this.f12648O000000o = O000000o(activity, "status_bar_height");
        if (Build.VERSION.SDK_INT >= 14) {
            View findViewById = activity.getWindow().findViewById(R.id.action_bar_container);
            i = findViewById != null ? findViewById.getMeasuredHeight() : 0;
            if (i == 0) {
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(16843499, typedValue, true);
                i = TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
            }
        } else {
            i = 0;
        }
        this.O00000Oo = i;
        if (Build.VERSION.SDK_INT < 14 || !O000000o(activity)) {
            i2 = 0;
        } else {
            i2 = O000000o(activity, this.O00000oo ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }
        this.O00000o = i2;
        if (Build.VERSION.SDK_INT < 14 || !O000000o(activity)) {
            i3 = 0;
        } else {
            i3 = O000000o(activity, "navigation_bar_width");
        }
        this.O00000oO = i3;
        this.O00000o0 = this.O00000o <= 0 ? false : z;
    }

    @TargetApi(14)
    private static boolean O000000o(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                return false;
            }
            if (awg.O00000o0()) {
                if (awg.O00000o() || Build.VERSION.SDK_INT < 21) {
                    if (Settings.System.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                        return false;
                    }
                } else if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                    return false;
                }
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        if (i2 - displayMetrics2.widthPixels > 0 || i - i3 > 0) {
            return true;
        }
        return false;
    }

    private static int O000000o(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        return this.O0000O0o >= 600.0f || this.O00000oo;
    }
}
