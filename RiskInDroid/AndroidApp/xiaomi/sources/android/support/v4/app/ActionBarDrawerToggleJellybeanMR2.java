package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(18)
@RequiresApi(18)
class ActionBarDrawerToggleJellybeanMR2 {
    private static final int[] THEME_ATTRS = {16843531};

    ActionBarDrawerToggleJellybeanMR2() {
    }

    public static Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }

    public static Object setActionBarDescription(Object obj, Activity activity, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public static Drawable getThemeUpIndicator(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        Context context = activity;
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
}
