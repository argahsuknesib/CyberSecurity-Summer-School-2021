package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;

public final class gri {
    public static final int O000000o(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static Point O000000o(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    public static int O000000o(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
