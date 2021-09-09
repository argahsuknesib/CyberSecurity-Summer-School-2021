package in.srain.cube.views.ptr.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class PtrLocalDisplay {
    public static float SCREEN_DENSITY;
    public static int SCREEN_HEIGHT_DP;
    public static int SCREEN_HEIGHT_PIXELS;
    public static int SCREEN_WIDTH_DP;
    public static int SCREEN_WIDTH_PIXELS;

    public static void init(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            SCREEN_WIDTH_PIXELS = displayMetrics.widthPixels;
            SCREEN_HEIGHT_PIXELS = displayMetrics.heightPixels;
            SCREEN_DENSITY = displayMetrics.density;
            SCREEN_WIDTH_DP = (int) (((float) SCREEN_WIDTH_PIXELS) / displayMetrics.density);
            SCREEN_HEIGHT_DP = (int) (((float) SCREEN_HEIGHT_PIXELS) / displayMetrics.density);
        }
    }

    public static int dp2px(float f) {
        return (int) ((f * SCREEN_DENSITY) + 0.5f);
    }

    public static int designedDP2px(float f) {
        int i = SCREEN_WIDTH_DP;
        if (i != 320) {
            f = (f * ((float) i)) / 320.0f;
        }
        return dp2px(f);
    }

    public static void setPadding(View view, float f, float f2, float f3, float f4) {
        view.setPadding(designedDP2px(f), dp2px(f2), designedDP2px(f3), dp2px(f4));
    }
}
