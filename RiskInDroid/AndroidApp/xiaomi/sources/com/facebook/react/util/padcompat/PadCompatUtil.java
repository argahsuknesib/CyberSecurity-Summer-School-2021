package com.facebook.react.util.padcompat;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.views.view.ReactViewGroup;

public class PadCompatUtil {
    public static volatile PadCompatUtil instance;
    PadUtils padUtils;

    public static PadCompatUtil getInstance() {
        if (instance == null) {
            synchronized (PadCompatUtil.class) {
                if (instance == null) {
                    instance = new PadCompatUtil();
                }
            }
        }
        return instance;
    }

    public void setPadUtils(PadUtils padUtils2) {
        this.padUtils = padUtils2;
    }

    public boolean isDialogThemePlugin() {
        PadUtils padUtils2 = this.padUtils;
        if (padUtils2 != null) {
            return padUtils2.isDialogThemePlugin();
        }
        return false;
    }

    public float getScaleFactor() {
        PadUtils padUtils2 = this.padUtils;
        if (padUtils2 != null) {
            return padUtils2.getScaleFactor();
        }
        return 1.0f;
    }

    public View handleModalContentViewWhenPad(ReactViewGroup reactViewGroup, Activity activity) {
        PadUtils padUtils2 = this.padUtils;
        if (padUtils2 != null) {
            return padUtils2.handleModalContentViewWhenPad(reactViewGroup, activity);
        }
        return null;
    }

    public Point getModalHostSize() {
        PadUtils padUtils2 = this.padUtils;
        if (padUtils2 != null) {
            return padUtils2.getModalHostSize();
        }
        return null;
    }

    public boolean interceptDimensionSize() {
        PadUtils padUtils2 = this.padUtils;
        if (padUtils2 != null) {
            return padUtils2.interceptDimensionSize();
        }
        return false;
    }

    public int getKeyBoardEventHeightDiff(View view, int i) {
        PadUtils padUtils2 = this.padUtils;
        if (padUtils2 != null) {
            return padUtils2.getKeyBoardEventHeightDiff(view, i);
        }
        return DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - i;
    }
}
