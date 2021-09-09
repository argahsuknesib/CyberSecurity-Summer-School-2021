package com.mi.global.shop.feature.search;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

public class DeviceUtils {
    @TargetApi(13)
    public static Point getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 13) {
            return new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }
}
